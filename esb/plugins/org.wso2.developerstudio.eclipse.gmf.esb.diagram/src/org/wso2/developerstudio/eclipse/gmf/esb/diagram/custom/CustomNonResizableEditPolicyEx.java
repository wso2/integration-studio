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


package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;


public class CustomNonResizableEditPolicyEx extends NonResizableEditPolicyEx {

	
	@Override
	protected List createSelectionHandles() {
		List list = new ArrayList();
		//createMoveHandle(list); //no need to add this, even without this it supports moving, this adds a border therefore dnt add
		return list;
	}
	
	
	/*
	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		// Use a ghost rectangle for feedback
		RectangleFigure r = new RectangleFigure();
		StackLayout propertyRectLayout = new StackLayout();
		r.setLayoutManager(propertyRectLayout);
		String path = "icons/ico20/property-mediator.gif";
		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(path, 55, 35);
		
		RectangleFigure propertyValueRectangle1 = new RectangleFigure();
		propertyValueRectangle1.setOutline(false);
		propertyValueRectangle1.setBackgroundColor(EditPartDrawingHelper.FigureNormalColor );
		propertyValueRectangle1.setAlpha(100); // ghost look
		
		r.add(iconImageFigure);
		r.add(propertyValueRectangle1);
		//FigureUtilities.makeGhostShape(r);
		r.setLineStyle(Graphics.LINE_DOT);
		r.setForegroundColor(ColorConstants.white);
		r.setBounds(getInitialFeedbackBounds());
		r.validate();
		addFeedback(r);
		return r;
	}
	*/
}
