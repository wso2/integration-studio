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
package org.eclipse.bpel.ui.details.providers;

import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.INamedElement;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * Label provider for the details area. Mainly used for updating
 * the details title.
 *
 * This implementation only keeps track of changes to one model
 * object only since it is currently not necessary for the details area
 * to keep track of more than one.
 */
public class DetailsLabelProvider extends LabelProvider {
	/**
	 * This is the model object we keep track of changes. This
	 * object is the last one passed as a parameter to getText().
	 */
	protected Object currentModelObject;
//	protected MultiObjectAdapter adapter;

	// TODO: this is a temp hack
	private Image currentImage;

	public DetailsLabelProvider() {
		super();
//		adapter = new MultiObjectAdapter() {
//			public void notify(Notification n) {
//				if (isDisplayNameAffected(n)) {
//					// creates an empty event - the event itself is not important only the notification
//					LabelProviderChangedEvent event = new LabelProviderChangedEvent(DetailsLabelProvider.this);
//					fireLabelProviderChanged(event);
//				}
//			}
//		};
	}

	@Override
	public Image getImage(Object model) {
		ILabeledElement element = BPELUtil.adapt(model, ILabeledElement.class);
		if (currentImage != null) {
			//currentImage.dispose();
		}
		currentImage = (element != null) ? element.getSmallImage(model) : null;
		return currentImage;
	}

	/**
	 * Parameter model has to be an EObject.
	 */
	@Override
	public String getText(Object model) {
		if (!(model instanceof EObject)) {
			return null;
		}
		hookListener((EObject) model);
		ILabeledElement element = BPELUtil.adapt(model, ILabeledElement.class);
		if (element != null) return element.getLabel(model);

		INamedElement namedElement = BPELUtil.adapt(model, INamedElement.class);
		return (namedElement != null) ? namedElement.getName(model) : null;
	}

	/**
	 * Listen to changes to the model object's name or label.
	 */
	protected void hookListener(EObject model) {
		if (model == currentModelObject) {
			return;
		}
		currentModelObject = model;
	}
}
