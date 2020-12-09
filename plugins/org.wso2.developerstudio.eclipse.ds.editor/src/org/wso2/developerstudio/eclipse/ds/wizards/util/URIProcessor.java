package org.wso2.developerstudio.eclipse.ds.wizards.util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.UrlValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class URIProcessor {

	private static URIProcessor uriProcessor = null;

	private URIProcessor() {

	}

	public static URIProcessor getInstance() {

		if (uriProcessor == null) {

			uriProcessor = new URIProcessor();
		}

		return uriProcessor;
	}

	public HashMap<String, String> getProcessedURI(String input) {

		HashMap<String, String> details = new HashMap<String, String>();

		boolean isOnline = false;
		boolean isGspread = false;

		Pattern gspread_pattern = Pattern.compile(DBUriConstants.REGEX_GSS_SPREAD);
		Matcher gss_matcher = gspread_pattern.matcher(input);

		String[] schemes = { "http", "https" };
		UrlValidator urlValidator = new UrlValidator(schemes);

		if (input.length() > 4 && input.substring(0, 4).equals(DBUriConstants.REGEX_RDBMS)) {

			details = rdbmsProccesor(input);

		} else if (input.length() > 24 &&
		           (input.substring(0, 24).equals(DBUriConstants.GSS_TYPE.substring(0, 24)) && gss_matcher.find())) {
			isGspread = true;

			details.put(DBUriConstants.DB_TYPE, DBUriConstants.GSS_TYPE);

		} else if (input.length() > 36 && input.substring(0, 36).equals(DBUriConstants.GSS_TYPE)) {

			isGspread = true;

			details.put(DBUriConstants.DB_TYPE, DBUriConstants.GSS_TYPE);

		} else if (!isGspread && urlValidator.isValid(input)) {

			isOnline = true;

			if (extIdentifer(input).equals(DBUriConstants.CSV_TYPE)) {

				details.put(DBUriConstants.DB_TYPE, DBUriConstants.CSV_TYPE_ONLIN);

			} else if (extIdentifer(input).equals(DBUriConstants.XLS_TYPE)) {

				details.put(DBUriConstants.DB_TYPE, DBUriConstants.XLS_TYPE_ONLIN);
			}

		} else if (!isOnline && extIdentifer(input).equals(DBUriConstants.CSV_TYPE)) {

			details.put(DBUriConstants.DB_TYPE, DBUriConstants.CSV_TYPE);

		} else if (!isOnline && extIdentifer(input).equals(DBUriConstants.XLS_TYPE)) {

			details.put(DBUriConstants.DB_TYPE, DBUriConstants.XLS_TYPE);

		} else {

			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "DB URL not in correct Format", "Error!");

		}

		return details;
	}

	private HashMap<String, String> rdbmsProccesor(String input) {

		HashMap<String, String> detailMap = new HashMap<String, String>();

		detailMap.put(DBUriConstants.RDBMS_FLAG, DBUriConstants.REGEX_RDBMS);
		detailMap.put(DBUriConstants.DB_URL, input);

		Pattern p = Pattern.compile(DBUriConstants.REGEX_COLON);
		String[] items = p.split(input);

		if (items.length >= 2) {

			if (items[1].equals(DBUriConstants.MYSQL_ID)) {

				/*
				 * "jdbc:mysql://[machine-name/ip]:[port]/[database-name]"
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.MYSQL_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.MY_SQL_DRIVER);

				if (items.length == 4) {

					detailMap.put(DBUriConstants.HOST, items[2].substring(2)); // host

					String[] t = items[3].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]); // port

						detailMap.put(DBUriConstants.DB_NAME, t[1]); // db name

					}
				}

			} else if (items[1].equals(DBUriConstants.DERBY_ID)) {

				/*
				 * "jdbc:derby:[path-to-data-file]"
				 */
				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.DERBY_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.DERBY_DRIVER);

				if (items.length == 3) {

					detailMap.put(DBUriConstants.DB_FILE_PATH, items[2]);

				}

			} else if (items[1].equals(DBUriConstants.MS_SQL_ID)) {

				/*
				 * "jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]"
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.MS_SQL_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.MS_SQL_DRIVER);

				if (items.length == 4) {

					detailMap.put(DBUriConstants.HOST, items[2].substring(2)); // host

					String[] t = items[3].split(DBUriConstants.REGEX_SCOLON);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]);

						int brk = t[1].lastIndexOf("=");

						if (brk != -1) {

							detailMap.put(DBUriConstants.DB_NAME, t[1].substring(brk + 1));
						}

					}

				}

			} else if (items[1].equals(DBUriConstants.ORACLE_ID)) {

				/*
				 * jdbc:oracle:thin:@//HOST:PORT/SERVICE
				 * 
				 * jdbc:oracle:thin:USER/PASSWORD@HOST:PORT:SID
				 * 
				 * jdbc:oracle:thin:USER/PASSWORD@HOST:PORT/SERVICE
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.ORACLE_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.ORACLE_DRIVER);

				if (items.length == 5) {

					detailMap.put(DBUriConstants.DB_DRIVE_TYPE, items[2]); // drive
					                                                       // type

					if (items[3].contains("@//")) {

						detailMap.put(DBUriConstants.HOST, items[3].substring(3));
						detailMap.put(DBUriConstants.ORC_TYPE, DBUriConstants.ORC_TYPE_ONE);

					} else {

						String[] q = items[3].split(DBUriConstants.REGEX_AT);

						detailMap.put(DBUriConstants.ORC_TYPE, DBUriConstants.ORC_TYPE_TWO);

						if (q.length == 2) {

							String[] r = q[0].split(DBUriConstants.REGEX_SLASH);

							if (r.length == 2) {

								detailMap.put(DBUriConstants.DB_U_NAME, r[0]);

								detailMap.put(DBUriConstants.DB_PASSWD, r[1]);

							}

							detailMap.put(DBUriConstants.HOST, q[1]);

						}

					}

					String[] t = items[4].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]); // port

						detailMap.put(DBUriConstants.DB_NAME, t[1]); // name

					}

				} else if (items.length == 6) {

					detailMap.put(DBUriConstants.DB_DRIVE_TYPE, items[2]); // drive
					                                                       // type
					detailMap.put(DBUriConstants.ORC_TYPE, DBUriConstants.ORC_TYPE_THREE);
					String[] q = items[3].split(DBUriConstants.REGEX_AT);

					if (q.length == 2) {

						String[] r = q[0].split(DBUriConstants.REGEX_SLASH);

						if (r.length == 2) {

							detailMap.put(DBUriConstants.DB_U_NAME, r[0]);

							detailMap.put(DBUriConstants.DB_PASSWD, r[1]);

						}

						detailMap.put(DBUriConstants.HOST, q[1]);

					}

					detailMap.put(DBUriConstants.PORT, items[4]);

					detailMap.put(DBUriConstants.DB_NAME, items[5]);

				}

			} else if (items[1].equals(DBUriConstants.DB2_ID)) {

				/*
				 * "jdbc:db2:[database]"
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.DB2_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.DB2_DRIVER);

				if (items.length == 3) {

					detailMap.put(DBUriConstants.DB_NAME, items[2]);

				}

			} else if (items[1].equals(DBUriConstants.HSQL_ID)) {

				/*
				 * jdbc:hsqldb:[path]
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.HSQL_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.HSQL_DRIVER);

				if (items.length == 3) {

					detailMap.put(DBUriConstants.DB_FILE_PATH, items[2]);

				}

			} else if (items[1].equals(DBUriConstants.INFORMIX_ID)) {

				/*
				 * jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[
				 * server-name]
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.INFORMIX_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.INFORMIX_DRIVER);

				if (items.length == 5) {

					detailMap.put(DBUriConstants.HOST, items[2].substring(2));

					String[] t = items[3].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]);

						detailMap.put(DBUriConstants.DB_NAME, t[1]);

					}

					int brk = items[4].lastIndexOf("=");

					if (brk != -1) {
						detailMap.put(DBUriConstants.DB_SERVER_NAME, items[4].substring(brk + 1));
					}

				}

			} else if (items[1].equals(DBUriConstants.POSTGRESQL_ID)) {

				/*
				 * jdbc:postgresql://[HOST]:[PORT5432]/[database]
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.POSTGRESQL_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.POSTGRESQL_DRIVER);

				if (items.length == 4) {

					detailMap.put(DBUriConstants.HOST, items[2].substring(2)); // host

					String[] t = items[3].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]); // port

						detailMap.put(DBUriConstants.DB_NAME, t[1]); // db name

					}
				}

			} else if (items[1].equals(DBUriConstants.SYBASE_ID)) {

				/*
				 * jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.SYBASE_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.SYBASE_DRIVER);

				if (items.length == 5) {

					detailMap.put(DBUriConstants.HOST, items[3]);

					String[] t = items[4].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]);

						detailMap.put(DBUriConstants.DB_NAME, t[1]);

					}

				}

			} else if (items[1].equals(DBUriConstants.H2_ID)) {

				/*
				 * jdbc:h2:tcp:[HOST]:[PORT]/[database]
				 */

				detailMap.put(DBUriConstants.DB_TYPE, DBUriConstants.H2_ID);
				detailMap.put(DBUriConstants.DB_DRIVER, DBUriConstants.H2_DRIVER);

				if (items.length == 5) {

					detailMap.put(DBUriConstants.HOST, items[3]);

					String[] t = items[4].split(DBUriConstants.REGEX_SLASH);

					if (t.length == 2) {

						detailMap.put(DBUriConstants.PORT, t[0]);

						detailMap.put(DBUriConstants.DB_NAME, t[1]);

					}
				}

			} else {

				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				                              "DB URL not in corret Format", "Error!");
			}

		} else {

			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
			                              "DB URL not in corret Format", "Error!");

		}

		return detailMap;
	}

	private String extIdentifer(String input) {

		int dotPosition = input.lastIndexOf(".");
		String extension = "";
		if (dotPosition != -1) {
			extension = input.substring(dotPosition);

			if (extension.equals(DBUriConstants.CSV_TYPE)) {
				return DBUriConstants.CSV_TYPE;
			} else if (extension.equals(DBUriConstants.XLS_TYPE)) {
				return DBUriConstants.XLS_TYPE;
			}

		}
		return DBUriConstants.NO_TYPE;
	}

	public Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();

	}

}
