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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointWestOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointCommons;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

public abstract class AbstractEndpointTransformer extends AbstractEsbNodeTransformer {

	protected void createAdvanceOptions(EndpointFormPage endpointFormPage, AbstractEndpoint endpoint) {
		EndpointDefinition synapseEPDef = new EndpointDefinition();
		EndpointCommons endpointCommons = endpointFormPage.getEndpointCommons();
		synapseEPDef.setFormat(endpointFormPage.getEP_Format().getText());
		
		if (endpointFormPage.getEP_Optimize().getSelectionIndex() == 1) {
			synapseEPDef.setUseMTOM(true);
		} else if (endpointFormPage.getEP_Optimize().getSelectionIndex() == 2) {
			synapseEPDef.setUseSwa(true);
		}

		AspectConfiguration aspectConfiguration = new AspectConfiguration(endpointFormPage.getEndpointName().getText());
		synapseEPDef.configure(aspectConfiguration);
		if (endpointFormPage.getEndpointStatistics().getSelectionIndex() == 0) {
			aspectConfiguration.enableStatistics();
		} else {
			aspectConfiguration.disableStatistics();
		}

		if (endpointFormPage.getEndpointTrace().getSelectionIndex() == 0) {
			synapseEPDef.getAspectConfiguration().enableTracing();
		} else {
			synapseEPDef.getAspectConfiguration().disableTracing();
		}

		if (endpointCommons.getEndpointSuspendErrorCodes() != null) {
			String suspendErrorCodes = endpointCommons.getEndpointSuspendErrorCodes().getText();
			if (suspendErrorCodes != null && !"".equals(suspendErrorCodes)) {
				String[] suspendErrorCodesList = suspendErrorCodes.split("\\,");
				List<String> suspendCodes = Arrays.asList(suspendErrorCodesList);
				for (String code : suspendCodes) {
					synapseEPDef.addSuspendErrorCode(Integer.parseInt(code));
				}
			}
		}

		if (endpointCommons.getEndpointSuspendInitialDuration() != null
				&& StringUtils.isNumeric(endpointCommons.getEndpointSuspendInitialDuration().getText())
				&& endpointCommons.getEndpointSuspendInitialDuration().getText() != ""
				&& !endpointCommons.getEndpointSuspendInitialDuration().getText().isEmpty()) {
			synapseEPDef.setInitialSuspendDuration(
					Long.parseLong(endpointCommons.getEndpointSuspendInitialDuration().getText().trim()));
		}
		if (endpointCommons.getEndpointSuspendMaxDuration() != null
				&& StringUtils.isNumeric(endpointCommons.getEndpointSuspendMaxDuration().getText())
				&& endpointCommons.getEndpointSuspendMaxDuration().getText() != ""
				&& !endpointCommons.getEndpointSuspendMaxDuration().getText().isEmpty()) {
			synapseEPDef.setSuspendMaximumDuration(
					Long.parseLong(endpointCommons.getEndpointSuspendMaxDuration().getText().trim()));
		}
		if (endpointCommons.getEndpointSuspendProgressFactor() != null
				&& StringUtils.isNumeric(endpointCommons.getEndpointSuspendProgressFactor().getText())
				&& endpointCommons.getEndpointSuspendProgressFactor().getText() != ""
				&& !endpointCommons.getEndpointSuspendProgressFactor().getText().isEmpty()) {
			synapseEPDef.setSuspendProgressionFactor(
					Float.parseFloat((endpointCommons.getEndpointSuspendProgressFactor().getText().trim())));
		}

		String retryErrorCodes = endpointCommons.getEndpointRetryErrorCodes().getText();
		if (retryErrorCodes != null && !"".equals(retryErrorCodes) && !retryErrorCodes.isEmpty()) {
			String[] retryCodesList = retryErrorCodes.split("\\,");
			List<String> retryCodes = Arrays.asList(retryCodesList);
			for (String code : retryCodes) {
				synapseEPDef.addTimeoutErrorCode(Integer.parseInt(code));
			}
		}
		if (StringUtils.isNumeric(endpointCommons.getEndpointRetryCount().getText())
				&& endpointCommons.getEndpointRetryCount().getText() != ""
				&& !endpointCommons.getEndpointRetryCount().getText().isEmpty()) {
			synapseEPDef.setRetriesOnTimeoutBeforeSuspend(
					Integer.parseInt(endpointCommons.getEndpointRetryCount().getText().trim()));
		}
		if (StringUtils.isNumeric(endpointCommons.getEndpointRetryDelay().getText())
				&& endpointCommons.getEndpointRetryDelay().getText() != ""
				&& !endpointCommons.getEndpointRetryDelay().getText().isEmpty()) {
			synapseEPDef.setRetryDurationOnTimeout(
					Integer.parseInt(endpointCommons.getEndpointRetryDelay().getText().trim()));
		}
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
		if (StringUtils.isNumeric(endpointCommons.getEndpointTimeoutDuration().getText())
				&& endpointCommons.getEndpointTimeoutDuration().getText() != ""
				&& !endpointCommons.getEndpointTimeoutDuration().getText().isEmpty()
				&& endpointCommons.getEndpointTimeoutDuration().getText() != "0") {
			synapseEPDef
					.setTimeoutDuration(Long.parseLong(endpointCommons.getEndpointTimeoutDuration().getText().trim()));
		}

		if (endpointCommons.getEndpointAddressing().getSelectionIndex() == 0) {
			synapseEPDef.setAddressingOn(true); // TODO implement these
												// parameters
			synapseEPDef.setUseSeparateListener(true);
			synapseEPDef.setAddressingVersion("final");
		}
		if (endpointCommons.getEndpointReliableMessaging().getSelectionIndex() == 0) {
			synapseEPDef.setReliableMessagingOn(true);
			String keyValue = "";
			if (keyValue != null && !keyValue.isEmpty()) {
				// synapseEPDef.setWsRMPolicyKey(visualEndPoint.getReliableMessagingPolicy().getKeyValue());
			}
		} else {
			synapseEPDef.setReliableMessagingOn(false);
		}

		if (endpointCommons.getEndpointSecurity().getSelectionIndex() == 0) {
			/*
			 * synapseEPDef.setSecurityOn(true); if
			 * (visualEndPoint.getSecurityPolicy() != null) { String policyValue
			 * = visualEndPoint.getSecurityPolicy().getKeyValue();
			 * if(policyValue != null && !policyValue.isEmpty()){
			 * synapseEPDef.setWsSecPolicyKey(policyValue); } }
			 * 
			 * if (visualEndPoint.getInboundPolicy() != null) { String
			 * inboundPolicyValue =
			 * visualEndPoint.getInboundPolicy().getKeyValue();
			 * if(inboundPolicyValue != null && !inboundPolicyValue.isEmpty()){
			 * synapseEPDef.setInboundWsSecPolicyKey(inboundPolicyValue); } }
			 * 
			 * if (visualEndPoint.getOutboundPolicy() != null) { String
			 * outboundPolicyValue =
			 * visualEndPoint.getOutboundPolicy().getKeyValue();
			 * if(outboundPolicyValue !=null && !outboundPolicyValue.isEmpty()){
			 * synapseEPDef.setOutboundWsSecPolicyKey(outboundPolicyValue); } }
			 */
		}

		// saveProperties(visualEndPoint, endpoint);
		if (StringUtils.isNotEmpty(endpointFormPage.getEP_Description().getText())) {
			endpoint.setDescription(endpointFormPage.getEP_Description().getText());
		}
		endpoint.setDefinition(synapseEPDef);

	}

