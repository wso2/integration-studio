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
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;


/**
 * Details section for the WhileCondition of an activity (a boolean expression).
 */
public class WhileConditionSection extends ExpressionSection {

	@Override
	protected String getExpressionType() { 
		return IEditorConstants.ET_BOOLEAN; 
	}
	
	
	@Override
	protected Composite createNoEditorWidgets (Composite composite) {
			    	    
		return super.createNoEditorWidgetsCreateComposite(composite,
				
				Messages.WhileConditionSection_No_condition_specified_1 + NL + NL +
				Messages.WhileConditionSection_Mandatory_condition_text_2 ,
				
				Messages.WhileConditionSection_Create_a_New_Condition_3);
	}

	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		
		if (object instanceof While) {
			return BPELPackage.eINSTANCE.getWhile_Condition() ;
		}
		if (object instanceof RepeatUntil) {
			return BPELPackage.eINSTANCE.getRepeatUntil_Condition();
		}
		
		return super.getStructuralFeature(object);
	}


	@Override
	protected boolean isValidClientUseType (String useType) {
		return IBPELUIConstants.USE_TYPE_CONDITION.equals(useType);
	}
	
	
	
	
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getMarkers(java.lang.Object)
	 */
	@Override
	protected IMarker[] getMarkers (Object input) {
		
		if ( input instanceof While ) {
			While _while = (While) input;
			return super.getMarkers( _while.getCondition() );
		}
		
		return EMPTY_MARKERS;
	}


	/**
	 * Return true if the marker is valid for this section.
	 * @return true if so, false otherwise.
	 */
	

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#isValidMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public boolean isValidMarker (IMarker marker) {
		String context = null;
		try {
			context = (String) marker.getAttribute("href.context");
		} catch (Exception ex) {
			return false;
		}
		
		return "name".equals (context) == false ;
	}	
	
}
