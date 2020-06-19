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
import org.wso2.carbon.identity.oauth.mediator.OAuthMediator;
import org.wso2.carbon.identity.oauth.mediator.config.xml.OAuthMediatorFactory;

public class OAuthServiceMediatorExtFactory extends OAuthMediatorFactory {

    private static final QName ELEMENT_OAUTH = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "oauthService");
    private static final QName ATTR_NAME_SERVICE_EPR = new QName("remoteServiceUrl");
    private static final QName ATTR_NAME_USERNAME = new QName("username");
    private static final QName ATTR_NAME_PASSWORD = new QName("password");
    
    private static OAuthServiceMediatorExtFactory instance;
    
    private OAuthServiceMediatorExtFactory() {
    }
    
    public static synchronized OAuthServiceMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new OAuthServiceMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        OAuthMediator mediator = null;
        OMAttribute remoteServiceUrl = null;
        OMAttribute username = null;
        OMAttribute password = null;

        mediator = new OAuthMediator();

        remoteServiceUrl = omElement.getAttribute(ATTR_NAME_SERVICE_EPR);
        if (remoteServiceUrl != null && remoteServiceUrl.getAttributeValue() != null) {
            mediator.setRemoteServiceUrl(remoteServiceUrl.getAttributeValue());
        }

        username = omElement.getAttribute(ATTR_NAME_USERNAME);
        if (username != null && username.getAttributeValue() != null) {
            mediator.setUsername(username.getAttributeValue());
        }

        password = omElement.getAttribute(ATTR_NAME_PASSWORD);
        if (password != null && password.getAttributeValue() != null) {
            mediator.setPassword(password.getAttributeValue());
        }

        return mediator;

    }

}
