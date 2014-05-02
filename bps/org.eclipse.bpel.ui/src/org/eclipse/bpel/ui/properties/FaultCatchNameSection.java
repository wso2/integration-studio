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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetFaultNameCommand;
import org.eclipse.bpel.ui.commands.SetFaultNamespaceCommand;
import org.eclipse.bpel.ui.commands.SetNameCommand;
import org.eclipse.bpel.ui.commands.SetVariableCommand;
import org.eclipse.bpel.ui.commands.SetVariableKindCommand;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.dialogs.TypeSelectorDialog;
import org.eclipse.bpel.ui.uiextensionmodel.VariableExtension;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.bpel.ui.util.WSDLImportHelper;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Details section for the fault name referenced in a Catch.
 */
public class FaultCatchNameSection extends BPELPropertySection {

	protected static final int NAME_BUILTIN_CONTEXT = 0;
	protected static final int NAMESPACE_CONTEXT = 1;
	protected static final int VARIABLE_CONTEXT = 2;
	protected static final int BUILTINRADIO_CONTEXT = 3;
	protected static final int USERDEFRADIO_CONTEXT = 4;
	protected static final int NAME_USERDEF_CONTEXT = 5;
	protected static final int FAULT_VARIABLE_NAME_CONTEXT = 6;
	protected static final int FAULT_VARIABLE_TYPE_CONTEXT = 7;

	protected int lastChangeContext = -1; 

	protected VariableTypeSelector variableTypeSelector;
	
	protected boolean isCatch, isFaultTypeEnabled;

	protected Composite parentComposite;
	protected Composite faultTypeComposite, namespaceComposite, faultNameComposite, faultUserDefNameComposite, faultVariableNameComposite;

	protected Button builtinRadio, userdefRadio;

	protected Text variableNameText;
	protected CCombo faultNameCombo, faultUserDefCombo, faultNamespaceCombo;
	
	protected ChangeTracker faultNameTracker, faultNamespaceTracker, 
		faultUserDefNameTracker, variableNameTracker;
		
	protected Vector<QName> faultNameQNames;

