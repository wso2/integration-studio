package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

public class ConfigureProxyPolicyDialog extends Dialog{

	ProxyService proxyService=null;
	private Button newPolicyButton;
	private Button removePolicyButton;
	private Table policyTable;
	private TransactionalEditingDomain editingDomain;
	private CompoundCommand resultCommand;
	private Combo cmbPolicyType;
	private TableEditor valueEditor;
	private PropertyText txtValue;
	
	private final static String LITERAL_KEY = "Key";
	
	public ConfigureProxyPolicyDialog(Shell parentShell, ProxyService proxyService) {
		super(parentShell);
		this.proxyService=proxyService;
		editingDomain = TransactionUtil.getEditingDomain(proxyService);
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		newPolicyButton = new Button(container, SWT.NONE);
		newPolicyButton.setText("New...");
		FormData newPolicyButtonLayoutData = new FormData(80, SWT.DEFAULT);
		newPolicyButtonLayoutData.right = new FormAttachment(100);
		newPolicyButton.setLayoutData(newPolicyButtonLayoutData);

		newPolicyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = bindPram(EsbFactory.eINSTANCE
						.createProxyServicePolicy());
				policyTable.select(policyTable.indexOf(item));
			}
		});

		removePolicyButton = new Button(container, SWT.NONE);
		removePolicyButton.setText("Remove");
		FormData removePolicyButtonLayoutData = new FormData();
		removePolicyButtonLayoutData.top = new FormAttachment(
				newPolicyButton, 5);
		removePolicyButtonLayoutData.right = new FormAttachment(100);
		removePolicyButtonLayoutData.left = new FormAttachment(
				newPolicyButton, 0, SWT.LEFT);
		removePolicyButton.setLayoutData(removePolicyButtonLayoutData);

		removePolicyButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = policyTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					initTableEditor(valueEditor,policyTable);
					unbindParam(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < policyTable.getItemCount()) {
						policyTable.select(selectedIndex);
					} else {
						policyTable.select(selectedIndex - 1);
					}
				}
			}
		});

		policyTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn keyColumn = new TableColumn(policyTable, SWT.LEFT);
		keyColumn.setText("Policy Key");
		keyColumn.setWidth(350);

		policyTable.setHeaderVisible(true);
		policyTable.setLinesVisible(true);

		Listener tblPolicyListener = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						editItem(item);
					}
				}
			}
		};

		policyTable.addListener(SWT.Selection, tblPolicyListener);

		for (ProxyServicePolicy policy : proxyService.getServicePolicies()) {
			bindPram(policy);
		}

		FormData proxyPolicyTableLayoutData = new FormData(SWT.DEFAULT, 150);
		proxyPolicyTableLayoutData.top = new FormAttachment(newPolicyButton,
				0, SWT.TOP);
		proxyPolicyTableLayoutData.left = new FormAttachment(0);
		proxyPolicyTableLayoutData.right = new FormAttachment(newPolicyButton,
				-5);
		proxyPolicyTableLayoutData.bottom = new FormAttachment(100);
		policyTable.setLayoutData(proxyPolicyTableLayoutData);

		return parent;

	}
	
	protected void okPressed() {
		for (TableItem item : policyTable.getItems()) {
			ProxyServicePolicy policies = (ProxyServicePolicy) item.getData();	
			if (policies.eContainer() == null) {
				AddCommand addCmd = new AddCommand(
						editingDomain,
						proxyService,
						EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES,
						policies);
				getResultCommand().append(addCmd);
			}
		}		
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
		super.okPressed();

	}
	
	protected void editItem(final TableItem item) {
		
		final ProxyServicePolicy policy=  (ProxyServicePolicy) item.getData();
		cmbPolicyType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPolicyType.setItems(new String[] {LITERAL_KEY });
		cmbPolicyType.select(0);
		valueEditor = initTableEditor(valueEditor,item.getParent());
		
		txtValue = new PropertyText(item.getParent(), SWT.NONE, cmbPolicyType);
		txtValue.addProperties(policy.getPolicyKey());
		valueEditor.setEditor(txtValue, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(0,txtValue.getText());
				Object property = txtValue.getProperty();
				if(property instanceof RegistryKeyProperty){
					policy.setPolicyKey((RegistryKeyProperty)property);
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
	
	private TableItem bindPram(ProxyServicePolicy policy) {
		TableItem item = new TableItem(policyTable, SWT.NONE);
		item.setText(0,policy.getPolicyKey().getKeyValue());
		item.setData(policy);
		item.setData("key", policy.getPolicyKey());
		return item;
	}

	private void unbindParam(int itemIndex) {
		TableItem item = policyTable.getItem(itemIndex);
		ProxyServicePolicy policy = (ProxyServicePolicy) item.getData();
		if (policy.eContainer() != null) {
			RemoveCommand removeCmd = new RemoveCommand(
					editingDomain,
					proxyService,
					EsbPackage.Literals.PROXY_SERVICE__SERVICE_POLICIES,
					policy);
			getResultCommand().append(removeCmd);
		}

		policyTable.remove(policyTable.indexOf(item));
	}
	
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

}
