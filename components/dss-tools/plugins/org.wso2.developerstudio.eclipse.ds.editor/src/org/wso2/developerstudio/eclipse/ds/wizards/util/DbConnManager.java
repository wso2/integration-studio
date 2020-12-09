package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class DbConnManager {

	private static DbConnManager dbConnManager = null;
	private Connection dbConn;

	private DbConnManager() {

	}

	public static DbConnManager getInstance() {

		if (dbConnManager == null) {

			dbConnManager = new DbConnManager();
		}
		return dbConnManager;
	}

	public boolean testConnection(String dbURL, String dbUsername, String dbPassword,
	                              String driverURL, String driverClass)
	                                                                   throws MalformedURLException,
	                                                                   InstantiationException,
	                                                                   IllegalAccessException,
	                                                                   ClassNotFoundException,
	                                                                   SQLException {
		Connection connection = null;
		boolean isConnAlive = false;
		// try {

		URL url = new URL("jar:file:" + driverURL + "!/");

		URLClassLoader ucl = new URLClassLoader(new URL[] { url });

		Driver driver = (Driver) Class.forName(driverClass, true, ucl).newInstance();

		DriverManager.registerDriver(new DriverShim(driver));

		connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		if (connection != null) {
			isConnAlive = true;
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Success!",
			                              "Ping Succeeded!");
		} else {

			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Error!",
			                              "Ping Failed!");
		}

		/*
		 * //} catch (MalformedURLException e) {
		 * MessageDialog.openInformation(Display.getCurrent()
		 * .getActiveShell(), "Error!", e.toString());
		 * }catch (InstantiationException e) {
		 * MessageDialog.openInformation(Display.getCurrent()
		 * .getActiveShell(), "Error!", e.toString());
		 * } catch (IllegalAccessException e) {
		 * MessageDialog.openInformation(Display.getCurrent()
		 * .getActiveShell(), "Error!", e.toString());
		 * } catch (ClassNotFoundException e) {
		 * MessageDialog.openInformation(Display.getCurrent()
		 * .getActiveShell(), "Error!", e.toString());
		 * } catch (SQLException e) {
		 * MessageDialog.openInformation(Display.getCurrent()
		 * .getActiveShell(), "Error!", e.toString());
		 * }
		 */

		return isConnAlive;

	}

	public Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();

	}

}
