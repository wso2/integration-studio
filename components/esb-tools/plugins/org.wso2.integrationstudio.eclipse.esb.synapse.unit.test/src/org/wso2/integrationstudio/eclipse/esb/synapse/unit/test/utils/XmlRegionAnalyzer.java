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

import java.util.ArrayList;
import java.util.List;

import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.XmlRegion.XmlRegionType;

public class XmlRegionAnalyzer {
    private int offset;

    /**
     * Method for analyzes a XML document.
     * 
     * @param xml
     *            the XML text (may be an invalid XML document)
     * @return a non-null list of XML positions
     */
    public List<XmlRegion> analyzeXml(String xml) {
        this.offset = 0;
        List<XmlRegion> positions = new ArrayList<XmlRegion>();
        while (this.offset < xml.length()) {
            // White spaces
            analyzeWhitespaces(xml, positions);
            if (this.offset >= xml.length())
                break;
            // "<" can be several things
            char c = xml.charAt(this.offset);
            if (c == '<') {
                if (analyzeInstruction(xml, positions))
                    continue;
                if (analyzeComment(xml, positions))
                    continue;
                if (analyzeMarkup(xml, positions))
                    continue;
                if (analyzeCData(xml, positions))
                    continue;
                positions.add(new XmlRegion(XmlRegionType.UNEXPECTED, this.offset, xml.length()));
                break;
            }
            // "/" and "/>" can only indicate a mark-up
            else if (c == '/' && xml.charAt(this.offset + 1) == '>' || c == '>') {
                if (analyzeMarkup(xml, positions))
                    continue;
                positions.add(new XmlRegion(XmlRegionType.UNEXPECTED, this.offset, xml.length()));
                break;
            } else if (c == '$') {
            	// Free marker name ${...} phase
            	int newPos = this.offset;
            	if (xml.charAt(newPos) == '$' && newPos + 1 < xml.length() && xml.charAt(newPos + 1) == '{') {
            		char ch = '!';
                    while (newPos < xml.length() && (ch = xml.charAt(newPos)) != '}')
                        newPos++;
                    if (ch == '}')
                        newPos++;
                    positions.add(new XmlRegion(XmlRegionType.FREE_MARKUP_DOLLER_SYNTAX, this.offset, newPos));
                    this.offset = newPos;
                    continue;
            	}
            }
            // Other things can be...
            if (analyzeAttribute(xml, positions))
                continue;
            if (analyzeAttributeValue(xml, positions))
                continue;
            if (analyzeMarkupValue(xml, positions))
                continue;
            positions.add(new XmlRegion(XmlRegionType.UNEXPECTED, this.offset, xml.length()));
            break;
        }
        return positions;
    }

