/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

/**
 * This class contains default values for message store property parameters 
 */
package org.wso2.developerstudio.eclipse.artifact.messagestore;

import org.eclipse.osgi.util.NLS;

public class DefaultValueConstants {
    
    private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.messagestore.defaultvalues"; //$NON-NLS-1$
    
    public static String EMPTY_STRING;
    public static String JMS_CONTEXT_FACTORY_WSO2_BROKER;
    public static String JMS_PROVIDER_URL_WSO2_BROKER;
    public static String JMS_CONNECTION_FACTORY_WSO2_BROKER;
    public static String JMS_CONTEXT_FACTORY_ACTIVEMQ;
    public static String JMS_PROVIDER_URL_ACTIVEMQ;
    public static String JMS_CONNECTION_FACTORY_ACTIVEMQ;
    
    static {
        // initializing resource bundle
        NLS.initializeMessages(BUNDLE_NAME, DefaultValueConstants.class);
    }

    private DefaultValueConstants() {
        
    }

}
