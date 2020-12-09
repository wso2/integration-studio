/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.resource;

import java.util.Iterator;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Links;
import org.eclipse.emf.ecore.EObject;

/**
 * Base implementation of LinkResolver. This resolves all link
 * as defined in the BPEL specifications.
 * 
 * Supply a different variable resolver by implementing LinkResolver
 * and executing:
 * BPELReader.LINK_RESOLVER = new MyLinkResolver();
 */
public class BPELLinkResolver implements LinkResolver {

	public Link getLink(Activity activity, String linkName) {
		if (activity != null) {
			EObject container = activity.eContainer();
			while (container != null) {
				if (container instanceof Flow) {
					Links links =((Flow)container).getLinks();
					if (links != null) {
						for (Iterator<Link> it = links.getChildren().iterator(); it.hasNext(); ) {
							Link candidate = it.next(); 		
							if (candidate.getName().equals(linkName)) 
								return candidate;
						}
					}
				}
				container = container.eContainer();
			}
		}
		return null;		
	}
}
