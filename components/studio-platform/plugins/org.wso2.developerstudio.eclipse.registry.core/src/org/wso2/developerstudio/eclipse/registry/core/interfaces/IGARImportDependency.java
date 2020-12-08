package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.io.File;
import java.net.URL;

/**
 * Model object to contain GAR dependency
 * 
 * @author saminda
 * 
 */
public interface IGARImportDependency {
	final static String SCHEMA_LOCATION="schemas";
	final static String WSDL_LOCATION="wsdls";
	final static String POLICY_LOCATION="policies";
	
	/**
	 * Whether to include this dependency in the governance archive
	 * 
	 * @return
	 */
	public boolean isExclude();
	
	/**
	 * set whether to exclude this dependency from the governance archive
	 * 
	 * @return
	 */
	public void setExclude(boolean exclude);

	/**
	 * Retrieve the list of WSDL imports in this dependency
	 * 
	 * @return
	 * @throws Exception 
	 */
	public IGARImportDependency[] getWSDLImports() throws Exception;

	/**
	 * Retrieve the list of Schema imports in this dependency
	 * 
	 * @return
	 * @throws Exception 
	 */
	public IGARImportDependency[] getSchemaImports() throws Exception;

	/**
	 * Retrieve the list of Schema includes in this dependency
	 * 
	 * @return
	 * @throws Exception 
	 */
	public IGARImportDependency[] getSchemaIncludes() throws Exception;
	
	/**
	 * Retrieve the list of policies in this dependency
	 * 
	 * @return
	 * @throws Exception 
	 */
	public IGARImportDependency[] getPolicyImports() throws Exception;
	
	/**
	 * Retrieve source url for this dependency
	 * 
	 * @return
	 */
	public URL getSource();

	/**
	 * Whether this dependency is a WSDL or a Schema
	 * 
	 * @return
	 */
	public GARFileType getType();

	/**
	 * Get the path which it was specified for the dependency import in this
	 * dependency
	 * 
	 * @param garImport
	 *            - the dependency import in this dependency import
	 * @return
	 * @throws Exception 
	 */
	public String getSpecifiedSource(IGARImportDependency garImport) throws Exception;
	
	/**
	 * Will create a governance archive compatible file structure with the dependent schemas & wsdls
	 * @param baseLocation
	 * @param schemaLocation
	 * @param wsdlLocation
	 * @param isRoot
	 * @return
	 * @throws Exception 
	 */
	public File toFile(File baseLocation, boolean isRoot) throws Exception;

}
