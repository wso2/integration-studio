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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Target;
import org.eclipse.emf.ecore.EObject;



/**
 * Helpers for dealing with Links in a Flow.
 * 
 * TODO: do all these helpers work OK if the Sources or Targets list is empty??
 */
public class FlowLinkUtil {
	
	/**
	 * Walks up the parent chain of the source and target activities to find the innermost flow
	 * which contains both.  Returns null if source and target have no common flow.
	 */
	public static Flow getCommonFlow(Activity source, Activity target) {
		if (source == null || target == null) return null;
		Flow[] sourceParents = getParentFlows(source);
		Flow[] targetParents = getParentFlows(target);
		if (sourceParents == null || targetParents == null) return null;
		int sIdx = sourceParents.length - 1;
		int tIdx = targetParents.length - 1;
		Flow commonFlow = null;
		while (sIdx >= 0 && tIdx >= 0) {
			if (sourceParents[sIdx] == targetParents[tIdx]) {
				commonFlow = sourceParents[sIdx];
			} else {
				break;
			}
			sIdx--; tIdx--;
		}
		return commonFlow;
	}

	/**
	 * Returns true if the given object is enclosed in a flow, or false otherwise.
	 */
	public static boolean hasParentFlow(EObject object) {
		for (object = object.eContainer(); object != null; object = object.eContainer()) {
			if (object instanceof Flow)  return true;
		}
		return false;
	}

	/**
	 * Walks up the parent chain of the given object and returns all the parents which are
	 * Flows, from the innermost (i.e. closest ancestor) to outermost (oldest ancestor).
	 * 
	 * The returned array will have non-zero length if and only if hasParentFlow(object) is true.
	 */	
	public static Flow[] getParentFlows(EObject object) {
		List list = new ArrayList();
		getParentFlows(object.eContainer(), list);
		return (Flow[])list.toArray(new Flow[list.size()]);
	}

	protected static void getParentFlows(EObject object, List list) {
		if (object == null) return;
		if (object instanceof Process) return;
		if (object instanceof Flow) list.add(object);
		getParentFlows(object.eContainer(), list);
	}
	
	/**
	 * Returns a list of links.
	 * Callers should NOT MODIFY this list as it may not be the real list!
	 */
	public static List getFlowLinks(Flow flow) {
		if (flow.getLinks() == null) {
			return Collections.EMPTY_LIST;
		}
		return Collections.unmodifiableList(flow.getLinks().getChildren());
	}
	
	public static void addFlowLink(Flow flow, Link link) {
		if (flow.getLinks() == null) {
			flow.setLinks(BPELFactory.eINSTANCE.createLinks());
		}
		flow.getLinks().getChildren().add(link);
	}
	
	public static void removeFlowLink(Flow flow, Link link) {
		if (flow.getLinks() != null) {
			flow.getLinks().getChildren().remove(link);
			if (flow.getLinks().getChildren().isEmpty()) {
				flow.setLinks(null);
			}
		}
	}
	
	public static void removeActivitySource(Source source) {
		Activity activity = source.getActivity();
		if (activity != null && activity.getSources() != null) {
			activity.getSources().getChildren().remove(source);
			if (activity.getSources().getChildren().isEmpty()) {
				activity.setSources(null);
			}
		}
	}
	
	public static void removeActivityTarget(Target target) {
		Activity activity = target.getActivity();
		if (activity != null && activity.getTargets() != null) {
			activity.getTargets().getChildren().remove(target);
			if (activity.getTargets().getChildren().isEmpty()) {
				activity.setTargets(null);
			}
		}
	}

	/**
	 * Returns the source of a Link, or null if it has none.
	 */
	public static Activity getLinkSource(Link link) {
		if (link.getSources().isEmpty()) return null;
		return ((link.getSources().get(0))).getActivity(); 
	}
	
	/**
	 * Returns the target of a Link, or null if it has none.
	 */
	public static Activity getLinkTarget(Link link) {
		if (link.getTargets().isEmpty()) return null;
		return ((link.getTargets().get(0))).getActivity(); 
	}
	
	/**
	 * Sets the source of a Link.
	 */
	public static void setLinkSource(Link link, Activity activity) {
		if (link.getSources().isEmpty()) {
			if (activity != null) {
				// Create new Source.
				Source source = BPELFactory.eINSTANCE.createSource();
				link.getSources().add(source);
				source.setActivity(activity);
			}
		} else {
			Source source = (link.getSources().get(0));
			Activity oldActivity = source.getActivity();
			if (activity != null) {
				// Re-target existing Source.  TODO: is this safe?
				source.setActivity(activity);
			} else {
				link.getSources().remove(source);
			}
			// In either case, the previous activity to which the
			// source was attached may now have an empty sources element.
			// If so, remove it now.
			if (oldActivity != null) {
				if (oldActivity.getSources() != null && oldActivity.getSources().getChildren().isEmpty()) {
					oldActivity.setSources(null);
				}
			}
		}
	}
	
