/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.cloud.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.EndpointData;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Runtime;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * Utils class for JSON conversions
 * 
 */
public class JsonUtils {

    /**
     * Converts a list to JSON array
     * 
     * @param tags
     * @return
     */
    public static String getJsonArrayFromList(List<Map<String, String>> tags) {
        Gson gson = new Gson();
        Type type = List.class;
        return gson.toJson(tags, type);
    }

    /**
     * Convert JSON to application object
     * 
     * @param json
     * @return
     */
    public static Application getApplicationFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Application>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON to application list
     * 
     * @param json
     * @return
     */
    public static List<Application> getApplicationListFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Application>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON to endpoint data
     * 
     * @param json
     * @return
     */
    public static EndpointData getEndpointDataFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<EndpointData>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON to runtime data
     * 
     * @param response
     * @return
     */
    public static List<Runtime> getRuntimesFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<org.wso2.developerstudio.eclipse.esb.cloud.model.Runtime>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
