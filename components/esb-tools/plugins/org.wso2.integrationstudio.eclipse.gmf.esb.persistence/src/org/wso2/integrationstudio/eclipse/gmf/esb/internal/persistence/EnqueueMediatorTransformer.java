package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.aether.util.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class EnqueueMediatorTransformer extends AbstractEsbNodeTransformer {

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        information.getParentSequence().addChild(createEnqueueMediator(subject, false));
        // Transform the property mediator output data flow path.
        doTransform(information, ((EnqueueMediator) subject).getOutputConnector());
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
        // TODO Auto-generated method stub

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        sequence.addChild(createEnqueueMediator(subject, false));
        doTransformWithinSequence(information, ((EnqueueMediator) subject).getOutputConnector().getOutgoingLink(),
                sequence);

    }

    public static org.apache.synapse.mediators.builtin.EnqueueMediator createEnqueueMediator(EsbNode subject, boolean isForValidation) {

        // Check subject.
        Assert.isTrue(subject instanceof EnqueueMediator, "Invalid subject.");
        EnqueueMediator visualEnqueue = (EnqueueMediator) subject;

        org.apache.synapse.mediators.builtin.EnqueueMediator enqueueMediator = new org.apache.synapse.mediators.builtin.EnqueueMediator();
        setCommonProperties(enqueueMediator, visualEnqueue);
        if(!isForValidation && StringUtils.isEmpty(visualEnqueue.getExecutor())) {
            // Set default values for the property since we need to use synapse serializer
            enqueueMediator.setExecutorName(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
        }else {
            enqueueMediator.setExecutorName(visualEnqueue.getExecutor());
        }
        if(!isForValidation && StringUtils.isEmpty(visualEnqueue.getSequenceKey().getKeyValue())) {
         // Set default values for the property since we need to use synapse serializer
            enqueueMediator.setSequenceName(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
        }else {
            enqueueMediator.setSequenceName(visualEnqueue.getSequenceKey().getKeyValue());
        }
        enqueueMediator.setPriority(visualEnqueue.getPriority());
        return enqueueMediator;
    }

}
