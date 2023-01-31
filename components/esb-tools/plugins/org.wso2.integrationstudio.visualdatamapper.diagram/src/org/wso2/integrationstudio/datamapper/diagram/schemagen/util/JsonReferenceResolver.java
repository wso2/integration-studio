/*
 * Copyright (c) 2023, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.datamapper.diagram.schemagen.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReferenceResolver {

    protected static final String DOLLAR_REF = "$ref";
    protected Map<JsonElement, Boolean> referenceDefinitions = new HashMap<>();

    public JsonReferenceResolver() {

    }

    public String resolve(String root) {
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(root);
        findAndReplaceRefs(rootElement, rootElement, null);
        return rootElement.toString();
    }

    private void findAndReplaceRefs(JsonElement rootElement, JsonElement currentElement, JsonElement parentElement) {
        if (currentElement instanceof JsonObject) {
            // Object
            Set<Entry<String, JsonElement>> entrySet = ((JsonObject) currentElement).entrySet();
            for (Entry<String, JsonElement> entry : entrySet) {
                // Avoid resolving definitions
                if (referenceDefinitions.containsKey(entry.getValue())) {
                    continue;
                }
                String id = entry.getKey();
                if (id.equals(DOLLAR_REF)) {
                    String referencePath = entry.getValue().getAsString();
                    if (referencePath.startsWith("#")) {
                        // Absolute path for definition
                        String[] referencePathArray = referencePath.substring(2).split("[\\/]");
                        // Find definition
                        JsonElement elementToReplaceWith = rootElement;
                        for (String pathName: referencePathArray) {
                            elementToReplaceWith = elementToReplaceWith.getAsJsonObject().get(pathName);
                            if (elementToReplaceWith == null) {
                                // Definition not found
                                return;
                            }
                        }
                        // Keep definitions recorded to avoid them from resolving
                        referenceDefinitions.put(elementToReplaceWith, true);
                        // Get a deep copy of definition element to avoid resolving original
                        Gson gson = new Gson();
                        elementToReplaceWith = gson.fromJson(elementToReplaceWith, JsonElement.class);
                        // Deep resolve references in definitions
                        findAndReplaceRefs(rootElement, elementToReplaceWith, currentElement);
                        // Replace $ref element with definition
                        Set<Entry<String, JsonElement>> entrySet1 = ((JsonObject) elementToReplaceWith).entrySet();
                        for (Entry<String, JsonElement> entry1 : entrySet1) {
                            ((JsonObject) currentElement).add(entry1.getKey(), entry1.getValue());
                        }
                        ((JsonObject) currentElement).remove(id);
                    } else {
                        // Relative path for definition
                        String[] referencePathArray = referencePath.split("[\\/]");
                        // Find definition
                        JsonElement elementToReplaceWith = parentElement;
                        for (String pathName: referencePathArray) {
                            elementToReplaceWith = elementToReplaceWith.getAsJsonObject().get(pathName);
                            if (elementToReplaceWith == null) {
                                // Definition not found
                                return;
                            }
                        }
                        // Keep definitions recorded to avoid them from resolving
                        referenceDefinitions.put(elementToReplaceWith, true);
                        // Get a deep copy of definition element to avoid resolving original
                        Gson gson = new Gson();
                        elementToReplaceWith = gson.fromJson(elementToReplaceWith, JsonElement.class);
                        // Deep resolve references in definitions
                        findAndReplaceRefs(rootElement, elementToReplaceWith, currentElement);
                        // Replace $ref element with definition
                        Set<Entry<String, JsonElement>> entrySet1 = ((JsonObject) elementToReplaceWith).entrySet();
                        for (Entry<String, JsonElement> entry1 : entrySet1) {
                            ((JsonObject) currentElement).add(entry1.getKey(), entry1.getValue());
                        }
                        ((JsonObject) currentElement).remove(id);
                    }
                }
                findAndReplaceRefs(rootElement, entry.getValue(), currentElement);
            }

        } else if (currentElement instanceof JsonArray){
            // Array
            Iterator<JsonElement> it = ((JsonArray) currentElement).iterator();
            while (it.hasNext()) {
                findAndReplaceRefs(rootElement, it.next(), currentElement);
            }

        }
    }

}
