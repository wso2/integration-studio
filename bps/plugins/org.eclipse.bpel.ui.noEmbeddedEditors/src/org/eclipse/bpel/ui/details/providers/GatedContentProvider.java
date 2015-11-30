/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

/**
 * This provider wraps another provider and is able to switch the provider on or off.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 18, 2006
 *
 */

public class GatedContentProvider extends AbstractContentProvider {

	boolean fEnabled = true;
	
	AbstractContentProvider fProvider;

	/**
	 * 
	 * @param provider
	 */
	public GatedContentProvider(AbstractContentProvider provider) {
		super();
		fProvider = provider;
	}

	public boolean isEnabled() {
		return fEnabled;
	}

	public void setEnabled(boolean enabled) {
		fEnabled = enabled;
	}
	
	
	@Override
	public void collectElements ( Object input, List list ) {
		if (fEnabled) {
			fProvider.collectElements(input, list);
		}
	}
	
	
	
	
	
}
