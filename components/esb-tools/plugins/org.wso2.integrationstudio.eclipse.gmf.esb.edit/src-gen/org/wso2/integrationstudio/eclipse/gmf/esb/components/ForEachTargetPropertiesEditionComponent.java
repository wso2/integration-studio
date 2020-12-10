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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ForEachTarget;
import org.wso2.integrationstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetSequenceType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachTargetPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ForEachTargetPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for sequence EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sequenceSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ForEachTargetPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject forEachTarget, String editing_mode) {
		super(editingContext, forEachTarget, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ForEachTarget.class;
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
			
			final ForEachTarget forEachTarget = (ForEachTarget)elt;
			final ForEachTargetPropertiesEditionPart basePart = (ForEachTargetPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.sequenceType)) {
				basePart.initSequenceType(EEFUtils.choiceOfValues(forEachTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType()), forEachTarget.getSequenceType());
			}
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.sequence)) {
				// init part
				sequenceSettings = new EObjectFlatComboSettings(forEachTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence());
				basePart.initSequence(sequenceSettings);
				// set the button mode
				basePart.setSequenceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(forEachTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType()), forEachTarget.getEndpointType());
			}
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.soapAction))
				basePart.setSoapAction(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, forEachTarget.getSoapAction()));
			
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.toAddress))
				basePart.setToAddress(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, forEachTarget.getToAddress()));
			
			// init filters
			
			if (isAccessible(EsbViewsRepository.ForEachTarget.Properties.sequence)) {
				basePart.addFilterToSequence(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof MediatorSequence); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for sequence
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
		if (editorKey == EsbViewsRepository.ForEachTarget.Properties.sequenceType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType();
		}
		if (editorKey == EsbViewsRepository.ForEachTarget.Properties.sequence) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence();
		}
		if (editorKey == EsbViewsRepository.ForEachTarget.Properties.endpointType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType();
		}
		if (editorKey == EsbViewsRepository.ForEachTarget.Properties.soapAction) {
			return EsbPackage.eINSTANCE.getForEachTarget_SoapAction();
		}
		if (editorKey == EsbViewsRepository.ForEachTarget.Properties.toAddress) {
			return EsbPackage.eINSTANCE.getForEachTarget_ToAddress();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ForEachTarget forEachTarget = (ForEachTarget)semanticObject;
		if (EsbViewsRepository.ForEachTarget.Properties.sequenceType == event.getAffectedEditor()) {
			forEachTarget.setSequenceType((TargetSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ForEachTarget.Properties.sequence == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sequenceSettings.setToReference((MediatorSequence)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				MediatorSequence eObject = EsbFactory.eINSTANCE.createMediatorSequence();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				sequenceSettings.setToReference(eObject);
			}
		}
		if (EsbViewsRepository.ForEachTarget.Properties.endpointType == event.getAffectedEditor()) {
			forEachTarget.setEndpointType((TargetEndpointType)event.getNewValue());
		}
		if (EsbViewsRepository.ForEachTarget.Properties.soapAction == event.getAffectedEditor()) {
			forEachTarget.setSoapAction((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ForEachTarget.Properties.toAddress == event.getAffectedEditor()) {
			forEachTarget.setToAddress((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ForEachTargetPropertiesEditionPart basePart = (ForEachTargetPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ForEachTarget.Properties.sequenceType))
				basePart.setSequenceType((TargetSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.ForEachTarget.Properties.sequence))
				basePart.setSequence((EObject)msg.getNewValue());
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ForEachTarget.Properties.endpointType))
				basePart.setEndpointType((TargetEndpointType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getForEachTarget_SoapAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachTarget.Properties.soapAction)) {
				if (msg.getNewValue() != null) {
					basePart.setSoapAction(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSoapAction("");
				}
			}
			if (EsbPackage.eINSTANCE.getForEachTarget_ToAddress().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ForEachTarget.Properties.toAddress)) {
				if (msg.getNewValue() != null) {
					basePart.setToAddress(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setToAddress("");
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
			EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType(),
			EsbPackage.eINSTANCE.getForEachTarget_SoapAction(),
			EsbPackage.eINSTANCE.getForEachTarget_ToAddress()		);
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
				if (EsbViewsRepository.ForEachTarget.Properties.sequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachTarget.Properties.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachTarget.Properties.soapAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getForEachTarget_SoapAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getForEachTarget_SoapAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ForEachTarget.Properties.toAddress == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getForEachTarget_ToAddress().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getForEachTarget_ToAddress().getEAttributeType(), newValue);
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
