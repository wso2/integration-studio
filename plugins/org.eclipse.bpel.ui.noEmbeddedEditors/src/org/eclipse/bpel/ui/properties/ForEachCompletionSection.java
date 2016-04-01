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

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Details section for the CompletionCondition of an forEach activity (a unsignedInteger expression).
 */
public class ForEachCompletionSection extends ExpressionSection {

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
	 * #addAllAdapters()
	 */
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		this.fAdapters[0].addToObject( getExpressionTarget() );
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature (EObject object) {
		return object instanceof ForEach ? BPELPackage.eINSTANCE.getCompletionCondition_Branches() : null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpressionTarget()
	 */
	@Override
	protected EObject getExpressionTarget() {

		EObject obj = getInput();
		if( obj instanceof ForEach ) {

			ForEach _for = (ForEach) obj;
			CompletionCondition target = _for.getCompletionCondition();
			if (target == null) {
				target = BPELFactory.eINSTANCE.createCompletionCondition();
				_for.setCompletionCondition( target );
			}

			return target;
		}

		return super.getExpressionTarget();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getExpression4Target(org.eclipse.bpel.model.Expression)
	 */
	@Override
	protected Expression getExpression4Target ( Expression expression ) {

		if (expression instanceof Branches) {
			return expression;
		}

		Branches branches = BPELFactory.eINSTANCE.createBranches();
		branches.setBody( expression.getBody());
		branches.setExpressionLanguage( expression.getExpressionLanguage());

		return branches;
	}
}
