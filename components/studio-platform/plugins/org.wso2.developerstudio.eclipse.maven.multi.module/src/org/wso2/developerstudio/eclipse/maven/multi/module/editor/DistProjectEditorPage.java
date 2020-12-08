/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.maven.multi.module.editor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Profile;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.dialogs.NewWizard;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.IIDEHelpContextIds;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.project.extensions.handlers.ProjectNatureListProvider;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * This class represents the editor page of the Maven Multi Module POM Editor.
 */
public class DistProjectEditorPage extends FormPage implements IResourceDeltaVisitor, IResourceChangeListener {

    private static final int TEXT_BOX_WIDTH = 350;
    private static final String EMPTY_STRING = "";
    private static final String SLASH = "/";
    private static final String REFRESH = "Refresh";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private final Image NEW_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");

    private IFile pomFileRes;
    private File pomFile;
    private MavenProject parentPrj;

    private FormToolkit toolkit;
    private ScrolledForm form;
    private Composite body;
    private Text txtGroupId;
    private Text txtArtifactId;
    private Text txtVersion;
    private Text txtDescription;
    private boolean pageDirty;

    IStatus editorStatus = new Status(IStatus.OK, Activator.PLUGIN_ID, EMPTY_STRING);

    private Map<String, ModuleData> moduleList = new LinkedHashMap<>();
    private SortedMap<String, ModuleData> projectList = Collections
            .synchronizedSortedMap(new TreeMap<String, ModuleData>(Collections.reverseOrder()));
    private Map<String, ModuleData> missingModuleList = new HashMap<>();

    private Tree trDependencies;
    private HashMap<String, TreeItem> treeNodes = new HashMap<>();
    private TreeEditor editor;

    private String projectName = EMPTY_STRING;
    private String groupId = EMPTY_STRING;
    private String artifactId = EMPTY_STRING;
    private String version = EMPTY_STRING;
    private String description = EMPTY_STRING;

    private Action refreshAction;

    public DistProjectEditorPage(String id, String title) {
        super(id, title);
    }

