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
package org.eclipse.bpel.ui.adapters.delegates;


import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.emf.ecore.EObject;


/**
 * Common base class for IContainer implementations.
 * 
 * Implementors of IContainer can use this class to simplify implementation.  They
 * also might want to subclass this if they plan to interact with the Actions returned
 * by other subclasses of AbstractContainer.
 */
public abstract class AbstractContainer implements IContainer<EObject> {

	protected abstract boolean isValidChild(EObject object, EObject child);

	/** 
	 * @param object 
	 * @param child 
	 * @param insertBefore 
	 * @return if we can add this object
	 * @see org.eclipse.bpel.ui.adapters.IContainer#canAddObject(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public boolean canAddObject (EObject object, EObject child, EObject insertBefore) {		
		return isValidChild (object, child);
	}

	/**
	 * @param object 
	 * @param child 
	 * @return next sibling child.
	 * @see org.eclipse.bpel.ui.adapters.IContainer#getNextSiblingChild(java.lang.Object, java.lang.Object)
	 */
	
	public final EObject getNextSiblingChild (EObject object, EObject child) {
		
		boolean bNext = false;
		for(EObject next : getChildren(object)) {
			if (next == child) {
				bNext = true;
			} else if (bNext) {
				return next;
			}
		}
		return null;
	}
}
