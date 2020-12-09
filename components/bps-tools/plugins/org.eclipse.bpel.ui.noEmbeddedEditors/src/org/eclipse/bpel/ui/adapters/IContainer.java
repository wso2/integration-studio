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
 * An IContainer is an element that has one or more children in an ordered
 * list.
 * 
 * @param <T> 
 */

public interface IContainer<T> {
	
	/**
	 * Return an ordered list of all children of the container.
	 * The returned list may or may not be a copy of the list held
	 * by the model, and as such should be considered read-only.
	 * 
	 * @param object the parent container 
	 * @return the list of children	
	 */
	
	public List<T> getChildren(T object);
	
	/** 
	 * returns the next sibling in the list of children of this parent
	 * returns null if the object is a singular child and has no direct
	 * siblings.
	 *
	 * @param object the parent container
	 * @param child the child object 
	 * @return the next sibling object.
	
	 */
	
	public T getNextSiblingChild(T object, T child);
	
	/**
	 * Adds the given child to the container before the object insertBefore.  If insertBefore
	 * is null, or if insertBefore is invalid (i.e. not a child in the container), the object
	 * should be inserted at the end of the list.
	 * 
	 * NOTE: some implementors may impose restrictions on where a certain child may appear
	 * within the total ordering; for example, a Process might require all Partners to
	 * appear before Containers, etc.  These implementors should add the child as close to
	 * the requested position as possible.  e.g. inserting a Container after a Partner might
	 * cause the insertion to occur between the last Partner and the first Container.
	 * 
	 * Returns true if the child is added successfully, otherwise false.
	 * 
	 * @param object the parent container
	 * @param child the child object
	 * @param insertBefore the reference point for insertion
	 * @return true if added, false otherwise.
	 * 
	 */
	public boolean addChild(T object, T child, T insertBefore);
	
	/** 
	 * this method allows us to test if we can actually add the object to the container
	 * at the specified location
	 * 
	 * for this function to be more useful, always try to pass a value for the
	 * insertBefore so we can do addition validity checks
	 * 
	 * @param object the parent container
	 * @param child the child object
	 * @param insertBefore the reference point for insertion
	 * @return true if can be added, false otherwise.
	 */
	
	public boolean canAddObject(T object, T child, T insertBefore);

	/**
	 * Answer if the child can be removed from the parent container.
	 * 
	 * @param object the parent container
	 * @param child the child object
	 * @return true if can be removed, false otherwise.
	 */
	
	public boolean canRemoveChild (T object, T child);
	
	/**
	 * Removes the given child from the container.
	 * 
	 * Returns true if the child is removed successfully, otherwise false.
	 * @param object the parent container
	 * @param child the child object
	 * @return true if removed, false otherwise.
	 */
	
	public boolean removeChild(T object, T child); 

	/**
	 * Replace the old child with the new child. In the case of ordered
	 * containers, this must insert the new child at the same index as
	 * the old child and return a Token which can be passed to the undo()/redo() methods.
	 * 
	 * Returns true if the child is replaced successfully, otherwise false.
	 * 
	 * @param object the parent container
	 * @param oldChild the old child object
	 * @param newChild the new child object
	 * @return true if removed, false otherwise.
	 */
	public boolean replaceChild(T object, T oldChild, T newChild);
	
}
