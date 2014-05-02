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
package org.eclipse.bpel.examples.extensionpoints.expression.editors;

import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.bpel.ui.util.BPELDateTimeHelpers;



/**
 * JavaScript editor used as an expression editor.
 * 
 * This example shows the use of the WTPs JavaScript editor as an expression
 * editor for the expression language set in the extension point.
 *    
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 17, 2007
 */

public class JavaScriptExpressionEditor extends SimpleTextExpressionEditor {

	@Override
	protected String getTextEditorId () {
		return JavaScriptTextEditor.TEXT_EDITOR_ID;
	}

	/**
	 * @see org.eclipse.bpel.examples.extensionpoints.expression.editors.SimpleTextExpressionEditor#getDefaultContent()
	 */
	
	@SuppressWarnings("nls")
	@Override
	public String getDefaultContent() {
		
		String exprType = getExprType();
		if (exprType.indexOf(IEditorConstants.ET_BOOLEAN) >= 0) {
			return "true";
		} else if (exprType.indexOf(IEditorConstants.ET_UNSIGNED_INT) >= 0) {
			return "1";
		} else if (exprType.indexOf(IEditorConstants.ET_DATETIME) >= 0) {
			return "new Date() // sample"; 					
		} else if (exprType.indexOf(IEditorConstants.ET_DURATION) >= 0) {
			return "parseTime(\"0d0h0m0s\") // sample";
		}
		
		return ""; //$NON-NLS-1$
	}

}
