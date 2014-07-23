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
package org.eclipse.bpel.ui.properties;

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Details section for the TransitionCondition of a link source (a boolean expression).
 */
public class TransitionConditionSection extends ExpressionSection {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #addAllAdapters()
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();

		Link link = getModel();
		for(Object next : link.getSources()) {
			Source source = (Source) next;
			this.fAdapters[0].addToObject( source );
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionType()
	 */
	@Override
	protected String getExpressionType() {
		return IEditorConstants.ET_TRANSITION;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		return BPELPackage.eINSTANCE.getSource_TransitionCondition() ;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionTarget()
	 */
	@Override
	protected EObject getExpressionTarget() {
		List<Source> sources = ((Link) getModel()).getSources();
		return sources.size() > 0 ? sources.get( 0 ) : null;
	}
}
