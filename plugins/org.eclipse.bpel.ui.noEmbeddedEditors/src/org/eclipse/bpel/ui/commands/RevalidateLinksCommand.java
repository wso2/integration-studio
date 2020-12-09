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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.bpel.ui.util.ModelHelper;



/**
 * Revalidate all the links for which the given activity(s) are the source or target.
 * 
 * For each link, the link should be contained in the innermost enclosing Flow which
 * contains both the source and the target.  If there is no such flow, the link is
 * deleted.  If there is such a flow and the Link is not currently owned by it, the
 * Link is moved into that Flow (and renamed, if necessary, to prevent naming collisions). 
 */
public class RevalidateLinksCommand extends AutoUndoCommand {

	List<Activity> activities;
	CompoundCommand deleteLinksCmd;
	
	public RevalidateLinksCommand(Collection activityCollection) {
		super(new ArrayList(1));
		this.activities = new ArrayList(activityCollection.size());
		this.activities.addAll(activityCollection);
		if (!activityCollection.isEmpty()) {
			addModelRoot(BPELUtils.getProcess(activityCollection.iterator().next()));
		}
	}
	
	// TODO: can we use the unique name support instead?
	protected boolean isAcceptableLinkName(Flow flow, String proposedName) {
		for (Iterator it = FlowLinkUtil.getFlowLinks(flow).iterator(); it.hasNext(); ) {
			Link link = (Link)it.next();
			if (proposedName.equals(link.getName())) return false;
		}
		return true;
	}
	
	protected void revalidateLink(Link link) {
		Flow linkFlow = (Flow)(link.eContainer().eContainer());
		Activity source = FlowLinkUtil.getLinkSource(link);
		Activity target = FlowLinkUtil.getLinkTarget(link);
		Flow commonFlow = FlowLinkUtil.getCommonFlow(source, target);
		if (commonFlow == null) {
			// We must delete this link.  Queue it up for deletion (don't delete
			// right away, as that would disturb the list(s) of sources/targets
			// which we are iterating over).
			deleteLinksCmd.add(new DeleteLinkCommand(link));
		} else if (commonFlow != linkFlow) {
			// Move this link into the commonFlow.
			// First, make sure none of the links in the commonFlow has the same name!
			if (!isAcceptableLinkName(commonFlow, link.getName())) {
				String s;
				int i = 0;
				do {
					++i; s = link.getName()+"_"+i; //$NON-NLS-1$
				} while (!isAcceptableLinkName(commonFlow, s));
				link.setName(s);
			}
			FlowLinkUtil.removeFlowLink(linkFlow, link);
			FlowLinkUtil.addFlowLink(commonFlow, link);
		}
	}
	
	@Override
	public void doExecute() {
		deleteLinksCmd = new CompoundCommand();
		
		// Figure out which model objects are being moved.
		HashSet revalidatingSet = new HashSet();
		for (Iterator<Activity> it = activities.iterator(); it.hasNext(); ) {
			Activity activity = it.next();
			ModelHelper.addSubtreeToCollection(activity, revalidatingSet);
		}
		for (Iterator it = revalidatingSet.iterator(); it.hasNext(); ) {
			Object object = it.next();
			if (object instanceof Activity) { 
				Activity activity = (Activity)object;
				Sources sources = activity.getSources();
				if (sources != null) {
					Iterator<Source> it2 = sources.getChildren().iterator();
					while (it2.hasNext()) revalidateLink((it2.next()).getLink());
				}
				Targets targets = activity.getTargets();
				if (targets != null) {
					Iterator<Target> it2 = targets.getChildren().iterator();
					while (it2.hasNext()) revalidateLink((it2.next()).getLink());
				}
			}
		}
		// delete any links that we queued up for deletion.
		if (!deleteLinksCmd.isEmpty()) deleteLinksCmd.execute();
	}
}
