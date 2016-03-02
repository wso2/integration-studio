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

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.swt.widgets.Display;

/**
 * MediatorFigureSelectionListener will listen on mediator selection and enables
 * description editing.
 * 
 */
public class MediatorFigureSelectionListener implements MouseListener {

	private EditPart editPart;

	public MediatorFigureSelectionListener() {
		
	}
	
	public MediatorFigureSelectionListener(EditPart editPart) {
		this.editPart = editPart;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.button == 1) {
			if (editPart instanceof FixedSizedAbstractMediator
					&& ((FixedSizedAbstractMediator) editPart).isSelected()) {
				((FixedSizedAbstractMediator) editPart).setSelected(false);
				Display.getCurrent().asyncExec(new Runnable() {
					public void run() {
						if (editPart != null && editPart.isActive()) {
							editPart.performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
							if ((editPart.getViewer() != null)) {
								editPart.getViewer().reveal(editPart);
							}
						}
					}
				});
			} else {
				((FixedSizedAbstractMediator) editPart).setSelected(true);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDoubleClicked(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
