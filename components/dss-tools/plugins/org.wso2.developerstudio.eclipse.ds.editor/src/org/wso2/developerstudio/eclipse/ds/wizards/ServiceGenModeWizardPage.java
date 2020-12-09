package org.wso2.developerstudio.eclipse.ds.wizards;

import java.sql.Connection;
import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.ds.wizards.util.UiUtil;
import org.wso2.developerstudio.eclipse.ds.wizards.util.ValidateUtil;

public class ServiceGenModeWizardPage extends WizardPage implements Listener {

	public static final String PAGE_NAME = "ServiceGenModeWizardPage";

	private ArrayList<String> selectedTableNames;
	private IStructuredSelection selection;
	private Composite comp;
	private Button single;
	private Button multiple;
	private Label nsLable;
	private Text nameSpacetxt;
	private Label dsLable;
	private Text serviceName;

	protected ServiceGenModeWizardPage(IStructuredSelection selection) {

		super(PAGE_NAME, "Service Generation Configurations", null);
		this.selection = selection;
	}

	public void createControl(Composite parent) {

		comp = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(2, false);
		comp.setLayout(gl);

		Group modeGrp = new Group(comp, SWT.NONE);
		modeGrp.setText("Select Service Generation Mode");
		modeGrp.setLayout(gl);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		modeGrp.setLayoutData(gd);

		single = new Button(modeGrp, SWT.RADIO);
		single.setText("Single Service - Creates one service for all selected tables.");
		single.setLayoutData(gd);

		multiple = new Button(modeGrp, SWT.RADIO);
		multiple.setText("Multiple Services - Creates a service per table.");
		multiple.setLayoutData(gd);

		UiUtil.createLine(comp, 2);

		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);

		nsLable = new Label(comp, SWT.WRAP);
		nsLable.setText("Data Service Namespace");
		nsLable.setLayoutData(gd1);

		nameSpacetxt = new Text(comp, SWT.SINGLE | SWT.BORDER);
		nameSpacetxt.setLayoutData(gd1);

		dsLable = new Label(comp, SWT.WRAP);
		dsLable.setText("Data Service Name");
		dsLable.setLayoutData(gd1);

		serviceName = new Text(comp, SWT.SINGLE | SWT.BORDER);
		serviceName.setLayoutData(gd1);

		addListners();

		setControl(comp);

	}

	private void addListners() {

		single.addListener(SWT.Selection, this);
		multiple.addListener(SWT.Selection, this);
		nameSpacetxt.addListener(SWT.Modify, this);
		serviceName.addListener(SWT.Selection, this);
	}

	public void handleEvent(Event event) {

		if (event.widget == multiple && multiple.getSelection() == true) {

			dsLable.setVisible(false);
			serviceName.setVisible(false);

		} else if (event.widget == single && single.getSelection() == true) {

			if (!dsLable.getVisible()) {

				dsLable.setVisible(true);
			}

			if (!serviceName.getVisible()) {

				serviceName.setVisible(true);
			}
		}

		for (String table : selectedTableNames) {

			System.out.println(table);
		}
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

	/*
	 * private String getCoulmns(){
	 * 
	 * 
	 * ResultSet schemas = meta.getSchemas();
	 * }
	 * 
	 * private ArrayList<String> getSchemas(){
	 * 
	 * 
	 * }
	 */

	public ArrayList<String> getSelectedTableNames() {
		return selectedTableNames;
	}

	public void setSelectedTableNames(ArrayList<String> selectedTableNames) {
		this.selectedTableNames = selectedTableNames;
	}

	public boolean canFlipToNextPage() {

		return false;
	}

	public boolean isPageComplete() {

		if (single.getSelection() == true && ValidateUtil.isTextNonEmpty(nameSpacetxt) &&
		    ValidateUtil.isTextNonEmpty(serviceName)) {

			DataServiceCreationWizard wizard = (DataServiceCreationWizard) getWizard();
			wizard.serviceGenPageCompleted = true;
			return true;
		}

		return false;

	}

}
