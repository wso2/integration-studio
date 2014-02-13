/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.presentation.ui;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;

/**
 * {@link CustomDialogCellEditor} responsible for handling evaluator expression property value
 * properties.
 */
public class EvaluatorExpressionEditor extends CustomDialogCellEditor {
	/**
	 * {@link EvaluatorExpressionProperty} used for editing.
	 */
	private EvaluatorExpressionProperty evaluatorExpressionProperty;

	/**
	 * Property owner.
	 */
	private Object propertyContainer;

	/**
	 * Property descriptor.
	 */
	private IItemPropertyDescriptor propertyDescriptor;

	/**
	 * Creates a new {@link EvaluatorExpressionEditor} instance.
	 * 
	 * @param parent
	 *            parent {@link Composite}.
	 * @param registryKeyProperty
	 *            orginal {@link EvaluatorExpressionProperty} to be replaced after
	 *            editing.
	 * @param propertyContainer
	 *            property owner.
	 * @param propertyDescriptor
	 *            property descriptor.
	 */
	public EvaluatorExpressionEditor(Composite parent,
			EvaluatorExpressionProperty evaluatorExpressionProperty,
			Object propertyContainer, IItemPropertyDescriptor propertyDescriptor) {
		super(parent);
		this.evaluatorExpressionProperty = getEsbFactory()
				.copyevaluatorExpressionProperty(evaluatorExpressionProperty);
		this.propertyContainer = propertyContainer;
		this.propertyDescriptor = propertyDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		EvaluatorExpressionEditorDialog dialog = new EvaluatorExpressionEditorDialog(
				cellEditorWindow.getShell(), evaluatorExpressionProperty);
		dialog.create();
		dialog.getShell().setText("Evaluator Expression Editor");
		dialog.open();

		if (dialog.getReturnCode() == Window.OK) {
			propertyDescriptor.setPropertyValue(propertyContainer,
					evaluatorExpressionProperty);
		}
		return null;
	}

}
