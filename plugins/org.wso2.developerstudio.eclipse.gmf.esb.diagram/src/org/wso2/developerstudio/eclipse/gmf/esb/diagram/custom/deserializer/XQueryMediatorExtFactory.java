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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.config.xml.OMElementUtils;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.xquery.MediatorBaseVariable;
import org.apache.synapse.mediators.xquery.MediatorCustomVariable;
import org.apache.synapse.mediators.xquery.MediatorVariable;
import org.apache.synapse.mediators.xquery.XQueryMediator;
import org.apache.synapse.mediators.xquery.XQueryMediatorFactory;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;

import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.XdmNodeKind;

public class XQueryMediatorExtFactory extends XQueryMediatorFactory {
    
    private static XQueryMediatorExtFactory instance;
    
    private XQueryMediatorExtFactory() {
    }
    
    public static synchronized XQueryMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new XQueryMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new XQueryMediator();

        QName ATT_NAME_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "name");
        QName ATT_VALUE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "value");
        QName ATT_EXPR_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "expression");
        QName ATT_KEY_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "key");
        QName ATT_TYPE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "type");

        OMAttribute xqueryKey = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
        OMAttribute attrTarget = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "target"));

        if (xqueryKey != null) {
            ValueFactoryExtended keyFac = new ValueFactoryExtended();
            Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

            if (generatedKey != null) {
                ((XQueryMediator) mediator).setQueryKey(generatedKey);
            }
        }

        if (attrTarget != null) {
            String targetValue = attrTarget.getAttributeValue();
            if (targetValue != null && !"".equals(targetValue)) {
                try {
                    ((XQueryMediator) mediator).setTarget(SynapseXPathFactory.getSynapseXPath(omElement, ATT_TARGET));
                } catch (JaxenException e) {
                    // ignore
                }
            }
        }

        processAuditStatus(mediator, omElement);
        OMElement dataSource = omElement
                .getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "dataSource"));
        if (dataSource != null) {
            ((XQueryMediator) mediator)
                    .addAllDataSourceProperties(MediatorPropertyFactory.getMediatorProperties(dataSource));
        }

        Iterator it = omElement.getChildrenWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "variable"));
        while (it.hasNext()) {
            OMElement variableOM = (OMElement) it.next();
            String name = variableOM.getAttributeValue(ATT_NAME_Q);
            if (name != null && !"".equals(name)) {
                String type = variableOM.getAttributeValue(ATT_TYPE_Q);
                if (type != null && !"".equals(type)) {
                    String value = variableOM.getAttributeValue(ATT_VALUE_Q);
                    MediatorVariable variable;
                    if (value != null && !"".equals(value)) {
                        variable = new MediatorBaseVariable(new QName(name.trim()));
                        variable.setValue(value.trim());
                    } else {
                        String key = variableOM.getAttributeValue(ATT_KEY_Q);
                        String expr = variableOM.getAttributeValue(ATT_EXPR_Q);
                        variable = new MediatorCustomVariable(new QName(name.trim()));
                        if (key != null) {
                            ((MediatorCustomVariable) variable).setRegKey(key.trim());
                        }
                        if (expr != null && !"".equals(expr)) {
                            try {
                                SynapseXPath xpath = new SynapseXPath(expr);
                                Log log = LogFactory.getLog(XQueryMediatorFactory.class);
                                OMElementUtils.addNameSpaces(xpath, variableOM, log);
                                ((MediatorCustomVariable) variable).setExpression(xpath);

                            } catch (JaxenException e) {
                                // ignore
                            }
                        }
                    }
                    if ("INT".equals(type.trim())) {
                        variable.setType(ItemType.INT);
                    } else if ("INTEGER".equals(type.trim())) {
                        variable.setType(ItemType.INTEGER);
                    } else if ("BOOLEAN".equals(type.trim())) {
                        variable.setType(ItemType.BOOLEAN);
                    } else if ("BYTE".equals(type.trim())) {
                        variable.setType(ItemType.BYTE);
                    } else if ("DOUBLE".equals(type.trim())) {
                        variable.setType(ItemType.DOUBLE);
                    } else if ("SHORT".equals(type.trim())) {
                        variable.setType(ItemType.SHORT);
                    } else if ("LONG".equals(type.trim())) {
                        variable.setType(ItemType.LONG);
                    } else if ("FLOAT".equals(type.trim())) {
                        variable.setType(ItemType.FLOAT);
                    } else if ("STRING".equals(type.trim())) {
                        variable.setType(ItemType.STRING);
                    } else if ("DOCUMENT".equals(type.trim())) {
                        variable.setNodeKind(XdmNodeKind.DOCUMENT);
                    } else if ("ELEMENT".equals(type.trim())) {
                        variable.setNodeKind(XdmNodeKind.ELEMENT);
                    } else {
                        variable.setType(ItemType.STRING);
                    }
                    ((XQueryMediator) mediator).addVariable(variable);
                }
            }
        }
        addAllCommentChildrenToList(omElement, ((XQueryMediator) mediator).getCommentsList());

        return mediator;
    }

}
