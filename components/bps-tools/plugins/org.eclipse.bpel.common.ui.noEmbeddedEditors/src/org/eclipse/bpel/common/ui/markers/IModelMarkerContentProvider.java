/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.markers;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;

public interface IModelMarkerContentProvider {

    /**
     * Returns the text associated with this marker.
     * 
     * @param marker
     * @return String
     */
    String getText(IMarker marker);
    
    /**
     * Returns the image associated with this marker.
     * 
     * The implementor is responsible for disposing of the image resource.
     * 
     * @param marker
     * @return Image
     */
    Image getImage(IMarker marker);
    
}
