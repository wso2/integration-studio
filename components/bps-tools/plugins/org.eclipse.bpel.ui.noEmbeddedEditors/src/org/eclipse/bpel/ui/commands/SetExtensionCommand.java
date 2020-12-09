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
package org.eclipse.bpel.ui.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.ExtensibleElement;

/** 
 * Sets an extension property of a model object.  E.g. BPEL+ uses extensions to
 * add properties to existing BPEL model types.
 * 
 * Similarly to SetCommand, subclasses need to implement get() and set() in terms
 * of the particular extension property they set.  They must also implement
 * createExtension() to create an extension of the proper type, and
 * isTargetExtensionUnused() to determine if the extension contains no meaningful
 * information.
 * 
 * Using these methods, SetExtensionCommand will automatically create the extension
 * when it doesn't exist (removing it again on undo).  It will also remove extensions
 * which become unused (restoring them on undo).
 * 
 * Lastly, SetExtensionCommand touches the target model object's extension list as
 * part of every operation (even if it doesn't add or remove the extension), so that
 * Adapters listening to the target model object are notified.  Avoiding the need to
 * listen to the specific extension is helpful because the lifetimes of the extension
 * objects themselves vary depending on the values stored in them.
 */
public abstract class SetExtensionCommand extends SetCommand {

	protected ExtensibilityElement oldExt, newExt;
	protected ExtensibilityElement targetExt;
	protected EClass extClass;

	public SetExtensionCommand(EObject target, EClass extClass, Object newValue)  {
		super(target, newValue);
		this.extClass = extClass;
	}

	public ExtensibilityElement createExtension() {
		return (ExtensibilityElement)extClass.getEPackage().getEFactoryInstance().create(extClass);
	}
	
	/**
	 * Returns true if the extension object is currently meaningless and should be
	 * removed.  The default behaviour is to return true iff all properties (except
	 * for internal ExtensionImpl properties) have their default values. 
	 */
	public boolean isTargetExtensionUnused() {
		for (Iterator it = targetExt.eClass().getEAllStructuralFeatures().iterator(); it.hasNext(); ) {
			EStructuralFeature feature = (EStructuralFeature)it.next();

			// TODO: this is a hack!  there must be a better way
			if (feature.isTransient() && "elementType".equals(feature.getName())) continue; //$NON-NLS-1$
			
			Object defaultValue = feature.getDefaultValue();
			if (defaultValue == null) {
				if (targetExt.eGet(feature) != null) return false;
			} else {
				if (!defaultValue.equals(targetExt.eGet(feature))) return false;
			}
		}
		return true;
	}

	@Override
	public void doExecute() {
		targetExt = oldExt = ModelHelper.getExtensibilityElement(fTarget, extClass);
		if (targetExt != null)  {
			fOldValue = get();
		}

		targetExt = newExt = (oldExt==null)? createExtension() : oldExt;

		// Cause a touch *before* the set as well as after...
		// necessary for automatic undo/redo to work correctly here.
		List eeList = ((ExtensibleElement)fTarget).getEExtensibilityElements();
		if (newExt == oldExt) {
			// NOTE: the following line deliberately causes a touch in the containing
			// object.  This reduces the need for everybody to put adapters on the
			// extension objects (having them on the extended object usually suffices).
			if (oldExt != null)  eeList.set(eeList.indexOf(oldExt), newExt);
		}
				
		if (targetExt != null)  {
			set(fNewValue);
		}
		
		if (isTargetExtensionUnused()) newExt = null;

		if (newExt == oldExt) {
			// NOTE: the following line deliberately causes a touch in the containing
			// object.  This reduces the need for everybody to put adapters on the
			// extension objects (having them on the extended object usually suffices).
			if (oldExt != null)  eeList.set(eeList.indexOf(oldExt), newExt);
		} else {
			if (oldExt != null)  eeList.remove(oldExt);
			if (newExt != null)  eeList.add(newExt);
		}
	}
}
