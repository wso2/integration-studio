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

import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * An AssignCategory representing opaque="yes" in a From object.
 * TODO: This should only appear for abstract processes
 */
public class OpaqueAssignCategory extends AssignCategoryBase {

	protected OpaqueAssignCategory(BPELPropertySection ownerSection) {
		super(ownerSection);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	@Override
	public String getName() { 
		return Messages.OpaqueAssignCategory_Opaque_1;
	} 

	@Override
	protected void createClient2(Composite parent) {
		super.createClient2(parent);
		Label opaqueLabel = fWidgetFactory.createLabel(fComposite,
			Messages.OpaqueAssignCategory_An_Opaque_value_is_used_in_abstract_processes__2, SWT.CENTER); 
		FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(50, 0);
		opaqueLabel.setLayoutData(data);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isCategoryForModel (EObject aModel) {
		
		From from = BPELUtil.adapt(aModel, From.class);
		if (from == null) {
			return false;
		}		
		return Boolean.TRUE.equals(from.getOpaque());		
	}
	
	
	@Override
	protected void load (IVirtualCopyRuleSide aModel) {
		
	}
	
	
	@Override
	protected void store (IVirtualCopyRuleSide aModel) {
		From from = BPELUtil.adapt(aModel.getCopyRuleSide(), From.class);
		if (from == null) {
			return ;
		}		
		from.setOpaque(Boolean.TRUE);
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

}
