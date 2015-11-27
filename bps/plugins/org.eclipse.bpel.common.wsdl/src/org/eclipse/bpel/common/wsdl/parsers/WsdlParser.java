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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.wst.wsdl.internal.util.WSDLResourceFactoryImpl;

/**
 * A set of utilities to parse WSDL definitions and accounting for file imports.
 * <p>
 * This class aims at providing more features than the WSDL meta-model (from WTP)
 * or than WSDL4j. The difference resides in the support of resource imports.
 * </p>
 * <p>
 * The implementation is currently based on the EMF meta-model for WSDL.
 * </p>
 *
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class WsdlParser {

	/**
	 * Loads a WSDL definition.
	 * @param emfUri an EMF URI
	 * @param resourceSet a resource set
	 * @return an instance of {@link Definition}
	 * <p>
	 * This object does not support inclusions of WSDL files.
	 * It means imported WSDL definitions must be parsed separately.
	 * Note that XML schema inclusions are correctly supported.
	 * </p>
	 */
	public static Definition loadWsdlDefinition( URI emfUri, ResourceSet resourceSet ) {
        Resource resource = resourceSet.getResource( emfUri, true );
        return (Definition) resource.getContents().iterator().next();
	}


	/**
	 * Loads a set of WSDL definition from one document.
	 * <p>
	 * The set includes the other definitions that come from the imports.
	 * </p>
	 *
	 * @see #findAllWsdlDefinitions(Definition)
	 * @param emfUri an EMF URI
	 * @param resourceSet a resource set
	 * @return an instance of {@link Definition}
	 * <p>
	 * This object supports inclusions of WSDL and XML Schema.
	 * XML schema inclusions are supported natively by the Definition object.
	 * WSDL inclusions are supported because every WSDL import results in a Definition instance.
	 * </p>
	 * <p>
	 * This method handles cyclic inclusions.
	 * </p>
	 */
	public static Collection<Definition> loadAllWsdlDefinitions( URI emfUri, ResourceSet resourceSet ) {
		Resource resource = resourceSet.getResource( emfUri, true );
        Definition def = (Definition) resource.getContents().iterator().next();
        return findAllWsdlDefinitions( def );
	}


	/**
	 * Finds all the referenced WSDL definitions from one already loaded definition.
	 * <p>
	 * The set includes the other definitions that come from the imports.
	 * </p>
	 *
	 * @param alreadyLoadedDefinition a WSDL definition
	 * @return an instance of {@link Definition}
	 * <p>
	 * This object supports inclusions of WSDL and XML Schema.
	 * XML schema inclusions are supported natively by the Definition object.
	 * WSDL inclusions are supported because every WSDL import results in a Definition instance.
	 * </p>
	 * <p>
	 * This method handles cyclic inclusions.
	 * </p>
	 */
	public static Collection<Definition> findAllWsdlDefinitions( Definition alreadyLoadedDefinition ) {

		// Add the initial definition
		Set<Definition> definitions = new HashSet<Definition> ();
        definitions.add( alreadyLoadedDefinition );

        // Process the imports
        processImports( alreadyLoadedDefinition.getImports(), definitions );

        return definitions;
	}


	/**
	 * Checks whether a definition seems valid or not.
	 * <p>
	 * The need for such a method results from the following discovery: when you load
	 * a WSDL 2.0 with the EMF meta-model, no error is thrown. Instead, a definition is
	 * created but it contains no information.
	 * </p>
	 *
	 * @param def a WSDL definition
	 * @return true if the definition seems valid, or false if it is definitely not a valid one
	 */
	public static boolean seemsValidDefinition( Definition def ) {

		return def.getBindings().size() != 0
				|| def.getPortTypes().size() != 0
				|| def.getServices().size() != 0
				|| def.getImports().size() != 0
				|| def.getTypes() != null;
	}


	/**
	 * Creates a resource set to parse WSDL definitions.
	 * <p>
	 * Note that WSDL extensions, such as partner link types, are not supported.
	 * Their support must be added in the resource set.
	 * </p>
	 *
	 * @return a resource set to parse WSDL
	 */
	public static ResourceSet createBasicResourceSetForWsdl() {

        ResourceSet resourceSet = XmlSchemaParser.createBasicResourceSetForXmlSchema();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "wsdl", new WSDLResourceFactoryImpl());
        resourceSet.getPackageRegistry().put( WSDLPackage.eNS_URI, WSDLPackage.eINSTANCE );

        return resourceSet;
	}


	/**
	 * Finds the definitions from imports and processes them recursively.
	 * @param imports a map of imports (see {@link Definition#getImports()})
	 * @param definitions a list of definitions, found from import declarations
	 */
	private static void processImports( Map<?,?> imports, Collection<Definition> definitions ) {

		for( Object o : imports.values()) {

			// Case "java.util.list"
			if( o instanceof List<?> ) {
				for( Object oo : ((List<?>) o)) {
					Definition d = ((Import) oo).getEDefinition();
					if( d != null && ! definitions.contains( d )) {
						definitions.add( d );
						processImports( d.getImports(), definitions );
					}
				}
			}

			// Case "org.eclipse.wst.Definition"
			else if( o instanceof Definition ) {
				Definition d = (Definition) o;;
				if( ! definitions.contains( d )) {
					definitions.add( d );
					processImports( d.getImports(), definitions );
				}
			}
		}
	}
}
