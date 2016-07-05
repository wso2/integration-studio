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

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
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
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.DefaultEndpointFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

public class DefaultEndpointDeserializer extends AbstractEndpointDeserializer {

	@Deprecated
	public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {

		Assert.isTrue(object instanceof org.apache.synapse.endpoints.DefaultEndpoint,
				"Unsupported endpoint passed in for deserialization at " + this.getClass());

		org.apache.synapse.endpoints.DefaultEndpoint dafaultEndpoint = (org.apache.synapse.endpoints.DefaultEndpoint) object;

		IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
				|| part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.DefaultEndPoint_3643
						: EsbElementTypes.DefaultEndPoint_3609;
		AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
		setElementToEdit(endPoint);
		deserializeEndpoint(dafaultEndpoint, endPoint);
		return endPoint;
	}

	@Override
	public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {
		ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
		EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
				.getFormPageForArtifact(ArtifactType.ENDPOINT);

		DefaultEndpoint endpoint = (DefaultEndpoint) endpointObject;

		DefaultEndpointFormPage defaultEndpointPage = (DefaultEndpointFormPage) endpointPage;
		deserializeEndpoint(formEditor, endpointObject);
		if (StringUtils.isNotEmpty(defaultEndpointPage.getEP_Description().getText())) {
			setTextValue(defaultEndpointPage.getEP_Description(), endpoint.getDescription());
		}

		super.createNode(formEditor, endpointObject);
	}

}
