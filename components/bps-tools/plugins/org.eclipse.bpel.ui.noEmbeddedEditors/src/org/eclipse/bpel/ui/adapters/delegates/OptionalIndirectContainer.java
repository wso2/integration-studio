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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An IndirectContainer which can create the EObject which is the target of the
 * indirection when an object is first inserted, and discard it when the last object
 * is removed from the list.  This is useful (for example) in Scope.
 */
public class OptionalIndirectContainer extends IndirectContainer {

	public OptionalIndirectContainer(EReference feature, AbstractContainer innerContainer) {
		super(feature, innerContainer);
	}

	protected void createTarget(Object object) {
		EClass targetClass = fIndirectionFeature.getEReferenceType(); 
		EObject newTarget = targetClass.getEPackage().getEFactoryInstance().create(targetClass);
		((EObject)object).eSet(fIndirectionFeature, newTarget);
	}
	
	protected void discardTarget(Object object) {
		((EObject)object).eSet(fIndirectionFeature, null);
	}
	
	/* IContainer */
	
	@Override
	public boolean addChild(EObject object, EObject child, EObject insertBefore) {
		if (getTarget(object) == null) {
			createTarget(object);
			boolean result = super.addChild(object, child, insertBefore);
			if (getChildren(object).isEmpty()) discardTarget(object);
			return result;
		}
		return super.addChild(object, child, insertBefore);
	}
	
	@Override
	public boolean removeChild(EObject object, EObject child) {
		if (getTarget(object) == null) return false;
		boolean result = super.removeChild(object, child);
		if (getChildren(object).isEmpty()) discardTarget(object);
		return result;
	}
	
	@Override
	public boolean replaceChild(EObject object, EObject oldChild, EObject newChild) {
		if (getTarget(object) == null) return false;
		return super.replaceChild(object, oldChild, newChild);
	}
}
