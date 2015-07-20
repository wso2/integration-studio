/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming {@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator}
 * model objects into corresponding synapse artifact(s).
 */
public class FaultMediatorTransformer extends AbstractEsbNodeTransformer {
	public static final String soap11EnvNS = "http://schemas.xmlsoap.org/soap/envelope/";
	public static final String soap12EnvNS = "http://www.w3.org/2003/05/soap-envelope";

	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {

		try {
			info.getParentSequence().addChild(createFaultMediator(subject));
			// Transform the fault mediator output data flow path.
			doTransform(info, ((FaultMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		} catch (URISyntaxException e) {
			throw new TransformerException(e);
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		try {
			sequence.addChild(createFaultMediator(subject));
			doTransformWithinSequence(information, ((FaultMediator) subject).getOutputConnector().getOutgoingLink(),
					sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		} catch (URISyntaxException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.transform.FaultMediator createFaultMediator(EsbNode subject)
			throws JaxenException, URISyntaxException {
		// Check subject.
		Assert.isTrue(subject instanceof FaultMediator, "Invalid subject.");
		FaultMediator visualFault = (FaultMediator) subject;

		// Configure fault mediator.
		org.apache.synapse.mediators.transform.FaultMediator faultMediator = new org.apache.synapse.mediators.transform.FaultMediator();
		setCommonProperties(faultMediator, visualFault);
		{
			// Soap Version.
			switch (visualFault.getSoapVersion()) {
			case SOAP_11:
				faultMediator.setSoapVersion(org.apache.synapse.mediators.transform.FaultMediator.SOAP11);

				if (visualFault.getFaultActor() != null) {
					faultMediator.setFaultRole(new URI(visualFault.getFaultActor()));
				}

				if (visualFault.getFaultCodeType().equals(FaultCodeType.EXPRESSION)) {
					SynapseXPath codeTypeExpression = new SynapseXPath(visualFault.getFaultCodeExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultCodeExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultCodeExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultCodeExpression().getNamespaces().get(prefix);
						codeTypeExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultCodeExpr(codeTypeExpression);
				} else {
					switch (visualFault.getFaultCodeSoap11()) {
					case VERSION_MISSMATCH:
						faultMediator.setFaultCodeValue(new QName(soap11EnvNS, "VersionMismatch", "soap11Env"));
						break;
					case MUST_UNDERSTAND:
						faultMediator.setFaultCodeValue(new QName(soap11EnvNS, "MustUnderstand", "soap11Env"));
						break;
					case SERVER:
						faultMediator.setFaultCodeValue(new QName(soap11EnvNS, "Server", "soap11Env"));
						break;
					case CLIENT:
						faultMediator.setFaultCodeValue(new QName(soap11EnvNS, "Client", "soap11Env"));
						break;
					}

				}

				switch (visualFault.getFaultStringType()) {
				case VALUE:
					faultMediator.setFaultReasonValue(visualFault.getFaultStringValue());
					break;
				case EXPRESSION:
					SynapseXPath reasonExpression = new SynapseXPath(visualFault.getFaultStringExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultStringExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultStringExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultStringExpression().getNamespaces().get(prefix);
						reasonExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultReasonExpr(reasonExpression);
					break;
				}

				switch (visualFault.getFaultDetailType()) {
				case VALUE:
					faultMediator.setFaultDetail(visualFault.getFaultDetailValue());
					break;
				case EXPRESSION:
					SynapseXPath detailExpression = new SynapseXPath(visualFault.getFaultDetailExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultDetailExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultDetailExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultDetailExpression().getNamespaces().get(prefix);
						detailExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultDetailExpr(detailExpression);
					break;
				}

				break;
			case SOAP_12:
				faultMediator.setSoapVersion(org.apache.synapse.mediators.transform.FaultMediator.SOAP12);

				if (visualFault.getRoleName() != null) {
					faultMediator.setFaultRole(new URI(visualFault.getRoleName()));
				}

				if (visualFault.getFaultCodeType().equals(FaultCodeType.EXPRESSION)) {
					SynapseXPath codeTypeExpression = new SynapseXPath(visualFault.getFaultCodeExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultCodeExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultCodeExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultCodeExpression().getNamespaces().get(prefix);
						codeTypeExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultCodeExpr(codeTypeExpression);
				} else {
					switch (visualFault.getFaultCodeSoap12()) {
					case VERSION_MISSMATCH:
						faultMediator.setFaultCodeValue(new QName(soap12EnvNS, "VersionMismatch", "soap12Env"));
						break;
					case MUST_UNDERSTAND:
						faultMediator.setFaultCodeValue(new QName(soap12EnvNS, "MustUnderstand", "soap12Env"));
						break;
					case SENDER:
						faultMediator.setFaultCodeValue(new QName(soap12EnvNS, "Sender", "soap12Env"));
						break;
					case RECEIVER:
						faultMediator.setFaultCodeValue(new QName(soap12EnvNS, "Receiver", "soap12Env"));
						break;
					case DATA_ENCODING_UNKNOWN:
						faultMediator.setFaultCodeValue(new QName(soap12EnvNS, "DataEncodingUnknown", "soap12Env"));
						break;
					}
				}

				switch (visualFault.getFaultReasonType()) {
				case VALUE:
					faultMediator.setFaultReasonValue(visualFault.getFaultReasonValue());
					break;
				case EXPRESSION:
					SynapseXPath reasonExpression = new SynapseXPath(visualFault.getFaultReasonExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultReasonExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultReasonExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultReasonExpression().getNamespaces().get(prefix);
						reasonExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultReasonExpr(reasonExpression);
					break;
				}

				switch (visualFault.getFaultDetailType()) {
				case VALUE:
					faultMediator.setFaultDetail(visualFault.getFaultDetailValue());
					break;
				case EXPRESSION:
					SynapseXPath detailExpression = new SynapseXPath(visualFault.getFaultDetailExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultDetailExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultDetailExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultDetailExpression().getNamespaces().get(prefix);
						detailExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultDetailExpr(detailExpression);
					break;
				}

				if (visualFault.getNodeName() != null) {
					faultMediator.setFaultNode(new URI(visualFault.getNodeName()));
				}
				break;

			case POX:

				faultMediator.setSoapVersion(org.apache.synapse.mediators.transform.FaultMediator.POX);

				switch (visualFault.getFaultReasonType()) {
				case VALUE:
					faultMediator.setFaultReasonValue(visualFault.getFaultReasonValue());
					break;
				case EXPRESSION:
					SynapseXPath reasonExpression = new SynapseXPath(visualFault.getFaultReasonExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultReasonExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultReasonExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultReasonExpression().getNamespaces().get(prefix);
						reasonExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultReasonExpr(reasonExpression);

					break;
				}

				switch (visualFault.getFaultDetailType()) {
				case VALUE:
					faultMediator.setFaultDetail(visualFault.getFaultDetailValue());
					break;
				case EXPRESSION:
					SynapseXPath detailExpression = new SynapseXPath(visualFault.getFaultDetailExpression()
							.getPropertyValue());
					for (int i = 0; i < visualFault.getFaultDetailExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) visualFault.getFaultDetailExpression().getNamespaces().keySet()
								.toArray()[i];
						String namespaceUri = visualFault.getFaultDetailExpression().getNamespaces().get(prefix);
						detailExpression.addNamespace(prefix, namespaceUri);
					}
					faultMediator.setFaultDetailExpr(detailExpression);
					break;
				}
			}

			faultMediator.setSerializeResponse(visualFault.isSerializeResponse());
			if (visualFault.isSerializeResponse()) {
				// Response?.
				faultMediator.setMarkAsResponse(visualFault.isMarkAsResponse());
			}

		}
		return faultMediator;
	}
}
