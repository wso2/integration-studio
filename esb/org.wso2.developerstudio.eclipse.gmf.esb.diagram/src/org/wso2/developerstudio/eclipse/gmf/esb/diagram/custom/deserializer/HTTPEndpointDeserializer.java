/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__URI_TEMPLATE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.HTTP_ENDPOINT__HTTP_METHOD;

import org.apache.axis2.Constants;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.rest.RESTConstants;
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
		String httpMethod = httpEndpoint.getHttpMethod();
        if (httpMethod != null) {
            if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_POST)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.POST);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_GET)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.GET);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PUT)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PUT);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_DELETE)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.DELETE);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_HEAD)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.HEAD);
            } else if (httpMethod.equalsIgnoreCase(Constants.Configuration.HTTP_METHOD_PATCH)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.PATCH);
            } else if (httpMethod.equalsIgnoreCase(RESTConstants.METHOD_OPTIONS)) {
            	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.OPTIONS);
            }
        } else{
        	executeSetValueCommand(HTTP_ENDPOINT__HTTP_METHOD, HttpMethodType.LEAVE_AS_IS);
        }	
		return endPoint;
	}

}
