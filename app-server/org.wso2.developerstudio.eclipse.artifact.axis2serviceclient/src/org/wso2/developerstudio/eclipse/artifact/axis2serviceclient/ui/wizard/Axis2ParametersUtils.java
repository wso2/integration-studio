/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.ui.wizard;

import java.util.List;
import java.util.Vector;

public abstract class Axis2ParametersUtils {

	/** The Constant WSDL_LOCATION_OPTION. */
	public static final String WSDL_LOCATION_OPTION = "-uri";

	/** The Constant GENERATED_CODE_LOCATION. */
	public static final String GENERATED_CODE_LOCATION = "-o";

	/** The Constant GENERATE_SERVICE_DESCRIPTION. */
	public static final String GENERATE_SERVICE_DESCRIPTION = "-sd";

	/** The Constant GENERATE_TEST_CASE. */
	public static final String GENERATE_TEST_CASE = "-t";

	/** The Constant NO_WSDL. */
	public static final String NO_WSDL = "-noWSDL";

	/** The Constant NO_MESSAGE_RECEIVER. */
	public static final String NO_MESSAGE_RECEIVER = "--noMessageReceiver";

	/** The Constant NO_BUILD_XML. */
	public static final String NO_BUILD_XML = "--noBuildXML";

	/** The Constant GENERATE_ASYNC_CODE. */
	public static final String GENERATE_ASYNC_CODE = "-a";

	/** The Constant GENERATE_SYNC_CODE. */
	public static final String GENERATE_SYNC_CODE = "-s";

	/** The Constant CUSTOM_PACKAGE_NAME. */
	public static final String CUSTOM_PACKAGE_NAME = "-p";

	/** The Constant LANGUAGE. */
	public static final String LANGUAGE = "-l";

	/** The Constant DATABINDING. */
	public static final String DATABINDING = "-d";

	/** The Constant UNPACK. */
	public static final String UNPACK = "-u";

	/** The Constant SOURCE_FOLDER. */
	public static final String SOURCE_FOLDER = "-S";

	/** The Constant RESOURCE_FOLDER. */
	public static final String RESOURCE_FOLDER = "-R";

	/** The Constant PORT_NAME. */
	public static final String PORT_NAME = "-pn";

	/** The Constant SERVICE_NAME. */
	public static final String SERVICE_NAME = "-sn";

	/** The Constant REPOSITORY_FOLDER. */
	public static final String REPOSITORY_FOLDER = "-r";

	/** The Constant GENERATE_SERVICE_SKELETON_ONLY. */
	public static final String GENERATE_SERVICE_SKELETON_ONLY = "-ssi";

	/** The Constant GENERATE_ALL_CODE. */
	public static final String GENERATE_ALL_CODE = "-g";

	/** The Constant EXTERNAL_TYPE_MAPPING_FILE. */
	public static final String EXTERNAL_TYPE_MAPPING_FILE = "-em";

	/** The Constant NAME_SPACE_PACKAGES. */
	public static final String NAME_SPACE_PACKAGES = "-ns2p";

	/** The Constant UNWRAP. */
	public static final String UNWRAP = "-uw";

	/** The Constant WSDL_VERSION. */
	public static final String WSDL_VERSION = "-wv";

	/** The Constant FLATTEN_FILES. */
	public static final String FLATTEN_FILES = "-f";

	/** The Constant IS_CODE_BACKWARD_COMPATIBLE. */
	public static final String IS_CODE_BACKWARD_COMPATIBLE = "-b";

	/** The Constant SUPPRESS_PREFIXES. */
	public static final String SUPPRESS_PREFIXES = "-sp";

	/** The Constant XSD_FILE_FOR_XML_BEANS. */
	public static final String XSD_FILE_FOR_XML_BEANS = "-xc";

	/** The Constant REMOVE_SELECTED_PACKAGES. */
	public static final String REMOVE_SELECTED_PACKAGES = "-ep";

	/** The Constant SKELETON_INTERFACE_NAME. */
	public static final String SKELETON_INTERFACE_NAME = "-sin";

	/** The Constant SKELETON_CLASS_NAME. */
	public static final String SKELETON_CLASS_NAME = "-scn";

	/** The Constant OVERRIDE_CODE. */
	public static final String OVERRIDE_CODE = "-or";

	/** The Constant OVERRIDE_SCHEMA_URLS. */
	public static final String OVERRIDE_SCHEMA_URLS = "-oaa";

	/** The Constant GENERATE_SERVER_SIDE_CODE. */
	public static final String GENERATE_SERVER_SIDE_CODE = "-ss";

	/**
	 * Gets the parameter array.
	 * 
	 * @param parameterList
	 *            the parameter list
	 * @return the parameter array
	 */
	public static String[] getParameterArray(List<String> parameterList) {

		String[] stringArray = new String[((Vector<String>) parameterList)
				.size()];
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = (String) parameterList.get(i);
		}

