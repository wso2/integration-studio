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
import org.wso2.integrationstudio.eclipse.gmf.esb.RouterTargetContainer;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterTargetContainerPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RouterTargetContainerPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public RouterTargetContainerPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject routerTargetContainer, String editing_mode) {
		super(editingContext, routerTargetContainer, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RouterTargetContainer.class;
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
			
			final RouterTargetContainer routerTargetContainer = (RouterTargetContainer)elt;
			final RouterTargetContainerPropertiesEditionPart basePart = (RouterTargetContainerPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute)) {
				basePart.setBreakAfterRoute(routerTargetContainer.isBreakAfterRoute());
			}
			if (isAccessible(EsbViewsRepository.RouterTargetContainer.Properties.routePattern))
				basePart.setRoutePattern(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, routerTargetContainer.getRoutePattern()));
			
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
		if (editorKey == EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute) {
			return EsbPackage.eINSTANCE.getRouterTargetContainer_BreakAfterRoute();
		}
		if (editorKey == EsbViewsRepository.RouterTargetContainer.Properties.routePattern) {
			return EsbPackage.eINSTANCE.getRouterTargetContainer_RoutePattern();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RouterTargetContainer routerTargetContainer = (RouterTargetContainer)semanticObject;
		if (EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute == event.getAffectedEditor()) {
			routerTargetContainer.setBreakAfterRoute((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RouterTargetContainer.Properties.routePattern == event.getAffectedEditor()) {
			routerTargetContainer.setRoutePattern((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RouterTargetContainerPropertiesEditionPart basePart = (RouterTargetContainerPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getRouterTargetContainer_BreakAfterRoute().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute))
				basePart.setBreakAfterRoute((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRouterTargetContainer_RoutePattern().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RouterTargetContainer.Properties.routePattern)) {
				if (msg.getNewValue() != null) {
					basePart.setRoutePattern(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRoutePattern("");
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
			EsbPackage.eINSTANCE.getRouterTargetContainer_BreakAfterRoute(),
			EsbPackage.eINSTANCE.getRouterTargetContainer_RoutePattern()		);
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
				if (EsbViewsRepository.RouterTargetContainer.Properties.breakAfterRoute == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRouterTargetContainer_BreakAfterRoute().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRouterTargetContainer_BreakAfterRoute().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RouterTargetContainer.Properties.routePattern == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRouterTargetContainer_RoutePattern().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRouterTargetContainer_RoutePattern().getEAttributeType(), newValue);
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
