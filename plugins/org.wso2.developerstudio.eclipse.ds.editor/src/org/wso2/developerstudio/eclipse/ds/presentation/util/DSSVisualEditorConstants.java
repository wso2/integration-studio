/*
 *     Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */

package org.wso2.developerstudio.eclipse.ds.presentation.util;

// Constants related to the DSS visual editor page
public class DSSVisualEditorConstants {
    
    public static class General {
        public static final String DSS_EDITOR = "DSS Editor";
        public static final String GUI_EDITOR_NAME = "Design";
        public static final String SOURCE_EDITOR_NAME = "Source";
    }
    
    public static class WebApp {
        public static final String INDEX_HTML_FILE_NAME = "index.html";
    }
    
    public static class ErrorMessages {
        public static final String ERROR_CREATING_UI_EDITOR = "Error creating GUI editor";
        public static final String ERROR_CREATING_NESTED_TEXT_EDITOR = "Error creating nested text editor";
        public static final String ERROR_INVALID_INPUT_MUST_BE_IFILE_EDITOR_INPUT = "Invalid input: Must be IFileEditorInput";
    }
    
    public static class RequestHeaders {
        public static final String HEADER_OPERATION_TYPE = "x-operation-type";
        public static final String HEADER_VALUE_SAVE_ALL = "save-all";
    }
}
