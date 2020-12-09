package org.eclipse.bpel.validator;

/**
 * Java JDK dependencies
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.model.resource.SAXParseDiagnostic;
import org.eclipse.bpel.validator.factory.AdapterFactory;
import org.eclipse.bpel.validator.helpers.ModelQueryImpl;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Messages;
import org.eclipse.bpel.validator.model.Problem;
import org.eclipse.bpel.validator.model.Runner;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Element;


/**
 * A builder which is invoked to build (in this case validate), the BPEL files
 * in the projects in which the builder is installed.
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 19, 2006
 *
 */

@SuppressWarnings("nls")
public class Builder extends IncrementalProjectBuilder {

	// https://jira.jboss.org/jira/browse/JBIDE-6006
	// Content Type ID for org.eclipse.bpel editor files
	public static final String BPEL_CONTENT_TYPE = "org.eclipse.bpel.contenttype"; //$NON-NLS-1$

	Date created = new Date();

	boolean bDebug = false;

	/** Empty problems list */
	IProblem[] EMPTY_PROBLEMS = {};

	/** The adapter manager for the platform */
	IAdapterManager fAdapterManager = Platform.getAdapterManager();

	BPELResourceSetImpl fResourceSet = new BPELResourceSetImpl();

	BPELReader fReader = new BPELReader();


	/**
	 * Create brand new shiny BPEL Builder.
	 */

	public Builder() {
		p("Created on " + this.created);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		super.setInitializationData(config, propertyName, data);
	}


	@Override
	protected IProject[] build (int kind, Map args, IProgressMonitor monitor)
			throws CoreException {


		long started = System.currentTimeMillis();
		if (args != null) {
			this.bDebug = toBoolean(args.get("debug"),false);
		}


		AdapterFactory.DEBUG = this.bDebug;
		if (this.bDebug) {
			p("Clear error messages from the cache ... (will re-load)");
			Messages.clear();
		}

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7116
		clearCach();

		IProject myProject = this.getProject();
		IResourceDelta resourceDelta = this.getDelta(myProject);

		if (resourceDelta == null) {

			// Now find all the BPEL files in the project and validate them
			validate ( myProject, monitor );

		} else {

			processDeltas(resourceDelta.getAffectedChildren( IResourceDelta.CHANGED ), monitor );

		}

		long ended = System.currentTimeMillis();
		p(" Validation Ended " + (ended-started) + "ms");
		return new IProject[] { myProject };
	}



	void processDeltas ( IResourceDelta [] deltas , IProgressMonitor monitor ) throws CoreException {

		for(IResourceDelta delta : deltas) {
			processDeltas( delta.getAffectedChildren(IResourceDelta.CHANGED, IResource.FILE), monitor );
			IResource resource = delta.getResource();
			if (resource.getType () != IResource.FILE) {
				continue;
			}

//			 * @see IResourceDelta#CONTENT
//			 * @see IResourceDelta#DESCRIPTION
//			 * @see IResourceDelta#ENCODING
//			 * @see IResourceDelta#OPEN
//			 * @see IResourceDelta#MOVED_TO
//			 * @see IResourceDelta#MOVED_FROM
//			 * @see IResourceDelta#TYPE
//			 * @see IResourceDelta#SYNC
//			 * @see IResourceDelta#MARKERS
//			 * @see IResourceDelta#REPLACED

			if ((delta.getFlags() & IResourceDelta.CONTENT) != IResourceDelta.CONTENT ) {
				continue;
			}

			this.fResourceSet.resourceChanged((IFile)resource);
			validate ( resource, monitor );
		}
	}


