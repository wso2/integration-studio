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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__END_POINT_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.TEMPLATE_ENDPOINT__TARGET_TEMPLATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartment2EditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.edit.parts.EndpointDiagramEndpointCompartmentEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.TemplateEndPointFormPage;

public class TemplateEndpointDeserializer extends AbstractEndpointDeserializer {

    public AbstractEndPoint createNode(IGraphicalEditPart part, AbstractEndpoint object) {
        Assert.isTrue(object instanceof org.apache.synapse.endpoints.TemplateEndpoint,
                "Unsupported endpoint passed in for deserialization at " + this.getClass());

        org.apache.synapse.endpoints.TemplateEndpoint templateEndpoint = (org.apache.synapse.endpoints.TemplateEndpoint) object;
        IElementType endpointType = (part instanceof EndpointDiagramEndpointCompartment2EditPart
                || part instanceof EndpointDiagramEndpointCompartmentEditPart) ? EsbElementTypes.TemplateEndpoint_3725
                        : EsbElementTypes.TemplateEndpoint_3716;
        AbstractEndPoint endPoint = (AbstractEndPoint) DeserializerUtils.createNode(part, endpointType);
        setElementToEdit(endPoint);

        executeSetValueCommand(TEMPLATE_ENDPOINT__TARGET_TEMPLATE, templateEndpoint.getTemplate());
        Map<String, String> parameterMap = templateEndpoint.getParameters();
        Iterator<String> keySet = parameterMap.keySet().iterator();
        while (keySet.hasNext()) {
            String key = keySet.next();
            TemplateEndpointParameter property = EsbFactory.eINSTANCE.createTemplateEndpointParameter();
            property.setParameterName(key);
            property.setParameterValue(parameterMap.get(key));
            executeAddValueCommand(((TemplateEndpoint) endPoint).getParameters(), property, false);
        }

        if (StringUtils.isNotBlank(templateEndpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, templateEndpoint.getName());
        }
        executeAddAllCommand(endPoint.getCommentsList(), templateEndpoint.getCommentsList());

        return endPoint;
    }

    @Override
    public void createNode(FormEditor formEditor, AbstractEndpoint endpointObject) {
        ESBFormEditor addressEPFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) addressEPFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        org.apache.synapse.endpoints.TemplateEndpoint templateEndpoint = (org.apache.synapse.endpoints.TemplateEndpoint) endpointObject;

        TemplateEndPointFormPage templateEndpointPage = (TemplateEndPointFormPage) endpointPage;

        if (templateEndpoint.getName() != null) {
            templateEndpointPage.setName(templateEndpoint.getName());
        }

        if (templateEndpoint.getTemplate() != null) {
            String[] availableTemplates = templateEndpointPage.getTempEP_AvaiableTemp().getItems();
            if (Arrays.asList(availableTemplates).contains(templateEndpoint.getTemplate())) {
                templateEndpointPage.getTempEP_AvaiableTemp().setText(templateEndpoint.getTemplate());
            }
            if (templateEndpointPage.getTempEP_TargetTemp() != null) {
                templateEndpointPage.getTempEP_TargetTemp().setText(templateEndpoint.getTemplate());
            }
        }

        if (templateEndpoint.getDescription() != null && templateEndpointPage.getTempEP_Description() != null) {
            templateEndpointPage.getTempEP_Description().setText(templateEndpoint.getDescription());
        }

        Map<String, String> parameterMap = (Map<String, String>) templateEndpoint.getParameters();
        Iterator<String> keySet = parameterMap.keySet().iterator();

        if (keySet != null) {
            List<TemplateEndpointParameter> existingProperties = templateEndpointPage.templateParameterList;
            templateEndpointPage.templateParameterList = getTemplateEndpointParameter(keySet, parameterMap,
                    existingProperties);
        } else {
            // When removing all properties from the source view then clear the list
            templateEndpointPage.templateParameterList = null;
        }

        super.createNode(formEditor, endpointObject);
    }

    /**
     * Gets the template parameters
     * 
     * @param keySet
     * @param parameterMap
     * @param existingProperties
     * @return
     */
    private List<TemplateEndpointParameter> getTemplateEndpointParameter(Iterator<String> keySet,
            Map<String, String> parameterMap, List<TemplateEndpointParameter> existingProperties) {
        List<TemplateEndpointParameter> newlyAddedProperties = new ArrayList<TemplateEndpointParameter>();
        List<TemplateEndpointParameter> removedProperties = new ArrayList<TemplateEndpointParameter>();
        List<TemplateEndpointParameter> newProperties = new ArrayList<TemplateEndpointParameter>();

        while (keySet.hasNext()) {
            String key = keySet.next();
            TemplateEndpointParameter property = EsbFactory.eINSTANCE.createTemplateEndpointParameter();
            property.setParameterName(key);
            property.setParameterValue(parameterMap.get(key));

            if (existingProperties != null) {
                for (TemplateEndpointParameter propertyItem : existingProperties) {
                    // When updating the existing properties from source view, then remove the property from old
                    // list and add to new list
                    if (propertyItem.getParameterName().equals(key)) {
                        existingProperties.remove(propertyItem);
                        newlyAddedProperties.add(property);
                        break;
                    }
                }
            }
            // When adding a new property from source then add it to the new list
            if (!newlyAddedProperties.contains(property)) {
                newlyAddedProperties.add(property);
            }
        }

        // If old properties contain any property values, then remove the value and add the property to the new
        // list, DEVTOOLESB-505
        if (existingProperties != null) {
            for (TemplateEndpointParameter prop : existingProperties) {
                String value = prop.getParameterName();
                String name = prop.getParameterName();
                if (StringUtils.isNotEmpty(value)) {
                    // Add the property to removed list
                    removedProperties.add(prop);
                    /*
                     * MessageProcessorParameter newPrp = createProperty(name); if
                     * (!newlyAddedProperties.contains(newPrp)) { // Add to the new properties list
                     * newProperties.add(newPrp); }
                     */
                }
            }
        }
        // First remove the removed properties from existing properties
        if (removedProperties.size() > 0) {
            existingProperties.removeAll(removedProperties);
        }
        // Adds the new properties
        if (newProperties.size() > 0) {
            newlyAddedProperties.addAll(newProperties);
        }
        // Adds the existing old properties (which didn't get updated) to the new list
        if (existingProperties != null) {
            newlyAddedProperties.addAll(existingProperties);
        }
        return newlyAddedProperties;

    }
    
    public org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint createUIEndpoint(Endpoint synapseEndpoint) {
        Assert.isTrue(synapseEndpoint instanceof org.apache.synapse.endpoints.TemplateEndpoint,
                "Unsupported endpoint has been passed to create the UI object at " + this.getClass());

        org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint endpoint = new TemplateEndpointImpl();

        org.apache.synapse.endpoints.TemplateEndpoint templateEndpoint = (org.apache.synapse.endpoints.TemplateEndpoint) synapseEndpoint;
        
        ((TemplateEndpointImpl) endpoint).setEndPointName(templateEndpoint.getName());
        ((TemplateEndpointImpl) endpoint).setTargetTemplate(templateEndpoint.getTemplate());
        if (templateEndpoint.getParameterValue("suspend_duration") != null) {
        	((TemplateEndpointImpl) endpoint).setSuspendInitialDuration(templateEndpoint.getParameterValue("suspend_duration"));
        }
        ((TemplateEndpointImpl) endpoint).setAddress(templateEndpoint.getParameterValue("uri"));

        return endpoint;
    }
}