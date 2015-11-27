/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.util;

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Import;
import org.eclipse.emf.ecore.EObject;


/**
 * Import resolver
 * 
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Apr 17, 2007
 */

public interface ImportResolver
{   
	/** Resolve the schema from the import */	
	int RESOLVE_SCHEMA = 1;
	
	/** Resolve the definition from the import */
	int RESOLVE_DEFINITION = 2;
	
	/** The top element, which implies the model behind the import */
	String TOP = "top.element"; //$NON-NLS-1$
	
	/**  
	 * @return the import type for this resolver
	 */
	
	String getImportType();
	
	/**
	 * Resolve the import
	 * @param imp
	 * @param qname
	 * @param name
	 * @param refType
	 * @return the resolved object
	 */
	
    EObject resolve(Import imp, QName qname, String name, String refType);
    
    /** 
     * Resolve something from the import
     *  
     * @param imp the import
     * @param what the thing to resolve 
     * @return the resolved list of objects (never null)
     */
    
    List<Object> resolve ( Import imp , int what );    
}
