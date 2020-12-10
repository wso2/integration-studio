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

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator;
import org.wso2.carbon.mediator.fastXSLT.config.xml.FastXSLTMediatorFactory;

public class FastXSLTMediatorExtFactory extends FastXSLTMediatorFactory {
    
    private static FastXSLTMediatorExtFactory instance;
    
    private FastXSLTMediatorExtFactory() {
    }
    
    public static synchronized FastXSLTMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new FastXSLTMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new FastXSLTMediator();

        OMAttribute attXslt = omElement.getAttribute(ATT_KEY);

        if (attXslt != null) {
            ValueFactoryExtended keyFac = new ValueFactoryExtended();
            Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

            ((FastXSLTMediator) mediator).setXsltKey(generatedKey);
        }

        processAuditStatus(mediator, omElement);
        addAllCommentChildrenToList(omElement, ((FastXSLTMediator) mediator).getCommentsList());
        
        return mediator;
    }

}
