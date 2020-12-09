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
import org.wso2.integrationstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.MethodArgumentPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.MethodArgumentPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class MethodArgumentPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public MethodArgumentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject methodArgument, String editing_mode) {
		super(editingContext, methodArgument, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.MethodArgument.class;
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
			
			final MethodArgument methodArgument = (MethodArgument)elt;
			final MethodArgumentPropertiesEditionPart basePart = (MethodArgumentPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, methodArgument.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyValueType)) {
				basePart.initPropertyValueType(EEFUtils.choiceOfValues(methodArgument, EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType()), methodArgument.getPropertyValueType());
			}
			if (isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyValue))
				basePart.setPropertyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, methodArgument.getPropertyValue()));
			
			// Start of user code  for propertyExpression command update
            if (isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyExpression)) {
                basePart.setPropertyExpression(methodArgument.getPropertyExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			// Start of user code  for propertyExpression filter update
            ((MethodArgumentPropertiesEditionPartImpl)editingPart).validate();
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
		if (editorKey == EsbViewsRepository.MethodArgument.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.MethodArgument.Properties.propertyValueType) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType();
		}
		if (editorKey == EsbViewsRepository.MethodArgument.Properties.propertyValue) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue();
		}
		if (editorKey == EsbViewsRepository.MethodArgument.Properties.propertyExpression) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MethodArgument methodArgument = (MethodArgument)semanticObject;
		if (EsbViewsRepository.MethodArgument.Properties.propertyName == event.getAffectedEditor()) {
			methodArgument.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MethodArgument.Properties.propertyValueType == event.getAffectedEditor()) {
			methodArgument.setPropertyValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.MethodArgument.Properties.propertyValue == event.getAffectedEditor()) {
			methodArgument.setPropertyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MethodArgument.Properties.propertyExpression == event.getAffectedEditor()) {
			// Start of user code for updatePropertyExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                methodArgument.setPropertyExpression(nsp);
            } else {
                methodArgument.setPropertyExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			MethodArgumentPropertiesEditionPart basePart = (MethodArgumentPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyValueType))
				basePart.setPropertyValueType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValue("");
				}
			}
					// Start of user code for propertyExpression live update
            if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyExpression()
                    .equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.MethodArgument.Properties.propertyExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setPropertyExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setPropertyExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyExpression()		);
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
				if (EsbViewsRepository.MethodArgument.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MethodArgument.Properties.propertyValueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MethodArgument.Properties.propertyValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue().getEAttributeType(), newValue);
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
