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
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.InvokeMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.template.InvokeMediator;

public class CallTemplateMediatorExtFactory extends InvokeMediatorFactory {
    
    private static CallTemplateMediatorExtFactory instance;
    
    private CallTemplateMediatorExtFactory() {
    }
    
    public static synchronized CallTemplateMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new CallTemplateMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        InvokeMediator mediator = new InvokeMediator();

        processAuditStatus(mediator, omElement);
        OMAttribute targetTemplateAttr = omElement.getAttribute(ATT_TARGET);
        if (targetTemplateAttr != null) {
            ((InvokeMediator) mediator).setTargetTemplate(targetTemplateAttr.getAttributeValue());
            buildParameters(omElement, (InvokeMediator) mediator);
        }
        addAllCommentChildrenToList(omElement, mediator.getCommentsList());

        return mediator;
    }

    private void buildParameters(OMElement elem, InvokeMediator invoker) {
        Iterator subElements = elem.getChildElements();
        while (subElements.hasNext()) {
            OMElement child = (OMElement) subElements.next();
            if (child.getQName().equals(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "with-param"))) {
                OMAttribute paramNameAttr = child.getAttribute(ATT_NAME);
                Value paramValue = new ValueFactoryExtended().createValue("value", child);
                if (paramNameAttr != null) {
                    invoker.addExpressionForParamName(paramNameAttr.getAttributeValue(), paramValue);
                } else {
                    invoker.addExpressionForParamName("", paramValue);
                }
            }
        }
    }
}
