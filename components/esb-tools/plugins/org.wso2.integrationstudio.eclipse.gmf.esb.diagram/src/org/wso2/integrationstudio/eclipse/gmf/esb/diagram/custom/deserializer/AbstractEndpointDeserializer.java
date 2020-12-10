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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.statistics.StatisticsConfigurable;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.integrationstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointCommons;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public abstract class AbstractEndpointDeserializer
        extends AbstractEsbNodeDeserializer<AbstractEndpoint, EndPoint> {

    @Deprecated
    protected <T extends AbstractEndpoint> void deserializeEndpoint(T endpoint, AbstractEndPoint visualEndpoint) {
        String suspendErrorCodes = null;
        String retryErrorCodes = null;
        
        String failoverRetryEnabledErrorCodes = null;
        String failoverRetryDisabledErrorCodes = null;

        if (StringUtils.isNotBlank(endpoint.getName())) {
            executeSetValueCommand(END_POINT__END_POINT_NAME, endpoint.getName());
        }

        if (endpoint.getDefinition() != null) {
            StatisticsConfigurable statisticsConfigurable = endpoint.getDefinition().getAspectConfiguration();
            if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
                executeSetValueCommand(ABSTRACT_END_POINT__STATISTICS_ENABLED, new Boolean(true));
            } else {
                executeSetValueCommand(ABSTRACT_END_POINT__STATISTICS_ENABLED, new Boolean(false));
            }
            // Fixing TOOLS-2652
            if (endpoint.getDefinition().isTracingEnabled()) {
                executeSetValueCommand(ABSTRACT_END_POINT__TRACE_ENABLED, new Boolean(true));
            } else {
                executeSetValueCommand(ABSTRACT_END_POINT__TRACE_ENABLED, new Boolean(false));
            }

            if ("soap11".equals(endpoint.getDefinition().getFormat())) {
                executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.SOAP_11);
            } else if ("soap12".equals(endpoint.getDefinition().getFormat())) {
                executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.SOAP_12);
            } else if ("pox".equals(endpoint.getDefinition().getFormat())) {
                executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.POX);
            } else if ("get".equals(endpoint.getDefinition().getFormat())) {
                executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.GET);
            } else if ("rest".equals(endpoint.getDefinition().getFormat())) {
                executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.REST);
            }

            if (endpoint.getDefinition().isUseMTOM()) {
                executeSetValueCommand(ABSTRACT_END_POINT__OPTIMIZE, EndPointAttachmentOptimization.MTOM);
            } else if (endpoint.getDefinition().isUseSwa()) {
                executeSetValueCommand(ABSTRACT_END_POINT__OPTIMIZE, EndPointAttachmentOptimization.SWA);
            }

            for (String code : endpoint.getDefinition().getSuspendErrorCodes()) {
                if (suspendErrorCodes == null) {
                    suspendErrorCodes = code.toString();
                } else {
                    suspendErrorCodes = suspendErrorCodes + "," + code.toString();
                }
            }
            executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_ERROR_CODES, suspendErrorCodes);
            executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION,
                    endpoint.getDefinition().getInitialSuspendDuration());
            executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION,
                    endpoint.getDefinition().getSuspendMaximumDuration());
            executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR,
                    endpoint.getDefinition().getSuspendProgressionFactor());

            for (Integer code : endpoint.getDefinition().getTimeoutErrorCodes()) {
                if (retryErrorCodes == null) {
                    retryErrorCodes = code.toString();
                } else {
                    retryErrorCodes = retryErrorCodes + "," + code.toString();
                }
            }
            executeSetValueCommand(ABSTRACT_END_POINT__RETRY_ERROR_CODES, retryErrorCodes);
            executeSetValueCommand(ABSTRACT_END_POINT__RETRY_COUNT,
                    endpoint.getDefinition().getRetriesOnTimeoutBeforeSuspend());
            executeSetValueCommand(ABSTRACT_END_POINT__RETRY_DELAY,
                    (long) endpoint.getDefinition().getRetryDurationOnTimeout());

            if (endpoint.getDefinition().getTimeoutAction() == 100) {
                executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.NEVER);
            } else if (endpoint.getDefinition().getTimeoutAction() == 101) {
                executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.DISCARD);
            } else if (endpoint.getDefinition().getTimeoutAction() == 102) {
                executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.FAULT);
            }

            if (endpoint.getDefinition().getTimeoutDuration() > 0
                    || endpoint.getDefinition().isDynamicTimeoutEndpoint()) {
                String duration = null;
                if (!endpoint.getDefinition().isDynamicTimeoutEndpoint()) {
                    duration = Long.toString(endpoint.getDefinition().getTimeoutDuration());
                } else {
                    duration = "{" + endpoint.getDefinition().getDynamicTimeoutExpression().getExpression() + "}";
                }
                executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_DURATION, duration);
            }

            if (endpoint.getDefinition().isAddressingOn()) {
                executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_ENABLED, true);
                executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER,
                        endpoint.getDefinition().isUseSeparateListener());
                if ("final".equals(endpoint.getDefinition().getAddressingVersion())) {
                    executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_VERSION, EndPointAddressingVersion.FINAL);
                } else {
                    executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_VERSION,
                            EndPointAddressingVersion.SUBMISSION);
                }
            }

            if (endpoint.getDefinition().isReliableMessagingOn()) {
                executeSetValueCommand(ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED, true);

                RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                String wsRMPolicyKey = endpoint.getDefinition().getWsRMPolicyKey();
                if (wsRMPolicyKey != null) {
                    regkey.setKeyValue(wsRMPolicyKey);
                } else {
                    regkey.setKeyValue("");
                }
                executeSetValueCommand(ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, regkey);
            }

            if (endpoint.getDefinition().isSecurityOn()) {
                executeSetValueCommand(ABSTRACT_END_POINT__SECURITY_ENABLED, true);

                String wsSecPolicyKey = endpoint.getDefinition().getWsSecPolicyKey();
                if (StringUtils.isNotBlank(wsSecPolicyKey)) {
                    RegistryKeyProperty regkey = getRegistryKeyForPolicy(wsSecPolicyKey);
                    executeSetValueCommand(ABSTRACT_END_POINT__SECURITY_POLICY, regkey);
                }

                String inboundPolicyKey = endpoint.getDefinition().getInboundWsSecPolicyKey();
                if (StringUtils.isNotBlank(inboundPolicyKey)) {
                    RegistryKeyProperty regkey = getRegistryKeyForPolicy(inboundPolicyKey);
                    executeSetValueCommand(ABSTRACT_END_POINT__INBOUND_POLICY, regkey);
                }

                String outoundPolicyKey = endpoint.getDefinition().getOutboundWsSecPolicyKey();
                if (StringUtils.isNotBlank(outoundPolicyKey)) {
                    RegistryKeyProperty regkey = getRegistryKeyForPolicy(outoundPolicyKey);
                    executeSetValueCommand(ABSTRACT_END_POINT__OUTBOUND_POLICY, regkey);
                }
            }
        }

        for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
            MediatorProperty next = i.next();
            EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
            property.setName(next.getName());

            if (next.getExpression() != null) {
                property.setValueType(PropertyValueType.EXPRESSION);
                NamespacedProperty valueXPath = EsbFactory.eINSTANCE.createNamespacedProperty();
                valueXPath.setPropertyValue(next.getExpression().toString());
                Map<String, String> namespaces = (Map<String, String>) next.getExpression().getNamespaces();
                valueXPath.setNamespaces(namespaces);
                property.setValueExpression(valueXPath);
            } else if (next.getValue() != null) {
                property.setValueType(PropertyValueType.LITERAL);
                property.setValue(next.getValue());
            }

            if (next.getScope() != null) {
                property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
            } else {
                property.setScope(EndPointPropertyScope.SYNAPSE);
            }

            executeAddValueCommand(visualEndpoint.getProperties(), property, false);
        }
        
        for (Integer code : endpoint.getDefinition().getRetryEnableErrorCodes()) {
            if (failoverRetryEnabledErrorCodes == null) {
                failoverRetryEnabledErrorCodes = code.toString();
            } else {
                failoverRetryEnabledErrorCodes = failoverRetryEnabledErrorCodes + "," + code.toString();
            }
        }
        executeSetValueCommand(ABSTRACT_END_POINT__FAILOVER_RETRY_ERROR_CODES, failoverRetryEnabledErrorCodes);
        
        for (Integer code : endpoint.getDefinition().getRetryDisabledErrorCodes()) {
            if (failoverRetryDisabledErrorCodes == null) {
                failoverRetryDisabledErrorCodes = code.toString();
            } else {
                failoverRetryDisabledErrorCodes = failoverRetryDisabledErrorCodes + "," + code.toString();
            }
        }
        executeSetValueCommand(ABSTRACT_END_POINT__FAILOVER_NON_RETRY_ERROR_CODES, failoverRetryDisabledErrorCodes);

    }

    private RegistryKeyProperty getRegistryKeyForPolicy(String wsSecPolicyKey) {
        RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
        if (wsSecPolicyKey != null) {
            regkey.setKeyValue(wsSecPolicyKey);
        } else {
            regkey.setKeyValue("");
        }
        return regkey;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void deserializeEndpoint(FormEditor formEditor, AbstractEndpoint object) {
        ESBFormEditor endpointFormEditor = (ESBFormEditor) formEditor;
        EndpointFormPage endpointPage = (EndpointFormPage) endpointFormEditor
                .getFormPageForArtifact(ArtifactType.ENDPOINT);

        EndpointCommons endpointCommons = endpointPage.getEndpointCommons();

        EndpointDefinition definition = object.getDefinition();

        if (StringUtils.isNotBlank(object.getName())) {
            endpointPage.getEndpointName().setText(object.getName());
        }

        StatisticsConfigurable statisticsConfigurable = definition.getAspectConfiguration();
        if (endpointPage.getEndpointStatistics() != null) {
            if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
                endpointPage.getEndpointStatistics().select(0);
            } else {
                endpointPage.getEndpointStatistics().select(1);
            }
        }
        // Fixing TOOLS-2652
        if (definition.isTracingEnabled()) {
            endpointPage.getEndpointTrace().select(0);// true
        } else {
            endpointPage.getEndpointTrace().select(1);// false
        }
        // String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX",
        // "GET", "REST"};
        if (endpointPage.getEP_Format() != null) {
            if ("soap11".equals(definition.getFormat())) {
                endpointPage.getEP_Format().select(1);
            } else if ("soap12".equals(definition.getFormat())) {
                endpointPage.getEP_Format().select(2);
            } else if ("pox".equals(definition.getFormat())) {
                endpointPage.getEP_Format().select(3);
            } else if ("get".equals(definition.getFormat())) {
                endpointPage.getEP_Format().select(4);
            } else if ("rest".equals(definition.getFormat())) {
                endpointPage.getEP_Format().select(5);
            } else {
                endpointPage.getEP_Format().select(0);
            }
        }
        // String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
        if (endpointPage.getEP_Optimize() != null) {
            if (definition.isUseMTOM()) {
                endpointPage.getEP_Optimize().select(1);
            } else if (definition.isUseSwa()) {
                endpointPage.getEP_Optimize().select(2);
            } else {
                endpointPage.getEP_Optimize().select(0);
            }
        }

        // Setting QOS
        if (definition.isSecurityOn()) {
            endpointCommons.getEndpointSecurity().select(0);
            String wsSecPolicyKey = definition.getWsSecPolicyKey();
            if (StringUtils.isNotEmpty(wsSecPolicyKey)) {
                endpointCommons.setWSFields(true);
                endpointCommons.getEndpointWSPolicyKey().setText(wsSecPolicyKey);
            }
            String inboundPolicyKey = definition.getInboundWsSecPolicyKey();
            String outboundPolicyKey = definition.getOutboundWsSecPolicyKey();
            if (StringUtils.isNotEmpty(inboundPolicyKey) || StringUtils.isNotEmpty(outboundPolicyKey)) {
                endpointCommons.setInoutFields(true);
                if (StringUtils.isNotEmpty(inboundPolicyKey)) {
                    endpointCommons.getEndpointSecurityInboundPolicyKey().setText(inboundPolicyKey);
                }
                if (StringUtils.isNotEmpty(outboundPolicyKey)) {
                    endpointCommons.getEndpointSecurityOutboundPolicyKey().setText(outboundPolicyKey);
                }
            }
        } else {
            endpointCommons.getEndpointSecurity().select(1);
        }

        if (definition.isAddressingOn()) {
            endpointCommons.getEndpointAddressing().select(0);
            endpointCommons.setAddressingFields(true);
            if ("final".equals(definition.getAddressingVersion())) {
                endpointCommons.getEndpointVersion().select(0);
            } else if ("submission".equals(definition.getAddressingVersion())) {
                endpointCommons.getEndpointVersion().select(1);
            }
            if (definition.isUseSeparateListener()) {
                endpointCommons.getEndpointSeparateListner().select(0);
            } else {
                endpointCommons.getEndpointSeparateListner().select(1);
            }
        } else {
            endpointCommons.getEndpointAddressing().select(1);
        }

        // Error Handling - Endpoint Suspension
        setTextValue(endpointCommons.getEndpointSuspendErrorCodes(),
                definition.getSuspendErrorCodes().toString().replace("[", "").replace("]", "").replace(", ", ","));

        setTextValue(endpointCommons.getEndpointSuspendInitialDuration(), definition.getInitialSuspendDuration());

        setTextValue(endpointCommons.getEndpointSuspendMaxDuration(), definition.getSuspendMaximumDuration());

        setTextValue(endpointCommons.getEndpointSuspendProgressFactor(), definition.getSuspendProgressionFactor());

        // Error Handling - Endpoint Retry
        setTextValue(endpointCommons.getEndpointRetryErrorCodes(),
                definition.getTimeoutErrorCodes().toString().replace("[", "").replace("]", "").replace(", ", ","));

        setTextValue(endpointCommons.getEndpointRetryCount(), definition.getRetriesOnTimeoutBeforeSuspend());

        setTextValue(endpointCommons.getEndpointRetryDelay(), definition.getRetryDurationOnTimeout());

        // Error Handling - Endpoint Timeout

        if (definition.getTimeoutDuration() > 0 || definition.isDynamicTimeoutEndpoint()) {
            String duration = null;
            if (!definition.isDynamicTimeoutEndpoint()) {
                duration = Long.toString(definition.getTimeoutDuration());
            } else {
                duration = "{" + definition.getDynamicTimeoutExpression().getExpression() + "}";
            }
            setTextValue(endpointCommons.getEndpointTimeoutDuration(), duration);

        }

        if (endpointCommons.getEndpointTimeoutAction() != null) {
            if (definition.getTimeoutAction() == 100) {
                endpointCommons.getEndpointTimeoutAction().select(0);
            } else if (definition.getTimeoutAction() == 101) {
                endpointCommons.getEndpointTimeoutAction().select(1);
            } else if (definition.getTimeoutAction() == 102) {
                endpointCommons.getEndpointTimeoutAction().select(2);
            }
        }
        
        setTextValue(endpointCommons.getEndpointSuspendErrorCodes(),
                definition.getSuspendErrorCodes().toString().replace("[", "").replace("]", "").replace(", ", ","));
        
        setTextValue(endpointCommons.getEndpointSuspendErrorCodes(),
                definition.getSuspendErrorCodes().toString().replace("[", "").replace("]", "").replace(", ", ","));

    }

    protected void setTextValue(Text textField, Object value) {
        if (value != null && textField != null) {
            textField.setText(value.toString());
        }
    }

    public org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint createUIEndpoint(Endpoint synapseEndpoint) {
        return null;
        
    }
}
