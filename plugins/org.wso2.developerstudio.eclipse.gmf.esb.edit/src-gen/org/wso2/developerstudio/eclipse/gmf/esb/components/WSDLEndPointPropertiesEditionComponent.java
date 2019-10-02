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

import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.WSDLEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class WSDLEndPointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	public WSDLEndPointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject wSDLEndPoint, String editing_mode) {
		super(editingContext, wSDLEndPoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.WSDLEndPoint.class;
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
			
			final WSDLEndPoint wSDLEndPoint = (WSDLEndPoint)elt;
			final WSDLEndPointPropertiesEditionPart basePart = (WSDLEndPointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.commentsList))
				basePart.setCommentsList(wSDLEndPoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.anonymous)) {
				basePart.setAnonymous(wSDLEndPoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.inLine)) {
				basePart.setInLine(wSDLEndPoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.duplicate)) {
				basePart.setDuplicate(wSDLEndPoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.properties)) {
				propertiesSettings = new ReferencesTableSettings(wSDLEndPoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.reversed)) {
				basePart.setReversed(wSDLEndPoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(wSDLEndPoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled)) {
				basePart.setSecurityEnabled(wSDLEndPoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled)) {
				basePart.setAddressingEnabled(wSDLEndPoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(wSDLEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), wSDLEndPoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(wSDLEndPoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(wSDLEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), wSDLEndPoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount)) {
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, wSDLEndPoint.getRetryCount()));
			}
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, wSDLEndPoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration)) {
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, wSDLEndPoint.getSuspendInitialDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, wSDLEndPoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor)) {
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, wSDLEndPoint.getSuspendProgressionFactor()));
			}
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(wSDLEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), wSDLEndPoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(wSDLEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), wSDLEndPoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(wSDLEndPoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled)) {
				basePart.setStatisticsEnabled(wSDLEndPoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled)) {
				basePart.setTraceEnabled(wSDLEndPoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri))
				basePart.setWsdlUri(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getWsdlUri()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.service))
				basePart.setService(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getService()));
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.port))
				basePart.setPort(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, wSDLEndPoint.getPort()));
			
			// Start of user code  for reliableMessagingPolicy command update
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy)) {
                basePart.setReliableMessagingPolicy(wSDLEndPoint.getReliableMessagingPolicy());
            }
			// End of user code
			
			// Start of user code  for securityPolicy command update
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy)) {
                basePart.setSecurityPolicy(wSDLEndPoint.getSecurityPolicy());
            }
			// End of user code
			
			// Start of user code  for inboundPolicy command update
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy)) {
                basePart.setInboundPolicy(wSDLEndPoint.getInboundPolicy());
            }
			// End of user code
			
			// Start of user code  for outboundPolicy command update
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy)) {
                basePart.setOutboundPolicy(wSDLEndPoint.getOutboundPolicy());
            }
			// End of user code
			
			// init filters
			
			// Start of user code for failover retry error codes
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
				basePart.setFailoverNonRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
						wSDLEndPoint.getFailoverNonRetryErrorCodes()));
			}
			// End of user code
			
			
			
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.properties)) {
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters)) {
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
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Basic.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.properties) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Basic.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri) {
			return EsbPackage.eINSTANCE.getWSDLEndPoint_WsdlUri();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.service) {
			return EsbPackage.eINSTANCE.getWSDLEndPoint_Service();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Misc.port) {
			return EsbPackage.eINSTANCE.getWSDLEndPoint_Port();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy();
		}
		if (editorKey == EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy();
		}
		// Start of user code for failover error codes
		if (editorKey == EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes) {
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
		WSDLEndPoint wSDLEndPoint = (WSDLEndPoint)semanticObject;
		if (EsbViewsRepository.WSDLEndPoint.Misc.description == event.getAffectedEditor()) {
			wSDLEndPoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				wSDLEndPoint.getCommentsList().clear();
				wSDLEndPoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.WSDLEndPoint.Properties.endPointName == event.getAffectedEditor()) {
			wSDLEndPoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Properties.anonymous == event.getAffectedEditor()) {
			wSDLEndPoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Basic.inLine == event.getAffectedEditor()) {
			wSDLEndPoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Properties.duplicate == event.getAffectedEditor()) {
			wSDLEndPoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Misc.properties == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.WSDLEndPoint.Properties.reversed == event.getAffectedEditor()) {
			wSDLEndPoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled == event.getAffectedEditor()) {
			wSDLEndPoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled == event.getAffectedEditor()) {
			wSDLEndPoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled == event.getAffectedEditor()) {
			wSDLEndPoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion == event.getAffectedEditor()) {
			wSDLEndPoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener == event.getAffectedEditor()) {
			wSDLEndPoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
			wSDLEndPoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction == event.getAffectedEditor()) {
			wSDLEndPoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
			wSDLEndPoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
			wSDLEndPoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
			wSDLEndPoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
			wSDLEndPoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
			wSDLEndPoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
			wSDLEndPoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
			wSDLEndPoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Basic.format == event.getAffectedEditor()) {
			wSDLEndPoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Misc.optimize == event.getAffectedEditor()) {
			wSDLEndPoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Properties.templateParameters == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
			wSDLEndPoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled == event.getAffectedEditor()) {
			wSDLEndPoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri == event.getAffectedEditor()) {
			wSDLEndPoint.setWsdlUri((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Misc.service == event.getAffectedEditor()) {
			wSDLEndPoint.setService((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Misc.port == event.getAffectedEditor()) {
			wSDLEndPoint.setPort((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy == event.getAffectedEditor()) {
			// Start of user code for updateReliableMessagingPolicy method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                wSDLEndPoint.setReliableMessagingPolicy(rkp);
            } else {
                wSDLEndPoint.setReliableMessagingPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy == event.getAffectedEditor()) {
			// Start of user code for updateSecurityPolicy method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                wSDLEndPoint.setSecurityPolicy(rkp);
            } else {
                wSDLEndPoint.setSecurityPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy == event.getAffectedEditor()) {
			// Start of user code for updateInboundPolicy method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                wSDLEndPoint.setInboundPolicy(rkp);
            } else {
                wSDLEndPoint.setInboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy == event.getAffectedEditor()) {
			// Start of user code for updateOutboundPolicy method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                wSDLEndPoint.setOutboundPolicy(rkp);
            } else {
                wSDLEndPoint.setOutboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		// Start of user code for failover error codes
		if (EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event
		        .getAffectedEditor()) {
			wSDLEndPoint.setFailoverNonRetryErrorCodes((java.lang.String) EEFConverterUtil
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
			WSDLEndPointPropertiesEditionPart basePart = (WSDLEndPointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.properties))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.WSDLEndPoint.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getWSDLEndPoint_WsdlUri().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri)) {
				if (msg.getNewValue() != null) {
					basePart.setWsdlUri(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setWsdlUri("");
				}
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPoint_Service().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.service)) {
				if (msg.getNewValue() != null) {
					basePart.setService(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setService("");
				}
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPoint_Port().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.WSDLEndPoint.Misc.port)) {
				if (msg.getNewValue() != null) {
					basePart.setPort(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPort("");
				}
			}
					// Start of user code for reliableMessagingPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingPolicy)) {
                if (msg.getNewValue() != null) {
                    basePart.setReliableMessagingPolicy((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setReliableMessagingPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for securityPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.securityPolicy)) {
                if (msg.getNewValue() != null) {
                    basePart.setSecurityPolicy((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setSecurityPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for inboundPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.inboundPolicy)) {
                if (msg.getNewValue() != null) {
                    basePart.setInboundPolicy((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setInboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for outboundPolicy live update
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(EsbViewsRepository.WSDLEndPoint.Qos.outboundPolicy)) {
                if (msg.getNewValue() != null) {
                    basePart.setOutboundPolicy((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setOutboundPolicy(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
			// Start of user code for failover error codes
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_FailoverNonRetryErrorCodes().equals(msg.getFeature())
			        && msg.getNotifier().equals(semanticObject) && basePart != null
			        && isAccessible(EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes)) {
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
			EsbPackage.eINSTANCE.getWSDLEndPoint_WsdlUri(),
			EsbPackage.eINSTANCE.getWSDLEndPoint_Service(),
			EsbPackage.eINSTANCE.getWSDLEndPoint_Port(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_InboundPolicy(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_OutboundPolicy(),
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
				if (EsbViewsRepository.WSDLEndPoint.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.WSDLEndPoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Basic.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Qos.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Qos.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Qos.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Qos.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Qos.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Timeout.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Timeout.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointTimeoutState.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.EndpointSuspendState.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Basic.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Misc.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Basic.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Basic.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Misc.wsdlUri == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getWSDLEndPoint_WsdlUri().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getWSDLEndPoint_WsdlUri().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Misc.service == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getWSDLEndPoint_Service().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getWSDLEndPoint_Service().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.WSDLEndPoint.Misc.port == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getWSDLEndPoint_Port().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getWSDLEndPoint_Port().getEAttributeType(), newValue);
				}
				// Start of user code for failover error codes
				if (EsbViewsRepository.WSDLEndPoint.FailoverErrorCodes.failoverNonRetryErrorCodes == event.getAffectedEditor()) {
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
