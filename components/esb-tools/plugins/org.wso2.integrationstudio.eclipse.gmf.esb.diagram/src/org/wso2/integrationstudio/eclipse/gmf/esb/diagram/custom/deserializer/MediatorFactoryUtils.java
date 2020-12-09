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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.MediatorFactory;
import org.apache.synapse.config.xml.MediatorFactoryFinder;

public class MediatorFactoryUtils {
    private static MediatorFactoryFinder mediatorFactoryFinder = null;
    private static DummyMediatorFactoryFinder dummyMediatorFactoryFinder = null;

    static {
        mediatorFactoryFinder = MediatorFactoryFinder.getInstance();
        dummyMediatorFactoryFinder = DummyMediatorFactoryFinder.getInstance();
    }

    /* custom mediator factories */
    @SuppressWarnings("rawtypes")
    private static final Class[] mediatorFactories = { ClassMediatorExtFactory.class,
            POJOCommandMediatorExtFactory.class, BuilderMediatorExtFactory.class, RuleMediatorExtFactory.class,
            EJBMediatorExtFactory.class, BeanMediatorExtFactory.class, BamMediatorExtFactory.class,
            CalloutMediatorExtFactory.class, EntitlementMediatorExtFactory.class,
            CloudConnectorOperationExtFactory.class, CacheMediatorExtFactory.class };

    public static synchronized void registerFactories() {
        @SuppressWarnings("rawtypes")
        Map<QName, Class> factoryMap = mediatorFactoryFinder.getFactoryMap();
        Map<QName, Class> dummyFactoryMap = dummyMediatorFactoryFinder.getFactoryMap();
        for (@SuppressWarnings("rawtypes")
        Class c : mediatorFactories) {
            try {
                MediatorFactory factory = (MediatorFactory) c.newInstance();
                if (factory instanceof CloudConnectorOperationExtFactory) {
                    List<QName> tagQNameList = ((CloudConnectorOperationExtFactory) factory).getTagQNameList();
                    for (int i = 0; i < tagQNameList.size(); ++i) {
                        factoryMap.put(tagQNameList.get(i), c);
                        dummyFactoryMap.put(tagQNameList.get(i), c);
                    }
                } else {
                    QName tagQName = factory.getTagQName();
                    factoryMap.put(tagQName, c);
                    dummyFactoryMap.put(tagQName, c);
                }
            } catch (Exception e) {
                throw new SynapseException("Error instantiating " + c.getName(), e);
            }
        }
    }

    public static synchronized void registerConnectorFactories() {
        Map<QName, Class> factoryMap = mediatorFactoryFinder.getFactoryMap();
        Map<QName, Class> dummyFactoryMap = dummyMediatorFactoryFinder.getFactoryMap();
        try {
            List<QName> tagQNameList = (CloudConnectorOperationExtFactory.class.newInstance()).getTagQNameList();
            for (QName tag : tagQNameList) {
                factoryMap.put(tag, CloudConnectorOperationExtFactory.class);
                dummyFactoryMap.put(tag, CloudConnectorOperationExtFactory.class);
            }

        } catch (Exception e) {
            throw new SynapseException("Error instantiating CloudConnectorOperationExtFactory.", e);
        }
    }

}
