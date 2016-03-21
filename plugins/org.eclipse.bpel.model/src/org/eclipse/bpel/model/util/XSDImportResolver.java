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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPlugin;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDConstants;


/**
 * XSD Import resolver.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Apr 17, 2007
 *
 */

@SuppressWarnings("nls")

public class XSDImportResolver implements ImportResolver {
    
	/**
	 * Report what kind of import handle.
	 * @return the schema for schema URI.
	 */
	
    public String getImportType() {
        return XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001;
    }
    
    /**
     * Find and load the schema based on the import statement
     * 
     * @param imp the import statement from the BPEL source
     * @return the schema that it references
     */
    
    
	protected <T extends EObject> T findAndLoad ( Import imp , String kind, Class<T> clazz ) 
    {
    	Resource baseResource = imp.eResource();
        String location = imp.getLocation();
        
    	// Bug 120110 - just bulletproofing :)
        if (baseResource==null)
        	return null;
        
        if (!baseResource.getURI().isRelative()) {
            location = URI.createURI(location).resolve(baseResource.getURI()).toString();
        }
        
        URI locationURI = URI.createURI(location);        
       
        BPELResourceSetImpl hackedResourceSet = BPELUtils.slightlyHackedResourceSet ( imp );
        
        Resource result = null;
        try {
        	result = hackedResourceSet.getResource(locationURI, true, kind);
        } catch (Throwable t) {
        	BPELPlugin.log("Resource " + locationURI + " cannot be read.",t,IStatus.WARNING);
        	return null;
        }
        
        // There is something here
        if (result.getContents().size() == 0) {
        	BPELPlugin.log("Resource " + locationURI + " is empty.",null,IStatus.WARNING) ;
        	return null;
        }
                
        try {
        	return clazz.cast(result.getContents().get(0));
        } catch (Throwable t) {
           	BPELPlugin.log("Resource " + locationURI + " is not of the expected kind.",t,IStatus.WARNING) ;        	
        }                
        return null;
    }

    
    /**
     * Resolve an object from the import.
     * @param imp to resolve from.
     * @param qname of the object.
     * @param name ?
     * @param refType the type of resolution that we are doing.
     * @return the resolved object.
     */
    
    public EObject resolve(Import imp, QName qname, String name, String refType) {
        EObject result = null;
        
        if (getImportType().equals(imp.getImportType()) == false) {
        	return result; 
        }
        
        if (XSDUtil.isSchemaType(refType) == false && TOP.equals(refType) == false) {
        	return result;            
        }        
        
        if (imp.getLocation() == null) { 
        	return result ; 
        }
        
        XSDSchema schema = findAndLoad( imp , "xsd", XSDSchema.class);   
        
        if (TOP.equals(refType)) {
        	return schema;
        }
        
        result = XSDUtil.resolve(schema, qname, name, refType);
        
        return result;
    }

    
	/** 
	 * Each XSDImport currently contributes only 1 schema.
	 * @param imp the import location
	 * @param what what to resolve
	 * @return the list of resolved items.
	 *  
	 * @see org.eclipse.bpel.model.util.ImportResolver#resolveSchemas(org.eclipse.bpel.model.Import)
	 */
    
	public List<Object> resolve (Import imp, int what) {
				
		if (getImportType().equals(imp.getImportType()) == false) {
			return Collections.emptyList();
		}
		if (what == RESOLVE_DEFINITION) {
			return Collections.emptyList();
		}
		
		List<Object> list = new ArrayList<Object>(1);
		XSDSchema schema = findAndLoad(imp,"xsd", XSDSchema.class);
		if (schema != null) {
			list.add ( schema );
		}
		return list;
	}    
    
}
