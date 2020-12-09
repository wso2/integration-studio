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
package org.eclipse.bpel.ui.expressions;

/**
 * 
 * Philosophical note.
 * 
 * Expression Editors present in the BPEL designer imply "expressions". Expressions tend 
 * to return things, so there should always be a type to an expression. In some cases
 * there are statically implied types (boolean, unsignedInt).
 * 
 * @author IBM Original Contribution
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 17, 2007
 *
 * 
 */

@SuppressWarnings("nls")
public interface IEditorConstants {
	
	/** General Boolean Expression Type */
	public static final String ET_BOOLEAN = "boolean"; //$NON-NLS-1$
	
	/** General datetime expression type (deadline) used in Wait, OnAlarm */	
	public static final String ET_DATETIME = "deadline"; //$NON-NLS-1$
	
	/** General duration expression type (time) used in Wait, OnAlarm */	
	public static final String ET_DURATION = "duration"; //$NON-NLS-1$
	
	/** Unsigned integer expression type, used in forEach loop */	
	public static final String ET_UNSIGNED_INT = "unsignedInt"; //$NON-NLS-1$
		
	/** Any expression type */
	public static final String ET_ANY = "any"; 
	
	/** A Boolean expression within a jointCondition */
	public static final String ET_JOIN = "joinCondition/boolean" ;

	/** A Boolean expression within a transitionCondition */
	public static final String ET_TRANSITION = "transitionCondition/boolean" ;

}
