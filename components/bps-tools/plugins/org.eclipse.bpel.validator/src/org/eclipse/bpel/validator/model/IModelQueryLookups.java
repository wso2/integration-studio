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
package org.eclipse.bpel.validator.model;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 19, 2007
 *
 */
public interface IModelQueryLookups {
	
	/** lookupNode() function call points */
	
	/** lookup variable, normal scoping rules, starting at context  */
	final int LOOKUP_NODE_VARIABLE = 1;
	
	/** lookup partner link, normal scoping rules, starting at context  */
	final int LOOKUP_NODE_PARTNER_LINK = 2;
	
	/** lookup a link node, normal scoping rules, starting at context  */
	final int LOOKUP_NODE_LINK = 3;
	
	/** lookup correlation set, normal scoping rules, starting at context  */
	final int LOOKUP_NODE_CORRELLETION_SET = 4;
	
	/** lookup import, normal scoping rules, starting at context  */
	final int LOOKUP_NODE_IMPORT = 5;
	    	
	/** Lookup operation */
	final int LOOKUP_NODE_OPERATION = 6;
	    	
	/** Lookup message type */
	final int LOOKUP_NODE_MESSAGE_TYPE = 7;
	    	
	/** Lookup XSDElement in the type system */
	final int LOOKUP_NODE_XSD_ELEMENT = 8; 
	    	
	/** Lookup XSD Type in the type system */
	final int LOOKUP_NODE_XSD_TYPE = 9;
	    	
	/** Lookup Partner link type */
	final int LOOKUP_NODE_PARTNER_LINK_TYPE = 10; 
	    	
	/** Lookup Role */
	final int LOOKUP_NODE_ROLE = 11; 
	    		
	/** Port types are looked up from definitions */
	final int LOOKUP_NODE_PORT_TYPE = 12; 
	    	
	/** Message parts are looked up from message types */
	final int LOOKUP_NODE_MESSAGE_PART = 13;
	    	
	/** Property */
	final int LOOKUP_NODE_PROPERTY = 14;
	    	
	/** Name steps are lookups in the location paths of an XML type */
	final int LOOKUP_NODE_NAME_STEP = 15;
			
	/** type of part lookup */
	final int LOOKUP_NODE_TYPE_OF_PART = 16;

	/** Name steps in attribute axis lookup */
	final int LOOKUP_NODE_NAME_STEP_ATTRIBUTE = 17;

	/** Name steps in descendant axis lookup */
	final int LOOKUP_NODE_NAME_STEP_DESCENDANT = 18;
	
	/** Name steps in descendant-or-self axis lookup */
	final int LOOKUP_NODE_NAME_STEP_DESCENDANT_OR_SELF = 19;

	/** Name steps in parent axis lookup */
	final int LOOKUP_NODE_NAME_STEP_PARENT = 20;


	
	/** hasSupport() function call points */
	
	/** Ask about query language support */
	final int SUPPORT_QUERY_LANGUAGE = 0;
		
	/** Ask about expression language support */
	final int SUPPORT_EXPRESSION_LANGUAGE = 1;
		
	/** Ask about import support */		
	final int SUPPORT_IMPORT_TYPE = 2;
		
	/** Ask about extensions */
	final int SUPPORT_EXTENSION = 3;	
	
	
	
   /**
     * Text lookup items. The things that we lookup in the model that have text value
     * of interest to us.
     *
     */
    	
    	/** lookup the prefix to get the namespace */
    final int LOOKUP_TEXT_PREFIX2NS = 0 ;
    	
    	/** lookup the prefix from the namespace */
    final int LOOKUP_TEXT_NS2PREFIX = 1 ;
    	
    	/** compute the nodes text value */
    final int LOOKUP_TEXT_TEXT = 2;
    	
    	/** compute the location of the node */
    final int LOOKUP_TEXT_LOCATION = 3 ;
    	
    	/** resource name, or file name */
    final int LOOKUP_TEXT_RESOURCE_PATH = 4 ;
    	
    	/** the pointer to that node in the model object space */
    final int LOOKUP_TEXT_HREF = 5 ;
    	
    	/** XPath to the node */
    final int LOOKUP_TEXT_HREF_XPATH = 6 ;
    
    
    

    
    /**
     * Lookup some numeric value in the model that is typically represented by a number. 
     */
        
    	/** Line number for this context node */
    final int LOOKUP_NUMBER_LINE_NO = 0;
    	
    	/** Column number */
    final int LOOKUP_NUMBER_COLUMN_NO = 1;
    	
    	/** char start for this context node */
    final int LOOKUP_NUMBER_CHAR_START = 2;
    	
    	/** char end for this context node */
    final int LOOKUP_NUMBER_CHAR_END = 3; 
    	    	
    	/** Line number for this context node (after) */
    final int LOOKUP_NUMBER_LINE_NO_2 = 4;
    	
    	/** Column number (after) */
    final int LOOKUP_NUMBER_COLUMN_NO_2 = 5;
    	
    	/** char start for this context node (after) */
    final int LOOKUP_NUMBER_CHAR_START_2 = 6;
    	
    	/** char end for this context node (after) */
    final int LOOKUP_NUMBER_CHAR_END_2 = 7; 
    
    
    
    /**
	 * Perform various tests on nodes.
	 * 
	 */
	
	/** Check if equal */
	final int TEST_EQUAL = 0;
		
	/** check to see if we are of simple type */
	final int TEST_IS_SIMPLE_TYPE = 1;
		
	/** Check compatible type */
	final int TEST_COMPATIBLE_TYPE = 2;
		
	/** Check for compatible Partner Activity messages */
	final int TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE = 3;
		
	/** Ask about import support */		
	final int TEST_RESOVLED = 4;
	
	
	/** Not hints for the adapter */
	final int ADAPT_HINT_NONE  = 0;
	
}
