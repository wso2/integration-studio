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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.Part;

/**
 * Tree node to represent a message-type model object.
 */
public class MessageTypeTreeNode extends TreeNode {

	boolean isPropertyTree;
	boolean displayParticles;
	
	public MessageTypeTreeNode(Input msg, boolean isCondensed, boolean isProperty) {
		this(msg, isCondensed, isProperty,true);		
	}
	
	
	public MessageTypeTreeNode(Output msg, boolean isCondensed, boolean isProperty) {
		this(msg, isCondensed, isProperty,true);		
	}
	
	public MessageTypeTreeNode(Message messageType, boolean isCondensed, boolean isPropertyTree) {
		this(messageType, isCondensed, isPropertyTree, true);
	}
	
	
	public MessageTypeTreeNode (Message messageType, boolean isCondensed,
		boolean isPropertyTree, boolean displayParticles) {
		this((EObject) messageType,isCondensed,isPropertyTree,displayParticles);
	}
	
	
	private MessageTypeTreeNode(EObject obj,  boolean isCondensed,
			boolean isPropertyTree, boolean displayParticles ) 
	{
		super(obj, isCondensed);
		this.isPropertyTree = isPropertyTree;
		this.displayParticles = displayParticles;
	}

	/* ITreeNode */

	@Override
	public Object[] getChildren() {
		
		Message msg = getMessage();
		
		if (msg == null) {
			return EMPTY_ARRAY;
		}
		
		if (isPropertyTree) {
			// Find propertyAliases that refer to this message.
			List<PropertyAlias> aliases = BPELUtil.getPropertyAliasesForMessageType(msg);
			List<Property> properties = getPropertiesFromPropertyAliases(aliases);
			List<PropertyTreeNode> list = new ArrayList<PropertyTreeNode>();
			for (Iterator<Property> it = properties.iterator(); it.hasNext(); ) {
				list.add(new PropertyTreeNode(it.next(), isCondensed));
			}
			return list.toArray();
		}

		if (msg.getParts() == null) {
			return EMPTY_ARRAY;
		}
		
		List<PartTreeNode> list = new ArrayList<PartTreeNode>();
		for (Iterator<Part> it = msg.getParts().values().iterator(); it.hasNext(); ) {
			list.add(new PartTreeNode(it.next(), isCondensed, displayParticles));
		}
		return list.toArray();
	}

	@Override
	public boolean hasChildren() {
		if (isPropertyTree) {
			// TODO: we need some sort of property map maintained by the same
			// builder that will keep track of the namespaceURI's of WSDL files
			return getChildren().length > 0;
		}

		Message msg = getMessage();
		if (msg == null) {
			return false;
		}
		
		return (msg.getParts() != null && !msg.getParts().isEmpty());
	}

	/* other methods */
	
	protected List<Property> getPropertiesFromPropertyAliases(List<PropertyAlias> aliases) {
		List<Property> properties = new ArrayList<Property>();
		Set<Property> propertySet = new HashSet<Property>();
		for (Iterator<PropertyAlias> it = aliases.iterator(); it.hasNext(); ) {
			PropertyAlias alias = it.next();
			Property property = (Property)alias.getPropertyName();
			if (!propertySet.contains(property)) {
				properties.add(property);
				propertySet.add(property);
			}
		}
		return properties;
	}
	
	
	Message getMessage () {
		if (modelObject instanceof Message) {
			return (Message) modelObject;
		}
		if (modelObject instanceof Input) {
			return ((Input)modelObject).getEMessage();
		}
		if (modelObject instanceof Output) {
			return ((Output)modelObject).getEMessage();
		}
		return null;
	}
	
	
}
