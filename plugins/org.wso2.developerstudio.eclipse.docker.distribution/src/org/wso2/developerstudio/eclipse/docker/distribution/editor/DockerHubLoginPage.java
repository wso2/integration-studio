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

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class DockerHubLoginPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private static final String DIALOG_TITLE = "Docker Registry Credentials";
    private static final String SUB_DIALOG_TITLE = "Enter Docker Registry Credentials";
    private static final String EMPTY_STRING = "";
    private static final String REGISTRY_URL = "Registry URL Type:";
    private static final String ENTER_REGISTRY_URL = "Enter Registry URL:";
    private static final String EMAIL = "Email:";
    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    public final String DOCKERHUB_REGISTRY = "Docker Hub";
    public final String OTHER_REGISTRY = "Other";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private String dockerHubUsername = EMPTY_STRING;
    private String dockerHubEmail = EMPTY_STRING;
    private String dockerHubPassword = EMPTY_STRING;
    private String dockerHubOtherRegistryURL = EMPTY_STRING;
    private String selectedRegistryType = EMPTY_STRING;

    private Combo registryURLCombo;
    private Text txtDockerEmail;
    private Text txtDockerUsername;
    private Text txtDockerPassword;
    private Text txtOtherEmail;
    private Text txtOtherUsername;
    private Text txtOtherPassword;
    private Text txtOtherRegistryURL;
    private Composite containerOtherRegistry;
    private Composite containerDockerRegistry;

    protected DockerHubLoginPage(IWorkbench wb, IStructuredSelection selection, IFile pomFile) {
        super(DIALOG_TITLE);
        setTitle(SUB_DIALOG_TITLE);
        setRegistryURLValues(pomFile);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;
        
        Label lblRegistryURL = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblRegistryURL.setLayoutData(data);
        lblRegistryURL.setText(REGISTRY_URL);

        String[] registryContainers = { DOCKERHUB_REGISTRY, OTHER_REGISTRY };
        registryURLCombo = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
        registryURLCombo.setItems(registryContainers);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(lblRegistryURL, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        registryURLCombo.setLayoutData(data);
        
        if (getSelectedRegistryType() != null && !getSelectedRegistryType().isEmpty()) {
            registryURLCombo.setText(getSelectedRegistryType());
        } else {
            setSelectedRegistryType(registryURLCombo.getText());
            registryURLCombo.setText(registryContainers[0]);
        }
        
        registryURLCombo.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setSelectedRegistryType(registryURLCombo.getText());
                validate();
                changeLoginView();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        containerOtherRegistry = new Composite(container, SWT.NULL);
        containerOtherRegistry.setLayout(new FormLayout());
        containerDockerRegistry = new Composite(container, SWT.NULL);
        containerDockerRegistry.setLayout(new FormLayout());
        
        data = new FormData();
        data.top = new FormAttachment(registryURLCombo, 15);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(100);
        containerDockerRegistry.setLayoutData(data);
        data = new FormData();
        data.top = new FormAttachment(28);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(100);
        containerOtherRegistry.setLayoutData(data);
        
        previewAuthFieldsForOtherRegistry();
        previewAuthFieldsForDockerRegistry();
        changeLoginView();
        setPageComplete(false);
    }
    
    private void changeLoginView() {
        if (getSelectedRegistryType().equals(DOCKERHUB_REGISTRY)) {
            txtOtherRegistryURL.setVisible(false);
            containerOtherRegistry.setVisible(false);
            containerDockerRegistry.setVisible(true);
            
            if (!getEmailValue().isEmpty()) {
                txtDockerEmail.setText(getEmailValue());
            }
            if (!getUsernameValue().isEmpty()) {
                txtDockerUsername.setText(getUsernameValue());
            }
            if (!getPasswordValue().isEmpty()) {
                txtDockerPassword.setText(getPasswordValue());
            }
        } else {
            txtOtherRegistryURL.setVisible(true);
            containerOtherRegistry.setVisible(true);
            containerDockerRegistry.setVisible(false);
            
            if (!getEmailValue().isEmpty()) {
                txtOtherEmail.setText(getEmailValue());
            }
            if (!getUsernameValue().isEmpty()) {
                txtOtherUsername.setText(getUsernameValue());
            }
            if (!getPasswordValue().isEmpty()) {
                txtOtherPassword.setText(getPasswordValue());
            }
        }
        
        validate();
    }
    
    private void previewAuthFieldsForOtherRegistry() {
        FormData data;
        
        Label lblEnterRegistryURL = new Label(containerOtherRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(containerOtherRegistry);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblEnterRegistryURL.setLayoutData(data);
        lblEnterRegistryURL.setText(ENTER_REGISTRY_URL);
        
        txtOtherRegistryURL = new Text(containerOtherRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(containerOtherRegistry);
        data.left = new FormAttachment(lblEnterRegistryURL, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtOtherRegistryURL.setLayoutData(data);
        if (getDockerHubOtherRegistryURL() != null && !getDockerHubOtherRegistryURL().isEmpty()) {
            txtOtherRegistryURL.setText(getDockerHubOtherRegistryURL());
        }
        
        txtOtherRegistryURL.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setDockerHubOtherRegistryURL(txtOtherRegistryURL.getText());
                validate();
            }
        });
        
        Label lblEmail = new Label(containerOtherRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(txtOtherRegistryURL, 20);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblEmail.setLayoutData(data);
        lblEmail.setText(EMAIL);

        txtOtherEmail = new Text(containerOtherRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(txtOtherRegistryURL, 20);
        data.left = new FormAttachment(lblEmail, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtOtherEmail.setLayoutData(data);

        txtOtherEmail.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setEmailValue(txtOtherEmail.getText());
                validate();
            }
        });

        Label lblUsername = new Label(containerOtherRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 25);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblUsername.setLayoutData(data);
        lblUsername.setText(USERNAME);

        txtOtherUsername = new Text(containerOtherRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 25);
        data.left = new FormAttachment(lblUsername, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtOtherUsername.setLayoutData(data);

        txtOtherUsername.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setUsernameValue(txtOtherUsername.getText());
                validate();
            }
        });

        Label lblPassword = new Label(containerOtherRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 25);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPassword.setLayoutData(data);
        lblPassword.setText(PASSWORD);

        txtOtherPassword = new Text(containerOtherRegistry, SWT.PASSWORD | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 25);
        data.left = new FormAttachment(lblPassword, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtOtherPassword.setLayoutData(data);

        txtOtherPassword.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPasswordValue(txtOtherPassword.getText());
                validate();
            }
        });
    }
    
    private void previewAuthFieldsForDockerRegistry() {
        FormData data;
        
        Label lblEmail = new Label(containerDockerRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(containerDockerRegistry);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblEmail.setLayoutData(data);
        lblEmail.setText(EMAIL);

        txtDockerEmail = new Text(containerDockerRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(containerDockerRegistry);
        data.left = new FormAttachment(lblEmail, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtDockerEmail.setLayoutData(data);
        if (!getEmailValue().isEmpty()) {
            txtDockerEmail.setText(getEmailValue());
        }

        txtDockerEmail.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setEmailValue(txtDockerEmail.getText());
                validate();
            }
        });

        Label lblUsername = new Label(containerDockerRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 25);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblUsername.setLayoutData(data);
        lblUsername.setText(USERNAME);

        txtDockerUsername = new Text(containerDockerRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 25);
        data.left = new FormAttachment(lblUsername, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtDockerUsername.setLayoutData(data);
        if (!getUsernameValue().isEmpty()) {
            txtDockerUsername.setText(getUsernameValue());
        }

        txtDockerUsername.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setUsernameValue(txtDockerUsername.getText());
                validate();
            }
        });

        Label lblPassword = new Label(containerDockerRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 25);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPassword.setLayoutData(data);
        lblPassword.setText(PASSWORD);

        txtDockerPassword = new Text(containerDockerRegistry, SWT.PASSWORD | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 25);
        data.left = new FormAttachment(lblPassword, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtDockerPassword.setLayoutData(data);
        if (!getPasswordValue().isEmpty()) {
            txtDockerPassword.setText(getPasswordValue());
        }

        txtDockerPassword.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPasswordValue(txtDockerPassword.getText());
                validate();
            }
        });
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getUsernameValue() == null || getUsernameValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry username");
            setPageComplete(false);
            return;
        } else if (getPasswordValue() == null || getPasswordValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry password");
            setPageComplete(false);
            return;
        } else if (getEmailValue() == null || getEmailValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry email");
            setPageComplete(false);
            return;
        } else if (!validateEmail(getEmailValue())) {
            setErrorMessage("Please enter a valid Email address");
            setPageComplete(false);
            return;
        } else if (getSelectedRegistryType().equals(OTHER_REGISTRY)
                && (getDockerHubOtherRegistryURL() == null || getDockerHubOtherRegistryURL().isEmpty())) {
            setErrorMessage("Please enter a valid registry URL to push the Docker image");
            setPageComplete(false);
            return;
        }

        setErrorMessage(null);
        setPageComplete(true);
    }
    
    private void setRegistryURLValues(IFile containerPomFile) {
     // take repository and tag from the pom file
        String repository = "";
        MavenProject mavenProject;
        try {
            mavenProject = MavenUtils.getMavenProject(containerPomFile.getLocation().toFile());
            List<Plugin> pluginList = mavenProject.getBuildPlugins();
            for (Plugin plugin : pluginList) {
                if (plugin.getGroupId().equals("com.spotify")) {
                    PluginExecution pluginExecution = plugin.getExecutions().get(0);
                    Xpp3Dom[] childs = ((Xpp3Dom) pluginExecution.getConfiguration()).getChildren();
                    for (Xpp3Dom child : childs) {
                        if (child.getName().equals(DockerProjectConstants.DOCKER_REPOSITORY)) {
                            repository = child.getValue();
                        } 
                    }
                }
            }
        } catch (IOException e) {
            log.error("IOException while reading the pom file in auth wizard", e);
        } catch (XmlPullParserException e) {
            log.error("XmlPullParserException while reading the pom file in auth wizard", e);
        }
        
        String[] repositoryTags = repository.split("/");
        if (repositoryTags.length == 3) {
            setSelectedRegistryType(OTHER_REGISTRY);
            setDockerHubOtherRegistryURL(repositoryTags[0]);
        } else {
            setSelectedRegistryType(DOCKERHUB_REGISTRY);
        }
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public String getUsernameValue() {
        return dockerHubUsername;
    }

    public void setUsernameValue(String username) {
        this.dockerHubUsername = username;
    }

    public String getPasswordValue() {
        return dockerHubPassword;
    }

    public void setPasswordValue(String password) {
        this.dockerHubPassword = password;
    }

    public String getEmailValue() {
        return dockerHubEmail;
    }

    public void setEmailValue(String email) {
        this.dockerHubEmail = email;
    }

    public String getDockerHubOtherRegistryURL() {
        return dockerHubOtherRegistryURL;
    }

    public void setDockerHubOtherRegistryURL(String dockerHubOtherRegistryURL) {
        this.dockerHubOtherRegistryURL = dockerHubOtherRegistryURL;
    }

    public String getSelectedRegistryType() {
        return selectedRegistryType;
    }

    public void setSelectedRegistryType(String selectedRegistryType) {
        this.selectedRegistryType = selectedRegistryType;
    }
    
}
