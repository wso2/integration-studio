package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.util.XPathValidator;
import org.wso2.developerstudio.eclipse.gmf.esb.util.XPathValidatorImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


/**
 * A SWT based editor dialog to be used for editing namespaced properties.
 */
public class EEFNameSpacedPropertyEditorDialog extends Dialog {
	
    private static final String JSON = "JSON";
    private static final String XML = "XML";
    private static final String EXPRESSION = "Expression";

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
     * Text input box for expressions.
     */
    private Text expressionTextField;
    
    /**
     * Evaluate XPath expression button.
     */
    private Button evaluateExpressionButton;
    
    /**
     * Evaluation type combo box.
     */
    private Combo evalTypeComboBox;
    
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
     * A boolean to check if inline XML text area is dirty.
     */
    private boolean isInlineXMLTextAreaDirty = false;
    
    /**
     * Expression elements group.
     */
    private Group expressionGroup;
    
    /**
     * Input label for XML.
     */
    private Label xmlInputLabel;
    
    /**
     * Output label for XML.
     */
    private Label xmlOutputLabel;
    
    /**
     * Input label for JSON.
     */
    private Label jsonInputLabel;
    
    /**
     * A flag to check if only XML is enabled.
     */
    private boolean isXMLOnly = false;
    
    /**
     * XPath validator object.
     */
    private XPathValidator xPathValidator;
    
    /**
     * Group for XML evaluator elements.
     */
    private Group xmlEvaluatorGroup;
    
    /**
     * Group for JSON evaluator elements.
     */
    private Group jsonEvaluatorGroup;
    
    /**
     * Group for expression evaluator elements.
     */
    private Group exprEvaluatorGroup;

    /**
     * Type of operating system
     */
    private String operatingSystemType;
    
    /**
     * Browser view for expression help.
     */
    private Browser exprBrowserView;
    
    private static final String EMPTY_STRING = "";
    private static final String SOURCE_VIEW_INFO_LABEL_TEXT = "Switch to 'Visual' tab to see a graphical "
            + "view of the XML content";
    private static final String TREE_VIEW_INFO_LABEL_TEXT = "Select an element to get the XPath expression";
    private static final String INVALID_XML_SYNTAX_LABEL_TEXT = "Invalid XML syntax";
    private static final String EDITOR_TITLE = "Expression Selector";
    private static final String XML_CONTENT_PLACEHOLDER_TEXT = "Paste your XML content here...";
    private static final String VISUAL_TAB_ITEM_TEXT = "Visual";
    private static final String SOURCE_TAB_ITEM_TEXT = "Source";
    private static final String NAMESPACES_TAB_ITEM_TEXT = "Namespaces";
    private static final String XML_CONTENT_TAB_ITEM_TEXT = "XML Content";
    private static final String FILE_RADIO_BUTTON_TEXT = "Load XML file";
    private static final String INLINE_RADIO_BUTTON_TEXT = "Enter XML";
    private static final String IN_PROGRESS_LABEL_TEXT = "Working...";
    private static final String CANCEL_BUTTON_TEXT = "Cancel";
    private static final String OK_BUTTON_TEXT = "OK";
    private static final String OUTPUT_LABEL_TEXT = "Output";
    private static final String INPUT_LABEL_TEXT = "Input";
    private static final String EVALUATE_LABEL_TEXT = "Evaluate";
    private static final String EXPRESSION_LABEL_TEXT = "Expression";
    private static final String REMOVE_BUTTON_TEXT = "Remove";
    private static final String EDIT_BUTTON_TEXT = "Edit";
    private static final String ADD_BUTTON_TEXT = "Add";
    private static final String URI_LABEL_TEXT = "URI:";
    private static final String INFO_LABEL_DEFAULT_TEXT = "Enter or load XML file from disk";
    private static final String INVALID_XPATH_EXPRESSION_TEXT = "Invalid XPath expression";
    private static final String EXPR_HELP_HTML_FILE_PATH = "platform:/plugin/org.wso2."
    		+ "developerstudio.eclipse.gmf.esb.edit/resources/expressions-help.html";

