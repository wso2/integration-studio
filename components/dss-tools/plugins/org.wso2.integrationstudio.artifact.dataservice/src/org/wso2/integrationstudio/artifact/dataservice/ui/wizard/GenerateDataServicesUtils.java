/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.integrationstudio.artifact.dataservice.ui.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDataServicesUtils {
    
    
    private static Map<Integer, String> definedTypeMap = new HashMap<Integer, String>();

    private static Map<Integer, String> qnameTypeMap = new HashMap<Integer, String>();
    
    public enum Methods
    {
        GET , POST , PUT , DELETE;
    }

    static {
        definedTypeMap.put(java.sql.Types.CHAR, "STRING");
        definedTypeMap.put(java.sql.Types.NUMERIC, "NUMERIC");
        definedTypeMap.put(java.sql.Types.DECIMAL, "DOUBLE");
        definedTypeMap.put(java.sql.Types.INTEGER, "INTEGER");
        definedTypeMap.put(java.sql.Types.SMALLINT, "SMALLINT");
        definedTypeMap.put(java.sql.Types.FLOAT, "DOUBLE");
        definedTypeMap.put(java.sql.Types.REAL, "REAL");
        definedTypeMap.put(java.sql.Types.DOUBLE, "DOUBLE");
        definedTypeMap.put(java.sql.Types.VARCHAR, "STRING");
                definedTypeMap.put(java.sql.Types.NVARCHAR, "STRING");
        // typeMap.put(java.sql.Types.LONGNVARCHAR, "STRING");
        // typeMap.put(java.sql.Types.NCHAR, "STRING");
        // typeMap.put(java.sql.Types.LONGNVARCHAR, "STRING");
        // typeMap.put(java.sql.Types.NVARCHAR, "STRING");
        definedTypeMap.put(java.sql.Types.CLOB, "STRING");
        // typeMap.put(java.sql.Types.SQLXML, "STRING");
        definedTypeMap.put(java.sql.Types.BOOLEAN, "BOOLEAN");
        definedTypeMap.put(java.sql.Types.TIMESTAMP, "TIMESTAMP");
        definedTypeMap.put(java.sql.Types.BIT, "BIT");
        definedTypeMap.put(java.sql.Types.TIME, "TIME");
        definedTypeMap.put(java.sql.Types.TINYINT, "TINYINT");
        definedTypeMap.put(java.sql.Types.BIGINT, "BIGINT");
        definedTypeMap.put(java.sql.Types.LONGVARBINARY, "BINARY");
        definedTypeMap.put(java.sql.Types.VARBINARY, "BINARY");
        definedTypeMap.put(java.sql.Types.BINARY, "BINARY");
        definedTypeMap.put(java.sql.Types.BLOB, "BINARY");
        definedTypeMap.put(java.sql.Types.DATE, "DATE");
        definedTypeMap.put(java.sql.Types.TIMESTAMP, "TIMESTAMP");

        qnameTypeMap.put(java.sql.Types.CHAR, "string");
        qnameTypeMap.put(java.sql.Types.NUMERIC, "integer");
        qnameTypeMap.put(java.sql.Types.DECIMAL, "decimal");
        qnameTypeMap.put(java.sql.Types.INTEGER, "integer");
        qnameTypeMap.put(java.sql.Types.SMALLINT, "integer");
        qnameTypeMap.put(java.sql.Types.FLOAT, "float");
        qnameTypeMap.put(java.sql.Types.REAL, "double");
        qnameTypeMap.put(java.sql.Types.DOUBLE, "double");
        qnameTypeMap.put(java.sql.Types.VARCHAR, "string");
                qnameTypeMap.put(java.sql.Types.NVARCHAR, "string");
        // typeMap.put(java.sql.Types.LONGNVARCHAR, "string");
        // typeMap.put(java.sql.Types.NCHAR, "string");
        // typeMap.put(java.sql.Types.NVARCHAR, "string");
        // typeMap.put(java.sql.Types.LONGNVARCHAR, "string");
        qnameTypeMap.put(java.sql.Types.CLOB, "string");
        // typeMap.put(java.sql.Types.SQLXML, "string");
        qnameTypeMap.put(java.sql.Types.BOOLEAN, "boolean");
        qnameTypeMap.put(java.sql.Types.TIMESTAMP, "dateTime");
        qnameTypeMap.put(java.sql.Types.BIT, "integer");
        qnameTypeMap.put(java.sql.Types.TIME, "time");
        qnameTypeMap.put(java.sql.Types.TINYINT, "integer");
        qnameTypeMap.put(java.sql.Types.BIGINT, "long");
        qnameTypeMap.put(java.sql.Types.LONGVARBINARY, "base64Binary");
        qnameTypeMap.put(java.sql.Types.VARBINARY, "base64Binary");
        qnameTypeMap.put(java.sql.Types.BINARY, "base64Binary");
        qnameTypeMap.put(java.sql.Types.BLOB, "base64Binary");
        qnameTypeMap.put(java.sql.Types.DATE, "date");
    }
    
    /**
     * select All SQL Statement
     * <p/>
     * SELECT * FROM [table name];
     * 
     * @param tableName
     *            -table Name of the given table
     * @param schema the database schema
     * @return SQL statement as a String
     */
    public static String getSelectAll(String tableName, String schema, String columnNames) {
        StringBuffer statement = new StringBuffer();
        statement.append("SELECT " + columnNames.trim() + " FROM ");
        statement.append((isEmptyString(schema) ? "" : (schema + ".")) + tableName.trim());
        return new String(statement);
    }

    /**
     * This method creates select by key, SQL Statement
     * <p/>
     * SELECT * FROM [table name] WHERE [field name] = "whatever";
     * 
     * @param tableName
     *            -table Name of the given table
     * @param schema the database schema
     * @param pKey
     *            -primary key of table
     * @return SQL statement as a String
     */
    public static String getSelectByKey(String tableName, String schema, 
            String pKey, String columnNames) {
        StringBuffer statement = new StringBuffer();
        statement.append("SELECT " + columnNames.trim() + " FROM ");
        statement.append((isEmptyString(schema) ? "" : (schema + ".")) + tableName.trim());
        statement.append(" WHERE ");
        statement.append(pKey).append("=?");
        return new String(statement);
    }

    /**
     * This method creates Data Insertion SQL Statement
     * <p/>
     * INSERT INTO tableName(c1,c2,c3) VALUES(p1,p2,p3)
     * 
     * @param param
     *            -List of parameters values
     * @param tableName
     *            -table Name of the given table
     * @param schema the database schema
     * @return SQL statement as a String
     */
    public static String getInsertStatement(String tableName, String schema, List<String> param) {
        StringBuffer statement = new StringBuffer();
        statement.append("INSERT INTO ");
        statement.append((isEmptyString(schema) ? "" : (schema + ".")) + tableName.trim());
        statement.append("(");
        int last = param.size();
        int index = 1;
        for (String par : param) {
            statement.append(par);
            if (index != last)
                statement.append(",");
            index++;
        }
        statement.append(")");
        statement.append(" VALUES");
        statement.append("(");
        index = 1;
        /* use this fore each loop just to travel inside list */
        // noinspection UnusedDeclaration
        for (@SuppressWarnings("unused")
        String par : param) {
            statement.append('?');
            if (index != last)
                statement.append(",");
            index++;
        }
        statement.append(")");
        return new String(statement);
    }

    /**
     * This method creates Data Update SQL Statement
     * <p/>
     * UPDATE [table name] SET Select_prev = 'Y',Update_prev = 'Y' where [field
     * name] = 'user';
     * 
     * @param param2
     *            -List of parameters values
     * @param tableName
     *            -table Name of the given table
     * @param schema the database schema
     * @param pKey
     *            -primary key of table
     * @return SQL statement as a String
     */
    public static String getUpdateStatement(String tableName, String schema, List<String> param2,
            List<String> pKeys) {
        List<String> param = new ArrayList<String>();
        for (String par : param2) {
            if (!pKeys.contains(par))
                param.add(par);
        }

        StringBuffer statement = new StringBuffer();
        statement.append("UPDATE ");
        statement.append((isEmptyString(schema) ? "" : (schema + ".")) + tableName.trim());
        statement.append(" SET ");
        int last = param.size();
        int index = 1;
        for (String par : param) {

            statement.append(par).append("=?");
            if (index != last)
                statement.append(",");

            index++;
        }
        statement.append(" WHERE ");
        int i = 0;
        for (String pKey : pKeys) {
            if (i > 0) {
                statement.append(" AND ");
            }
            statement.append(pKey).append("=?");
            i++;
        }
        return new String(statement);
    }

    /**
     * This method creates Data Delete SQL Statement
     * <p/>
     * DELETE from [table name] where [field name] = 'whatever';
     * 
     * @param tableName
     *            -table Name of the given table
     * @param schema the database schema
     * @param pKey
     *            -primary key of table
     * @return SQL statement as a String
     */
    public static String getDeleteStatement(String tableName, String schema, List<String> pKeys) {
        StringBuffer statement = new StringBuffer();
        statement.append("DELETE FROM ");
        statement.append((isEmptyString(schema) ? "" : (schema + ".")) + tableName.trim());
        statement.append(" WHERE ");
        int i = 0;
        for (String pKey : pKeys) {
            if (i > 0) {
                statement.append(" AND ");
            }
            statement.append(pKey).append("=?");
            i++;
        }
        return new String(statement);
    }
    
    /**
     * Check the given text is empty or not.
     *
     * @param text The text to be checked
     * @return true if text is null or trimmed text length is empty, or else false
     */
    private static boolean isEmptyString(String text) {
        if (text != null && text.trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Map<Integer, String> getDefinedTypes() {
        return definedTypeMap;
    }

}
