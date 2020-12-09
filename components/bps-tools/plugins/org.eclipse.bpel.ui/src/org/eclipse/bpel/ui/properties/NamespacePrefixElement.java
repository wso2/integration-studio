/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.properties;

import org.eclipse.emf.ecore.EObject;

/*
 * This represents an entry in the NamespacesPrefixesSection table in the Namespaces Property Tab.
 * The NamespacesPrefixesProvider builds a list of these to be displayed in the table.
 *
 * @see https://jira.jboss.org/browse/JBIDE-6765
 * @author Bob Brodt
 * @date Aug 13, 2010
 */
public class NamespacePrefixElement {
	
	public String prefix;
	public String namespace;
	public EObject context;
	public String location;
	
	public NamespacePrefixElement(String prefix, String namespace, EObject context, String location)
	{
		this.prefix = prefix;
		this.namespace = namespace;
		this.context = context;
		this.location = location;
	}
}