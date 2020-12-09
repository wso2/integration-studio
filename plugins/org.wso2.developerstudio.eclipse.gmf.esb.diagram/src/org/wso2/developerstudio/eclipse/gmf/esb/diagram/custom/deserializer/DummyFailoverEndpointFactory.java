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

import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.axis2.util.JavaUtils;

import javax.xml.namespace.QName;
import java.util.Properties;

public class DummyFailoverEndpointFactory extends DummyEndpointFactory {

    private static DummyFailoverEndpointFactory instance = new DummyFailoverEndpointFactory();

    private DummyFailoverEndpointFactory() {
    }

    public static DummyFailoverEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        OMElement failoverElement = epConfig
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "failover"));
        if (failoverElement != null) {

            FailoverEndpoint failoverEndpoint = new FailoverEndpoint();

            String name = epConfig.getAttributeValue(new QName("name"));
            if (name != null) {
                failoverEndpoint.setName(name);
            }

            failoverEndpoint.setChildren(getEndpoints(failoverElement, failoverEndpoint, properties));

            String dynamicFO = failoverElement.getAttributeValue(new QName("dynamic"));
            if (dynamicFO != null && JavaUtils.isFalseExplicitly(dynamicFO)) {
                failoverEndpoint.setDynamic(false);
            }

            String buildMessageAtt = failoverElement.getAttributeValue(new QName(XMLConfigConstants.BUILD_MESSAGE));
            if (buildMessageAtt != null) {
                failoverEndpoint.setBuildMessageAttAvailable(true);
                if (JavaUtils.isTrueExplicitly(buildMessageAtt)) {
                    failoverEndpoint.setBuildMessageAtt(true);
                }
            }

            processProperties(failoverEndpoint, epConfig);

            return failoverEndpoint;
        }
        return null;
    }
}
