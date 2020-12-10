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

import org.wso2.integrationstudio.eclipse.gmf.esb.APIResource;
import org.wso2.integrationstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.Protocol;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class APIResourcePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for inSequenceInputConnectors ReferencesTable
	 */
	protected ReferencesTableSettings inSequenceInputConnectorsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public APIResourcePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject aPIResource, String editing_mode) {
		super(editingContext, aPIResource, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.APIResource.class;
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
			
			final APIResource aPIResource = (APIResource)elt;
			final APIResourcePropertiesEditionPart basePart = (APIResourcePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors)) {
				inSequenceInputConnectorsSettings = new ReferencesTableSettings(aPIResource, EsbPackage.eINSTANCE.getAPIResource_InSequenceInputConnectors());
				basePart.initInSequenceInputConnectors(inSequenceInputConnectorsSettings);
			}
			if (isAccessible(EsbViewsRepository.APIResource.Basic.urlStyle)) {
				basePart.initUrlStyle(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_UrlStyle()), aPIResource.getUrlStyle());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Basic.uriTemplate))
				basePart.setUriTemplate(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getUriTemplate()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Basic.urlMapping))
				basePart.setUrlMapping(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getUrlMapping()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Basic.protocol)) {
				basePart.initProtocol(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_Protocol()), aPIResource.getProtocol());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowGet)) {
				basePart.setAllowGet(aPIResource.isAllowGet());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowPost)) {
				basePart.setAllowPost(aPIResource.isAllowPost());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowPut)) {
				basePart.setAllowPut(aPIResource.isAllowPut());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowDelete)) {
				basePart.setAllowDelete(aPIResource.isAllowDelete());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowOptions)) {
				basePart.setAllowOptions(aPIResource.isAllowOptions());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowHead)) {
				basePart.setAllowHead(aPIResource.isAllowHead());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Methods.allowPatch)) {
				basePart.setAllowPatch(aPIResource.isAllowPatch());
			}
			if (isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceType)) {
				basePart.initInSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_InSequenceType()), aPIResource.getInSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceName))
				basePart.setInSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getInSequenceName()));
			
			// Start of user code  for inSequenceKey command update
			if (isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceKey)) {
                basePart.setInSequenceKey(aPIResource.getInSequenceKey());
            }
			// End of user code
			
			if (isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceType)) {
				basePart.initOutSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_OutSequenceType()), aPIResource.getOutSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceName))
				basePart.setOutSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getOutSequenceName()));
			
			// Start of user code  for outSequenceKey command update
			if (isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceKey)) {
                basePart.setOutSequenceKey(aPIResource.getOutSequenceKey());
            }
			// End of user code
			
			if (isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType)) {
				basePart.initFaultSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType()), aPIResource.getFaultSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceName))
				basePart.setFaultSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getFaultSequenceName()));
			
			// Start of user code  for faultSequenceKey command update
			if (isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey)) {
                basePart.setFaultSequenceKey(aPIResource.getFaultSequenceKey());
            }
			// End of user code
			
			// init filters
			if (isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors)) {
				basePart.addFilterToInSequenceInputConnectors(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof APIResourceInSequenceInputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for inSequenceInputConnectors
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Start of user code  for inSequenceKey filter update
			// End of user code
			
			
			
			// Start of user code  for outSequenceKey filter update
			// End of user code
			
			
			
			// Start of user code  for faultSequenceKey filter update
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
		if (editorKey == EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceInputConnectors();
		}
		if (editorKey == EsbViewsRepository.APIResource.Basic.urlStyle) {
			return EsbPackage.eINSTANCE.getAPIResource_UrlStyle();
		}
		if (editorKey == EsbViewsRepository.APIResource.Basic.uriTemplate) {
			return EsbPackage.eINSTANCE.getAPIResource_UriTemplate();
		}
		if (editorKey == EsbViewsRepository.APIResource.Basic.urlMapping) {
			return EsbPackage.eINSTANCE.getAPIResource_UrlMapping();
		}
		if (editorKey == EsbViewsRepository.APIResource.Basic.protocol) {
			return EsbPackage.eINSTANCE.getAPIResource_Protocol();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowGet) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowGet();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowPost) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPost();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowPut) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPut();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowDelete) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowDelete();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowOptions) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowOptions();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowHead) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowHead();
		}
		if (editorKey == EsbViewsRepository.APIResource.Methods.allowPatch) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPatch();
		}
		if (editorKey == EsbViewsRepository.APIResource.InSequence.inSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.InSequence.inSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.InSequence.inSequenceKey) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceKey();
		}
		if (editorKey == EsbViewsRepository.APIResource.OutSequence.outSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_OutSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.OutSequence.outSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_OutSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.OutSequence.outSequenceKey) {
			return EsbPackage.eINSTANCE.getAPIResource_OutSequenceKey();
		}
		if (editorKey == EsbViewsRepository.APIResource.FaultSequence.faultSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.FaultSequence.faultSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey) {
			return EsbPackage.eINSTANCE.getAPIResource_FaultSequenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		APIResource aPIResource = (APIResource)semanticObject;
		if (EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, inSequenceInputConnectorsSettings, editingContext.getAdapterFactory());
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
				inSequenceInputConnectorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				inSequenceInputConnectorsSettings.move(event.getNewIndex(), (APIResourceInSequenceInputConnector) event.getNewValue());
			}
		}
		if (EsbViewsRepository.APIResource.Basic.urlStyle == event.getAffectedEditor()) {
			aPIResource.setUrlStyle((ApiResourceUrlStyle)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Basic.uriTemplate == event.getAffectedEditor()) {
			aPIResource.setUriTemplate((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Basic.urlMapping == event.getAffectedEditor()) {
			aPIResource.setUrlMapping((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Basic.protocol == event.getAffectedEditor()) {
			aPIResource.setProtocol((Protocol)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowGet == event.getAffectedEditor()) {
			aPIResource.setAllowGet((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowPost == event.getAffectedEditor()) {
			aPIResource.setAllowPost((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowPut == event.getAffectedEditor()) {
			aPIResource.setAllowPut((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowDelete == event.getAffectedEditor()) {
			aPIResource.setAllowDelete((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowOptions == event.getAffectedEditor()) {
			aPIResource.setAllowOptions((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowHead == event.getAffectedEditor()) {
			aPIResource.setAllowHead((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Methods.allowPatch == event.getAffectedEditor()) {
			aPIResource.setAllowPatch((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.InSequence.inSequenceType == event.getAffectedEditor()) {
			aPIResource.setInSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.InSequence.inSequenceName == event.getAffectedEditor()) {
			aPIResource.setInSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.InSequence.inSequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateInSequenceKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                aPIResource.setInSequenceKey(rkp);
            } else {
                aPIResource.setInSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.APIResource.OutSequence.outSequenceType == event.getAffectedEditor()) {
			aPIResource.setOutSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.OutSequence.outSequenceName == event.getAffectedEditor()) {
			aPIResource.setOutSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.OutSequence.outSequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateOutSequenceKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                aPIResource.setOutSequenceKey(rkp);
            } else {
                aPIResource.setOutSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.APIResource.FaultSequence.faultSequenceType == event.getAffectedEditor()) {
			aPIResource.setFaultSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.FaultSequence.faultSequenceName == event.getAffectedEditor()) {
			aPIResource.setFaultSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateFaultSequenceKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                aPIResource.setFaultSequenceKey(rkp);
            } else {
                aPIResource.setFaultSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			APIResourcePropertiesEditionPart basePart = (APIResourcePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceInputConnectors().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceInputConnectors))
				basePart.updateInSequenceInputConnectors();
			if (EsbPackage.eINSTANCE.getAPIResource_UrlStyle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Basic.urlStyle))
				basePart.setUrlStyle((ApiResourceUrlStyle)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_UriTemplate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Basic.uriTemplate)) {
				if (msg.getNewValue() != null) {
					basePart.setUriTemplate(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUriTemplate("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_UrlMapping().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Basic.urlMapping)) {
				if (msg.getNewValue() != null) {
					basePart.setUrlMapping(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUrlMapping("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_Protocol().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Basic.protocol))
				basePart.setProtocol((Protocol)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowGet().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowGet))
				basePart.setAllowGet((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPost().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowPost))
				basePart.setAllowPost((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPut().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowPut))
				basePart.setAllowPut((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowDelete().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowDelete))
				basePart.setAllowDelete((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowOptions().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowOptions))
				basePart.setAllowOptions((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowHead().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowHead))
				basePart.setAllowHead((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPatch().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Methods.allowPatch))
				basePart.setAllowPatch((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceType))
				basePart.setInSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setInSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInSequenceName("");
				}
			}
					// Start of user code for inSequenceKey live update
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.APIResource.InSequence.inSequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setInSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setInSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
			if (EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceType))
				basePart.setOutSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setOutSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutSequenceName("");
				}
			}
					// Start of user code for outSequenceKey live update
			if (EsbPackage.eINSTANCE.getAPIResource_OutSequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.APIResource.OutSequence.outSequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setOutSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setOutSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
			if (EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceType))
				basePart.setFaultSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultSequenceName("");
				}
			}
					// Start of user code for faultSequenceKey live update
			if (EsbPackage.eINSTANCE.getAPIResource_FaultSequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.APIResource.FaultSequence.faultSequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setFaultSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setFaultSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getAPIResource_InSequenceInputConnectors(),
			EsbPackage.eINSTANCE.getAPIResource_UrlStyle(),
			EsbPackage.eINSTANCE.getAPIResource_UriTemplate(),
			EsbPackage.eINSTANCE.getAPIResource_UrlMapping(),
			EsbPackage.eINSTANCE.getAPIResource_Protocol(),
			EsbPackage.eINSTANCE.getAPIResource_AllowGet(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPost(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPut(),
			EsbPackage.eINSTANCE.getAPIResource_AllowDelete(),
			EsbPackage.eINSTANCE.getAPIResource_AllowOptions(),
			EsbPackage.eINSTANCE.getAPIResource_AllowHead(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPatch(),
			EsbPackage.eINSTANCE.getAPIResource_InSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_InSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_InSequenceKey(),
			EsbPackage.eINSTANCE.getAPIResource_OutSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_OutSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_OutSequenceKey(),
			EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_FaultSequenceKey()		);
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
				if (EsbViewsRepository.APIResource.Basic.urlStyle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UrlStyle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UrlStyle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Basic.uriTemplate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UriTemplate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UriTemplate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Basic.urlMapping == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UrlMapping().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UrlMapping().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Basic.protocol == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_Protocol().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_Protocol().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowGet == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowGet().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowGet().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowPost == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPost().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPost().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowPut == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPut().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPut().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowDelete == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowDelete().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowDelete().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowOptions == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowOptions().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowOptions().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowHead == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowHead().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowHead().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Methods.allowPatch == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPatch().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPatch().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.InSequence.inSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_InSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_InSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.InSequence.inSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_InSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_InSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.OutSequence.outSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.OutSequence.outSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.FaultSequence.faultSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.FaultSequence.faultSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().getEAttributeType(), newValue);
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
