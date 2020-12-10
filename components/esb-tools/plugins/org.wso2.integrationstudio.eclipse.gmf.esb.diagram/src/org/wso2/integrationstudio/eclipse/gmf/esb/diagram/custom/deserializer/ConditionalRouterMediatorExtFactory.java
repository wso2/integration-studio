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

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.util.JavaUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.synapse.commons.evaluators.EvaluatorException;
import org.apache.synapse.commons.evaluators.config.EvaluatorFactoryFinder;
import org.apache.synapse.config.xml.ConditionalRouterMediatorFactory;
import org.apache.synapse.config.xml.TargetFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.mediators.filters.router.ConditionalRoute;
import org.apache.synapse.mediators.filters.router.ConditionalRouterMediator;

public class ConditionalRouterMediatorExtFactory extends ConditionalRouterMediatorFactory {
    
    private static ConditionalRouterMediatorExtFactory instance;
    
    private ConditionalRouterMediatorExtFactory() {
    }
    
    public static synchronized ConditionalRouterMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new ConditionalRouterMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new ConditionalRouterMediator();

        QName CONDITIONAL_ROUTER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "conditionalRouter");
        QName ROUTE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "conditionalRoute");
        QName CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "condition");
        QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");

        QName CONTINUE_AFTER_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "continueAfter");
        QName BREAK_ROUTE_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "breakRoute");
        QName ASYNCHRONOUS_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "asynchronous");

        processAuditStatus(mediator, omElement);

        if (omElement.getAttribute(CONTINUE_AFTER_ATTR) != null) {
            if (JavaUtils.isTrueExplicitly(omElement.getAttributeValue(CONTINUE_AFTER_ATTR).trim())) {
                ((ConditionalRouterMediator) mediator).setContinueAfter(true);
            } else {
                ((ConditionalRouterMediator) mediator).setContinueAfter(false);
            }
        }

        Iterator itr = omElement.getChildrenWithName(ROUTE_Q);
        while (itr.hasNext()) {
            OMElement routeElem = (OMElement) itr.next();
            ConditionalRoute conditionalRoute = new ConditionalRoute();

            if (routeElem.getAttribute(BREAK_ROUTE_ATTR) != null) {
                if (JavaUtils.isTrueExplicitly(routeElem.getAttributeValue(BREAK_ROUTE_ATTR).trim())) {

                    conditionalRoute.setBreakRoute(true);
                } else {

                    conditionalRoute.setBreakRoute(false);
                }
            }

            OMElement conditionElem = routeElem.getFirstChildWithName(CONDITION_Q);
            if (conditionElem != null) {

                try {
                    Evaluator evaluator = EvaluatorFactoryFinder.getInstance()
                            .getEvaluator(conditionElem.getFirstElement());
                    conditionalRoute.setEvaluator(evaluator);
                } catch (EvaluatorException ee) {
                    // ignore
                }
            }

            OMElement targetElem = routeElem.getFirstChildWithName(TARGET_Q);
            Target target = TargetFactory.createTarget(targetElem, null);
            if (JavaUtils.isTrueExplicitly(routeElem.getAttributeValue(ASYNCHRONOUS_ATTR))) {
                target.setAsynchronous(true);
            } else {
                target.setAsynchronous(false);
            }
            conditionalRoute.setTarget(target);
            ((ConditionalRouterMediator) mediator).addRoute(conditionalRoute);

        }
        addAllCommentChildrenToList(omElement, ((ConditionalRouterMediator) mediator).getCommentsList());

        return mediator;
    }

}
