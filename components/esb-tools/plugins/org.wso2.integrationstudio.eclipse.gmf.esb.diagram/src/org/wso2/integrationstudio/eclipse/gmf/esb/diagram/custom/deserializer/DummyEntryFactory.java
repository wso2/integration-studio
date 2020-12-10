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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.Entry;
import org.apache.synapse.config.xml.XMLConfigConstants;

public class DummyEntryFactory {

    private static final QName DESCRIPTION_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "description");

    public static Entry createEntry(OMElement elem, Properties properties) {

        OMAttribute key = elem.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
        Entry entry;
        if (key == null) {
            entry = new Entry("");
        } else {
            entry = new Entry(key.getAttributeValue());
        }

        OMElement descriptionElem = elem.getFirstChildWithName(DESCRIPTION_Q);
        if (descriptionElem != null) {
            entry.setDescription(descriptionElem.getText());
            descriptionElem.detach();
        }

        String src = elem.getAttributeValue(new QName(XMLConfigConstants.NULL_NAMESPACE, "src"));
        if (src != null) {
            try {
                entry.setSrc(new URL(src.trim()));
                entry.setType(Entry.URL_SRC);
            } catch (MalformedURLException e) {
                // ignore
            }

        } else {
            OMNode nodeValue = elem.getFirstOMChild();
            OMElement elemValue = elem.getFirstElement();

            if (elemValue != null) {
                entry.setType(Entry.INLINE_XML);
                entry.setValue(elemValue);
            } else if (nodeValue != null && nodeValue instanceof OMText) {
                entry.setType(Entry.INLINE_TEXT);
                entry.setValue(elem.getText());
            }
        }

        return entry;
    }
}
