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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.NamespacedPropertyPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class NamespacedPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public NamespacedPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject namespacedProperty, String editing_mode) {
		super(editingContext, namespacedProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.NamespacedProperty.class;
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
			
			final NamespacedProperty namespacedProperty = (NamespacedProperty)elt;
			final NamespacedPropertyPropertiesEditionPart basePart = (NamespacedPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.prettyName))
				basePart.setPrettyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namespacedProperty.getPrettyName()));
			
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namespacedProperty.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.propertyValue))
				basePart.setPropertyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namespacedProperty.getPropertyValue()));
			
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.namespaces))
				basePart.setNamespaces(EEFConverterUtil.convertToString(EsbPackage.Literals.MAP, namespacedProperty.getNamespaces()));
			
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths)) {
				basePart.setSupportsDynamicXPaths(namespacedProperty.isSupportsDynamicXPaths());
			}
			if (isAccessible(EsbViewsRepository.NamespacedProperty.Properties.dynamic)) {
				basePart.setDynamic(namespacedProperty.isDynamic());
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
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.prettyName) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_PrettyName();
		}
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.propertyValue) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_PropertyValue();
		}
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.namespaces) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_Namespaces();
		}
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_SupportsDynamicXPaths();
		}
		if (editorKey == EsbViewsRepository.NamespacedProperty.Properties.dynamic) {
			return EsbPackage.eINSTANCE.getNamespacedProperty_Dynamic();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NamespacedProperty namespacedProperty = (NamespacedProperty)semanticObject;
		if (EsbViewsRepository.NamespacedProperty.Properties.prettyName == event.getAffectedEditor()) {
			namespacedProperty.setPrettyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamespacedProperty.Properties.propertyName == event.getAffectedEditor()) {
			namespacedProperty.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamespacedProperty.Properties.propertyValue == event.getAffectedEditor()) {
			namespacedProperty.setPropertyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamespacedProperty.Properties.namespaces == event.getAffectedEditor()) {
			namespacedProperty.setNamespaces((java.util.Map)EEFConverterUtil.createFromString(EsbPackage.Literals.MAP, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths == event.getAffectedEditor()) {
			namespacedProperty.setSupportsDynamicXPaths((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamespacedProperty.Properties.dynamic == event.getAffectedEditor()) {
			namespacedProperty.setDynamic((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			NamespacedPropertyPropertiesEditionPart basePart = (NamespacedPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getNamespacedProperty_PrettyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.prettyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPrettyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPrettyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getNamespacedProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getNamespacedProperty_PropertyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.propertyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getNamespacedProperty_Namespaces().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.namespaces)) {
				if (msg.getNewValue() != null) {
					basePart.setNamespaces(EcoreUtil.convertToString(EsbPackage.Literals.MAP, msg.getNewValue()));
				} else {
					basePart.setNamespaces("");
				}
			}
			if (EsbPackage.eINSTANCE.getNamespacedProperty_SupportsDynamicXPaths().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths))
				basePart.setSupportsDynamicXPaths((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getNamespacedProperty_Dynamic().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamespacedProperty.Properties.dynamic))
				basePart.setDynamic((Boolean)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getNamespacedProperty_PrettyName(),
			EsbPackage.eINSTANCE.getNamespacedProperty_PropertyName(),
			EsbPackage.eINSTANCE.getNamespacedProperty_PropertyValue(),
			EsbPackage.eINSTANCE.getNamespacedProperty_Namespaces(),
			EsbPackage.eINSTANCE.getNamespacedProperty_SupportsDynamicXPaths(),
			EsbPackage.eINSTANCE.getNamespacedProperty_Dynamic()		);
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
				if (EsbViewsRepository.NamespacedProperty.Properties.prettyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_PrettyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_PrettyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamespacedProperty.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamespacedProperty.Properties.propertyValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_PropertyValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_PropertyValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamespacedProperty.Properties.namespaces == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_Namespaces().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_Namespaces().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamespacedProperty.Properties.supportsDynamicXPaths == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_SupportsDynamicXPaths().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_SupportsDynamicXPaths().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamespacedProperty.Properties.dynamic == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamespacedProperty_Dynamic().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamespacedProperty_Dynamic().getEAttributeType(), newValue);
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
