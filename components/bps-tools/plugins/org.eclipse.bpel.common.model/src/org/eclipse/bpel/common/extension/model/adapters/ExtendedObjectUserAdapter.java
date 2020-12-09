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
package org.eclipse.bpel.common.extension.model.adapters;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.emf.common.notify.Adapter;


/**
 * This adapter provides an easy way to get to an Extension object.  It is
 * created when an EObject is extended or its Extension is retrieved from the
 * ExtensionMap.
 * @custom
 */
public interface ExtendedObjectUserAdapter extends Adapter {
	
	/**
	 * Method getNamespace 
	 * Returns the namesapce of the ExtensionMap that associated this adapter.
	 * @return String
	 */
	String getNamespace();
	
	/**
	 * Sets the ExtensionMap.
	 * @param extensionMap
	 */
	void setExtensionMap(ExtensionMap extensionMap);

	/**
	 * Gets the extension object extending the extendedObject.
	 * @return extensionObject
	 */
	Object get(Object extendedObject);
	
}
