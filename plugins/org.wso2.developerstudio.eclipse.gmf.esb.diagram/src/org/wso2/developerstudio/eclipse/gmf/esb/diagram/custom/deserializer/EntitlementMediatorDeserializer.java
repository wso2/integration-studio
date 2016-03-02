package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EntitlementMediatorExt;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class EntitlementMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, EntitlementMediator>{
	
	final static String BASIC_AUTH = "basicAuth";
	final static String THRIFT = "thrift";
	final static String SOAP = "soap";
	final static String WS_XACML ="wsXacml";
	final static String UT ="org.wso2.carbon.identity.entitlement.mediator.callback.UTEntitlementCallbackHandler";
	final static String SAML ="org.wso2.carbon.identity.entitlement.mediator.callback.SAMLEntitlementCallbackHandler";
	final static String KERBEROS ="org.wso2.carbon.identity.entitlement.mediator.callback.KerberosEntitlementCallbackHandler";
	final static String X509 ="org.wso2.carbon.identity.entitlement.mediator.callback.X509EntitlementCallbackHandler";
	
	public EntitlementMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof EntitlementMediatorExt, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		EntitlementMediatorExt entitlementMediator = (EntitlementMediatorExt)mediator;
		
		EntitlementMediator visualEntitlementMediator = (EntitlementMediator) DeserializerUtils.createNode(part, EsbElementTypes.EntitlementMediator_3505);
		setElementToEdit(visualEntitlementMediator);
		setCommonProperties(entitlementMediator, visualEntitlementMediator);
		refreshEditPartMap();
		
		executeSetValueCommand(ENTITLEMENT_MEDIATOR__ENTITLEMENT_SERVER_URL, entitlementMediator.getRemoteServiceUrl());
		executeSetValueCommand(ENTITLEMENT_MEDIATOR__USERNAME, entitlementMediator.getRemoteServiceUserName());
		executeSetValueCommand(ENTITLEMENT_MEDIATOR__PASSWORD, entitlementMediator.getRemoteServicePassword());
	//	executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME, entitlementMediator.getCallbackClass());
		
		
		
		if (entitlementMediator.getCallbackClass() != null) {
			String callbackClass = entitlementMediator.getCallbackClass();
			if (callbackClass != null && !callbackClass.equals("")) {
				if(callbackClass.equalsIgnoreCase(UT)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
							EntitlementCallbackHandler.UT);
				}
				else if(callbackClass.equalsIgnoreCase(SAML)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
							EntitlementCallbackHandler.SAML);
				}
				else if(callbackClass.equalsIgnoreCase(KERBEROS)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
							EntitlementCallbackHandler.KERBEROS);
				}
				else if(callbackClass.equalsIgnoreCase(X509)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
							EntitlementCallbackHandler.X509);
				}
				else{
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_HANDLER,
							EntitlementCallbackHandler.CUSTOM);
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__CALLBACK_CLASS_NAME, entitlementMediator.getCallbackClass());

				}
			}
		}
	
		if (entitlementMediator.getClient() != null) {
			String clientType = entitlementMediator.getClient();
			if (clientType != null && !clientType.equals("")) {
				if(clientType.equalsIgnoreCase(BASIC_AUTH)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE,
							EntitlementClientType.BASIC_AUTH);
				}
				else if(clientType.equalsIgnoreCase(THRIFT)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE,
							EntitlementClientType.THRIFT);
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__THRIFT_HOST, entitlementMediator.getThriftHost());
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__THRIFT_PORT, entitlementMediator.getThriftPort());	
				}
				else if(clientType.equalsIgnoreCase(SOAP)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE,
							EntitlementClientType.SOAP);
					
				}
				else if(clientType.equalsIgnoreCase(WS_XACML)){
					executeSetValueCommand(ENTITLEMENT_MEDIATOR__ENTITLEMENT_CLIENT_TYPE,
							EntitlementClientType.WSXACML);
					
				}
			}
	}
	
	
		
		if(entitlementMediator.getOnRejectMediator() != null){
			SequenceMediator sequence = (SequenceMediator) entitlementMediator.getOnRejectMediator();
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualEntitlementMediator.getEntitlementContainer().getOnRejectContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualEntitlementMediator.getOnRejectOutputConnector());
		}else if(entitlementMediator.getOnRejectSeqKey() != null && !entitlementMediator.getOnRejectSeqKey().equals("")){
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_TYPE, EntitlementSequenceType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(entitlementMediator.getOnRejectSeqKey());
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ON_REJECT_SEQUENCE_KEY, regkey);
		}
		
		if(entitlementMediator.getOnAcceptMediator() != null){
			SequenceMediator sequence = (SequenceMediator) entitlementMediator.getOnAcceptMediator();
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualEntitlementMediator.getEntitlementContainer().getOnAcceptContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualEntitlementMediator.getOnAcceptOutputConnector());
		}else if(entitlementMediator.getOnAcceptSeqKey() != null && !entitlementMediator.getOnAcceptSeqKey().equals("")){
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_TYPE, EntitlementSequenceType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(entitlementMediator.getOnAcceptSeqKey());
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ON_ACCEPT_SEQUENCE_KEY, regkey);
		}
		
		if(entitlementMediator.getAdviceMediator() != null){
			SequenceMediator sequence = (SequenceMediator) entitlementMediator.getAdviceMediator();
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualEntitlementMediator.getEntitlementContainer().getAdviceContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualEntitlementMediator.getAdviceOutputConnector());
		}else if(entitlementMediator.getAdviceSeqKey() != null && !entitlementMediator.getAdviceSeqKey().equals("")){
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_TYPE, EntitlementSequenceType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(entitlementMediator.getAdviceSeqKey());
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__ADVICE_SEQUENCE_KEY, regkey);
		}
		
		if(entitlementMediator.getObligationsMediator() != null){
			SequenceMediator sequence = (SequenceMediator) entitlementMediator.getObligationsMediator();
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualEntitlementMediator.getEntitlementContainer().getObligationsContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualEntitlementMediator.getObligationsOutputConnector());
		}else if(entitlementMediator.getObligationsSeqKey() != null && !entitlementMediator.getObligationsSeqKey().equals("")){
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_TYPE, EntitlementSequenceType.REGISTRY_REFERENCE);
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			regkey.setKeyValue(entitlementMediator.getObligationsSeqKey());
			executeSetValueCommand(ENTITLEMENT_MEDIATOR__OBLIGATIONS_SEQUENCE_KEY, regkey);
		}
		
		return visualEntitlementMediator;
	}

}
