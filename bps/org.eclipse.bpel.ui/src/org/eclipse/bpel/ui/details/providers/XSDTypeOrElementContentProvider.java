/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Types;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;

/**
 * Content provider for XSDComplexType. It also handles built-in types.
 * 
 * Expects an XSDSchema as input.
 */
public class XSDTypeOrElementContentProvider extends AbstractContentProvider  {

	final protected static List xsdPrimitiveTypes = XSDUtils.getAdvancedPrimitives();
	
	final protected static HashSet xsdPrimitiveTypesNames = new HashSet(xsdPrimitiveTypes.size() + 1);
	
	final public static int INCLUDE_SIMPLE_TYPES = 0x1;
	final public static int INCLUDE_COMPLEX_TYPES = 0x2;
	
	final public static int INCLUDE_TYPES = INCLUDE_SIMPLE_TYPES | INCLUDE_COMPLEX_TYPES;
	
	final public static int INCLUDE_ELEMENT_DECLARATIONS = 0x4;
	final public static int INCLUDE_PRIMITIVES = 0x8;
	
	// https://issues.jboss.org/browse/JBIDE-8045
	// fix typo
	final public static int INCLUDE_ALL = 0xff;
	
	static {
		Iterator i = xsdPrimitiveTypes.iterator();
		while (i.hasNext()) {
			XSDNamedComponent component =  (XSDNamedComponent) i.next();
			xsdPrimitiveTypesNames.add( component.getName() );
		}
	}

	private int fFilter = INCLUDE_ALL;
	

	public void setFilter ( int filter ) {
		fFilter = filter;
	}
	
	
	public int getFilter () {
		return fFilter;
	}
		
	
	/**
	 * Append the schemas that are present in the object passed to the list
	 * indicated. This can deal with WSDL definitions, XSDSchema, and a List or Array 
	 * of objects that any of those.  
	 * 
	 * @param input an object that has or is schema definitions.
	 * @param list the list where the schemas are put.
	 */
	
	@Override
	public void collectElements ( Object input, List list) {
		
		if (input == null) {
			return ;
		}
		
		if (input instanceof Definition) {
			Types types = ((Definition)input).getETypes();
			if (types == null) {
				return;
			}
			collectElements( types.getSchemas(), list);
			return;
		}
		
		if (input instanceof XSDSchema) {
			XSDSchema schema = (XSDSchema)input;
			addSchemaElements(list, schema);
			return;
		}

		collectComplex(input, list);
	}
	

	protected void addSchemaElements(List list, XSDSchema schema) {
		
		boolean builtInTypesSchema = XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001.equals(schema.getTargetNamespace());
		
		if (builtInTypesSchema && (fFilter & INCLUDE_PRIMITIVES) > 0 ) {			
			list.addAll ( XSDUtils.getAdvancedPrimitives () );
			return ;
		}
		
		if ((fFilter & INCLUDE_ELEMENT_DECLARATIONS) > 0) {
			list.addAll ( schema.getElementDeclarations() );	
		}
		
		if ( (fFilter & INCLUDE_TYPES) == 0) {
			return ;
		}
		
		List types = schema.getTypeDefinitions();
		Iterator i = types.iterator();
		boolean bAdd = false;
		
		while (i.hasNext()) {
			
			XSDTypeDefinition defn = (XSDTypeDefinition) i.next();
			
			bAdd = ( ((fFilter & INCLUDE_COMPLEX_TYPES) > 0) && (defn instanceof XSDComplexTypeDefinition) ||
					 ((fFilter & INCLUDE_SIMPLE_TYPES) > 0) && (defn instanceof XSDSimpleTypeDefinition) )  ;
					 
			if (bAdd) {
				list.add(defn);
			}			
		}	
		
	}
	
	/**
	 * Helper method for identifying if a given type is a built-in type.
	 */
	public static boolean isBuiltInType(XSDTypeDefinition target) {
		
		XSDSchema schema = (XSDSchema) target.eContainer();
		if (!XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001.equals(schema.getTargetNamespace())) {
			return false;
		}
		return xsdPrimitiveTypesNames.contains(target.getName());
	}
	
	
}
