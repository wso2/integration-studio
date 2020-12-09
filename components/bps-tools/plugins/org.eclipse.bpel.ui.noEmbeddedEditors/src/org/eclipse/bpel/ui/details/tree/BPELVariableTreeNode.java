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

import org.eclipse.bpel.model.Variable;


/**
 * Tree node to represent a Variable model object.  For !isCondensed, a Variable node has
 * one child which describes its Message type.  For isCondensed trees, the Message type node
 * is elided and its label is displayed as a suffix of the Variable node's label.
 */
public class BPELVariableTreeNode extends TreeNode {

	TreeNode fNode;
	
	boolean isPropertyTree;
	boolean displayParticles;
	
	public BPELVariableTreeNode(Variable variable, boolean isCondensed, boolean isPropertyTree, boolean displayParticles) {
		super(variable, isCondensed);
		this.displayParticles = displayParticles;
		this.isPropertyTree = isPropertyTree;

		if (isCondensed) {
			if (variable.getMessageType() != null)  {
				fNode = new MessageTypeTreeNode(variable.getMessageType(),
					isCondensed, isPropertyTree);
			} else if (variable.getType() != null) {
				fNode = new XSDTypeDefinitionTreeNode(variable.getType(), isCondensed);
			} else if (variable.getXSDElement() != null) {
				fNode = new XSDElementDeclarationTreeNode(variable.getXSDElement(), isCondensed);			
			}
		}
	}

	/* ITreeNode */

	@Override
	public String getLabelSuffix() {
		if (isCondensed && fNode != null) {
			return fNode.getLabel();
		}
		return null;
	}

	@Override
	public Object[] getChildren() {
		if (isCondensed) {
			return fNode != null ? fNode.getChildren() : EMPTY_ARRAY;
		}
		Variable variable = (Variable)modelObject;
		if (variable.getMessageType() != null) {
			return new Object[] {
					new MessageTypeTreeNode(variable.getMessageType(),
							isCondensed, isPropertyTree, displayParticles) 
				};			
		}
		if (variable.getType() != null) {
			return new Object[] {
					new XSDTypeDefinitionTreeNode(variable.getType(), isCondensed)
			};
		}
		if (variable.getXSDElement() != null) {
			return new Object[] {
					new XSDElementDeclarationTreeNode(variable.getXSDElement(), isCondensed)
			};
		}
		return EMPTY_ARRAY;
	}

	@Override
	public boolean hasChildren() {
		if (isCondensed) {
			return fNode != null ? fNode.hasChildren() : false;
		}
		Variable variable = (Variable) modelObject;
		return (variable.getMessageType() != null) ||
			(variable.getType() != null) ||	(variable.getXSDElement() != null);
	}
}
