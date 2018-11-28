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

import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Protocol;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.APIResourcePropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


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
			if (isAccessible(EsbViewsRepository.APIResource.Properties.urlStyle)) {
				basePart.initUrlStyle(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_UrlStyle()), aPIResource.getUrlStyle());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.uriTemplate))
				basePart.setUriTemplate(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getUriTemplate()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Properties.urlMapping))
				basePart.setUrlMapping(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getUrlMapping()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowGet)) {
				basePart.setAllowGet(aPIResource.isAllowGet());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowPost)) {
				basePart.setAllowPost(aPIResource.isAllowPost());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowPut)) {
				basePart.setAllowPut(aPIResource.isAllowPut());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowDelete)) {
				basePart.setAllowDelete(aPIResource.isAllowDelete());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowOptions)) {
				basePart.setAllowOptions(aPIResource.isAllowOptions());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowHead)) {
				basePart.setAllowHead(aPIResource.isAllowHead());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.allowPatch)) {
				basePart.setAllowPatch(aPIResource.isAllowPatch());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceType)) {
				basePart.initInSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_InSequenceType()), aPIResource.getInSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceName))
				basePart.setInSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getInSequenceName()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Properties.outSequenceType)) {
				basePart.initOutSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_OutSequenceType()), aPIResource.getOutSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.outSequenceName))
				basePart.setOutSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getOutSequenceName()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Properties.faultSequenceType)) {
				basePart.initFaultSequenceType(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType()), aPIResource.getFaultSequenceType());
			}
			if (isAccessible(EsbViewsRepository.APIResource.Properties.faultSequenceName))
				basePart.setFaultSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, aPIResource.getFaultSequenceName()));
			
			if (isAccessible(EsbViewsRepository.APIResource.Properties.protocol)) {
				basePart.initProtocol(EEFUtils.choiceOfValues(aPIResource, EsbPackage.eINSTANCE.getAPIResource_Protocol()), aPIResource.getProtocol());
			}
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
		if (editorKey == EsbViewsRepository.APIResource.Properties.urlStyle) {
			return EsbPackage.eINSTANCE.getAPIResource_UrlStyle();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.uriTemplate) {
			return EsbPackage.eINSTANCE.getAPIResource_UriTemplate();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.urlMapping) {
			return EsbPackage.eINSTANCE.getAPIResource_UrlMapping();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowGet) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowGet();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowPost) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPost();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowPut) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPut();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowDelete) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowDelete();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowOptions) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowOptions();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowHead) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowHead();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.allowPatch) {
			return EsbPackage.eINSTANCE.getAPIResource_AllowPatch();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.inSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.inSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_InSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.outSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_OutSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.outSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_OutSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.faultSequenceType) {
			return EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.faultSequenceName) {
			return EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName();
		}
		if (editorKey == EsbViewsRepository.APIResource.Properties.protocol) {
			return EsbPackage.eINSTANCE.getAPIResource_Protocol();
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
		if (EsbViewsRepository.APIResource.Properties.urlStyle == event.getAffectedEditor()) {
			aPIResource.setUrlStyle((ApiResourceUrlStyle)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.uriTemplate == event.getAffectedEditor()) {
			aPIResource.setUriTemplate((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Properties.urlMapping == event.getAffectedEditor()) {
			aPIResource.setUrlMapping((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Properties.allowGet == event.getAffectedEditor()) {
			aPIResource.setAllowGet((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowPost == event.getAffectedEditor()) {
			aPIResource.setAllowPost((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowPut == event.getAffectedEditor()) {
			aPIResource.setAllowPut((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowDelete == event.getAffectedEditor()) {
			aPIResource.setAllowDelete((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowOptions == event.getAffectedEditor()) {
			aPIResource.setAllowOptions((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowHead == event.getAffectedEditor()) {
			aPIResource.setAllowHead((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.allowPatch == event.getAffectedEditor()) {
			aPIResource.setAllowPatch((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.inSequenceType == event.getAffectedEditor()) {
			aPIResource.setInSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.inSequenceName == event.getAffectedEditor()) {
			aPIResource.setInSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Properties.outSequenceType == event.getAffectedEditor()) {
			aPIResource.setOutSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.outSequenceName == event.getAffectedEditor()) {
			aPIResource.setOutSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Properties.faultSequenceType == event.getAffectedEditor()) {
			aPIResource.setFaultSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.APIResource.Properties.faultSequenceName == event.getAffectedEditor()) {
			aPIResource.setFaultSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.APIResource.Properties.protocol == event.getAffectedEditor()) {
			aPIResource.setProtocol((Protocol)event.getNewValue());
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
			if (EsbPackage.eINSTANCE.getAPIResource_UrlStyle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Properties.urlStyle))
				basePart.setUrlStyle((ApiResourceUrlStyle)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_UriTemplate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.uriTemplate)) {
				if (msg.getNewValue() != null) {
					basePart.setUriTemplate(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUriTemplate("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_UrlMapping().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.urlMapping)) {
				if (msg.getNewValue() != null) {
					basePart.setUrlMapping(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUrlMapping("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_AllowGet().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowGet))
				basePart.setAllowGet((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPost().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowPost))
				basePart.setAllowPost((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPut().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowPut))
				basePart.setAllowPut((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowDelete().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowDelete))
				basePart.setAllowDelete((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowOptions().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowOptions))
				basePart.setAllowOptions((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowHead().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowHead))
				basePart.setAllowHead((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_AllowPatch().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.allowPatch))
				basePart.setAllowPatch((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceType))
				basePart.setInSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_InSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.inSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setInSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Properties.outSequenceType))
				basePart.setOutSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.outSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setOutSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Properties.faultSequenceType))
				basePart.setFaultSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.APIResource.Properties.faultSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAPIResource_Protocol().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.APIResource.Properties.protocol))
				basePart.setProtocol((Protocol)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getAPIResource_AllowGet(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPost(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPut(),
			EsbPackage.eINSTANCE.getAPIResource_AllowDelete(),
			EsbPackage.eINSTANCE.getAPIResource_AllowOptions(),
			EsbPackage.eINSTANCE.getAPIResource_AllowHead(),
			EsbPackage.eINSTANCE.getAPIResource_AllowPatch(),
			EsbPackage.eINSTANCE.getAPIResource_InSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_InSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_OutSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_OutSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType(),
			EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName(),
			EsbPackage.eINSTANCE.getAPIResource_Protocol()		);
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
				if (EsbViewsRepository.APIResource.Properties.urlStyle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UrlStyle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UrlStyle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.uriTemplate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UriTemplate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UriTemplate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.urlMapping == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_UrlMapping().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_UrlMapping().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowGet == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowGet().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowGet().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowPost == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPost().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPost().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowPut == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPut().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPut().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowDelete == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowDelete().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowDelete().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowOptions == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowOptions().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowOptions().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowHead == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowHead().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowHead().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.allowPatch == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_AllowPatch().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_AllowPatch().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.inSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_InSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_InSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.inSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_InSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_InSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.outSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_OutSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.outSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_OutSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.faultSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.faultSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_FaultSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.APIResource.Properties.protocol == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAPIResource_Protocol().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAPIResource_Protocol().getEAttributeType(), newValue);
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
