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
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */
public class ForEachFinalCounterValueSection extends ExpressionSection {

	/**
	 * Constructor.
	 */
	public ForEachFinalCounterValueSection() {
		super();
		this.title = Messages.ForEachFinalCounterValuesSection_TITLE_3;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionType()
	 */
	@Override
	protected String getExpressionType() {
		return IEditorConstants.ET_UNSIGNED_INT;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		return object instanceof ForEach ? BPELPackage.eINSTANCE.getForEach_FinalCounterValue() : null;
	}
}
