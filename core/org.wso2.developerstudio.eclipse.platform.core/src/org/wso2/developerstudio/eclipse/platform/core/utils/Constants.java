/*
 * Copyright (c) 2011 - 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.utils;

import org.eclipse.osgi.util.NLS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a Java class for loading and keeping WSO2 Developer Studio defined project natures from constants.properties file.
 * This will use org.eclipse.osgi.util.NLS class provided mechanism for loading constant values from .properties file
 * Also keeps some String constants to be used
 */
public class Constants extends NLS{
   public static final String PROPERTIES_FILE_BASE_NAME = "org.wso2.developerstudio.eclipse.platform.core.utils.constants";
   public static final String POM_FILE_NAME = "pom";
   public static final String POM_FILE_EXTENSION = "xml";
   public static final String ARTIFACT_XML = "artifact.xml";
   public static final String SYNAPSE_CONFIG_TYPE = "synapse/configuration";
   public static final String ESB_PROJECT_TARGET_CAPP = "target" + File.separator + "capp" + File.separator
           + "artifacts";
   public static final String MAVEN_BASE_DIR_PREFIX = "${basedir}";
   public static final String CAPP_PREFIX = "capp/";
   public static final String SEQUENCE_TEMPLATE_TYPE = "synapse/sequenceTemplate";
   public static final String ENDPOINT_TEMPLATE_TYPE = "synapse/endpointTemplate";
   public static final String COMMON_TEMPLATE_TYPE = "synapse/template";
   public static final String JAVA_PROJECT_NATURE ="org.eclipse.jdt.core.javanature";

   public static final double MINIMUM_REQUIRED_JAVA_VERSION = 1.7;

   //String constant value declaration, these values loaded from constants.properties file at run time
   public static String AXIS2_PROJECT_NATURE;
   public static String BPEL_PROJECT_NATURE;
   public static String DS_PROJECT_NATURE;
   public static String DS_VALIDATOR_PROJECT_NATURE;
   public static String JAXWS_PROJECT_NATURE;
   public static String JAXRS_PROJECT_NATURE;
   public static String WEBAPP_PROJECT_NATURE;
   public static String ESB_PROJECT_NATURE;
   public static String GADGET_PROJECT_NATURE;
   public static String LIBRARY_PROJECT_NATURE;
   public static String MEDIATOR_PROJECT_NATURE;
   public static String REGISTRY_FILTER_PROJECT_NATURE;
   public static String REGISTRY_HANDLER_PROJECT_NATURE;
   public static String GENERAL_PROJECT_NATURE;
   public static String CARBON_UI_PROJECT_NATURE;
   public static String DISTRIBUTION_PROJECT_NATURE;
   public static String CEP_PROJECT_NATURE;
   public static String BRS_PROJECT_NATURE ;
   public static String JAGGERY_NATURE;
   public static String SERVICE_META_PROJECT_NATURE;
   public static String DETECTED_JAVA_VERSION_MESSAGE;
   public static String RECOMMENDED_JAVA_VERSION_MESSAGE;
   public static String JAVA_VERSION_ALERT_MESSAGE;
   public static String JAVA_VERSION_CONTINUE_MESSAGE;
   public static String MAVEN_MULTI_MODULE_PROJECT_NATURE;
   public static String CONNECTOR_PROJECT_NATURE;

   static {
      // initialize resource bundle, this will load all constants from PROPERTIES_FILE_BASE_NAME file to this class
      NLS.initializeMessages(PROPERTIES_FILE_BASE_NAME, Constants.class);
   }
   
   public static List<String> getAllNatures(){
      List<String> list=new ArrayList<String>();
      
      list.add(AXIS2_PROJECT_NATURE);
      list.add(BPEL_PROJECT_NATURE);
      list.add(DS_PROJECT_NATURE);
      list.add(DS_VALIDATOR_PROJECT_NATURE);
      list.add(JAXWS_PROJECT_NATURE);
      list.add(JAXRS_PROJECT_NATURE);
      list.add(WEBAPP_PROJECT_NATURE);
      list.add(ESB_PROJECT_NATURE);
      list.add(GADGET_PROJECT_NATURE);
      list.add(LIBRARY_PROJECT_NATURE);
      list.add(MEDIATOR_PROJECT_NATURE);
      list.add(REGISTRY_FILTER_PROJECT_NATURE);
      list.add(REGISTRY_HANDLER_PROJECT_NATURE);
      list.add(GENERAL_PROJECT_NATURE);
      list.add(CARBON_UI_PROJECT_NATURE);
      list.add(DISTRIBUTION_PROJECT_NATURE);
      list.add(CEP_PROJECT_NATURE);
      list.add(BRS_PROJECT_NATURE);
      list.add(JAGGERY_NATURE);
      list.add(SERVICE_META_PROJECT_NATURE);
      list.add(MAVEN_MULTI_MODULE_PROJECT_NATURE);
      list.add(CONNECTOR_PROJECT_NATURE);

      return list;
   }
}