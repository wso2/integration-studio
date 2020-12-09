/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.resource;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Link;

/**
 * Interface LinkResolver provides an extension mechanism for resolution
 * of a link with a given name.
 */
public interface LinkResolver {
	public Link getLink(Activity activity, String linkName);
}
