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
package org.eclipse.bpel.ui.commands;

import java.util.ArrayList;

import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;


public class DeleteLinkCommand extends AutoUndoCommand {

	private Link link;
	private Flow flow;

	public DeleteLinkCommand(Link link) {
		super(IBPELUIConstants.CMD_DELETE_LINK, new ArrayList<Object>());
		this.link = link;
		EObject cont = link.eContainer().eContainer();
		flow = (Flow)cont;
		addModelRoot(flow);
	}

	// NOTE: By selecting an activity and link at the same time, the user can run
	// a GEF DeleteAction which results in two DeleteLinkCommands for the same link
	// (one from GEF and one in DeleteChildCommand).  This is harmless as long as
	// our canExecute() and canUndo() methods check if the link is actually in
	// the model.

	@Override
	public boolean canDoExecute() {
		if (link == null || flow == null) return false;
		// see comment above
		return FlowLinkUtil.getFlowLinks(flow).contains(link);
	}
	
	@Override
	public void doExecute() {
		// remove any markers associated with the child.
		// TODO: We need an undo/redo story for marker removal.
		IMarkerHolder markerHolder = BPELUtil.adapt(link, IMarkerHolder.class);
		if (markerHolder != null) {
			IMarker[] markers = markerHolder.getMarkers(link);
			for (int i = 0; i < markers.length; i++) {
				try {
					markers[i].delete();
				} catch (CoreException e) {
					BPELUIPlugin.log(e);
				}
			}
		}
		
		Object[] source = link.getSources().toArray();
		for (int i = 0; i<source.length; i++) {
			if (source[i] != null) FlowLinkUtil.removeActivitySource((Source)source[i]);
		}

		Object[] target = link.getTargets().toArray();
		for (int i = 0; i<target.length; i++) {
			if (target[i] != null) FlowLinkUtil.removeActivityTarget((Target)target[i]);
		}
		
		if (flow != null) FlowLinkUtil.removeFlowLink(flow, link);
	}
}
