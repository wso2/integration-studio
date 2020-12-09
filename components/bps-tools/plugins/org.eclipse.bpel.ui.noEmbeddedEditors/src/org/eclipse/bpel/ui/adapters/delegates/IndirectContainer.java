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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A container which allows you to re-map the target object for other containers.
 * 
 * In particular, this class allows you to specify a single-valued EReference feature
 * and use the value read from that as the target object.
 */
public class IndirectContainer extends AbstractContainer {

	protected EReference fIndirectionFeature;
	protected AbstractContainer fInnerContainer;
	
	/**
	 * Brand new shiny IndirectContainer 
	 * @param feature
	 * @param innerContainer
	 */
	public IndirectContainer (EReference feature, AbstractContainer innerContainer) {
		if (feature.isMany()) throw new IllegalArgumentException();
		this.fIndirectionFeature = feature;
		this.fInnerContainer = innerContainer;
	}

	protected EObject getTarget(Object object) {
		return (EObject)((EObject)object).eGet(fIndirectionFeature);
	}
	
	// TODO: this is kind of a hack.  We shouldn't need to know it's an AbstractContainer :(
	
	@Override
	protected boolean isValidChild(EObject object, EObject child) {
		return fInnerContainer.isValidChild(object, child);
	}
	
	/**
	 * @param object 
	 * @param child 
	 * @param insertBefore 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#addChild(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	
	public boolean addChild(EObject object, EObject child, EObject insertBefore) {
		EObject target = getTarget(object);
		return (target == null)? false : fInnerContainer.addChild(target, child, insertBefore);
	}
	
	/**
	 * @param object 
	 * @return the list of children.
	 * @see org.eclipse.bpel.ui.adapters.IContainer#getChildren(java.lang.Object)
	 */
	
	public List<EObject> getChildren (EObject object) {
		EObject target = getTarget(object);
		if (target == null) {
			return Collections.emptyList();
		}
		return fInnerContainer.getChildren(target);
	}
	
	/**
	 * @param object 
	 * @param child 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#removeChild(java.lang.Object, java.lang.Object)
	 */
	
	public boolean removeChild(EObject object, EObject child) {
		EObject target = getTarget(object);
		if (target == null) {
			return false;
		}
		return fInnerContainer.removeChild(target, child);
	}
	
	/**
	 * @param object 
	 * @param oldChild 
	 * @param newChild 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#replaceChild(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public boolean replaceChild(EObject object, EObject oldChild, EObject newChild) {		
		EObject target = getTarget(object);
		if (target == null) {
			return false;			
		}
		return fInnerContainer.replaceChild(target, oldChild, newChild);
	}

	/**
	 * @param object 
	 * @param child 
	 * @return 
	 * @see org.eclipse.bpel.ui.adapters.IContainer#canRemoveChild(java.lang.Object, java.lang.Object)
	 */
	public boolean canRemoveChild (EObject object, EObject child) {
		EObject target = getTarget(object);
		if (target == null) {
			return false;
		}		
		return fInnerContainer.canRemoveChild(target, child);
	}
	
	
}
