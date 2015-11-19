/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.security.project.ui.form;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormConstants;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.security.Activator;
import org.wso2.developerstudio.eclipse.security.project.model.Policy2;
import org.wso2.developerstudio.eclipse.security.project.ui.dialog.UserRolesDialog;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicies;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicyUtils;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityTemplateUtil;
import org.xml.sax.SAXException;
import org.eclipse.swt.widgets.Control;

public class SecurityFormPage extends FormPage {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final int NUMBER_OF_COLUMNS_IN_SHELL = 1;
    private static final int NUM_OF_COLUMNS_GRID_LAYOUT_MAIN_PAGE = 6;
    private static final String TIP_MESSAGE = "Description not available";
    private static final String PLUGIN_NAME = "org.wso2.developerstudio.eclipse.artifact.security";

    private boolean pageDirty = false;

    public IProject project;
    private File physicalPolicyFile;
    private File policyTemplateFile;
    private Policy2 policyObject;
    private String selectedPolicy;
    private String policyFileName;
    private String policyID;
    private Document policyFileDOMDocument;

    private List<String> userRoles;

    private Object[] encryptionPropertiesContainer;
    private Object[] signaturePropertiesContainer;
    private Object[] kerberosPropertiesContainer;

    private Map<String, String> rampartConfigDataMap;
    private Map<String, String> encryptionPropertiesDataMap;
    private Map<String, String> signaturePropertiesDataMap;
    private Map<String, String> kerberosPropertiesDataMap;
    private Map<String, String> carbonSecAuthDataMap;
    private Map<String, String> carbonSecTrustDataMap;

    private Map<String, Object> rampartConfigControlMap;
    private Map<String, Text> encryptionPropertiesControlMap;
    private Map<String, Text> signaturePropertiesControlMap;
    private Map<String, Text> kerberosPropertiesControlMap;
    private Map<String, String> carbonSecAuthControlMap;
    private Map<String, Text> carbonSecTrustControlMap;

    private Map<String, Button> policyButtonMap;

    // UI components
    private Button policyOneUserRolesButton;
    private Button policySevenUserRolesButton;
    private Button policyEightUserRolesButton;
    private Button policyFourteenUserRolesButton;
    private Button policyFifteenUserRolesButton;
    private Text kerberosPrincipalNameText;
    private Text kerberosPrincipalPasswordText;
    private Text rampartUserText;
    private Text rampartEncryptionUserText;
    private Text rampartMinTTLText;
    private Text rampartTimestampMaxSkewText;
    private Text rampartTokenStoreClassText;
    private Text rampartNonceLifeTimeText;
    private Combo rampartTimestampStrictCombo;
    private Combo rampartTimestampPrecisionCombo;
    private Image securityScenarioBalloonBackgroundImage;
    private Shell parentShell;

