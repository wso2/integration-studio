package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;


import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.graphics.Color;

public class EsbGraphicalShape extends RoundedRectangle {
	RectangleFigure propertyValueRectangle1;
	static int Figure_PreferredWidth = FixedSizedAbstractMediator.FigureWidth;
	static int Figure_PreferredHeight = FixedSizedAbstractMediator.FigureHeight;
	static int Image_PreferredWidth = 55;
	static int Image_PreferredHeight = 55;
	static int marginWidth = (Figure_PreferredWidth - Image_PreferredWidth) / 2; //equals to 10
	static int marginHeight = 10;

	public EsbGraphicalShape() {
		GridLayout layoutThis = new GridLayout();
		layoutThis.marginHeight = 0; // if we keep default value (5), then selected border and normal border will not coincide
		layoutThis.marginWidth = 0;
		this.setLayoutManager(layoutThis);

		this.setCornerDimensions(new Dimension(8, 8));
		this.setFill(false);
		this.setOutline(false);
		this.setPreferredSize(new Dimension(Figure_PreferredWidth, Figure_PreferredHeight));
		
		RoundedRectangleBorder border = new RoundedRectangleBorder(8, 8);
        border.setColor(EditPartDrawingHelper.FigureNormalColor);
        this.setBorder(border);
        
		createContents();
	}

	private void createContents() {

		RoundedRectangle bottomRondedRect = new RoundedRectangle();
		bottomRondedRect.setCornerDimensions(new Dimension(8, 8));
		bottomRondedRect.setOutline(false);
		//bottomRondedRect.setBackgroundColor(this.getBackgroundColor()); //do no set background since this will case probs with selection colors
		bottomRondedRect.setPreferredSize(new Dimension(Figure_PreferredWidth, Figure_PreferredHeight));
		// we do not set border since we dont want to show that in unselected state
		
		GridLayout bottomRondedRectGridLayout = new GridLayout();
		bottomRondedRectGridLayout.horizontalSpacing = 0;
		bottomRondedRectGridLayout.verticalSpacing = 0;
		bottomRondedRectGridLayout.marginHeight = marginHeight - 1; // -1 is to handle visual pixel offset
		bottomRondedRectGridLayout.marginWidth = marginWidth;
		bottomRondedRect.setLayoutManager(bottomRondedRectGridLayout);
		
		ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(getIconPath(), Image_PreferredWidth, Image_PreferredHeight);
		bottomRondedRect.add(iconImageFigure);	
		
		GridData bottomRoundedRectConstrainGridData = new GridData();
		bottomRoundedRectConstrainGridData.verticalAlignment = GridData.BEGINNING;
		bottomRoundedRectConstrainGridData.horizontalAlignment = GridData.CENTER;
		this.add(bottomRondedRect, bottomRoundedRectConstrainGridData);
		
		propertyValueRectangle1 = new RectangleFigure();
		propertyValueRectangle1.setOutline(false);
		//propertyValueRectangle1.setBackgroundColor(EditPartDrawingHelper.FigureNormalColor);
		propertyValueRectangle1.setPreferredSize(new Dimension(Figure_PreferredWidth, 10));
		propertyValueRectangle1.setLayoutManager(new StackLayout());
	}

	public RectangleFigure getPropertyValueRectangle1() {
		return propertyValueRectangle1;
	}

	public String getIconPath() {
		return "override this in the child class with actual icon path";
	}

	public String getNodeName() {
		return "<default>";
	}
	
	public Color getLabelBackColor() {
		return this.getBackgroundColor();
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
	}
	
}
