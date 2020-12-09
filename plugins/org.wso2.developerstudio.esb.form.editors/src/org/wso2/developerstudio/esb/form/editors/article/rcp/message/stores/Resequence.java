package org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamespacedPropertyEditorDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class Resequence implements IMessageStore {

	public Text resequence_dbTable;
	public Combo resequence_connectionInfo;
	public Text resequence_driver;
	public Label lbl_resequence_driver;
	public Text resequence_url;
	public Label lbl_resequence_url;
	public Text resequence_username;
	public Label lbl_resequence_username;
	public Text resequence_password;
	public Label lbl_resequence_password;
	public Text resequence_poll_count;
	public Label lbl_resequence_poll_count;
	public Text resequence_xpath;
	public Button resequence_path_namespaces;
	public String prettyXpathName;
	public Label lbl_resequence_xpath;
	public NamespacedProperty nsp;
	public Text resequence_DsName;
	public Label lbl_resequence_DsName;

	private AbstractEsbFormPage esbFormPage;

	ScrolledForm form;
	FormToolkit toolkit;

	Section connSection;
	Section parameterSection;

	public Resequence(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
		this.form = form;
		this.toolkit = toolkit;
		this.esbFormPage = esbFormPage;
		this.nsp = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
	}

	@Override
	public void createConnectionSectionFields() {

		connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));

		Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new GridLayout());
		connSection.setClient(connSectionClient);

		connSection.setVisible(false);

		GridData taskImplGridData = new GridData();
		taskImplGridData.horizontalSpan = 3;
		taskImplGridData.horizontalAlignment = GridData.FILL;
		taskImplGridData.grabExcessHorizontalSpace = true;
		connSection.setLayoutData(taskImplGridData);

		toolkit.createLabel(connSectionClient, "Resequence Database Table");
		resequence_dbTable = toolkit.createText(connSectionClient, "");
		resequence_dbTable.setBackground(new Color(null, 229, 236, 253));
		GridData resequence_dbTableGridData = new GridData();
		resequence_dbTableGridData.horizontalSpan = 3;
		resequence_dbTableGridData.horizontalAlignment = GridData.FILL;
		resequence_dbTableGridData.grabExcessHorizontalSpace = true;
		resequence_dbTable.setLayoutData(resequence_dbTableGridData);
		resequence_dbTable.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(connSectionClient, "Resequence Polling Count");
		resequence_poll_count = toolkit.createText(connSectionClient, "");
		resequence_poll_count.setBackground(new Color(null, 229, 236, 253));
		GridData resequence_pollinCountGridData = new GridData();
		resequence_pollinCountGridData.horizontalSpan = 3;
		resequence_pollinCountGridData.horizontalAlignment = GridData.FILL;
		resequence_pollinCountGridData.grabExcessHorizontalSpace = true;
		resequence_poll_count.setLayoutData(resequence_pollinCountGridData);
		resequence_poll_count.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(connSectionClient, "Resequence Path");
		resequence_xpath = toolkit.createText(connSectionClient, "");
		resequence_xpath.setBackground(new Color(null, 229, 236, 253));
		GridData resequence_xpathGridData = new GridData();
		resequence_xpathGridData.horizontalSpan = 3;
		resequence_xpathGridData.horizontalAlignment = GridData.FILL;
		resequence_xpathGridData.grabExcessHorizontalSpace = true;
		resequence_xpath.setLayoutData(resequence_xpathGridData);
		resequence_xpath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		resequence_path_namespaces = toolkit.createButton(connSectionClient, " Add Resequence path namespace",
				SWT.PUSH);
		resequence_path_namespaces.setBackground(new Color(null, 229, 236, 253));
		resequence_path_namespaces.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				NamespacedPropertyEditorDialog paramDialog = new NamespacedPropertyEditorDialog(shell, SWT.NULL, nsp);
				if (!StringUtils.isBlank(resequence_xpath.getText())) {
					nsp.setPropertyValue(resequence_xpath.getText());
				}
				paramDialog.open();
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		toolkit.createLabel(connSectionClient, "Resequence Connection Information");
		resequence_connectionInfo = new Combo(connSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData resequence_connectionInfoGridData = new GridData();
		resequence_connectionInfoGridData.horizontalSpan = 3;
		resequence_connectionInfoGridData.horizontalAlignment = GridData.FILL;
		resequence_connectionInfoGridData.grabExcessHorizontalSpace = true;
		resequence_connectionInfo.setLayoutData(resequence_connectionInfoGridData);
		String[] resequenceTypes = { "RESEQUENCE_DB_POOL", "RESEQUENCE_CARBON_DATASOURCE" };
		resequence_connectionInfo.setItems(resequenceTypes);
		resequence_connectionInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (resequence_connectionInfo.getSelectionIndex() == 0) {
					enablePoolfields();
					disableDataSourcefields();
					resequence_DsName.setText("");
				} else {
					disablePoolfields();
					enableDataSourcefields();
					resequence_driver.setText("");
					resequence_url.setText("");
					resequence_username.setText("");
					resequence_password.setText("");
				}
				super.widgetSelected(e);
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();

			}
		});
		
		resequence_connectionInfo.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		// -- if connection info is JDBC_POOL
		lbl_resequence_driver = toolkit.createLabel(connSectionClient, "Resequence DB Driver");
		GridData lbl_jdbc_driverInfoGridData = new GridData();
		lbl_jdbc_driverInfoGridData.horizontalSpan = 3;
		lbl_jdbc_driverInfoGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_driverInfoGridData.grabExcessHorizontalSpace = true;
		lbl_resequence_driver.setLayoutData(lbl_jdbc_driverInfoGridData);

		resequence_driver = toolkit.createText(connSectionClient, "");
		resequence_driver.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_driverInfoGridData = new GridData();
		jdbc_driverInfoGridData.horizontalSpan = 3;
		jdbc_driverInfoGridData.horizontalAlignment = GridData.FILL;
		jdbc_driverInfoGridData.grabExcessHorizontalSpace = true;
		resequence_driver.setLayoutData(jdbc_driverInfoGridData);
		resequence_driver.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_resequence_url = toolkit.createLabel(connSectionClient, "Resequence DB URL");
		GridData lbl_jdbc_urlGridData = new GridData();
		lbl_jdbc_urlGridData.horizontalSpan = 3;
		lbl_jdbc_urlGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_urlGridData.grabExcessHorizontalSpace = true;
		lbl_resequence_url.setLayoutData(lbl_jdbc_urlGridData);

		resequence_url = toolkit.createText(connSectionClient, "");
		resequence_url.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_urlInfoGridData = new GridData();
		jdbc_urlInfoGridData.horizontalSpan = 3;
		jdbc_urlInfoGridData.horizontalAlignment = GridData.FILL;
		jdbc_urlInfoGridData.grabExcessHorizontalSpace = true;
		resequence_url.setLayoutData(jdbc_urlInfoGridData);
		resequence_url.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_resequence_username = toolkit.createLabel(connSectionClient, "Resequence DB Username");
		GridData lbl_jdbc_usernameGridData = new GridData();
		lbl_jdbc_usernameGridData.horizontalSpan = 3;
		lbl_jdbc_usernameGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_usernameGridData.grabExcessHorizontalSpace = true;
		lbl_resequence_username.setLayoutData(lbl_jdbc_usernameGridData);

		resequence_username = toolkit.createText(connSectionClient, "");
		resequence_username.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_usernameGridData = new GridData();
		jdbc_usernameGridData.horizontalSpan = 3;
		jdbc_usernameGridData.horizontalAlignment = GridData.FILL;
		jdbc_usernameGridData.grabExcessHorizontalSpace = true;
		resequence_username.setLayoutData(jdbc_usernameGridData);
		resequence_username.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_resequence_password = toolkit.createLabel(connSectionClient, "Resequence DB Password");
		GridData lbl_jdbc_passwordGridData = new GridData();
		lbl_jdbc_passwordGridData.horizontalSpan = 3;
		lbl_jdbc_passwordGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_passwordGridData.grabExcessHorizontalSpace = true;
		lbl_resequence_password.setLayoutData(lbl_jdbc_passwordGridData);

		resequence_password = toolkit.createText(connSectionClient, "");
		resequence_password.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_passwordGridData = new GridData();
		jdbc_passwordGridData.horizontalSpan = 3;
		jdbc_passwordGridData.horizontalAlignment = GridData.FILL;
		jdbc_passwordGridData.grabExcessHorizontalSpace = true;
		resequence_password.setLayoutData(jdbc_passwordGridData);
		resequence_password.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		disablePoolfields();

		// -- if connection info is JDBC_CARBON_DATASOURCE
		lbl_resequence_DsName = toolkit.createLabel(connSectionClient, "Resequence DB Datasource Name");
		GridData lbl_jdbc_DsNameGridData = new GridData();
		lbl_jdbc_DsNameGridData.horizontalSpan = 3;
		lbl_jdbc_DsNameGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_DsNameGridData.grabExcessHorizontalSpace = true;
		lbl_resequence_DsName.setLayoutData(lbl_jdbc_DsNameGridData);

		resequence_DsName = toolkit.createText(connSectionClient, "");
		resequence_DsName.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_DsNameGridData = new GridData();
		jdbc_DsNameGridData.horizontalSpan = 3;
		jdbc_DsNameGridData.horizontalAlignment = GridData.FILL;
		jdbc_DsNameGridData.grabExcessHorizontalSpace = true;
		resequence_DsName.setLayoutData(jdbc_DsNameGridData);
		resequence_DsName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		disableDataSourcefields();

	}

	private void disablePoolfields() {

		GridData gdDriver = (GridData) resequence_driver.getLayoutData();
		gdDriver.exclude = true;
		GridData gdDriverLbl = (GridData) lbl_resequence_driver.getLayoutData();
		gdDriverLbl.exclude = true;
		GridData gdUrl = (GridData) resequence_url.getLayoutData();
		gdUrl.exclude = true;
		GridData gdUrlLbl = (GridData) lbl_resequence_url.getLayoutData();
		gdUrlLbl.exclude = true;
		GridData gdUName = (GridData) resequence_username.getLayoutData();
		gdUName.exclude = true;
		GridData gdUNameLbl = (GridData) lbl_resequence_username.getLayoutData();
		gdUNameLbl.exclude = true;
		GridData gdPass = (GridData) resequence_password.getLayoutData();
		gdPass.exclude = true;
		GridData gdPassLbl = (GridData) lbl_resequence_password.getLayoutData();
		gdPassLbl.exclude = true;
		// rmPolicy.setVisible(false);
		resequence_driver.setVisible(false);
		lbl_resequence_driver.setVisible(false);
		resequence_url.setVisible(false);
		lbl_resequence_url.setVisible(false);
		resequence_username.setVisible(false);
		lbl_resequence_username.setVisible(false);
		resequence_password.setVisible(false);
		lbl_resequence_password.setVisible(false);
		enbaleVisualizingConnectionFields();
	}

	private void enablePoolfields() {

		GridData gdDriver = (GridData) resequence_driver.getLayoutData();
		gdDriver.exclude = false;
		GridData gdDriverLbl = (GridData) lbl_resequence_driver.getLayoutData();
		gdDriverLbl.exclude = false;
		GridData gdUrlLbl = (GridData) lbl_resequence_url.getLayoutData();
		gdUrlLbl.exclude = false;
		GridData gdUrl = (GridData) resequence_url.getLayoutData();
		gdUrl.exclude = false;
		GridData gdUName = (GridData) resequence_username.getLayoutData();
		gdUName.exclude = false;
		GridData gdUNameLbl = (GridData) lbl_resequence_username.getLayoutData();
		gdUNameLbl.exclude = false;
		GridData gdPass = (GridData) resequence_password.getLayoutData();
		gdPass.exclude = false;
		GridData gdPassLbl = (GridData) lbl_resequence_password.getLayoutData();
		gdPassLbl.exclude = false;
		// rmPolicy.setVisible(false);
		resequence_driver.setVisible(true);
		lbl_resequence_driver.setVisible(true);
		resequence_url.setVisible(true);
		lbl_resequence_url.setVisible(true);
		resequence_username.setVisible(true);
		lbl_resequence_username.setVisible(true);
		resequence_password.setVisible(true);
		lbl_resequence_password.setVisible(true);
		enbaleVisualizingConnectionFields();
	}

	public void setPoolingFields(boolean check) {
		if (check) {
			enablePoolfields();
		}
	}

	public void setDataSourceFields(boolean check) {
		if (check) {
			enableDataSourcefields();
		}
	}

	private void disableDataSourcefields() {

		GridData gdDSname = (GridData) resequence_DsName.getLayoutData();
		gdDSname.exclude = true;
		GridData gdDSnameLbl = (GridData) lbl_resequence_DsName.getLayoutData();
		gdDSnameLbl.exclude = true;
		resequence_DsName.setVisible(false);
		lbl_resequence_DsName.setVisible(false);
		enbaleVisualizingConnectionFields();
	}

	private void enableDataSourcefields() {

		GridData gdDSname = (GridData) resequence_DsName.getLayoutData();
		gdDSname.exclude = false;
		GridData gdDSnameLbl = (GridData) lbl_resequence_DsName.getLayoutData();
		gdDSnameLbl.exclude = false;
		resequence_DsName.setVisible(true);
		lbl_resequence_DsName.setVisible(true);
		enbaleVisualizingConnectionFields();
	}

	private void enbaleVisualizingConnectionFields() {
		if (connSection.isExpanded() == true) {
			connSection.setExpanded(false);
			connSection.setExpanded(true);
		}
	}

	@Override
	public void createParameterSectionFields() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasGuaranteedDelivery() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return false;
	}

	@Override
	public boolean hasConnection() {
		return true;
	}

	@Override
	public void hideGuaranteedDeliverySection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideParametersSection() {
		// parameterSection.setVisible(false);

	}

	@Override
	public void hideConnectionSection() {
		connSection.setVisible(false);
		connSection.setExpanded(false);
	}

	@Override
	public void showGuaranteedDeliverySection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showParametersSection() {
		// parameterSection.setVisible(true);

	}

	@Override
	public void showConnectionSection() {
		connSection.setVisible(true);
		connSection.setExpanded(true);
	}

	private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {

		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);

		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);

		return section;
	}

}
