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

/**
 * This interface should be implemented by EditParts which now how to react if 
 * a switch of layout orientation occurs.
 * @author ascharf
 *
 */
public interface ILayoutAware {

	/**
	 * Switches the layout to the new orientation. All necessary things to fulfill
	 * the switch has to be done here, e.g. setting the layout managers orientation,
	 * adding/removing border and stuff like that. 
	 * @param horizontal
	 */
	void switchLayout(boolean horizontal);
	
}
