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

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * Removes a Correlation from an Invoke/Receive/Reply/OnMessage.
 */
public class RemoveCorrelationCommand extends RemoveFromListCommand {

	public RemoveCorrelationCommand(EObject target, Correlation oldCorrelation) {
		super(target, oldCorrelation, IBPELUIConstants.CMD_DELETE_CORRELATION);
	}

	@Override
	protected EList<Correlation> getList() {
		Correlations c = ModelHelper.getCorrelations(target);
		return (c == null)? null : c.getChildren();
	}

	@Override
	protected void createList() {
		ModelHelper.setCorrelations(target, BPELFactory.eINSTANCE.createCorrelations());
	}
	@Override
	protected void deleteList() {
		ModelHelper.setCorrelations(target, null);
	}
}
