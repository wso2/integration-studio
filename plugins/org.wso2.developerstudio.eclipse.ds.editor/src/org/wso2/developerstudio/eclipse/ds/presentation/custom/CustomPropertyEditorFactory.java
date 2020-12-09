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
package org.wso2.developerstudio.eclipse.ds.presentation.custom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.ds.presentation.ui.RegistryKeyPropertyEditor;

/**
 * Factory for generating custom property editors based on property type.
 */
public class CustomPropertyEditorFactory {
	/**
	 * Map of property types against custom property builders.
	 */
	private static Map<String, CustomPropertyEditorBuilder> customPropertyEditorBuildersMap;

	/**
	 * Internal interface representing a property editor builder.
	 */
	interface CustomPropertyEditorBuilder {
		CellEditor build(Composite composite, Object propertyContainer,
		                 IItemPropertyDescriptor propertyDescriptor);
	}

	/**
	 * Static initializer for populating custom property editors map.
	 */
	static {
		customPropertyEditorBuildersMap = new HashMap<String, CustomPropertyEditorBuilder>();

		customPropertyEditorBuildersMap.put("xsltPath", new CustomPropertyEditorBuilder() {
			public CellEditor build(Composite composite, Object propertyContainer,
			                        IItemPropertyDescriptor propertyDescriptor) {
				return new RegistryKeyPropertyEditor(composite, propertyContainer,
				                                     propertyDescriptor);
			}
		});
	}

	/**
	 * Attempts to create a custom property editor for the specified property.
	 * 
	 * @param composite
	 *            container UI widget.
	 * @param propertyContainer
	 *            property container object.
	 * @param propertyDescriptor
	 *            property descriptor.
	 * @return a {@link CellEditor} which fires up a custom property editor or
	 *         null if no such custom editor is defined.
	 */
	public static CellEditor createCustomPropertyEditor(Composite composite,
	                                                    Object propertyContainer,
	                                                    IItemPropertyDescriptor propertyDescriptor) {
		Object feature = propertyDescriptor.getFeature(propertyContainer);
		if (feature instanceof EStructuralFeature) {
			if ((((EStructuralFeature) feature).getName()).equals("xsltPath")) {
				CustomPropertyEditorBuilder builder =
				                                      customPropertyEditorBuildersMap.get("xsltPath");
				if (null != builder) {
					return builder.build(composite, propertyContainer, propertyDescriptor);
				}
			}

		}
		return null;
	}

}