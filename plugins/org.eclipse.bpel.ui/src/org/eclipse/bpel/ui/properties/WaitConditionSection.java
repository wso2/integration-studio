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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the duration/date of a Wait activity and of the OnAlarm 
 * activity.
 * 
 * This is a little more involved, because "until" and "for" are mutually exclusive in the model.
 *   
 */

public class WaitConditionSection extends RadioChoiceExpressionSection {
	
	@Override
	protected Composite createNoEditorWidgets(Composite composite) {
		return createNoEditorWidgetsCreateComposite(composite,
				
				Messages.WaitConditionSection_No_condition_specified_1 + NL + NL +
				Messages.WaitConditionSection_Create_condition_text_2 ,
				
				Messages.WaitConditionSection_Create_a_New_Condition_2);		
	}
		
	 
	@Override
	protected String[] getButtonLabels() {
		return gLabels;
	}
	

	@Override
	protected String getButtonExprType (int buttonIndex) {
		if (buttonIndex == 0) {
			return IEditorConstants.ET_DATETIME;
		}
		if (buttonIndex == 1) {
			return IEditorConstants.ET_DURATION;
		}
		throw new IllegalArgumentException();
	}
	
	
	@Override
	protected void radioButtonSelected (int index, Button button) {
			
		if (button.getSelection() == false) {
			return ;
		}
		
		/** Mark the current radio button selection */		
		fCurrentButtonIndex = index;	
		
		runCommand(newStoreToModelCommand( getDefaultBody(editorLanguage,getButtonExprType(index) ) ) ) ;		
	}


	/**
	 * This is a map between classes (Wait, OnAlarm)
	 * and the structural features that they support (For and Until).
	 * 
	 * Pay particular attention to the indices of the arrays because they are ... 
	 * let's just say "connected"
	 */
	
	static final String[] gLabels = 
		{ 
			Messages.WaitConditionSection_Date_1, 
			Messages.WaitConditionSection_Duration_2 
		};
	
	/** 
	 * Button 0 is for "until" (date time)
	 * Button 1 is for "for"   (duration)
	 */
	
	static Map<EClass, EStructuralFeature[]> CLASS2FEATURES  = new HashMap<EClass, EStructuralFeature[]>();
	static {
		CLASS2FEATURES.put( BPELPackage.eINSTANCE.getWait() , 
				new EStructuralFeature [] {
					BPELPackage.eINSTANCE.getWait_Until(),
			 		BPELPackage.eINSTANCE.getWait_For()
			 		
				});
		CLASS2FEATURES.put( BPELPackage.eINSTANCE.getOnAlarm() , 
				new EStructuralFeature [] {
					BPELPackage.eINSTANCE.getOnAlarm_Until(),
			 		BPELPackage.eINSTANCE.getOnAlarm_For()			 		
				});		
	}
	
	
	@Override
	protected Expression getExprFromModel() {	
	
		EObject input = getInput();
		
		EStructuralFeature feature = getStructuralFeature (input);
		if (feature == null) {
			return null;
		}
		
		Object result = input.eGet(feature);
		if (result != null && result instanceof Expression) {
			return (Expression) result;		
		}
		return null; 
	}
	
	@SuppressWarnings("nls")
	@Override
	protected int getButtonIndexFromModel() {
		EObject input = getInput();
		EStructuralFeature feature = getStructuralFeature(input);
		if (feature == null) {
			return 1;
		}				
		if (feature.getName().indexOf("until") >= 0) {
			return 0;
		}		
		return 1;
	}

	
	@Override
	protected boolean isValidClientUseType (String useType) {
		return IBPELUIConstants.USE_TYPE_DEADLINE_CONDITION.equals(useType)
			|| IBPELUIConstants.USE_TYPE_DURATION_CONDITION.equals(useType);
	}
	
	@Override
	protected void createClient (Composite parent) {
		super.createClient(parent);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			fParentComposite, IHelpContextIds.PROPERTY_PAGE_WAIT);
	}
	
	
	/**
	 * Return true if the marker is valid for this section.
	 * @return true if so, false otherwise.
	 */
		
	@Override
	public boolean isValidMarker (IMarker marker ) {
		return false;
	}

	/**
	 * We override this parameter-less method since the feature changes as the button selection changes.
	 * The target of this structural feature (for the SetCommand model mutation change) is the target itself,
	 * that is the Wait activity.  
	 */
	
	@Override
	protected EStructuralFeature getStructuralFeature (  ) {
		return getStructuralFeature ( fCurrentButtonIndex );
	}
	
	protected EStructuralFeature getStructuralFeature ( int index ) {
		EStructuralFeature features []  = CLASS2FEATURES.get( getInput().eClass() );		
		assert (features != null) : "Features cannot be null";
		return features[ index ];
	}
	
	
	@Override
	protected EStructuralFeature getStructuralFeature ( EObject eObj ) {
						
		EStructuralFeature features [] = CLASS2FEATURES.get(eObj.eClass() );		
		for (EStructuralFeature f : features) {
			Object result = eObj.eGet(f);
			if (result != null) {
				return f;
			}
		}
		
		return super.getStructuralFeature(eObj);
	}
	
	/**
	 * Here we have to set the feature that we are setting and unset all
	 * the other mutually exclusive features. 
	 * 
	 * 
	 */
	@Override
	protected Command newStoreToModelCommand (Object body) {
		
		CompoundCommand result = new CompoundCommand();		
		Expression oldExp = getExprFromModel();
		
		Expression exp = BPELFactory.eINSTANCE.createExpression();
		
		// Don't set the language, because if the user has changed the
		// language, a condition would already exist at this point.
		
		if (oldExp != null) {
			exp.setExpressionLanguage(oldExp.getExpressionLanguage());
		}
		exp.setBody(body);
		
		
		/** Be nice and unset the features that should not be set. */
		
		EStructuralFeature aFeature = getStructuralFeature();
		EObject target = getExpressionTarget();
		
		/** Set the feature being edited */
		result.add (new SetCommand(target, exp, aFeature));
		
		// Unset others, if set
		for (EStructuralFeature feature : CLASS2FEATURES.get( getInput().eClass() ) ) {
			if (feature.equals(aFeature) || target.eIsSet(feature) == false ) {
				continue;
			}			
			result.add( new SetCommand(target,null,feature)) ;
		}
		
		return result;
	}
	
}
