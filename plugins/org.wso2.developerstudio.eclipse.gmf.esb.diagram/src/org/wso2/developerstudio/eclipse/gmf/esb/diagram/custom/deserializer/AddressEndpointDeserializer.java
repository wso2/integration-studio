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

import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.AddressEndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class AddressEndpointDeserializer extends AbstractEndpointDeserializer {

	@Deprecated
	public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
		Assert.isTrue(object instanceof org.apache.synapse.endpoints.AddressEndpoint,
				"Unsupported endpoint passed in for deserialization at " + this.getClass());

		org.apache.synapse.endpoints.AddressEndpoint addressEndpoint = (org.apache.synapse.endpoints.AddressEndpoint) object;
		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
				|| part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.AddressEndPoint_3646
						: EsbElementTypes.AddressEndPoint_3610;
		AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
		setElementToEdit(endPoint);
		deserializeEndpoint(addressEndpoint, endPoint);

		executeSetValueCommand(ADDRESS_END_POINT__URI, addressEndpoint.getDefinition().getAddress());

		return endPoint;
	}

	@Override
	public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {

		ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
		EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor.getFormPageForArtifact(ArtifactType.ENDPOINT);

		AddressEndpoint endpoint = (AddressEndpoint) endpointObject;
		
		AddressEndpointFormPage addressEndpointPage = (AddressEndpointFormPage)endpointPage;
		
		setTextValue(addressEndpointPage.addressEP_URI, endpoint.getDefinition().getAddress());
//		setTextValue(addressEndpointPage.addressEP_Properties, endpoint.getDefinition().get);
		setTextValue(addressEndpointPage.addressEP_Description, endpoint.getDescription());
		
		if (endpoint.getDefinition().getFormat() == null) {
			addressEndpointPage.addressEP_Format.select(0);
		} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("soap11")) {
			addressEndpointPage.addressEP_Format.select(1);
		} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("soap12")) {
			addressEndpointPage.addressEP_Format.select(2);
		} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("pox")) {
			addressEndpointPage.addressEP_Format.select(3);
		} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("get")) {
			addressEndpointPage.addressEP_Format.select(4);
		} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("rest")) {
			addressEndpointPage.addressEP_Format.select(5);
		}else {
			addressEndpointPage.addressEP_Format.select(0);
		}
		
		if (endpoint.getDefinition().isTracingEnabled()) {
			addressEndpointPage.endpointTrace.select(0);
		} else {
			addressEndpointPage.endpointTrace.select(1);
		}
		
		if (endpoint.getDefinition().isStatisticsEnable()) {
			addressEndpointPage.endpointStatistics.select(0);
		} else {
			addressEndpointPage.endpointStatistics.select(1);
		}
		
		if (endpoint.getDefinition().isUseMTOM()) {
			addressEndpointPage.addressEP_Optimize.select(1);
		} else if (endpoint.getDefinition().isUseSwa()) {
			addressEndpointPage.addressEP_Optimize.select(2);
		} else {
			addressEndpointPage.addressEP_Optimize.select(0);
		}
		
		super.createNode(formEditor, endpointObject);
	}
	
}
