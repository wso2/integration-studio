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
package org.eclipse.bpel.ui.adapters;

import java.util.List;

import org.eclipse.bpel.ui.actions.editpart.IEditPartAction;
import org.eclipse.gef.EditPart;


/**
 * Interface for adapters to contribute IEditPartActions to the context menu for the
 * EditPart for this type of model object.
 */
public interface IEditPartActionContributor {
	public List<? extends IEditPartAction> getEditPartActions(EditPart editPart);
}