	/**
	 * Sets the target of a Link.
	 */
	public static void setLinkTarget(Link link, Activity activity) {
		if (link.getTargets().isEmpty()) {
			if (activity != null) {
				// Create new Target.
				Target target = BPELFactory.eINSTANCE.createTarget();
				link.getTargets().add(target);
				target.setActivity(activity);
			}
		} else {
			Target target = (link.getTargets().get(0));
			Activity oldActivity = target.getActivity();
			if (activity != null) {
				// Re-target existing Target.  TODO: is this safe?
				target.setActivity(activity);
			} else {
				// Remove existing Target.
				link.getTargets().remove(target);
			}
			// In either case, the previous activity to which the
			// target was attached may now have an empty targets element.
			// If so, remove it now.
			if (oldActivity != null) {
				if (oldActivity.getTargets() != null && oldActivity.getTargets().getChildren().isEmpty()) {
					oldActivity.setTargets(null);
				}
			}
		}
	}
	
	/**
	 * If the from Activity is a source or target in a Link it is
	 * replaced by the to Activity. Nothing happens otherwise.
	 * 
	 * TODO: this was only used by some generic fault-handler stuff in ActivityAdapter.
	 * Consider removing this in the future, if we don't need that stuff anymore!
	 */
	public static void replaceLinkSourceAndTarget(Activity from, Activity to) {
		Flow[] flows = getParentFlows(from);
		if (flows != null && flows.length > 0) {
			Flow flow = flows[0];
			List links = getFlowLinks(flow);
			for (Iterator iter = links.iterator(); iter.hasNext();) {
				Link link = (Link) iter.next();
				Activity temp = getLinkSource(link);
				if (temp != null && temp == from) {
					setLinkSource(link, to); 
				} else {
					temp = getLinkTarget(link);
					if (temp != null && temp == from) {
						setLinkTarget(link, to); 
					}
				}
			}
		}
	}
	
//	/**
//	 * Returns the EditPart which should act as the source for a given Link object.
//	 * (this depends on the collapsed/expanded state..its basically the source Activity
//	 * itself, or its innermost enclosing container, which is actually visible)
//	 */
//	public static EditPart getActingSourceEditPart(EditPartViewer viewer, Link link) {
//		EObject modelObject = getLinkSource(link);
//		while (modelObject != null) {
//			EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(modelObject);
//			if (editPart != null) return editPart;
//			modelObject = BPELUtil.getIContainerParent(modelObject);
//		}
//		return null;
//	}
//	
//	/**
//	 * Returns the EditPart which should act as the target for a given Link object.
//	 * (this depends on the collapsed/expanded state..its basically the target Activity
//	 * itself, or its innermost enclosing container, which is actually visible)
//	 */
//	public static EditPart getActingTargetEditPart(EditPartViewer viewer, Link link) {
//		EObject modelObject = getLinkTarget(link);
//		while (modelObject != null) {
//			EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(modelObject);
//			if (editPart != null) return editPart;
//			modelObject = BPELUtil.getIContainerParent(modelObject);
//		}
//		return null;
//	}
//	
//	/**
//	 * Return all the links for which a collapsed edit part should act as the source,
//	 * even though it really isn't.  (Because the *actual* sources are contained in
//	 * the edit part).
//	 */
//	public static List getAllContainedSourceLinks(EObject model) {
//		List result = new ArrayList();
//		for (TreeIterator it = model.eAllContents(); it.hasNext(); ) {
//			Object object = it.next();
//			// Activity *contains* the Sources which *contains* the Source
//			if (object instanceof Source) {
//				Link link = ((Source)object).getLink();
//				if (link != null) result.add(link);
//			}
//		}
//		return result;
//	}
//	
//	/**
//	 * Return all the links for which a collapsed edit part should act as the source,
//	 * even though it really isn't.  (Because the *actual* sources are contained in
//	 * the edit part).
//	 */
//	public static List getAllContainedTargetLinks(EObject model) {
//		List result = new ArrayList();
//		for (TreeIterator it = model.eAllContents(); it.hasNext(); ) {
//			Object object = it.next();
//			// Activity *contains* the Sources which *contains* the Source
//			if (object instanceof Source) {
//				Link link = ((Source)object).getLink();
//				if (link != null) result.add(link);
//			}
//		}
//		return result;
//	}
	
}
