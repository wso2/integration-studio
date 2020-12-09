/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.wsil.model.inspection.Link;
import org.eclipse.swt.graphics.Image;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */

public class WSILLinkAdapter extends AbstractAdapter 
	implements ILabeledElement 
{
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
	 */
	public Image getLargeImage(Object object) {
		return null;
	}	

	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
	 */
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_WSIL_LINK );	
	}	


	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
	 */
	public String getTypeLabel ( Object obj ) {
		return obj.getClass().getSimpleName();
	}
	
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLabel(java.lang.Object)
	 */
	public String getLabel ( Object obj  )
	{	
		Link link = getTarget(obj, Link.class);		
		if (link == null) {
			return getTypeLabel(obj);
		}
		return link.getLocation();
	}	
	
}