    /**
     * Method for tries to analyze a XML instruction.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeInstruction(String xml, List<XmlRegion> positions) {
        boolean result = false;
        int newPos = this.offset;
        if (newPos < xml.length() && xml.charAt(newPos) == '<' && ++newPos < xml.length()
                && xml.charAt(newPos) == '?') {
            while (++newPos < xml.length() && xml.charAt(newPos) != '>')
                newPos = xml.indexOf('?', newPos);
            if (xml.charAt(newPos) == '>') {
                positions.add(new XmlRegion(XmlRegionType.INSTRUCTION, this.offset, newPos + 1));
                this.offset = newPos + 1;
                result = true;
            }
        }
        return result;
    }

    /**
     * Method for tries to analyze a XML comment.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeComment(String xml, List<XmlRegion> positions) {
        boolean result = false;
        int newPos = this.offset;
        if (xml.charAt(newPos) == '<' && ++newPos < xml.length() && xml.charAt(newPos) == '!' && ++newPos < xml.length()
                && xml.charAt(newPos) == '-' && ++newPos < xml.length() && xml.charAt(newPos) == '-') {
            int seq = 0;
            while (seq != 3 && ++newPos < xml.length()) {
                char c = xml.charAt(newPos);
                seq = c == '-' && seq < 2 || c == '>' && seq == 2 ? seq + 1 : 0;
            }
            if (seq == 3)
                newPos++;
            positions.add(new XmlRegion(XmlRegionType.COMMENT, this.offset, newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze a XML mark-up.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeMarkup(String xml, List<XmlRegion> positions) {
        int newPos = this.offset;
        boolean result = false;
        // "<..."
        if (xml.charAt(newPos) == '<') {
            // Do not process a CData section or a comment as a mark-up
            if (newPos + 1 < xml.length() && xml.charAt(newPos + 1) == '!')
                return false;
            // Process a free marker code segment <#
            boolean isFreeMarkerSyntax = false;
            if (newPos + 1 < xml.length() && xml.charAt(newPos + 1) == '#' || 
            		(newPos + 1 < xml.length() && xml.charAt(newPos + 1) == '/' && newPos + 2 < xml.length() && xml.charAt(newPos + 2) == '#')) {
            	// Free marker name
                char c = '!';
                while (newPos < xml.length() && (c = xml.charAt(newPos)) != '>')
                    newPos++;
                if (c == '>')
                    newPos++;
                positions.add(new XmlRegion(XmlRegionType.FREE_MARKUP_LOOP, this.offset, newPos));
                this.offset = newPos;
                result = true;
                isFreeMarkerSyntax = true;
            }
            if (!isFreeMarkerSyntax) {
            	// Mark-up name
                char c = '!';
                while (newPos < xml.length() && (c = xml.charAt(newPos)) != '>' && !Character.isWhitespace(c))
                    newPos++;
                if (c == '>')
                    newPos++;
                positions.add(new XmlRegion(XmlRegionType.MARKUP, this.offset, newPos));
                this.offset = newPos;
                result = true;
            }
        } 
        // "/>"
        else if (xml.charAt(newPos) == '/' && ++newPos < xml.length() && xml.charAt(newPos) == '>') {
            positions.add(new XmlRegion(XmlRegionType.MARKUP, this.offset, ++newPos));
            this.offset = newPos;
            result = true;
        }
        // "attributes... >"
        else if (xml.charAt(newPos) == '>') {
            positions.add(new XmlRegion(XmlRegionType.MARKUP, this.offset, ++newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze a XML attribute.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeAttribute(String xml, List<XmlRegion> positions) {
        // An attribute value follows a mark-up
        for (int i = positions.size() - 1; i >= 0; i--) {
            XmlRegion xr = positions.get(i);
            if (xr.getXmlRegionType() == XmlRegionType.WHITESPACE)
                continue;
            if (xr.getXmlRegionType() == XmlRegionType.ATTRIBUTE_VALUE)
                break;
            if (xr.getXmlRegionType() == XmlRegionType.MARKUP) {
                char c = xml.charAt(xr.getEnd() - 1);
                if (c != '>')
                    break;
            }
            return false;
        }
        // Analyze what we have...
        boolean result = false;
        int newPos = this.offset;
        char c;
        while (newPos < xml.length() && (c = xml.charAt(newPos)) != '=' && c != '/' && c != '>'
                && !Character.isWhitespace(c))
            newPos++;
        // Found one?
        if (newPos != this.offset) {
            positions.add(new XmlRegion(XmlRegionType.ATTRIBUTE, this.offset, newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze a mark-up's value.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeMarkupValue(String xml, List<XmlRegion> positions) {
        // A mark-up value follows a mark-up
        for (int i = positions.size() - 1; i >= 0; i--) {
            XmlRegion xr = positions.get(i);
            if (xr.getXmlRegionType() == XmlRegionType.WHITESPACE)
                continue;
            if (xr.getXmlRegionType() == XmlRegionType.MARKUP || xr.getXmlRegionType() == XmlRegionType.FREE_MARKUP_LOOP 
            		|| xr.getXmlRegionType() == XmlRegionType.COMMENT) {
                char c = xml.charAt(xr.getEnd() - 1);
                if (c == '>')
                    break;
            }
            return false;
        }
        // Read...
        boolean result = false;
        int newPos = this.offset;
        while (newPos < xml.length() && xml.charAt(newPos) != '<' && 
        		(newPos < xml.length() && xml.charAt(newPos) != '$' && newPos < xml.length() && xml.charAt(newPos) != '{')) {
            newPos++;
        }
        // We read something and this something is not only made up of white
        // spaces
        if (this.offset != newPos) {
            // We must here repair the list if the previous position is made up
            // of white spaces
            XmlRegion xr = positions.get(positions.size() - 1);
            int start = this.offset;
            if (xr.getXmlRegionType() == XmlRegionType.WHITESPACE) {
                start = xr.getStart();
                positions.remove(xr);
            }
            positions.add(new XmlRegion(XmlRegionType.MARKUP_VALUE, start, newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze a XML attribute's value.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeAttributeValue(String xml, List<XmlRegion> positions) {
        // An attribute value follows an attribute
        for (int i = positions.size() - 1; i >= 0; i--) {
            XmlRegion xr = positions.get(i);
            if (xr.getXmlRegionType() == XmlRegionType.WHITESPACE)
                continue;
            if (xr.getXmlRegionType() == XmlRegionType.ATTRIBUTE)
                break;
            return false;
        }
        // Analyze what we have
        boolean result = false;
        int newPos = this.offset;
        if (xml.charAt(newPos) == '=') {
            analyzeWhitespaces(xml, positions);
            int cpt = 0;
            char previous = '!';
            while (++newPos < xml.length()) {
                char c = xml.charAt(newPos);
                if (previous != '\\' && c == '"')
                    cpt++;
                previous = c;
                if (cpt == 2) {
                    newPos++;
                    break;
                }
            }
            positions.add(new XmlRegion(XmlRegionType.ATTRIBUTE_VALUE, this.offset, newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze a CDATA section.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     * @return true if it recognized a XML instruction
     */
    boolean analyzeCData(String xml, List<XmlRegion> positions) {
        boolean result = false;
        int newPos = this.offset;
        if (xml.charAt(newPos) == '<' && ++newPos < xml.length() && xml.charAt(newPos) == '!' && ++newPos < xml.length()
                && xml.charAt(newPos) == '[' && ++newPos < xml.length() && xml.charAt(newPos) == 'C'
                && ++newPos < xml.length() && xml.charAt(newPos) == 'D' && ++newPos < xml.length()
                && xml.charAt(newPos) == 'A' && ++newPos < xml.length() && xml.charAt(newPos) == 'T'
                && ++newPos < xml.length() && xml.charAt(newPos) == 'A' && ++newPos < xml.length()
                && xml.charAt(newPos) == '[') {
            int cpt = 0;
            while (++newPos < xml.length()) {
                char c = xml.charAt(newPos);
                if (cpt < 2 && c == ']' || cpt == 2 && c == '>')
                    cpt++;
                else
                    cpt = 0;
                if (cpt == 3) {
                    newPos++;
                    break;
                }
            }
            positions.add(new XmlRegion(XmlRegionType.CDATA, this.offset, newPos));
            this.offset = newPos;
            result = true;
        }
        return result;
    }

    /**
     * Method for tries to analyze white spaces.
     * 
     * @param xml
     *            the XML text
     * @param positions
     *            the positions already found
     */
    void analyzeWhitespaces(String xml, List<XmlRegion> positions) {
        int i = this.offset;
        while (i < xml.length() && Character.isWhitespace(xml.charAt(i)))
            i++;
        if (i != this.offset) {
            positions.add(new XmlRegion(XmlRegionType.WHITESPACE, this.offset, i));
            this.offset = i;
        }
    }
}
