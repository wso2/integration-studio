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

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetFaultNameCommand;
import org.eclipse.bpel.ui.commands.SetFaultNamespaceCommand;
import org.eclipse.bpel.ui.commands.SetVariableCommand;
import org.eclipse.bpel.ui.dialogs.VariableSelectorDialog;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the fault name referenced in a Throw activity.
 */
public class FaultThrowNameSection extends BPELPropertySection {

	protected static final int NAME_BUILTIN_CONTEXT = 0;
	protected static final int NAMESPACE_CONTEXT = 1;
	protected static final int VARIABLE_CONTEXT = 2;
	protected static final int BUILTINRADIO_CONTEXT = 3;
	protected static final int USERDEFRADIO_CONTEXT = 4;
	protected static final int NAME_USERDEF_CONTEXT = 5;
	protected static final int FAULT_VARIABLE_CONTEXT = 6;

	protected int lastChangeContext = -1; 

	protected boolean isCatch, isFaultTypeEnabled;

	protected Composite parentComposite;
	protected Composite faultTypeComposite, namespaceComposite, faultNameComposite, faultUserDefNameComposite, faultVariableNameComposite;

	protected Button builtinRadio, userdefRadio;
	protected Button /*namespaceBrowseButton,*/ variableBrowseButton;

	protected Text faultNamespaceText, faultUserDefText, variableNameText;
	protected CCombo faultNameCombo;
	protected Label variableName;
	
