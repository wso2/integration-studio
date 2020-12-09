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

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EndPointPropertyPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.EndPointPropertyPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class EndPointPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EndPointPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject endPointProperty, String editing_mode) {
		super(editingContext, endPointProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.EndPointProperty.class;
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
			
			final EndPointProperty endPointProperty = (EndPointProperty)elt;
			final EndPointPropertyPropertiesEditionPart basePart = (EndPointPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.EndPointProperty.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, endPointProperty.getName()));
			
			if (isAccessible(EsbViewsRepository.EndPointProperty.Properties.value))
				basePart.setValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, endPointProperty.getValue()));
			
			if (isAccessible(EsbViewsRepository.EndPointProperty.Properties.scope)) {
				basePart.initScope(EEFUtils.choiceOfValues(endPointProperty, EsbPackage.eINSTANCE.getEndPointProperty_Scope()), endPointProperty.getScope());
			}
			if (isAccessible(EsbViewsRepository.EndPointProperty.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(endPointProperty, EsbPackage.eINSTANCE.getEndPointProperty_ValueType()), endPointProperty.getValueType());
			}
			// Start of user code  for valueExpression command update
			if (isAccessible(EsbViewsRepository.EndPointProperty.Properties.valueExpression)) {
                basePart.setValueExpression(endPointProperty.getValueExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			
			// Start of user code  for valueExpression filter update
			((EndPointPropertyPropertiesEditionPartImpl) editingPart).validate();
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
		if (editorKey == EsbViewsRepository.EndPointProperty.Properties.name) {
			return EsbPackage.eINSTANCE.getEndPointProperty_Name();
		}
		if (editorKey == EsbViewsRepository.EndPointProperty.Properties.value) {
			return EsbPackage.eINSTANCE.getEndPointProperty_Value();
		}
		if (editorKey == EsbViewsRepository.EndPointProperty.Properties.scope) {
			return EsbPackage.eINSTANCE.getEndPointProperty_Scope();
		}
		if (editorKey == EsbViewsRepository.EndPointProperty.Properties.valueType) {
			return EsbPackage.eINSTANCE.getEndPointProperty_ValueType();
		}
		if (editorKey == EsbViewsRepository.EndPointProperty.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getEndPointProperty_ValueExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EndPointProperty endPointProperty = (EndPointProperty)semanticObject;
		if (EsbViewsRepository.EndPointProperty.Properties.name == event.getAffectedEditor()) {
			endPointProperty.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EndPointProperty.Properties.value == event.getAffectedEditor()) {
			endPointProperty.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EndPointProperty.Properties.scope == event.getAffectedEditor()) {
			endPointProperty.setScope((EndPointPropertyScope)event.getNewValue());
		}
		if (EsbViewsRepository.EndPointProperty.Properties.valueType == event.getAffectedEditor()) {
			endPointProperty.setValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.EndPointProperty.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nspValueExpression = (NamespacedProperty)event.getNewValue();
                endPointProperty.setValueExpression(nspValueExpression);
            } else {
                endPointProperty.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EndPointPropertyPropertiesEditionPart basePart = (EndPointPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEndPointProperty_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EndPointProperty.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPointProperty_Value().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EndPointProperty.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPointProperty_Scope().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EndPointProperty.Properties.scope))
				basePart.setScope((EndPointPropertyScope)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPointProperty_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EndPointProperty.Properties.valueType))
				basePart.setValueType((PropertyValueType)msg.getNewValue());
			
					// Start of user code for valueExpression live update
			if (EsbPackage.eINSTANCE.getEndPointProperty_ValueExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null 
			        && isAccessible(EsbViewsRepository.EndPointProperty.Properties.valueExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setValueExpression((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getEndPointProperty_Name(),
			EsbPackage.eINSTANCE.getEndPointProperty_Value(),
			EsbPackage.eINSTANCE.getEndPointProperty_Scope(),
			EsbPackage.eINSTANCE.getEndPointProperty_ValueType(),
			EsbPackage.eINSTANCE.getEndPointProperty_ValueExpression()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EsbViewsRepository.EndPointProperty.Properties.name || key == EsbViewsRepository.EndPointProperty.Properties.value || key == EsbViewsRepository.EndPointProperty.Properties.scope;
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
				if (EsbViewsRepository.EndPointProperty.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPointProperty_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPointProperty_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EndPointProperty.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPointProperty_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPointProperty_Value().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EndPointProperty.Properties.scope == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPointProperty_Scope().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPointProperty_Scope().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EndPointProperty.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPointProperty_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPointProperty_ValueType().getEAttributeType(), newValue);
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
