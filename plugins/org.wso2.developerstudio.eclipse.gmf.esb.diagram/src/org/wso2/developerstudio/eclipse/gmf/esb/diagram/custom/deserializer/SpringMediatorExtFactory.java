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

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.spring.SpringMediator;
import org.apache.synapse.mediators.spring.SpringMediatorFactory;

public class SpringMediatorExtFactory extends SpringMediatorFactory {
    
    private static SpringMediatorExtFactory instance;
    
    private SpringMediatorExtFactory() {
    }
    
    public static synchronized SpringMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new SpringMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new SpringMediator();
        OMAttribute bean = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "bean"));
        OMAttribute key = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));

        processAuditStatus(mediator, omElement);
        ((SpringMediator) mediator).setBeanName(bean.getAttributeValue());
        ((SpringMediator) mediator).setConfigKey(key.getAttributeValue());
        addAllCommentChildrenToList(omElement, ((SpringMediator) mediator).getCommentsList());

        return mediator;
    }

}
