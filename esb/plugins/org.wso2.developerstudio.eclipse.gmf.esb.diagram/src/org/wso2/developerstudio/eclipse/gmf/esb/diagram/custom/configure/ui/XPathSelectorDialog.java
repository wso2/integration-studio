/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wst.xml.xpath.core.util.XSLTXPathHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;
import org.apache.commons.lang.StringUtils;

/**
 * A dialog used to select an xpath from a given xml document.
 */
public class XPathSelectorDialog extends Dialog {
	/**
	 * Attribute icon path.
	 */
	private static final String ATTRIBUTE_ICON_PATH = "icons/xpath/xmlAttribute.png";

	/**
	 * Element icon path.
	 */
	private static final String ELEMENT_ICON_PATH = "icons/xpath/xmlElement.png";

	/**
	 * Key used to store dom nodes as data within tree items.
	 */
	private static final String TREE_ITEM_DATA_KEY = "dom_user_data_key";

	/**
	 * Dialog shell.
	 */
	private Shell dialogShell;

	/**
	 * Label providing an informative message.
	 */
	private Label infoLabel;

	/**
	 * Selected file path text filed.
	 */
	private Text filePathTextField;

	/**
	 * Browse button.
	 */
	private Button browseButton;

	/**
	 * Tree viewer.
	 */
	private Tree treeViewWidget;

	/**
	 * Xpath label.
	 */
	private Label xpathLabel;

	/**
	 * XPath expression text field.
	 */
	private Text xpathTextField;

	/**
	 * Cancel button.
	 */
	private Button cancelButton;

	/**
	 * Ok button.
	 */
	private Button okButton;

	/**
	 * Selected xpath.
	 */
	private String selectedXpath;
	
	/**
	 * XML namespaces.
	 */
	private Map<String,String> nameSpaces;

	/**
	 * A utility class used to track {@link TreeItem} state as well as store
	 * user data in it.
	 */
	private class TreeItemData {
		/**
		 * Whether the associated {@link TreeItem} has already been explored
		 * once.
		 */
		private boolean markAsExplored;

		/**
		 * Dom {@link Node} attached to the {@link TreeItem}.
		 */
		private Node domNode;

		/**
		 * Instantiates a new {@link TreeItemData} instance which is in
		 * 'unexplored' state.
		 * 
		 * @param domNode
		 *            associated dom {@link Node}.
		 */
		public TreeItemData(Node domNode) {
			this.domNode = domNode;
		}

		/**
		 * @return whether the corresponding {@link TreeItem} has already been
		 *         explored.
		 */
		public boolean isMarkedAsExplored() {
			return markAsExplored;
		}

		/**
		 * marks the corresponding {@link TreeItem} as explored.
		 */
		public void setMarkedAsExplored() {
			this.markAsExplored = true;
		}

		/**
		 * @return associated dom {@link Node} instance.
		 */
		public Node getDomNode() {
			return domNode;
		}
	}

	/**
	 * Creates a new {@link XPathSelectorDialog} instance.
	 * 
	 * @param parent
	 *            parent shell.
	 */
	public XPathSelectorDialog(Shell parent) {
		super(parent);
		this.dialogShell = new Shell(parent, SWT.DIALOG_TRIM
				| SWT.APPLICATION_MODAL);//new Shell(parent);
	}

