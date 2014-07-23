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
package org.eclipse.bpel.common.ui.editmodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;

/**
 * The ResourceInfo, which is a reference count cache to a model,
 * will call the model update listeners when the model
 * is deleted, reloaded, moved, or its dirty state is changed. 
 */
public interface IEditModelListener {
		
	/**
	 * The model has been deleted. All cached references to the model
	 * should be deleted.
	 * 
	 * If this is model the primary model and the editor is not dirty,
	 * the editor should be closed. If this is a secondary model,
	 * the editor may not need to be closed.
	 *  
	 * @param resourceInfo the resource info
	 */
	public void modelDeleted (ResourceInfo resourceInfo);
	
	/**
	 * The model was changed outside this framework and reloaded
	 * by the edit model framework. It may be needed to refresh visuals.
	 * @param resourceInfo the resource info
	 */
	
	public void modelReloaded (ResourceInfo resourceInfo);
	
	/**
	 * The model file was moved from its location. All references
	 * to this file should be updated.
	 * 
	 * @param resourceInfo 
	 * @param movedToFile 
	 */
	
	public void modelLocationChanged (ResourceInfo resourceInfo,IFile movedToFile);
	
	/**
	 * The model dirty state was changed.
	 * @param resourceInfo 
	 */
	
	public void modelDirtyStateChanged (ResourceInfo resourceInfo);
	
	/**
	 * Notifies that markers have changed on the resource info.
	 * 
	 * @param resourceInfo
	 * @param markerDelta 
	 */
	
	public void modelMarkersChanged ( ResourceInfo resourceInfo , IMarkerDelta [] markerDelta );

}