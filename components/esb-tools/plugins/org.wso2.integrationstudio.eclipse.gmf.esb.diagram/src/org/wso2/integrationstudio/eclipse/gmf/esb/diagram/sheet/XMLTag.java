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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.sheet;

/**
 * Class to represent the xml tag, part of a tag, or a source view line with no
 * tags.
 */
public class XMLTag {

    /**
     * Tag types are categorized as follows,
     * 1 <abc>
     * 2 </abc>
     * 3 <abc/>
     * 4 <log level="ab"
     * 5 level="abc" />
     * 6 level="abc">
     * 7 level="abc" => no tags
     * 8 <?xml version=\"1.0\" encoding=\"UTF-8\"?>
     */
    int tagType;

    /**
     * string value hold by this xml part
     */
    String value;

    /**
     * Line number on the source view
     */
    int line;

    /**
     * Starting index according to the source view content
     */
    int startIndex;

    /**
     * Ending index according to the source view content
     */
    int endIndex;

    /**
     * qName if there is a part of a tag
     */
    String qName = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getqName() {
        int index = qName.indexOf(":");
        if (index == -1) {
            return qName;
        } else {
            return qName.substring(index + 1);
        }
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    /**
     * Return whether it is an ending tag, i.e. is a tag type 2 or tag type 5 (type
     * 3 is not considered, as it has both starting and ending tags)
     * 
     * @return Is ending tag
     */
    public boolean isEndTag() {
        if (this.tagType == 2 || this.tagType == 5) {
            return true;
        }

        return false;
    }

    /**
     * Return whether it is a starting tag, i.e. is a tag type 1 or tag type 4 (type
     * 3 is not considered, as it has both starting and ending tags)
     * 
     * @return Is staring tag
     */
    public boolean isStartTag() {
        if (this.tagType == 1 || this.tagType == 4) {
            return true;
        }

        return false;
    }
}
