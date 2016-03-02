/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;

/**
 * Mediator editpart listener to capture editpart select and 
 * deselect.
 *
 */
public class MediatorEditPartListener implements EditPartListener {

	private EditPart editPart;

	public MediatorEditPartListener(EditPart editPart) {
		this.editPart = editPart;
	}

	@Override
	public void childAdded(EditPart child, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partActivated(EditPart editpart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partDeactivated(EditPart editpart) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removingChild(EditPart child, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectedStateChanged(EditPart editpart) {
		// Reset select state on deselection of the mediator
		if (editPart instanceof FixedSizedAbstractMediator
				&& ((FixedSizedAbstractMediator) editPart).isSelected()
				&& editpart.getSelected() == 0) {
			((FixedSizedAbstractMediator) editPart).setSelected(false);
		}
	}

}
