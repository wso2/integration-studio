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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.ui.details.providers.DetailsLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;


/**
 * Workaround for reusing the existing DetailsLabelProvider with
 * the properties framework. This class is referenced in the plugin.xml.
 */
public class PropertiesLabelProvider extends DetailsLabelProvider {

	private static PropertiesLabelProvider instance;
	
    public static PropertiesLabelProvider getInstance() {
    	if (instance == null) {
    		instance = new PropertiesLabelProvider();
    	}
    	return instance;
    }
    
    @Override
	public Image getImage(Object model) {
        model = remap(model);
        return super.getImage(model);
    }

    @Override
	public String getText(Object model) {
        model = remap(model);
        return super.getText(model);
    }

    protected Object remap(Object model) {
        if (model instanceof IStructuredSelection) {
            Object element = ((IStructuredSelection)model).getFirstElement();
            return element;
        }
        return model; //default
    }
}
