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

import org.wso2.integrationstudio.eclipse.gmf.esb.AbstractCommonTarget;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetSequenceType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.AbstractCommonTargetPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class AbstractCommonTargetPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for sequence EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sequenceSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public AbstractCommonTargetPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject abstractCommonTarget, String editing_mode) {
		super(editingContext, abstractCommonTarget, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.AbstractCommonTarget.class;
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
			
			final AbstractCommonTarget abstractCommonTarget = (AbstractCommonTarget)elt;
			final AbstractCommonTargetPropertiesEditionPart basePart = (AbstractCommonTargetPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.sequenceType)) {
				basePart.initSequenceType(EEFUtils.choiceOfValues(abstractCommonTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType()), abstractCommonTarget.getSequenceType());
			}
			if (isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.sequence)) {
				// init part
				sequenceSettings = new EObjectFlatComboSettings(abstractCommonTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence());
				basePart.initSequence(sequenceSettings);
				// set the button mode
				basePart.setSequenceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(abstractCommonTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType()), abstractCommonTarget.getEndpointType());
			}
			// init filters
			
			if (isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.sequence)) {
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
		if (editorKey == EsbViewsRepository.AbstractCommonTarget.Properties.sequenceType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType();
		}
		if (editorKey == EsbViewsRepository.AbstractCommonTarget.Properties.sequence) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence();
		}
		if (editorKey == EsbViewsRepository.AbstractCommonTarget.Properties.endpointType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		AbstractCommonTarget abstractCommonTarget = (AbstractCommonTarget)semanticObject;
		if (EsbViewsRepository.AbstractCommonTarget.Properties.sequenceType == event.getAffectedEditor()) {
			abstractCommonTarget.setSequenceType((TargetSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.AbstractCommonTarget.Properties.sequence == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.AbstractCommonTarget.Properties.endpointType == event.getAffectedEditor()) {
			abstractCommonTarget.setEndpointType((TargetEndpointType)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AbstractCommonTargetPropertiesEditionPart basePart = (AbstractCommonTargetPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.sequenceType))
				basePart.setSequenceType((TargetSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.sequence))
				basePart.setSequence((EObject)msg.getNewValue());
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AbstractCommonTarget.Properties.endpointType))
				basePart.setEndpointType((TargetEndpointType)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType()		);
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
				if (EsbViewsRepository.AbstractCommonTarget.Properties.sequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AbstractCommonTarget.Properties.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), newValue);
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
