package org.wso2.developerstudio.eclipse.ds.wizards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.ds.wizards.util.CSVReader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DBUriConstants;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DLoader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.ExelReader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.FileUtil;
import org.wso2.developerstudio.eclipse.ds.wizards.util.GSpreadReader;
import org.wso2.developerstudio.eclipse.ds.wizards.util.URIProcessor;
import org.wso2.developerstudio.eclipse.ds.wizards.util.UiUtil;
import org.wso2.developerstudio.eclipse.ds.wizards.util.ValidateUtil;

import com.google.gdata.util.ServiceException;

public class DataServiceCreationWizadPage extends WizardPage implements Listener {

	public static final String PAGE_NAME = "DataServiceCreationWizardPage";

	public static final String BASE_WORKSHEET_URL =
	                                                "http://spreadsheets.google.com/feeds/worksheets/";

	private static final String TEMP_FILE_NAME = "temp";

	private Text sourceUriText;

	private URIProcessor urip;

	Composite dataSourceComp;

	private Composite gspreadComp;

	private Composite credentialGrp;

	private boolean isGspredWidgetadded;

	private boolean isCredentialUIadded;

	private Text username;

	private Text passwd;

	private Combo visibilityCombo;

	protected DataServiceCreationWizadPage() {

		super(PAGE_NAME, "Create New Data Service", null);
		urip = URIProcessor.getInstance();
		isGspredWidgetadded = false;
		isCredentialUIadded = false;

	}

	public void createControl(Composite parent) {

		dataSourceComp = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(2, false);
		dataSourceComp.setLayout(gl);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;
		gd.horizontalIndent = 10;

		new Label(dataSourceComp, SWT.WRAP).setText("Data Source URL");
		sourceUriText = new Text(dataSourceComp, SWT.BORDER);
		sourceUriText.setLayoutData(gd);

		UiUtil.createLine(dataSourceComp, 2);

		setControl(dataSourceComp);

		addListeners();

	}

	private void addListeners() {

		sourceUriText.addListener(SWT.Modify, this);
	}

	public boolean canFlipToNextPage() {

		if (ValidateUtil.isTextNonEmpty(sourceUriText))
			return true;
		return false;
	}

