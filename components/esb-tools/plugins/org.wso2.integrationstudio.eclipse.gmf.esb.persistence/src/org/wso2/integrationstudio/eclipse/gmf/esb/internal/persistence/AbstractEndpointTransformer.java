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

package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPointWestOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPointWestOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.RecipientListEndPointWestOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointCommons;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

public abstract class AbstractEndpointTransformer extends AbstractEsbNodeTransformer {

    @SuppressWarnings("deprecation")
    protected void createAdvanceOptions(EndpointFormPage endpointFormPage, AbstractEndpoint endpoint)
            throws NumberFormatException, JaxenException {

        EndpointDefinition synapseEPDef = new EndpointDefinition();
        EndpointCommons endpointCommons = endpointFormPage.getEndpointCommons();
        /**
         * LEAVE_AS_IS,
         * SOAP_11,
         * SOAP_12,
         * POX,
         * GET,
         * REST,
         **/
        if (endpointFormPage.getEP_Format() != null) {
            if (endpointFormPage.getEP_Format().getSelectionIndex() == 1) {
                synapseEPDef.setFormat("soap11");
            } else if (endpointFormPage.getEP_Format().getSelectionIndex() == 2) {
                synapseEPDef.setFormat("soap12");
            } else if (endpointFormPage.getEP_Format().getSelectionIndex() == 3) {
                synapseEPDef.setFormat("pox");
            } else if (endpointFormPage.getEP_Format().getSelectionIndex() == 4) {
                synapseEPDef.setFormat("get");
            } else if (endpointFormPage.getEP_Format().getSelectionIndex() == 5) {
                synapseEPDef.setFormat("rest");
            } else {
                synapseEPDef.setFormat("LEAVE_AS_IS");
            }
        }

        if (endpointFormPage.getEP_Optimize() != null) {
            if (endpointFormPage.getEP_Optimize().getSelectionIndex() == 1) {
                synapseEPDef.setUseMTOM(true);
            } else if (endpointFormPage.getEP_Optimize().getSelectionIndex() == 2) {
                synapseEPDef.setUseSwa(true);
            }
        }

        if (endpointFormPage.getEndpointName() != null) {
            AspectConfiguration aspectConfiguration = new AspectConfiguration(
                    endpointFormPage.getEndpointName().getText());
            synapseEPDef.configure(aspectConfiguration);
            if (endpointFormPage.getEndpointStatistics() != null) {
                if (endpointFormPage.getEndpointStatistics().getSelectionIndex() == 0) {
                    aspectConfiguration.enableStatistics();
                } else {
                    aspectConfiguration.disableStatistics();
                }
            }
        }

        if (endpointFormPage.getEndpointTrace() != null) {
            if (endpointFormPage.getEndpointTrace().getSelectionIndex() == 0) {
                synapseEPDef.getAspectConfiguration().enableTracing();
            } else {
                synapseEPDef.getAspectConfiguration().disableTracing();
            }
        }

        if (endpointCommons.getEndpointSuspendErrorCodes() != null) {
            String suspendErrorCodes = endpointCommons.getEndpointSuspendErrorCodes().getText();
            if (StringUtils.isNotEmpty(suspendErrorCodes)) {
                String[] suspendErrorCodesList = suspendErrorCodes.split("\\,");
                List<String> suspendCodes = Arrays.asList(suspendErrorCodesList);
                for (String code : suspendCodes) {
                    try {
                        synapseEPDef.addSuspendErrorCode(code);
                    } catch (NumberFormatException ex) {
                        throw new NumberFormatException(
                                "Input for Suspend Error Codes is invalid,the value should be an interger");
                    }
                }
            }
        }

        if (endpointCommons.getEndpointSuspendInitialDuration() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointSuspendInitialDuration().getText())) {
            try {
                synapseEPDef.setInitialSuspendDuration(
                        endpointCommons.getEndpointSuspendInitialDuration().getText().trim());
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(
                        "Input for Suspend Initial Duration is invalid,the value should be a long");
            }
        }

