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

import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.editors.xpath.ColorManager;
import org.eclipse.bpel.ui.editors.xpath.XPathSourceViewerConfiguration;
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
 * Base class with some shared behavior for details panes that edit a XPath expression.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @author Vincent Zurczak - EBM WebSourcing (Merge this class with TextSection, simplify it by only using the XPath viewer)
 * @author Lorenzo Bettini relies on {@link AbstractStyledTextExpressionSection}
 * FIXME: There are probably cases that are not handled correctly. To be fixed on the fly.
 * FIXME: Undo is not supported correctly.
 */
public abstract class ExpressionSection extends AbstractStyledTextExpressionSection {


	protected String getStyledTextLabelString() {
		return "Edit the associated XPath Expression.";
	}

	protected StyledText createStyledText(Composite styledTextComposite) {
		Composite editor = getWidgetFactory().createComposite( styledTextComposite, SWT.BORDER );
		editor.setLayout( new FillLayout ());

		GridData layoutData = new GridData( GridData.FILL_BOTH );
		editor.setLayoutData( layoutData );
		
		int style = SWT.V_SCROLL | SWT.MULTI | SWT.BORDER;
		final ISourceViewer viewer = new SourceViewer(editor,
				new VerticalRuler(0), style);
		ColorManager cManager = new ColorManager();
		viewer.configure(new XPathSourceViewerConfiguration(cManager));

		StyledText styledText = viewer.getTextWidget();
		styledText.setLayoutData(new FillLayout());
		IDocument document = new Document("");
		viewer.setDocument(document);
		return styledText;
	}

	protected String getExpressionLanguage() {
		return BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_2007;
	}
}