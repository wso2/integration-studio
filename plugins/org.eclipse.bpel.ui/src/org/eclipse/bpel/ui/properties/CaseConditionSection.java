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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;


/**
 * Details section for the CaseCondition of an activity (a boolean expression).
 */
public class CaseConditionSection extends ExpressionSection {
	

	@Override
	protected String getExpressionType() { 
		return IEditorConstants.ET_BOOLEAN ; 
	}
	
	
	@Override
	protected Composite createNoEditorWidgets(Composite composite) {
		
		return createNoEditorWidgetsCreateComposite(composite,			
				Messages.ElseIfConditionSection_No_condition_specified_1 + NL + NL +
				Messages.ElseIfConditionSection_Create_condition_text_2 ,				
				Messages.ElseIfConditionSection_Create_a_New_Condition_2);
	}
	
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		
		if (object instanceof If) {
			return BPELPackage.eINSTANCE.getIf_Condition();
		}
		if (object instanceof ElseIf) {
			return BPELPackage.eINSTANCE.getElseIf_Condition();
		}
		return super.getStructuralFeature(object);
	}

}