        if (endpointCommons.getEndpointSuspendMaxDuration() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointSuspendMaxDuration().getText())) {
            try {
                synapseEPDef.setSuspendMaximumDuration(
                        Long.parseLong(endpointCommons.getEndpointSuspendMaxDuration().getText().trim()));
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(
                        "Input for Suspend Maximum Duration is invalid,the value should be a long");
            }

        }

        if (endpointCommons.getEndpointSuspendProgressFactor() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointSuspendProgressFactor().getText())) {
            try {
                synapseEPDef.setSuspendProgressionFactor(
                        (endpointCommons.getEndpointSuspendProgressFactor().getText().trim()));
            } catch (NumberFormatException ex) {
                throw new NumberFormatException(
                        "Input for Suspend Progression Factor is invalid,the value should be a float");
            }

        }

        if (endpointCommons.getEndpointRetryErrorCodes() != null) {
            String retryErrorCodes = endpointCommons.getEndpointRetryErrorCodes().getText();
            if (retryErrorCodes != null && !"".equals(retryErrorCodes) && !retryErrorCodes.isEmpty()) {
                String[] retryCodesList = retryErrorCodes.split("\\,");
                List<String> retryCodes = Arrays.asList(retryCodesList);
                for (String code : retryCodes) {
                    try {
                        synapseEPDef.addTimeoutErrorCode(Integer.parseInt(code));
                    } catch (NumberFormatException ex) {
                        throw new NumberFormatException(
                                "Input for Entry Error Codes is invalid,the value should be a float");
                    }

                }
            }
        }

        if (endpointCommons.getEndpointRetryCount() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointRetryCount().getText())) {
            try {
                synapseEPDef.setRetriesOnTimeoutBeforeSuspend(
                        endpointCommons.getEndpointRetryCount().getText().trim());
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Input for Entry Count is invalid,the value should be a float");
            }
        }

        if (endpointCommons.getEndpointRetryDelay() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointRetryDelay().getText())) {
            try {
                synapseEPDef.setRetryDurationOnTimeout(
                        Integer.parseInt(endpointCommons.getEndpointRetryDelay().getText().trim()));
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Input for Entry Delay is invalid,the value should be a float");
            }
        }

        if (endpointCommons.getEndpointTimeoutAction() != null) {
            if (endpointCommons.getEndpointTimeoutAction().getSelectionIndex() != 0) {
                if (endpointCommons.getEndpointTimeoutAction().getSelectionIndex() == 1) {
                    synapseEPDef.setTimeoutAction(101);
                } else {// endpointCommons.getEndpointTimeoutAction().getSelectionIndex()
                        // = 2
                    synapseEPDef.setTimeoutAction(102);
                }
            } else {
                synapseEPDef.setTimeoutAction(100);
            }
        }

        if (endpointCommons.getEndpointTimeoutDuration() != null
                && StringUtils.isNotEmpty(endpointCommons.getEndpointTimeoutDuration().getText())) {
            try {
                String duration = endpointCommons.getEndpointTimeoutDuration().getText();
                Pattern pattern = Pattern.compile("\\{.*\\}");
                if (pattern.matcher(duration).matches()) {
                    duration = duration.trim().substring(1, duration.length() - 1);
                    SynapseXPath xpath = new SynapseXPath(duration);
                    synapseEPDef.setDynamicTimeoutExpression(xpath);
                } else {
                    long timeoutMilliSeconds = Long.parseLong(duration.trim());
                    synapseEPDef.setTimeoutDuration(timeoutMilliSeconds);
                }
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Input for Timeout Duration is invalid,the value should be a number");
            } catch (JaxenException e) {
                throw e;
            }
        }

        if (endpointCommons.getEndpointAddressing() != null) {
            if (endpointCommons.getEndpointAddressing().getSelectionIndex() == 0) {
                synapseEPDef.setAddressingOn(true);
                synapseEPDef.setUseSeparateListener(
                        Boolean.valueOf(endpointCommons.getEndpointSeparateListner().getText().toString()));
                String version = endpointCommons.getEndpointVersion().getText();
                if (StringUtils.isNotEmpty(version)) {
                    synapseEPDef.setAddressingVersion((version.equals("final")) ? "final" : "submission");
                }
            }
        }

        if (endpointCommons.getEndpointSecurity() != null) {
            if (endpointCommons.getEndpointSecurity().getSelectionIndex() == 0) {
                synapseEPDef.setSecurityOn(true);

                if (StringUtils.isNotEmpty(endpointCommons.getEndpointWSPolicyKey().getText())) {
                    String policyValue = endpointCommons.getEndpointWSPolicyKey().getText();
                    synapseEPDef.setWsSecPolicyKey(policyValue);
                }

                if (StringUtils.isNotEmpty(endpointCommons.getEndpointSecurityInboundPolicyKey().getText())) {
                    String inboundPolicyValue = endpointCommons.getEndpointSecurityInboundPolicyKey().getText();
                    synapseEPDef.setInboundWsSecPolicyKey(inboundPolicyValue);
                }

                if (StringUtils.isNotEmpty(endpointCommons.getEndpointSecurityOutboundPolicyKey().getText())) {
                    String outboundPolicyValue = endpointCommons.getEndpointSecurityOutboundPolicyKey().getText();
                    synapseEPDef.setOutboundWsSecPolicyKey(outboundPolicyValue);
                }
            }
        }

        if (endpointFormPage.getEP_Description() != null) {
            if (StringUtils.isNotEmpty(endpointFormPage.getEP_Description().getText())) {
                endpoint.setDescription(endpointFormPage.getEP_Description().getText());
            }
        }
        endpoint.setDefinition(synapseEPDef);

    }

    @SuppressWarnings("deprecation")
    protected void createAdvanceOptions(AbstractEndPoint visualEndPoint, AbstractEndpoint endpoint)
            throws JaxenException {
        EndpointDefinition synapseEPDef = new EndpointDefinition();

        synapseEPDef.setFormat(visualEndPoint.getFormat().getLiteral());
        if (visualEndPoint.getOptimize().getValue() == 1) {
            synapseEPDef.setUseMTOM(true);
        } else if (visualEndPoint.getOptimize().getValue() == 2) {
            synapseEPDef.setUseSwa(true);
        }
        
        String retryEnabledErrorCodes = visualEndPoint.getFailoverRetryErrorCodes();
        if (retryEnabledErrorCodes != null && !"".equals(retryEnabledErrorCodes)) {
            String[] retryEnabledErrorCodesList = retryEnabledErrorCodes.split("\\,");
            List<String> retryEnabledErrorCodesArr = Arrays.asList(retryEnabledErrorCodesList);
            for (String code : retryEnabledErrorCodesArr) {
                synapseEPDef.addRetryEnabledErrorCode(Integer.parseInt(code));
            }
        }
        
        String retryDisabledErrorCodes = visualEndPoint.getFailoverNonRetryErrorCodes();
        if (retryDisabledErrorCodes != null && !"".equals(retryDisabledErrorCodes)) {
            String[] retryDisabledErrorCodesList = retryDisabledErrorCodes.split("\\,");
            List<String> retryDisabledErrorCodesArr = Arrays.asList(retryDisabledErrorCodesList);
            for (String code : retryDisabledErrorCodesArr) {
                synapseEPDef.addRetryDisabledErrorCode(Integer.parseInt(code));
            }
        }

        AspectConfiguration aspectConfiguration = new AspectConfiguration(visualEndPoint.getEndPointName());
        synapseEPDef.configure(aspectConfiguration);
        if (visualEndPoint.isStatisticsEnabled()) {
            aspectConfiguration.enableStatistics();
        } else {
            aspectConfiguration.disableStatistics();
        }

        if (visualEndPoint.isTraceEnabled()) {
            synapseEPDef.getAspectConfiguration().enableTracing();
        } else {
            synapseEPDef.getAspectConfiguration().disableTracing();
        }

        String suspendErrorCodes = visualEndPoint.getSuspendErrorCodes();
        if (suspendErrorCodes != null && !"".equals(suspendErrorCodes)) {
            String[] suspendErrorCodesList = suspendErrorCodes.split("\\,");
            List<String> suspendCodes = Arrays.asList(suspendErrorCodesList);
            for (String code : suspendCodes) {
                synapseEPDef.addSuspendErrorCode(code);
            }
        }
        synapseEPDef.setInitialSuspendDuration(visualEndPoint.getSuspendInitialDuration());
        synapseEPDef.setSuspendMaximumDuration(visualEndPoint.getSuspendMaximumDuration());
        synapseEPDef.setSuspendProgressionFactor(visualEndPoint.getSuspendProgressionFactor());

        String retryErrorCodes = visualEndPoint.getRetryErrorCodes();
        if (retryErrorCodes != null && !"".equals(retryErrorCodes)) {
            String[] retryCodesList = retryErrorCodes.split("\\,");
            List<String> retryCodes = Arrays.asList(retryCodesList);
            for (String code : retryCodes) {
                synapseEPDef.addTimeoutErrorCode(Integer.parseInt(code));
            }
        }
        synapseEPDef.setRetriesOnTimeoutBeforeSuspend(visualEndPoint.getRetryCount());
        synapseEPDef.setRetryDurationOnTimeout((int) visualEndPoint.getRetryDelay());

        synapseEPDef.setTimeoutAction(visualEndPoint.getTimeOutAction().getValue());

        String timeOutDuration = visualEndPoint.getTimeOutDuration();
        Pattern pattern = Pattern.compile("\\{.*\\}");
        if (pattern.matcher(timeOutDuration).matches()) {
            timeOutDuration = timeOutDuration.trim().substring(1, timeOutDuration.length() - 1);
            SynapseXPath xpath = new SynapseXPath(timeOutDuration);
            synapseEPDef.setDynamicTimeoutExpression(xpath);
        } else {
            long timeoutMilliSeconds = Long.parseLong(timeOutDuration.trim());
            synapseEPDef.setTimeoutDuration(timeoutMilliSeconds);
        }

        if (visualEndPoint.isAddressingEnabled()) {
            synapseEPDef.setAddressingOn(true);
            synapseEPDef.setUseSeparateListener(visualEndPoint.isAddressingSeparateListener());
            synapseEPDef.setAddressingVersion(
                    (visualEndPoint.getAddressingVersion() == EndPointAddressingVersion.FINAL) ? "final"
                            : "submission");
        }
        if (visualEndPoint.isReliableMessagingEnabled()) {
            synapseEPDef.setReliableMessagingOn(visualEndPoint.isReliableMessagingEnabled());
            String keyValue = visualEndPoint.getReliableMessagingPolicy().getKeyValue();
            if (keyValue != null && !keyValue.isEmpty()) {
                synapseEPDef.setWsRMPolicyKey(visualEndPoint.getReliableMessagingPolicy().getKeyValue());
            }
        }

        if (visualEndPoint.isSecurityEnabled()) {
            synapseEPDef.setSecurityOn(true);
            if (visualEndPoint.getSecurityPolicy() != null) {
                String policyValue = visualEndPoint.getSecurityPolicy().getKeyValue();
                if (policyValue != null && !policyValue.isEmpty()) {
                    synapseEPDef.setWsSecPolicyKey(policyValue);
                }
            }

            if (visualEndPoint.getInboundPolicy() != null) {
                String inboundPolicyValue = visualEndPoint.getInboundPolicy().getKeyValue();
                if (inboundPolicyValue != null && !inboundPolicyValue.isEmpty()) {
                    synapseEPDef.setInboundWsSecPolicyKey(inboundPolicyValue);
                }
            }

            if (visualEndPoint.getOutboundPolicy() != null) {
                String outboundPolicyValue = visualEndPoint.getOutboundPolicy().getKeyValue();
                if (outboundPolicyValue != null && !outboundPolicyValue.isEmpty()) {
                    synapseEPDef.setOutboundWsSecPolicyKey(outboundPolicyValue);
                }
            }
        }

        saveProperties(visualEndPoint, endpoint);
        if (visualEndPoint.getDescription() != null) {
            endpoint.setDescription(visualEndPoint.getDescription());
        }
        endpoint.setDefinition(synapseEPDef);

    }

    /**
     * Save endpoint properties
     * 
     * @param model
     * @param endpoint
     */
    protected void saveProperties(EndPoint model, AbstractEndpoint endpoint) {
        for (Iterator<EndPointProperty> iterator = model.getProperties().iterator(); iterator.hasNext();) {
            EndPointProperty property = iterator.next();
            MediatorProperty mediatorProperty = new MediatorProperty();
            mediatorProperty.setName(property.getName());

            if (property.getValueType().toString().equals("EXPRESSION")) {
                SynapseXPath XPath = null;
                try {
                    XPath = new SynapseXPath(property.getValueExpression().getPropertyValue());
                    for (int i = 0; i < property.getValueExpression().getNamespaces().keySet().size(); ++i) {
                        String prefix = (String) property.getValueExpression().getNamespaces().keySet().toArray()[i];
                        String namespaceUri = property.getValueExpression().getNamespaces().get(prefix);
                        XPath.addNamespace(prefix, namespaceUri);
                    }
                    mediatorProperty.setExpression(XPath);
                } catch (JaxenException e) {
                    log.error("Error while persisting Endpoint properties", e);
                }
            } else if (property.getValueType().toString().equals("LITERAL")) {
                mediatorProperty.setValue(property.getValue());
            }

            mediatorProperty.setScope(property.getScope().toString().toLowerCase());
            endpoint.addProperty(mediatorProperty);
        }
    }

    /**
     * transform Endpoint Output flow
     * 
     * @param info
     */
    protected void transformEndpointOutflow(TransformationInfo info) {
        if (!info.isOutputPathSet) {
            if (info.firstEndPoint instanceof FailoverEndPoint) {
                try {
                    FailoverEndPointWestOutputConnector westOutputConnector = ((FailoverEndPoint) info.firstEndPoint)
                            .getWestOutputConnector();

                    List<EsbNode> transformedMediators = info.getTransformedMediators();
                    if (westOutputConnector != null) {
                        EsbNode nextElement = getTargetContainer(westOutputConnector);
                        if (nextElement != null) {
                            if (!transformedMediators.contains(nextElement)) {
                                doTransform(info, westOutputConnector);
                                transformedMediators.add(nextElement);
                            }
                        }

                    }

                } catch (Exception e) {
                    log.warn("Error while executing outflow  serialization", e);
                }
            } else if (info.firstEndPoint instanceof LoadBalanceEndPoint) {
                try {
                    LoadBalanceEndPointWestOutputConnector westOutputConnector = ((LoadBalanceEndPoint) info.firstEndPoint)
                            .getWestOutputConnector();
                    List<EsbNode> transformedMediators = info.getTransformedMediators();
                    if (westOutputConnector != null) {
                        EsbNode nextElement = getTargetContainer(westOutputConnector);
                        if (nextElement != null) {
                            if (!transformedMediators.contains(nextElement)) {
                                doTransform(info, westOutputConnector);
                                transformedMediators.add(nextElement);
                            }
                        }

                    }
                } catch (Exception e) {
                    log.warn("Error while executing outflow  serialization", e);
                }
            } else if (info.firstEndPoint instanceof RecipientListEndPoint) {
                try {
                    RecipientListEndPointWestOutputConnector westOutputConnector = ((RecipientListEndPoint) info.firstEndPoint)
                            .getWestOutputConnector();

                    List<EsbNode> transformedMediators = info.getTransformedMediators();
                    if (westOutputConnector != null) {
                        EsbNode nextElement = getTargetContainer(westOutputConnector);
                        if (nextElement != null) {
                            if (!transformedMediators.contains(nextElement)) {
                                doTransform(info, westOutputConnector);
                                transformedMediators.add(nextElement);
                            }
                        }

                    }

                } catch (Exception e) {
                    log.warn("Error while executing outflow  serialization", e);
                }
            }
            info.isOutputPathSet = true;
        }
    }

    /**
     * Get target node
     * 
     * @param outputConnector
     * @return
     */
    protected EsbNode getTargetContainer(OutputConnector outputConnector) {
        EsbNode node = null;
        EsbLink outgoingLink = outputConnector.getOutgoingLink();
        if (outgoingLink != null) {
            InputConnector target = outgoingLink.getTarget();
            if (target != null) {
                if (target.eContainer() instanceof EsbNode) {
                    node = (EsbNode) target.eContainer();
                }
            }
        }
        return node;
    }

    protected SendMediator getSendMediator(TransformationInfo info) {
        SendMediator sendMediator = null;
        if (info.getPreviouNode() instanceof org.wso2.integrationstudio.eclipse.gmf.esb.SendMediator) {
            int size = info.getParentSequence().getList().size();
            if (size > 0) {
                Mediator lastObj = info.getParentSequence().getList().get(size - 1);
                if (lastObj instanceof SendMediator) {
                    sendMediator = (SendMediator) lastObj;
                }
            }
        } else if (info.getPreviouNode() instanceof org.wso2.integrationstudio.eclipse.gmf.esb.Sequence) {
            sendMediator = null;
        } else {
        }
        return sendMediator;
    }

    protected SendMediator getSendMediator(SequenceMediator sequence) {
        SendMediator sendMediator = null;
        int size = sequence.getList().size();
        if (size > 0 && sequence.getList().get(size - 1) instanceof SendMediator) {
            sendMediator = (SendMediator) sequence.getList().get(size - 1);
        } else {
            sendMediator = new SendMediator();
            sequence.addChild(sendMediator);
        }
        return sendMediator;
    }

    protected CallMediator getCallMediator(TransformationInfo info) {
        CallMediator callMediator = null;
        if (info.getPreviouNode() instanceof org.wso2.integrationstudio.eclipse.gmf.esb.CallMediator) {
            int size = info.getParentSequence().getList().size();
            if (size > 0) {
                Mediator lastObj = info.getParentSequence().getList().get(size - 1);
                if (lastObj instanceof CallMediator) {
                    callMediator = (CallMediator) lastObj;
                }
            }
        } else if (info.getPreviouNode() instanceof org.wso2.integrationstudio.eclipse.gmf.esb.Sequence) {
            callMediator = null;
        } else {
        }
        return callMediator;
    }

    protected CallMediator getCallMediator(SequenceMediator sequence) {
        CallMediator callMediator = null;
        int size = sequence.getList().size();
        if (size > 0 && sequence.getList().get(size - 1) instanceof CallMediator) {
            callMediator = (CallMediator) sequence.getList().get(size - 1);
        } else {
            callMediator = new CallMediator();
            sequence.addChild(callMediator);
        }
        return callMediator;
    }

    protected void setEndpointToSendOrCallMediator(SequenceMediator sequence, Endpoint synapseEP) {
        int size = sequence.getList().size();
        Object mediator = null;
        if (size > 0) {
            mediator = sequence.getList().get(size - 1);
        }
        if (mediator instanceof SendMediator) {
            SendMediator sendMediator = getSendMediator(sequence);
            sendMediator.setEndpoint(synapseEP);
        } else if (mediator instanceof CallMediator) {
            CallMediator callMediator = getCallMediator(sequence);
            callMediator.setEndpoint(synapseEP);
        }
    }

    protected void setEndpointToSendCallOrProxy(TransformationInfo info, EndPoint visualEndPoint, Endpoint synapseEP) {
        SendMediator sendMediator = getSendMediator(info);
        CallMediator callMediator = getCallMediator(info);

        if (visualEndPoint.isInLine()) {
            if (info != null && info.getCurrentProxy() != null) {
                info.getCurrentProxy().setTargetInLineEndpoint(synapseEP);
            }
        } else {
            if (sendMediator != null) {
                sendMediator.setEndpoint(synapseEP);
            } else if (callMediator != null) {
                callMediator.setEndpoint(synapseEP);
            }
        }
    }

    protected org.apache.synapse.endpoints.Template createTemplate(EndpointFormPage formPage,
            AbstractEndpoint synapseEP) {
        org.apache.synapse.endpoints.Template endpointTemplate = new org.apache.synapse.endpoints.Template();
        endpointTemplate.setName(formPage.getTemplateName().getText());
        if (formPage.getTemplateCommentList() != null) {
            endpointTemplate.getCommentsList().addAll(formPage.getTemplateCommentList());
        }
        List<TemplateParameter> templateParams = formPage.getTemplateParameterList();
        if (templateParams != null) {
            for (TemplateParameter parameter : templateParams) {
                endpointTemplate.addParameter(parameter.getName());
            }
        }
        endpointTemplate.setElement(EndpointSerializer.getElementFromEndpoint(synapseEP));
        return endpointTemplate;
    }

}