	/**
	 * A main method for testing the dialog ui.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String[] args) {
		XPathSelectorDialog dialog = new XPathSelectorDialog(new Shell(
				Display.getDefault()));
		dialog.open();
	}

	/**
	 * Layout ui elements and open dialog window.
	 */
	public void open() {
		// Dialog shell.
		dialogShell.setText("XPath Navigator");
		{
			FormLayout dialogShellLayout = new FormLayout();
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.marginWidth = 5;
			dialogShell.setLayout(dialogShellLayout);
			
		}

		// Ok button.
		okButton = new Button(dialogShell, SWT.NONE);
		{
			okButton.setText("OK");
			FormData okButtonLayoutData = new FormData();
			okButtonLayoutData.right = new FormAttachment(100);
			okButtonLayoutData.bottom = new FormAttachment(100);
			okButtonLayoutData.width = 80;
			okButton.setLayoutData(okButtonLayoutData);
		}

		// Cancel button.
		cancelButton = new Button(dialogShell, SWT.NONE);
		{
			cancelButton.setText("Cancel");
			cancelButton.setToolTipText("click here to exit");
			FormData cancelButtonLayoutData = new FormData();
			cancelButtonLayoutData.top = new FormAttachment(okButton, 0,
					SWT.CENTER);
			cancelButtonLayoutData.right = new FormAttachment(okButton, -5);
			cancelButtonLayoutData.width = 80;
			cancelButton.setLayoutData(cancelButtonLayoutData);
		}

		// XPath label.
		xpathLabel = new Label(dialogShell, SWT.NONE);
		{
			xpathLabel.setText("XPath:");
			FormData xpathLabelLayoutData = new FormData();
			xpathLabelLayoutData.top = new FormAttachment(okButton, 0,
					SWT.CENTER);
			xpathLabelLayoutData.left = new FormAttachment(0);
			xpathLabel.setLayoutData(xpathLabelLayoutData);
		}

		// XPath text field.
		xpathTextField = new Text(dialogShell, SWT.BORDER);
		{
			xpathTextField.setEditable(false);
			FormData xPathTextLayoutData = new FormData();
			xPathTextLayoutData.top = new FormAttachment(okButton, 0,
					SWT.CENTER);
			xPathTextLayoutData.left = new FormAttachment(xpathLabel, 5);
			xPathTextLayoutData.right = new FormAttachment(cancelButton, -5);
			xpathTextField.setLayoutData(xPathTextLayoutData);
		}

		// Browse button.
		browseButton = new Button(dialogShell, SWT.NONE);
		{
			browseButton.setText("Browse");
			FormData browseButtonLayoutData = new FormData();
			browseButtonLayoutData.top = new FormAttachment(0);
			browseButtonLayoutData.right = new FormAttachment(100);
			browseButtonLayoutData.width = 80;
			browseButton.setLayoutData(browseButtonLayoutData);
		}

		// Information label.
		infoLabel = new Label(dialogShell, SWT.NONE);
		{
			infoLabel.setText("XML document:");
			FormData infoLabelLayoutData = new FormData();
			infoLabelLayoutData.top = new FormAttachment(browseButton, 0,
					SWT.CENTER);
			infoLabelLayoutData.left = new FormAttachment(0);
			infoLabel.setLayoutData(infoLabelLayoutData);
		}

		// File path text field.
		filePathTextField = new Text(dialogShell, SWT.BORDER);
		{
			filePathTextField.setEnabled(false);
			FormData filePathTextFieldLayoutData = new FormData();
			filePathTextFieldLayoutData.top = new FormAttachment(browseButton,
					0, SWT.CENTER);
			filePathTextFieldLayoutData.left = new FormAttachment(infoLabel, 5);
			filePathTextFieldLayoutData.right = new FormAttachment(
					browseButton, -5);
			filePathTextField.setLayoutData(filePathTextFieldLayoutData);
		}

		// Tree view.
		treeViewWidget = new Tree(dialogShell, SWT.BORDER);
		{
			FormData treeViewLayoutData = new FormData();
			treeViewLayoutData.top = new FormAttachment(filePathTextField, 5);
			treeViewLayoutData.left = new FormAttachment(0);
			treeViewLayoutData.right = new FormAttachment(100);
			treeViewLayoutData.bottom = new FormAttachment(okButton, -5);
			treeViewLayoutData.width = 500;
			treeViewLayoutData.height = 400;
			treeViewWidget.setLayoutData(treeViewLayoutData);
		}

		initializeActions();
		setTabOrder();

		dialogShell.pack();
		dialogShell.open();
		centerDialog();
		Display display = getParent().getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
	}

