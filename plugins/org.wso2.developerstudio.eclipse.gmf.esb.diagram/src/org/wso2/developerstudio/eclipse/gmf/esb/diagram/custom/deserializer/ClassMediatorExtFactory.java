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

import java.util.Properties;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.config.xml.ClassMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;

public class ClassMediatorExtFactory extends ClassMediatorFactory {

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        OMAttribute name = elem.getAttribute(ATT_NAME);

        ClassMediatorExt classMediator;
        if (name != null) {
            classMediator = new ClassMediatorExt(name.getAttributeValue());
        } else {
            classMediator = new ClassMediatorExt("sample-class-mediator");
        }

        classMediator.addAllProperties(MediatorPropertyFactory.getMediatorProperties(elem));
        processAuditStatus(classMediator, elem);

        return classMediator;
    }
}
