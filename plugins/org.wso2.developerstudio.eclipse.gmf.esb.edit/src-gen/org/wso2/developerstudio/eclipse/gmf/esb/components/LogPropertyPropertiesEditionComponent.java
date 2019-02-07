/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.LogPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.impl.LogPropertyPropertiesEditionPartImpl;;


// End of user code

/**
 * 
 * 
 */
public class LogPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public LogPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject logProperty, String editing_mode) {
		super(editingContext, logProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.LogProperty.class;
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
			
			final LogProperty logProperty = (LogProperty)elt;
			final LogPropertyPropertiesEditionPart basePart = (LogPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.LogProperty.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, logProperty.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.LogProperty.Properties.propertyValueType)) {
				basePart.initPropertyValueType(EEFUtils.choiceOfValues(logProperty, EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType()), logProperty.getPropertyValueType());
			}
			if (isAccessible(EsbViewsRepository.LogProperty.Properties.propertyValue))
				basePart.setPropertyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, logProperty.getPropertyValue()));
			
			// Start of user code  for propertyExpression command update
			if (isAccessible(EsbViewsRepository.LogProperty.Properties.propertyExpression)) {
				basePart.setExpressionValue(logProperty.getPropertyExpression());
			}
			// End of user code

		
			// init filters
			
			
			
			// Start of user code  for propertyExpression filter update
			((LogPropertyPropertiesEditionPartImpl) editingPart).validate();
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
		if (editorKey == EsbViewsRepository.LogProperty.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.LogProperty.Properties.propertyValueType) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType();
		}
		if (editorKey == EsbViewsRepository.LogProperty.Properties.propertyValue) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue();
		}
		if (editorKey == EsbViewsRepository.LogProperty.Properties.propertyExpression) {
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
		LogProperty logProperty = (LogProperty)semanticObject;
		if (EsbViewsRepository.LogProperty.Properties.propertyName == event.getAffectedEditor()) {
			logProperty.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LogProperty.Properties.propertyValueType == event.getAffectedEditor()) {
			logProperty.setPropertyValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.LogProperty.Properties.propertyValue == event.getAffectedEditor()) {
			logProperty.setPropertyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LogProperty.Properties.propertyExpression == event.getAffectedEditor()) {
			// Start of user code for updatePropertyExpression method body
			if (event.getNewValue() != null) {
				NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
				logProperty.setPropertyExpression(nsp);
			} else {
				logProperty.setPropertyExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			LogPropertyPropertiesEditionPart basePart = (LogPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LogProperty.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.LogProperty.Properties.propertyValueType))
				basePart.setPropertyValueType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LogProperty.Properties.propertyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValue("");
				}
			}
					// Start of user code for propertyExpression live update
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyExpression()
					.equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.LogProperty.Properties.propertyExpression)) {
				if (msg.getNewValue() != null) {
					basePart.setExpressionValue((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setExpressionValue(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
				if (EsbViewsRepository.LogProperty.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LogProperty.Properties.propertyValueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LogProperty.Properties.propertyValue == event.getAffectedEditor()) {
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
