/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wst.xml.xpath.core.util.XSLTXPathHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.ImageHolder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.XpathValidator;
import org.wso2.developerstudio.eclipse.gmf.esb.util.XPathValidator;
import org.wso2.developerstudio.eclipse.gmf.esb.util.XPathValidatorImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.FocusEvent;

/**
 * A SWT based editor dialog to be used for editing namespaced properties.
 */
public class NamespacedPropertyEditorDialog extends Dialog {

    /**
     * Dialog shell.
     */
    private Shell dialogShell;

    /**
     * Group box for separating property value edit area.
     */
    private Group treeViewGroupBox;

    /**
     * Group box for separating namespaces edit area.
     */
    private Group namespacesGroupBox;

    /**
     * Namespace 'Prefix' label.
     */
    private Label nsPrefixLabel;

    /**
     * Namespace prefix text field.
     */
    private Text nsPrefixTextField;

    /**
     * Namespace 'URI' label.
     */
    private Label nsUriLabel;

    /**
     * Namespace URI text field.
     */
    private Text nsUriTextField;

    /**
     * Namespace list box.
     */
    private List nsListBox;

    /**
     * Add namespace button.
     */
    private Button addButton;

    /**
     * Edit namespace button.
     */
    private Button editButton;

    /**
     * Remove namespace button.
     */
    private Button removeButton;

    /**
     * Cancel button.
     */
    private Button cancelButton;

    /**
     * Ok button.
     */
    private Button okButton;

    /**
     * {@link NamespacedProperty} being edited.
     */
    private NamespacedProperty nsProperty;

    /**
     * Namespaces collected.
     */
    private Map<String, String> collectedNamespaces;

    /**
     * Format string used for displaying namespaces.
     */
    private static final String namespaceDisplayFormat = "xmlns:%s=\"%s\"";

    /**
     * Regex pattern used to identify a namespace string.
     */
    private static final Pattern namespaceDisplayPattern = Pattern.compile("xmlns:([^=]++)=.*+");

    /**
     * Status indicating whether this dialog was saved or cancelled.
     */
    private boolean saved;

    /**
     * The main tab view.
     */
    private TabFolder mainTabFolder;

    /**
     * Tab item for XML content.
     */
    private TabItem xmlContentTabItem;
    
    /**
     * Group box for XML content tab elements.
     */
    private Group xmlContentTabGroupBox;

    /**
     * Tab item for namespaces.
     */
    private TabItem namespacesTabItem;
    
    /**
     * Label providing an informative message.
     */
    private Label xmlDocumentLabel;
    
    /**
     * Browse button.
     */
    private Button browseButton;
    
    /**
     * Selected file path text filed.
     */
    private Text filePathTextField;
    
    /**
     * Tree viewer.
     */
    private Tree treeViewWidget;
    
    /**
     * XML namespaces.
     */
    private Map<String, String> nameSpaces;
    
    /**
     * Selected xpath.
     */
    private String selectedXpath;
    
    /**
     * Content of the XML file loaded.
     */
    private String xmlFileContentStr;
    
    /**
     * Inline XML input type radio button.
     */
    private Button inlineRadioButton;
    
    /**
     * File input type radio button.
     */
    private Button browseFileRadioButton;
    
    /**
     * Group box for XML content.
     */
    private Group xmlContentGroupBox;
    
    /**
     * Text area for inline XML content.
     */
    private StyledText inlineXMLTextArea;
    
    /**
     * Group box for file browse components.
     */
    private Group browseFileGroupBox;
    
    /**
     * Tab view for XML content.
     */
    private TabFolder xmlContentTabFolder;
    
    /**
     * Tab item for XML source.
     */
    private TabItem xmlSourceTabItem;
    
    /**
     * Tab item for XML visual tree view.
     */
    private TabItem xmlVisualTabItem;
    
    /**
     * Label for XPath input box.
     */
    private Label xPathLabel;
    
    /**
     * Text input box for XPath expressions.
     */
    private Text xPathTextField;
    
    /**
     * Evaluate XPath expression button.
     */
    private Button evaluateXPathButton;
    
    /**
     * Text area for evaluated XPath output.
     */
    private StyledText outputXMLTextArea;
    
    /**
     * Currently chosen XML file from the browse dialog box.
     */
    private File currentFile;
    
    /**
     * Group box for 'Input Type' radio button group.
     */
    private Group inputTypeRadioGroup;
    
    /**
     * XML content information label.
     */
    private Label infoLabel;
    
    /**
     * Inline XML content.
     */
    private String inlineXMLContent;
    
    /**
     * A boolean to keep track of changes in inline XML content.
     */
    private boolean isInlineXMLContentChanged;
    
    /**
     * A boolean to keep track of inline XML content validity.
     */
    private boolean isCurrentXMLContentValid = true;
    
    /**
     * XPath validator object.
     */
    private XPathValidator xPathValidator;
    
