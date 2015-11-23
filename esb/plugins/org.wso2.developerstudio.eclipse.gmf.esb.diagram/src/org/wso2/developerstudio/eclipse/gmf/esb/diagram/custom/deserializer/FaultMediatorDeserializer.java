package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class FaultMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, FaultMediator>{
	
	final static int POX = 3;
	final static int SOAP11 = 1;
	final static int SOAP12 = 2;

	public FaultMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {

		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.transform.FaultMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.transform.FaultMediator faultMediator = (org.apache.synapse.mediators.transform.FaultMediator)mediator;
		
		FaultMediator visualFaultMediator = (FaultMediator) DeserializerUtils.createNode(part, EsbElementTypes.FaultMediator_3509);
		setElementToEdit(visualFaultMediator);	
		setCommonProperties(faultMediator, visualFaultMediator);
		
		switch (faultMediator.getSoapVersion()) {
		case SOAP11:
			executeSetValueCommand(FAULT_MEDIATOR__SOAP_VERSION, FaultSoapVersion.SOAP_11);
			
			if(faultMediator.getFaultRole()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_ACTOR, faultMediator.getFaultRole().getPath());
			}
			
			if(faultMediator.getFaultReasonValue()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_STRING_VALUE, faultMediator.getFaultReasonValue());
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_STRING_TYPE, FaultStringType.VALUE);
			}else if(faultMediator.getFaultReasonExpr()!=null){	
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, createNamespacedProperty(faultMediator.getFaultReasonExpr()));
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_STRING_TYPE, FaultStringType.EXPRESSION);
			}
			
			if(faultMediator.getFaultCodeValue()!=null){
				if("VersionMismatch".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.VERSION_MISSMATCH);
				}else if("MustUnderstand".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.MUST_UNDERSTAND);
				}else if("Server".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.SERVER);
				}else if("Client".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.CLIENT);
				}
			}else if(faultMediator.getFaultCodeExpr()!=null){	
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, createNamespacedProperty(faultMediator.getFaultCodeExpr()));
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_TYPE, FaultCodeType.EXPRESSION);
			}
			
			break;
		
		case 0:	
		case SOAP12:
			executeSetValueCommand(FAULT_MEDIATOR__SOAP_VERSION, FaultSoapVersion.SOAP_12);
			
			if(faultMediator.getFaultRole()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__ROLE_NAME, faultMediator.getFaultRole().getPath());
			}
			
			if(faultMediator.getFaultReasonValue()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_VALUE, faultMediator.getFaultReasonValue());
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_TYPE, FaultReasonType.VALUE);
			}else if(faultMediator.getFaultReasonExpr()!=null){	
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, createNamespacedProperty(faultMediator.getFaultReasonExpr()));
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_TYPE, FaultReasonType.EXPRESSION);
			}
			if(faultMediator.getFaultNode()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__NODE_NAME, faultMediator.getFaultNode().getPath());
			}	
			if(faultMediator.getFaultCodeValue()!=null){
				if("VersionMismatch".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.VERSION_MISSMATCH);
				}else if("MustUnderstand".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.MUST_UNDERSTAND);
				}else if("Server".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.SERVER);
				}else if("Client".equals(faultMediator.getFaultCodeValue().getLocalPart())){
					executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_SOAP11, FaultCodeSoap11.CLIENT);
				}
			}else if(faultMediator.getFaultCodeExpr()!=null){	
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, createNamespacedProperty(faultMediator.getFaultCodeExpr()));
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_CODE_TYPE, FaultCodeType.EXPRESSION);
			}	
			break;		
			
		case POX:
			executeSetValueCommand(FAULT_MEDIATOR__SOAP_VERSION, FaultSoapVersion.POX);
			
			if(faultMediator.getFaultReasonValue()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_VALUE, faultMediator.getFaultReasonValue());
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_TYPE, FaultReasonType.VALUE);
			}else if(faultMediator.getFaultReasonExpr()!=null){	
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, createNamespacedProperty(faultMediator.getFaultReasonExpr()));
				executeSetValueCommand(FAULT_MEDIATOR__FAULT_REASON_TYPE, FaultReasonType.EXPRESSION);
			}
			if(faultMediator.getFaultNode()!=null){
				executeSetValueCommand(FAULT_MEDIATOR__NODE_NAME, faultMediator.getFaultNode().getPath());
			}			
			break;	
			
		}	
		if(faultMediator.getFaultDetail()!=null){
			executeSetValueCommand(FAULT_MEDIATOR__FAULT_DETAIL_VALUE, faultMediator.getFaultDetail());
			executeSetValueCommand(FAULT_MEDIATOR__FAULT_DETAIL_TYPE, FaultDetailType.VALUE);
		}else if(faultMediator.getFaultDetailExpr()!=null){	
			executeSetValueCommand(FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, createNamespacedProperty(faultMediator.getFaultDetailExpr()));
			executeSetValueCommand(FAULT_MEDIATOR__FAULT_DETAIL_TYPE, FaultDetailType.EXPRESSION);
		}	
		
		executeSetValueCommand(FAULT_MEDIATOR__SERIALIZE_RESPONSE, faultMediator.isSerializeResponse());
		if (faultMediator.isSerializeResponse()) {
			executeSetValueCommand(FAULT_MEDIATOR__MARK_AS_RESPONSE, faultMediator.isMarkAsResponse());
		} 
				
		return visualFaultMediator;
	}

}
