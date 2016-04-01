/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.xsd.XSDSchema;

/**
 * Content provider for XSDSchema. 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */

public class XSDSchemaFromResourceContentProvider extends AbstractResourceContentProvider  {

	static private final String KIND [] = { "xsd","wsdl" }; //$NON-NLS-1$ //$NON-NLS-2$
	
	static private final Class  KIND_CLASS[] = { XSDSchema.class , Definition.class };
	
	
	/**
	 * Append the schemas that are present in the object passed to the list
	 * indicated.   
	 * 
	 * @param input an object that has or is schema definitions.
	 * @param list the list where the schemas are put.
	 */
		 
	public XSDSchemaFromResourceContentProvider ( ResourceSet set ) {
		super(set);		
	}
	
	@Override
	protected Class[] getKindClass () {
		return KIND_CLASS;
	}
		
	@Override
	protected String[] getKind () {
		return KIND;
	}
}
