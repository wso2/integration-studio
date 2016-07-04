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
import org.apache.synapse.endpoints.WSDLEndpoint;
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
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.WsdlEndpointFormPage;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class WSDLEndpointDeserializer extends AbstractEndpointDeserializer {

	@Deprecated
	public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
		Assert.isTrue(object instanceof org.apache.synapse.endpoints.WSDLEndpoint,
				"Unsupported endpoint passed in for deserialization at " + this.getClass());

		org.apache.synapse.endpoints.WSDLEndpoint wsdlEndpoint = (org.apache.synapse.endpoints.WSDLEndpoint) object;

		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
				|| part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.WSDLEndPoint_3653
						: EsbElementTypes.WSDLEndPoint_3612;
		AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
		setElementToEdit(endPoint);
		deserializeEndpoint(wsdlEndpoint, endPoint);

		executeSetValueCommand(WSDL_END_POINT__WSDL_URI, wsdlEndpoint.getWsdlURI());
		executeSetValueCommand(WSDL_END_POINT__PORT, wsdlEndpoint.getPortName());
		executeSetValueCommand(WSDL_END_POINT__SERVICE, wsdlEndpoint.getServiceName());

		return endPoint;
	}

	@Override
	public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {
		ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
		EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
				.getFormPageForArtifact(ArtifactType.ENDPOINT);

		WSDLEndpoint endpoint = (WSDLEndpoint) endpointObject;

		WsdlEndpointFormPage wsdlEndpointPage = (WsdlEndpointFormPage) endpointPage;
		// setTextValue(wsdlEndpointPage.wsdlEP_Properties,
		// endpoint.getDefinition().get);
		deserializeEndpoint(formEditor, endpointObject);
		setTextValue(wsdlEndpointPage.getWsdlEP_WsdlUri(), endpoint.getWsdlURI());
		setTextValue(wsdlEndpointPage.getWsdlEP_Service(), endpoint.getServiceName());
		setTextValue(wsdlEndpointPage.getWsdlEP_Port(), endpoint.getPortName());
		setTextValue(wsdlEndpointPage.getEndpointName(), endpoint.getName());
		setTextValue(wsdlEndpointPage.getEP_Description(), endpoint.getDescription());
		if (endpoint.getDefinition().getFormat() != null) {
			if (endpoint.getDefinition().getFormat().equalsIgnoreCase("soap11")) {
				wsdlEndpointPage.getEP_Format().select(1);
			} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("soap12")) {
				wsdlEndpointPage.getEP_Format().select(2);
			} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("pox")) {
				wsdlEndpointPage.getEP_Format().select(3);
			} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("get")) {
				wsdlEndpointPage.getEP_Format().select(4);
			} else if (endpoint.getDefinition().getFormat().equalsIgnoreCase("reset")) {
				wsdlEndpointPage.getEP_Format().select(5);
			} else {
				wsdlEndpointPage.getEP_Format().select(0);
			}
		}
		if (wsdlEndpointPage.getEndpointTrace() != null) {
			if (endpoint.getDefinition().isTracingEnabled()) {
				wsdlEndpointPage.getEndpointTrace().select(0);
			} else {
				wsdlEndpointPage.getEndpointTrace().select(1);
			}
		}
		if (wsdlEndpointPage.getEndpointStatistics() != null) {
			if (endpoint.getDefinition().isStatisticsEnable()) {
				wsdlEndpointPage.getEndpointStatistics().select(0);
			} else {
				wsdlEndpointPage.getEndpointStatistics().select(1);
			}
		}

		if (wsdlEndpointPage.getEP_Optimize() != null) {
			if (endpoint.getDefinition().isUseMTOM()) {
				wsdlEndpointPage.getEP_Optimize().select(1);
			} else if (endpoint.getDefinition().isUseSwa()) {
				wsdlEndpointPage.getEP_Optimize().select(2);
			} else {
				wsdlEndpointPage.getEP_Optimize().select(0);
			}
		}

		super.createNode(formEditor, endpointObject);
	}

}
