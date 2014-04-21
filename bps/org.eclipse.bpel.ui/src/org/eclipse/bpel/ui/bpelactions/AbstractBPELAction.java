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
package org.eclipse.bpel.ui.bpelactions;

import org.eclipse.bpel.ui.commands.ReplaceInContainerCommand;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.BPELUIObjectFactory;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;


public abstract class AbstractBPELAction {

    public abstract EClass getModelType();

    public abstract String getLabel();

    public abstract String getDescription();
    
    /**
     * Returns true if the given object is an instance
     * of this action.
     */
    public boolean isInstanceOf(Object target) {
        return ((EObject)target).eClass() == getModelType();
    }
    
    public AdapterFactory getAdapterFactory() {
        return null;
    }

    /**
     * The implemention of this method is optional. It should
     * be implemented if the new object instances need to be
     * initialized with specific values.
     */
    public CreationFactory getCreationFactory() {
        return null;
    }

	/**
	 * Return a small image representing the type of model object this factory creates
	 */
	public ImageDescriptor getSmallImageDescriptor() {
	    return BPELUIObjectFactory.getSmallImageDescriptor(getModelType());
	}

	/**
	 * Return a large image representing the type of model object this factory creates
	 */
	public ImageDescriptor getLargeImageDescriptor() {
	    return BPELUIObjectFactory.getLargeImageDescriptor(getModelType());
	}

    public AbstractUIObjectFactory getUIObjectFactory() {
        return UIObjectFactoryProvider.getInstance().getFactoryFor(getModelType());
    }
    
    public Command getChangeActionTypeCommand(Object parent, Object currentModel, Object newModel) {
        return new ReplaceInContainerCommand(parent, currentModel, newModel);
    }
}
