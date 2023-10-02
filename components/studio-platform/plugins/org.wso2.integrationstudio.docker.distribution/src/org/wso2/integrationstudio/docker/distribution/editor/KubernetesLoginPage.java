/*
 * Copyright (c) 2023, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.docker.distribution.editor;

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
import org.wso2.integrationstudio.docker.distribution.Activator;
import org.wso2.integrationstudio.docker.distribution.utils.DockerProjectConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.xml.sax.SAXException;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class KubernetesLoginPage extends WizardPage {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String DIALOG_TITLE = "Docker Registry Credentials";
	private static final String SUB_DIALOG_TITLE = "Enter Docker Registry Credentials";
	private static final String BASE_IMAGE_AUTHENTICATION_TEXT = "Base Image Docker Authentication";
	private static final String PUSH_DOCKER_AUTHENTICATION_TEXT = "Push Image Docker Authentication";
	private static final String EMPTY_STRING = "";
	private static final String REGISTRY_TYPE = "Registry Type:";
	private static final String REGISTRY_URL = "Registry URL Type:";
	private static final String IMAGE_NAME = "Image Name:";
	private static final String ENTER_REGISTRY_URL = "Enter Registry URL:";
	private static final String USERNAME = "Username:";
	private static final String PASSWORD = "Password:";
	public final String DOCKERHUB_REGISTRY = "Docker Hub";
	public final String OTHER_REGISTRY = "Other";
	private static final String ARIAL = "Arial";
	private final String PUBLIC = "Public";
	private final String PRIVATE = "Private";

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	        Pattern.CASE_INSENSITIVE);

	private String wso2DockerHubUsername = EMPTY_STRING;
	private String wso2DockerHubPassword = EMPTY_STRING;
	private String selectedWso2RegistryType = EMPTY_STRING;

	private String targetDockerHubUsername = EMPTY_STRING;
	private String targetDockerHubPassword = EMPTY_STRING;
	private String dockerHubOtherRegistryURL = EMPTY_STRING;
	private String selectedRegistryType = EMPTY_STRING;
	private String targetDockerImageName = EMPTY_STRING;

	private Combo wso2RegistryURLCombo;
	private Text txtWso2DockerUsername;
	private Text txtWso2DockerPassword;
	private Composite containerPrivateWso2DockerRegistry;

	private Combo registryURLCombo;
	private Text txtDockerUsername;
	private Text txtDockerPassword;
	private Text txtOtherUsername;
	private Text txtOtherPassword;
	private Text txtOtherRegistryURL;
	private Composite pushDockerRegistry;
	private Composite containerOtherRegistry;
	private Composite containerDockerRegistry;

	protected KubernetesLoginPage(IWorkbench wb, IStructuredSelection selection, IFile pomFile) {
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

		Label titleLabel = new Label(container, SWT.NONE);
		titleLabel.setText(BASE_IMAGE_AUTHENTICATION_TEXT);
		Font font = new Font(Display.getCurrent(), ARIAL, 12, SWT.BOLD);
		titleLabel.setFont(font);

		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);

		FormData titleData = new FormData();
		titleData.top = new FormAttachment(0);
		titleData.left = new FormAttachment(0, 10);
		titleLabel.setLayoutData(titleData);

		FormData separatorData = new FormData();
		separatorData.top = new FormAttachment(titleLabel, 5);
		separatorData.left = new FormAttachment(0, 10);
		separatorData.right = new FormAttachment(100, -10);
		separator.setLayoutData(separatorData);

		FormData contentData = new FormData();
		contentData.top = new FormAttachment(separator, 5);
		contentData.left = new FormAttachment(0, 10);
		contentData.right = new FormAttachment(100, -10);
		container.setLayoutData(contentData);

		Label lblWso2RegistryURL = new Label(container, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(separator, 20);
		data.left = new FormAttachment(3);
		data.width = 160;
		lblWso2RegistryURL.setLayoutData(data);
		lblWso2RegistryURL.setText(REGISTRY_TYPE);

		String[] wso2RegistryContainers = { PUBLIC, PRIVATE };
		wso2RegistryURLCombo = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
		wso2RegistryURLCombo.setItems(wso2RegistryContainers);
		data = new FormData();
		data.top = new FormAttachment(separator, 20);
		data.left = new FormAttachment(lblWso2RegistryURL, 0);
		data.right = new FormAttachment(97);
		data.width = 400;
		wso2RegistryURLCombo.setLayoutData(data);

		if (getSelectedWso2RegistryType() != null && !getSelectedWso2RegistryType().isEmpty()) {
			wso2RegistryURLCombo.setText(getSelectedWso2RegistryType());
		} else {
			wso2RegistryURLCombo.setText(wso2RegistryContainers[1]);
			setSelectedWso2RegistryType(wso2RegistryURLCombo.getText());
		}

		wso2RegistryURLCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				setSelectedWso2RegistryType(wso2RegistryURLCombo.getText());
				validate();
				changeWso2LoginView();
				container.layout();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		containerPrivateWso2DockerRegistry = new Composite(container, SWT.NULL);
		containerPrivateWso2DockerRegistry.setLayout(new FormLayout());

		data = new FormData();
		data.top = new FormAttachment(wso2RegistryURLCombo, 15);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		containerPrivateWso2DockerRegistry.setLayoutData(data);
		previewAuthFieldsForPullRegistry();

		pushDockerRegistry = new Composite(container, SWT.NULL);
		pushDockerRegistry.setLayout(new FormLayout());

		titleLabel = new Label(pushDockerRegistry, SWT.NONE);
		titleLabel.setText(PUSH_DOCKER_AUTHENTICATION_TEXT);
		titleLabel.setFont(font);

		separator = new Label(pushDockerRegistry, SWT.SEPARATOR | SWT.HORIZONTAL);

		titleData = new FormData();
		titleData.top = new FormAttachment(containerPrivateWso2DockerRegistry, 10);
		titleData.left = new FormAttachment(0, 10);
		titleLabel.setLayoutData(titleData);

		separatorData = new FormData();
		separatorData.top = new FormAttachment(titleLabel, 5);
		separatorData.left = new FormAttachment(0, 10);
		separatorData.right = new FormAttachment(100, -10);
		separator.setLayoutData(separatorData);

		contentData = new FormData();
		contentData.top = new FormAttachment(separator, 5);
		contentData.left = new FormAttachment(0, 10);
		contentData.right = new FormAttachment(100, -10);
		pushDockerRegistry.setLayoutData(contentData);

		Label lblImageName = new Label(pushDockerRegistry, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(separator, 10);
		data.left = new FormAttachment(3);
		data.width = 160;
		lblImageName.setLayoutData(data);
		lblImageName.setText(IMAGE_NAME);

		Text txtImageNameValue = new Text(pushDockerRegistry, SWT.READ_ONLY | SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(separator, 10);
		data.left = new FormAttachment(lblImageName, 0);
		data.right = new FormAttachment(97);
		data.width = 400;
		txtImageNameValue.setLayoutData(data);
		txtImageNameValue.setText(targetDockerImageName);
		txtImageNameValue.setSelection(0);

		Label lblRegistryURL = new Label(pushDockerRegistry, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblImageName, 20);
		data.left = new FormAttachment(3);
		data.width = 160;
		lblRegistryURL.setLayoutData(data);
		lblRegistryURL.setText(REGISTRY_URL);

		String[] registryContainers = { DOCKERHUB_REGISTRY, OTHER_REGISTRY };
		registryURLCombo = new Combo(pushDockerRegistry, SWT.READ_ONLY | SWT.BORDER);
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
				container.layout();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		containerOtherRegistry = new Composite(pushDockerRegistry, SWT.NULL);
		containerOtherRegistry.setLayout(new FormLayout());
		containerDockerRegistry = new Composite(pushDockerRegistry, SWT.NULL);
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
		changeWso2LoginView();
		container.layout();
		setPageComplete(false);
		font.dispose();
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

	private void changeWso2LoginView() {
		if (getSelectedWso2RegistryType().equals(PRIVATE)) {
			containerPrivateWso2DockerRegistry.setVisible(true);
			FormData data = new FormData();
			data.top = new FormAttachment(containerPrivateWso2DockerRegistry, 15);
			data.left = new FormAttachment(0);
			data.right = new FormAttachment(100);
			pushDockerRegistry.setLayoutData(data);
			if (!getUsernameValue().isEmpty()) {
				txtWso2DockerUsername.setText(getWso2DockerUsernameValue());
			}
			if (!getPasswordValue().isEmpty()) {
				txtWso2DockerPassword.setText(getWso2DockerPasswordValue());
			}
		} else {
			containerPrivateWso2DockerRegistry.setVisible(false);
			FormData data = new FormData();
			data.top = new FormAttachment(wso2RegistryURLCombo, 15);
			data.left = new FormAttachment(0);
			data.right = new FormAttachment(100);
			pushDockerRegistry.setLayoutData(data);
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

	private void previewAuthFieldsForPullRegistry() {
		FormData data;

		Label lblUsername = new Label(containerPrivateWso2DockerRegistry, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(containerPrivateWso2DockerRegistry);
		data.left = new FormAttachment(3);
		data.width = 160;
		lblUsername.setLayoutData(data);
		lblUsername.setText(USERNAME);

		txtWso2DockerUsername = new Text(containerPrivateWso2DockerRegistry, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(containerPrivateWso2DockerRegistry);
		data.left = new FormAttachment(lblUsername, 0);
		data.right = new FormAttachment(97);
		data.width = 400;
		txtWso2DockerUsername.setLayoutData(data);
		if (!getWso2DockerUsernameValue().isEmpty()) {
			txtWso2DockerUsername.setText(getWso2DockerUsernameValue());
		}

		txtWso2DockerUsername.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setWso2DockerUsernameValue(txtWso2DockerUsername.getText());
				validate();
			}
		});

		Label lblPassword = new Label(containerPrivateWso2DockerRegistry, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblUsername, 25);
		data.left = new FormAttachment(3);
		data.width = 160;
		lblPassword.setLayoutData(data);
		lblPassword.setText(PASSWORD);

		txtWso2DockerPassword = new Text(containerPrivateWso2DockerRegistry, SWT.PASSWORD | SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblUsername, 25);
		data.left = new FormAttachment(lblPassword, 0);
		data.right = new FormAttachment(97);
		data.width = 400;
		txtWso2DockerPassword.setLayoutData(data);
		txtWso2DockerPassword.setFocus();
		if (!getWso2DockerPasswordValue().isEmpty()) {
			txtWso2DockerPassword.setText(getWso2DockerPasswordValue());
		}

		txtWso2DockerPassword.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setWso2DockerPasswordValue(txtWso2DockerPassword.getText());
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

		} else if (getSelectedWso2RegistryType().equals(PRIVATE)) {
			if (getWso2DockerUsernameValue() == null || getWso2DockerUsernameValue().equals(EMPTY_STRING)) {
				setErrorMessage("Please enter the base image Docker registry username");
				setPageComplete(false);
				return;
			} else if (getWso2DockerPasswordValue() == null || getWso2DockerPasswordValue().equals(EMPTY_STRING)) {
				setErrorMessage("Please enter the base image Docker registry password");
				setPageComplete(false);
				return;
			}
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

			// checks pom is an old project or not
			// it checks buildArg parameter is there in docker plugin to verify whether this pom is a new one or not
			XPathExpression xpBuildArgs = XPathFactory.newInstance().newXPath()
			        .compile(DockerProjectConstants.DOCKER_MAVEN_PLUGIN_BUILD_ARG);
			if (xpBuildArgs.evaluate(doc).isEmpty()) {

				// Read target repository name and the tag from the pom docker plugin tags
				XPathExpression xpRepo = XPathFactory.newInstance().newXPath()
				        .compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH_OLD);
				repository = xpRepo.evaluate(doc);
				targetDockerImageName += repository;

			} else {
				// Read target repository name and the tag from the pom properties tags
				XPathExpression xpRepo = XPathFactory.newInstance().newXPath()
				        .compile(DockerProjectConstants.TARGET_REPOSITORY_XPATH);
				repository = xpRepo.evaluate(doc);
				targetDockerImageName += repository;

				XPathExpression xpTag = XPathFactory.newInstance().newXPath()
				        .compile(DockerProjectConstants.TARGET_TAG_XPATH);
				targetDockerImageName += ":" + xpTag.evaluate(doc);
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
		return targetDockerHubUsername;
	}

	public void setUsernameValue(String username) {
		this.targetDockerHubUsername = username;
	}

	public String getPasswordValue() {
		return targetDockerHubPassword;
	}

	public void setPasswordValue(String password) {
		this.targetDockerHubPassword = password;
	}

	public String getWso2DockerUsernameValue() {
		return wso2DockerHubUsername;
	}

	public void setWso2DockerUsernameValue(String username) {
		this.wso2DockerHubUsername = username;
	}

	public String getWso2DockerPasswordValue() {
		return wso2DockerHubPassword;
	}

	public void setWso2DockerPasswordValue(String password) {
		this.wso2DockerHubPassword = password;
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

	public String getSelectedWso2RegistryType() {
		return selectedWso2RegistryType;
	}

	public void setSelectedWso2RegistryType(String selectedWso2RegistryType) {
		this.selectedWso2RegistryType = selectedWso2RegistryType;
	}

}
