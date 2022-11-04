/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.integrationstudio.ds.wizards.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.ds.editors.DSSMultiPageEditor;
import org.wso2.integrationstudio.ds.presentation.DsEditorPlugin;
import org.wso2.integrationstudio.ds.presentation.util.DSSVisualEditorConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

/**
 * This class contains utility methods for the DSS editor.
 *
 */
public class DSSEditorUtils {

    private static volatile DSSEditorUtils instance;

    // Path to the properties file where editor-related meta data is saved.
    private static final String PROPERTIES_FILE_PATH = File.separator + ".metadata" + File.separator
            + "integration-studio.dsseditor.properties";    
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    //relative path to where microesb is packaged
    public static final String MICRO_ESB_PATH = "runtime" + File.separator + "microesb";

    private static IIntegrationStudioLog log = Logger.getLog("org.wso2.integrationstudio.ds.editor");

    public static DSSEditorUtils getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (DSSEditorUtils.class) {
            if (instance == null) {
                instance = new DSSEditorUtils();
            }
        }

        return instance;
    }

    private DSSEditorUtils() {
    };

    /**
     * Saves a property to the configured property file.
     * 
     * @param propertyName Name of the property.
     * @param value Value of the property.
     * @param comments Description of the property.
     * @return 'True' if successfully saved, 'False' otherwise.
     * @throws IOException
     */
    public boolean saveProperty(String propertyName, String value, String comments) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        String configFilePath = workspaceDirectory.getAbsolutePath() + PROPERTIES_FILE_PATH;
        File confFile = new File(configFilePath);
        OutputStream output = null;
        InputStream input = null;

        // Create properties file if does not exist
        if (!confFile.exists()) {
            try {
                confFile.createNewFile();
            } catch (IOException e) {
                log.error("Error occurred while creating the property file.", e);
                return false;
            }
        }

        try {
            // Load existing properties
            input = new FileInputStream(configFilePath);
            Properties properties = new Properties();
            properties.load(input);
            input.close();

            // If exists, delete
            if (properties.get(propertyName) != null) {
                properties.remove(propertyName);
            }

            // Add new property
            properties.setProperty(propertyName, value);

            // Write back to file
            output = new FileOutputStream(configFilePath);
            properties.store(output, comments);
            output.close();

            return true;
        } catch (IOException e) {
            log.error("Error occurred while saving the property.", e);
            return false;
        }
    }

    /**
     * Retrieves a property from the configured property file.
     * 
     * @param propertyName Name of the property.
     * @return Property value | null if does not exist.
     */
    public String getPropertyValue(String propertyName) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        String configFilePath = workspaceDirectory.getAbsolutePath() + PROPERTIES_FILE_PATH;
        File confFile = new File(configFilePath);

        if (confFile.exists()) {
            try (InputStream input = new FileInputStream(configFilePath)) {
                Properties properties = new Properties();
                properties.load(input);
                input.close();
                return properties.getProperty(propertyName);
            } catch (IOException e) {
                log.error("Error occurred while retrieving the property.", e);
                return null;
            }
        } else {
            log.error("Property file does not exist.");
            return null;
        }
    }

    /**
     * Get data source details from properties.
     * 
     * @param datasourceId Data source ID.
     * @return Data source details.
     */
    public String getDSDetails(String dataSourceId) {
        return getPropertyValue(dataSourceId);
    }

    /**
     * Saves data source details to the configured property file.
     * 
     * @param dataSourceId Data source ID.
     * @param details Data source details as a string.
     * @return 'True' of successfully saved, 'False' otherwise.
     */
    public boolean saveDSDetails(String dataSourceId, String details) {
        return saveProperty(dataSourceId, details, null);
    }

    /**
     * Tests connection to a database.
     * 
     * @param dbType Type of the database (mysql, oracle, etc.)
     * @param username Login username.
     * @param password Login password.
     * @return 'True' if connection is successful, 'False' otherwise.
     */
    public boolean testDBConnection(String dbType, String version, String username, String password, String host,
            String port, String dbName) {
        Connection connection = getConnection(dbType, version, username, password, host, port, dbName);
        
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns a string which consists of column names retrieved from the DB.
     * 
     * @param sqlStr SQL query.
     * @param dbEngine Database engine.
     * @return A comma-separated string of column names.
     */
    public String generateMappings(String sqlStr, String conUrl, String username, String password) {
        List<String> mappings = new ArrayList<>();
        String columnListStr = "";
        Connection connection = getConnectionFromUrl(conUrl, username, password);
        
        if (connection != null) {
            PreparedStatement pstmt;
            ResultSetMetaData metaData;
            try {
                pstmt = connection.prepareStatement(sqlStr);
                metaData = pstmt.getMetaData();
                // Column indexes start from 1
                
                if (metaData == null) {
                    return "";
                }
                
                for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                    mappings.add(metaData.getColumnName(i));
                }
                
            } catch (SQLException e) {
                log.error("Could not retrieve SQL metadata.", e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("Could not close connection.", e);
                }
            }
        }
        
        StringBuilder sbQueryStr = new StringBuilder("");
        
        for (String column : mappings) {
            sbQueryStr.append(column).append(",");
        }
        
        columnListStr = sbQueryStr.toString();
        
        return columnListStr;
    }

    private String generateConnectionUrl(String dbType, String version, String username, String password, String host,
            String port, String dbName) {
        String connectionUrl = DSSVisualEditorConstants.DBUrlParams.DB_URL_JDBC_BASE;

        switch (dbType) {
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_MYSQL:
            // Template: jdbc:mysql://HOST:PORT/DBname
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_MYSQL + "://" + host + ":" + port + "/"
                    + dbName;
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_MSSQL:
            // Template: jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_MSSQL_CONN + "://" + host + ":" + port
                    + ";databaseName=" + dbName;
            break;
        case DSSVisualEditorConstants.DBTypes.DB_URL_JDBC_BASE:
            // Template: jdbc:mysql://HOST:PORT/DBname
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_POSTGRESSQL:
            // Template: jdbc:postgresql://HOST:PORT/DBname
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_POSTGRESSQL + "://" + host + ":" + port + "/"
                    + dbName;
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_DERBY:
            // Template: jdbc:derby://HOST:PORT/DBname
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_DERBY_CONN + "://" + host + ":" + port + "/"
                    + dbName;
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_H2:
            // Template: jdbc:h2:tcp://HOST/~/DBname
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_H2 + ":tcp://" + host + "/~/" + dbName;
            break;
        
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_ORACLE:
            // Template: jdbc:oracle:thin:@//<hostName>:<portNumber>/serviceName
            connectionUrl += DSSVisualEditorConstants.DBTypes.DB_TYPE_ORACLE_CONN + ":@//" + host + ":" + port + "/"
                    + dbName;
            break;

        }

        return connectionUrl;
    }
    
    private String getDBDriverJarName(String dbType, String version) {
        String jarName = "";

        switch (dbType) {
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_MYSQL:
            if (DSSVisualEditorConstants.DBConnectionParams.MYSQL_VERSION_5_1_47.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.MYSQL_JAR_5_1_47;
            } else if (DSSVisualEditorConstants.DBConnectionParams.MYSQL_VERSION_8_0_15.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.MYSQL_JAR_8_0_15;
            }
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_MSSQL:
            if (DSSVisualEditorConstants.DBConnectionParams.MSSQL_VERSION_6_4_0.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.MSSQL_JAR_6_4_0;
            } else if (DSSVisualEditorConstants.DBConnectionParams.MSSQL_VERSION_7_20_0.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.MSSQL_JAR_7_20_0;
            }
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_POSTGRESSQL:
            if (DSSVisualEditorConstants.DBConnectionParams.POSTGRESSQL_VERSION_42_2_11.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.POSTGRESSQL_JAR_42_2_11;
            }
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_DERBY:
            if (DSSVisualEditorConstants.DBConnectionParams.DERBY_VERSION_10_14_2_0.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.DERBY_JAR_10_14_2_0;
            }
            break;
        case DSSVisualEditorConstants.DBTypes.DB_TYPE_H2:
            if (DSSVisualEditorConstants.DBConnectionParams.H2_VERSION_1_4_200.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.H2_JAR_1_4_200;
            }
            break;

        case DSSVisualEditorConstants.DBTypes.DB_TYPE_ORACLE:
            if (DSSVisualEditorConstants.DBConnectionParams.ORACLE_VERSION_8.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.ORACLE_JAR_8;
            } else if (DSSVisualEditorConstants.DBConnectionParams.ORACLE_VERSION_11.equals(version)) {
                jarName = DSSVisualEditorConstants.DBConnectionParams.ORACLE_JAR_11;
            }
            break;

        }

        return jarName;
    }
    
    private Connection getConnection(String dbType, String version, String username, String password, String host,
            String port, String dbName) {

        String connUriStr = generateConnectionUrl(dbType, username, version, password, host, port, dbName);
        Connection connection = null;
        
        try {
            String driverUrl = getServerHome() + File.separator + "lib";
            List<URL> urls = new ArrayList<>();
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(driverUrl), "*.jar")) {
                for (Path path : directoryStream) {
                    urls.add(path.toUri().toURL());
                }
            }
            URLClassLoader urlClassLoader = new URLClassLoader(urls.toArray(new URL[urls.size()]));

            Driver driver = null;
            switch (dbType) {
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_MYSQL:
                driver = (Driver) Class.forName(DSSVisualEditorConstants.DBDrivers.MYSQL_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_MSSQL:
                driver = (Driver) Class.forName(DSSVisualEditorConstants.DBDrivers.MS_SQL_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_POSTGRESSQL:
                driver = (Driver) Class.forName(DSSVisualEditorConstants.DBDrivers.POSTGRESQL_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_DERBY:
                driver = (Driver) Class
                        .forName(DSSVisualEditorConstants.DBDrivers.DERBY_CLIENT_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_H2:
                driver = (Driver) Class.forName(DSSVisualEditorConstants.DBDrivers.H2_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            case DSSVisualEditorConstants.DBTypes.DB_TYPE_ORACLE:
                driver = (Driver) Class.forName(DSSVisualEditorConstants.DBDrivers.ORACLE_DRIVER, true, urlClassLoader)
                        .newInstance();
                break;
            }

            DriverManager.registerDriver(new DriverShim(driver));
            // Check username and password are empty due to Derby db can connect without username and password
            if (dbType.equals(DSSVisualEditorConstants.DBTypes.DB_TYPE_DERBY)
                    && username.equals(DSSVisualEditorConstants.General.EMPTY_INPUT)
                    && password.equals(DSSVisualEditorConstants.General.EMPTY_INPUT)) {
                connection = DriverManager.getConnection(connUriStr);
            } else {
                connection = DriverManager.getConnection(connUriStr, username, password);
            }
            
        } catch (Exception e) {
            log.error("Could not establish database connection.", e);
        }
        
        return connection;
    }
    
    private Connection getConnectionFromUrl(String conUrl, String username, String password) {

        Connection connection = null;
        String dbType = "";
        String version = "";
        
        if (conUrl.contains("mysql")) {
            dbType = "mysql";
            version = DSSVisualEditorConstants.DBConnectionParams.MYSQL_VERSION_8_0_15;
        } else if (conUrl.contains("sqlserver")) {
            dbType = "mssql";
            version = DSSVisualEditorConstants.DBConnectionParams.MSSQL_VERSION_6_4_0;
        }
        
        try {
            String driverUrl = getServerHome() + File.separator + "lib";
            List<URL> urls = new ArrayList<>();
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(driverUrl), "*.jar")) {
                for (Path path : directoryStream) {
                    urls.add(path.toUri().toURL());
                }
            }
            URLClassLoader urlClassLoader = new URLClassLoader(urls.toArray(new URL[urls.size()]));

            Driver driver = (Driver) Class
                    .forName(DSSVisualEditorConstants.DBDrivers.MYSQL_DRIVER, true, urlClassLoader).newInstance();
            DriverManager.registerDriver(new DriverShim(driver));

            connection = DriverManager.getConnection(conUrl, username, password);
            
        } catch (Exception e) {
            log.error("Could not establish database connection.", e);
        }
        
        return connection;
    }

    /**
     * Get absolute path to server home folder
     * 
     * @return return path as a string
     */
    public String getServerHome() {
        String microInteratorPath = null;
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            boolean isRelativeToolingAppExists = false;
            File macOSRelativeToolingApp = null;
            try {
                macOSRelativeToolingApp = new File(
                        (new File(".").getCanonicalFile()).getParent().toString() + File.separator + "Eclipse");
                if (macOSRelativeToolingApp.exists()) {
                    isRelativeToolingAppExists = true;
                }
            } catch (IOException e) {
            }
            if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                microInteratorPath = macOSRelativeToolingApp.getAbsolutePath() + File.separator + MICRO_ESB_PATH;
            } else if (new File(TOOLING_PATH_MAC).exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + MICRO_ESB_PATH;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MICRO_ESB_PATH;
            }

        } else {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MICRO_ESB_PATH;
        }
        return microInteratorPath;
    }

}
