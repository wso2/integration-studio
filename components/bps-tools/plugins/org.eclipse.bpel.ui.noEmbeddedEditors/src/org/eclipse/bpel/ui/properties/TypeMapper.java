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

import org.eclipse.gef.EditPart;
import org.eclipse.ui.views.properties.tabbed.ITypeMapper;


public class TypeMapper implements ITypeMapper {

    public Class remapType(Object object, Class effectiveType) {
    	// We probably won't get any edit parts here, since now the
    	// editor provides model objects instead of edit parts as
    	// selection, but just to be safe.
        if (object instanceof EditPart) {
            object = ((EditPart)object).getModel();
        }
		return object.getClass();
    }

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ITypeMapper#mapType(java.lang.Object)
	 */
	public Class mapType(Object object) {
		
		if (object instanceof EditPart) {
            object = ((EditPart)object).getModel();
        }
		return object.getClass();		
	}
}
