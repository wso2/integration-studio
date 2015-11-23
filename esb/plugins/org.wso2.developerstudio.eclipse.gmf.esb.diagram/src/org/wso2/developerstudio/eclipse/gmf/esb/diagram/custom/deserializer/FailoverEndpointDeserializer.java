/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__END_POINT_NAME;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class FailoverEndpointDeserializer extends AbstractComplexEndPointDeserializer{
	
	public FailoverEndPoint createNode(IGraphicalEditPart part,AbstractEndpoint object) {
		Assert.isTrue(object instanceof org.apache.synapse.endpoints.FailoverEndpoint, "Unsupported endpoint passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.endpoints.FailoverEndpoint failoverEndpoint = (org.apache.synapse.endpoints.FailoverEndpoint)object;
		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart ||
				part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.FailoverEndPoint_3649
				: EsbElementTypes.FailoverEndPoint_3611;
		FailoverEndPoint endPoint = (FailoverEndPoint) DeserializerUtils.createNode(part,endpointType);
		setElementToEdit(endPoint);
		
		for (Iterator<MediatorProperty> i = failoverEndpoint.getProperties().iterator(); i.hasNext();) {
			MediatorProperty next = i.next();
			EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
			property.setName(next.getName());
			property.setValue(next.getValue());
			if(next.getScope()!=null){
				property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
			} else{
				property.setScope(EndPointPropertyScope.SYNAPSE);
			}
			executeAddValueCommand(endPoint.getProperties(), property);
		}
		
		deserializeComplexEndpoint(failoverEndpoint,part);
			
		if(StringUtils.isNotBlank(failoverEndpoint.getName())){
             executeSetValueCommand(END_POINT__END_POINT_NAME, failoverEndpoint.getName());
		}
		
		return endPoint;
	}

}
