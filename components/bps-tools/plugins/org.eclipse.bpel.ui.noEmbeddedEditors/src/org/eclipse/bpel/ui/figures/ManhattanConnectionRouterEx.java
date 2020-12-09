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
package org.eclipse.bpel.ui.figures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A ManhattanConnectionRouter with the additional support of specifying 
 * the start and end direction of the connection
 * @author ascharf
 *
 */
public class ManhattanConnectionRouterEx extends AbstractRouter {


	private Map rowsUsed = new HashMap();
	private Map colsUsed = new HashMap();
	//private Hashtable offsets = new Hashtable(7);

	private Map reservedInfo = new HashMap();

	private class ReservedInfo {
		public List reservedRows = new ArrayList(2);
		public List reservedCols = new ArrayList(2);
	}

	public static Ray 	UP		= new Ray(0, -1),
							DOWN	= new Ray(0, 1),
							LEFT	= new Ray(-1, 0),
							RIGHT	= new Ray(1, 0);


	private Ray prefStartDirection, prefEndDirection;
	
	public ManhattanConnectionRouterEx(){
		this(null,null);
	}
	
	/**
	 * Construct a router with the preferred start and end direction.
	 * Possible types are:
	 * <ul>
	 * <li>ManhattanConnectionRouterEx.UP</li>
	 * <li>ManhattanConnectionRouterEx.LEFT</li>
	 * <li>ManhattanConnectionRouterEx.DOWN</li>
	 * <li>ManhattanConnectionRouterEx.RIGHT</li>
	 * </ul>
	 * @param startDirection
	 * @param endDirection
	 */
	public ManhattanConnectionRouterEx(Ray startDirection, Ray endDirection){
		this.prefStartDirection = startDirection;
		this.prefEndDirection = endDirection;
	}
	
	/**
	 * @see ConnectionRouter#invalidate(Connection)
	 */
	@Override
	public void invalidate(Connection connection) {
		removeReservedLines(connection);
	}

	private int getColumnNear(Connection connection, int r, int n, int x) {
		int min = Math.min(n, x),
			max = Math.max(n, x);
		if (min > r) {
			max = min;
			min = r - (min - r);
		}
		if (max < r) {
			min = max;
			max = r + (r - max);
		}
		int proximity = 0;
		int direction = -1;
		if (r % 2 != 0)
			r--;
		Integer i;
		while (proximity < r) {
			i = Integer.valueOf( r + proximity * direction );
			if (!colsUsed.containsKey(i)) {
				colsUsed.put(i, i);
				reserveColumn(connection, i);
				return i.intValue();
			}
			int j = i.intValue();
			if (j <= min)
				return j + 2;
			if (j >= max)
				return j - 2;
			if (direction == 1)
				direction = -1;
			else {
				direction = 1;
				proximity += 2;
			}
		}
		return r;
	}

	/**
	 * Returns the direction the point <i>p</i> is in relation to the given rectangle.
	 * Possible values are LEFT (-1,0), RIGHT (1,0), UP (0,-1) and DOWN (0,1).
	 * 
	 * @param r the rectangle
	 * @param p the point
	 * @return the direction from <i>r</i> to <i>p</i>
	 */
	protected Ray getDirection(Rectangle r, Point p) {
		int i, distance = Math.abs(r.x - p.x);
		Ray direction;
		
		direction = LEFT;

		i = Math.abs(r.y - p.y);
		if (i <= distance) {
			distance = i;
			direction = UP;
		}

		i = Math.abs(r.bottom() - p.y);
		if (i <= distance) {
			distance = i;
			direction = DOWN;
		}

		i = Math.abs(r.right() - p.x);
		if (i < distance) {
			distance = i;
			direction = RIGHT;
		}

		return direction;
	}

	protected Ray getEndDirection(Connection conn) {
		ConnectionAnchor anchor = conn.getTargetAnchor();
		Point p = getEndPoint(conn);
		Rectangle rect;
		if (anchor.getOwner() == null)
			rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
		else {
			rect = conn.getTargetAnchor().getOwner().getBounds().getCopy();
			conn.getTargetAnchor().getOwner().translateToAbsolute(rect);
		}
		return getDirection(rect, p);
	}

	protected int getRowNear(Connection connection, int r, int n, int x) {
		int min = Math.min(n, x),
			max = Math.max(n, x);
		if (min > r) {
			max = min;
			min = r - (min - r);
		}
		if (max < r) {
			min = max;
			max = r + (r - max);
		}

		int proximity = 0;
		int direction = -1;
		if (r % 2 != 0)
			r--;
		Integer i;
		while (proximity < r) {
			i = Integer.valueOf( r + proximity * direction );
			if (!rowsUsed.containsKey(i)) {
				rowsUsed.put(i, i);
				reserveRow(connection, i);
				return i.intValue();
			}
			int j = i.intValue();
			if (j <= min)
				return j + 2;
			if (j >= max)
				return j - 2;
			if (direction == 1)
				direction = -1;
			else {
				direction = 1;
				proximity += 2;
			}
		}
		return r;
	}

	protected Ray getStartDirection(Connection conn) {
		ConnectionAnchor anchor = conn.getSourceAnchor();
		Point p = getStartPoint(conn);
		Rectangle rect;
		if (anchor.getOwner() == null)
			rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
		else {
			rect = conn.getSourceAnchor().getOwner().getBounds().getCopy();
			conn.getSourceAnchor().getOwner().translateToAbsolute(rect);
		}
		return getDirection(rect, p);
	}

