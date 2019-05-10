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

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteRulePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class URLRewriteRulePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for rewriteRuleAction ReferencesTable
	 */
	protected ReferencesTableSettings rewriteRuleActionSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public URLRewriteRulePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject uRLRewriteRule, String editing_mode) {
		super(editingContext, uRLRewriteRule, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.URLRewriteRule.class;
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
			
			final URLRewriteRule uRLRewriteRule = (URLRewriteRule)elt;
			final URLRewriteRulePropertiesEditionPart basePart = (URLRewriteRulePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction)) {
				rewriteRuleActionSettings = new ReferencesTableSettings(uRLRewriteRule, EsbPackage.eINSTANCE.getURLRewriteRule_RewriteRuleAction());
				basePart.initRewriteRuleAction(rewriteRuleActionSettings);
			}
			// Start of user code  for urlRewriteRuleCondition command update
			if (isAccessible(EsbViewsRepository.URLRewriteRule.Properties.urlRewriteRuleCondition)) {
				basePart.setUrlRewriteRuleCondition(uRLRewriteRule.getUrlRewriteRuleCondition());
			}
			// End of user code
			
			// init filters
			if (isAccessible(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction)) {
				basePart.addFilterToRewriteRuleAction(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof URLRewriteRuleAction); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for rewriteRuleAction
				// End of user code
			}
			// Start of user code  for urlRewriteRuleCondition filter update
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
		if (editorKey == EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction) {
			return EsbPackage.eINSTANCE.getURLRewriteRule_RewriteRuleAction();
		}
		if (editorKey == EsbViewsRepository.URLRewriteRule.Properties.urlRewriteRuleCondition) {
			return EsbPackage.eINSTANCE.getURLRewriteRule_UrlRewriteRuleCondition();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		URLRewriteRule uRLRewriteRule = (URLRewriteRule)semanticObject;
		if (EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, rewriteRuleActionSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				rewriteRuleActionSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				rewriteRuleActionSettings.move(event.getNewIndex(), (URLRewriteRuleAction) event.getNewValue());
			}
		}
		
		if (EsbViewsRepository.URLRewriteRule.Properties.urlRewriteRuleCondition == event.getAffectedEditor()) {
			// Start of user code for updateUrlRewriteRuleCondition method body
			if (event.getNewValue() != null) {
				EvaluatorExpressionProperty eep = (EvaluatorExpressionProperty) event.getNewValue();
				uRLRewriteRule.setUrlRewriteRuleCondition(eep);
			} else {
				uRLRewriteRule.setUrlRewriteRuleCondition(EsbFactoryImpl.eINSTANCE.createEvaluatorExpressionProperty());
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
			URLRewriteRulePropertiesEditionPart basePart = (URLRewriteRulePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getURLRewriteRule_RewriteRuleAction().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.URLRewriteRule.Properties.rewriteRuleAction))
				basePart.updateRewriteRuleAction();
					// Start of user code for urlRewriteRuleCondition live update
			if (EsbPackage.eINSTANCE.getURLRewriteRule_UrlRewriteRuleCondition().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.URLRewriteRule.Properties.urlRewriteRuleCondition)) {
				if (msg.getNewValue() != null) {
					basePart.setUrlRewriteRuleCondition((EvaluatorExpressionProperty) msg.getNewValue());
				} else {
					basePart.setUrlRewriteRuleCondition(EsbFactoryImpl.eINSTANCE.createEvaluatorExpressionProperty());
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
			EsbPackage.eINSTANCE.getURLRewriteRule_RewriteRuleAction(),
			EsbPackage.eINSTANCE.getURLRewriteRule_UrlRewriteRuleCondition()		);
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
