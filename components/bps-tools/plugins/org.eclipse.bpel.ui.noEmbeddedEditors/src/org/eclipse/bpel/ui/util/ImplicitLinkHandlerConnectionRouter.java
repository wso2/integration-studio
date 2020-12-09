/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class ImplicitLinkHandlerConnectionRouter extends AbstractRouter {
	
	private boolean horizontal;
	
	public ImplicitLinkHandlerConnectionRouter(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	public void route(Connection conn) {
		if ((conn.getSourceAnchor() == null) || (conn.getTargetAnchor() == null)) 
			return;
		
		Point start = getStartPoint(conn);
		conn.translateToRelative(start);
		Point end = getEndPoint(conn);
		conn.translateToRelative(end);
		
		Point c1 = null, c2 = null;
		
		if(horizontal){
			c1 = new Point(end.x-10, start.y);
			c2 = new Point(end.x-10, end.y);
		}else{
			c2 = new Point(end.x, end.y-10);
			c1 = new Point(start.x, end.y-10);
		}
		
		
		PointList list = new PointList();
		list.addPoint(start);
		list.addPoint(c1);
		list.addPoint(c2);
		list.addPoint(end);
		
		conn.setPoints(list);

	}

}
