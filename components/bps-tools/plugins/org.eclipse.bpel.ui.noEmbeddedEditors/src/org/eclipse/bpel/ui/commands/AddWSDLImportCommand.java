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
package org.eclipse.bpel.ui.commands;

import java.util.Iterator;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;


/**
 * Adds an Import to the Imports contained in the Process.
 * 
 * This command object can also be used to determine if an import
 * can be added or if it would create a duplicate.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

public class AddWSDLImportCommand extends AutoUndoCommand {
	
	/* Definition into which the import will be placed. */
	Definition fDefinition;
	
	/* The WSDL import to create. 
	 * Note this is the WSDL import, not the BPEL import */
	Import fImport;

	/**
	 * Create a new instance of the AddImportCommand
	 * @param defn the WSDL definition to add import to
	 * @param object either an Import, XSDSchema, Definition, or any element
	 *  belonging to schema or definition (that is, whose parent is  either a schema
	 *  or a definition).
	 */
	
	public AddWSDLImportCommand ( Definition defn , Object object ) {
		super (defn);
		setLabel(IBPELUIConstants.CMD_ADD_IMPORT);
		
		fDefinition = defn;
		fImport = createImport( object );		
	}
		

	@Override
	public void doExecute() {
		
		if (fImport == null) {
			return ;
		}
		
		/* Add the WSDL imports */
		if (containsImport(fDefinition,fImport) == false) {				
			fImport.setEnclosingDefinition( fDefinition );
			fDefinition.addImport( fImport );		
		}				
	}


	Import createImport ( Object obj ) {
		
		if (obj instanceof Import) {
			return (Import) obj;
		}
		
		Import imp = null;
		
		EObject eObj = findImportableEntity ( (EObject) obj );
		
		if (eObj instanceof XSDSchema) {
			imp = createImportFrom((XSDSchema)eObj);			
		} else if (eObj instanceof Definition) {
			imp = createImportFrom((Definition)eObj);
		}
		
		return imp;
	}

	
	
	/**
	 * Try to establish the importable entity from the object passed.
	 * It is either a schema or a definition. Hence, any descendant may be 
	 * passed and the import command would correctly figure out which 
	 * object to import.
	 * 
	 * @param eObj the "reference" to base the import on
	 * @return the importable entity
	 */
	
	EObject findImportableEntity ( EObject eObj ) {
				
		// Figure my schema ... if any
		if (eObj instanceof XSDNamedComponent) {			
			XSDNamedComponent xsdObj = (XSDNamedComponent) eObj;
			eObj = xsdObj.getSchema();
		}
		
		// find the importable entity.
		while (eObj != null) 
		{		
			if (eObj instanceof Definition) {
				return eObj;
			}
			if (eObj instanceof XSDSchema) {
				// Hack ? 
				if (eObj.eContainer() == null) {
					return eObj;
				}
			}
			eObj = eObj.eContainer();
		}
		return eObj;			
	}
		

	Import createImportFrom (XSDSchema schema) {
		
		Import imp = WSDLFactory.eINSTANCE.createImport();
	
		// namespace
		String t = schema.getTargetNamespace();
		
		if (t != null) {
			imp.setNamespaceURI( t );
		}
		// location
		Resource resource = fDefinition.eResource();		
		URI schemaURI = URI.createURI(schema.getSchemaLocation());
				
		imp.setLocationURI( schemaURI.deresolve(resource.getURI()).toString() );
		
		imp.setDefinition( fDefinition );
		// imp.setImportType( XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);
	
		return imp;
	}

	
	Import createImportFrom (Definition defn) {
		
		Import imp = WSDLFactory.eINSTANCE.createImport();
	
		// namespace
		String t = defn.getTargetNamespace();
		if (t != null) {
			imp.setNamespaceURI( t );
		}
		
		// location of our the definition into which we are adding the import
		Resource resource = fDefinition.eResource();		
		URI defnURI = defn.eResource().getURI();
		String importURI = defnURI.deresolve(resource.getURI()).toString();
		if (importURI == null) {
			importURI = defnURI.toString();
		}
		imp.setLocationURI( importURI );
	
		return imp;		
	}

	boolean containsImport ( Definition defn, Import imp) {
		EList imports = defn.getEImports();
		// this checks for identity
		if (imports.contains( imp )) {
			return true;
		}

		// Don't add the import if it already exists ...
		Iterator i = imports.iterator();
		boolean bExists = false;
		while (i.hasNext() && !bExists) {
			Import n = (Import) i.next();			
			bExists = 	isEqual ( n.getLocationURI(),   imp.getLocationURI() )  &&
						isEqual ( n.getNamespaceURI(),  imp.getNamespaceURI() ) ;
		}		
		return bExists;
	}
	
	boolean isEqual ( String s1, String s2 ) {
		return s1 != null ? s1.equals( s2 ) : s2 == null;
	}
}
