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

import java.util.ArrayList;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.widgets.DecoratedLabel;
import org.eclipse.bpel.common.ui.details.widgets.StatusLabel2;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.details.providers.ExpressionEditorDescriptorContentProvider;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.bpel.ui.expressions.IExpressionEditor;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.ExpressionEditorDescriptor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;



/**
 * Base class with some shared behavior for details panes that edit an expression.
 * 
 * NB: Nov 2nd, 2006
 * 
 * The code used CComboViewer and CCombo to show the expression language drop down. 
 * There used to be a lot of code that dealt with refresh and selection disappearing in the
 * CCombo to the point that the XPath editor was created and destroyed 14 times every time a 
 * object was selected in the process map that required this particular expression section.
 * 
 * I debugged the code, I swear it was this bad.
 * 
 * I had done some cleanup here to make it easier to understand because there is truly a little
 * too much magic for this simple thing. So ...
 * 
 * <ol>
 * <li> The expression language is a Combo, wrapped in a ComboViewer.
 * <li> The ComboViewer has a content provider which it will refresh every time a setInput is 
 * used on the ComboViewer. Any other refresh logic is not necessary.
 * <li> The section is configured when the basicSetInput is called. Then the editor is picked,created, etc.
 * <li> There is a general problem with refresh() method calls, .aboutToBeShown(), etc. many of them simply 
 * used to call refresh() which just destroyed and re-created the views. 
 * 
 * </ol>
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */
public abstract class ExpressionSection extends TextSection {
	
	 
	protected String editorLanguage;
	
	protected ComboViewer expressionLanguageViewer;	
	
	protected ExpressionComboContentProvider expressionComboContentProvider;
	
	/** The editor area composite, it is used to display editors or the no-editor widgets in it */
	protected Composite fEditorArea ;
	
	
	// Pseudo-model object to represent no expression at all (in which case no editor
	// is used).
	protected static final Object NO_EXPRESSION = new Object();
	
	// Pseudo-model object to represent the absence of an expression language within
	// the expression (i.e. the expression language is inherited from the Process).
	protected static final Object SAME_AS_PARENT = new Object();
	
	/** The composite which holds the no-editor widgets */
	protected Composite fNoEditorWidgets;

	/** The parent composite, it owns the expression language combo and the editor area */
	protected Composite fParentComposite;

	protected Font boldFont;

	protected String title;

	protected Label titleLabel;

	StackLayout fEditorAreaStackLayout;

	Composite fEditorComposite;

	protected StatusLabel2 expressionLanguageLabel;

	/** The EMF structural feature that is this expression */
	protected EStructuralFeature fStructuralFeature;

	protected Button fCreateExpressionButton;

