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

package org.eclipse.bpel.common.wsdl.parsers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.eclipse.xsd.util.XSDUtil;

/**
 * A set of utilities to parse XML schemas and accounting for file imports.
 * <p>
 * This class can be used with {@link XSDUtil}.
 * </p>
 *
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class XmlSchemaParser {

	/**
	 * Loads a XML schema.
	 * @param emfUri an EMF URI
	 * @param resourceSet a resource set
	 * @return an instance of {@link XSDSchema}
	 * <p>
	 * This object already supports inclusions, which means there is no need to
	 * get the imports and parse them.
	 * </p>
	 */
	public static XSDSchema loadXmlSchema( URI emfUri, ResourceSet resourceSet ) {
        Resource resource = resourceSet.getResource( emfUri, true );
        return (XSDSchema) resource.getContents().iterator().next();
	}


	/**
	 * @return a resource set to parse XML schemas
	 */
	public static ResourceSet createBasicResourceSetForXmlSchema() {

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "xml", new XMLResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "xsd", new XSDResourceFactoryImpl());
        resourceSet.getPackageRegistry().put( XSDPackage.eNS_URI, XSDPackage.eINSTANCE );

        return resourceSet;
	}
}
