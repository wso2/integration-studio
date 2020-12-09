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

import java.util.List;

/**
 * Adapter for an Activity which supports IContainer.  This class forwards
 * the IContainer methods to a delegate which subclasses should supply.
 */
public abstract class ContainerActivityAdapter extends ActivityAdapter implements IContainer {

	IContainer containerDelegate = null;
	
	protected final IContainer getContainerDelegate(Object object) {
		if (containerDelegate == null) containerDelegate = createContainerDelegate();
		return containerDelegate;
	}
	
	/**
	 * Subclasses must override this to create the actual IContainer
	 * implementation.  This method should not return null.
	 */
	protected abstract IContainer createContainerDelegate();
	
	/* IContainer */

	public boolean addChild(Object object, Object child, Object insertBefore) {
		return getContainerDelegate(object).addChild(object, child, insertBefore);
	}
	public List getChildren(Object object) {
		return getContainerDelegate(object).getChildren(object);
	}
	public boolean removeChild(Object object, Object child) {
		return getContainerDelegate(object).removeChild(object, child);
	}
	public boolean replaceChild(Object object, Object oldChild, Object newChild) {
		return getContainerDelegate(object).replaceChild(object, oldChild, newChild);
	}
	public Object getNextSiblingChild(Object object, Object child) {
		return getContainerDelegate(object).getNextSiblingChild(object, child);
	}
	public boolean canAddObject(Object object, Object child, Object insertBefore) {
		return getContainerDelegate(object).canAddObject(object, child, insertBefore);
	}
	
	public boolean canRemoveChild (Object object, Object child) {
		return getContainerDelegate(object).canRemoveChild(object, child);
	}
}
