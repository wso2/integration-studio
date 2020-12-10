 /*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.JSONTransformMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.builtin.JSONTransformMediator;

public class JsonTransformMediatorExtFactory extends JSONTransformMediatorFactory {

    private static final QName ATT_SCHEMA = new QName("schema");

    private static JsonTransformMediatorExtFactory instance;

    private JsonTransformMediatorExtFactory() {

    }

    public static JsonTransformMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new JsonTransformMediatorExtFactory();
        }
        return instance;
    }

    @Override
    protected Mediator createSpecificMediator(OMElement omElement, Properties properties) {
        JSONTransformMediator JSONTransformMediator = new JSONTransformMediator();
        processAuditStatus(JSONTransformMediator, omElement);
        OMAttribute schema = omElement.getAttribute(ATT_SCHEMA);
        if (schema != null) {
            // ValueFactory for creating dynamic or static Value
            ValueFactory keyFac = new ValueFactory();
            // create dynamic or static key based on OMElement
            Value generatedKey = keyFac.createValue("schema", omElement);
            JSONTransformMediator.setSchemaKey(generatedKey);
        }
        List<MediatorProperty> mediatorPropertyList = MediatorPropertyExtFactory.getMediatorProperties(omElement);
        if (!mediatorPropertyList.isEmpty()) {
            JSONTransformMediator.addAllProperties(mediatorPropertyList);
        }
        addAllCommentChildrenToList(omElement, JSONTransformMediator.getCommentsList());
        return JSONTransformMediator;
    }
}
