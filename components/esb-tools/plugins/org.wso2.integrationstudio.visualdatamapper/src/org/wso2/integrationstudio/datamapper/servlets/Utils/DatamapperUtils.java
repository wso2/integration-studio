/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.integrationstudio.datamapper.servlets.Utils;

import org.apache.commons.io.IOUtils;
import org.apache.synapse.MessageContext;
import org.apache.synapse.commons.json.JsonUtil;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.wso2.carbon.mediator.datamapper.DataMapperMediator;
import org.wso2.carbon.mediator.datamapper.engine.core.mapper.MappingResource;
import org.wso2.carbon.mediator.datamapper.engine.utils.InputOutputDataType;

import java.io.InputStream;

/**
 * This class will create a dummy message context with input data, call the mediate method of
 * Datamapper mediator and return the results.
 * 
 * @author lahiru
 *
 */
public class DatamapperUtils {

    /**
     * Given the following inputs this method will call the mediate methos of Datamapper mediator and return the result.
     * 
     * @param inputType data type of the input.
     * @param outPutType data type of the output.
     * @param inputSchema inputSchema as an input stream.
     * @param outputSchema outputSchema as an input stream.
     * @param DMC datamapper config file as an input stream.
     * @param inputPayload input payload as a String.
     * @return result from Datamapper mediator as String.
     * @throws Exception Exception occurs while mediating.
     */
    public static String processDatamapper(String inputType, String outPutType, InputStream inputSchema,
            InputStream outputSchema, InputStream DMC, String inputPayload) throws Exception {
        DataMapperMediator datamapper = new DataMapperMediator();
        datamapper.setInputType(inputType);
        datamapper.setOutputType(outPutType);

        MappingResource mappingResource = new MappingResource(inputSchema, outputSchema, DMC, outPutType);
        datamapper.setMappingResource(mappingResource);

        MessageContext synCtx;
        if (inputType.equals(InputOutputDataType.JSON.toString())) {
            synCtx = new TestMessageContextBuilder().setRequireAxis2MessageContext(true)
                    .setJsonBodyFromString(inputPayload).addTextAroundBody().build();
        } else {
            synCtx = new TestMessageContextBuilder().setRequireAxis2MessageContext(true).setBodyFromString(inputPayload)
                    .addTextAroundBody().build();
        }
        boolean status = datamapper.mediate(synCtx);
        String result = "";
        if (status) {
            if (outPutType.equals(InputOutputDataType.JSON.toString())) {
                result = IOUtils
                        .toString(JsonUtil.getJsonPayload(((Axis2MessageContext) synCtx).getAxis2MessageContext()));
            } else {
                result = synCtx.getEnvelope().getBody().getFirstElement().toString();
            }
        } else {
            result = "Error occured while mediating";
        }
        return result;
    }
}
