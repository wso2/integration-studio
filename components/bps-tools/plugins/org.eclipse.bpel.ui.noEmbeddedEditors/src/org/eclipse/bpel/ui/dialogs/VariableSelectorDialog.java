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
package org.eclipse.bpel.ui.dialogs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameCommand;
import org.eclipse.bpel.ui.commands.SetVariableTypeCommand;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.NameDialog;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * Asks the user to select a variable.
 */
public class VariableSelectorDialog extends SelectionAndCreationDialog {

	protected static class TypeLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof Variable) {
				Variable variable = (Variable)element;
				if (variable.getMessageType() != null) {
					Message message = variable.getMessageType();
					QName qname = message.getQName();
					String uri = NamespaceUtils.convertUriToNamespace(qname.getNamespaceURI());
					return uri + " - " + qname.getLocalPart(); //$NON-NLS-1$
				}
				if (variable.getType() != null) {
					return XSDUtils.getDisplayNameFromXSDType(variable.getType());
				}
				if (variable.getXSDElement() != null) {
					return variable.getXSDElement().getName();
				}
			}
			return Messages.VariableSelectorDialog_None_0; 
		}
	}
	
	/**
	 * The sort order should be:
	 *   - variables with the desired type
	 *   - alphabetical by name 
	 */
	protected class VariableComparator implements Comparator {
		/**
		 * The given objects are the variable names.
		 */
		public int compare(Object o1, Object o2) {
			String name1 = (String)o1;
			String name2 = (String)o2;
			if (name1 == null || name2 == null) {
				// neither of the names should be null but we handle it here in case that happens
				if (name1 == null && name2 == null) return 0;
				if (name1 == null) return 1;
				return -1;
			}
			// since we are only passed the variable names, we have to use the following workaround
			// to get the variable object 
			Variable var1 = getVariable(name1);
			Variable var2 = getVariable(name2);
			if (variableType != null) {
				Object type1 = null;
				Object type2 = null;
				if (variableType instanceof Message) {
					type1 = var1.getMessageType();
					type2 = var2.getMessageType();
				} else if (variableType instanceof XSDTypeDefinition) {
					type1 = var1.getType();
					type2 = var2.getType();
				} else if (variableType instanceof XSDElementDeclaration) {
					type1 = var1.getXSDElement();
					type2 = var2.getXSDElement();
				}
				if (variableType.equals(type1) && !variableType.equals(type2)) return -1;
				if (!variableType.equals(type1) && variableType.equals(type2)) return 1;
				// if both are equal we should compare the names (bellow)
			}
			return name1.compareTo(name2);
		}
	}
	
	protected EObject modelObject;
	protected Map nameToVariable;
	protected Variable[] variables;
	protected EObject variableType;
	protected Text filterText;
	
	/**
	 * The modelObject is the model element that indicates the scope in which the
	 * variable should be visible.
	 */
	public VariableSelectorDialog(Shell parent, EObject modelObject, EObject variableType) {
		super(parent, new PropertiesLabelProvider(), new TypeLabelProvider());
		this.modelObject = modelObject;
		this.variableType = variableType;
		nameToVariable = new HashMap();
		setMessage(Messages.VariableSelectorDialog_Variable_Name_wildcards_1); 
		setUpperListLabel(Messages.VariableSelectorDialog_Matches_2); 
		setLowerListLabel(Messages.VariableSelectorDialog_Variable_Type_4); 
		refreshVariables();
	}
	
	protected void refreshVariables() {
		variables = BPELUtil.getVisibleVariables(modelObject);
		setElements(variables);
		if (fFilteredList != null) {
			setListElements(variables);
		}
	}
	
	@Override
	protected FilteredList createFilteredList(Composite parent) {
		FilteredList result = super.createFilteredList(parent);
		result.setComparator(new VariableComparator());
		return result;
	}
	
	@Override
	protected void handleNewButtonPushed() {
		Variable variable = BPELFactory.eINSTANCE.createVariable();
		Process process = BPELUtils.getProcess(modelObject);
		String newName = filterText.getText();
		newName = BPELUtil.generateUniqueModelName(process, newName, variable);
		NameDialog nameDialog = new NameDialog(getShell(), Messages.VariableSelectorDialog_New_Variable_4, Messages.VariableSelectorDialog_Variable_Name_5, 
			newName, BPELUtil.getNCNameValidator());
		if (nameDialog.open() == Window.OK) {
			String newVariableName = nameDialog.getValue();
			CompoundCommand command = new CompoundCommand();
			command.add(new InsertInContainerCommand(process, variable, null));
			command.add(new SetNameCommand(variable, newVariableName));
			command.add(new SetVariableTypeCommand(variable, variableType));
			ModelHelper.getBPELEditor(process).getCommandStack().execute(command);
			refreshVariables();
			setFilter(variable.getName());
			setLowerSelectedElement(variable);
			
			// give focus to the dialog's OK button
			getOkButton().setFocus();
		}
	}
	
	/**
	 * Returns a variable from its name.
	 */
	protected Variable getVariable(String name) {
		Variable result = (Variable)nameToVariable.get(name);
		if (result != null) return result;
		for (int i = 0; i < variables.length; i++) {
			if (name.equals(variables[i].getName())) {
				nameToVariable.put(name, variables[i]);
				return variables[i];
			}
		}
		return null; // should never happen
	}
	
	/**
	 * Returns the chosen variable or null.
	 */
	public Variable getVariable() {
		if (getResult().length > 0) {
			return (Variable)getResult()[0];
		}
		return null;
	}
	
	/**
	 * Only used to get the Text instance.
	 */
	@Override
	protected Text createFilterText(Composite parent) {
		filterText = super.createFilterText(parent);
		return filterText;
	}
}
