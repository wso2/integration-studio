package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class AbstractPointerShape extends Shape {	
	
	public AbstractPointerShape() {
		this.setFill(true);
		this.setOutline(false);
	}
	
	protected void fillShape(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.pushState();
		graphics.translate(bounds.x, bounds.y);
		graphics.fillPolygon(getDrawPoints());
		graphics.popState();
	}

	protected void outlineShape(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.pushState();
		graphics.translate(bounds.x, bounds.y);
		graphics.drawPolygon(getDrawPoints());
		graphics.popState();
	}
	
	public abstract PointList getDrawPoints();
	
	public abstract Point getInputAnchorPoint();
	
	public abstract Point getOutputAnchorPoint();	
}
