/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;

import java.util.ArrayList;

import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 7, 2007
 *
 */

// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7526
// push all of the Marker stuff up to MarkerHolderAdapter to avoid duplication
public class ExpressionAdapter extends MarkerHolderAdapter implements IMarkerHolder, AdapterNotification {

}
