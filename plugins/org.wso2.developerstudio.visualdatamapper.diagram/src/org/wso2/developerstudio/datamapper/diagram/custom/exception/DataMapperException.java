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
package org.wso2.developerstudio.datamapper.diagram.custom.exception;

/**
 * This Exception is used to throw when an common error occurs in Data Mapper.
 * <p>
 * All other custom exceptions related to Data Mapper extends this class.
 *
 */
public class DataMapperException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataMapperException(String message) {
        super(message);
    }

    public DataMapperException(Throwable cause) {
        super(cause);
    }

    public DataMapperException(String message, Throwable cause) {
        super(message, cause);
    }

}