	protected void processPositions(Ray start, Ray end, List positions, 
						  			boolean horizontal, Connection conn) {
		removeReservedLines(conn);

		int pos[] = new int[positions.size() + 2];
		if (horizontal)
			pos[0] = start.x;
		else
			pos[0] = start.y;
		int i;
		for (i = 0; i < positions.size(); i++) {
			pos[i + 1] = ((Integer)positions.get(i)).intValue();
		}
		if (horizontal == (positions.size() % 2 != 0))
			pos[++i] = end.x;
		else
			pos[++i] = end.y;

		PointList points = new PointList();
		points.addPoint(new Point(start.x, start.y));
		Point p;
		int current, prev, min, max;
		boolean adjust;
		for (i = 2; i < pos.length - 1; i++) {
			horizontal = !horizontal;
			prev = pos[i - 1];
			current = pos[i];

			adjust = (i != pos.length - 2);
			if (horizontal) {
				if (adjust) {
					min = pos[i - 2];
					max = pos[i + 2];
					pos[i] = current = getRowNear(conn, current, min, max);
				}
				p = new Point(prev, current);
			} else {
				if (adjust) {
					min = pos[i - 2];
					max = pos[i + 2];
					pos[i] = current = getColumnNear(conn, current, min, max);
				}
				p = new Point(current, prev);
			}
			points.addPoint(p);
		}
		points.addPoint(new Point(end.x, end.y));
		conn.setPoints(points);
	}

	/**
	 * @see ConnectionRouter#remove(Connection)
	 */
	@Override
	public void remove(Connection connection) {
		removeReservedLines(connection);
	}

	protected void removeReservedLines(Connection connection) {
		ReservedInfo rInfo = (ReservedInfo) reservedInfo.get(connection);
		if (rInfo == null) 
			return;
		
		for (int i = 0; i < rInfo.reservedRows.size(); i++) {
			rowsUsed.remove(rInfo.reservedRows.get(i));
		}
		for (int i = 0; i < rInfo.reservedCols.size(); i++) {
			colsUsed.remove(rInfo.reservedCols.get(i));
		}
		reservedInfo.remove(connection);
	}

	protected void reserveColumn(Connection connection, Integer column) {
		ReservedInfo info = (ReservedInfo) reservedInfo.get(connection);
		if (info == null) {
			info = new ReservedInfo();
			reservedInfo.put(connection, info);
		}
		info.reservedCols.add(column);
	}

	protected void reserveRow(Connection connection, Integer row) {
		ReservedInfo info = (ReservedInfo) reservedInfo.get(connection);
		if (info == null) {
			info = new ReservedInfo();
			reservedInfo.put(connection, info);
		}
		info.reservedRows.add(row);
	}

	/**
	 * @see ConnectionRouter#route(Connection)
	 */
	public void route(Connection conn) {
		if ((conn.getSourceAnchor() == null) || (conn.getTargetAnchor() == null)) 
			return;
		int i;
		Point startPoint = getStartPoint(conn);
		conn.translateToRelative(startPoint);
		Point endPoint = getEndPoint(conn);
		conn.translateToRelative(endPoint);

		Ray start = new Ray(startPoint);
		Ray end = new Ray(endPoint);
		Ray average = start.getAveraged(end);

		Ray direction = new Ray(start, end);
		
		Ray startNormal = null, endNormal = null;
		
		if(prefEndDirection != null && prefStartDirection != null){
			startNormal = prefStartDirection;
			endNormal = prefEndDirection;
		}else{
			startNormal = getStartDirection(conn);
			endNormal   = getEndDirection(conn);
		}
		

		List positions = new ArrayList(5);
		boolean horizontal = startNormal.isHorizontal();
		if (horizontal) 
			positions.add(new Integer(start.y));
		else
			positions.add(new Integer(start.x));
		horizontal = !horizontal;

		if (startNormal.dotProduct(endNormal) == 0) {
			if ((startNormal.dotProduct(direction) >= 0) 
				&& (endNormal.dotProduct(direction) <= 0)) {
				// 0
			} else {
				// 2
				if (startNormal.dotProduct(direction) < 0)
					i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
				else {
					if (horizontal) 
						i = average.y;
					else 
						i = average.x;
				}
				positions.add(new Integer(i));
				horizontal = !horizontal;

				if (endNormal.dotProduct(direction) > 0)
					i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
				else {
					if (horizontal) 
						i = average.y;
					else 
						i = average.x;
				}
				positions.add(new Integer(i));
				horizontal = !horizontal;
			}
		} else {
			if (startNormal.dotProduct(endNormal) > 0) {
				//1
				if (startNormal.dotProduct(direction) >= 0)
					i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
				else
					i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
				positions.add(new Integer(i));
				horizontal = !horizontal;
			} else {
				//3 or 1
				if (startNormal.dotProduct(direction) < 0) {
					i = startNormal.similarity(start.getAdded(startNormal.getScaled(10)));
					positions.add(new Integer(i));
					horizontal = !horizontal;
				}

				if (horizontal) 
					i = average.y;
				else 
					i = average.x;
				positions.add( Integer.valueOf( i ));
				horizontal = !horizontal;

				if (startNormal.dotProduct(direction) < 0) {
					i = endNormal.similarity(end.getAdded(endNormal.getScaled(10)));
					positions.add( Integer.valueOf( i ));
					horizontal = !horizontal;
				}
			}
		}
		if (horizontal) 
			positions.add( Integer.valueOf( end.y ));
		else 
			positions.add( Integer.valueOf( end.x ));
		
		processPositions(start, end, positions, startNormal.isHorizontal(), conn);
	}

	public void setPrefStartDirection(Ray prefStartDirection) {
		this.prefStartDirection = prefStartDirection;
	}

	public void setPrefEndDirection(Ray prefEndDirection) {
		this.prefEndDirection = prefEndDirection;
		
	}

	
}
