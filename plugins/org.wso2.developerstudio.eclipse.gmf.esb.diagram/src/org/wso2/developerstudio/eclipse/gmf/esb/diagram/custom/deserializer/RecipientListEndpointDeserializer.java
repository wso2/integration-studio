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
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.RECIPIENT_LIST_END_POINT__MAX_CACHE;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class RecipientListEndpointDeserializer extends AbstractComplexEndPointDeserializer {

	public RecipientListEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
		Assert.isTrue(object instanceof RecipientListEndpoint,
				"Unsupported endpoint passed in for deserialization at " + this.getClass());

		RecipientListEndpoint endpoint = (RecipientListEndpoint) object;
		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart ||
				part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.RecipientListEndPoint_3696
				: EsbElementTypes.RecipientListEndPoint_3692;
		RecipientListEndPoint model = (RecipientListEndPoint) DeserializerUtils.createNode(part,
				endpointType);
		setElementToEdit(model);

		for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
			MediatorProperty next = i.next();
			EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
			property.setName(next.getName());
			property.setValue(next.getValue());
			if (next.getScope() != null) {
				property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
			} else {
				property.setScope(EndPointPropertyScope.SYNAPSE);
			}
			executeAddValueCommand(model.getProperties(), property);
		}

		if (endpoint.getDynamicEnpointSet() != null) {
			if (StringUtils.isNotBlank(endpoint.getDynamicEnpointSet().getKeyValue())) {
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.VALUE);
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINTS_VALUE, endpoint.getDynamicEnpointSet().getKeyValue());
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__MAX_CACHE, endpoint.getCurrentPoolSize());
			} else if (endpoint.getDynamicEnpointSet().getExpression() != null) {
				SynapsePath xpath = endpoint.getDynamicEnpointSet().getExpression();
				NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.XPATH);
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINTS_EXPRESSION, namespaceProp);
				executeSetValueCommand(RECIPIENT_LIST_END_POINT__MAX_CACHE, endpoint.getCurrentPoolSize());
			}
		} else {
			executeSetValueCommand(RECIPIENT_LIST_END_POINT__ENDPOINT_TYPE, RecipientListEndpointType.INLINE);
			deserializeComplexEndpoint(endpoint,part);
		}
		
		if(StringUtils.isNotBlank(endpoint.getName())){
            executeSetValueCommand(END_POINT__END_POINT_NAME, endpoint.getName());
		}

		return model;
	}

}
