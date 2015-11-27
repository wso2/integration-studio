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

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.fnmeta.model.Function;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetNamespaceMappingCommand;
import org.eclipse.bpel.ui.editors.TextEditorInput;
import org.eclipse.bpel.ui.editors.xpath.XPathTextEditor;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.properties.DateTimeSelector;
import org.eclipse.bpel.ui.properties.DurationSelector;
import org.eclipse.bpel.ui.util.BPELDateTimeHelpers;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * Expression language editor for XPath.
 */
@SuppressWarnings("nls")
public class XPathExpressionEditor extends AbstractExpressionEditor {

	static final String BOOLEAN_EXPR_DEFAULT = "true()"; //$NON-NLS-1$
	static final String UNSIGNED_INT_EXPR_DEFAULT = "1"; //$NON-NLS-1$
	
	static final String TEXT_STRING = Messages.XPathExpressionEditor_Text_0,
			LITERAL_STRING = Messages.XPathExpressionEditor_Literal_1;

	static final int TEXT = 0, LITERAL = 1;

	protected static final String DEFAULT_DURATION_VALUE = "\'P0D\'"; //$NON-NLS-1$

	protected Combo combo; // Expression type values

	protected Label comboLabel; // Expression type

	protected Composite mainComposite; // high level composite control

	protected XPathTextEditor textEditor; // expression text

	/** The date/time  selector, alternative to just plain text */
	protected DateTimeSelector dateTimeSelector;

	/** The duration selector, alternative to just plain text */
	protected DurationSelector durationSelector;

	protected IPropertyListener propertyListener;


	/** This composite holds a stack of editors, only the top one is shown */
	protected Composite editorComposite;

	/** The text editor composite, a child control of the editorComposite */
	protected Composite textEditorComposite;

	/** The duration editor composite, a child control of the editorComposiste */
	protected Composite durationEditorComposite;

	/** The date time editor composite, a child control of the editorComposiste */
	protected Composite dateTimeEditorComposite;

	// private int comboValue = -1;

	/** The input to the text editor. */
	protected TextEditorInput textEditorInput;
	
	private FocusListener focusListener;

	/**
	 * Create a brand new shiny XPathExpressionEditor ...
	 */

	public XPathExpressionEditor() {
		super();
	}

	/**
	 * Create controls ..
	 */
	@Override
	public void createControls(Composite parent, FormToolkit toolkit) {
		super.createControls(parent, toolkit);
		createEditor(parent);
	}

	protected void createEditor(Composite parent) {

		this.mainComposite = wf.createComposite( parent );
		FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 0;
		mainComposite.setLayout(layout);
		mainComposite.setBackground(BPELUIPlugin.INSTANCE.getColorRegistry()
				.get(IBPELUIConstants.COLOR_WHITE));
		comboLabel = wf.createLabel(mainComposite,
				Messages.XPathExpressionEditor_Expression_Type_2);

		combo = new Combo(mainComposite, SWT.BORDER | SWT.READ_ONLY | SWT.FLAT);

		combo.add(TEXT_STRING);
		combo.add(LITERAL_STRING);

		combo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				updateEditorToType(combo.getSelectionIndex());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		FormData data = new FormData();
		data.top = new FormAttachment(combo, 0, SWT.CENTER);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(combo,	-IDetailsAreaConstants.HSPACE);
		comboLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, IDetailsAreaConstants.VSPACE );
		data.left = new FormAttachment(0, BPELUtil.calculateLabelWidth(
				comboLabel, BPELPropertySection.STANDARD_LABEL_WIDTH_LRG));
		data.right = new FormAttachment(100, 0);
		combo.setLayoutData(data);

		// Create the editor composite
		// The editor composite will contain one of N editors.
		// We use stack layout, because only one editor is visible at a time.

		editorComposite = wf.createComposite(mainComposite);
		editorComposite.setLayout(new StackLayout());