	Combo expressionLanguageCombo;

	
	protected static boolean objectsEqual(Object lhs, Object rhs) {
		if (lhs == null) return (rhs == null);
		return lhs.equals(rhs);
	}
	

	
	/**
	 * A content provider which (1) adds the NO_EXPRESSION and SAME_AS_PARENT elements,
	 * (2) ensures that the selected object is in the list, and (3) removes any
	 * elements from the list which are not supported (unless they happen to be
	 * the selected object at the moment--an error case).
	 */
		
	
	class ExpressionComboContentProvider extends ExpressionEditorDescriptorContentProvider {
		Object selectedObject = SAME_AS_PARENT;
		
		
		/**
		 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#getElements(java.lang.Object)
		 */
		@Override
		public Object[] getElements(Object inputElement) {
			Object[] descriptors = super.getElements(inputElement);
			
			ArrayList<Object> result = new ArrayList<Object>(descriptors.length + 2);
			if (isExpressionOptional() || selectedObject==NO_EXPRESSION) {
				result.add(NO_EXPRESSION);
			}
			if (selectedObject==SAME_AS_PARENT || allowItem(SAME_AS_PARENT)) {
				result.add(SAME_AS_PARENT);
			}
			for (Object descriptor : descriptors) {
				if (objectsEqual(selectedObject, descriptor) ||	allowItem(descriptor)) {
					result.add(descriptor);
				}
			}
			if (!result.contains(selectedObject)) {
				result.add(selectedObject);
			}
			return result.toArray();
		}
		/**
		 * 
		 * @param element
		 * @return true if item is to be allowed, false otherwise.
		 */
		public boolean allowItem(Object element) {
			String language = getEffectiveLanguage(getExpressionLanguage(element));
			try {
				IExpressionEditor exEditor = BPELUIRegistry.getInstance().getExpressionEditor(language);
				return (exEditor == null)? false : isEditorSupported(exEditor);
			} catch (CoreException e) {
				BPELUIPlugin.log(e);
				return false;
			}
		}		
	}
	
	
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Expression e = getExprFromModel();
		if (e != null) {
			fAdapters[0].addToObject(e);
		}
	}

	/**
	 * Get rid of the current editor.
	 * We do this when the Expression Language changes and we have to replace the editor with the right
	 * editor for the expression language.
	 */
	
	@Override
	protected void disposeEditor() {		
	    super.disposeEditor();
		editorLanguage = null;
		if (fEditorComposite != null) {
			fEditorComposite.dispose();
			fEditorComposite = null;
		}
	}
	
	
	protected Object getDefaultBody (String newLanguage, String exprType ) {
		
		IExpressionEditor ed = null;
		try {
			newLanguage = getEffectiveLanguage(newLanguage);
			ed = BPELUIRegistry.getInstance().getExpressionEditor(newLanguage);
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
			return EMPTY_STRING;
		}
		
		// TODO: call supportsExpressionType in the right place
		ed.setExpressionType(exprType);
		ed.setModelObject( getInput() );
		return ed.getDefaultContent() ;
	}
	
	
	protected void createTitleWidgets(Composite composite) {
		FlatFormData data;
		titleLabel = fWidgetFactory.createLabel(composite, title);
		titleLabel.setFont(boldFont);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		titleLabel.setLayoutData(data);
	}
	
	protected void createExpressionLanguageWidgets(final Composite composite) {

		FlatFormData data;
		
		DecoratedLabel nameLabel = new DecoratedLabel(composite,SWT.LEFT);
		fWidgetFactory.adapt(nameLabel);		
		nameLabel.setText( Messages.ExpressionSection_Expression_language_1); 
		expressionLanguageLabel = new StatusLabel2( nameLabel );				
		expressionLanguageCombo = new Combo (composite, SWT.FLAT | SWT.READ_ONLY );
		fWidgetFactory.adapt(expressionLanguageCombo);
		
		expressionLanguageViewer = new ComboViewer(expressionLanguageCombo);				
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(nameLabel, STANDARD_LABEL_WIDTH_LRG));
		data.right = new FlatFormAttachment(100, 0);
		if (this.title != null) {
			data.top = new FlatFormAttachment(this.titleLabel, IDetailsAreaConstants.VSPACE);
		} else {
			data.top = new FlatFormAttachment(0, 0);
		}
		expressionLanguageViewer.getControl().setLayoutData(data);


		expressionLanguageViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == NO_EXPRESSION) {
					return Messages.ExpressionSection_No_Expression_2; 
				}
				
				if (element == SAME_AS_PARENT) {
					String text = getBPELEditor().getProcess().getExpressionLanguage();
					if (text == null) {
						text = BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE;
					}
					ExpressionEditorDescriptor descriptor = BPELUIRegistry.getInstance().getExpressionEditorDescriptor(text);
					if (descriptor != null) {
						text = descriptor.getLabel();
					}
					return NLS.bind(Messages.ExpressionSection_Same_as_Process_1, (new Object[] { text })); 
				}
				if (element instanceof String) {
					return (String)element;	
				}
				ExpressionEditorDescriptor descriptor = (ExpressionEditorDescriptor) element;
				String text = descriptor.getLabel();
				return (text != null) ? text : descriptor.getExpressionLanguage();
			}
		});
		
		expressionComboContentProvider = new ExpressionComboContentProvider();		
		expressionLanguageViewer.setContentProvider(expressionComboContentProvider);
		expressionLanguageViewer.setInput( SAME_AS_PARENT );
		
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(expressionLanguageViewer.getControl(), -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(expressionLanguageViewer.getControl(), 0, SWT.CENTER);
		expressionLanguageLabel.setLayoutData(data);
		
		// Selection on the combo.
		expressionLanguageCombo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);				
			}

			public void widgetSelected(SelectionEvent e) {								
				updateFromSelection ( selectedExpressionLanguage() );
			}
		
		});			
	}
	
	protected void updateFromSelection ( Object elm ) {

		Command cmd; 
		
		if (elm == NO_EXPRESSION || elm == null ) {
			cmd = new SetCommand(getExpressionTarget(), null, getStructuralFeature() );
		} else {					
			
			String language = getExpressionLanguage(elm);											
			Expression exp = BPELFactory.eINSTANCE.createCondition();					
			exp.setExpressionLanguage(language);

			Object newDefaultBody = getDefaultBody(language, getExpressionType()  );
			
			// Figure out what the new default value should be for this expression,
			// 	and install it in the model.  It is necessary to do this before we
			// 	properly create the editor (which happens when we update widgets in
			// response to the model change).
			exp.setBody(newDefaultBody);
								
			cmd = new SetCommand(getExpressionTarget(), getExpression4Target (exp), getStructuralFeature()) ;
		}
		
		getCommandFramework().execute( wrapInShowContextCommand(cmd) ); 
	}
	
	/**
	 * Return the currently selected expression language.
	 * 
	 * @return the currently selected expression language
	 */
	
	protected Object selectedExpressionLanguage () {
		IStructuredSelection selection = (IStructuredSelection) expressionLanguageViewer.getSelection();
		return selection.getFirstElement();		
	}
	
	/**
	 * This method is used by subclasses who need to select a language programmatically.
	 * 
	 */
	
	protected void doChooseExpressionLanguage (Object model) {
		
		Object selection = selectedExpressionLanguage();
		if (selection == model) {
			return ;
		}
		
		// By setting the selection on the combo box, we are kicking off a selection changed event.
		// This is intentional, because we are emulating the a user interface command.
		
		expressionLanguageViewer.setSelection(new StructuredSelection( model ), true);
		updateFromSelection( selectedExpressionLanguage() );
	}
	
	
	protected void updateExpressionLanguageWidgets() {
        
		Object model = NO_EXPRESSION;
        if (getExprFromModel() != null) {
			String language = getExpressionLanguageFromModel();
	        if (language == null) {
	            model = SAME_AS_PARENT;
	        } else {
	            model = BPELUIRegistry.getInstance().getExpressionEditorDescriptor(language);
	            if (model == null) {
	            	model = language;
	            }
	        }
        }
        
		expressionLanguageViewer.setSelection( new StructuredSelection( model ), true );				
		
		// Reflect the model in the editor
		updateEditor();
		
		// Markers
		updateMarkers();
    }
	
	
	/**
	 *  When this method is called, the section has already been created.
	 *  
	 *  The widgets are available to be configured, however, the section may not be shown yet.
	 *  
	 *  The concept here is that we are reflecting the input selected in the UI. So the path that is taken
	 *  by this code must not create any re-doable commands, just set the widgets to what they are supposed to
	 *  be based on the model.
	 */
	
	
	@Override
	protected void basicSetInput (EObject newInput) {
		
		super.basicSetInput(newInput);
		
		/** Figure out based in the input, what EMF structural feature we are setting */
		setStructuralFeature ( getStructuralFeature (newInput) );
		
		// A different input may have different expression language settings.
		expressionLanguageViewer.refresh(true);
				 
		// Reveal the right selection in the widget.
		updateExpressionLanguageWidgets();		
	}
	

	protected void setStructuralFeature ( EStructuralFeature feature ) {
		fStructuralFeature = feature;
	}
	
	/**
	 * Get the structural feature of this input object.
	 * This will be something like BPELPackage.eINSTANCE.getWait_Until()
	 *  
	 * @param eObject
	 * @return the structural feature that we will be setting.
	 */
	
	protected EStructuralFeature getStructuralFeature ( EObject eObject ) {
		return null;
	}
	
	
	/** 
	 * Return the previously computed structural feature of the input object.
	 * @return
	 */
	protected EStructuralFeature getStructuralFeature () {
		return fStructuralFeature;
	}
	
	protected boolean isExpressionOptional() { 
		return true; 
	}

	
	protected String getExpressionType() { 
		return IEditorConstants.ET_ANY ; 
	}
	
		
	/** 
	 * The expression target is the target object on which we can execute
	 * the SetCommand(target,object,structural-feature).
	 * 
	 * In most cases, it is just the input of the section. But in some cases
	 * the input if the section does not match the target, so sub-classes
	 * may override this method.
	 * 
	 * @return
	 */
	protected EObject getExpressionTarget () {
		return getInput();
	}
	
	
	/**
	 * Returns the expressionLanguage string underlying the given combo element.  For
	 * cases other than NO_EXPRESSION, this is the proper value to store into the model.
	 */
	protected String getExpressionLanguage (Object comboElement) {
		if (comboElement == NO_EXPRESSION || comboElement == SAME_AS_PARENT) {
			return null;
		}
		String language = null;
		if (comboElement instanceof ExpressionEditorDescriptor) {
		    language = ((ExpressionEditorDescriptor)comboElement).getExpressionLanguage();
		} else if (comboElement instanceof String) {
			language = (String)comboElement;
		}
		if (EMPTY_STRING.equals(language)) {
			language = null; 
		}
		return language;
	}
	
	/**
	 * Returns the expression language which will be in effect if this language is
	 * read from/stored into the model.  (i.e. if language is null, the value is
	 * inherited from the process or the default, XPath). 
	 */
	protected String getEffectiveLanguage(String language) {
		if (language == null) {
			language = getBPELEditor().getProcess().getExpressionLanguage();
			if (language == null) {
				language = BPELConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE;
			}
		}
		return language;
	}
	
	/**
	 * Return the actual namespace from the expression, or null if not set.
	 */
	protected String getExpressionLanguageFromModel() {
		Expression expression = getExprFromModel();
		if (expression == null) {
			return null;
		}
		return expression.getExpressionLanguage();
	}
	
	
	
	protected Expression getExprFromModel() {
		
		EObject target = getExpressionTarget();		
		if (target != null) {
			Object result = target.eGet( getStructuralFeature() );		
			if (result instanceof Expression) {
				return (Expression) result;
			}
		}		
		return null;
	}
	
	
	protected Expression getExpression4Target ( Expression expression ) {
		return expression;
	}
	
	
	
	@Override
	protected boolean isBodyAffected(Notification n) {
		
		if (n.getOldValue() instanceof Expression ||
			n.getNewValue() instanceof Expression ||
			n.getNotifier() instanceof Expression) {
			
			return true;
		}
		return n.getFeature() == getStructuralFeature();			
	}

	
	@Override
	protected Command newStoreToModelCommand (Object body) {
		
		CompoundCommand result = new CompoundCommand();		
		Expression oldExp = getExprFromModel();
		
		Expression exp = BPELFactory.eINSTANCE.createCondition();
		
		// Don't set the language, because if the user has changed the
		// language, a condition would already exist at this point.
		
		if (oldExp != null) {
			exp.setExpressionLanguage(oldExp.getExpressionLanguage());
		}
		exp.setBody(body);
		
		result.add (new SetCommand(getExpressionTarget(), getExpression4Target(exp) , getStructuralFeature() ));
		fEditor.addExtraStoreCommands (result);
		
		return result;
	}
	
	
	/**
	 * Create the client area. This is just done once.
	 */
	
	@Override
	protected void createClient (Composite parent) {
		
		fParentComposite =  createFlatFormComposite(parent);
		
		if (this.title != null) {
			createBoldFont(fParentComposite);
			createTitleWidgets(fParentComposite);
		}
		
		createExpressionLanguageWidgets(fParentComposite);
		
		FlatFormData data = new FlatFormData();
		
		data.top = new FlatFormAttachment(expressionLanguageViewer.getControl(),IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0,0);
		data.right = new FlatFormAttachment(100,0);
		data.bottom = new FlatFormAttachment(100,0);
					
		fEditorArea = fWidgetFactory.createComposite(fParentComposite);			
		
		fEditorAreaStackLayout = new StackLayout();
		fEditorArea.setLayout( fEditorAreaStackLayout );		
		fEditorArea.setLayoutData(data);
		
		fNoEditorWidgets = createNoEditorWidgets(fEditorArea);
		
		fEditorAreaStackLayout.topControl = fNoEditorWidgets;			
		
		createChangeHelper();
	}
		
	
	protected Composite createNoEditorWidgets (Composite composite) {
		return fWidgetFactory.createComposite(composite);
	}
	
	protected Composite createNoEditorWidgetsCreateComposite (Composite composite, String message, String buttonMessage ) {
			    	    
		FlatFormData ffdata;
		
		Composite section = createFlatFormComposite(composite);		
				
		Label label = fWidgetFactory.createLabel(section,EMPTY_STRING, SWT.WRAP | SWT.READ_ONLY  );
		
		ffdata = new FlatFormData();
		ffdata.left = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE );
		ffdata.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE * 2);
		ffdata.right = new FlatFormAttachment(100, 0);
		label.setLayoutData(ffdata);
		
		
		fCreateExpressionButton = fWidgetFactory.createButton(section, buttonMessage , SWT.PUSH); 
		ffdata = new FlatFormData();
		ffdata.left = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		ffdata.top = new FlatFormAttachment(label, IDetailsAreaConstants.VSPACE * 2);
		fCreateExpressionButton.setLayoutData(ffdata);
		
		fCreateExpressionButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				doChooseExpressionLanguage(SAME_AS_PARENT);
			}
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
		label.setText(message);
		
		return section;
	}
	
	
	/** 
	 * Create the editor.
	 * 
	 */
	
	@Override
	protected void createEditor (Composite parent) {
									
		String language = getEffectiveLanguage(getExpressionLanguageFromModel());
		
		try {
			fEditor = BPELUIRegistry.getInstance().getExpressionEditor(language);
		} catch (CoreException e) {
			BPELUIPlugin.log(e);			
			return ;
		}
			
		editorLanguage = language;
		fEditor.createControls(parent, getWidgetFactory());
		
		fEditor.addListener(new IExpressionEditor.Listener() {
			public void notifyChanged() {
				if (!updating) { // && !isExecutingStoreCommand()) {
					notifyEditorChanged();
				}
			}
			public void focusOut() {
				// If expression editor has lost focus then apply current changes
				getCommandFramework().applyCurrentChange();
			}
			public void focusIn() {
				// TODO Auto-generated method stub
			}
		});
	}
	
	/**
	 * We update the editor from the model. This is a model-to-ui operation.
	 * 
	 */
	@Override
	protected void updateEditor() {		
		Expression expr = getExprFromModel();
		
		Control previousTop = fEditorAreaStackLayout.topControl;
		
		if (expr == null) {
			fEditorAreaStackLayout.topControl = fNoEditorWidgets;			
		} else {
			String newLanguage = getEffectiveLanguage(getExpressionLanguageFromModel());
			
			if ( newLanguage.equals(editorLanguage) == false || hasEditor() == false) {
				// get rid of the old editor
				// The "old" editorComposite will be buried in the stack layout				
				disposeEditor();				
				
				fEditorComposite = fWidgetFactory.createComposite(fEditorArea);	
				fEditorComposite.setLayout( new FillLayout() );
				createEditor (fEditorComposite);
				
			}
			fEditorAreaStackLayout.topControl = fEditorComposite;		
		
			// we update our editor with the model, since something may have changed
			// in it that needs to be reflected in the editor.
			fEditor.setExpressionType( getExpressionType() );
			// editor.setExpressionType(getExpressionType(), getExpressionContext());
			fEditor.setModelObject(getInput());
			
			// TODO: WTF ?
			fEditor.setEditorContent( (String) expr.getBody());
			fEditor.aboutToBeShown();
		}
		
		
		if ( previousTop != fEditorAreaStackLayout.topControl ) {
			// Layout is necessary after swapping the top element in the stack layout
			fEditorArea.layout(new Control[] { fEditorAreaStackLayout.topControl } );			
		}				
	}
	
	/**
	 * This is used by the Expression Language combo to filter out editors that
	 * can't be used with the current type/context.
	 */
	protected boolean isEditorSupported(IExpressionEditor exEditor) {
		return exEditor.supportsExpressionType( getExpressionType() );
	}
	
	/**
	 * Whether the marker use type is useful for this section. 
	 */
	protected boolean isValidClientUseType (String useType) {
		return false;
	}
	
	/**
	 * Answer if we have an editor visible. 
	 * 
	 * @return true if visible, false otherwise.
	 */
	
	public boolean hasEditor () {
		return (fEditor != null && fEditorAreaStackLayout.topControl != fNoEditorWidgets) ;
	}
	
	private void createBoldFont (Composite parent) {
		FontData[] data = parent.getDisplay().getSystemFont().getFontData();
		FontData data0 = data[0];
		data0.setStyle(SWT.BOLD);
		boldFont = new Font(parent.getDisplay(), data0);
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.TextSection#dispose()
	 */
	
	@Override
	public void dispose() {
		if (boldFont != null) {
			boldFont.dispose();
		}
		super.dispose();
	}
	
	@Override
	protected void updateMarkers () {				
		expressionLanguageLabel.clear();		
		for(IMarker m : getMarkers(getInput())) {
			if (expressionLanguageLabel.getControl().isDisposed() == false) {
				expressionLanguageLabel.addStatus( BPELUtil.adapt(m, IStatus.class) );
			} else {
				new Throwable("FixMe: Why is update markers being called ?").printStackTrace();
			}
			
		}		
	}	
	
	
	
//	public void aboutToBeHidden() {
//		super.aboutToBeHidden();
//		if (expressionChangeHelper != null) {
//			getCommandFramework().notifyChangeDone(expressionChangeHelper);
//		}
//	}
}