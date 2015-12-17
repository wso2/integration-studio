/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;

/**
 * This class defines naming strategy for json message fields which sent to ESB
 * Server Debugger
 * <p>
 * Eg:
 * <li>command : command</li>
 * <li>commandArgument : command-argument</li>
 */
public class PojoToGsonCustomNamingStrategy implements FieldNamingStrategy {

    private static final String JSON_MESSAGE_COMMAND_NAME_SEPERATOR = "-";

    @Override
    public String translateName(Field filedName) {
        StringBuilder translation = new StringBuilder();
        char[] nameArray = filedName.getName().toCharArray();
        for (char character : nameArray) {
            if (Character.isUpperCase(character) && translation.length() != 0) {
                String separator = JSON_MESSAGE_COMMAND_NAME_SEPERATOR;
                translation.append(separator);
            }
            translation.append(character);
        }
        return translation.toString().toLowerCase();
    }
}
