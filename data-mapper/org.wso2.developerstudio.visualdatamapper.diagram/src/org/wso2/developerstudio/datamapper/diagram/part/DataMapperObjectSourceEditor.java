package org.wso2.developerstudio.datamapper.diagram.part;

import java.awt.Component;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.internal.resources.ModelObject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IModelStateListener;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.text.rules.StructuredTextPartitioner;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.datamapper.*;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute;



public class DataMapperObjectSourceEditor {

	/**
	 * Default input.
	 */
	public static final String EDITOR_DEFAULT_INPUT = "<note>Source not available.</note>";
	
	/**
	 * Used to execute commands.
	 */
	private AdapterFactoryEditingDomain editingDomain;
	
	/**
	 * Internal {@link StructuredTextEditor} instance.
	 */
	private StructuredTextEditor editor;
	
	/**
	 * A custom {@link IEditorInput} used for editing in-memory resources.
	 */
	private IEditorInput input;
	
	/**
	 * Used by the client to listen for editor changes.
	 */
	private IModelStateListener listener;
	
	/**
	 * Currently edited object.
	 */
	//private ModelObject modelObject;	
	
	//private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * Creates a new {@link DataMapperObjectSourceEditor} using the specified {@link IFile} as a dummy input.
	 * 
	 * @param dummyFile temporary {@link IFile} to be used as {@link IEditorInput}.
	 * @param editingDomain used to execute commands.
	 * @return 
	 */
	public  DataMapperObjectSourceEditor(IFile dummyFile){//, AdapterFactoryEditingDomain editingDomain) {
		//this.editingDomain = editingDomain;
		this.editor = new StructuredTextEditor(){

			public void doSave(IProgressMonitor progressMonitor) {
				/*TODO: handle source to design*/
				super.doSave(progressMonitor);
			}

			public boolean isEditable() {
				/*Source view is currently read-only*/
				return true;
			}
		};
		this.input = new FileEditorInput(dummyFile);
		
//		getDocument().set("Lali");
//		this.listener = new ModelStateListenerAdapter() {
//            public void modelChanged(IStructuredModel model) {
//            	handleSourceEditedEvent();
//            }			
//		};
	}
	
//	/**
//	 * Method invoked when the user edits the source.	
//	 */
//	private void handleSourceEditedEvent() {
//		if (null != modelObject) {
//			if (!modelObject.getObjectState().equals(ModelObjectState.WORKING)) {
//				Command setObjectStateCommand = new SetCommand(editingDomain, modelObject, EsbPackage.eINSTANCE
//						.getModelObject_ObjectState(), ModelObjectState.WORKING);
//				editingDomain.getCommandStack().execute(setObjectStateCommand);
//			}
//			modelObject.setSourceText(getSource());
//		}
//	}
	
	/**
	 * @return current source content of the editor.
	 */
	private String getSource() {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();
	}
	
/*	*//**
	 * Updates this source editor to represent the specified {@link ModelObject}.
	 * 
	 * @param object {@link ModelObject} to be edited.
	 * 
	 */
	public void update(String configuration) {
//		getDocument().setDocumentPartitioner(new StructuredTextPartitioner());
		getDocument().set(configuration);
		
//		export(configuration);
//		 EList<TreeNode> tree= configuration.getTreeNode();
		
//		printHierarchy(configuration);
		
		/*
		 * get all root (trees - atribute -  element)
		 */
	}
	
	
	private void export(String input) {
		MessageBox exportMsg = new MessageBox(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.ICON_INFORMATION);
		exportMsg.setText("WSO2 Platform Distribution DataMapper");
		DirectoryDialog dirDlg = new DirectoryDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		String dirName = dirDlg.open();
		
		File config = new File(dirName, "config.js");
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(config));
			output.write(input);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}

	@SuppressWarnings("unchecked")
	private void printHierarchy(EList<TreeNode> treeNode){
		getDocument().set("map org.wso2.employee -> org.example.wso2.datamapper.engineer \n fullname = concat(firstname,lastname)");
//		getDocument().set("<" +treeNode.getName()+">"+ "\n");
		System.out.println("<" + "tree "+">"+ "\n");
		
		for(int i =0;  i< (((TreeNode) (treeNode)).getNode()).size();i++){
			
			printHierarchy( (EList<TreeNode>) ((TreeNode) treeNode).getNode().get(i));
		}
		
		for(int j=0; j<((TreeNode) treeNode).getAttribute().size();j++){
			System.out.println("<" +((Attribute) ((TreeNode) treeNode).getAttribute()).getName()+">"+ "\n");
		}
		
		for(int k=0; k<((TreeNode) treeNode).getElement().size();k++){
			System.out.println("<" +((Element) ((TreeNode) treeNode).getElement()).getName()+">"+ "\n");
		}
		
		
		
		//getDocument().set("</" +treeNode.getName()+"> " + "\n");
	}
	
	/*
	public void update(EsbServer server){//ModelObject object) {
		String newSource = null;		
//		try {
			try {
				newSource=EsbModelTransformer.instance.designToSource(server);
			}catch (Exception e) {
				log.error("Cannot update source view", e);
				String simpleMessage = ExceptionMessageMapper.getNonTechnicalMessage(e.getMessage());
				IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
				ErrorDialog.openError(getEditor().getSite().getShell(), "Error", "Cannot update source view. The following error(s) have been detected", editorStatus);
			} 
			*/
//			newSource = EsbFactory.eINSTANCE.serializeToString(object);
//		} catch (Exception ex) {
//			// TODO: Get rid of this.
//			ex.printStackTrace();
//		}	
//		
//		IStructuredModel model = getStructuredModel();
//
//		// Remove the listener so that no events are fired during update.
//		if (null != model) {
//			model.removeModelStateListener(listener);
//		}
//
//		// Save model object.
//		//this.modelObject = object;
//
//		if (null == newSource) {
//			// Reset source editor input.
//			getDocument().set(EDITOR_DEFAULT_INPUT);
//		} else {
//			// Avoid un-necessay refreshing.
//			if (!getSource().equals(newSource)) {
//				// Change source editor input.
//			getDocument().setDocumentPartitioner(new StructuredTextPartitioner());
//				getDocument().set(newSource);
//			}
//
//			// Add back source listner.
//			model = getStructuredModel();
//			if (null != model) {
//				model.addModelStateListener(listener);
//			}
//		}
//	}
	
	/**
	 * Utility method for obtaining the current {@link IDocument} instance.
	 * 
	 * @return {@link IDocument} corresponding to current {@link IEditorInput}.
	 */
	public IDocument getDocument() {
		return editor.getDocumentProvider().getDocument(editor.getEditorInput());
	}
	
	/**
	 * Attempts to retrieve the {@link IStructuredModel} used by the internal {@link StructuredTextEditor}.
	 * 
	 * @return {@link IStructuredModel} used by the source editor or null. 
	 */
	private IStructuredModel getStructuredModel() {
		IDocument document = getDocument();
		IStructuredModel model = StructuredModelManager.getModelManager().getExistingModelForEdit(document);					
		if (null == model && (document instanceof IStructuredDocument)) {
			model = StructuredModelManager.getModelManager().getModelForEdit((IStructuredDocument) document);
		}
		return model;
	}	
	
	/**
	 * @return internal {@link IEditorPart} instance.
	 */
	public IEditorPart getEditor() {
		return editor;
	}
	
	/**
	 * @return internal {@link IEditorInput} instance.
	 */
	public IEditorInput getInput() {
		return input;
	}
}
