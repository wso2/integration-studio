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
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class FailoverEndPointTransformer extends AbstractEndpointTransformer {

	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {

		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		FailoverEndpoint synapseEP = create(info, visualEndPoint, visualEndPoint.getName(), null);
		setEndpointToSendCallOrProxy(info, visualEndPoint, synapseEP);

		if (!info.isEndPointFound) {
			info.isEndPointFound = true;
			info.firstEndPoint = visualEndPoint;
		}

		if (visualEndPoint.getWestOutputConnector() != null) {
			if (visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
				InputConnector nextInputConnector = visualEndPoint.getWestOutputConnector().getOutgoingLink()
						.getTarget();
				if ((!(nextInputConnector instanceof SequenceInputConnector))
						|| ((((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink() != null) && (!(((Sequence) nextInputConnector
								.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))) {
					info.setParentSequence(info.getOriginOutSequence());
					info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
				} else if (visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence) {
					info.setParentSequence(info.getCurrentReferredSequence());
				}
			}
		}

		List<EsbNode> transformedMediators = info.getTransformedMediators();
		if (visualEndPoint.getOutputConnector() != null && visualEndPoint.getWestOutputConnector() != null
				&& visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
			EsbNode nextElement = (EsbNode) visualEndPoint.getWestOutputConnector().getOutgoingLink().getTarget()
					.eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			doTransform(info, visualEndPoint.getWestOutputConnector());
			transformedMediators.add(nextElement);
		}

	}

	@Override
	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) throws TransformerException {

		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		endPoints.add(create(info, visualEndPoint, visualEndPoint.getEndPointName(), endPoints));

	}

	@Override
	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		Endpoint synapseEP = create(information, visualEndPoint, visualEndPoint.getEndPointName(), null);
		setEndpointToSendOrCallMediator(sequence, synapseEP);
	}

	public FailoverEndpoint create(TransformationInfo info, FailoverEndPoint visualEndPoint, String name,
			List<Endpoint> endPoints) throws TransformerException {
		
		if (StringUtils.isEmpty(visualEndPoint.getName())) {
			throw new TransformerException(
					"FailoverEndPoint should be configured. Double click on endpoint to configure.");
		}
		
		IEditorPart editorPart = null;
		IProject activeProject = null;
		FailoverEndpoint synapseFailEP = new FailoverEndpoint();

		if (StringUtils.isNotBlank(name)) {
			synapseFailEP.setName(name);
		}

		EndpointDefinition synapseEPDef = new EndpointDefinition();
		List<Endpoint> endPointsList = new ArrayList<Endpoint>();
		synapseFailEP.setChildren(endPointsList);
		synapseFailEP.setDefinition(synapseEPDef);
		saveProperties(visualEndPoint, synapseFailEP);

		if (!info.isEndPointFound) {
			info.isEndPointFound = true;
			info.firstEndPoint = visualEndPoint;
		}
		try {
			if (visualEndPoint.eContainer() instanceof EndpointDiagram) {
				ArrayList<FailoverEndPointOutputConnector> connectors = new ArrayList<FailoverEndPointOutputConnector>();
				connectors.addAll(visualEndPoint.getOutputConnector());
				for (FailoverEndPointOutputConnector outputConnector : connectors) {
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
				synapseFailEP = (FailoverEndpoint) EndpointFactory.getEndpointFromElement(element, false, properties);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return synapseFailEP;
	}
}
