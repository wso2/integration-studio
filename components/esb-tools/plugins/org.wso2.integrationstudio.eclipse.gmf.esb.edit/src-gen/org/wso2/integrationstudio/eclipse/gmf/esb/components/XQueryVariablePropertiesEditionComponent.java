/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.integrationstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.integrationstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XQueryVariablePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.XQueryVariablePropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class XQueryVariablePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public XQueryVariablePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject xQueryVariable, String editing_mode) {
		super(editingContext, xQueryVariable, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.XQueryVariable.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final XQueryVariable xQueryVariable = (XQueryVariable)elt;
			final XQueryVariablePropertiesEditionPart basePart = (XQueryVariablePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.variableName))
				basePart.setVariableName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, xQueryVariable.getVariableName()));
			
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.variableType)) {
				basePart.initVariableType(EEFUtils.choiceOfValues(xQueryVariable, EsbPackage.eINSTANCE.getXQueryVariable_VariableType()), xQueryVariable.getVariableType());
			}
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(xQueryVariable, EsbPackage.eINSTANCE.getXQueryVariable_ValueType()), xQueryVariable.getValueType());
			}
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, xQueryVariable.getValueLiteral()));
			
			// Start of user code  for valueExpression command update
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueExpression)) {
                basePart.setValueExpression(xQueryVariable.getValueExpression());
            }
			// End of user code
			
			// Start of user code  for valueKey command update
			if (isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueKey)) {
                basePart.setValueKey(xQueryVariable.getValueKey());
            }
			// End of user code
			
			// init filters
			
			
			
			
			// Start of user code  for valueExpression filter update
			((XQueryVariablePropertiesEditionPartImpl) editingPart).validate();
			// End of user code
			
			// Start of user code  for valueKey filter update
			// End of user code
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}









	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.variableName) {
			return EsbPackage.eINSTANCE.getXQueryVariable_VariableName();
		}
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.variableType) {
			return EsbPackage.eINSTANCE.getXQueryVariable_VariableType();
		}
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.valueType) {
			return EsbPackage.eINSTANCE.getXQueryVariable_ValueType();
		}
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getXQueryVariable_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getXQueryVariable_ValueExpression();
		}
		if (editorKey == EsbViewsRepository.XQueryVariable.Properties.valueKey) {
			return EsbPackage.eINSTANCE.getXQueryVariable_ValueKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		XQueryVariable xQueryVariable = (XQueryVariable)semanticObject;
		if (EsbViewsRepository.XQueryVariable.Properties.variableName == event.getAffectedEditor()) {
			xQueryVariable.setVariableName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.XQueryVariable.Properties.variableType == event.getAffectedEditor()) {
			xQueryVariable.setVariableType((XQueryVariableType)event.getNewValue());
		}
		if (EsbViewsRepository.XQueryVariable.Properties.valueType == event.getAffectedEditor()) {
			xQueryVariable.setValueType((XQueryVariableValueType)event.getNewValue());
		}
		if (EsbViewsRepository.XQueryVariable.Properties.valueLiteral == event.getAffectedEditor()) {
			xQueryVariable.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.XQueryVariable.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nspHeaderName = (NamespacedProperty)event.getNewValue();
                xQueryVariable.setValueExpression(nspHeaderName);
            } else {
                xQueryVariable.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.XQueryVariable.Properties.valueKey == event.getAffectedEditor()) {
			// Start of user code for updateValueKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                xQueryVariable.setValueKey(rkp);
            } else {
                xQueryVariable.setValueKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			XQueryVariablePropertiesEditionPart basePart = (XQueryVariablePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getXQueryVariable_VariableName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.XQueryVariable.Properties.variableName)) {
				if (msg.getNewValue() != null) {
					basePart.setVariableName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setVariableName("");
				}
			}
			if (EsbPackage.eINSTANCE.getXQueryVariable_VariableType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.XQueryVariable.Properties.variableType))
				basePart.setVariableType((XQueryVariableType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getXQueryVariable_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueType))
				basePart.setValueType((XQueryVariableValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getXQueryVariable_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
					// Start of user code for valueExpression live update
			if (EsbPackage.eINSTANCE.getXQueryVariable_ValueExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null
			        && isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setValueExpression((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
					// End of user code
			
					// Start of user code for valueKey live update
			if (EsbPackage.eINSTANCE.getXQueryVariable_ValueKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.XQueryVariable.Properties.valueKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setValueKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setValueKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getXQueryVariable_VariableName(),
			EsbPackage.eINSTANCE.getXQueryVariable_VariableType(),
			EsbPackage.eINSTANCE.getXQueryVariable_ValueType(),
			EsbPackage.eINSTANCE.getXQueryVariable_ValueLiteral(),
			EsbPackage.eINSTANCE.getXQueryVariable_ValueExpression(),
			EsbPackage.eINSTANCE.getXQueryVariable_ValueKey()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.XQueryVariable.Properties.variableName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getXQueryVariable_VariableName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getXQueryVariable_VariableName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.XQueryVariable.Properties.variableType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getXQueryVariable_VariableType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getXQueryVariable_VariableType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.XQueryVariable.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getXQueryVariable_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getXQueryVariable_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.XQueryVariable.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getXQueryVariable_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getXQueryVariable_ValueLiteral().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
