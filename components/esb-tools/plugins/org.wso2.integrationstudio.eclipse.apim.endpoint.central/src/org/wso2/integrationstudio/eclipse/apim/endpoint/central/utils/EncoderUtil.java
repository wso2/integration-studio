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

import java.util.Base64;

/**
 * This class provide encoding and decoding functionalities.
 */
public class EncoderUtil {

    /**
     * Encode a given string to Base64.
     * 
     * @param stringToEncode string to be encoded
     * @return encoded string
     */
    public static String encode(String stringToEncode) {
        byte[] encodedBytes = Base64.getEncoder().encode(stringToEncode.getBytes());
        return new String(encodedBytes);
    }
    
    /**
     * Decode a Base64 encoded string.
     * 
     * @param stringToDecode encoded string
     * @return decoded string
     */
    public static String decode(String stringToDecode) {
        byte[] decodedBytes = Base64.getDecoder().decode(stringToDecode.getBytes());
        return new String(decodedBytes);
    }
}