    public DistProjectEditorPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
    }

    /**
     * This method initializes the page by setting data.
     * 
     * @throws CoreException exceptions occurred while getting project data
     * @throws XmlPullParserException exceptions occurred while parsing xml files
     * @throws IOException exceptions occurred while manipulating projects files
     */
    public void initContent() throws CoreException, IOException, XmlPullParserException {
        pomFileRes = ((IFileEditorInput) (getEditor().getEditorInput())).getFile();
        pomFile = pomFileRes.getLocation().toFile();
        parentPrj = MavenUtils.getMavenProject(pomFile);
        SortedMap<String, ModuleData> projectList = getProjectsInTheWorkspace(parentPrj);
        Map<String, ModuleData> moduleList = new LinkedHashMap<>();

        // If propeties of pom in old format(DevS 3.2 or earlier) reformat it to new format.
        updatePomToNewFormat();

        // Create profiles if not exists
        boolean changed = updatePOMToProfiles(parentPrj);
        if (changed) {
            setPageDirty(true);
            updateDirtyState();
        }

        for (String module : parentPrj.getModel().getModules()) {
            ModuleData moduleData = getModuleDataFromModule(module);
            moduleList.put(moduleData.getRelativePath(), moduleData);
        }

        for (Profile profile : parentPrj.getModel().getProfiles()) {
            for (String module : profile.getModules()) {
                ModuleData moduleData = getModuleDataFromModule(module);
                if (!moduleList.containsKey(moduleData.getRelativePath())) {
                    moduleList.put(moduleData.getRelativePath(), moduleData);
                }
            }
        }

        setProjectName(parentPrj.getName());
        setArtifactId(parentPrj.getArtifactId());
        setGroupId(parentPrj.getGroupId());
        setVersion(parentPrj.getVersion());
        setDescription(parentPrj.getDescription());
        setProjectList(projectList);
        setModuleList(moduleList);
        setMissingModuleList((Map<String, ModuleData>) ((HashMap) getModuleList()).clone());
    }

    /**
     * Change the old maven POM files to have profiles.
     * 
     * @param mavenProject project to be changed
     * @return Whether any changes done to the project
     */
    private boolean updatePOMToProfiles(MavenProject mavenProject) {
        boolean changed = false;
        if (mavenProject.getModel().getProfiles().size() != Constants.getAllMavenMultiModuleProfiles().size()) {
            for (String profileName : Constants.getAllMavenMultiModuleProfiles()) {
                if (profileName.equals(Constants.DEFAULT_PROFILE)) {
                    MavenUtils.createProfileEntry(mavenProject, profileName, true);
                } else {
                    MavenUtils.createProfileEntry(mavenProject, profileName, false);
                }
            }
            changed = true;
        }
        while (!mavenProject.getBuild().getPlugins().isEmpty()) {
            Plugin plugin = mavenProject.getBuild().getPlugins().get(0);
            for (Profile profile : mavenProject.getModel().getProfiles()) {
                profile.getBuild().addPlugin(plugin);
            }
            mavenProject.getBuild().getPlugins().remove(plugin);
            changed = true;
        }
        return changed;
    }

    /**
     * This method save data in the design view to the POM file.
     * 
     * @throws IOException exceptions occurred while saving project files
     * @throws CoreException exceptions occurred while refreshing the project
     */
    public void savePOM() throws IOException, CoreException {
        if (editorStatus != null) {
            if (!editorStatus.isOK()) {
                ErrorDialog.openError(getSite().getShell(), "Warning", "The following warning(s) have been detected",
                        editorStatus);
                editorStatus = new Status(IStatus.OK, Activator.PLUGIN_ID, EMPTY_STRING);
            }
        }
        parentPrj.setGroupId(getGroupId());
        parentPrj.setVersion(getVersion());
        parentPrj.setDescription(getDescription());
        addModulesToProject(parentPrj);
        MavenUtils.saveMavenProject(parentPrj, pomFile);
        setPageDirty(false);
        updateDirtyState();
        pomFileRes.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

    /**
     * This method adds selected modules to the project.
     * 
     * @param mavenProject project to be altered
     */
    private void addModulesToProject(MavenProject mavenProject) {
        List<String> modules = new ArrayList<String>();
        List<String> dockerModules = new ArrayList<>();
        List<String> kubernetesModules = new ArrayList<>();
        for (String modulePath : getModuleList().keySet()) {
            ModuleData moduleData = getModuleList().get(modulePath);
            String nature = moduleData.getProjectNature();
            if (nature == null) {
                modules.add(modulePath);
            } else if (nature.equals(Constants.DOCKER_EXPORTER_PROJECT_NATURE)) {
                dockerModules.add(modulePath);
            } else if (nature.equals(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                kubernetesModules.add(modulePath);
            } else {
                modules.add(modulePath);
            }
        }

        // Get modules sorted
        modules = sortProjectsInBuildOrder(modules);

        Profile dockerProfile = null;
        Profile kubernetesProfile = null;
        Profile defaultProfile = null;

        for (Profile profile : mavenProject.getModel().getProfiles()) {
            if (profile.getId().equals(Constants.DOCKER_PROFILE)) {
                dockerProfile = profile;
            } else if (profile.getId().equals(Constants.KUBERNETES_PROFILE)) {
                kubernetesProfile = profile;
            } else {
                defaultProfile = profile;
            }
        }

        mavenProject.getModules().clear();
        dockerProfile.getModules().clear();
        kubernetesProfile.getModules().clear();
        defaultProfile.getModules().clear();

        for (String module : modules) {
            if (!mavenProject.getModules().contains(module)) {
                mavenProject.getModules().add(module);
            }
        }

        for (String module : dockerModules) {
            if (!dockerProfile.getModules().contains(module)) {
                dockerProfile.getModules().add(module);
            }
            if (!defaultProfile.getModules().contains(module)) {
                defaultProfile.getModules().add(module);
            }
        }

        for (String module : kubernetesModules) {
            if (!kubernetesProfile.getModules().contains(module)) {
                kubernetesProfile.getModules().add(module);
                defaultProfile.getModules().add(module);
            }
            if (!defaultProfile.getModules().contains(module)) {
                defaultProfile.getModules().add(module);
            }
        }
    }

    /**
     * This methods sorts modules according to the order which they should be built.
     * 
     * @param modules modules to be sorted
     * @return sorted modules
     */
    private List<String> sortProjectsInBuildOrder(List<String> modules) {
        List<List<String>> moduleMap = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            moduleMap.add(new ArrayList<String>());
        }

        for (String module : modules) {
            String nature = getModuleList().get(module).getProjectNature();
            if (nature == null) {
                moduleMap.get(0).add(module);
            } else if (nature.equals(Constants.GENERAL_PROJECT_NATURE)) {
                moduleMap.get(1).add(module);
            } else if (nature.equals(Constants.CONNECTOR_PROJECT_NATURE)) {
                moduleMap.get(2).add(module);
            } else if (nature.equals(Constants.DATASOURCE_PROJECT_NATURE)) {
                moduleMap.get(3).add(module);
            } else if (nature.equals(Constants.DS_PROJECT_NATURE)) {
                moduleMap.get(4).add(module);
            } else if (nature.equals(Constants.MEDIATOR_PROJECT_NATURE)) {
                moduleMap.get(5).add(module);
            } else if (nature.equals(Constants.CARBON_UI_PROJECT_NATURE)) {
                moduleMap.get(6).add(module);
            } else if (nature.equals(Constants.ESB_PROJECT_NATURE)) {
                moduleMap.get(7).add(module);
            } else if (nature.equals(Constants.DISTRIBUTION_PROJECT_NATURE)) {
                moduleMap.get(8).add(module);
            } else {
                moduleMap.get(0).add(module);
            }
        }

        List<String> sortedModules = new ArrayList<>();
        for (List<String> list : moduleMap) {
            sortedModules.addAll(list);
        }
        return sortedModules;
    }

    /**
     * Get the data of a given module.
     * 
     * @param moduleName name of the module
     * @return ModuleData object with data of the module
     * @throws CoreException exceptions occurred while accessing the related project
     */
    private ModuleData getModuleDataFromModule(String moduleName) throws CoreException {
        String[] split = moduleName.split(Pattern.quote(SLASH));
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(split[split.length - 1]);
        return getModuleDataFromProject(project);
    }

    /**
     * Get the data of a given project.
     * 
     * @param project interested project
     * @return ModuleData object with data of the project
     * @throws CoreException exceptions occurred while accessing the related project
     */
    private ModuleData getModuleDataFromProject(IProject project) throws CoreException {
        String projectName = project.getName();
        String relativePath = FileUtils.getRelativePath(pomFile.getParentFile(), project.getLocation().toFile())
                .replaceAll(Pattern.quote(File.separator), SLASH);
        String nature = project.getDescription().getNatureIds().length > 0 ? project.getDescription().getNatureIds()[0]
                : null;
        ModuleData moduleData = new ModuleData(projectName, relativePath, nature);
        return moduleData;
    }

    /**
     * This method provides the list of projects in the maven multi module project.
     * 
     * @param mavenProject interested project
     * @return data of the projects inside the maven project
     */
    private SortedMap<String, ModuleData> getProjectsInTheWorkspace(MavenProject mavenProject) {
        SortedMap<String, ModuleData> list = Collections
                .synchronizedSortedMap(new TreeMap<String, ModuleData>(Collections.reverseOrder()));
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IProject[] projects = root.getProjects();
        for (IProject project : projects) {
            ProjectNatureListProvider projectNatureListProvider = new ProjectNatureListProvider();
            if (project != null && project.exists() && project.isOpen()
                    && !mavenProject.getArtifactId().equals(project.getName())) {
                try {
                    if (project.hasNature(Constants.JAVA_PROJECT_NATURE)
                            || projectNatureListProvider.isWSO2ProjectType(project)
                            || project.hasNature(Constants.DOCKER_EXPORTER_PROJECT_NATURE)
                            || project.hasNature(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                        ModuleData moduleData = getModuleDataFromProject(project);
                        if (!moduleData.getRelativePath().contains("..")) {
                            list.put(moduleData.getRelativePath(), moduleData);
                        }
                    }
                } catch (CoreException e) {
                    log.error("Error reading project list", e);
                }
            }
        }
        return list;
    }

    @Override
    protected void createFormContent(IManagedForm managedForm) {
        managedForm.getForm().setImage(SWTResourceManager.getImage(this.getClass(), "/icons/mmm-pom-dir-32x32.png"));
        toolkit = managedForm.getToolkit();
        form = managedForm.getForm();
        form.setText(getProjectName());
        form.getToolBarManager().add(getRefreshAction());
        body = form.getBody();
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);
        managedForm.getForm().getBody().setLayout(new GridLayout(2, false));

        // Create group ID text box
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Group Id", SWT.NONE);
        txtGroupId = managedForm.getToolkit().createText(managedForm.getForm().getBody(), EMPTY_STRING, SWT.NONE);
        txtGroupId.setText(getGroupId());
        GridData gd_txtGroupId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtGroupId.widthHint = TEXT_BOX_WIDTH;
        txtGroupId.setLayoutData(gd_txtGroupId);
        txtGroupId.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setGroupId(txtGroupId.getText().trim());
                updateDirtyState();
            }
        });

        // Create Artifact ID text box
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Artifact Id", SWT.NONE);
        txtArtifactId = managedForm.getToolkit().createText(managedForm.getForm().getBody(), EMPTY_STRING,
                SWT.NONE | SWT.READ_ONLY);
        txtArtifactId.setText(getArtifactId());
        GridData gd_txtArtifactId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtArtifactId.widthHint = TEXT_BOX_WIDTH;
        txtArtifactId.setLayoutData(gd_txtArtifactId);

        // Create Version textbox
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Version", SWT.NONE);
        txtVersion = managedForm.getToolkit().createText(managedForm.getForm().getBody(), EMPTY_STRING, SWT.NONE);
        txtVersion.setText(getVersion());
        GridData gd_txtVersion = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtVersion.widthHint = TEXT_BOX_WIDTH;
        txtVersion.setLayoutData(gd_txtVersion);
        txtVersion.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setVersion(txtVersion.getText().trim());
                updateDirtyState();
            }
        });

        // Create Desciption text box
        Label lblDescription = managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Description",
                SWT.NONE);
        lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
        txtDescription = managedForm.getToolkit().createText(managedForm.getForm().getBody(), EMPTY_STRING,
                SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
        txtDescription.setText(getDescription());
        GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_txtDescription.heightHint = 60;
        txtDescription.setLayoutData(gd_txtDescription);
        txtDescription.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setDescription(txtDescription.getText().trim());
                updateDirtyState();
            }
        });

        // Create Modules section
        Section sctnDependencies = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
                Section.TWISTIE | Section.TITLE_BAR);
        GridData gd_sctnNewSection = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        gd_sctnNewSection.heightHint = 350;
        gd_sctnNewSection.widthHint = 411;
        sctnDependencies.setLayoutData(gd_sctnNewSection);
        managedForm.getToolkit().paintBordersFor(sctnDependencies);
        sctnDependencies.setText("Modules");
        sctnDependencies.setExpanded(true);

        // Create composite of modules form
        Composite composite = managedForm.getToolkit().createComposite(sctnDependencies, SWT.NONE);
        managedForm.getToolkit().paintBordersFor(composite);
        sctnDependencies.setClient(composite);
        composite.setLayout(new GridLayout(2, false));

        // Create add modules button
        GridData addModuleBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        addModuleBtn.widthHint = 100;
        Button btnAddModule = createAddButton(composite, EMPTY_STRING, SWT.PUSH);
        final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
        btnAddModule.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event evt) {
                CreateNewProjectAction newProjectAction = new CreateNewProjectAction(project);
                newProjectAction.run();
                try {
                    refreshForm();
                } catch (CoreException | IOException | XmlPullParserException e) {
                    log.error("Failed to refresh the editor after project creation.", e);
                }
            }
        });

        // Create tree structure in the modules view
        trDependencies = managedForm.getToolkit().createTree(composite, SWT.CHECK);
        trDependencies.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        trDependencies.setHeaderVisible(true);
        managedForm.getToolkit().paintBordersFor(trDependencies);
        TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
        trclmnArtifact.setWidth(400);
        trclmnArtifact.setText("Name");
        TreeColumn trclmnServerRole = new TreeColumn(trDependencies, SWT.NONE);
        trclmnServerRole.setWidth(280);
        trclmnServerRole.setText("Path");
        editor = new TreeEditor(trDependencies);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        trDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (item != null) {
                    if (evt.detail == SWT.CHECK) {
                        handleTreeItemChecked(item);
                    } else {
                        handleTreeItemEdit(item);
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
            }
        });

        // Set data to module tree
        createTreeContent();

        // Setting up the select button area
        GridData gdBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gdBtn.widthHint = 100;

        // Create Select All button
        Button btnSelectAll = managedForm.getToolkit().createButton(composite, "Select All", SWT.NONE);
        btnSelectAll.setLayoutData(gdBtn);
        btnSelectAll.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event evt) {
                TreeItem[] items = trDependencies.getItems();
                for (TreeItem item : items) {
                    if (!item.getChecked() || item.getGrayed()) {
                        item.setChecked(true);
                        handleTreeItemChecked(item);
                    }
                }
            }
        });

        // Create DeselectAll button
        Button btnDeselectAll = managedForm.getToolkit().createButton(composite, "Deselect All", SWT.NONE);
        btnDeselectAll.setLayoutData(gdBtn);
        btnDeselectAll.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event evt) {
                TreeItem[] items = trDependencies.getItems();
                for (TreeItem item : items) {
                    item.setChecked(false);
                    handleTreeItemChecked(item);
                }
            }
        });
        Label lblEmpty = managedForm.getToolkit().createLabel(composite, EMPTY_STRING);
        GridData gdEmpty = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        lblEmpty.setLayoutData(gdEmpty);

        // Finalizing the form
        form.updateToolBar();
        form.reflow(true);
    }

    /**
     * Method of creating add button.
     * 
     * @param parent composite layout
     * @param text Button text
     * @param style style as int
     * @return Button widget
     */
    public Button createAddButton(Composite parent, String text, int style) {
        Button addButton = new Button(parent, style);
        addButton.setVisible(true);
        addButton.setImage(NEW_ELEMENT_IMG);
        addButton.setText(text);
        return addButton;
    }

    /**
     * Handle tree item check event.
     * 
     * @param item Selected tree item
     */
    private void handleTreeItemChecked(TreeItem item) {
        boolean select = item.getChecked();
        ModuleData moduleData = (ModuleData) item.getData();
        if (select) {
            addModule(moduleData);
        } else {
            removeModule(moduleData);
        }
        setPageDirty(true);
        updateDirtyState();
    }

    /**
     * Handle tree item edit events.
     * 
     * @param item Selected tree item
     */
    private void handleTreeItemEdit(final TreeItem item) {
        boolean select = item.getChecked();
        ModuleData moduleData = (ModuleData) item.getData();
        if (select && !getModuleList().containsKey(moduleData.getRelativePath())) {
            addModule(moduleData);
            setPageDirty(true);
            updateDirtyState();
        } else if (!select && getModuleList().containsKey(moduleData.getRelativePath())) {
            removeModule(moduleData);
            setPageDirty(true);
            updateDirtyState();
        }
    }

    /**
     * Remove a project dependencies from the maven model.
     * 
     * @param ModuleData ModuleData of selected treeitem
     */
    private void removeModule(ModuleData moduleData) {
        if (getModuleList().containsKey(moduleData.getRelativePath())) {
            getModuleList().remove(moduleData.getRelativePath());
        }
    }

    /**
     * Add a project dependencies to the maven model.
     * 
     * @param moduleData ModuleData of selected treeitem
     */
    private void addModule(ModuleData moduleData) {
        String moduleName = moduleData.getModuleName();
        String relativePath = moduleData.getRelativePath();
        String nature = moduleData.getProjectNature();

        if (!getModuleList().containsKey(relativePath)) {
            getModuleList().put(relativePath, new ModuleData(moduleName, relativePath, nature));
        }
    }

    /**
     * Create content of tree control.
     */
    protected void createTreeContent() {
        trDependencies.removeAll();
        treeNodes.clear();

        for (String module : getProjectList().keySet()) {
            ModuleData moduleData = getProjectList().get(module);
            if (!treeNodes.containsKey(moduleData.getRelativePath())) {
                createNode(trDependencies, moduleData, true);
            }
        }

        for (String module : getMissingModuleList().keySet()) {
            ModuleData moduleData = getMissingModuleList().get(module);
            if (!treeNodes.containsKey(moduleData.getRelativePath())) {
                createNode(trDependencies, moduleData, false);
            }
        }
        trDependencies.layout();
    }

    /**
     * Create a Item for a module.
     * 
     * @param parent Parent tree control
     * @param moduleData ModuleData module
     * @param available available of module in workspace
     * @return new TreeItem
     */
    protected TreeItem createNode(Tree parent, final ModuleData moduleData, boolean available) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        item.setText(0, moduleData.getModuleName());
        item.setText(1, moduleData.getRelativePath());
        item.setImage(0, SWTResourceManager.getImage(this.getClass(), getProjectIcon(moduleData.getProjectNature())));
        item.setData(new ModuleData(moduleData.getModuleName(), moduleData.getRelativePath(),
                moduleData.getProjectNature()));
        if (getModuleList().containsKey(moduleData.getRelativePath())) {
            item.setChecked(true);
            if (getMissingModuleList().containsKey(moduleData.getRelativePath())) {
                getMissingModuleList().remove(moduleData.getRelativePath());
            }
            if (!available) {
                item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/cancel_16.png"));
            }
        }
        return item;
    }

    /**
     * This method returns the icon of a given project nature.
     * 
     * @param projectNature interested project nature
     * @return path of the related icon
     */
    private String getProjectIcon(String projectNature) {
        if (projectNature == null) {
            return "/icons/projects.gif";
        } else if (projectNature.equals(Constants.GENERAL_PROJECT_NATURE)) {
            return "/icons/general-project-12.png";
        } else if (projectNature.equals(Constants.CONNECTOR_PROJECT_NATURE)) {
            return "/icons/connector-12x12.png";
        } else if (projectNature.equals(Constants.DATASOURCE_PROJECT_NATURE)) {
            return "/icons/data-source-12x12.png";
        } else if (projectNature.equals(Constants.DS_PROJECT_NATURE)) {
            return "/icons/ds-12x12.png";
        } else if (projectNature.equals(Constants.ESB_PROJECT_NATURE)) {
            return "/icons/esb.png";
        } else if (projectNature.equals(Constants.DISTRIBUTION_PROJECT_NATURE)) {
            return "/icons/composite-folder.png";
        } else if (projectNature.equals(Constants.DOCKER_EXPORTER_PROJECT_NATURE)) {
            return "/icons/docker-16.png";
        } else if (projectNature.equals(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
            return "/icons/k8s-16.png";
        } else if (projectNature.equals(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
            return "/icons/mmm-project-12x12.png";
        } else {
            return "/icons/projects.gif";
        }
    }

    /**
     * This method returns the action responsible of refreshing the page.
     * 
     * @return refresh action
     */
    public Action getRefreshAction() {
        if (refreshAction == null) {
            refreshAction = new Action(REFRESH, ImageDescriptor
                    .createFromImage(SWTResourceManager.getImage(this.getClass(), "/icons/refresh.png"))) {
                public void run() {
                    try {
                        refreshForm();
                        if (getMissingModuleList().size() == 0) {
                            setPageDirty(false);
                            updateDirtyState();
                        }
                    } catch (CoreException | IOException | XmlPullParserException e) {
                        log.error("An unexpected error has occurred", e);
                    }
                };
            };
            refreshAction.setToolTipText(REFRESH);
        }
        return refreshAction;
    }

    /**
     * This method refresh the form and its content.
     * 
     * @throws CoreException exceptions occurred while getting project data
     * @throws XmlPullParserException exceptions occurred while parsing xml files
     * @throws IOException exceptions occurred while manipulating projects files
     */
    public void refreshForm() throws CoreException, IOException, XmlPullParserException {
        initContent();
        new Thread(new Runnable() {
            public void run() {
                Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                        if (trDependencies.isDisposed()) {
                            return;
                        }
                        createTreeContent();
                        txtVersion.setText(getVersion());
                        txtArtifactId.setText(getArtifactId());
                        txtDescription.setText(getDescription());
                        txtGroupId.setText(getGroupId());
                    }
                });
            }
        }).start();
    }

    /**
     * This method set the module list(Selected modules).
     * 
     * @param moduleList selected modules
     */
    public void setModuleList(Map<String, ModuleData> moduleList) {
        this.moduleList = moduleList;
    }

    /**
     * This method returns the module list(Selected modules).
     * 
     * @return selected modules
     */
    public Map<String, ModuleData> getModuleList() {
        return moduleList;
    }

    /**
     * This method sets all the projects in the maven multi module folder.
     * 
     * @param projectList list of projects
     */
    public void setProjectList(SortedMap<String, ModuleData> projectList) {
        this.projectList = projectList;
    }

    /**
     * This method sets all the projects in the maven multi module folder.
     * 
     * @return list of projects
     */
    public SortedMap<String, ModuleData> getProjectList() {
        return projectList;
    }

    /**
     * This method sets the selected modules that are not present in the maven multi module project folder.
     * 
     * @param missingModuleList list of missing projects
     */
    public void setMissingModuleList(Map<String, ModuleData> missingModuleList) {
        this.missingModuleList = missingModuleList;
    }

    /**
     * This method returns the selected modules that are not present in the maven multi module project folder.
     * 
     * @return list of missing projects
     */
    public Map<String, ModuleData> getMissingModuleList() {
        return missingModuleList;
    }

    /**
     * This method returns the name of the project.
     * 
     * @return name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method sets the name of the project.
     * 
     * @param projectName name of the project
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * This method returns the groupID of the project.
     * 
     * @return groupID
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method sets the groupID of the project.
     * 
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method returns the artifactId of the project.
     * 
     * @return artifactId project artifactId
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * This method sets the artifactId of the project.
     * 
     * @param artifactId project artifactId
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    /**
     * This method returns the version of the project.
     * 
     * @return project version
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method sets the version of the project.
     * 
     * @param version project version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * This method returns the description of the project.
     * 
     * @return project description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method sets the description of the project.
     * 
     * @param description project description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return whether there are unsaved changes.
     * 
     * @return state
     */
    public boolean isPageDirty() {
        return pageDirty;
    }

    /**
     * Sets whether there are unsaved changes.
     * 
     * @param isPageDirty state to set
     */
    public void setPageDirty(boolean isPageDirty) {
        this.pageDirty = isPageDirty;
    }

    /**
     * Updates the dirty state of the editor according to the page.
     */
    public void updateDirtyState() {
        ((DistProjectEditor) getEditor()).updateDirtyState();;
    }

    /**
     * Return whether there are unsaved changes.
     * 
     * @return state
     */
    public boolean isDirty() {
        return isPageDirty();
    }

    /**
     * Check whether format of properties in old format. If in old format transformProperties().
     */
    private void updatePomToNewFormat() {
        List<Dependency> dependencies = parentPrj.getDependencies();
        Properties properties = parentPrj.getModel().getProperties();

        for (Dependency dependency : dependencies) {
            String artifactInfoOld = DistProjectUtils.getArtifactInfoAsStringOld(dependency);
            if (properties.containsKey(artifactInfoOld)) {
                transformProperties(properties);
                break;
            }
        }
    }

    /**
     * This method transforms properties from old format to new format.
     * 
     * @param properties properties to be transformed
     */
    private void transformProperties(Properties properties) {
        Map<String, String> oldServerRoleList = new HashMap<>();
        for (Dependency dependency : (List<Dependency>) parentPrj.getDependencies()) {
            oldServerRoleList.put(DistProjectUtils.getArtifactInfoAsString(dependency),
                    DistProjectUtils.getServerRole(parentPrj, dependency));
        }
        properties.clear();
        for (String key : oldServerRoleList.keySet()) {
            properties.setProperty(key, oldServerRoleList.get(key));
        }

        // change maven-car-plugin version to 2.0.5 and car-deploy version 1.0.4
        List<Plugin> pluginList = parentPrj.getBuildPlugins();
        for (Plugin plugin : pluginList) {
            if (plugin.getArtifactId().equalsIgnoreCase("maven-car-plugin")) {
                plugin.setVersion(MavenConstants.MAVEN_CAR_VERSION);
            } else if (plugin.getArtifactId().equalsIgnoreCase("maven-car-deploy-plugin")) {
                plugin.setVersion(MavenConstants.MAVEN_CAR_DEPLOY_VERSION);
            }
        }
        setPageDirty(true);
        updateDirtyState();
    }

    /**
     * This method combined given to string arrays.
     * 
     * @param firstArray first string array
     * @param secondArray second string array
     * @return combined array
     */
    public static String[] combine(String[] firstArray, String[] secondArray) {
        int length = firstArray.length + secondArray.length;
        String[] result = new String[length];
        System.arraycopy(firstArray, 0, result, 0, firstArray.length);
        System.arraycopy(secondArray, 0, result, firstArray.length, secondArray.length);
        return result;
    }

    @Override
    public boolean visit(IResourceDelta delta) throws CoreException {
        switch (delta.getKind()) {
        case IResourceDelta.REMOVED:
            if (pomFileRes.getLocation() != null) {
                try {
                    refreshForm();
                } catch (CoreException | IOException | XmlPullParserException e) {
                    log.error("refresh opration failed", e);
                }
            }
            break;
        }
        return true;
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        if (event.getType() != IResourceChangeEvent.POST_CHANGE)
            return;
        try {
            event.getDelta().accept(this);
        } catch (CoreException e) {
            log.error("event is failed to capture", e);
        }
    }

    /**
     * This inner class holds important data of a module.
     */
    private class ModuleData {

        private String moduleName;
        private String relativePath;
        private String projectNature;

        /**
         * Initializes an MdouleData instance.
         * 
         * @param moduleName name of the module
         * @param relativePath path to the module from maven multi module project
         * @param projectNature nature of the project related to module
         */
        public ModuleData(String moduleName, String relativePath, String projectNature) {
            super();
            this.moduleName = moduleName;
            this.relativePath = relativePath;
            this.projectNature = projectNature;
        }

        /**
         * This method returns the module name.
         * 
         * @return name of the module
         */
        public String getModuleName() {
            return moduleName;
        }

        /**
         * This method returns the path to the module from maven multi module project.
         * 
         * @return relative path
         */
        public String getRelativePath() {
            return relativePath;
        }

        /**
         * This method returns the nature of the project related to module.
         * 
         * @return nature
         */
        public String getProjectNature() {
            return projectNature;
        }
    }

    /**
     * This class represents the Action call opening the 'New Project' wizard.
     */
    private class CreateNewProjectAction extends Action {

        private static final int SIZING_WIZARD_WIDTH = 500;
        private static final int SIZING_WIZARD_HEIGHT = 500;
        private static final String NEW_WIZARD_ACTION = "NewWizardAction";
        
        private IProject project;

        /**
         * Creates a new action for launching the new project selection wizard.
         *
         * @param project project to be selected as the parent
         */
        public CreateNewProjectAction(IProject project) {
            super(IDEWorkbenchMessages.NewProjectAction_text);
            this.project = project;
            ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
            setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
            setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
            setToolTipText(IDEWorkbenchMessages.NewProjectAction_toolTip);
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
                    org.eclipse.ui.internal.IWorkbenchHelpContextIds.NEW_ACTION);
        }

        @Override
        public void run() {
            // Create wizard selection wizard.
            IWorkbench workbench = PlatformUI.getWorkbench();
            NewWizard wizard = new NewWizard();
            wizard.setProjectsOnly(true);
            IStructuredSelection selectionToPass = new TreeSelection(new TreePath(new Object[] { project }));
            wizard.init(workbench, selectionToPass);
            IDialogSettings workbenchSettings = IDEWorkbenchPlugin.getDefault().getDialogSettings();
            IDialogSettings wizardSettings = workbenchSettings.getSection(NEW_WIZARD_ACTION);
            if (wizardSettings == null) {
                wizardSettings = workbenchSettings.addNewSection(NEW_WIZARD_ACTION);
            }
            wizard.setDialogSettings(wizardSettings);
            wizard.setForcePreviousAndNextButtons(true);

            // Create wizard dialog.
            WizardDialog dialog = new WizardDialog(null, wizard);
            dialog.create();
            dialog.getShell().setSize(Math.max(SIZING_WIZARD_WIDTH, dialog.getShell().getSize().x),
                    SIZING_WIZARD_HEIGHT);
            PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(), IIDEHelpContextIds.NEW_PROJECT_WIZARD);

            // Open wizard.
            dialog.open();
        }
    }

}
