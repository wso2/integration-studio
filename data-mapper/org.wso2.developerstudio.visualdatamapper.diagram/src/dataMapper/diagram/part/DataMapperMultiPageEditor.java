package dataMapper.diagram.part;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.MultiPageEditorPart;

import dataMapper.Attribute;
import dataMapper.DataMapperLink;
import dataMapper.DataMapperRoot;
import dataMapper.Element;
import dataMapper.TreeNode;
import dataMapper.diagram.tree.generator.TreeFromAvro;


public class DataMapperMultiPageEditor extends MultiPageEditorPart
		implements
			IGotoMarker {

	private DataMapperDiagramEditor graphicalEditor;

	private DataMapperObjectSourceEditor sourceEditor;

	public static final String TEMPORARY_RESOURCES_DIRECTORY = "org.wso2.developerstudio.visualdatamapper";

	private static final int SOURCE_VIEW_PAGE_INDEX = 1;

	private static final int DESIGN_VIEW_PAGE_INDEX = 0;

	private Set<IFile> tempFiles = new HashSet<IFile>();

	// private static IDeveloperStudeioLog Log
	// =Logger.getLog(Activator.PLUGIN_ID);

	private boolean sourceDirty;

	public DataMapperMultiPageEditor() {
		super();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();

		try {
			workbench
					.showPerspective(
							"org.wso2.developerstudio.visualdatamapper.diagram.custom.perspective",
							window);
		} catch (WorkbenchException e) {
		}

	}

	void createPage0() {
		try {
			graphicalEditor = new DataMapperDiagramEditor(this);
			addPage(DESIGN_VIEW_PAGE_INDEX, graphicalEditor, getEditorInput());
			setPageText(DESIGN_VIEW_PAGE_INDEX, "Design");

			// if(getDiagramGraphicalViewer() != null){
			// getDiagramGraphicalViewer().setProperty(
			// MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL));
			// }
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "ErrorCreating", null,
					e.getStatus());
		}

		// EditorUtil.setLockmode(graphicalEditor,false);

	}

	/**
	 * Creates page 1 of the multi-page editor, which allows you to edit the
	 * xml.
	 */
	void createPage1() {

		try {
			sourceEditor = new DataMapperObjectSourceEditor(
					getTemporaryFile("xml"));
			addPage(SOURCE_VIEW_PAGE_INDEX, sourceEditor.getEditor(),
					sourceEditor.getInput());
			setPageText(SOURCE_VIEW_PAGE_INDEX, "Source");

			sourceEditor.getDocument().addDocumentListener(
					new IDocumentListener() {

						public void documentAboutToBeChanged(
								final DocumentEvent event) {
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
		String fileName = String.format("%s.%s", UUID.randomUUID().toString(),
				extension);
		IFile tempFile = getTemporaryDirectory().getFile(fileName);
		if (!tempFile.exists()) {
			tempFile.create(new ByteArrayInputStream(new byte[0]), true, null);
		}
		tempFiles.add(tempFile);
		return tempFile;
	}

	private IFolder getTemporaryDirectory() throws Exception {
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput
				|| editorInput instanceof FileStoreEditorInput) {

			IProject tempProject = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(".tmp");

			if (!tempProject.exists()) {
				tempProject.create(new NullProgressMonitor());
			}

			if (!tempProject.isOpen()) {
				tempProject.open(new NullProgressMonitor());
			}

			if (!tempProject.isHidden()) {
				tempProject.setHidden(true);
			}

			IFolder folder = tempProject
					.getFolder(TEMPORARY_RESOURCES_DIRECTORY);

			if (!folder.exists()) {
				folder.create(true, true, new NullProgressMonitor());
			}

			return folder;
		} else {
			throw new Exception(
					"Unable to create temporary resources directory.");
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

	private String generateFunction() {
		DataMapperRoot rootDiagram = (DataMapperRoot) graphicalEditor
				.getDiagram().getElement();
		// String input =
		// rootDiagram.getDataMapperDiagram().getInput().getTreeNode().get(0).getName().split(",")[1];
		// String output =
		// rootDiagram.getDataMapperDiagram().getOutput().getTreeNode().get(0).getName().split(",")[1];

		ArrayList<String> functionsList = new ArrayList<String>();
		functionsList = findForAction(rootDiagram.getDataMapperDiagram()
				.getInput().getTreeNode());

		String allFunctions = "";

		for (String function : functionsList) {
			allFunctions = allFunctions + "\n" + function;
		}

		/*
		 * String flagLSInput = "S"; // @param for set List or Single flag in
		 * configuration if(TreeFromAvro.multipleData) flagLSInput = "L";
		 */
		// String function =
		// "function map_"+flagLSInput+"_"+input.toLowerCase()+"_"+flagLSInput+"_"+output.toLowerCase()+"( "+"input"
		// +" , "+"output"+" ){ \n "+
		// allActions.toLowerCase()+" \n return output;"+" \n}";
		return allFunctions;
	}

	/*
	 * 
	 * generated NOT go through each tree ,element, attribute of InPut and find
	 * for link if link exist, find connected Output element, attribute for it
	 * get the tree list of OutPut element hirachy
	 */
	// FIXME if link connected to operator, aware of that and build relavent
	// configuration script
	public ArrayList<String> findForAction(EList<TreeNode> eList) {

		Iterator<TreeNode> treeNodeIterator = eList.iterator();
		ArrayList<String> functionListForTree = new ArrayList<String>();
		ArrayList<String> actionList = new ArrayList<String>();
		while (treeNodeIterator.hasNext()) {
			// for tree
			TreeNode eListObject = treeNodeIterator.next();
			ArrayList<String> tempList = findForAction(eListObject.getNode());
			functionListForTree.addAll(tempList);
			// actionList.addAll(tempList);

			/*
			 * get A/E , gets its outnode., check for links connected to tht
			 * node, if connected gets links Innode, get Innode connected A/E,
			 * gets A/E parent tree, get hierachical tree of tht until get
			 * Output.
			 */

			// for atribute
			Iterator<Attribute> attributeIterator = eListObject.getAttribute()
					.iterator();
			while (attributeIterator.hasNext()) {
				Attribute attributeIteratorObject = attributeIterator.next();
				EList<DataMapperLink> attributeLinkList = attributeIteratorObject
						.getOutNode().getOutgoingLink();

				Iterator<DataMapperLink> mapperLinkIterator = attributeLinkList
						.iterator();
				while (mapperLinkIterator.hasNext()) {
					DataMapperLink mapperLinkObject = mapperLinkIterator.next();
					if (mapperLinkObject.getInNode() != null) {

						// atribute -----> element
						if (mapperLinkObject.getInNode().getElementParent() != null) {
							Element outputElement = mapperLinkObject
									.getInNode().getElementParent();

							// tree.attribute --------> tree.element
							String action = createActionScript(outputElement
									.getName().split(",")[1],
									attributeIteratorObject.getName()
											.split(",")[1]);
							// goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+"="+
							// goUpOnInputTree(eListObject)+attributeIteratorObject.getName().split(",")[1];
							actionList.add(action);

						}
						// atribute -----> attribute
						else if (mapperLinkObject.getInNode()
								.getAttributeParent() != null) {
							Attribute outputAttribute = mapperLinkObject
									.getInNode().getAttributeParent();

							// tree.attribute --------> tree.attribute
							String action = createActionScript(outputAttribute
									.getName().split(",")[1],
									attributeIteratorObject.getName()
											.split(",")[1]);
							// goUpOnOutputTree(outputAttribute.getFieldParent())+outputAttribute.getName().split(",")[1]+"="+
							// goUpOnInputTree(eListObject)+attributeIteratorObject.getName().split(",")[1];
							actionList.add(action);
						}

					}
				}// end itrt links atribute
			}// end iterat attribut

			// for element

			// boolean firstScriptLine = true;

			Iterator<Element> elementIterator = eListObject.getElement()
					.iterator();
			while (elementIterator.hasNext()) {
				Element elementIteratorObject = elementIterator.next();
				EList<DataMapperLink> elementLinkList = elementIteratorObject
						.getOutNode().getOutgoingLink();
				Iterator<DataMapperLink> mapperLinkIterator = elementLinkList
						.iterator();

				while (mapperLinkIterator.hasNext()) {
					DataMapperLink mapperLinkObject = mapperLinkIterator.next();
					if (mapperLinkObject.getInNode() != null) {

						// element -----> element
						if (mapperLinkObject.getInNode().getElementParent() != null) {
							Element outputElement = mapperLinkObject
									.getInNode().getElementParent();

							// tree.element --------> tree.element

							String action = outputElement.getFieldParent()
									.getName().split(",")[1]
									+ ","
									+ createActionScript(outputElement
											.getName().split(",")[1],
											elementIteratorObject.getName()
													.split(",")[1]);
							// goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+" = "+
							// goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1];
							actionList.add(action);

						}

						// element -----> attribute
						else if (mapperLinkObject.getInNode()
								.getAttributeParent() != null) {
							Attribute outputAttribute = mapperLinkObject
									.getInNode().getAttributeParent();

							// tree.element --------> tree.attribute
							String action = createActionScript(
									outputAttribute.getName().split(",")[1],
									elementIteratorObject.getName().split(",")[1]);

							// goUpOnOutputTree(outputAttribute.getFieldParent())+outputAttribute.getName().split(",")[1]+" = "+
							// goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1];
							actionList.add(action);

						}
					}// end if linkobject element
				}// end itrt links element
			}// end itrt element

			// create function String

			functionListForTree.addAll(createFunctionScript(eListObject
					.getName().split(",")[1], actionList));
		}// tree
		return functionListForTree;
	}// findForAction

	private String createActionScript(String output, String input) {
		return "output." + output + " = " + "input." + input;
	}

	private ArrayList<String> createFunctionScript(String input,
			ArrayList<String> actionList) {
		ArrayList<String> functionList = new ArrayList<String>();
		ArrayList<String> dummyActionList = new ArrayList<String>();
		dummyActionList.addAll(actionList);
		for (String action : actionList) {
			String output = action.split(",")[0];
			ArrayList<String> tempActionList = new ArrayList<String>();

			/*
			 * for (String otherAction : dummyActionList){
			 * if(output.equalsIgnoreCase(otherAction.split(",")[0])){
			 * tempActionList.add(otherAction.split(",")[1]);
			 * dummyActionList.remove(otherAction); }
			 */
			Iterator<String> it = dummyActionList.iterator();
			while (it.hasNext()) {
				String otherAction = it.next();
				if (output.equalsIgnoreCase(otherAction.split(",")[0])) {
					tempActionList.add(otherAction.split(",")[1]);
					it.remove();
				}
			}

			if (!tempActionList.isEmpty()) {
				String allActions = "";
				for (String temp : tempActionList) {
					allActions = allActions + "\n" + temp + ";";
				}
				// FIXME function LS flag is inaccurate
				String flagLSInput = "S"; // @param for set List or Single flag
											// in configuration
				if (TreeFromAvro.multipleData)
					flagLSInput = "L";
				String function = "function map_" + flagLSInput + "_"
						+ input.toLowerCase() + "_" + flagLSInput + "_"
						+ output.toLowerCase() + "( " + "input" + " , "
						+ "output" + " ){ " + allActions.toLowerCase()
						+ " \n return output;" + " \n}";
				functionList.add(function);
			}

		}
		/*
		 * String flagLSInput = "S"; // @param for set List or Single flag in
		 * configuration if(TreeFromAvro.multipleData) flagLSInput = "L";
		 * 
		 * String function =
		 * "function map_"+flagLSInput+"_"+input.toLowerCase()+
		 * "_"+flagLSInput+"_"+output.toLowerCase()+"( "+"input"
		 * +" , "+"output"+" ){ \n "+
		 * allActions.toLowerCase()+" \n return output;"+" \n}"; return
		 * function;
		 */
		return functionList;
	}

	/*
	 * walk through tree structure and return each data field.
	 */
	private String goUpOnOutputTree(TreeNode node) {
		String temp = "";
		if (node.getOutputParent() == null) {
			temp = goUpOnOutputTree(node.getFieldParent())
					+ node.getName().split(",")[1] + ".";
		} else {
			return "output.";
		}
		return temp;
	}

	private String goUpOnInputTree(TreeNode node) {
		String temp = "";

		if (node.getInputParent() == null) {
			temp = goUpOnInputTree(node.getFieldParent())
					+ node.getName().split(",")[1] + ".";
		} else {
			return "input.";
		}
		return temp;
	}

	// generated not
	private void updateSourceEditor() {

		sourceEditor.update(generateFunction());
		sourceDirty = false;
		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public void gotoMarker(IMarker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

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