    public SecurityFormPage(FormEditor editor, String id, String title, IProject iproject, File file, Display display) {
        super(editor, id, title);

        userRoles = new ArrayList<>();
        rampartConfigDataMap = new HashMap<>();
        encryptionPropertiesDataMap = new HashMap<>();
        signaturePropertiesDataMap = new HashMap<>();
        carbonSecAuthDataMap = new HashMap<>();
        carbonSecTrustDataMap = new HashMap<>();
        kerberosPropertiesDataMap = new HashMap<>();

        // Fill Data Maps with default values
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_USER, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER,
                SecurityFormConstants.RAMPART_ENCRYPTION_USER_VALUE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, SecurityFormConstants.RAMPART_TIME_VALUE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, SecurityFormConstants
                .RAMPART_TIME_VALUE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS,
                SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS_VALUE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, SecurityFormConstants
                .RAMPART_TIME_VALUE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
                SecurityFormConstants.VALUE_FALSE);
        rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, SecurityFormConstants.VALUE_FALSE);

        encryptionPropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
                SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
        encryptionPropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
                SecurityFormConstants.WSO2_PRIVATESTORE);
        encryptionPropertiesDataMap
                .put(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID, SecurityFormConstants.RAMPART_TENANT_VALUE);
        encryptionPropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
                SecurityFormConstants.WSO2_PRIVATESTORE);
        encryptionPropertiesDataMap.put(SecurityFormConstants.RAMPART_CONFIG_USER, SecurityFormConstants
                .WSO2_PRIVATESTORE_ALIAS);

        signaturePropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
                SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
        signaturePropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
                SecurityFormConstants.WSO2_PRIVATESTORE);
        signaturePropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID, SecurityFormConstants
                .RAMPART_TENANT_VALUE);
        signaturePropertiesDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
                SecurityFormConstants.WSO2_PRIVATESTORE);
        signaturePropertiesDataMap.put(SecurityFormConstants.RAMPART_CONFIG_USER, SecurityFormConstants
                .WSO2_PRIVATESTORE_ALIAS);

        carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
                SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
        carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
                SecurityFormConstants.WSO2_PRIVATESTORE);
        carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
                SecurityFormConstants.WSO2_PRIVATESTORE);

        rampartConfigControlMap = new HashMap<>();
        encryptionPropertiesControlMap = new HashMap<>();
        signaturePropertiesControlMap = new HashMap<>();
        kerberosPropertiesControlMap = new HashMap<>();
        carbonSecAuthControlMap = new HashMap<>();
        carbonSecTrustControlMap = new HashMap<>();

        policyButtonMap = new HashMap<>();
        physicalPolicyFile = file;
        policyTemplateFile = file;
        project = iproject;

        String policyFileContent = convertXMLFileToString(policyTemplateFile);
        InputStream policyFileStream = new ByteArrayInputStream(policyFileContent.getBytes());
        closeInputStream(policyFileStream);

        try {
            Unmarshaller pUnmarshaller = getUnmarshaller();
            policyObject = (Policy2) pUnmarshaller.unmarshal(policyFileStream);
            policyID = policyObject.getId();
            selectedPolicy = SecurityPolicyUtils.getInstance().getPolicyTypeFromPolicyUUID(policyID);
            DocumentBuilder dBuilder = getDocumentBuilder();
            policyFileDOMDocument = dBuilder.parse(policyTemplateFile);
        } catch (JAXBException | IOException | ParserConfigurationException | SAXException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_INITIALIZE_ERROR, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_INITIALIZE_ERROR);
            msg.open();
        }
    }

    protected void createFormContent(IManagedForm managedForm) {

        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.setText(SecurityFormConstants.EDITOR_TITLE);
        Composite body = form.getBody();
        GridLayout gridParentLayout = new GridLayout(1, true);

        body.setLayout(gridParentLayout);
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);

        //Create a main section for basic and advanced security scenarios
        Object[] securityScenarioSection = createMainSection(toolkit, body, SecurityFormConstants
                        .SECTION_SECURITY_SERVICE, 10, 70, 600,
                30, true);
        Composite securityScenarioComposite = (Composite) securityScenarioSection[1];
        GridLayout gridSecLayout = new GridLayout(NUM_OF_COLUMNS_GRID_LAYOUT_MAIN_PAGE, false);
        securityScenarioComposite.setLayout(gridSecLayout);

        createCategory(toolkit, securityScenarioComposite, SecurityFormConstants.BASIC_SCENARIOS);
        try {
            createSecurityScenarioOptionButtons(securityScenarioComposite, SecurityPolicyUtils.getInstance()
                    .getBasicSecurityScenarios(), managedForm, 0);
        } catch (IOException | JAXBException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_READ_POLICY, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
            msg.open();
        }

        createCategory(toolkit, securityScenarioComposite, SecurityFormConstants.ADVANCED_SCENARIOS);
        try {
            createSecurityScenarioOptionButtons(securityScenarioComposite, SecurityPolicyUtils.getInstance()
                    .getAdvancedSecurityScenarios(), managedForm, 4);
        } catch (IOException | JAXBException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_READ_POLICY, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
            msg.open();
        }

        //Create a main section for Rampart advanced configurations
        Object[] rampartConfigSection = createMainSection(toolkit, body, SecurityFormConstants.ADVANCE_CONFIGURATION,
                10, 15, 600, 30, true);
        Composite rampartInfComposite = (Composite) rampartConfigSection[1];
        GridLayout rampartInfoLayout = new GridLayout();
        rampartInfComposite.setLayout(rampartInfoLayout);

        //Create a sub main section for Rampart Configuration
        Object[] rampartBasicContainer = createMainSection(toolkit, rampartInfComposite, SecurityFormConstants
                .SECTION_RAMPART_CONFIGURATION, 10, 20, 600, 30, true);
        Composite rampartBasicComposite = (Composite) rampartBasicContainer[1];
        GridLayout rampartBasicLayout = new GridLayout(2, false);
        rampartBasicComposite.setLayout(rampartBasicLayout);

        createRampartConfigUIs(managedForm, rampartBasicComposite);

        //Create a sub main section for Encryption Properties
        encryptionPropertiesContainer = createMainSection(toolkit, rampartInfComposite,
                SecurityFormConstants.SECTION_ENCRYPTION_PROPERTIES, 10, 20, 600, 30, false);
        Composite encryptionPropertiesComposite = (Composite) encryptionPropertiesContainer[1];
        GridLayout encryptionPropertiesLayout = new GridLayout(3, false);
        encryptionPropertiesComposite.setLayout(encryptionPropertiesLayout);
        Section encryptionPropertiesSection = (Section) this.encryptionPropertiesContainer[0];
        encryptionPropertiesSection.setVisible(false);

        //Create a sub main section for Signature Properties
        signaturePropertiesContainer = createMainSection(toolkit, rampartInfComposite,
                SecurityFormConstants.SECTION_SIGNATURE_PROPOERTIES, 10, 30, 600, 30, false);
        Composite signaturePropertiesComposite = (Composite) signaturePropertiesContainer[1];
        GridLayout signaturePropertiesLayout = new GridLayout(3, false);
        signaturePropertiesComposite.setLayout(signaturePropertiesLayout);
        Section signaturePropertiesSection = (Section) this.signaturePropertiesContainer[0];
        signaturePropertiesSection.setVisible(false);

        String[] rampartProperties = new String[]{
                SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS + SecurityFormConstants.ALIAS,
                SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE + SecurityFormConstants.PRIVATESTORE,
                SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID + SecurityFormConstants.TENANT_ID,
                SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES + SecurityFormConstants.TRUSTSTORES,
                SecurityFormConstants.RAMPART_CONFIG_USER + SecurityFormConstants.USER};
        for (String property : rampartProperties) {
            createRampartPropertiesUIs(toolkit, encryptionPropertiesComposite, property, SecurityFormConstants.EN);
            createRampartPropertiesUIs(toolkit, signaturePropertiesComposite, property, SecurityFormConstants.SIGN);
        }

        // UI for Kerberos
        kerberosPropertiesContainer = createMainSection(toolkit, body, SecurityFormConstants.SECTION_KERBEROS, 10,
                70, 600, 30,
                false);
        Composite kerberosPropertiesComposite = (Composite) kerberosPropertiesContainer[1];
        GridLayout kerberosPropertiesLayout = new GridLayout();
        kerberosPropertiesComposite.setLayout(kerberosPropertiesLayout);
        Section kerberosPropertiesSection = (Section) this.kerberosPropertiesContainer[0];
        kerberosPropertiesSection.setVisible(false);

        Composite compositeKerberos = new Composite(kerberosPropertiesComposite, SWT.NULL);
        GridLayout basicLayout = new GridLayout(3, false);
        compositeKerberos.setLayout(basicLayout);

        toolkit.createLabel(compositeKerberos, SecurityFormConstants.LABEL_SERVICE_PRINCIPAL_NAME);

        Label nameMark = toolkit.createLabel(compositeKerberos, "*");
        Device device = Display.getCurrent();
        Color red = new Color(device, 255, 0, 0);
        nameMark.setForeground(red);

        kerberosPrincipalNameText = new Text(compositeKerberos, SWT.BORDER);
        kerberosPrincipalNameText.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
        GridData keylayoutData = new GridData();
        keylayoutData.minimumWidth = 200;
        keylayoutData.horizontalAlignment = SWT.FILL;
        keylayoutData.grabExcessHorizontalSpace = true;
        kerberosPrincipalNameText.setLayoutData(keylayoutData);
        kerberosPropertiesControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, kerberosPrincipalNameText);
        kerberosPrincipalNameText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                kerberosPropertiesDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, kerberosPrincipalNameText
                        .getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(compositeKerberos, SecurityFormConstants.LABEL_SERVICE_PRINCIPAL_PASSWORD);

        Label passMark = toolkit.createLabel(compositeKerberos, "*");
        passMark.setForeground(red);

        kerberosPrincipalPasswordText = new Text(compositeKerberos, SWT.BORDER);
        kerberosPrincipalPasswordText.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
        GridData keyplayoutData = new GridData();
        keyplayoutData.minimumWidth = 200;
        keyplayoutData.horizontalAlignment = SWT.FILL;
        keyplayoutData.grabExcessHorizontalSpace = true;
        kerberosPrincipalPasswordText.setLayoutData(keyplayoutData);
        kerberosPropertiesControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD,
                kerberosPrincipalPasswordText);
        kerberosPrincipalPasswordText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                kerberosPropertiesDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD,
                        kerberosPrincipalPasswordText.getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        //Update form UI according to xml given
        try {
            updateSecurityOptionButton();
            updateRampartUIAndUserRoles();
            setDirty(false);
            updateDirtyState();
        } catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_LOAD_PAGE, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
            msg.open();
        }
    }

    /**
     * Saves the form content to the XML file
     */
    public boolean doPageSave() {
        //If the user roles are not set for security scenarios that requires it, not allowing to save it
        if (SecurityPolicyUtils.getInstance().getUserRoleRequiredSecurityScenarios().contains(selectedPolicy) &&
                userRoles.isEmpty()) {
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.USER_ROLES_NOT_SET_ERROR);
            msg.open();
            return false;
        }
        try {
            // Update the control maps
            updateControlMaps();

            // Update data maps with user inputs
            updateDataMaps();

            // Updates the source view
            updateSourceConfiguration();

            // Saves the final output to the physicalPolicyFile
            saveFinalConfigToFile();

            // Refresh project with file system
            refreshProject();

        } catch (JAXBException | IOException | CoreException | ParserConfigurationException | SAXException
                | TransformerException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.error("Saving Error", e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
            msg.open();
            return false;
        }
        setDirty(false);
        return true;
    }

    /**
     * Update the source at page change
     *
     * @return updated source as a string
     */
    public String updateSource() {
        String updatedContent = null;
        try {
            // Adds the policy
            updateControlMaps();
            // Update data maps with user inputs
            updateDataMaps();
            // Updates the source view
            updateSourceConfiguration();
            //Get the updated content
            updatedContent = getUpdatedContent();
        } catch (JAXBException | IOException | CoreException | ParserConfigurationException | SAXException
                | TransformerException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_SAVE, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
            msg.open();
        }
        return updatedContent;
    }

    /**
     * Update the UI at page change
     *
     * @param xmlSource xml source as string
     */
    public void updateUI(String xmlSource) {
        try {
            Unmarshaller uUnmarshaller = getUnmarshaller();
            InputStream xmlStream = new ByteArrayInputStream(xmlSource.getBytes());
            policyObject = (Policy2) uUnmarshaller.unmarshal(xmlStream);
            policyID = policyObject.getId();
            selectedPolicy = SecurityPolicyUtils.getInstance().getPolicyTypeFromPolicyUUID(policyID);
            closeInputStream(xmlStream);

            xmlStream = new ByteArrayInputStream(xmlSource.getBytes());
            DocumentBuilder dBuilder = getDocumentBuilder();
            policyFileDOMDocument = dBuilder.parse(xmlStream);

            updateSecurityOptionButton();
            updateRampartUIAndUserRoles();
            setDirty(false);
            updateDirtyState();
        } catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
            log.error("Error in loading page", e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
            msg.open();
        }
    }

    public void updateDirtyState() {
        ((SecurityFormEditor) getEditor()).updateDirtyState();
    }

    public void setDirty(boolean isPageDirty) {
        this.pageDirty = isPageDirty;
    }

    @Override
    public boolean isDirty() {
        return pageDirty;
    }

    /**
     * <p>
     * Security scenario number should provide for this method.
     * <p>
     * <p>
     * This method opens a shell window which shows the description of mentioned security scenario given in the
     * parameter list.
     *
     * @param scenarioNumber
     */
    private void showPolicyUseCase(int scenarioNumber) {

        String shellTitle = SecurityFormConstants.SHELL_WINDOW_TITLE_PREFIX + scenarioNumber;
        Shell existingShell = getExistingUseCaseShell(shellTitle);

        if (existingShell == null) {

            String fileName = SecurityFormConstants.IMAGE_PREFIX + scenarioNumber + SecurityFormConstants.IMAGE_POSTFIX;
            String relativeFilePath = SecurityFormConstants.RELATIVE_FOLDER_PATH + fileName;
            String securityScenarioTitle = getSecurityScenarioTitle(scenarioNumber);

            Shell shell = new Shell(parentShell);
            Composite parent = new Composite(shell, SWT.NONE);
            shell.setBackgroundImage(securityScenarioBalloonBackgroundImage);
            shell.setLayout(new RowLayout());
            shell.setText(shellTitle);

            GridLayout gridLayout = new GridLayout();
            gridLayout.numColumns = NUMBER_OF_COLUMNS_IN_SHELL;
            parent.setLayout(gridLayout);

            Label scenarioTitle = new Label(parent, SWT.NONE);
            scenarioTitle.setText(shellTitle + SecurityFormConstants.SECURITY_SCENARIO_TITLE_SEPARATOR
                    + securityScenarioTitle);
            GridData textGridData = new GridData();
            textGridData.horizontalAlignment = SWT.CENTER;
            scenarioTitle.setLayoutData(textGridData);

            Label labelImage = new Label(parent, SWT.NONE);
            Image scenarioImage = getScenarioImage(relativeFilePath);
            labelImage.setImage(scenarioImage);
            labelImage.setToolTipText(shellTitle);
            GridData imageGridData = new GridData();
            imageGridData.horizontalAlignment = SWT.CENTER;
            labelImage.setLayoutData(imageGridData);

            Rectangle monitorBound = Display.getCurrent().getPrimaryMonitor().getBounds();
            Rectangle shellBound = shell.getBounds();

            shell.setLocation(getXCoordinate(monitorBound, shellBound), getYCoordinate(monitorBound, shellBound));
            shell.pack();
            shell.open();
        } else {
            existingShell.open();
        }

    }

    private void createRampartConfigUIs(IManagedForm managedForm, Composite rampartBasic) {

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_USER);
        rampartUserText = managedForm.getToolkit().createText(rampartBasic, "");
        GridData rmUserlayoutData = new GridData();
        rmUserlayoutData.minimumWidth = 200;
        rmUserlayoutData.horizontalAlignment = SWT.FILL;
        rmUserlayoutData.grabExcessHorizontalSpace = true;
        rampartUserText.setLayoutData(rmUserlayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_USER, rampartUserText);

        rampartUserText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_USER, rampartUserText.getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_ENCRYPTION_USER);
        rampartEncryptionUserText = managedForm.getToolkit().createText(rampartBasic, "");
        GridData encryptionUserlayoutData = new GridData();
        encryptionUserlayoutData.minimumWidth = 200;
        encryptionUserlayoutData.horizontalAlignment = SWT.FILL;
        encryptionUserlayoutData.grabExcessHorizontalSpace = true;
        rampartEncryptionUserText.setLayoutData(encryptionUserlayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, rampartEncryptionUserText);

        rampartEncryptionUserText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, rampartEncryptionUserText
                        .getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        String[] values = new String[]{SecurityFormConstants.VALUE_FALSE, SecurityFormConstants.VALUE_TRUE};
        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_PRECISION);
        rampartTimestampPrecisionCombo = new Combo(rampartBasic, SWT.READ_ONLY);
        rampartTimestampPrecisionCombo.setItems(values);
        GridData timestampPrecisionInMillisecondslayoutData = new GridData();
        timestampPrecisionInMillisecondslayoutData.minimumWidth = 200;
        timestampPrecisionInMillisecondslayoutData.horizontalAlignment = SWT.FILL;
        timestampPrecisionInMillisecondslayoutData.grabExcessHorizontalSpace = true;
        rampartTimestampPrecisionCombo.setLayoutData(timestampPrecisionInMillisecondslayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
                rampartTimestampPrecisionCombo);

        rampartTimestampPrecisionCombo.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
                        rampartTimestampPrecisionCombo.getItem(rampartTimestampPrecisionCombo.getSelectionIndex()));
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_TTL);
        rampartMinTTLText = managedForm.getToolkit().createText(rampartBasic, " ");
        GridData timestampTTLlayoutData = new GridData();
        timestampTTLlayoutData.minimumWidth = 200;
        timestampTTLlayoutData.horizontalAlignment = SWT.FILL;
        timestampTTLlayoutData.grabExcessHorizontalSpace = true;
        rampartMinTTLText.setLayoutData(timestampTTLlayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, rampartMinTTLText);

        rampartMinTTLText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, rampartMinTTLText.getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_MAX);
        rampartTimestampMaxSkewText = managedForm.getToolkit().createText(rampartBasic, "");
        GridData timestampMaxSkewlayoutData = new GridData();
        timestampMaxSkewlayoutData.minimumWidth = 200;
        timestampMaxSkewlayoutData.horizontalAlignment = SWT.FILL;
        timestampMaxSkewlayoutData.grabExcessHorizontalSpace = true;
        rampartTimestampMaxSkewText.setLayoutData(timestampMaxSkewlayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, rampartTimestampMaxSkewText);

        rampartTimestampMaxSkewText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW,
                        rampartTimestampMaxSkewText.getText());
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_STRICT);
        rampartTimestampStrictCombo = new Combo(rampartBasic, SWT.READ_ONLY);
        rampartTimestampStrictCombo.setItems(values);
        GridData timestampStrictlayoutData = new GridData();
        timestampStrictlayoutData.minimumWidth = 200;
        timestampStrictlayoutData.horizontalAlignment = SWT.FILL;
        timestampStrictlayoutData.grabExcessHorizontalSpace = true;
        rampartTimestampStrictCombo.setLayoutData(timestampStrictlayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, rampartTimestampStrictCombo);

        rampartTimestampStrictCombo.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT,
                        rampartTimestampStrictCombo.getItem(rampartTimestampStrictCombo.getSelectionIndex()));
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TOKEN_STORE_CLASS);
        rampartTokenStoreClassText = managedForm.getToolkit().createText(rampartBasic, "");
        GridData tokenStoreClasslayoutData = new GridData();
        tokenStoreClasslayoutData.minimumWidth = 200;
        tokenStoreClasslayoutData.horizontalAlignment = SWT.FILL;
        tokenStoreClasslayoutData.grabExcessHorizontalSpace = true;
        rampartTokenStoreClassText.setLayoutData(tokenStoreClasslayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, rampartTokenStoreClassText);

        rampartTokenStoreClassText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, rampartTokenStoreClassText
                        .getText
                                ());
                setDirty(true);
                updateDirtyState();
            }
        });

        managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_NONCELIFETIME);
        rampartNonceLifeTimeText = managedForm.getToolkit().createText(rampartBasic, "");
        GridData nonceLifeTimelayoutData = new GridData();
        nonceLifeTimelayoutData.minimumWidth = 200;
        nonceLifeTimelayoutData.horizontalAlignment = SWT.FILL;
        nonceLifeTimelayoutData.grabExcessHorizontalSpace = true;
        rampartNonceLifeTimeText.setLayoutData(nonceLifeTimelayoutData);
        rampartConfigControlMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, rampartNonceLifeTimeText);

        rampartNonceLifeTimeText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, rampartNonceLifeTimeText
                        .getText());
                setDirty(true);
                updateDirtyState();
            }
        });
    }

    /**
     * Adds the policy
     *
     * @throws JAXBException
     * @throws IOException
     * @throws PropertyException
     * @throws CoreException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws TransformerException
     */
    private void updateControlMaps() throws JAXBException, IOException, PropertyException, CoreException,
            ParserConfigurationException, SAXException, TransformerException {

        // Define roles in UsernameToken based security policies.
        if (SecurityPolicyUtils.getInstance().getUserRoleRequiredSecurityScenarios().contains(selectedPolicy)) {
            String userRolesInLine = getUserRolesInLine();
            carbonSecAuthControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES, userRolesInLine);
        }

        if (SecurityPolicyUtils.getInstance().getSecurityTrustRequiredSecurityScenarios().contains(selectedPolicy)) {
            carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
                    encryptionPropertiesControlMap.get(SecurityFormConstants
                            .ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS));
            carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
                    encryptionPropertiesControlMap.get(SecurityFormConstants
                            .ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE));
            carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
                    encryptionPropertiesControlMap.get(SecurityFormConstants
                            .ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES));

        }
    }

    /**
     * Saves the data maps with user values
     */
    private void updateDataMaps() {

        Set<String> keySet = encryptionPropertiesControlMap.keySet();
        for (String key : keySet) {
            Object control = encryptionPropertiesControlMap.get(key);
            Text controlText = (Text) control;
            if (StringUtils.isEmpty(controlText.getText())) {
                encryptionPropertiesDataMap.put(key, null);
            }
            encryptionPropertiesDataMap.put(key, controlText.getText());
        }

        keySet = signaturePropertiesControlMap.keySet();
        for (String key : keySet) {
            Object control = signaturePropertiesControlMap.get(key);
            Text controlText = (Text) control;
            if (StringUtils.isEmpty(controlText.getText())) {
                signaturePropertiesDataMap.put(key, null);
            }
            signaturePropertiesDataMap.put(key, controlText.getText());
        }

        keySet = carbonSecAuthControlMap.keySet();
        for (String key : keySet) {
            String control = carbonSecAuthControlMap.get(key);
            carbonSecAuthDataMap.put(key, control);
        }

        keySet = carbonSecTrustControlMap.keySet();
        for (String key : keySet) {
            Object control = carbonSecTrustControlMap.get(key);
            Text controlText = (Text) control;
            carbonSecTrustDataMap.put(key, controlText.getText());
        }

        keySet = kerberosPropertiesControlMap.keySet();
        for (String key : keySet) {
            Object control = kerberosPropertiesControlMap.get(key);
            Text controlText = (Text) control;
            kerberosPropertiesDataMap.put(key, controlText.getText());
        }
    }

    /**
     * Updates the source with changes
     *
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    private void updateSourceConfiguration() throws ParserConfigurationException, SAXException, IOException {
        boolean isKerberosAuthenticationScenario = SecurityPolicies.POLICY_TYPE_16.equals(selectedPolicy);

        Node rampartConfigNode = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG)
                .item(0);
        Element rampartConfigElement = (Element) rampartConfigNode;

        Node securityConfigNode = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG)
                .item(0);
        Element securityConfigElement = (Element) securityConfigNode;

        if (!isKerberosAuthenticationScenario) {
            Node userNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants.RAMPART_USER).item(0);
            String userValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_USER);
            updateXMLNodeValue(userNode, userValue, policyFileDOMDocument, rampartConfigElement,
                    SecurityFormConstants.RAMPART_USER);

            Node encryptionUserNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_ENCRYPTION_USER).item(0);
            String encryptionUserValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER);
            updateXMLNodeValue(encryptionUserNode, encryptionUserValue, policyFileDOMDocument, rampartConfigElement,
                    SecurityFormConstants.RAMPART_ENCRYPTION_USER);
        }

        Node timestampPrecisionInMSNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
        String timestampPrecisionInMSValue = rampartConfigDataMap.get(SecurityFormConstants
                .RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
        updateXMLNodeValue(timestampPrecisionInMSNode, timestampPrecisionInMSValue, policyFileDOMDocument,
                rampartConfigElement,
                SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);

        Node timestampTTLNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_TTL)
                .item(0);
        String timestampTTLValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL);
        updateXMLNodeValue(timestampTTLNode, timestampTTLValue, policyFileDOMDocument, rampartConfigElement,
                SecurityFormConstants.RAMPART_TIMESTAMP_TTL);

        Node timestampMaxSkewNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_TIMESTAMP_MAX_SKEW).item(0);
        String timestampMaxSkewValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW);
        updateXMLNodeValue(timestampMaxSkewNode, timestampMaxSkewValue, policyFileDOMDocument, rampartConfigElement,
                SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW);

        Node timestampStrictNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_TIMESTAMP_STRICT).item(0);
        String timestampStrictValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT);
        updateXMLNodeValue(timestampStrictNode, timestampStrictValue, policyFileDOMDocument, rampartConfigElement,
                SecurityFormConstants.RAMPART_TIMESTAMP_STRICT);

        if (!isKerberosAuthenticationScenario) {
            Node tokenStoreClassNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_TOKEN_STORE_CLASS)
                    .item(0);
            String tokenStoreClassValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS);
            updateXMLNodeValue(tokenStoreClassNode, tokenStoreClassValue, policyFileDOMDocument, rampartConfigElement,
                    SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS);
        }

        Node nonceLifeTimeNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_NONCE_LIFE_TIME)
                .item(0);
        String nonceLifeTimeNodeValue = rampartConfigDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME);
        updateXMLNodeValue(nonceLifeTimeNode, nonceLifeTimeNodeValue, policyFileDOMDocument, rampartConfigElement,
                SecurityFormConstants.RAMPART_NONCE_LIFE_TIME);

        if (!isKerberosAuthenticationScenario) {
            Node encryptionCryptoNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_ENCRYPTION_CRYPTO).item(
                    0);
            if (encryptionCryptoNode != null) {
                setEncryptionCrypto(encryptionCryptoNode, encryptionPropertiesDataMap);
            }

            Node signatureCryptoNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_SIGNATURE_CRYPTO).item(0);
            if (signatureCryptoNode != null) {
                setSignatureCrypto(signatureCryptoNode, signaturePropertiesDataMap);
            }
        } else {
            Node kerberosConfigNode = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_KERBEROS_CONFIG).item(0);
            if (kerberosConfigNode != null) {
                setKerberosRampartConfig(kerberosConfigNode, kerberosPropertiesDataMap);
            }

            if (securityConfigElement != null) {
                Node kerberosSec = securityConfigElement.getElementsByTagName(SecurityFormConstants.CARBON_KEBEROS)
                        .item(0);
                if (kerberosSec != null) {
                    setKerberosSecConfig(kerberosSec, kerberosPropertiesDataMap);
                }
            }
        }

        if (SecurityPolicyUtils.getInstance().getUserRoleRequiredSecurityScenarios().contains(selectedPolicy)) {
            if (securityConfigElement != null) {
                Node securityAuth = securityConfigElement.getElementsByTagName(SecurityFormConstants
                        .CARBONSEC_AUTHORIZATION).item
                        (0);
                if (securityAuth != null) {
                    setSecAuthorization(securityAuth, carbonSecAuthDataMap);
                }
            } else {
                if (StringUtils.isNotEmpty(carbonSecAuthControlMap.get(SecurityFormConstants
                        .ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES))) {
                    Node wsPolicyNode = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.WS_POLICY)
                            .item(0);

                    securityConfigElement = policyFileDOMDocument.createElement(SecurityFormConstants.CARBONSEC_CONFIG);
                    securityConfigElement.setAttribute(SecurityFormConstants.XML_NS_SEC, SecurityFormConstants
                            .XML_NS_SEC_ATTRIBUTE);
                    wsPolicyNode.appendChild(securityConfigElement);

                    Node carbonAuthNode = policyFileDOMDocument.createElement(SecurityFormConstants
                            .CARBONSEC_AUTHORIZATION);
                    securityConfigElement.appendChild(carbonAuthNode);

                    Node secPropertyNode = policyFileDOMDocument.createElement(SecurityFormConstants
                            .CARBONSEC_PROPERTY);
                    ((Element) secPropertyNode).setAttribute(SecurityFormConstants.PROPERTY_NAME,
                            SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES);
                    carbonAuthNode.appendChild(secPropertyNode);
                    secPropertyNode.setTextContent(carbonSecAuthControlMap.get(SecurityFormConstants
                            .ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES));
                }
            }
        }

        if (SecurityPolicyUtils.getInstance().getSecurityTrustRequiredSecurityScenarios().contains(selectedPolicy)) {
            if (securityConfigElement != null) {
                Node securityTrustNode = securityConfigElement.getElementsByTagName(SecurityFormConstants
                        .CARBONSEC_TRUST)
                        .item(0);
                if (securityTrustNode != null) {
                    setSecTrust(securityTrustNode, carbonSecTrustDataMap);
                }
            }
        }
    }

    /**
     * This method is to update a XML node value
     */
    private void updateXMLNodeValue(Node node, String value, Document document, Element
            parentNode, String nodeName) {
        if (node != null && StringUtils.isNotEmpty(value)) {
            node.setTextContent(value);
        } else if (node == null && StringUtils.isNotEmpty(value)) {
            createXMLNode(document, parentNode, nodeName, value);
        } else if (node != null && StringUtils.isEmpty(value)) {
            node.getParentNode().removeChild(node);
        }
    }

    /**
     * This method is to create a new XML node
     */
    private void createXMLNode(Document document, Element element, String nodeName, String nodeValue) {
        Element newElement = document.createElement(nodeName);
        newElement.setTextContent(nodeValue);
        element.appendChild(newElement);
    }

    /**
     * Get allow roles in role1,role2, format.
     *
     * @return roles
     */
    private String getUserRolesInLine() {
        String allowRoles = "";

        for (int i = 0; i < userRoles.size(); i++) {
            if (i == userRoles.size() - 1) {
                allowRoles += userRoles.get(i);
            } else {
                allowRoles += userRoles.get(i) + ",";
            }
        }
        return allowRoles;
    }

    /**
     * Gets the document builder
     *
     * @return dBuilder document builder
     * @throws ParserConfigurationException
     */
    private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder;
    }

    /**
     * Gets the transformer
     *
     * @return transformer transformer
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException
     */
    private Transformer getTransformer() throws TransformerFactoryConfigurationError,
            TransformerConfigurationException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        return transformer;
    }

    /**
     * Closes the input stream
     *
     * @param stream
     */
    private void closeInputStream(InputStream stream) {
        try {
            stream.close();
        } catch (IOException e) {
            log.error("Error in closing the input stream", e);
        }
    }

    /**
     * Gets the unmarshaller
     *
     * @return unmarshaller unmarshaller
     * @throws JAXBException
     */
    private Unmarshaller getUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Policy2.class);
        Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
        return uUnmarshaller;
    }

    /**
     * Saves the final configurations to the file
     *
     * @throws TransformerException
     */
    private void saveFinalConfigToFile() throws TransformerException, IOException, IllegalAccessException,
            ClassNotFoundException, InstantiationException {
        FileUtils.writeStringToFile(physicalPolicyFile, getUpdatedContent());
    }

    /**
     * Gets the updated content of the source
     *
     * @return content
     * @throws TransformerException
     */
    public String getUpdatedContent() throws TransformerException, InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
        final LSSerializer writer = impl.createLSSerializer();

        // Set this to true if the output needs to be beautified.
        writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
        // Set this to true if the declaration is needed to be outputted.
        writer.getDomConfig().setParameter("xml-declaration", false);

        return writer.writeToString(policyFileDOMDocument);
    }

    /**
     * Updates the RampartUI and user roles from xml source
     *
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    private void updateRampartUIAndUserRoles() throws ParserConfigurationException,
            SAXException, IOException {
        // Update rampart config values from the source view
        updateRampartConfigDataMapFromDocument();

        if (!SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy) && !SecurityPolicies.POLICY_TYPE_16.equals
                (selectedPolicy)) {
            // Update rampart encryption and sign values from source view
            updateEncryptionAndSignaturePropertiesDataMapFromDocument();
        }

        if (SecurityPolicyUtils.getInstance().getUserRoleRequiredSecurityScenarios().contains(selectedPolicy)) {
            // Update rampart encryption and sign values from source view
            updateUserRolesFromDocument();
        }

        if (SecurityPolicies.POLICY_TYPE_16.equals(selectedPolicy)) {
            // Update Kerberos values from the source view
            updateKerberosPropertiesDataMapFromDocument();
        }

        // updates rampart config ui
        Text txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_USER);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_USER) != null && txtRampartProperties != null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_USER));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER) != null && txtRampartProperties
                != null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL) != null && txtRampartProperties !=
                null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW) != null
                && txtRampartProperties != null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS) != null && txtRampartProperties !=
                null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        txtRampartProperties = (Text) rampartConfigControlMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME) != null && txtRampartProperties
                != null) {
            txtRampartProperties.setText(rampartConfigDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME));
        } else if (txtRampartProperties != null) {
            txtRampartProperties.setText("");
        }

        Combo cmbRampartTimeStampProperty = (Combo) rampartConfigControlMap
                .get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS) != null
                && cmbRampartTimeStampProperty != null) {
            if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).equals(
                    SecurityFormConstants.VALUE_FALSE)) {
                cmbRampartTimeStampProperty.select(0); // Index 0
            } else {
                cmbRampartTimeStampProperty.select(1); // Index 1
            }
        }

        cmbRampartTimeStampProperty = (Combo) rampartConfigControlMap.get(SecurityFormConstants
                .RAMPART_TIMESTAMP_STRICT);
        if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT) != null
                && cmbRampartTimeStampProperty != null) {
            if (rampartConfigDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT).equals(
                    SecurityFormConstants.VALUE_FALSE)) {
                cmbRampartTimeStampProperty.select(0); // Index 0
            } else {
                cmbRampartTimeStampProperty.select(1);// Index 1
            }
        }

        if (!SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy) && !SecurityPolicies.POLICY_TYPE_16.equals
                (selectedPolicy)) {
            // update encryption properties ui
            updateCryptoUI(encryptionPropertiesDataMap, encryptionPropertiesControlMap);

            // update signature properties ui
            updateCryptoUI(signaturePropertiesDataMap, signaturePropertiesControlMap);
        }

        if (SecurityPolicies.POLICY_TYPE_16.equals(selectedPolicy)) {
            // update kerberos properties ui
            updateKerberosUI(kerberosPropertiesDataMap, kerberosPropertiesControlMap);
        }
    }

    /**
     * Updates crypto UI
     *
     * @param dataMap    data map
     * @param controlMap ui map
     */
    private void updateCryptoUI(Map<String, String> dataMap, Map<String, Text> controlMap) {
        if (controlMap.size() > 0) {
            if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE) != null) {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(
                        dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE));
            } else {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText("");

            }
            if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES) != null) {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(
                        dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES));
            } else {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText("");

            }
            if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS) != null) {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(
                        dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS));
            } else {
                controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText("");

            }
            if (dataMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID) != null) {
                controlMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID).setText(
                        dataMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID));
            } else {
                controlMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID).setText("");

            }
            if (dataMap.get(SecurityFormConstants.RAMPART_CONFIG_USER) != null) {
                controlMap.get(SecurityFormConstants.RAMPART_CONFIG_USER).setText(
                        dataMap.get(SecurityFormConstants.RAMPART_CONFIG_USER));
            } else {
                controlMap.get(SecurityFormConstants.RAMPART_CONFIG_USER).setText("");
            }
        }
    }

    /**
     * Updates Kerberos UI
     *
     * @param dataMap    data map
     * @param controlMap ui map
     */
    private void updateKerberosUI(Map<String, String> dataMap, Map<String, Text> controlMap) {

        Text textPrincipalName = controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME);
        if (textPrincipalName != null
                && StringUtils.isNotEmpty(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME))) {
            textPrincipalName.setText(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME));
        } else if (textPrincipalName != null) {
            textPrincipalName.setText("");
        }

        Text textPrincipalPassword = controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD);
        if (textPrincipalPassword != null
                && StringUtils.isNotEmpty(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD))) {
            textPrincipalPassword.setText(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD));
        } else if (textPrincipalPassword != null) {
            textPrincipalPassword.setText("");
        }

        if (!dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME).equals(rampartConfigDataMap.get
                (SecurityFormConstants.SERVICE_PRINCIPAL_NAME))) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_DIFFERENT_KERBEROS_PRINCIPAL_NAMES);
            msgBox.open();
        }
    }

    /**
     * Update security options buttons from xml source
     *
     * @throws JAXBException
     */
    private void updateSecurityOptionButton() throws JAXBException {

        Section encryptionPropertiesSection = (Section) encryptionPropertiesContainer[0];
        Section signaturePropertiesSection = (Section) signaturePropertiesContainer[0];
        Section kerberosPropertiesSection = (Section) kerberosPropertiesContainer[0];

        if (policyID.equals(SecurityFormConstants.POLICY_OBJECT_UT)) {
            encryptionPropertiesSection.setVisible(false);
            signaturePropertiesSection.setVisible(false);
            kerberosPropertiesSection.setVisible(false);
        } else if (policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT)) {
            encryptionPropertiesSection.setVisible(false);
            signaturePropertiesSection.setVisible(false);
            kerberosPropertiesSection.setVisible(true);
        } else {
            encryptionPropertiesSection.setVisible(true);
            signaturePropertiesSection.setVisible(true);
            kerberosPropertiesSection.setVisible(false);
        }

        deSelectAllSecurityOptionButtons();
        Button button = policyButtonMap.get(policyID);
        if (button != null) {
            button.setSelection(true);
            enableUserRoleButton(button);
            policyFileName = (String) button.getData();
            selectedPolicy = button.getToolTipText();
        }
    }

    /**
     * Deselect all security option buttons and hide all user roles button
     */
    private void deSelectAllSecurityOptionButtons() {
        for (Button securityOptionButton : policyButtonMap.values()) {
            //Deselect security option buttons
            securityOptionButton.setSelection(false);
        }
        //Hide User Roles button
        policyOneUserRolesButton.setVisible(false);
        policySevenUserRolesButton.setVisible(false);
        policyEightUserRolesButton.setVisible(false);
        policyFourteenUserRolesButton.setVisible(false);
        policyFifteenUserRolesButton.setVisible(false);
    }

    /**
     * Creates RampartProperties
     *
     * @param enComposite composite
     * @param fullname    name
     * @param prefix      prefix
     */
    private void createRampartPropertiesUIs(FormToolkit toolkit, Composite enComposite, String fullname, final String
            prefix) {
        final String[] split = fullname.split(":");
        String name = split[1];
        final Text en;
        if (name.equals(SecurityFormConstants.PRIVATESTORE_LABEL)
                || name.equals(SecurityFormConstants.TRUSTSTORE_LABEL)) {
            toolkit.createLabel(enComposite, name + ":");
            Label nameMark = toolkit.createLabel(enComposite, "*");
            Device device = Display.getCurrent();
            Color red = new Color(device, 255, 0, 0);
            nameMark.setForeground(red);
            en = toolkit.createText(enComposite, " ");
        } else {
            toolkit.createLabel(enComposite, name + ":");
            toolkit.createLabel(enComposite, "");
            en = toolkit.createText(enComposite, " ");
        }

        GridData enlayoutData = new GridData();
        enlayoutData.minimumWidth = 200;
        enlayoutData.horizontalAlignment = SWT.FILL;
        enlayoutData.grabExcessHorizontalSpace = true;
        en.setLayoutData(enlayoutData);
        en.setData(name, split[0]);

        if (SecurityFormConstants.EN.equals(prefix)) {
            encryptionPropertiesControlMap.put(split[0], en);
            //Setting the default value
            en.setText(encryptionPropertiesDataMap.get(split[0]));
        } else {
            signaturePropertiesControlMap.put(split[0], en);
            //Setting the default value
            en.setText(signaturePropertiesDataMap.get(split[0]));
        }

        en.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent arg0) {
                if (SecurityFormConstants.EN.equals(prefix)) {
                    encryptionPropertiesDataMap.put(split[0], en.getText());
                } else {
                    signaturePropertiesDataMap.put(split[0], en.getText());
                }
                setDirty(true);
                updateDirtyState();
            }
        });

    }

    /**
     * Convert XML to string
     *
     * @param resourceFile file
     * @return XML string
     */
    private String convertXMLFileToString(File resourceFile) {
        StringWriter stw = new StringWriter();
        try {
            DocumentBuilder dBuilder = getDocumentBuilder();
            InputStream inputStream = new FileInputStream(resourceFile);
            org.w3c.dom.Document doc = dBuilder.parse(inputStream);
            Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty("omit-xml-declaration", "yes");
            serializer.transform(new DOMSource(doc), new StreamResult(stw));
        } catch (TransformerException | SAXException | IOException | ParserConfigurationException
                | TransformerFactoryConfigurationError e) {
            log.error(SecurityFormMessageConstants.MESSAGE_XML_ERROR, e);
        }
        return stw.toString();
    }

    /**
     * Refreshes the project
     *
     * @throws CoreException
     */
    public void refreshProject() throws CoreException {
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

    /**
     * Updates the rampart configuration data map
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private void updateRampartConfigDataMapFromDocument() throws ParserConfigurationException,
            SAXException, IOException {

        boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

        Node nrampart = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
        Element rampartConfigElement = (Element) nrampart;

        if (!isKerberossignandencrypt) {
            Node user = rampartConfigElement.getElementsByTagName(SecurityFormConstants.RAMPART_USER).item(0);
            if (user != null) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_USER, user.getTextContent());
            } else {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_USER, "");
            }

            Node encryptionUser = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_ENCRYPTION_USER).item(0);
            if (encryptionUser != null) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, encryptionUser.getTextContent
                        ());
            } else {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, "");
            }

        } else {
            // rampart:kerberosConfig
            Node kerberosConfig = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_KERBEROS_CONFIG).item(0);
            if (kerberosConfig != null) {
                addRampartKerberosConfigPropertis(kerberosConfig);
            }
        }

        Node timestampPrecisionInMilliseconds = rampartConfigElement.getElementsByTagName(
                SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
        if (timestampPrecisionInMilliseconds != null) {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
                    timestampPrecisionInMilliseconds.getTextContent());
        } else {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS, "");
        }

        Node timestampTTL = rampartConfigElement.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_TTL)
                .item(0);
        if (timestampTTL != null) {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, timestampTTL.getTextContent());
        } else {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, "");
        }

        Node timestampMaxSkew = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_TIMESTAMP_MAX_SKEW).item(0);
        if (timestampMaxSkew != null) {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew
                    .getTextContent());
        } else {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, "");
        }

        Node timestampStrict = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_TIMESTAMP_STRICT).item(0);
        if (timestampStrict != null) {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, timestampStrict.getTextContent());
        } else {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, "");
        }

        if (!isKerberossignandencrypt) {
            Node tokenStoreClass = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_TOKEN_STORE_CLASS)
                    .item(0);
            if (tokenStoreClass != null) {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, tokenStoreClass
                        .getTextContent());
            } else {
                rampartConfigDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, "");
            }
        }

        Node nonceLifeTime = rampartConfigElement.getElementsByTagName(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME)
                .item(0);
        if (nonceLifeTime != null) {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, nonceLifeTime.getTextContent());
        } else {
            rampartConfigDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, "");
        }
    }

    /**
     * Updates the encryption and signature properties data map
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private void updateEncryptionAndSignaturePropertiesDataMapFromDocument()
            throws ParserConfigurationException, SAXException, IOException {
        Node nrampart = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
        Element rampartConfigElement = (Element) nrampart;

        Node encryptionCrypto = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_ENCRYPTION_CRYPTO).item(
                0);
        if (encryptionCrypto != null) {
            encryptionPropertiesDataMap = getRampartCryptoProperties(encryptionCrypto);
        }

        // rampart:signatureCrypto
        Node signatureCrypto = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                .RAMPART_SIGNATURE_CRYPTO).item(0);
        if (signatureCrypto != null) {
            signaturePropertiesDataMap = getRampartSignatureProperties(signatureCrypto);
        }
    }

    /**
     * Updates the user roles from xml document
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private void updateUserRolesFromDocument()
            throws ParserConfigurationException, SAXException, IOException {

        Node carbonSecConfigNode = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG)
                .item(0);
        Element securityConfigElement = (Element) carbonSecConfigNode;

        if (securityConfigElement != null) {
            Node secAuth = securityConfigElement.getElementsByTagName(SecurityFormConstants
                    .CARBONSEC_AUTHORIZATION).item(0);
            if (secAuth != null) {
                carbonSecAuthDataMap = getCarbonAuthProperties(secAuth);
            }
        }
    }

    /**
     * Updates the kerberos data map
     *
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private void updateKerberosPropertiesDataMapFromDocument() throws ParserConfigurationException,
            SAXException, IOException {

        boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

        Node nrampart = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
        Element rampartConfigElement = (Element) nrampart;

        Node nsec = policyFileDOMDocument.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG).item(0);
        Element securityConfigElement = (Element) nsec;

        if (isKerberossignandencrypt) {
            Node rampartKerberos = rampartConfigElement.getElementsByTagName(SecurityFormConstants
                    .RAMPART_KERBEROS_CONFIG).item(0);
            if (rampartKerberos != null) {
                kerberosPropertiesDataMap = addKerberosProperties(rampartKerberos);
            }

            if (securityConfigElement != null) {
                Node secKerberos = securityConfigElement.getElementsByTagName(SecurityFormConstants.CARBON_KEBEROS)
                        .item(0);
                if (secKerberos != null) {
                    kerberosPropertiesDataMap = addKerberosProperties(secKerberos);
                }
            }

        }

    }

    /**
     * Get rampart:encryptionCrypto properties
     *
     * @param crypto crypto node
     */
    private Map<String, String> getRampartCryptoProperties(Node crypto) {

        Map<String, String> cryptoMap = new HashMap<>();
        Node encrypto = ((Element) crypto).getElementsByTagName(SecurityFormConstants.RAMPART_CRYPTO).item(0);

        NodeList list = encrypto.getChildNodes();
        boolean isPrivatestoreEmpty = false;
        boolean isTruststoreEmpty = false;
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                cryptoMap.put(attribute, eElement.getTextContent());
                if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE)
                        && StringUtils.isEmpty(eElement.getTextContent())) {
                    isPrivatestoreEmpty = true;
                } else if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES)
                        && StringUtils.isEmpty(eElement.getTextContent())) {
                    isTruststoreEmpty = true;
                }
            }
        }

        if (isPrivatestoreEmpty && isTruststoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_EN_PROPERTIES);
            msgBox.open();
        } else if (isPrivatestoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_PRIVATESTORE_EN);
            msgBox.open();
        } else if (isTruststoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_TRUSTSTORE_EN);
            msgBox.open();
        }
        return cryptoMap;
    }

    /**
     * Get rampart:signatureCrypto properties.
     *
     * @param crypto crypto node
     */
    private Map<String, String> getRampartSignatureProperties(Node crypto) {

        Map<String, String> cryptoMap = new HashMap<>();
        Node encrypto = ((Element) crypto).getElementsByTagName(SecurityFormConstants.RAMPART_CRYPTO).item(0);

        NodeList list = encrypto.getChildNodes();
        boolean isPrivatestoreEmpty = false;
        boolean isTruststoreEmpty = false;
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                cryptoMap.put(attribute, eElement.getTextContent());

                if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE))) {
                    isPrivatestoreEmpty = true;
                } else if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES))) {
                    isTruststoreEmpty = true;
                }
            }
        }
        if (isPrivatestoreEmpty && isTruststoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_SIGN_PROPERTIES);
            msgBox.open();
        } else if (isPrivatestoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_PRIVATESTORE_SIGN);
            msgBox.open();
        } else if (isTruststoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_TRUSTSTORE_SIGN);
            msgBox.open();
        }
        return cryptoMap;
    }

    /**
     * Add rampart:kerberosConfig or rampart:signatureCrypto properties.
     */
    private Map<String, String> addKerberosProperties(Node kerberos) {

        Map<String, String> kerberosMap = new HashMap<>();
        NodeList list = kerberos.getChildNodes();
        boolean isPasswordEmpty = false;
        boolean isPrincipalNameEmpty = false;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                kerberosMap.put(attribute, eElement.getTextContent());
                if (kerberosPropertiesControlMap.get(attribute) != null) {
                    kerberosPropertiesControlMap.get(attribute).setText(eElement.getTextContent());
                }
                if (StringUtils.isEmpty(eElement.getTextContent())) {
                    if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_NAME)) {
                        isPrincipalNameEmpty = true;
                    } else if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD)) {
                        isPasswordEmpty = true;
                    }
                }
            }
        }

        if (isPasswordEmpty && isPrincipalNameEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PROPERTIES);
            msgBox.open();
        } else if (isPrincipalNameEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_NAME);
            msgBox.open();
        } else if (isPasswordEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PASSWORD);
            msgBox.open();
        }
        return kerberosMap;
    }

    /**
     * Get sec:Authorization properties.
     *
     * @param secAuth secAuth node
     */
    private Map<String, String> getCarbonAuthProperties(Node secAuth) {

        Map<String, String> secAuthMap = new HashMap<>();

        NodeList list = secAuth.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                /*
                 * Update the relevant maps and role vale when changing the
				 * userRole value from the source view
				 */
                secAuthMap.put(attribute, eElement.getTextContent());
                carbonSecAuthControlMap.put(attribute, eElement.getTextContent());
                if (userRoles == null) {
                    userRoles = new ArrayList<>();
                } else {
                    userRoles.clear();
                    String inlineUserRoles = eElement.getTextContent();
                    if (StringUtils.isNotBlank(inlineUserRoles)) {
                        String[] roles = inlineUserRoles.split(",");
                        for (int j = 0; j < roles.length; j++) {
                            if (StringUtils.isNotBlank(roles[j])) {
                                userRoles.add(roles[j].trim());
                            }
                        }
                    }
                }

				/*
                 * Update the relevant maps and role vale when removing the
				 * userRole value from the source view
				 */
                if (StringUtils.isEmpty(eElement.getTextContent())) {
                    userRoles.clear();
                    carbonSecAuthControlMap.put(attribute, null);
                    carbonSecAuthDataMap.put(attribute, null);
                }
            }
        }
        return secAuthMap;
    }

    /**
     * Add rampart:kerberosConfig properties.
     *
     * @param kerberosConfig kerberos node
     */
    private void addRampartKerberosConfigPropertis(Node kerberosConfig) {
        NodeList list = kerberosConfig.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                rampartConfigDataMap.put(attribute, eElement.getTextContent());
            }
        }
    }

    /**
     * Sets the encryption
     *
     * @param encryptionCrypto node encrypto
     * @param cryptoMap        map
     */
    private void setEncryptionCrypto(Node encryptionCrypto, Map<String, String> cryptoMap) {
        Node rampartCryptoProperties = ((Element) encryptionCrypto).getElementsByTagName(SecurityFormConstants
                .RAMPART_CRYPTO).item(0);
        NodeList list = rampartCryptoProperties.getChildNodes();
        boolean isPrivateStoreEmpty = false;
        boolean isTrustStoreEmpty = false;
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    node.setTextContent(cryptoMap.get(attribute));
                }

                if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE))) {
                    isPrivateStoreEmpty = true;
                } else if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES))) {
                    isTrustStoreEmpty = true;
                }
            }
        }
        //Showing warnings if private store or trust store is empty
        if (isPrivateStoreEmpty && isTrustStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_EN_PROPERTIES);
            msgBox.open();
        } else if (isPrivateStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_PRIVATESTORE_EN);
            msgBox.open();
        } else if (isTrustStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_TRUSTSTORE_EN);
            msgBox.open();
        }
    }

    /**
     * Sets the encryption sign value
     *
     * @param encryptionCrypto node encrypto
     * @param cryptoMap        map
     */
    private void setSignatureCrypto(Node encryptionCrypto, Map<String, String> cryptoMap) {
        Node rampartCryptoProperties = ((Element) encryptionCrypto).getElementsByTagName(SecurityFormConstants
                .RAMPART_CRYPTO).item(0);
        NodeList list = rampartCryptoProperties.getChildNodes();
        boolean isPrivateStoreEmpty = false;
        boolean isTrustStoreEmpty = false;
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node != null && SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    node.setTextContent(cryptoMap.get(attribute));
                }

                if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE))) {
                    isPrivateStoreEmpty = true;
                }
                if (attribute.equals(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES)
                        && StringUtils.isEmpty(cryptoMap
                        .get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES))) {
                    isTrustStoreEmpty = true;
                }
            }
        }
        //Showing warnings if private store or trust store is empty
        if (isPrivateStoreEmpty && isTrustStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_SIGN_PROPERTIES);
            msgBox.open();
        } else if (isPrivateStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_PRIVATESTORE_SIGN);
            msgBox.open();
        } else if (isTrustStoreEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_TRUSTSTORE_SIGN);
            msgBox.open();
        }

    }

    /**
     * Sets the security authorization
     *
     * @param carbonSecurity node carbonSecurity
     * @param carbonAuthMap  map
     */
    private void setSecAuthorization(Node carbonSecurity, Map<String, String> carbonAuthMap) {
        NodeList list = carbonSecurity.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    if (StringUtils.isNotEmpty(carbonAuthMap.get(attribute))) {
                        node.setTextContent(carbonAuthMap.get(attribute));
                    } else {
                        // Remove the sec: tag when User Role value is empty
                        if (SecurityPolicies.POLICY_TYPE_14.equals(selectedPolicy)
                                || SecurityPolicies.POLICY_TYPE_15.equals(selectedPolicy)) {
                            node.getParentNode().getParentNode().removeChild(carbonSecurity);
                        } else {
                            node.getParentNode().getParentNode().getParentNode()
                                    .removeChild(carbonSecurity.getParentNode());
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the security trust
     *
     * @param carbonTrust    node carbonTrust
     * @param carbonTrustMap map
     */
    private void setSecTrust(Node carbonTrust, Map<String, String> carbonTrustMap) {
        NodeList list = carbonTrust.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    node.setTextContent(carbonTrustMap.get(attribute));
                }
            }
        }
    }

    /**
     * Sets the security trust
     */
    private void setKerberosSecConfig(Node carbonKerberos, Map<String, String> carbonKerberosMap) {
        NodeList list = carbonKerberos.getChildNodes();
        boolean isPasswordEmpty = false;
        boolean isPrincipalNameEmpty = false;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    if (StringUtils.isNotEmpty(carbonKerberosMap.get(attribute))) {
                        node.setTextContent(carbonKerberosMap.get(attribute));
                    } else {
                        if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_NAME)) {
                            isPrincipalNameEmpty = true;
                        }
                        if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD)) {
                            isPasswordEmpty = true;
                        }
                    }
                }
            }
        }
        //Showing warnings if principal name or password is empty
        if (isPasswordEmpty && isPrincipalNameEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PROPERTIES);
            msgBox.open();
        } else if (isPrincipalNameEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_NAME);
            msgBox.open();
        } else if (isPasswordEmpty) {
            MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
            msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PASSWORD);
            msgBox.open();
        }
    }

    /**
     * Sets the kerberos configs
     *
     * @param kerberosConfig kerbeos config
     */
    private void setKerberosRampartConfig(Node kerberosConfig, Map<String, String> carbonSecKerberosDataMap) {

        NodeList list = kerberosConfig.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
                Element eElement = (Element) node;
                String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
                if (StringUtils.isNotBlank(attribute)) {
                    node.setTextContent(carbonSecKerberosDataMap.get(attribute));
                }
            }
        }
    }

    /**
     * Create button for balloon to show the description of a specific security scenario
     *
     * @param secComposite
     * @param scenarioNumber
     */
    private void insertPolicyViewButton(Composite secComposite, final int scenarioNumber) {

        Image buttonImage = ResourceManager.getPluginImage(PLUGIN_NAME,
                SecurityFormConstants.SECURITY_SCENARIO_BUTTON_IMAGE_PATH);
        Button securityScenarioDisplayButton = new Button(secComposite, SWT.NONE);
        securityScenarioDisplayButton.setImage(buttonImage);
        securityScenarioDisplayButton.setVisible(true);
        securityScenarioDisplayButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                showPolicyUseCase(scenarioNumber);
                updateDirtyState();
            }
        });
        GridData securitySenarioDisplayButtonGridData = new GridData();
        securitySenarioDisplayButtonGridData.horizontalAlignment = GridData.BEGINNING;
        securitySenarioDisplayButtonGridData.grabExcessHorizontalSpace = false;
        securitySenarioDisplayButtonGridData.horizontalSpan = 1;
        securityScenarioDisplayButton.setLayoutData(securitySenarioDisplayButtonGridData);
    }

    /**
     * Creates the security scenario option buttons
     *
     * @param secComposite                   composite
     * @param names                          names
     * @param managedForm                    form
     * @param securityScenarioStartingNumber int value
     */
    private void createSecurityScenarioOptionButtons(final Composite secComposite, String[] names,
                                                     IManagedForm managedForm, int securityScenarioStartingNumber)
            throws IOException,
            JAXBException {
        int securityScenarioNumber = securityScenarioStartingNumber;
        securityScenarioBalloonBackgroundImage = getBackgroundImage();
        parentShell = new Shell(Display.getCurrent(), SWT.TITLE | SWT.CLOSE | SWT.BORDER);

        for (String securityScenarioName : names) {
            securityScenarioNumber++;
            insertPolicyViewButton(secComposite, securityScenarioNumber);
            final Button secBtn = new Button(secComposite, SWT.RADIO);
            secBtn.setText("");
            secBtn.setToolTipText(securityScenarioName);

            String fileName = SecurityFormConstants.FILE_PREFIX + securityScenarioNumber + SecurityFormConstants
                    .FILE_POSTFIX;
            secBtn.setData(fileName);
            secBtn.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateSecurityScenarioSelection(secBtn);
                }
            });

            String filePath = SecurityFormConstants.POLICIES + fileName;
            SecurityTemplateUtil qoSTemplateUtil = new SecurityTemplateUtil();
            File resourceFile = qoSTemplateUtil.getResourceFile(filePath);
            if (resourceFile != null) {
                Unmarshaller pUnmarshaller = getUnmarshaller();
                Policy2 policy2 = (Policy2) pUnmarshaller.unmarshal(resourceFile);
                policyButtonMap.put(policy2.getId(), secBtn);
            }

            final ToolTip tip = new ToolTip(secComposite.getShell(), SWT.BALLOON | SWT.ICON_INFORMATION);
            tip.setMessage(TIP_MESSAGE);

            Hyperlink securityScenarioHyperlink = managedForm.getToolkit().createHyperlink(secComposite,
                    securityScenarioName,
                    SWT.RADIO);

            securityScenarioHyperlink.addHyperlinkListener(new HyperlinkAdapter() {
                @Override
                public void linkActivated(HyperlinkEvent e) {
                    Control[] children = secComposite.getChildren();
                    for (Control child : children) {
                        if (child instanceof Button) {
                            ((Button) child).setSelection(false);
                        }
                    }
                    secBtn.setSelection(true);
                    updateSecurityScenarioSelection(secBtn);
                }
            });

            if (SecurityPolicies.POLICY_TYPE_1.equals(securityScenarioName)) {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.grabExcessHorizontalSpace = true;
                policyLinkGrdiData.horizontalSpan = 3;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);

                policyOneUserRolesButton = new Button(secComposite, SWT.NONE);
                policyOneUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
                policyOneUserRolesButton.setVisible(false);
                policyOneUserRolesButton.addListener(SWT.Selection, new Listener() {
                    @Override
                    public void handleEvent(Event event) {
                        openUserRolesDialog();
                        setDirty(true);
                        updateDirtyState();
                    }
                });

                GridData userRolesButtonGridData = new GridData();
                userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
                userRolesButtonGridData.grabExcessHorizontalSpace = false;
                policyOneUserRolesButton.setLayoutData(userRolesButtonGridData);
            } else if (SecurityPolicies.POLICY_TYPE_7.equals(securityScenarioName)) {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.grabExcessHorizontalSpace = true;
                policyLinkGrdiData.horizontalSpan = 3;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);

                policySevenUserRolesButton = new Button(secComposite, SWT.NONE);
                policySevenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
                policySevenUserRolesButton.setVisible(false);
                policySevenUserRolesButton.addListener(SWT.Selection, new Listener() {
                    @Override
                    public void handleEvent(Event event) {
                        openUserRolesDialog();
                        setDirty(true);
                        updateDirtyState();
                    }
                });

                GridData userRolesButtonGridData = new GridData();
                userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
                userRolesButtonGridData.grabExcessHorizontalSpace = false;
                policySevenUserRolesButton.setLayoutData(userRolesButtonGridData);
            } else if (SecurityPolicies.POLICY_TYPE_8.equals(securityScenarioName)) {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.grabExcessHorizontalSpace = true;
                policyLinkGrdiData.horizontalSpan = 3;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);

                policyEightUserRolesButton = new Button(secComposite, SWT.NONE);
                policyEightUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
                policyEightUserRolesButton.setVisible(false);
                policyEightUserRolesButton.addListener(SWT.Selection, new Listener() {
                    @Override
                    public void handleEvent(Event event) {
                        openUserRolesDialog();
                        setDirty(true);
                        updateDirtyState();
                    }
                });

                GridData userRolesButtonGridData = new GridData();
                userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
                userRolesButtonGridData.grabExcessHorizontalSpace = false;
                policyEightUserRolesButton.setLayoutData(userRolesButtonGridData);
            } else if (SecurityPolicies.POLICY_TYPE_14.equals(securityScenarioName)) {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.grabExcessHorizontalSpace = true;
                policyLinkGrdiData.horizontalSpan = 3;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);

                policyFourteenUserRolesButton = new Button(secComposite, SWT.NONE);
                policyFourteenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
                policyFourteenUserRolesButton.setVisible(false);
                policyFourteenUserRolesButton.addListener(SWT.Selection, new Listener() {
                    @Override
                    public void handleEvent(Event event) {
                        openUserRolesDialog();
                        setDirty(true);
                        updateDirtyState();
                    }
                });

                GridData userRolesButtonGridData = new GridData();
                userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
                userRolesButtonGridData.grabExcessHorizontalSpace = false;
                policyFourteenUserRolesButton.setLayoutData(userRolesButtonGridData);
            } else if (SecurityPolicies.POLICY_TYPE_15.equals(securityScenarioName)) {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.grabExcessHorizontalSpace = true;
                policyLinkGrdiData.horizontalSpan = 3;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);

                policyFifteenUserRolesButton = new Button(secComposite, SWT.NONE);
                policyFifteenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
                policyFifteenUserRolesButton.setVisible(false);
                policyFifteenUserRolesButton.addListener(SWT.Selection, new Listener() {
                    @Override
                    public void handleEvent(Event event) {
                        openUserRolesDialog();
                        setDirty(true);
                        updateDirtyState();
                    }
                });

                GridData userRolesButtonGridData = new GridData();
                userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
                userRolesButtonGridData.grabExcessHorizontalSpace = false;
                policyFifteenUserRolesButton.setLayoutData(userRolesButtonGridData);
            } else {
                GridData policyLinkGrdiData = new GridData();
                policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
                policyLinkGrdiData.horizontalSpan = 4;
                securityScenarioHyperlink.setLayoutData(policyLinkGrdiData);
            }
        }
    }

    /**
     * Update the view when a security scenario option is selected
     *
     * @param secBtn
     */
    protected void updateSecurityScenarioSelection(final Button secBtn) {
        policyFileName = (String) secBtn.getData();
        SecurityTemplateUtil secTemplateUtil = new SecurityTemplateUtil();
        String filename = SecurityFormConstants.POLICIES + policyFileName;
        try {
            policyTemplateFile = secTemplateUtil.getResourceFile(filename);
        } catch (IOException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_SAVE, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
            msg.open();
        }
        String content = convertXMLFileToString(this.policyTemplateFile);

        InputStream policyFileStream = new ByteArrayInputStream(content.getBytes());
        closeInputStream(policyFileStream);

        try {
            Unmarshaller pUnmarshaller = getUnmarshaller();
            policyObject = (Policy2) pUnmarshaller.unmarshal(policyFileStream);
            policyID = policyObject.getId();
            DocumentBuilder dBuilder = getDocumentBuilder();
            policyFileDOMDocument = dBuilder.parse(policyTemplateFile);
        } catch (SAXException | IOException | ParserConfigurationException | JAXBException e) {
            log.error(SecurityFormMessageConstants.MESSAGE_SAVE, e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
            msg.open();
        }

        if (!secBtn.getToolTipText().equals(selectedPolicy)) {
            selectedPolicy = secBtn.getToolTipText();
            setDirty(true);
            updateDirtyState();
        }
        if (encryptionPropertiesContainer != null || signaturePropertiesContainer != null) {
            Section encrypt = (Section) encryptionPropertiesContainer[0];
            Section signResult = (Section) this.signaturePropertiesContainer[0];
            Section kebSection = (Section) kerberosPropertiesContainer[0];

            if (selectedPolicy.equals(SecurityFormConstants.POLICY_UT)) {
                encrypt.setVisible(false);
                signResult.setVisible(false);
                kebSection.setVisible(false);
            } else if (selectedPolicy.equals(SecurityFormConstants.POLICY_KERBEROS)) {
                encrypt.setVisible(false);
                signResult.setVisible(false);
                kebSection.setVisible(true);
            } else {
                encrypt.setVisible(true);
                signResult.setVisible(true);
                kebSection.setVisible(false);
            }
        }

        enableUserRoleButton(secBtn);
    }

    /**
     * Enables the user role button
     *
     * @param secBtn
     */
    private void enableUserRoleButton(Button secBtn) {
        if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_1)) {
            policyOneUserRolesButton.setVisible(true);
            policySevenUserRolesButton.setVisible(false);
            policyEightUserRolesButton.setVisible(false);
            policyFourteenUserRolesButton.setVisible(false);
            policyFifteenUserRolesButton.setVisible(false);

        } else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_7)) {
            policyOneUserRolesButton.setVisible(false);
            policySevenUserRolesButton.setVisible(true);
            policyEightUserRolesButton.setVisible(false);
            policyFourteenUserRolesButton.setVisible(false);
            policyFifteenUserRolesButton.setVisible(false);

        } else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_8)) {
            policyOneUserRolesButton.setVisible(false);
            policySevenUserRolesButton.setVisible(false);
            policyEightUserRolesButton.setVisible(true);
            policyFourteenUserRolesButton.setVisible(false);
            policyFifteenUserRolesButton.setVisible(false);

        } else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_14)) {
            policyOneUserRolesButton.setVisible(false);
            policySevenUserRolesButton.setVisible(false);
            policyEightUserRolesButton.setVisible(false);
            policyFourteenUserRolesButton.setVisible(true);
            policyFifteenUserRolesButton.setVisible(false);

        } else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_15)) {
            policyOneUserRolesButton.setVisible(false);
            policySevenUserRolesButton.setVisible(false);
            policyEightUserRolesButton.setVisible(false);
            policyFourteenUserRolesButton.setVisible(false);
            policyFifteenUserRolesButton.setVisible(true);

        } else {
            policyOneUserRolesButton.setVisible(false);
            policySevenUserRolesButton.setVisible(false);
            policyEightUserRolesButton.setVisible(false);
            policyFourteenUserRolesButton.setVisible(false);
            policyFifteenUserRolesButton.setVisible(false);

        }
    }

    /**
     * Open User Roles dialog for UT policy.
     */
    private void openUserRolesDialog() {
        UserRolesDialog dialog = new UserRolesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                userRoles);
        dialog.open();
    }

    /**
     * Create sections
     *
     * @param toolkit     form
     * @param body        body
     * @param sectionName name of the section
     * @param x           int
     * @param y           int
     * @param width       width
     * @param height      height
     * @param expand      boolean
     * @return object
     */
    private Object[] createMainSection(FormToolkit toolkit, final Composite body, String sectionName, final int x,
                                       final int y, final int width, final int height, boolean expand) {

        Object[] comp = new Object[2];
        final Section sctnCreate = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
        sctnCreate.setBounds(x, y, width, height);
        toolkit.paintBordersFor(sctnCreate);
        sctnCreate.setText(sectionName);
        sctnCreate.setExpanded(expand);

        sctnCreate.addExpansionListener(new IExpansionListener() {

            @Override
            public void expansionStateChanging(ExpansionEvent e) {
            }

            @Override
            public void expansionStateChanged(ExpansionEvent e) {

            }
        });
        comp[0] = sctnCreate;
        Composite composite = toolkit.createComposite(sctnCreate, SWT.NULL);
        toolkit.paintBordersFor(composite);
        sctnCreate.setClient(composite);
        composite.setLayout(new GridLayout(1, false));
        comp[1] = composite;

        return comp;
    }

    /**
     * Create contents of category
     *
     * @param toolkit   form
     * @param composite composite
     * @param category  category
     */
    private void createCategory(FormToolkit toolkit, Composite composite, String category) {

        Label lblcategory = toolkit.createLabel(composite, category, SWT.NONE);
        lblcategory.setFont(SWTResourceManager.getFont(SecurityFormConstants.SANS, 10, SWT.BOLD));
        GridData gdCategory = new GridData(SWT.FILL, SWT.CENTER, true, false, NUM_OF_COLUMNS_GRID_LAYOUT_MAIN_PAGE, 1);
        gdCategory.verticalIndent = 10;
        lblcategory.setLayoutData(gdCategory);

    }

    /**
     * This method checks whether there is an already opened shell with title @param securityScenarioTitle and returns
     * shell if it exists or null if it doesn't exist.
     *
     * @param securityScenarioTitle
     * @return
     */
    private Shell getExistingUseCaseShell(String securityScenarioTitle) {
        for (Shell shell : parentShell.getShells()) {
            if (shell.getText().equalsIgnoreCase(securityScenarioTitle)) {
                return shell;
            }
        }
        return null;
    }

    /**
     * <p>
     * This method takes two Rectangle objects of current monitor and generating shell. Then calculate and returns
     * the X
     * coordinate value of the generated shell rectangle.
     *
     * @param monitorBound
     * @param shellBound
     * @return
     */
    private int getXCoordinate(Rectangle monitorBound, Rectangle shellBound) {
        return monitorBound.x + (monitorBound.width - shellBound.width / 2) / 2;
    }

    /**
     * <p>
     * This method takes two Rectangle objects of current monitor and generating shell. Then calculate and returns the Y
     * coordinate value of the generated shell rectangle.
     *
     * @param monitorBound
     * @param shellBound
     * @return
     */
    private int getYCoordinate(Rectangle monitorBound, Rectangle shellBound) {
        return monitorBound.x + (monitorBound.width - shellBound.width) / 4;
    }

    /**
     * This method returns the shell background image.
     *
     * @return Background image
     */
    private Image getBackgroundImage() {
        return ResourceManager.getPluginImage(SecurityFormConstants.PLUGIN_NAME,
                SecurityFormConstants.BACKGROUD_IMAGE_RELAVIVE_PATH);
    }

    /**
     * This method returns an image in "org.wso2.developerstudio.eclipse.artifact.security" plug-in, specified by the
     * relative path parameter.
     *
     * @param relativeFilePath
     * @return Security scenario image
     */
    private Image getScenarioImage(String relativeFilePath) {
        return ResourceManager.getPluginImage(SecurityFormConstants.PLUGIN_NAME, relativeFilePath);
    }

    /**
     * This method simply take security scenario number as an input.
     * <p>
     * Returns title of the shell window which describes the security scenario.
     *
     * @param fileNumber
     * @return Security scenario title
     */
    private String getSecurityScenarioTitle(int fileNumber) {
        switch (fileNumber) {
            case 1:
                return SecurityPolicies.POLICY_TYPE_1;
            case 2:
                return SecurityPolicies.POLICY_TYPE_2;
            case 3:
                return SecurityPolicies.POLICY_TYPE_3;
            case 4:
                return SecurityPolicies.POLICY_TYPE_4;
            case 5:
                return SecurityPolicies.POLICY_TYPE_5;
            case 6:
                return SecurityPolicies.POLICY_TYPE_6;
            case 7:
                return SecurityPolicies.POLICY_TYPE_7;
            case 8:
                return SecurityPolicies.POLICY_TYPE_8;
            case 9:
                return SecurityPolicies.POLICY_TYPE_9;
            case 10:
                return SecurityPolicies.POLICY_TYPE_10;
            case 11:
                return SecurityPolicies.POLICY_TYPE_11;
            case 12:
                return SecurityPolicies.POLICY_TYPE_12;
            case 13:
                return SecurityPolicies.POLICY_TYPE_13;
            case 14:
                return SecurityPolicies.POLICY_TYPE_14;
            case 15:
                return SecurityPolicies.POLICY_TYPE_15;
            case 16:
                return SecurityPolicies.POLICY_TYPE_16;
            case 17:
                return SecurityPolicies.POLICY_TYPE_17;
            case 18:
                return SecurityPolicies.POLICY_TYPE_18;
            case 19:
                return SecurityPolicies.POLICY_TYPE_19;
            case 20:
                return SecurityPolicies.POLICY_TYPE_20;
            default:
                return "";
        }
    }
}