    private static final String EMPTY_STRING = "";
    private static final String SOURCE_VIEW_INFO_LABEL_TEXT = "Switch to 'Visual' tab to see a graphical "
            + "view of the XML content";
    private static final String TREE_VIEW_INFO_LABEL_TEXT = "Select an element to get the XPath expression";
    private static final String INVALID_XML_SYNTAX_LABEL_TEXT = "Invalid XML syntax";
    private static final String EDITOR_TITLE = "XPath Property Editor";
    private static final String XML_CONTENT_PLACEHOLDER_TEXT = "Paste your XML content here...";
    private static final String VISUAL_TAB_ITEM_TEXT = "Visual";
    private static final String SOURCE_TAB_ITEM_TEXT = "Source";
    private static final String NAMESPACES_TAB_ITEM_TEXT = "Namespaces";
    private static final String XML_CONTENT_TAB_ITEM_TEXT = "XML Content";
    private static final String FILE_RADIO_BUTTON_TEXT = "Load XML file from disk";
    private static final String INLINE_RADIO_BUTTON_TEXT = "Enter XML";
    private static final String IN_PROGRESS_LABEL_TEXT = "Working...";
    private static final String CANCEL_BUTTON_TEXT = "Cancel";
    private static final String OK_BUTTON_TEXT = "OK";
    private static final String OUTPUT_LABEL_TEXT = "Output:";
    private static final String EVALUATE_LABEL_TEXT = "Evaluate";
    private static final String XPATH_LABEL_TEXT = "XPath";
    private static final String REMOVE_BUTTON_TEXT = "Remove";
    private static final String EDIT_BUTTON_TEXT = "Edit";
    private static final String ADD_BUTTON_TEXT = "Add";
    private static final String URI_LABEL_TEXT = "URI:";
    private static final String INFO_LABEL_DEFAULT_TEXT = "Enter or load XML file from disk";
    private static final String INVALID_XPATH_EXPRESSION_TEXT = "Invalid XPath expression";

    private static final String UI_JOB_ID = "add-root-tree-item-job";
    private static final String XML_EXTENSION_TYPE = "*.xml";
    private static final String TREE_ITEM_DATA_KEY = "dom_user_data_key";
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    /**
     * A utility class used to track TreeItem state as well as store
     * user data in it.
     */
    private class TreeItemData {
        /**
         * Whether the associated TreeItem has already been explored
         * once.
         */
        private boolean markAsExplored;

        /**
         * Dom Node attached to the TreeItem.
         */
        private Node domNode;

        /**
         * Instantiates a new TreeItemData instance which is in
         * 'unexplored' state.
         * 
         * @param domNode
         *            associated dom Node.
         */
        public TreeItemData(Node domNode) {
            this.domNode = domNode;
        }

        /**
         * @return whether the corresponding TreeItem has already been
         *         explored.
         */
        public boolean isMarkedAsExplored() {
            return markAsExplored;
        }

        /**
         * marks the corresponding TreeItem as explored.
         */
        public void setMarkedAsExplored() {
            this.markAsExplored = true;
        }

        /**
         * @return associated dom Node instance.
         */
        public Node getDomNode() {
            return domNode;
        }
    }

    /**
     * Constructs a new dialog.
     * 
     * @param parent parent shell.
     * @param style style.
     * @param property namespaced property to be manipulated.
     */
    public NamespacedPropertyEditorDialog(Shell parent, int style, NamespacedProperty property) {
        super(parent, style);
        this.nsProperty = property;
        this.collectedNamespaces = new HashMap<String, String>();
        xPathValidator = XPathValidatorImpl.getInstance();
    }

    /**
     * Main function used for testing purposes.
     * 
     * @param args arguments.
     */
    public static void main(String[] args) {
        Shell shell = Display.getDefault().getActiveShell();
        NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(shell, SWT.NULL,
                EsbFactory.eINSTANCE.createNamespacedProperty());
        dialog.open();
    }

