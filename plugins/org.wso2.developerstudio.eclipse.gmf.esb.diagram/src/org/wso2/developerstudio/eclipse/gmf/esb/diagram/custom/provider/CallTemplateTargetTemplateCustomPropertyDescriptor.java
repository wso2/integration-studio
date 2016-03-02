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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.eclipse.ui.internal.WorkbenchWindow;

public class CallTemplateTargetTemplateCustomPropertyDescriptor extends PropertyDescriptor{
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String synapseNS = "http://ws.apache.org/ns/synapse";
	private Properties properties = new Properties();
	private final String TYPE_TEMPLATE="synapse/sequenceTemplate";
	private final String DEFAULT_VALUE="Select From Templates";
	
	public CallTemplateTargetTemplateCustomPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
	
	public CellEditor createPropertyEditor(Composite parent) {	
		Map<String, String> seqTemplateMap=new HashMap<String, String>();
		try {
			seqTemplateMap.putAll(getAvailableDynamicSequenceTemplates());
		} catch (CoreException e) {
			log.error("An unexpected error has occurred while getting Dynamic Sequence Templates", e);
		} catch (IOException e) {
			log.error("I/O error has occurred while getting Dynamic Sequence Templates", e);
		}		
		File projectPath = null;
		final Object object_=this.object;
		final Shell shell=(Shell)parent.getShell();
		final IEditorPart editor=(IEditorPart) ((WorkbenchWindow)shell.getDisplay().getActiveShell().getData()).getActivePage().getActiveEditor();
		if (editor != null) {
			EsbEditorInput input = (EsbEditorInput) editor.getEditorInput();
			IFile file = input.getXmlResource();
			IProject activeProject = file.getProject();
			//FIXME: scan whole workspace
			try {
				if (activeProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
					ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
					projectPath = activeProject.getLocation().toFile();
					try {
						esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile());
						List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
						for (ESBArtifact esbArtifact : allESBArtifacts) {
							if (TYPE_TEMPLATE.equals(esbArtifact.getType())) {
								File artifact = new File(projectPath, esbArtifact.getFile());
								String key=artifact.getName().replaceAll("[.]xml$", "");								
								seqTemplateMap.put(key, projectPath + File.separator+"src"+File.separator+"main"+File.separator+"synapse-config"+File.separator+"templates"+ File.separator + key + ".xml");
							}
						}
					} catch (Exception e) {
						log.error("Error occured while scanning the project for " + TYPE_TEMPLATE+ " artifacts", e);
						ErrorDialog.openError(shell,"Error occured while scanning the project for " + TYPE_TEMPLATE+ " artifacts", e.getMessage(), null);
					}
				}
			} catch (CoreException e) {
				log.error("Error occured while scanning the project", e);
				ErrorDialog.openError(shell,"Error occured while scanning the project", e.getMessage(), null);
			}
		}
		final Map<String, String> seqTemplateMap_=seqTemplateMap;		
		ArrayList<String> definedTemplates = new ArrayList<String>();	
		definedTemplates.add(DEFAULT_VALUE);
		definedTemplates.addAll(seqTemplateMap.keySet());
		
		/*
		 * A custom comboBox control which has available templates in its list will be returned.   
		 */
		return new ExtendedComboBoxCellEditor(parent,definedTemplates,getLabelProvider()){	
			/*
			 * The purpose of overriding this 'focusLost' method is to fill the parameters dialog of the callTemplate mediator
			 * with parameters of the selected template.  
			 */
			protected void focusLost() {
				super.focusLost();
				TransactionalEditingDomain editingDomain=null;				
				String path=seqTemplateMap_.get(getValue());				
				if(!DEFAULT_VALUE.equals(getValue().toString())){				
					try {
						String source = FileUtils.getContentAsString(new File(path));
						OMElement element = AXIOMUtil.stringToOM(source);
	
						if (element.getFirstChildWithName(new QName(synapseNS, "sequence", null)) != null) {
							TemplateMediatorFactory templateMediatorFactory = new TemplateMediatorFactory();
							TemplateMediator templateMediator = (TemplateMediator) templateMediatorFactory.createMediator(element, properties);						
							editingDomain =((EsbMultiPageEditor)editor).getGraphicalEditor().getEditingDomain();						
							DeleteCommand modelDeleteCommand = new DeleteCommand(editingDomain, ((CallTemplateMediator)object_).getTemplateParameters());
							if (modelDeleteCommand.canExecute()) {
								editingDomain.getCommandStack().execute(modelDeleteCommand);
							}						
							for (String parameter : templateMediator.getParameters()) {
								final CallTemplateParameter callTemplateParameter = EsbFactory.eINSTANCE.createCallTemplateParameter();
								callTemplateParameter.setParameterName(parameter);							
								if(editor instanceof EsbMultiPageEditor){
									RecordingCommand command = new RecordingCommand(editingDomain) {
										protected void doExecute() {
											((CallTemplateMediator)object_).getTemplateParameters().add(callTemplateParameter);
										}
									};
									if (command.canExecute()) {
										editingDomain.getCommandStack().execute(command);
									}
								}	
							}
						}
					} catch (XMLStreamException e) {
						log.error("Error occured while parsing selected template file", e);
					    ErrorDialog.openError(shell,"Error occured while parsing selected template file", e.getMessage(), null);
					}  catch (IOException e) {
						log.error("Error occured while reading selected template file", e);
						ErrorDialog.openError(shell,"Error occured while reading selected template file", e.getMessage(), null);
					}					
					
					SetCommand setCmd = new SetCommand(editingDomain, (EObject) object_,
							EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE, getValue().toString());
					if (setCmd.canExecute()) {
						editingDomain.getCommandStack().execute(setCmd);
					}		
				}			
			}
		};
	}	
	
	// TODO This method should be defined as a generic method rather defining here.
	public Map<String, String> getAvailableDynamicSequenceTemplates() throws CoreException, IOException {

		Map<String, String> availableTemplatesMap = new HashMap<String, String>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		for (IProject workspaceProject : projects) {
			if (workspaceProject.isOpen()
					&& workspaceProject.hasNature("org.wso2.developerstudio.eclipse.general.project.nature")) {
				GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
				try {
					generalProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
					List<RegistryArtifact> allGREGArtifacts = generalProjectArtifact.getAllArtifacts();
					for (RegistryArtifact registryArtifact : allGREGArtifacts) {
						if (registryArtifact.getType().equals("registry/resource")) {
							java.util.List<RegistryElement> elements = registryArtifact.getAllRegistryItems();
							for (RegistryElement registryElement : elements) {
								if (registryElement instanceof RegistryItem) {
									String mediaType = ((RegistryItem) registryElement).getMediaType();
									if (mediaType.equals("application/vnd.wso2.template")) {
										String filePath = workspaceProject.getLocation().toOSString() + File.separator
												+ ((RegistryItem) registryElement).getFile();
										String path = ((RegistryItem) registryElement).getPath() + "/"
												+ registryArtifact.getName() + ".xml"; // .xml is a constant for
																						// sequence temple type
										if (path.startsWith("/_system/governance/")) {
											path = String.format("gov:%s",
													path.substring("/_system/governance/".length()));
										} else if (path.startsWith("/_system/config/")) {
											path = String
													.format("conf:%s", path.substring("/_system/config/".length()));
										}
										availableTemplatesMap.put(path, filePath);
									}
								}
							}
						}
					}
				} catch (Exception e) {
					log.error("Error occured while scanning the workspace for Templates", e);
				}
			}
		}
		return availableTemplatesMap;
	}
}
