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
package org.eclipse.bpel.validator.vprop;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.rules.CValidator;



/**
 * 
 * <vprop:propertyAlias propertyName="QName"
      messageType="QName"?
      part="NCName"?
      type="QName"?
      element="QName"?>
      <vprop:query queryLanguage="anyURI"?>?
         queryContent
      </vprop:query>
   </vprop:propertyAlias>   
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */


@SuppressWarnings( {"nls","boxing"} )

public class PropertyAlias extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( WSDL_ND_DEFINITIONS );

	protected String fTypeName;
	protected String fElementName;
	protected String fPropertyName;
	protected String fMessageTypeName;
	protected String fMessagePartName;
	protected String fDuplicateKey = null;	
	
	
	/**
	 * Start performing link checks.
	 */	
	
	@Override
	public void start () {
		super.start();			
		fPropertyName = mNode.getAttribute( WSDL_AT_PROPERTY_NAME );	
		
	}
	
	/**
	 * Rule to check the name of the link. 
	 */
	@ARule(
		sa = 0,
		desc = "Check the QName of the property for this propertyAlias",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007"
	)
	
	public void rule_CheckQName_1 () {		
//		if (mChecks.checkQName(mNode, fPropertyName, WSDL_AT_PROPERTY_NAME) == false) {
//			disableRules();
//		}		
	}
	
	
	/**
	 * A <vprop:propertyAlias> element MUST use one of the three following
	 * combinations of attributes:
	 * 
	 * 1. both messageType and part 
	 * 2. type
	 * 3. element 
	 */
	
	@ARule(
		sa = 20,
		desc = "Either the type or element attributes MUST be present or messageType AND part.",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass1",
		errors="BPELC_PROPERTY__UNSET"
	)
	
	public void rule_CheckPropertyAliasDefinition_10 () {
		
		fMessageTypeName = mNode.getAttribute(AT_MESSAGE_TYPE);
		fMessagePartName = mNode.getAttribute(AT_PART);
		
		fTypeName = mNode.getAttribute(AT_TYPE);
		fElementName = mNode.getAttribute(AT_ELEMENT);
		
		IProblem problem;
		QName nn = mNode.nodeName();
		
		if (isNonEmpty(fMessageTypeName) && isNonEmpty(fMessagePartName)) {			
			// good
			fDuplicateKey = nn + "/messageType/" + fMessageTypeName + "/" + fMessagePartName + "/" + fPropertyName;

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7107
		// sheesh! fix a typo
		} else if (isEmpty(fMessageTypeName) && isEmpty(fMessagePartName) ) {
			
			if (isEmpty(fTypeName) && isNonEmpty(fElementName)) {
				// good, element name
				fDuplicateKey = nn + "/element/" + fElementName + "/" + fPropertyName;
			
			} else if (isNonEmpty(fTypeName) && isEmpty(fElementName)) {
				// good, type name
				fDuplicateKey = "propertyAlias/type/" + fTypeName + "/" + fPropertyName;
				
			} else {
				
				problem = createError();
				problem.fill("BPELC_PROPERTY__UNSET",
						toString(mNode.nodeName()),
						AT_TYPE,
						AT_ELEMENT,
						0);
			}
			
		} else {
			
			problem  = createError();
			problem.fill("BPELC_PROPERTY__UNSET",
					toString(mNode.nodeName()),
					AT_MESSAGE_TYPE,
					AT_PART,
					1);						
		}
	}
	
	
	
	/**
	 * Static analysis MUST detect property usages where propertyAliases for the
	 * associated variable's type are not found in any WSDL definitions directly
	 * imported by the WS-BPEL process.
	 * 
	 */
	@ARule(
		sa = 21,
		desc = "Check types of property aliases",
		author = "michal.chmielewski@oracle.com",
		date = "03/18/2007",
		errors="BPELC__UNRESOLVED_ATTRIBUTE,BPELC_MSG__PART"
	)
	
	public void rule_ChceckPropertyAliasTypes_13 () {
		
		if (isEmpty(fDuplicateKey)) {
			return ;
		}
		
		IProblem problem;
		INode typeNode = null;

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7107				
		if (isNonEmpty(fMessageTypeName) && isNonEmpty(fMessagePartName)) {			
			// good			
			INode msgType = mModelQuery.lookup(mNode.rootNode(), 
					IModelQueryLookups.LOOKUP_NODE_MESSAGE_TYPE,fMessageTypeName);
			
			if (isUndefined(msgType)) {
				problem = createError();
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
						toString(mNode.nodeName()),
						AT_MESSAGE_TYPE,
						KIND_NODE,
						fMessageTypeName
				);
				
			} else {
				typeNode = mModelQuery.lookup(msgType, 
						IModelQueryLookups.LOOKUP_NODE_TYPE_OF_PART,fMessagePartName);
				
				if (isUndefined(typeNode)) {
					problem = createError();
					problem.fill("BPELC_MSG__PART",
						toString(mNode.nodeName()),
						fMessagePartName,
						fMessageTypeName
					);
				}
				
			}

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7107
		// reversed type and element...
		// wow, Michal must have been tired when he was writing this ;)
		} else if (isNonEmpty(fTypeName)) {
			// good, type name
			
			typeNode = mModelQuery.lookup(mNode.rootNode(), 
					IModelQueryLookups.LOOKUP_NODE_XSD_TYPE, fTypeName);
			
			if (isUndefined(typeNode)) {
				problem = createError();
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
						toString(mNode.nodeName()),
						AT_TYPE,
						KIND_NODE,
						fTypeName
				);
			}
				
		} else if (isNonEmpty(fElementName) ) {
			// good, element name
						
			typeNode = mModelQuery.lookup(mNode.rootNode(), 
					IModelQueryLookups.LOOKUP_NODE_XSD_ELEMENT, fElementName);
			
			if (isUndefined(typeNode)) {				
				problem = createError();				
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
						toString(mNode.nodeName()),
						AT_ELEMENT,
						KIND_NODE,
						fElementName
				);
			}
		}		
		
		// Set the type of property alias as derived so far.
		
		if (isDefined(typeNode)) {
			setValue("type",typeNode);
		}				
	}
	
	
	/**
	 * A WS-BPEL process definition MUST NOT be accepted for processing if it
	 * defines two or more propertyAliases for the same property name and
	 * WS-BPEL variable type.
	 * 
	 */
	@ARule(
		sa = 22,
		desc = "Detect duplicate propertyAlias definitions",
		author = "michal.chmielewski@oracle.com",
		date = "03/20/2007",
		errors="BPELC__DUPLICATE"
	)
	
	public void rule_CheckDuplicatePropertyAlias_25 () {
		
		if (isEmpty(fDuplicateKey)) {
			return;
		}
		
		IProblem problem;
		
		if (containsValueKey(fParentNode,fDuplicateKey)) {
			problem = createError();
			problem.fill("BPELC__DUPLICATE",
					toString(mNode.nodeName()),
					fPropertyName);
			return ;
		}
		
		setValue(fParentNode, fDuplicateKey,true);		
	}


	
	
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
