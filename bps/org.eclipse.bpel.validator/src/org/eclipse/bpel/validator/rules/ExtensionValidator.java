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

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;




/**
 * Validates Exit nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */

@SuppressWarnings({"nls","boxing"} )

public class ExtensionValidator extends CValidator {
			
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_EXTENSIONS );
	
	
	protected String fMustUnderstand;
	private String fNamespaceURI;
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#start()
	 */
	@Override
	protected void start() {
		super.start();
	}
	
	
	/**
	 * Check must understand
	 */
	
	@ARule(
			desc = "Check mustUnderstand attribute.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckMustUnderstand_1 () {
		fMustUnderstand = getAttribute(mNode, AT_MUST_UNDERSTAND, KIND_NODE, Filters.BOOLEAN_FILTER	,true);
		
		if (fMustUnderstand == null) {
			fMustUnderstand = NO;
		}		
	}
		
	/**
	 * Check to make sure namespace URI is set.
	 */
	
	@ARule(
			desc = "Check namespaceURI attribute.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckNamespaceURI_2 () {
		
		fNamespaceURI = getAttribute(mNode, AT_NAMESPACE, KIND_NODE, null, true);
		
	}
	
	
	/**
	 * In the case of mandatory extensions declared in the <extensions> element
	 * not supported by a WS-BPEL implementation, the process definition MUST be
	 * rejected.
	 * 
	 */

	@ARule(
		sa = 9,
		desc = "Mandatory extensions must be understood",
		date = "03/15/2007",
		errors="BPELC_EXTENSION__NOT_SUPPORTED"
	)
	public void rule_CheckMustUnderstand_20 () {
		String key = "extension." + fNamespaceURI + "." + fMustUnderstand;
		
		if (containsValueKey(fParentNode,key) ) {
			return ;
		}		
		boolean bSupports = mModelQuery.hasSupport(IModelQueryLookups.SUPPORT_EXTENSION,fNamespaceURI );
		
		setValue(fParentNode,key, bSupports);
		
		IProblem problem;
		
		if ( bSupports == false && YES.equals(fMustUnderstand)) {
			problem = createError();
			
			problem.fill("BPELC_EXTENSION__NOT_SUPPORTED",
				toString(mNode.nodeName()),
				fNamespaceURI,
				fMustUnderstand);
		}
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
