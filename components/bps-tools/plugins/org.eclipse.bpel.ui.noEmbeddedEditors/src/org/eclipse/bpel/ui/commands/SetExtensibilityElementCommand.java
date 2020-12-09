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
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.ExtensibleElement;

/** 
 * Used to add or remove an ExtensibilityElement from a target model object.
 * 
 * NOTE: this should ONLY be used when the target only supports a single instance of the
 * ExtensibilityElement.
 */
public class SetExtensibilityElementCommand extends AutoUndoCommand {

	int oldIndex;
	boolean initialized = false;
	
	ExtensibleElement target;
	ExtensibilityElement oldExtension;
	ExtensibilityElement newExtension;
	Class clazz;
	
	public SetExtensibilityElementCommand(ExtensibleElement target, Class clazz,
		ExtensibilityElement newExtension)
	{
		super(target);
		this.target = target;
		this.newExtension = newExtension;
		this.clazz = clazz;
		setLabel(Messages.SetExtensibilityElementCommand_Change_1); 
	}
	
	protected void initValues() {
		if (initialized) return;
		oldExtension = ModelHelper.getExtensibilityElement(target, clazz);
		initialized = true;
	}

	@Override
	public boolean canDoExecute() {
		initValues();
		return true;
		//return (oldExtension != newExtension);
	}

	@Override
	public void doExecute() {
		initValues();
		if (oldExtension != null) {
			oldIndex = target.getEExtensibilityElements().indexOf(oldExtension);
			target.getEExtensibilityElements().remove(oldIndex);
		} 
		if (newExtension != null) target.getEExtensibilityElements().add(newExtension);
	}
}
