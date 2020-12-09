/**
 * 
 */
package org.eclipse.bpel.examples.extensionpoints.assigncategory;

import org.eclipse.bpel.ui.properties.AbstractExpressionAssignCategory;
import org.eclipse.bpel.ui.properties.IAssignCategory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

/**
 * An example of {@link IAssignCategory} which only shows a simple text editor.
 * 
 * @author Lorenzo Bettini
 *
 */
public class SimpleTextAssignCategory extends AbstractExpressionAssignCategory {

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.AbstractExpressionAssignCategory#getExpressionLanguage()
	 */
	@Override
	protected String getExpressionLanguage() {
		return "simpletext";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.AbstractStyledTextExpressionSection#createStyledText(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected StyledText createStyledText(Composite styledTextComposite) {
		Composite editor = getWidgetFactory().createComposite( styledTextComposite, SWT.BORDER );
		editor.setLayout( new FillLayout ());

		GridData layoutData = new GridData( GridData.FILL_BOTH );
		editor.setLayoutData( layoutData );
		
		int style = SWT.V_SCROLL | SWT.MULTI | SWT.BORDER;
		final ISourceViewer viewer = new SourceViewer(editor,
				new VerticalRuler(0), style);

		StyledText styledText = viewer.getTextWidget();
		styledText.setLayoutData(new FillLayout());
		IDocument document = new Document("");
		viewer.setDocument(document);
		return styledText;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.AbstractStyledTextExpressionSection#getStyledTextLabelString()
	 */
	@Override
	protected String getStyledTextLabelString() {
		return "Edit the associated simple text Expression.";
	}

	@Override
	public String getName() {
		return "Simple Text Editor";
	}


}
