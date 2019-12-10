package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.JsonTransformMediatorProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class JsonTransformMediatorTransformer extends AbstractEsbNodeTransformer {

    @Override
    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        Assert.isTrue(subject instanceof JsonTransformMediator, "Invalid subject.");
        JsonTransformMediator visualJsonTransform = (JsonTransformMediator) subject;

            information.getParentSequence().addChild(createJsonTransformMediator(visualJsonTransform, false));
            // Transform the jsonTransform mediator output data flow path.
            doTransform(information, visualJsonTransform.getOutputConnector());
    }

    private Mediator createJsonTransformMediator(JsonTransformMediator visualJsonTransform, boolean b) {
        org.apache.synapse.mediators.builtin.JSONTransformMediator jsonTransformMediator = new org.apache.synapse.mediators.builtin.JSONTransformMediator();
        setCommonProperties(jsonTransformMediator, visualJsonTransform);
        
        if (visualJsonTransform.getSchema() != null && !visualJsonTransform.getSchema().getKeyValue().equals("")) {
            jsonTransformMediator.setSchemaKey(new Value(visualJsonTransform.getSchema().getKeyValue()));
            
        } else if(!visualJsonTransform.getJsonTransformProperty().isEmpty()) {
            List<MediatorProperty> mediatorPropertyList = new ArrayList<MediatorProperty>();
            for (JsonTransformMediatorProperty jsonTransformMediatorProperty : visualJsonTransform.getJsonTransformProperty()) {
                MediatorProperty mediatorProperty = new MediatorProperty();
                mediatorProperty.setName(jsonTransformMediatorProperty.getPropertyName());
                mediatorProperty.setValue(jsonTransformMediatorProperty.getPropertyValue());
                mediatorPropertyList.add(mediatorProperty);
            }
            jsonTransformMediator.addAllProperties(mediatorPropertyList);
        }
        
        return jsonTransformMediator;

    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub
        System.out.println("########## JsonTransformMediatorTransformer == createSynapseObject");
    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        // TODO Auto-generated method stub
        System.out.println("########## JsonTransformMediatorTransformer == transformWithinSequence");
    }

}
