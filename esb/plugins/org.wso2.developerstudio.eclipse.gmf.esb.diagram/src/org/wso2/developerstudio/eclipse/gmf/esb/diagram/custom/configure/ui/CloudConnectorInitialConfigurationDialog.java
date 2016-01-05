package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.extensions.CustomPaletteToolTransferDropTargetListener;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.factory.LocalEntryFileCreator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
//import org.wso2.developerstudio.eclipse.artifact.localentry.model.LocalEntryModel;

public class CloudConnectorInitialConfigurationDialog extends TitleAreaDialog {
	
	private String droppedCloudConnector;
	private String droppedCloudConnectorComponentName;	

	/**
     * Value type constant.
     */
	private static final String VALUE_TYPE = "Value";
	/**
	 * Expression type constant.
	 */
	private static final String EXPRESSION_TYPE = "Expression";
	/**
	 * Table for add/edit/remove parameters.
	 */
	private Table paramTable;
	
	protected static final OMFactory fac = OMAbstractFactory.getOMFactory();
	protected static final OMNamespace synNS = SynapseConstants.SYNAPSE_OMNAMESPACE;
	private final String connectorProperties = "cloudConnector.properties";
	private final String configNameSeparator = "::";
	private final String configExistsErrorMessage = "Connector configuration already exists";
	private final String emptyNameErrorMessage = "Configuration name cannot be empty";

	private static String operationName = "init";
	
	private CloudConnectorOperation operation;
	
	private TableEditor paramTypeEditor;
	private TableEditor paramNameEditor;
	private TableEditor paramValueEditor;
	
	private Combo cmbParamType;
	private Text txtParamName;
	private PropertyText paramValue;
	
	private Text nameText;
	private Label configurationNameLabel;
	private String configName;
	private Collection<String> parameters;
	//private Label saveOptionLabel;
	private Combo saveOptionCombo;
	
	private List<String> availableConfigs;
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public CloudConnectorInitialConfigurationDialog(Shell parent,CloudConnectorOperation operation,Collection<String> parameters) {
		super(parent);
		this.parameters=parameters;
		this.operation=operation;
		//parent.setText("Connector Configuration.");
	}	
	
	public String getDroppedCloudConnectorComponentName() {
		return droppedCloudConnectorComponentName;
	}

	public void setDroppedCloudConnectorComponentName(String droppedCloudConnectorComponentName) {
		this.droppedCloudConnectorComponentName = droppedCloudConnectorComponentName;
	}
	
    private String getDroppedCloudConnector() {
		return droppedCloudConnector;
	}

	public void setDroppedCloudConnector(String droppedCloudConnector) {
		this.droppedCloudConnector = droppedCloudConnector;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		/*FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);*/
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		configurationNameLabel = new Label(container, SWT.NONE);
		{
			configurationNameLabel.setText("Name: ");
			/*FormData logCategoryLabelLayoutData = new FormData(80,SWT.DEFAULT);
			logCategoryLabelLayoutData.top = new FormAttachment(0, 10);
			logCategoryLabelLayoutData.left = new FormAttachment(0);
			configurationNameLabel.setLayoutData(logCategoryLabelLayoutData);*/
			configurationNameLabel.setBounds(10, 10, 50, 25);
		}
			
		// Text box for add new parameter.
		nameText = new Text(container, SWT.NONE);
		{
			/*FormData logCategoryLabelLayoutData = new FormData(160,SWT.DEFAULT);
			logCategoryLabelLayoutData.top = new FormAttachment(
					configurationNameLabel, 0, SWT.CENTER);
			logCategoryLabelLayoutData.left = new FormAttachment(
					configurationNameLabel, 5);
			nameText.setLayoutData(logCategoryLabelLayoutData);*/
			nameText.setBounds(65, 10, 250, 25);
		}
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				configName=nameText.getText();
				//CustomPaletteToolTransferDropTargetListener.definedName=nameText.getText();
				if (StringUtils.isNotBlank(configName)) {
					if (availableConfigs.contains(configName)) {
						setErrorMessage(configExistsErrorMessage);
						updateOKButtonStatus(false);
					} else {
						setErrorMessage(null);
						updateOKButtonStatus(true);
					}
				} else {
					setErrorMessage(emptyNameErrorMessage);
					updateOKButtonStatus(false);
				}
			}
		});
		
		
