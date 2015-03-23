/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.maven.axis2;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.apache.maven.archiver.MavenArchiveConfiguration;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;

/**
 * Generate client stubs.
 *
 */
public abstract class Axis2Mojo extends AbstractMojo {

	/** The Constant WSDL_LOCATION_OPTION. */
	protected static final String WSDL_LOCATION_OPTION = "-uri";

	/** The Constant GENERATED_CODE_LOCATION. */
	protected static final String GENERATED_CODE_LOCATION = "-o";

	/** The Constant GENERATE_SERVICE_DESCRIPTION. */
	protected static final String GENERATE_SERVICE_DESCRIPTION = "-sd";

	/** The Constant GENERATE_TEST_CASE. */
	protected static final String GENERATE_TEST_CASE = "-t";

	/** The Constant NO_WSDL. */
	protected static final String NO_WSDL = "-noWSDL";

	/** The Constant NO_MESSAGE_RECEIVER. */
	protected static final String NO_MESSAGE_RECEIVER = "--noMessageReceiver";

	/** The Constant NO_BUILD_XML. */
	protected static final String NO_BUILD_XML = "--noBuildXML";

	/** The Constant GENERATE_ASYNC_CODE. */
	protected static final String GENERATE_ASYNC_CODE = "-a";

	/** The Constant GENERATE_SYNC_CODE. */
	protected static final String GENERATE_SYNC_CODE = "-s";

	/** The Constant CUSTOM_PACKAGE_NAME. */
	protected static final String CUSTOM_PACKAGE_NAME = "-p";

	/** The Constant LANGUAGE. */
	protected static final String LANGUAGE = "-l";

	/** The Constant DATABINDING. */
	protected static final String DATABINDING = "-d";

	/** The Constant UNPACK. */
	protected static final String UNPACK = "-u";

	/** The Constant SOURCE_FOLDER. */
	protected static final String SOURCE_FOLDER = "-S";

	/** The Constant RESOURCE_FOLDER. */
	protected static final String RESOURCE_FOLDER = "-R";

	/** The Constant PORT_NAME. */
	protected static final String PORT_NAME = "-pn";

	/** The Constant SERVICE_NAME. */
	protected static final String SERVICE_NAME = "-sn";

	/** The Constant REPOSITORY_FOLDER. */
	protected static final String REPOSITORY_FOLDER = "-r";

	/** The Constant GENERATE_SERVICE_SKELETON_ONLY. */
	protected static final String GENERATE_SERVICE_SKELETON_ONLY = "-ssi";

	/** The Constant GENERATE_ALL_CODE. */
	protected static final String GENERATE_ALL_CODE = "-g";

	/** The Constant EXTERNAL_TYPE_MAPPING_FILE. */
	protected static final String EXTERNAL_TYPE_MAPPING_FILE = "-em";

	/** The Constant NAME_SPACE_PACKAGES. */
	protected static final String NAME_SPACE_PACKAGES = "-ns2p";

	/** The Constant UNWRAP. */
	protected static final String UNWRAP = "-uw";

	/** The Constant WSDL_VERSION. */
	protected static final String WSDL_VERSION = "-wv";

	/** The Constant FLATTEN_FILES. */
	protected static final String FLATTEN_FILES = "-f";

	/** The Constant IS_CODE_BACKWARD_COMPATIBLE. */
	protected static final String IS_CODE_BACKWARD_COMPATIBLE = "-b";

	/** The Constant SUPPRESS_PREFIXES. */
	protected static final String SUPPRESS_PREFIXES = "-sp";

	/** The Constant XSD_FILE_FOR_XML_BEANS. */
	protected static final String XSD_FILE_FOR_XML_BEANS = "-xc";

	/** The Constant REMOVE_SELECTED_PACKAGES. */
	protected static final String REMOVE_SELECTED_PACKAGES = "-ep";

	/** The Constant SKELETON_INTERFACE_NAME. */
	protected static final String SKELETON_INTERFACE_NAME = "-sin";

	/** The Constant SKELETON_CLASS_NAME. */
	protected static final String SKELETON_CLASS_NAME = "-scn";

	/** The Constant OVERRIDE_CODE. */
	protected static final String OVERRIDE_CODE = "-or";

	/** The Constant OVERRIDE_SCHEMA_URLS. */
	protected static final String OVERRIDE_SCHEMA_URLS = "-oaa";

	/**
	 * The maven archive configuration to use.
	 *
	 * @parameter
	 */
	protected MavenArchiveConfiguration archive = new MavenArchiveConfiguration();

	/**
	 * The project helper.
	 *
	 * @component
	 *
	 */
	protected MavenProjectHelper projectHelper;

	/**
	 * The maven project.
	 *
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;

	/**
	 * Location of the WSDL file. Option : -uri ${wsdlLocation}
	 *
	 * @parameter
	 * @required
	 */
	protected File wsdlLocation;

	/**
	 * Location to put the generated code. Option : -o ${generatedCodeLocation}
	 *
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	protected File generatedCodeLocation;

	/**
	 * Generate service descriptor (i.e. services.xml). Option : -sd
	 *
	 * @parameter expression="false"
	 */
	protected boolean generateServiceDescription;

