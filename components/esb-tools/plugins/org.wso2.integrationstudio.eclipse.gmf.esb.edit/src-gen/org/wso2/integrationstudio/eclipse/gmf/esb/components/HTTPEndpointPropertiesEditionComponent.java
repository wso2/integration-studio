/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.HttpMethodType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.HTTPEndpointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class HTTPEndpointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for properties ReferencesTable
	 */
	protected ReferencesTableSettings propertiesSettings;
	
	/**
	 * Settings for templateParameters ReferencesTable
	 */
	protected ReferencesTableSettings templateParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public HTTPEndpointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject hTTPEndpoint, String editing_mode) {
		super(editingContext, hTTPEndpoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.HTTPEndpoint.class;
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
			
			final HTTPEndpoint hTTPEndpoint = (HTTPEndpoint)elt;
			final HTTPEndpointPropertiesEditionPart basePart = (HTTPEndpointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointDescription.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.commentsList))
				basePart.setCommentsList(hTTPEndpoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.anonymous)) {
				basePart.setAnonymous(hTTPEndpoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.inLine)) {
				basePart.setInLine(hTTPEndpoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.duplicate)) {
				basePart.setDuplicate(hTTPEndpoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointProperties.properties)) {
				propertiesSettings = new ReferencesTableSettings(hTTPEndpoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.reversed)) {
				basePart.setReversed(hTTPEndpoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(hTTPEndpoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.securityEnabled)) {
				basePart.setSecurityEnabled(hTTPEndpoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingEnabled)) {
				basePart.setAddressingEnabled(hTTPEndpoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(hTTPEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), hTTPEndpoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(hTTPEndpoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Timeout.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Timeout.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(hTTPEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), hTTPEndpoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryCount)) {
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, hTTPEndpoint.getRetryCount()));
			}
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, hTTPEndpoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendInitialDuration)) {
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, hTTPEndpoint.getSuspendInitialDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, hTTPEndpoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendProgressionFactor)) {
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, hTTPEndpoint.getSuspendProgressionFactor()));
			}
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(hTTPEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), hTTPEndpoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(hTTPEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), hTTPEndpoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(hTTPEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.statisticsEnabled)) {
				basePart.setStatisticsEnabled(hTTPEndpoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.traceEnabled)) {
				basePart.setTraceEnabled(hTTPEndpoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.uRITemplate))
				basePart.setURITemplate(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, hTTPEndpoint.getURITemplate()));
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.httpMethod)) {
				basePart.initHttpMethod(EEFUtils.choiceOfValues(hTTPEndpoint, EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod()), hTTPEndpoint.getHttpMethod());
			}
			// init filters
			
			// Start of user code for failover retry error codes
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
				basePart.setFailoverNonRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
						hTTPEndpoint.getFailoverNonRetryErrorCodes()));
			}
			// End of user code
			
			
			
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointProperties.properties)) {
				basePart.addFilterToProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EndPointProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for properties
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.templateParameters)) {
				basePart.addFilterToTemplateParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for templateParameters
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
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointDescription.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointProperties.properties) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Timeout.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Timeout.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Basic.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Basic.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Basic.uRITemplate) {
			return EsbPackage.eINSTANCE.getHTTPEndpoint_URITemplate();
		}
		if (editorKey == EsbViewsRepository.HTTPEndpoint.Basic.httpMethod) {
			return EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod();
		}
		// Start of user code for failover error codes
		if (editorKey == EsbViewsRepository.HTTPEndpoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes();
		}
		// End of user code
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		HTTPEndpoint hTTPEndpoint = (HTTPEndpoint)semanticObject;
		if (EsbViewsRepository.HTTPEndpoint.EndpointDescription.description == event.getAffectedEditor()) {
			hTTPEndpoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				hTTPEndpoint.getCommentsList().clear();
				hTTPEndpoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.endPointName == event.getAffectedEditor()) {
			hTTPEndpoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.anonymous == event.getAffectedEditor()) {
			hTTPEndpoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.inLine == event.getAffectedEditor()) {
			hTTPEndpoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.duplicate == event.getAffectedEditor()) {
			hTTPEndpoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointProperties.properties == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, propertiesSettings, editingContext.getAdapterFactory());
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
				propertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				propertiesSettings.move(event.getNewIndex(), (EndPointProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.reversed == event.getAffectedEditor()) {
			hTTPEndpoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
			hTTPEndpoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
			hTTPEndpoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
			hTTPEndpoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
			hTTPEndpoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
			hTTPEndpoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
			hTTPEndpoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.Timeout.timeOutAction == event.getAffectedEditor()) {
			hTTPEndpoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
			hTTPEndpoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
			hTTPEndpoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
			hTTPEndpoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
			hTTPEndpoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
			hTTPEndpoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
			hTTPEndpoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
			hTTPEndpoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.format == event.getAffectedEditor()) {
			hTTPEndpoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.optimize == event.getAffectedEditor()) {
			hTTPEndpoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Properties.templateParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, templateParametersSettings, editingContext.getAdapterFactory());
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
				templateParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				templateParametersSettings.move(event.getNewIndex(), (TemplateParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.HTTPEndpoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
			hTTPEndpoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Basic.traceEnabled == event.getAffectedEditor()) {
			hTTPEndpoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.HTTPEndpoint.Basic.uRITemplate == event.getAffectedEditor()) {
			hTTPEndpoint.setURITemplate((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HTTPEndpoint.Basic.httpMethod == event.getAffectedEditor()) {
			hTTPEndpoint.setHttpMethod((HttpMethodType)event.getNewValue());
		}
		// Start of user code for failover error codes
		if (EsbViewsRepository.HTTPEndpoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event
		        .getAffectedEditor()) {
			hTTPEndpoint.setFailoverNonRetryErrorCodes((java.lang.String) EEFConverterUtil
			        .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
		}
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			HTTPEndpointPropertiesEditionPart basePart = (HTTPEndpointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointDescription.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointProperties.properties))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Timeout.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HTTPEndpoint.Timeout.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.HTTPEndpoint.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getHTTPEndpoint_URITemplate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.uRITemplate)) {
				if (msg.getNewValue() != null) {
					basePart.setURITemplate(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setURITemplate("");
				}
			}
			if (EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HTTPEndpoint.Basic.httpMethod))
				basePart.setHttpMethod((HttpMethodType)msg.getNewValue());
			
			// Start of user code for failover error codes
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes().equals(msg.getFeature())
			        && msg.getNotifier().equals(semanticObject) && basePart != null
			        && isAccessible(EsbViewsRepository.HTTPEndpoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setFailoverNonRetryErrorCodes(
					        EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFailoverNonRetryErrorCodes("");
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
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getEndPoint_EndPointName(),
			EsbPackage.eINSTANCE.getEndPoint_Anonymous(),
			EsbPackage.eINSTANCE.getEndPoint_InLine(),
			EsbPackage.eINSTANCE.getEndPoint_Duplicate(),
			EsbPackage.eINSTANCE.getEndPoint_Properties(),
			EsbPackage.eINSTANCE.getEndPoint_Reversed(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_Format(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled(),
			EsbPackage.eINSTANCE.getHTTPEndpoint_URITemplate(),
			EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes());
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
				if (EsbViewsRepository.HTTPEndpoint.EndpointDescription.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Timeout.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Properties.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Basic.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Basic.uRITemplate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHTTPEndpoint_URITemplate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHTTPEndpoint_URITemplate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HTTPEndpoint.Basic.httpMethod == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHTTPEndpoint_HttpMethod().getEAttributeType(), newValue);
				}
				// Start of user code for failover error codes
				if (EsbViewsRepository.HTTPEndpoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes().getEAttributeType(), newValue);
				}
				// End of user code
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
