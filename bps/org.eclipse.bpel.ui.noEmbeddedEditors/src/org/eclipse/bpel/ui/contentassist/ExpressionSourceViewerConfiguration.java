/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.contentassist;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.ISourceViewer;

public class ExpressionSourceViewerConfiguration extends
		SourceViewerConfiguration {

	private ContentAssistant bpelAssistant = null;
	
	public ExpressionSourceViewerConfiguration() {
		super();
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer viewer) {
		if (bpelAssistant == null) {
			bpelAssistant = new ContentAssistant();
			ExpressionContentAssistProcessor exprProcessor = new ExpressionContentAssistProcessor();
			// install custom content assist processor
			bpelAssistant.setContentAssistProcessor(exprProcessor, 
					IDocument.DEFAULT_CONTENT_TYPE);
			bpelAssistant.setInformationControlCreator(this.getInformationControlCreator(viewer));
			bpelAssistant.enableAutoActivation(true);
			
			// support for multiple proposal suggestions
			bpelAssistant.setRepeatedInvocationMode(true);
			bpelAssistant.setStatusLineVisible(true);
			bpelAssistant.addCompletionListener(exprProcessor);
		}
		return bpelAssistant;
	}

	public ContentAssistant getBpelAssistant() {
		return bpelAssistant;
	}
}
