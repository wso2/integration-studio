package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

public class ConfigureProxyWSDLResourceDialog extends Dialog {
	
	ProxyService proxyService;
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
	private Table resourcesTable;
	/**
	 * Table Editors
	 */
	private TableEditor keyEditor;
	private TableEditor locationEditor;
	/**
	 * Table widgets
	 */
	private PropertyText resourceKey;
	private Text txtLocation;
	private Text txtKey;
	/**
	 * Button for add new parameter.
	 */
	private Button newResourceButton;
	/**
	 * Button for remove parameter.
	 */
	private Button removeResourceButton;
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;


	public ConfigureProxyWSDLResourceDialog(Shell parentShell, ProxyService proxyService) {
		super(parentShell);
		this.proxyService=proxyService;
		editingDomain = TransactionUtil.getEditingDomain(proxyService);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// Button for add new WSDL Resource.
		newResourceButton = new Button(container, SWT.NONE);
		newResourceButton.setText("New...");
		FormData newWSDLResourceButtonLayoutData = new FormData(80, SWT.DEFAULT);
		newWSDLResourceButtonLayoutData.right = new FormAttachment(100);
		newResourceButton.setLayoutData(newWSDLResourceButtonLayoutData);

		newResourceButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = bindPram(EsbFactory.eINSTANCE
						.createProxyWSDLResource());
				resourcesTable.select(resourcesTable.indexOf(item));
			}
		});

		// Button for remove parameter.
		removeResourceButton = new Button(container, SWT.NONE);
		removeResourceButton.setText("Remove");
		FormData removeWSDLResourceButtonLayoutData = new FormData();
		removeWSDLResourceButtonLayoutData.top = new FormAttachment(
				newResourceButton, 5);
		removeWSDLResourceButtonLayoutData.right = new FormAttachment(100);
		removeWSDLResourceButtonLayoutData.left = new FormAttachment(
				newResourceButton, 0, SWT.LEFT);
		removeResourceButton.setLayoutData(removeWSDLResourceButtonLayoutData);

		removeResourceButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = resourcesTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					initTableEditor(keyEditor, resourcesTable);
					initTableEditor(locationEditor, resourcesTable);
					unbindParam(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < resourcesTable.getItemCount()) {
						resourcesTable.select(selectedIndex);
					} else {
						resourcesTable.select(selectedIndex - 1);
					}
				}
			}
		});

		// Table for show the parameters.
		resourcesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn keyColumn = new TableColumn(resourcesTable, SWT.LEFT);
		TableColumn locationColumn = new TableColumn(resourcesTable, SWT.LEFT);
		keyColumn.setText("Key");
		keyColumn.setWidth(150);
		locationColumn.setText("Location");
		locationColumn.setWidth(200);

		resourcesTable.setHeaderVisible(true);
		resourcesTable.setLinesVisible(true);

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

		resourcesTable.addListener(SWT.Selection, tblPropertiesListener);

		// Populate params
		for (ProxyWSDLResource param : proxyService.getWsdlResources()) {
			bindPram(param);
		}

		//setupTableEditor(paramTable);

		FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
		logPropertiesTableLayoutData.top = new FormAttachment(newResourceButton,
				0, SWT.TOP);
		logPropertiesTableLayoutData.left = new FormAttachment(0);
		logPropertiesTableLayoutData.right = new FormAttachment(newResourceButton,
				-5);
		logPropertiesTableLayoutData.bottom = new FormAttachment(100);
		resourcesTable.setLayoutData(logPropertiesTableLayoutData);

		return parent;

	}

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 *            table against which a table editor is setup.
	 */
	@Deprecated
	private void setupTableEditor(final Table table) {
		final TableEditor cellEditor = new TableEditor(table);
		cellEditor.grabHorizontal = true;
		cellEditor.minimumWidth = 50;
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Setup a new cell editor control at double click event.
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// Dispose the old editor control (if one is setup).
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();

				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item)
					return;

				// Determine which column was selected.
				int selectedColumn = -1;
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}

				// Setup a new editor control.
				if (-1 != selectedColumn) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							cellEditor.getItem().setText(editorControlColumn,
									text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}
			}

			/**
			 * Dispose cell editor control at mouse down (otherwise the control
			 * keep showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();
			}
		});
	}

	private void editItem(final TableItem item) {
		RegistryKeyProperty registryKey= (RegistryKeyProperty) item.getData("key");
		
		locationEditor = initTableEditor(locationEditor, item.getParent());
		txtLocation = new Text(item.getParent(), SWT.NONE);
		txtLocation.setText((String) item.getData("location"));
		locationEditor.setEditor(txtLocation, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		txtLocation.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
//				item.setText(0,txtLocation.getText());
				((ProxyWSDLResource)item.getData()).setLocation(txtLocation.getText());
				item.setData("location", txtLocation.getText());
			}
		});
		
		
		keyEditor = initTableEditor(keyEditor,
				item.getParent());
		
		resourceKey = new PropertyText(item.getParent(), SWT.NONE);
		resourceKey.addProperties(registryKey,item.getText());
		keyEditor.setEditor(resourceKey, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		resourceKey.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(resourceKey.getText());
				Object property = resourceKey.getProperty();
				if(property instanceof RegistryKeyProperty){
					((ProxyWSDLResource)item.getData()).setKey((RegistryKeyProperty)property);
					item.setData("key",(RegistryKeyProperty)property);
				} 
			}
		});
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

	private TableItem bindPram(ProxyWSDLResource param) {
		TableItem item = new TableItem(resourcesTable, SWT.NONE);
		item.setText(0,param.getKey().getKeyValue());
		item.setText(1, param.getLocation());
		item.setData(param);
		item.setData("key", param.getKey());
		item.setData("location", param.getLocation());
		return item;
	}

	private void unbindParam(int itemIndex) {
		TableItem item = resourcesTable.getItem(itemIndex);
		ProxyWSDLResource param = (ProxyWSDLResource) item.getData();
		if (param.eContainer() != null) {
			RemoveCommand removeCmd = new RemoveCommand(
					editingDomain,
					proxyService,
					EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES,
					param);
			getResultCommand().append(removeCmd);
		}

		resourcesTable.remove(resourcesTable.indexOf(item));
	}

	protected void okPressed() {

		for (TableItem item : resourcesTable.getItems()) {

			ProxyWSDLResource resource = (ProxyWSDLResource) item
			.getData();
			
			if (resource.eContainer() == null) {
				
				//SetCommand setCmd=new SetCommand(editingDomain, proxyService, EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES, resource);
				AddCommand addCmd = new AddCommand(
						editingDomain,
						proxyService,
						EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES,
						resource);
				getResultCommand().append(addCmd);

			} else {

				if (!resource.getKey().getKeyValue().equals(item.getText(0))) {

					SetCommand setCmd = new SetCommand(
							editingDomain,
							resource,
							EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES,
							item.getText(0));

					getResultCommand().append(setCmd);
				}
				
				if (!resource.getLocation().equals(item.getText(1))) {

					SetCommand setCmd = new SetCommand(
							editingDomain,
							resource,
							EsbPackage.Literals.PROXY_SERVICE__WSDL_RESOURCES,
							item.getText(1));

					getResultCommand().append(setCmd);
				}

			}

		}
		
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}

		super.okPressed();

	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

}
