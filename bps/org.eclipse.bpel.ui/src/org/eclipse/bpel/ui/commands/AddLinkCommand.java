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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;


public class AddLinkCommand extends AutoUndoCommand {

	protected Flow flow;
	protected Activity source;
	protected Activity target; 
	protected Link link;
	protected Command setNameCmd;
	protected boolean addNewObjectMode = false;

	public void setAddNewObjectMode(boolean addNewObjectMode) {
		this.addNewObjectMode = addNewObjectMode;
	}

	public AddLinkCommand(Command setNameCmd, EObject modelRoot) {
		super(IBPELUIConstants.CMD_ADD_LINK, modelRoot);
		this.setNameCmd = setNameCmd;
	}
	
	@Override
	public boolean canDoExecute() {
		if (link == null || source == null || target == null)  
			return false;
		if (source == target) return false;
		if (FlowLinkUtil.getCommonFlow(source, target) == null && !addNewObjectMode)  
			return false;
		return true;
	}
	
	@Override
	public void doExecute() {
		if (setNameCmd != null) {
			// This is a hack.
			// TODO: Fix this when we stop using canExecute()==false for no-op commands.
			if (!setNameCmd.canExecute())  setNameCmd = null;
		}
		
		flow = FlowLinkUtil.getCommonFlow(source, target);
		if (flow == null) {
			if (Policy.DEBUG) System.out.println("No common flow found!!"); //$NON-NLS-1$
			return;
		}
		if (setNameCmd != null)  setNameCmd.execute();
		FlowLinkUtil.setLinkSource(link, source);
		FlowLinkUtil.setLinkTarget(link, target);
		if (link.eContainer() != null) {
			Flow oldParent = (Flow)link.eContainer().eContainer();
			if (oldParent != null) {
				FlowLinkUtil.removeFlowLink(oldParent, link);
			}
		}
		FlowLinkUtil.addFlowLink(flow, link);
	}
	
	public Link getLink() { return link; }
	public void setSource(Activity source) { this.source = source; }
	public void setTarget(Activity target) { this.target = target; }
	public void setLink(Link link) { this.link = link; }	
}