/*		saveOptionLabel = new Label(container, SWT.NONE);
		{
			saveOptionLabel.setText("Save as : ");
			FormData logCategoryLabelLayoutData1 = new FormData(80,SWT.DEFAULT);
			logCategoryLabelLayoutData1.top = new FormAttachment(configurationNameLabel, 20);
			logCategoryLabelLayoutData1.left = new FormAttachment(0);
			saveOptionLabel.setLayoutData(logCategoryLabelLayoutData1);
		}
		
		saveOptionCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		{
			saveOptionCombo.add("Inline Config");
			saveOptionCombo.add("Sequence Config");
			saveOptionCombo.select(0);
			FormData logCategoryComboLayoutData = new FormData(160,SWT.DEFAULT);
			logCategoryComboLayoutData.top = new FormAttachment(
					saveOptionLabel, 0, SWT.CENTER);
			logCategoryComboLayoutData.left = new FormAttachment(
					saveOptionLabel, 5);
			saveOptionCombo.setLayoutData(logCategoryComboLayoutData);
		}*/

		// Table for show the parameters.
		paramTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);
		paramTable.setBounds(10, 50, 600, 200);

		TableColumn nameColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn typeColumn = new TableColumn(paramTable, SWT.LEFT);
		nameColumn.setText("Parameter Name");
		nameColumn.setWidth(200);
		valueColumn.setText("Value/Expression");
		valueColumn.setWidth(250);
		typeColumn.setText("Parameter Type");
		typeColumn.setWidth(150);

		paramTable.setHeaderVisible(true);
		paramTable.setLinesVisible(true);

		Listener tblPropertiesListener = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						editItem(item);
					}
				}
			}
		};

		paramTable.addListener(SWT.Selection, tblPropertiesListener);

		if (parameters != null) {
			for (String param : parameters) {
				CallTemplateParameter callTemplateParameter=EsbFactory.eINSTANCE.createCallTemplateParameter();
				callTemplateParameter.setParameterName(param);
				callTemplateParameter.setParameterValue("");
				callTemplateParameter.setTemplateParameterType(RuleOptionType.VALUE);
				bindPram(callTemplateParameter);
			}
		}

		//setupTableEditor(paramTable);

		/*FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
		logPropertiesTableLayoutData.top = new FormAttachment(configurationNameLabel, 20);
		logPropertiesTableLayoutData.left = new FormAttachment(0);
		logPropertiesTableLayoutData.bottom = new FormAttachment(100);
		paramTable.setLayoutData(logPropertiesTableLayoutData);*/
		
		availableConfigs = getAvailableConfigs();
		
		return parent;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Connector Configuration");
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(630, 400);
	}
	
	private TableItem bindPram(CallTemplateParameter param) {
		TableItem item = new TableItem(paramTable, SWT.NONE);
		if (param.getTemplateParameterType().getLiteral().equals(VALUE_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getParameterValue(),
					param.getTemplateParameterType().getLiteral() });
		}
		if (param.getTemplateParameterType().getLiteral()
				.equals(EXPRESSION_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getParameterExpression().getPropertyValue(),
					param.getTemplateParameterType().getLiteral()});
		}

		item.setData(param);
		item.setData("exp", EsbFactory.eINSTANCE.copyNamespacedProperty(param.getParameterExpression()));
		return item;
	}
	
	private TableEditor initTableEditor(TableEditor editor, Table table) {
		if (null != editor) {
			Control lastCtrl = editor.getEditor();
			if (null != lastCtrl) {
				lastCtrl.dispose();
			}
		}
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		return editor;
	}
	
	private void editItem(final TableItem item) {
		
		NamespacedProperty expression = (NamespacedProperty)item.getData("exp");
		
		paramNameEditor = initTableEditor(paramNameEditor, item.getParent());
		txtParamName = new Text(item.getParent(), SWT.NONE);
		txtParamName.setText(item.getText(0));
		paramNameEditor.setEditor(txtParamName, item, 0);
		txtParamName.setEditable(false);
		item.getParent().redraw();
		item.getParent().layout();
		txtParamName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0,txtParamName.getText());
			}
		});
		
		paramTypeEditor = initTableEditor(paramTypeEditor,
				item.getParent());
		cmbParamType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbParamType.setItems(new String[] { VALUE_TYPE, EXPRESSION_TYPE });
		cmbParamType.setText(item.getText(2));
		paramTypeEditor.setEditor(cmbParamType, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		cmbParamType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(2, cmbParamType.getText());
			}
		});
		
		paramValueEditor = initTableEditor(paramValueEditor,
				item.getParent());
		
		paramValue = new PropertyText(item.getParent(), SWT.NONE, cmbParamType);
		paramValue.addProperties(item.getText(1),expression);
		paramValueEditor.setEditor(paramValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		paramValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(1,paramValue.getText());
				Object property = paramValue.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("exp",(NamespacedProperty)property);
				} 
			}
		});
	}
	
    private void serializeParams(OMElement invokeElem) {
    	OMElement connectorEl = fac.createOMElement(getDroppedCloudConnectorComponentName()+"."+operationName,synNS);
    	for(int i=0;i<paramTable.getItems().length;++i){
    		TableItem tableItem=paramTable.getItems()[i];
    		CallTemplateParameter callTemplateParameter=(CallTemplateParameter) tableItem.getData();    		
            if (!"".equals(callTemplateParameter.getParameterName())) {
                OMElement paramEl = fac.createOMElement(callTemplateParameter.getParameterName(),
                                                        synNS);
                paramEl.setText(tableItem.getText(1));
               // new ValueSerializer().serializeValue(value, "value", paramEl);
                connectorEl.addChild(paramEl);
            }
        }
    	invokeElem.addChild(connectorEl);
    }
    
    /**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		updateOKButtonStatus(false);
	}
    
    private void updateOKButtonStatus(boolean status) {
    	getButton(IDialogConstants.OK_ID).setEnabled(status);
    }
	
	
	@Override
	protected void okPressed() {
        IContainer location = EditorUtils.getActiveProject().getFolder("src" + File.separator + "main"
				+ File.separator + "synapse-config" + File.separator
				+ "local-entries");		
			
		try {
			
			LocalEntryFileCreator localEntryFileCreator = new LocalEntryFileCreator();
			String content="<?xml version=\"1.0\" encoding=\"UTF-8\"?><localEntry xmlns=\"http://ws.apache.org/ns/synapse\" key=\""+configName+"\"/>";
			
			OMElement payload = AXIOMUtil.stringToOM(content); 
			serializeParams(payload);			
			localEntryFileCreator.createLocalEntryFile(payload.toString(), location, configName);
		} catch (Exception e) {
			log.error("Error occured while creating the Local entry file", e);
		}
		
		
		/**
		 *  put a entry in cloudConnector.properties file
		 */
		
		String pathName=EditorUtils.getActiveProject().getLocation().toOSString()+File.separator+"resources";
		File resources=new File(pathName);
		try {
			resources.mkdir();
			File cloudConnectorConfig = new File(pathName + File.separator + connectorProperties);
			cloudConnectorConfig.createNewFile();

			Properties prop = new Properties();
			prop.load(new FileInputStream(pathName + File.separator + connectorProperties));
			String localEntryConfigs = prop.getProperty("LOCAL_ENTRY_CONFIGS");
			if (localEntryConfigs == null || "".equals(localEntryConfigs)) {
				prop.setProperty("LOCAL_ENTRY_CONFIGS", configName + configNameSeparator
						+ getDroppedCloudConnector());
			} else {
				prop.setProperty("LOCAL_ENTRY_CONFIGS", localEntryConfigs + "," + configName
						+ configNameSeparator + getDroppedCloudConnector());
			}
			prop.setProperty("INLINE_CONFIGS", "");
			prop.store(new FileOutputStream(cloudConnectorConfig.getAbsolutePath()), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		Display.getCurrent().asyncExec(new Runnable() {			
			public void run() {
				IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getEditorReferences();
				IEditorPart activeEditor=PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
				for (int i = 0; i < editorReferences.length; i++) {
					IEditorPart editor = editorReferences[i].getEditor(false);
					if ((editor instanceof EsbMultiPageEditor)) {
				        
				         * This must be altered. 'addDefinedSequences' and 'addDefinedEndpoints' methods should not exist inside EsbPaletteFactory class. 
				         * Creating new instance of 'EsbPaletteFactory' must be avoided.
				         
						EsbPaletteFactory esbPaletteFactory=new EsbPaletteFactory();
						if(!editor.equals(activeEditor)){					        
					        //esbPaletteFactory.addDefinedSequences(((EsbMultiPageEditor) editor).getGraphicalEditor());
					        //esbPaletteFactory.addDefinedEndpoints(((EsbMultiPageEditor) editor).getGraphicalEditor());					        
						}else{
							//esbPaletteFactory.addCloudConnectorOperations(((EsbMultiPageEditor) editor).getGraphicalEditor(),configName,getDroppedCloudConnector());
						}
					}
				}
			}
		});*/
		
		
		
		
		SetCommand setCmd = new SetCommand(TransactionUtil.getEditingDomain(operation), operation,
				EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONFIG_REF,
				configName);
		if(setCmd.canExecute()){
			TransactionUtil.getEditingDomain(operation).getCommandStack().execute(setCmd);
		}
		
		super.okPressed();
	}
	
	/**
	 * Get available configurations for the given connector.
	 * @return available configurations 
	 */
	private ArrayList<String> getAvailableConfigs() {
		ArrayList<String> availableConfigs = new ArrayList<String>();
		
		String pathName = EditorUtils.getActiveProject().getLocation().toOSString()+File.separator+"resources";
		File resources = new File(pathName);
		
		if (resources.exists()) {
			File connectorConfig = new File(pathName + File.separator + connectorProperties);
			if (connectorConfig.exists()) {
				Properties prop = new Properties();
				try {
					prop.load(new FileInputStream(pathName + File.separator + connectorProperties));
					String localEntryConfigs = prop.getProperty("LOCAL_ENTRY_CONFIGS");
					if (localEntryConfigs != null) {
						String[] configs = localEntryConfigs.split(",");

						for (int i = 0; i < configs.length; ++i) {
							if (!"".equals(configs[i])) {
								availableConfigs.add(configs[i].split(configNameSeparator)[0]);
							}
						}
					}
					
				} catch (FileNotFoundException e) {
					//e.printStackTrace();
				} catch (IOException e) {
					//e.printStackTrace();
				}			
			}
		}
		
		return availableConfigs;
	}
	
}