		return stringArray;
	}

	/**
	 * Gets the parameter list.
	 * 
	 * @return the parameter list
	 */
	public static List<String> getParameterList(DataModel model) {

		Vector<String> parameterList = new Vector<String>();
		parameterList.add(WSDL_LOCATION_OPTION);
		parameterList.add(model.getWsdlURI());
		parameterList.add(GENERATED_CODE_LOCATION);
		parameterList.add(model.getGeneratedCodeLocation());

		if (model.isGenerateServiceDescriptor()) {
			parameterList.add(GENERATE_SERVICE_DESCRIPTION);
		}
		if (model.isGenerateTestCase()) {
			parameterList.add(GENERATE_TEST_CASE);
		}
		if (model.isNoWSDL()) {
			parameterList.add(NO_WSDL);
		}
		if (model.isNoMessageReceiver()) {
			parameterList.add(NO_MESSAGE_RECEIVER);
		}
		if (model.isNoBuildXml()) {
			parameterList.add(NO_BUILD_XML);
		}
		if (model.isGenerateAsyncCode()) {
			parameterList.add(GENERATE_ASYNC_CODE);
		}
		if (model.isGenerateSyncCode()) {
			parameterList.add(GENERATE_SYNC_CODE);
		}
		if (model.getPackageName() != null
				&& !model.getPackageName().equals("")) {
			parameterList.add(CUSTOM_PACKAGE_NAME);
			parameterList.add(model.getPackageName());
		}
		if (model.getLanguage() != null && !model.getLanguage().equals("")) {
			parameterList.add(LANGUAGE);
			parameterList.add(model.getLanguage());
		}
		if (model.getDatabindingType() != null
				&& !model.getDatabindingType().equals("")) {
			parameterList.add(DATABINDING);
			parameterList.add(model.getDatabindingType());
		}
		if (model.isUnpack()) {
			parameterList.add(UNPACK);
		}
		if (model.getSourceFolder() != null
				&& !model.getSourceFolder().toString().equals("")) {
			parameterList.add(SOURCE_FOLDER);
			parameterList.add(model.getSourceFolder().toString());
		}
		if (model.getResourceFolder() != null
				&& !model.getResourceFolder().toString().equals("")) {
			parameterList.add(RESOURCE_FOLDER);
			parameterList.add(model.getResourceFolder().toString());
		}
		if (model.getPortName() != null && !model.getPortName().equals("")) {
			parameterList.add(PORT_NAME);
			parameterList.add(model.getPortName());
		}
		if (model.getServiceName() != null
				&& !model.getServiceName().equals("")) {
			parameterList.add(SERVICE_NAME);
			parameterList.add(model.getServiceName());
		}
		if (model.getRepositoryFolder() != null
				&& !model.getRepositoryFolder().toString().equals("")) {
			parameterList.add(REPOSITORY_FOLDER);
			parameterList.add(model.getRepositoryFolder().toString());
		}
		if (model.isGenerateServiceSkeletonOnly()) {
			parameterList.add(GENERATE_SERVICE_SKELETON_ONLY);
		}
		if (model.isGenerateAllCode()) {
			parameterList.add(GENERATE_ALL_CODE);
		}
		if (model.getExternalTypeMappingFile() != null
				&& !model.getExternalTypeMappingFile().toString().equals("")) {
			parameterList.add(EXTERNAL_TYPE_MAPPING_FILE);
			parameterList.add(model.getExternalTypeMappingFile().toString());
		}
		// if (namespacePackages != null && !namespacePackages.equals("")) {
		// parameterList.add(NAME_SPACE_PACKAGES);
		// for (int i = 0; i < namespacePackages.size(); i++) {
		// String parameter = new String();
		// parameter = "uri=" + namespacePackages.get(i);
		// // Add a comma if not the last parameter
		// if (i != namespacePackages.size() - 1) {
		// parameter = parameter + ",";
		//
		// }
		// }
		// }

		if (model.getNamespaseToPackageMapping() != null
				&& !model.getNamespaseToPackageMapping().equals("")) {
			parameterList.add(NAME_SPACE_PACKAGES);
			parameterList.add(model.getNamespaseToPackageMapping());
		}
		if (model.isUnwrap()) {
			parameterList.add(UNWRAP);
		}
		if (model.getWsdlVersion() != null
				&& !model.getWsdlVersion().equals("")) {
			parameterList.add(WSDL_VERSION);
			parameterList.add(model.getWsdlVersion());
		}
		if (model.isFlattenFiles()) {
			parameterList.add(FLATTEN_FILES);
		}
		if (model.isCodeBackwardCompatible()) {
			parameterList.add(IS_CODE_BACKWARD_COMPATIBLE);
		}
		if (model.isSuppressPrefixes()) {
			parameterList.add(SUPPRESS_PREFIXES);
		}
		if (model.getXsdFileForXMLBeans() != null
				&& !model.getXsdFileForXMLBeans().toString().equals("")) {
			parameterList.add(XSD_FILE_FOR_XML_BEANS);
			parameterList.add(model.getXsdFileForXMLBeans().toString());
		}
		if (model.isRemoveSelectedPackages()) {
			parameterList.add(REMOVE_SELECTED_PACKAGES);
		}
		if (model.getSkeletonInterfaceName() != null
				&& !model.getSkeletonInterfaceName().equals("")) {
			parameterList.add(SKELETON_INTERFACE_NAME);
			parameterList.add(model.getSkeletonInterfaceName());
		}
		if (model.getSkeletonClassName() != null
				&& !model.getSkeletonClassName().equals("")) {
			parameterList.add(SKELETON_CLASS_NAME);
			parameterList.add(model.getSkeletonClassName());
		}
		if (model.isOverrideCode()) {
			parameterList.add(OVERRIDE_CODE);
		}
		if (model.isOverrideSchemaURLs()) {
			parameterList.add(OVERRIDE_SCHEMA_URLS);
		}
		if (model.isGenerateServerSideCode()) {
			parameterList.add(GENERATE_SERVER_SIDE_CODE);
		}

		return parameterList;

	}

}
