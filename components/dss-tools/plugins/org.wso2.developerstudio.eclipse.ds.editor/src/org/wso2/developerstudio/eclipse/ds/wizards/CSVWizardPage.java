package org.wso2.developerstudio.eclipse.ds.wizards;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.ds.wizards.util.CSVReader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.UiUtil;

public class CSVWizardPage extends WizardPage {

	public static final String PAGE_NAME = "CSVWizardPage";

	public Composite comp;
	private Composite control;
	private CSVReader csvReader;
	private boolean containsColumnHeaderRow;

	protected CSVWizardPage() {
		super(PAGE_NAME, "CSV Details page", null);

	}

	public void createControl(Composite parent) {

		comp = new Composite(parent, SWT.NONE);

		GridLayout gl = new GridLayout(2, true);
		comp.setLayout(gl);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;

		new Label(comp, SWT.WRAP).setText("Make these as headers");

		final Combo hCombo = new Combo(comp, SWT.READ_ONLY);
		hCombo.add("Yes");
		hCombo.add("No");
		hCombo.select(0);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		hCombo.setLayoutData(gd);
		hCombo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				if (hCombo.getSelectionIndex() == 0) {

					containsColumnHeaderRow = true;

				} else {

					containsColumnHeaderRow = false;
				}
			}
		});

		setControl(comp);

	}

	public void updatePage(CSVReader reader) throws IOException {

		csvReader = reader;

		if (control != null)
			control.dispose();

		ArrayList<String> headers = csvReader.getHeaders();

		Composite chek = new Composite(comp, SWT.NONE);

		GridLayout gl = new GridLayout(2, true);
		chek.setLayout(gl);

		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		chek.setLayoutData(data);

		for (String header : headers) {

			UiUtil.createChekBox(chek, header);

		}

		control = chek;

		if (!control.isDisposed())
			control.setLayoutData(data);

		comp.layout(true);

	}

	public boolean isColumnHeaderRowcontains() {

		return containsColumnHeaderRow;
	}

	public boolean canFlipToNextPage() {

		return false;
	}

}