	@SuppressWarnings("deprecation")
	protected void createAdvanceOptions(AbstractEndPoint visualEndPoint, AbstractEndpoint endpoint) {
		EndpointDefinition synapseEPDef = new EndpointDefinition();

		synapseEPDef.setFormat(visualEndPoint.getFormat().getLiteral());
		if (visualEndPoint.getOptimize().getValue() == 1) {
			synapseEPDef.setUseMTOM(true);
		} else if (visualEndPoint.getOptimize().getValue() == 2) {
			synapseEPDef.setUseSwa(true);
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
				synapseEPDef.addSuspendErrorCode(Integer.parseInt(code));
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
		synapseEPDef.setTimeoutDuration(visualEndPoint.getTimeOutDuration());

		if (visualEndPoint.isAddressingEnabled()) {
			synapseEPDef.setAddressingOn(true);
			synapseEPDef.setUseSeparateListener(visualEndPoint.isAddressingSeparateListener());
			synapseEPDef.setAddressingVersion((visualEndPoint.getAddressingVersion() == EndPointAddressingVersion.FINAL)
					? "final" : "submission");
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
		if (info.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) {
			int size = info.getParentSequence().getList().size();
			if (size > 0) {
				Mediator lastObj = info.getParentSequence().getList().get(size - 1);
				if (lastObj instanceof SendMediator) {
					sendMediator = (SendMediator) lastObj;
				}
			}
		} else if (info.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.Sequence) {
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
		if (info.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.CallMediator) {
			int size = info.getParentSequence().getList().size();
			if (size > 0) {
				Mediator lastObj = info.getParentSequence().getList().get(size - 1);
				if (lastObj instanceof CallMediator) {
					callMediator = (CallMediator) lastObj;
				}
			}
		} else if (info.getPreviouNode() instanceof org.wso2.developerstudio.eclipse.gmf.esb.Sequence) {
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
			info.getCurrentProxy().setTargetInLineEndpoint(synapseEP);
		} else {
			if (sendMediator != null) {
				sendMediator.setEndpoint(synapseEP);
			} else if (callMediator != null) {
				callMediator.setEndpoint(synapseEP);
			}
		}
	}

}
