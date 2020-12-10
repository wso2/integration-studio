/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.bpel.fnmeta.ClasspathFunctionRegistryLoader;
import org.eclipse.bpel.fnmeta.FunctionLibrary;
import org.eclipse.bpel.fnmeta.model.util.FMResourceFactoryImpl;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.model.adapters.BasicBPELAdapterFactory;
import org.eclipse.bpel.model.resource.BPELResourceFactoryImpl;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.validator.helpers.CmdValidator;
import org.eclipse.bpel.validator.helpers.GetOpt;
import org.eclipse.bpel.validator.helpers.ModelQueryImpl;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Runner;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.wst.wsdl.internal.util.WSDLResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.w3c.dom.Element;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 2, 2007
 *
 */

@SuppressWarnings("nls")

public class Main extends CmdValidator {
	
	ResourceSet fResourceSet;
		
	/**
	 * Create a brand new 
	 */
	@SuppressWarnings("unchecked")	
	public Main () {
	
		super();
		
		// Create the Quasi-Eclipse environment ...							
		AdapterRegistry.INSTANCE.registerAdapterFactory( new org.eclipse.bpel.validator.factory.AdapterFactory() );
		AdapterRegistry.INSTANCE.registerAdapterFactory( BPELPackage.eINSTANCE, BasicBPELAdapterFactory.INSTANCE );
				
		//	Create a resource set.
		fResourceSet = new BPELResourceSetImpl();
	    
		// Register the resource factories for .bpel, .wsdl, and .xsd resources.
		//   - bpel reads BPEL resources (our model)
		
		fResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	    		"bpel", new BPELResourceFactoryImpl() 
	    );

		fResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	    		"wsdl", new WSDLResourceFactoryImpl() 
	    );
		//   - wsdl reads WSDL resources (from wst project)
		
		// WSDL also needs to know about the extensions to WSDl that we provide, namely
		// partner links, variable properties, etc.
		// We need to register them someplace here ...
		
		fResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	    		"xsd", new XSDResourceFactoryImpl() 
	    );
		//   - xsd reads WSDL resources (from wst project)	
		
		
		fResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"fnmeta", new FMResourceFactoryImpl ()
		);
		
		// Register the real model query interface, that knows about EMF world as well.		
		ModelQueryImpl.register( new ModelQuery() );	
		
		// The function library is late bound. When eclipse is running, this information
		// is registered via the plugin's descriptor. On its own, we have to do it another way.
		
		FunctionLibrary.INSTANCE.registerLoader( new ClasspathFunctionRegistryLoader (fResourceSet) );
	}
	
	
	/**
	 * Validate the given file.
	 * @param file
	 * @return the list of validation errors.
	 */
	
	@Override
	public IProblem[] validate (File file) {
		//
		//Step 1. Read the BPEL process using the Model API.
		BPELReader reader = new BPELReader();
			
		reader.read( file, fResourceSet );
		Process process = reader.getProcess();
		
		if (process == null) {
			// If the file cannot be fetched in the resource set it's not because it does not exist necessarily.
			// EMF resource sets will not produce a corresponding EMF model if the process (top node) has the "wrong" 
			// namespace. In this case, we fall back to DOM only validation.
			return super.validate(file);
		}
		
		// Step 2. Preparation for the validator.
		linkModels(process);
				
		// Process as INode 
		INode node = AdapterRegistry.INSTANCE.adapt( process.getElement(), INode.class );
		
		// Step 3. Run it
		fRunner = new Runner ( new ModelQuery() , node);
		return fRunner.run();		
	}
		
	/**
	 * @param source
	 * @return the validation result
	 */
	
	@Override
	public IProblem[] validate (URL source) {
		//
		//Step 1. Read the BPEL process using the Model API.
		BPELReader reader = new BPELReader();
			
		reader.read( source, fResourceSet );
		Process process = reader.getProcess();
		
		if (process == null) {
			// If the file cannot be fetched in the resource set it's not because it does not exist necessarily.
			// EMF resource sets will not produce a corresponding EMF model if the process (top node) has the "wrong" 
			// namespace. In this case, we fall back to DOM only validation.
			return super.validate(source);
		}
		// Step 2. Preparation for the validator.
		linkModels(process);
				
		// Process as INode 
		INode node = AdapterRegistry.INSTANCE.adapt( process.getElement(), INode.class );
		
		// Step 3. Run it
		fRunner = new Runner ( new ModelQuery() , node);
		return fRunner.run();		
	}
		
	
	void linkModels ( EObject process ) {
		
		// 
		// Each extensible element points to the DOM element that 
		// comprises it. This is done in the BPEL reader as well as
		// the WSDL readers. Here we add a pointer to the 
		// emf objects from the DOM objects.
	
		Iterator<?> emfIterator = process.eAllContents();
		while (emfIterator.hasNext()) {
			Object obj = emfIterator.next();
			// This is because only ExtensibleElement has a reference to
			// a DOM element.
			if (obj instanceof WSDLElement) {
				WSDLElement wsdle = (WSDLElement) obj;
				Element el = wsdle.getElement();
				if (el != null) {
					el.setUserData("emf.model", obj, null); //$NON-NLS-1$
				}
			}
		}
	}
	
		
	/**
	 * Main entry point for the command line validator.
	 * @param argv
	 * @throws Exception 
	 */
	
	static public void main (String argv[]) throws Exception {
		
		Main builder = new Main();
		GetOpt opt = new GetOpt("-h",argv);		
		builder.run(opt);
	}
}
