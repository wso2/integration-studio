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
package org.eclipse.bpel.ui.util;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Interface to an adapter which knows how to batch changes.  CommandStackChangeBatcher
 * uses this to tell the adapter when the changes should be processed.
 */
public interface IBatchedAdapter extends Adapter {

	void finish();
}
