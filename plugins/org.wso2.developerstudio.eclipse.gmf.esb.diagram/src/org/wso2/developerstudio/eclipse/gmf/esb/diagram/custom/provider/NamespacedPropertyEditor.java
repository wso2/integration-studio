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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamespacedPropertyEditorDialog;

/**
 * {@link CustomDialogCellEditor} responsible for handling namespaced
 * properties.
 */
public class NamespacedPropertyEditor extends CustomDialogCellEditor {
	/**
	 * {@link NamespacedProperty} instance used for editing.
	 */
	private NamespacedProperty namespacedProperty;

	/**
	 * Property owner.
	 */
	private Object propertyContainer;

	/**
	 * Property descriptor.
	 */
	private IItemPropertyDescriptor propertyDescriptor;

	/**
	 * Creates a new {@link NamespacedPropertyEditor) instance.
	 * 
	 * @param parent parent {@link Composite}.
	 * @param namespacedProperty original {@link NamespacedProperty} instance to be replaced after editing.
	 * @param propertyContainer property owner object.
	 * @param propertyDescriptor property descriptor.
	 */
	public NamespacedPropertyEditor(Composite parent, NamespacedProperty namespacedProperty, Object propertyContainer,
			IItemPropertyDescriptor propertyDescriptor) {
		super(parent);
		this.namespacedProperty = getEsbFactory().copyNamespacedProperty(namespacedProperty);
		this.propertyContainer = propertyContainer;
		this.propertyDescriptor = propertyDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(cellEditorWindow.getShell(),
				getStyle(), namespacedProperty);
		dialog.open();
		if (dialog.isSaved()) {
			propertyDescriptor.setPropertyValue(propertyContainer, namespacedProperty);
		}
		return null;
	}	

	protected NamespacedProperty getNamespacedProperty() {
		return namespacedProperty;
	}

	protected void setNamespacedProperty(NamespacedProperty namespacedProperty) {
		this.namespacedProperty = namespacedProperty;
	}
}
