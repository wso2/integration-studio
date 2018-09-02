package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.util.ESBProjectWizardModel;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.util.TemplateProjectWizardModel;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class HelloWorldTemplateProjectWizard extends TemplateProjectWizard{
    
    String name = "HelloWorld";
    ESBProjectArtifact esbProjectArtifact;
    File pomfile;

    @Override
    protected TemplateProjectWizardModel fillWizardModel() {
        ESBProjectWizardModel esbProjectWizardModel = new ESBProjectWizardModel();
        esbProjectWizardModel.setPageTitle(TemplateProjectConstants.PROJECT_WIZARD_PAGE_TITLE);
        esbProjectWizardModel.setPageDescription(TemplateProjectConstants.PROJECT_WIZARD_PAGE_DESCRIPTION);
        esbProjectWizardModel.setWizardPageText(TemplateProjectConstants.WIZARD_PAGE_TEXT);
        esbProjectWizardModel.setWindowTitle(TemplateProjectConstants.PROJECT_WIZARD_TITLE);
        return esbProjectWizardModel;
    }
    
    @Override
    protected void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {
        createESBProject(containerName, monitor);         
    }
    
    private void createESBProject(String containerName, IProgressMonitor monitor) throws CoreException {
        IProject project = createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);
        pomfile = project.getFile("pom.xml").getLocation().toFile();
        try {
            createPOM(pomfile, containerName);
            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);
            esbProjectArtifact = new ESBProjectArtifact();
            IFile file = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(file.getLocation().toFile());
            esbProjectArtifact.toFile();
            copyFiles(project, 
                    "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "proxy-services");
        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating pom file for project " + containerName, ex);
        }
    }
    
    private void copyFiles(IProject esbProject, String targetLocation) {

        IContainer location = esbProject.getFolder(targetLocation);
        try {
            ArrayList<File> importFiles = getSampleResourceFiles();
            for (File importFile : importFiles) {
                String sampleFileName = name + ".xml";
                File sampleFile = new File(sampleFileName);
                IFile proxyServiceFile = location.getFile(new Path(sampleFile.getName()));
                File destFile = proxyServiceFile.getLocation().toFile();
                FileUtils.copy(importFile, destFile);
                String grpID = groupId + ".proxy-service";
                String relativePath = FileUtils
                        .getRelativePath(location.getProject().getLocation().toFile(),
                                new File(location.getLocation().toFile(), sampleFileName))
                        .replaceAll(Pattern.quote(File.separator), "/");
                esbProjectArtifact.addESBArtifact(createArtifact(sampleFileName, grpID, version, relativePath,
                        "synapse/proxy-service", "EnterpriseServiceBus"));
                esbProjectArtifact.toFile();
                esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }
    
    private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type, String serverRole) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType(type);
        artifact.setServerRole(serverRole);
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }
    
    private ArrayList<File> getSampleResourceFiles() throws IOException {
        ArrayList<File> arrayList = new ArrayList<>();
        arrayList.add(ProxyServiceTemplateUtils.getInstance().getResourceFile("Samples/HelloWorld/HelloWorld.xml"));
        return arrayList;
    }

}
