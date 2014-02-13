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


/**
 * This class resolves types from the XMLCatalog. While this
 * code properly belongs in XSDUtil, it sits in its own class
 * because none of this code may run in the runtime (where the
 * XMLCatalog does not exist). Callers of these methods *must*
 * ensure that they are running in a tools environment.
 */
public class XMLCatalogUtil {
// RTP:
//	
//    protected static XMLCatalogURIResolverExtension xmlCatalogResolver;
//
//    /**
//     * Resolve from a system schema. This uses the XML catalog, and should
//     * only ever be called from within the tools.
//     */
//    public static EObject resolveFromSystemSchema(QName qname, String refType, Resource context) {
//    	if (!Platform.isRunning()) return null;
//		if (xmlCatalogResolver == null)
//			xmlCatalogResolver = new XMLCatalogURIResolverExtension();
//		String publicID = qname.getNamespaceURI();
//		String systemID = null;
//		
//		String locationString = xmlCatalogResolver.resolve(null, null, publicID, systemID);
//		if (locationString == null) return null;
//		URI locationURI = URI.createURI(locationString);
//        
//        // Load the schema
//        try {
//            ResourceSet resourceSet = context.getResourceSet();
//            XSDResourceImpl resource = (XSDResourceImpl)resourceSet.getResource(locationURI, true);
//            XSDSchema schema = resource.getSchema();
//            return XSDUtil.resolve(schema, qname, null, refType);
//        } catch (Exception e) {
//            // TODO : Handle this better
//        	e.printStackTrace();
//        }
//        return null;
//    }
//    
//
}
