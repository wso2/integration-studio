/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.SALoadbalanceEndpoint;
import org.apache.synapse.endpoints.algorithms.LoadbalanceAlgorithm;
import org.apache.synapse.endpoints.dispatch.Dispatcher;
import org.apache.synapse.endpoints.dispatch.HttpSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SimpleClientSessionDispatcher;
import org.apache.synapse.endpoints.dispatch.SoapSessionDispatcher;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class LoadBalanceEndPointTransformer extends AbstractEndpointTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {

		Assert.isTrue(subject instanceof LoadBalanceEndPoint, "Invalid subject.");
		LoadBalanceEndPoint visualEndPoint = (LoadBalanceEndPoint) subject;
		Endpoint synapseEP = create(information, visualEndPoint, visualEndPoint.getName(), null);
		setEndpointToSendCallOrProxy(information, visualEndPoint, synapseEP);

		if (!information.isEndPointFound) {
			information.isEndPointFound = true;
			information.firstEndPoint = visualEndPoint;
		}

		if (visualEndPoint.getWestOutputConnector() != null) {
			if (visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
				InputConnector nextInputConnector = visualEndPoint.getWestOutputConnector().getOutgoingLink()
						.getTarget();
				if ((!(nextInputConnector instanceof SequenceInputConnector))
						|| ((((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink() != null) && (!(((Sequence) nextInputConnector
								.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))) {
					information.setParentSequence(information.getOriginOutSequence());
					information.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
				} else if (visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence) {
					information.setParentSequence(information.getCurrentReferredSequence());
				}
			}
		}

		List<EsbNode> transformedMediators = information.getTransformedMediators();
		if (visualEndPoint.getOutputConnector() != null && visualEndPoint.getWestOutputConnector() != null
				&& visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
			EsbNode nextElement = (EsbNode) visualEndPoint.getWestOutputConnector().getOutgoingLink().getTarget()
					.eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			doTransform(information, visualEndPoint.getWestOutputConnector());
			transformedMediators.add(nextElement);
		}

	}

	@Override
	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) throws TransformerException {

		Assert.isTrue(subject instanceof LoadBalanceEndPoint, "Invalid subject.");
		LoadBalanceEndPoint visualEndPoint = (LoadBalanceEndPoint) subject;
		endPoints.add(create(info, visualEndPoint, visualEndPoint.getEndPointName(), endPoints));

	}

	@Override
	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		Assert.isTrue(subject instanceof LoadBalanceEndPoint, "Invalid subject");
		LoadBalanceEndPoint visualEndPoint = (LoadBalanceEndPoint) subject;
		Endpoint synapseEP = create(information, visualEndPoint, visualEndPoint.getEndPointName(), null);
		setEndpointToSendOrCallMediator(sequence, synapseEP);
	}

	public LoadbalanceEndpoint create(TransformationInfo info,
			LoadBalanceEndPoint visualEndPoint, String name,
			List<Endpoint> endPoints) throws TransformerException {

		if (StringUtils.isEmpty(visualEndPoint.getName())) {
			throw new TransformerException(
					"Load-BalanceEndPoint should be configured. Double click on endpoint to configure.");
		}
		IEditorPart editorPart = null;
		IProject activeProject = null;
		List<Endpoint> endPointsList = new ArrayList<Endpoint>();
		EndpointDefinition synapseEPDef = new EndpointDefinition();

		LoadbalanceEndpoint synapseLBEP;

		if (visualEndPoint.getSessionType().equals(LoadBalanceSessionType.NONE)) {
			synapseLBEP = new LoadbalanceEndpoint();
		} else {
			synapseLBEP = new SALoadbalanceEndpoint();

			Long sessionTimeout = visualEndPoint.getSessionTimeout();
			if (sessionTimeout != null) {
				((SALoadbalanceEndpoint) synapseLBEP).setSessionTimeout(sessionTimeout);
			}
		}

		if (StringUtils.isNotBlank(name)) {
			synapseLBEP.setName(name);
		}

		/*
		 * We should give this LoadbalanceAlgorithm class at runtime.User should
		 * be requested to give a class.
		 */
		try {
			Class<?> algorithmClass = Class.forName(visualEndPoint.getAlgorithm().trim());
			Object algorithm = algorithmClass.newInstance();
			if (algorithm instanceof LoadbalanceAlgorithm) {
				synapseLBEP.setAlgorithm((LoadbalanceAlgorithm) algorithm);
			}
		} catch (ClassNotFoundException e1) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error in Loadbalance Endpoint ! ",
					visualEndPoint.getAlgorithm().trim() + " algorithm class not found.");
			e1.printStackTrace();
		} catch (InstantiationException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error in Loadbalance Endpoint ! ",
					visualEndPoint.getAlgorithm().trim() + " algorithm class cannot be instantiated.");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error in Loadbalance Endpoint ! ",
					"Illegal access to " + visualEndPoint.getAlgorithm().trim() + " algorithm class.");
			e.printStackTrace();
		}

		switch (visualEndPoint.getSessionType()) {
		case SOAP:
			Dispatcher soapDispatcher = new SoapSessionDispatcher();
			((SALoadbalanceEndpoint) synapseLBEP).setDispatcher(soapDispatcher);
			break;
		case TRANSPORT:
			Dispatcher httpDispatcher = new HttpSessionDispatcher();
			((SALoadbalanceEndpoint) synapseLBEP).setDispatcher(httpDispatcher);
			break;
		case CLIENT_ID:
			Dispatcher csDispatcher = new SimpleClientSessionDispatcher();
			((SALoadbalanceEndpoint) synapseLBEP).setDispatcher(csDispatcher);
			break;
		case NONE:
			break;
		}

		synapseLBEP.setDefinition(synapseEPDef);
		saveProperties(visualEndPoint, synapseLBEP);

		if (!info.isEndPointFound) {
			info.isEndPointFound = true;
			info.firstEndPoint = visualEndPoint;
		}

		try {
			if (visualEndPoint.eContainer() instanceof EndpointDiagram) {
				ArrayList<LoadBalanceEndPointOutputConnector> connectors = new ArrayList<LoadBalanceEndPointOutputConnector>();
				connectors.addAll(visualEndPoint.getOutputConnector());

				for (LoadBalanceEndPointOutputConnector outputConnector : connectors) {
					if (outputConnector.getOutgoingLink() != null) {
						if (outputConnector.getOutgoingLink().getTarget() != null) {
							EsbNode esbNode = (EsbNode) outputConnector.getOutgoingLink().getTarget().eContainer();
							EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(
									esbNode);
							transformer.createSynapseObject(info, esbNode, endPointsList);
						}
					}
				}
			} else {

				IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getEditorReferences();
				for (int i = 0; i < editorReferences.length; i++) {
					IEditorPart editor = editorReferences[i].getEditor(false);

					if (editor != null) {
						editorPart = editor.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
					}

					if (editorPart != null) {
						IEsbEditorInput input = (IEsbEditorInput) editorPart.getEditorInput();
						IFile file = input.getXmlResource();
						activeProject = file.getProject();
					}
				}

				String endpointName = (String) visualEndPoint.getName();
				IPath location = new Path("src/main/synapse-config/complex-endpoints" + "/" + endpointName + ".xml");
				IFile file = activeProject.getFile(location);

				final String source = FileUtils.getContentAsString(file.getContents());

				OMElement element = AXIOMUtil.stringToOM(source);
				Properties properties = new Properties();
				properties.put(WSDLEndpointFactory.SKIP_WSDL_PARSING, "true");
				synapseLBEP = (LoadbalanceEndpoint) EndpointFactory.getEndpointFromElement(element, false, properties);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (synapseLBEP instanceof SALoadbalanceEndpoint) {
			synapseLBEP.setChildren(endPointsList);
		} else {
			if (endPointsList.size() > 0) {
				synapseLBEP.setChildren(endPointsList);
			} else {
				// Load Balance endpoint members.
				List<org.apache.axis2.clustering.Member> members = new ArrayList<org.apache.axis2.clustering.Member>();
				if (visualEndPoint.getMember() != null && visualEndPoint.getMember().size() > 0) {
					EList<Member> visualMembers = visualEndPoint.getMember();

					for (Member visualMember : visualMembers) {
						org.apache.axis2.clustering.Member member = new org.apache.axis2.clustering.Member(
								visualMember.getHostName(), -1);
						member.setHttpPort(Integer.parseInt(visualMember.getHttpPort()));
						member.setHttpsPort(Integer.parseInt(visualMember.getHttpsPort()));
						members.add(member);
					}
				}

				synapseLBEP.setMembers(members);
			}
		}

		return synapseLBEP;
	}

}
