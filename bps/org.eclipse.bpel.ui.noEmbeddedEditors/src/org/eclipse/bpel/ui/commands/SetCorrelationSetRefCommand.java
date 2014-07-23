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

import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.ui.IBPELUIConstants;


/** 
 * Sets the "set" property of a Correlation (NOTE: not a CorrelationSet!)
 */
public class SetCorrelationSetRefCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_EDIT_CORRELATION; }

	public SetCorrelationSetRefCommand(Correlation target, CorrelationSet newSetRef)  {
		super(target, newSetRef);
	}

	@Override
	public Object get() {
		return ((Correlation)fTarget).getSet();
	}
	@Override
	public void set(Object o) {
		((Correlation)fTarget).setSet((CorrelationSet)o);
	}
}
