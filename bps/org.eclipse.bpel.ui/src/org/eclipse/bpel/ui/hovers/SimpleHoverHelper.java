/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.hovers;

import org.eclipse.bpel.common.ui.markers.ModelMarkerUtil;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 22, 2007
 *
 */
public class SimpleHoverHelper implements IHoverHelper {

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.IHoverHelper#getHoverFigure(org.eclipse.emf.ecore.EObject)
	 */
	public IFigure getHoverFigure (EObject modelObject) {
		
		IHoverHelper delegate  = BPELUtil.adapt(modelObject, IHoverHelper.class);
		if (delegate != null) {
			return delegate.getHoverFigure(modelObject);
		}
		return null;
	}

	
	/**
	 * @see org.eclipse.bpel.ui.IHoverHelper#getHoverHelp(org.eclipse.core.resources.IMarker)
	 */
		
	public String getHoverHelp (IMarker marker) {		
		return ModelMarkerUtil.getText(marker);		
	}

}
