/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * for failureHandling extension provided by ODE: JIRA:TOOLS-785
 * $Id$
 */
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FailureHandlingProperty extends BPELPropertySection {

	// faultOnFailure
	protected Label faultOnFailureLabel;
	protected Button faultOnFailureRadioOn;
	protected Button faultOnFailureRadioOff;
	// retryFor
	protected Label retryForLable;
	protected Text retryForTextbox;
	// retryDelay
	protected Label retryDelayLabel;
	protected Text retryDelayTextbox;

	// Error Message UI
	protected Label errorMsgRetryFor;
	protected Label errorMsgRetryDelay;
	protected EditController faultOnFailureCheckboxController;

	// Error Status values
	private boolean retryForOnErrorStatus = false;
	private boolean retryDelayOnErrorStatus = false;
	private static String ERROR_INTEGER_INVALIED = "Error: Incorrect integer value";

	// These are GUI constants.
	public static final int SPLIT_POINT = 55;
	public static final int SPLIT_POINT_OFFSET = 3 * IDetailsAreaConstants.HSPACE;
	public static final String EMPTY_TEXT = "";

	/**
	 * Returns failureHandeling object of the Invoke activity. 
	 * @return
	 */
	private FailureHandling getFailureHandling() {
		EObject parrentInvoke = getInput();
		if (parrentInvoke != null) {
			FailureHandling failureHandling = ((Invoke) parrentInvoke)
					.getFailureHandling();
			if (failureHandling != null) {
				return failureHandling;
			}
		}
		return null;
	}

	protected void createClient(Composite parent) {

		final Composite composite = createFlatFormComposite(createFlatFormComposite(parent));
		Composite ref = null;
		ref = createFailureHandlingWidget(ref, composite);

	}

	/**
	 * data serialization; when Fault on failure true
	 */
	private void writeValue() {

		boolean faultOnFailureValue = faultOnFailureRadioOn.getSelection();

		FailureHandling failureHandling = getFailureHandling();
		if (failureHandling == null) { // Creates new failureHandling object
			failureHandling = BPELFactory.eINSTANCE.createFailureHandling();
			((Invoke) getInput()).setFailureHandling(failureHandling);
		}

		// Set Fault On Failure Values
		FaultOnFailure faultOnFailure = BPELFactory.eINSTANCE
				.createFaultOnFailure();
		faultOnFailure.setValue(faultOnFailureValue);
		failureHandling.setFaultOnFailure(faultOnFailure);
		
		// check for integer error status. 
		if (!retryForOnErrorStatus && !retryDelayOnErrorStatus) {
			// Set RetryFor values
			RetryFor retryFor = BPELFactory.eINSTANCE.createRetryFor();
			retryFor.setValue(Integer.parseInt(retryForTextbox.getText()));
			failureHandling.setRetryFor(retryFor);
			// Set RetryDelay values
			RetryDelay retryDelay = BPELFactory.eINSTANCE.createRetryDelay();
			retryDelay.setValue(Integer.parseInt(retryDelayTextbox.getText()));
			failureHandling.setRetryDelay(retryDelay);
		}

		// data serialization
		getCommandFramework().execute(
				wrapInShowContextCommand((new SetCommand(((Invoke) getInput()),
						failureHandling, BPELPackage.eINSTANCE
								.getInvoke_FailureHandling()))));

	}

	/**
	 * Creating the widget.
	 */
	private Composite createFailureHandlingWidget(Composite top,
			Composite parent) {
		FlatFormData data;

		final Composite composite = createFlatFormComposite(parent);
		data = new FlatFormData();
		if (top == null) {
			data.top = new FlatFormAttachment(0, 5);
		} else {
			data.top = new FlatFormAttachment(top, 5);
		}
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(SPLIT_POINT, -SPLIT_POINT_OFFSET);
		composite.setLayoutData(data);

		errorMsgRetryDelay = fWidgetFactory.createLabel(composite, "");
		errorMsgRetryFor = fWidgetFactory.createLabel(composite, "");

		// faultOnFailure
		faultOnFailureLabel = fWidgetFactory.createLabel(composite,
				"Fault On Failure:");
		faultOnFailureRadioOn = fWidgetFactory.createButton(composite, "True",
				SWT.RADIO);
		faultOnFailureRadioOff = fWidgetFactory.createButton(composite,
				"False", SWT.RADIO);

		// Retry For
		retryForLable = fWidgetFactory.createLabel(composite, "Retry For");
		retryForTextbox = fWidgetFactory.createText(composite, "0", SWT.RIGHT);

		// Retry Delay
		retryDelayLabel = fWidgetFactory.createLabel(composite,
				"Retry Delay (Sec.)");
		retryDelayTextbox = fWidgetFactory
				.createText(composite, "0", SWT.RIGHT);

		// Default values
		faultOnFailureRadioOff.setSelection(true);
		faultOnFailureRadioOn.setSelection(false);

		/*
		 * Setup positions
		 */

		// faultOnFailure
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultOnFailureRadioOn,
				-IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 5);
		faultOnFailureLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(
				faultOnFailureLabel, STANDARD_LABEL_WIDTH_SM));
		data.top = new FlatFormAttachment(0, 5);
		faultOnFailureRadioOn.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(0,5);
		data.left = new FlatFormAttachment(faultOnFailureRadioOn, 20);
		faultOnFailureRadioOff.setLayoutData(data);


		// Retry For
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(faultOnFailureLabel, 20);
		retryForLable.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 130);
		data.width = 100;
		data.top = new FlatFormAttachment(faultOnFailureLabel, 15);
		retryForTextbox.setLayoutData(data);

		//Retry For Error Message
		data = new FlatFormData();
		data.left = new FlatFormAttachment(retryForTextbox, 10);
		data.width = 400;
		data.top = new FlatFormAttachment(faultOnFailureLabel, 20);
		errorMsgRetryFor.setLayoutData(data);
		errorMsgRetryFor.setForeground(new Color(Display.getDefault(), 255, 0,
				0));

		
		// Retry Delay
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(retryForLable, 20);
		retryDelayLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 130);
		data.width = 100;
		data.top = new FlatFormAttachment(retryForLable, 15);
		retryDelayTextbox.setLayoutData(data);


		// Retry Delay Error Message
		data = new FlatFormData();
		data.left = new FlatFormAttachment(retryDelayTextbox, 10);
		data.width = 400;
		data.top = new FlatFormAttachment(retryForLable, 20);
		errorMsgRetryDelay.setLayoutData(data);
		errorMsgRetryDelay.setForeground(new Color(Display.getDefault(), 255,
				0, 0));

		retryForTextbox.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				if (validateValueForInteger(retryForTextbox.getText())) {
					retryForTextbox.setForeground(new Color(Display
							.getDefault(), 0, 0, 0)); // set text as valid
														// integer
					errorMsgRetryFor.setText("");
					retryForOnErrorStatus = false;
				} else {
					retryForTextbox.setForeground(new Color(Display
							.getDefault(), 255, 0, 0)); // mark text as red and
														// text is not integer
														// value.
					errorMsgRetryFor.setText(ERROR_INTEGER_INVALIED);
					retryForOnErrorStatus = true;
				}
			}
		});

		retryForTextbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				writeValue();

			}

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		retryDelayTextbox.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				if (validateValueForInteger(retryDelayTextbox.getText())) {
					retryDelayTextbox.setForeground(new Color(Display
							.getDefault(), 0, 0, 0)); // set text as valid
														// integer
					errorMsgRetryDelay.setText("");
					retryDelayOnErrorStatus = false;
				} else {
					retryDelayTextbox.setForeground(new Color(Display
							.getDefault(), 255, 0, 0)); // mark text as red and
														// text is not integer
														// value.
					errorMsgRetryDelay.setText(ERROR_INTEGER_INVALIED);
					retryDelayOnErrorStatus = true;
				}

			}
		});
		retryDelayTextbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				writeValue();

			}

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		faultOnFailureRadioOff.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				writeValue();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing Here
			}

		});

		faultOnFailureRadioOn.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				writeValue();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing Here
			}

		});

		return composite;
	}

	/**
	 * updates property sheet values when activity selected.
	 */
	private void updateFailureHandlingWidget() {

		FailureHandling currentFailureHandling = getFailureHandling();

		if (currentFailureHandling != null) {
			if (currentFailureHandling.getFaultOnFailure() != null) {
				retryDelayTextbox.setText(String.valueOf(currentFailureHandling
						.getRetryDelay().getValue()));
				retryForTextbox.setText(String.valueOf(currentFailureHandling
						.getRetryFor().getValue()));
				// case Fault on Failure true
				if (currentFailureHandling.getFaultOnFailure().isValue()) {
					faultOnFailureRadioOff.setSelection(false);
					faultOnFailureRadioOn.setSelection(true);
				} else {

					faultOnFailureRadioOff.setSelection(true);
					faultOnFailureRadioOn.setSelection(false);
				}
				return;
			}
		}
		// default case
		faultOnFailureRadioOff.setSelection(true);
		faultOnFailureRadioOn.setSelection(false);
		retryDelayTextbox.setText(String.valueOf(0));
		retryForTextbox.setText(String.valueOf(0));

	}

	/**
	 * checks whether input String is an interger or not
	 * 
	 * @param number
	 * @return true is number is an interger, else return false.
	 */
	private boolean validateValueForInteger(String number) {

		if (number != null && !number.equals("")) {
			return number.matches("([0-9]*)");
		} else {
			return false;
		}
	}

	protected void basicSetInput(EObject newInput) {
		if (newInput instanceof Invoke) {
			super.basicSetInput(newInput);
			// updates property sheet values when activity selected.
			updateFailureHandlingWidget();
		}
	}

}
