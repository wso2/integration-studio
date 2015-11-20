package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.part.EndpointCreationWizardPage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.part.TemplateCreationWizardPage;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.*;

/**
 * @generated NOT
 */
public class EsbCreationWizard extends Wizard implements INewWizard, IExecutableExtension {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected EsbCreationWizardPage diagramModelFilePage;

	protected TemplateCreationWizardPage templateCreationPage;

	protected EndpointCreationWizardPage endpointCreationPage;
	/**
	 * @generated NOT
	 */
	/*protected EsbCreationWizardPage domainModelFilePage;*/

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	private IProject esbProject;

	private ESBProjectArtifact esbProjectArtifact;

	private URI fileCreationLocationDiagram;

	private URI fileCreationLocationDomain;

	private IContainer location;

	private WizardMode wizardMode = WizardMode.DEFAULT;

	private String defaultFilename = "synapse";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.EsbCreationWizardTitle);
		setDefaultPageImageDescriptor(EsbDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewEsbWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated NOT
	 */
	public void addPages() {
		diagramModelFilePage = new EsbCreationWizardPage("DiagramModelFile", getSelection(), null); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(Messages.EsbCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(Messages.EsbCreationWizard_DiagramModelFilePageDescription);
		diagramModelFilePage.setDefaultFilename(getDefaultFilename());
		addPage(diagramModelFilePage);

		switch (wizardMode) {
		case TEMPLATE:
			templateCreationPage = new TemplateCreationWizardPage("TemplateCreation");
			addPage(templateCreationPage);
			break;

		case ENDPOINT:
			endpointCreationPage = new EndpointCreationWizardPage("EndpointCreation");
			addPage(endpointCreationPage);
			break;

		}

		/* removed domainModelFilePage */
		/*	domainModelFilePage = new EsbCreationWizardPage(
					"DomainModelFile", getSelection(), "esb") { //$NON-NLS-1$ //$NON-NLS-2$

				public void setVisible(boolean visible) {
					if (visible) {
						String fileName = diagramModelFilePage.getFileName();
						fileName = fileName.substring(0, fileName.length()
								- ".esb_diagram".length()); //$NON-NLS-1$
						setFileName(EsbDiagramEditorUtil.getUniqueFileName(
								getContainerFullPath(), fileName, "esb")); //$NON-NLS-1$
					}
					super.setVisible(visible);
				}
			};
			domainModelFilePage
					.setTitle(Messages.EsbCreationWizard_DomainModelFilePageTitle);
			domainModelFilePage
					.setDescription(Messages.EsbCreationWizard_DomainModelFilePageDescription);
			addPage(domainModelFilePage);*/
	}

	/**
	 * @generated NOT
	 */
	public boolean performFinish() {
		try {

			IRunnableWithProgress op = null;

			IPath containerFullPath = diagramModelFilePage.getContainerFullPath();

			esbProject = ResourcesPlugin.getWorkspace().getRoot().getProject(containerFullPath.segment(0));

			esbProjectArtifact = new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());

			location = esbProject.getFolder(SYNAPSE_RESOURCE_DIR);
			String type = null;

			switch (wizardMode) {
			case SEQUENCE:
				location = esbProject.getFolder(SEQUENCE_RESOURCE_DIR);
				op = createDiagram("sequence_", SEQUENCE_RESOURCE_DIR, "sequence", null);
				EditorUtils.updateToolpalette();
				type = "synapse/sequence";
				break;

			case PROXY:
				location = esbProject.getFolder(PROXY_RESOURCE_DIR);
				op = createDiagram("proxy_", PROXY_RESOURCE_DIR, "proxy", null);
				type = "synapse/proxy-service";
				break;

			case ENDPOINT:
				location = esbProject.getFolder(ENDPOINT_RESOURCE_DIR);
				op = createDiagram("endpoint_", ENDPOINT_RESOURCE_DIR, "endpoint", endpointCreationPage.selection);
				EditorUtils.updateToolpalette();
				type = "synapse/endpoint";
				break;

			case LOCALENTRY:
				location = esbProject.getFolder(LOCAL_ENTRY_RESOURCE_DIR);
				op = createDiagram("localentry_", LOCAL_ENTRY_RESOURCE_DIR, "localentry", null);
				type = "synapse/local-entry";
				break;

			case TEMPLATE:
				location = esbProject.getFolder(TEMPLATE_RESOURCE_DIR);
				if (templateCreationPage.sequenceRadioButton.getSelection()) {
					op = createDiagram("template_", TEMPLATE_RESOURCE_DIR, "template.sequence", null);
					type = "synapse/template";
				} else if (templateCreationPage.endpointRadioButton.getSelection()) {
					op = createDiagram("template_", TEMPLATE_RESOURCE_DIR, "template.endpoint",
							templateCreationPage.selection);
					type = "synapse/template";
				}

				break;

			case TASK:
				location = esbProject.getFolder(TASK_RESOURCE_DIR);
				op = createDiagram("task_", TASK_RESOURCE_DIR, "task", null);
				type = "synapse/task";
				break;

			case API:
				location = esbProject.getFolder(API_RESOURCE_DIR);
				op = createDiagram("api_", API_RESOURCE_DIR, "api", null);
				type = "synapse/api";
				break;

			case MAIN_SEQUENCE:
				location = esbProject.getFolder(SEQUENCE_RESOURCE_DIR);
				op = createDiagram("sequence_", SEQUENCE_RESOURCE_DIR, "main_sequence", null);
				type = "synapse/main_sequence";
				break;

			default:
				fileCreationLocationDiagram = URI.createPlatformResourceURI(location.getFullPath().toString() + "/"
						+ diagramModelFilePage.getFileName() + DIAGRAM_FILE_EXTENSION, false);
				fileCreationLocationDomain = URI.createPlatformResourceURI(location.getFullPath().toString() + "/"
						+ diagramModelFilePage.getFileName() + DOMAIN_FILE_EXTENSION, false);
				op = createSynapseDiagram();
				type = "synapse/configuration";
				break;
			}

			String relativePathDiagram = FileUtils.getRelativePath(esbProject.getLocation().toFile(), new File(location
					.getLocation().toFile(), diagramModelFilePage.getFileName() + ".xml"));
			relativePathDiagram = relativePathDiagram.replaceAll(Pattern.quote("\\"), "/");
			relativePathDiagram = relativePathDiagram.replaceFirst("/graphical-synapse-config", "/synapse-config");
			esbProjectArtifact.addESBArtifact(createArtifact(diagramModelFilePage.getFileName(),
					getMavenGroupID(esbProject, type), "1.0.0", relativePathDiagram, type));

			esbProjectArtifact.toFile();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			try {
				getContainer().run(false, true, op);
			} catch (InterruptedException e) {
				return false;
			} catch (InvocationTargetException e) {
				if (e.getTargetException() instanceof CoreException) {
					ErrorDialog.openError(getContainer().getShell(), Messages.EsbCreationWizardCreationError, null,
							((CoreException) e.getTargetException()).getStatus());
				} else {
					EsbDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
				}
				return false;
			}
			return diagram != null;

		} catch (Exception e) {
			ErrorDialog.openError(getContainer().getShell(), "Error creating diagram",
					"An unexpected error has occurred while creating diagram", Status.CANCEL_STATUS);
			// TODO: log error
		}
		return true;
	}

	private IRunnableWithProgress createSynapseDiagram() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				/*diagram = EsbDiagramEditorUtil.createDiagram(
						diagramModelFilePage.getURI(),
						domainModelFilePage.getURI(), monitor);  */
				diagram = EsbDiagramEditorUtil.createDiagram(fileCreationLocationDiagram, fileCreationLocationDomain,
						monitor);
				createXMLfile(diagramModelFilePage.getFileName(), diagram, SYNAPSE_RESOURCE_DIR);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						EsbDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), Messages.EsbCreationWizardOpenEditorError,
								null, e.getStatus());
					}
				}
			}
		};
		return op;
	}

	private IRunnableWithProgress createDiagram(final String extentionPrefix, final String dir, final String type,
			final Object specificType) {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				IPath fileLocation = new Path(location.getFullPath().toString() + "/" + extentionPrefix
						+ diagramModelFilePage.getFileName() + DIAGRAM_FILE_EXTENSION);
				IFile file = esbProject.getFile(dir + "/" + fileLocation.lastSegment());

				/*				if (!file.exists()) {
				 diagram = EsbDiagramEditorUtil.createResource(URI
				 .createPlatformResourceURI(location.getFullPath()
				 .toString()
				 + "/"
				 + extentionPrefix
				 + diagramModelFilePage.getFileName()
				 + DIAGRAM_FILE_EXTENSION, false), URI
				 .createPlatformResourceURI(location.getFullPath()
				 .toString()
				 + "/"
				 + extentionPrefix
				 + diagramModelFilePage.getFileName()
				 + DOMAIN_FILE_EXTENSION, false),
				 new NullProgressMonitor(), type,
				 diagramModelFilePage.getFileName(), specificType);
				 createXMLfile(diagramModelFilePage.getFileName(), diagram,
				 dir);
				 try {
				 EsbDiagramEditorUtil.openDiagram(diagram);

				 } catch (PartInitException e) {
				 ErrorDialog.openError(getContainer().getShell(),
				 Messages.EsbCreationWizardOpenEditorError,
				 null, e.getStatus());
				 }
				 }*/
			}
		};
		return op;
	}

	protected void createXMLfile(String name, Resource resource, String dir) {

		String xmlFilePath = dir.replaceAll("/graphical-synapse-config", "/synapse-config") + "/" + name + ".xml";
		IFile xmlFile = esbProject.getFile(xmlFilePath);
		EsbDiagram diagram = (EsbDiagram) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) resource.getContents()
				.get(0)).getElement();
		EsbServer server = diagram.getServer();

		String newSource = null;
		try {
			newSource = EsbModelTransformer.instance.designToSource(server);
			InputStream is = new ByteArrayInputStream(newSource.getBytes());
			xmlFile.create(is, true, null);
		} catch (Exception e) {
			log.warn("Could not create file " + xmlFile);
		}

	}

	private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		try {
			if (propertyName != null) {
				if ("class".equals(propertyName)) {
					if (data instanceof Map) {
						String type = (String) ((Map) data).get("mode");
						wizardMode = WizardMode.valueOf(type.toUpperCase());
						setDefaultFilename(wizardMode.toString().toLowerCase().replaceAll("^default$", "synapse"));
					}
				}
			}
		} catch (Exception e) {
			//ignore. Then wizard mode would be default.
		}
	}

	private String getMavenGroupID(IProject project, String type) {
		String groupID = "com.example";
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
			groupID = mavenProject.getGroupId();
		} catch (Exception e) {
			//ignore. Then group id would be default. 
		}

		return groupID + "." + type.substring(type.indexOf('/') + 1);
	}

	public void setDefaultFilename(String defaultFilename) {
		this.defaultFilename = defaultFilename;
	}

	public String getDefaultFilename() {
		return defaultFilename;
	}

	public enum WizardMode {
		DEFAULT("DEFAULT"), PROXY("PROXY"), SEQUENCE("SEQUENCE"), ENDPOINT("ENDPOINT"), LOCALENTRY("LOCALENTRY"), TEMPLATE(
				"TEMPLATE"), TASK("TASK"), API("API"), MAIN_SEQUENCE("MAIN_SEQUENCE");

		private final String mode;

		private WizardMode(final String text) {
			this.mode = text;
		}

		@Override
		public String toString() {
			return mode;
		}
	}

}
