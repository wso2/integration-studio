package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.IManagedConnection;
import org.eclipse.datatools.connectivity.ProfileManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class ConnectionProfileReader {

	private static final String[] DB_TABLE_TYPES = { "TABLE" };

	private static final String TABLE_NAME = "TABLE_NAME";

	public IConnectionProfile[] getConectionProfiles() {

		IConnectionProfile[] profiles = ProfileManager.getInstance().getProfiles();

		return profiles;
	}

	public ArrayList<String> getTableNames(IConnectionProfile profile) {

		ArrayList<String> list = new ArrayList<String>();
		IStatus status = profile.connect();

		if (status.getCode() == IStatus.OK) {
			Connection conn = getJavaConnectionForProfile(profile);

			try {
				DatabaseMetaData dbMetaData = conn.getMetaData();
				ResultSet rs = dbMetaData.getTables(null, null, null, DB_TABLE_TYPES);

				while (rs.next()) {
					String tableName = rs.getString(TABLE_NAME);

					if (tableName != null) {
						list.add(tableName);
					}
				}

			} catch (SQLException e) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				                              "Error occurs while accessing the Database",
				                              e.toString());
			}

		} else {

			if (status.getException() != null) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				                              "Connection error occured", status.getException()
				                                                                .toString());

			}
		}

		return list;
	}

	public Connection getJavaConnectionForProfile(IConnectionProfile profile) {
		IManagedConnection managedConnection =
		                                       ((IConnectionProfile) profile).getManagedConnection("java.sql.Connection");
		if (managedConnection != null) {
			return (Connection) managedConnection.getConnection().getRawConnection();
		}
		return null;
	}

}
