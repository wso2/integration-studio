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

import org.wso2.developerstudio.eclipse.gmf.esb.AttributeType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorAttributePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class PublishEventMediatorAttributePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public PublishEventMediatorAttributePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject publishEventMediatorAttribute, String editing_mode) {
		super(editingContext, publishEventMediatorAttribute, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PublishEventMediatorAttribute.class;
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
			
			final PublishEventMediatorAttribute publishEventMediatorAttribute = (PublishEventMediatorAttribute)elt;
			final PublishEventMediatorAttributePropertiesEditionPart basePart = (PublishEventMediatorAttributePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName))
				basePart.setAttributeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediatorAttribute.getAttributeName()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType)) {
				basePart.initAttributeValueType(EEFUtils.choiceOfValues(publishEventMediatorAttribute, EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType()), publishEventMediatorAttribute.getAttributeValueType());
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue))
				basePart.setAttributeValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediatorAttribute.getAttributeValue()));
			
			if (isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType)) {
				basePart.initAttributeType(EEFUtils.choiceOfValues(publishEventMediatorAttribute, EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType()), publishEventMediatorAttribute.getAttributeType());
			}
			if (isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue))
				basePart.setDefaultValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, publishEventMediatorAttribute.getDefaultValue()));
			
			// init filters
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeName();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValue();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType();
		}
		if (editorKey == EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue) {
			return EsbPackage.eINSTANCE.getPublishEventMediatorAttribute_DefaultValue();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PublishEventMediatorAttribute publishEventMediatorAttribute = (PublishEventMediatorAttribute)semanticObject;
		if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName == event.getAffectedEditor()) {
			publishEventMediatorAttribute.setAttributeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType == event.getAffectedEditor()) {
			publishEventMediatorAttribute.setAttributeValueType((AttributeValueType)event.getNewValue());
		}
		if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue == event.getAffectedEditor()) {
			publishEventMediatorAttribute.setAttributeValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType == event.getAffectedEditor()) {
			publishEventMediatorAttribute.setAttributeType((AttributeType)event.getNewValue());
		}
		if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue == event.getAffectedEditor()) {
			publishEventMediatorAttribute.setDefaultValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PublishEventMediatorAttributePropertiesEditionPart basePart = (PublishEventMediatorAttributePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName)) {
				if (msg.getNewValue() != null) {
					basePart.setAttributeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAttributeName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType))
				basePart.setAttributeValueType((AttributeValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue)) {
				if (msg.getNewValue() != null) {
					basePart.setAttributeValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAttributeValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType))
				basePart.setAttributeType((AttributeType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getPublishEventMediatorAttribute_DefaultValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue)) {
				if (msg.getNewValue() != null) {
					basePart.setDefaultValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDefaultValue("");
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
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeName(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValue(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType(),
			EsbPackage.eINSTANCE.getPublishEventMediatorAttribute_DefaultValue()		);
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
				if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.attributeType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionAttribute_AttributeType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PublishEventMediatorAttribute.Properties.defaultValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getPublishEventMediatorAttribute_DefaultValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getPublishEventMediatorAttribute_DefaultValue().getEAttributeType(), newValue);
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
