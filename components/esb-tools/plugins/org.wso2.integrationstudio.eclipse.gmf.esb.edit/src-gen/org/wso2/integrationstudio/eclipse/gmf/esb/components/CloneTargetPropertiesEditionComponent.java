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

import org.wso2.integrationstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneTargetPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.CloneTargetPropertiesEditionPartImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.ValidateSchemaPropertiesEditionPartImpl;

// End of user code

/**
 * 
 * 
 */
public class CloneTargetPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for sequence EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sequenceSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CloneTargetPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cloneTarget, String editing_mode) {
		super(editingContext, cloneTarget, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CloneTarget.class;
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
			
			final CloneTarget cloneTarget = (CloneTarget)elt;
			final CloneTargetPropertiesEditionPart basePart = (CloneTargetPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.sequenceType)) {
				basePart.initSequenceType(EEFUtils.choiceOfValues(cloneTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType()), cloneTarget.getSequenceType());
			}
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.sequence)) {
				// init part
				sequenceSettings = new EObjectFlatComboSettings(cloneTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence());
				basePart.initSequence(sequenceSettings);
				// set the button mode
				basePart.setSequenceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(cloneTarget, EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType()), cloneTarget.getEndpointType());
			}
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.soapAction))
				basePart.setSoapAction(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneTarget.getSoapAction()));
			
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.toAddress))
				basePart.setToAddress(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneTarget.getToAddress()));
			
			// Start of user code for endpointRegistryKey command update
            if (isAccessible(EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey)) {
                basePart.setEndpointKey(cloneTarget.getEndpointKey());
            }
            // End of user code
			
			// Start of user code for sequenceRegistryKey command update
            if (isAccessible(EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey)) {
                basePart.setSequenceKey(cloneTarget.getSequenceKey());
            }
            // End of user code
			
			// init filters
			
			if (isAccessible(EsbViewsRepository.CloneTarget.Properties.sequence)) {
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
			
			
			
			// Start of user code for endpointRegistryKey filter update
            // End of user code
			
			// Start of user code for sequenceRegistryKey filter update
			((CloneTargetPropertiesEditionPartImpl) editingPart).validate();
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
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.sequenceType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.sequence) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.endpointType) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.soapAction) {
			return EsbPackage.eINSTANCE.getCloneTarget_SoapAction();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.toAddress) {
			return EsbPackage.eINSTANCE.getCloneTarget_ToAddress();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey();
		}
		if (editorKey == EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey) {
			return EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CloneTarget cloneTarget = (CloneTarget)semanticObject;
		if (EsbViewsRepository.CloneTarget.Properties.sequenceType == event.getAffectedEditor()) {
			cloneTarget.setSequenceType((TargetSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.CloneTarget.Properties.sequence == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.CloneTarget.Properties.endpointType == event.getAffectedEditor()) {
			cloneTarget.setEndpointType((TargetEndpointType)event.getNewValue());
		}
		if (EsbViewsRepository.CloneTarget.Properties.soapAction == event.getAffectedEditor()) {
			cloneTarget.setSoapAction((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloneTarget.Properties.toAddress == event.getAffectedEditor()) {
			cloneTarget.setToAddress((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey == event.getAffectedEditor()) {
			// Start of user code for updateEndpointRegistryKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                cloneTarget.setEndpointKey(rkp);
            } else {
                cloneTarget.setEndpointKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
            // End of user code
			
		}
		if (EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey == event.getAffectedEditor()) {
			// Start of user code for updateSequenceRegistryKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                cloneTarget.setSequenceKey(rkp);
            } else {
                cloneTarget.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			CloneTargetPropertiesEditionPart basePart = (CloneTargetPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CloneTarget.Properties.sequenceType))
				basePart.setSequenceType((TargetSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.CloneTarget.Properties.sequence))
				basePart.setSequence((EObject)msg.getNewValue());
			if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CloneTarget.Properties.endpointType))
				basePart.setEndpointType((TargetEndpointType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCloneTarget_SoapAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneTarget.Properties.soapAction)) {
				if (msg.getNewValue() != null) {
					basePart.setSoapAction(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSoapAction("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloneTarget_ToAddress().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneTarget.Properties.toAddress)) {
				if (msg.getNewValue() != null) {
					basePart.setToAddress(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setToAddress("");
				}
			}
					// Start of user code for endpointRegistryKey live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CloneTarget.Properties.sequenceRegistryKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
            // End of user code
			
					// Start of user code for sequenceRegistryKey live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CloneTarget.Properties.endpointRegistryKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setEndpointKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setEndpointKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_Sequence(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType(),
			EsbPackage.eINSTANCE.getCloneTarget_SoapAction(),
			EsbPackage.eINSTANCE.getCloneTarget_ToAddress(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey(),
			EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceKey()		);
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
				if (EsbViewsRepository.CloneTarget.Properties.sequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_SequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneTarget.Properties.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneTarget.Properties.soapAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneTarget_SoapAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneTarget_SoapAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneTarget.Properties.toAddress == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneTarget_ToAddress().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneTarget_ToAddress().getEAttributeType(), newValue);
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
