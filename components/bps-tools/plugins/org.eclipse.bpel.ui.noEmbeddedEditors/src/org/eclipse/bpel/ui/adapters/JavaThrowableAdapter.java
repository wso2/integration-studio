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

import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.swt.graphics.Image;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 10, 2007
 *
 */

public class JavaThrowableAdapter extends AbstractAdapter implements 
		ILabeledElement
{

	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLabel(java.lang.Object)
	 */
	public String getLabel (Object object) {
		
		for(Throwable t = getTarget(object,Throwable.class); t != null; t = t.getCause() ) {
			String result = t.getLocalizedMessage();
			if (result != null && result.length() > 0) {
				return result;
			}
		}
		return null;
	}

    /**
     * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
     */
    public String getTypeLabel(Object object) {
        return object.getClass().getSimpleName();
    }

    /**
     * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
     */
    public Image getSmallImage(Object object) {
        return  BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_EXCEPTION_16);
    }

    /**
     *  
     * Get the large image ...
     * 
     * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
     */
    public Image getLargeImage(Object object) {
        return null;
    }
}
