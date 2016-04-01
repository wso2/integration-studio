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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;

class AnnotationSwitch extends DiffSwitch<Object> {

	private HashMap<EObject, DiffElement> model2annotation =
		new HashMap<EObject, DiffElement>();
	public List<DiffElement> annotations = new ArrayList<DiffElement>();

	public HashMap<EObject, DiffElement> getAnnotations(DiffModel diff, MatchModel match) {
		
		for (Iterator<EObject> iter = diff.eAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();
			doSwitch(eObject);
		}
		
		return model2annotation;
	}

	@Override
	public Object caseUpdateAttribute(UpdateAttribute object) {
		annotate(object.getLeftElement(), object);
		annotate(object.getRightElement(), object);
		annotations.add(object);
		return object;
	}
	
	@Override
	public Object caseModelElementChangeLeftTarget(ModelElementChangeLeftTarget object) {
		annotate(object.getLeftElement(), object);
		annotations.add(object);
		return object;
	}
	
	@Override
	public Object caseModelElementChangeRightTarget(ModelElementChangeRightTarget object) {
		annotate(object.getRightElement(), object);
		annotations.add(object);
		return object;
	}
	
//	@Override
//	public Object caseRemoveModelElement(RemoveModelElement object) {
//		annotate(object.getLeftElement(), object);
//		annotations.add(object);
//		return object;
//	}
	
	@Override
	public Object caseReferenceChangeRightTarget(
			ReferenceChangeRightTarget object) {
		annotate(object.getRightElement(), object);
		annotations.add(object);
		return object;
	}

//	@Override
//	public Object caseAddModelElement(AddModelElement object) {
//		annotate(object.getRightElement(), object);
//		annotations.add(object);
//		return object;
//	}
	
	@Override
	public Object caseMoveModelElement(MoveModelElement object) {
		annotate(object.getLeftElement(), object);
		annotate(object.getRightElement(), object);
		annotations.add(object);
		return object;
	}
	
	private void annotate(EObject model, DiffElement annotation) {
		model2annotation.put(model, annotation);
	}

}
