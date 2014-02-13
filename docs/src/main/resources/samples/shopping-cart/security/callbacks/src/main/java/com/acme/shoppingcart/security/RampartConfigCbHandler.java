/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package com.acme.shoppingcart.security;

import org.apache.rampart.RampartConfigCallbackHandler;
import org.apache.rampart.policy.model.CryptoConfig;
import org.apache.rampart.policy.model.RampartConfig;

import java.util.Properties;

public class RampartConfigCbHandler implements RampartConfigCallbackHandler {
    public void update(RampartConfig rampartConfig) {
        Properties merlinProp = new Properties();
        merlinProp.put("org.apache.ws.security.crypto.merlin.keystore.type", "JKS");
        merlinProp.put("org.apache.ws.security.crypto.merlin.file", "resources/security/wso2carbon.jks");
        merlinProp.put("org.apache.ws.security.crypto.merlin.keystore.password", "wso2carbon");

        CryptoConfig sigCryptoConfig = new CryptoConfig();
        sigCryptoConfig.setProvider("org.apache.ws.security.components.crypto.Merlin");
        sigCryptoConfig.setProp(merlinProp);

        CryptoConfig encCryptoConfig = new CryptoConfig();
        encCryptoConfig.setProvider("org.apache.ws.security.components.crypto.Merlin");
        encCryptoConfig.setProp(merlinProp);

        rampartConfig.setUser("admin");
        rampartConfig.setEncryptionUser("wso2carbon");
        rampartConfig.setUserCertAlias("wso2carbon");
        rampartConfig.setPwCbClass("com.acme.shoppingcart.security.pwcb.PWCBHandler");
        rampartConfig.setEncrCryptoConfig(encCryptoConfig);
        rampartConfig.setSigCryptoConfig(sigCryptoConfig);
    }
}
