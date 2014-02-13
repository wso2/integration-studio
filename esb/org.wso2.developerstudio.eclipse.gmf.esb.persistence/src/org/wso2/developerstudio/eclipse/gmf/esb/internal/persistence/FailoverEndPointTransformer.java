package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.FailoverEndpoint;
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
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpointsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbTransformerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class FailoverEndPointTransformer extends AbstractEndpointTransformer{

	public void transform(TransformationInfo info, EsbNode subject)
			throws Exception {
		//try{
		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		FailoverEndpoint synapseEP = create(info, visualEndPoint, visualEndPoint.getEndPointName(), null);
		setEndpointToSendCallOrProxy(info, visualEndPoint, synapseEP);
		
		if(!info.isEndPointFound){
			info.isEndPointFound=true;
			info.firstEndPoint=visualEndPoint;
		}
		
		if(visualEndPoint.getWestOutputConnector()!=null){
			if(visualEndPoint.getWestOutputConnector().getOutgoingLink() !=null){
			InputConnector nextInputConnector=visualEndPoint.getWestOutputConnector().getOutgoingLink().getTarget();
			if((!(nextInputConnector instanceof SequenceInputConnector))||
					((((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink()!=null)&&(!(((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))){
				info.setParentSequence(info.getOriginOutSequence());
				info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
			}else if(visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence){
				info.setParentSequence(info.getCurrentReferredSequence());
			}
			}
		}
		
		List<EsbNode> transformedMediators = info.getTransformedMediators();
		if (visualEndPoint.getOutputConnector() != null && visualEndPoint.getWestOutputConnector() !=null && visualEndPoint.getWestOutputConnector().getOutgoingLink()!=null) {
			EsbNode nextElement = (EsbNode) visualEndPoint.getWestOutputConnector().getOutgoingLink().getTarget().eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			doTransform(info, visualEndPoint.getWestOutputConnector());
			transformedMediators.add(nextElement);
		}

		
		
/*		if(!info.isEndPointFound){
			info.isEndPointFound=true;
			info.firstEndPoint=visualEndPoint;
		}		
		
		
		ArrayList<ComplexEndpointsOutputConnector> connectors=createAllEndpoints(visualEndPoint);
		
		for (ComplexEndpointsOutputConnector outputConnector : connectors) {
			if(outputConnector.getOutgoingLink()!=null){
				if(outputConnector.getOutgoingLink().getTarget()!=null){
			EsbNode esbNode=(EsbNode)outputConnector.getOutgoingLink().getTarget().eContainer();
			EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(esbNode);
			transformer.createSynapseObject(info,esbNode,endPoints);
						
			}
			}
		}*/
		
/*	}
	catch(Exception e){
		e.printStackTrace();
	}*/
		
	}

	
	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
		//try{
		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		create(info, visualEndPoint, visualEndPoint.getEndPointName(), endPoints);
		
/*		org.apache.synapse.endpoints.FailoverEndpoint synapseFailEP = new org.apache.synapse.endpoints.FailoverEndpoint();
		EndpointDefinition synapseEPDef = new EndpointDefinition();
		
		List<Endpoint>endPointsList= new ArrayList<Endpoint>();
		synapseFailEP.setChildren(endPointsList);
		synapseFailEP.setDefinition(synapseEPDef);
		endPoints.add(synapseFailEP);
		
		if(!info.isEndPointFound){
			info.isEndPointFound=true;
			info.firstEndPoint=visualEndPoint;
		}
		
		ArrayList<ComplexEndpointsOutputConnector> connectors=createAllEndpoints(visualEndPoint);
		
		for (ComplexEndpointsOutputConnector outputConnector : connectors) {
			if(outputConnector.getOutgoingLink()!=null){
				if(outputConnector.getOutgoingLink().getTarget()!=null){
			EsbNode esbNode=(EsbNode)outputConnector.getOutgoingLink().getTarget().eContainer();
			EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance().getTransformer(esbNode);
			transformer.createSynapseObject(info,esbNode,endPointsList);						
			}
			}
		}*/
/*		}
		catch(Exception e){
			e.printStackTrace();
		}	*/	
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject");
		FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
		Endpoint synapseEP = create(information, visualEndPoint, visualEndPoint.getEndPointName(), null);
		setEndpointToSendOrCallMediator(sequence, synapseEP);
	}
	
	public FailoverEndpoint create(TransformationInfo info, FailoverEndPoint visualEndPoint,
			String name,List<Endpoint> endPoints) {
		FailoverEndpoint synapseFailEP = new FailoverEndpoint();
		
		if (StringUtils.isNotBlank(name)) {
			synapseFailEP.setName(name);
		}
		
		EndpointDefinition synapseEPDef = new EndpointDefinition();
		List<Endpoint> endPointsList = new ArrayList<Endpoint>();
		synapseFailEP.setChildren(endPointsList);
		synapseFailEP.setDefinition(synapseEPDef);
		saveProperties(visualEndPoint,synapseFailEP);
		if(endPoints!=null){
			endPoints.add(synapseFailEP);
		}

		if (!info.isEndPointFound) {
			info.isEndPointFound = true;
			info.firstEndPoint = visualEndPoint;
		}
		try {
			ArrayList<ComplexEndpointsOutputConnector> connectors = createAllEndpoints(visualEndPoint);

			for (ComplexEndpointsOutputConnector outputConnector : connectors) {
				if (outputConnector.getOutgoingLink() != null) {
					if (outputConnector.getOutgoingLink().getTarget() != null) {
						EsbNode esbNode = (EsbNode) outputConnector.getOutgoingLink().getTarget()
								.eContainer();
						EsbNodeTransformer transformer = EsbTransformerRegistry.getInstance()
								.getTransformer(esbNode);
						transformer.createSynapseObject(info, esbNode, endPointsList);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return synapseFailEP;
	}
	
	private ArrayList<ComplexEndpointsOutputConnector> createAllEndpoints(FailoverEndPoint failoverEndPoint) throws Exception{
		IEditorPart editorPart = null;
		IProject activeProject = null;
		ArrayList<ComplexEndpointsOutputConnector> outputConnectors= new ArrayList<ComplexEndpointsOutputConnector>();
		
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
		
		String name = (String) failoverEndPoint.getName();
		IPath location = new Path("src/main/graphical-synapse-config/complex_endpoints" + "/" + "complex_endpoint_"
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
				if (esbElement instanceof ComplexEndpoints){
					outputConnectors.addAll(((ComplexEndpoints)esbElement).getOutputConnector()); 
				}
			}
		}		
		return outputConnectors;
	}
}
