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
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

import org.eclipse.bpel.ui.util.BPELUtil;

/**
 * Content provider which expects a Compensate activity as input, and returns the
 * list of activities to which the Compensate can be applied.
 */
public class CompensableActivityContentProvider extends AbstractContentProvider {
	
	@Override
	public void collectElements (Object input, List list) {
		list.addAll( BPELUtil.getCompensableActivities(input) );
	}

}