	/**
	 * Generate a test case for the generated code. Option : -t
	 *
	 * @parameter expression="false"
	 */
	protected boolean generateTestCase;

	/**
	 * Don't Copy the Source WSDL. Option : -noWSDL
	 *
	 * @parameter expression="false"
	 */
	protected boolean noWSDL;

	/**
	 * Don't Generate Message Receiver. Option : --noMessageReceiver
	 *
	 * @parameter expression="false"
	 */
	protected boolean noMessageReceiver;

	/**
	 * Don't Generate Ant Build Script. Option : --noBuildXML
	 *
	 * @parameter expression="false"
	 */
	protected boolean noBuildXML;

	/**
	 * Generate Asynchronous Client Invocation Code. Option : -a
	 *
	 * @parameter expression="false"
	 */
	protected boolean generateAsyncCode;

	/**
	 * Generate Synchronous Client Invocation Code. Option : -s
	 *
	 * @parameter expression="false"
	 */
	protected boolean generateSyncCode;

	/**
	 * Custom package name. Option : -p
	 *
	 * @parameter
	 */
	protected String customPackageName;

	/**
	 * Stub language. Option : -l ${language}. Valid languages are java and c
	 * (Default: java)
	 *
	 * @parameter expression="java"
	 */
	protected String language;

	/**
	 * Data Binding Framework. Option : -d ${databinding}. Valid databinding(s)
	 * are adb, xmlbeans, jibx and jaxbri (Default: adb).
	 *
	 * @parameter expression="adb"
	 */
	protected String databinding;

	/**
	 * Unpacks generated classes. Option : -u
	 *
	 * @parameter expression="false"
	 */
	protected boolean unpack;

	/**
	 * Source Folder Name. Option : -S ${sourceFolder}
	 *
	 * @parameter
	 */
	protected File sourceFolder;

	/**
	 * Resource Folder Name. Option : -R ${resourceFolder}
	 *
	 * @parameter
	 */
	protected File resourceFolder;

	/**
	 * Choose a specific port when there are multiple ports in the wsdl. Option
	 * : -pn ${portName}
	 *
	 * @parameter
	 */
	protected String portName;

	/**
	 * Choose a specific service when there are multiple services in the wsdl.
	 * Option : -sn ${serviceName}
	 *
	 * @parameter
	 */
	protected String serviceName;

	/**
	 * Repository location. Option : -r${repositoryFolder}
	 *
	 * @parameter
	 */
	protected File repositoryFolder;

	/**
	 * Generate service skeleton interface only. Option : -ssi
	 *
	 * @parameter expression = "false"
	 */
	protected boolean generateServiceSkeletonOnly;

	/**
	 * Generates all code (synchronous and asynchronous). Option : -g
	 *
	 * @parameter expression="false"
	 */
	protected boolean generateAllCode;

	/**
	 * External type mapping file. Option : -em ${externalTypeMappingFile}
	 *
	 * @parameter
	 */
	protected File externalTypeMappingFile;

	/**
	 * Namespaces to Package Mappings . Option-ns2p
	 * uri=namespacePackages.get(0),uri=namespacePackages.get(1),...
	 *
	 * @parameter
	 */
	protected List<String> namespacePackages;

	/**
	 * Unwrap Parameters. Option : -uw
	 *
	 * @parameter expression="false"
	 * @required
	 */
	protected boolean unwrap;

	/**
	 * The WSDL Version. Valid options are 1.1 and 2.0. Option : -wv
	 * ${wsdlVersion}
	 *
	 * @parameter expression="1.1"
	 * @required
	 */
	protected String wsdlVersion;

	/**
	 * Flatten files. Option : -f
	 *
	 * @parameter expression="false"
	 * @required
	 */
	protected boolean flattenFiles;

	/**
	 * Make the generated code backward compatible. Option : -b
	 *
	 * @parameter expression="false"
	 */
	protected boolean isCodeBackwardCompatible;

	/**
	 * Suppress Prefixes. Option : -sp
	 *
	 * @parameter expression="false"
	 */
	protected boolean suppressPrefixes;

	/**
	 * XSD configuration file for XMLBeans. Option : -xc ${xsdFileForXMLBeans}
	 *
	 * @parameter
	 */
	protected File xsdFileForXMLBeans;

	/**
	 * Remove selected packages. Option : -ep
	 *
	 * @parameter expression="false"
	 */
	protected boolean removeSelectedPackages;

	/**
	 * Custom skeleton interface name. Option : -sin ${skeletonInterfaceName}
	 *
	 * @parameter
	 */
	protected String skeletonInterfaceName;

	/**
	 * Custom skeleton class name. Option : -scn ${skeletonInterfaceName}
	 *
	 * @parameter
	 */
	protected String skeletonClassName;

	/**
	 * Override existing code. Option : -or
	 *
	 * @parameter expression="false"
	 */
	protected boolean overrideCode;

	/**
	 * Override absolute schema URLs. Option : -oaa
	 *
	 * @parameter expression="false"
	 */
	protected boolean overrideSchemaURLs;

