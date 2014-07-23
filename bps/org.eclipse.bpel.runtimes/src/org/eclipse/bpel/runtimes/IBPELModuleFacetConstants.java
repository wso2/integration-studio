/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes;

/**
 *
 *
 * @author Bruno Wassermann, written Jun 29, 2006
 */
public interface IBPELModuleFacetConstants {
	public final static String BPEL_CONTENT_FOLDER =  "BPELFacetInstallDataModelProvider.contentRoot";
	public final static String BPEL_CONTENT_DEFAULT_FOLDER =  "bpelContent";

	// module types
	public final static String BPEL20_MODULE_TYPE = "bpel.module"; //$NON-NLS-1$
	
	// module type versions
	public final static String BPEL11_MODULE_VERSION = "1.1"; // $NON-NLS-1$
	public final static String BPEL20_MODULE_VERSION = "2.0"; // $NON-NLS-1$
	
	// facet template
	public final static String BPEL20_FACET_TEMPLATE = "template.bpel.core";  //$NON-NLS-1$
	
	// facet
	public final static String BPEL20_PROJECT_FACET = "bpel.facet.core"; //$NON-NLS-1$ 
	public final static String JBT_BPEL20_PROJECT_FACET = "jbt.bpel.facet.core"; //$NON-NLS-1$ 
	
	// bpel file extension
	public final static String BPEL_FILE_EXTENSION = "bpel";  //$NON-NLS-1$
	public final static String DOT_BPEL_FILE_EXTENSION = "." + BPEL_FILE_EXTENSION;  //$NON-NLS-1$
}
