/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dialogs;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SaveImageDialog extends TrayDialog {

	private static final String SETTINGS_IS_TRANSPARENT = "Transparent";
	private static final String SETTINGS_DIRECTORY = "Directory";
	private Text txtImageFileName;
	private Button btnTransparent;

	private String fileNamePart;
	private String imageFileName;
	private boolean transparent;
	private IDialogSettings settings;

	public SaveImageDialog(Shell parentShell, String filename) {
		super(parentShell);
		int shellStyle = getShellStyle();
		setShellStyle(shellStyle | SWT.MAX | SWT.RESIZE);
		this.fileNamePart = stripExtenstion(filename);
		settings = BPELUIPlugin.INSTANCE.getDialogSettingsFor(this);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Export as image");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = (GridLayout) composite.getLayout();
		layout.numColumns = 3;

		new Label(composite, SWT.NONE).setText("To image file:");

		txtImageFileName = new Text(composite, SWT.BORDER);
		txtImageFileName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		txtImageFileName.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				btnTransparent.setEnabled(txtImageFileName.getText().endsWith(
						".png"));
			}
		});

		Button browseButton = new Button(composite, SWT.NONE);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectFile();
			}
		});

		btnTransparent = new Button(composite, SWT.CHECK);
		btnTransparent.setText("Transparent background");
		GridData gd = new GridData();
		gd.widthHint = 400;
		gd.horizontalSpan = 3;
		btnTransparent.setLayoutData(gd);

		applySettings();

		return composite;
	}

	private void applySettings() {
		String dir = settings.get(SETTINGS_DIRECTORY);
		if (dir != null)
			txtImageFileName.setText((new Path(dir)).append(fileNamePart)
					.addFileExtension("png").toOSString());
		btnTransparent.setSelection(settings
				.getBoolean(SETTINGS_IS_TRANSPARENT));
	}

	private void selectFile() {
		String[] filterExtensions = new String[] { "*.png", "*.jpg", "*.bmp" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		String[] filterNames = new String[] {
				"PNG (*.png)", "JPEG (*.jpg)", "BMP (*.bmp)" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
		fileDialog.setFilterPath(txtImageFileName.getText());
		fileDialog.setFileName(fileNamePart);
		fileDialog.setFilterNames(filterNames);
		fileDialog.setFilterExtensions(filterExtensions);
		fileDialog.setText("Export as");
		String result = fileDialog.open();
		if (result != null) {
			txtImageFileName.setText(result);
		}
	}

	private String stripExtenstion(String fileName) {
		int pos = fileName.lastIndexOf('.');
		return (pos == -1) ? fileName : fileName.substring(0, pos);
	}

	public String getFileName() {
		return imageFileName;
	}

	public boolean isTransparent() {
		return transparent;
	}

	@Override
	protected void okPressed() {
		imageFileName = txtImageFileName.getText();
		transparent = btnTransparent.getSelection();
		settings.put(SETTINGS_IS_TRANSPARENT, transparent);
		settings.put(SETTINGS_DIRECTORY, (new Path(imageFileName)
				.removeLastSegments(1).toString()));
		super.okPressed();
	}

}
