package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.carbon.tools.converter.BundleGeneratorTool;
import org.xml.sax.SAXException;

public class DependancyProvider extends Dialog {

	public static final String OS_NAME = "os.name";
	public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
	public static final String OS_TYPE_MAC = "mac";
	public static final String OS_TYPE_DARWIN = "darwin";
	public static final String EI_TOOLING_HOME_MACOS = "/Applications/DeveloperStudio.app/Contents/MacOS";
	public static final String EMPTY_STRING = "";

	private Shell shell;
	private Display display;

	private Combo connectiontype;
	private Combo version;
	private String groupId;
	private String artifactId;
	private Label infoLabel;

	private String eclipseWorkspace;
	private String activeProjectName;

	private Text hostText;
	private Text portText;
	private Text userNameText;
	private Text passwordText;
	private Text databaseText;
	private Text jarLocationText;

	private String jarOutputPath;
	private String jdbcDriver;
	private String databaseProtocol;
	private String databaseURL;
	private String userName;
	private String password;
	private String connectionType;
	private String jdbcConnectivityJar;
	private String dependencyDir;

	private Label lblConnectionValidate;
	private Label lblVersionValidate;
	private Label lblBrowseValidate;
	private Label lblHostValidate;
	private Label lblPortValidate;
	private Label lblUsernameValidate;
	private Label lblPasswordValidate;
	private Label lblDatabaseValidate;

	private Button btnDownload;

	private ConnectionObj connectionObj;

	private ProgressMonitorDialog progressMonitorDialog;

	static ArrayList<Dependency> dependencyList;

	private String databaseArr[] = new String[] { "MYSQL", "MSSQL", "ORACLE", "POSTGRESQL", "OTHER" };
	private String mysqlVersionArr[] = new String[] { "8.0.15", "8.0.14", "5.1.47", "5.1.46" };
	private String mssqlVersionArr[] = new String[] { "6.4.0.jre8", "7.2.0.jre8" };
	private String postgresSqlVersionArr[] = new String[] { "42.2.5" };
	private String oracleVersionArr[] = new String[] { "10.2.0.4.0" };

	private static final String microesbLibPath = "runtime" + File.separator + "microesb" + File.separator + "lib";