    /**
     * Creates ui components and opens the dialog.
     */
    public void open() {
        Shell parentShell = getParent();
        dialogShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

        // Configure dialog shell internal layout.
        FormLayout dialogShellLayout = new FormLayout();
        dialogShellLayout.marginHeight = 5;
        dialogShellLayout.marginWidth = 5;
        dialogShell.setLayout(dialogShellLayout);
        
        // XML input type radio button group
        inputTypeRadioGroup = new Group(dialogShell, SWT.NONE);
        {   
            RowLayout inputTypeRadioGroupRowLayout = new RowLayout(SWT.HORIZONTAL);
            inputTypeRadioGroupRowLayout.wrap = true;
            inputTypeRadioGroupRowLayout.marginRight = 0;
            inputTypeRadioGroupRowLayout.spacing = 30;
            inputTypeRadioGroup.setLayout(inputTypeRadioGroupRowLayout);
            
            FormData inputTypeRadioGroupLayout = new FormData();
            inputTypeRadioGroupLayout.top = new FormAttachment(0);
            inputTypeRadioGroupLayout.left = new FormAttachment(1);
            inputTypeRadioGroupLayout.right = new FormAttachment(99);
            inputTypeRadioGroup.setLayoutData(inputTypeRadioGroupLayout);
            
            inlineRadioButton = new Button(inputTypeRadioGroup, SWT.RADIO);
            inlineRadioButton.setText(INLINE_RADIO_BUTTON_TEXT);
            inlineRadioButton.setSelection(true);
            
            browseFileRadioButton = new Button(inputTypeRadioGroup, SWT.RADIO);
            browseFileRadioButton.setText(FILE_RADIO_BUTTON_TEXT);
        }
        
        browseFileGroupBox = new Group(dialogShell, SWT.NONE);
        {   
            FormData browseFileGroupBoxLayoutData = new FormData();
            browseFileGroupBoxLayoutData.top = new FormAttachment(inputTypeRadioGroup, 0);
            browseFileGroupBoxLayoutData.left = new FormAttachment(1);
            browseFileGroupBoxLayoutData.right = new FormAttachment(99);
            browseFileGroupBox.setLayoutData(browseFileGroupBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout browseFileGroupBoxLayout = new FormLayout();
            browseFileGroupBoxLayout.marginWidth = 5;
            browseFileGroupBoxLayout.marginHeight = 5;
            browseFileGroupBox.setLayout(browseFileGroupBoxLayout);
            
            // File path text field.
            filePathTextField = new Text(browseFileGroupBox, SWT.BORDER);
            {
                filePathTextField.setEnabled(false);
                FormData filePathTextFieldLayoutData = new FormData();
                filePathTextFieldLayoutData.top = new FormAttachment(browseFileGroupBox, 5);
                filePathTextFieldLayoutData.left = new FormAttachment(0);
                filePathTextFieldLayoutData.right = new FormAttachment(80);
                filePathTextField.setLayoutData(filePathTextFieldLayoutData);
                filePathTextField.setEnabled(false);
            }
            
            // Browse button.
            browseButton = new Button(browseFileGroupBox, SWT.BORDER);
            {
                browseButton.setText("Browse");
                FormData browseButtonLayoutData = new FormData();
                browseButtonLayoutData.top = new FormAttachment(browseFileGroupBox, 1);
                browseButtonLayoutData.left = new FormAttachment(filePathTextField, 5);
                browseButtonLayoutData.right = new FormAttachment(100);
                browseButtonLayoutData.width = 80;
                browseButton.setLayoutData(browseButtonLayoutData);
                browseButton.setEnabled(false);
            }
        }
        
        // Initialising main tab layout
        mainTabFolder = new TabFolder(dialogShell, SWT.NONE);
        FormData tabFolderLayoutData = new FormData();
        tabFolderLayoutData.top = new FormAttachment(browseFileGroupBox, 0);
        tabFolderLayoutData.left = new FormAttachment(0);
        tabFolderLayoutData.right = new FormAttachment(100);
        tabFolderLayoutData.height = 370;
        mainTabFolder.setLayoutData(tabFolderLayoutData);
        
        // First Tab
        xmlContentTabItem = new TabItem(mainTabFolder, SWT.NONE);
        xmlContentTabItem.setText(XML_CONTENT_TAB_ITEM_TEXT);
        
        // Second Tab
        namespacesTabItem = new TabItem(mainTabFolder, SWT.NONE);
        namespacesTabItem.setText(NAMESPACES_TAB_ITEM_TEXT);

        // Construct and layout namespace edit box.
        namespacesGroupBox = new Group(mainTabFolder, SWT.NONE);
        {
            FormData groupBoxLayoutData = new FormData();
            groupBoxLayoutData.top = new FormAttachment(0);
            groupBoxLayoutData.left = new FormAttachment(0);
            groupBoxLayoutData.right = new FormAttachment(100);
            groupBoxLayoutData.bottom = new FormAttachment(dialogShell, 100);
            namespacesGroupBox.setLayoutData(groupBoxLayoutData);
            namespacesGroupBox.setSize(dialogShell.getSize());

            // Configure group box internal layout.
            FormLayout groupBoxLayout = new FormLayout();
            groupBoxLayout.marginWidth = 5;
            groupBoxLayout.marginHeight = 5;
            namespacesGroupBox.setLayout(groupBoxLayout);

            // Namespace prefix label.
            nsPrefixLabel = new Label(namespacesGroupBox, SWT.NONE);
            {
                nsPrefixLabel.setText("Prefix:");
                FormData nsPrefixLabelLayoutData = new FormData();
                nsPrefixLabelLayoutData.top = new FormAttachment(0);
                nsPrefixLabelLayoutData.left = new FormAttachment(0);
                nsPrefixLabel.setLayoutData(nsPrefixLabelLayoutData);
            }

            // Namespace prefix text field.
            nsPrefixTextField = new Text(namespacesGroupBox, SWT.BORDER);
            {
                FormData nsPrefixTextFieldLayoutData = new FormData();
                nsPrefixTextFieldLayoutData.top = new FormAttachment(nsPrefixLabel, 0, SWT.CENTER);
                nsPrefixTextFieldLayoutData.left = new FormAttachment(nsPrefixLabel, 5);
                nsPrefixTextFieldLayoutData.width = 100;
                nsPrefixTextField.setLayoutData(nsPrefixTextFieldLayoutData);
            }

            // Namespace URI label.
            nsUriLabel = new Label(namespacesGroupBox, SWT.NONE);
            {
                nsUriLabel.setText(URI_LABEL_TEXT);
                FormData nsUriLabelLayoutData = new FormData();
                nsUriLabelLayoutData.top = new FormAttachment(nsPrefixTextField, 0, SWT.CENTER);
                nsUriLabelLayoutData.left = new FormAttachment(nsPrefixTextField, 5);
                nsUriLabel.setLayoutData(nsUriLabelLayoutData);
            }

            // Add namespace button.
            addButton = new Button(namespacesGroupBox, SWT.NONE);
            {
                addButton.setText(ADD_BUTTON_TEXT);
                FormData addButtonLayoutData = new FormData();
                addButtonLayoutData.top = new FormAttachment(nsUriLabel, 0, SWT.CENTER);
                addButtonLayoutData.right = new FormAttachment(100);
                addButtonLayoutData.width = 80;
                addButton.setLayoutData(addButtonLayoutData);
            }

            // Namespace URI input text field.
            nsUriTextField = new Text(namespacesGroupBox, SWT.BORDER);
            {
                FormData nsUriTextFieldLayoutData = new FormData();
                nsUriTextFieldLayoutData.top = new FormAttachment(nsUriLabel, 0, SWT.CENTER);
                nsUriTextFieldLayoutData.left = new FormAttachment(nsUriLabel, 5);
                nsUriTextFieldLayoutData.right = new FormAttachment(addButton, -5);
                nsUriTextField.setLayoutData(nsUriTextFieldLayoutData);
            }

            // Edit namespace button.
            editButton = new Button(namespacesGroupBox, SWT.NONE);
            {
                editButton.setText(EDIT_BUTTON_TEXT);
                FormData editButtonLayoutData = new FormData();
                editButtonLayoutData.top = new FormAttachment(addButton, 10);
                editButtonLayoutData.right = new FormAttachment(100);
                editButtonLayoutData.left = new FormAttachment(addButton, 0, SWT.LEFT);
                editButton.setLayoutData(editButtonLayoutData);
            }

            // Remove namespace button.
            removeButton = new Button(namespacesGroupBox, SWT.NONE);
            {
                removeButton.setText(REMOVE_BUTTON_TEXT);
                FormData removeButtonLayoutData = new FormData();
                removeButtonLayoutData.top = new FormAttachment(editButton, 5);
                removeButtonLayoutData.right = new FormAttachment(100);
                removeButtonLayoutData.left = new FormAttachment(editButton, 0, SWT.LEFT);
                removeButton.setLayoutData(removeButtonLayoutData);
            }

            // Namespaces list box.
            nsListBox = new List(namespacesGroupBox, SWT.BORDER);
            {
                FormData nsListBoxFormData = new FormData();
                nsListBoxFormData.top = new FormAttachment(editButton, 0, SWT.TOP);
                nsListBoxFormData.left = new FormAttachment(0);
                nsListBoxFormData.right = new FormAttachment(addButton, -5);
                nsListBoxFormData.bottom = new FormAttachment(100);
                nsListBox.setLayoutData(nsListBoxFormData);
            }
        }
        
        // Layout for XML tab content.
        xmlContentTabGroupBox = new Group(mainTabFolder, SWT.NONE);
        {
            FormData xmlContentTabGroupBoxLayoutData = new FormData();
            xmlContentTabGroupBoxLayoutData.top = new FormAttachment(xmlContentTabFolder, 5);
            xmlContentTabGroupBoxLayoutData.left = new FormAttachment(1);
            xmlContentTabGroupBoxLayoutData.right = new FormAttachment(100);
            xmlContentTabGroupBox.setLayoutData(xmlContentTabGroupBoxLayoutData);

            // Configure group box internal layout.
            FormLayout testGroupBoxLayout = new FormLayout();
            testGroupBoxLayout.marginWidth = 5;
            testGroupBoxLayout.marginHeight = 5;
            xmlContentTabGroupBox.setLayout(testGroupBoxLayout);
        }
        
        infoLabel = new Label(xmlContentTabGroupBox, SWT.NONE);
        {
            infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
            FormData infoLabelLayoutData = new FormData();
            infoLabelLayoutData.top = new FormAttachment(xmlContentTabGroupBox, 2);
            infoLabelLayoutData.left = new FormAttachment(1);
            infoLabelLayoutData.right = new FormAttachment(99);
            infoLabel.setLayoutData(infoLabelLayoutData);
        }
        
        // Initialising XML tab layout
        xmlContentTabFolder = new TabFolder(xmlContentTabGroupBox, SWT.BOTTOM | SWT.BORDER_SOLID);
        Device device = Display.getCurrent();
        xmlContentTabFolder.setBackground(new Color(device, new RGB(220, 220, 220)));
        
        FormData xmlContentTabFolderLayoutData = new FormData();
        xmlContentTabFolderLayoutData.top = new FormAttachment(infoLabel, 5);
        xmlContentTabFolderLayoutData.left = new FormAttachment(0);
        xmlContentTabFolderLayoutData.right = new FormAttachment(100);
        xmlContentTabFolderLayoutData.bottom = new FormAttachment(100);
        xmlContentTabFolder.setLayoutData(xmlContentTabFolderLayoutData);
        
        // First Tab
        xmlSourceTabItem = new TabItem(xmlContentTabFolder, SWT.NONE);
        xmlSourceTabItem.setText(SOURCE_TAB_ITEM_TEXT);
        
        // Second Tab
        xmlVisualTabItem = new TabItem(xmlContentTabFolder, SWT.NONE);
        xmlVisualTabItem.setText(VISUAL_TAB_ITEM_TEXT);
        
        // Construct and layout property edit box.
        xmlContentGroupBox = new Group(xmlContentTabFolder, SWT.NONE);
        {
            FormData xmlContentGroupBoxLayoutData = new FormData();
            xmlContentGroupBoxLayoutData.top = new FormAttachment(xmlContentTabFolder, 5);
            xmlContentGroupBoxLayoutData.left = new FormAttachment(0);
            xmlContentGroupBoxLayoutData.right = new FormAttachment(100);
            xmlContentGroupBox.setLayoutData(xmlContentGroupBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout xmlContentGroupBoxLayout = new FormLayout();
            xmlContentGroupBoxLayout.marginWidth = 5;
            xmlContentGroupBoxLayout.marginHeight = 5;
            xmlContentGroupBox.setLayout(xmlContentGroupBoxLayout);
            
            inlineXMLTextArea = new StyledText(xmlContentGroupBox, SWT.MULTI | SWT.BORDER | SWT.WRAP | 
                    SWT.H_SCROLL | SWT.V_SCROLL);
            FormData xmlTextAreaLayoutData = new FormData();
            xmlTextAreaLayoutData.top = new FormAttachment(xmlContentGroupBox, 0);
            xmlTextAreaLayoutData.right = new FormAttachment(100);
            xmlTextAreaLayoutData.left = new FormAttachment(0);
            xmlTextAreaLayoutData.bottom = new FormAttachment(100);
            inlineXMLTextArea.setText(XML_CONTENT_PLACEHOLDER_TEXT);
            inlineXMLTextArea.setLayoutData(xmlTextAreaLayoutData);
        }
        
        // Construct and layout property edit box.
        treeViewGroupBox = new Group(xmlContentTabFolder, SWT.NONE);
        {
            FormData groupBoxLayoutData = new FormData();
            groupBoxLayoutData.top = new FormAttachment(xmlContentTabFolder, 5);
            groupBoxLayoutData.left = new FormAttachment(1);
            groupBoxLayoutData.right = new FormAttachment(100);
            treeViewGroupBox.setLayoutData(groupBoxLayoutData);

            // Configure group box internal layout.
            FormLayout groupBoxLayout = new FormLayout();
            groupBoxLayout.marginWidth = 5;
            groupBoxLayout.marginHeight = 5;
            treeViewGroupBox.setLayout(groupBoxLayout);
            
            // Tree view.
            treeViewWidget = new Tree(treeViewGroupBox, SWT.BORDER);
            {
                FormData treeViewLayoutData = new FormData();
                treeViewLayoutData.top = new FormAttachment(xmlContentGroupBox, 0);
                treeViewLayoutData.left = new FormAttachment(0);
                treeViewLayoutData.right = new FormAttachment(100);
                treeViewLayoutData.bottom = new FormAttachment(100);
                treeViewWidget.setLayoutData(treeViewLayoutData);
            }
        }
        
        // Label for XPath text field
        xPathLabel = new Label(dialogShell, SWT.NONE);
        {
            xPathLabel.setText(XPATH_LABEL_TEXT);
            FormData xPathLabelLayoutData = new FormData();
            xPathLabelLayoutData.top = new FormAttachment(mainTabFolder, 5);
            xPathLabelLayoutData.left = new FormAttachment(1);
            xPathLabel.setLayoutData(xPathLabelLayoutData);
        }
        
        // Evaluate XPath button
        evaluateXPathButton = new Button(dialogShell, SWT.NONE);
        {
            evaluateXPathButton.setText(EVALUATE_LABEL_TEXT);
            FormData evaluateXPathButtonLayoutData = new FormData();
            evaluateXPathButtonLayoutData.top = new FormAttachment(mainTabFolder, 0, SWT.BOTTOM);
            evaluateXPathButtonLayoutData.right = new FormAttachment(99);
            evaluateXPathButtonLayoutData.width = 80;
            evaluateXPathButton.setLayoutData(evaluateXPathButtonLayoutData);
        }
        
        // XPath text field
        xPathTextField = new Text(dialogShell, SWT.BORDER);
        {
            FormData xpathTextFieldLayoutData = new FormData();
            xpathTextFieldLayoutData.top = new FormAttachment(mainTabFolder, 5);
            xpathTextFieldLayoutData.left = new FormAttachment(xPathLabel, 5);
            xpathTextFieldLayoutData.right = new FormAttachment(evaluateXPathButton, -5);
            xPathTextField.setLayoutData(xpathTextFieldLayoutData);
        }
        
        Label outputLabel = new Label(dialogShell, SWT.NONE);
        {
            outputLabel.setText(OUTPUT_LABEL_TEXT);
            FormData outputLabelLayoutData = new FormData();
            outputLabelLayoutData.top = new FormAttachment(xPathTextField, 5);
            outputLabelLayoutData.left = new FormAttachment(1);
            outputLabel.setLayoutData(outputLabelLayoutData);
        }
        
        // Evaluated output text area 
        outputXMLTextArea = new StyledText(dialogShell, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        {
            FormData xmlTextAreaLayoutData = new FormData();
            xmlTextAreaLayoutData.top = new FormAttachment(outputLabel, 5);
            xmlTextAreaLayoutData.right = new FormAttachment(98);
            xmlTextAreaLayoutData.left = new FormAttachment(1);
            xmlTextAreaLayoutData.height = 90;
            
            outputXMLTextArea.setText(EMPTY_STRING);
            outputXMLTextArea.setWordWrap(false);
            outputXMLTextArea.setLayoutData(xmlTextAreaLayoutData);
        }
        
        // OK button.
        okButton = new Button(dialogShell, SWT.NONE);
        {
            okButton.setText(OK_BUTTON_TEXT);
            FormData okButtonLayoutData = new FormData();
            okButtonLayoutData.right = new FormAttachment(100);
            okButtonLayoutData.bottom = new FormAttachment(100);
            okButtonLayoutData.width = 80;
            okButton.setLayoutData(okButtonLayoutData);
        }

        // Cancel button.
        cancelButton = new Button(dialogShell, SWT.NONE);
        {
            cancelButton.setText(CANCEL_BUTTON_TEXT);
            FormData cancelButtonLayoutData = new FormData();
            cancelButtonLayoutData.top = new FormAttachment(okButton, 0, SWT.CENTER);
            cancelButtonLayoutData.right = new FormAttachment(okButton, -5);
            cancelButtonLayoutData.width = 80;
            cancelButton.setLayoutData(cancelButtonLayoutData);
        }
        
        // Setting content to tabs
        xmlContentTabItem.setControl(xmlContentTabGroupBox);
        namespacesTabItem.setControl(namespacesGroupBox);
        
        xmlSourceTabItem.setControl(xmlContentGroupBox);
        xmlVisualTabItem.setControl(treeViewGroupBox);

        loadConfiguration();
        initActions();
        setTabOrder();

        // Open dialog.
        dialogShell.layout();
        dialogShell.pack();
        dialogShell.setSize(640, 740);
        centerDialog();
        dialogShell.open();
        Display display = dialogShell.getDisplay();
        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    private void loadConfiguration() {
        dialogShell.setText(String.format(EDITOR_TITLE, nsProperty.getPrettyName()));
        if (!StringUtils.isBlank(nsProperty.getPropertyValue())) {
            xPathTextField.setText(nsProperty.getPropertyValue());
        }

        // Load namespaces.
        for (Entry<String, String> nsEntry : nsProperty.getNamespaces().entrySet()) {
            addNamespace(nsEntry.getKey(), nsEntry.getValue());
        }
        
        xPathTextField.setFocus();
    }

    private void initActions() {
        
        addButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                String prefix = nsPrefixTextField.getText();
                String uri = nsUriTextField.getText();
                if (XpathValidator.isValidNamespace(dialogShell, collectedNamespaces, prefix, uri)) {
                    addNamespace(prefix, uri);
                    nsPrefixTextField.setText(EMPTY_STRING);
                    nsUriTextField.setText(EMPTY_STRING);
                    nsPrefixTextField.setFocus();
                }
            }
        });

        removeButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                for (String selection : nsListBox.getSelection()) {
                    removeNamespace(selection);
                }
            }
        });

        editButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                String[] selection = nsListBox.getSelection();
                if (selection.length > 0) {
                    String selectedNamespace = selection[0];
                    String prefix = extractPrefix(selectedNamespace);
                    String uri = collectedNamespaces.get(prefix);
                    if (null != uri) {
                        collectedNamespaces.remove(prefix);
                        nsPrefixTextField.setText(prefix);
                        nsUriTextField.setText(uri);
                        nsPrefixTextField.setFocus();
                    }
                    nsListBox.remove(selectedNamespace);
                }
            }
        });

        okButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                if (XpathValidator.isValidConfiguration(dialogShell, xPathTextField.getText(),
                        collectedNamespaces)) {
                    try {
                        saveConfiguration();
                        setSaved(true);
                    } catch (Exception ex) {
                        log.error("Error while saving namespace property", ex);
                    }
                    dialogShell.dispose();
                }
            }
        });

        cancelButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                setSaved(false);
                dialogShell.dispose();
            }
        });
        
        browseButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                // Configure file dialog.
                FileDialog fileBrowserDialog = new FileDialog(dialogShell, SWT.OPEN);
                fileBrowserDialog.setText("Select XML Document");
                fileBrowserDialog.setFilterExtensions(new String[] { XML_EXTENSION_TYPE });

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
                        currentFile = selectedFile;
                        // Create a new runnable that can be executed with a
                        // progress bar.
                        IRunnableWithProgress runnable = new IRunnableWithProgress() {
                            public void run(IProgressMonitor monitor)
                                    throws InvocationTargetException, InterruptedException {
                                // We have no clue how long this would take.
                                monitor.beginTask("Parsing xml document...", IProgressMonitor.UNKNOWN);

                                // Parse the xml document into a dom object.
                                try {
                                    Document document = parseDocument(selectedFile);
                                    final Node rootNode = document.getDocumentElement();

                                    // Adding a tree item is a ui related
                                    // operation which must be executed on the
                                    // ui thread. Since we are currently
                                    // executing inside a background thread, we
                                    // need to explicitly invoke the ui thread.
                                    new UIJob(UI_JOB_ID) {
                                        public IStatus runInUIThread(IProgressMonitor monitor) {
                                            addTreeItem(null, rootNode);
                                            addNameSpaces(rootNode);
                                            collectedNamespaces.clear();
                                            nsListBox.removeAll();
                                            for (Entry<String, String> nsEntry : getNameSpaces().entrySet()) {
                                                addNamespace(nsEntry.getKey(), nsEntry.getValue());
                                            }
                                            
                                            // Get formatted XML content
                                            xmlFileContentStr = xPathValidator.getFormattedXMLStringFromDoc(document);
                                            inlineXMLTextArea.setText(xmlFileContentStr);
                                            infoLabel.setText(TREE_VIEW_INFO_LABEL_TEXT);
                                            isCurrentXMLContentValid = true;
                                            
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
                            new ProgressMonitorDialog(dialogShell).run(true, false, runnable);
                        } catch (Exception ex) {
                            MessageDialog.openError(dialogShell, "Parsing Error",
                                    "Error while parsing the specified xml file.");
                        }
                    } else {
                        MessageDialog.openError(dialogShell, "I/O Error", "Unable to read specified input file.");
                    }
                }
            }
        });
        
        treeViewWidget.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TreeItemData treeItemData = (TreeItemData) event.item.getData(TREE_ITEM_DATA_KEY);
                xPathTextField.setText(XSLTXPathHelper.calculateXPathToNode(treeItemData.getDomNode()));
            }
        });

        treeViewWidget.addListener(SWT.Expand, new Listener() {
            public void handleEvent(Event event) {
                TreeItem currentItem = (TreeItem) event.item;
                TreeItemData treeItemData = (TreeItemData) currentItem.getData(TREE_ITEM_DATA_KEY);

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
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                TreeItem[] selection = treeViewWidget.getSelection();
                if (selection.length > 0) {
                    Node selectedNode = ((TreeItemData) selection[0].getData(TREE_ITEM_DATA_KEY)).getDomNode();
                    setSelectedXpath(XSLTXPathHelper.calculateXPathToNode(selectedNode));
                    dialogShell.dispose();
                }
            }
            
            // The following two methods were left empty intentionally since they must be overridden
            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDown(MouseEvent e) {}

        });
        
        inlineRadioButton.addSelectionListener(new SelectionAdapter()  {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    filePathTextField.setText(EMPTY_STRING);
                    xPathTextField.setText(EMPTY_STRING);
                    outputXMLTextArea.setText(EMPTY_STRING);
                    inlineXMLTextArea.setText(XML_CONTENT_PLACEHOLDER_TEXT);
                    infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
                    
                    browseButton.setEnabled(false);
                    filePathTextField.setEnabled(false);
                    
                    xmlContentTabFolder.setSelection(0);
                    xmlContentTabFolder.getTabList()[0].setEnabled(true);
               
                    treeViewWidget.removeAll();
                }
            }
        });
         
        browseFileRadioButton.addSelectionListener(new SelectionAdapter()  {
 
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    browseButton.setEnabled(true);
                    infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
                    
                    xmlContentTabFolder.setSelection(1);
                    treeViewWidget.removeAll();
                    inlineXMLTextArea.setText(EMPTY_STRING);
                    outputXMLTextArea.setText(EMPTY_STRING);
                }
            } 
        });
        
        inlineXMLTextArea.addLineStyleListener(new LineStyleListener()
        {
            public void lineGetStyle(LineStyleEvent e)
            {
                e.bulletIndex = inlineXMLTextArea.getLineAtOffset(e.lineOffset);

                StyleRange style = new StyleRange();
                Device device = Display.getCurrent();
                final RGB LINE_NUMBER_BG = new RGB(0, 0, 100);
                final RGB LINE_NUMBER_FG = new RGB(255, 255, 255);
                
                style.background = new Color(device, LINE_NUMBER_BG);
                style.foreground = new Color(device, LINE_NUMBER_FG);
                
                style.metrics = new GlyphMetrics(0, 0, Integer.toString(inlineXMLTextArea.
                        getLineCount() + 1).length() * 12);

                e.bullet = new Bullet(ST.BULLET_NUMBER, style);
            }
        });
        
        inlineXMLTextArea.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(org.eclipse.swt.events.FocusEvent e) {
                if (XML_CONTENT_PLACEHOLDER_TEXT.equalsIgnoreCase(inlineXMLTextArea.getText())) {
                    inlineXMLTextArea.setText(EMPTY_STRING);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                String xmlText = inlineXMLTextArea.getText().trim();
                
                if (isInlineXMLContentChanged) {
                    
                    if (!xPathValidator.isValidXML(xmlText)) {
                        outputXMLTextArea.setText(EMPTY_STRING);
                        treeViewWidget.removeAll();
                        isInlineXMLContentChanged = false;
                        isCurrentXMLContentValid = false;
                        return;
                    }
                    
                    treeViewWidget.removeAll();

                    IRunnableWithProgress runnable = new IRunnableWithProgress() {
                        public void run(IProgressMonitor monitor)
                                throws InvocationTargetException, InterruptedException {

                            monitor.beginTask("Parsing xml document...", IProgressMonitor.UNKNOWN);

                            try {
                                Document document = xPathValidator.parseXML(xmlText);
                                final Node rootNode = document.getDocumentElement();

                                new UIJob(UI_JOB_ID) {
                                    public IStatus runInUIThread(IProgressMonitor monitor) {
                                        addTreeItem(null, rootNode);
                                        addNameSpaces(rootNode);
                                        collectedNamespaces.clear();
                                        nsListBox.removeAll();
                                        for (Entry<String, String> nsEntry : getNameSpaces().entrySet()) {
                                            addNamespace(nsEntry.getKey(), nsEntry.getValue());
                                        }
                                        isInlineXMLContentChanged = false;
                                        isCurrentXMLContentValid = true;
                                        return Status.OK_STATUS;
                                    }
                                }.schedule();

                                monitor.done();
                            } catch (Exception ex) {
                                monitor.done();
                                throw new InvocationTargetException(ex);
                            }
                        }
                    };

                    try {
                        new ProgressMonitorDialog(dialogShell).run(true, false, runnable);
                    } catch (Exception ex) {
                        MessageDialog.openError(dialogShell, "Parsing Error",
                                "Error while parsing the specified xml file.");
                    }
                }
                
            }
        });
        
        // Modify listener for inline XML text area.
        inlineXMLTextArea.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {  
                isInlineXMLContentChanged = true;
                
                if (EMPTY_STRING.equalsIgnoreCase(inlineXMLTextArea.getText())) {
                    infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
                } else {
                    infoLabel.setText(SOURCE_VIEW_INFO_LABEL_TEXT);
                }
                
                // For line number redrawing.
                inlineXMLTextArea.redraw();
            }
        });
        
        // Event listener for evaluate xpath button.
        evaluateXPathButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                outputXMLTextArea.setText(EMPTY_STRING);
                
                if (xPathValidator.isValidXML(inlineXMLTextArea.getText().trim())) {
                    String outputStr = xPathValidator.getEvaluatedResult(inlineXMLTextArea.getText().trim(),
                            xPathTextField.getText().trim(), nameSpaces);
                    
                    if (EMPTY_STRING.equalsIgnoreCase(outputStr)) {
                        outputXMLTextArea.setText(INVALID_XPATH_EXPRESSION_TEXT);
                    } else {
                        outputXMLTextArea.setText(outputStr);
                    }

                } else {
                    isCurrentXMLContentValid = false;
                    infoLabel.setText(INVALID_XML_SYNTAX_LABEL_TEXT);
                    outputXMLTextArea.setText(INVALID_XML_SYNTAX_LABEL_TEXT);
                }
            }
        });
        
        // Event listener for XML content tab folder selection
        xmlContentTabFolder.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent evt) {
                TabItem item = xmlContentTabFolder.getSelection()[0];
                
                if (XML_CONTENT_PLACEHOLDER_TEXT.equalsIgnoreCase(inlineXMLTextArea.getText()) || 
                        EMPTY_STRING.equalsIgnoreCase(inlineXMLTextArea.getText())) {
                    infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
                } else {
                    if (isCurrentXMLContentValid) {
                        if (item.getText().equalsIgnoreCase(SOURCE_TAB_ITEM_TEXT)) {
                            infoLabel.setText(SOURCE_VIEW_INFO_LABEL_TEXT);
                        } else {
                            infoLabel.setText(TREE_VIEW_INFO_LABEL_TEXT);
                        }
                    } else {
                        infoLabel.setText(INVALID_XML_SYNTAX_LABEL_TEXT);
                    }
                }
            }
        });
    }

    private void addNamespace(String prefix, String uri) {
        collectedNamespaces.put(prefix, uri);
        String namespaceDisplayValue = String.format(namespaceDisplayFormat, prefix, uri);
        nsListBox.add(namespaceDisplayValue);
    }

    private void removeNamespace(String namespace) {
        nsListBox.remove(namespace);
        String prefix = extractPrefix(namespace);
        if (!StringUtils.isBlank(prefix)) {
            collectedNamespaces.remove(prefix);
        }
    }

    private String extractPrefix(String namespace) {
        Matcher matcher = namespaceDisplayPattern.matcher(namespace);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private void centerDialog() {
        Rectangle parentBounds = getParent().getBounds();
        Rectangle dialogBounds = dialogShell.getBounds();
        int centerX, centerY;
        centerX = (parentBounds.width - dialogBounds.width) / 2 + parentBounds.x;
        centerY = (parentBounds.height - dialogBounds.height) / 2 + parentBounds.y;
        dialogShell.setLocation(new Point(centerX, centerY));
    }

    private void setTabOrder() {
        Control[] tabOrder = new Control[] { nsPrefixTextField, nsUriTextField, addButton };
  
        namespacesGroupBox.setTabList(tabOrder);

        tabOrder = new Control[] { okButton };
        dialogShell.setTabList(tabOrder);
        
        tabOrder = new Control[] { xmlContentTabGroupBox, namespacesGroupBox };
        mainTabFolder.setTabList(tabOrder);
        
        tabOrder = new Control[] { xmlContentGroupBox, treeViewGroupBox };
        xmlContentTabFolder.setTabList(tabOrder);
    }

    private void saveConfiguration() throws Exception {
        nsProperty.setPropertyValue(xPathTextField.getText());
        nsProperty.getNamespaces().clear();
        nsProperty.getNamespaces().putAll(collectedNamespaces);
    }

    private void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isSaved() {
        return saved;
    }
    
    private void setSelectedXpath(String selectedXpath) {
        this.selectedXpath = selectedXpath;
    }
    
    /**
     * Utility method for constructing a Document from an XML file.
     * 
     * @param file File containing the XML string.
     * @return a Document instance representing the XML structure.
     * @throws Exception If an error is encountered while reading the file or parsing its content.
     */
    public static Document parseDocument(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }
    
    
    /**
     * Utility method for adding a child TreeItem into the specified parent TreeItem object.
     * 
     * @param parent Parent TreeItem or null if this is root.
     * @param node DOM Node to be associated with this TreeItem.
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
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            childTreeItem.setImage(ImageHolder.getInstance().getXPathElementImage());
        } else {
            childTreeItem.setImage(ImageHolder.getInstance().getXPathAttributeImage());
        }

        // Associated dom node with the newly created tree item.
        childTreeItem.setData(TREE_ITEM_DATA_KEY, new TreeItemData(node));

        // Here we determine if a dummy grand-child should be added into the
        // newly created child item. The grand-child is needed so that the
        // expand handle (little triangle besides the tree item) appears and the
        // user is able to expand the node (upon which event we explore the rest
        // of the tree dynamically).
        boolean hasChildren = (node.getNodeType() == Node.ELEMENT_NODE) ? node.hasChildNodes() : false;
        if (hasChildren) {
            TreeItem grandChild = new TreeItem(childTreeItem, SWT.NONE);
            grandChild.setText(IN_PROGRESS_LABEL_TEXT);
        }
    }
    
    /**
     * Adding namespaces to a list.
     * 
     * @param Node object
     */
    private void addNameSpaces(Node node) {
        nameSpaces = new HashMap<String, String>();
        NamedNodeMap nsList = node.getAttributes();
        if (nsList.getLength() > 0) {
            for (int i = 0; i < nsList.getLength(); i++) {
                Node item = nsList.item(i);
                if (null != item.getNodeName() && item.getNodeName().startsWith("xmlns:")) {
                    nameSpaces.put(item.getNodeName().replaceAll("^xmlns:", EMPTY_STRING), item.getNodeValue());
                }
            }
        }
    }
    
    private Map<String, String> getNameSpaces() {
        return nameSpaces;
    }
    
}
