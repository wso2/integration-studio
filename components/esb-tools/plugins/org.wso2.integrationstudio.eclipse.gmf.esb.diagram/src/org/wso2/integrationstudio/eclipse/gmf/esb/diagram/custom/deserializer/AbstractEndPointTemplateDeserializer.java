/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.Template;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

public abstract class AbstractEndPointTemplateDeserializer
        extends AbstractEsbNodeDeserializer<org.apache.synapse.endpoints.Template, Template> {

    public void createNode(FormEditor formEditor, org.apache.synapse.endpoints.Template template) {
        ESBFormEditor addressTemplateEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) addressTemplateEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        if (endpointPage.getTemplateParameterList() == null) {
            List<TemplateParameter> parameterList = new ArrayList<TemplateParameter>();
            endpointPage.setTemplateParameterList(parameterList);
        }
        endpointPage.getTemplateParameterList().clear();
        for (String parameter : template.getParameters()) {
            if (parameter != null && !(parameter.equals("name") || parameter.equals("uri"))) {
                TemplateParameter templateParameter = EsbFactory.eINSTANCE.createTemplateParameter();
                templateParameter.setName(parameter);
                endpointPage.getTemplateParameterList().add(templateParameter);
            }
        }
        setTextValue(endpointPage.getTemplateName(), template.getName());
        endpointPage.setTemplateCommentList(template.getCommentsList());

        Endpoint endpoint = DummyTemplateEndpointFactory.getEndpointFromElement(template.getElement(), false,
                new Properties());
        IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endpoint);
        deserializer.createNode(formEditor, endpoint);
    }

    protected void setTextValue(Text textField, Object value) {
        if (value != null && textField != null) {
            textField.setText(value.toString());
        }
    }
}
