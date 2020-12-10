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

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * Help with resolution (lookup) of types and element declaration in schemas.
 *  
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Feb 27, 2007
 *
 */

@SuppressWarnings("nls")
public class XSDUtil
{
	/** Lookup type definitions */
    public static final String XSD_TYPE_DEFINITION = XSDPackage.eINSTANCE.getXSDTypeDefinition().getName();
    
    /** Lookup element declarations */
    public static final String XSD_ELEMENT_DECLARATION = XSDPackage.eINSTANCE.getXSDElementDeclaration().getName();
    
    /** Lookup schema */
    public static final String XSD_SCHEMA = XSDPackage.eINSTANCE.getXSDSchema().getName();

    /**
     * Tests if <code>typeName</code> is a recognized reference type.
     * @param typeName the thing that we can lookup
     * @return true if we can, false if we cannot
     */
    
    public static boolean isSchemaType(String typeName)
    {
        return typeName == null ? false :
            XSD_TYPE_DEFINITION.equals(typeName)
            || XSD_ELEMENT_DECLARATION.equals(typeName);
    }

    /**
     * Resolve with the given schema the QName passed, given the hint on its refType 
     * 
     * @param schema the schema 
     * @param qname the QName to resolve
     * @param name  currently null
     * @param refType the refType to resolve.
     * 
     * @return the resolved object, or null
     */

	public static EObject resolve(XSDSchema schema, QName qname, String name, String refType)
    {
        EObject resolvedObject = null;
        if (XSD_TYPE_DEFINITION.equals(refType))
        {
            resolvedObject = resolveTypeDefinition(schema, qname);
        }
        else if (XSD_ELEMENT_DECLARATION.equals(refType))
        {
            resolvedObject = resolveElementDeclaration(schema, qname);
        }
        else if (XSD_SCHEMA.equals(refType)) 
        {
        	return schema;
        }
        else
        {
            System.err.println(XSDUtil.class.getName() + ": unrecognized refType: " + refType);
        }        
        return resolvedObject;
    }

	
    /**
     * Find the element declaration pointed by the QName in the schema passed.
     * 
     * @param schema the schema
     * @param qname the QName of the element declaration to find
     * @return the element declaration or null
     */
	
    public static XSDElementDeclaration resolveElementDeclaration(XSDSchema schema, QName qname)
    {
    	// Bug 120110 - just bulletproofing :)
    	if (schema==null)
    		return null;
        return schema.resolveElementDeclaration(XSDNamespaceAdjust (qname.getNamespaceURI()) , qname.getLocalPart());
    }
    
    
    /**
     * Find the type definition pointed by the QName in the schema passed.
     * 
     * @param schema the schema
     * @param qname the QName of the type definition to find
     * @return the type definition or null
     */
    public static XSDTypeDefinition resolveTypeDefinition(XSDSchema schema, QName qname)
    {
    	// Bug 120110 - just bulletproofing :)
    	if (schema==null)
    		return null;
        return schema.resolveTypeDefinition(XSDNamespaceAdjust ( qname.getNamespaceURI() ), qname.getLocalPart());
    }
    
    
    
    private static final String XSDNamespaceAdjust ( String nsURI ) {
    	if ("".equals(nsURI)) {
    		return null;
    	}
    	return nsURI;
    }
}
