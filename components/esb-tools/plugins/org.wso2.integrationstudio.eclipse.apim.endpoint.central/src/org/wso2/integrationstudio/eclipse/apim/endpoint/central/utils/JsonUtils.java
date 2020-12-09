/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.integrationstudio.eclipse.apim.endpoint.central.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.APIArtifact;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.APIImportPayload;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.CTLAPI;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.CTLEnvironment;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.LoginPayload;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.ProjectData;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.Registry;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.RegistryEntry;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.model.UserSession;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * This class converts JSON to java objects and vice versa.
 */
public class JsonUtils {
    
    /**
     * Converts Registry object to JSON.
     * 
     * @param registry registry object
     * @return
     */
    public static String getJsonFromRegistry(Registry registry) {
        Gson gson = new Gson();
        Type type = new TypeToken<Registry>() {
        }.getType();
        return gson.toJson(registry, type);
    }
    
    /**
     * Converts UserSession object to JSON.
     * 
     * @param userSession userSession object
     * @return
     */
    public static String getJsonFromUserSession(UserSession userSession) {
        Gson gson = new Gson();
        Type type = new TypeToken<UserSession>() {
        }.getType();
        return gson.toJson(userSession, type);
    }
    
    /**
     * Converts RegistryEntry object to JSON.
     * 
     * @param registryEntry RegistryEntry object
     * @return
     */
    public static String getJsonFromRegistryEntry(RegistryEntry registryEntry) {
        Gson gson = new Gson();
        Type type = new TypeToken<RegistryEntry>() {
        }.getType();
        return gson.toJson(registryEntry, type);
    }
    
    /**
     * Converts RegistryEntry list object to JSON.
     * 
     * @param list RegistryEntry list
     * @return json
     */
    public static String getJsonArrayFromRegistryEntry(List<RegistryEntry> list) {
        Gson gson = new Gson();
        Type type = List.class;
        return gson.toJson(list, type);
    }
    
    /**
     * Converts ProjectData list object to JSON.
     * 
     * @param list ProjectData list
     * @return json
     */
    public static String getJsonArrayFromProjectList(List<ProjectData> list) {
        Gson gson = new Gson();
        Type type = List.class;
        return gson.toJson(list, type);
    }
    
    /**
     * Converts a map to JSON object.
     * 
     * @param map
     * @return json
     */
    public static String getJsonFromMap(Map<String, Object> map) {
        Gson gson = new Gson();
        Type type = Map.class;
        return gson.toJson(map, type);
    }
    
    /**
     * Convert JSON to Registry object.
     * 
     * @param json
     * @return registry object
     */
    public static Registry getRegistryFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Registry>() {
        }.getType();
        return gson.fromJson(json, type);
    }
    
    /**
     * Convert JSON to APIArtifact object.
     * 
     * @param json
     * @return APIArtifact object
     */
    public static APIArtifact getAPIArtifactFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<APIArtifact>() {
        }.getType();
        return gson.fromJson(json, type);
    }
    
    /**
     * Convert JSON to LoginPayload object.
     * 
     * @param json
     * @return LoginPayload object
     */
    public static LoginPayload getLoginPayloadFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<LoginPayload>() {
        }.getType();
        return gson.fromJson(json, type);
    }
    
    /**
     * Convert JSON to APIImportPayload object.
     * 
     * @param json
     * @return APIImportPayload object
     */
    public static APIImportPayload getAPIImportPayloadFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<APIImportPayload>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON to Registry list.
     * 
     * @param json
     * @return Registry list
     */
    public static List<Registry> getRegistryListFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Registry>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
    
    /**
     * Convert JSON to RegistryEntry object.
     * 
     * @param json
     * @return RegistryEntry object
     */
    public static RegistryEntry getRegistryEntryFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<RegistryEntry>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON to RegistryEntry list.
     * 
     * @param json
     * @return RegistryEntry list
     */
    public static List<RegistryEntry> getRegistryEntryListFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<RegistryEntry>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Convert JSON list to CTLEnvironment list.
     * 
     * @param json
     * @return CTLEnvironment list
     */
    public static List<CTLEnvironment> getCTLEnvironmentListFromJson(List<String> jsonList) {
        List<CTLEnvironment> environments = new ArrayList<>();
        for (String json : jsonList) {
            Gson gson = new Gson();
            Type type = new TypeToken<CTLEnvironment>() {
            }.getType();
            environments.add(gson.fromJson(json, type));
        }
        return environments;
    }

    /**
     * Convert JSON list to CTLAPI list.
     * 
     * @param json
     * @return CTLEnvironment list
     */
    public static List<CTLAPI> getCTLAPIListFromJson(List<String> jsonList) {
        List<CTLAPI> apis = new ArrayList<>();
        for (String json : jsonList) {
            Gson gson = new Gson();
            Type type = new TypeToken<CTLAPI>() {
            }.getType();
            apis.add(gson.fromJson(json, type));
        }
        return apis;
    }
}
