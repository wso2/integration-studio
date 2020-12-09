/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.figures;

/**
 * This is a hack to get the vertical connection lines perfectly
 * straight. Relies on assumption
 * that vertical lines are sometimes crooked by 1 pixel depending
 * on the magnification.
 */
public class ConnectionCoordHistory {
	private static ConnectionCoordHistory instance;

	// x-coord of 1st anchor in aligned vertical parts
	private static int firstX = 0;	
	
	// y-coord of 1st anchor in aligned horizontal parts
	private static int firstY = 0;	
	
	private ConnectionCoordHistory(){}		
	
	public static ConnectionCoordHistory getInstance() {
		if (instance == null)  instance = new ConnectionCoordHistory();
		return instance;
	}	
	
	public int adjustX(int x){
		if (firstX ==0 ){
			firstX = x;
			return x;			
		}else if (Math.abs(firstX - x) > 2){
			/* assume any anchor point outside 2px of firstX means
			 * that the anchor is at the start of a new container
			 */
			firstX = x;
			return x;			
		}
		return firstX;
	}
	
	public int adjustY(int y){
		if (firstY ==0 ){
			firstY = y;
			return y;			
		}else if (Math.abs(firstY - y) > 2){
			/* assume any anchor point outside 2px of firstY means
			 * that the anchor is at the start of a new container
			 */
			firstY = y;
			return y;			
		}
		return firstY;
	}
}
