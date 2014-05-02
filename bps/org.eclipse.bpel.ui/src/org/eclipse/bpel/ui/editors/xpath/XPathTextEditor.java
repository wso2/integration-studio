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
package org.eclipse.bpel.ui.editors.xpath;

import java.util.ResourceBundle;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.contentassist.ExpressionContentAssistProcessor;
import org.eclipse.bpel.ui.editors.TextEditor;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.bpel.ui.preferences.PreferenceConstants;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;


/**
 * The XPath Text Editor.
 * 
 * A bunch of the code is borrowed from the Java Text Editor. 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 26, 2006
 */


public class XPathTextEditor extends TextEditor {
	
	/** The editor id, based on the name of our class */
	public static final String XPATH_EDITOR_ID = XPathTextEditor.class.getName();
	
	/** Matchable character pairs */
	protected final static char[] BRACKETS= { '(', ')', '[', ']' };
	
	/** The editor's bracket maTtcher */
	protected XPathCharPairMatcher fBracketMatcher= new XPathCharPairMatcher(BRACKETS);
	
	/** The bracket inserter. */
	BracketInserter fBracketInserter= new BracketInserter();	
	
	private ColorManager fColorManager;
	
	IWhitespaceDetector fWhitespaceDetector = new XPathWhitespaceDetector();

	VariablePickerAction fVariablePickerAction;

	/** Decoration for the content assist */
	private ControlDecoration decoration;
	
	/**
	 * 
	 */
	public XPathTextEditor() {
		super();
		fColorManager = new ColorManager();
		
		setSourceViewerConfiguration(new XPathSourceViewerConfiguration(fColorManager) ); 
	}
	
	/**
	 * 
	 */
	@Override
	
	protected void createActions() {
		super.createActions();
		
		ResourceBundle bundle = ResourceBundle.getBundle("bpelexpression"); //$NON-NLS-1$
		Action action = new ContentAssistAction(bundle, "ContentAssistProposal.", this);  //$NON-NLS-1$
		String id = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(id);
		setAction("ContentAssistProposal", action);  //$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
		

		
		fVariablePickerAction = new VariablePickerAction(XPathEditorMessages.getBundleForConstructedKeys(), "Editor.VariablePicker.", this); //$NON-NLS-1$
		// action.setHelpContextId(IAbstractTextEditorHelpContextIds.GOTO_LINE_ACTION);
		fVariablePickerAction.setActionDefinitionId(IXPathEditorActionDefinitionIds.VARIABLE_PICKER);
		setAction(IXPathEditorActionConstants.VARIABLE_PICKER, fVariablePickerAction);
		
		
	}
	
	
	@Override
	protected void doSetInput (IEditorInput input) throws CoreException {
		
		super.doSetInput(input);
		
		ExpressionContentAssistProcessor caproc = (ExpressionContentAssistProcessor)
							this.getSourceViewerConfiguration().
							getContentAssistant( this.getSourceViewer() ).
							getContentAssistProcessor(IDocument.DEFAULT_CONTENT_TYPE);
	
		EObject eObj = (EObject) input.getAdapter(EObject.class);
		
		if (eObj != null) {
			caproc.setModelObject( eObj );
		}
		
		String expressionContext = (String) input.getAdapter(Integer.class);
		if (expressionContext != null) {
			caproc.setExpressionContext(expressionContext);
			// 
			if (fVariablePickerAction != null) {
				fVariablePickerAction.setEnabled(expressionContext.indexOf(IEditorConstants.ET_JOIN) < 0);
			}
		}
	}		
	
	/**
	 * @see AbstractTextEditor#createPartControl(Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		super.createPartControl(parent);
					
		IPreferenceStore preferenceStore= getPreferenceStore();
		boolean closeBrackets= preferenceStore.getBoolean(PreferenceConstants.EDITOR_CLOSE_BRACKETS);
		boolean closeStrings= preferenceStore.getBoolean(PreferenceConstants.EDITOR_CLOSE_STRINGS);
		
		fBracketInserter.setCloseBracketsEnabled(closeBrackets);
		fBracketInserter.setCloseStringsEnabled(closeStrings);
		
		ISourceViewer sourceViewer = getSourceViewer();
		
		if (sourceViewer instanceof ITextViewerExtension) {
			((ITextViewerExtension) sourceViewer).prependVerifyKeyListener(fBracketInserter);
		}
		
	}
	
	
	/**
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#editorContextMenuAboutToShow(org.eclipse.jface.action.IMenuManager)
	 * @since 3.1
	 */
	
	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {
		
		super.editorContextMenuAboutToShow(menu);

		IAction variablePicker = getAction(IXPathEditorActionConstants.VARIABLE_PICKER);
		menu.add( new Separator() );
		menu.add( variablePicker );
		
//		menu.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, new Separator(ITextEditorActionConstants.GROUP_SETTINGS));
//		menu.appendToGroup(ITextEditorActionConstants.GROUP_SETTINGS, preferencesAction);
//		
//		menu.appendToGroup(ITextEditorActionConstants.GROUP_SAVE, new Separator(ITextEditorActionConstants.GROUP_OPEN));
//		MenuManager showInSubMenu= new MenuManager(getShowInMenuLabel());
//		showInSubMenu.add(ContributionItemFactory.VIEWS_SHOW_IN.create(getEditorSite().getWorkbenchWindow()));
//		menu.appendToGroup(ITextEditorActionConstants.GROUP_OPEN, showInSubMenu); 
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#dispose()
	 */
	@Override
	
	public void dispose() 
    {
		fColorManager.dispose();
		fBracketMatcher.dispose();
		
		ISourceViewer sourceViewer= getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension) {
			((ITextViewerExtension) sourceViewer).removeVerifyKeyListener(fBracketInserter);
		}
		
		super.dispose();		
	}

    
	
    
   
    
    
