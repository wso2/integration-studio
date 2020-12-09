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
import org.wso2.integrationstudio.eclipse.gmf.esb.NameValueTypeProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskPropertyType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.NameValueTypePropertyPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class NameValueTypePropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public NameValueTypePropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject nameValueTypeProperty, String editing_mode) {
		super(editingContext, nameValueTypeProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.NameValueTypeProperty.class;
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
			
			final NameValueTypeProperty nameValueTypeProperty = (NameValueTypeProperty)elt;
			final NameValueTypePropertyPropertiesEditionPart basePart = (NameValueTypePropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nameValueTypeProperty.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue))
				basePart.setPropertyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nameValueTypeProperty.getPropertyValue()));
			
			if (isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType)) {
				basePart.initPropertyType(EEFUtils.choiceOfValues(nameValueTypeProperty, EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType()), nameValueTypeProperty.getPropertyType());
			}
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
		if (editorKey == EsbViewsRepository.NameValueTypeProperty.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue) {
			return EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyValue();
		}
		if (editorKey == EsbViewsRepository.NameValueTypeProperty.Properties.propertyType) {
			return EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NameValueTypeProperty nameValueTypeProperty = (NameValueTypeProperty)semanticObject;
		if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyName == event.getAffectedEditor()) {
			nameValueTypeProperty.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue == event.getAffectedEditor()) {
			nameValueTypeProperty.setPropertyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyType == event.getAffectedEditor()) {
			nameValueTypeProperty.setPropertyType((TaskPropertyType)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			NameValueTypePropertyPropertiesEditionPart basePart = (NameValueTypePropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NameValueTypeProperty.Properties.propertyType))
				basePart.setPropertyType((TaskPropertyType)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyName(),
			EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyValue(),
			EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType()		);
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
				if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NameValueTypeProperty.Properties.propertyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNameValueTypeProperty_PropertyType().getEAttributeType(), newValue);
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
