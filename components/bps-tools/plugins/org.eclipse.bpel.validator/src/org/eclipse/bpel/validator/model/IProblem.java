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

import java.util.Map;

/**
 * IProblem is a generic self contained "marker" or "note" or "message"
 * that is generated as a result of the validation pass. Instances
 * of IProblem contain descriptive information about the problem 
 * discovered by the validator. 
 * <p>
 * For workbench use, instances if IProblem will be adapted to IMarker.
 * <p>
 * For use in other places, instances of IProblem can be flushed to a 
 * logger, send to a console, etc. 
 * <p>
 * The intention of the interface presented here is that it has no
 * dependencies other then the java runtime and the underlying 
 * "validation" model to which it belongs.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */
@SuppressWarnings("nls")
public interface IProblem  {

	/** 
	 * Severity marker attribute.  A number from the set of error, warning and info
	 * severities defined by the platform.
	 *
	 * @see #SEVERITY_ERROR
	 * @see #SEVERITY_WARNING
	 * @see #SEVERITY_INFO
	 */
	public static final String SEVERITY = "severity"; //$NON-NLS-1$

	/** 
	 * Message marker attribute.  A localized string describing the nature
	 * of the marker (e.g., a name for a bookmark or task).  The content
	 * and form of this attribute is not specified or interpreted by the platform.
	 *
	 * @see #getAttribute(String, String)
	 */
	public static final String MESSAGE = "message"; //$NON-NLS-1$

	
	/** Message id */
	public static final String MESSAGE_ID = "message.id";

	/** Message arguments used to format the message */
	public static final String MESSAGE_ARGS = "message.args";


	
	/** 
	 * Location marker attribute.  The location is a human-readable (localized) string which
	 * can be used to distinguish between markers on a resource.  As such it 
	 * should be concise and aimed at users.  The content and 
	 * form of this attribute is not specified or interpreted by the platform.
	 *
	 * @see #getAttribute(String, String)
	 */
	public static final String LOCATION = "location"; //$NON-NLS-1$

	/** 
	 * Character start marker attribute.  An integer value indicating where a text
	 * marker starts.  This attribute is zero-relative and inclusive.
	 *
	 * @see #getAttribute(String, String)
	 */
	public static final String CHAR_START = "charStart"; //$NON-NLS-1$

	/** 
	 * Character end marker attribute.  An integer value indicating where a text
	 * marker ends.  This attribute is zero-relative and exclusive.
	 *
	 * @see #getAttribute(String, String)
	 */
	public static final String CHAR_END = "charEnd"; //$NON-NLS-1$

	/** 
	 * Line number marker attribute.  An integer value indicating the line number
	 * for a text marker.  This attribute is 1-relative.
	 *
	 * @see #getAttribute(String, String)
	 */
	public static final String LINE_NUMBER = "lineNumber"; //$NON-NLS-1$


	/**
	 * Line number marker attribute. An integer value indicating the line number
	 * for a text marker. This attribute is 1-relative.
	 */
	
	public static final String COLUMN_NUMBER = "columnNumber";
	
	
	/**
	 * The XPATH pointer into the problem node in the XML model space.
	 * 
	 */
	
	public static final String ADDRESS_XPATH = "address.xpath";

	/**
	 * The XPath pointer into the problem node in the model model space.
	 */
	
	public static final String ADDRESS_MODEL = "address.model";
	
	
	/*====================================================================
	 * Marker attributes values:
	 *====================================================================*/


	/** 
	 * Error severity constant (value 2) indicating an error state.
	 *
	 */
	public static final int SEVERITY_ERROR = 2;

	/** 
	 * Warning severity constant (value 1) indicating a warning.
	 *
	 */
	public static final int SEVERITY_WARNING = 1;

	/** 
	 * Info severity constant (value 0) indicating information only.
	 *
	 */
	public static final int SEVERITY_INFO = 0;

	/**
	 * The Node on which the problem is being reported.
	 * 
	 */
	public static final String NODE = "node"; //$NON-NLS-1$

	/**
	 * The fix messages, how to fix the problem.
	 */
	
	public static final String FIX = "fixMessage"; //$NON-NLS-1$

	/**
	 * The rule name that produced this problem.
	 */
	public static final String RULE = "ruleName";  //$NON-NLS-1$

	/**
	 * The description of the rule which produced this problem.
	 */
	public static final String RULE_DESC = "ruleDescription";  //$NON-NLS-1$

	
		
	/**
	 * A further context associating this problem with something
	 * that would be useful in dereferencing the problem in the model. 
	 */
	
	public static final String CONTEXT = "context.name"; //$NON-NLS-1$


