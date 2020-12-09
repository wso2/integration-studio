/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.MessageStoreFactory;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.message.store.MessageStore;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageStore;

/**
 * Create an instance of the given Dummy Message Store, and sets properties on it.
 *
 */
public class DummyMessageStoreFactory {

    private static final Log log = LogFactory.getLog(MessageStoreFactory.class);

    public static final QName CLASS_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "class");
    public static final QName NAME_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "name");
    public static final QName SEQUENCE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "sequence");
    public static final QName EXPRESSION_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "expression");

    public static final QName PARAMETER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "parameter");
    private static final QName DESCRIPTION_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "description");

    public static MessageStore createMessageStore(OMElement elem, Properties properties) {

        OMAttribute clss = elem.getAttribute(CLASS_Q);
        MessageStore messageStore;
        if (clss != null) {
            messageStore = new DummyMessageStore();
            ((DummyMessageStore) messageStore).setClassName(clss.getAttributeValue());
        } else {
            messageStore = new InMemoryStore();
        }

        OMAttribute nameAtt = elem.getAttribute(NAME_Q);

        if (nameAtt != null) {
            messageStore.setName(nameAtt.getAttributeValue());
        } else {
            handleException("Message Store name not specified");
        }

        OMElement descriptionElem = elem.getFirstChildWithName(DESCRIPTION_Q);
        if (descriptionElem != null) {
            messageStore.setDescription(descriptionElem.getText());
        }

        messageStore.setParameters(getParameters(elem));

        return messageStore;
    }

    private static Map<String, Object> getParameters(OMElement elem) {
        Map<String, Object> parameters = null;
        try {
            Iterator params = elem.getChildrenWithName(PARAMETER_Q);
            parameters = new HashMap<>();
            while (params.hasNext()) {
                Object o = params.next();
                if (o instanceof OMElement) {
                    OMElement prop = (OMElement) o;
                    OMAttribute paramName = prop.getAttribute(NAME_Q);
                    OMAttribute expression = prop.getAttribute(EXPRESSION_Q);
                    String paramValue = prop.getText();
                    if (expression != null) {
                        SynapsePath xPathExpression = SynapsePathFactory.getSynapsePath(prop, EXPRESSION_Q);
                        registerParameter(parameters, paramName, xPathExpression);
                    } else {
                        registerParameter(parameters, paramName, paramValue);
                    }
                }
            }
        } catch (JaxenException e) {
            throw new SynapseException("Error occurred while extracting the parameters", e);
        }
        return parameters;
    }

    /**
     * Register the extracted parameter in the list.
     *
     * @param parameters
     *            the list of parameters which should be registered.
     * @param paramName
     *            the name of the parameter.
     * @param paramValue
     *            the value of the parameter.
     * @param <T>
     *            the type of the parameter.
     */
    private static <T> void registerParameter(Map<String, Object> parameters, OMAttribute paramName, T paramValue) {
        if (paramName != null && paramValue != null) {
            parameters.put(paramName.getAttributeValue(), paramValue);
        } else {
            handleException("Invalid MessageStore parameter - Parameter must have a name ");
        }
    }

    private static void handleException(String msg) {
        log.error(msg);
        throw new SynapseException(msg);
    }

}
