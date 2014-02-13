package org.wso2.developerstudio.eclipse.artifact.axis2.model;

import java.util.Observable;

import org.eclipse.core.resources.IProject;

public class DataModel extends Observable {

	// Required Parameters

	/**
	 * Data Binding Framework. Option : -d ${databinding}. Valid databinding(s)
	 * are adb, xmlbeans, jibx and jaxbri (Default: adb).
	 */
	private String databindingType;

	/**
	 * Namespaces to Package Mappings . Option-ns2p
	 * uri=namespacePackages.get(0),uri=namespacePackages.get(1),...
	 */
	private String namespaseToPackageMapping;

	/**
	 * Generate Synchronous Client Invocation Code. Option : -s
	 */
	private boolean generateSyncCode = false;
	/**
	 * Generate Asynchronous Client Invocation Code. Option : -a
	 */
	private boolean generateAsyncCode = false;

	/**
	 * Generates all code (synchronous and asynchronous). Option : -g
	 */
	private boolean generateAllCode = false;
	/**
	 * Generate a test case for the generated code. Option : -t
	 */
	private boolean generateTestCase = false;

	/**
	 * Unpacks generated classes. Option : -u
	 */
	private boolean unpack = false;

	/**
	 * Unwrap Parameters. Option : -uw
	 */
	private boolean unwrap = false;

	/**
	 * Location of the pom.xml (This is not a parameter)
	 */
	private String pomFileLocation;

	/**
	 * Location to put the generated code. Option : -o ${generatedCodeLocation}
	 */
	private String generatedCodeLocation;

	/**
	 * Location of the WSDL file. Option : -uri ${wsdlLocation}
	 */
	private String wsdlURI;

	/**
	 * Choose a specific port when there are multiple ports in the wsdl. Option
	 * : -pn ${portName}
	 */
	private String portName;

	/**
	 * Choose a specific service when there are multiple services in the wsdl.
	 * Option : -sn ${serviceName}
	 */
	private String serviceName;

	/**
	 * Custom package name. Option : -p
	 */
	private String packageName;

	/**
	 * Don't Generate Ant Build Script. Option : --noBuildXML
	 */
	private boolean noBuildXml;

	// ****************************Advanced Options
	// Parameters***********************************************************************************

	/**
	 * Generate service descriptor (i.e. services.xml). Option : -sd
	 *
	 * @parameter expression="false"
	 */
	private boolean generateServicedescriptor;

	/**
	 * Don't Copy the Source WSDL. Option : -noWSDL
	 *
	 * @parameter expression="false"
	 */
	private boolean noWSDL;

	/**
	 * Don't Generate Message Receiver. Option : --noMessageReceiver
	 *
	 * @parameter expression="false"
	 */
	private boolean noMessageReceiver;

	/**
	 * Stub language. Option : -l ${language}. Valid languages are java and c
	 * (Default: java)
	 */
	private String language;

	/**
	 * Source Folder Name. Option : -S ${sourceFolder}
	 */
	private String sourceFolder;

	/**
	 * Resource Folder Name. Option : -R ${resourceFolder}
	 */
	private String resourceFolder;

	/**
	 * Repository location. Option : -r${repositoryFolder}
	 *
	 * @parameter
	 */
	private String repositoryFolder;

	/**
	 * Generate service skeleton interface only. Option : -ssi
	 */
	private boolean generateServiceSkeletonOnly = false;

	/**
	 * External type mapping file. Option : -em ${externalTypeMappingFile}
	 */
	private String externalTypeMappingFile;

	/**
	 * The WSDL Version. Valid options are 1.1 and 2.0. Option : -wv
	 * ${wsdlVersion}
	 */
	private String wsdlVersion;

	/**
	 * Flatten files. Option : -f
	 */
	private boolean flattenFiles = false;

	/**
	 * Make the generated code backward compatible. Option : -b
	 *
	 * @parameter expression="false"
	 */
	private boolean isCodeBackwardCompatible = false;

	/**
	 * Suppress Prefixes. Option : -sp
	 */
	private boolean suppressPrefixes = false;

	/**
	 * XSD configuration file for XMLBeans. Option : -xc ${xsdFileForXMLBeans}
	 */
	private String xsdFileForXMLBeans;

	/**
	 * Remove selected packages. Option : -ep
	 */
	private boolean removeSelectedPackages = false;

	/**
	 * Custom skeleton interface name. Option : -sin ${skeletonInterfaceName}
	 */
	private String skeletonInterfaceName;

	/**
	 * Custom skeleton class name. Option : -scn ${skeletonInterfaceName}
	 */
	private String skeletonClassName;

	/**
	 * Override existing code. Option : -or
	 */
	private boolean overrideCode = false;

	/**
	 * Override absolute schema URLs. Option : -oaa
	 */
	private boolean overrideSchemaURLs = false;

	/**
	 * Generate server side code (i.e. skeletons). Option : -ss
	 *
	 * @parameter expression="false"
	 */
	private boolean generateServerSideCode;

	private IProject selectedProject;

	public String getPomFileLocation() {
		return pomFileLocation;
	}

	public void setPomFileLocation(String pomFileLocation) {
		this.pomFileLocation = pomFileLocation;
	}

	public String getDatabindingType() {
		return databindingType;
	}

	public void setDatabindingType(String databindingType) {
		this.databindingType = databindingType;
	}

	public boolean isGenerateAllCode() {
		return generateAllCode;
	}

	public void setGenerateAllCode(boolean generateAllCheck) {
		this.generateAllCode = generateAllCheck;
	}

	public String getNamespaseToPackageMapping() {
		return namespaseToPackageMapping;
	}

