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
package org.wso2.developerstudio.eclipse.ds.presentation.ui;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * {@link CustomDialogCellEditor} responsible for handling registry key
 * properties.
 */
public class RegistryKeyPropertyEditor extends CustomDialogCellEditor {

	/**
	 * Property owner.
	 */
	private Object propertyContainer;

	/**
	 * Property descriptor.
	 */
	private IItemPropertyDescriptor propertyDescriptor;

	/**
	 * Creates a new {@link RegistryKeyPropertyEditor} instance.
	 * 
	 * @param parent
	 *            parent {@link Composite}.
	 * @param xsltPathProperty
	 *            orginal {@link RegistryKeyProperty} to be replaced after
	 *            editing.
	 * @param propertyContainer
	 *            property owner.
	 * @param propertyDescriptor
	 *            property descriptor.
	 */
	public RegistryKeyPropertyEditor(Composite parent, Object propertyContainer,
	                                 IItemPropertyDescriptor propertyDescriptor) {
		super(parent);
		this.propertyContainer = propertyContainer;
		this.propertyDescriptor = propertyDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		RegistryKeyPropertyEditorDialog dialog =
		                                         new RegistryKeyPropertyEditorDialog(
		                                                                             cellEditorWindow.getShell(),
		                                                                             getStyle(),
		                                                                             new ArrayList<NamedEntityDescriptor>());
		dialog.open();
		if (dialog.isSaved()) {
			propertyDescriptor.setPropertyValue(propertyContainer, dialog.getXsltPathProperty());
		}
		return null;
	}
}
