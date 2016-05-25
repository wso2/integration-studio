package org.wso2.developerstudio.eclipse.ds.wizards;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DBUriConstants;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DbConnManager;
import org.wso2.developerstudio.eclipse.ds.wizards.util.DriverShim;
import org.wso2.developerstudio.eclipse.ds.wizards.util.ValidateUtil;

public class DriverConnDetailPage extends WizardPage implements Listener {

	public static final String PAGE_NAME = "DBDetailWizardPage";
	private static final String[] FILTER_EXTS = { "*.jar", "*.*" };

	private HashMap<String, String> dbDetails;
	// private boolean isConnAlive = false;
	private Connection dbConn;

	private Composite detailComp;
	private Button testConnBtn;
	private Text drivePathTxt;
	private Text dbtypeTxt;
	private Text hostTxt;
	private Text portTxt;
	private Text userNameTxt;
	private Text passwdTxt;
	private Text dbNameTxt;
	private Text dbDriveTxt;
	private Text dbServerTxt;

	private Composite control;

	protected DriverConnDetailPage() {

		super(PAGE_NAME, "Driver Connection Details ", null);

	}

	protected void init(HashMap<String, String> details) {

		setDBDetails(details);

		populatePropertyGrp();

		clearConnection();

	}

	public void createControl(Composite parent) {

		detailComp = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(3, false);
		detailComp.setLayout(gl);

		new Label(detailComp, SWT.WRAP).setText("Drivers:");

		drivePathTxt = new Text(detailComp, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 1;

		drivePathTxt.setLayoutData(gd);
		drivePathTxt.addListener(SWT.Modify, this);

		Button browseBtn = new Button(detailComp, SWT.PUSH);
		browseBtn.setText("Browse");
		gd = new GridData();
		browseBtn.setLayoutData(gd);
		browseBtn.setSize(100, 20);

		browseBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				FileDialog dlg = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
				dlg.setFilterExtensions(FILTER_EXTS);
				String fn = dlg.open();

				drivePathTxt.setText(fn);

			}
		});

		setControl(detailComp);

	}

	private void addTestbutton(Composite parent) {

		testConnBtn = new Button(parent, SWT.PUSH);
		testConnBtn.setText("Test Connection");
		GridData gd = new GridData();
		gd.horizontalSpan = 1;
		testConnBtn.setLayoutData(gd);

		testConnBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				if (ValidateUtil.isTextNonEmpty(drivePathTxt)) {
					if (ValidateUtil.isTextNonEmpty(userNameTxt) &&
					    ValidateUtil.isTextNonEmpty(passwdTxt)) {

						try {
							Connection conn =
							                  testConnection(dbDetails.get(DBUriConstants.DB_URL),
							                                 userNameTxt.getText(),
							                                 passwdTxt.getText(),
							                                 drivePathTxt.getText(),
							                                 dbDetails.get(DBUriConstants.DB_DRIVER));
							if (conn != null) {

								dbConn = conn;
							}

						} catch (MalformedURLException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "Error!", e.toString());
						} catch (InstantiationException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "Error!", e.toString());
						} catch (IllegalAccessException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "Error!", e.toString());
						} catch (ClassNotFoundException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "Error!", e.toString());
						} catch (SQLException e) {
							MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							                              "Error!", e.toString());
						}

					} else {

						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Error!", "User Name or password empty!");

					}

				} else {
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
					                              "Please Select the driver path from the file system!");
				}
			}
		});

		testConnBtn.addListener(SWT.Selection, this);
	}

	private void populatePropertyGrp() {

		if (control != null)
			control.dispose();

		Composite content = new Composite(detailComp, SWT.NONE);
		GridLayout contentLayout = new GridLayout(1, false);
		content.setLayout(contentLayout);

		Group propertyGrp = new Group(content, SWT.NONE);
		propertyGrp.setText("Properties");
		GridLayout gl = new GridLayout(2, true);
		propertyGrp.setLayout(gl);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		propertyGrp.setLayoutData(gd);

		if (dbDetails.get(DBUriConstants.DB_TYPE) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Database Type:");

			dbtypeTxt = new Text(propertyGrp, SWT.BORDER);
			gd = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 1;
			dbtypeTxt.setLayoutData(gd);

			dbtypeTxt.setText(dbDetails.get(DBUriConstants.DB_TYPE));

			dbtypeTxt.setEditable(false);

		}

		if (dbDetails.get(DBUriConstants.HOST) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Host:");

			hostTxt = new Text(propertyGrp, SWT.BORDER);
			hostTxt.setLayoutData(gd);

			hostTxt.setText(dbDetails.get(DBUriConstants.HOST));

			hostTxt.addListener(SWT.Modify, this);

		} else if (dbDetails.get(DBUriConstants.DB_FILE_PATH) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Path:");

			hostTxt = new Text(propertyGrp, SWT.BORDER);
			hostTxt.setLayoutData(gd);

			hostTxt.setText(dbDetails.get(DBUriConstants.DB_FILE_PATH));

			hostTxt.addListener(SWT.Modify, this);

		}

		if (dbDetails.get(DBUriConstants.PORT) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Port:");

			portTxt = new Text(propertyGrp, SWT.BORDER);
			portTxt.setLayoutData(gd);

			portTxt.setText(dbDetails.get(DBUriConstants.PORT));

			portTxt.addListener(SWT.Modify, this);

		}

		new Label(propertyGrp, SWT.WRAP).setText("User Name:");

		userNameTxt = new Text(propertyGrp, SWT.BORDER);
		userNameTxt.setLayoutData(gd);

		if (dbDetails.get(DBUriConstants.DB_U_NAME) != null) {
			userNameTxt.setText(dbDetails.get(DBUriConstants.DB_U_NAME));
		}

		userNameTxt.addListener(SWT.Modify, this);

		new Label(propertyGrp, SWT.WRAP).setText("Password:");

		passwdTxt = new Text(propertyGrp, SWT.BORDER | SWT.PASSWORD);
		passwdTxt.setLayoutData(gd);

		if (dbDetails.get(DBUriConstants.DB_PASSWD) != null) {
			passwdTxt.setText(dbDetails.get(DBUriConstants.DB_PASSWD));
		}

		passwdTxt.addListener(SWT.Modify, this);

		if (dbDetails.get(DBUriConstants.DB_NAME) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Database name:");

			dbNameTxt = new Text(propertyGrp, SWT.BORDER);
			dbNameTxt.setLayoutData(gd);

			dbNameTxt.setText(dbDetails.get(DBUriConstants.DB_NAME));

			dbNameTxt.addListener(SWT.Modify, this);

		}

		if (dbDetails.get(DBUriConstants.DB_DRIVE_TYPE) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Database Driver Type:");

			dbDriveTxt = new Text(propertyGrp, SWT.BORDER);
			dbDriveTxt.setLayoutData(gd);

			dbDriveTxt.setText(dbDetails.get(DBUriConstants.DB_DRIVE_TYPE));

			dbDriveTxt.addListener(SWT.Modify, this);

		}

		if (dbDetails.get(DBUriConstants.DB_SERVER_NAME) != null) {

			new Label(propertyGrp, SWT.WRAP).setText("Database Server Name:");

			dbServerTxt = new Text(propertyGrp, SWT.BORDER);
			dbServerTxt.setLayoutData(gd);

			dbServerTxt.setText(dbDetails.get(DBUriConstants.DB_SERVER_NAME));

			dbServerTxt.addListener(SWT.Modify, this);

		}
		addTestbutton(content);
		control = content;

		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
		control.setLayoutData(data);

		detailComp.layout(true);

	}

	private void generateDbUrl() {

		String dataBaseType = dbDetails.get(DBUriConstants.DB_TYPE);
		String url = "";

		if (dataBaseType.equals(DBUriConstants.MYSQL_ID)) {
			/*
			 * jdbc:mysql://HOST:PORT/DBname
			 */
			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.MYSQL_ID + DBUriConstants.REGEX_COLON +
			              DBUriConstants.REGEX_DSLASH + hostTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
			              DBUriConstants.REGEX_SLASH + dbNameTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.DERBY_ID)) {
			/*
			 * jdbc:derby:[path-to-data-file]
			 */
			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.DERBY_ID + DBUriConstants.REGEX_COLON +
			              hostTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.MS_SQL_ID)) {

			/*
			 * jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.MS_SQL_ID + DBUriConstants.REGEX_COLON +
			              DBUriConstants.REGEX_DSLASH + hostTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
			              DBUriConstants.REGEX_SCOLON + DBUriConstants.MS_DBNAME +
			              DBUriConstants.REGEX_EQL + dbNameTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.ORACLE_ID)) {

			if (dbDetails.get(DBUriConstants.ORC_TYPE) != null) {

				String orcUrlType = dbDetails.get(DBUriConstants.ORC_TYPE);

				if (orcUrlType.equals(DBUriConstants.ORC_TYPE_ONE)) {
					/*
					 * jdbc:oracle:thin:@//HOST:PORT/SERVICE
					 */
					url =
					      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
					              DBUriConstants.ORACLE_ID + DBUriConstants.REGEX_COLON +
					              dbDriveTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              DBUriConstants.REGEX_AT + DBUriConstants.REGEX_DSLASH +
					              DBUriConstants.REGEX_COLON + hostTxt.getText().trim() +
					              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
					              DBUriConstants.REGEX_SLASH + dbNameTxt.getText().trim();

				} else if (orcUrlType.equals(DBUriConstants.ORC_TYPE_TWO)) {
					/*
					 * jdbc:oracle:thin:USER/PASSWORD@HOST:PORT/SERVICE
					 */

					url =
					      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
					              DBUriConstants.ORACLE_ID + DBUriConstants.REGEX_COLON +
					              dbDriveTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              userNameTxt.getText().trim() + DBUriConstants.REGEX_SLASH +
					              passwdTxt.getText().trim() + DBUriConstants.REGEX_AT +
					              hostTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              portTxt.getText().trim() + DBUriConstants.REGEX_SLASH +
					              dbNameTxt.getText().trim();

				} else if (orcUrlType.equals(DBUriConstants.ORC_TYPE_THREE)) {
					/*
					 * jdbc:oracle:thin:USER/PASSWORD@HOST:PORT:SID
					 */

					url =
					      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
					              DBUriConstants.ORACLE_ID + DBUriConstants.REGEX_COLON +
					              dbDriveTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              userNameTxt.getText().trim() + DBUriConstants.REGEX_SLASH +
					              passwdTxt.getText().trim() + DBUriConstants.REGEX_AT +
					              hostTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              portTxt.getText().trim() + DBUriConstants.REGEX_COLON +
					              dbNameTxt.getText().trim();
				}
			}

		} else if (dataBaseType.equals(DBUriConstants.DB2_ID)) {
			/*
			 * jdbc:db2:[database]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON + DBUriConstants.DB2_ID +
			              DBUriConstants.REGEX_COLON + dbNameTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.HSQL_ID)) {
			/*
			 * jdbc:hsqldb:[path]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON + DBUriConstants.HSQL_ID +
			              DBUriConstants.REGEX_COLON + hostTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.INFORMIX_ID)) {
			/*
			 * jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server
			 * -name]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.INFORMIX_ID + DBUriConstants.REGEX_COLON +
			              DBUriConstants.REGEX_DSLASH + hostTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
			              DBUriConstants.REGEX_SLASH + dbNameTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + DBUriConstants.INFORMIXSERVER +
			              DBUriConstants.REGEX_EQL + dbServerTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.POSTGRESQL_ID)) {
			/*
			 * jdbc:postgresql://[HOST]:[PORT5432]/[database]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.POSTGRESQL_ID + DBUriConstants.REGEX_COLON +
			              DBUriConstants.REGEX_DSLASH + hostTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
			              DBUriConstants.REGEX_SLASH + dbNameTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.SYBASE_ID)) {
			/*
			 * jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON +
			              DBUriConstants.SYBASE_ID + DBUriConstants.REGEX_COLON +
			              DBUriConstants.SYBASE_TDS + DBUriConstants.REGEX_COLON +
			              hostTxt.getText().trim() + DBUriConstants.REGEX_COLON +
			              portTxt.getText().trim() + DBUriConstants.REGEX_SLASH +
			              dbNameTxt.getText().trim();

		} else if (dataBaseType.equals(DBUriConstants.H2_ID)) {
			/*
			 * jdbc:h2:tcp:[HOST]:[PORT]/[database]
			 */

			url =
			      DBUriConstants.REGEX_RDBMS + DBUriConstants.REGEX_COLON + DBUriConstants.H2_ID +
			              DBUriConstants.REGEX_COLON + DBUriConstants.H2_TCP +
			              DBUriConstants.REGEX_COLON + hostTxt.getText().trim() +
			              DBUriConstants.REGEX_COLON + portTxt.getText().trim() +
			              DBUriConstants.REGEX_SLASH + dbNameTxt.getText().trim();
		}

		dbDetails.put(DBUriConstants.DB_URL, url);

	}

	public Connection testConnection(String dbURL, String dbUsername, String dbPassword,
	                                 String driverURL, String driverClass)
	                                                                      throws MalformedURLException,
	                                                                      InstantiationException,
	                                                                      IllegalAccessException,
	                                                                      ClassNotFoundException,
	                                                                      SQLException {
		Connection connection = null;
		// boolean isConnAlive = false;
		try {

			URL url = new URL("jar:file:" + driverURL + "!/");

			URLClassLoader ucl = new URLClassLoader(new URL[] { url });

			Driver driver = (Driver) Class.forName(driverClass, true, ucl).newInstance();

			DriverManager.registerDriver(new DriverShim(driver));

			connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

			if (connection != null) {
				// isConnAlive = true;
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Success!",
				                              "Ping Succeeded!");
			} else {

				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
				                              "Ping Failed!");
			}

		} catch (MalformedURLException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              e.toString());
		} catch (InstantiationException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              e.toString());
		} catch (IllegalAccessException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              e.toString());
		} catch (ClassNotFoundException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              e.toString());
		} catch (SQLException e) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              e.toString());
		}

		return connection;

	}

	public boolean canFlipToNextPage() {

		if (dbConn != null)
			return true;

		return false;
	}

	public IWizardPage getNextPage() {

		IWizardPage nextPage = null;

		if (dbConn != null) {

			try {
				((DataServiceCreationWizard) getWizard()).dbdPage.init(dbConn);
			} catch (SQLException e) {

				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
				                              e.toString());

				return null;
			}
			nextPage = ((DataServiceCreationWizard) getWizard()).dbdPage;

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error !",
			                              "Error occurs while accessing the Database");

		}

		return nextPage;

	}

	private void setDBDetails(HashMap<String, String> details) {

		if (details != null) {

			dbDetails = details;
		}
	}

	public void handleEvent(Event event) {

		if (event.widget != testConnBtn) {
			clearConnection();
			generateDbUrl();
		}
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();

	}

	private void clearConnection() {

		dbConn = null;
	}

	public boolean isPageComplete() {

		/*
		 * if(dbConn != null)
		 * return true;
		 */
		return false;
	}

}
