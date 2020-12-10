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

public class XmlRegion {

    public enum XmlRegionType {
        INSTRUCTION, COMMENT, CDATA, MARKUP, ATTRIBUTE, MARKUP_VALUE, ATTRIBUTE_VALUE, WHITESPACE, UNEXPECTED, FREE_MARKUP_LOOP, FREE_MARKUP_DOLLER_SYNTAX;
    }

    private final XmlRegionType xmlRegionType;
    private final int start;
    private int end;

    public XmlRegion(XmlRegionType xmlRegionType, int start) {
        this.xmlRegionType = xmlRegionType;
        this.start = start;
    }

    public XmlRegion(XmlRegionType xmlRegionType, int start, int end) {
        this(xmlRegionType, start);
        this.end = end;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public XmlRegionType getXmlRegionType() {
        return this.xmlRegionType;
    }

    public int getStart() {
        return this.start;
    }
}
