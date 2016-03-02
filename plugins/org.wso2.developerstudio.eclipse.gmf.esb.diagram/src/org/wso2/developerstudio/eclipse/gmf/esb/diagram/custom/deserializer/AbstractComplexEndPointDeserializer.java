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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.COMPLEX_ENDPOINT_RESOURCE_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SYNAPSE_CONFIG_DIR;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.commons.io.FileUtils;
import org.apache.synapse.config.xml.endpoints.EndpointSerializer;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ParentEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractComplexEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbDiagramEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbServerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment18EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment29EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;

public abstract class AbstractComplexEndPointDeserializer extends AbstractEsbNodeDeserializer<AbstractEndpoint, ParentEndPoint> {

	private static IDeveloperStudioLog log = Logger.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram");
	
	private EsbDiagramEditor mainDiagramEditorRef;
	
	protected <T extends AbstractEndpoint> void deserializeComplexEndpoint(T endpoint, IGraphicalEditPart graphicalEditPart){	
		
		IGraphicalEditPart gpart = null;
		String endpointName;


		
		if(endpoint.getChildren() != null && !endpoint.getChildren().isEmpty()){
			
			if (endpoint.getName() != null) {
				endpointName = endpoint.getName();
				executeSetValueCommand(EsbPackage.Literals.PARENT_END_POINT__NAME, endpointName);
			} else {
				long lDateTime = new Date().getTime();
				endpointName = String.valueOf(lDateTime);
				executeSetValueCommand(EsbPackage.Literals.PARENT_END_POINT__NAME, endpointName);
				// Setting a name for original endpoint if there was no name specified. Reason is, according to the
				// current design, anonymous complex endpoints(LB,Failover etc..) will be converted to a named endpoint
				// while deserialization.
				endpoint.setName(endpointName);
				endpoint.setAnonymous(false);
			}
			
			mainDiagramEditorRef = getDiagramEditor();
						
			IProject currentProject=getActiveProject();
					IFile fileTobeOpened = null;
					OMElement configOM = EndpointSerializer.getElementFromEndpoint(endpoint);
		
						try{
						IFolder iFolder = currentProject.getFolder(SYNAPSE_CONFIG_DIR + "/complex-endpoints/");
						if (!iFolder.exists()){
							iFolder.create(IResource.NONE, true, null);
						} 
						fileTobeOpened = iFolder.getFile(endpointName + ".xml");
						InputStream stream = new ByteArrayInputStream(configOM.toString().getBytes(StandardCharsets.UTF_8));
						if(!fileTobeOpened.exists()){
							fileTobeOpened.create(stream, true, new NullProgressMonitor());
						}else{
							fileTobeOpened.setContents(stream, false, false, null);		
						}						
						}catch(Exception e){
							log.error(e);
						}
			
						if(endpoint.getParentEndpoint() != null){// && ((AbstractEndpoint)endpoint.getParentEndpoint()).getParentEndpoint() != null){
							return;
						}
			
			//We can not get the editorPart without opening the editor.
/*			IEditorPart editorPart = createFiles(endpointName,
					"complex_endpoint_" + endpointName + ".esb_diagram",
					"complex_endpoint_" + endpointName + ".esb");*/
			
/*			
			if (editorPart != null && editorPart instanceof EsbMultiPageEditor) {

				EsbMultiPageEditor editor = (EsbMultiPageEditor) editorPart;*/
				
				/*
				 * Setting the sub editor editing domain to deserializerRegistry.
				 */
/*				EsbDiagramEditor subDiagramEditor = editor.getGraphicalEditor();
				if (subDiagramEditor != null) {
					EsbDeserializerRegistry.getInstance().init(subDiagramEditor);
				}*/
				
				final List<EditPart> editPartList = new ArrayList<EditPart>();
				
/*				if (editor.getDiagramEditPart() != null) {

					EsbDiagramEditPart esbDiagramEditPart = (EsbDiagramEditPart) editor.getDiagramEditPart();*/
				
					
/*					if (esbDiagramEditPart.getChildren() != null && !esbDiagramEditPart.getChildren().isEmpty()) {

						EsbServerEditPart esbServerEditPart = (EsbServerEditPart) esbDiagramEditPart.getChildren().get(0);
						
							EditPart childEditPart = (EditPart) esbServerEditPart.getChildren().get(0);*/
							
							//get the edit part for adding endpoints
							//gpart = findRelevntEditPart(childEditPart);
							gpart = findRelevntEditPart(graphicalEditPart);
							
							if (gpart != null) {

								for (Endpoint ep : endpoint.getChildren()) {
									
									 	@SuppressWarnings("rawtypes")
									 	IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(ep);

										@SuppressWarnings("unchecked")
										EsbNode visualEndpoint = deserializer.createNode(gpart, ep);
										refreshEditPartMap();
										EditPart endpointEP = getEditpart(visualEndpoint);
										editPartList.add(endpointEP);
									
								}
							}
					//}
				//}
				
				//final IEditorPart tempEp = editorPart;

				Display.getCurrent().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						relocateEndPoints(editPartList);	
						//Save the sub editor when the work done
						//tempEp.doSave(new NullProgressMonitor());
												
						//IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						//activePage.closeEditor(tempEp, false);
					}
				});
				
				/*
				 * Setting back main editor editing domain to deserializerRegistry.
				 */
				
				if(mainDiagramEditorRef != null){
					EsbDeserializerRegistry.getInstance().init(mainDiagramEditorRef);
					refreshEditPartMap();
				}
							
			//}
		}
	}
	
	/**
	 * This is to avoid RJS0007E Semantic refresh failed issue appears in
	 * compartments, which has only one node. This should be replaced with the
	 * better approach
	 */
	public static void relocateEndPoints(List<EditPart> editPartList){
		for (Iterator<EditPart> it = editPartList.iterator(); it.hasNext();) {
			EditPart next = it.next();

			GraphicalEditPart gEditpart = (GraphicalEditPart) next;
			Rectangle rect = gEditpart.getFigure().getBounds().getCopy();
			rect.y++;
			SetBoundsCommand sbc = new SetBoundsCommand(gEditpart.getEditingDomain(),
					"change location", new EObjectAdapter((View) next.getModel()), rect);

			gEditpart.getDiagramEditDomain().getDiagramCommandStack()
					.execute(new ICommandProxy(sbc));
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				//ignored
			}

		}
		editPartList = new ArrayList<EditPart>();
	}
	
	protected IGraphicalEditPart findRelevntEditPart(EditPart childEditPart) {
		
		IGraphicalEditPart gpartTemp = null;
		
		//Check child edit part it self AbstractComplexEndpointCompartmentEditPart
		if (childEditPart instanceof AbstractComplexEndpointCompartmentEditPart) {

			return (AbstractComplexEndpointCompartmentEditPart) childEditPart;
			
		} 
		else{
			// Check children of this AbstractComplexEndpointCompartmentEditPart
			if (childEditPart.getChildren() != null ) {
				
				for (Object child : childEditPart.getChildren()) {
					
					EditPart l2childEditPart = (EditPart) child;
					
					if (l2childEditPart instanceof AbstractComplexEndpointCompartmentEditPart) {

						return (AbstractComplexEndpointCompartmentEditPart) l2childEditPart;
						
					}else {
						
						gpartTemp = findRelevntEditPart(l2childEditPart);
						
						if(gpartTemp != null){
							
							break;
						}
						
					}
				}
			}
		}
		
		return gpartTemp;
	}
	
	protected IEditorPart createFiles(String name, String fileURI1, String fileURI2) {
		IEditorPart editorPart = null;
		Resource diagram;
		IProject currentProject=getActiveProject();

		String basePath = "platform:/resource/" + currentProject.getName() + "/" + COMPLEX_ENDPOINT_RESOURCE_DIR  + "/";
		
		IFile file = currentProject.getFile(COMPLEX_ENDPOINT_RESOURCE_DIR + "/"+ fileURI1);

		if (!file.exists()) {
			
			
			IFile fileTobeOpened = currentProject.getFile(SYNAPSE_CONFIG_DIR
					+ "/endpoints/" + name + ".xml");
			
			String path = fileTobeOpened.getParent().getFullPath() + "/";
			
/*			diagram = EsbDiagramEditorUtil.createResource(
					URI.createURI(basePath + fileURI1),
					URI.createURI(basePath + fileURI2),
					new NullProgressMonitor(), "complex_endpoint", name, null);*/
			String source;
			try {
				source = FileUtils.readFileToString(fileTobeOpened.getLocation().toFile());
				Openable openable = ESBGraphicalEditor.getOpenable();
				editorPart = openable.editorOpen(fileTobeOpened.getName(), ArtifactType.COMPLEX_ENDPOINT.getLiteral(), path, source);
			} catch (IOException e1) {
				log.error("Error while reading the file : "+fileTobeOpened, e1);
			} catch (Exception e) {
				log.error("Error while opening the file : "+fileTobeOpened, e);
			}			
/*			try {
				EsbDiagramEditorUtil.openDiagram(diagram);

			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}*/
			
		}
/*			
			diagram = EsbDiagramEditorUtil.createResource(
					URI.createURI(basePath + fileURI1),
					URI.createURI(basePath + fileURI2),
					new NullProgressMonitor(), "complex_endpoint", name, null);
			try {
				String path = diagram.getURI().toPlatformString(true);
				IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(new Path(path));
				if (workspaceResource instanceof IFile) {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage();
					editorPart =  page.openEditor(new FileEditorInput((IFile) workspaceResource),EsbDiagramEditor.ID);
				}
		

			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}
			
		}
		return editorPart;*/
		return editorPart;
		
	}
	
	protected IProject getActiveProject() {
		IEditorPart editorPart = null;
		IProject activeProject = null;
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
				EsbEditorInput input = (EsbEditorInput) editorPart
						.getEditorInput();
				IFile file = input.getXmlResource();
				activeProject = file.getProject();
			}
		}
		return activeProject;
	}
	
	
}
