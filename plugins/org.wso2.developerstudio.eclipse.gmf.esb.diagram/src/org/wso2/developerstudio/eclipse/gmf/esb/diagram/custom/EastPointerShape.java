package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class EastPointerShape extends AbstractPointerShape {	
	/**
	 * {@inheritDoc}
	 */
	public PointList getDrawPoints() {
		PointList result = new PointList();		
		Rectangle bounds = getBounds();		
		double cellWidth = bounds.preciseWidth() * 0.618;
		double cellHeight = bounds.preciseHeight() / 2;
		
		result.addPoint(new PrecisionPoint(0.0, 0.0));
//		result.addPoint(new PrecisionPoint(cellWidth * 2, 0.0));
		result.addPoint(new PrecisionPoint(cellWidth , 0.0));
		result.addPoint(new PrecisionPoint(bounds.preciseWidth(), cellHeight));
		result.addPoint(new PrecisionPoint(cellWidth , bounds.preciseHeight()));
		
//		result.addPoint(new PrecisionPoint(cellWidth * 2, bounds.preciseHeight()));
		result.addPoint(new PrecisionPoint(0.0, bounds.preciseHeight()));
//		result.addPoint(new PrecisionPoint(cellWidth, cellHeight));
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Point getInputAnchorPoint() {
		Rectangle bounds = getBounds();
		return new PrecisionPoint(bounds.preciseX(),
				bounds.preciseY() + bounds.preciseHeight() / 2);
	}

	/**
	 * {@inheritDoc}
	 */
	public Point getOutputAnchorPoint() {
		Rectangle bounds = getBounds();
		return new PrecisionPoint(bounds.preciseX() + bounds.preciseWidth(),
				bounds.preciseY() + bounds.preciseHeight() / 2);
	}
}
