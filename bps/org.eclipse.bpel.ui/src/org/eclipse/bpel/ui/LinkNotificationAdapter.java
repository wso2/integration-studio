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

import java.util.Map;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;



/**
 * An adapter which gets notified of all model changes and refreshes the connections
 * of the appropriate edit parts when there are model changes involving links.
 * 
 * The adapter is currently attached to ModelListenerAdapter (since that is already
 * an EContentAdapter).
 */
class LinkNotificationAdapter extends MultiObjectAdapter {
	private BPELEditor bpelEditor;

	protected boolean DEBUG = false;
	
	LinkNotificationAdapter(BPELEditor editor) {
		this.bpelEditor = editor;
	}

	@Override
	public void notify(Notification n) {
		if (bpelEditor.getGraphicalViewer() == null) return;
		if (n.getNotifier() instanceof Links) {
			if (n.getFeatureID(Links.class) == BPELPackage.LINKS__CHILDREN) {
				if (DEBUG) System.out.println("Links change not handled yet!"); //$NON-NLS-1$
			}
		}
		if (n.getNotifier() instanceof Sources) {
			if (n.getFeatureID(Sources.class) == BPELPackage.SOURCES__CHILDREN) {
				if (DEBUG) System.out.println("Sources change not handled yet!"); //$NON-NLS-1$
			}
		}
		if (n.getNotifier() instanceof Targets) {
			if (n.getFeatureID(Targets.class) == BPELPackage.TARGETS__CHILDREN) {
				if (DEBUG) System.out.println("Targets change not handled yet!"); //$NON-NLS-1$
			}
		}
		if (n.getNotifier() instanceof Source) {
			if (n.getFeatureID(Source.class) == BPELPackage.SOURCE__ACTIVITY) {
				if (n.getOldValue() instanceof Activity) {
					refreshConnections((Activity)n.getOldValue(), "old source",true,false); //$NON-NLS-1$
				}
				if (n.getNewValue() instanceof Activity) {
					refreshConnections((Activity)n.getNewValue(), "new source",true,false); //$NON-NLS-1$
				}
			}
		}
		if (n.getNotifier() instanceof Target) {
			if (n.getFeatureID(Target.class) == BPELPackage.TARGET__ACTIVITY) {
				if (n.getOldValue() instanceof Activity) {
					refreshConnections((Activity)n.getOldValue(), "old target",false,true); //$NON-NLS-1$
				}
				if (n.getNewValue() instanceof Activity) {
					refreshConnections((Activity)n.getNewValue(), "new target",false,true); //$NON-NLS-1$
				}
			}
		}
		if (n.getNotifier() instanceof Activity) {
			if (n.getFeatureID(Activity.class) == BPELPackage.ACTIVITY__SOURCES) {
				switch (n.getEventType()) {
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					refreshConnections((Activity)n.getNotifier(), "old source(2)",true,false); break; //$NON-NLS-1$
				case Notification.ADD:
				case Notification.ADD_MANY:
					refreshConnections((Activity)n.getNotifier(), "new source(2)",true,false); break; //$NON-NLS-1$
				}
			}
			if (n.getFeatureID(Activity.class) == BPELPackage.ACTIVITY__TARGETS) {
				switch (n.getEventType()) {
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					refreshConnections((Activity)n.getNotifier(), "old target(2)",false,true); break; //$NON-NLS-1$
				case Notification.ADD:
				case Notification.ADD_MANY:
					refreshConnections((Activity)n.getNotifier(), "new target(2)",false,true); break; //$NON-NLS-1$
				}
			}
		}
		// TODO: this part is kind of iffy...  (how do I detect the containment features??)
		if (n.getOldValue() instanceof Activity) {
			activityMoved((Activity)n.getOldValue());
		}
		if (n.getNewValue() instanceof Activity) {
			activityMoved((Activity)n.getNewValue());
		}
	}
	
	protected void refreshConnections(Activity activity, String debugRole, boolean refreshSource, boolean refreshTarget) {
		Map registry = this.bpelEditor.getGraphicalViewer().getEditPartRegistry();
		EditPart editPart = (EditPart)registry.get(activity);
		if ((editPart instanceof BPELEditPart) && editPart.isActive()) {
			System.out.println(debugRole+": "+editPart.getModel()); //$NON-NLS-1$
			if (refreshSource) ((BPELEditPart)editPart).refreshSourceConnections();
			if (refreshTarget) ((BPELEditPart)editPart).refreshTargetConnections();
		}
	}

	protected void refreshConnectionTargets(Sources sources) {
		Map registry = this.bpelEditor.getGraphicalViewer().getEditPartRegistry();
		for (Source source : sources.getChildren()) {
			Link link = source.getLink();
			if (link != null) {
				Activity targetActivity = FlowLinkUtil.getLinkTarget(link);
				if (targetActivity != null) {
					EditPart targetEditPart = (EditPart)registry.get(targetActivity);
					if ((targetEditPart instanceof BPELEditPart) && targetEditPart.isActive()) {
						if (DEBUG) System.out.println("refreshConnectionTargets on: "+targetEditPart); //$NON-NLS-1$
						((BPELEditPart)targetEditPart).refreshTargetConnections();
					}
				}
			}
		}
	}		
	protected void refreshConnectionSources(Targets targets) {
		Map registry = this.bpelEditor.getGraphicalViewer().getEditPartRegistry();
		for (Target target : targets.getChildren()) {
			Link link = target.getLink();
			if (link != null) {
				Activity sourceActivity = FlowLinkUtil.getLinkSource(link);
				if (sourceActivity != null) {
					EditPart sourceEditPart = (EditPart)registry.get(sourceActivity);
					if ((sourceEditPart instanceof BPELEditPart) && sourceEditPart.isActive()) {
						if (DEBUG) System.out.println("refreshConnectionSources on: "+sourceEditPart); //$NON-NLS-1$
						((BPELEditPart)sourceEditPart).refreshSourceConnections();
					}
				}
			}
		}
	}

	protected void activityMoved(Activity activity) {
		Map registry = this.bpelEditor.getGraphicalViewer().getEditPartRegistry();
		EditPart editPart = (EditPart)registry.get(activity);
		if ((editPart instanceof BPELEditPart) && editPart.isActive()) {
			if (DEBUG) System.out.println("moved activity: "+editPart.getModel()); //$NON-NLS-1$
			((BPELEditPart)editPart).refreshSourceConnections();
			((BPELEditPart)editPart).refreshTargetConnections();
		}
		// refresh the target connections of activities at the other end of
		// links for which we are the source!
		if (activity.getSources() != null) {
			refreshConnectionTargets(activity.getSources());
		}
		// refresh the source connections of activities at the other end of
		// links for which we are the target!
		if (activity.getTargets() != null) {
			refreshConnectionSources(activity.getTargets());
		}
//		if ((editPart instanceof BPELEditPart) && editPart.isActive()) {
//			System.out.println("(re-refresh!)");
//			((BPELEditPart)editPart).refreshSourceConnections();
//			((BPELEditPart)editPart).refreshTargetConnections();
//		}
	}
	
}