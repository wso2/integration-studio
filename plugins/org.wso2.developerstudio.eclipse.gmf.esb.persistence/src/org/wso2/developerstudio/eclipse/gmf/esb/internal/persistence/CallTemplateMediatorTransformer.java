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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map.Entry;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.codehaus.plexus.util.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class CallTemplateMediatorTransformer extends AbstractEsbNodeTransformer {

    private static final String JSON_EVAL = "json-eval(";
    private static final String INVALID_SUBJECT = "Invalid subject.";

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof CallTemplateMediator, INVALID_SUBJECT);
        CallTemplateMediator visuaCallTemplate = (CallTemplateMediator) subject;
        try {
            information.getParentSequence().addChild(createInvokeMediator(information, visuaCallTemplate));
            // Transform the callTemplate mediator output data flow path.
            doTransform(information, visuaCallTemplate.getOutputConnector());
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        Assert.isTrue(subject instanceof CallTemplateMediator, INVALID_SUBJECT);
        CallTemplateMediator visuaCallTemplate = (CallTemplateMediator) subject;
        try {
            sequence.addChild(createInvokeMediator(information, visuaCallTemplate));
            doTransformWithinSequence(information, visuaCallTemplate.getOutputConnector().getOutgoingLink(), sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    public static InvokeMediator createInvokeMediator(TransformationInfo information, CallTemplateMediator obj)
            throws JaxenException {

        InvokeMediator invokeMediator = new InvokeMediator();
        setCommonProperties(invokeMediator, obj);
        invokeMediator.setTargetTemplate(obj.getTargetTemplate());
        if (obj.getOnError() != null && obj.getOnError().getKeyValue() != null
                && !obj.getOnError().getKeyValue().isEmpty()) {
            invokeMediator.setErrorHandler(obj.getOnError().getKeyValue());
        }
        for (CallTemplateParameter param : obj.getTemplateParameters()) {
            String parameterName = "";
            if (param.getParameterName() != null && !param.getParameterName().isEmpty()) {
                parameterName = param.getParameterName();
            }
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
                    invokeMediator.getpName2ExpressionMap().put(parameterName, value);
                } else if (StringUtils.isBlank(xpathValue)) {
                    String xpathValueTemp = ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION;
                    SynapsePath paramExpression = getParamExpression(namespacedExpression, xpathValueTemp);
                    invokeMediator.getpName2ExpressionMap().put(parameterName, new Value(paramExpression));
                } else {
                    SynapsePath paramExpression = getParamExpression(namespacedExpression, xpathValue);
                    invokeMediator.getpName2ExpressionMap().put(parameterName, new Value(paramExpression));
                }
            } else {
                invokeMediator.getpName2ExpressionMap().put(parameterName, new Value(param.getParameterValue()));
            }
            
        }
        return invokeMediator;
    }

    /**
     * Gets the param expression based on json and xpath
     * 
     * @param namespacedExpression
     * @param xpathValue
     * @return
     * @throws JaxenException
     */

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

    /**
     * Adds the namespace to param
     * 
     * @param namespacedExpression
     * @param paramExpression
     * @throws JaxenException
     */
    private static SynapsePath addNamespaceToParam(NamespacedProperty namespacedExpression, SynapsePath paramExpression)
            throws JaxenException {
        for (Entry<String, String> entry : namespacedExpression.getNamespaces().entrySet()) {
            paramExpression.addNamespace(entry.getKey(), entry.getValue());
        }
        return paramExpression;
    }
}
