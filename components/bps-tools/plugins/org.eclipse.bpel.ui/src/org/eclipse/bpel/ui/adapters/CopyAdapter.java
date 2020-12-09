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

import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.emf.ecore.EObject;

// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7497
// use MarkerDelegateAdapter to forward marker notifications to the enclosing <assign>
public class CopyAdapter extends MarkerDelegateAdapter implements IExtensionFactory {

	/* IExtensionFactory */
	
	public EObject createExtension(EObject object) {
		return UiextensionmodelFactory.eINSTANCE.createCopyExtension();
	}
}
