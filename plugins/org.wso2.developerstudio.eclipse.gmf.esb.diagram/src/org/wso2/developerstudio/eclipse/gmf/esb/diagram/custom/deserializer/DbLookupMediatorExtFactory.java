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
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.DBLookupMediatorFactory;
import org.apache.synapse.mediators.db.DBLookupMediator;

public class DbLookupMediatorExtFactory extends DBLookupMediatorFactory {
    
    private static DbLookupMediatorExtFactory instance;
    
    private DbLookupMediatorExtFactory() {
    }
    
    public static synchronized DbLookupMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new DbLookupMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new DBLookupMediator();
        processAuditStatus(mediator, omElement);
        buildDataSource(omElement, (DBLookupMediator) mediator);
        processStatements(omElement, (DBLookupMediator) mediator);
        addAllCommentChildrenToList(omElement, ((DBLookupMediator) mediator).getCommentsList());

        return mediator;
    }

}
