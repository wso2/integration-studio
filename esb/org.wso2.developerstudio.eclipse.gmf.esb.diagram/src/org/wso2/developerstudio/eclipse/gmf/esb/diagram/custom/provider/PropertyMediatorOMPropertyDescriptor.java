/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;;


public class PropertyMediatorOMPropertyDescriptor extends PropertyDescriptor {
		 
		public PropertyMediatorOMPropertyDescriptor(Object object,
				IItemPropertyDescriptor itemPropertyDescriptor) {
			super(object, itemPropertyDescriptor);
		}
	 
		
		public CellEditor createPropertyEditor(Composite parent) {
			return new ExtendedDialogCellEditor(parent, getLabelProvider()) {
				
				protected Object openDialogBox(Control cellEditorWindow) {
					Display display = Display.getDefault();
					Shell shell = new Shell(display);
					String title = EMFEditUIPlugin.INSTANCE.getString("_UI_FeatureEditorDialog_title", 
											new Object [] { getDisplayName(), getEditLabelProvider().getText(object) });
					PropertyMediator propertyMediator = (PropertyMediator) object;
					PropertyMediatorOMPropertyDialog nediatorConfigurationDialog = new PropertyMediatorOMPropertyDialog(title, shell, 
							propertyMediator, EsbPackage.Literals.PROPERTY_MEDIATOR__OM, propertyMediator.getOM());
					nediatorConfigurationDialog.setBlockOnOpen(true);
					nediatorConfigurationDialog.open();
					
					return null;
				}
			};
		}
	 
	}
