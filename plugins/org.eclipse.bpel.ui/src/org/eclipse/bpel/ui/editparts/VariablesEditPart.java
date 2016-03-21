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
package org.eclipse.bpel.ui.editparts;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.requests.CreationFactory;


public class VariablesEditPart extends BPELTrayCategoryEditPart {

	@Override
	protected EList<Variable> getModelChildren() {
		return getVariables().getChildren();
	}

	protected Variables getVariables() {
		return (Variables)getModel();
	}

	@Override
	protected CreationFactory getCreationFactory() {
		return UIObjectFactoryProvider.getInstance().getFactoryFor(BPELPackage.eINSTANCE.getVariable());
	}
	
	@Override
	protected IFigure getAddToolTip() {
	    return new Label(Messages.VariablesEditPart_Add_Variable_1); 
	}
	
	@Override
	protected IFigure getRemoveToolTip() {
	    return new Label(Messages.VariablesEditPart_Remove_Variable_1); 
	}
	
	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub
		super.setModel(model);
	}
}
