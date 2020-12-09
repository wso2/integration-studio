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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils;

import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible holding Combo data items.
 */
public class ComboItems {

    private static String[] STATUS_CODES = { "100 Continue", "101 Switching Protocols", "102 Processing", "200 OK",
            "201 Created", "202 Accepted", "203 Non-Authoritative Information", "204 No Content", "205 Reset Content",
            "206 Partial Content", "207 Multi-Status", "300 Multiple Choices", "301 Moved Permanently", "302 Found",
            "303 See Other", "304 Not Modified", "305 Use Proxy", "307 Temporary Redirect", "400 Bad Request",
            "401 Unauthorized", "402 Payment Required", "403 Forbidden", "404 Not Found", "405 Method Not Allowed",
            "406 Not Acceptable", "407 Proxy Authentication Required", "408 Request Timeout", "409 Conflict",
            "410 Gone", "411 Length Required", "412 Precondition Failed", "413 Request Entity Too Large",
            "414 Request-URI Too Long", "415 Unsupported Media Type", "416 Requested Range Not Satisfiable",
            "417 Expectation Failed", "422 Unprocessable Entity", "423 Locked", "424 Failed Dependency",
            "425 Unordered Collection", "426 Upgrade Required", "428 Precondition Required", "429 Too Many Requests",
            "431 Request Header Fields Too Large", "500 Internal Server Error", "501 Not Implemented",
            "502 Bad Gateway", "503 Service Unavailable", "504 Gateway Timeout", "505 HTTP Version Not Supported",
            "506 Variant Also Negotiates", "507 Insufficient Storage", "510 Not Extended",
            "511 Network Authentication Required" };

    private static String[] OTHER_PROP_ITEMS = { "Transport" };

    private static String[] OTHER_PROP_NAME_ITEMS = { "$trp:" };

    private static String[] SEQ_PROP_ITEMS = { "Synapse", "Axis2", "Transport" };

    private static String[] SEQ_PROP_NAME_ITEMS = { "$ctx:", "$axis2:", "$trp:" };

    private static String[] SERVICE_HEADERS = { "Accept", "Accept-Language", "Authorization", "Content-Type",
            "Cache-Control", "Proxy-Authorization", "Access-Control-Request-Headers", "Access-Control-Request-Method",
            "Transfer-Encoding", "Content-MD5", "Content-Length", "Accept-Charset" };

    private static String[] SERVICE_HEADER_VALUES = { "*", "application/xml", "text/plain", "application/json",
            "application/atom+xml", "application/soap+xml", "application/x-www-form-urlencoded" };

    private static String[] REST_TYPES = { "GET", "POST", "PUT", "DELETE" };

    public static String[] getStatusCodes() {
        return STATUS_CODES;
    }

    public static String[] getServiceHeaders() {
        return SERVICE_HEADERS;
    }

    public static String[] getServiceHeaderValues() {
        return SERVICE_HEADER_VALUES;
    }

    public static String[] getRestTypes() {
        return REST_TYPES;
    }

    public static String[] getPropItems(String artifactType) {
        if (artifactType.equals(Constants.SEQUENCE_ARTIFACTS)) {
            return SEQ_PROP_ITEMS;
        } else {
            return OTHER_PROP_ITEMS;
        }
    }

    public static String[] getPropItemNames(String artifactType) {
        if (artifactType.equals(Constants.SEQUENCE_ARTIFACTS)) {
            return SEQ_PROP_NAME_ITEMS;
        } else {
            return OTHER_PROP_NAME_ITEMS;
        }
    }
}
