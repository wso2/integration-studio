package org.wso2.developerstudio.eclipse.humantask.editor.editors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.UUID;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.humantask.editor.Activator;
import org.wso2.tools.humantask.model.ht.DocumentRoot;
import org.wso2.tools.humantask.model.ht.THumanInteractions;
import org.wso2.tools.humantask.model.ht.util.HTAdapterFactory;
import org.wso2.tools.humantask.model.ht.util.HTResourceFactoryImpl;


/**
 * Human Interactions multi-page editor. Developed as a multi-paged form editor.
 * This editor will contain separate form views for overall human interactions file listing
 * tasks, notifications, logical people groups and imported files. And this overall view will allow 
 * users to add logical people groups, tasks, and notifications. 
 * 
 * There will be a separate page for each and every task and notification created. Those pages are
 * developed based on eclipse form editing capabilities. 
 * 
 */
public class HTMultiPageEditor extends FormEditor implements
		IEditingDomainProvider {
	// Human Interactions Model
	protected THumanInteractions humanInteractions;

	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;

	// Human Interactions source viewer
	protected StructuredTextEditor sourceViewer;

	// Command stack used to track the editor dirty state and undo/redo
	protected BasicCommandStack commandStack;
	
	// Human Interaction overall view page. Contains Logical People Group list, Task List, Notification
	// list.
	protected HumanInteractionsPage humanIneractionsPage;

	public HTMultiPageEditor() {
		super();
		initializeEditingDomain();
	}

	/**
	 * The implementation of this method checks that the input is an instance of
	 * <code>IFileEditorInput</code> and creates the data model.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		super.init(site, editorInput);
		setPartName(editorInput.getName());

		if (!(editorInput instanceof IFileEditorInput)) {
			throw new PartInitException(
					"Invalid Input: Must be IFileEditorInput"); //$NON-NLS-1$
		}
		
		createModel();
	}

	/**
	 * Create the Human Interactions EMF generated model from the input file.
	 * @throws PartInitException
	 */
	protected void createModel() throws PartInitException {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Resource resource = null;

		HTResourceFactoryImpl fac = new HTResourceFactoryImpl();
		resource = fac.createResource(resourceURI);
		editingDomain.getResourceSet().getResources().add(resource);
		try {
			resource.load(Collections.EMPTY_MAP);

			EList<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof DocumentRoot) {
				humanInteractions = ((DocumentRoot) contents.get(0))
						.getHumanInteractions();
			}
		} catch (IOException e) {
			throw new PartInitException(e.getMessage(), e);
		}
	}

	/**
	 * Add pages to multi-page editor. This method will only add source view and overall view page
	 * in default and if the file is a already edited one containing several tasks definitions,
	 * pages for those tasks will also get created.
	 */
	@Override
	protected void addPages() {
		try {
			humanIneractionsPage = new HumanInteractionsPage(this, humanInteractions);
			addPage(humanIneractionsPage);
			sourceViewer = new StructuredTextEditor() {

				@Override
				public boolean isEditable() {
					return false;
				}
				
			};
			//xmlEditor = new StructuredTextEditor();			
			int index = addPage(sourceViewer, getEditorInput());
			setPageText(index, sourceViewer.getTitle());
			/* addPageChangedListener(new IPageChangedListener() {
                public void pageChanged(PageChangedEvent event) {
                	if(xmlEditor.isDirty()){
                		reflectModel();
                		sourceChanged = true;
                		HTMultiPageEditor.this.editorDirtyStateChanged();
                		humanIneractionsPage.updateModel(humanInteractions);
                	}
                }
			});	*/		
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	/*private void reflectModel() {
		reflecting = true;
		try {
			String content = getSource();
			IFileEditorInput inputFile = (IFileEditorInput)getEditorInput();			
			
			HTResourceFactoryImpl fac = new HTResourceFactoryImpl();

			IPath tempLocation = Activator.getStateLocationHT();
			UUID fileUUID = UUID.randomUUID();
			String fileName = "temp_hi" + fileUUID.toString() + ".hi";
			IPath tempFilePath = tempLocation.append(fileName);
			File tempHIFile = tempFilePath.toFile();

			FileWriter writer = new FileWriter(tempHIFile);
			writer.write(content);
			writer.close();

			Resource resource = fac.createResource(URI.createFileURI(tempHIFile
					.getAbsolutePath()));

			resource.load(Collections.EMPTY_MAP);

			EList<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof DocumentRoot) {
				File originalFile = new File(inputFile.getFile().getLocationURI());
				FileWriter outWriter = new FileWriter(originalFile);
				outWriter.write(content);
				outWriter.close();
				Resource originalResource = 
					fac.createResource(URI.createFileURI(originalFile.getAbsolutePath()));
				originalResource.load(Collections.EMPTY_MAP);
				EList<EObject> contentsOfOriginal = resource.getContents();
				if(!contentsOfOriginal.isEmpty() && contentsOfOriginal.get(0) instanceof DocumentRoot){
					humanInteractions = ((DocumentRoot) contents.get(0))
					.getHumanInteractions();
				}
			}
		} catch (IOException e) {			
			// Ignore
		} finally {
			reflecting = false;
		}
	}*/

	/*public String getSource() {
		IDocument document = xmlEditor.getDocumentProvider().getDocument(
				getEditorInput());
		return document.get();
	}*/

	@Override
	public void doSave(IProgressMonitor arg0) {
		//sourceChanged = false;
		//xmlEditor.doSave(null);
		commitPages(true);
		try {
			humanInteractions.eResource().save(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		flushCommandStack();
	}

	void flushCommandStack() {
		((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
		if (getContainer() != null && !getContainer().isDisposed())
			getContainer().getDisplay().asyncExec(new Runnable() {
				public void run() {
					editorDirtyStateChanged();
				}
			});
	}

	@Override
	public void doSaveAs() {
		throw new UnsupportedOperationException("SaveAs is not allowed.");
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack())
				.isSaveNeeded();
	}	

	@Override
	public void setFocus() {
		if (getActivePage() != -1 && getControl(getActivePage()) != null) {
			getControl(getActivePage()).setFocus();
		}
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new HTAdapterFactory());

		// Create the command stack that will notify this editor as commands are
		// executed.
		commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to
		// be the selection of the viewer with focus.
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						editorDirtyStateChanged();
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}
	
	protected IEditorSite createSite(IEditorPart page) {
		IEditorSite site = null;
		if (page == sourceViewer) {
			site = new MultiPageEditorSite(this, page);
		}
		else {
			site = super.createSite(page);
		}
		return site;
	}

}
