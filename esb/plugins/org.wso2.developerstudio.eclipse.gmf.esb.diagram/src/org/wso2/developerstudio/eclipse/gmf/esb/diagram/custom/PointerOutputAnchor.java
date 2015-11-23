package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;

public class PointerOutputAnchor extends AbstractConnectionAnchor {
	public PointerOutputAnchor(AbstractPointerShape pointerShape) {
		super(pointerShape);
	}

	/**
	 * {@inheritDoc}
	 */
	public Point getLocation(Point reference) {
		Point result = ((AbstractPointerShape) getOwner()).getOutputAnchorPoint();
		getOwner().translateToAbsolute(result);
		return result;
	}		
}
