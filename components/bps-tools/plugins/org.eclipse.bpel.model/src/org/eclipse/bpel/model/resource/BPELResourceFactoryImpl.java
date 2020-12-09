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
package org.eclipse.bpel.model.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class BPELResourceFactoryImpl extends XMIResourceFactoryImpl {
	/**
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl#createResource(URI)
	 */
	@Override
	public Resource createResource(URI uri) {
		return new BPELResourceImpl(uri);
	}
}
