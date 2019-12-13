package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.JSONTransformMediatorFactory;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.builtin.JSONTransformMediator;

public class JsonTransformMediatorExtFactory extends JSONTransformMediatorFactory {
    
    private static final QName JSON_TRANSFORM_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "jsontransform");
    private static final QName ATT_SCHEMA = new QName("schema");
    
    private static JsonTransformMediatorExtFactory instance;
    
    private JsonTransformMediatorExtFactory() {
        
    }
    
    public static JsonTransformMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new JsonTransformMediatorExtFactory();
        }
        return instance;
    }
    
    protected Mediator createSpecificMediator(OMElement omElement) {
        JSONTransformMediator JSONTransformMediator = new JSONTransformMediator();
        processAuditStatus(JSONTransformMediator, omElement);
        OMAttribute schema = omElement.getAttribute(ATT_SCHEMA);
        if (schema != null) {
            // ValueFactory for creating dynamic or static Value
            ValueFactory keyFac = new ValueFactory();
            // create dynamic or static key based on OMElement
            Value generatedKey = keyFac.createValue("schema", omElement);
            JSONTransformMediator.setSchemaKey(generatedKey);
        }
        List<MediatorProperty> mediatorPropertyList = MediatorPropertyFactory.getMediatorProperties(omElement);
        if (!mediatorPropertyList.isEmpty()) {
            JSONTransformMediator.addAllProperties(mediatorPropertyList);
        }

        return JSONTransformMediator;
    }

}