	/**
	 * Gets the parameter array.
	 *
	 * @param parameterList
	 *            the parameter list
	 * @return the parameter array
	 */
	protected String[] getParameterArray(List<String> parameterList) {

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
	protected List<String> getParameterList() {

		Vector<String> parameterList = new Vector<String>();
		parameterList.add(WSDL_LOCATION_OPTION);
		parameterList.add(wsdlLocation.toString());
		parameterList.add(GENERATED_CODE_LOCATION);
		parameterList.add(generatedCodeLocation.toString());

		if (generateServiceDescription) {
			parameterList.add(GENERATE_SERVICE_DESCRIPTION);
		}
		if (generateTestCase) {
			parameterList.add(GENERATE_TEST_CASE);
		}
		if (noWSDL) {
			parameterList.add(NO_WSDL);
		}
		if (noMessageReceiver) {
			parameterList.add(NO_MESSAGE_RECEIVER);
		}
		if (noBuildXML) {
			parameterList.add(NO_BUILD_XML);
		}
		if (generateAsyncCode) {
			parameterList.add(GENERATE_ASYNC_CODE);
		}
		if (generateSyncCode) {
			parameterList.add(GENERATE_SYNC_CODE);
		}
		if (customPackageName != null && !customPackageName.equals("")) {
			parameterList.add(CUSTOM_PACKAGE_NAME);
			parameterList.add(customPackageName);
		}
		if (language != null && !language.equals("")) {
			parameterList.add(LANGUAGE);
			parameterList.add(language);
		}
		if (databinding != null && !databinding.equals("")) {
			parameterList.add(DATABINDING);
			parameterList.add(databinding);
		}
		if (unpack) {
			parameterList.add(UNPACK);
		}
		if (sourceFolder != null && !sourceFolder.toString().equals("")) {
			parameterList.add(SOURCE_FOLDER);
			parameterList.add(sourceFolder.toString());
		}
		if (resourceFolder != null && !resourceFolder.toString().equals("")) {
			parameterList.add(RESOURCE_FOLDER);
			parameterList.add(resourceFolder.toString());
		}
		if (portName != null && !portName.equals("")) {
			parameterList.add(PORT_NAME);
			parameterList.add(portName);
		}
		if (serviceName != null && !serviceName.equals("")) {
			parameterList.add(SERVICE_NAME);
			parameterList.add(serviceName);
		}
		if (repositoryFolder != null && !repositoryFolder.toString().equals("")) {
			parameterList.add(REPOSITORY_FOLDER);
			parameterList.add(repositoryFolder.toString());
		}
		if (generateServiceSkeletonOnly) {
			parameterList.add(GENERATE_SERVICE_SKELETON_ONLY);
		}
		if (generateAllCode) {
			parameterList.add(GENERATE_ALL_CODE);
		}
		if (externalTypeMappingFile != null
				&& !externalTypeMappingFile.toString().equals("")) {
			parameterList.add(EXTERNAL_TYPE_MAPPING_FILE);
			parameterList.add(externalTypeMappingFile.toString());
		}
		if (namespacePackages != null && !namespacePackages.equals("")) {
			parameterList.add(NAME_SPACE_PACKAGES);
			for (int i = 0; i < namespacePackages.size(); i++) {
				String parameter = new String();
				parameter = "uri=" + namespacePackages.get(i);
				// Add a comma if not the last parameter
				if (i != namespacePackages.size() - 1) {
					parameter = parameter + ",";

				}
			}
		}
		if (unwrap) {
			parameterList.add(UNWRAP);
		}
		if (wsdlVersion != null && !wsdlVersion.equals("")) {
			parameterList.add(WSDL_VERSION);
			parameterList.add(wsdlVersion);
		}
		if (flattenFiles) {
			parameterList.add(FLATTEN_FILES);
		}
		if (isCodeBackwardCompatible) {
			parameterList.add(IS_CODE_BACKWARD_COMPATIBLE);
		}
		if (suppressPrefixes) {
			parameterList.add(SUPPRESS_PREFIXES);
		}
		if (xsdFileForXMLBeans != null
				&& !xsdFileForXMLBeans.toString().equals("")) {
			parameterList.add(XSD_FILE_FOR_XML_BEANS);
			parameterList.add(xsdFileForXMLBeans.toString());
		}
		if (removeSelectedPackages) {
			parameterList.add(REMOVE_SELECTED_PACKAGES);
		}
		if (skeletonInterfaceName != null && !skeletonInterfaceName.equals("")) {
			parameterList.add(SKELETON_INTERFACE_NAME);
			parameterList.add(skeletonInterfaceName);
		}
		if (skeletonClassName != null && !skeletonClassName.equals("")) {
			parameterList.add(SKELETON_CLASS_NAME);
			parameterList.add(skeletonClassName);
		}
		if (overrideCode) {
			parameterList.add(OVERRIDE_CODE);
		}
		if (overrideSchemaURLs) {
			parameterList.add(OVERRIDE_SCHEMA_URLS);
		}

		return parameterList;

	}
}
