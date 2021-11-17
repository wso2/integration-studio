package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.gmf.esb.NTLMMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals;

public class NTLMMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, NTLMMediator> {

    @Override
    public NTLMMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) throws DeserializerException {
        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.NTLMMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());
        org.apache.synapse.mediators.builtin.NTLMMediator ntlmMediator = (org.apache.synapse.mediators.builtin.NTLMMediator) mediator;
        NTLMMediator visualNtlm = (NTLMMediator) DeserializerUtils.createNode(part, EsbElementTypes.NTLMMediator_3797);
        setElementToEdit(visualNtlm);
        setCommonProperties(ntlmMediator, visualNtlm);

        String username = ntlmMediator.getUsername();
        String password = ntlmMediator.getPassword();
        String host = ntlmMediator.getHost();
        String domain = ntlmMediator.getDomain();
        String ntlmVersion = ntlmMediator.getNtlmVersion();

        if (username != null) {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__USERNAME, username);
        } else {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__USERNAME, "");
        }
        if (password != null) {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__PASSWORD, password);
        } else {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__PASSWORD, "");
        }
        if (host != null) {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__HOST, host);
        } else {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__HOST, "");
        }
        if (domain != null) {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__DOMAIN, domain);
        } else {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__DOMAIN, "");
        }
        if (ntlmVersion != null) {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__NTLM_VERSION, ntlmVersion);
        } else {
            executeSetValueCommand(Literals.NTLM_MEDIATOR__NTLM_VERSION, "");
        }

        return visualNtlm;
    }

}
