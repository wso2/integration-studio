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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.emf.ecore.EObject;


/**
 * This AssignCategory is shown when no other category applies. 
 */
public class NullAssignCategory extends AssignCategoryBase {

	protected NullAssignCategory(BPELPropertySection ownerSection) {
		super(ownerSection);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	@Override
	public String getName() { 
		return Messages.NullAssignCategory____None____1; 
	} 

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isCategoryForModel (EObject aModel) {
		return (aModel == null);		
	}
	
	@Override
	protected void load (IVirtualCopyRuleSide aModel) {
		
	}
	@Override
	protected void store (IVirtualCopyRuleSide aModel) {
		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
	}

	@Override
	protected boolean isDefaultCompositeOpaque() { 
		return false; 
	}
}