	/**
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void clean (IProgressMonitor monitor) throws CoreException {
		removeProblemsAndTasksFor(getProject());
	}

	public static void removeProblemsAndTasksFor(IResource resource) {
		try {
			if (resource != null && resource.exists()) {
				resource.deleteMarkers(IBPELMarker.ID, false, IResource.DEPTH_INFINITE);
			}
		} catch (CoreException e) {
			// assume there were no problems
		}
	}
	/**
	 * Validate the resource using the monitor passed.
	 *
	 * @param resource (File or Folder)
	 * @param monitor the monitor to use.
	 * @throws CoreException
	 */
	public void validate (IResource resource, IProgressMonitor monitor) throws CoreException {

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7116
		// enable element location tracking for error reporting
		// TODO: move this to somewhere more appropriate when fixing JBIDE-6839
		Map<Object, Object> loadOptions = this.fResourceSet.getLoadOptions();
		loadOptions.put("TRACK_LOCATION", Boolean.TRUE);
		this.fResourceSet.setLoadOptions(loadOptions);


		switch (resource.getType()) {

		case IResource.FOLDER :
			IFolder folder = (IFolder) resource;
			for(IResource next :  folder.members() ) {
				validate (next,monitor);
			}
			break;

		case IResource.FILE :
			IFile file = (IFile) resource;

			p("File Resource : " + file.getName() );
			// https://jira.jboss.org/jira/browse/JBIDE-6006
			// use content type to check for BPEL files
			if ( isBPELFile(file) ||  "wsdl".equalsIgnoreCase(file.getFileExtension()) ) {
				IProject project = file.getProject();
				validate(project, monitor);
//				file.deleteMarkers(IBPELMarker.ID, true,  IResource.DEPTH_INFINITE);
//				deleteMarkersInReferencialResources(file);
//				makeMarkers ( validate (  file, monitor  ) );
			}
			break;

		case IResource.PROJECT:
			for(IFile bpelFile : getBPELFilesByProject((IProject)resource)){
				p("File Resource : " + bpelFile.getName() );

				bpelFile.deleteMarkers(IBPELMarker.ID, true,  IResource.DEPTH_INFINITE);
				deleteMarkersInReferencialResources(bpelFile);
				makeMarkers ( validate (  bpelFile, monitor  ) );
			}
		}


	}

