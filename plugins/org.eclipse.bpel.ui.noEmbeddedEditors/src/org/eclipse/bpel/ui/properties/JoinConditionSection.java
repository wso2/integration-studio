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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Details section for the JoinCondition of an activity (a boolean expression).
 */
public class JoinConditionSection extends ExpressionSection {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #addAllAdapters()
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();

		Activity activity = getModel();
		Targets targets = activity.getTargets();
		if( targets != null )
			this.fAdapters[0].addToObject( targets );
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionType()
	 */
	@Override
	protected String getExpressionType() {
		return IEditorConstants.ET_JOIN;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionTarget()
	 */
	@Override
	protected EObject getExpressionTarget() {
		Activity activity = getModel();
		return activity.getTargets();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		return object instanceof Activity ? BPELPackage.eINSTANCE.getTargets_JoinCondition() : null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #getMarkers(java.lang.Object)
	 */
	@Override
	protected IMarker[] getMarkers (Object input) {

		IMarker[] result = EMPTY_MARKERS;
		if( input instanceof Activity ) {
			Activity activity = (Activity) input;
			Targets targets = activity.getTargets();
			if( targets != null )
				result = super.getMarkers( targets.getJoinCondition());
		}

		return result;
	}

}
