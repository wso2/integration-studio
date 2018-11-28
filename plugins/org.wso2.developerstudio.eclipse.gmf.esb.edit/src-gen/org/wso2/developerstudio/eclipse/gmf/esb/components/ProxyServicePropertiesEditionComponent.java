/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ProxyServicePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for inSequenceInputConnectors ReferencesTable
	 */
	protected ReferencesTableSettings inSequenceInputConnectorsSettings;
	
	/**
	 * Settings for serviceParameters ReferencesTable
	 */
	protected ReferencesTableSettings serviceParametersSettings;
	
	/**
	 * Settings for servicePolicies ReferencesTable
	 */
	protected ReferencesTableSettings servicePoliciesSettings;
	
	/**
	 * Settings for wsdlResources ReferencesTable
	 */
	protected ReferencesTableSettings wsdlResourcesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ProxyServicePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject proxyService, String editing_mode) {
		super(editingContext, proxyService, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ProxyService.class;
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
			
			final ProxyService proxyService = (ProxyService)elt;
			final ProxyServicePropertiesEditionPart basePart = (ProxyServicePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getDescription()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.commentsList))
				basePart.setCommentsList(proxyService.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors)) {
				inSequenceInputConnectorsSettings = new ReferencesTableSettings(proxyService, EsbPackage.eINSTANCE.getProxyService_InSequenceInputConnectors());
				basePart.initInSequenceInputConnectors(inSequenceInputConnectorsSettings);
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getName()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.pinnedServers))
				basePart.setPinnedServers(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getPinnedServers()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.serviceGroup))
				basePart.setServiceGroup(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getServiceGroup()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.traceEnabled)) {
				basePart.setTraceEnabled(proxyService.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(proxyService.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.startOnLoad)) {
				basePart.setStartOnLoad(proxyService.isStartOnLoad());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.transports))
				basePart.setTransports(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getTransports()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(proxyService.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.securityEnabled)) {
				basePart.setSecurityEnabled(proxyService.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.serviceParameters)) {
				serviceParametersSettings = new ReferencesTableSettings(proxyService, EsbPackage.eINSTANCE.getProxyService_ServiceParameters());
				basePart.initServiceParameters(serviceParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.servicePolicies)) {
				servicePoliciesSettings = new ReferencesTableSettings(proxyService, EsbPackage.eINSTANCE.getProxyService_ServicePolicies());
				basePart.initServicePolicies(servicePoliciesSettings);
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceType)) {
				basePart.initInSequenceType(EEFUtils.choiceOfValues(proxyService, EsbPackage.eINSTANCE.getProxyService_InSequenceType()), proxyService.getInSequenceType());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceName))
				basePart.setInSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getInSequenceName()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.outSequenceType)) {
				basePart.initOutSequenceType(EEFUtils.choiceOfValues(proxyService, EsbPackage.eINSTANCE.getProxyService_OutSequenceType()), proxyService.getOutSequenceType());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.outSequenceName))
				basePart.setOutSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getOutSequenceName()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.faultSequenceType)) {
				basePart.initFaultSequenceType(EEFUtils.choiceOfValues(proxyService, EsbPackage.eINSTANCE.getProxyService_FaultSequenceType()), proxyService.getFaultSequenceType());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.faultSequenceName))
				basePart.setFaultSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getFaultSequenceName()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(proxyService, EsbPackage.eINSTANCE.getProxyService_EndpointType()), proxyService.getEndpointType());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.endpointName))
				basePart.setEndpointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getEndpointName()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.mainSequence)) {
				basePart.setMainSequence(proxyService.isMainSequence());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlType)) {
				basePart.initWsdlType(EEFUtils.choiceOfValues(proxyService, EsbPackage.eINSTANCE.getProxyService_WsdlType()), proxyService.getWsdlType());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.preservePolicy)) {
				basePart.setPreservePolicy(proxyService.isPreservePolicy());
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlXML))
				basePart.setWsdlXML(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getWsdlXML()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlURL))
				basePart.setWsdlURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, proxyService.getWsdlURL()));
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlResources)) {
				wsdlResourcesSettings = new ReferencesTableSettings(proxyService, EsbPackage.eINSTANCE.getProxyService_WsdlResources());
				basePart.initWsdlResources(wsdlResourcesSettings);
			}
			// init filters
			
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors)) {
				basePart.addFilterToInSequenceInputConnectors(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ProxyInSequenceInputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for inSequenceInputConnectors
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.serviceParameters)) {
				basePart.addFilterToServiceParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ProxyServiceParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for serviceParameters
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.servicePolicies)) {
				basePart.addFilterToServicePolicies(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ProxyServicePolicy); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for servicePolicies
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlResources)) {
				basePart.addFilterToWsdlResources(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ProxyWSDLResource); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for wsdlResources
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
		if (editorKey == EsbViewsRepository.ProxyService.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors) {
			return EsbPackage.eINSTANCE.getProxyService_InSequenceInputConnectors();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.name) {
			return EsbPackage.eINSTANCE.getProxyService_Name();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.pinnedServers) {
			return EsbPackage.eINSTANCE.getProxyService_PinnedServers();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.serviceGroup) {
			return EsbPackage.eINSTANCE.getProxyService_ServiceGroup();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getProxyService_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getProxyService_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.startOnLoad) {
			return EsbPackage.eINSTANCE.getProxyService_StartOnLoad();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.transports) {
			return EsbPackage.eINSTANCE.getProxyService_Transports();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getProxyService_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.securityEnabled) {
			return EsbPackage.eINSTANCE.getProxyService_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.serviceParameters) {
			return EsbPackage.eINSTANCE.getProxyService_ServiceParameters();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.servicePolicies) {
			return EsbPackage.eINSTANCE.getProxyService_ServicePolicies();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.inSequenceType) {
			return EsbPackage.eINSTANCE.getProxyService_InSequenceType();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.inSequenceName) {
			return EsbPackage.eINSTANCE.getProxyService_InSequenceName();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.outSequenceType) {
			return EsbPackage.eINSTANCE.getProxyService_OutSequenceType();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.outSequenceName) {
			return EsbPackage.eINSTANCE.getProxyService_OutSequenceName();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.faultSequenceType) {
			return EsbPackage.eINSTANCE.getProxyService_FaultSequenceType();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.faultSequenceName) {
			return EsbPackage.eINSTANCE.getProxyService_FaultSequenceName();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.endpointType) {
			return EsbPackage.eINSTANCE.getProxyService_EndpointType();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.endpointName) {
			return EsbPackage.eINSTANCE.getProxyService_EndpointName();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.mainSequence) {
			return EsbPackage.eINSTANCE.getProxyService_MainSequence();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.wsdlType) {
			return EsbPackage.eINSTANCE.getProxyService_WsdlType();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.preservePolicy) {
			return EsbPackage.eINSTANCE.getProxyService_PreservePolicy();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.wsdlXML) {
			return EsbPackage.eINSTANCE.getProxyService_WsdlXML();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.wsdlURL) {
			return EsbPackage.eINSTANCE.getProxyService_WsdlURL();
		}
		if (editorKey == EsbViewsRepository.ProxyService.Properties.wsdlResources) {
			return EsbPackage.eINSTANCE.getProxyService_WsdlResources();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ProxyService proxyService = (ProxyService)semanticObject;
		if (EsbViewsRepository.ProxyService.Properties.description == event.getAffectedEditor()) {
			proxyService.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				proxyService.getCommentsList().clear();
				proxyService.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors == event.getAffectedEditor()) {
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
				inSequenceInputConnectorsSettings.move(event.getNewIndex(), (ProxyInSequenceInputConnector) event.getNewValue());
			}
		}
		if (EsbViewsRepository.ProxyService.Properties.name == event.getAffectedEditor()) {
			proxyService.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.pinnedServers == event.getAffectedEditor()) {
			proxyService.setPinnedServers((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.serviceGroup == event.getAffectedEditor()) {
			proxyService.setServiceGroup((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.traceEnabled == event.getAffectedEditor()) {
			proxyService.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.statisticsEnabled == event.getAffectedEditor()) {
			proxyService.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.startOnLoad == event.getAffectedEditor()) {
			proxyService.setStartOnLoad((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.transports == event.getAffectedEditor()) {
			proxyService.setTransports((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
			proxyService.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.securityEnabled == event.getAffectedEditor()) {
			proxyService.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.serviceParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, serviceParametersSettings, editingContext.getAdapterFactory());
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
				serviceParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				serviceParametersSettings.move(event.getNewIndex(), (ProxyServiceParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.ProxyService.Properties.servicePolicies == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, servicePoliciesSettings, editingContext.getAdapterFactory());
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
				servicePoliciesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				servicePoliciesSettings.move(event.getNewIndex(), (ProxyServicePolicy) event.getNewValue());
			}
		}
		if (EsbViewsRepository.ProxyService.Properties.inSequenceType == event.getAffectedEditor()) {
			proxyService.setInSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.inSequenceName == event.getAffectedEditor()) {
			proxyService.setInSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.outSequenceType == event.getAffectedEditor()) {
			proxyService.setOutSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.outSequenceName == event.getAffectedEditor()) {
			proxyService.setOutSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.faultSequenceType == event.getAffectedEditor()) {
			proxyService.setFaultSequenceType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.faultSequenceName == event.getAffectedEditor()) {
			proxyService.setFaultSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.endpointType == event.getAffectedEditor()) {
			proxyService.setEndpointType((SequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.endpointName == event.getAffectedEditor()) {
			proxyService.setEndpointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.mainSequence == event.getAffectedEditor()) {
			proxyService.setMainSequence((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.wsdlType == event.getAffectedEditor()) {
			proxyService.setWsdlType((ProxyWsdlType)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.preservePolicy == event.getAffectedEditor()) {
			proxyService.setPreservePolicy((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ProxyService.Properties.wsdlXML == event.getAffectedEditor()) {
			proxyService.setWsdlXML((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.wsdlURL == event.getAffectedEditor()) {
			proxyService.setWsdlURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ProxyService.Properties.wsdlResources == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, wsdlResourcesSettings, editingContext.getAdapterFactory());
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
				wsdlResourcesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				wsdlResourcesSettings.move(event.getNewIndex(), (ProxyWSDLResource) event.getNewValue());
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
			ProxyServicePropertiesEditionPart basePart = (ProxyServicePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getProxyService_InSequenceInputConnectors().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceInputConnectors))
				basePart.updateInSequenceInputConnectors();
			if (EsbPackage.eINSTANCE.getProxyService_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_PinnedServers().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.pinnedServers)) {
				if (msg.getNewValue() != null) {
					basePart.setPinnedServers(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPinnedServers("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_ServiceGroup().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.serviceGroup)) {
				if (msg.getNewValue() != null) {
					basePart.setServiceGroup(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setServiceGroup("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_StartOnLoad().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.startOnLoad))
				basePart.setStartOnLoad((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_Transports().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.transports)) {
				if (msg.getNewValue() != null) {
					basePart.setTransports(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTransports("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_ServiceParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ProxyService.Properties.serviceParameters))
				basePart.updateServiceParameters();
			if (EsbPackage.eINSTANCE.getProxyService_ServicePolicies().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ProxyService.Properties.servicePolicies))
				basePart.updateServicePolicies();
			if (EsbPackage.eINSTANCE.getProxyService_InSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceType))
				basePart.setInSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_InSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.inSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setInSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_OutSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ProxyService.Properties.outSequenceType))
				basePart.setOutSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_OutSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.outSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setOutSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_FaultSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ProxyService.Properties.faultSequenceType))
				basePart.setFaultSequenceType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_FaultSequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.faultSequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ProxyService.Properties.endpointType))
				basePart.setEndpointType((SequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_EndpointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.endpointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndpointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndpointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_MainSequence().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.mainSequence))
				basePart.setMainSequence((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_WsdlType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlType))
				basePart.setWsdlType((ProxyWsdlType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_PreservePolicy().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.preservePolicy))
				basePart.setPreservePolicy((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getProxyService_WsdlXML().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlXML)) {
				if (msg.getNewValue() != null) {
					basePart.setWsdlXML(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsdlXML("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_WsdlURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlURL)) {
				if (msg.getNewValue() != null) {
					basePart.setWsdlURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsdlURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getProxyService_WsdlResources().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ProxyService.Properties.wsdlResources))
				basePart.updateWsdlResources();
			
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
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getProxyService_InSequenceInputConnectors(),
			EsbPackage.eINSTANCE.getProxyService_Name(),
			EsbPackage.eINSTANCE.getProxyService_PinnedServers(),
			EsbPackage.eINSTANCE.getProxyService_ServiceGroup(),
			EsbPackage.eINSTANCE.getProxyService_TraceEnabled(),
			EsbPackage.eINSTANCE.getProxyService_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getProxyService_StartOnLoad(),
			EsbPackage.eINSTANCE.getProxyService_Transports(),
			EsbPackage.eINSTANCE.getProxyService_ReliableMessagingEnabled(),
			EsbPackage.eINSTANCE.getProxyService_SecurityEnabled(),
			EsbPackage.eINSTANCE.getProxyService_ServiceParameters(),
			EsbPackage.eINSTANCE.getProxyService_ServicePolicies(),
			EsbPackage.eINSTANCE.getProxyService_InSequenceType(),
			EsbPackage.eINSTANCE.getProxyService_InSequenceName(),
			EsbPackage.eINSTANCE.getProxyService_OutSequenceType(),
			EsbPackage.eINSTANCE.getProxyService_OutSequenceName(),
			EsbPackage.eINSTANCE.getProxyService_FaultSequenceType(),
			EsbPackage.eINSTANCE.getProxyService_FaultSequenceName(),
			EsbPackage.eINSTANCE.getProxyService_EndpointType(),
			EsbPackage.eINSTANCE.getProxyService_EndpointName(),
			EsbPackage.eINSTANCE.getProxyService_MainSequence(),
			EsbPackage.eINSTANCE.getProxyService_WsdlType(),
			EsbPackage.eINSTANCE.getProxyService_PreservePolicy(),
			EsbPackage.eINSTANCE.getProxyService_WsdlXML(),
			EsbPackage.eINSTANCE.getProxyService_WsdlURL(),
			EsbPackage.eINSTANCE.getProxyService_WsdlResources()		);
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
				if (EsbViewsRepository.ProxyService.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.ProxyService.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.pinnedServers == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_PinnedServers().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_PinnedServers().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.serviceGroup == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_ServiceGroup().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_ServiceGroup().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.startOnLoad == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_StartOnLoad().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_StartOnLoad().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.transports == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_Transports().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_Transports().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.inSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_InSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_InSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.inSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_InSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_InSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.outSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_OutSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_OutSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.outSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_OutSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_OutSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.faultSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_FaultSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_FaultSequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.faultSequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_FaultSequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_FaultSequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_EndpointType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.endpointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_EndpointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_EndpointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.mainSequence == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_MainSequence().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_MainSequence().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.wsdlType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_WsdlType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_WsdlType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.preservePolicy == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_PreservePolicy().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_PreservePolicy().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.wsdlXML == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_WsdlXML().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_WsdlXML().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ProxyService.Properties.wsdlURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getProxyService_WsdlURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getProxyService_WsdlURL().getEAttributeType(), newValue);
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