	/**
	 * In case the model is completely hoarked and we don't even have
	 * a Process or any sort of context, we still want to be able to
	 * report this as a problem. This is the emf Resource that is in error.
	 * @see Bugzilla 324165
	 */
	public static final String ERESOURCE = "eResource"; //$NON-NLS-1$
	
	/**
	 * This is the name of the Java Resource bundle 
	 * from which the fill method of IProblem will 
	 * get the error descriptions that it will push
	 * into it's attributes.
	 * <p>
	 * 
	 * For example, "org.eclipse.bpel.rules.messages"
	 * 
	 */
	
	public static final String BUNDLE_NAME = "bundleName"; //$NON-NLS-1$

	/**
	 * Static analysis code related to this problem in the space of the validator.
	 * 
	 */
	
	public static final String SA_CODE = "staticAnalysisCode"; //$NON-NLS-1$

	/**
	 * The class that we start from searching for message bundles
	 */
	public static final String BUNDLE_CLAZZ = "bundle.clazz";

	/** 
	 * The java exception that is to be associated with this problem. 
	 * This is typically only used for reporting fatal code errors, for which a little 
	 * extra help is necessary.
	 * 
	 */
	
	public static final String EXCEPTION = "exception";

	

	
	/**
	 * Tests this marker for equality with the given object.
	 * Two markers are equal if their id and resource are both equal.
	 * 
	 * @param object the other object
	 * @return an indication of whether the objects are equal
	 */
	public boolean equals (Object object);

	/**
	 * Returns the attribute with the given name.  The result is an instance of one
	 * of the following classes: <code>String</code>, <code>Integer</code>, 
	 * or <code>Boolean</code>.
	 * Returns <code>null</code> if the attribute is undefined.
	 * 
	 * @param <T> the type 
	 * @param attributeName the name of the attribute
	 * @return the value, or <code>null</code> if the attribute is undefined.
	 */
	
	public <T extends Object> T getAttribute (String attributeName);

	/**
	 * Returns the attribute with the given name.  
	 * Returns the given default value if the attribute is undefined.
	 * or the marker does not exist or is not an integer value.
	 * 
	 * @param <T> 
	 * @param attributeName the name of the attribute
	 * @param defaultValue the value to use if no value is found
	 * @return the value or the default value if no value was found.
	 */

	public <T extends Object> T getAttribute ( String attributeName, T defaultValue) ;
	
	/**
	 * Returns a map with all the attributes for the marker.
	 * If the marker has no attributes then <code>null</code> is returned.
	 *
	 * @return a map of attribute keys and values (key type : <code>String</code> 
	 *		value type : <code>String</code>, <code>Integer</code>, or 
	 *		<code>Boolean</code>) or <code>null</code>.
	 */
	public Map<String,Object> getAttributes();


	/**
	 * Returns the time at which this marker was created.
	 *
	 * @return the difference, measured in milliseconds, between the time at which
	 *    this marker was created and midnight, January 1, 1970 UTC, or <code>0L</code>
	 *    if the creation time is not known (this can occur in workspaces created using v2.0 or earlier).
	 * @since 2.1
	 */
	public long getCreationTime();

	/**
	 * Returns the id of the marker.  The id of a marker is unique
	 * relative to the resource with which the marker is associated.
	 * Marker IDS are not globally unique.
	 *
	 * @return the id of the marker 
	 */
	
	public long getId();


	/**
	 * Sets the attribute with the given name.  
	 * <p>
	 * This method changes resources; these changes will be reported
	 * in a subsequent resource change event, including an indication 
	 * that this marker has been modified.
	 * </p>
	 * 
	 * @param <T> 
	 * @param attributeName the name of the attribute
	 * @param value the value
	 */

	public <T extends Object> void setAttribute(String attributeName, T value);

	
	/**
	 * This method changes resources; these changes will be reported
	 * in a subsequent resource change event, including an indication 
	 * that this marker has been modified.
	 * </p>
	 *
	 * @param attributes a map of attribute names to attribute values 
	 *		(key type : <code>String</code> value type : <code>String</code>, 
	 *		<code>Integer</code>, or <code>Boolean</code>) or <code>null</code>
	 */
	
	public void setAttributes(Map<String,Object> attributes);
	
	
	/**
	 * Fill the appropriate information in the problem (attributes and such)
	 * that relate the message id that is passed as the argument.
	 * <p>
	 * For this to be successful, contractually at least, the property
	 * BUNDLE_NAME must be set in the problem prior to invoking fill().    
	 *
	 * @param msgId the message id
	 * @param args the arguments to pass
	 */
	
	public void fill ( String msgId, Object ... args);
}
