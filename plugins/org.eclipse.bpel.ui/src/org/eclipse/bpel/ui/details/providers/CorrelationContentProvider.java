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

import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.ui.util.ModelHelper;


public class CorrelationContentProvider extends AbstractContentProvider {

	@Override
	public void collectElements (Object input, List list) {
		try {
			Correlations c = ModelHelper.getCorrelations(input);
			if (c != null) {
				list.addAll( c.getChildren() );
			}		
		} catch (IllegalArgumentException e) {
			// 
		}		
	}
	
}
