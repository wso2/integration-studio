/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.mediators.builtin.PropertyGroupMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;

public class PropertyGroupMediatorExtFactory extends PropertyMediatorFactory {

    private static PropertyGroupMediatorExtFactory instance;

    PropertyGroupMediatorExtFactory() {
    }

    public static synchronized PropertyGroupMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new PropertyGroupMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {
        PropertyGroupMediator propertyGroupMediator = new PropertyGroupMediator();
        PropertyMediatorExtFactory propertyMediatorExtFactory = new PropertyMediatorExtFactory();
        List<PropertyMediator> propertyGroupList = new ArrayList<>();
        Iterator propertyGroupIterator = omElement.getChildrenWithName(PROP_Q);

        while (propertyGroupIterator.hasNext()) {
            OMElement propertyElement = (OMElement) propertyGroupIterator.next();
            Mediator propertyMediator = propertyMediatorExtFactory.createSpecificMediator(propertyElement);
            propertyGroupList.add((PropertyMediator) propertyMediator);
        }
        propertyGroupMediator.setPropGroupList(propertyGroupList);
        return propertyGroupMediator;
    }
}