	public IWizardPage getNextPage() {

		IWizardPage nextPage = null;

		String inputUrl = sourceUriText.getText().trim();

		HashMap<String, String> sourceDetails = urip.getProcessedURI(inputUrl);

		if (sourceDetails != null) {
			if (sourceDetails.get(DBUriConstants.DB_TYPE) != null) {
				if (sourceDetails.get(DBUriConstants.DB_TYPE).equals(DBUriConstants.CSV_TYPE)) {

					try {
						csvHandler(inputUrl);
					} catch (IOException e) {

						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error occured while reading the file",
						                              e.toString());
						return null;
					}

					nextPage = ((DataServiceCreationWizard) getWizard()).csvPage;

				} else if (sourceDetails.get(DBUriConstants.DB_TYPE)
				                        .equals(DBUriConstants.XLS_TYPE)) {

					try {
						exelHandler(inputUrl);
					} catch (FileNotFoundException e) {
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "File not found", e.toString());
						return null;
					} catch (IOException e) {
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error occured while reading the file",
						                              e.toString());
						return null;
					}

					nextPage = ((DataServiceCreationWizard) getWizard()).xlsPage;

				} else if (sourceDetails.get(DBUriConstants.DB_TYPE)
				                        .equals(DBUriConstants.GSS_TYPE)) {

					try {
						gspreadhandler();
					} catch (IOException e) {
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error occured while reading the file",
						                              e.toString());
						return null;
					} catch (ServiceException e) {
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Google Data Service can not be established",
						                              e.toString());
						return null;
					}

					nextPage = ((DataServiceCreationWizard) getWizard()).gspPage;

				} else if (sourceDetails.get(DBUriConstants.DB_TYPE)
				                        .equals(DBUriConstants.CSV_TYPE_ONLIN)) {

					IProject project = null;
					try {
						project = FileUtil.createTempLoaction();

					} catch (CoreException e) {

						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error occured while reading the file",
						                              e.toString());

					}

					if (project != null) {

						String tempFilePath =
						                      project.getLocation().toString() + File.separator +
						                              TEMP_FILE_NAME + DBUriConstants.CSV_TYPE;
						boolean isComplete = false;

						try {
							isComplete = DLoader.download(inputUrl, tempFilePath);
						} catch (IOException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "File not found", e.toString());
							return null;
						}
						if (isComplete) {

							try {
								csvHandler(tempFilePath);
							} catch (IOException e) {
								MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
								                              "Error occured while reading the file",
								                              e.toString());
								return null;
							}
						}
					}
					nextPage = ((DataServiceCreationWizard) getWizard()).csvPage;

				} else if (sourceDetails.get(DBUriConstants.DB_TYPE)
				                        .equals(DBUriConstants.XLS_TYPE_ONLIN)) {

					IProject project = null;

					try {

						project = FileUtil.createTempLoaction();

					} catch (CoreException e) {

						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error occured while reading the file",
						                              e.toString());

					}

					if (project != null) {

						String tempFilePath =
						                      project.getLocation().toString() + File.separator +
						                              TEMP_FILE_NAME + DBUriConstants.XLS_TYPE;
						boolean isComplete = false;

						try {
							isComplete = DLoader.download(inputUrl, tempFilePath);
						} catch (IOException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "File not found", e.toString());
							return null;
						}
						if (isComplete) {
							try {
								exelHandler(tempFilePath);
							} catch (FileNotFoundException e) {
								MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
								                              "Error occured while reading the file",
								                              e.toString());
								return null;
							} catch (IOException e) {
								MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
								                              "Error occured while reading the file",
								                              e.toString());
								return null;
							}
						}
					}

					nextPage = ((DataServiceCreationWizard) getWizard()).xlsPage;

				} else if (sourceDetails.get(DBUriConstants.RDBMS_FLAG)
				                        .equals(DBUriConstants.REGEX_RDBMS)) {

					((DataServiceCreationWizard) getWizard()).driveConPage.init(sourceDetails);

					nextPage = ((DataServiceCreationWizard) getWizard()).driveConPage;
					((DataServiceCreationWizard) getWizard()).dbFlag = true;
				}
			}
		}
		return nextPage;

	}

	private void csvHandler(String inputUrl) throws IOException {

		CSVReader csvReader = new CSVReader(inputUrl);

		((DataServiceCreationWizard) getWizard()).csvPage.updatePage(csvReader);

	}

	private void exelHandler(String inputUrl) throws FileNotFoundException, IOException {

		ExelWizardPage xlsPage = ((DataServiceCreationWizard) getWizard()).xlsPage;

		ExelReader exlreader = new ExelReader(inputUrl);

		ArrayList<String> sheetNames = exlreader.getWorkSheets();

		if (xlsPage.sheetCombo.getItems() != null && xlsPage.sheetCombo.getItems().length != 0) {

			xlsPage.sheetCombo.removeAll();
		}
		for (String sheet : sheetNames) {

			xlsPage.sheetCombo.add(sheet);

		}

		if (sheetNames.size() != 0)
			xlsPage.setSlectedSheet(sheetNames.get(0));

		xlsPage.sheetCombo.select(0);

		xlsPage.updateFields(exlreader);

	}

	private void gspreadhandler() throws IOException, ServiceException {

		GSpreadReader gr = null;
		String url = generateWorksheetFeedURL();
		if (visibilityCombo.getSelectionIndex() == 0) {

			gr = new GSpreadReader(url);

		} else {
			String userName = "";
			String password = "";
			if (ValidateUtil.isTextNonEmpty(username) && ValidateUtil.isTextNonEmpty(passwd)) {
				// TODO validation
				userName = username.getText();
				password = passwd.getText();
			}
			gr = new GSpreadReader(userName, password, url);
		}

		ArrayList<String> sheetNames = gr.getWorkSheets();

		GSpreadWizardPage gspPage = ((DataServiceCreationWizard) getWizard()).gspPage;

		if (sheetNames.size() != 0) {

			if (gspPage.sheetCombo.getItems() != null && gspPage.sheetCombo.getItems().length != 0) {

				gspPage.sheetCombo.removeAll();
			}
			for (String sheet : sheetNames) {

				gspPage.sheetCombo.add(sheet);

			}

			gspPage.setSlectedSheet(sheetNames.get(0));

			gspPage.sheetCombo.select(0);

			gspPage.updateFieldcombo(gr);
		}

	}

	private void gSpreadUpdater(boolean istoRemove) {

		if (!istoRemove) {

			gspreadComp = createGSpreadutilComp();

			GridData data = new GridData(SWT.FILL, SWT.NONE, false, false);
			data.horizontalSpan = 2;
			gspreadComp.setLayoutData(data);

			dataSourceComp.layout(true);

		} else {
			gspreadComp.dispose();
			dataSourceComp.layout(true);
		}

	}

	private Composite createGSpreadutilComp() {

		final Composite comp = new Composite(dataSourceComp, SWT.NONE);
		GridLayout gl = new GridLayout(2, true);
		gl.horizontalSpacing = 4;
		gl.verticalSpacing = 4;
		gl.marginBottom = 5;
		gl.marginTop = 5;
		comp.setLayout(gl);

		new Label(comp, SWT.WRAP).setText("Visibility");

		visibilityCombo = new Combo(comp, SWT.READ_ONLY);
		visibilityCombo.add("Public");
		visibilityCombo.add("Private");
		GridData cgd1 =
		                new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);

		visibilityCombo.setLayoutData(cgd1);

		visibilityCombo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				if (visibilityCombo.getSelectionIndex() == 1) {

					if (!isCredentialUIadded) {

						credentialGrp = getCredentialsUI(comp);
						isCredentialUIadded = true;
						dataSourceComp.layout(true);
					}
				} else {

					if (isCredentialUIadded) {

						credentialGrp.dispose();
						isCredentialUIadded = false;
						dataSourceComp.layout(true);

					}
				}

			}

		});

		visibilityCombo.select(0);
		comp.layout(true);

		return comp;
	}

	private Composite getCredentialsUI(Composite parent) {

		Composite ownerInfo = new Composite(parent, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		ownerInfo.setLayout(gridLayout);

		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		gridData.horizontalSpan = 2;
		ownerInfo.setLayoutData(gridData);

		new Label(ownerInfo, SWT.WRAP).setText("Name:");

		username = new Text(ownerInfo, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 1;
		gridData.horizontalIndent = 40;
		username.setLayoutData(gridData);

		new Label(ownerInfo, SWT.WRAP).setText("Password:");
		passwd = new Text(ownerInfo, SWT.BORDER | SWT.PASSWORD);
		passwd.setLayoutData(gridData);

		return ownerInfo;
	}

	private String extractKey(String documentURL) throws MalformedURLException {

		int keyIndex = documentURL.lastIndexOf("key=");

		if (documentURL.length() < (keyIndex + 5)) {

			throw new MalformedURLException();
		}

		int keystr = documentURL.indexOf("&", keyIndex);
		if (keystr < 0) {
			return documentURL.substring(keyIndex + 4);
		} else {
			return documentURL.substring(keyIndex + 4, keystr);
		}
	}

	private String generateWorksheetFeedURL() throws MalformedURLException {

		String key = extractKey(sourceUriText.getText().trim());
		String visibility = "";

		if (visibilityCombo.getSelectionIndex() == 0) {
			visibility = DBUriConstants.VIS_PUB;
		} else {
			visibility = DBUriConstants.VISS_PRI;
		}

		return BASE_WORKSHEET_URL + key + "/" + visibility + "/full";
	}

	public String getSourceUriText() {

		return sourceUriText.getText().trim();
	}

	public void handleEvent(Event event) {

		if (event.widget == sourceUriText) {

			handleSourceUriModification();
		}

		getWizard().getContainer().updateButtons();

	}

	private void handleSourceUriModification() {

		if (sourceUriText.getText().trim().length() > 36) {

			if (isGspredWidgetadded == false) {

				Pattern gspread_pattern = Pattern.compile(DBUriConstants.REGEX_GSS_SPREAD);
				Matcher gss_matcher = gspread_pattern.matcher(sourceUriText.getText().trim());

				if (sourceUriText.getText().trim().substring(0, 36).equals(DBUriConstants.GSS_TYPE)) {

					gSpreadUpdater(false);
					isGspredWidgetadded = true;

				} else if (sourceUriText.getText().trim().substring(0, 24)
				                        .equals(DBUriConstants.GSS_TYPE.substring(0, 24)) &&
				           gss_matcher.find()) {

					gSpreadUpdater(false);
					isGspredWidgetadded = true;

				}
			}

		}

		if (sourceUriText.getText().trim().length() < 36) {

			if (isGspredWidgetadded == true) {
				if (gspreadComp != null) {
					if (!gspreadComp.isDisposed()) {

						gSpreadUpdater(true);
						isGspredWidgetadded = false;

					}
				}
			}
		}

	}

	protected void setSourceUriText(String dbSourceUri) {

		sourceUriText.setText(dbSourceUri);
	}

}
