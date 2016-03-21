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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.util.ElementFactory;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.w3c.dom.Element;

/**
 * An IContainer implementation for containers of a single Activity (such as While and
 * ElseIf and RepeatUntil).  This container will actually allow multiple children, and will manage the
 * necessary implicit sequence without directly exposing it to the code above.
 */
public class ActivityContainer extends ReferenceContainer {

	/**
	 * Brand new shiny ImplicitSequenceContainer 
	 * @param aFeature
	 */
	public ActivityContainer(EReference aFeature) {
		super(aFeature);
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer#addChild(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean addChild (EObject object, EObject newChild, EObject insertBefore) {
		
		Object currentChild = getSingleChild (object);		

		/** No activity, just set the current activity as the new child */
		if (currentChild == null) {
			// adding first child.
			// For a single child container, insertBefore can't be valid
			setSingleChild(object, newChild);
			return true;
		}
		
		if (currentChild instanceof Sequence) {
			
			Sequence sequence = (Sequence) currentChild;
			if (insertBefore == null) {
				sequence.getActivities().add( (Activity) newChild );
			} else {
				sequence.getActivities().add(0, (Activity)newChild);
			}						
		} else {				
			// already have one child, adding a 2nd one.  poof up a sequence.
			BPELEditor bpelEditor = ModelHelper.getBPELEditor(object);
			
			Sequence sequence = BPELFactory.eINSTANCE.createSequence();
			Element childElement = ElementFactory.getInstance().createElement(sequence, object);
			sequence.setElement(childElement);
			
			sequence.setName(BPELUtil.getUniqueModelName(bpelEditor.getProcess(), 
					Messages.BPELUtil_Sequence_1, Collections.singletonList(sequence)));			
			
//			Object originalChild = getSingleChild(object);
//			Node parentNode = null;
//			if (originalChild instanceof ExtensibleElement) {
//				ExtensibleElement child = (ExtensibleElement) originalChild;
//				parentNode = child.getElement().getParentNode();
////				removeChild(object, child);
//			}		
			
			// NOTE: its important that the implicit sequence be added to the model
			// *before* we insert the other children in it.  Otherwise Undo/Redo
			// will not be able to correctly handle changes to the parentage of
			// those children.			
//			if (parentNode != null) {
//				parentNode.appendChild(childElement);
//			}					
			
			setSingleChild(object, sequence);
			
			if (insertBefore==currentChild) {
				sequence.getActivities().add( (Activity) newChild);
			}			
			sequence.getActivities().add( (Activity)currentChild);
			if (insertBefore != currentChild) {
				sequence.getActivities().add((Activity) newChild);
			}
			
		}
		
		
		return true;
	}
	
	/** 
	 * @param object 
	 * @param child 
	 * @param insertBefore 
	 * @return if we can add this object
	 * @see org.eclipse.bpel.ui.adapters.IContainer#canAddObject(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean canAddObject (EObject object, EObject child, EObject insertBefore) {		
		return child != null && child instanceof Activity;
	}

}
