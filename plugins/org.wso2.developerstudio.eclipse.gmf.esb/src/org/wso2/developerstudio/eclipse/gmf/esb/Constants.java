/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.osgi.util.NLS;

public class Constants extends NLS {

    private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.gmf.esb.constants"; //$NON-NLS-1$
    
    public static String EMPTY_TEXT;
    
    // DB related constants
    public static String TXT_EMPTY;
    public static String TXT_DATABASE_DRIVER_MYSQL;
    public static String TXT_DATABASE_DRIVER_ORACLE;
    public static String TXT_DATABASE_DRIVER_MSSQL;
    public static String TXT_DATABASE_DRIVER_POSTGRESQL;
    public static String TXT_DATABASE_CONNECTION_URL_MYSQL;
    public static String TXT_DATABASE_CONNECTION_URL_ORACLE;
    public static String TXT_DATABASE_CONNECTION_URL_MSSQL;
    public static String TXT_DATABASE_CONNECTION_URL_POSTGRESQL;
    public static String TXT_DATABASE_USER_MYSQL;
    public static String TXT_DATABASE_USER_ORACLE;
    public static String TXT_DATABASE_USER_MSSQL;
    public static String TXT_DATABASE_USER_POSTGRESQL;
    public static String TXT_DATABASE_TYPE_MYSQL;
    public static String TXT_DATABASE_TYPE_ORACLE;
    public static String TXT_DATABASE_TYPE_MSSQL;
    public static String TXT_DATABASE_TYPE_POSTGRESQL;
    public static String TXT_DATABASE_TYPE_OTHER;
    
    static {
        // initializing resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Constants.class);
    }

    private Constants() {

    }
    
}
