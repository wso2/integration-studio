package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CloudConnectorAvailableConfigPropertyDescriptor extends PropertyDescriptor{

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String synapseNS = "http://ws.apache.org/ns/synapse";
	private Properties properties = new Properties();
	private final String TYPE_TEMPLATE="synapse/sequenceTemplate";
	private final String DEFAULT_VALUE="Select From Available Configurations";
	private final String configNameSeparator = "::";
	private final String connectorProperties = "cloudConnector.properties";
	
	public CloudConnectorAvailableConfigPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}
	
	public CellEditor createPropertyEditor(Composite parent) {		
		ArrayList<String> definedTemplates = new ArrayList<String>();	
		definedTemplates.add(DEFAULT_VALUE);

		String pathName = EditorUtils.getActiveProject().getLocation().toOSString()+File.separator+"resources";
		File connectorPropertiesFile = new File(pathName, connectorProperties);
		if (connectorPropertiesFile.exists()) {
			Properties prop = new Properties();
			
			try {
				prop.load(new FileInputStream(pathName + File.separator + connectorProperties));
			} catch (FileNotFoundException e) {
				log.error("Connector configurations are not available for the project", e);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String localEntryConfigs=prop.getProperty("LOCAL_ENTRY_CONFIGS");
			if (localEntryConfigs != null) {
				String[] configs = localEntryConfigs.split(",");

				for (int i = 0; i < configs.length; ++i) {
					if (!"".equals(configs[i])) {
						if (configs[i].split(configNameSeparator)[1]
								.equals(((CloudConnectorOperation) object).getCloudConnectorName())) {
							definedTemplates.add(configs[i].split(configNameSeparator)[0]);
						}
						// esbPaletteFactory.addCloudConnectorOperations(getEditor(0),
						// configs[i].split("-")[0],configs[i].split("-")[1]);
					}
				}
			}
		}

		final Object object_=this.object;
		
/*		
		
		
		
		
		File projectPath = null;
		final Object object_=this.object;
		final Shell shell=(Shell)parent.getShell();
		final IEditorPart editor=(IEditorPart) ((WorkbenchWindow)shell.getDisplay().getActiveShell().getData()).getActivePage().getActiveEditor();
		if (editor != null) {
			IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
			IFile file = input.getFile();
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
								definedTemplates.add(artifact.getName().replaceAll("[.]xml$", ""));
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
		final File projectPath_ =projectPath;*/
		
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
/*				TransactionalEditingDomain editingDomain=null;
				String path = projectPath_ + "/src/main/synapse-config/templates/" + getValue()	+ ".xml";
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
					}	*/				
					
				
					if(getValue()!=null && !DEFAULT_VALUE.equals(getValue().toString())){					
						SetCommand setCmd = new SetCommand(TransactionUtil.getEditingDomain(object_), (EObject) object_,
								EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONFIG_REF, getValue().toString());
						if (setCmd.canExecute()) {
							TransactionUtil.getEditingDomain(object_).getCommandStack().execute(setCmd);
						}
					}
				}			
			//}
		};
	}

}
