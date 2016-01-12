package org.wso2.developerstudio.datamapper.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.avro.Schema;
import org.apache.avro.SchemaParseException;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.AvroSchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.DataMapperModelTransformer;
import org.wso2.developerstudio.datamapper.diagram.custom.util.EditorUtils;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class DataMapperMultiPageEditor extends MultiPageEditorPart implements IGotoMarker {

	private static DataMapperDiagramEditor graphicalEditor;

	private DataMapperObjectSourceEditor sourceEditor;

	public static final String TEMPORARY_RESOURCES_DIRECTORY = "org.wso2.developerstudio.visualdatamapper"; //$NON-NLS-1$

	private static final int SOURCE_VIEW_PAGE_INDEX = 1;

	private static final int DESIGN_VIEW_PAGE_INDEX = 0;
	
	private static final String INPUT_SCHEMA_ID = "Input-Schema"; //$NON-NLS-1$
	
	private static final String OUTPUT_SCHEMA_ID = "Output-Schema"; //$NON-NLS-1$

	private static final String ERROR_WRITING_SCHEMA_FILE = Messages.DataMapperMultiPageEditor_errorWritingSchemaFile;

	private static final String ERROR_PARSING_THE_SCHEMA = "Error parsing the schema";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private Set<IFile> tempFiles = new HashSet<IFile>();
	
//	private static ArrayList<Integer> OPERATION_LIST = new ArrayList<Integer>();

	// private static IDeveloperStudeioLog Log
	// =Logger.getLog(Activator.PLUGIN_ID);

	private boolean sourceDirty;

	public DataMapperMultiPageEditor() {
		super();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();

		try {
			workbench.showPerspective("org.wso2.developerstudio.datamapper.diagram.custom.perspective", window); //$NON-NLS-1$
		} catch (WorkbenchException e) {
		}

	}

	void createPage0() {
		try {
			graphicalEditor = new DataMapperDiagramEditor(this);
			addPage(DESIGN_VIEW_PAGE_INDEX, graphicalEditor, getEditorInput());
			setPageText(DESIGN_VIEW_PAGE_INDEX, "Design"); //$NON-NLS-1$

			// if(getDiagramGraphicalViewer() != null){
			// getDiagramGraphicalViewer().setProperty(
			// MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL));
			// }
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "ErrorCreating", null, e.getStatus()); //$NON-NLS-1$
		}

		// EditorUtil.setLockmode(graphicalEditor,false);

	}

	/**
	 * Creates page 1 of the multi-page editor, which allows you to edit the
	 * xml.
	 */
	void createPage1() {

		try {
			sourceEditor = new DataMapperObjectSourceEditor(getTemporaryFile("xml")); //$NON-NLS-1$
			addPage(SOURCE_VIEW_PAGE_INDEX, sourceEditor.getEditor(), sourceEditor.getInput());
			setPageText(SOURCE_VIEW_PAGE_INDEX, "Source"); //$NON-NLS-1$

			sourceEditor.getDocument().addDocumentListener(new IDocumentListener() {

				public void documentAboutToBeChanged(final DocumentEvent event) {
					// nothing to do
				}

				public void documentChanged(final DocumentEvent event) {
					sourceDirty = true;
					// firePropertyChange(PROP_DIRTY);
				}
			});
			Composite composite = new Composite(getContainer(), SWT.NONE);
			FillLayout layout = new FillLayout();
			composite.setLayout(layout);

			// listViewer = new ListViewer(composite);

			// Initialize source editor.
			// updateSourceEditor();
		} catch (Exception ex) {
			// log.error("Error while initializing source viewer control.",ex);
		}

	}

	private IFile getTemporaryFile(String extension) throws Exception {
		String fileName = String.format("%s.%s", UUID.randomUUID().toString(), extension); //$NON-NLS-1$
		IFile tempFile = getTemporaryDirectory().getFile(fileName);
		if (!tempFile.exists()) {
			tempFile.create(new ByteArrayInputStream(new byte[0]), true, null);
		}
		tempFiles.add(tempFile);
		return tempFile;
	}

	private IFolder getTemporaryDirectory() throws Exception {
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput || editorInput instanceof FileStoreEditorInput) {

			IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".tmp"); //$NON-NLS-1$

			if (!tempProject.exists()) {
				tempProject.create(new NullProgressMonitor());
			}

			if (!tempProject.isOpen()) {
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
			throw new Exception("Unable to create temporary resources directory."); //$NON-NLS-1$
		}
	}

	protected void createPages() {
		createPage0();

		createPage1();

		/*
		 * EditorUtils.setLockmode(graphicalEditor, true); IFile file =
		 * ((IFileEditorInput)getEditorInput()).getFile(); ElementDuplicator
		 * endPointDuplicator = new
		 * ElementDuplicator(file.getProject(),getGraphicalEditor());
		 * endPointDuplicator.updateAssociatedDiagrams(this);
		 * EditorUtils.setLockmode(graphicalEditor, false);
		 */

		// createPage2();
	}

	public void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		if (pageIndex == 1) {
			// sourceEditor.update();
			updateSourceEditor();
		}

	}
	
	/*
	 * function generator
	 */

	
	
