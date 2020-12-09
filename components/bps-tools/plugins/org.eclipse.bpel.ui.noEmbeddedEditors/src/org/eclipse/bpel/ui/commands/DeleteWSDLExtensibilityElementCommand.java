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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;

/**
 * Deletes an ExtensibilityElement from its enclosing WSDL resource.
 * 
 * Also runs a DeleteNonContainmentRefsCommand using the WSDL resource and
 * the BPEL resource as model roots. 
 */
public abstract class DeleteWSDLExtensibilityElementCommand extends AutoUndoCommand {

	Definition fDefinition;
	ExtensibilityElement fElement;
	
	DeleteNonContainmentRefsCommand deleteRefsCmd;
	
	/**
	 * @return the default label
	 */
	public abstract String getDefaultLabel();

	/**
	 * 
	 * @param element
	 */
	public DeleteWSDLExtensibilityElementCommand(ExtensibilityElement element) {
		super(new ArrayList<Object>(1));
		this.fElement = element;
		setLabel(getDefaultLabel());
		addModelRoot(element.getEnclosingDefinition());
	}

	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#canDoExecute()
	 */
	@Override
	public boolean canDoExecute() {
		if (fElement.getEnclosingDefinition() == null)  return false;
		return super.canDoExecute();
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		fDefinition = fElement.getEnclosingDefinition();
	
		Set<Object> modelRootSet = new HashSet<Object>();
		modelRootSet.add(fElement.eResource());		
		modelRootSet.add(ModelHelper.getBPELEditor(fElement).getResource());
		deleteRefsCmd = new DeleteNonContainmentRefsCommand(Collections.singleton((Object) fElement), modelRootSet);
		
		fElement.setEnclosingDefinition(null);
		fDefinition.getEExtensibilityElements().remove(fElement);

		deleteRefsCmd.execute();
	}
}
