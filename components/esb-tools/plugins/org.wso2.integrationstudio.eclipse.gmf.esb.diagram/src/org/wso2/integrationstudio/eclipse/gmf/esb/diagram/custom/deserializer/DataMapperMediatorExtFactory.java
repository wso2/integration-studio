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

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.mediators.Value;
import org.wso2.carbon.mediator.datamapper.DataMapperMediator;
import org.wso2.carbon.mediator.datamapper.config.xml.DataMapperMediatorConstants;
import org.wso2.carbon.mediator.datamapper.config.xml.DataMapperMediatorFactory;

public class DataMapperMediatorExtFactory extends DataMapperMediatorFactory {
    
    private static DataMapperMediatorExtFactory instance;
    
    private DataMapperMediatorExtFactory() {
    }
    
    public static synchronized DataMapperMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new DataMapperMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new DataMapperMediator();

        OMAttribute configKeyAttribute = omElement.getAttribute(new QName(DataMapperMediatorConstants.CONFIG));
        OMAttribute inputSchemaKeyAttribute = omElement
                .getAttribute(new QName(DataMapperMediatorConstants.INPUT_SCHEMA));
        OMAttribute outputSchemaKeyAttribute = omElement
                .getAttribute(new QName(DataMapperMediatorConstants.OUTPUT_SCHEMA));
        OMAttribute inputTypeAttribute = omElement.getAttribute(new QName(DataMapperMediatorConstants.INPUT_TYPE));
        OMAttribute outputTypeAttribute = omElement.getAttribute(new QName(DataMapperMediatorConstants.OUTPUT_TYPE));

        ValueFactory keyFac = new ValueFactory();

        if (configKeyAttribute != null) {
            Value configKeyValue = keyFac.createValue(configKeyAttribute.getLocalName(), omElement);
            ((DataMapperMediator) mediator).setMappingConfigurationKey(configKeyValue);
        }

        if (inputSchemaKeyAttribute != null) {
            Value inputSchemaKeyValue = keyFac.createValue(inputSchemaKeyAttribute.getLocalName(), omElement);
            ((DataMapperMediator) mediator).setInputSchemaKey(inputSchemaKeyValue);
        }

        if (outputSchemaKeyAttribute != null) {
            Value outputSchemaKeyValue = keyFac.createValue(outputSchemaKeyAttribute.getLocalName(), omElement);
            ((DataMapperMediator) mediator).setOutputSchemaKey(outputSchemaKeyValue);
        }

        if (inputTypeAttribute != null) {
            ((DataMapperMediator) mediator).setInputType(inputTypeAttribute.getAttributeValue());
        }

        if (outputTypeAttribute != null) {
            ((DataMapperMediator) mediator).setOutputType(outputTypeAttribute.getAttributeValue());
        }

        processAuditStatus(mediator, omElement);
        addAllCommentChildrenToList(omElement, ((DataMapperMediator) mediator).getCommentsList());

        return mediator;

    }

}