		data = new FormData();
		data.top = new FormAttachment(combo,2 * IDetailsAreaConstants.VSPACE);
		data.left = new FormAttachment(0, 5);
		data.right = new FormAttachment(100, 0);
		data.bottom = new FormAttachment(100, 0);
		editorComposite.setLayoutData(data);
	}

	protected void rearrangeComboAndEditorComposite() {

		boolean comboVisible = isLiteralType();

		combo.setVisible(comboVisible);
		comboLabel.setVisible(comboVisible);

		if (editorComposite != null) {
			FormData data = (FormData) editorComposite.getLayoutData();
			if (comboVisible) {
				data.top = new FormAttachment(combo,
						2 * IDetailsAreaConstants.VSPACE);
			} else {
				data.top = new FormAttachment(0,
						2 * IDetailsAreaConstants.VSPACE);
			}
		}

	}

	/**
	 * Gets the text editor composite, creates it if necessary and makes it
	 * visible by default.
	 * 
	 * @return the composite for the text editor ...
	 */

	Composite getTextEditorComposite() {
				
		if (textEditorComposite != null) {
			return textEditorComposite;
		}

				
		textEditorComposite = wf.createComposite(editorComposite,SWT.BORDER);
		textEditorComposite.setLayout(new FillLayout());
		textEditor = (XPathTextEditor) createEditor(
				XPathTextEditor.XPATH_EDITOR_ID,
				this.textEditorInput, 
				textEditorComposite);

		textEditor.addPropertyListener(getPropertyListener());
		textEditor.addFocusListener(getFocusListener());
		textEditor.setDecoration(true);
		
		return textEditorComposite;
	}

	protected FocusListener getFocusListener() {
		if (focusListener == null){
			focusListener = new FocusAdapter(){
			public void focusLost(FocusEvent e) {
				notifyFocusOut();
			}
		};}
		return focusListener;
	}

	Composite getDateTimeEditor() {
		if (dateTimeEditorComposite != null) {
			return dateTimeEditorComposite;
		}

		dateTimeEditorComposite = wf.createComposite(editorComposite, SWT.NONE);

		FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 0;
		dateTimeEditorComposite.setLayout(layout);

		Label label = wf.createLabel(dateTimeEditorComposite,
				Messages.XPathExpressionEditor_Date_Time_UTC_3);
		dateTimeSelector = new DateTimeSelector(wf, dateTimeEditorComposite,
				SWT.NONE, BPELDateTimeHelpers.yearMin,
				BPELDateTimeHelpers.yearMax);

		String body = (String) textEditorInput.getAdapter(String.class);

		int[] dateTime = BPELDateTimeHelpers.parseXPathDateTime(body, false);
		dateTimeSelector.setValues(dateTime);

		FormData data = new FormData();
		data.top = new FormAttachment(0, 10);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(dateTimeSelector,
				-IDetailsAreaConstants.HSPACE);
		label.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, 10);
		data.left = new FormAttachment(0, BPELUtil.calculateLabelWidth(
				label, BPELPropertySection.STANDARD_LABEL_WIDTH_LRG));
		// data.right = new FormAttachment(100, 0);
		dateTimeSelector.setLayoutData(data);

		dateTimeSelector.addSelectionListener(  new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				// Push new values to the text editor document so that
				// it is reflected next time we shift
				// to the text editor.
				
				if (textEditorInput != null) {
					int[] values = dateTimeSelector.getValues();         		        
					textEditorInput.setEditorContent ( BPELDateTimeHelpers.createXPathDateTime(values, false) , getModelObject() );
				}
				notifyChanged();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});	

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				dateTimeEditorComposite,
				IHelpContextIds.XPATH_DATE);

		return dateTimeEditorComposite;
	}

	/**
	 * Get or create the duration editor.
	 * 
	 * @return
	 */

	Composite getDurationEditor() {
		
		if (durationEditorComposite != null) {			
			return durationEditorComposite;
		}
		
	    durationEditorComposite = wf.createComposite(editorComposite, SWT.NONE);
	    FormLayout layout = new FormLayout();
	    layout.marginWidth = layout.marginHeight = 0;
	    durationEditorComposite.setLayout(layout);
	    
	    Label label = wf.createLabel(durationEditorComposite, Messages.XPathExpressionEditor_Duration_4); 
	    durationSelector = new DurationSelector(wf, durationEditorComposite, SWT.NONE);
	    
	    FormData data = new FormData();
	    data.top = new FormAttachment(0, 10);
	    data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(durationSelector, -IDetailsAreaConstants.HSPACE);	    
	    label.setLayoutData(data);

	    data = new FormData();
	    data.top = new FormAttachment(0, 10);
		data.left = new FormAttachment(0, BPELUtil.calculateLabelWidth(label, BPELPropertySection.STANDARD_LABEL_WIDTH_LRG));
		// data.right = new FormAttachment(100, 0);
		durationSelector.setLayoutData(data);

	    durationSelector.addSelectionListener( new SelectionListener() {	    	
			public void widgetSelected(SelectionEvent e) {
			 	
				// Push new values to the text editor document so that
				// it is reflected next time we shift
				// to the text editor.
				
				if (textEditorInput != null) {
					int[] duration = durationSelector.getValues();         		        
					textEditorInput.setEditorContent( BPELDateTimeHelpers.createXPathDuration(duration) , getModelObject() );
				}
			
			 }
			 public void widgetDefaultSelected(SelectionEvent e) { }
	    });
	    
	    PlatformUI.getWorkbench().getHelpSystem().setHelp(
	    		durationEditorComposite, IHelpContextIds.XPATH_DURATION);
	    
	    return durationEditorComposite;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#dispose()
	 */

	public void dispose() {

		if (textEditor != null) {
			getEditorManager().disposeEditor(textEditor);
			textEditor = null;
		}

		// This is the main composite of all the editors.
		if (editorComposite != null && !editorComposite.isDisposed()) {
			editorComposite.dispose();
			editorComposite = null;
		}
	}

	/**
	 * This is called from a number of places and we have to be smart to not
	 * create and re-create the editors every time refresh is called.
	 * 
	 */

	@Override
	public void refresh() {

		int editorType = combo.getSelectionIndex();

		if (editorType < 0) {
			String body = (String) textEditorInput.getAdapter(String.class);

			// TODO: try literal widgets!
			editorType = TEXT;
			if (BPELDateTimeHelpers.parseXPathDuration(body) != null) {
				editorType = LITERAL;
			} else if (BPELDateTimeHelpers.parseXPathDateTime(body, false) != null) {
				editorType = LITERAL;
			}
			// update the editor type
			combo.select(editorType);
		}

		updateEditorToType(editorType);
	}

	/**
	 * Update the editor to the right type.
	 * 
	 * @param editorType
	 */

	void updateEditorToType(int editorType) {

		String body = (String) textEditorInput.getAdapter(String.class);

		switch (editorType) {
		case TEXT:
			restackEditorComposite(getTextEditorComposite());
			break;
		case LITERAL:
			if (IEditorConstants.ET_DURATION.equals(getExprType())) {
				restackEditorComposite(getDurationEditor());

				int[] duration = BPELDateTimeHelpers.parseXPathDuration(body);
				if (duration != null) {
					durationSelector.setValues(duration);
				}
			} else {

				restackEditorComposite(getDateTimeEditor());

				int[] dateTime = BPELDateTimeHelpers.parseXPathDateTime(body,
						false);
				if (dateTime != null) {
					dateTimeSelector.setValues(dateTime);
				}
			}
			break;
		}
	}

	/**
	 * We re-stack the editors and have stack layout only show the top child
	 * control.
	 * 
	 * @param c
	 *            the editor composite for one of our editors.
	 */

	void restackEditorComposite(Composite c) {

		Layout layout = c.getParent().getLayout();

		if (layout instanceof StackLayout) {
			StackLayout stackLayout = (StackLayout) layout;
			if (c != stackLayout.topControl) {
				stackLayout.topControl = c;

				rearrangeComboAndEditorComposite();

				c.getParent().layout(true);
			}
		}
	}

	/**
	 * About to be hidden.
	 */

	public void aboutToBeHidden() {

	}

	/**
	 * The editor is about to be shown.
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#aboutToBeShown()
	 */

	public void aboutToBeShown() {
		refresh();
	}

	/**
	 * If the editor is dirty it registers an ongoing change.
	 */
	protected IPropertyListener getPropertyListener() {

		if (propertyListener == null) {
			propertyListener = new IPropertyListener() {
				public void propertyChanged(Object source, int propId) {
					if (propId == IEditorPart.PROP_DIRTY) {
						boolean isEditorDirty = false;
						if (textEditor != null) {
							isEditorDirty = textEditor.isDirty();
						}
						if (isEditorDirty) {
							notifyChanged();
						}
					}
				}
			};
		}
		return propertyListener;
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#getUserContext()
	 */
	public Object getUserContext() {
		return null;
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#restoreUserContext(java.lang.Object)
	 */
	public void restoreUserContext(Object userContext) {

		// TODO! this is bogus
		if (textEditor != null) {
			textEditor.setFocus();
		}
	}

	/**
	 * Return the body of the editor.
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#getEditorContent()
	 */
	@Override
	public String getEditorContent() {

		int editorType = combo.getSelectionIndex();

		if (editorType == LITERAL) {
			if (IEditorConstants.ET_DURATION.equals(getExprType())) {
				int[] duration = durationSelector.getValues();
				return BPELDateTimeHelpers.createXPathDuration(duration);
			}
			int[] dateTime = dateTimeSelector.getValues();
			return BPELDateTimeHelpers.createXPathDateTime(dateTime, false);
		}
		return textEditor.getContents();
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#setEditorContent(java.lang.String)
	 */
	@Override
	public void setEditorContent (String body) {		
		this.textEditorInput = new TextEditorInput(body, getModelObject(), getExprType() );
		// Refresh the text editor input, if not set
		if (textEditor != null) {
			textEditor.setInput(this.textEditorInput);
		}
	}

	/**
	 * Answer if the editor edits literal type expressions. These have their own
	 * editor UI to deal with that.
	 * 
	 * @return
	 */

	boolean isLiteralType() {
		return IEditorConstants.ET_DURATION.equals(getExprType())
				|| IEditorConstants.ET_DATETIME.equals(getExprType());
	}

	/**
	 * Return the default body for the given edit UI type.
	 * 
	 * @return the default body to throw into the editor.
	 */

	public String getDefaultContent() {

		if (isLiteralType()) {
			return getDefaultBody(LITERAL);
		}
		return getDefaultBody(TEXT);
	}

	protected String getDefaultBody(int comboValue) {
		String exprType = getExprType();
		switch (comboValue) {
		case TEXT: {
			if (exprType.indexOf(IEditorConstants.ET_BOOLEAN) >= 0) {
				return BOOLEAN_EXPR_DEFAULT;
			} else if (exprType.indexOf(IEditorConstants.ET_UNSIGNED_INT) >= 0) {
				return UNSIGNED_INT_EXPR_DEFAULT;
			}
			return ""; //$NON-NLS-1$
		}
		case LITERAL: {
			if (exprType.indexOf(IEditorConstants.ET_DURATION) >= 0) {
				return DEFAULT_DURATION_VALUE;
			}
			int[] dateTime = BPELDateTimeHelpers.getCurrentLocalDateTime();
			BPELDateTimeHelpers.convertLocalToGMT(dateTime);
			return BPELDateTimeHelpers.createXPathDateTime(dateTime, false);
		}
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#gotoTextMarker(org.eclipse.core.resources.IMarker, java.lang.String, java.lang.Object)
	 */
	public void gotoTextMarker(IMarker marker, String codeType,
			Object modelObject) {
		// TODO
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#supportsExpressionType(java.lang.String)
	 */
	
	public boolean supportsExpressionType ( String exprType ) {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#markAsClean()
	 */

	public void markAsClean() {
		if (textEditor != null) {
			textEditor.markAsClean();
		}
	}

	
	/**
	 * This is probably not the best place to do this, but we do need to do this someplace ...
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#addExtraStoreCommands(org.eclipse.gef.commands.CompoundCommand)
	 */	
	@Override
	public void addExtraStoreCommands (CompoundCommand compoundCommand) {
		
		EObject eObj = (EObject) getModelObject();
		
		for(Function fn : Functions.getInstance(BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE_2007).getFunctions().values()) {
			
			if (BPELUtils.isEmptyOrWhitespace(fn.getNamespace()) || BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE.equals(fn.getNamespace())) {
				continue;
			}
			
			String pfx = BPELUtils.getNamespacePrefix( eObj, fn.getNamespace());
			
			if (pfx == null) {
				compoundCommand.add(new SetNamespaceMappingCommand(eObj, fn.getNamespace(), fn.getPrefix() )) ;
			}
		}
		
	}

}
