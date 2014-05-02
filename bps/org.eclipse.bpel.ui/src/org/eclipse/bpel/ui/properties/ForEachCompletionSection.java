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

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;


/**
 * Details section for the CompletionCondition of an forEach activity (a unsignedInteger expression).
 */
public class ForEachCompletionSection extends ExpressionSection {

	@Override
	protected String getExpressionType() { 
		return IEditorConstants.ET_UNSIGNED_INT; 
	}	
	
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();		
		fAdapters[0].addToObject( getExpressionTarget() );		
	}
	
	@Override
	protected Composite createNoEditorWidgets(Composite composite) {
		
		return createNoEditorWidgetsCreateComposite(composite,			
				Messages.ForEachCompletionConditionSection_No_condition_specified_1 + NL + NL +
				Messages.ForEachCompletionConditionSection_Optional_condition_text_2 ,
				
				Messages.ForEachCompletionConditionSection_Create_a_New_Condition_3);			
	}
	
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		if (object instanceof ForEach) {
			return BPELPackage.eINSTANCE.getCompletionCondition_Branches() ;
		}
		return super.getStructuralFeature(object);
	}
	
	
	@Override
	protected EObject getExpressionTarget() {
		
		EObject obj = getInput();
		
		if (obj instanceof ForEach) {
			
			ForEach _for = (ForEach) obj;
			CompletionCondition target = _for.getCompletionCondition();
			if (target == null) {
				target = BPELFactory.eINSTANCE.createCompletionCondition();
				_for.setCompletionCondition( target );
			}
			return target;
			
		}
		
		return super.getExpressionTarget();
	}

	@Override
	protected Expression getExpression4Target ( Expression expression ) {
		
		if (expression instanceof Branches) {
			return expression;
		}
		
		Branches branches = BPELFactory.eINSTANCE.createBranches();
		
		branches.setBody( expression.getBody() );
		branches.setExpressionLanguage( expression.getExpressionLanguage() );
		
		return branches;
	}
	

	@Override
	protected boolean isValidClientUseType(String useType) {
		return IBPELUIConstants.USE_TYPE_CONDITION.equals(useType);
	}
}
