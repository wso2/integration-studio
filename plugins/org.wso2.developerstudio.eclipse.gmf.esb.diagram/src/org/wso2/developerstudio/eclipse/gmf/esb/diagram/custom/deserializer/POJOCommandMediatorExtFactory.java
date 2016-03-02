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

import java.util.Iterator;
import java.util.Properties;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.POJOCommandMediatorFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.POJOCommandMediatorExt;

public class POJOCommandMediatorExtFactory extends POJOCommandMediatorFactory {

	public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        // Class name of the Command object should be present
        OMAttribute name = elem.getAttribute(ATT_NAME);
        if (name == null) {
            String msg = "The name of the actual POJO command implementation class" +
                    " is a required attribute";
            throw new SynapseException(msg);
        }

        // load the class for the command object
        POJOCommandMediatorExt pojoMediator = new POJOCommandMediatorExt(name.getAttributeValue());

        // setting the properties to the command. these properties will be instantiated
        // at the mediation time
        for (Iterator it = elem.getChildElements(); it.hasNext();) {
            OMElement child = (OMElement) it.next();
            if("property".equals(child.getLocalName())) {

                OMAttribute nameAttr = child.getAttribute(ATT_NAME);
                if (nameAttr != null && nameAttr.getAttributeValue() != null
                    && !"".equals(nameAttr.getAttributeValue())) {

                    handlePropertyAction(nameAttr.getAttributeValue(), child, pojoMediator);
                } else {
                    handleException("A POJO command mediator " +
                        "property must specify the name attribute");
                }
            }
        }

        return pojoMediator;
    }
	
    private void handlePropertyAction(String name, OMElement propElem, POJOCommandMediatorExt m) {

        OMAttribute valueAttr   = propElem.getAttribute(ATT_VALUE);
        OMAttribute exprAttr    = propElem.getAttribute(ATT_EXPRN);
        OMAttribute ctxNameAttr = propElem.getAttribute(ATT_CTXNAME);
        OMAttribute actionAttr  = propElem.getAttribute(ATT_ACTION);

        SynapseXPath xpath = null;
        try {
            if (exprAttr != null) {
                xpath = SynapseXPathFactory.getSynapseXPath(propElem, ATT_EXPRN);
            }
        } catch (JaxenException e) {
            handleException("Error in building the expression as an SynapseXPath" + e);
        }

        // if there is a value attribute there is no action (action is implied as read value)
        if (valueAttr != null) {
            String value = valueAttr.getAttributeValue();
            // all other three attributes can not co-exists
            if (exprAttr != null && ctxNameAttr != null) {
                handleException("Command properties can not contain all three 'value', " +
                    "'expression' and 'context-name' attributes. Only one or " +
                    "combination of two can be there.");
            } else {
                m.addStaticSetterProperty(name, value);
                if (exprAttr != null) {
                    // action ==> ReadValueAndUpdateMesssage
                    m.addMessageGetterProperty(name, xpath);
                } else if (ctxNameAttr != null) {
                    // action ==> ReadValueAndUpdateContext
                    m.addContextGetterProperty(name, ctxNameAttr.getAttributeValue());
                } // else the action ==> ReadValue
            }
        } else if (propElem.getFirstElement() != null) {
            // all other two attributes can not co-exists
            if (exprAttr != null && ctxNameAttr != null) {
                handleException("Command properties can not contain all the " +
                    "'expression' and 'context-name' attributes with a child. Only one " +
                    "attribute of those can co-exists with a child");
            } else {
                m.addStaticSetterProperty(name, propElem.getFirstElement());
                if (exprAttr != null) {
                    // action ==> ReadValueAndUpdateMesssage
                    m.addMessageGetterProperty(name, xpath);
                } else if (ctxNameAttr != null) {
                    // action ==> ReadValueAndUpdateContext
                    m.addContextGetterProperty(name, ctxNameAttr.getAttributeValue());
                } // else the action ==> ReadValue
            }
        } else {
            // if both context-name and expression is there
            if (exprAttr != null && ctxNameAttr != null) {
                if (actionAttr != null && actionAttr.getAttributeValue() != null) {
                    String action = actionAttr.getAttributeValue();
                    if (RM_ACTION.equals(action) || UC_ACTION.equals(action)) {
                        // action ==> ReadMessageAndUpdateContext
                        m.addMessageSetterProperty(name, xpath);
                        m.addContextGetterProperty(name, ctxNameAttr.getAttributeValue());
                    } else if (RC_ACTION.equals(action) || UM_ACTION.equals(action)) {
                        // action ==> ReadContextAndUpdateMessage
                        m.addContextSetterProperty(name, ctxNameAttr.getAttributeValue());
                        m.addMessageGetterProperty(name, xpath);
                    } else {
                        handleException("Invalid action for " +
                            "the command property with the name " + name);
                    }
                } else {
                    handleException("Action attribute " +
                        "is required for the command property with name " + name);
                }
            } else {
                // only one of expression or context-name is present
                if (actionAttr != null && actionAttr.getAttributeValue() != null) {
                    String action = actionAttr.getAttributeValue();
                    if (exprAttr != null) {
                        if (RM_ACTION.equals(action)) {
                            // action ==> ReadMessage
                            m.addMessageSetterProperty(name, xpath);
                        } else if (UM_ACTION.equals(action)) {
                            // action ==> UpdateMessage
                            m.addMessageGetterProperty(name, xpath);
                        } else if (RAUM_ACTION.equals(action)) {
                            // action ==> ReadAndUpdateMessage
                            m.addMessageSetterProperty(name, xpath);
                            m.addMessageGetterProperty(name, xpath);
                        } else {
                            handleException("Invalid action for " +
                                "the command property with the name " + name);
                        }
                    } else if (ctxNameAttr != null) {
                        String ctxName = ctxNameAttr.getAttributeValue();
                        if (RC_ACTION.equals(action)) {
                            // action ==> ReadContext
                            m.addContextSetterProperty(name, ctxName);
                        } else if (UC_ACTION.equals(action)) {
                            // action ==> UpdateContext
                            m.addContextGetterProperty(name, ctxName);
                        } else if (RAUC_ACTION.equals(action)) {
                            // action ==> ReadAndUpdateContext
                            m.addContextSetterProperty(name, ctxName);
                            m.addContextGetterProperty(name, ctxName);
                        } else {
                            handleException("Invalid action for " +
                                "the command property with the name " + name);
                        }
                    } else {
                        handleException("Unrecognized command property with the name " + name);
                    }
                } else {
                    // action ==> ReadAndUpdateMessage/Context
                    if (exprAttr != null) {
                        m.addMessageSetterProperty(name, xpath);
                        m.addMessageGetterProperty(name, xpath);
                    } else if (ctxNameAttr != null) {
                        String ctxName = ctxNameAttr.getAttributeValue();
                        m.addContextSetterProperty(name, ctxName);
                        m.addContextGetterProperty(name, ctxName);
                    } else {
                        handleException("Unrecognized command property with the name " + name);
                    }
                }
            }
        }
    }
}