	protected ChangeTracker faultNameTracker, faultNamespaceTracker, 
		faultUserDefNameTracker, variableNameTracker;
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
			/* model object */
			new MultiObjectAdapter() {
				@Override
				public void notify(Notification n) {
					if (ModelHelper.isFaultNameAffected(getInput(), n) && builtinRadio.getSelection()) {
						updateFaultNameWidgets();
					}
					else if (ModelHelper.isFaultNameAffected(getInput(), n) && userdefRadio.getSelection()) {
						updateUserDefFaultNameWidgets();
					}

					if (isFaultTypeEnabled && ModelHelper.isFaultNamespaceAffected(getInput(), n)) {
						updateFaultNamespaceWidgets();
					} 
					if (ModelHelper.isVariableAffected(getInput(), n, ModelHelper.OUTGOING)) {
						updateFaultVariableWidgets();
						updateVariableWidgets();
					}
				}
			},
		};
	}
	
	protected boolean isNamespaceUserDef() {
		return isFaultTypeEnabled && userdefRadio.getSelection();
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}
	
	protected void doChildLayout() {
		FlatFormData data = null;
		FlatFormData data1 = null;
		if (isFaultTypeEnabled) {
			if (isNamespaceUserDef()) {
				data = (FlatFormData)faultUserDefNameComposite.getLayoutData();
				data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
				data1 = (FlatFormData)faultVariableNameComposite.getLayoutData();
				data1.top = new FlatFormAttachment(faultUserDefNameComposite, IDetailsAreaConstants.VSPACE);
			} else {
				data = (FlatFormData)faultNameComposite.getLayoutData();
				data.top = new FlatFormAttachment(faultTypeComposite, IDetailsAreaConstants.VSPACE);
				data1 = (FlatFormData)faultVariableNameComposite.getLayoutData();
				data1.top = new FlatFormAttachment(faultNameComposite, IDetailsAreaConstants.VSPACE);
			}
		} else {
			data.top = new FlatFormAttachment(0, 0);
		}
		faultTypeComposite.setVisible(isFaultTypeEnabled);
		namespaceComposite.setVisible(isNamespaceUserDef());
		faultNameComposite.setVisible(!isNamespaceUserDef());
		faultUserDefNameComposite.setVisible(isNamespaceUserDef());
		faultVariableNameComposite.setVisible(true);
		parentComposite.layout(true);
	}

	@Override
	protected void basicSetInput(EObject input) {
		super.basicSetInput(input);
		rearrangeWidgets();
	}
	
	protected void rearrangeWidgets() {
		// hack hack.
		isCatch = (getInput() instanceof Catch);

		isFaultTypeEnabled = true;
		if (isCatch) {
			FaultHandler faultHandler = (FaultHandler)getInput().eContainer();
			if (faultHandler != null) {
				Object maybeInvoke = faultHandler.eContainer();
				if (maybeInvoke instanceof Invoke)  isFaultTypeEnabled = false;
			}
		}
		doChildLayout();
	}

	protected void createFaultTypeWidgets(Composite parent) {
		FlatFormData data;
		
		Composite composite = faultTypeComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		composite.setLayoutData(data);
		
		Label faultTypeLabel = fWidgetFactory.createLabel(composite, Messages.FaultThrowNameDetails_Fault_Type__13); 
		builtinRadio = fWidgetFactory.createButton(composite, Messages.FaultThrowNameDetails_Built_in_14, SWT.RADIO); 
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultTypeLabel, STANDARD_LABEL_WIDTH_SM));
		// hack: fudge vertical alignment.
		data.top = new FlatFormAttachment(0, 2);
		builtinRadio.setLayoutData(data);
		builtinRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!builtinRadio.getSelection()) return;
				doChildLayout();
				CompoundCommand compound = new CompoundCommand();
				Command cmd = new SetFaultNamespaceCommand(getInput(), BPELConstants.NAMESPACE);
				if (cmd.canExecute()) compound.add(cmd);
				Command cmd1 = new SetFaultNameCommand(getInput(), BPELConstants.standardFaults[0]);
				if(cmd1.canExecute()) compound.add(cmd1);
				lastChangeContext = BUILTINRADIO_CONTEXT;
				getCommandFramework().execute(wrapInShowContextCommand(compound));
				updateUserDefFaultNameWidgets();
				updateFaultNameWidgets();
				updateFaultNamespaceWidgets();
				updateFaultVariableWidgets();
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});

		userdefRadio = fWidgetFactory.createButton(composite, Messages.FaultThrowNameDetails_User_defined_15, SWT.RADIO); 
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(builtinRadio, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 2);
		userdefRadio.setLayoutData(data);
		userdefRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!userdefRadio.getSelection()) return;
				doChildLayout();
				// Set the namespace to the process namespace.
				Command cmd = new SetFaultNamespaceCommand(getInput(), getProcess().getTargetNamespace());
				lastChangeContext = USERDEFRADIO_CONTEXT;
				getCommandFramework().execute(wrapInShowContextCommand(cmd));
				updateUserDefFaultNameWidgets();
				updateFaultNameWidgets();
				updateFaultNamespaceWidgets();
				updateFaultVariableWidgets();
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(builtinRadio, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(builtinRadio, 0, SWT.CENTER);
		faultTypeLabel.setLayoutData(data);
	}

	protected void createChangeTrackers() {
		IOngoingChange change = new IOngoingChange() {
			public String getLabel() {
				return IBPELUIConstants.CMD_EDIT_FAULTNAME;
			}
			public Command createApplyCommand() {
				String name = faultNameCombo.getText();
				lastChangeContext = NAME_BUILTIN_CONTEXT;
				Command command;
				CompoundCommand c = new CompoundCommand();
				c.add(new SetFaultNameCommand(getInput(), "".equals(name)? null : name)); //$NON-NLS-1$
				Command c2 = new SetFaultNamespaceCommand(getInput(), BPELConstants.NAMESPACE);
				if (c2.canExecute())  c.add(c2);
				command = c;
				return wrapInShowContextCommand(command);
			}
			public void restoreOldState() {
				updateFaultNameWidgets();			
			}
		};
		faultNameTracker = new ChangeTracker(faultNameCombo, change, getCommandFramework());

		change = new IOngoingChange() {
			public String getLabel() {
				return IBPELUIConstants.CMD_EDIT_FAULTNAME;
			}
			public Command createApplyCommand() {
				String s = faultNamespaceText.getText();
				lastChangeContext = NAMESPACE_CONTEXT;
				return wrapInShowContextCommand(new SetFaultNamespaceCommand(
					getInput(), "".equals(s)? null : s)); //$NON-NLS-1$
			}
			public void restoreOldState() {
				updateFaultNameWidgets();
			}
		};
		faultNamespaceTracker = new ChangeTracker(faultNamespaceText, change, getCommandFramework());

		change = new IOngoingChange() {
			public String getLabel() {
				return IBPELUIConstants.CMD_EDIT_FAULTNAME;
			}
			public Command createApplyCommand() {
				String s = faultUserDefText.getText();
				lastChangeContext = NAME_USERDEF_CONTEXT;
				return wrapInShowContextCommand(new SetFaultNameCommand(
					getInput(), "".equals(s)? null : s)); //$NON-NLS-1$
			}
			public void restoreOldState() {
				updateUserDefFaultNameWidgets();			
			}
		};
		faultUserDefNameTracker = new ChangeTracker(faultUserDefText, change, getCommandFramework());
	}

	protected void createFaultNameWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = faultNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		Label faultNameLabel = fWidgetFactory.createLabel(composite, Messages.FaultThrowNameDetails_Fault_Name__16); 
		faultNameCombo = fWidgetFactory.createCCombo(composite);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultNameLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, -SHORT_BUTTON_WIDTH-IDetailsAreaConstants.HSPACE-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, 0);
		
		faultNameCombo.setItems(BPELConstants.standardFaults);
		faultNameCombo.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultNameCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(faultNameCombo, 0, SWT.CENTER);
		faultNameLabel.setLayoutData(data);
	}
	
	protected void createNamespaceWidgets(Composite parent) {
		FlatFormData data;

		final Composite composite = namespaceComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(faultTypeComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		//namespaceBrowseButton = wf.createButton(composite, "Browse...", SWT.PUSH);

		Label faultNamespaceLabel = fWidgetFactory.createLabel(composite, Messages.FaultThrowNameDetails_Namespace__21); 
		faultNamespaceText = fWidgetFactory.createText(composite, ""); //$NON-NLS-1$
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultNamespaceLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, -SHORT_BUTTON_WIDTH-IDetailsAreaConstants.HSPACE-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, +1);
		data.bottom = new FlatFormAttachment(100, -1);
		faultNamespaceText.setLayoutData(data);
				
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultNamespaceText, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(faultNamespaceText, 0, SWT.CENTER);
		faultNamespaceLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(faultNamespaceText, IDetailsAreaConstants.HSPACE);
		data.right = new FlatFormAttachment(100, 0);
		data.left = new FlatFormAttachment(100, -STANDARD_BUTTON_WIDTH);
		data.top = new FlatFormAttachment(faultNamespaceText, -1, SWT.TOP);
		data.bottom = new FlatFormAttachment(faultNamespaceText, +1, SWT.BOTTOM);
		//namespaceBrowseButton.setLayoutData(data);

//		namespaceBrowseButton.addSelectionListener(new SelectionListener() {
//			public void widgetSelected(SelectionEvent e) {
//				WorkbenchFileSelectionDialog dialog = new WorkbenchFileSelectionDialog(
//					composite.getShell(), BPELUtil.lastWSDLFilePath, IBPELUIConstants.BROWSE_WSDL_DLG_TITLE,
//						IBPELUIConstants.EXTENSION_DOT_WSDL);
//				if (dialog.open() == WorkbenchFileSelectionDialog.OK) {
//					IFile targetFile = ResourcesPlugin.getWorkspace().getRoot().getFile(dialog.getLocationPath());
//					// TODO: Load the target file and find the target namespace
//				}
//			}
//			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
//		});
	}
	
	protected void createUserDefFaultNameWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = faultUserDefNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
	
		Label faultUserDefNameLabel = fWidgetFactory.createLabel(composite, Messages.FaultThrowNameDetails_Fault_Name__24); 
		faultUserDefText = fWidgetFactory.createText(composite, ""); //$NON-NLS-1$
	
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultUserDefNameLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, -SHORT_BUTTON_WIDTH-IDetailsAreaConstants.HSPACE-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, +1);
		faultUserDefText.setLayoutData(data);	
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultUserDefText, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(faultUserDefText, 0, SWT.CENTER);
		faultUserDefNameLabel.setLayoutData(data);
	}

	protected void createVariableWidgets(Composite parent) {
		FlatFormData data;

		final Composite composite = faultVariableNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(faultNameComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		Label variableLabel = fWidgetFactory.createLabel(composite, Messages.FaultThrowNameDetails_Fault_Variable__27); 
		variableName = fWidgetFactory.createLabel(composite, "", SWT.NONE); //$NON-NLS-1$
		variableBrowseButton = fWidgetFactory.createButton(composite, Messages.FaultThrowNameSection_Browse_1, SWT.PUSH); 

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(variableLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(variableBrowseButton, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 0);
		data.height = FigureUtilities.getTextExtents(variableBrowseButton.getText(), variableBrowseButton.getFont()).height + 4;
		variableName.setLayoutData(data);

		data = new FlatFormData();
		data.top = new FlatFormAttachment(variableName, 0, SWT.TOP);
		data.bottom = new FlatFormAttachment(variableName, 2, SWT.BOTTOM);
		data.left = new FlatFormAttachment(50, -BPELUtil.calculateButtonWidth(variableBrowseButton, SHORT_BUTTON_WIDTH)-IDetailsAreaConstants.CENTER_SPACE);
		data.right = new FlatFormAttachment(50, -IDetailsAreaConstants.CENTER_SPACE);
		variableBrowseButton.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(variableName, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(variableName, 0, SWT.CENTER);
		variableLabel.setLayoutData(data);
		
		variableBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = composite.getShell();
				EObject model = getInput();
				VariableSelectorDialog dialog = new VariableSelectorDialog(shell, model, ModelHelper.getVariableType(model, ModelHelper.OUTGOING));
				dialog.setTitle(Messages.FaultThrowNameSection_Select_Fault_Variable_2); 
				if (dialog.open() == Window.OK) {
					Variable variable = dialog.getVariable();
					Command command = new SetVariableCommand(fModelObject, variable, ModelHelper.OUTGOING);
					lastChangeContext = VARIABLE_CONTEXT; 
					getCommandFramework().execute(wrapInShowContextCommand(command));
				}
			}
			public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
		});
	}

	@Override
	protected void createClient(Composite parent) {
		Composite composite = parentComposite = createFlatFormComposite(parent);
		createFaultTypeWidgets(composite);
		createUserDefFaultNameWidgets(composite);
		createNamespaceWidgets(composite);
		createFaultNameWidgets(composite);
		createVariableWidgets(composite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parentComposite, IHelpContextIds.PROPERTY_PAGE_FAULT);
	}

	protected void updateFaultNameWidgets() {
		Assert.isNotNull(getInput());
		faultNameTracker.stopTracking();
		try {
			String s = ModelHelper.getFaultName(getInput());
			if (s == null)  s = ""; //$NON-NLS-1$
			if (!s.equals(faultNameCombo.getText()))  faultNameCombo.setText(s);			
		} finally {
			faultNameTracker.startTracking();
		}
	}

	protected void updateFaultNamespaceWidgets() {
		Assert.isNotNull(getInput());
		if (isFaultTypeEnabled) {
			faultNamespaceTracker.stopTracking();
			try {
				String s = ModelHelper.getFaultNamespace(getInput());
				if (s == null) {
					faultNamespaceText.setText("");//$NON-NLS-1$
				} else {
					if (!s.equals(faultNamespaceText.getText())) {
						faultNamespaceText.setText(NamespaceUtils.convertUriToNamespace(s));
					}
				}
			} finally {
				faultNamespaceTracker.startTracking();
			}
		}
	}
	
	protected void updateUserDefFaultNameWidgets() {
		Assert.isNotNull(getInput());
		faultUserDefNameTracker.stopTracking();
		try {
			String s = ModelHelper.getFaultName(getInput());
			if (s == null)  s = ""; //$NON-NLS-1$
			if (!s.equals(faultUserDefText.getText()))  faultUserDefText.setText(s);
		} finally {
			faultUserDefNameTracker.startTracking();
		}
	}

	protected void updateFaultTypeWidgets() {
		Assert.isNotNull(getInput());
		String faultNamespace = ModelHelper.getFaultNamespace(getInput());

		boolean isBuiltin = BPELConstants.NAMESPACE.equals(faultNamespace);
		if (faultNamespace == null) {
			if (ModelHelper.getFaultName(getInput()) == null)  isBuiltin = true;
		}
		
		builtinRadio.setSelection(isBuiltin);
		userdefRadio.setSelection(!isBuiltin);
		doChildLayout();
	}
	
	protected void updateFaultVariableWidgets() {
		Assert.isNotNull(getInput());
		Variable v = ((Throw)getInput()).getFaultVariable();
		String s = (v==null)? null : v.getName();
		if (s == null)  s = ""; //$NON-NLS-1$
		if (!s.equals(variableName.getText())) variableName.setText(s);
	}
	
	protected void updateVariableWidgets() {
		Variable variable = ModelHelper.getVariable(getInput(), ModelHelper.OUTGOING);
		if (variable == null) {
			variableName.setText(Messages.FaultThrowNameSection_None_3); 
			variableName.setEnabled(false);
		} else {
			ILabeledElement labeledElement = BPELUtil.adapt(variable, ILabeledElement.class);
			variableName.setText(labeledElement.getLabel(variable));
			variableName.setEnabled(true);
		}
	}

	@Override
	public void refresh() {
		super.refresh();
		updateFaultTypeWidgets();
		updateFaultNamespaceWidgets();
		updateFaultNameWidgets();
		updateUserDefFaultNameWidgets();
		updateFaultVariableWidgets();
		updateVariableWidgets();
	}

	@Override
	public Object getUserContext() {
		return Integer.valueOf( lastChangeContext );
	}
	@Override
	public void restoreUserContext(Object userContext) {
		int i = ((Integer)userContext).intValue();
		switch (i) {
			case NAME_BUILTIN_CONTEXT: faultNameCombo.setFocus(); return;
			case NAMESPACE_CONTEXT: faultNamespaceText.setFocus(); return;
			case BUILTINRADIO_CONTEXT: builtinRadio.setFocus(); return;
			case USERDEFRADIO_CONTEXT: userdefRadio.setFocus(); return;
			case NAME_USERDEF_CONTEXT: faultUserDefText.setFocus(); return;
			case FAULT_VARIABLE_CONTEXT: variableNameText.setFocus(); return;
		}
		throw new IllegalStateException();
	}
}
