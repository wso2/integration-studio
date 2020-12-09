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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RegistryKeyPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class RegistryKeyPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public RegistryKeyPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject registryKeyProperty, String editing_mode) {
		super(editingContext, registryKeyProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RegistryKeyProperty.class;
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
			
			final RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)elt;
			final RegistryKeyPropertyPropertiesEditionPart basePart = (RegistryKeyPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.prettyName))
				basePart.setPrettyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, registryKeyProperty.getPrettyName()));
			
			if (isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.keyName))
				basePart.setKeyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, registryKeyProperty.getKeyName()));
			
			if (isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.keyValue))
				basePart.setKeyValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, registryKeyProperty.getKeyValue()));
			
			if (isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.filters))
				basePart.setFilters(EEFConverterUtil.convertToString(EsbPackage.Literals.MAP, registryKeyProperty.getFilters()));
			
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
		if (editorKey == EsbViewsRepository.RegistryKeyProperty.Properties.prettyName) {
			return EsbPackage.eINSTANCE.getRegistryKeyProperty_PrettyName();
		}
		if (editorKey == EsbViewsRepository.RegistryKeyProperty.Properties.keyName) {
			return EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyName();
		}
		if (editorKey == EsbViewsRepository.RegistryKeyProperty.Properties.keyValue) {
			return EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyValue();
		}
		if (editorKey == EsbViewsRepository.RegistryKeyProperty.Properties.filters) {
			return EsbPackage.eINSTANCE.getRegistryKeyProperty_Filters();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)semanticObject;
		if (EsbViewsRepository.RegistryKeyProperty.Properties.prettyName == event.getAffectedEditor()) {
			registryKeyProperty.setPrettyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RegistryKeyProperty.Properties.keyName == event.getAffectedEditor()) {
			registryKeyProperty.setKeyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RegistryKeyProperty.Properties.keyValue == event.getAffectedEditor()) {
			registryKeyProperty.setKeyValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.RegistryKeyProperty.Properties.filters == event.getAffectedEditor()) {
			registryKeyProperty.setFilters((java.util.Map)EEFConverterUtil.createFromString(EsbPackage.Literals.MAP, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RegistryKeyPropertyPropertiesEditionPart basePart = (RegistryKeyPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getRegistryKeyProperty_PrettyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.prettyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPrettyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPrettyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.keyName)) {
				if (msg.getNewValue() != null) {
					basePart.setKeyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setKeyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.keyValue)) {
				if (msg.getNewValue() != null) {
					basePart.setKeyValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setKeyValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getRegistryKeyProperty_Filters().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RegistryKeyProperty.Properties.filters)) {
				if (msg.getNewValue() != null) {
					basePart.setFilters(EcoreUtil.convertToString(EsbPackage.Literals.MAP, msg.getNewValue()));
				} else {
					basePart.setFilters("");
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
			EsbPackage.eINSTANCE.getRegistryKeyProperty_PrettyName(),
			EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyName(),
			EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyValue(),
			EsbPackage.eINSTANCE.getRegistryKeyProperty_Filters()		);
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
				if (EsbViewsRepository.RegistryKeyProperty.Properties.prettyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRegistryKeyProperty_PrettyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRegistryKeyProperty_PrettyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RegistryKeyProperty.Properties.keyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RegistryKeyProperty.Properties.keyValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRegistryKeyProperty_KeyValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RegistryKeyProperty.Properties.filters == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRegistryKeyProperty_Filters().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRegistryKeyProperty_Filters().getEAttributeType(), newValue);
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
