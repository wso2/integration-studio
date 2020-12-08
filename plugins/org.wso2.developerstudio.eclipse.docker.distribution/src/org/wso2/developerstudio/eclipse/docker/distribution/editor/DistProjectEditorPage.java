/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.docker.distribution.editor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.model.NodeData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.action.DockerBuildActionUtil;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerHubAuth;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PlatformUIConstants;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserInputValidator;
import org.xml.sax.SAXException;
import org.eclipse.jface.dialogs.ErrorDialog;

public class DistProjectEditorPage extends FormPage implements IResourceDeltaVisitor, IResourceChangeListener {

    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String SERVER_ROLE_ATTR = "serverRole";
    private static final String REGISTERED_SERVER_ROLES = "org.wso2.developerstudio.register.server.role";

    private IFile pomFileRes;
    private File pomFile;
    private MavenProject parentPrj;
    private String containerType;

    private FormToolkit toolkit;
    private ScrolledForm form;
    private Composite body;
    private Text txtGroupId;
    private Text txtArtifactId;
    private Text txtVersion;
    private Text txtBaseImage;
    private Text txtTargetRepository;
    private Text txtTargetTag;
    private Text txtDescription;
    private Button btnDeploymentTomlEnableChecker;
    private Button btnSecurityEnableChecker;
    private boolean pageDirty;

    IStatus editorStatus = new Status(IStatus.OK, Activator.PLUGIN_ID, "");

    private Map<String, Dependency> dependencyList = new LinkedHashMap<String, Dependency>();
    private Map<String, String> serverRoleList = new HashMap<String, String>();
    private SortedMap<String, DependencyData> projectList = Collections
            .synchronizedSortedMap(new TreeMap<String, DependencyData>(Collections.reverseOrder()));
    private Map<String, Dependency> missingDependencyList = new HashMap<String, Dependency>();
    private List<String> dependencyProjectNames = new ArrayList<>();

    private Tree trDependencies;
    private HashMap<String, TreeItem> nodesWithSubNodes = new HashMap<String, TreeItem>();
    private TreeEditor editor;

    private String projectName = "";
    private String groupId = "";
    private String artifactId = "";
    private String version = "";
    private String description = "";
    private String baseImage = "";
    private String targetRepository = "";
    private String targetTag = "";
    private boolean isDeploymentConfigEnabled = false;
    private boolean isSecurityEnabled = false;
    private boolean isThisOldContainerProject = false;

    private Action dockerBuildAction;
    private Action dockerPushAction;
    private Action refreshAction;

    public DistProjectEditorPage(String id, String title) {
        super(id, title);
        readContainerProjectNature();
    }

