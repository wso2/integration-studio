package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__URI_TEMPLATE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__HTTP_METHOD;

import org.apache.synapse.endpoints.AbstractEndpoint;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.HttpMethodType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class HTTPEndpointDeserializer extends AbstractEndpointDeserializer{

	public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
		Assert.isTrue(object instanceof org.apache.synapse.endpoints.HTTPEndpoint, "Unsupported endpoint passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.endpoints.HTTPEndpoint httpEndpoint = (org.apache.synapse.endpoints.HTTPEndpoint)object;
		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart ||
				part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.HTTPEndpoint_3712
				: EsbElementTypes.HTTPEndpoint_3709;
		AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
		setElementToEdit(endPoint);
		deserializeEndpoint(httpEndpoint,endPoint);
		
		if(httpEndpoint.getUriTemplate() !=null){
			executeSetValueCommand(HTTP_ENDPOINT__URI_TEMPLATE, httpEndpoint.getUriTemplate().getTemplate());
		}
		if (httpEndpoint.getHttpMethod() != null) {
			executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.get(httpEndpoint.getHttpMethod().toUpperCase()));
		}
		
		return endPoint;
	}

}
