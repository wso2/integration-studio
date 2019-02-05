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
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyWSDLResourcePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ProxyWSDLResourcePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ProxyWSDLResourcePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject proxyWSDLResource, String editing_mode) {
		super(editingContext, proxyWSDLResource, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ProxyWSDLResource.class;
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
			
			final ProxyWSDLResource proxyWSDLResource = (ProxyWSDLResource)elt;
			final ProxyWSDLResourcePropertiesEditionPart basePart = (ProxyWSDLResourcePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ProxyWSDLResource.Properties.location))
				basePart.setLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyWSDLResource.getLocation()));
			
			// Start of user code  for key command update
			if (isAccessible(EsbViewsRepository.ProxyWSDLResource.Properties.key)) {
			    basePart.setKey(proxyWSDLResource.getKey());
			}
			// End of user code
			
			// init filters
			
			// Start of user code  for key filter update
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
		if (editorKey == EsbViewsRepository.ProxyWSDLResource.Properties.location) {
			return EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Location();
		}
		if (editorKey == EsbViewsRepository.ProxyWSDLResource.Properties.key) {
			return EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Key();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ProxyWSDLResource proxyWSDLResource = (ProxyWSDLResource)semanticObject;
		if (EsbViewsRepository.ProxyWSDLResource.Properties.location == event.getAffectedEditor()) {
			proxyWSDLResource.setLocation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyWSDLResource.Properties.key == event.getAffectedEditor()) {
			// Start of user code for updateKey method body
		    if (event.getNewValue() != null) {
		        RegistryKeyProperty rkp = (RegistryKeyProperty)event.getNewValue();
		        proxyWSDLResource.setKey(rkp);
		    } else {
		        proxyWSDLResource.setKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			ProxyWSDLResourcePropertiesEditionPart basePart = (ProxyWSDLResourcePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Location().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyWSDLResource.Properties.location)) {
				if (msg.getNewValue() != null) {
					basePart.setLocation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setLocation("");
				}
			}
					// Start of user code for key live update
			if (EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Key().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.ProxyWSDLResource.Properties.key)) {
                if (msg.getNewValue() != null) {
                    basePart.setKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Location(),
			EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Key()		);
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
				if (EsbViewsRepository.ProxyWSDLResource.Properties.location == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Location().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractLocationKeyResource_Location().getEAttributeType(), newValue);
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