    private static final String UI_JOB_ID = "add-root-tree-item-job";
    private static final String XML_EXTENSION_TYPE = "*.xml";
    private static final String TREE_ITEM_DATA_KEY = "dom_user_data_key";
    public static final String OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
    public static final String OS_TYPE_WINDOWS = "windows";
    
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
     * @param parent Parent shell.
     * @param style Style.
     * @param property Namespaced property.
     */
    public EEFNameSpacedPropertyEditorDialog(Shell parent, int style, NamespacedProperty property) {
        super(parent, style);
        this.nsProperty = property;
        this.collectedNamespaces = new HashMap<String, String>();
        xPathValidator = XPathValidatorImpl.getInstance();
        operatingSystemType = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);
    }
    
    /**
     * Constructs a new dialog.
     * 
     * @param parent parent shell.
     * @param style style.
     * @param property Namespaced property
     * @param isXMLOnly A flag to check if only XML is enabled.
     */
    public EEFNameSpacedPropertyEditorDialog(Shell parent, int style, NamespacedProperty property,
    		boolean isXMLOnly) {
        super(parent, style);
        this.isXMLOnly = isXMLOnly;
        this.nsProperty = property;
        this.collectedNamespaces = new HashMap<String, String>();
        xPathValidator = XPathValidatorImpl.getInstance();
        operatingSystemType = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);
    }

    /**
     * Main function used for testing purposes.
     * 
     * @param args arguments.
     */
    public static void main(String[] args) {}

    /**
     * Creates UI components and opens the dialog.
     */
    public NamespacedProperty open() {
        Shell parentShell = getParent();
        dialogShell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE);

        // Configure dialog shell internal layout.
        FormLayout dialogShellLayout = new FormLayout();
        dialogShellLayout.marginHeight = 5;
        dialogShellLayout.marginWidth = 5;
        dialogShell.setLayout(dialogShellLayout);
        
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
        
        expressionGroup = new Group(dialogShell, SWT.NONE);
        {   
        	FormData expressionGroupBoxLayoutData = new FormData();
        	expressionGroupBoxLayoutData.top = new FormAttachment(0);
        	expressionGroupBoxLayoutData.left = new FormAttachment(1);
        	expressionGroupBoxLayoutData.right = new FormAttachment(99);
        	expressionGroup.setLayoutData(expressionGroupBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout expressionGroupBoxLayout = new FormLayout();
            expressionGroupBoxLayout.marginWidth = 5;
            expressionGroupBoxLayout.marginHeight = 5;
            expressionGroup.setLayout(expressionGroupBoxLayout);
            
            evalTypeComboBox = new Combo(expressionGroup, SWT.VERTICAL | SWT.DROP_DOWN
            		| SWT.BORDER | SWT.READ_ONLY);
            {
            	evalTypeComboBox.add(XML);
            	evalTypeComboBox.add(JSON);
            	evalTypeComboBox.add(EXPRESSION);
            	evalTypeComboBox.select(0);
            	FormData evalTypeComboBoxLayoutData = new FormData();
            	evalTypeComboBoxLayoutData.top = new FormAttachment(1);
            	evalTypeComboBoxLayoutData.left = new FormAttachment(1);
            	evalTypeComboBoxLayoutData.width = 125;
            	evalTypeComboBox.setLayoutData(evalTypeComboBoxLayoutData);
            }
            
            // XPath text field
            expressionTextField = new Text(expressionGroup, SWT.BORDER);
            {
                FormData xpathTextFieldLayoutData = new FormData();
                xpathTextFieldLayoutData.top = new FormAttachment(1);
                xpathTextFieldLayoutData.left = new FormAttachment(evalTypeComboBox, 5);
                xpathTextFieldLayoutData.right = new FormAttachment(99);
                expressionTextField.setLayoutData(xpathTextFieldLayoutData);
            }
            
        }
        
        expressionTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {}
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.keyCode == SWT.CR) {
                    if (EEFXpathValidator.isValidConfiguration(dialogShell, expressionTextField.getText(),
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
            }
        });
        
        // Construct and layout namespace edit box.
        namespacesGroupBox = new Group(dialogShell, SWT.NONE);
        {
            FormData groupBoxLayoutData = new FormData();
            groupBoxLayoutData.top = new FormAttachment(expressionGroup, 5);
            groupBoxLayoutData.left = new FormAttachment(1);
            groupBoxLayoutData.right = new FormAttachment(99);
            namespacesGroupBox.setLayoutData(groupBoxLayoutData);
            namespacesGroupBox.setSize(dialogShell.getSize());
            namespacesGroupBox.setText("Namespaces");

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
                addButtonLayoutData.width = 100;
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
        
        xmlEvaluatorGroup = new Group(dialogShell, SWT.NONE);
        {   
            FormData xmlEvaluatorGroupBoxLayoutData = new FormData();
            xmlEvaluatorGroupBoxLayoutData.top = new FormAttachment(namespacesGroupBox, 2);
            xmlEvaluatorGroupBoxLayoutData.left = new FormAttachment(1);
            xmlEvaluatorGroupBoxLayoutData.right = new FormAttachment(99);
            xmlEvaluatorGroupBoxLayoutData.bottom = new FormAttachment(okButton, -5);
            xmlEvaluatorGroup.setLayoutData(xmlEvaluatorGroupBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout xmlEvaluatorGroupBoxLayout = new FormLayout();
            xmlEvaluatorGroupBoxLayout.marginWidth = 5;
            xmlEvaluatorGroupBoxLayout.marginHeight = 5;
            xmlEvaluatorGroup.setLayout(xmlEvaluatorGroupBoxLayout);
            
            xmlEvaluatorGroup.setText("Evaluate Xpath");
        }
        
        jsonEvaluatorGroup = new Group(dialogShell, SWT.NONE);
        {   
            FormData jsonEvaluatorGrouppBoxLayoutData = new FormData();
            jsonEvaluatorGrouppBoxLayoutData.top = new FormAttachment(expressionGroup, 2);
            jsonEvaluatorGrouppBoxLayoutData.left = new FormAttachment(1);
            jsonEvaluatorGrouppBoxLayoutData.right = new FormAttachment(99);
            jsonEvaluatorGrouppBoxLayoutData.bottom = new FormAttachment(okButton, -5);
            jsonEvaluatorGroup.setLayoutData(jsonEvaluatorGrouppBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout jsonEvaluatorGroupBoxLayout = new FormLayout();
            jsonEvaluatorGroupBoxLayout.marginWidth = 5;
            jsonEvaluatorGroupBoxLayout.marginHeight = 5;
            jsonEvaluatorGroup.setLayout(jsonEvaluatorGroupBoxLayout);
            
            jsonEvaluatorGroup.setText("Evaluate JSON Path");
            jsonEvaluatorGroup.setVisible(false);
        }
        
        exprEvaluatorGroup = new Group(dialogShell, SWT.NONE);
        {   
        	FormData exprEvaluatorGroupBoxLayoutData = new FormData();
            exprEvaluatorGroupBoxLayoutData.top = new FormAttachment(expressionGroup, 2);
            exprEvaluatorGroupBoxLayoutData.left = new FormAttachment(1);
            exprEvaluatorGroupBoxLayoutData.right = new FormAttachment(99);
            exprEvaluatorGroupBoxLayoutData.bottom = new FormAttachment(okButton, -5);
            exprEvaluatorGroup.setLayoutData(exprEvaluatorGroupBoxLayoutData);
            
            // Configure group box internal layout.
            FormLayout exprEvaluatorGroupBoxLayout = new FormLayout();
            exprEvaluatorGroupBoxLayout.marginWidth = 5;
            exprEvaluatorGroupBoxLayout.marginHeight = 5;
            exprEvaluatorGroup.setLayout(exprEvaluatorGroupBoxLayout);
            
            exprEvaluatorGroup.setVisible(false);
        }
        
        exprBrowserView = new Browser(exprEvaluatorGroup, SWT.NONE);
        {
            FormData exprBrowserViewLayoutData = new FormData();
            exprBrowserViewLayoutData.top = new FormAttachment(2);
            exprBrowserViewLayoutData.left = new FormAttachment(1);
            exprBrowserViewLayoutData.right = new FormAttachment(99);
            exprBrowserViewLayoutData.bottom = new FormAttachment(99);
            exprBrowserView.setLayoutData(exprBrowserViewLayoutData);
            
            // Configure group box internal layout.
            FormLayout exprBrowserViewLayout = new FormLayout();
            exprBrowserViewLayout.marginWidth = 5;
            exprBrowserViewLayout.marginHeight = 5;
            exprBrowserView.setLayout(exprBrowserViewLayout);
            
        	URL url;
            try {
                url = new URL(EXPR_HELP_HTML_FILE_PATH);
                
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        		String inputLine = "";
        		String html = "";
        		
        		while ((inputLine = in.readLine()) != null) {
        			html += inputLine;
        		}
        		
        		exprBrowserView.setBounds(100, 100, 1000, 800);
        		exprBrowserView.setText(html);
        		in.close();
            } catch (IOException e) {
                log.error(e);
            }
		
        }
        
        xmlInputLabel = new Label(xmlEvaluatorGroup, SWT.NONE);
        {
            xmlInputLabel.setText(INPUT_LABEL_TEXT);
            FormData inputLabelLayoutData = new FormData();
            inputLabelLayoutData.top = new FormAttachment(0);
            inputLabelLayoutData.left = new FormAttachment(1);
            inputLabelLayoutData.right = new FormAttachment(45);
            xmlInputLabel.setLayoutData(inputLabelLayoutData);
            
            FontData fontData = xmlInputLabel.getFont().getFontData()[0];
            Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(),
            		16, SWT.BOLD));
            xmlInputLabel.setFont(font);
        }
        
        jsonInputLabel = new Label(jsonEvaluatorGroup, SWT.WRAP | SWT.BORDER);
        {
            jsonInputLabel.setText("JSON expression evaluation capabilities are not supported yet."
        			+ " However, you can still use JSON expressions in the integration flow.");
            FormData jsonInputLabelLayoutData = new FormData();
            jsonInputLabelLayoutData.top = new FormAttachment(expressionGroup, 5);
            jsonInputLabelLayoutData.left = new FormAttachment(1);
            jsonInputLabelLayoutData.right = new FormAttachment(99);
            jsonInputLabel.setLayoutData(jsonInputLabelLayoutData);
            
            FontData fontData = jsonInputLabel.getFont().getFontData()[0];
            Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(),
            		fontData.getHeight(), SWT.BOLD));
            jsonInputLabel.setFont(font);
            
            jsonInputLabel.setVisible(false);
        }
        
        // XML input type radio button group
        inputTypeRadioGroup = new Group(xmlEvaluatorGroup, SWT.NONE | SWT.CENTER);
        {   
            RowLayout inputTypeRadioGroupRowLayout = new RowLayout(SWT.HORIZONTAL);
            inputTypeRadioGroupRowLayout.wrap = true;
            inputTypeRadioGroupRowLayout.center = true;
            inputTypeRadioGroupRowLayout.marginRight = 0;
            inputTypeRadioGroupRowLayout.spacing = 10;
            inputTypeRadioGroup.setLayout(inputTypeRadioGroupRowLayout);
            
            FormData inputTypeRadioGroupLayout = new FormData();
            inputTypeRadioGroupLayout.top = new FormAttachment(xmlInputLabel, 5);
            inputTypeRadioGroupLayout.left = new FormAttachment(1);
            inputTypeRadioGroupLayout.right = new FormAttachment(48);
            inputTypeRadioGroup.setLayoutData(inputTypeRadioGroupLayout);
            
            inlineRadioButton = new Button(inputTypeRadioGroup, SWT.RADIO);
            inlineRadioButton.setText(INLINE_RADIO_BUTTON_TEXT);
            inlineRadioButton.setSelection(true);
            
            browseFileRadioButton = new Button(inputTypeRadioGroup, SWT.RADIO | SWT.RIGHT);
            browseFileRadioButton.setText(FILE_RADIO_BUTTON_TEXT);
            
            // Browse button.
            browseButton = new Button(inputTypeRadioGroup, SWT.BORDER);
            {
                browseButton.setText("Browse File");
                browseButton.setVisible(false);
            }
        }
        
        // Layout for XML tab content.
        xmlContentTabGroupBox = new Group(xmlEvaluatorGroup, SWT.NONE);
        {
            FormData xmlContentTabGroupBoxLayoutData = new FormData();
            xmlContentTabGroupBoxLayoutData.top = new FormAttachment(inputTypeRadioGroup, 5);
            xmlContentTabGroupBoxLayoutData.left = new FormAttachment(1);
            xmlContentTabGroupBoxLayoutData.right = new FormAttachment(48);
            xmlContentTabGroupBoxLayoutData.bottom = new FormAttachment(99);
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
        xmlContentTabFolder = new TabFolder(xmlContentTabGroupBox, SWT.BOTTOM | 
        		SWT.BORDER_SOLID | SWT.TRANSPARENT);
        
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
            inlineXMLTextArea.setCaretOffset(inlineXMLTextArea.getText().length());
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
 
        xmlOutputLabel = new Label(xmlEvaluatorGroup, SWT.NONE);
        {
            xmlOutputLabel.setText(OUTPUT_LABEL_TEXT);
            FormData outputLabelLayoutData = new FormData();
            outputLabelLayoutData.top = new FormAttachment(xmlEvaluatorGroup, 1);
            outputLabelLayoutData.left = new FormAttachment(60);
            outputLabelLayoutData.right = new FormAttachment(99);
            xmlOutputLabel.setLayoutData(outputLabelLayoutData);
            
            FontData fontData = xmlInputLabel.getFont().getFontData()[0];
            Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(),
            		16, SWT.BOLD));
            xmlOutputLabel.setFont(font);
        }
        
        // Evaluated output text area 
        outputXMLTextArea = new StyledText(xmlEvaluatorGroup, SWT.MULTI | SWT.BORDER | SWT.WRAP | 
                SWT.H_SCROLL | SWT.V_SCROLL | SWT.READ_ONLY);
        {
            FormData xmlTextAreaLayoutData = new FormData();
            xmlTextAreaLayoutData.top = new FormAttachment(xmlOutputLabel, 5);
            xmlTextAreaLayoutData.right = new FormAttachment(99);
            xmlTextAreaLayoutData.left = new FormAttachment(60);
            xmlTextAreaLayoutData.bottom = new FormAttachment(98);
            xmlTextAreaLayoutData.height = 90;
            
            outputXMLTextArea.setText(EMPTY_STRING);
            outputXMLTextArea.setLayoutData(xmlTextAreaLayoutData);
        }
        
        // Evaluate XPath button
        evaluateExpressionButton = new Button(xmlEvaluatorGroup, SWT.NONE);
        {
            evaluateExpressionButton.setText(EVALUATE_LABEL_TEXT);
            FormData evaluateXPathButtonLayoutData = new FormData();
            evaluateXPathButtonLayoutData.top = new FormAttachment(45);
            evaluateXPathButtonLayoutData.left = new FormAttachment(49);
            evaluateXPathButtonLayoutData.right = new FormAttachment(59);
            evaluateXPathButtonLayoutData.height = 50;
            evaluateExpressionButton.setLayoutData(evaluateXPathButtonLayoutData);
        }
        
        // Check if only XML expressions are enabled
        if (isXMLOnly) {
        	evalTypeComboBox.setEnabled(false);
        }
        
        xmlSourceTabItem.setControl(xmlContentGroupBox);
        xmlVisualTabItem.setControl(treeViewGroupBox);

        loadConfiguration();
        initActions();
        setTabOrder();

        // Open dialog.
        dialogShell.layout();
        dialogShell.pack();
        if (operatingSystemType.indexOf(OS_TYPE_WINDOWS) >= 0) {
            dialogShell.setSize(1050, 770);
        } else {
            dialogShell.setSize(1050, 700);
        }
        centerDialog();
        dialogShell.open();
        Display display = dialogShell.getDisplay();
        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        NamespacedProperty nsp = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        nsp.setPropertyValue(nsProperty.getPropertyValue());
        nsp.setPropertyName(nsProperty.getPropertyName());
        nsp.setNamespaces(nsProperty.getNamespaces());
        return nsp;
    }

    private void loadConfiguration() {
        dialogShell.setText(String.format(EDITOR_TITLE, nsProperty.getPrettyName()));
        if (!StringUtils.isBlank(nsProperty.getPropertyValue())) {
            expressionTextField.setText(nsProperty.getPropertyValue());
        }

        // Load namespaces.
        for (Entry<String, String> nsEntry : nsProperty.getNamespaces().entrySet()) {
            addNamespace(nsEntry.getKey(), nsEntry.getValue());
        }
        
    }

    private void initActions() {
        
        addButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                String prefix = nsPrefixTextField.getText();
                String uri = nsUriTextField.getText();
                if (EEFXpathValidator.isValidNamespace(dialogShell, collectedNamespaces, prefix, uri)) {
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
                if (EEFXpathValidator.isValidConfiguration(dialogShell, expressionTextField.getText(),
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
        
        evalTypeComboBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (evalTypeComboBox.getSelectionIndex() == 0) {
					setXMLEvaluatorElementsVisibility(true);
					setJSONEvaluatorElementsVisibility(false);
					setExprEvaluatorElementsVisibility(false);
					
			        if (operatingSystemType.indexOf(OS_TYPE_WINDOWS) >= 0) {
			            dialogShell.setSize(1050, 870);
			        } else {
			            dialogShell.setSize(1050, 800);
			        }
					
				} else if (evalTypeComboBox.getSelectionIndex() == 1) {
					// Set the visibility to 'false' intentionally.
					// Can be made visible once JSON path evaluation
					// features are added.
					setJSONEvaluatorElementsVisibility(false);
					
					setXMLEvaluatorElementsVisibility(false);
					setExprEvaluatorElementsVisibility(false);
					
					dialogShell.layout(true, true);
					dialogShell.setSize(new Point(1050, 140));
					
				} else {
					setExprEvaluatorElementsVisibility(true);
					setXMLEvaluatorElementsVisibility(false);
					setJSONEvaluatorElementsVisibility(false);
					
					dialogShell.layout(true, true);
					dialogShell.setSize(new Point(1050, 800));
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
			
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
                                    final Document document = parseDocument(selectedFile);
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
                                            final String xmlFileContentStr = xPathValidator.getFormattedXMLStringFromDoc(document);
                                            inlineXMLTextArea.setText(xmlFileContentStr);
                                            infoLabel.setText(TREE_VIEW_INFO_LABEL_TEXT);
                                            isCurrentXMLContentValid = true;
                                            isInlineXMLTextAreaDirty = true;
                                            
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
                expressionTextField.setText(XSLTXPathHelper.calculateXPathToNode(treeItemData.getDomNode()));
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
                if(source.getSelection())  {
                    expressionTextField.setText(EMPTY_STRING);
                    outputXMLTextArea.setText(EMPTY_STRING);
                    infoLabel.setText(INFO_LABEL_DEFAULT_TEXT);
                    
                    browseButton.setVisible(false);
                    
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
                if(source.getSelection())  {
                    browseButton.setVisible(true);
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
        
        inlineXMLTextArea.addFocusListener(new org.eclipse.swt.events.FocusListener() {
            
            @Override
            public void focusLost(org.eclipse.swt.events.FocusEvent e) {
                
                final String xmlText = inlineXMLTextArea.getText().trim();
                
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
                                final Document document = xPathValidator.parseXML(xmlText);
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
            
            @Override
            public void focusGained(org.eclipse.swt.events.FocusEvent e) {}

        });
        
        inlineXMLTextArea.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseDown(MouseEvent e) {
                if (!isInlineXMLTextAreaDirty) {
                    inlineXMLTextArea.setText(EMPTY_STRING);
                }
                isInlineXMLTextAreaDirty = true;
            }
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
        });
        
        inlineXMLTextArea.addKeyListener(new KeyListener() {
            
            @Override
            public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
                if (!isInlineXMLTextAreaDirty) {
                    inlineXMLTextArea.setText(inlineXMLTextArea.getText().replaceFirst(XML_CONTENT_PLACEHOLDER_TEXT, EMPTY_STRING));
                    inlineXMLTextArea.setCaretOffset(inlineXMLTextArea.getText().length());
                }
                isInlineXMLTextAreaDirty = true;
            }
            
            @Override
            public void keyReleased(org.eclipse.swt.events.KeyEvent e) {}
           
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
        evaluateExpressionButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                outputXMLTextArea.setText(EMPTY_STRING);
                
                if (xPathValidator.isValidXML(inlineXMLTextArea.getText().trim())) {
                    String outputStr = xPathValidator.getEvaluatedResult(inlineXMLTextArea.getText().trim(),
                            expressionTextField.getText().trim(), nameSpaces);
                    
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
        dialogShell.setLocation(new Point(centerX, centerY + 85)); //adding a constant number of pixels to avoid removing borders
    }

    private void setTabOrder() {
        Control[] tabOrder = new Control[] { nsPrefixTextField, nsUriTextField, addButton };
  
        namespacesGroupBox.setTabList(tabOrder);

        tabOrder = new Control[] { okButton };
        dialogShell.setTabList(tabOrder);
        
        tabOrder = new Control[] { xmlContentGroupBox, treeViewGroupBox };
        xmlContentTabFolder.setTabList(tabOrder);
    }

    private void saveConfiguration() throws Exception {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(nsProperty);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

            @Override
            protected void doExecute() {
                nsProperty.setPropertyValue(expressionTextField.getText());
                nsProperty.getNamespaces().clear();
                nsProperty.getNamespaces().putAll(collectedNamespaces);
            }
        });
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
/*        if (node.getNodeType() == Node.ELEMENT_NODE) {
            childTreeItem.setImage(ImageHolder.getInstance().getXPathElementImage());
        } else {
            childTreeItem.setImage(ImageHolder.getInstance().getXPathAttributeImage());
        }*/

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
    
    private void setXMLEvaluatorElementsVisibility(boolean isVisible) {
    	xmlInputLabel.setVisible(isVisible);
    	inputTypeRadioGroup.setVisible(isVisible);
    	xmlOutputLabel.setVisible(isVisible);
    	outputXMLTextArea.setVisible(isVisible);
    	evaluateExpressionButton.setVisible(isVisible);
    	namespacesGroupBox.setVisible(isVisible);
    	xmlEvaluatorGroup.setVisible(isVisible);
    }
    
    private void setJSONEvaluatorElementsVisibility(boolean isVisible) {
    	jsonEvaluatorGroup.setVisible(isVisible);
    	jsonInputLabel.setVisible(isVisible);
    }
    
    private void setExprEvaluatorElementsVisibility(boolean isVisible) {
    	exprEvaluatorGroup.setVisible(isVisible);
    }
    
    private Map<String, String> getNameSpaces() {
        return nameSpaces;
    }
}
