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

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;


/**
 * Details section for the TransitionCondition of a link source (a boolean expression).
 */
public class TransitionConditionSection extends ExpressionSection {
	
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Link link = getModel();
		for(Object next : link.getSources()) {
			Source source = (Source) next;
			fAdapters[0].addToObject(source);		
		}		
	}
	
	@Override
	protected String getExpressionType() { 
		return IEditorConstants.ET_TRANSITION; 
	}

	
	@Override
	protected boolean isExpressionOptional() { 
		return true; 
	}	
	
	@Override
	protected Composite createNoEditorWidgets(Composite composite) {
	
		return createNoEditorWidgetsCreateComposite(composite,
				
				Messages.TransitionConditionSection_No_condition_specified_1 + NL + NL +
				Messages.TransitionConditionSection_Optional_condition_text_2 ,
				
				Messages.TransitionConditionSection_Create_a_New_Condition_3);
	}


	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		return BPELPackage.eINSTANCE.getSource_TransitionCondition() ;		
	}
	
	
	@Override
	protected EObject getExpressionTarget() {
		Link link = getModel();
		List<?> sources = link.getSources();
		if (sources.size() > 0) {
			return (Source) sources.get(0);
		}
		return  null;			
	}
	
	@Override
	protected boolean isValidClientUseType(String useType) {		
		return IBPELUIConstants.USE_TYPE_TRANSITION_CONDITION.equals(useType);
	}
}
