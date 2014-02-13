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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;


import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint2;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditPartDrawingHelper;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;


public class HighlightOnSelectionEditPolicy extends SelectionEditPolicy {
	
	protected void showSelection() {
		setselected(true);
	}

	protected void hideSelection() {
		setselected(false);
	}
		
	private void setselected(boolean isselected) {
		
		Color figureColor = EditPartDrawingHelper.FigureNormalColor;
		Color boderColor = EditPartDrawingHelper.FigureNormalColor;
		if (isselected) { 
			figureColor = EditPartDrawingHelper.FigureSelectedColor;
			boderColor = EditPartDrawingHelper.FigureSelectedBorderColor;
		}
		
		if(getHost() instanceof FixedSizedAbstractMediator) {
			FixedSizedAbstractMediator mediator = (FixedSizedAbstractMediator)getHost();
			mediator.getFixedSizedPrimaryShape().setBackgroundColor(figureColor);
			RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getFixedSizedPrimaryShape().getBorder();
			border.setColor(boderColor);
		}
		
		if(getHost() instanceof complexFiguredAbstractMediator) {
			complexFiguredAbstractMediator mediator = (complexFiguredAbstractMediator)getHost();
			mediator.getComplexFiguredPrimaryShape().setBackgroundColor(figureColor);
			//RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getComplexFiguredPrimaryShape().getBorder();
			//border.setColor(boderColor);
		}
		
		if(getHost() instanceof AbstractEndpoint) {
			AbstractEndpoint mediator = (AbstractEndpoint)getHost();
			mediator.getEndPointPrimaryShape().setBackgroundColor(figureColor);
			RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getEndPointPrimaryShape().getBorder();
			border.setColor(boderColor);
		}
		
		if(getHost() instanceof AbstractEndpoint2) {
			AbstractEndpoint2 mediator = (AbstractEndpoint2)getHost();
			mediator.getEndPoint2PrimaryShape().setBackgroundColor(figureColor);
			RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getEndPoint2PrimaryShape().getBorder();
			border.setColor(boderColor);
		}
	}

}

