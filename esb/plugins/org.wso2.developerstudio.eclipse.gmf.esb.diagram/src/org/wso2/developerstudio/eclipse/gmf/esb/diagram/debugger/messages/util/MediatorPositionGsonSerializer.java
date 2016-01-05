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

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * This class implements the Gson Json serializer for {@link ESBMediatorPosition}
 * 
 * @see <a
 *      href="https://sites.google.com/site/gson/gson-user-guide#TOC-Serializing-and-Deserializing-Collection-with-Objects-of-Arbitrary-Types">GOSN
 *      Serializing</a>
 *
 */
public class MediatorPositionGsonSerializer implements JsonSerializer<ESBMediatorPosition> {

    private static final String ARRAY_VALUE_SEPERATOR = ",";
    private static final String STRING_SPACE_VALUE = " ";
    private static final String ARRAY_ENDING_BRACKET = "]";
    private static final String EMPTY_STRING_VALUE = "";

    @Override
    public JsonElement serialize(ESBMediatorPosition position, Type typeOfPosition, JsonSerializationContext context) {
        String positionString = position.getPosition().toString().trim();
        return new JsonPrimitive(positionString.substring(1, positionString.lastIndexOf(ARRAY_ENDING_BRACKET))
                .replaceAll(STRING_SPACE_VALUE, EMPTY_STRING_VALUE)
                .replaceAll(ARRAY_VALUE_SEPERATOR, STRING_SPACE_VALUE));
    }

}
