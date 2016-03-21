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

import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension;


/** 
 * Sets the the process spec-compliant flag.
 */
public class SetSpecCompliantProcessCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_SPECCOMPLIANT; }

	public SetSpecCompliantProcessCommand(ProcessExtension target, boolean specCompliant)  {
		super(target, Boolean.valueOf( specCompliant ));
	}

	@Override
	public Object get() {
		return Boolean.valueOf(((ProcessExtension)fTarget).isSpecCompliant());
	}
	@Override
	public void set(Object o) {
		((ProcessExtension)fTarget).setSpecCompliant(((Boolean)o).booleanValue());
	}
}
