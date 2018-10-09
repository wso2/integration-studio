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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.commons.util.PropertyHelper;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.ClassEndpoint;
import org.apache.synapse.endpoints.Endpoint;

import javax.xml.namespace.QName;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Properties;

public class DummyClassEndpointFactory extends DummyEndpointFactory {

    private static DummyClassEndpointFactory instance = new DummyClassEndpointFactory();
    public static final QName CLASS_QNAME = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "class");
    public static final QName NAME_QNAME = new QName("name");
    public static final QName PARAMETER_QNAME = new QName("parameter");

    private DummyClassEndpointFactory() {

    }

    public static DummyClassEndpointFactory getInstance() {
        return instance;
    }

    protected Endpoint createEndpoint(OMElement epConfig, boolean anonymousEndpoint, Properties properties) {

        ClassEndpoint clazzEndpoint = new ClassEndpoint();
        OMAttribute endpointName = epConfig.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "name"));

        if (endpointName != null) {
            clazzEndpoint.setName(endpointName.getAttributeValue());
        }

        OMElement classElement = epConfig.getFirstChildWithName(CLASS_QNAME);
        if (classElement != null) {

            String nameAttr = classElement.getAttributeValue(NAME_QNAME);
            if (nameAttr != null) {

                Endpoint endpoint = null;
                try {
                    Class clazz = Class.forName(nameAttr);
                    endpoint = (Endpoint) clazz.newInstance();
                    for (Iterator iter = classElement.getChildrenWithName(PARAMETER_QNAME); iter.hasNext();) {
                        OMElement paramEle = (OMElement) iter.next();
                        setParameter(endpoint, paramEle, clazzEndpoint);
                    }
                } catch (Exception e) {
                    // ignore
                }

                clazzEndpoint.setClassEndpoint(endpoint);
            }
        }
        return clazzEndpoint;
    }

    private void setParameter(Endpoint endpoint, OMElement paramEle, ClassEndpoint clazzEndpoint)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String name = paramEle.getAttributeValue(new QName("name"));
        String value = paramEle.getText();
        if (name != null) {
            PropertyHelper.setInstanceProperty(name, value, endpoint);
            clazzEndpoint.setParameters(name, value);
        }
    }
}
