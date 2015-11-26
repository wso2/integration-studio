package org.wso2.developerstudio.eclipse.ds.wizards.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class UiUtil {

	public static Button createChekBox(Composite parent, String text) {

		Button chckBtn = new Button(parent, SWT.CHECK);
		chckBtn.setText(text);
		GridData gd = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		chckBtn.setLayoutData(gd);
		chckBtn.setData(DBUriConstants.CHEK_BTN_FLG);
		return chckBtn;
	}

	public static void createLine(Composite parent, int ncol) {
		Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.BOLD);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = ncol;
		line.setLayoutData(gridData);
	}

}
