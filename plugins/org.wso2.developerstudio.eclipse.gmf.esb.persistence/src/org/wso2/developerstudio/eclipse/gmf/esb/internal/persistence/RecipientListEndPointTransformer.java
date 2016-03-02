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
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RecipientListEndPointTransformer extends AbstractEndpointTransformer {

	public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
		Assert.isTrue(subject instanceof RecipientListEndPoint, "Invalid subject.");
		RecipientListEndPoint endPointModel = (RecipientListEndPoint) subject;
		Endpoint synapseEP;
		try {
			synapseEP = create(info, endPointModel, endPointModel.getName(), null);

		setEndpointToSendCallOrProxy(info, endPointModel, synapseEP);

		if (!info.isEndPointFound) {
			info.isEndPointFound = true;
			info.firstEndPoint = endPointModel;
		}

		if (endPointModel.getWestOutputConnector() != null) {
			if (endPointModel.getWestOutputConnector().getOutgoingLink() != null) {
				InputConnector nextInputConnector = endPointModel.getWestOutputConnector().getOutgoingLink()
						.getTarget();
				if ((!(nextInputConnector instanceof SequenceInputConnector))
						|| ((((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink() != null) && (!(((Sequence) nextInputConnector
								.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))) {
					info.setParentSequence(info.getOriginOutSequence());
					info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
				} else if (endPointModel.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence) {
					info.setParentSequence(info.getCurrentReferredSequence());
				}
			}
		}

		List<EsbNode> transformedMediators = info.getTransformedMediators();
		if (endPointModel.getOutputConnector() != null && endPointModel.getWestOutputConnector() != null
				&& endPointModel.getWestOutputConnector().getOutgoingLink() != null) {
			EsbNode nextElement = (EsbNode) endPointModel.getWestOutputConnector().getOutgoingLink().getTarget()
					.eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			doTransform(info, endPointModel.getWestOutputConnector());
			transformedMediators.add(nextElement);
		}
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}

	}

	@Override
	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
			throws TransformerException {
		Assert.isTrue(subject instanceof RecipientListEndPoint, "Invalid subject.");
		RecipientListEndPoint model = (RecipientListEndPoint) subject;
		try {
			endPoints.add(create(info, model, model.getEndPointName(), endPoints));
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	@Override
	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence)
			throws TransformerException {
		Assert.isTrue(subject instanceof RecipientListEndPoint, "Invalid subject");
		RecipientListEndPoint endPointModel = (RecipientListEndPoint) subject;
		Endpoint synapseEP;
		try {
			synapseEP = create(information, endPointModel, endPointModel.getEndPointName(), null);
			setEndpointToSendOrCallMediator(sequence, synapseEP);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}

	public RecipientListEndpoint create(TransformationInfo info,
			RecipientListEndPoint model, String name, List<Endpoint> endPoints)
			throws JaxenException, TransformerException {
		
		if (StringUtils.isEmpty(model.getName())) {
			throw new TransformerException(
					"RecipientListEndPoint should be configured. Double click on endpoint to configure.");
		}
		
		RecipientListEndpoint recipientList;
		IEditorPart editorPart = null;
		IProject activeProject = null;

		if (model.getEndpointType().getLiteral().equals(RecipientListEndpointType.VALUE.getLiteral())
				|| model.getEndpointType().getLiteral().equals(RecipientListEndpointType.XPATH.getLiteral())) {
			recipientList = new RecipientListEndpoint(model.getMaxCache());
		} else {
			recipientList = new RecipientListEndpoint();
		}

		if (StringUtils.isNotBlank(name)) {
			recipientList.setName(name);
		}

		if (model.getEndpointType().getLiteral().equals(RecipientListEndpointType.VALUE.getLiteral())) {
			Value dynamicEnpointSet = new Value(model.getEndpointsValue());
			recipientList.setDynamicEnpointSet(dynamicEnpointSet);
		} else if (model.getEndpointType().getLiteral().equals(RecipientListEndpointType.XPATH.getLiteral())) {
			if (model.getEndpointsExpression() != null) {
				NamespacedProperty endpointsExpression = model.getEndpointsExpression();
				SynapseXPath xpath = new SynapseXPath(endpointsExpression.getPropertyValue());

				for (Entry<String, String> entry : endpointsExpression.getNamespaces().entrySet()) {
					xpath.addNamespace(entry.getKey(), entry.getValue());
				}
				Value dynamicEnpointSet = new Value(xpath);

				recipientList.setDynamicEnpointSet(dynamicEnpointSet);
			}

		} else {
			EndpointDefinition synapseEPDef = new EndpointDefinition();
			List<Endpoint> endPointsList = new ArrayList<Endpoint>();
			recipientList.setChildren(endPointsList);
			recipientList.setDefinition(synapseEPDef);

			if (!info.isEndPointFound) {
				info.isEndPointFound = true;
				info.firstEndPoint = model;
			}
			try {
				if (model.eContainer() instanceof EndpointDiagram) {
					ArrayList<RecipientListEndPointOutputConnector> connectors = new ArrayList<RecipientListEndPointOutputConnector>();
					connectors.addAll(model.getOutputConnector());

					for (RecipientListEndPointOutputConnector outputConnector : connectors) {
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

					String endpointName = (String) model.getName();
					IPath location = new Path("src/main/synapse-config/complex-endpoints" + "/" + endpointName + ".xml");
					IFile file = activeProject.getFile(location);

					final String source = FileUtils.getContentAsString(file.getContents());

					OMElement element = AXIOMUtil.stringToOM(source);
					Properties properties = new Properties();
					properties.put(WSDLEndpointFactory.SKIP_WSDL_PARSING, "true");
					recipientList = (RecipientListEndpoint) EndpointFactory.getEndpointFromElement(element, false,
							properties);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Serialize the parameters
		saveProperties(model, recipientList);
		return recipientList;
	}

}
