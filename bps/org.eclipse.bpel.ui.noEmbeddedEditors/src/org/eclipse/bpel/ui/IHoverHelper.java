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
package org.eclipse.bpel.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;

/**
 * The hover helper is used to provide hover help for model objects.
 * It is an interface that can be implemented by extension points.
 * 
 * @author IBM 
 */


public interface IHoverHelper {
	/**
	 * Return a figure which will be used as the hover help figure for the
	 * specified model object.
	 * 
	 * @param modelObject  The model object to create hover help for
	 * @return a figure which will be displayed in the hover tool-tip window
	 */
	public IFigure getHoverFigure (EObject modelObject);
	
	/**
	 * Return a string which will be used as the hover-help for the
	 * specified marker.
	 * 
	 * @param marker  The marker which the user is hovering over
	 * @return a string which will be displayed in the tool-tip window
	 */
	public String getHoverHelp(IMarker marker);
}