	public FaultCatchNameSection()  {
		super();
	}
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new BatchedMultiObjectAdapter[] {
			/* model object */
			new BatchedMultiObjectAdapter() {
				boolean refreshFaultName = false;
				boolean refreshUserDefFaultName = false;
				boolean refreshFaultNamespace = false;
				boolean refreshVariable = false;

				@Override
				public void notify(Notification n) {
					if (ModelHelper.isFaultNameAffected(getInput(), n) && builtinRadio.getSelection()) {
						refreshFaultName = true;
					}
					if (ModelHelper.isFaultNameAffected(getInput(), n) && userdefRadio.getSelection()) {
						refreshUserDefFaultName = true;
					}

					if (isFaultTypeEnabled && ModelHelper.isFaultNamespaceAffected(getInput(), n)) {
						refreshFaultNamespace = true;
					} 
					if (ModelHelper.isVariableAffected(getInput(), n, ModelHelper.INCOMING)) {
						refreshVariable = true;
					} else if (n.getFeatureID(Catch.class) == BPELPackage.CATCH__FAULT_MESSAGE_TYPE) {
						refreshVariable = true;
					}
				}
				@Override
				public void finish() {
					if (refreshFaultName) updateFaultNameWidgets();
					if (refreshFaultNamespace) updateFaultNamespaceWidgets();
					if (refreshUserDefFaultName) updateUserDefFaultNameWidgets();
					if (refreshVariable) updateVariableWidgets();
					refreshFaultName = false;
					refreshUserDefFaultName = false;
					refreshFaultNamespace = false;
					refreshVariable = false;
				}
			},
		};
	}
	
	protected boolean isNamespaceUserDef() {
		return (!isFaultTypeEnabled) || userdefRadio.getSelection();
	}

	protected void doChildLayout() {
		FlatFormData data = null;
		FlatFormData data1 = null;
		boolean isNamespaceUserDef = isNamespaceUserDef();
		if (isFaultTypeEnabled) {
			data = (FlatFormData)namespaceComposite.getLayoutData();
			data.top = new FlatFormAttachment(faultTypeComposite, IDetailsAreaConstants.VSPACE);
			if (isNamespaceUserDef) {
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
			data = (FlatFormData)namespaceComposite.getLayoutData();
			data.top = new FlatFormAttachment(0, 0);
			// note: isNamespaceUserDef == true
			data = (FlatFormData)faultUserDefNameComposite.getLayoutData();
			data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
			data1 = (FlatFormData)faultVariableNameComposite.getLayoutData();
			data1.top = new FlatFormAttachment(faultUserDefNameComposite, IDetailsAreaConstants.VSPACE);
		}
		faultTypeComposite.setVisible(isFaultTypeEnabled);
		namespaceComposite.setVisible(isNamespaceUserDef);
		faultNameComposite.setVisible(!isNamespaceUserDef);
		faultUserDefNameComposite.setVisible(isNamespaceUserDef);
		parentComposite.layout(true);
		parentComposite.getParent().layout(true);
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}
	
	@Override
	protected void basicSetInput(EObject input) {
		super.basicSetInput(input);
		rearrangeWidgets();
	}
	
	protected void rearrangeWidgets() {
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
		
		Label faultTypeLabel = fWidgetFactory.createLabel(composite, Messages.FaultCatchNameDetails_Fault_Type__13); 
		
		builtinRadio = fWidgetFactory.createButton(composite, Messages.FaultCatchNameDetails_Built_in_14, SWT.RADIO); 

		data = new FlatFormData();
		
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultTypeLabel, STANDARD_LABEL_WIDTH_SM));
		// hack: fudge vertical alignment.
		data.top = new FlatFormAttachment(0, 2);
		builtinRadio.setLayoutData(data);
		builtinRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!builtinRadio.getSelection()) return;
				doChildLayout();
				// hack!
				updateFaultNameWidgets();
				updateUserDefFaultNameWidgets();
				
				CompoundCommand command = new CompoundCommand();
				String newName = faultNameCombo.getText();
				Command cmd = new SetFaultNameCommand(getInput(), isEmptyMessageType(newName) ? "" : newName);
				if (cmd.canExecute()) command.add(cmd);
				cmd = new SetFaultNamespaceCommand(getInput(), BPELConstants.NAMESPACE);
				if (cmd.canExecute()) command.add(cmd);
				command.setLabel(cmd.getLabel());
				if (command.canExecute()) {
					lastChangeContext = BUILTINRADIO_CONTEXT;
					getCommandFramework().execute(wrapInShowContextCommand(command));
				}
				updateUserDefFaultNameWidgets();
				updateFaultNameWidgets();
				updateFaultNamespaceWidgets();
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			    // Do nothing - widgetDefaultSelected is not called.
			}
		});

		userdefRadio = fWidgetFactory.createButton(composite, Messages.FaultCatchNameDetails_User_defined_15, SWT.RADIO); 
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(builtinRadio, IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(0, 2);
		userdefRadio.setLayoutData(data);
		userdefRadio.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!userdefRadio.getSelection()) return;
				doChildLayout();
				// hack!
				String s = ""; //$NON-NLS-1$
				Vector<QName> names = getFaultNames(getProcess().getTargetNamespace());
				if (!names.isEmpty()) s = (names.get(0)).getLocalPart();
				CompoundCommand command = new CompoundCommand();

				Command cmd = new SetFaultNameCommand(getInput(), (s==null)? "" : s); //$NON-NLS-1$
				if (cmd.canExecute()) command.add(cmd);
				// Set the namespace to the process namespace.
				cmd = new SetFaultNamespaceCommand(getInput(), getProcess().getTargetNamespace());
				if (cmd.canExecute()) command.add(cmd);
				if (command.canExecute()) {
					lastChangeContext = USERDEFRADIO_CONTEXT;
					getCommandFramework().execute(wrapInShowContextCommand(command));
				}

				updateUserDefFaultNameWidgets();
				updateFaultNameWidgets();
				updateFaultNamespaceWidgets();
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			    // Do nothing - widgetDefaultSelected is not called.
			}
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
				CompoundCommand command = new CompoundCommand();
				String newName = "".equals(name)? null : name; //$NON-NLS-1$
				Command newNameCommand = new SetFaultNameCommand(getInput(), isEmptyMessageType(newName) ? "" : newName); 
				if (newNameCommand.canExecute())  command.add(newNameCommand);
				Command c2 = new SetFaultNamespaceCommand(getInput(), BPELConstants.NAMESPACE);
				if (c2.canExecute())  command.add(c2);
				lastChangeContext = NAME_BUILTIN_CONTEXT;
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
				String s = NamespaceUtils.convertNamespaceToUri(faultNamespaceCombo.getText());
				lastChangeContext = NAMESPACE_CONTEXT;
				CompoundCommand command = new CompoundCommand();
				command.add(new SetFaultNamespaceCommand(getInput(), "".equals(s)? null : s)); //$NON-NLS-1$
				Vector<QName> faultNames = getFaultNames(s);
				String name = null;
				if (!faultNames.isEmpty()) {
					name = (faultNames.get(0)).getLocalPart();
				}
				command.add(new SetFaultNameCommand(getInput(), isEmptyMessageType(name) ? "" : name));
				return wrapInShowContextCommand(command);
			}
			public void restoreOldState() {
				updateFaultNamespaceWidgets();
			}
		};
		faultNamespaceTracker = new ChangeTracker(faultNamespaceCombo, change, getCommandFramework());

		change = new IOngoingChange() {
			public String getLabel() {
				return IBPELUIConstants.CMD_EDIT_FAULTNAME;
			}
			public Command createApplyCommand() {
				lastChangeContext = NAME_USERDEF_CONTEXT;
				String faultName = faultUserDefCombo.getText();
				String namespace = NamespaceUtils.convertNamespaceToUri(faultNamespaceCombo.getText());
				if (!validNamespaceFaultNameCombination(namespace, faultName)) {
					namespace = NamespaceUtils.convertUriToNamespace(getNamespaceByFaultName(faultName));
					if (namespace == null) namespace = ""; //$NON-NLS-1$
				}
				faultNamespaceCombo.setText(NamespaceUtils.convertUriToNamespace(namespace));
				CompoundCommand command = new CompoundCommand(IBPELUIConstants.CMD_EDIT_FAULTNAME);
				command.add(new SetFaultNamespaceCommand(getInput(), "".equals(namespace) ? null : namespace)); //$NON-NLS-1$
				String newName = "".equals(faultName) ? null : faultName;
				command.add(new SetFaultNameCommand(getInput(), isEmptyMessageType(newName) ? "" : newName)); //$NON-NLS-1$
				return wrapInShowContextCommand(command);
			}
			public void restoreOldState() {
				updateUserDefFaultNameWidgets();
			}
		};
		faultUserDefNameTracker = new ChangeTracker(faultUserDefCombo, change, getCommandFramework());

		change = new IOngoingChange() {
			public String getLabel() {
				return IBPELUIConstants.CMD_SELECT_VARIABLE;
			}
			public Command createApplyCommand() {
			    final Catch _catch = (Catch)getInput();
				String s = variableNameText.getText();
				if ("".equals(s)) s = null; //$NON-NLS-1$
				CompoundCommand result = new CompoundCommand();
				Variable variable = _catch.getFaultVariable();
				if (s != null) {
					if (variable == null) {
					    variable = BPELFactory.eINSTANCE.createVariable();
					    result.add(new SetVariableCommand(_catch, variable, ModelHelper.INCOMING));
					}
					result.add(new SetNameCommand(variable, s));
				} else {
					if (variable != null) {
						result.add(new SetVariableCommand(_catch, null, ModelHelper.INCOMING));
					}
				}
				lastChangeContext = FAULT_VARIABLE_NAME_CONTEXT;
				return wrapInShowContextCommand(result);
			}
			public void restoreOldState() {
 				updateVariableWidgets();
 			}
		};
		variableNameTracker = new ChangeTracker(variableNameText, change, getCommandFramework());
	}

	protected void createFaultNameWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = faultNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		faultNameCombo = fWidgetFactory.createCCombo(composite);
		Label faultNameLabel = fWidgetFactory.createLabel(composite, Messages.FaultCatchNameDetails_Fault_Name__16); 
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultNameLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50,
			-SHORT_BUTTON_WIDTH-IDetailsAreaConstants.HSPACE-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, 0);
		
		List<String> faultNames = getBuiltinFaultNames();
		String[] result = faultNames.toArray(new String[faultNames.size()]);
		faultNameCombo.setItems(result);
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
		
		faultNamespaceCombo = fWidgetFactory.createCCombo(composite); 
		
		Label faultNamespaceLabel = fWidgetFactory.createLabel(composite, Messages.FaultCatchNameDetails_Namespace__21); 
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultNamespaceLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, -SHORT_BUTTON_WIDTH-IDetailsAreaConstants.HSPACE-IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, +1);
		faultNamespaceCombo.setLayoutData(data);
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultNamespaceCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(faultNamespaceCombo, 0, SWT.CENTER);
		faultNamespaceLabel.setLayoutData(data);
		
		data = new FlatFormData();
		data.right = new FlatFormAttachment(100, 0);
		data.left = new FlatFormAttachment(100, -STANDARD_BUTTON_WIDTH);
		data.top = new FlatFormAttachment(faultNamespaceCombo, -1, SWT.TOP);
		data.bottom = new FlatFormAttachment(faultNamespaceCombo, +1, SWT.BOTTOM);
	}
	
	protected void createUserDefFaultNameWidgets(Composite parent) {
		FlatFormData data;

		Composite composite = faultUserDefNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(namespaceComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);

		Label faultUserDefNameLabel = fWidgetFactory.createLabel(composite, Messages.FaultCatchNameDetails_Fault_Name__24); 
		faultUserDefCombo = fWidgetFactory.createCCombo(composite, SWT.FLAT | SWT.READ_ONLY); 

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultUserDefNameLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, -SHORT_BUTTON_WIDTH - IDetailsAreaConstants.HSPACE - IDetailsAreaConstants.CENTER_SPACE);
		data.top = new FlatFormAttachment(0, +1);
		faultUserDefCombo.setLayoutData(data);

		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(faultUserDefCombo, -IDetailsAreaConstants.HSPACE);
		data.top = new FlatFormAttachment(faultUserDefCombo, 0, SWT.CENTER);
		faultUserDefNameLabel.setLayoutData(data);
	}
	
	public class FaultVariableTypeCallback implements VariableTypeSelector.Callback {
		protected void store(final EObject type) {
			final Catch _catch = (Catch)getInput();
			CompoundCommand command = new CompoundCommand();
			command.add(new AutoUndoCommand(getProcess()) {
				@Override
				public void doExecute() {
					Variable variable = _catch.getFaultVariable();
					if (variable == null) {
						variable = BPELFactory.eINSTANCE.createVariable();
					    _catch.setFaultVariable(variable);
					}
					// https://issues.jboss.org/browse/JBIDE-8045
					// Data caught by fault handler can be either a Message Type
					// or an XSD Element.
					if (type instanceof Message) {
					    _catch.setFaultMessageType((Message)type);
						_catch.setFaultElement(null);
					}
					else if (type instanceof XSDElementDeclaration) {
					    _catch.setFaultMessageType(null);
						_catch.setFaultElement((XSDElementDeclaration)type);
					}
				}
			});
			getCommandFramework().execute(wrapInShowContextCommand(command));
		}
		public void selectRadioButton(final int index) {
			final Catch _catch = (Catch)getInput();
			Variable variable = _catch.getFaultVariable();
			if (variable == null) {
				variable = BPELFactory.eINSTANCE.createVariable();
			}
			final Variable variable2 = variable;
			CompoundCommand command = new CompoundCommand();
			command.add(new AutoUndoCommand(getProcess()) {
				@Override
				public void doExecute() {
					if (_catch.getFaultVariable() != variable2) {
						_catch.setFaultVariable(variable2);
					}
					ModelHelper.createExtensionIfNecessary(
						getBPELEditor().getExtensionMap(), variable2);
					_catch.setFaultMessageType(null);
					VariableExtension varExt = (VariableExtension)ModelHelper.getExtension(variable2);
					if ((varExt.getVariableKind() != index)) {
						(new SetVariableKindCommand(varExt, index)).execute();
					}
				}
			});
			if (!command.isEmpty()) getCommandFramework().execute(wrapInShowContextCommand(command));

		}
		// https://issues.jboss.org/browse/JBIDE-8045
		public void selectXSDType(XSDTypeDefinition xsdType) {
			MessageDialog.openError(null, Messages.SelectionAndCreationDialog_Error_2,
					Messages.FaultCatchNameSection_Error_Invalid_Type);
		}
		public void selectXSDElement(XSDElementDeclaration xsdElement) {
			store(xsdElement);
		}
		public void selectMessageType(Message message) {
			store(message); 
		}
	}
	
	protected void createVariableWidgets(Composite parent) {
		FlatFormData data;

		final Composite composite = faultVariableNameComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(faultNameComposite, IDetailsAreaConstants.VSPACE);
		composite.setLayoutData(data);
		
		Label variableLabel = fWidgetFactory.createLabel(composite, Messages.FaultCatchNameSection_Variable_Name_3); 
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		variableLabel.setLayoutData(data);
		
		variableNameText = fWidgetFactory.createText(composite, ""); //$NON-NLS-1$
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(variableLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(50, 0);
		data.top = new FlatFormAttachment(0, 0);
		variableNameText.setLayoutData(data);
		variableNameText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				updateVariableTypeSelector();
			}
		});

		// https://issues.jboss.org/browse/JBIDE-8045
		variableTypeSelector = new VariableTypeSelector(composite, SWT.NONE, getBPELEditor(),
			fWidgetFactory, new FaultVariableTypeCallback(), false,
			TypeSelectorDialog.INCLUDE_ELEMENT_DECLARATIONS | TypeSelectorDialog.INCLUDE_MESSAGE_TYPES);
		data = new FlatFormData();
		data.top = new FlatFormAttachment(variableNameText, IDetailsAreaConstants.VSPACE+4);
		data.left = new FlatFormAttachment(0,0);
		data.right = new FlatFormAttachment(100,0);
		data.bottom = new FlatFormAttachment(100,0);
		variableTypeSelector.setLayoutData(data);
	}

	@Override
	protected void createClient(Composite parent) {
		parentComposite = createFlatFormComposite(parent);
		createFaultTypeWidgets(parentComposite);
		createUserDefFaultNameWidgets(parentComposite);
		createNamespaceWidgets(parentComposite);
		createFaultNameWidgets(parentComposite);
		createVariableWidgets(parentComposite);
		createChangeTrackers();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parentComposite, IHelpContextIds.PROPERTY_PAGE_FAULT);
	}

	protected void updateFaultNameWidgets() {
		Assert.isNotNull(getInput());
		
		faultNameTracker.stopTracking();
		try {
			String s = ModelHelper.getFaultName(getInput());
			if (s == null || "".equals(s)) { //$NON-NLS-1$
				faultNameCombo.setText(Messages.FaultCatchNameSection_None_0); 
			} else if (!s.equals(faultNameCombo.getText())) {
				if (faultNameCombo.indexOf(s) == -1) s = ""; //$NON-NLS-1$
				faultNameCombo.setText(s); 
			} 
		} finally {
			faultNameTracker.startTracking();
		}
	}

	protected void updateUserDefFaultNameWidgets() {
		Assert.isNotNull(getInput());
		faultUserDefNameTracker.stopTracking();
		try {
			String namespace = ModelHelper.getFaultNamespace(getInput());
			Vector<QName> faultNames;
			if (namespace == null)
				faultNames = getFaultNames();
			else faultNames = getFaultNames(namespace);
				
			faultUserDefCombo.removeAll();
			for (QName faultName : faultNames) {
				if (faultUserDefCombo.indexOf(faultName.getLocalPart()) == -1) faultUserDefCombo.add(faultName.getLocalPart());
			}
			String s = ModelHelper.getFaultName(getInput());
			if (s == null)  s = ""; //$NON-NLS-1$
			if (!s.equals(faultUserDefCombo.getText()))
			{
				if (faultUserDefCombo.indexOf(s) == -1) {
					faultUserDefCombo.setText(""); //$NON-NLS-1$
				} else {
					faultUserDefCombo.setText(s);
				}
			} 
		} finally {
			faultUserDefNameTracker.startTracking();
		}
	}

	protected void updateFaultNamespaceWidgets() {
		Assert.isNotNull(getInput());
		faultNamespaceTracker.stopTracking();
		try {
			Vector<QName> namespaces = getFaultNames();

			faultNamespaceCombo.removeAll();
			for (QName qname : namespaces) {
				String uri = NamespaceUtils.convertUriToNamespace(qname.getNamespaceURI());
				if (faultNamespaceCombo.indexOf(uri) == -1)
					faultNamespaceCombo.add(uri);
			}
			String s = ModelHelper.getFaultNamespace(getInput());
			s = NamespaceUtils.convertUriToNamespace(s);
			if (s == null)
				s = ""; //$NON-NLS-1$
			if (!s.equals(faultNamespaceCombo.getText())) {
				if (faultNamespaceCombo.indexOf(s) == -1)
					s = ""; //$NON-NLS-1$
				faultNamespaceCombo.setText(s);
			}
		} finally {
			faultNamespaceTracker.startTracking();
		}
	}

	protected void updateFaultTypeWidgets() {
		Assert.isNotNull(getInput());
		String faultNamespace = ModelHelper.getFaultNamespace(getInput());

		boolean isBuiltin = isBuiltinFault(faultNamespace);
		
		builtinRadio.setSelection(isBuiltin);
		userdefRadio.setSelection(!isBuiltin);
		doChildLayout();
	}

	protected void updateVariableTypeSelector() {
		Catch _catch = (Catch)getInput();
		if (_catch.getFaultVariable() == null) {
			variableTypeSelector.setVariableType(null);
			String name = variableNameText.getText();
			variableTypeSelector.setEnabled(name != null && !"".equals(name)); //$NON-NLS-1$
		} else {
			variableTypeSelector.setEnabled(true);
		}
		if (_catch.getFaultMessageType() != null) {
			variableTypeSelector.setVariableType(_catch.getFaultMessageType());
		}
		// https://issues.jboss.org/browse/JBIDE-8045
		if (_catch.getFaultElement() != null) {
			variableTypeSelector.setVariableType(_catch.getFaultElement());
		}
	}
	
	@Override
	public void refresh() {
		super.refresh();
		updateFaultTypeWidgets();
		updateFaultNamespaceWidgets();
		updateUserDefFaultNameWidgets();
		updateFaultNameWidgets();
		updateVariableWidgets();
	}

	protected void updateVariableWidgets() {
		variableNameTracker.stopTracking();
		try {
		    Catch _catch = (Catch)getInput();
		    Variable variable = _catch.getFaultVariable();
		    if (variable == null) {
		        variableNameText.setText(""); //$NON-NLS-1$
		    } else {
		        variableNameText.setText(variable.getName() == null ? "" : variable.getName()); //$NON-NLS-1$
		    }
		    updateVariableTypeSelector();
		} finally {
			variableNameTracker.startTracking();
		}
	}

	protected String getFaultNameByNamespace(String namespace) {
		Vector<QName> faultNames = getFaultNames();
		Assert.isNotNull(faultNames);
		for (QName qname : faultNames) {
			if (qname.getNamespaceURI().equals(namespace))
				return qname.getLocalPart();
		}
		return null;
	}

	protected String getNamespaceByFaultName(String faultname) {
		Vector<QName> faultNames = getFaultNames();
		Assert.isNotNull(faultNames);
		for (QName qname : faultNames) {
			if (qname.getLocalPart().equals(faultname))
				return qname.getNamespaceURI();
		}
		return null;
	}
	
	protected boolean validNamespaceFaultNameCombination(String namespace, String faultname) {
		Vector<QName> faultNames = getFaultNames();
		Assert.isNotNull(faultNames);
		for (QName qname : faultNames) {
			if (qname.getLocalPart().equals(faultname) && qname.getNamespaceURI().equals(namespace))
				return true;
		}
		return false;
	}
	
	protected void getFaultNames(Object activity) {
		EList<Activity> activities = null;
		if (activity instanceof Sequence)
			activities = ((Sequence) activity).getActivities();
		if (activity instanceof Flow)
			activities = ((Flow) activity).getActivities();
		if (activity instanceof While)
			getFaultNames(((While) activity).getActivity());
		if (activity instanceof RepeatUntil)
			getFaultNames(((RepeatUntil) activity).getActivity());
		if (activity instanceof If) {
			for (ElseIf elif : ((If) activity).getElseIf()) {			
				getFaultNames(elif.getActivity());
			}
		}
		if (activity instanceof Pick) {
			for (OnMessage onMessage : ((Pick) activity).getMessages()) {
				getFaultNames(onMessage.getActivity());
			}
			for (OnAlarm onAlarm : ((Pick) activity).getAlarm()) {
				getFaultNames(onAlarm.getActivity());
			}
		}
		if (activity instanceof Scope) {
			Scope scope = (Scope) activity;
			FaultHandler faultHandler = scope.getFaultHandlers();
			if (faultHandler != null) {
				for (Catch c : faultHandler.getCatch()) {
					getFaultNames(c.getActivity());
				}
				CatchAll catchAll = faultHandler.getCatchAll();
				if (catchAll != null) {
					getFaultNames(catchAll.getActivity());
				}
			}
			getFaultNames(scope.getActivity());
		}

		if (activities != null) {
			for (Activity subActivity : activities) {
				getFaultNames(subActivity);
			}
		}
		if (activity instanceof Throw) {
			QName name = ((Throw)activity).getFaultName();
			if (name != null) {
				faultNameQNames.add(name);
			}
		}
	}
	
	protected Vector<QName> getFaultNames(String namespace) {
		Vector<QName> result = new Vector<QName>();
		for (QName qname : getFaultNames()) {
			if (qname.getNamespaceURI().equals(namespace))
				result.add(qname);
		}
		return result;
	}
	
	protected Vector<QName> getFaultNames() {
		faultNameQNames = new Vector<QName>();
		if (getInput() == null)
			throw new IllegalStateException();
		Process p = BPELUtils.getProcess(getInput());

		// get FaultNames from activities
		getFaultNames(p.getActivity());

		for (PartnerLink partnerLink : p.getPartnerLinks().getChildren()) {
			Role role = partnerLink.getMyRole();
			if (role == null)
				role = partnerLink.getPartnerRole();
			if (role != null) {
				PortType portType = (PortType)role.getPortType();
				if (portType != null && !portType.eIsProxy()) {
					for (Iterator operationsIterator = portType.getEOperations().iterator(); operationsIterator.hasNext();) {
						Operation operation = (Operation) operationsIterator.next();
						Map faults = operation.getFaults();
						if (faults != null) {
							if (faults.size() > 0) {
								for (Iterator faultsIter = faults.values().iterator(); faultsIter.hasNext();) {
									Fault fault = (Fault) faultsIter.next();
									faultNameQNames.add(new QName(portType.getQName().getNamespaceURI(), fault.getName()));
								}
							}
						}
					}
				}
			}
		}
		return faultNameQNames;
	}

	public static class FaultCatchContext {
		public int context;
		public Object innerContext;
		FaultCatchContext(int context) { this.context = context; }
	}
	
	@Override
	public Object getUserContext() {
		FaultCatchContext result = new FaultCatchContext(lastChangeContext);
		if (lastChangeContext == FAULT_VARIABLE_TYPE_CONTEXT) {
			result.innerContext = variableTypeSelector.getUserContext();
		}
		return result;
	}
	@Override
	public void restoreUserContext(Object userContext) {
		FaultCatchContext c = (FaultCatchContext)userContext; 
		switch (c.context) {
			case NAME_BUILTIN_CONTEXT: faultNameCombo.setFocus(); return;
			case NAMESPACE_CONTEXT: faultNamespaceCombo.setFocus(); return;
			case BUILTINRADIO_CONTEXT: builtinRadio.setFocus(); return;
			case USERDEFRADIO_CONTEXT: userdefRadio.setFocus(); return;
			case NAME_USERDEF_CONTEXT: faultUserDefCombo.setFocus(); return;
			case FAULT_VARIABLE_NAME_CONTEXT: variableNameText.setFocus(); return;
			case FAULT_VARIABLE_TYPE_CONTEXT:
				variableTypeSelector.restoreUserContext(c.innerContext); return;
		}
		throw new IllegalStateException();
	}

	private Command getCreateNewVariableCommand() {
		return new AutoUndoCommand(getProcess()) {
			@Override
			public void doExecute() {
				CompoundCommand result = new CompoundCommand();
				// if the variable does not exist or does not have a type,
				// create one and assign the best default type
				Catch _catch = (Catch)getInput();
				Variable variable = _catch.getFaultVariable();
				QName faultQName = ModelHelper.getFaultQName(getInput());
				Message type = getFaultMessage(faultQName);
			    variable = BPELFactory.eINSTANCE.createVariable();
			    variable.setMessageType(type);
			    result.add(new SetVariableCommand(_catch, variable, ModelHelper.INCOMING));
				// set variable name command
				String name = variableNameText.getText();
				if (name == null || "".equals(name)) { //$NON-NLS-1$
					String hint = BPELPackage.eINSTANCE.getVariable().getName();
					name = BPELUtil.getUniqueModelName(getProcess(), hint, null);
				}
				result.add(new SetNameCommand(variable, name));
				result.execute();
			}
		};
	}

	/**
	 * Gets the fault message from the fault qname.
	 */
	protected Message getFaultMessage(QName faultQName) {
		if (faultQName == null || faultQName.getNamespaceURI() == null || faultQName.getLocalPart() == null) return null;

		Definition[] definitions = getDefinitions(faultQName.getNamespaceURI());
		for (int i = 0; i < definitions.length; i++) {
			Definition definition = definitions[i];
			for (Iterator iter1 = definition.getEPortTypes().iterator(); iter1.hasNext();) {
				PortType portType = (PortType) iter1.next();
				for (Iterator iter2 = portType.getOperations().iterator(); iter2.hasNext();) {
					Operation operation = (Operation) iter2.next();
					Fault fault = (Fault) operation.getFault(faultQName.getLocalPart());
					if (fault != null) {
						return fault.getEMessage();
					}
				}
			}
		}

		// it does not exist in a WSDL files, check
		// if it is declared in a throw activity
		return getMessageFromThrow(faultQName);
	}
	
	protected Definition[] getDefinitions(String namespace) {
		List<Definition> result = new ArrayList<Definition>();
		List<Import> imports = getProcess().getImports();
		if (imports != null) {
			for (Import _import: imports) {
				if (WSDLConstants.WSDL_NAMESPACE_URI.equals(_import.getImportType()))  {
					if (namespace.equals(_import.getNamespace())) {
						result.add(WSDLImportHelper.getDefinition(_import));
					}
				}
			}
		}
		return result.toArray(new Definition[result.size()]);
	}
	
	/**
	 * Given the fault qname, looks for the message type defined by
	 * a throw activity visible to this context.
	 */
	protected Message getMessageFromThrow(QName faultQName) {
		Object container = getInput().eContainer().eContainer();
		if (!(container instanceof Scope)) return null; // it might be an invoke so return null
		Scope scope = (Scope) container;
		for (Iterator<EObject> iter = scope.eAllContents(); iter.hasNext();) {
			Object element = iter.next();
			if (element instanceof Throw) {
				Throw t = (Throw) element;
				if (faultQName.equals(t.getFaultName()) && (t.getFaultVariable() != null)) {
					return (t.getFaultVariable()).getMessageType();
				}
			}
		}
		return null;
	}

	protected boolean isEmptyMessageType(String newName) {
		return Messages.FaultCatchNameSection_None_0.equals(newName) && builtinRadio.getSelection();
	}

	protected List<String> getBuiltinFaultNames() {
		List<String> faultNames = new ArrayList<String>();
		faultNames.add(Messages.FaultCatchNameSection_None_0);
		faultNames.addAll(Arrays.asList(BPELConstants.standardFaults));		
		return faultNames;
	}
	
	protected boolean isBuiltinFault(String faultNamespace) {
		boolean isBuiltin = BPELConstants.NAMESPACE.equals(faultNamespace);
		if (faultNamespace == null) {
			if (ModelHelper.getFaultName(getInput()) == null)  isBuiltin = true;
		}
		return isBuiltin;
	}


}