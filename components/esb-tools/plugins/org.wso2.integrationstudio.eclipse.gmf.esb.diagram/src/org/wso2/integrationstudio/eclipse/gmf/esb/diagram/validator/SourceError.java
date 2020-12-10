/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.validator;

/**
 * Class to represent a source error which will be represented in an IMarker
 *
 */
public class SourceError {

    /**
     * Exception to be added as the error message
     */
    private String exception;

    /**
     * Line number where the error occurred
     */
    private int lineNumber;

    /**
     * Starting chat index to indicate the error according to the source view
     * content
     */
    private int startChar;

    /**
     * Ending char index to indicate the error according to the source view content
     */
    private int endChar;

    public SourceError(String exception, int lineNumber, int startChar, int endChar) {
        this.exception = exception;
        this.lineNumber = lineNumber;
        this.startChar = startChar;
        this.endChar = endChar;
    }

    public SourceError() {

    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getStartChar() {
        return startChar;
    }

    public void setStartChar(int startChar) {
        this.startChar = startChar;
    }

    public int getEndChar() {
        return endChar;
    }

    public void setEndChar(int endChar) {
        this.endChar = endChar;
    }

}
