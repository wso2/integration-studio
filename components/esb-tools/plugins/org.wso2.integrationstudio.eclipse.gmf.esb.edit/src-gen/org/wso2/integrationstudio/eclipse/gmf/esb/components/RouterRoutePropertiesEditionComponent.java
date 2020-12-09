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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RouterRoute;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RouterRoutePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RouterRoutePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for routeExpression EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings routeExpressionSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public RouterRoutePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject routerRoute, String editing_mode) {
		super(editingContext, routerRoute, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.RouterRoute.class;
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
			
			final RouterRoute routerRoute = (RouterRoute)elt;
			final RouterRoutePropertiesEditionPart basePart = (RouterRoutePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute)) {
				basePart.setBreakAfterRoute(routerRoute.isBreakAfterRoute());
			}
			if (isAccessible(EsbViewsRepository.RouterRoute.Properties.routeExpression)) {
				// init part
				routeExpressionSettings = new EObjectFlatComboSettings(routerRoute, EsbPackage.eINSTANCE.getRouterRoute_RouteExpression());
				basePart.initRouteExpression(routeExpressionSettings);
				// set the button mode
				basePart.setRouteExpressionButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EsbViewsRepository.RouterRoute.Properties.routePattern))
				basePart.setRoutePattern(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, routerRoute.getRoutePattern()));
			
			// init filters
			
			if (isAccessible(EsbViewsRepository.RouterRoute.Properties.routeExpression)) {
				basePart.addFilterToRouteExpression(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof NamespacedProperty); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for routeExpression
				// End of user code
			}
			
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
		if (editorKey == EsbViewsRepository.RouterRoute.Properties.breakAfterRoute) {
			return EsbPackage.eINSTANCE.getRouterRoute_BreakAfterRoute();
		}
		if (editorKey == EsbViewsRepository.RouterRoute.Properties.routeExpression) {
			return EsbPackage.eINSTANCE.getRouterRoute_RouteExpression();
		}
		if (editorKey == EsbViewsRepository.RouterRoute.Properties.routePattern) {
			return EsbPackage.eINSTANCE.getRouterRoute_RoutePattern();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RouterRoute routerRoute = (RouterRoute)semanticObject;
		if (EsbViewsRepository.RouterRoute.Properties.breakAfterRoute == event.getAffectedEditor()) {
			routerRoute.setBreakAfterRoute((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.RouterRoute.Properties.routeExpression == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				routeExpressionSettings.setToReference((NamespacedProperty)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				NamespacedProperty eObject = EsbFactory.eINSTANCE.createNamespacedProperty();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				routeExpressionSettings.setToReference(eObject);
			}
		}
		if (EsbViewsRepository.RouterRoute.Properties.routePattern == event.getAffectedEditor()) {
			routerRoute.setRoutePattern((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			RouterRoutePropertiesEditionPart basePart = (RouterRoutePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getRouterRoute_BreakAfterRoute().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RouterRoute.Properties.breakAfterRoute))
				basePart.setBreakAfterRoute((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getRouterRoute_RouteExpression().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.RouterRoute.Properties.routeExpression))
				basePart.setRouteExpression((EObject)msg.getNewValue());
			if (EsbPackage.eINSTANCE.getRouterRoute_RoutePattern().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.RouterRoute.Properties.routePattern)) {
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
			EsbPackage.eINSTANCE.getRouterRoute_BreakAfterRoute(),
			EsbPackage.eINSTANCE.getRouterRoute_RouteExpression(),
			EsbPackage.eINSTANCE.getRouterRoute_RoutePattern()		);
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
				if (EsbViewsRepository.RouterRoute.Properties.breakAfterRoute == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRouterRoute_BreakAfterRoute().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRouterRoute_BreakAfterRoute().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.RouterRoute.Properties.routePattern == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getRouterRoute_RoutePattern().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getRouterRoute_RoutePattern().getEAttributeType(), newValue);
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
