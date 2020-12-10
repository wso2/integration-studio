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

import java.util.Properties;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;

import javax.xml.namespace.QName;

public class DummyIndirectEndpointFactory extends DummyEndpointFactory {

    private static DummyIndirectEndpointFactory instance = new DummyIndirectEndpointFactory();

    public static DummyIndirectEndpointFactory getInstance() {
        return instance;
    }

    @Override
    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
        String ref = epConfig.getAttributeValue(new QName("key"));
        String name = epConfig.getAttributeValue(new QName("name"));
        if (name != null) {
            indirectEndpoint.setName(name);
        }
        indirectEndpoint.setKey(ref);

        // process the parameters
        processProperties(indirectEndpoint, epConfig);

        return indirectEndpoint;
    }

}
