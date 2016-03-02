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

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;

public class PropertyMediatorOMPropertyDialog extends
		AbstractMediatorMultiLinePropertyDialog {

	public PropertyMediatorOMPropertyDialog(String title, Shell parentShell,
			Mediator mediator, EStructuralFeature feature, String initialText) {
		super(title, parentShell, mediator, feature, initialText);
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText("Property Mediator OM Value");
	}

	@Override
	protected boolean isValid(String stringContent) {
		
			OMElement element = null;
			try {
				element = AXIOMUtil.stringToOM(stringContent);
				element.build();
			} catch (Exception e) {
				String errorMsgHeader = "Malformed xml";
				IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						e.getMessage());
				ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error",
						errorMsgHeader, editorStatus);
				element = null;
			}
			if (element != null) {
				return true;
			} else {
				return false;
			}
		}
	
}
