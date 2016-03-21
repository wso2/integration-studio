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
package org.eclipse.bpel.compare.ui.annotation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.compare.CompareConfiguration;

public class AnnotationsStore {

	private static AnnotationsStore instance;
	private WeakHashMap<EObject, DiffElement> model2annotation =
		new WeakHashMap<EObject, DiffElement>();
	public HashMap<CompareConfiguration, List<DiffElement>> annotations = new HashMap<CompareConfiguration, List<DiffElement>>();
	
	public static synchronized AnnotationsStore getInstance() {
		if (instance == null) {
			instance = new AnnotationsStore();
		}
		return instance;
	}
	
	/**
	 * Compares two models and stores all the changes.
	 * To get the change for certain element use {@link #getAnnotation(EObject)}
	 * 
	 * This function should be used once for given <code>left</code>
	 * and <code>right</code> objects. Next call will override the result of
	 * the previous call.
	 * 
	 * I.e. this function should not be used like that:
	 * annotate(left, right);
	 * annotate(left, right1);
	 * 
	 * @param left
	 * @param right
	 */
	public void annotate(CompareConfiguration cc, EObject left, EObject right) {
		try {
			MatchModel match = MatchService.doMatch(left, right, 
					Collections.<String, Object> emptyMap());
			DiffModel diff = DiffService.doDiff(match, false);
			AnnotationSwitch as = new AnnotationSwitch();
			model2annotation.putAll(as.getAnnotations(diff, match));
			annotations.put(cc, as.annotations);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DiffElement getAnnotation(EObject model) {
		return model2annotation.get(model);
	}
	
}