	public DependancyProvider(Shell parent) {
		super(parent);
		eclipseWorkspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart != null) {
			IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
			IFile file = input.getFile();
			IProject activeProject = file.getProject();
			activeProjectName = activeProject.getName();
		}
		jarOutputPath = eclipseWorkspace + File.separator + activeProjectName + File.separator + "dependancies";
		dependencyDir = eclipseWorkspace + File.separator + activeProjectName + File.separator + "dependancies";
	}

	void open(final ConnectionObj connectionObj) {
		this.connectionObj = connectionObj;
		databaseProtocol = connectionObj.getJdbcProtocol();
		jdbcDriver = connectionObj.getDbDriver();

		display = PlatformUI.getWorkbench().getDisplay();
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Database Configuration");
		shell.setLayout(new FillLayout());

		FormToolkit toolkit = new FormToolkit(display);
		Form form = toolkit.createForm(shell);
		toolkit.decorateFormHeading(form);
		form.setText("Database Configuration");
		form.setFont(new Font(display, "Tahoma", 18, SWT.BOLD));
		form.setBackground(new Color(display, 237, 237, 237));
		form.getBody().setLayout(new GridLayout());
		form.getBody().setForeground(new Color(display, 0, 0, 0));

		GridData gridData = new GridData();
		Composite composite = new Composite(form.getBody(), SWT.BORDER);
		GridLayout gridLayout = new GridLayout(9, false);
		gridLayout.horizontalSpacing = -3;
		composite.setLayout(gridLayout);

		Label connectionLabel = new Label(composite, SWT.NONE);
		connectionLabel.setText("Connection Type: ");
		gridData = new GridData();
		gridData.widthHint = 150;
		connectionLabel.setLayoutData(gridData);

		lblConnectionValidate = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 15;
		lblConnectionValidate.setLayoutData(gridData);

		connectiontype = new Combo(composite, SWT.READ_ONLY);
		connectiontype.setItems(databaseArr);
		connectiontype.setText("Select Connection Type");
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 7;
		gridData.grabExcessHorizontalSpace = true;
		connectiontype.setLayoutData(gridData);

		Label versionLabel = new Label(composite, SWT.NONE);
		versionLabel.setText("Verison:");
		gridData = new GridData();
		versionLabel.setLayoutData(gridData);
		lblVersionValidate = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 15;
		lblVersionValidate.setLayoutData(gridData);

		version = new Combo(composite, SWT.READ_ONLY);
		version.setItems(new String[] { "Select Version" });

		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 7;
		gridData.grabExcessHorizontalSpace = true;
		version.setLayoutData(gridData);

		Label browseLabel = new Label(composite, SWT.NONE);
		browseLabel.setText("Browse:");
		gridData = new GridData();
		browseLabel.setLayoutData(gridData);

		lblBrowseValidate = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 15;
		lblBrowseValidate.setLayoutData(gridData);

		jarLocationText = new Text(composite, SWT.BORDER);
		jarLocationText.setText("");
		gridData = new GridData();
		gridData.horizontalSpan = 6;
		gridData.grabExcessHorizontalSpace = true;
		gridData.widthHint = 445;
		gridData.minimumWidth = 485;
		jarLocationText.setLayoutData(gridData);

		Button btnLocate = new Button(composite, SWT.NULL);
		btnLocate.setText("...");
		gridData = new GridData();
		btnLocate.setLayoutData(gridData);

		btnDownload = new Button(composite, SWT.NULL);
		btnDownload.setText("Download");
		btnDownload.setLocation(new Point(400, 0));
		gridData = new GridData();
		gridData.horizontalSpan = 9;
		gridData.horizontalAlignment = SWT.END;
		btnDownload.setLayoutData(gridData);

		composite = new Composite(form.getBody(), SWT.BORDER);
		gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft = 5;
		gridLayout.marginBottom = 10;
		composite.setLayout(gridLayout);

		Group outerGroup = new Group(composite, SWT.NULL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);

		outerGroup.setLayoutData(gridData);

		gridLayout = new GridLayout(3, false);
		gridLayout.marginRight = -3;
		gridLayout.marginBottom = 5;
		outerGroup.setLayout(gridLayout);
		outerGroup.setText("Connection");

		Label hostLabel = new Label(outerGroup, SWT.NONE);
		hostLabel.setSize(50, 50);
		hostLabel.setText("host:");

		gridData = new GridData();
		gridData.minimumWidth = 130;
		gridData.grabExcessHorizontalSpace = true;
		hostLabel.setLayoutData(gridData);

		lblHostValidate = new Label(outerGroup, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 15;
		lblHostValidate.setLayoutData(gridData);

		hostText = new Text(outerGroup, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.widthHint = 480;
		hostText.setLayoutData(gridData);
		hostText.setText("");

		Label portLabel = new Label(outerGroup, SWT.NONE);
		portLabel.setText("Port:");
		gridData = new GridData();
		portLabel.setLayoutData(gridData);

		lblPortValidate = new Label(outerGroup, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 10;
		lblPortValidate.setLayoutData(gridData);

		portText = new Text(outerGroup, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;

		portText.setLayoutData(gridData);
		portText.setText("");

		Label userLabel = new Label(outerGroup, SWT.NONE);
		userLabel.setText("user name:");

		lblUsernameValidate = new Label(outerGroup, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 10;
		lblUsernameValidate.setLayoutData(gridData);

		userNameText = new Text(outerGroup, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		userNameText.setLayoutData(gridData);
		userNameText.setText("");

		Label passwordLabel = new Label(outerGroup, SWT.NONE);
		passwordLabel.setText("password:");

		lblPasswordValidate = new Label(outerGroup, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 10;
		lblPasswordValidate.setLayoutData(gridData);

		passwordText = new Text(outerGroup, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		passwordText.setLayoutData(gridData);
		passwordText.setText("");

		Label databaseLabel = new Label(outerGroup, SWT.NONE);
		databaseLabel.setText("database:");

		lblDatabaseValidate = new Label(outerGroup, SWT.NONE);
		gridData = new GridData();
		gridData.widthHint = 10;
		lblDatabaseValidate.setLayoutData(gridData);

		databaseText = new Text(outerGroup, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		databaseText.setLayoutData(gridData);
		databaseText.setText("");

		composite = new Composite(form.getBody(), SWT.APPLICATION_MODAL);
		gridLayout = new GridLayout(3, false);
		gridLayout.horizontalSpacing = 1;
		gridLayout.marginLeft = 390;
		gridLayout.marginRight = -5;
		composite.setLayout(gridLayout);
		composite.setBackground(new Color(display, 237, 237, 237));

		gridData = new GridData(GridData.END, GridData.END, false, false);
		Button testConnectionBtn = new Button(composite, SWT.NULL);
		testConnectionBtn.setText("Test Connection");
		testConnectionBtn.setLayoutData(gridData);

		Button okBtn = new Button(composite, SWT.NULL);
		okBtn.setText("  Save  ");
		gridData = new GridData(GridData.END, GridData.END, false, false);
		okBtn.setLayoutData(gridData);

		Button cancelBtn = new Button(composite, SWT.NULL);
		cancelBtn.setText("Cancel");
		gridData = new GridData(GridData.END, GridData.END, false, false);
		cancelBtn.setLayoutData(gridData);

		connectiontype.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				clearRequiredFeilds();
				version.setEnabled(true);
				remove(jdbcConnectivityJar);
				remove(jarLocationText.getText());
				switch (connectiontype.getText()) {
				case "MYSQL":
					version.setItems(mysqlVersionArr);
					groupId = "mysql";
					artifactId = "mysql-connector-java";
					jdbcDriver = "com.mysql.jdbc.Driver";
					setDefaults("localhost", "3306", "root", "password", "database");
					databaseProtocol = "jdbc:mysql://";
					break;

				case "MSSQL":
					version.setItems(mssqlVersionArr);
					groupId = "com.microsoft.sqlserver";
					artifactId = "mssql-jdbc";
					jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					setDefaults("localhost", "1433", "root", "password", "database");
					databaseProtocol = "jdbc:sqlserver://";
					break;

				case "ORACLE":
					btnDownload.setEnabled(false);
					version.setItems(oracleVersionArr);
					groupId = "com.oracle";
					artifactId = "ojdbc14";
					jdbcDriver = "com.oracle.jdbc.Driver";
					databaseProtocol = "jdbc:oracle:thin:@";
					break;

				case "POSTGRESQL":
					version.setItems(postgresSqlVersionArr);
					groupId = "org.postgresql";
					artifactId = "postgresql";
					jdbcDriver = "com.postgres.jdbc.Driver";
					setDefaults("localhost", "5432", "root", "password", "database");
					databaseProtocol = "jdbc:postgresql://";
					break;

				case "OTHER":

					break;
				}

				jarLocationText.setText("");
				File dir = new File(dependencyDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println(connectiontype.getText());
			}
		});

		version.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				remove(jdbcConnectivityJar);
				remove(jarLocationText.getText());
				if ((connectionObj.getDbType() != null && connectionObj.getVersion() != null)) {
					remove(getDownlodedJarByName(connectionObj.getDbType(), connectionObj.getVersion()));
				}
				jarLocationText.setText("");
				if (!connectiontype.getText().equals("ORACLE") && (jarLocationText.getText() == null || jarLocationText.getText().equals(""))
						&& !version.getText().equals("Select Version") && !version.getText().isEmpty()
						&& version.getText() != null && !connectiontype.getText().equals("")
						&& connectiontype.getText() != null ) {
					btnDownload.setEnabled(true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}

		});

		ModifyListener listener = new ModifyListener() {
			/** {@inheritDoc} */
			public void modifyText(ModifyEvent e) {
				// Handle event
				if (connectiontype.getText().equals("ORACLE") || jarLocationText.getText() != null
						|| version.getText().equals("Select Version") || version.getText().equals("")
						|| version.getText() == null) {
					btnDownload.setEnabled(false);
				}
				if ((jarLocationText.getText() == null || jarLocationText.getText().equals(""))
						&& !version.getText().equals("Select Version") && !version.getText().isEmpty()
						&& version.getText() != null && !connectiontype.getText().equals("")
						&& connectiontype.getText() != null && !connectiontype.getText().equals("ORACLE")) {
					btnDownload.setEnabled(true);
				}
			}
		};

		jarLocationText.addModifyListener(listener);
		jarLocationText.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				// TODO Auto-generated method stub
				if (validate()) {
					if (jarLocationText.getText() != null && !jarLocationText.getText().equals("")) {
						if (e.keyCode == SWT.CR) {
							creatBundleFromJar(jarLocationText.getText());
						}
					}
				}
			}
		});
		jarLocationText.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event e) {
				if (connectiontype.getText().equals("ORACLE")) {
				   btnDownload.setEnabled(false);
				}
			}
		});

		btnLocate.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				FileDialog dialog = new FileDialog(shell, SWT.NULL);
				String path = dialog.open();
				creatBundleFromJar(path);
			}
		});

		btnDownload.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				List<Dependency> denpendency = new ArrayList<Dependency>();
				System.out.println("groupId" + groupId);
				System.out.println(artifactId);
				System.out.println(version.getText());
				denpendency.add(new Dependency(groupId, artifactId, version.getText()));
				createPOM(denpendency);
				progressMonitorDialog = new ProgressMonitorDialog(shell);
				try {
					progressMonitorDialog.run(true, true, new LongRunningOperation(true, shell));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		okBtn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {

				fillConnectionObj();
				String microInteratorPath = getWorkingDirectory() + File.separator + microesbLibPath;

				try {
					File file = new File(eclipseWorkspace + File.separator + activeProjectName + File.separator
							+ "dependancies" + File.separator
							+ getDownlodedJarByName(connectiontype.getText(), version.getText()));

					if (file.exists()) {
						FileUtils.copyFile(file, new File(microInteratorPath + File.separator + file.getName()));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				remove(jdbcConnectivityJar);

				shell.dispose();
			}
		});

		testConnectionBtn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				if (!validate()) {
					testConnecton();
				}
			}
		});

		cancelBtn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {	
				remove(jdbcConnectivityJar);
				remove(getDownlodedJarByName(connectiontype.getText(), version.getText()));
				remove(dependencyDir + "/target");
				remove(dependencyDir + "/pom.xml");
				shell.dispose();
			}
		});

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				remove(jdbcConnectivityJar);
				remove(getDownlodedJarByName(connectiontype.getText(), version.getText()));
			}
		});

		connectiontype.select(getDatabaseIndex(databaseArr, connectionObj.getDbType()));

		hostText.setText(connectionObj.getHost());
		portText.setText(connectionObj.getPort());
		userNameText.setText(connectionObj.getUserName());
		passwordText.setText(connectionObj.getPassword());
		databaseText.setText(connectionObj.getDatabase());
		jarLocationText.setText(connectionObj.getJarPath());

		if (connectionObj.getVersion() != null || !connectionObj.getVersion().equals("")) {
			version.setEnabled(false);
		}

		version.setItems(new String[] { connectionObj.getVersion() });
		version.select(0);
		shell.setSize(450, 400);
		shell.pack();

		Monitor primary = display.getPrimaryMonitor();

		/** get the size of the screen */
		Rectangle bounds = primary.getBounds();

		/** get the size of the window */
		Rectangle rect = shell.getBounds();

		/** calculate the centre */
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		/** set the new location */
		shell.setLocation(x, y);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	boolean changeLabelColor(Label label, Color color, String text) {
		label.setText(text);
		label.setForeground(color);
		return true;
	}

	void clearRequiredFeilds() {
		lblConnectionValidate.setText("");
		lblVersionValidate.setText("");
		lblBrowseValidate.setText("");
		lblHostValidate.setText("");
		lblPortValidate.setText("");
		lblUsernameValidate.setText("");
		lblDatabaseValidate.setText("");
	}

	void fillConnectionObj() {
		connectionObj.setDbType(connectiontype.getText());
		connectionObj.setDbDriver(jdbcDriver);
		connectionObj.setUserName(userNameText.getText());
		connectionObj.setPassword(passwordText.getText());
		connectionObj.setDatabase(databaseText.getText());
		connectionObj.setHost(hostText.getText());
		connectionObj.setPort(portText.getText());
		connectionObj.setVersion(version.getText());
		connectionObj.setJarPath(jarLocationText.getText());
		connectionObj.setJdbcProtocol(databaseProtocol);
		databaseURL = generateDbUrl(connectiontype.getText());
		connectionObj.setUrl(databaseURL);
	}

	void creatBundleFromJar(String path) {
		if (path != null) {

			File file = new File(path);
			if (file.isFile()) {

				String fileName = file.getName().replaceAll("-", "_");
				String pluginName = fileName.substring(0, fileName.length() - 4) + "_1.0.0.jar";
				jarLocationText.setText(path);
				BundleGeneratorTool bcg = new BundleGeneratorTool();
				String p[] = { path, dependencyDir, dependencyDir };
				bcg.execute(p);

				jdbcConnectivityJar = dependencyDir + File.separator + pluginName;
			}
		}
	}

	boolean validate() {
		final Color redColor = new Color(display, 255, 0, 0);
		boolean hasErrors = false;

		if (connectiontype.getText().equals("") || connectiontype.getText().equals("")) {
			hasErrors = changeLabelColor(lblConnectionValidate, redColor, " *");
		}
		if (version.getText().equals("") || version.getText().equals("Select Version")) {
			hasErrors = changeLabelColor(lblVersionValidate, redColor, " *");
		}
		if (jarLocationText.getText().equals("") && !btnDownload.isEnabled()) {
			hasErrors = changeLabelColor(lblBrowseValidate, redColor, " *");
		}
		if (hostText.getText().equals("")) {
			hasErrors = changeLabelColor(lblHostValidate, redColor, "*");
		}
		if (portText.getText().equals("")) {
			hasErrors = changeLabelColor(lblPortValidate, redColor, "*");
		}
		if (userNameText.getText().equals("")) {
			hasErrors = changeLabelColor(lblUsernameValidate, redColor, "*");
		}
		if (databaseText.getText().equals("")) {
			hasErrors = changeLabelColor(lblDatabaseValidate, redColor, "*");
		}

		return hasErrors;
	}

	void remove(String path) {
		if (path != null) {
			File dir = new File(path);
			if (dir.exists()) {
				try {
					FileUtils.forceDelete(new File(path));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	void setDefaults(String host, String port, String user, String password, String database) {
		hostText.setText(host);
		portText.setText(port);
		userNameText.setText(user);
		passwordText.setText(password);
		databaseText.setText(database);
	}

	String getDownlodedJarByName(String connectionType, String version) {

		switch (connectionType) {
		case "MYSQL":
			return "mysql-connector-java-" + version + ".jar";

		case "MSSQL":
			return "mssql-jdbc-" + version + ".jar";

		case "POSTGRESQL":
			return "postgresql-" + version + ".jar";
		}
		return null;
	}

	String generateDbUrl(String dbType) {
		if (dbType.equals("MSSQL")) {
			return databaseProtocol + hostText.getText() + ":" + portText.getText() + ";databaseName="
					+ databaseText.getText() + ";";
		} else {
			System.out.println("databaseProtocol" + databaseProtocol);
			return databaseProtocol + hostText.getText() + ":" + portText.getText() + "/" + databaseText.getText();
		}
	}

	void testConnecton() {
		creatBundleFromJar(
				dependencyDir + File.separator + getDownlodedJarByName(connectiontype.getText(), version.getText()));
		String path = "file://" + jdbcConnectivityJar;
		Connection conn = null;
		try {
			Bundle bundle = Platform.getBundle("org.wso2.developerstudio.eclipse.gmf.esb.edit");
			Bundle newBundle;
			databaseURL = generateDbUrl(connectiontype.getText());
			switch (connectiontype.getText()) {
			case "MYSQL":
				newBundle = bundle.getBundleContext().installBundle(path);
				newBundle.start();
				if (version.getText().equals("8.0.15") || version.getText().equals("8.0.14")) {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} else {
					Class.forName("com.mysql.jdbc.Driver");
				}
				break;
			case "MSSQL":
				newBundle = bundle.getBundleContext().installBundle(path);
				newBundle.start();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				break;
			case "POSTGRESQL":
				newBundle = bundle.getBundleContext().installBundle(path);
				newBundle.start();
				Class.forName("org.postgresql.Driver");
				break;
			case "ORACLE":
				newBundle = bundle.getBundleContext().installBundle(path);
				newBundle.start();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				break;
			default:
				break;
			}
			conn = DriverManager.getConnection(databaseURL, userNameText.getText(), passwordText.getText());
			if (conn != null) {
				showMessage("Connection Successful");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
		} catch (BundleException e) {
			e.printStackTrace();
			ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
		} catch (Exception e) {
			e.printStackTrace();
			ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	public void showMessage(String msg) {

		int style = SWT.ICON_INFORMATION | SWT.OK | SWT.CANCEL;
		MessageBox dia = new MessageBox(this.getParent(), style);
		dia.setText("Information");
		dia.setMessage(msg);
		int rc = dia.open();

		switch (rc) {
		case SWT.OK:
			System.out.println("SWT.OK");
			break;
		case SWT.CANCEL:
			System.out.println("SWT.CANCEL");
			break;
		}
	}

	public void isDpendancyAvailable(String name) {

		File dependancy = new File(dependencyDir + File.separator + name + ".jar");
		if (!dependancy.exists()) {
			infoLabel.setText("*Please download required dependancy");
		} else {
			infoLabel.setText("");
		}

	}

	public BufferedReader buildPOM() {

		try {
			File dir = new File(dependencyDir);
			Process p = Runtime.getRuntime().exec("mvn install clean", null, dir);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			p.destroy();
			return stdInput;
		} catch (IOException e) {
			progressMonitorDialog.close();
			ErrorDialog.openError(shell, "Error", "An error has occourred",
					createMultiStatus(e.getLocalizedMessage(), e));
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public void createPOM(List<Dependency> dependencyList) {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			File dir = new File(dependencyDir);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			File pomXML = new File(dependencyDir + File.separator + "pom.xml");

			if (pomXML.exists()) {
				document = documentBuilder.parse(pomXML);
				document.getDocumentElement().normalize();
				NodeList nList = document.getElementsByTagName("dependencies");
				Node ss = nList.item(0);
				addDepencisToPOM(dependencyList, ss, document);
			} else {
				document.setXmlStandalone(true);
				Element root = document.createElement("project");
				document.appendChild(root);

				Attr xmlns = document.createAttribute("xmlns");
				xmlns.setValue("http://maven.apache.org/POM/4.0.0");
				root.setAttributeNode(xmlns);

				Attr xmlnsXsi = document.createAttribute("xmlns:xsi");
				xmlnsXsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
				root.setAttributeNode(xmlnsXsi);

				Attr xsiSchemaLocation = document.createAttribute("xsi:schemaLocation");
				xsiSchemaLocation
						.setValue("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
				root.setAttributeNode(xsiSchemaLocation);

				Element modelVersion = document.createElement("modelVersion");
				modelVersion.appendChild(document.createTextNode("4.0.0"));
				root.appendChild(modelVersion);

				Element groupId = document.createElement("groupId");
				groupId.appendChild(document.createTextNode("com.wso2.test"));
				root.appendChild(groupId);

				Element artifactId = document.createElement("artifactId");
				artifactId.appendChild(document.createTextNode("test"));
				root.appendChild(artifactId);

				Element version = document.createElement("version");
				version.appendChild(document.createTextNode("1.0-SNAPSHOT"));
				root.appendChild(version);

				Element dependencies = document.createElement("dependencies");
				root.appendChild(dependencies);

				addDepencisToPOM(dependencyList, dependencies, document);

				Element build = document.createElement("build");
				root.appendChild(build);

				Element plugins = document.createElement("plugins");
				build.appendChild(plugins);

				Element plugin = document.createElement("plugin");
				plugins.appendChild(plugin);

				Element pGroupId = document.createElement("groupId");
				pGroupId.appendChild(document.createTextNode("org.apache.maven.plugins"));
				plugin.appendChild(pGroupId);

				Element pArtifactId = document.createElement("artifactId");
				pArtifactId.appendChild(document.createTextNode("maven-dependency-plugin"));
				plugin.appendChild(pArtifactId);

				Element pVersion = document.createElement("version");
				pVersion.appendChild(document.createTextNode("3.1.1"));
				plugin.appendChild(pVersion);

				Element executions = document.createElement("executions");
				plugin.appendChild(executions);

				Element execution = document.createElement("execution");
				executions.appendChild(execution);

				Element eId = document.createElement("id");
				eId.appendChild(document.createTextNode("copy-dependencies"));
				execution.appendChild(eId);

				Element phase = document.createElement("phase");
				phase.appendChild(document.createTextNode("package"));
				execution.appendChild(phase);

				Element goals = document.createElement("goals");
				execution.appendChild(goals);

				Element goal = document.createElement("goal");
				goal.appendChild(document.createTextNode("copy-dependencies"));
				goals.appendChild(goal);

				Element configuration = document.createElement("configuration");
				execution.appendChild(configuration);

				Element excludeArtifactIds = document.createElement("excludeArtifactIds");
				excludeArtifactIds.appendChild(document.createTextNode("protobuf-java"));
				configuration.appendChild(excludeArtifactIds);

				Element outputDirectory = document.createElement("outputDirectory");
				outputDirectory.appendChild(document.createTextNode(jarOutputPath));
				configuration.appendChild(outputDirectory);

				Element overWriteReleases = document.createElement("overWriteReleases");
				overWriteReleases.appendChild(document.createTextNode("false"));
				configuration.appendChild(overWriteReleases);

				Element overWriteSnapshots = document.createElement("overWriteSnapshots");
				overWriteSnapshots.appendChild(document.createTextNode("false"));
				configuration.appendChild(overWriteSnapshots);

				Element overWriteIfNewer = document.createElement("overWriteIfNewer");
				overWriteIfNewer.appendChild(document.createTextNode("true"));
				configuration.appendChild(overWriteIfNewer);

				Element cleanPlugin = document.createElement("plugin");
				plugins.appendChild(cleanPlugin);

				Element cArtifactId = document.createElement("artifactId");
				cArtifactId.appendChild(document.createTextNode("maven-clean-plugin"));
				cleanPlugin.appendChild(cArtifactId);

				Element cVersion = document.createElement("version");
				cVersion.appendChild(document.createTextNode("3.1.0"));
				cleanPlugin.appendChild(cVersion);

				Element cConfiguration = document.createElement("configuration");
				cleanPlugin.appendChild(cConfiguration);

				Element filesets = document.createElement("filesets");
				cConfiguration.appendChild(filesets);

				Element fileset = document.createElement("fileset");
				filesets.appendChild(fileset);

				Element directory = document.createElement("directory");
				directory.appendChild(document.createTextNode(dependencyDir));
				fileset.appendChild(directory);

				Element includes = document.createElement("includes");
				fileset.appendChild(includes);

				Element include = document.createElement("include");
				include.appendChild(document.createTextNode(dependencyDir + File.separator + "pom.xml"));
				includes.appendChild(include);

				Element followSymlinks = document.createElement("followSymlinks");
				followSymlinks.appendChild(document.createTextNode("false"));
				fileset.appendChild(followSymlinks);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(dependencyDir + File.separator + "pom.xml"));
			transformer.transform(domSource, streamResult);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addDepencisToPOM(List<Dependency> dependencyList, Node node, Document document) {

		for (Dependency d : dependencyList) {

			Element dependency = document.createElement("dependency");
			node.appendChild(dependency);

			System.out.println(node.toString());
			Element dGroupId = document.createElement("groupId");
			dGroupId.appendChild(document.createTextNode(d.getGroupId()));
			dependency.appendChild(dGroupId);

			Element dArtifactId = document.createElement("artifactId");
			dArtifactId.appendChild(document.createTextNode(d.getArtifactId()));
			dependency.appendChild(dArtifactId);

			Element dVersion = document.createElement("version");
			dVersion.appendChild(document.createTextNode(d.getVersion()));
			dependency.appendChild(dVersion);

		}
	}

	private String getWorkingDirectory() {
		String workingDirectory = null;
		String OS = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);

		if ((OS.indexOf(OS_TYPE_MAC) >= 0) || (OS.indexOf(OS_TYPE_DARWIN) >= 0)) {
			String eiToolingHomeForMac = EI_TOOLING_HOME_MACOS;
			File macOSEIToolingAppFile = new File(eiToolingHomeForMac);

			if (macOSEIToolingAppFile.exists()) {
				workingDirectory = eiToolingHomeForMac;
			} else {
				Path path = Paths.get(EMPTY_STRING);
				workingDirectory = (path).toAbsolutePath().toString();
			}

		} else {
			java.nio.file.Path path = Paths.get(EMPTY_STRING);
			workingDirectory = (path).toAbsolutePath().toString();
		}

		return workingDirectory;
	}

	private static MultiStatus createMultiStatus(String msg, Throwable t) {

		List<Status> childStatuses = new ArrayList<>();
		StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

		for (StackTraceElement stackTrace : stackTraces) {
			Status status = new Status(IStatus.ERROR, "org.wso2.developerstudio.eclipse.gmf.esb.edit",
					stackTrace.toString());
			childStatuses.add(status);
		}

		MultiStatus ms = new MultiStatus("org.wso2.developerstudio.eclipse.gmf.esb.edit", IStatus.ERROR,
				childStatuses.toArray(new Status[] {}), t.toString(), t);
		return ms;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setJarOutputPath(String jarOutputPath) {
		this.jarOutputPath = jarOutputPath;
	}

	class ConnectionObj {

		ConnectionObj() {
		}

		private String dbType;
		private String dbDriver;
		private String url;
		private String userName;
		private String password;
		private String host;
		private String port;
		private String database;
		private String version;
		private String jarPath;
		private String jdbcProtocol;

		public String getDbType() {
			return dbType;
		}

		public void setDbType(String dbType) {
			this.dbType = dbType;
		}

		public String getDbDriver() {
			return dbDriver;
		}

		public void setDbDriver(String dbDriver) {
			this.dbDriver = dbDriver;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getDatabase() {
			return database;
		}

		public void setDatabase(String database) {
			this.database = database;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getJarPath() {
			return jarPath;
		}

		public void setJarPath(String jarPath) {
			this.jarPath = jarPath;
		}

		public String getJdbcProtocol() {
			return jdbcProtocol;
		}

		public void setJdbcProtocol(String jdbcProtocol) {
			this.jdbcProtocol = jdbcProtocol;
		}

		@Override
		public String toString() {
			return "ConnectionObj [dbType=" + dbType + ", dbDriver=" + dbDriver + ", url=" + url + ", userName="
					+ userName + ", password=" + password + ", host=" + host + ", port=" + port + ", database="
					+ database + ", version=" + version + ", jarPath=" + jarPath + ", jdbcProtocol=" + jdbcProtocol
					+ "]";
		}

	}

	class Dependency {

		String groupId;
		String artifactId;
		String version;

		public Dependency(String groupId, String artifactId, String version) {
			super();
			this.groupId = groupId;
			this.artifactId = artifactId;
			this.version = version;
		}

		public String getGroupId() {
			return groupId;
		}

		public String getArtifactId() {
			return artifactId;
		}

		public String getVersion() {
			return version;
		}

	}

	class LongRunningOperation implements IRunnableWithProgress {
		private static final int TOTAL_TIME = 1000000000;
		private boolean indeterminate;
		private Shell shell;

		protected boolean downloadSuccess = true;;

		public LongRunningOperation(boolean indeterminate, Shell shell) {
			this.indeterminate = indeterminate;
			this.shell = shell;
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

			monitor.beginTask("Downloading Required Dependency JAR",
					indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_TIME);
			Thread.sleep(500);

			String s = "";
			try {
				File dir = new File(dependencyDir);

				final Process p = Runtime.getRuntime().exec("mvn install clean", null, dir);

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

				while ((s = stdInput.readLine()) != null) {

					System.out.println(s);

					if (monitor.isCanceled()) {
						p.destroy();
						Display.getDefault().syncExec(new Runnable() {
							public void run() {
								downloadSuccess = false;
								remove(dependencyDir + "/target");
								remove(dependencyDir + "/pom.xml");
								MessageDialog.openInformation(shell, "Cancelled",
										"JDBC driver download operation was cancelled");
								// cleanDirectory(eclipseWorkspace + "/" + activeProjectName + "/dependancies");
							}
						});

						throw new InterruptedException("JDBC driver download operation was cancelled");
					}
					monitor.worked(100);

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			monitor.done();

			if (downloadSuccess) {
				remove(dependencyDir + File.separator + "pom.xml");
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openInformation(shell, "Success", "JDBC driver was downloaded sucessfuly");
						creatBundleFromJar(dependencyDir + File.separator
								+ getDownlodedJarByName(connectiontype.getText(), version.getText()));
					}
				});
			}

		}
	}

	public int getDatabaseIndex(String arr[], String dbType) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(dbType)) {
				return i;
			}
		}
		return 0;
	}
}
