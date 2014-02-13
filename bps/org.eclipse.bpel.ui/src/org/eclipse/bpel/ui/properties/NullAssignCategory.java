/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
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
	
	public String getName() { 
		return Messages.NullAssignCategory____None____1; 
	} 

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	
	public boolean isCategoryForModel (EObject aModel) {
		return (aModel == null);		
	}
	
	
	protected void load (IVirtualCopyRuleSide aModel) {
		
	}
	
	protected void store (IVirtualCopyRuleSide aModel) {
		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	
	public Object getUserContext() {
		return null;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	
	public void restoreUserContext(Object userContext) {
	}

	
	protected boolean isDefaultCompositeOpaque() { 
		return false; 
	}
}
