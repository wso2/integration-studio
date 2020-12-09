/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyDataType;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.PropertyMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms.PropertyMediatorPropertiesEditionPartForm;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.PropertyMediatorPropertiesEditionPartImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class PropertyMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public PropertyMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject propertyMediator, String editing_mode) {
		super(editingContext, propertyMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PropertyMediator.class;
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
			
			final PropertyMediator propertyMediator = (PropertyMediator)elt;
			final PropertyMediatorPropertiesEditionPart basePart = (PropertyMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyName)) {
				basePart.initPropertyName(EEFUtils.choiceOfValues(propertyMediator, EsbPackage.eINSTANCE.getPropertyMediator_PropertyName()), propertyMediator.getPropertyName());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyDataType)) {
				basePart.initPropertyDataType(EEFUtils.choiceOfValues(propertyMediator, EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType()), propertyMediator.getPropertyDataType());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyAction)) {
				basePart.initPropertyAction(EEFUtils.choiceOfValues(propertyMediator, EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction()), propertyMediator.getPropertyAction());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyScope)) {
				basePart.initPropertyScope(EEFUtils.choiceOfValues(propertyMediator, EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope()), propertyMediator.getPropertyScope());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(propertyMediator, EsbPackage.eINSTANCE.getPropertyMediator_ValueType()), propertyMediator.getValueType());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.value))
				basePart.setValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getValue()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.expression))
				basePart.setExpression(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getExpression()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix))
				basePart.setNamespacePrefix(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getNamespacePrefix()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.namespace))
				basePart.setNamespace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getNamespace()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.boolean_)) {
				basePart.setBoolean_(propertyMediator.isBoolean());
			}
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.oM))
				basePart.setOM(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getOM()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern))
				basePart.setValueStringPattern(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getValueStringPattern()));
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup)) {
				basePart.setValueStringCapturingGroup(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, propertyMediator.getValueStringCapturingGroup()));
			}
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.newPropertyName))
				basePart.setNewPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getNewPropertyName()));
			
			// Start of user code  for valueExpression command update
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueExpression)) {
			    basePart.setValueExpression(propertyMediator.getValueExpression());
            }
			// End of user code
			
			if (isAccessible(EsbViewsRepository.PropertyMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, propertyMediator.getDescription()));
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Start of user code  for valueExpression filter update
            if (editingPart instanceof PropertyMediatorPropertiesEditionPartImpl) {
                ((PropertyMediatorPropertiesEditionPartImpl) editingPart).validate();
            }
            if (editingPart instanceof PropertyMediatorPropertiesEditionPartForm) {
                ((PropertyMediatorPropertiesEditionPartForm) editingPart).updateValueField();
            }
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
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getPropertyMediator_PropertyName();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.propertyDataType) {
			return EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.propertyAction) {
			return EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.propertyScope) {
			return EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.valueType) {
			return EsbPackage.eINSTANCE.getPropertyMediator_ValueType();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.value) {
			return EsbPackage.eINSTANCE.getPropertyMediator_Value();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.expression) {
			return EsbPackage.eINSTANCE.getPropertyMediator_Expression();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.namespacePrefix) {
			return EsbPackage.eINSTANCE.getPropertyMediator_NamespacePrefix();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.namespace) {
			return EsbPackage.eINSTANCE.getPropertyMediator_Namespace();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.boolean_) {
			return EsbPackage.eINSTANCE.getPropertyMediator_Boolean();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.oM) {
			return EsbPackage.eINSTANCE.getPropertyMediator_OM();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.valueStringPattern) {
			return EsbPackage.eINSTANCE.getPropertyMediator_ValueStringPattern();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup) {
			return EsbPackage.eINSTANCE.getPropertyMediator_ValueStringCapturingGroup();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.newPropertyName) {
			return EsbPackage.eINSTANCE.getPropertyMediator_NewPropertyName();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getPropertyMediator_ValueExpression();
		}
		if (editorKey == EsbViewsRepository.PropertyMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PropertyMediator propertyMediator = (PropertyMediator)semanticObject;
		if (EsbViewsRepository.PropertyMediator.Properties.propertyName == event.getAffectedEditor()) {
			propertyMediator.setPropertyName((PropertyName)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.propertyDataType == event.getAffectedEditor()) {
			propertyMediator.setPropertyDataType((PropertyDataType)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.propertyAction == event.getAffectedEditor()) {
			propertyMediator.setPropertyAction((PropertyAction)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.propertyScope == event.getAffectedEditor()) {
			propertyMediator.setPropertyScope((PropertyScope)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.valueType == event.getAffectedEditor()) {
			propertyMediator.setValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.value == event.getAffectedEditor()) {
			propertyMediator.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.expression == event.getAffectedEditor()) {
			propertyMediator.setExpression((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.namespacePrefix == event.getAffectedEditor()) {
			propertyMediator.setNamespacePrefix((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.namespace == event.getAffectedEditor()) {
			propertyMediator.setNamespace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.boolean_ == event.getAffectedEditor()) {
			propertyMediator.setBoolean((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.PropertyMediator.Properties.oM == event.getAffectedEditor()) {
			propertyMediator.setOM((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.valueStringPattern == event.getAffectedEditor()) {
			propertyMediator.setValueStringPattern((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup == event.getAffectedEditor()) {
			propertyMediator.setValueStringCapturingGroup((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.newPropertyName == event.getAffectedEditor()) {
			propertyMediator.setNewPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyMediator.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                propertyMediator.setValueExpression(nsp);
            } else {
                propertyMediator.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.PropertyMediator.Properties.description == event.getAffectedEditor()) {
			propertyMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PropertyMediatorPropertiesEditionPart basePart = (PropertyMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getPropertyMediator_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyName))
				basePart.setPropertyName((PropertyName)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyDataType))
				basePart.setPropertyDataType((PropertyDataType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyAction))
				basePart.setPropertyAction((PropertyAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PropertyMediator.Properties.propertyScope))
				basePart.setPropertyScope((PropertyScope)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueType))
				basePart.setValueType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_Value().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_Expression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.expression)) {
				if (msg.getNewValue() != null) {
					basePart.setExpression(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setExpression("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_NamespacePrefix().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.namespacePrefix)) {
				if (msg.getNewValue() != null) {
					basePart.setNamespacePrefix(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNamespacePrefix("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_Namespace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.namespace)) {
				if (msg.getNewValue() != null) {
					basePart.setNamespace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNamespace("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_Boolean().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.boolean_))
				basePart.setBoolean_((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPropertyMediator_OM().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.oM)) {
				if (msg.getNewValue() != null) {
					basePart.setOM(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOM("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_ValueStringPattern().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueStringPattern)) {
				if (msg.getNewValue() != null) {
					basePart.setValueStringPattern(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueStringPattern("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_ValueStringCapturingGroup().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup)) {
				if (msg.getNewValue() != null) {
					basePart.setValueStringCapturingGroup(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setValueStringCapturingGroup("");
				}
			}
			if (EsbPackage.eINSTANCE.getPropertyMediator_NewPropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.newPropertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setNewPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNewPropertyName("");
				}
			}
					// Start of user code for valueExpression live update
			if (EsbPackage.eINSTANCE.getPropertyMediator_ValueExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.valueExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setValueExpression((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }	
					// End of user code
			
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PropertyMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			
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
			EsbPackage.eINSTANCE.getPropertyMediator_PropertyName(),
			EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType(),
			EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction(),
			EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope(),
			EsbPackage.eINSTANCE.getPropertyMediator_ValueType(),
			EsbPackage.eINSTANCE.getPropertyMediator_Value(),
			EsbPackage.eINSTANCE.getPropertyMediator_Expression(),
			EsbPackage.eINSTANCE.getPropertyMediator_NamespacePrefix(),
			EsbPackage.eINSTANCE.getPropertyMediator_Namespace(),
			EsbPackage.eINSTANCE.getPropertyMediator_Boolean(),
			EsbPackage.eINSTANCE.getPropertyMediator_OM(),
			EsbPackage.eINSTANCE.getPropertyMediator_ValueStringPattern(),
			EsbPackage.eINSTANCE.getPropertyMediator_ValueStringCapturingGroup(),
			EsbPackage.eINSTANCE.getPropertyMediator_NewPropertyName(),
			EsbPackage.eINSTANCE.getPropertyMediator_ValueExpression(),
			EsbPackage.eINSTANCE.getEsbElement_Description()		);
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
				if (EsbViewsRepository.PropertyMediator.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.propertyDataType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_PropertyDataType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.propertyAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_PropertyAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.propertyScope == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_PropertyScope().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_Value().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.expression == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_Expression().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_Expression().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.namespacePrefix == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_NamespacePrefix().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_NamespacePrefix().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.namespace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_Namespace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_Namespace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.boolean_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_Boolean().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_Boolean().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.oM == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_OM().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_OM().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.valueStringPattern == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_ValueStringPattern().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_ValueStringPattern().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.valueStringCapturingGroup == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_ValueStringCapturingGroup().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_ValueStringCapturingGroup().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.newPropertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPropertyMediator_NewPropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPropertyMediator_NewPropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}
	
    // Start of user code for help compatibility

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }

    // End of user code

}
