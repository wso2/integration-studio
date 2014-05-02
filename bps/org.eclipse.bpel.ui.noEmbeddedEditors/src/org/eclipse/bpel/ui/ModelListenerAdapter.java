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
package org.eclipse.bpel.ui;

import java.util.EventObject;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack.SharedCommandStackListener;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.ListenerDescriptor;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.commands.CommandStackListener;


/**
 * ModelListenerAdapter
 * 
 */

public class ModelListenerAdapter extends EContentAdapter implements CommandStackListener {
	
	ExtensionMap fxtensionMap = null;
	
	Adapter linkNotificationAdapter;
	
	int executionStackLevel = 0;
	boolean ignoreChanges = true;
	
	/**
	 * 
	 * @param adapter
	 */
	public void setLinkNotificationAdapter(Adapter adapter) {
		this.linkNotificationAdapter = adapter;
	}
	
	/**
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged (Notification n) {
		super.notifyChanged(n);			
		
		for (ListenerDescriptor desc : BPELUIRegistry.getInstance().getListenerDescriptors() ) {
		    desc.getModelListener().handleChange(n);
		}
		
		// TODO: should the descriptor-based listeners be protected by this as well?
		if (!ignoreChanges) {
			if (linkNotificationAdapter != null) {
				linkNotificationAdapter.notifyChanged(n);
			}
		}
	}
	
	/**
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void setTarget(Notifier notifier) {
		super.setTarget(notifier);
		if ((notifier instanceof EObject) && (fxtensionMap != null)) {
			if (executionStackLevel > 0) {
				ModelHelper.createExtensionIfNecessary(fxtensionMap, (EObject)notifier);
			}
		}
	}
	
	/**
	 * @param extensionMap
	 */
	public void setExtensionMap(ExtensionMap extensionMap) {
		this.fxtensionMap = extensionMap;
	}

	/**
	 * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java.util.EventObject)
	 */
	
	public void commandStackChanged(EventObject e) {
		
		if (e instanceof EditModelCommandStack.SharedCommandStackChangedEvent) {
			switch (((EditModelCommandStack.SharedCommandStackChangedEvent)e).getProperty()) {
			case SharedCommandStackListener.EVENT_START_EXECUTE:
				executionStackLevel++; ignoreChanges = false; break;
			case SharedCommandStackListener.EVENT_START_UNDO:
			case SharedCommandStackListener.EVENT_START_REDO:
				ignoreChanges = false; break;
			case SharedCommandStackListener.EVENT_FINISH_EXECUTE:
				executionStackLevel--; ignoreChanges = true; break;
			case SharedCommandStackListener.EVENT_FINISH_UNDO:
			case SharedCommandStackListener.EVENT_FINISH_REDO:
				ignoreChanges = true; break;
			}
		}
	}
}
