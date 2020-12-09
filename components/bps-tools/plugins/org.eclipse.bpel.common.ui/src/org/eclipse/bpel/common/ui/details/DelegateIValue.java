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
package org.eclipse.bpel.common.ui.details;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */
public class DelegateIValue implements IValue {
	
	protected IValue fDelegate;
	
	/**
	 * 
	 */
	public DelegateIValue () {
		fDelegate = null;
	}
	
	/**
	 * @param value
	 */
	public DelegateIValue ( IValue value ) {
		fDelegate = value;
	}
	
	/**
	 * @return the value in the delegate.
	 */
	public Object get () {
		return fDelegate != null ? fDelegate.get() : null ;		
	}
	
	/**
	 * @param object
	 */
	
	public void set (Object object) {
		if (fDelegate == null) {
			return ;
		}
		fDelegate.set(object);
	}
}
