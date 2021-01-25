package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import java.util.Map;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.END_POINT__REVERSED;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__SOURCE_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__CONTENT_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__TARGET_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__TARGET_PROPERTY;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__SOURCE_XPATH;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__SOURCE_PROPERTY;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__SOURCE_PAYLOAD;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_TYPE;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT;
import static org.wso2.integrationstudio.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMText;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.elementary.Target;
import org.apache.synapse.mediators.elementary.Source;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.gmf.esb.CallMediator;
import org.wso2.integrationstudio.gmf.esb.CallMediatorEndpointType;
import org.wso2.integrationstudio.gmf.esb.CallSourceType;
import org.wso2.integrationstudio.gmf.esb.CallTargetType;
import org.wso2.integrationstudio.gmf.esb.EndPoint;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;

public class CallMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CallMediator> {

    public CallMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) throws DeserializerException {

        Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.CallMediator,
                "Unsupported mediator passed in for deserialization at " + this.getClass());

        org.apache.synapse.mediators.builtin.CallMediator callMediator = (org.apache.synapse.mediators.builtin.CallMediator) mediator;

        CallMediator visualCallMediator = (CallMediator) DeserializerUtils.createNode(part,
                EsbElementTypes.CallMediator_3742);
        setElementToEdit(visualCallMediator);
        setCommonProperties(callMediator, visualCallMediator);

        refreshEditPartMap();
        EditPart mediatorFlow = getEditpart(visualCallMediator.getMediatorFlow());

        Endpoint endPoint = callMediator.getEndpoint();
        CallMediatorEndpointType endPointType = getEndpointType(endPoint);
        executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_TYPE, endPointType);
        executeSetValueCommand(CALL_MEDIATOR__ENABLE_BLOCKING_CALLS, callMediator.isBlocking());
        if (endPoint != null) {
            @SuppressWarnings("rawtypes")
            IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endPoint);
            @SuppressWarnings("unchecked")
            // EndPoint visualEndPoint = (EndPoint) deserializer.createNode(getRootCompartment(), endpoint);
            EndPoint visualEndPoint = (EndPoint) deserializer
                    .createNode((IGraphicalEditPart) mediatorFlow.getChildren().get(0), endPoint);
            if (isReversed()) {
                executeSetValueCommand(visualEndPoint, END_POINT__REVERSED, true);
            }
            // visualCallMediator.setNextNode(visualEndPoint);

            if (endPointType == CallMediatorEndpointType.REGISRTYKEY) {
                RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                IndirectEndpoint indeirectEP = (IndirectEndpoint) endPoint;
                regkey.setKeyValue(indeirectEP.getKey());
                executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, regkey);
            } else if (endPointType == CallMediatorEndpointType.XPATH) {
                ResolvingEndpoint resolvingEndpoint = (ResolvingEndpoint) endPoint;
                SynapseXPath xpath = resolvingEndpoint.getKeyExpression();
                NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
                executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_XPATH, namespaceProp);
            }
        }

        executeSetValueCommand(CALL_MEDIATOR__ENDPOINT, endPoint);
        
        if (callMediator.getSourceForOutboundPayload() != null) {
            Source source = callMediator.getSourceForOutboundPayload();
            switch (source.getSourceType()) {
            case org.apache.synapse.mediators.elementary.EnrichMediator.BODY: {
                executeSetValueCommand(CALL_MEDIATOR__SOURCE_TYPE, CallSourceType.BODY);
                break;
            }
            case org.apache.synapse.mediators.elementary.EnrichMediator.INLINE: {
                executeSetValueCommand(CALL_MEDIATOR__SOURCE_TYPE, CallSourceType.INLINE);
                if (source.getInlineOMNode() != null) {
                    if (source.getInlineOMNode() instanceof OMElement) {
                        executeSetValueCommand(CALL_MEDIATOR__SOURCE_PAYLOAD, source.getInlineOMNode().toString());
                    } else if (source.getInlineOMNode() instanceof OMText) {
                        executeSetValueCommand(CALL_MEDIATOR__SOURCE_PAYLOAD,
                                ((OMText) source.getInlineOMNode()).getText());
                    }
                }
                break;
            }
            case org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY: {
                executeSetValueCommand(CALL_MEDIATOR__SOURCE_TYPE, CallSourceType.PROPERTY);
                if (source.getProperty() != null && !source.getProperty().equals("")) {
                    executeSetValueCommand(CALL_MEDIATOR__SOURCE_PROPERTY, source.getProperty());
                }
                break;
            }
            case org.apache.synapse.mediators.elementary.EnrichMediator.CUSTOM: {
                executeSetValueCommand(CALL_MEDIATOR__SOURCE_TYPE, CallSourceType.CUSTOM);
                SynapsePath xpath = source.getXpath();

                NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
                nsp.setPropertyValue(xpath.toString());
                nsp.setSupportJsonPaths(true);

                if (xpath.getNamespaces() != null) {

                    @SuppressWarnings("unchecked")
                    Map<String, String> map = xpath.getNamespaces();

                    nsp.setNamespaces(map);
                }

                executeSetValueCommand(CALL_MEDIATOR__SOURCE_XPATH, nsp);
                break;
            }
            }
        }

        if (callMediator.getTargetForInboundPayload() != null) {
            Target target = callMediator.getTargetForInboundPayload();
            switch (target.getTargetType()) {
            case org.apache.synapse.mediators.elementary.EnrichMediator.BODY: {
                executeSetValueCommand(CALL_MEDIATOR__TARGET_TYPE, CallTargetType.BODY);
                break;
            }
            case org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY: {
                executeSetValueCommand(CALL_MEDIATOR__SOURCE_TYPE, CallSourceType.PROPERTY);
                if (target.getProperty() != null && !target.getProperty().equals("")) {
                    executeSetValueCommand(CALL_MEDIATOR__TARGET_PROPERTY, target.getProperty());
                }
                break;
            }
            }
        }

        if (callMediator.getSourceMessageType() != null) {
            executeSetValueCommand(CALL_MEDIATOR__CONTENT_TYPE, callMediator.getSourceMessageType());
        }

        return visualCallMediator;
    }

    private CallMediatorEndpointType getEndpointType(Endpoint endPoint) {
        CallMediatorEndpointType endPointType = CallMediatorEndpointType.INLINE;
        if (endPoint == null) {
            // endPointType = CallMediatorEndpointType.NONE; //- Fixing TOOLS-3286
        } else if (endPoint instanceof IndirectEndpoint) {
            endPointType = CallMediatorEndpointType.REGISRTYKEY;
        } else if (endPoint instanceof ResolvingEndpoint) {
            endPointType = CallMediatorEndpointType.XPATH;
        }
        return endPointType;
    }

}