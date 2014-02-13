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
package org.eclipse.bpel.ui.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.internal.WorkbenchImages;

public class SharedImages {
	
	// TODO: should we not be using the workbench images directly?
	public static ImageDescriptor getWorkbenchImageDescriptor(String symbolicName) {
		return WorkbenchImages.getImageDescriptor(symbolicName);
	}
}
