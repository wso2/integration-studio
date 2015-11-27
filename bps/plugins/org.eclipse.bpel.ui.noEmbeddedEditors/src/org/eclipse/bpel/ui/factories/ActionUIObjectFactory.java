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
package org.eclipse.bpel.ui.factories;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;


public class ActionUIObjectFactory extends AbstractUIObjectFactory {

    protected AbstractBPELAction action;
    
    public ActionUIObjectFactory(AbstractBPELAction action) {
        super();
        this.action = action;
    }

    @Override
	public EClass getModelType() {
        return action.getModelType();
    }

    @Override
	public ImageDescriptor getSmallImageDescriptor() {
        return action.getSmallImageDescriptor();
    }

    @Override
	public ImageDescriptor getLargeImageDescriptor() {
        return action.getLargeImageDescriptor();
    }

    // helper method
    protected Image getImage(String key, ImageDescriptor descriptor) {
        ImageRegistry registry = BPELUIPlugin.INSTANCE.getImageRegistry();
        Image result = registry.get(key);
        if (result == null) {
            result = descriptor.createImage();
            registry.put(key, result);
        }
        return result;
    }

    @Override
	public Image getSmallImage() {
        String key = getUniqueIdString() + "#SmallImage"; //$NON-NLS-1$
        return getImage(key, getSmallImageDescriptor());
    }

    @Override
	public Image getLargeImage() {
        String key = getUniqueIdString() + "#LargeImage"; //$NON-NLS-1$
        return getImage(key, getLargeImageDescriptor());
    }

    @Override
	public String getTypeLabel() {
        return action.getLabel();
    }

    /**
     * The parent parameter is not used here but might be useful for subclasses.
     * It is intended to be used as a hint to where the new model object will
     * be created.
     */
    public EObject createInstance(EObject parent) {
        CreationFactory factory = action.getCreationFactory();
        if (factory != null) return (EObject) factory.getNewObject();
        return super.createInstance(); // default
    }

    @Override
	public EObject createInstance() {
    	return createInstance(null);
    }
}
