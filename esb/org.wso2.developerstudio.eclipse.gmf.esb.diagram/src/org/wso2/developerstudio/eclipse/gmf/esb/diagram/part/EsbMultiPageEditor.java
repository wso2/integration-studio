/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;


import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SEQUENCE_RESOURCE_DIR;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ExceptionMessageMapper;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.MediatorFactoryUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.UpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.SequenceInfo;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * The main editor class which contains design view and source view
 * <ul>
 * <li>page 0 graphical view
 * <li>page 1 source view
 * </ul>
 */
public class EsbMultiPageEditor extends MultiPageEditorPart implements
        IGotoMarker,IDiagramWorkbenchPart{

    /** Our all new graphical editor */
    private EsbDiagramEditor graphicalEditor;

	/**
	 * {@link ModelObject} source editor.
	 */
	private EsbObjectSourceEditor sourceEditor;
    
	/**
	 * Name of the directory which holds temporary files.
	 */
	public static final String TEMPORARY_RESOURCES_DIRECTORY = ".org.wso2.developerstudio.eclipse.esb";

	/**
	 * Design view page index.
	 */
	private static final int DESIGN_VIEW_PAGE_INDEX = 0;

	/**
	 * Source view page index.
	 */
	private static final int SOURCE_VIEW_PAGE_INDEX = 1;
	
	/**
	 * Properties view page index.
	 */
	private static final int PROPERTY_VIEW_PAGE_INDEX = 2;
	
	/**
	 * Used to hold temporary files.
	 */
	private Set<IFile> tempFiles = new HashSet<IFile>();
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	/*source editor dirty state*/
	private boolean sourceDirty;
	
	public static EsbMultiPageEditor currentEditor;
	
    /**
     * Creates a multi-page editor
     */
    public EsbMultiPageEditor() {
        super();
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
         
        // open the perspective "wso2 esb graphical"
        // TODO review if this is the best place for switching
        try {
			workbench.showPerspective("org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.perspective", window);
		} catch (WorkbenchException e) {
		}

    }
 

    /**
     * Creates page 0 of the multi-page editor,
     * which contains a out graphical diagram
     */
    void createPage0() {
        try {
        	GMFPluginDetails.setiUpdateGMFPlugin(new UpdateGMFPlugin());
        	currentEditor=this;
            graphicalEditor = new EsbDiagramEditor(this);
            addPage(DESIGN_VIEW_PAGE_INDEX, graphicalEditor, getEditorInput());
            setPageText(DESIGN_VIEW_PAGE_INDEX, "Design"); //$NON-NLS-1$
            
            // Disable Zoom on CTRL+MOUSE WHEEL. 
			if (getDiagramGraphicalViewer() != null) {
				getDiagramGraphicalViewer().setProperty(
						MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL), null);
			}
        } catch (PartInitException e) {
            ErrorDialog
                    .openError(
                            getSite().getShell(),
                            "ErrorCreatingNestedEditor", null, e.getStatus());
        }
        
        /*
         * This must be altered. 'addDefinedSequences' and 'addDefinedEndpoints' methods should not exist inside EsbPaletteFactory class. 
         * Creating new instance of 'EsbPaletteFactory' must be avoided.
         */
        EsbPaletteFactory esbPaletteFactory=new EsbPaletteFactory();
        esbPaletteFactory.addDefinedSequences(getEditor(0));
        esbPaletteFactory.addDefinedEndpoints(getEditor(0));
        
        //esbPaletteFactory.addCloudConnectors(getEditor(0));
        
        
		IFileEditorInput input = (IFileEditorInput) getEditor(0).getEditorInput();
		IFile file = input.getFile();
		IProject activeProject = file.getProject();
		
		//String connectorDirectory=activeProject.getLocation().toOSString()+File.separator+"cloudConnectors";
		String connectorDirectory = activeProject.getWorkspace().getRoot().getLocation()
				.toOSString()
				+ File.separator + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
		File directory=new File(connectorDirectory);
		if(directory.isDirectory()){
			String[] children=directory.list();
	        for(int i=0;i<children.length;++i){
	        	esbPaletteFactory.addCloudConnectorOperations(getEditor(0), children[i]);
	        }
		}

        
        

        
		String pathName=activeProject.getLocation().toOSString()+File.separator+"resources";
/*		File resources=new File(pathName);
			resources.mkdir();
			File cloudConnectorConfig=new File(pathName+File.separator+"cloudConnector.properties");
			cloudConnectorConfig.createNewFile();*/
			
		Properties prop = new Properties();
		FileInputStream inStream = null;
		File cloudConFile = new File(pathName, "cloudConnector.properties");
		if (cloudConFile.exists()) {
			try {
				inStream = new FileInputStream(cloudConFile);
				prop.load(inStream);
			} catch (FileNotFoundException e) {
				log.error("File is not available.", e);
			} catch (IOException e) {
				log.error("Error occured while trying to load properties", e);
			} finally {
				if (inStream != null) {
					try {
						inStream.close();
					} catch (IOException e) {
						log.error(
								"Error occured while tying to close the file stream",
								e);
					}
				}
			}
		}
		
		String localEntryConfigs=prop.getProperty("LOCAL_ENTRY_CONFIGS");
		if(localEntryConfigs!=null){
			String[] configs=localEntryConfigs.split(",");
	        
	        for(int i=0;i<configs.length;++i){
	        	if(!"".equals(configs[i])){
	        		//esbPaletteFactory.addCloudConnectorOperations(getEditor(0), configs[i].split("-")[0],configs[i].split("-")[1]);
	        	}
	        }
		}
        esbPaletteFactory.updateToolPaletteItems(graphicalEditor);
        
        EditorUtils.setLockmode(graphicalEditor, false);

		// change editor title when a file rename occurs
		getEditor(0).addPropertyListener(new IPropertyListener() {

			@Override
			public void propertyChanged(Object source, int propId) {
				setInput(getEditor(0).getEditorInput());
				IFileEditorInput editorInp = (IFileEditorInput) getEditor(0).getEditorInput();
				String fileName = editorInp.getFile().getName();
				setTitle(fileName.substring(fileName.indexOf('_') + 1, fileName.length() -
				                                                       "esb_diagram".length()) +
				         "xml");
			}
		});
    }

    /**
     * Creates page 1 of the multi-page editor,
     * which allows you to edit the xml.
     */
    void createPage1() {   
    	
		try {
			sourceEditor = new EsbObjectSourceEditor(
					getTemporaryFile("xml"));
			addPage(SOURCE_VIEW_PAGE_INDEX,
					sourceEditor.getEditor(),
					sourceEditor.getInput());
			setPageText(SOURCE_VIEW_PAGE_INDEX,	"Source");
			
			sourceEditor.getDocument().addDocumentListener(new IDocumentListener() {  
			    
	            public void documentAboutToBeChanged(final DocumentEvent event) {  
	                // nothing to do
	            }  
	   
	            public void documentChanged(final DocumentEvent event) {  
	            	sourceDirty=true;
	            	firePropertyChange(PROP_DIRTY);
	            }  
	        });  

			// Initialize source editor.
			//updateSourceEditor();
		} catch (Exception ex) {
			log.error("Error while initializing source viewer control.",ex);
		}	
		
    }
    
  /*  private void createModel(IEditorInput editorInput) throws PartInitException{
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Resource resource = null;
		
		EsbResourceFactoryImpl fac = new EsbResourceFactoryImpl();
		resource = fac.createResource(resourceURI);
		
		graphicalEditor = new EsbDiagramEditor();
		graphicalEditor.setDocumentProvider(editorInput);
		TransactionalEditingDomain  t=graphicalEditor.getEditingDomain();
		t.getResourceSet().getResources().add(resource);
		try {
			// Load the resource through the editing domain.
			//
			resource = graphicalEditor.getEditingDomain().getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = graphicalEditor.getEditingDomain().getResourceSet().getResource(resourceURI, false);
		}
    }*/

    /**
     * Creates page 2 of the multi-page editor,
     * which shows the sorted text.
     */
    void createPage2() {
        Composite composite = new Composite(getContainer(), SWT.NONE);
        GridLayout layout = new GridLayout();
        composite.setLayout(layout);
        layout.numColumns = 2;

        //Label demoLabel = new Label(composite, SWT.NONE);
        GridData gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan = 2;
        //demoLabel.setLayoutData(gd);
        //demoLabel.setText("ChangeFont");

        int index = addPage(composite);
        setPageText(index, "Properties");
    }
    
	/**
	 * Utility method for obtaining a reference to a temporary file with the
	 * given extension.
	 *
	 * @param extension
	 *            extension of the temporary file.
	 * @return {@link IFile} instance corresponding to the spefied temporary
	 *         file.
	 * @throws Exception
	 *             if a temporary file cannot be created.
	 */
	private IFile getTemporaryFile(String extension) throws Exception {
		String fileName = String.format("%s.%s", UUID.randomUUID().toString(),
				extension);
		IFile tempFile = getTemporaryDirectory().getFile(fileName);
		if (!tempFile.exists()) {
			tempFile.create(new ByteArrayInputStream(new byte[0]), true, null);
		}
		tempFiles.add(tempFile);
		return tempFile;
	}

	/**
	 * Utility method for obtaining a reference to the temporary files
	 * directory.
	 *
	 * @return reference to the temporary files directory inside the current
	 *         project.
	 * @throws Exception
	 *             if an error occurs while creating the temporary resources
	 *             directory.
	 */
	private IFolder getTemporaryDirectory() throws Exception {
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput || editorInput instanceof FileStoreEditorInput) {
			
			IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".tmp");
			
			if (!tempProject.exists()){
				tempProject.create(new NullProgressMonitor());
			}
			
			if (!tempProject.isOpen()){
				tempProject.open(new NullProgressMonitor());
			}
			
			if (!tempProject.isHidden()) {
				tempProject.setHidden(true);
			}

			IFolder folder = tempProject.getFolder(TEMPORARY_RESOURCES_DIRECTORY);
			
			if (!folder.exists()) {
				folder.create(true, true, new NullProgressMonitor());
			}
			
			return folder;
		} else {
			throw new Exception(
					"Unable to create temporary resources directory.");
		}
	}

    /**
     * Creates the pages of the multi-page editor.
     */
    protected void createPages() {
        createPage0();
        EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
		EsbServer server = diagram.getServer();	
        switch (server.getType()) {
		case COMPLEX_ENDPOINT:			
			break;
		default:
			createPage1();
			break;
		}
        EditorUtils.setLockmode(graphicalEditor, true);
		IFile file = ((IFileEditorInput)getEditorInput()).getFile();
/*        ElementDuplicator endPointDuplicator = new ElementDuplicator(file.getProject(),getGraphicalEditor());        
        endPointDuplicator.updateAssociatedDiagrams(this);*/
        EditorUtils.setLockmode(graphicalEditor, false);
        
        //createPage2();
    }
    
	/**
	 * This is used to track the active viewer. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		// I do not understand why this is necessary (emf generated code).
		// if (contentOutlinePage != null) {
		// handleContentOutlineSelection(contentOutlinePage.getSelection());
		// }

		// Invoke the appropriate handler method.
		switch (pageIndex) {
		case DESIGN_VIEW_PAGE_INDEX: {
			MediatorFactoryUtils.registerFactories();
			handleDesignViewActivatedEvent(); 
			final EsbMultiPageEditor currentEditor = this;						
			Display.getCurrent().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					EditorUtils.setLockmode(graphicalEditor, true);
					final boolean dirty = isDirty(); //save previous status
					IFile file = ((IFileEditorInput)getEditorInput()).getFile();
/*			        ElementDuplicator endPointDuplicator = new ElementDuplicator(file.getProject(),getGraphicalEditor());        
			        endPointDuplicator.updateAssociatedDiagrams(currentEditor);*/

					/**
					 * This is to avoid RJS0007E Semantic refresh failed issue
					 * appears in compartments, which has only one node. This
					 * should be replaced with the better approach
					 */
			        AbstractEsbNodeDeserializer.relocateStartNodes();
			        AbstractEsbNodeDeserializer.resizeParentCompartments();
			        
			        if(!dirty && isDirty()){
			        	//remove any dirty status introduced by ElementDuplicator or relocateStartNodes();
			        	 getEditor(0).doSave(new NullProgressMonitor());
			        	 firePropertyChange(PROP_DIRTY);
			        }

			        EditorUtils.setLockmode(graphicalEditor, false);
			        
				}
			});
		
			break;
		}
		case SOURCE_VIEW_PAGE_INDEX: {
			updateSequenceDetails();
			handleSourceViewActivatedEvent();
			break;

		}
		}
	}
	
	/**
	 * Performs necessary house-keeping tasks whenever the design view is
	 * activated.
	 */
	private void handleDesignViewActivatedEvent() {

//		if (null != sourceEditor.getObject()) {
//			rebuildModelObject(objectSourceEditor.getObject());
//		}
		if(sourceEditor!=null){
			String xmlSource = sourceEditor.getDocument().get();
			if(xmlSource!=null && sourceDirty){
				  if(!xmlSource.trim().isEmpty()){
					  rebuildModelObject(xmlSource); 
				  }
			}
		}
		
	}

	/**
	 * Performs necessary house-keeping tasks whenever the source view is
	 * activated.
	 */
	private void handleSourceViewActivatedEvent() {
//		if (null == contentOutlinePage) {
//			// Need to sync the soure editor explicitly.
		
			updateSourceEditor();
//		}
	}

    private void updateSourceEditor() {
    	EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
		EsbServer server = diagram.getServer();	
		sourceEditor.update(server);		
		sourceDirty=false;
		firePropertyChange(PROP_DIRTY);
	}
    
    
	private void updateAssociatedXMLFile(IProgressMonitor monitor) {
		EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
		EsbServer server = diagram.getServer();
		IEditorInput editorInput = getEditor(0).getEditorInput();
		
		if (editorInput instanceof IFileEditorInput) {
			IFile diagramFile = ((FileEditorInput) editorInput).getFile();
			String xmlFilePath = diagramFile.getFullPath().toString();
			xmlFilePath = xmlFilePath
					.replaceFirst("/graphical-synapse-config/", "/synapse-config/")
					.replaceFirst("/(endpoint_|localentry_|proxy_|sequence_|task_|template_|api_|messageStore_|messageProcessor_)", "/") /* Fixing TOOLS-1578 */
					.replaceAll(".esb_diagram$", ".xml");
			IFile xmlFile = diagramFile.getWorkspace().getRoot().getFile(new Path(xmlFilePath));
			try {
				String source = EsbModelTransformer.instance.designToSource(server);
				if (source == null) {
					log.warn("Could get source");
					return;
				}
				InputStream is = new ByteArrayInputStream(source.getBytes());
				if (xmlFile.exists()) {
					xmlFile.setContents(is, true, true, monitor);
				} else {
					xmlFile.create(is, true, monitor);
				}

			} catch (Exception e) {
				log.warn("Could not save file " + xmlFile);
			}
		}
	}
	
	private void updateAssociatedDiagrams() {
		
		EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
		EsbServer server = diagram.getServer();
		switch (server.getType()) {
		case SEQUENCE:
			Object child = server.getChildren().get(0);
			if (child instanceof Sequences) {
				IFileEditorInput input = (IFileEditorInput) this.getEditorInput();
				IFile file = input.getFile();

				IEditorReference editorReferences[] = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage().getEditorReferences();
				for (int i = 0; i < editorReferences.length; i++) {
					IEditorPart editor = editorReferences[i].getEditor(false);
					if ((editor instanceof EsbMultiPageEditor)&&(!editor.equals(this))) {
						
						
						
						IFile openedFile = ((IFileEditorInput)editor.getEditorInput()).getFile();
/*				        ElementDuplicator endPointDuplicator = new ElementDuplicator(openedFile.getProject(),((EsbMultiPageEditor)editor).getGraphicalEditor());        
				        endPointDuplicator.updateAssociatedDiagrams((EsbMultiPageEditor)editor);*/
						
						
/*						Map registry = ((EsbMultiPageEditor) editor).getDiagramEditPart()
								.getViewer().getEditPartRegistry();

						
						Collection<Object> values=new ArrayList<Object>();
						values.addAll(registry.values());
						
						for (int j = 0; j < values.size(); ++j) {
							EditPart element = (EditPart) values.toArray()[j];
							if (element instanceof SequenceEditPart) {
								String key = ((Sequence) ((Node) element.getModel()).getElement())
										.getName();
								String name = ((Sequences) child).getName();
								if (key.equals(name)) {
									EndPointDuplicator endPointDuplicator = new EndPointDuplicator(file.getProject(),
											((EsbMultiPageEditor) editor).graphicalEditor);
									GraphicalEditPart rootCompartment = EditorUtils
											.getSequenceAndEndpointCompartmentEditPart(element);
									endPointDuplicator.duplicateEndPoints(rootCompartment,
											((Sequences) child).getName());
								}
							}
						}*/
					}
				}
			}
			break;
		}
	}
    

	/**
     * Saves the multi-page editor's document.
     */
    public void doSave(IProgressMonitor monitor) {
    	if(getActivePage()==SOURCE_VIEW_PAGE_INDEX){
    		handleDesignViewActivatedEvent();
    	}
    	sourceDirty=false;
        getEditor(0).doSave(monitor);
        EsbServer esbServer = EditorUtils.getEsbServer(graphicalEditor);
        
        //Since Complex endpoint type editors dose not have assiociated xml file do not need to call this.
        if(!esbServer.getType().equals(ArtifactType.COMPLEX_ENDPOINT)){
        	
        	updateAssociatedXMLFile(monitor);
        }
        
		EditorUtils.setLockmode(graphicalEditor, true);
        
		IFile file = ((IFileEditorInput)getEditorInput()).getFile();
/*        ElementDuplicator endPointDuplicator = new ElementDuplicator(file.getProject(),getGraphicalEditor());        
        endPointDuplicator.updateAssociatedDiagrams(this);*/
        updateAssociatedDiagrams();
        getEditor(0).doSave(monitor);
        
		EditorUtils.setLockmode(graphicalEditor, false);
    }
    

	public boolean isDirty() {
		if (getEditor(0) instanceof EsbDiagramEditor) {
			return getEditor(0).isDirty() || sourceDirty;
		}
		return super.isDirty();
	}

    /**
     * Saves the multi-page editor's document as another file.
     * Also updates the text for page 0's tab, and updates this multi-page editor's input
     * to correspond to the nested editor's.
     */
    public void doSaveAs() {
    	if(getActivePage()==SOURCE_VIEW_PAGE_INDEX){
    		handleDesignViewActivatedEvent();
    	}
    	sourceDirty=false;
        IEditorPart editor = getEditor(0);
        editor.doSaveAs();
        setPageText(0, editor.getTitle());
        setInput(editor.getEditorInput());
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    public void init(IEditorSite site, IEditorInput editorInput)
            throws PartInitException {    	
    	
    	/*setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());*/
    	
        if (!(editorInput instanceof IFileEditorInput))
            throw new PartInitException("InvalidInput"); //$NON-NLS-1$     
        
       // createModel(editorInput);
       super.init(site, editorInput);
       String name = editorInput.getName();
       setTitle(name.substring(name.indexOf('_')+1,name.length()-"esb_diagram".length())+"xml");
    }    
    

    /* (non-Javadoc)
     * Method declared on IEditorPart.
     */
    public boolean isSaveAsAllowed() {
        return true;
    }


    /* (non-Javadoc)
     * @see org.eclipse.ui.ide.IGotoMarker
     */
    public void gotoMarker(IMarker marker) {
        setActivePage(DESIGN_VIEW_PAGE_INDEX);
        IDE.gotoMarker(graphicalEditor, marker);
    }
    
    
    private void updateSequenceDetails(){

		IEditorPart editorPart = null;
		IProject activeProject = null;
		IEditorReference editorReferences[] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);

			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow()
						.getActivePage().getActiveEditor();
			}

			if (editorPart != null) {
				IFileEditorInput input = (IFileEditorInput) editorPart
						.getEditorInput();
				IFile file = input.getFile();
				activeProject = file.getProject();

			}

		}
		
		List<Sequence> childNodes = new ArrayList<Sequence>();		
		
		for (int i = 0; i < graphicalEditor.getDiagramEditPart().getViewer()
				.getEditPartRegistry().size(); ++i) {

			EditPart element = (EditPart) graphicalEditor.getDiagramEditPart()
					.getViewer().getEditPartRegistry().values().toArray()[i];
			if (element instanceof SequenceEditPart) {
				if (((NodeImpl) ((SequenceEditPart) element).getModel())
						.getElement() instanceof Sequence) {
					childNodes
							.add((Sequence) ((NodeImpl) ((SequenceEditPart) element)
									.getModel()).getElement());
				}
			}
		}		
		
		for (Sequence childNode : childNodes) {
				String name = childNode.getName();
				IPath location = new Path(SEQUENCE_RESOURCE_DIR + "/" + "sequence_"
						+ name + ".esb_diagram");
				IFile file = activeProject.getFile(location);

				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = null;

				File f = new File(file.getLocationURI().getPath());
				URI uri = URI.createFileURI(f.getAbsolutePath());

				if (!f.exists()) {

				} else {

					resource = resourceSet.getResource(uri, true);

					EsbDiagram s = (EsbDiagram) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) resource
							.getContents().get(0)).getElement();
					EList<EsbElement> children = s.getServer().getChildren();
					for (EsbElement esbElement : children) {
						if (esbElement instanceof Sequences){
							Sequences sequence = (Sequences) esbElement;
							EsbLink incomingLink = sequence.getOutputConnector().getOutgoingLink();
							SequenceInfo.sequenceMap.put(name, incomingLink);
						}
					}
