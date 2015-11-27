/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.tree;

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Tree node to represent a Property for which a PropertyAlias exists that
 * references the messageType of a Variable.
 */
public class PropertyTreeNode extends TreeNode {

	XSDTypeDefinitionTreeNode xsdType;

	public PropertyTreeNode(Property property, boolean isCondensed) {
		super(property, isCondensed);
		if (isCondensed && property.getType() != null)  {
			xsdType = new XSDTypeDefinitionTreeNode(
				(XSDTypeDefinition)property.getType(), isCondensed);
		}
	}

	/* ITreeNode */

	@Override
	public String getLabelSuffix() {
		if (isCondensed && xsdType != null)  return xsdType.getLabel();
		return null;
	}

	@Override
	public Object[] getChildren() {
		if (isCondensed) {
			if (xsdType != null)  return xsdType.getChildren();
			return EMPTY_ARRAY;
		}
		Property property = (Property)modelObject;
		if (property.getType() != null)  {
			Object[] result = new Object[1];
			result[0] = new XSDTypeDefinitionTreeNode(
				(XSDTypeDefinition)property.getType(), isCondensed);
			return result;
		}
		return EMPTY_ARRAY;
	}

	@Override
	public boolean hasChildren() {
		if (isCondensed) {
			if (xsdType != null)  return xsdType.hasChildren();
			return false;
		}
		Property property = (Property)modelObject;
		return (property.getType() != null);
	}
}