    public DistProjectEditorPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
        readContainerProjectNature();
    }

    public void initContent() throws Exception {

        pomFileRes = ((IFileEditorInput) (getEditor().getEditorInput())).getFile();
        pomFile = pomFileRes.getLocation().toFile();

        ProjectList projectListProvider = new ProjectList();
        List<ListData> projectListData = projectListProvider.getListData(null, null,
                DockerProjectConstants.EXTENTION_POINT_NAME);
        SortedMap<String, DependencyData> projectList = Collections
                .synchronizedSortedMap(new TreeMap<String, DependencyData>());
        Map<String, Dependency> dependencyMap = new LinkedHashMap<String, Dependency>();
        for (ListData data : projectListData) {
            DependencyData dependencyData = (DependencyData) data.getData();
            String projectType = dependencyData.getCApptype();
            if ("carbon/application".equals(projectType)) {
                projectList.put(data.getCaption(), dependencyData);
            }
        }

        parentPrj = MavenUtils.getMavenProject(pomFile);

        /*
         * if propeties of pom in old format(DevS 3.2 or earlier) reformat it to new
         * format.
         */

        for (Dependency dependency : (List<Dependency>) parentPrj.getDependencies()) {
            dependencyMap.put(DistProjectUtils.getArtifactInfoAsString(dependency), dependency);
            serverRoleList.put(DistProjectUtils.getArtifactInfoAsString(dependency),
                    DistProjectUtils.getServerRole(parentPrj, dependency));
            dependencyProjectNames.add(dependency.getArtifactId());
        }
        setProjectName(parentPrj.getName());
        setArtifactId(parentPrj.getArtifactId());
        setGroupId(parentPrj.getGroupId());
        setVersion(parentPrj.getVersion());
        setDescription(parentPrj.getDescription());
        setProjectList(projectList);
        setDependencyList(dependencyMap);
        readDockerImageDetails(pomFile);
    }
    
    /**
     * Read docker image details from the POM file.
     * 
     * @param pomFile pom file
     */
    private void readDockerImageDetails(File pomFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(pomFile);
            
            //check pom is an old project or not
            //it checks buildArg parameter is there in docker plugin to verify whether this pom is a new one or not
            XPathExpression xpBuildArgs = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.DOCKER_SPOTIFY_PLUGIN_BUILD_ARG);
            if (xpBuildArgs.evaluate(doc).isEmpty()) {
                isThisOldContainerProject = true;
                
                //Read target repository name and the tag from the pom spotify plugin tags
                XPathExpression xpRepo = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH_OLD);
                String repository = xpRepo.evaluate(doc);
                setTargetRepository(repository);

                XPathExpression xpTag = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_TAG_XPATH_OLD);
                String tag = xpTag.evaluate(doc);
                setTargetTag(tag);
            } else {
                //Read target repository name and the tag from the pom properties tags
                XPathExpression xpBaseImage = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.BASE_IMAGE_XPATH);
                String baseImage = xpBaseImage.evaluate(doc);
                setBaseImage(baseImage);
                
                XPathExpression xpRepo = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH);
                String repository = xpRepo.evaluate(doc);
                setTargetRepository(repository);

                XPathExpression xpTag = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_TAG_XPATH);
                String tag = xpTag.evaluate(doc);
                setTargetTag(tag);
                
                XPathExpression xpCipherToolEnable = XPathFactory.newInstance().newXPath()
                        .compile(DockerProjectConstants.CIPHER_TOOL_ENABLE_XPATH);
                setSecurityEnabled(Boolean.parseBoolean(xpCipherToolEnable.evaluate(doc)));
            }
            
			XPathExpression xPathConfigMapEnabled = XPathFactory.newInstance().newXPath()
					.compile(DockerProjectConstants.CONFIGMAP_PLUGIN_XPATH);
			String configMapEnable = xPathConfigMapEnabled.evaluate(doc);
			if (configMapEnable.equals("package")) {
				setDeploymentConfigEnabled(true);
			} else {
				setDeploymentConfigEnabled(false);
			}

        } catch (XPathExpressionException e) {
            log.error("XPathExpressionException while reading pomfile", e);
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException while reading pomfile", e);
        } catch (SAXException e) {
            log.error("SAXException while reading pomfile", e);
        } catch (IOException e) {
            log.error("IOException while reading pomfile", e);
        }
    }

    public void savePOM() throws Exception {
        try {
            if (editorStatus != null) {
                if (!editorStatus.isOK()) {
                    ErrorDialog.openError(getSite().getShell(), "Warning", "The following warning(s) have been detected",
                            editorStatus);
                    editorStatus = new Status(IStatus.OK, Activator.PLUGIN_ID, ""); // clear
                                                                                    // error
                }
            }
            parentPrj.setGroupId(getGroupId());
            parentPrj.setVersion(getVersion());
            parentPrj.setDescription(getDescription());
            parentPrj.setDependencies(new ArrayList<Dependency>(getDependencyList().values()));
            MavenUtils.saveMavenProject(parentPrj, pomFile);
            
            if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
                dockerFieldValidator();
            }
            
            DockerBuildActionUtil.changeDockerImageDataInPOMPlugin(pomFile, getBaseImage(), getTargetRepository(), getTargetTag(),
                    isDeploymentConfigEnabled, pomFileRes, isThisOldContainerProject, isSecurityEnabled);
            setPageDirty(false);
            updateDirtyState();
            pomFileRes.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        } catch (Exception e) {
            DockerBuildActionUtil.showMessageBox("Container Project Save Failed", e.getMessage(), SWT.ICON_ERROR);
        }
    }

    protected void createFormContent(IManagedForm managedForm) {
        if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
            managedForm.getForm().setImage(SWTResourceManager.getImage(this.getClass(), "/kubernetes64x64.png"));
        } else {
            managedForm.getForm().setImage(SWTResourceManager.getImage(this.getClass(), "/icons/Docker64x64.png"));
        }
        
        toolkit = managedForm.getToolkit();
        form = managedForm.getForm();
        form.setText(getProjectName());
        form.getToolBarManager().add(getRefreshAction());
        form.getToolBarManager().add(getDockerBuildAction());
        if (getContainerType().equals(DockerProjectConstants.DOCKER_CONTAINER)) {
            form.getToolBarManager().add(getDockerPushAction());
        }
        body = form.getBody();
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);
        managedForm.getForm().getBody().setLayout(new GridLayout(2, false));

        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Group Id", SWT.NONE);

        txtGroupId = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "", SWT.NONE);
        txtGroupId.setText(getGroupId());
        GridData gd_txtGroupId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtGroupId.widthHint = 350;
        txtGroupId.setLayoutData(gd_txtGroupId);
        txtGroupId.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setGroupId(txtGroupId.getText().trim());
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Artifact Id", SWT.NONE);

        txtArtifactId = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "",
                SWT.NONE | SWT.READ_ONLY);
        txtArtifactId.setText(getArtifactId());
        GridData gd_txtArtifactId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtArtifactId.widthHint = 350;
        txtArtifactId.setLayoutData(gd_txtArtifactId);

        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Version", SWT.NONE);

        txtVersion = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "", SWT.NONE);
        txtVersion.setText(getVersion());
        GridData gd_txtVersion = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtVersion.widthHint = 350;
        txtVersion.setLayoutData(gd_txtVersion);
        txtVersion.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setVersion(txtVersion.getText().trim());
                updateDirtyState();
            }
        });

        Label lblDescription = managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Description",
                SWT.NONE);
        lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));

        txtDescription = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "",
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
        
        if (!isThisOldContainerProject) {
            managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Base Image", SWT.NONE);
            
            txtBaseImage = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "", SWT.NONE);
            txtBaseImage.setText(getBaseImage());
            GridData gd_txtBaseImage = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
            gd_txtBaseImage.widthHint = 350;
            txtBaseImage.setLayoutData(gd_txtBaseImage);
            txtBaseImage.addModifyListener(new ModifyListener() {

                public void modifyText(ModifyEvent evt) {
                    setPageDirty(true);
                    setBaseImage(txtBaseImage.getText().trim());
                    updateDirtyState();
                }
            });
        }
        
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Target Repository", SWT.NONE);

        txtTargetRepository = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "", SWT.NONE);
        txtTargetRepository.setText(getTargetRepository());
        GridData gd_txtTargetRepository = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtTargetRepository.widthHint = 350;
        txtTargetRepository.setLayoutData(gd_txtTargetRepository);
        txtTargetRepository.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setTargetRepository(txtTargetRepository.getText().trim());
                updateDirtyState();
            }
        });
        
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Target Tag", SWT.NONE);

        txtTargetTag = managedForm.getToolkit().createText(managedForm.getForm().getBody(), "", SWT.NONE);
        txtTargetTag.setText(getTargetTag());
        GridData gd_txtTargetTag = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_txtTargetTag.widthHint = 350;
        txtTargetTag.setLayoutData(gd_txtTargetTag);
        txtTargetTag.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {
                setPageDirty(true);
                setTargetTag(txtTargetTag.getText().trim());
                updateDirtyState();
            }
        });
        
        managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Deployment Configurations", SWT.NONE);
        btnDeploymentTomlEnableChecker = managedForm.getToolkit().createButton(managedForm.getForm().getBody(),
                "Automatically deploy configurations (supports Micro-Integrator-1.1.0 upwards)", SWT.CHECK);
        btnDeploymentTomlEnableChecker.setSelection(isDeploymentConfigEnabled());
        GridData gdBtnDeploymentTomlEnableChecker = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        btnDeploymentTomlEnableChecker.setLayoutData(gdBtnDeploymentTomlEnableChecker);
        
        btnDeploymentTomlEnableChecker.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setPageDirty(true);
                if (btnDeploymentTomlEnableChecker.getSelection()) {
                    setDeploymentConfigEnabled(true);
                } else {
                    setDeploymentConfigEnabled(false);
                }
                updateDirtyState();
            }
        });
        
        //Enable security check button for new Docker/k8s projects, since this is working only for newer plugin versions
        if (!isThisOldContainerProject) {
            managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "Enable Cipher Tool", SWT.NONE);
            btnSecurityEnableChecker = managedForm.getToolkit().createButton(managedForm.getForm().getBody(),
                    "Required for secrets encryption and decryption", SWT.CHECK);
            btnSecurityEnableChecker.setSelection(isSecurityEnabled());
            GridData gdBtnSecurityEnableChecker = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
            btnSecurityEnableChecker.setLayoutData(gdBtnSecurityEnableChecker);
            btnSecurityEnableChecker.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    setPageDirty(true);
                    if (btnSecurityEnableChecker.getSelection()) {
                        setSecurityEnabled(true);
                    } else {
                        setSecurityEnabled(false);
                    }
                    updateDirtyState();
                }
            });
        }
        
        Section sctnDependencies = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
                Section.TWISTIE | Section.TITLE_BAR);
        GridData gd_sctnNewSection = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        gd_sctnNewSection.heightHint = 250;
        gd_sctnNewSection.widthHint = 411;
        gd_sctnNewSection.verticalSpan = 55;
        sctnDependencies.setLayoutData(gd_sctnNewSection);
        managedForm.getToolkit().paintBordersFor(sctnDependencies);
        sctnDependencies.setText("Dependencies");
        sctnDependencies.setExpanded(true);

        Composite composite = managedForm.getToolkit().createComposite(sctnDependencies, SWT.NONE);
        managedForm.getToolkit().paintBordersFor(composite);
        sctnDependencies.setClient(composite);
        composite.setLayout(new GridLayout(2, false));

        trDependencies = managedForm.getToolkit().createTree(composite, SWT.CHECK);
        trDependencies.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        trDependencies.setHeaderVisible(true);
        managedForm.getToolkit().paintBordersFor(trDependencies);

        TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
        trclmnArtifact.setWidth(480);
        trclmnArtifact.setText("Artifact");

        /*
         * TreeColumn trclmnServerRole = new TreeColumn(trDependencies, SWT.NONE);
         * trclmnServerRole.setWidth(200); trclmnServerRole.setText("Server Role");
         */

        TreeColumn trclmnVersion = new TreeColumn(trDependencies, SWT.NONE);
        trclmnVersion.setWidth(200);
        trclmnVersion.setText("Version");

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

        createTreeContent();

        GridData gdBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gdBtn.widthHint = 100;
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
        Label lblEmpty = managedForm.getToolkit().createLabel(composite, "");
        GridData gdEmpty = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        lblEmpty.setLayoutData(gdEmpty);

        form.updateToolBar();
        form.reflow(true);
    }
    
    /**
     * Validate the repository and tag fields in pom UI.
     */
    private void dockerFieldValidator() throws RuntimeException {
        if (getTargetRepository() == null || getTargetRepository().isEmpty()) {
            throw new RuntimeException(PlatformUIConstants.NO_KUBE_TARGET_REPOSITORY);
        } else if (getTargetTag() == null || getTargetTag().isEmpty()) {
            throw new RuntimeException(PlatformUIConstants.NO_TARGET_TAG_ERROR);
        } else if (!UserInputValidator.isRepositoryValid(getTargetRepository())) {
            throw new RuntimeException(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
        } else if (!UserInputValidator.isTagValid(getTargetTag())) {
            throw new RuntimeException(PlatformUIConstants.INVALID_TARGET_TAG_MESSAGE);
        } else if (getTargetRepository() != null
                && (getTargetRepository().split("/").length != 2 && getTargetRepository().split("/").length != 3)) {
            throw new RuntimeException(PlatformUIConstants.TARGET_REPOSITORY_INVALID);
        }
    }

    /**
     * handle tree item check event
     * 
     * @param item
     *            Selected tree item
     */
    private void handleTreeItemChecked(TreeItem item) {
        boolean select = item.getChecked();
        NodeData nodeData = (NodeData) item.getData();
        if (nodeData.hasChildren()) {
            TreeItem[] subItems = item.getItems();
            if (select) {
                boolean conflict = false;
                for (TreeItem subitem : subItems) {
                    if (!subitem.getChecked()) {
                        NodeData subNodeData = (NodeData) subitem.getData();
                        if (!isNameConflict(subNodeData)) {
                            subitem.setChecked(true);
                            addDependency(subNodeData);
                            setPageDirty(true);
                        } else {
                            conflict = true;
                        }
                    }
                }
                if (conflict) {
                    MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                            "Add dependencies", "Cannot add multiple dependencies with same identity");
                }
            } else {
                for (TreeItem subitem : subItems) {
                    if (subitem.getChecked()) {
                        subitem.setChecked(false);
                        NodeData subNodeData = (NodeData) subitem.getData();
                        removeDependency(subNodeData);
                        setPageDirty(true);
                    }
                }
            }
            updateCheckState(item);
        } else {
            TreeItem parentItem = item.getParentItem();
            if (select) {
                if (!isNameConflict(nodeData)) {
                    addDependency(nodeData);
                    setPageDirty(true);
                } else {
                    item.setChecked(false);
                    MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                            "Add dependencies", "Cannot add multiple dependencies with same identity");
                }
            } else {
                removeDependency(nodeData);
                setPageDirty(true);
            }
            updateCheckState(parentItem);
        }
        updateDirtyState();
    }

    /**
     * Check for conflicts
     * 
     * @param nodeData
     * @return
     */
    private boolean isNameConflict(NodeData nodeData) {
        Dependency dependency = nodeData.getDependency();
        for (Dependency entry : getDependencyList().values()) {
            if (entry.getArtifactId().equalsIgnoreCase(dependency.getArtifactId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * handle tree item edit events
     * 
     * @param item
     *            Selected tree item
     */
    private void handleTreeItemEdit(final TreeItem item) {
        final NodeData nodeData = (NodeData) item.getData();
        Control lastCtrl = editor.getEditor();
        if (lastCtrl != null) {
            lastCtrl.dispose();
        }

        if (nodeData.hasChildren()) {
            return;
        }

        DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
        IConfigurationElement[] elements = devStudioUtils.getExtensionPointmembers(REGISTERED_SERVER_ROLES);
        List<String> defaultServerRoles = new ArrayList<String>();
        for (IConfigurationElement serverRoleElem : elements) {
            String serverRole = serverRoleElem.getAttribute(SERVER_ROLE_ATTR);
            if (!defaultServerRoles.contains(serverRole)) {
                defaultServerRoles.add(serverRole);
            }
        }

    }

    /**
     * Remove a project dependencies from the maven model
     * 
     * @param nodeData
     *            NodeData of selected treeitem
     */
    private void removeDependency(NodeData nodeData) {
        Dependency project = nodeData.getDependency();
        String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);

        if (getDependencyList().containsKey(artifactInfo)) {
            getDependencyList().remove(artifactInfo);
            if (serverRoleList.containsKey(artifactInfo)) {
                serverRoleList.remove(artifactInfo);
            }
        }
        if (dependencyProjectNames.contains(project.getArtifactId())) {
            dependencyProjectNames.remove(project.getArtifactId());
        }
    }

    /**
     * Add a project dependencies to the maven model
     * 
     * @param nodeData
     *            NodeData of selected treeitem
     */
    private void addDependency(NodeData nodeData) {
        Dependency project = nodeData.getDependency();
        String serverRole = nodeData.getServerRole();
        String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);

        if (!getDependencyList().containsKey(artifactInfo)) {

            Dependency dependency = new Dependency();
            dependency.setArtifactId(project.getArtifactId());
            dependency.setGroupId(project.getGroupId());
            dependency.setVersion(project.getVersion());
            dependency.setType(project.getType());

            serverRoleList.put(artifactInfo, "capp/" + serverRole);

            getDependencyList().put(artifactInfo, dependency);
        }
        dependencyProjectNames.add(project.getArtifactId());
    }

    /**
     * Update state of treeItem
     * 
     * @param item
     *            Selected tree item
     */
    private void updateCheckState(TreeItem item) {
        if (item != null) {
            TreeItem[] subItems = item.getItems();
            int i = 0;
            for (TreeItem subItem : subItems) {
                if (subItem.getChecked())
                    i++;
            }
            if (i == item.getItemCount()) {
                item.setGrayed(false);
                item.setChecked(true);
            } else if (i < item.getItemCount() && i > 0) {
                item.setChecked(true);
                item.setGrayed(true);

            } else {
                item.setGrayed(false);
                item.setChecked(false);
            }
        }
    }

    /**
     * Create content of tree control
     */
    protected void createTreeContent() {
        trDependencies.removeAll();
        nodesWithSubNodes.clear();

        for (String project : getProjectList().keySet()) {
            DependencyData dependencyData = getProjectList().get(project);
            Object parent = dependencyData.getParent();
            Object self = dependencyData.getSelf();
            if ((parent == null) && (self != null)) {
                if (self instanceof IProject) {
                    createNode(trDependencies, dependencyData.getDependency(), true);
                }
            } else if (parent != null) {
                if (parent instanceof IProject) {
                    IProject prj = (IProject) parent;
                    TreeItem parentNode = null;
                    if (nodesWithSubNodes.containsKey(prj.getName())) {
                        parentNode = nodesWithSubNodes.get(prj.getName());
                    } else {
                        parentNode = createNode(trDependencies, prj);
                        nodesWithSubNodes.put(prj.getName(), parentNode);
                    }
                    if (parentNode != null) {
                        createNode(parentNode, dependencyData.getDependency(), true);
                    }
                    updateCheckState(parentNode);
                }
            }
        }
        trDependencies.layout();
    }

    /**
     * Create a subItem for a project
     * 
     * @param parent
     *            Parent treeItem
     * @param project
     *            Project dependency
     * @param available
     *            available of dependency in workspace
     * @return new TreeItem
     */
    TreeItem createNode(TreeItem parent, final Dependency project, boolean available) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);
        String serverRole = DistProjectUtils.getDefaultServerRole(getProjectList(), artifactInfo).replaceAll("^capp/",
                "");
        String version = project.getVersion();

        item.setText(0, DistProjectUtils.getMavenInfoAsString(artifactInfo));

        item.setText(1, version);
        NodeData nodeData = new NodeData(project);
        nodeData.setServerRole(serverRole);
        item.setData(nodeData);

        if (getDependencyList().containsKey(artifactInfo)) {
            item.setChecked(true);
        }

        if (getMissingDependencyList().containsKey(artifactInfo)) {
            getMissingDependencyList().remove(artifactInfo);
        }
        item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/composite-folder.png"));

        return item;
    }

    /**
     * Create a Item for a dependency
     * 
     * @param parent
     *            Parent tree control
     * @param project
     *            Project dependency
     * @param available
     *            available of dependency in workspace
     * @return new TreeItem
     */
    TreeItem createNode(Tree parent, final Dependency project, boolean available) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        final String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);
        final String serverRole = DistProjectUtils.getDefaultServerRole(getProjectList(), artifactInfo)
                .replaceAll("^capp/", "");
        final String version = project.getVersion();

        item.setText(0, DistProjectUtils.getMavenInfoAsString(artifactInfo));

        item.setText(1, version);

        NodeData nodeData = new NodeData(project);
        nodeData.setServerRole(serverRole);

        item.setData(nodeData);

        if (available) {
            if (getDependencyList().containsKey(artifactInfo)) {
                item.setChecked(true);
            }
            if (getMissingDependencyList().containsKey(artifactInfo)) {
                getMissingDependencyList().remove(artifactInfo);
            }

        } else {
            if (getDependencyList().containsKey(artifactInfo)) {
                getDependencyList().remove(artifactInfo);
            }
        }
        if (available) {
            item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/composite-folder.png"));
        } else {
            item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/cancel_16.png"));
        }
        return item;

    }

    /**
     * Create a tree Item for a project
     * 
     * @param parent Parent tree control
     * @param project eclipse project
     * @return new TreeItem
     */
    TreeItem createNode(Tree parent, final IProject project) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        MavenProject mavenProject;
        try {
            mavenProject = DistProjectUtils.getMavenProject(project);
            item.setText(0, project.getName());
            // item.setText(1, "--");
            item.setText(1, mavenProject.getModel().getVersion());
            NodeData nodeData = new NodeData(project);
            item.setData(project);

            nodeData.setHaschildren(true);
            item.setData(nodeData);

            item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/projects.gif"));
        } catch (Exception e) {
            log.error("createNode fail", e);
            return null;
        }
        return item;

    }

    /**
     * Trigger the docker build action from the UI.
     * 
     * @return triggered action
     */
    public Action getDockerBuildAction() {
        if (dockerBuildAction == null) {
            IProject project = ((IFileEditorInput) (getEditor().getEditorInput())).getFile().getProject();
            String actionIconType;
            if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
                actionIconType = "/icons/buildPush.png";
            } else {
                actionIconType = "/icons/build.png";
            }

            dockerBuildAction = new Action("Generate Docker Image",
                    ImageDescriptor.createFromImage(SWTResourceManager.getImage(this.getClass(), actionIconType))) {
                public void run() {
                    // save all the existing editors
                    IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
                    if (pages != null) {
                        for (IWorkbenchPage page : pages) {
                            IEditorPart editor = page.getActiveEditor();
                            if (editor != null) {
                                page.saveEditor(editor, true);
                            }
                        }
                    }

                    // check whether there are atleast one depenedency composite project to build a image
                    List<String> dependencyProjectNames = DockerBuildActionUtil.getCompositeAppDependencyList(pomFile);
                    if (dependencyProjectNames.size() == 0) {
                        DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                                DockerProjectConstants.SUFFCIENT_DEPENDENCY_NOT_FOUND, SWT.ERROR);
                        return;
                    }

                    DockerHubAuth newConfiguration = null;
                    if (getContainerType().equals(DockerProjectConstants.KUBERNETES_CONTAINER)) {
                        newConfiguration = new DockerHubAuth();
                        DockerHubLoginWizard wizard = new DockerHubLoginWizard(newConfiguration, pomFileRes);
                        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                        wizard.init(PlatformUI.getWorkbench(), null);
                        CustomWizardDialog headerWizardDialog = new CustomWizardDialog(window.getShell(), wizard);
                        headerWizardDialog.setHelpAvailable(false);
                        headerWizardDialog.setPageSize(580, 230);
                        headerWizardDialog.open();

                        if (newConfiguration.getAuthUsername() == null || newConfiguration.getAuthPassword() == null) {
                            return;
                        }
                        
                        newConfiguration.setKubernetesProject(true);
                        dockerBuildAction.setToolTipText("Build & Push Docker Image");
                    } else {
                        dockerBuildAction.setToolTipText("Build Docker Image");
                    }

                    //execute maven build and push jobs using project POM
                    executeDockerBuildProcess(project, dependencyProjectNames, newConfiguration);
                };
            };
        }
        return dockerBuildAction;
    }
    
    /**
     * Trigger the docker push action from the UI.
     * 
     * @return triggered action
     */
    public Action getDockerPushAction() {
        if (dockerPushAction == null) {
            IProject project = ((IFileEditorInput) (getEditor().getEditorInput())).getFile().getProject();
            String actionIconType = "/icons/push.png";
            
            dockerPushAction = new Action("Push Docker Image",
                    ImageDescriptor.createFromImage(SWTResourceManager.getImage(this.getClass(), actionIconType))) {
                public void run() {

                    DockerHubAuth newConfiguration = new DockerHubAuth();
                    DockerHubLoginWizard wizard = new DockerHubLoginWizard(newConfiguration, pomFileRes);
                    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                    wizard.init(PlatformUI.getWorkbench(), null);
                    CustomWizardDialog headerWizardDialog = new CustomWizardDialog(window.getShell(), wizard);
                    headerWizardDialog.setHelpAvailable(false);
                    headerWizardDialog.setPageSize(580, 230);
                    headerWizardDialog.open();
                    
                    if (newConfiguration.getAuthUsername() == null || newConfiguration.getAuthPassword() == null) {
                        return;
                    }
                    
                    dockerPushAction.setToolTipText("Push Docker Image");
                    //execute maven push jobs using project POM
                    executeDockerPushOnlyProcess(project, dependencyProjectNames, newConfiguration);
                };
            };
        }
        return dockerPushAction;
    }
    
    /**
     * Execute docker build and push maven jobs in UI thread.
     * 
     * @param project container project
     * @param dependencyProjectNames CApp project name list in POM file
     * @param configuration auth connection data for docker push
     */
    private void executeDockerBuildProcess(IProject project, List<String> dependencyProjectNames,
            DockerHubAuth configuration) {
        String m2Directory = FileUtils.getUserDirectory().getPath() + File.separator + ".m2" + File.separator
                + "repository";

        try {
            DockerBuildActionUtil.exportCarbonAppsToTargetFolder(m2Directory, dependencyProjectNames);

            // check docker registry URL has changed, if yes append the private remote url to the target repository
            String targetRepository = DockerBuildActionUtil.readDockerImageDetailsFromPomPlugin(pomFile,
                    isThisOldContainerProject);
            String[] reposirotyTags = targetRepository.split(DockerProjectConstants.REPOSITORY_SEPERATOR);
            if (reposirotyTags.length == 3) {
                targetRepository = reposirotyTags[1] + DockerProjectConstants.REPOSITORY_SEPERATOR + reposirotyTags[2];
            }

            if (configuration != null && !configuration.isDockerRegistry()) {
                targetRepository = configuration.getRemoteRegistryURL() + DockerProjectConstants.REPOSITORY_SEPERATOR
                        + targetRepository;
            }

            DockerBuildActionUtil.changeDockerImageDataInPOMPlugin(pomFile, targetRepository, isThisOldContainerProject);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            DockerBuildActionUtil.runDockerBuildWithMavenProfile(project, DockerBuildActionUtil.MAVEN_BUILD_GOAL,
                    configuration, isThisOldContainerProject);
        } catch (CoreException e) {
            log.error("CoreException in while executing the docker build process", e);
        }
    }
    
    /**
     * Execute docker push maven jobs in UI thread.
     * 
     * @param project container project
     * @param dependencyProjectNames CApp project name list in POM file
     * @param configuration auth connection data for docker push
     */
    private void executeDockerPushOnlyProcess(IProject project, List<String> dependencyProjectNames,
            DockerHubAuth configuration) {

        try {
            // check docker registry URL has changed, if yes append the private remote url to the target repository
            String targetRepository = DockerBuildActionUtil.readDockerImageDetailsFromPomPlugin(pomFile, isThisOldContainerProject);
            String[] reposirotyTags = targetRepository.split(DockerProjectConstants.REPOSITORY_SEPERATOR);
            if (reposirotyTags.length == 3) {
                targetRepository = reposirotyTags[1] + DockerProjectConstants.REPOSITORY_SEPERATOR + reposirotyTags[2];
            }

            if (configuration != null && !configuration.isDockerRegistry()) {
                targetRepository = configuration.getRemoteRegistryURL() + DockerProjectConstants.REPOSITORY_SEPERATOR
                        + targetRepository;
            }

            DockerBuildActionUtil.changeDockerImageDataInPOMPlugin(pomFile, targetRepository, isThisOldContainerProject);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            DockerBuildActionUtil.runDockerPushWithMavenProfile(project, configuration, isThisOldContainerProject);
        } catch (CoreException e) {
            log.error("CoreException in while executing the docker push process", e);
        }
    }

    public Action getRefreshAction() {
        if (refreshAction == null) {
            refreshAction = new Action("Refresh", ImageDescriptor
                    .createFromImage(SWTResourceManager.getImage(this.getClass(), "/icons/refresh.png"))) {
                public void run() {
                    try {
                        refreshForm();
                        if (getMissingDependencyList().size() == 0) {
                            setPageDirty(false);
                            updateDirtyState();
                        }
                    } catch (Exception e) {
                        log.error("An unexpected error has occurred", e);
                    }
                };
            };
            refreshAction.setToolTipText("Refresh");
        }
        return refreshAction;
    }

    /*
     * If the GUI elements are accessed from a thread other than the thread that has
     * created the element ERROR_THREAD_INVALID_ACCESS exception will be thrown. To
     * avoid that a new thread is created and UISynchronize's asyncExec() is called
     */
    public void refreshForm() throws Exception {
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
                        txtTargetRepository.setText(getTargetRepository());
                        txtTargetTag.setText(getTargetTag());
                        btnDeploymentTomlEnableChecker.setSelection(isDeploymentConfigEnabled());
                        if (!isThisOldContainerProject) {
                            txtBaseImage.setText(getBaseImage());
                            btnSecurityEnableChecker.setSelection(isSecurityEnabled());
                        }
                    }
                });
            }
        }).start();
    }

    /*
     * Reads project nature of the project to get the project type.
     */
    private void readContainerProjectNature() {
        // read properties file and check the type of the container
        IProject project = ((IFileEditorInput) (getEditor().getEditorInput())).getFile().getProject();
      
        try {
            if (project.hasNature(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                setContainerType(DockerProjectConstants.KUBERNETES_CONTAINER);
            } else {
                setContainerType(DockerProjectConstants.DOCKER_CONTAINER);
            }
        } catch (CoreException e) {
            log.error("CoreException while reading the project nature", e);
        }
    }

    public void setDependencyList(Map<String, Dependency> dependencyList) {
        this.dependencyList = dependencyList;
    }

    public Map<String, Dependency> getDependencyList() {
        return dependencyList;
    }

    public void setProjectList(SortedMap<String, DependencyData> projectList) {
        this.projectList = projectList;
    }

    public SortedMap<String, DependencyData> getProjectList() {
        return projectList;
    }

    public void setMissingDependencyList(Map<String, Dependency> missingDependencyList) {
        this.missingDependencyList = missingDependencyList;
    }

    public Map<String, Dependency> getMissingDependencyList() {
        return missingDependencyList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPageDirty() {
        return pageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.pageDirty = isPageDirty;
    }

    public void updateDirtyState() {
        ((DistProjectEditor) getEditor()).updateDirtyState();;
    }

    public boolean isDirty() {
        return isPageDirty();
    }
    
    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    public String getTargetRepository() {
        return targetRepository;
    }

    public void setTargetRepository(String targetRepository) {
        this.targetRepository = targetRepository;
    }

    public String getTargetTag() {
        return targetTag;
    }

    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }
    
    public void setDeploymentConfigEnabled(boolean isEnabled) {
        this.isDeploymentConfigEnabled = isEnabled;
    }
    
    public boolean isDeploymentConfigEnabled() {
        return isDeploymentConfigEnabled;
    }
    
    public boolean isSecurityEnabled() {
        return isSecurityEnabled;
    }

    public void setSecurityEnabled(boolean isSecurityEnabled) {
        this.isSecurityEnabled = isSecurityEnabled;
    }

    public static String[] combine(String[] a, String[] b) {
        int length = a.length + b.length;
        String[] result = new String[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    @Override
    public boolean visit(IResourceDelta delta) throws CoreException {

        switch (delta.getKind()) {
        case IResourceDelta.REMOVED:
            if (pomFileRes.getLocation() != null) {
                try {
                    refreshForm();
                } catch (Exception e) {
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

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

}
