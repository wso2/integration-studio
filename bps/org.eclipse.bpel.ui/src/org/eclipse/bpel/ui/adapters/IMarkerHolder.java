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
package org.eclipse.bpel.ui.adapters;

import org.eclipse.core.resources.IMarker;

/**
 * IMarkerHolder provides access to markers attached to model objects.
 * 
 * generate the refId according to the following rule:
 *    The marker strategy for BPEL objects is as follows:
 * 		 		"activity:activityId"
 *              "variable:variableName"
 *				"correlationSet:correlationSetName"
 *				"partnerLink:partnerName"
 *				"link:sourceActivityId.linkName"
 *				"case:switchActivityId.caseIndex"
 *				"onMessage:pickActivityId.onMessageIndex"
 *				"process:"
 *
 */
public interface IMarkerHolder {
	/**
	 * 
	 * Return an array of all markers attached to the given model object.
	 * @param object the object (model object)
	 * 
	 * @return the markers it holds on to. 
	 */
	public IMarker[] getMarkers (Object object) ;
}