    @Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		
		support.setCharacterPairMatcher(fBracketMatcher);
		support.setMatchingCharacterPainterPreferenceKeys(
				PreferenceConstants.EDITOR_MATCHING_BRACKETS, 
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR);
		
		super.configureSourceViewerDecorationSupport(support);
	}

	@Override
	protected void setPreferenceStore (IPreferenceStore store) {
		if (store != null) {
			PreferenceConstants.initializeDefaultValues( store );
		}
		super.setPreferenceStore(store);
	}
	
	
	/**
	 * @see AbstractTextEditor#handlePreferenceStoreChanged(PropertyChangeEvent)
	 */
	@Override
	protected void handlePreferenceStoreChanged (PropertyChangeEvent event) {
		
		String p = event.getProperty();		
		
		if (PreferenceConstants.EDITOR_CLOSE_BRACKETS.equals(p)) {
			fBracketInserter.setCloseBracketsEnabled(getPreferenceStore().getBoolean(p));
			return;	
		}

		if (PreferenceConstants.EDITOR_CLOSE_STRINGS.equals(p)) {
			fBracketInserter.setCloseStringsEnabled(getPreferenceStore().getBoolean(p));
			return;
		}
								
		super.handlePreferenceStoreChanged(event);
	}
	
	/**
	 * Enable/disable content assist decoration
	 * @param enabled
	 */
	public void setDecoration(boolean enabled) {
		if (enabled){
			decoration = new ControlDecoration(getSourceViewer().getTextWidget(), SWT.TOP | SWT.LEFT);
			decoration.setMarginWidth(25);
			decoration.setDescriptionText("Content Assist Available (Ctrl+Space)");
			decoration.setShowOnlyOnFocus(true);
			FieldDecoration dec = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL);
			decoration.setImage(dec.getImage());
		} else {
			decoration.dispose();
		}
	}

	/*** Private Classes */
	
	class BracketInserter implements VerifyKeyListener  {
		
		private boolean fCloseBrackets = true;
		private boolean fCloseStrings  = true;		
		
		/**
		 * @param enabled
		 */
		public void setCloseBracketsEnabled(boolean enabled) {
			fCloseBrackets= enabled;
		}

		/**
		 * @param enabled
		 */
		public void setCloseStringsEnabled(boolean enabled) {
			fCloseStrings= enabled ;
			
		}

		private boolean hasIdentifierToTheRight(IDocument document, int offset) {
			try {
				int end= offset;
				IRegion endLine= document.getLineInformationOfOffset(end);
				int maxEnd= endLine.getOffset() + endLine.getLength();
				while (end != maxEnd &&  fWhitespaceDetector.isWhitespace(document.getChar(end)))
					++end;

				return end != maxEnd && Character.isJavaIdentifierPart(document.getChar(end));

			} catch (BadLocationException e) {
				// be conservative
				return true;
			}
		}

		private boolean hasIdentifierToTheLeft(IDocument document, int offset) {
			try {
				int start= offset;
				IRegion startLine= document.getLineInformationOfOffset(start);
				int minStart= startLine.getOffset();
				while (start != minStart && fWhitespaceDetector.isWhitespace(document.getChar(start - 1)))
					--start;
				
				return start != minStart && Character.isJavaIdentifierPart(document.getChar(start - 1));

			} catch (BadLocationException e) {
				return true;
			}			
		}

		private boolean hasCharacterToTheRight(IDocument document, int offset, char character) {
			try {
				int end= offset;
				IRegion endLine= document.getLineInformationOfOffset(end);
				int maxEnd= endLine.getOffset() + endLine.getLength();
				while (end != maxEnd && fWhitespaceDetector.isWhitespace(document.getChar(end)))
					++end;
				
				return end != maxEnd && document.getChar(end) == character;


			} catch (BadLocationException e) {
				// be conservative
				return true;
			}			
		}


		
		private boolean hasCharacterAtOffset (IDocument document, int offset, char character) {
			try {
				return document.getChar(offset) == character ;
			} catch (BadLocationException e) {
				return false;
			}		
		}

		
		/**
		 *  (non-Javadoc)
		 * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
		 */
		
		@SuppressWarnings("fallthrough")
		public void verifyKey(VerifyEvent event) {			

			if (!event.doit || getInsertMode() != SMART_INSERT) {
				return;
			}
				
			ISourceViewer sourceViewer = getSourceViewer();
			IDocument document= sourceViewer.getDocument();

			final Point selection= sourceViewer.getSelectedRange();
			final int offset= selection.x;
			final int length= selection.y;

			switch (event.character) {
			
			case ']' :
				if (!fCloseBrackets) {
					return ;
				}
				// Fall through
				
			case ')':				
				if (hasCharacterAtOffset(document, offset + length, event.character ) ) {
					sourceViewer.setSelectedRange(offset + length + 1,0);
					event.doit = false;
					return ;
				}
				break; 				
				
			case '(':
				if (hasCharacterToTheRight(document, offset + length, '('))
					return;

				// fall through

			case '[':
					if (!fCloseBrackets)
						return;
					if (hasIdentifierToTheRight(document, offset + length))
						return;
			
				// fall through
			
			case '\'':
				if (event.character == '\'') {
					if (!fCloseStrings)
						return;
					
					if ( hasCharacterAtOffset(document,offset-1,'\\')) {
						return ;
					}					

					if ( hasCharacterAtOffset(document,offset + length,'\'') ) { 
						sourceViewer.setSelectedRange(offset + length + 1,0);
						event.doit = false;
						return ;
					}
					
					if (hasIdentifierToTheLeft(document, offset) || hasIdentifierToTheRight(document, offset + length)) {
						return;
					}					
				}
				
				// fall through

			case '"':
				if (event.character == '"') {
					if (!fCloseStrings)
						return;
					
					if ( hasCharacterAtOffset(document,offset-1,'\\')) {
						return ;
					}					
					if ( hasCharacterAtOffset(document,offset+length,'"') ) {																
						sourceViewer.setSelectedRange(offset+length+1,0);	
						event.doit = false;
						return ;
					}
					
					if (hasIdentifierToTheLeft(document, offset) || hasIdentifierToTheRight(document, offset + length))
						return;
					
				}
				
				try {		
//					ITypedRegion partition= TextUtilities.getPartition(document, IJavaPartitions.JAVA_PARTITIONING, offset, true);
////					if (! IDocument.DEFAULT_CONTENT_TYPE.equals(partition.getType()) && partition.getOffset() != offset)
//					if (! IDocument.DEFAULT_CONTENT_TYPE.equals(partition.getType()))
//						return;
//						
					if (!validateEditorInputState()) {
						return ;
					}

					final StringBuffer buffer= new StringBuffer();
					buffer.append( event.character );
					buffer.append( getPeerCharacter(event.character) );

					document.replace(offset, length, buffer.toString());
					
					// move to the right of the inserted element
					sourceViewer.setSelectedRange(offset+1,0);
					
//					
//					BracketLevel level= new BracketLevel();
//					fBracketLevelStack.push(level);
//					
//					LinkedPositionGroup group= new LinkedPositionGroup(); 
//					group.addPosition(new LinkedPosition(document, offset + 1, 0, LinkedPositionGroup.NO_STOP));
//
//					LinkedModeModel model= new LinkedModeModel();
//					model.addLinkingListener(this);
//					model.addGroup(group);
//					model.forceInstall();
//					
//					level.fOffset= offset;
//					level.fLength= 2;
//			
//					// set up position tracking for our magic peers
//					if (fBracketLevelStack.size() == 1) {
//						document.addPositionCategory(CATEGORY);
//						document.addPositionUpdater(fUpdater);
//					}
//					level.fFirstPosition= new Position(offset, 1);
//					level.fSecondPosition= new Position(offset + 1, 1);
//					document.addPosition(CATEGORY, level.fFirstPosition);
//					document.addPosition(CATEGORY, level.fSecondPosition);
//					
//					level.fUI= new EditorLinkedModeUI(model, sourceViewer);
//					level.fUI.setSimpleMode(true);
//					level.fUI.setExitPolicy(new ExitPolicy(closingCharacter, getEscapeCharacter(closingCharacter), fBracketLevelStack));
//					level.fUI.setExitPosition(sourceViewer, offset + 2, 0, Integer.MAX_VALUE);
//					level.fUI.setCyclingMode(LinkedModeUI.CYCLE_NEVER);
//					level.fUI.enter();
//					
//					
//					IRegion newSelection= level.fUI.getSelectedRegion();
					// sourceViewer.setSelectedRange(newSelection.getOffset(), newSelection.getLength());
	
					event.doit= false;

				} catch (BadLocationException e) {
					BPELUIPlugin.log(e);
				}
//					catch (BadPositionCategoryException e) {
//					BPELUIPlugin.log(e);
//				}
				break;	
			}
		}
	}
	
	static char getEscapeCharacter (char character) {
		switch (character) {
			case '"':
			case '\'':
				return '\\';
			default:
				return 0;
		}
	}
	
	static char getPeerCharacter(char character) {
		switch (character) {
			case '(':
				return ')';
				
			case ')':
				return '(';
				
			case '[':
				return ']';
				
			case '"':
				return character;
				
			case '\'':
				return character;
			
			default:
				throw new IllegalArgumentException();
		}					
	}

	public void addFocusListener(FocusListener focusListener) {
		getSourceViewer().getTextWidget().addFocusListener(focusListener);
	}
	
}
