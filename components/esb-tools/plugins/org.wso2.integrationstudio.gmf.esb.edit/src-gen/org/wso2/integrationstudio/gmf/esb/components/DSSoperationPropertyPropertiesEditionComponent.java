/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.components;

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

import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.PropertyValueType;

import org.wso2.integrationstudio.gmf.esb.parts.DSSoperationPropertyPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DSSoperationPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public DSSoperationPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dSSoperationProperty, String editing_mode) {
		super(editingContext, dSSoperationProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DSSoperationProperty.class;
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
			
			final DSSoperationProperty dSSoperationProperty = (DSSoperationProperty)elt;
			final DSSoperationPropertyPropertiesEditionPart basePart = (DSSoperationPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dSSoperationProperty.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyValueType)) {
				basePart.initPropertyValueType(EEFUtils.choiceOfValues(dSSoperationProperty, EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType()), dSSoperationProperty.getPropertyValueType());
			}
			if (isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyValue))
				basePart.setPropertyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dSSoperationProperty.getPropertyValue()));
			
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
		if (editorKey == EsbViewsRepository.DSSoperationProperty.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.DSSoperationProperty.Properties.propertyValueType) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType();
		}
		if (editorKey == EsbViewsRepository.DSSoperationProperty.Properties.propertyValue) {
			return EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DSSoperationProperty dSSoperationProperty = (DSSoperationProperty)semanticObject;
		if (EsbViewsRepository.DSSoperationProperty.Properties.propertyName == event.getAffectedEditor()) {
			dSSoperationProperty.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DSSoperationProperty.Properties.propertyValueType == event.getAffectedEditor()) {
			dSSoperationProperty.setPropertyValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.DSSoperationProperty.Properties.propertyValue == event.getAffectedEditor()) {
			dSSoperationProperty.setPropertyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DSSoperationPropertyPropertiesEditionPart basePart = (DSSoperationPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyValueType))
				basePart.setPropertyValueType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSoperationProperty.Properties.propertyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValue("");
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
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType(),
			EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValue()		);
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
				if (EsbViewsRepository.DSSoperationProperty.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSoperationProperty.Properties.propertyValueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractNameValueExpressionProperty_PropertyValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSoperationProperty.Properties.propertyValue == event.getAffectedEditor()) {
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
