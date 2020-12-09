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
import org.eclipse.bpel.ui.contentassist.ExpressionContentAssistProcessor;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.VariableTreeContentProvider;
import org.eclipse.bpel.ui.dialogs.ElementTreePreviewSelectionDialog;
import org.eclipse.bpel.ui.editors.xpath.ColorManager;
import org.eclipse.bpel.ui.editors.xpath.XPathSourceViewerConfiguration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

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
		
		XPathSourceViewerConfiguration sourceViewConfiguration = new XPathSourceViewerConfiguration(new ColorManager());
		viewer.configure(sourceViewConfiguration);
		
		StyledText styledText = viewer.getTextWidget();
		styledText.setLayoutData(new FillLayout());
		IDocument document = new Document("");
		viewer.setDocument(document);
		
		setContentAssist(sourceViewConfiguration, viewer);
		setContextMenu(styledTextComposite, editor, document, styledText);
		return styledText;
	}

	private void setContentAssist(XPathSourceViewerConfiguration sourceViewConfiguration, ISourceViewer viewer) {
		
		final SourceViewer sourceViewer = (SourceViewer)viewer;
		sourceViewer.appendVerifyKeyListener( new VerifyKeyListener() {
				      public void verifyKey(VerifyEvent event) {

				      if (event.stateMask == SWT.CTRL && event.character == ' ') {

				        if (sourceViewer.canDoOperation(SourceViewer.CONTENTASSIST_PROPOSALS)) {
				        	sourceViewer.doOperation(SourceViewer.CONTENTASSIST_PROPOSALS);
				        }
				        //to avoid further processing
				        event.doit = false;
				      }
				   }
				});
		
		ContentAssistant assitant = sourceViewConfiguration.getBpelAssistant();
		if (assitant != null) {
			IContentAssistProcessor processor = assitant.getContentAssistProcessor(IDocument.DEFAULT_CONTENT_TYPE);
			if (processor instanceof ExpressionContentAssistProcessor) {
				final ExpressionContentAssistProcessor exprProcessor  = (ExpressionContentAssistProcessor)processor;
				exprProcessor.setPropertySection(this);
			}
			
			assitant.addCompletionListener(new ICompletionListener() {
				
				@Override
				public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
				}
				
				@Override
				public void assistSessionStarted(ContentAssistEvent event) {
				}
				
				@Override
				public void assistSessionEnded(ContentAssistEvent event) {
					//Have to rub this asynchronously since we have to wait till text editor updates itself with the proposal
					Display.getDefault().asyncExec(new Runnable() {
						
						@Override
						public void run() {
							updateExpressionToModel();
						}
					});
				}

			});
			
		}
	}
	
	private void updateExpressionToModel() {
		super.saveExpressionToModel();
	}

	private void setContextMenu(Composite styledTextComposite,
			final Composite editor, final IDocument document,
			final StyledText styledText) {
		
		Menu menu = new Menu(styledTextComposite.getShell(), SWT.POP_UP);
		addEditMenuItem(styledText, menu, "Cut", ST.CUT);
		addEditMenuItem(styledText, menu, "Copy", ST.COPY);
		addEditMenuItem(styledText, menu, "Paste", ST.PASTE);
		addVariablePickerMenuItem(editor, document, styledText, menu);
		styledTextComposite.setMenu(menu);
		styledText.setMenu(menu);
	}

	private void addVariablePickerMenuItem(final Composite editor,
			final IDocument document, final StyledText styledText, Menu menu) {
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Variable Picker..");
		item.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				popupVariablePickerDialog(editor, styledText, document);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	private void addEditMenuItem(final StyledText styledText, Menu menu, String editAction, final int styledTextAction ) {
		MenuItem cutItem = new MenuItem(menu, SWT.PUSH);
		cutItem.setText(editAction);
		cutItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.invokeAction(styledTextAction);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	private void popupVariablePickerDialog(Composite editor, StyledText styledText, IDocument document){
		VariableTreeContentProvider variableContentProvider = new VariableTreeContentProvider(true, false, false);
        
        ElementTreePreviewSelectionDialog dialog = new ElementTreePreviewSelectionDialog (
        		editor.getShell(), 
        		new ModelTreeLabelProvider(), 
        		variableContentProvider);
        
		dialog.setTitle( "Select Variable" );
		dialog.setAllowMultiple(false);
		
		if (this instanceof ExpressionAssignCategory) {
			ExpressionAssignCategory expAssign = (ExpressionAssignCategory)this;
			EObject eObject = expAssign.getInput();
			dialog.setInput( eObject );
		}
		
		if (dialog.open() == Window.OK) {
			String result = dialog.getPreviewResult();
			replaceText(styledText, document, result);				
		}
	}

	private void replaceText(StyledText styledText, IDocument document,
			String result) {
	   Point sel = styledText.getSelectionRange();
	   int offset = sel.x;
	   int length = sel.y;
		
	   try {
			   document.replace(offset, length, result);
			   updateExpressionToModel();
	   }
	   catch (BadLocationException ble) {
			   ble.printStackTrace();
	   }
	}
	

	protected String getExpressionLanguage() {
		return BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_2007;
	}
}