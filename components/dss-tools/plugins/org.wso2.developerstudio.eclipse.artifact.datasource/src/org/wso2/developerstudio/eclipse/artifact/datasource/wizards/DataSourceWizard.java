package org.wso2.developerstudio.eclipse.artifact.datasource.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import javax.xml.stream.FactoryConfigurationError;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.*;

import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.datasource.artifact.DataSourceArtifact;
import org.wso2.developerstudio.eclipse.artifact.datasource.artifact.DataSourceProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.datasource.utils.DataSourceArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.datasource.utils.DataSourceTemplateUtils;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "xml". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class DataSourceWizard extends Wizard implements INewWizard {
	private static final String DATASOURCE_PLUGIN_ID = "org.wso2.developerstudio.eclipse.artifact.datasource";
	private DataSourceWizardPage page;
	private ISelection selection;

	private static final String POM_FILE = "pom.xml";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-datasource-plugin";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String TYPE = "datasource/datasource";
	private static final String SERVER_ROLE = "DataServicesServer";
	private static final String LINE_SEPERATOR = "line.separator";
	private static final String DATASERVICE_TEMPLATE = "templates/DataSourceTemplate.datasource";
	private String version = "1.0.0";
	
	private DataSourceProjectArtifact dssProjectArtifact;
	private IProject project;

	/**
	 * Constructor for DataSourceWizard.
	 */
	public DataSourceWizard() {
		super();
		setWindowTitle(DataSourceArtifactConstants.DS_WIZARD_WINDOW_TITLE);
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new DataSourceWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} catch (FactoryConfigurationError e) {
					throw new InvocationTargetException(e);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 * @throws Exception 
	 * @throws FactoryConfigurationError 
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws FactoryConfigurationError, Exception {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		project = container.getProject();
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream(project,fileName);
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
		}
		File mavenProjectPom = project.getFile(POM_FILE).getLocation().toFile();
		File dataSourceFile = file.getLocation().toFile();
		updateMavenPlugin(dataSourceFile, mavenProjectPom);
		String groupId = getMavenGroupID(mavenProjectPom)+ ".datasource";
		String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(), dataSourceFile).replaceAll(
				Pattern.quote(File.separator), "/");
		addMetaData(dataSourceFile, groupId, relativePath);

		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
					MessageDialog.openError(getShell(), "Error", e.getMessage());
				}
			}
		});
		monitor.worked(1);
	}
	
	private String getMavenGroupID(File pomFile) throws IOException, XmlPullParserException{
		String groupId = "org.wso2.carbon";
		if(pomFile!=null && pomFile.exists()){
			MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
			groupId = mavenProject.getGroupId();
		}
		return groupId;
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 * @throws Exception 
	 * @throws IOException 
	 */

	private InputStream openContentStream(IProject project,String fileName) throws IOException, Exception {
		String contents = FileUtils.getContentAsString(addDSTemplate(project,fileName));
		return new ByteArrayInputStream(contents.getBytes());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, DATASOURCE_PLUGIN_ID, IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
	/**
	 * Adds meta data
	 * 
	 * @param openFile
	 *            data service file
	 * @param groupId
	 *            group ID
	 * @param relativePath
	 *            relative path
	 * @throws FactoryConfigurationError
	 * @throws Exception
	 * @throws CoreException
	 */
	private void addMetaData(File openFile, String groupId, String relativePath) throws FactoryConfigurationError,
			Exception, CoreException {
		dssProjectArtifact = new DataSourceProjectArtifact();
		dssProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE).getLocation().toFile());

		String servieName = FilenameUtils.removeExtension(openFile.getName());
		dssProjectArtifact.addDSSArtifact(createArtifact(servieName, groupId, version, relativePath));
		dssProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}
	
	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updateMavenPlugin(File openFile, File mavenProjectPom) throws IOException, XmlPullParserException {
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPom);

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID)) {
			return;
		}

		Plugin pluginEntry = MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
				MavenConstants.MAVEN_DATASOURCE_PLUGIN_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("datasource");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		pluginEntry.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPom);
	}

	/**
	 * Creates artifact
	 * 
	 * @param name
	 *            artifact name
	 * @param groupId
	 *            group ID
	 * @param version
	 *            version
	 * @param path
	 *            path
	 * @return artifact
	 */
	private DataSourceArtifact createArtifact(String name, String groupId, String version, String path) {
		DataSourceArtifact artifact = new DataSourceArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(TYPE);
		artifact.setServerRole(SERVER_ROLE);
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}
	
	/**
	 * Adds the template
	 * 
	 * @param project
	 *            project
	 * @return datasource.xml file
	 * @throws Exception
	 */
	private File addDSTemplate(IProject project,String fileName) throws Exception{
		String eol = System.getProperty(LINE_SEPERATOR);
		ITemporaryFileTag dsTempTag = FileUtils.createNewTempTag();
		StringBuffer sb = new StringBuffer();
		File dsTemplateFile = new DataSourceTemplateUtils().getResourceFile(DATASERVICE_TEMPLATE);
		String templateContent = FileUtils.getContentAsString(dsTemplateFile);
		IFolder dsfolder = project.getFolder(DataSourceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File template = new File(dsfolder.getLocation().toFile(), fileName);
		templateContent = XMLUtil.prettify(templateContent);
		templateContent = templateContent.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		templateContent = templateContent.replaceAll("^" + eol, "");
		FileUtils.createFile(template, templateContent);
		dsTempTag.clearAndEnd();
		return template;
	}
}