//					if (s.getSequence().getInput().getOutgoingLink() != null) {
//						EsbLink incomingLink = s.getSequence().getInput()
//								.getOutgoingLink();
//						SequenceInfo.sequenceMap.put(name, incomingLink);
//					}
				}
		}
    }
    
    
	void rebuildModelObject(final String xml) {
		/*try {
			Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(activeShell);
			progressMonitorDialog.setOpenOnRun(true);
			progressMonitorDialog.run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException,
						InterruptedException {
					try {
						monitor.setTaskName("Generating diagram from source");
						Deserializer.getInstance().updateDesign(xml, graphicalEditor);
						sourceDirty=false;
					} catch (Exception e) {
						new InvocationTargetException(e);
					}
				}
			
			});
			
		} catch (InvocationTargetException e) {
			log.error("Error while generating diagram from source",e.getTargetException());
		} catch (InterruptedException e) {
			log.warn("The operation was canceled by the user", e);
		} finally{
			firePropertyChange(PROP_DIRTY);
		}*/
		
		try {
			Deserializer.getInstance().updateDesign(xml, graphicalEditor);
			
			final EsbMultiPageEditor tempEditor = this;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					page.activate(tempEditor);
					
				}
			});
			
		} catch (Exception e) {
			log.error("Error while generating diagram from source", e);
			String errorMsgHeader = "Error occuerd during buidling the esb design view."
							+ " Any changes you make in the source view to be discarded."
							+ " Please see the log for more details.";
			String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(e.getMessage());
			IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
			ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorMsgHeader, editorStatus);
			
		} finally{
			AbstractEsbNodeDeserializer.cleanupData();
			sourceDirty=false;
			firePropertyChange(PROP_DIRTY);
		}
	}
	
	public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		return graphicalEditor.getDiagramGraphicalViewer();
	}
	
	public IDiagramEditDomain getDiagramEditDomain() {
		return graphicalEditor.getDiagramEditDomain();
	}
	
	public Diagram getDiagram() {
		return graphicalEditor.getDiagram();
	}
	
	public DiagramEditPart getDiagramEditPart() {
		return graphicalEditor.getDiagramEditPart();
	}
    
	public EsbDiagramEditor getGraphicalEditor() {
		return graphicalEditor;
	}
	
	public void focusToolbar() {
		graphicalEditor.focusToolBar();
	}
	
}
