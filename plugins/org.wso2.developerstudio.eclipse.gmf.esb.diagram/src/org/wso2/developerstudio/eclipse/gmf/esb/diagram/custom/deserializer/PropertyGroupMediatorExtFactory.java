package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.mediators.builtin.PropertyGroupMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;

public class PropertyGroupMediatorExtFactory extends PropertyMediatorFactory {

    private static PropertyGroupMediatorExtFactory instance;

    PropertyGroupMediatorExtFactory() {
    }

    public static synchronized PropertyGroupMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new PropertyGroupMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {
        PropertyGroupMediator propertyGroupMediator = new PropertyGroupMediator();
        PropertyMediatorExtFactory propertyMediatorExtFactory = new PropertyMediatorExtFactory();
        List<PropertyMediator> propertyGroupList = new ArrayList<>();
        Iterator propertyGroupIterator = omElement.getChildrenWithName(PROP_Q);

        while (propertyGroupIterator.hasNext()) {
            OMElement propertyElement = (OMElement) propertyGroupIterator.next();
            Mediator propertyMediator = propertyMediatorExtFactory.createSpecificMediator(propertyElement);
            propertyGroupList.add((PropertyMediator) propertyMediator);
        }
        propertyGroupMediator.setPropGroupList(propertyGroupList);
        return propertyGroupMediator;
    }
}
