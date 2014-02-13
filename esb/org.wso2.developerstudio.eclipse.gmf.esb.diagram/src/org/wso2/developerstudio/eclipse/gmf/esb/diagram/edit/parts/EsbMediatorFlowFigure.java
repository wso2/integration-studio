package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

	public class EsbMediatorFlowFigure extends RoundedRectangle {

		/**
		 * @generated NOT
		 */
		public EsbMediatorFlowFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.horizontalSpacing = 5;
			layoutThis.verticalSpacing = 5;
			layoutThis.marginHeight = 5;
			layoutThis.marginWidth = 5;
			layoutThis.makeColumnsEqualWidth = true;
			this.setAlpha(0); //to make this transparent
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(1, 1));
			this.setOutline(false);
		}

		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof ResizableCompartmentFigure) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			} else {
				super.add(figure, constraint, index);
			}
		}
		

	}

