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
package org.eclipse.bpel.validator.wsdl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.validator.IBPELMarker;
import org.eclipse.bpel.validator.ModelQuery;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Validator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.internal.impl.ImportImpl;
import org.eclipse.wst.wsdl.util.WSDLParser;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.impl.XSDImportImpl;
import org.eclipse.xsd.impl.XSDIncludeImpl;
import org.eclipse.xsd.util.XSDParser;
import org.w3c.dom.Node;


/**
 * This thing exists here just for the benefit of the property and property
 * alias validators.
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */


public class Definitions extends Validator {

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7116
	// Added <import> location checking: missing XSD imports are not reported by WSDL validator!
	@Override
	@ARule(
			sa = -1,
			desc = "Check WSDL definition",
			author = "michal.chmielewski@oracle.com",
			date = "02/15/2007",
			errors="BPELC_IMPORT__UNRESOVED"
		)
	protected void start() {
		super.start();
		
		Definition definition = (Definition)mModelQuery.adapt(mNode,EObject.class,ModelQuery.ADAPT_HINT_NONE);
		List<EObject> unresolved = findUnresolvedImports(definition);
		
		for (EObject obj : unresolved) {
			String location = "unkonwn";
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7107
			// line/column gathering was moved to ModelQuery class
			if (obj instanceof Import) {
				location = ((Import)obj).getLocationURI();
			}
			else if ( obj instanceof XSDImportImpl ) {
				location = ((XSDImportImpl)obj).getSchemaLocation();
			}
			else if ( obj instanceof XSDIncludeImpl ) {
				location = ((XSDIncludeImpl)obj).getSchemaLocation();
			}
			
			IProblem problem = createWarning( (INode)mModelQuery.adapt(obj,INode.class,IModelQuery.ADAPT_HINT_NONE) );
			
			problem.fill("BPELC_IMPORT__UNRESOVED",  //$NON-NLS-1$
					toString(mNode.nodeName()),
					location, // location of the unresolved document being imported
					definition.getLocation()); // location of document doing the importing	
		}
	}
	
    
    @SuppressWarnings({ "restriction", "unchecked", "rawtypes" })
	protected List<EObject> findUnresolvedImports(Definition definition) {
    	if (definition == null) {
        	return Collections.emptyList();
        }
    	
    	IAdapterManager adapterManager = Platform.getAdapterManager();
    	IFile file = (IFile)adapterManager.getAdapter(definition, IResource.class);
		if (file!=null && file.exists())
			try {
				file.deleteMarkers(IBPELMarker.ID, false, IResource.DEPTH_INFINITE);
//				System.out.println("deleted markers from "+file);
			} catch (CoreException e) {
				e.printStackTrace();
			}
        
        ArrayList<EObject> imports = new ArrayList<EObject>();
        if (definition.getImports() != null) {
        	Iterator defImp = definition.getImports().values().iterator();
        	while (defImp.hasNext()) {
        		List impList = (List) defImp.next();
        		for (int i=0; i<impList.size(); i++) {
					ImportImpl wsdlImport = (ImportImpl) impList.get(i);
        			wsdlImport.importDefinitionOrSchema();
        			XSDSchema schema = wsdlImport.getESchema();
        			Definition wsdlDefinition = wsdlImport.getEDefinition();
        			if (schema==null && wsdlDefinition==null)
        				imports.add(wsdlImport);
        			// only look at top-level imports to avoid multiple reports of the same problem
					imports.addAll(findUnresolvedImports(wsdlDefinition));
        		}
        	}
        }
        if (definition.getETypes() != null) {
			List<XSDSchema> schemas = definition.getETypes().getSchemas();
        	for (XSDSchema si : schemas) {
        		for (XSDSchemaContent sc : si.getContents()) {
        			if (sc instanceof XSDIncludeImpl) {
        				XSDIncludeImpl inc = (XSDIncludeImpl)sc;
        				inc.getIncorporatedSchema();
        				if (inc.getResolvedSchema() == null)
        					imports.add(inc);
        			}
        			if (sc instanceof XSDImportImpl) {
        				XSDImportImpl imp = (XSDImportImpl)sc;
        				imp.importSchema();
        				if (imp.getResolvedSchema() == null)
        					imports.add(imp);
        			}
        		}
        	}
        }

        return imports;        	
    }
}
