/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.Target;


/**
 * Content provider for links.
 * 
 * Provides all the links visible in a given context.
 */

public class LinkContentProvider extends AbstractContentProvider  {

	/**
	 * All incoming links to the activity in question
	 */
	public static final int INCOMING = 0;
	
	/**
	 * All outgoing links to the activity in question
	 */
	public static final int OUTGOING = 1;
	
	/**
	 * All declared links in the nearest flow
	 */
	public static final int DECLARED = 2;
	
	int fMode = INCOMING;
	
	
	/**
	 * @param mode
	 */
	public LinkContentProvider (int mode) {
		fMode = mode;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#collectElements(java.lang.Object, java.util.List)
	 */
	@Override
	public void collectElements (Object input, List<Object> list)  {
		
		if (input == null) {
			return;
		}
				
		if (fMode == INCOMING) {
			collectIncoming( input, list) ;
			return ;
		}
		
		if (fMode == OUTGOING) {
			collectOutgoing(input,list);
			return ;
		}
		
		collectDeclaredLinks ( input, list );
	}
	
	
	void collectDeclaredLinks ( Object input, List<Object> list) {
		if (input == null) {
			return;
		}

		if (input instanceof Flow) {
			Flow flow = (Flow)input;
			Links links = flow.getLinks();
			if (links == null) {
				return ;
			}
			list.addAll( links.getChildren() );			
			return ;
		}
		
		if (input instanceof Activity) {
			Activity activty = (Activity) input;
			collectDeclaredLinks(activty.eContainer(), list);
		}
	}
	
	void collectIncoming (Object input, List<Object> list) {
		if (input instanceof Activity) {
			Activity activity = (Activity) input;
			Targets targets = activity.getTargets();
			if (targets == null) {
				return ;
			}
			for(Object next : targets.getChildren()) {
				Target aTarget = (Target) next;
				list.add(aTarget.getLink());
			}
		}
	}
	
	void collectOutgoing (Object input, List<Object> list) {
		if (input instanceof Activity) {
			Activity activity = (Activity) input;
			Sources sources = activity.getSources();
			if (sources == null) {
				return ;
			}
			for(Object next : sources.getChildren()) {
				Source aSource = (Source) next;
				list.add(aSource.getLink());
			}
			
		}
	}
}
