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

import java.util.Arrays;

import javax.xml.namespace.QName;

/**
 * NodeNameFilter filters based on the nodeName returned from INode. Filter
 * nodes based on their name.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 * 
 */
@SuppressWarnings("nls")

public class NodeNameFilter extends Filter implements IFilter<INode> {
	
	static QName ANY = new QName("*");

	QName[] fNodeNames = { ANY };

	/**
	 * 
	 * @param nodeName
	 */
	public NodeNameFilter(QName nodeName) {
		fNodeNames[0] = nodeName;
	}

	/**
	 * List of node names.
	 * 
	 * @param nodeNames
	 */
	public NodeNameFilter (QName ... nodeNames) {
		fNodeNames = nodeNames;
		if (fNodeNames == null) {
			fNodeNames = new QName[] {};
		} else if (nodeNames.length > 1) {
			Arrays.sort(fNodeNames , QNAME_COMPARATOR );
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param node
	 * @return true to select, false to not.
	 * @see org.eclipse.bpel.validator.model.IFilter#select(java.lang.Object)
	 */
	public boolean select(INode node) {

		QName nn = node.nodeName();

		if (fNodeNames.length == 1) {
			if (fNodeNames[0].equals(ANY)) {
				return true;
			}
			return fNodeNames[0].equals(nn);
		}
		boolean valid = (Arrays.binarySearch(fNodeNames, nn, QNAME_COMPARATOR) >= 0);
		if (!valid)
		{
			// Bugzilla 324115
			// check if this is a structured extension activity (a container)
			node = node.parentNode();
			if (node!=null)
			{
				nn = node.nodeName();
				if (IConstants.ND_EXTENSION_ACTIVITY.equals(nn))
					valid = (Arrays.binarySearch(fNodeNames, nn, QNAME_COMPARATOR) >= 0);
			}
		}
		return valid;
	}

	/**
	 * Return a toString of this filter
	 * 
	 * @return a to string pretty print of this filter
	 */

	@Override
	public String toString() {
		return toString (fNodeNames);
	}
	
	@SuppressWarnings("nls")
	protected String toString ( QName ... vals ) {
		StringBuilder sb = new StringBuilder();
		for(QName n : vals) {
			sb.append("\"").append(n.getLocalPart()).append("\"").append(", ");
		}
		sb.setLength(sb.length()-2);
		return sb.toString();
	}

	
}
