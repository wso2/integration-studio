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

import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;

public class PropertyMediatorExtFactory extends PropertyMediatorFactory {
    
    private static PropertyMediatorExtFactory instance;

    PropertyMediatorExtFactory() {
    }
    
    public static synchronized PropertyMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new PropertyMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        QName ATT_SCOPE = new QName("scope");
        QName ATT_ACTION = new QName("action");
        QName ATT_TYPE = new QName("type");
        QName ATT_PATTERN = new QName("pattern");
        QName ATT_GROUP = new QName("group");

        Mediator mediator = new PropertyMediator();

        OMAttribute name = omElement.getAttribute(ATT_NAME);
        OMAttribute value = omElement.getAttribute(ATT_VALUE);
        OMAttribute expression = omElement.getAttribute(ATT_EXPRN);
        OMAttribute scope = omElement.getAttribute(ATT_SCOPE);
        OMAttribute action = omElement.getAttribute(ATT_ACTION);
        OMAttribute type = omElement.getAttribute(ATT_TYPE);
        OMAttribute pattern = omElement.getAttribute(ATT_PATTERN);
        OMAttribute group = omElement.getAttribute(ATT_GROUP);

        OMElement valueElement = omElement.getFirstElement();

        if (name != null) {
            ((PropertyMediator) mediator).setName(name.getAttributeValue());
        }

        String dataType = null;
        if (type != null) {
            dataType = type.getAttributeValue();
        }

        if (value != null) {
            ((PropertyMediator) mediator).setValue(value.getAttributeValue(), dataType);

        } else if (valueElement != null) {
            ((PropertyMediator) mediator).setValueElement(valueElement.cloneOMElement());

        } else if (expression != null) {
            try {
                ((PropertyMediator) mediator).setExpression(SynapsePathFactory.getSynapsePath(omElement, ATT_EXPRN),
                        dataType);
            } catch (JaxenException e) {
                ((PropertyMediator) mediator).setExpression(
                        SynapseXPathExt.createSynapsePath(omElement.getAttribute(ATT_EXPRN).getAttributeValue()));
            }
        }

        if (pattern != null) {
            ((PropertyMediator) mediator).setPattern(Pattern.compile(pattern.getAttributeValue()));
            if (group != null) {
                int groupValue = Integer.parseInt(group.getAttributeValue());
                if (groupValue >= 0) {
                    ((PropertyMediator) mediator).setGroup(groupValue);
                }
            }
        }

        if (action != null && "remove".equals(action.getAttributeValue())) {
            ((PropertyMediator) mediator).setAction(PropertyMediator.ACTION_REMOVE);
        }

        if (scope != null) {
            ((PropertyMediator) mediator).setScope(scope.getAttributeValue());
        }

        processAuditStatus(mediator, omElement);
        addAllCommentChildrenToList(omElement, ((PropertyMediator) mediator).getCommentsList());
        
        return mediator;
    }
}
