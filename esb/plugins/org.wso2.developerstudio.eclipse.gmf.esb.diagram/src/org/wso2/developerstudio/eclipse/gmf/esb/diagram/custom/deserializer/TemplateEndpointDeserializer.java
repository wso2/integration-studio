/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.TEMPLATE_ENDPOINT__TARGET_TEMPLATE;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class TemplateEndpointDeserializer extends AbstractEsbNodeDeserializer<AbstractEndpoint, AbstractEndPoint>{
	 
    public AbstractEndPoint createNode(IGraphicalEditPart part,
                    AbstractEndpoint object) {
            Assert.isTrue(object instanceof org.apache.synapse.endpoints.TemplateEndpoint, "Unsupported endpoint passed in for deserialization at " + this.getClass());

            org.apache.synapse.endpoints.TemplateEndpoint templateEndpoint = (org.apache.synapse.endpoints.TemplateEndpoint)object;
            IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart ||
                            part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.TemplateEndpoint_3725
                            : EsbElementTypes.TemplateEndpoint_3716;
            AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
            setElementToEdit(endPoint);

            executeSetValueCommand(TEMPLATE_ENDPOINT__TARGET_TEMPLATE, templateEndpoint.getTemplate());
            Map<String, String> parameterMap=templateEndpoint.getParameters();
            Iterator<String> keySet=parameterMap.keySet().iterator();
            while(keySet.hasNext()){
                    String key=keySet.next();
                    TemplateEndpointParameter property = EsbFactory.eINSTANCE.createTemplateEndpointParameter();
                    property.setParameterName(key);
                    property.setParameterValue(parameterMap.get(key));
                    executeAddValueCommand(((TemplateEndpoint)endPoint).getParameters(), property);
            }
            
		if (StringUtils.isNotBlank(templateEndpoint.getName())) {
			executeSetValueCommand(END_POINT__END_POINT_NAME, templateEndpoint.getName());
		}

            return endPoint;
    }
}