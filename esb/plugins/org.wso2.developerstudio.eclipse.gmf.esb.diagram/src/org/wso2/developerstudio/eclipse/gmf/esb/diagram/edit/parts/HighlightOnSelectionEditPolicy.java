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


import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint2;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditPartDrawingHelper;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;


public class HighlightOnSelectionEditPolicy extends SelectionEditPolicy {
	
	private static final int BREAKPOINT_HIT_BORDER_WIDTH = 3;

	protected void showSelection() {
		setselected(true);
	}

	protected void hideSelection() {
		setselected(false);
	}
		
	private void setselected(boolean isselected) {
		
		Color figureColor = EditPartDrawingHelper.FigureNormalColor;
		Color borderColor = EditPartDrawingHelper.FigureNormalColor;
		if (isselected) { 
			figureColor = EditPartDrawingHelper.FigureSelectedColor;
			borderColor = EditPartDrawingHelper.FigureSelectedBorderColor;
		}
		
		if(getHost() instanceof FixedSizedAbstractMediator) {
			FixedSizedAbstractMediator mediator = (FixedSizedAbstractMediator)getHost();
			mediator.getFixedSizedPrimaryShape().setBackgroundColor(figureColor);
			RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getFixedSizedPrimaryShape().getBorder();
			border.setColor(borderColor);
			if (mediator.isBreakpointHit()) {
				border.setColor(EditPartDrawingHelper.FigureBreakpointHitColor);
				border.setWidth(BREAKPOINT_HIT_BORDER_WIDTH);
			} else {
				border.setColor(borderColor);
				border.setWidth(0);
			}
		}
		
		if (getHost() instanceof complexFiguredAbstractMediator) {
			complexFiguredAbstractMediator mediator = (complexFiguredAbstractMediator) getHost();
			mediator.getComplexFiguredPrimaryShape().setBackgroundColor(
					figureColor);
			if (mediator.isBreakpointHit()) {
				LineBorder border = (LineBorder) mediator
						.getComplexFiguredPrimaryShape().getBorder();
				border.setColor(EditPartDrawingHelper.FigureBreakpointHitColor);
				border.setWidth(BREAKPOINT_HIT_BORDER_WIDTH);
			} else {
				LineBorder border = (LineBorder) mediator
						.getComplexFiguredPrimaryShape().getBorder();
				border.setColor(EditPartDrawingHelper.ComplexFigureSelectedBorderColor);
				border.setWidth(0);
			}
		}
		
		if (getHost() instanceof AbstractEndpoint) {
			AbstractEndpoint mediator = (AbstractEndpoint) getHost();
			mediator.getEndPointPrimaryShape().setBackgroundColor(figureColor);
			Border border = mediator.getEndPointPrimaryShape().getBorder();
			if (border instanceof RoundedRectangleBorder) {
				RoundedRectangleBorder roundedRectangleBorder = (RoundedRectangleBorder) border;
				roundedRectangleBorder.setColor(borderColor);
			}
		}
		
		if(getHost() instanceof AbstractEndpoint2) {
			AbstractEndpoint2 mediator = (AbstractEndpoint2)getHost();
			mediator.getEndPoint2PrimaryShape().setBackgroundColor(figureColor);
			RoundedRectangleBorder border = (RoundedRectangleBorder)mediator.getEndPoint2PrimaryShape().getBorder();
			border.setColor(borderColor);
		}
	}

}

