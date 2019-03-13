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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class CalloutMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public CalloutMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject calloutMediator, String editing_mode) {
		super(editingContext, calloutMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CalloutMediator.class;
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
			
			final CalloutMediator calloutMediator = (CalloutMediator)elt;
			final CalloutMediatorPropertiesEditionPart basePart = (CalloutMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CalloutMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Misc.commentsList))
				basePart.setCommentsList(calloutMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Misc.reverse)) {
				basePart.setReverse(calloutMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.serviceURL))
				basePart.setServiceURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getServiceURL()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.soapAction))
				basePart.setSoapAction(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getSoapAction()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml))
				basePart.setPathToAxis2xml(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getPathToAxis2xml()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository))
				basePart.setPathToAxis2Repository(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getPathToAxis2Repository()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadType)) {
				basePart.initPayloadType(EEFUtils.choiceOfValues(calloutMediator, EsbPackage.eINSTANCE.getCalloutMediator_PayloadType()), calloutMediator.getPayloadType());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Target.resultType)) {
				basePart.initResultType(EEFUtils.choiceOfValues(calloutMediator, EsbPackage.eINSTANCE.getCalloutMediator_ResultType()), calloutMediator.getResultType());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Target.resultContextProperty))
				basePart.setResultContextProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getResultContextProperty()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.Misc.passHeaders)) {
				basePart.setPassHeaders(calloutMediator.isPassHeaders());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(calloutMediator, EsbPackage.eINSTANCE.getCalloutMediator_EndpointType()), calloutMediator.getEndpointType());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadProperty))
				basePart.setPayloadProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, calloutMediator.getPayloadProperty()));
			
			if (isAccessible(EsbViewsRepository.CalloutMediator.WS.securityType)) {
				basePart.initSecurityType(EEFUtils.choiceOfValues(calloutMediator, EsbPackage.eINSTANCE.getCalloutMediator_SecurityType()), calloutMediator.getSecurityType());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.WS.policies)) {
				basePart.initPolicies(EEFUtils.choiceOfValues(calloutMediator, EsbPackage.eINSTANCE.getCalloutMediator_Policies()), calloutMediator.getPolicies());
			}
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions)) {
				basePart.setInitAxis2ClientOptions(calloutMediator.isInitAxis2ClientOptions());
			}
			// Start of user code  for addressEndpoint command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.Service.addressEndpoint)) {
				basePart.setAddressEndpoint(calloutMediator.getAddressEndpoint());
			}
			// End of user code
			
			// Start of user code  for payloadMessageXpath command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath)) {
				basePart.setPayloadMessageXpath(calloutMediator.getPayloadMessageXpath());
			}
			// End of user code
			
			// Start of user code  for resultMessageXpath command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.Target.resultMessageXpath)) {
				basePart.setResultMessageXpath(calloutMediator.getResultMessageXpath());
			}
			// End of user code
			
			// Start of user code  for policyKey command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.WS.policyKey)) {
				basePart.setPolicyKey(calloutMediator.getPolicyKey());
			}
			// End of user code
			
			// Start of user code  for outboundPolicyKey command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey)) {
				basePart.setOutboundPolicyKey(calloutMediator.getOutboundPolicyKey());
			}
			// End of user code
			
			// Start of user code  for inboundPolicyKey command update
			if (isAccessible(EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey)) {
				basePart.setInboundPolicyKey(calloutMediator.getInboundPolicyKey());
			}
			// End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Start of user code  for addressEndpoint filter update
			// End of user code
			
			// Start of user code  for payloadMessageXpath filter update
			// End of user code
			
			// Start of user code  for resultMessageXpath filter update
			// End of user code
			
			// Start of user code  for policyKey filter update
			// End of user code
			
			// Start of user code  for outboundPolicyKey filter update
			// End of user code
			
			// Start of user code  for inboundPolicyKey filter update
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
		if (editorKey == EsbViewsRepository.CalloutMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Misc.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Misc.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.serviceURL) {
			return EsbPackage.eINSTANCE.getCalloutMediator_ServiceURL();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.soapAction) {
			return EsbPackage.eINSTANCE.getCalloutMediator_SoapAction();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2xml();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2Repository();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Source.payloadType) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PayloadType();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Target.resultType) {
			return EsbPackage.eINSTANCE.getCalloutMediator_ResultType();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Target.resultContextProperty) {
			return EsbPackage.eINSTANCE.getCalloutMediator_ResultContextProperty();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Misc.passHeaders) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PassHeaders();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.endpointType) {
			return EsbPackage.eINSTANCE.getCalloutMediator_EndpointType();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Source.payloadProperty) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PayloadProperty();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.WS.securityType) {
			return EsbPackage.eINSTANCE.getCalloutMediator_SecurityType();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.WS.policies) {
			return EsbPackage.eINSTANCE.getCalloutMediator_Policies();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions) {
			return EsbPackage.eINSTANCE.getCalloutMediator_InitAxis2ClientOptions();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Service.addressEndpoint) {
			return EsbPackage.eINSTANCE.getCalloutMediator_AddressEndpoint();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PayloadMessageXpath();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.Target.resultMessageXpath) {
			return EsbPackage.eINSTANCE.getCalloutMediator_ResultMessageXpath();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.WS.policyKey) {
			return EsbPackage.eINSTANCE.getCalloutMediator_PolicyKey();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey) {
			return EsbPackage.eINSTANCE.getCalloutMediator_OutboundPolicyKey();
		}
		if (editorKey == EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey) {
			return EsbPackage.eINSTANCE.getCalloutMediator_InboundPolicyKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CalloutMediator calloutMediator = (CalloutMediator)semanticObject;
		if (EsbViewsRepository.CalloutMediator.Misc.description == event.getAffectedEditor()) {
			calloutMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Misc.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				calloutMediator.getCommentsList().clear();
				calloutMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.CalloutMediator.Misc.reverse == event.getAffectedEditor()) {
			calloutMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Service.serviceURL == event.getAffectedEditor()) {
			calloutMediator.setServiceURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Service.soapAction == event.getAffectedEditor()) {
			calloutMediator.setSoapAction((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml == event.getAffectedEditor()) {
			calloutMediator.setPathToAxis2xml((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository == event.getAffectedEditor()) {
			calloutMediator.setPathToAxis2Repository((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Source.payloadType == event.getAffectedEditor()) {
			calloutMediator.setPayloadType((CalloutPayloadType)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Target.resultType == event.getAffectedEditor()) {
			calloutMediator.setResultType((CalloutResultType)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Target.resultContextProperty == event.getAffectedEditor()) {
			calloutMediator.setResultContextProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.Misc.passHeaders == event.getAffectedEditor()) {
			calloutMediator.setPassHeaders((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Service.endpointType == event.getAffectedEditor()) {
			calloutMediator.setEndpointType((CalloutEndpointType)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Source.payloadProperty == event.getAffectedEditor()) {
			calloutMediator.setPayloadProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CalloutMediator.WS.securityType == event.getAffectedEditor()) {
			calloutMediator.setSecurityType((CalloutSecurityType)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.WS.policies == event.getAffectedEditor()) {
			calloutMediator.setPolicies((CalloutSecurityPolicies)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions == event.getAffectedEditor()) {
			calloutMediator.setInitAxis2ClientOptions((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CalloutMediator.Service.addressEndpoint == event.getAffectedEditor()) {
			// Start of user code for updateAddressEndpoint method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				calloutMediator.setAddressEndpoint(rkp);
			} else {
				calloutMediator.setAddressEndpoint(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath == event.getAffectedEditor()) {
			// Start of user code for updatePayloadMessageXpath method body
			if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                calloutMediator.setPayloadMessageXpath(nsp);
            } else {
            	calloutMediator.setPayloadMessageXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.CalloutMediator.Target.resultMessageXpath == event.getAffectedEditor()) {
			// Start of user code for updateResultMessageXpath method body
			if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                calloutMediator.setResultMessageXpath(nsp);
            } else {
            	calloutMediator.setResultMessageXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.CalloutMediator.WS.policyKey == event.getAffectedEditor()) {
			// Start of user code for updatePolicyKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				calloutMediator.setPolicyKey(rkp);
			} else {
				calloutMediator.setPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey == event.getAffectedEditor()) {
			// Start of user code for updateOutboundPolicyKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				calloutMediator.setOutboundPolicyKey(rkp);
			} else {
				calloutMediator.setOutboundPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey == event.getAffectedEditor()) {
			// Start of user code for updateInboundPolicyKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				calloutMediator.setInboundPolicyKey(rkp);
			} else {
				calloutMediator.setInboundPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			CalloutMediatorPropertiesEditionPart basePart = (CalloutMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Misc.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Misc.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_ServiceURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Service.serviceURL)) {
				if (msg.getNewValue() != null) {
					basePart.setServiceURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setServiceURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_SoapAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Service.soapAction)) {
				if (msg.getNewValue() != null) {
					basePart.setSoapAction(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSoapAction("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2xml().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml)) {
				if (msg.getNewValue() != null) {
					basePart.setPathToAxis2xml(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPathToAxis2xml("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2Repository().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository)) {
				if (msg.getNewValue() != null) {
					basePart.setPathToAxis2Repository(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPathToAxis2Repository("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_PayloadType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadType))
				basePart.setPayloadType((CalloutPayloadType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_ResultType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CalloutMediator.Target.resultType))
				basePart.setResultType((CalloutResultType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_ResultContextProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Target.resultContextProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setResultContextProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setResultContextProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_PassHeaders().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Misc.passHeaders))
				basePart.setPassHeaders((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CalloutMediator.Service.endpointType))
				basePart.setEndpointType((CalloutEndpointType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_PayloadProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setPayloadProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPayloadProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getCalloutMediator_SecurityType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CalloutMediator.WS.securityType))
				basePart.setSecurityType((CalloutSecurityType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_Policies().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CalloutMediator.WS.policies))
				basePart.setPolicies((CalloutSecurityPolicies)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCalloutMediator_InitAxis2ClientOptions().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions))
				basePart.setInitAxis2ClientOptions((Boolean)msg.getNewValue());
			
					// Start of user code for addressEndpoint live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_AddressEndpoint().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.Service.addressEndpoint)) {
				if (msg.getNewValue() != null) {
					basePart.setAddressEndpoint((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setAddressEndpoint(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for payloadMessageXpath live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_PayloadMessageXpath().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.Source.payloadMessageXpath)) {
				if (msg.getNewValue() != null) {
					basePart.setPayloadMessageXpath((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setPayloadMessageXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
				}
			}
					// End of user code
			
					// Start of user code for resultMessageXpath live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_ResultMessageXpath().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.Target.resultMessageXpath)) {
				if (msg.getNewValue() != null) {
					basePart.setResultMessageXpath((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setResultMessageXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
				}
			}
					// End of user code
			
					// Start of user code for policyKey live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_PolicyKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.WS.policyKey)) {
				if (msg.getNewValue() != null) {
					basePart.setPolicyKey((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for outboundPolicyKey live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_OutboundPolicyKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.WS.outboundPolicyKey)) {
				if (msg.getNewValue() != null) {
					basePart.setOutboundPolicyKey((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setOutboundPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for inboundPolicyKey live update
			if (EsbPackage.eINSTANCE.getCalloutMediator_InboundPolicyKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.CalloutMediator.WS.inboundPolicyKey)) {
				if (msg.getNewValue() != null) {
					basePart.setInboundPolicyKey((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setInboundPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getCalloutMediator_ServiceURL(),
			EsbPackage.eINSTANCE.getCalloutMediator_SoapAction(),
			EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2xml(),
			EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2Repository(),
			EsbPackage.eINSTANCE.getCalloutMediator_PayloadType(),
			EsbPackage.eINSTANCE.getCalloutMediator_ResultType(),
			EsbPackage.eINSTANCE.getCalloutMediator_ResultContextProperty(),
			EsbPackage.eINSTANCE.getCalloutMediator_PassHeaders(),
			EsbPackage.eINSTANCE.getCalloutMediator_EndpointType(),
			EsbPackage.eINSTANCE.getCalloutMediator_PayloadProperty(),
			EsbPackage.eINSTANCE.getCalloutMediator_SecurityType(),
			EsbPackage.eINSTANCE.getCalloutMediator_Policies(),
			EsbPackage.eINSTANCE.getCalloutMediator_InitAxis2ClientOptions(),
			EsbPackage.eINSTANCE.getCalloutMediator_AddressEndpoint(),
			EsbPackage.eINSTANCE.getCalloutMediator_PayloadMessageXpath(),
			EsbPackage.eINSTANCE.getCalloutMediator_ResultMessageXpath(),
			EsbPackage.eINSTANCE.getCalloutMediator_PolicyKey(),
			EsbPackage.eINSTANCE.getCalloutMediator_OutboundPolicyKey(),
			EsbPackage.eINSTANCE.getCalloutMediator_InboundPolicyKey()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
//		if (key == EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml)
//			return ""; //$NON-NLS-1$
//		if (key == EsbViewsRepository.CalloutMediator.Service.addressEndpoint)
//			return ""; //$NON-NLS-1$
//		return super.getHelpContent(key, kind);
	    return EEFPropertyViewUtil.getHelpContent(key);
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
				if (EsbViewsRepository.CalloutMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Misc.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.CalloutMediator.Misc.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.serviceURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_ServiceURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_ServiceURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.soapAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_SoapAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_SoapAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.pathToAxis2xml == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2xml().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2xml().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.pathToAxis2Repository == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2Repository().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_PathToAxis2Repository().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Source.payloadType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_PayloadType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_PayloadType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Target.resultType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_ResultType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_ResultType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Target.resultContextProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_ResultContextProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_ResultContextProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Misc.passHeaders == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_PassHeaders().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_PassHeaders().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_EndpointType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Source.payloadProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_PayloadProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_PayloadProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.WS.securityType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_SecurityType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_SecurityType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.WS.policies == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_Policies().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_Policies().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CalloutMediator.Service.initAxis2ClientOptions == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCalloutMediator_InitAxis2ClientOptions().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCalloutMediator_InitAxis2ClientOptions().getEAttributeType(), newValue);
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
