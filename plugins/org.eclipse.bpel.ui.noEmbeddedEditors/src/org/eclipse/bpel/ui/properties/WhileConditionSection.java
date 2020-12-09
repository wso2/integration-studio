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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Details section for the WhileCondition of an activity (a boolean expression).
 */
public class WhileConditionSection extends ExpressionSection {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionType()
	 */
	@Override
	protected String getExpressionType() {
		return IEditorConstants.ET_BOOLEAN;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {

		if( object instanceof While )
			return BPELPackage.eINSTANCE.getWhile_Condition() ;

		if( object instanceof RepeatUntil )
			return BPELPackage.eINSTANCE.getRepeatUntil_Condition();

		return null;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #getMarkers(java.lang.Object)
	 */
	@Override
	protected IMarker[] getMarkers (Object input) {
		return input instanceof While ? super.getMarkers(((While) input).getCondition()) : EMPTY_MARKERS;
	}
}
