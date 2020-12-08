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
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

public class DockerHubLoginPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private static final String DIALOG_TITLE = "Docker Registry Credentials";
    private static final String SUB_DIALOG_TITLE = "Enter Docker Registry Credentials";
    private static final String EMPTY_STRING = "";
    private static final String REGISTRY_URL = "Registry URL Type:";
    private static final String IMAGE_NAME = "Docker Image Name:";
    private static final String ENTER_REGISTRY_URL = "Enter Registry URL:";
    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    public final String DOCKERHUB_REGISTRY = "Docker Hub";
    public final String OTHER_REGISTRY = "Other";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private String dockerHubUsername = EMPTY_STRING;
    private String dockerHubPassword = EMPTY_STRING;
    private String dockerHubOtherRegistryURL = EMPTY_STRING;
    private String selectedRegistryType = EMPTY_STRING;
    private String dockerImageName = EMPTY_STRING;

    private Combo registryURLCombo;
    private Text txtDockerUsername;
    private Text txtDockerPassword;
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
        
        Label lblImageName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblImageName.setLayoutData(data);
        lblImageName.setText(IMAGE_NAME);
        
        Text txtImageNameValue = new Text(container, SWT.READ_ONLY | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(lblImageName, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtImageNameValue.setLayoutData(data);
        txtImageNameValue.setText(dockerImageName);
        txtImageNameValue.setSelection(0);
        
        Label lblRegistryURL = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblImageName, 20);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblRegistryURL.setLayoutData(data);
        lblRegistryURL.setText(REGISTRY_URL);

        String[] registryContainers = { DOCKERHUB_REGISTRY, OTHER_REGISTRY };
        registryURLCombo = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
        registryURLCombo.setItems(registryContainers);
        data = new FormData();
        data.top = new FormAttachment(lblImageName, 20);
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
        data.top = new FormAttachment(registryURLCombo, 16);
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

        Label lblUsername = new Label(containerOtherRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblEnterRegistryURL, 25);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblUsername.setLayoutData(data);
        lblUsername.setText(USERNAME);

        txtOtherUsername = new Text(containerOtherRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblEnterRegistryURL, 25);
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
        
        Label lblUsername = new Label(containerDockerRegistry, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(containerDockerRegistry);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblUsername.setLayoutData(data);
        lblUsername.setText(USERNAME);

        txtDockerUsername = new Text(containerDockerRegistry, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(containerDockerRegistry);
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
        txtDockerPassword.setFocus();
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
        String repository;
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(containerPomFile.getLocation().toFile());
            
            //checks pom is an old project or not
            //it checks buildArg parameter is there in docker plugin to verify whether this pom is a new one or not
            XPathExpression xpBuildArgs = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.DOCKER_SPOTIFY_PLUGIN_BUILD_ARG);
            if (xpBuildArgs.evaluate(doc).isEmpty()) {
                
                //Read target repository name and the tag from the pom spotify plugin tags
                XPathExpression xpRepo = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH_OLD);
                repository = xpRepo.evaluate(doc);
                dockerImageName += repository;
                
                XPathExpression xpTag = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_TAG_XPATH_OLD);
                dockerImageName += ":" + xpTag.evaluate(doc);
            } else {
                //Read target repository name and the tag from the pom properties tags
                XPathExpression xpRepo = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH);
                repository = xpRepo.evaluate(doc);
                dockerImageName += repository;
                
                XPathExpression xpTag = XPathFactory.newInstance().newXPath().compile(DockerProjectConstants.TARGET_TAG_XPATH);
                dockerImageName += ":" + xpTag.evaluate(doc);
            }
            
            String[] repositoryTags = repository.split("/");
            if (repositoryTags.length == 3) {
                setSelectedRegistryType(OTHER_REGISTRY);
                setDockerHubOtherRegistryURL(repositoryTags[0]);
                setUsernameValue(repositoryTags[1]);
            } else {
                setUsernameValue(repositoryTags[0]);
                setSelectedRegistryType(DOCKERHUB_REGISTRY);
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
