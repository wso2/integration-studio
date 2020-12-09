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

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.mediators.builtin.LogMediator;

public class LogMediatorExtFactory extends LogMediatorFactory {
    
    private static LogMediatorExtFactory instance;
    
    private LogMediatorExtFactory() {
    }
    
    public static synchronized LogMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new LogMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new LogMediator();

        OMAttribute level = omElement.getAttribute(new QName("level"));
        OMAttribute category = omElement.getAttribute(new QName("category"));
        OMAttribute separator = omElement.getAttribute(new QName("separator"));

        processAuditStatus(mediator, omElement);

        if (level != null) {
            String levelstr = level.getAttributeValue();
            if ("simple".equals(levelstr)) {
                ((LogMediator) mediator).setLogLevel(LogMediator.SIMPLE);
            } else if ("headers".equals(levelstr)) {
                ((LogMediator) mediator).setLogLevel(LogMediator.HEADERS);
            } else if ("full".equals(levelstr)) {
                ((LogMediator) mediator).setLogLevel(LogMediator.FULL);
            } else if ("custom".equals(levelstr)) {
                ((LogMediator) mediator).setLogLevel(LogMediator.CUSTOM);
            } else {
                ((LogMediator) mediator).setLogLevel(LogMediator.CUSTOM);
            }
        }

        if (category != null) {
            String catstr = category.getAttributeValue().trim().toUpperCase();
            if ("INFO".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_INFO);
            } else if ("TRACE".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_TRACE);
            } else if ("DEBUG".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_DEBUG);
            } else if ("WARN".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_WARN);
            } else if ("ERROR".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_ERROR);
            } else if ("FATAL".equals(catstr)) {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_FATAL);
            } else {
                ((LogMediator) mediator).setCategory(LogMediator.CATEGORY_DEBUG);
            }
        }

        if (separator != null) {
            ((LogMediator) mediator).setSeparator(separator.getAttributeValue());
        }
        addAllCommentChildrenToList(omElement, ((LogMediator) mediator).getCommentsList());

        return mediator;
    }

}
