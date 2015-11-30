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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * An abstract IContainer implementation for containers composed of one or more Lists
 * of children in a particular relative order.
 * 
 * NOTE: insertBefore references across all sub-containers are valid, but child objects
 * are constrained to be in the proper list.
 */
public class MultiContainer extends AbstractContainer {

	boolean allowMixedTypeReplace = false;

	protected List<AbstractContainer> fContainers = new ArrayList<AbstractContainer>();
	
	/**
	 * Add the container.
	 * @param container
	 */
	public void add (AbstractContainer container) { 
		fContainers.add(container); 
	}

	/**
	 * Return the sub container for the given container.
	 * 
	 * @param object the container object
	 * @param child the child objects
	 * 
	 * @return the sub container for the child
	 * 
	 */

	public final AbstractContainer getSubContainer(EObject object, Object child) {
		
		if (child instanceof EObject == false) {
			return null;
		}
		for(AbstractContainer sub : fContainers) {
			if (sub.isValidChild(object, (EObject)child)) {
				return sub;
			}
		}
		return null;
	}
	
	@Override
	protected final boolean isValidChild(EObject object, EObject child) {
		return getSubContainer(object, child) != null;
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IContainer#addChild(java.lang.Object, java.lang.Object, java.lang.Object)
	 */	
	public boolean addChild(EObject object, EObject child, EObject insertBefore) {
		
		AbstractContainer childContainer = getSubContainer(object, child);
		if (insertBefore == null) {
			/** This happens during copy/paste operations */
			if (childContainer == null) {
				return false;
			}
			return childContainer.addChild(object, child, null);
		}
		
		AbstractContainer insertBeforeContainer = getSubContainer(object, insertBefore);
		if (childContainer == insertBeforeContainer) {
			return childContainer.addChild(object, child, insertBefore);
		}
		
		// Child either belongs at the beginning of its sub-container, or the end.
		// Which sub-container comes first?
		int childRange = 0;
		int insertBeforeRange = 0;
		Object[] containers = fContainers.toArray();
		for (int i = 0; i<containers.length; i++) {
			if (containers[i] == childContainer)  childRange = i;
			if (containers[i] == insertBeforeContainer)  insertBeforeRange = i;
		}
		if (childRange > insertBeforeRange) {
			// child should go at beginning of sub-container.
			List<EObject> children = childContainer.getChildren(object);
			if (children.size() > 0) {
				return childContainer.addChild(object, child, children.get(0));
			}
		}
		// put child at end of sub-container.
		return childContainer.addChild(object, child, null); 
	}

	/**
	 * @param object 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#getChildren(java.lang.Object)
	 */
	
	public List<EObject> getChildren(EObject object) {
		
		List<EObject> result = new ArrayList<EObject>();
		for (AbstractContainer container : fContainers) {
			result.addAll( container.getChildren( object ) ) ;
		}
		if (result.isEmpty()) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(result);
	}

	
	/**
	 * @see org.eclipse.bpel.ui.adapters.IContainer#removeChild(java.lang.Object, java.lang.Object)
	 */
	
	public boolean removeChild(EObject object, EObject child) {
		return getSubContainer(object, child).removeChild(object, child);
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IContainer#replaceChild(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public boolean replaceChild(EObject object, EObject oldChild,	EObject newChild) 
	{
		AbstractContainer oldSubContainer = getSubContainer(object, oldChild);
		AbstractContainer newSubContainer = getSubContainer(object, newChild);
		if (oldSubContainer == newSubContainer) {
			return oldSubContainer.replaceChild(object, oldChild, newChild);
		}
		// the elements are in different subContainers.
		if (!allowMixedTypeReplace)  {
			return false;
		}
		return replaceMixedTypeChild(object, oldChild, newChild);		
	}

	// subclasses might want to override this to check types (e.g. to return null instead)
	protected boolean replaceMixedTypeChild(EObject object, EObject oldChild,
		EObject newChild)
	{
		AbstractContainer oldSubContainer = getSubContainer(object, oldChild);
		AbstractContainer newSubContainer = getSubContainer(object, newChild);

		oldSubContainer.removeChild(object, oldChild);
		newSubContainer.addChild(object, newChild, null);
		return true;
	}

	
	/**
	 * @see org.eclipse.bpel.ui.adapters.delegates.AbstractContainer#canAddObject(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	
	@Override
	public boolean canAddObject (EObject object, EObject child, EObject insertBefore) {
		AbstractContainer ac = getSubContainer(object, child);
		return (ac == null)? false : ac.canAddObject(object, child, insertBefore);
	}

	/**
	 * @param object 
	 * @param child 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#canRemoveChild(java.lang.Object, java.lang.Object)
	 */
	
	public boolean canRemoveChild(EObject object, EObject child) {
		AbstractContainer ac = getSubContainer(object, child);
		return (ac == null)? false : ac.canRemoveChild( object, child );
	}	
	
}
