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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

/**
 * Details section for the duration/date of a Wait activity and of the OnAlarm activity.
 * <p>
 * This is a little more involved, because "until" and "for" are mutually exclusive in the model.
 * </p>
 * TODO: review and complete this class (VZ)
 */
public class WaitConditionSection extends ExpressionSection {

	protected Button[] radioButtons;
	protected int fButtonCount ;
	protected int fCurrentButtonIndex;

	@Override
	protected String getExpressionType() {
		return getButtonExprType(this.fCurrentButtonIndex);
	}

	/**
	 * Change the input.
	 */
	@Override
	protected void basicSetInput(EObject newInput) {

		super.basicSetInput(newInput);
		this.fCurrentButtonIndex = getButtonIndexFromModel();
		updateRadioButtonWidgets();
	}


	/**
	 * Update the Radio button widgets according to the state of the model.
	 */
	protected void updateRadioButtonWidgets() {

		this.fCurrentButtonIndex = getButtonIndexFromModel();
		if (this.fCurrentButtonIndex >= 0) this.radioButtons[this.fCurrentButtonIndex].setSelection(true);
		for (int i = 0; i<this.radioButtons.length; i++) {
			if (i != this.fCurrentButtonIndex)
				this.radioButtons[i].setSelection(false);
		}
	}

	/**
	 * Creates the radio button widgets.
	 * @param parent
	 */
	protected void createRadioButtonWidgets(Composite parent) {

		this.fButtonCount = gLabels.length;

		Composite radioComposite = getWidgetFactory().createComposite( parent );
		radioComposite.setLayout( new GridLayout( 2, true ));

		this.radioButtons = new Button[ this.fButtonCount ];
		for(int i = 0; i < this.fButtonCount; i++) {
			this.radioButtons[i] = this.fWidgetFactory.createButton(radioComposite, gLabels[i], SWT.RADIO);
			this.radioButtons[i].addSelectionListener(new SelectionListener() {
				public void widgetSelected (SelectionEvent e) {
					// TODO: store the information
				}
				public void widgetDefaultSelected(SelectionEvent e) { }
			});
		}
	}

	protected void createClient(Composite parent) {
		super.createClient(parent);
		createRadioButtonWidgets( parent );
		PlatformUI.getWorkbench().getHelpSystem().setHelp( parent, IHelpContextIds.PROPERTY_PAGE_WAIT );
	}

	protected String getButtonExprType (int buttonIndex) {
		if (buttonIndex == 0) {
			return IEditorConstants.ET_DATETIME;
		}
		if (buttonIndex == 1) {
			return IEditorConstants.ET_DURATION;
		}
		throw new IllegalArgumentException();
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

	protected boolean isValidClientUseType (String useType) {
		return IBPELUIConstants.USE_TYPE_DEADLINE_CONDITION.equals(useType)
			|| IBPELUIConstants.USE_TYPE_DURATION_CONDITION.equals(useType);
	}


	/**
	 * We override this parameter-less method since the feature changes as the button selection changes.
	 * The target of this structural feature (for the SetCommand model mutation change) is the target itself,
	 * that is the Wait activity.
	 */
	@Override
	protected EStructuralFeature getStructuralFeature() {
		return getStructuralFeature ( this.fCurrentButtonIndex );
	}

	protected EStructuralFeature getStructuralFeature( int index ) {
		EStructuralFeature features []  = CLASS2FEATURES.get( getInput().eClass());
		assert (features != null) : "Features cannot be null";
		return features[ index ];
	}


	@Override
	protected EStructuralFeature getStructuralFeature( EObject eObj ) {

		EStructuralFeature features [] = CLASS2FEATURES.get(eObj.eClass() );
		for (EStructuralFeature f : features) {
			Object result = eObj.eGet(f);
			if (result != null) {
				return f;
			}
		}

		return null;
	}


	/**
	 * Saves the expression to the model.
	 */
	protected void saveExpressionToModel() {

		if( this.modelUpdate.get())
			return;

		// Usual behavior
		EStructuralFeature aFeature = getStructuralFeature();
		EObject target = getExpressionTarget();

		CompoundCommand result = new CompoundCommand();
		Expression exp = BPELFactory.eINSTANCE.createCondition();
		exp.setBody( this.expressionText != null ? this.expressionText.getText().trim() : "" );
		result.add( new SetCommand( target, getExpression4Target( exp ) , aFeature ));

		// Unset the features that should not be set
		for (EStructuralFeature feature : CLASS2FEATURES.get( getInput().eClass() ) ) {
			if( ! feature.equals( aFeature ) && target.eIsSet(feature))
				result.add( new SetCommand(target,null,feature)) ;
		}

		getCommandFramework().execute( result );
	}
}
