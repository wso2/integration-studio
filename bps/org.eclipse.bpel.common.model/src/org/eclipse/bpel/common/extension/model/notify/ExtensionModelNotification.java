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
package org.eclipse.bpel.common.extension.model.notify;

import org.eclipse.emf.common.notify.Notification;

public interface ExtensionModelNotification extends Notification {

	/**
	 * A fature ID indicating that the ExtensionMap.put(Object,Object) method
	 * has been called. Arg1 is set to extended object. Arg2 is set to the old
	 * extension object (if one exists).
	 */
	int EXTENSION_MAP_PUT = 996;

	/**
	 * A fature ID indicating that the ExtensionMap.putAll(Map) method has been
	 * called. Arg1 is set to the original map contents before the method is
	 * executed. Arg2 is null.
	 */
	int EXTENSION_MAP_PUTALL = 997;

	/**
	 * A fature ID indicating that the ExtensionMap.remove(Object) method has
	 * been called. Arg1 is set to the extended object being removed. Arg2 is
	 * set to the extension object corresponding to the extended object being
	 * removed.
	 */
	int EXTENSION_MAP_REMOVE = 998;

	/**
	 * A fature ID indicating that the ExtensionMap.clear() method has been
	 * called. Arg1 is set to the original map contents before the clear is
	 * executed. Arg2 is null.
	 */
	int EXTENSION_MAP_CLEAR = 999;

	/**
	 * The Object returned depends on the feature ID (see above).
	 * 
	 * @return
	 */
	Object getArg1();

	/**
	 * The Object returned depends on the feature ID (see above).
	 * 
	 * @return
	 */
	Object getArg2();

}