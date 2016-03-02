package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.util.Iterator;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;

public class CloudConnectorDynamicParameterPropertyDescriptor extends PropertyDescriptor{
	
	IItemPropertyDescriptor itemPropertyDescriptor=null;
	
	public CloudConnectorDynamicParameterPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
		this.itemPropertyDescriptor=itemPropertyDescriptor;
	}
	
	public CellEditor createPropertyEditor(Composite parent) {		
		if (((CloudConnectorOperation) object).getParameterEditorType() == CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR) {

			return new NamespacedPropertyEditor(parent,EsbFactory.eINSTANCE.createNamespacedProperty(), object, itemPropertyDescriptor) {
				@Override
				protected Object openDialogBox(Control cellEditorWindow) {
					String displayName = itemPropertyDescriptor.getDisplayName(object);
					Iterator<CallTemplateParameter> iterator = ((CloudConnectorOperation) object).getConnectorParameters().iterator();
					while (iterator.hasNext()) {
						final CallTemplateParameter next = (CallTemplateParameter) iterator.next();
						NamespacedProperty nsProperty = next.getParameterExpression();

						if (next.getParameterName().equals(displayName)) {
							setNamespacedProperty(EsbFactory.eINSTANCE.copyNamespacedProperty(nsProperty));
							NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(
									cellEditorWindow.getShell(), getStyle(), getNamespacedProperty());
							dialog.open();
							if (dialog.isSaved()) {
								SetCommand setCmd = new SetCommand(TransactionUtil.getEditingDomain(object),
										next,
										EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION,
										getNamespacedProperty());
								if (setCmd.canExecute()) {
									TransactionUtil.getEditingDomain(object).getCommandStack().execute(setCmd);
								}

								SetCommand setCmd2 = new SetCommand(TransactionUtil.getEditingDomain(object),
										next,
										EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE,
										RuleOptionType.EXPRESSION);
								if (setCmd.canExecute()) {
									TransactionUtil.getEditingDomain(object).getCommandStack().execute(setCmd2);
								}
							}
						}
					}
					return null;
				}
			};
		} else{		
			TextCellEditor textCellEditor=new TextCellEditor(parent){
				
				@Override
				protected void focusLost() {				
	 				String displayName=itemPropertyDescriptor.getDisplayName(object);
					Iterator<CallTemplateParameter> iterator=((CloudConnectorOperation)object).getConnectorParameters().iterator();
					String s=null;
					while (iterator.hasNext()) {
						CallTemplateParameter next = (CallTemplateParameter)iterator.next();
						if(next.getParameterName().equals(displayName)){					
						s=getValue().toString();
						
						SetCommand setCmd = new SetCommand(TransactionUtil.getEditingDomain(object), next,
								EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE,
								s);
						if(setCmd.canExecute()){
							TransactionUtil.getEditingDomain(object).getCommandStack().execute(setCmd);
						}
						
						SetCommand setCmd2 = new SetCommand(TransactionUtil.getEditingDomain(object), next,
								EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE,
								RuleOptionType.VALUE);
						if(setCmd.canExecute()){
							TransactionUtil.getEditingDomain(object).getCommandStack().execute(setCmd2);
						}
						
						setValue(s);
						}					
					}
					super.focusLost();
				}
		
			     @Override
				protected void doSetValue(Object value) {
					if (value == null) {
						Iterator<CallTemplateParameter> iterator = ((CloudConnectorOperation) object)
								.getConnectorParameters().iterator();
						while (iterator.hasNext()) {
							CallTemplateParameter next = (CallTemplateParameter) iterator.next();
							if (next.getParameterName().equals(getDisplayName())) {
								value = next.getParameterValue();
							}
						}
						if (value == null) {
							value = "";
						}
					}
					super.doSetValue(value);
				}
			};
			return textCellEditor;
		}
	}

}
