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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottlePolicyConfiguration;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottlePolicyType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyConfigurationPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ThrottlePolicyConfigurationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for policyEntries ReferencesTable
	 */
	protected ReferencesTableSettings policyEntriesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ThrottlePolicyConfigurationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject throttlePolicyConfiguration, String editing_mode) {
		super(editingContext, throttlePolicyConfiguration, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ThrottlePolicyConfiguration.class;
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
			
			final ThrottlePolicyConfiguration throttlePolicyConfiguration = (ThrottlePolicyConfiguration)elt;
			final ThrottlePolicyConfigurationPropertiesEditionPart basePart = (ThrottlePolicyConfigurationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType)) {
				basePart.initPolicyType(EEFUtils.choiceOfValues(throttlePolicyConfiguration, EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType()), throttlePolicyConfiguration.getPolicyType());
			}
			if (isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount)) {
				basePart.setMaxConcurrentAccessCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, throttlePolicyConfiguration.getMaxConcurrentAccessCount()));
			}
			
			if (isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries)) {
				policyEntriesSettings = new ReferencesTableSettings(throttlePolicyConfiguration, EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyEntries());
				basePart.initPolicyEntries(policyEntriesSettings);
			}
			// init filters
			
			
			if (isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries)) {
				basePart.addFilterToPolicyEntries(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ThrottlePolicyEntry); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for policyEntries
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
		if (editorKey == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType) {
			return EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount) {
			return EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries) {
			return EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyEntries();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ThrottlePolicyConfiguration throttlePolicyConfiguration = (ThrottlePolicyConfiguration)semanticObject;
		if (EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType == event.getAffectedEditor()) {
			throttlePolicyConfiguration.setPolicyType((ThrottlePolicyType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount == event.getAffectedEditor()) {
			throttlePolicyConfiguration.setMaxConcurrentAccessCount((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, policyEntriesSettings, editingContext.getAdapterFactory());
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
				policyEntriesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				policyEntriesSettings.move(event.getNewIndex(), (ThrottlePolicyEntry) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ThrottlePolicyConfigurationPropertiesEditionPart basePart = (ThrottlePolicyConfigurationPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType))
				basePart.setPolicyType((ThrottlePolicyType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount)) {
				if (msg.getNewValue() != null) {
					basePart.setMaxConcurrentAccessCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setMaxConcurrentAccessCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyEntries().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyEntries))
				basePart.updatePolicyEntries();
			
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
			EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType(),
			EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount(),
			EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyEntries()		);
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
				if (EsbViewsRepository.ThrottlePolicyConfiguration.Properties.policyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_PolicyType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyConfiguration.Properties.maxConcurrentAccessCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount().getEAttributeType(), newValue);
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