/*	public static String generateFunction() {
		DataMapperRoot rootDiagram = (DataMapperRoot) graphicalEditor.getDiagram().getElement();
		// String input =
		// rootDiagram.getDataMapperDiagram().getInput().getTreeNode().get(0).getName().split(",")[1];
		// String output =
		// rootDiagram.getDataMapperDiagram().getOutput().getTreeNode().get(0).getName().split(",")[1];

		ArrayList<String> functionsList = new ArrayList<String>();
		functionsList = DataMapperConfigurationGenerator.findForAction(rootDiagram.getInput().getTreeNode());

		String allFunctions = "";

		for (String function : functionsList) {
			allFunctions = allFunctions + "\n" + function;
		}

		
		 * String flagLSInput = "S"; // @param for set List or Single flag in
		 * configuration if(TreeFromAvro.multipleData) flagLSInput = "L";
		 
		// String function =
		// "function map_"+flagLSInput+"_"+input.toLowerCase()+"_"+flagLSInput+"_"+output.toLowerCase()+"( "+"input"
		// +" , "+"output"+" ){ \n "+
		// allActions.toLowerCase()+" \n return output;"+" \n}";
		return allFunctions;
	}*/



	/*
	 * walk through tree structure and return each data field.
	 */
	private String goUpOnOutputTree(TreeNode node) {
		String temp = ""; //$NON-NLS-1$
		if (node.getOutputParent() == null) {
			//temp = goUpOnOutputTree(node.getFieldParent()) + node.getName().split(",")[1] + ".";
			temp = goUpOnOutputTree(node.getFieldParent()) + node.getName() + "."; //$NON-NLS-1$
		} else {
			return "output."; //$NON-NLS-1$
		}
		return temp;
	}

	private String goUpOnInputTree(TreeNode node) {
		String temp = ""; //$NON-NLS-1$

		if (node.getInputParent() == null) {
			//temp = goUpOnInputTree(node.getFieldParent()) + node.getName().split(",")[1] + ".";
			temp = goUpOnInputTree(node.getFieldParent()) + node.getName() + "."; //$NON-NLS-1$
		} else {
			return "input."; //$NON-NLS-1$
		}
		return temp;
	}

	public void updateSourceEditor() {

//		sourceEditor.update(DataMapperConfigurationGenerator.generateFunction());
//		DataMapperConfiguration temp = DataMapperModelTransformer.getInstance().transform((DataMapperRoot) graphicalEditor.getDiagram().getElement());
//		String temp2="";
//		if (temp != null) {
//			for (Function temp3 : temp.getFunctionList()) {
//				temp2 += temp3.toString();
//			}
//		}
//		sourceEditor.update(temp2);
//		sourceDirty = false;
//		firePropertyChange(PROP_DIRTY);
		
		DataMapperRoot rootDiagram = (DataMapperRoot) DataMapperMultiPageEditor.getGraphicalEditor().getDiagram().getElement();
		String source = DataMapperModelTransformer.getInstance().transform(rootDiagram);
		sourceEditor.update(source);
		sourceDirty = false;
		firePropertyChange(PROP_DIRTY);
	}
	
	
	private void updateAssociatedConfigFile(IProgressMonitor monitor) {
		IEditorInput editorInput = getEditor(0).getEditorInput();
		
		if (editorInput instanceof IFileEditorInput) {
			IFile diagramFile = ((FileEditorInput) editorInput).getFile();
			String configFilePath = diagramFile.getFullPath().toString();
			configFilePath = configFilePath
					.replaceAll(".datamapper_diagram$", ".dmc"); //$NON-NLS-1$ //$NON-NLS-2$
			IFile configFile = diagramFile.getWorkspace().getRoot().getFile(new Path(configFilePath));
			InputStream is = null;
			try {
				DataMapperRoot rootDiagram = (DataMapperRoot) DataMapperMultiPageEditor.getGraphicalEditor().getDiagram().getElement();
				String source = DataMapperModelTransformer.getInstance().transform(rootDiagram);
				if (source == null) {
					log.warn("Could get source"); //$NON-NLS-1$
					return;
				}
				is = new ByteArrayInputStream(source.getBytes());
				if (configFile.exists()) {
					configFile.setContents(is, true, true, monitor);
				} else {
					configFile.create(is, true, monitor);
				}

			} catch (Exception e) {
				log.warn("Could not save file " + configFile); //$NON-NLS-1$
			} finally {
				if(is != null) {
					try {
						is.close();
					} catch (IOException e) {
						// ignore.
					}
				}
			}
		}
	}	

	/**
	 * Traverses input and output trees and generates respective avro schema
	 */
	private void updateAvroSchema() {
		// Get model root of the active DataMapperDiagramEditor
		EObject modelRoot = ((DataMapperDiagramEditor) getEditor(0)).getDiagram().getElement();
		DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) modelRoot;

		// Model root of input schema tree
		EList<TreeNode> inputTreeNodesList = ((DataMapperRoot) datamapperRoot).getInput()
				.getTreeNode();
		// If a tree node is found, continue saving
		if (null != inputTreeNodesList && !inputTreeNodesList.isEmpty()) {
			TreeNodeImpl inputTreeNode = (TreeNodeImpl) inputTreeNodesList.get(0);
			// This traverses input tree view and returns the updated avro
			// schema
			AvroSchemaTransformer avroSchemaTransformer = new AvroSchemaTransformer();
			Schema inputAvroSchema = avroSchemaTransformer.transform(inputTreeNode);
			updateSchemaFile(INPUT_SCHEMA_ID, inputAvroSchema);
		}
		// Empty tree node, clear the file
		else {
			updateSchemaFile(INPUT_SCHEMA_ID, null);
		}

		// Model root of output schema tree
		EList<TreeNode> outputTreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput()
				.getTreeNode();
		// If a tree node is found, continue saving
		if (null != outputTreeNodesList && !outputTreeNodesList.isEmpty()) {
			TreeNodeImpl outputTreeNode = (TreeNodeImpl) outputTreeNodesList.get(0);
			// This traverses output tree view and returns the updated avro
			// schema
			AvroSchemaTransformer avroSchemaTransformer = new AvroSchemaTransformer();
			Schema outputAvroSchema = avroSchemaTransformer.transform(outputTreeNode);
			updateSchemaFile(OUTPUT_SCHEMA_ID, outputAvroSchema);
		}
		// Empty tree node, clear the file
		else {
			updateSchemaFile(OUTPUT_SCHEMA_ID, null);
		}

	}

	/**
	 * Writes the avro schema to target file
	 * 
	 * @param schemaType
	 *            either input or output
	 * @param schema
	 *            Avro schema respective to modified tree
	 */
	private void updateSchemaFile(String schemaType, Schema schema) {
		// Schema file location is identified using editor input
		IFile graphicalFile = ((IFileEditorInput) getEditorInput()).getFile();
		String configName = graphicalFile.getName().substring(0,
				graphicalFile.getName().indexOf(EditorUtils.DIAGRAM_FILE_EXTENSION));

		String graphicalFileDirPath = graphicalFile.getParent().getProjectRelativePath().toString();
		if (graphicalFileDirPath != null && !"".equals(graphicalFileDirPath)) { //$NON-NLS-1$
			graphicalFileDirPath += File.separator;
		}

		String newFilePath;
		IFile newSchemaIFile;
		// Schema type can only be either input or output
		if (INPUT_SCHEMA_ID.equals(schemaType)) {
			newFilePath = graphicalFileDirPath + configName + EditorUtils.INPUT_SCHEMA_FILE_SUFFIX
					+ EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
			newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
		} else {
			newFilePath = graphicalFileDirPath + configName + EditorUtils.OUTPUT_SCHEMA_FILE_SUFFIX
					+ EditorUtils.AVRO_SCHEMA_FILE_EXTENSION;
			newSchemaIFile = graphicalFile.getProject().getFile(newFilePath);
		}
		File newSchemaFile = newSchemaIFile.getRawLocation().makeAbsolute().toFile();

		String fileContent = "";
		// Becomes null when tree is cleared. Write empty string
		if (null != schema) {
			try {
				fileContent = schema.toString(true);
			} catch (SchemaParseException e) {
				log.error(ERROR_PARSING_THE_SCHEMA, e);
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
				ErrorDialog.openError(getSite().getShell(), ERROR_PARSING_THE_SCHEMA, null, status);
				return;
			}
		}

		try {
			FileUtils.writeStringToFile(newSchemaFile, fileContent);
		} catch (IOException e) {
			log.error(ERROR_WRITING_SCHEMA_FILE + newSchemaIFile.getName(), e);
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
			ErrorDialog.openError(getSite().getShell(),
					ERROR_WRITING_SCHEMA_FILE + newSchemaIFile.getName(), null, status);
			return;
		}

	}
	
	public void init(IEditorSite site, IEditorInput editorInput)
	           throws PartInitException {    	
		
		        if (!(editorInput instanceof IFileEditorInput))
		            throw new PartInitException("InvalidInput"); //$NON-NLS-1$     
		       
		       super.init(site, editorInput);
		       String name = editorInput.getName();
		       setTitleOfDataMapperDiagramConfiguration(name);
		    }
		
			private void setTitleOfDataMapperDiagramConfiguration(String name) {
				String title = name.replace("datamapper_diagram","dmc"); //$NON-NLS-1$ //$NON-NLS-2$
				setTitle(title);
			}    

	
	public static DataMapperDiagramEditor getGraphicalEditor() {
		return graphicalEditor;
	}

	@Override
	public void gotoMarker(IMarker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		updateAvroSchema();
		updateAssociatedConfigFile(monitor);
		getEditor(0).doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}
}
