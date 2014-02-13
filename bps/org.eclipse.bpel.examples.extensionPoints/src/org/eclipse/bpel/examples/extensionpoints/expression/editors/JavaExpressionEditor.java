package org.eclipse.bpel.examples.extensionpoints.expression.editors;



/**
 * Simple text editor used as an expression editor.
 * 
 * This example shows the use of the eclipse default text editor as an expression
 * editor for the expression language set in the extension point.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 17, 2007
 */

public class JavaExpressionEditor extends SimpleTextExpressionEditor {

	@Override
	protected String getTextEditorId () {
		return JavaTextEditor.TEXT_EDITOR_ID;
	}
	
}
