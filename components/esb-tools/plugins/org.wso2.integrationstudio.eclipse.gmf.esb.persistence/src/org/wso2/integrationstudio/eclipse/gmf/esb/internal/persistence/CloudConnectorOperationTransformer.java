/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map.Entry;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.codehaus.plexus.util.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.integrationstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class CloudConnectorOperationTransformer extends AbstractEsbNodeTransformer {

    private static final String JSON_EVAL = "json-eval(";

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
        CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
        try {
            information.getParentSequence()
                    .addChild(createCloudConnectorOperation(information, visuaCloudConnectorOperation));
            doTransform(information, visuaCloudConnectorOperation.getOutputConnector());
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
        // TODO Auto-generated method stub

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        Assert.isTrue(subject instanceof CloudConnectorOperation, "Invalid subject.");
        CloudConnectorOperation visuaCloudConnectorOperation = (CloudConnectorOperation) subject;
        try {
            sequence.addChild(createCloudConnectorOperation(information, visuaCloudConnectorOperation));
            doTransformWithinSequence(information, visuaCloudConnectorOperation.getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    private CloudConnectorOperationExt createCloudConnectorOperation(TransformationInfo information,
            CloudConnectorOperation visuaCloudConnectorOperation) throws JaxenException {

        CloudConnectorOperationExt cloudConnectorOperation = new CloudConnectorOperationExt();

        cloudConnectorOperation.setConnectorComponentName(visuaCloudConnectorOperation.getConnectorName());
        cloudConnectorOperation.setOperation(visuaCloudConnectorOperation.getOperationName());
        cloudConnectorOperation.setConfigRef(visuaCloudConnectorOperation.getConfigRef());

        for (CallTemplateParameter param : visuaCloudConnectorOperation.getConnectorParameters()) {
            String parameterName = "";
            if (param.getParameterName() != null && !param.getParameterName().isEmpty()) {
                parameterName = param.getParameterName();

                if (param.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
                    NamespacedProperty namespacedExpression = param.getParameterExpression();
                    String xpathValue = namespacedExpression.getPropertyValue();
                    Boolean dynamic = namespacedExpression.isDynamic();

                    if (dynamic) {
                        xpathValue = "{" + xpathValue + "}";
                        Value value = new Value(xpathValue);

                        if (namespacedExpression.getNamespaces().size() > 0) {
                            OMFactory factory = OMAbstractFactory.getOMFactory();
                            OMElement root = null;
                            int i = 0;
                            for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {
                                if (i == 0) {
                                    OMNamespace firstNameSpace = factory.createOMNamespace(entry.getValue(),
                                            entry.getKey());
                                    root = factory.createOMElement("root", firstNameSpace);
                                } else {
                                    root.declareNamespace(entry.getValue(), entry.getKey());
                                }
                                i++;
                            }
                            value.setNamespaces(root);
                        }
                        cloudConnectorOperation.getpName2ExpressionMap().put(parameterName, value);
                    } else if (StringUtils.isBlank(xpathValue)) {
                        String xpathValueTemp = ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION;
                        SynapsePath paramExpression = getParamExpression(namespacedExpression, xpathValueTemp);
                        cloudConnectorOperation.getpName2ExpressionMap().put(parameterName, new Value(paramExpression));
                    } else {
                        SynapsePath paramExpression = getParamExpression(namespacedExpression, xpathValue);
                        cloudConnectorOperation.getpName2ExpressionMap().put(parameterName, new Value(paramExpression));
                    }
                } else {
                    String paramValue = param.getParameterValue();
                    if (paramValue != null && paramValue.startsWith("{") && paramValue.endsWith("}")) {
                        paramValue = paramValue.substring(1, paramValue.length() - 1);
                        SynapseXPath paramExpression = new SynapseXPath(paramValue);
                        cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(),
                                new Value(paramExpression));
                    } else {
                        cloudConnectorOperation.getpName2ExpressionMap().put(param.getParameterName(),
                                new Value(paramValue));
                    }
                }
            }
        }
        return cloudConnectorOperation;
    }

    private static SynapsePath getParamExpression(NamespacedProperty namespacedExpression, String xpathValue)
            throws JaxenException {
        if (xpathValue.startsWith(JSON_EVAL)) {
            SynapseJsonPath paramExpression = new SynapseJsonPath(xpathValue.substring(10, xpathValue.length() - 1));
            return addNamespaceToParam(namespacedExpression, paramExpression);
        } else {
            SynapseXPath paramExpression = new SynapseXPath(xpathValue);
            return addNamespaceToParam(namespacedExpression, paramExpression);
        }
    }

    private static SynapsePath addNamespaceToParam(NamespacedProperty namespacedExpression, SynapsePath paramExpression)
            throws JaxenException {
        for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {
            paramExpression.addNamespace(entry.getKey(), entry.getValue());
        }
        return paramExpression;
    }
}
