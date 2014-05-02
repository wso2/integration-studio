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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;


/**
 * Details section for the JoinCondition of an activity (a boolean expression).
 */
public class JoinConditionSection extends ExpressionSection {

	
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Activity activity = getModel();
		Targets targets = activity.getTargets();
		if (targets != null) {
			fAdapters[0].addToObject(targets);
		}
	}
	
	@Override
	protected String getExpressionType() { 
		return IEditorConstants.ET_JOIN; 
	}
	
	
	@Override
	protected boolean isExpressionOptional() { 
		return true; 
	}
	
	
	@Override
	protected Composite createNoEditorWidgets(Composite composite) {
	
		return createNoEditorWidgetsCreateComposite(composite,			
				Messages.JoinConditionSection_No_condition_specified_1 + NL + NL +
				Messages.JoinConditionSection_Optional_condition_text_2 ,				
				Messages.JoinConditionSection_Create_a_New_Condition_3);
	}
	
	
	@Override
	protected EObject getExpressionTarget() {		
		Activity activity = getModel();
		return activity.getTargets();		
	}

	
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {		
		if (object instanceof Activity) {
			return BPELPackage.eINSTANCE.getTargets_JoinCondition() ;
		}
		return super.getStructuralFeature(object);
	}
	
	/**
	 * Update the widgets based on the last input set.
	 * 
	 */
	@Override
	protected void updateWidgets() {
		
		super.updateWidgets();
		
		Activity activity = getModel ();
		Targets targets = activity.getTargets();
		boolean enable = (targets != null);
				
		expressionLanguageViewer.getControl().setEnabled(enable);
		
		if (hasEditor() == false && fCreateExpressionButton != null ) {					
			fCreateExpressionButton.setEnabled(enable);
		}
	}

	
	@Override
	protected void basicSetInput(EObject newInput) {		
		super.basicSetInput(newInput);
		
		// update the widgets
		updateWidgets();
	}

	
	@Override
	protected boolean isValidClientUseType(String useType) {
		return IBPELUIConstants.USE_TYPE_JOIN_CONDITION.equals(useType);
	}
	

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getMarkers(java.lang.Object)
	 */
	@Override
	protected IMarker[] getMarkers (Object input) {
		
		if ( input instanceof Activity ) {
			Activity activity = (Activity) input;
			Targets targets = activity.getTargets();
			if (targets != null) {
				return super.getMarkers( targets.getJoinCondition() );	
			}			
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
	@SuppressWarnings("nls")
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
