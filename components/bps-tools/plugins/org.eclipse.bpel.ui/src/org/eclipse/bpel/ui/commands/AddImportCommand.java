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

import org.eclipse.bpel.common.ui.editmodel.ResourceInfo;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDConstants;


/**
 * Adds an Import to the Imports contained in the Process.
 * 
 * This command object can also be used to determine if an import
 * can be added or if it would create a duplicate.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

public class AddImportCommand extends AutoUndoCommand {
	
	Process fProcess;
	Import  fImport;
	boolean bNoop = false;
	
	ResourceInfo fResourceInfo;	

	/**
	 * Create a new instance of the AddImportCommand
	 * @param process
	 * @param object either an Import, XSDSchema, Definition, or any element
	 *  belonging to schema or definition (that is, whose parent is  either a schema
	 *  or a definition).
	 */
	
	public AddImportCommand ( Process process , Object object, ResourceInfo info ) {
		super(IBPELUIConstants.CMD_ADD_IMPORT,process);
		fProcess = process;
		fResourceInfo = info;
		
		fImport = createImport( object );	
		
		if (fImport != null) {	
			bNoop = ModelHelper.containsImport( fProcess, fImport );
		}		
	}
	
	public AddImportCommand ( Process process, Object object) {
		this(process,object,null);
	}	
	
	protected EList<Import> getList() {	
		return fProcess.getImports();		
	}
	
	@Override
	public void doExecute() {
		if (bNoop) {
			return ;
		}
		fProcess.getImports().add(0, fImport );
	}


	public boolean wouldCreateDuplicateImport () {
		return bNoop;
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
		

	Import createImportFrom(XSDSchema schema) {
		
		Import imp = BPELFactory.eINSTANCE.createImport();
	
		// namespace
		String t = schema.getTargetNamespace();
		if (t != null) {
			imp.setNamespace( t );
		}
		// location
		Resource resource = fProcess.eResource();		
		URI schemaURI = URI.createURI(schema.getSchemaLocation());
				
		imp.setLocation( schemaURI.deresolve(resource.getURI()).toString() );
		
		// importType (the XSD kind)
		imp.setImportType( XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);
	
		return imp;
	}

	
	Import createImportFrom (Definition defn) {
		
		Import imp = BPELFactory.eINSTANCE.createImport();
	
		// namespace
		String t = defn.getTargetNamespace();
		if (t != null) {
			imp.setNamespace( t );
		}
		// location
		Resource resource = fProcess.eResource();
		URI schemaURI = null;
		
		if (defn.getLocation() == null) {
			
			if (fResourceInfo != null) {
				imp.setLocation ( fResourceInfo.getFile().toString() );
			}
			
		} else {
			schemaURI = URI.createURI( defn.getLocation() );
			imp.setLocation( schemaURI.deresolve(resource.getURI(),true,true,true).toString() );
		}
		
		// importType (the WSDL kind)
		imp.setImportType(  WSDLConstants.WSDL_NAMESPACE_URI );
	
		return imp;		
	}

}