	/**
	 * Initialize action listeners.
	 */
	private void initializeActions() {
		treeViewWidget.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TreeItemData treeItemData = (TreeItemData) event.item
						.getData(TREE_ITEM_DATA_KEY);
				xpathTextField.setText(XSLTXPathHelper
						.calculateXPathToNode(treeItemData.getDomNode()));
			}
		});

		treeViewWidget.addListener(SWT.Expand, new Listener() {
			public void handleEvent(Event event) {
				TreeItem currentItem = (TreeItem) event.item;
				TreeItemData treeItemData = (TreeItemData) currentItem
						.getData(TREE_ITEM_DATA_KEY);

				// Explore if not already explored.
				if (!treeItemData.isMarkedAsExplored()) {
					// Make sure to remove the dummy child item.
					currentItem.removeAll();

					Node node = treeItemData.getDomNode();

					// Attributes.
					if (node.hasAttributes()) {
						NamedNodeMap attributesMap = node.getAttributes();
						for (int i = 0; i < attributesMap.getLength(); i++) {
							Node childNode = attributesMap.item(i);
							addTreeItem(currentItem, childNode);
						}
					}

					// Children.
					if (node.hasChildNodes()) {
						NodeList childNodes = node.getChildNodes();
						for (int i = 0; i < childNodes.getLength(); i++) {
							Node childNode = childNodes.item(i);
							if (childNode.getNodeType() == Node.ELEMENT_NODE) {
								addTreeItem(currentItem, childNode);
							}
						}
					}

					// Done exploring.
					treeItemData.setMarkedAsExplored();
				}
			}
		});

		treeViewWidget.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
				TreeItem[] selection = treeViewWidget.getSelection();
				if (selection.length > 0) {
					Node selectedNode = ((TreeItemData) selection[0]
							.getData(TREE_ITEM_DATA_KEY)).getDomNode();
					setSelectedXpath(XSLTXPathHelper
							.calculateXPathToNode(selectedNode));
					dialogShell.dispose();
				}
			}
		});

		okButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				setSelectedXpath(xpathTextField.getText());
				dialogShell.dispose();
			}
		});

		cancelButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event arg0) {
				dialogShell.dispose();
			}
		});

		browseButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				// Configure file dialog.
				FileDialog fileBrowserDialog = new FileDialog(dialogShell,
						SWT.OPEN);
				fileBrowserDialog.setText("Select XML Document");
				fileBrowserDialog.setFilterExtensions(new String[] { "*.xml" });

				// Let the user browse for the input xml file.
				final String filePath = fileBrowserDialog.open();

				// If the user selected a file.
				if (!StringUtils.isBlank(filePath)) {
					// Clear tree view.
					treeViewWidget.removeAll();

					// Update the selected path
					filePathTextField.setText(filePath);

					final File selectedFile = new File(filePath);
					if (selectedFile.exists() && selectedFile.canRead()) {
						// Create a new runnable that can be executed with a
						// progress bar.
						IRunnableWithProgress runnable = new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								// We have no clue how long this would take.
								monitor.beginTask("Parsing xml document...",
										IProgressMonitor.UNKNOWN);

								// Parse the xml document into a dom object.
								try {
									Document document = parseDocument(selectedFile);
									final Node rootNode = document
											.getDocumentElement();

									// Adding a tree item is a ui related
									// operation which must be executed on the
									// ui thread. Since we are currently
									// executing inside a background thread, we
									// need to explicitly invoke the ui thread.
									new UIJob("add-root-tree-item-job") {
										public IStatus runInUIThread(
												IProgressMonitor monitor) {
											addTreeItem(null, rootNode);
											addNameSpaces(rootNode);
											return Status.OK_STATUS;
										}
									}.schedule();

									// Done.
									monitor.done();
								} catch (Exception ex) {
									// Stop progress.
									monitor.done();

									// Report error.
									throw new InvocationTargetException(ex);
								}
							}
						};

						// Run the operation within a progress monitor dialog,
						// make sure to fork-off from the ui thread so that we
						// don't cause the ui to hang.
						try {
							new ProgressMonitorDialog(dialogShell).run(true,
									false, runnable);
						} catch (Exception ex) {
							MessageDialog.openError(dialogShell, "Parse Error",
									"Error while parsing specified xml file.");
						}
					} else {
						MessageDialog.openError(dialogShell, "I/O Error",
								"Unable to read specified input file.");
					}
				}
			}
		});
	}

	/**
	 * Utility method for adding a child {@link TreeItem} into the specified
	 * parent {@link TreeItem}.
	 * 
	 * @param parent
	 *            parent {@link TreeItem} or null if this is root.
	 * @param node
	 *            dom {@link Node} to be associated with this {@link TreeItem}.
	 */
	private void addTreeItem(TreeItem parent, Node node) {
		TreeItem childTreeItem;
		if (null == parent) {
			childTreeItem = new TreeItem(treeViewWidget, SWT.NONE);
		} else {
			childTreeItem = new TreeItem(parent, SWT.NONE);
		}
		childTreeItem.setText(node.getNodeName());

		// Select the icon based on the node type.
		ImageDescriptor icon;
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			icon = EsbDiagramEditorPlugin
					.getBundledImageDescriptor(ELEMENT_ICON_PATH);
		} else {

			icon = EsbDiagramEditorPlugin
					.getBundledImageDescriptor(ATTRIBUTE_ICON_PATH);
		}

		childTreeItem.setImage(icon.createImage());

		// Associated dom node with the newly created tree item.
		childTreeItem.setData(TREE_ITEM_DATA_KEY, new TreeItemData(node));

		// Here we determine if a dummy grand-child should be added into the
		// newly created child item. The grand-child is needed so that the
		// expand handle (little triangle besides the tree item) appears and the
		// user is able to expand the node (upon which event we explore the rest
		// of the tree dynamically).
		boolean hasChildren = (node.getNodeType() == Node.ELEMENT_NODE) ? node
				.hasChildNodes() : false;
		if (hasChildren) {
			TreeItem grandChild = new TreeItem(childTreeItem, SWT.NONE);
			grandChild.setText("Working...");
		}
	}

	private void centerDialog() {
		Monitor primary = dialogShell.getDisplay().getPrimaryMonitor ();
		Rectangle bounds = primary.getBounds ();
		Rectangle rect = dialogShell.getBounds ();
		int x = (bounds.width - rect.width) / 2;
		int y = (bounds.height - rect.height) / 2;
		dialogShell.setLocation(new Point(x,y));
	}

	private void setTabOrder() {
		Control[] tabOrder = new Control[] { browseButton, okButton,
				cancelButton };
		dialogShell.setTabList(tabOrder);
	}

	private void setSelectedXpath(String selectedXpath) {
		this.selectedXpath = selectedXpath;
	}
	
	/**
	 * Adding NameSpaces
	 * @param node
	 */
	private void addNameSpaces(Node node){
		nameSpaces = new HashMap<String, String>();
		NamedNodeMap nsList = node.getAttributes();
		if (nsList.getLength() > 0) {
			for (int i = 0; i < nsList.getLength(); i++) {
				Node item = nsList.item(i);
				if (null != item.getNodeName() && item.getNodeName().startsWith("xmlns:")) {
					nameSpaces.put(item.getNodeName().replaceAll("^xmlns:", ""), item.getNodeValue());
				}
			}
		}
	}

	/**
	 * @return selected xpath.
	 */
	public String getSelectedXpath() {
		return selectedXpath;
	}

	/**
	 * Utility method for constructing a {@link Document} from an XML file.
	 * 
	 * @param file
	 *            {@link File} containing the XML string.
	 * @return a {@link Document} instance representing the XML structure.
	 * @throws Exception
	 *             if an error is encountered while reading the file or parsing
	 *             its content.
	 */
	public static Document parseDocument(File file) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(file);
	}
	
	public Map<String,String> getNameSpaces(){
		return nameSpaces;
	}
}