	private List<IFile> getBPELFilesByProject(IProject project){

		final List<IFile> bpelFolders = new ArrayList<IFile>();
		IResourceVisitor bpelFolderFinder = new IResourceVisitor() {

			@Override
			public boolean visit(IResource resource) throws CoreException {
				if( resource.getType() == IResource.FILE){
					// https://jira.jboss.org/jira/browse/JBIDE-6006
					if(isBPELFile(resource)){
						bpelFolders.add((IFile)resource);
						return false;
					}
				}
				return true;
			}
		};
		try {
			project.accept(bpelFolderFinder);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return bpelFolders;
	}

	private void deleteMarkersInReferencialResources(IFile bpelFile) throws CoreException{

		this.fResourceSet.resourceChanged(bpelFile);
		this.fReader.read( bpelFile, this.fResourceSet );
		Process process = this.fReader.getProcess();

		p("Delete markers");
		// https://jira.jboss.org/browse/JBIDE-6825
		// in case of XML parse errors, the Process will be null!
		if (process == null) {
			p ("Cannot read BPEL Process !!!");
			return;
		}

		IContainer container = bpelFile.getParent();
		for(Import impt : process.getImports()){
			String fileLocation = impt.getLocation();
			IFile importedFile = container.getFile(new Path(fileLocation));
			if(importedFile != null && importedFile.exists()){
				importedFile.deleteMarkers(IBPELMarker.ID, false,  IResource.DEPTH_ZERO);
			}
		}

	}


	public void clearCach(){
		this.fResourceSet.getResources().clear();
	}
	/**
	 * @param file
	 * @param monitor
	 * @return return the list of problems found
	 */
	public IProblem[] validate (IFile file, IProgressMonitor monitor  ) {


		p("Validating BPEL Resource : " + file.getName() );

		// Step 1. Read the BPEL process using the Model API.

		this.fResourceSet.resourceChanged(file);
		this.fReader.read( file, this.fResourceSet );
		Process process = this.fReader.getProcess();

		if (process == null) {
			// https://jira.jboss.org/browse/JBIDE-6825
			// if the resource failed to parse because of malformed XML, the Process
			// will be null. Fetch the SAXParseDiagnostics from the resource and build
			// problem markers for this resource.
			Resource resource = this.fReader.getProcessResource();
			if ( resource!=null && !resource.getErrors().isEmpty() )
			{
				ArrayList<IProblem> problems = new ArrayList<IProblem>(resource.getErrors().size());
				for ( Diagnostic d : resource.getErrors())
				{
					IProblem problem = new Problem();
					problem.setAttribute(IProblem.ERESOURCE,resource);
					if (d instanceof SAXParseDiagnostic &&
							((SAXParseDiagnostic)d).getSeverity() == SAXParseDiagnostic.WARNING)
					{
						problem.setAttribute(IProblem.SEVERITY, IProblem.SEVERITY_WARNING);
					}
					else
						problem.setAttribute(IProblem.SEVERITY, IProblem.SEVERITY_ERROR);
					problem.setAttribute(IProblem.LINE_NUMBER, d.getLine());
					problem.setAttribute(IProblem.COLUMN_NUMBER, d.getColumn());
					problem.setAttribute(IProblem.MESSAGE, d.getMessage());

					problems.add(problem);
				}
				return problems.toArray( new Problem[problems.size()] );
			}

			p ("Cannot read BPEL Process !!!");
			return this.EMPTY_PROBLEMS ;
		}

		p("Read in BPEL Model OK" );

		// Step 2. Preparation for the validator.
		linkModels ( process );
		p("Models Linked" );

		// Process as INode
		INode node = (INode) this.fAdapterManager.getAdapter( process.getElement(), INode.class );

		// Debug: Dump the dom from the reader, just to see what we have
		// p( org.eclipse.bpel.model.util.BPELUtils.elementToString(process.getElement()));

		// Step 4. Run the validator.

		IProblem[] problemList = new Runner (ModelQueryImpl.getModelQuery(), node ).run();
		p("Validator Executed" );
		return problemList;
	}



	/**
	 * @param problemList
	 */
	public void makeMarkers ( IProblem [] problemList ) {

		if (problemList.length < 1) {
			return ;
		}

		// Step 5. Adapt problems to markers.
		for(IProblem problem : problemList) {
			this.fAdapterManager.getAdapter(problem, IMarker.class);
		}

		p( "Markers Created " );
		p( " ------ Done" );

		// done.
	}



	void linkModels ( EObject process ) {

		//
		// Each extensible element points to the DOM element that
		// comprises it. This is done in the BPEL reader as well as
		// the WSDL readers. Here we add a pointer to the
		// emf objects from the DOM objects.

		Iterator<?> emfIterator = process.eAllContents();
		while (emfIterator.hasNext()) {
			Object obj = emfIterator.next();
			// This is because only WSDLElement has a reference to
			// a DOM element.
			if (obj instanceof WSDLElement) {
				WSDLElement wsdle = (WSDLElement) obj;
				Element el = wsdle.getElement();
				if (el != null) {
//					System.out.println(el.getOwnerDocument().getDocumentURI() + " " + el.getLocalName() + "----" + obj);
					el.setUserData("emf.model", obj, null); //$NON-NLS-1$
				}
			}
		}
	}


	@SuppressWarnings("boxing")
	boolean toBoolean ( Object obj , boolean def) {
		if (obj instanceof String) {
			return Boolean.valueOf((String)obj);
		}
		return def;
	}



	void p (String msg ) {
		if (this.bDebug) {
			System.out.printf( "[%1$s]>> %2$s\n", getClass().getName(), msg);
			System.out.flush();
		}
	}

	// https://jira.jboss.org/jira/browse/JBIDE-6006
	public static boolean isBPELFile(IResource res)
	{
		try
		{
			if (res.getType() == IResource.FILE) {
				IContentDescription desc = ((IFile) res).getContentDescription();
				if (desc != null) {
					IContentType type = desc.getContentType();
					if (type.getId().equals(BPEL_CONTENT_TYPE))
						return true;
				}
			}
		}
		catch(Exception ex)
		{
		}
		return false;
	}

}
