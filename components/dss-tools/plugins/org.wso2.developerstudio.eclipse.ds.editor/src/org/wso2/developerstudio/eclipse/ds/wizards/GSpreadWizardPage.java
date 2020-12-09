package org.wso2.developerstudio.eclipse.ds.wizards;

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
import org.wso2.developerstudio.eclipse.ds.wizards.util.GSpreadReader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.UiUtil;

public class GSpreadWizardPage extends WizardPage {

	public static final String PAGE_NAME = "GSpreadAWizardPage";
	public Composite comp;
	public Combo sheetCombo;
	private String selectedSheet;
	private Composite control;
	private GSpreadReader gspReader;
	private boolean containsColumnHeaderRow;

	protected GSpreadWizardPage() {

		super(PAGE_NAME, "Google Spread Sheet Details", null);
	}

	public void createControl(Composite parent) {

		comp = new Composite(parent, SWT.NONE);

		GridLayout gl = new GridLayout(2, false);
		comp.setLayout(gl);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		gd.horizontalIndent = 20;

		new Label(comp, SWT.NONE).setText("Sheet Names");
		sheetCombo = new Combo(comp, SWT.READ_ONLY);
		sheetCombo.setLayoutData(gd);
		addSelectionLisner(sheetCombo);

		new Label(comp, SWT.WRAP).setText("Make these as headers");

		final Combo hCombo = new Combo(comp, SWT.READ_ONLY);
		hCombo.add("Yes");
		hCombo.add("No");
		hCombo.select(0);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalIndent = 20;
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

	private void addSelectionLisner(final Combo sheetCombo) {

		sheetCombo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				selectedSheet = sheetCombo.getItem(sheetCombo.getSelectionIndex());

				updateFieldcombo(gspReader);
			}
		});

	}

	public String getSlectedSheet() {

		return selectedSheet;
	}

	public void setSlectedSheet(String selectedSheet) {

		this.selectedSheet = selectedSheet;
	}

	public void updateFieldcombo(GSpreadReader gspreader) {

		if (gspReader == null)
			gspReader = gspreader;

		if (control != null)
			control.dispose();

		ArrayList<String> headers = gspreader.getHeaders(getSlectedSheet());

		Composite chek = new Composite(comp, SWT.NONE);
		GridLayout gl = new GridLayout(2, false);
		chek.setLayout(gl);

		for (String header : headers) {

			UiUtil.createChekBox(chek, header);
		}

		control = chek;

		GridData data = new GridData(SWT.FILL, SWT.NONE, false, false);
		data.horizontalSpan = 2;

		if (!control.isDisposed())
			control.setLayoutData(data);

		comp.layout(true);
	}

	public boolean canFlipToNextPage() {

		return false;
	}

}
