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

import org.wso2.integrationstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointFailoverRetryType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.AddressEndPointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class AddressEndPointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	public AddressEndPointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject addressEndPoint, String editing_mode) {
		super(editingContext, addressEndPoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.AddressEndPoint.class;
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
			
			final AddressEndPoint addressEndPoint = (AddressEndPoint)elt;
			final AddressEndPointPropertiesEditionPart basePart = (AddressEndPointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.commentsList))
				basePart.setCommentsList(addressEndPoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.anonymous)) {
				basePart.setAnonymous(addressEndPoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.inLine)) {
				basePart.setInLine(addressEndPoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.duplicate)) {
				basePart.setDuplicate(addressEndPoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Misc.properties)) {
				propertiesSettings = new ReferencesTableSettings(addressEndPoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.reversed)) {
				basePart.setReversed(addressEndPoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(addressEndPoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled)) {
				basePart.setSecurityEnabled(addressEndPoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled)) {
				basePart.setAddressingEnabled(addressEndPoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), addressEndPoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(addressEndPoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), addressEndPoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount)) {
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, addressEndPoint.getRetryCount()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, addressEndPoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration)) {
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, addressEndPoint.getSuspendInitialDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, addressEndPoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor)) {
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, addressEndPoint.getSuspendProgressionFactor()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), addressEndPoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Misc.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), addressEndPoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled)) {
				basePart.setStatisticsEnabled(addressEndPoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled)) {
				basePart.setTraceEnabled(addressEndPoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.uRI))
				basePart.setURI(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getURI()));
			
			// Start of user code  for reliableMessagingPolicy command update
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy)) {
				basePart.setReliableMessagingPolicy(addressEndPoint.getReliableMessagingPolicy());
			}
			// End of user code
			
			// Start of user code  for securityPolicy command update
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.securityPolicy)) {
				basePart.setSecurityPolicy(addressEndPoint.getSecurityPolicy());
			}
			// End of user code
			
			// Start of user code  for inboundPolicy command update
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy)) {
				basePart.setInboundPolicy(addressEndPoint.getInboundPolicy());
			}
			// End of user code
			
			// Start of user code  for outboundPolicy command update
			if (isAccessible(EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy)) {
				basePart.setOutboundPolicy(addressEndPoint.getOutboundPolicy());
			}
			// End of user code
			
			// Start of user code  for failover retry error codes
			if (isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType)) {
				basePart.initFailoverType(EEFUtils.choiceOfValues(addressEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType()), addressEndPoint.getFailoverRetryType());
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes)) {
				basePart.setFailoverRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getFailoverRetryErrorCodes()));
			}
			if (isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
				basePart.setFailoverNonRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressEndPoint.getFailoverNonRetryErrorCodes()));
			}
			// End of user code
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Misc.properties)) {
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.AddressEndPoint.Basic.templateParameters)) {
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
			
			
			
			// Start of user code  for reliableMessagingPolicy filter update
			// End of user code
			
			// Start of user code  for securityPolicy filter update
			// End of user code
			
			// Start of user code  for inboundPolicy filter update
			// End of user code
			
			// Start of user code  for outboundPolicy filter update
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
		if (editorKey == EsbViewsRepository.AddressEndPoint.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Misc.properties) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Misc.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.Basic.uRI) {
			return EsbPackage.eINSTANCE.getAddressEndPoint_URI();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.securityPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy();
		}
		
		// Start of user code for failover error codes
		if (editorKey == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
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
		AddressEndPoint addressEndPoint = (AddressEndPoint)semanticObject;
		if (EsbViewsRepository.AddressEndPoint.Misc.description == event.getAffectedEditor()) {
			addressEndPoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				addressEndPoint.getCommentsList().clear();
				addressEndPoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.endPointName == event.getAffectedEditor()) {
			addressEndPoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.anonymous == event.getAffectedEditor()) {
			addressEndPoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.inLine == event.getAffectedEditor()) {
			addressEndPoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.duplicate == event.getAffectedEditor()) {
			addressEndPoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Misc.properties == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.AddressEndPoint.Basic.reversed == event.getAffectedEditor()) {
			addressEndPoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled == event.getAffectedEditor()) {
			addressEndPoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.securityEnabled == event.getAffectedEditor()) {
			addressEndPoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled == event.getAffectedEditor()) {
			addressEndPoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.addressingVersion == event.getAffectedEditor()) {
			addressEndPoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener == event.getAffectedEditor()) {
			addressEndPoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
			addressEndPoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction == event.getAffectedEditor()) {
			addressEndPoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
			addressEndPoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
			addressEndPoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
			addressEndPoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
			addressEndPoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
			addressEndPoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
			addressEndPoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
			addressEndPoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.format == event.getAffectedEditor()) {
			addressEndPoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Misc.optimize == event.getAffectedEditor()) {
			addressEndPoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.templateParameters == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
			addressEndPoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.traceEnabled == event.getAffectedEditor()) {
			addressEndPoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.Basic.uRI == event.getAffectedEditor()) {
			addressEndPoint.setURI((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy == event.getAffectedEditor()) {
			// Start of user code for updateReliableMessagingPolicy method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				addressEndPoint.setReliableMessagingPolicy(rkp);
			} else {
				addressEndPoint.setReliableMessagingPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.securityPolicy == event.getAffectedEditor()) {
			// Start of user code for updateSecurityPolicy method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				addressEndPoint.setSecurityPolicy(rkp);
			} else {
				addressEndPoint.setSecurityPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy == event.getAffectedEditor()) {
			// Start of user code for updateInboundPolicy method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				addressEndPoint.setInboundPolicy(rkp);
			} else {
				addressEndPoint.setInboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy == event.getAffectedEditor()) {
			// Start of user code for updateOutboundPolicy method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				addressEndPoint.setOutboundPolicy(rkp);
			} else {
				addressEndPoint.setOutboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		
		// Start of user code for failover error codes
		if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType == event.getAffectedEditor()) {
			addressEndPoint.setFailoverRetryType((EndPointFailoverRetryType)event.getNewValue());
		}
		if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes == event.getAffectedEditor()) {
			addressEndPoint.setFailoverRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event.getAffectedEditor()) {
			addressEndPoint.setFailoverNonRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
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
			AddressEndPointPropertiesEditionPart basePart = (AddressEndPointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.AddressEndPoint.Misc.properties))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.QoS.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressEndPoint.Misc.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAddressEndPoint_URI().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.Basic.uRI)) {
				if (msg.getNewValue() != null) {
					basePart.setURI(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setURI("");
				}
			}
					// Start of user code for reliableMessagingPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingPolicy)) {
				if (msg.getNewValue() != null) {
					basePart.setReliableMessagingPolicy((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setReliableMessagingPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for securityPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.AddressEndPoint.QoS.securityPolicy)) {
				if (msg.getNewValue() != null) {
					basePart.setSecurityPolicy((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setSecurityPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for inboundPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.AddressEndPoint.QoS.inboundPolicy)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundPolicy((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setInboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for outboundPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.AddressEndPoint.QoS.outboundPolicy)) {
				if (msg.getNewValue() != null) {
					basePart.setOutboundPolicy((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setOutboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
			// Start of user code for failover error codes
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType)) {
				basePart.setFailoverType((EndPointFailoverRetryType) msg.getNewValue());
			}
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setFailoverRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFailoverRetryErrorCodes("");
				}
			}
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setFailoverNonRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
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
			EsbPackage.eINSTANCE.getAddressEndPoint_URI(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryErrorCodes(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes() );
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
				if (EsbViewsRepository.AddressEndPoint.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.QoS.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.QoS.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.QoS.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.QoS.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.QoS.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Timeout.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Misc.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressEndPoint.Basic.uRI == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAddressEndPoint_URI().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAddressEndPoint_URI().getEAttributeType(), newValue);
				}
				// Start of user code for failover error codes
				if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryType().getEAttributeType(), newValue);
				}
				
				if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverRetryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverRetryErrorCodes().getEAttributeType(), newValue);
				}
				
				if (EsbViewsRepository.AddressEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event.getAffectedEditor()) {
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
