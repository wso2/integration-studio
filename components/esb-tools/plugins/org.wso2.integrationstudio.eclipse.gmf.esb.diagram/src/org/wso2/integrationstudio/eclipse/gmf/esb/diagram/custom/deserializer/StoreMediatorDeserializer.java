package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.StoreMediatorSpecifyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class StoreMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, StoreMediator> {

    public StoreMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {
        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.store.MessageStoreMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());

        org.apache.synapse.mediators.store.MessageStoreMediator storeMediator = (org.apache.synapse.mediators.store.MessageStoreMediator) mediator;

        StoreMediator visualStoreMediator = (StoreMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.StoreMediator_3588);
        setElementToEdit(visualStoreMediator);
        setCommonProperties(storeMediator, visualStoreMediator);

        if ((storeMediator.getOnStoreSequence() != null) && !("".equals(storeMediator.getOnStoreSequence()))) {
            executeSetValueCommand(visualStoreMediator.getOnStoreSequence(), REGISTRY_KEY_PROPERTY__KEY_VALUE,
                    storeMediator.getOnStoreSequence());
        }

        if (storeMediator.getMessageStoreExp() != null) {
            executeSetValueCommand(STORE_MEDIATOR__EXPRESSION,
                    createNamespacedProperty(storeMediator.getMessageStoreExp()));
            executeSetValueCommand(STORE_MEDIATOR__SPECIFY_AS, StoreMediatorSpecifyType.EXPRESSION);
        } else if (storeMediator.getMessageStoreName() != null) {
            executeSetValueCommand(STORE_MEDIATOR__MESSAGE_STORE, storeMediator.getMessageStoreName());
            executeSetValueCommand(STORE_MEDIATOR__SPECIFY_AS, StoreMediatorSpecifyType.VALUE);
        } else {
            executeSetValueCommand(STORE_MEDIATOR__EXPRESSION,
                    createNamespacedProperty(SynapseXPathExt.createSynapsePath("")));
            executeSetValueCommand(STORE_MEDIATOR__SPECIFY_AS, StoreMediatorSpecifyType.EXPRESSION);
        }

        return visualStoreMediator;
    }

}
