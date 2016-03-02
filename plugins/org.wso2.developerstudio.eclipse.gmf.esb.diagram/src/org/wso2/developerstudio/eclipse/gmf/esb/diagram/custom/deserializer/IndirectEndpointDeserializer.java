/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

import org.apache.synapse.endpoints.IndirectEndpoint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class IndirectEndpointDeserializer extends
		AbstractEsbNodeDeserializer<IndirectEndpoint, NamedEndpoint> {

	public NamedEndpoint createNode(IGraphicalEditPart part, IndirectEndpoint indirectEndpoint) {

		NamedEndpoint endPoint = (NamedEndpoint) DeserializerUtils.createNode(part,
				EsbElementTypes.NamedEndpoint_3660);
		setElementToEdit(endPoint);

		executeSetValueCommand(NAMED_ENDPOINT__NAME,indirectEndpoint.getKey());
		executeSetValueCommand(NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE,KeyType.STATIC);

		return endPoint;
	}

}
