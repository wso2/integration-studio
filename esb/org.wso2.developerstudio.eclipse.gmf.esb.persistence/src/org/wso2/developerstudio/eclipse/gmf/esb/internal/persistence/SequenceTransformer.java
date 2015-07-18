/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

import java.io.File;
import java.util.List;

import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class SequenceTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {	
		// Check subject.
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.Sequences,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.Sequences visualSequence = (org.wso2.developerstudio.eclipse.gmf.esb.Sequences) subject;
		if(visualSequence.isRecieveSequence()){
			handleServiceChaining(visualSequence,(SequenceMediator) information.getParentSequence(),visualSequence.getAssociatedProxy());
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// Check subject.
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.Sequences,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.Sequences visualSequence = (org.wso2.developerstudio.eclipse.gmf.esb.Sequences) subject;
		if(!"".equals(visualSequence.getOnError().getKeyValue())){
			sequence.setErrorHandler(visualSequence.getOnError().getKeyValue());
		}
		
		// Fixing TOOLS-2652
		sequence.setTraceState(visualSequence.isTraceEnabled() ? 1 : 0);

		AspectConfiguration aspectConfiguration = new AspectConfiguration(visualSequence.getName());
		sequence.configure(aspectConfiguration);
		if (visualSequence.isStatisticsEnabled()) {
			aspectConfiguration.enableStatistics();
		} else {
			aspectConfiguration.disableStatistics();
		}
		
		EsbLink outgoingLink= visualSequence.getOutputConnector().getOutgoingLink();
		doTransformWithinSequence(information, outgoingLink, sequence);	
	}
	
	private void handleServiceChaining(org.wso2.developerstudio.eclipse.gmf.esb.Sequences visualSequence,SequenceMediator sequence,List proxyNames) throws TransformerException{
		IEditorPart editorPart = null;
		IProject activeProject = null;
		Sequence currentSequence = null;
		
		IEditorReference editorReferences[] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);

			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow()
						.getActivePage().getActiveEditor();
			}

			if (editorPart != null) {
				IFileEditorInput input = (IFileEditorInput) editorPart
						.getEditorInput();
				IFile file = input.getFile();
				activeProject = file.getProject();
			}
		}	
		
		String name = (String) proxyNames.get(0);
		IPath location = new Path("src/main/graphical-synapse-config/proxy-services" + "/" + "proxy_"
				+ name + ".esb_diagram");
		IFile file = activeProject.getFile(location);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;

		File f = new File(file.getLocationURI().getPath());
		URI uri = URI.createFileURI(f.getAbsolutePath());

		if (!f.exists()) {

		} else {

			resource = resourceSet.getResource(uri, true);

			EsbDiagram s = (EsbDiagram) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) resource
					.getContents().get(0)).getElement();
			EList<EsbElement> children = s.getServer().getChildren();
			for (EsbElement esbElement : children) {
				if (esbElement instanceof ProxyService){
					ProxyService proxyService = (ProxyService) esbElement;
					List<EsbElement> elements = (List<EsbElement>) proxyService.getContainer().getSequenceAndEndpointContainer().getMediatorFlow().getChildren();
					for(EsbElement elem:elements){
						if((elem instanceof Sequence)&&(((Sequence)elem).getName().equals(visualSequence.getName()))){
							currentSequence=(Sequence) elem;
						}						
					}
				}
			}
			OutputConnector source=((EsbLink)currentSequence.getInputConnector().getIncomingLinks().get(0)).getSource();
			InputConnector target=null;
			if(currentSequence.getOutputConnector().get(0).getOutgoingLink()!=null){
				target = currentSequence.getOutputConnector().get(0).getOutgoingLink().getTarget();
			}
			
			if((source.eContainer() instanceof AbstractEndPoint)&&((target!=null)&&(target.eContainer() instanceof AbstractEndPoint))){
				
				EsbNodeTransformer transformer=EsbTransformerRegistry.getInstance().getTransformer((EsbNode)target.eContainer());
				TransformationInfo transformationInfo=new TransformationInfo();
				transformationInfo.setParentSequence(sequence);
				SendMediator sendMediator=new SendMediator();
				sequence.addChild(sendMediator);			
				
				if((getEndpointOutputConnector((AbstractEndPoint) target.eContainer())).getOutgoingLink()!=null){
					InputConnector nextTarget=(getEndpointOutputConnector((AbstractEndPoint) target.eContainer())).getOutgoingLink().getTarget();
					if(nextTarget.eContainer() instanceof Sequence){
						String sequenceName=((Sequence)nextTarget.eContainer()).getName();
						if(((Sequence)nextTarget.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof AbstractEndPoint){
							sendMediator.setReceivingSequence(new Value(sequenceName));
						}
					}
				}
				transformer.transformWithinSequence(transformationInfo,(EsbNode)target.eContainer(),sequence);				
			}
		}		
	}
	
	public static OutputConnector getEndpointOutputConnector(AbstractEndPoint endpoint){
		if(endpoint instanceof AddressEndPoint){
			return ((AddressEndPoint)endpoint).getOutputConnector();
		}else if(endpoint instanceof DefaultEndPoint){
			return ((DefaultEndPoint)endpoint).getOutputConnector();
		}else if(endpoint instanceof WSDLEndPoint){
			return ((WSDLEndPoint)endpoint).getOutputConnector();
		}else if(endpoint instanceof NamedEndpoint){
			return ((NamedEndpoint)endpoint).getOutputConnector();
		} else if(endpoint instanceof TemplateEndpoint){
			return ((TemplateEndpoint)endpoint).getOutputConnector();
        }
		return null;
	}
}
