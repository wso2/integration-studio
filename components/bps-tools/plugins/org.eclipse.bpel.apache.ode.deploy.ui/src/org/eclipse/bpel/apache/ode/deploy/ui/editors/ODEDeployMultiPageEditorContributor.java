/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui.editors;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;

/**
 * No-op editor contributor
 * @author Tammo van Lessen (IAAS)
 * @author Simon Moser (IBM)
 */
public class ODEDeployMultiPageEditorContributor extends EditingDomainActionBarContributor {

	public ODEDeployMultiPageEditorContributor() {
		super();
		createActions();
	}

	private void createActions() {
		// new actions go here
	}

	public void contributeToMenu(IMenuManager manager) {
		// contribute here
	}
	
	public void contributeToToolBar(IToolBarManager manager) {
		// contribute here
	}
}
