package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementCallbackHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementClientType;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EntitlementMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerUtils;

public class EntitlementMediatorTransformer extends AbstractEsbNodeTransformer{
	
	
	final static String BASIC_AUTH = "basicAuth";
	final static String THRIFT = "thrift";
	final static String SOAP = "soap";
	final static String WS_XACML ="wsXacml";
	final static String UT ="org.wso2.carbon.identity.entitlement.mediator.callback.UTEntitlementCallbackHandler";
	final static String SAML ="org.wso2.carbon.identity.entitlement.mediator.callback.SAMLEntitlementCallbackHandler";
	final static String KERBEROS ="org.wso2.carbon.identity.entitlement.mediator.callback.KerberosEntitlementCallbackHandler";
	final static String X509 ="org.wso2.carbon.identity.entitlement.mediator.callback.X509EntitlementCallbackHandler";

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(createEntitlementMediator(information,subject));
		/*
		 *  Transform the Entitlement mediator output data flow path.
		 */
		doTransform(information,
				((EntitlementMediator) subject).getOutputConnector());	
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createEntitlementMediator(information,subject));
		doTransformWithinSequence(information,((EntitlementMediator) subject).getOutputConnector().getOutgoingLink(),sequence);			
	}
	
	private EntitlementMediatorExt createEntitlementMediator(TransformationInfo information,EsbNode subject) throws TransformerException{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof EntitlementMediator, "Invalid subject.");
		EntitlementMediator visualEntitlement = (EntitlementMediator) subject;
		EntitlementMediatorExt entitlementMediator=new EntitlementMediatorExt();
		setCommonProperties(entitlementMediator, visualEntitlement);
		{			
			entitlementMediator.setRemoteServiceUrl(visualEntitlement.getEntitlementServerURL());
			entitlementMediator.setRemoteServiceUserName(visualEntitlement.getUsername());
			entitlementMediator.setRemoteServicePassword(visualEntitlement.getPassword());
		//	entitlementMediator.setCallbackClass(visualEntitlement.getCallbackClassName());
			
		
		}	
		
		if(visualEntitlement.getCallbackHandler().equals(EntitlementCallbackHandler.CUSTOM)){
			entitlementMediator.setCallbackClass(visualEntitlement.getCallbackClassName());
			}
			else if (visualEntitlement.getCallbackHandler().equals(EntitlementCallbackHandler.SAML)){
				entitlementMediator.setCallbackClass(SAML);
				}
			else if (visualEntitlement.getCallbackHandler().equals(EntitlementCallbackHandler.UT)){
				entitlementMediator.setCallbackClass(UT);
				}
			else if (visualEntitlement.getCallbackHandler().equals(EntitlementCallbackHandler.KERBEROS)){
				entitlementMediator.setCallbackClass(KERBEROS);
				}
			else if (visualEntitlement.getCallbackHandler().equals(EntitlementCallbackHandler.X509)){
				entitlementMediator.setCallbackClass(X509);

			}
			
		if(visualEntitlement.getEntitlementClientType().equals(EntitlementClientType.THRIFT))	{
			entitlementMediator.setClient(THRIFT);
			entitlementMediator.setThriftHost(visualEntitlement.getThriftHost());
			entitlementMediator.setThriftPort(visualEntitlement.getThriftPort());
		}else if(visualEntitlement.getEntitlementClientType().equals(EntitlementClientType.BASIC_AUTH)){
			entitlementMediator.setClient(BASIC_AUTH);
		}else if (visualEntitlement.getEntitlementClientType().equals(EntitlementClientType.SOAP)){
			entitlementMediator.setClient(SOAP);
		}else if (visualEntitlement.getEntitlementClientType().equals(EntitlementClientType.WSXACML)){
			entitlementMediator.setClient(WS_XACML);
		}

		
		
		if (visualEntitlement.getOnRejectSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)) {
			entitlementMediator.setOnRejectSeqKey(visualEntitlement.getOnRejectSequenceKey().getKeyValue());
		}else{		
			/*
			 *  Transform onReject output data flow path.
			 */
			SequenceMediator onReject = new SequenceMediator();
			entitlementMediator.setOnRejectMediator(onReject);
			TransformationInfo newOnRejectInfo = TransformerUtils.cloneTransformationInfo(information);
			newOnRejectInfo.setParentSequence(onReject);
			doTransform(newOnRejectInfo, visualEntitlement.getOnRejectOutputConnector());
		
		}
		
		if (visualEntitlement.getOnAcceptSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)) {
			entitlementMediator.setOnAcceptSeqKey(visualEntitlement.getOnAcceptSequenceKey().getKeyValue());
		}else{
			/*
			 *  Transform onAccept output data flow path.
			 */
			SequenceMediator onAccept = new SequenceMediator();
			entitlementMediator.setOnAcceptMediator(onAccept);
			TransformationInfo newOnAcceptInfo = TransformerUtils.cloneTransformationInfo(information);
			newOnAcceptInfo.setParentSequence(onAccept);	
			doTransform(newOnAcceptInfo, visualEntitlement.getOnAcceptOutputConnector());
		}
		
		if (visualEntitlement.getAdviceSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)) {
			entitlementMediator.setAdviceSeqKey(visualEntitlement.getAdviceSequenceKey().getKeyValue());
		}else{
			/*
			 *  Transform advice output data flow path.
			 */
			SequenceMediator advice = new SequenceMediator();
			entitlementMediator.setAdviceMediator(advice);
			TransformationInfo newAdviceInfo = TransformerUtils.cloneTransformationInfo(information);
			newAdviceInfo.setParentSequence(advice);
			doTransform(newAdviceInfo, visualEntitlement.getAdviceOutputConnector());
		}
		if (visualEntitlement.getObligationsSequenceType().equals(EntitlementSequenceType.REGISTRY_REFERENCE)) {
			entitlementMediator.setObligationsSeqKey(visualEntitlement.getObligationsSequenceKey().getKeyValue());
		}else{
			/*
			 *  Transform obligations output data flow path.
			 */
			SequenceMediator obligations = new SequenceMediator();
			entitlementMediator.setObligationsMediator(obligations);
			TransformationInfo newObligationsInfo = TransformerUtils.cloneTransformationInfo(information);
			newObligationsInfo.setParentSequence(obligations);	
			doTransform(newObligationsInfo, visualEntitlement.getObligationsOutputConnector());
		}
		
		return entitlementMediator;
	}
}
