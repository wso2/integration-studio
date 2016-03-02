package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.transform.Argument;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class PayloadFactoryMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, PayloadFactoryMediator>{
	private static String XML_LITERAL = "xml"; 
	private static String JSON_LITERAL = "json"; 
	
	public PayloadFactoryMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.transform.PayloadFactoryMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.transform.PayloadFactoryMediator payloadFactoryMediator = (org.apache.synapse.mediators.transform.PayloadFactoryMediator)mediator;
		
		PayloadFactoryMediator visualPayloadFactoryMediator = (PayloadFactoryMediator) DeserializerUtils.createNode(part, EsbElementTypes.PayloadFactoryMediator_3597);
		setElementToEdit(visualPayloadFactoryMediator);
		setCommonProperties(payloadFactoryMediator, visualPayloadFactoryMediator);
		
		if (payloadFactoryMediator.getFormatKey() != null) {
			executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT, PayloadFormatType.REGISTRY_REFERENCE);
			RegistryKeyProperty payloadFormatKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			payloadFormatKey.setKeyValue(payloadFactoryMediator.getFormatKey().getKeyValue());
			
			executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_KEY, payloadFormatKey);
			
		} else {
			executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT, PayloadFormatType.INLINE);
			executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__PAYLOAD, payloadFactoryMediator.getFormat());
		}
		
		if (payloadFactoryMediator.getType() != null) {
			if(payloadFactoryMediator.getType().equals(XML_LITERAL)){
				executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE, MediaType.XML);
			} else if(payloadFactoryMediator.getType().equals(JSON_LITERAL)){
				executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE, MediaType.JSON);
			}
		}
		
		EList<PayloadFactoryArgument> arguments=new BasicEList<PayloadFactoryArgument>();
		for(Argument argument: payloadFactoryMediator.getPathArgumentList()){
			PayloadFactoryArgument payloadFactoryArgument= EsbFactory.eINSTANCE.createPayloadFactoryArgument();
			if(argument.getExpression()!=null){
				executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, createNamespacedProperty(argument.getExpression()));
				executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE, PayloadFactoryArgumentType.EXPRESSION);
				if(argument.getExpression().getPathType() == SynapsePath.X_PATH){
					executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__EVALUATOR, MediaType.XML);
				}else if(argument.getExpression().getPathType() == SynapsePath.JSON_PATH){
					executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__EVALUATOR, MediaType.JSON);
				}
				
			}else{
				executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE, argument.getValue());
				executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE, PayloadFactoryArgumentType.VALUE);
			}
			arguments.add(payloadFactoryArgument);
		}
		
/*		for(Argument argument: payloadFactoryMediator.getJsonPathArgumentList()){
			PayloadFactoryArgument payloadFactoryArgument= EsbFactory.eINSTANCE.createPayloadFactoryArgument();
			if(argument.getJsonPath()!=null){
				try {
					SynapseXPath xpath = new SynapseXPath(argument.getJsonPath().getJsonPathExpression());
					executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION, createNamespacedProperty(xpath));
					executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE, PayloadFactoryArgumentType.EXPRESSION);
					executeSetValueCommand(payloadFactoryArgument,PAYLOAD_FACTORY_ARGUMENT__EVALUATOR, MediaType.JSON);
					arguments.add(payloadFactoryArgument);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}*/
		
		executeSetValueCommand(PAYLOAD_FACTORY_MEDIATOR__ARGS, arguments);
			
		return visualPayloadFactoryMediator;
	}

}
