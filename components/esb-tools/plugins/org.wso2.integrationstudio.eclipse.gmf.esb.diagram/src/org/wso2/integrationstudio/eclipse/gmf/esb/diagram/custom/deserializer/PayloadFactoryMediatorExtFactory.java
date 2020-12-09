/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMText;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.SynapseJsonPathFactory;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.transform.Argument;
import org.apache.synapse.mediators.transform.PayloadFactoryMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;

public class PayloadFactoryMediatorExtFactory extends PayloadFactoryMediatorFactory {
    
    private static PayloadFactoryMediatorExtFactory instance;
    
    private PayloadFactoryMediatorExtFactory() {
    }
    
    public static synchronized PayloadFactoryMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new PayloadFactoryMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        QName PAYLOAD_FACTORY_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "payloadFactory");

        QName FORMAT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "format");
        QName ARGS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "args");
        QName ATT_LITERAL = new QName("literal");

        QName TYPE_Q = new QName("media-type");

        String JSON_TYPE = "json";
        String XML_TYPE = "xml";
        String TEXT_TYPE = "text";

        Mediator mediator = new PayloadFactoryMediator();

        processAuditStatus(mediator, omElement);
        String mediaTypeValue = omElement.getAttributeValue(TYPE_Q);

        if (mediaTypeValue != null) {
            ((PayloadFactoryMediator) mediator).setType(mediaTypeValue);
        } else {
            ((PayloadFactoryMediator) mediator).setType(XML_TYPE);
        }

        OMElement formatElem = omElement.getFirstChildWithName(FORMAT_Q);
        if (formatElem != null) {
            OMAttribute n = formatElem.getAttribute(ATT_KEY);
            if (n == null) {
                OMElement copy = formatElem.cloneOMElement();
                removeIndentations(copy);

                if (mediaTypeValue != null
                        && (mediaTypeValue.contains(JSON_TYPE) || mediaTypeValue.contains(TEXT_TYPE))) {
                    ((PayloadFactoryMediator) mediator).setFormat(copy.getText());
                } else {
                    ((PayloadFactoryMediator) mediator).setFormat(copy.getFirstElement().toString());
                }

            } else {
                ValueFactory keyFac = new ValueFactory();
                Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, formatElem);
                ((PayloadFactoryMediator) mediator).setFormatKey(generatedKey);
                ((PayloadFactoryMediator) mediator).setFormatDynamic(true);

            }
        }

        OMElement argumentsElem = omElement.getFirstChildWithName(ARGS_Q);

        if (argumentsElem != null) {

            Iterator itr = argumentsElem.getChildElements();

            while (itr.hasNext()) {
                Object argObj = itr.next();
                if (argObj instanceof OMElement) {
                    OMElement argElem = (OMElement) argObj;
                    Argument arg = new Argument();
                    String value;

                    boolean isLiteral = false;
                    String isLiteralString = argElem.getAttributeValue(ATT_LITERAL);
                    if (isLiteralString != null) {
                        isLiteral = Boolean.parseBoolean(isLiteralString);

                    }
                    arg.setLiteral(isLiteral);

                    if ((value = argElem.getAttributeValue(ATT_VALUE)) != null) {

                        arg.setValue(value);
                        arg.setExpression(null);
                        ((PayloadFactoryMediator) mediator).addPathArgument(arg);

                    } else if ((value = argElem.getAttributeValue(ATT_EXPRN)) != null) {

                        try {

                            String evaluator = argElem.getAttributeValue(new QName("evaluator"));
                            if (evaluator != null && evaluator.equals(JSON_TYPE)) {
                                if (value.startsWith("json-eval(")) {
                                    value = value.substring(10, value.length() - 1);
                                }
                                arg.setExpression(SynapseJsonPathFactory.getSynapseJsonPath(value));

                                arg.getExpression().setPathType(SynapsePath.JSON_PATH);
                                ((PayloadFactoryMediator) mediator).addPathArgument(arg);
                            } else {
                                SynapseXPath sxp = null;
                                if (value.trim().length() > 0) {
                                    sxp = SynapseXPathFactory.getSynapseXPath(argElem, ATT_EXPRN);
                                } else {
                                    sxp = (SynapseXPath) SynapseXPathExt.createSynapsePath("");
                                }
                                sxp.setForceDisableStreamXpath(Boolean.TRUE);
                                arg.setExpression(sxp);
                                arg.getExpression().setPathType(SynapsePath.X_PATH);
                                ((PayloadFactoryMediator) mediator).addPathArgument(arg);
                            }
                        } catch (JaxenException e) {
                            // ignore
                        }
                    }
                }
            }

        }
        addAllCommentChildrenToList(omElement, ((PayloadFactoryMediator) mediator).getCommentsList());

        return mediator;
    }

    private void removeIndentations(OMElement element) {
        List<OMText> removables = new ArrayList<OMText>();
        removeIndentations(element, removables);
        for (OMText node : removables) {
            node.detach();
        }
    }

    private void removeIndentations(OMElement element, List<OMText> removables) {
        Iterator children = element.getChildren();
        while (children.hasNext()) {
            Object next = children.next();
            if (next instanceof OMText) {
                OMText text = (OMText) next;
                if (text.getText().trim().equals("")) {
                    removables.add(text);
                }
            } else if (next instanceof OMElement) {
                removeIndentations((OMElement) next, removables);
            }
        }
    }

}
