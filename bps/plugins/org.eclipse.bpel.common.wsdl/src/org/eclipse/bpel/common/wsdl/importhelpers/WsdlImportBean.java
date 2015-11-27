/******************************************************************************
 * Copyright (c) 2011, EBM WebSourcing
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EBM WebSourcing - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.common.wsdl.importhelpers;

import java.util.HashMap;
import java.util.Map;

/**
 * A bean to store information about an import in a WSDL or XML schema.
 * <p>
 * Package visibility.
 * </p>
 *
 * @author Vincent Zurczak - EBM WebSourcing
 */
class WsdlImportBean {

	private boolean analyzed = false;
	private String originUri;
	private String relativePathToTargetDirectory;
	private final Map<String,String> importDeclarationToImportFullUri;



	/**
	 * Constructor.
	 */
	public WsdlImportBean() {
		this.importDeclarationToImportFullUri = new HashMap<String,String>();
	}


	/**
	 * @return the originUri
	 */
	public String getOriginUri() {
		return this.originUri;
	}


	/**}
	 * @param originUri the originUri to set
	 */
	public void setOriginUri( String originUri ) {
		this.originUri = originUri;
	}


	/**
	 * @return the analyzed
	 */
	public boolean wasAnalyzed() {
		return this.analyzed;
	}


	/**
	 * @param analyzed the analyzed to set
	 */
	public void setAnalyzed( boolean analyzed ) {
		this.analyzed = analyzed;
	}


	/**
	 * @return the relativePathToTargetDirectory
	 */
	public String getRelativePathToTargetDirectory() {
		return this.relativePathToTargetDirectory;
	}


	/**
	 * @param relativePathToTargetDirectory the relativePathToTargetDirectory to set
	 */
	public void setRelativePathToTargetDirectory(
			String relativePathToTargetDirectory ) {
		this.relativePathToTargetDirectory = relativePathToTargetDirectory;
	}


	/**
	 * @param importDeclaration the import declaration
	 * @param importFullUri the full URI of the import
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 * <p>
	 * If the file being parsed is located at <i>http://192.168.1.17/WSDL/myWsdl.wsdl</i>
	 * and associated to this instance of {@link WsdlImportBean},
	 * then an import declaration make be <i>subDir/schemes.xsd</i> and the full URI
	 * be <i>http://192.168.1.17/WSDL/subDir/schemes.xsd</i>.
	 * </p>
	 */
	public void registerImport( String importDeclaration, String importFullUri ) {
		this.importDeclarationToImportFullUri.put( importDeclaration, importFullUri );
	}


	/**
	 * @return the map that associates import declarations (keys) and full URIs( values)
	 */
	public Map<String, String> getImportDeclarationToImportFullUri() {
		return this.importDeclarationToImportFullUri;
	}
}
