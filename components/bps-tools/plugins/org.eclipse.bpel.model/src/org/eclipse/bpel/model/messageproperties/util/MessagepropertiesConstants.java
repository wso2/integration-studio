/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.messageproperties.util;

import org.w3c.dom.Element;

/**
 * Message Properties constants.
 *
 */

@SuppressWarnings("nls")
public final class MessagepropertiesConstants
{
	/**
	 * The BPEL namespace.
	 */
	public static final String NAMESPACE_2004 = "http://schemas.xmlsoap.org/ws/2004/03/business-process/";

	/**
	 * The variable properties namespace from BPEL 2.0 onwards.
	 */
	
	public static final String NAMESPACE_2007 = "http://docs.oasis-open.org/wsbpel/2.0/varprop";
	
	/**
	 * The current namespace.
	 */
	public static String NAMESPACE = NAMESPACE_2007;

	/**
	 * Tests if <code>namespace</code> equals any of the valid namespaces.
	 */
	public static boolean isMessagePropertiesNamespace(String namespace)
	{
		return namespace != null
			&& (namespace.equals(NAMESPACE_2004) ||
				namespace.equals(NAMESPACE_2007));
	}
	
	
    public static final String PROPERTY_ELEMENT_TAG = "property";
    public static final String PROPERTY_ALIAS_ELEMENT_TAG = "propertyAlias";
    public static final String QUERY_ELEMENT_TAG = "query";

    public static final String PROPERTY_NAME_ATTRIBUTE = "name";
    public static final String PROPERTY_TYPE_ATTRIBUTE = "type";
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
    // https://jira.jboss.org/browse/JBIDE-7107
    // added to allow "element" addressing for <property> and <propertyAlias>
    public static final String PROPERTY_XSD_ELEMENT_ATTRIBUTE = "element";
    public static final String PROPERTY_ALIAS_PROPERTY_NAME_ATTRIBUTE = "propertyName";
    public static final String PROPERTY_ALIAS_MESSAGE_TYPE_ATTRIBUTE = "messageType";
    public static final String PROPERTY_ALIAS_PART_ATTRIBUTE = "part";
    public static final String PROPERTY_ALIAS_QUERY_ATTRIBUTE = "query";
    public static final String PROPERTY_ALIAS_TYPE_ATTRIBUTE = "type";
    public static final String PROPERTY_ALIAS_XSD_ELEMENT_ATTRIBUTE = "element";
    public static final String QUERY_QUERYLANGUAGE_ATTRIBUTE = "queryLanguage";

    public static String getAttribute(Element element, String attributeName)
	{
        return element.hasAttribute(attributeName) ? element.getAttribute(attributeName) : null;
    }
}
