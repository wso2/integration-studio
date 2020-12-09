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
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * An AssignCategory where the user can type in a literal value (note: NOT an expression).
 * 
 * TODO: his could be an XML editor one day ...
 */

public class LiteralAssignCategory extends AssignCategoryBase {

	Text fLiteralText;
	
	protected LiteralAssignCategory (BPELPropertySection ownerSection ) {
		super(ownerSection);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	
	@Override
	public String getName() { 
		return Messages.LiteralAssignCategory_Fixed_Value_1;
	} 

	@Override
	protected String getLabelFlatFormatString() {
		return IBPELUIConstants.FORMAT_CMD_EDIT;
	}

	@Override
	protected void createClient2(Composite parent) {
		FlatFormData data;

		
		fLiteralText = fWidgetFactory.createText(parent, EMPTY_STRING, SWT.V_SCROLL | SWT.MULTI);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		//data.top = new FlatFormAttachment(typeComposite, IDetailsAreaConstants.VSPACE);
		data.top = new FlatFormAttachment(0,0);
		data.bottom = new FlatFormAttachment(100, 0);
		fLiteralText.setLayoutData(data);
		
		fChangeHelper.startListeningTo(fLiteralText);
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	
	@Override
	public boolean isCategoryForModel (EObject aModel) {
		From from = BPELUtil.adapt(aModel, From.class);
		return (from != null && from.getLiteral() != null);
	}
	
	@Override
	protected void load (IVirtualCopyRuleSide aModel) {
			
		From from = BPELUtil.adapt(aModel.getCopyRuleSide(), From.class);

		fChangeHelper.startNonUserChange();
		try {
			String fromString = EMPTY_STRING;
			if (from != null) {
				fromString = from.getLiteral();
			}
			if (fromString == null) {
				fromString = EMPTY_STRING;
			}
			
			fLiteralText.setText(fromString);			
		} finally {
			fChangeHelper.finishNonUserChange();
		}
	}
	
	
	@Override
	protected void store (IVirtualCopyRuleSide aModel) {
		
		From from = BPELUtil.adapt(aModel.getCopyRuleSide(), From.class);
		
		String expr = fLiteralText.getText();

		from.setLiteral(expr);

		if (expr == null) {
			from.setUnsafeLiteral(Boolean.FALSE);
		} else {
			// test if the unsafe literal can be converted into an element and serialized safely 
			if (BPELUtils.convertStringToNode(from, expr, (BPELResource)getBPELEditor().getResource()) != null) {
				from.setUnsafeLiteral(Boolean.TRUE);
			} else {
				from.setUnsafeLiteral(Boolean.FALSE);
				MessageDialog.openWarning(fLiteralText.getShell(),
					Messages.LiteralAssignCategory_Warning_1, 
					Messages.LiteralAssignCategory_Literal_not_XML_2); 
			}
		}
		
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
		fLiteralText.setFocus();
	}

}
