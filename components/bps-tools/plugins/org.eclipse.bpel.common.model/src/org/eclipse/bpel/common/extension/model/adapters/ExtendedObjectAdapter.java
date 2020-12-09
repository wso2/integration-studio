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

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;


/**
 * This adapter provides an easy way to get to an Extension object.  It is
 * created when an EObject is extended or its Extension is retrieved from the
 * ExtensionMap.
 * @custom
 */
public interface ExtendedObjectAdapter extends Adapter {
	
	/**
	 * Returns the compExtension.
	 * Gets the Extension object extending the adapted EObject.
	 * @return ComponentExtension
	 */
	Extension getExtension();
	
	/**
	 * Returns the extension object.
	 * @return ComponentExtension
	 */
	EObject getExtensionObject();

	/**
	 * Sets the compExtension.
	 * Sets the Extension object extending the adapted EObject.
	 * @param compExtension The compExtension to set
	 */
	void setExtension(Extension extension);
	
	/**
	 * Method getNamespace 
	 * Returns the namesapce of the ExtensionMap that associated this adapter.
	 * @return String
	 */
	String getNamespace();
	
	/**
	 * Method setNamespace.
	 * Sets the namescpase for this adapter (which should correspond to the
	 * namespace of the ExtensionMap that associated this adapter).
	 * @param namespace
	 */
	void setNamespace(String namespace);
		
}