	public void setNamespaseToPackageMapping(String namespaseToPackageMapping) {
		this.namespaseToPackageMapping = namespaseToPackageMapping;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getWsdlURI() {
		return wsdlURI;
	}

	public void setWsdlURI(String wsdlURI) {
		this.wsdlURI = wsdlURI;
//		setChanged();
//		notifyObservers();
	}

	public boolean isGenerateAsyncCode() {
		return generateAsyncCode;
	}

	public void setGenerateAsyncCode(boolean async) {
		generateAsyncCode = async;
	}

	public boolean isGenerateSyncCode() {
		return generateSyncCode;
	}

	public void setGenerateSyncCode(boolean sync) {
		generateSyncCode = sync;
	}

	public boolean isGenerateTestCase() {
		return generateTestCase;
	}

	public void setGenerateTestCase(boolean testCaseCheck) {
		this.generateTestCase = testCaseCheck;
	}

	public boolean isUnpack() {
		return unpack;
	}

	public void setUnpack(boolean unpackClasses) {
		this.unpack = unpackClasses;
	}

	public void setUnwrap(boolean unwrapClasses) {
		this.unwrap = unwrapClasses;
	}

	public boolean isUnwrap() {
		return unwrap;
	}

	public String getGeneratedCodeLocation() {
		return generatedCodeLocation;
	}

	public void setGeneratedCodeLocation(String location) {
		this.generatedCodeLocation = location;
	}

	public void setNoBuildXml(boolean noBuildXml) {
		this.noBuildXml = noBuildXml;
	}

	public boolean isNoBuildXml() {
		return noBuildXml;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isGenerateServiceDescriptor() {
		return generateServicedescriptor;
	}

	public void setGenerateServicedescriptor(boolean generateServicedescriptor) {
		this.generateServicedescriptor = generateServicedescriptor;
	}

	public boolean isNoWSDL() {
		return noWSDL;
	}

	public void setNoWSDL(boolean noWSDL) {
		this.noWSDL = noWSDL;
	}

	public boolean isNoMessageReceiver() {
		return noMessageReceiver;
	}

	public void setNoMessageReceiver(boolean noMessageReceiver) {
		this.noMessageReceiver = noMessageReceiver;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSourceFolder() {
		return sourceFolder;
	}

	public void setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
		setChanged();
		notifyObservers();
	}

	public String getResourceFolder() {
		return resourceFolder;
	}

	public void setResourceFolder(String resourceFolder) {
		this.resourceFolder = resourceFolder;
	}

	public String getRepositoryFolder() {
		return repositoryFolder;
	}

	public void setRepositoryFolder(String repositoryFolder) {
		this.repositoryFolder = repositoryFolder;
	}

	public boolean isGenerateServiceSkeletonOnly() {
		return generateServiceSkeletonOnly;
	}

	public void setGenerateServiceSkeletonOnly(
			boolean generateServiceSkeletonOnly) {
		this.generateServiceSkeletonOnly = generateServiceSkeletonOnly;
	}

	public String getExternalTypeMappingFile() {
		return externalTypeMappingFile;
	}

	public void setExternalTypeMappingFile(String externalTypeMappingFile) {
		this.externalTypeMappingFile = externalTypeMappingFile;
	}

	public String getWsdlVersion() {
		return wsdlVersion;
	}

	public void setWsdlVersion(String wsdlVersion) {
		this.wsdlVersion = wsdlVersion;
	}

	public boolean isFlattenFiles() {
		return flattenFiles;
	}

	public void setFlattenFiles(boolean flattenFiles) {
		this.flattenFiles = flattenFiles;
	}

	public boolean isCodeBackwardCompatible() {
		return isCodeBackwardCompatible;
	}

	public void setCodeBackwardCompatible(boolean isCodeBackwardCompatible) {
		this.isCodeBackwardCompatible = isCodeBackwardCompatible;
	}

	public boolean isSuppressPrefixes() {
		return suppressPrefixes;
	}

	public void setSuppressPrefixes(boolean suppressPrefixes) {
		this.suppressPrefixes = suppressPrefixes;
	}

	public String getXsdFileForXMLBeans() {
		return xsdFileForXMLBeans;
	}

	public void setXsdFileForXMLBeans(String xsdFileForXMLBeans) {
		this.xsdFileForXMLBeans = xsdFileForXMLBeans;
	}

	public boolean isRemoveSelectedPackages() {
		return removeSelectedPackages;
	}

	public void setRemoveSelectedPackages(boolean removeSelectedPackages) {
		this.removeSelectedPackages = removeSelectedPackages;
	}

	public String getSkeletonInterfaceName() {
		return skeletonInterfaceName;
	}

	public void setSkeletonInterfaceName(String skeletonInterfaceName) {
		this.skeletonInterfaceName = skeletonInterfaceName;
	}

	public String getSkeletonClassName() {
		return skeletonClassName;
	}

	public void setSkeletonClassName(String skeletonClassName) {
		this.skeletonClassName = skeletonClassName;
	}

	public boolean isOverrideCode() {
		return overrideCode;
	}

	public void setOverrideCode(boolean overrideCode) {
		this.overrideCode = overrideCode;
	}

	public boolean isOverrideSchemaURLs() {
		return overrideSchemaURLs;
	}

	public void setOverrideSchemaURLs(boolean overrideSchemaURLs) {
		this.overrideSchemaURLs = overrideSchemaURLs;
	}

	public boolean isGenerateServerSideCode() {
		return generateServerSideCode;
	}

	public void setGenerateServerSideCode(boolean generateServerSideCode) {
		this.generateServerSideCode = generateServerSideCode;
	}

	public boolean isGenerateServicedescriptor() {
		return generateServicedescriptor;
	}

	public IProject getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}


}
