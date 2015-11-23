/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.Entry;
import org.apache.synapse.config.xml.EntryFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;

/**
 * Custom factory for {@link Entry} instances. 
 */
public class EntryExtFactory extends EntryFactory {
	
    private static Log log = LogFactory.getLog(EntryFactory.class);

    private static final QName DESCRIPTION_Q
            = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "description");
    
    public static Entry createEntry(OMElement elem, Properties properties) {

        OMAttribute key = elem.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
        if (key == null) {
            handleException("The 'key' attribute is required for a local registry entry");
            return null;

        } else {

            Entry entry = new Entry(key.getAttributeValue());

            OMElement descriptionElem = elem.getFirstChildWithName(DESCRIPTION_Q);
            if (descriptionElem != null) {
                entry.setDescription(descriptionElem.getText());
                descriptionElem.detach();
            }

            String src  = elem.getAttributeValue(
                    new QName(XMLConfigConstants.NULL_NAMESPACE, "src"));

            if (src != null) {
                try {
                    entry.setSrc(new URL(src.trim()));
                    entry.setType(Entry.URL_SRC);
                } catch (MalformedURLException e) {
                    handleException("The entry with key : " + key + " refers to an invalid URL");
                }

            } else {
                OMNode    nodeValue = elem.getFirstOMChild();
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

	private static void handleException(String msg) {
		log.error(msg);
		throw new SynapseException(msg);
	}

}
