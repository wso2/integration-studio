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

import org.eclipse.emf.ecore.EObject;

/**
 * Implemented by model adapters to support creation of the proper type of extension
 * object for that type of model object. 
 *
 * Note: You should not need to create extensions manually--extensions are created
 * automatically for objects when they are first inserted in the model.
 */
public interface IExtensionFactory {
	public EObject createExtension(EObject object);
}
