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
package org.eclipse.bpel.validator.rules;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Runner;



/**
 * Validates Import nodes.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 3, 2006
 *
 */


@SuppressWarnings("nls")
public class ImportValidator extends CValidator {
			
	/**
	 * Parent nodes 
	 */
	
	static public IFilter<INode> PARENTS = Filters.PROCESS;
	
	String fImportType;
	String fLocation;
	String fNamespace;
	INode fImportedNode;
	
	/**
	 * Start the validation of this node.
	 */
	@Override
	protected void start () {
		super.start();
		
		fLocation = mNode.getAttribute( AT_LOCATION );
		fImportType = mNode.getAttribute(AT_IMPORT_TYPE );
		fNamespace = mNode.getAttribute( AT_NAMESPACE );
	}
	
	/**
	 * Check if the importType attribute is set on the
	 * import. If it is not, then this is an error, per SA00013. 
	 */
	@ARule(
			desc = "Check if importType is set on import",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE"
		)
	
	@SuppressWarnings("boxing")
	public void rule_CheckIfImportTypesSet_1 () {
		
		IProblem problem;
		
		if (isEmptyOrWhitespace(fImportType)) {
			problem = createError();	
			problem.fill("BPELC__UNSET_ATTRIBUTE", //$NON-NLS-1$
					toString(mNode.nodeName()),
					AT_IMPORT_TYPE,					
					KIND_NODE);
			
			fImportType = null;
		}		
	}
		
	
	/**
	 * Check the location of the import. The location
	 * need not be specified, so this is a noop if it is not
	 * specified as we don't generally know how to resolve imports
	 * otherwise.
	 * Since ODE BPEL runtime only support the artifacts that be contained
	 * within the folder hierarchy of the deployment descriptor at the root
	 */
	
	@ARule(
			desc = "Check if location is set on import",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC_IMPORT_LOCATION"
		)
	public void rule_CheckLocation_3 () {
		
		if (fLocation == null) {
			return ;
		}
		// TODO: Check import locations to see if accessible  ?
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		IProblem problem;
		if(fLocation.indexOf("../") >=0 ){
			problem = createError();
			problem.fill( "BPELC_IMPORT_LOCATION", //$NON-NLS-1$
				fLocation,
				AT_LOCATION,
				toString(mNode.nodeName()),
				KIND_NODE );
		}
	}
	
	
	/**
	 * Check the import type. 
	 * BPEL 2.0 currently supports WSDL and XSD import types.
	 * Other importTypes are permitted, but not necessarily 
	 * understood. For this we print an informational problem only.
	 * 
	 */
	
	
	@ARule (
		date = "10/3/2006",
		author = "michal.chmielewski@oracle.com",
		desc = "Check the import type. BPEL 2.0 currently supports WSDL and XSD import types.",
		sa = 13 ,
		infos="BPELC_IMPORT__IMPORT_TYPE"
	)
	@SuppressWarnings("boxing")
	
	public void rule_CheckImportType_4 () {
		if (fImportType == null) {
			return ;
		}
		
		IProblem problem;
		if (mModelQuery.hasSupport(IModelQueryLookups.SUPPORT_IMPORT_TYPE,fImportType)) {			
			// good  
			
		} else {
			// This is just a note that says we don't understand it.
			// It is not an error per BPEL 2.0 spec.
			problem = createInfo();
			problem.fill( "BPELC_IMPORT__IMPORT_TYPE", //$NON-NLS-1$
				fImportType,
				AT_IMPORT_TYPE,
				toString(mNode.nodeName()),
				KIND_NODE );
			
		}
		
	}
	
	
	/**
	 * The namespace attribute. If set it must match the target
	 * namespace of the imported document. If unset, the imported
	 * document must not have a targetNamesace declared.
	 * 
	 */
	
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "01/15/2007",
		desc = "Imported namespace, if set, must match",
		sa = 11	,
		errors="BPELC_IMPORT__NS1"
	)
	public void rule_CheckNamespaceOfImport_8 () {
		
		if (fImportType == null) {
			return ;
		}
		IProblem problem;
		
		// look up the import node to produce the facade for the imported document.
		fImportedNode = mModelQuery.lookup( mNode,IModelQueryLookups.LOOKUP_NODE_IMPORT, "document");
		
		
		if (isUndefined(fImportedNode)) {
			return ;
		}
		
		String targetNS = fImportedNode.getAttribute(AT_TARGET_NAMESPACE);
		
		if ( isEmpty(fNamespace) == false ) {
			
			if (fNamespace.equals( targetNS ) == false) {
				problem = createError();
				problem.fill("BPELC_IMPORT__NS1",  //$NON-NLS-1$
						toString(mNode.nodeName()),
						fNamespace,
						targetNS);			
			}
		}			
	}


	/**
	 * Warn if the import cannot happen.
	 */
	
	@ARule(
		sa = 1234,
		desc = "Imported node location problem",
		author = "michal.chmielewski@oracle.com",
		date = "03/29/2007",
		errors="BPELC_IMPORT__UNRESOVED"
	)
	
	public void rule_CheckImportLocation_14 () {
		
		IProblem problem ;
		if (isUndefined(fImportedNode) && isNonEmpty(fLocation)) {
			
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7478
			problem = createError();
			problem.fill("BPELC_IMPORT__UNRESOVED",
					toString(mNode.nodeName()),
					fImportType,
					fLocation );
	}		

	}
	
	
	/**
	 * "When import has no namespace, the targetNamespace must be empty.",
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "01/15/2007",
		desc = "When import has no namespace, the targetNamespace must be empty.",
		sa = 12	,
		errors="BPELC_IMPORT__NS2"
	)
	
	public void rule_CheckNamespaceOfImport_15 () {

		if (isUndefined(fImportedNode)) {
			return ;
		}
		String targetNS = fImportedNode.getAttribute(AT_TARGET_NAMESPACE);
		
		IProblem problem;
		
		if (isEmpty(fNamespace)) {
 
			if (isEmpty(targetNS) == false) {
				problem = createError();
				problem.fill("BPELC_IMPORT__NS2",  //$NON-NLS-1$
						toString(mNode.nodeName()),
						fNamespace,
						targetNS);
			}
			
		}
		
	}
	
	
	
	/**
	 * Check the WSDL type of imports by running the validators that are hooked onto these 
	 * types of nodes.
	 *
	 */
		
	@Override
	public void end () {
		
		super.end();
		
		if (AT_VAL_IMPORT_WSDL.equals(fImportType) == false || isUndefined(fImportedNode) ) {
			return ;
		}
		
		Runner runner = new Runner(mModelQuery,fImportedNode);		
		addProblems( runner.run() );
	}
	
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
