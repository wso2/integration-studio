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
package org.eclipse.bpel.ui.util;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.CreationTool;


public class BPELCreationTool extends CreationTool implements IHilightControllingTool {

	public BPELCreationTool() {
		super();
	}

	public BPELCreationTool(CreationFactory aFactory) {
		super(aFactory);
	}

	public boolean hilightModelTarget(EObject targetObject) {
		return false;
		//IContainer container = (IContainer)BPELUtil.adapt(targetObject, IContainer.class);
		//if (container == null)  return false;
		//return container.isValidChild(targetObject, (EClass)getFactory().getObjectType());
	}
	

	@Override
	protected Command getCommand() {
		try {
			return super.getCommand();
		} catch (OperationCanceledException e) {
			// if the user canceled the current operation we should set the default tool
			getDomain().setActiveTool(getDomain().getDefaultTool());
		}
		return null;
	}
}
