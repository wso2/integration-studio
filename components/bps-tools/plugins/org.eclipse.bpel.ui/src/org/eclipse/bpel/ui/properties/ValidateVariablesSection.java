/*******************************************************************************
 * Copyright (c) 2006, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import java.util.Arrays;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddVariableToValidateCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.RemoveValidateVariableCommand;
import org.eclipse.bpel.ui.details.providers.AbstractContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.dialogs.VariableSelectorDialog;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the variables of a Validate.
 */
public class ValidateVariablesSection extends BPELPropertySection {
	
	protected Button fAddButton;
	protected Button fRemoveButton;
	List fVariableList;
	ListViewer fVariablesViewer;
	
	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() { 
		return true; 
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object and Correlations object */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {

					if (n.getFeature() == BPELPackage.eINSTANCE.getValidate_Variables() ) {						
						updateVariableWidgets(null);
						refreshAdapters();
					}
				}
			},
			/* correlation(s) and correlation set(s) */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (n.getNotifier() instanceof Variable) {
						updateVariableWidgets((Variable)n.getNotifier());
						refreshAdapters();
					} 
				}
			}
		};
	}
	
	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Validate validate = getModel();
		EList<Variable> variables = validate.getVariables();
		if (variables != null) {
			for(Variable var : variables) {
				fAdapters[1].addToObject(var);
			}
		}
	}

	protected void createVariablesWidgets(final Composite composite)  {
		FlatFormData data;
		
		fAddButton = fWidgetFactory.createButton(composite, Messages.ValidateDetails_1, SWT.PUSH); 
		fRemoveButton = fWidgetFactory.createButton(composite, Messages.ValidateDetails_2, SWT.PUSH); 
		Label validateVariablesLabel = fWidgetFactory.createLabel(composite, Messages.ValidateDetails_3); 
		fVariableList = fWidgetFactory.createList(composite, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER );
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE );
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		validateVariablesLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(fAddButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(fRemoveButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		fAddButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.width = BPELUtil.calculateButtonWidth(fRemoveButton, STANDARD_BUTTON_WIDTH);
		data.right = new FlatFormAttachment(100, (-2) * IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, IDetailsAreaConstants.VSPACE);
		fRemoveButton.setLayoutData(data);
		fRemoveButton.setEnabled(false);
		
		fAddButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = composite.getShell();
				EObject model = getInput();
				VariableSelectorDialog dialog = new VariableSelectorDialog(shell, model, ModelHelper.getVariableType(model, ModelHelper.OUTGOING)){

					@Override
					protected void computeResult() {
						Object[] results = getSelectedElements() ;
				        setResult(Arrays.asList(results));
					}
					
					
				};
				dialog.setMultipleSelection(true);
				dialog.setTitle(Messages.ValidateDetails_4); 
				if (dialog.open() == Window.OK) {
					CompoundCommand ccmd = new CompoundCommand();
					Variable variable = null;
					for(Object next : dialog.getResult()) {									
						variable = (Variable) next;
						ccmd.add(new AddVariableToValidateCommand(getInput(), variable));																
					}
					runCommand ( ccmd );
					fVariablesViewer.setSelection(new StructuredSelection(variable),true);					
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
		Listener removeListener = new Listener() {
			public void handleEvent(Event e) {
				if (e.type == SWT.KeyUp && e.character != SWT.DEL)  {
					return;
				}
				IStructuredSelection sel = (IStructuredSelection) fVariablesViewer.getSelection();				
				int selectionIndex = fVariableList.getSelectionIndex();
				CompoundCommand ccmd = new CompoundCommand();
				for (Object next : sel.toArray()) {
					Variable var = (Variable) next;
					ccmd.add(new RemoveValidateVariableCommand(getInput(), var));
				}
				runCommand(ccmd);				
				// selects the element at the deleted element position
				int items = fVariableList.getItemCount();
				if (items > 0) {
					selectionIndex = (selectionIndex < items) ? selectionIndex : 0;
					fVariableList.setSelection(selectionIndex);
				} else {
					fVariablesViewer.setSelection(StructuredSelection.EMPTY);
				}
			}
		};
		
		fVariableList.addListener(SWT.KeyUp, removeListener);
		
		fRemoveButton.addListener(SWT.Selection, removeListener);
		fRemoveButton.addListener(SWT.DefaultSelection, removeListener);

		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(100, (-2) * IDetailsAreaConstants.HSPACE );
		data.top = new FlatFormAttachment(fAddButton, IDetailsAreaConstants.VSPACE);
		data.bottom = new FlatFormAttachment(100, (-1) * IDetailsAreaConstants.VSPACE );
		fVariableList.setLayoutData(data);
						

		fVariablesViewer = new ListViewer(fVariableList);				
		fVariablesViewer.setLabelProvider(new ModelLabelProvider() );		
		fVariablesViewer.setContentProvider(new AbstractContentProvider(){
			@Override
			public Object[] getElements (Object inputElement)  {
				try {
					Validate input = (Validate)inputElement;
					EList<?> l = input.getVariables();
					return (l == null)? EMPTY_ARRAY : l.toArray();
				} catch (Throwable t) {
					return EMPTY_ARRAY;
				}
			}			
		});
		
		fVariablesViewer.addSelectionChangedListener (new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {				
				fRemoveButton.setEnabled( fVariablesViewer.getSelection().isEmpty() == false);
			}
		});
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				composite, IHelpContextIds.PROPERTY_PAGE_VALIDATE_DETAILS);
	}
	
	@Override
	protected void createClient(Composite parent)  {
		Composite composite = createFlatFormComposite(parent);
		createVariablesWidgets(composite);
	}

	protected void updateVariableWidgets (Variable var) {		
		
		Object input = getInput();		
		
		if (input == null)  {
			throw new IllegalStateException();
		}
		
		fVariablesViewer.setInput( input );
		
		if (var != null) {
			fVariablesViewer.refresh(var, true);
		} else {
			fVariablesViewer.refresh();
		}
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		updateVariableWidgets(null);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return ((StructuredSelection)fVariablesViewer.getSelection()).getFirstElement();
	}
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		fVariableList.setFocus();
		if (userContext != null) {
			fVariablesViewer.setSelection(new StructuredSelection(userContext),true);
		} else {
			fVariablesViewer.setSelection(StructuredSelection.EMPTY);			
		}
	}
	
	@Override
	protected void basicSetInput(EObject newInput) {
		saveUserContextToInput();
		super.basicSetInput(newInput);
		restoreUserContextFromInput();
	}	
}
