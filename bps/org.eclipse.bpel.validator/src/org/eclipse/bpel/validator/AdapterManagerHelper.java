/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator;


import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 17, 2007
 *
 */
public class AdapterManagerHelper {

	private IAdapterManager fAdapterManager;
	
	static private AdapterManagerHelper singleton = new AdapterManagerHelper ();
		
	@SuppressWarnings("restriction")
	private AdapterManagerHelper () {
		if (Platform.isRunning()) {
			fAdapterManager = Platform.getAdapterManager();
		} else {
			fAdapterManager = org.eclipse.core.internal.runtime.AdapterManager.getDefault();
		}		
	}
	
	
	/**
	 * Return the adapter manager.
	 * 
	 * @return Return the adapter manager.
	 */
	
	static public IAdapterManager getAdapterManager () {
		return singleton.fAdapterManager ;
	}
	
}
