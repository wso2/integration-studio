/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.bean.BeanConstants;
import org.apache.synapse.mediators.bean.BeanMediator.Action;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.BeanMediatorExt;

public class BeanMediatorExtFactory extends AbstractMediatorFactory {

    private static final QName BEAN_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "bean");

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        BeanMediatorExt mediator = new BeanMediatorExt();

        String attributeValue;

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.VAR));
        if (attributeValue != null) {
            mediator.setVarName(attributeValue);
        }

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.ACTION));
        if (attributeValue != null) {
            try {
                switch (Action.valueOf(attributeValue.toUpperCase())) {
                case CREATE:
                    populateCreateBeanCase(mediator, elem);
                    break;
                case REMOVE:
                    mediator.setAction(Action.REMOVE);
                    break;
                case SET_PROPERTY:
                    populateSetPropertyCase(mediator, elem);
                    break;
                case GET_PROPERTY:
                    populateGetPropertyCase(mediator, elem);
                    break;
                default:
                    assert false;
                }
            } catch (IllegalArgumentException e) {
                // ignore
            }
        }
        addAllCommentChildrenToList(elem, mediator.getCommentsList());
        
        return mediator;
    }

        /**
         * This method will create a Bean mediator for the validation purposes. This will try 
         * to create the bean mediator with the given OMElement, if it fails to create a mediator
         * this will throw synapse excpetions, otherwise this will return a valid bean mediator
         * @param elem OMElement of the mediator
         * @param properties
         * @return
         */
        public Mediator createSpecificMediatorForValidation(OMElement elem, Properties properties) {

            BeanMediatorExt mediator = new BeanMediatorExt();

            String attributeValue;

            attributeValue = elem.getAttributeValue(new QName(BeanConstants.VAR));
            if (attributeValue != null) {
                mediator.setVarName(attributeValue);
            }

            attributeValue = elem.getAttributeValue(new QName(BeanConstants.ACTION));
            if (attributeValue != null) {
                try {
                    switch (Action.valueOf(attributeValue.toUpperCase())) {
                    case CREATE:
                        populateCreateBeanCase(mediator, elem);
                        break;
                    case REMOVE:
                        mediator.setAction(Action.REMOVE);
                        break;
                    case SET_PROPERTY:
                        populateSetPropertyCaseForValidation(mediator, elem);
                        break;
                    case GET_PROPERTY:
                        populateGetPropertyCaseForValidation(mediator, elem);
                        break;
                    default:
                        assert false;
                    }
                } catch (IllegalArgumentException e) {
                    // The purpose of this method is to create a dummy bean mediator synapse 
                    // object. So if there are exceptions the EI-tooling, we can proceed with
                    // the already created mediator object, hence ignoring
                }
            }

        return mediator;
    }

    private void populateCreateBeanCase(BeanMediatorExt mediator, OMElement elem) {

        mediator.setAction(Action.CREATE);

        String attributeValue;

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.CLASS));
        if (attributeValue != null) {
            mediator.setClassName(attributeValue.trim());
        }

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.REPLACE));
        if (attributeValue != null) {
            mediator.setReplace(Boolean.parseBoolean(attributeValue.trim()));
        }

    }

    private void populateSetPropertyCase(BeanMediatorExt mediator, OMElement elem) {

        mediator.setAction(Action.SET_PROPERTY);

        populatePropertyName(mediator, elem);

        if (elem.getAttributeValue(ATT_VALUE) != null) {
            mediator.setValue(new ValueFactoryExtended().createValue(BeanConstants.VALUE, elem));
        }
    }
    
    /**
     * This method will populate the SetPropertyCase parameter with the use the synapse 
     * ValueFactory() class which will throw synapse exceptions if the mediator contains invalid parameters.
     * This is useful for the validation of the 
     * bean mediator
     * @param mediator
     * @param elem
     */
    private void populateSetPropertyCaseForValidation(BeanMediatorExt mediator, OMElement elem) {

        mediator.setAction(Action.SET_PROPERTY);

        populatePropertyName(mediator, elem);

        if (elem.getAttributeValue(ATT_VALUE) != null) {
            mediator.setValue(new ValueFactory().createValue(BeanConstants.VALUE, elem));
        }
    }

    private void populateGetPropertyCase(BeanMediatorExt mediator, OMElement elem) {

        mediator.setAction(Action.GET_PROPERTY);

        populatePropertyName(mediator, elem);

        if (elem.getAttributeValue(new QName(BeanConstants.TARGET)) != null) {
            mediator.setTargetValue(new ValueFactoryExtended().createValue(BeanConstants.TARGET, elem));
        }
    }
    
    /**
     * This method will populate the GetPropertyCase parameter with the use the synapse 
     * ValueFactory() class which will throw synapse exceptions if the mediator contains invalid parameters.
     * This is useful for the validation of the 
     * bean mediator
     * @param mediator
     * @param elem
     */
    private void populateGetPropertyCaseForValidation(BeanMediatorExt mediator, OMElement elem) {

        mediator.setAction(Action.GET_PROPERTY);

        populatePropertyName(mediator, elem);

        if (elem.getAttributeValue(new QName(BeanConstants.TARGET)) != null) {
            mediator.setTargetValue(new ValueFactory().createValue(BeanConstants.TARGET, elem));
        }
    }

    private void populatePropertyName(BeanMediatorExt mediator, OMElement elem) {

        String attributeValue;

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.PROPERTY));
        if (attributeValue != null) {
            mediator.setPropertyName(attributeValue);
        }
    }

    public QName getTagQName() {
        return BEAN_Q;
    }

}
