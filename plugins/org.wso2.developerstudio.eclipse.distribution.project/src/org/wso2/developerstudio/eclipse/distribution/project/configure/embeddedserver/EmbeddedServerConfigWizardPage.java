/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.distribution.project.configure.embeddedserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.libraries.utils.LibImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import net.consensys.cava.toml.Toml;
import net.consensys.cava.toml.TomlParseResult;
import net.consensys.cava.toml.TomlTable;

public class EmbeddedServerConfigWizardPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String DIALOG_TITLE = "Embedded Micro Integrator Server Configuration";
    private static final String SERVER_CONFIG_LIBS = File.separator + "lib";
    private static final String SERVER_CONFIG_DROPINS = File.separator + "dropins";
    private static final String SERVER_CONFIG_SELECTED_LIBS = File.separator + "selected";
    private static final String DELIMETER = "\\";

    private String tomlConfig;
    private Map<String, Boolean> librariesList = new HashMap<>();
    private Map<String, Boolean> dropinLibrariesList = new HashMap<>();
    private String serverConfigPath;
    private String embeddedMILocation;
    private Table libTable;
    private Table dropinLibTable;
    private boolean isTomlChanged = false;

    /**
     * Class constructor.
     */
    public EmbeddedServerConfigWizardPage(String tomlConfig, String serverConfigPath,
            Map<String, Boolean> librariesList, String embeddedMILocation, Map<String, Boolean> dropinLibrariesList) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        final URL imagePathInString = FileLocator.find(bundle, new Path("icons/server-config-64x64.png"), null);
        FileLocator.find(bundle, new Path("icons/server-config-64x64.png"), null);
        setImageDescriptor(ImageDescriptor.createFromURL(imagePathInString));
        setTomlConfig(tomlConfig);
        this.serverConfigPath = serverConfigPath;
        this.librariesList = librariesList;
        this.embeddedMILocation = embeddedMILocation;
        this.dropinLibrariesList = dropinLibrariesList;
    }

    @Override
    public void createControl(Composite parent) {
        parent.setLayout(new FormLayout());

        // Create the ScrolledComposite to scroll vertically
        ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        FormData data = new FormData();
        data.top = new FormAttachment(0, 5);
        data.left = new FormAttachment(0, 5);
        data.bottom = new FormAttachment(100, -5);
        data.right = new FormAttachment(100, -5);
        scrolledComposite.setLayoutData(data);
        scrolledComposite.setMinSize(500, 980);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);
        setControl(scrolledComposite);
        
        Composite container = new Composite(scrolledComposite, SWT.NONE);
        container.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(0, 5);
        data.left = new FormAttachment(0, 5);
        data.bottom = new FormAttachment(100, -5);
        data.right = new FormAttachment(100, -5);
        container.setLayoutData(data);
        scrolledComposite.setContent(container);

        Group textGroup = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(container, 5);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        textGroup.setLayoutData(data);
        textGroup.setLayout(new FormLayout());
        textGroup.setText("Edit embedded deployment.toml file:");
        Font boldFont = new Font(null, new FontData("Arial", 10, SWT.BOLD));
        textGroup.setFont(boldFont);

        StyledText inlineTomlTextArea = new StyledText(textGroup, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        data = new FormData();
        data.top = new FormAttachment(0, 5);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.bottom = new FormAttachment(100, -45);
        data.height = 300;
        data.width = 510;
        inlineTomlTextArea.setCaretOffset(inlineTomlTextArea.getText().length());
        inlineTomlTextArea.setLayoutData(data);
        if (getTomlConfig() != null) {
            inlineTomlTextArea.setText(getTomlConfig());
        }

        // scroll bottom
        inlineTomlTextArea.setTopIndex(inlineTomlTextArea.getLineCount() - 1);

        inlineTomlTextArea.addLineStyleListener(new LineStyleListener() {
            public void lineGetStyle(LineStyleEvent e) {
                e.bulletIndex = inlineTomlTextArea.getLineAtOffset(e.lineOffset);
                StyleRange style = new StyleRange();
                Device device = Display.getCurrent();
                final RGB LINE_NUMBER_FG = new RGB(201, 208, 211);
                style.foreground = new Color(device, LINE_NUMBER_FG);
                style.metrics = new GlyphMetrics(0, 0,
                        Integer.toString(inlineTomlTextArea.getLineCount() + 1).length() * 15);
                e.bullet = new Bullet(ST.BULLET_NUMBER, style);
            }
        });

        // Modify listener for inline XML text area.
        inlineTomlTextArea.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                isTomlChanged = true;
                if (inlineTomlTextArea.getText().isEmpty()) {
                    setPageComplete(false);
                } else {
                    setPageComplete(true);
                    setTomlConfig(inlineTomlTextArea.getText());
                }
                // For line number redrawing.
                inlineTomlTextArea.redraw();
            }
        });
        
        Label restoreLabel = new Label(textGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(inlineTomlTextArea, 10, 5);
        data.left = new FormAttachment(3);
        restoreLabel.setText("Restore deployment.toml default configuration: ");
        restoreLabel.setLayoutData(data);
        
        Button restoreButton = new Button(textGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(inlineTomlTextArea, 10, 5);
        data.right = new FormAttachment(97);
        restoreButton.setLayoutData(data);
        restoreButton.setText("Restore Defaults");
        
        Group secureGroup = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(textGroup, 10);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        secureGroup.setLayoutData(data);
        secureGroup.setLayout(new FormLayout());

        Label secureLabel = new Label(secureGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(0, 5);
        data.left = new FormAttachment(3);
        //data.right = new FormAttachment(97);
        secureLabel.setText("Encrypt secrets by running cipher-tool: ");
        secureLabel.setLayoutData(data);

        Button encryptButton = new Button(secureGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(0, 0);
        data.bottom = new FormAttachment(100, -5);
        data.height = 30;
        data.right = new FormAttachment(97);
        encryptButton.setLayoutData(data);
        encryptButton.setText("Encrypt Secrets");

        encryptButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String tomlFile = serverConfigPath + File.separator + "deployment.toml";

                try {
                    FileUtils.writeStringToFile(new File(tomlFile), getTomlConfig());
                } catch (IOException error) {
                    log.error("Error while writing toml configurations", error);
                }

                try {
                    Map<String, String> secrets = getSecretsFromConfiguration(tomlFile);
                    if (secrets.size() > 0) {
                        // create secret.conf.properties file
                        File secretConfFile = new File(serverConfigPath + File.separator + "secret-conf.properties");
                        if (!secretConfFile.exists()) {
                            secretConfFile.createNewFile();
                        }

                        String cipherTransformation = "RSA/ECB/OAEPwithSHA1andMGF1Padding";
                        String keyStoreFile = embeddedMILocation + File.separator + "repository" + File.separator
                                + "resources" + File.separator + "security" + File.separator + "wso2carbon.jks";
                        KeyStore primaryKeyStore = getKeyStore(keyStoreFile, "wso2carbon", "JKS");

                        try {
                            Certificate certs = primaryKeyStore.getCertificate("wso2carbon");
                            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding");
                            cipher.init(Cipher.ENCRYPT_MODE, certs);

                            for (Map.Entry<String, String> entry : secrets.entrySet()) {
                                String key = entry.getKey();
                                String value = getUnEncryptedValue(entry.getValue());
                                if (StringUtils.isNotEmpty(value)) {
                                    String encryptedValue = doEncryption(cipher, value);
                                    secrets.replace(key, encryptedValue);
                                }
                            }

                            updateDeploymentConfigurationWithEncryptedKeys(secrets, tomlFile);

                            Properties properties = new Properties();
                            properties.setProperty("secVault.enabled", "true");
                            properties.setProperty("carbon.secretProvider",
                                    "org.wso2.securevault.secret.handler.SecretManagerSecretCallbackHandler");
                            properties.setProperty("secretRepositories", "file");
                            properties.setProperty("secretRepositories.file.provider",
                                    "org.wso2.securevault.secret.repository.FileBaseSecretRepositoryProvider");
                            properties.setProperty("secretRepositories.file.location",
                                            "conf" + File.separator + "security"
                                            + File.separator + "cipher-text.properties");
                            properties.setProperty("keystore.identity.location", keyStoreFile);
                            properties.setProperty("keystore.identity.type", "JKS");
                            properties.setProperty("keystore.identity.alias", "wso2carbon");
                            properties.setProperty("keystore.identity.store.password", "identity.store.password");
                            properties.setProperty("keystore.identity.store.secretProvider",
                                    "org.wso2.carbon.securevault.DefaultSecretCallbackHandler");
                            properties.setProperty("keystore.identity.key.password", "identity.key.password");
                            properties.setProperty("keystore.identity.key.secretProvider",
                                    "org.wso2.carbon.securevault.DefaultSecretCallbackHandler");
                            properties.setProperty("secretRepositories.file.algorithm", cipherTransformation);
                            writeToPropertyFile(properties, secretConfFile.getAbsolutePath());

                            String content = new String(Files.readAllBytes(Paths.get(tomlFile)));
                            inlineTomlTextArea.setText(content);
                            inlineTomlTextArea.setCaretOffset(inlineTomlTextArea.getText().length());
                            inlineTomlTextArea.setTopIndex(inlineTomlTextArea.getLineCount() - 1);
                            setTomlConfig(content);
                        } catch (Exception err) {
                            log.error("Error creating cipher object", err);
                        }
                    } else {
                        MessageBox messageBox = new MessageBox(
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.ERROR | SWT.OK);
                        messageBox.setMessage("Can not encrypt empty secret toml configuration");
                        messageBox.setText("No Secrets Found");
                        messageBox.open();
                    }
                } catch (IOException err) {
                    log.error("Error while loading toml file to resolve secrets", err);
                }
            }
        });

        Group libGroup = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(secureGroup, 10);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        data.height = 210;
        libGroup.setLayoutData(data);
        libGroup.setLayout(new FormLayout());
        libGroup.setText("Select libraries(JARs) that need to be copied to the Lib directory:");
        Font boldLibFont = new Font(null, new FontData("Arial", 10, SWT.BOLD));
        libGroup.setFont(boldLibFont);

        Button removeButton = new Button(libGroup, SWT.NONE);
        removeButton.setImage(LibImageUtils.getInstance().getImageDescriptor("delete.png").createImage());
        data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        removeButton.setLayoutData(data);
        removeButton.setEnabled(false);

        Button addButton = new Button(libGroup, SWT.NONE);
        addButton.setImage(LibImageUtils.getInstance().getImageDescriptor("add.png").createImage());
        data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(removeButton, -3);
        addButton.setLayoutData(data);
        addButton.setEnabled(true);

        addButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                try {
                    FileDialog fileDlg = new FileDialog(getShell());
                    String[] filterExt = { "*.jar;*.JAR" };
                    fileDlg.setFilterExtensions(filterExt);
                    String importFile = fileDlg.open();
                    if (importFile != null) {
                        String[] pathSegments = importFile.split("\\"+File.separator);
                        String libraryName = pathSegments[pathSegments.length - 1];
                        FileUtils.copyFile(new File(importFile),
                                new File(serverConfigPath + SERVER_CONFIG_LIBS + SERVER_CONFIG_SELECTED_LIBS + 
                                		File.separator + libraryName));
                        if (libraryName != null && !libraryName.isEmpty()) {
                            librariesList.put(libraryName, true);
                            reloadLibraryList();
                        }
                    }
                } catch (IOException err) {
                    log.error("Error while loading selected jar file", err);
                }
            }
        });

        libTable = new Table(libGroup, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        data = new FormData();
        data.top = new FormAttachment(removeButton, 5, 5);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.height = 130;
        data.bottom = new FormAttachment(100,-40);
        libTable.setLayoutData(data);
        libTable.setLinesVisible(true);
        libTable.setHeaderVisible(true);



        TableColumn columnLibName = new TableColumn(libTable, SWT.LEFT);
        columnLibName.setText("Library Name");
        columnLibName.setWidth(520);

        for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
            TableItem item = new TableItem(libTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setChecked(entry.getValue());
        }

        libTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                final TableItem item = (TableItem) event.item;
                if (event.detail == SWT.CHECK && item != null) {
                    String itemName = item.getText(0);
                    String sourceDirectory;
                    String destinationDirectory;
                    try {
                        if (item.getChecked()) {
                            sourceDirectory = serverConfigPath + SERVER_CONFIG_LIBS + File.separator + itemName;
                            destinationDirectory = serverConfigPath + SERVER_CONFIG_LIBS + SERVER_CONFIG_SELECTED_LIBS
                                    + File.separator + itemName;
                        } else {
                            sourceDirectory = serverConfigPath + SERVER_CONFIG_LIBS + SERVER_CONFIG_SELECTED_LIBS
                                    + File.separator + itemName;
                            destinationDirectory = serverConfigPath + SERVER_CONFIG_LIBS + File.separator + itemName;
                        }
                        java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                java.nio.file.Paths.get(destinationDirectory));
                        if (movedFile == null) {
                            throw new IOException("Error while 'moving as selected' the selected jar file");
                        }

                        if (librariesList.containsKey(itemName)) {
                            librariesList.put(itemName, item.getChecked());
                            reloadLibraryList();
                        }
                    } catch (IOException e) {
                        log.error("Error while 'moving as selected' the selected jar file", e);
                    }
                } else {
                    TableItem selectedItem = (TableItem) event.item;
                    if (selectedItem != null) {
                        libTable.setSelection(libTable.indexOf(selectedItem));
                        removeButton.setEnabled(true);
                    } else {
                        removeButton.setEnabled(false);
                    }
                }
            }
        });

        removeButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                if (libTable.getSelectionIndex() >= 0) {
                    String propertyKey = libTable.getItem(libTable.getSelectionIndex()).getText(0);
                    if (librariesList.containsKey(propertyKey)) {
                        String selectedJarLocatedPath;
                        if (librariesList.get(propertyKey)) {
                            selectedJarLocatedPath = serverConfigPath + SERVER_CONFIG_LIBS
                                    + SERVER_CONFIG_SELECTED_LIBS;
                        } else {
                            selectedJarLocatedPath = serverConfigPath + SERVER_CONFIG_LIBS;
                        }
                        try {
                            Files.deleteIfExists(Paths.get(selectedJarLocatedPath + File.separator + propertyKey));
                        } catch (IOException err) {
                            log.error("Error while deleting selected jar file", err);
                        }
                        librariesList.remove(propertyKey);
                        libTable.remove(libTable.getSelectionIndices());
                        removeButton.setEnabled(false);
                    }
                }
            }
        });

        Button selectAllButton = new Button(libGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(libTable, 5);
        data.left = new FormAttachment(2);
        selectAllButton.setLayoutData(data);
        selectAllButton.setText("Select All");

        Button deselectAllButton = new Button(libGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(libTable, 5);
        data.left = new FormAttachment(selectAllButton, 3);
        deselectAllButton.setLayoutData(data);
        deselectAllButton.setText("Deselect All");

        selectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                libTable.removeAll();

                for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
                    String itemName = entry.getKey();
                    String sourceDirectory = serverConfigPath + SERVER_CONFIG_LIBS + File.separator + itemName;
                    String destinationDirectory = serverConfigPath + SERVER_CONFIG_LIBS + SERVER_CONFIG_SELECTED_LIBS
                            + File.separator + itemName;

                    File currentJar = new File(sourceDirectory);
                    if (currentJar.exists()) {
                        try {
                            java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                    java.nio.file.Paths.get(destinationDirectory));
                            if (movedFile == null) {
                                throw new IOException("Error while 'moving as selected' the selected jar file");
                            }

                        } catch (IOException err) {
                            log.error("Error while 'moving as selected' the selected jar file", err);
                        }
                    }

                    TableItem item = new TableItem(libTable, SWT.NONE);
                    item.setText(0, entry.getKey());
                    item.setChecked(true);

                    if (librariesList.containsKey(itemName)) {
                        librariesList.put(itemName, true);
                    }
                }
            }
        });

        deselectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                libTable.removeAll();

                for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
                    String itemName = entry.getKey();
                    String sourceDirectory = serverConfigPath + SERVER_CONFIG_LIBS + SERVER_CONFIG_SELECTED_LIBS
                            + File.separator + itemName;
                    String destinationDirectory = serverConfigPath + SERVER_CONFIG_LIBS + File.separator + itemName;

                    File currentJar = new File(sourceDirectory);
                    if (currentJar.exists()) {
                        try {
                            java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                    java.nio.file.Paths.get(destinationDirectory));
                            if (movedFile == null) {
                                throw new IOException("Error while 'moving as selected' the selected jar file");
                            }

                        } catch (IOException err) {
                            log.error("Error while 'moving as selected' the selected jar file", err);
                        }
                    }

                    TableItem item = new TableItem(libTable, SWT.NONE);
                    item.setText(0, entry.getKey());
                    item.setChecked(false);

                    if (librariesList.containsKey(itemName)) {
                        librariesList.put(itemName, false);
                    }
                }
            }
        });
        
        restoreButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String confPath = embeddedMILocation + File.separator + "conf" + File.separator;
                String tmpTomlFile = confPath + "deployment_temp.toml";
                try {
                    String content;
                    if (new File(tmpTomlFile).exists()) {
                        content = new String(Files.readAllBytes(Paths.get(tmpTomlFile)));
                    } else {
                        String tomlFile = confPath + "deployment.toml";
                        content = new String(Files.readAllBytes(Paths.get(tomlFile)));
                    }
                    inlineTomlTextArea.setText(content);
                    inlineTomlTextArea.setCaretOffset(inlineTomlTextArea.getText().length());
                    inlineTomlTextArea.setTopIndex(inlineTomlTextArea.getLineCount() - 1);
                    setTomlConfig(content);
                } catch (IOException e1) {
                    MessageBox messageBox = new MessageBox(
                            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.ERROR | SWT.OK);
                    messageBox.setMessage("Error while restoring the default toml configuration.");
                    messageBox.setText("Restore Defaults Error");
                    messageBox.open();
                }
            }
        });
        
        Group dropingLibGroup = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(libGroup, 10);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        data.bottom = new FormAttachment(97);
        data.height = 210;
        dropingLibGroup.setLayoutData(data);
        dropingLibGroup.setLayout(new FormLayout());
        dropingLibGroup.setText("Select libraries(JARs) that need to be copied to the Dropins directory:");
        Font bldLibFont = new Font(null, new FontData("Arial", 10, SWT.BOLD));
        dropingLibGroup.setFont(bldLibFont);

        Button dropinLibRemoveButton = new Button(dropingLibGroup, SWT.NONE);
        dropinLibRemoveButton.setImage(LibImageUtils.getInstance().getImageDescriptor("delete.png").createImage());
        data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        dropinLibRemoveButton.setLayoutData(data);
        dropinLibRemoveButton.setEnabled(false);

        Button dropingLibAddButton = new Button(dropingLibGroup, SWT.NONE);
        dropingLibAddButton.setImage(LibImageUtils.getInstance().getImageDescriptor("add.png").createImage());
        data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(dropinLibRemoveButton, -3);
        dropingLibAddButton.setLayoutData(data);
        dropingLibAddButton.setEnabled(true);
        
        dropingLibAddButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                try {
                    FileDialog fileDlg = new FileDialog(getShell());
                    String[] filterExt = { "*.jar;*.JAR" };
                    fileDlg.setFilterExtensions(filterExt);
                    String importFile = fileDlg.open();
                    if (importFile != null) {
                        String[] pathSegments = importFile.split(DELIMETER + File.separator);
                        String libraryName = pathSegments[pathSegments.length - 1];
                        FileUtils.copyFile(new File(importFile),
                                new File(serverConfigPath + SERVER_CONFIG_DROPINS + SERVER_CONFIG_SELECTED_LIBS + 
                                        File.separator + libraryName));
                        if (libraryName != null && !libraryName.isEmpty()) {
                            dropinLibrariesList.put(libraryName, true);
                            reloadLibraryList();
                        }
                    }
                } catch (IOException err) {
                    log.error("Error while loading selected jar file", err);
                }
            }
        });
        
        dropinLibTable = new Table(dropingLibGroup, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        data = new FormData();
        data.top = new FormAttachment(dropinLibRemoveButton, 5, 5);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.height = 130;
        data.bottom = new FormAttachment(100,-40);
        dropinLibTable.setLayoutData(data);
        dropinLibTable.setLinesVisible(true);
        dropinLibTable.setHeaderVisible(true);

        TableColumn dropingColumnLibName = new TableColumn(dropinLibTable, SWT.LEFT);
        dropingColumnLibName.setText("Library Name");
        dropingColumnLibName.setWidth(520);
        
        for (Map.Entry<String, Boolean> entry : dropinLibrariesList.entrySet()) {
            TableItem item = new TableItem(dropinLibTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setChecked(entry.getValue());
        }
        
        dropinLibTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                final TableItem item = (TableItem) event.item;
                if (event.detail == SWT.CHECK && item != null) {
                    String itemName = item.getText(0);
                    String sourceDirectory;
                    String destinationDirectory;
                    try {
                        if (item.getChecked()) {
                            sourceDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + File.separator + itemName;
                            destinationDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + SERVER_CONFIG_SELECTED_LIBS
                                    + File.separator + itemName;
                        } else {
                            sourceDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + SERVER_CONFIG_SELECTED_LIBS
                                    + File.separator + itemName;
                            destinationDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + File.separator + itemName;
                        }
                        java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                java.nio.file.Paths.get(destinationDirectory));
                        if (movedFile == null) {
                            throw new IOException("Error while 'moving as selected' the selected jar file");
                        }

                        if (dropinLibrariesList.containsKey(itemName)) {
                            dropinLibrariesList.put(itemName, item.getChecked());
                            reloadLibraryList();
                        }
                    } catch (IOException e) {
                        log.error("Error while 'moving as selected' the selected jar file", e);
                    }
                } else {
                    TableItem selectedItem = (TableItem) event.item;
                    if (selectedItem != null) {
                        dropinLibTable.setSelection(dropinLibTable.indexOf(selectedItem));
                        dropinLibRemoveButton.setEnabled(true);
                    } else {
                        dropinLibRemoveButton.setEnabled(false);
                    }
                }
            }
        });

        dropinLibRemoveButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                if (dropinLibTable.getSelectionIndex() >= 0) {
                    String propertyKey = dropinLibTable.getItem(dropinLibTable.getSelectionIndex()).getText(0);
                    if (dropinLibrariesList.containsKey(propertyKey)) {
                        String selectedJarLocatedPath;
                        if (dropinLibrariesList.get(propertyKey)) {
                            selectedJarLocatedPath = serverConfigPath + SERVER_CONFIG_DROPINS
                                    + SERVER_CONFIG_SELECTED_LIBS;
                        } else {
                            selectedJarLocatedPath = serverConfigPath + SERVER_CONFIG_DROPINS;
                        }
                        try {
                            Files.deleteIfExists(Paths.get(selectedJarLocatedPath + File.separator + propertyKey));
                        } catch (IOException err) {
                            log.error("Error while deleting selected jar file", err);
                        }
                        dropinLibrariesList.remove(propertyKey);
                        dropinLibTable.remove(dropinLibTable.getSelectionIndices());
                        dropinLibRemoveButton.setEnabled(false);
                    }
                }
            }
        });
        
        Button dropinSelectAllButton = new Button(dropingLibGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(dropinLibTable, 5);
        data.left = new FormAttachment(2);
        dropinSelectAllButton.setLayoutData(data);
        dropinSelectAllButton.setText("Select All");

        Button dropinDeselectAllButton = new Button(dropingLibGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(dropinLibTable, 5);
        data.left = new FormAttachment(dropinSelectAllButton, 3);
        dropinDeselectAllButton.setLayoutData(data);
        dropinDeselectAllButton.setText("Deselect All");
        
        dropinSelectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dropinLibTable.removeAll();

                for (Map.Entry<String, Boolean> entry : dropinLibrariesList.entrySet()) {
                    String itemName = entry.getKey();
                    String sourceDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + File.separator + itemName;
                    String destinationDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + SERVER_CONFIG_SELECTED_LIBS
                            + File.separator + itemName;

                    File currentJar = new File(sourceDirectory);
                    if (currentJar.exists()) {
                        try {
                            java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                    java.nio.file.Paths.get(destinationDirectory));
                            if (movedFile == null) {
                                throw new IOException("Error while 'moving as selected' the selected jar file");
                            }

                        } catch (IOException err) {
                            log.error("Error while 'moving as selected' the selected jar file", err);
                        }
                    }

                    TableItem item = new TableItem(dropinLibTable, SWT.NONE);
                    item.setText(0, entry.getKey());
                    item.setChecked(true);

                    if (dropinLibrariesList.containsKey(itemName)) {
                        dropinLibrariesList.put(itemName, true);
                    }
                }
            }
        });

        dropinDeselectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dropinLibTable.removeAll();

                for (Map.Entry<String, Boolean> entry : dropinLibrariesList.entrySet()) {
                    String itemName = entry.getKey();
                    String sourceDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + SERVER_CONFIG_SELECTED_LIBS
                            + File.separator + itemName;
                    String destinationDirectory = serverConfigPath + SERVER_CONFIG_DROPINS + File.separator + itemName;

                    File currentJar = new File(sourceDirectory);
                    if (currentJar.exists()) {
                        try {
                            java.nio.file.Path movedFile = Files.move(java.nio.file.Paths.get(sourceDirectory),
                                    java.nio.file.Paths.get(destinationDirectory));
                            if (movedFile == null) {
                                throw new IOException("Error while 'moving as selected' the selected jar file");
                            }

                        } catch (IOException err) {
                            log.error("Error while 'moving as selected' the selected jar file", err);
                        }
                    }

                    TableItem item = new TableItem(dropinLibTable, SWT.NONE);
                    item.setText(0, entry.getKey());
                    item.setChecked(false);

                    if (dropinLibrariesList.containsKey(itemName)) {
                        dropinLibrariesList.put(itemName, false);
                    }
                }
            }
        });
    }

    private void reloadLibraryList() {
        libTable.removeAll();
        for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
            TableItem item = new TableItem(libTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setChecked(entry.getValue());
        }
        dropinLibTable.removeAll();
        for (Map.Entry<String, Boolean> entry : dropinLibrariesList.entrySet()) {
            TableItem item = new TableItem(dropinLibTable, SWT.NONE);
            item.setText(0, entry.getKey());
            item.setChecked(entry.getValue());
        }

    }

    /**
     * Read deployment.toml file and return list of secrets
     *
     * @param configFilePath file path to deployment toml
     * @return Map of secrets
     */
    public Map<String, String> getSecretsFromConfiguration(String configFilePath) throws IOException {
        Map<String, String> context = new LinkedHashMap<>();

        TomlParseResult result = Toml.parse(Paths.get(configFilePath));
        TomlTable table = result.getTable("secrets");
        if (table != null) {
            table.dottedKeySet().forEach(key -> context.put(key, table.getString(key)));
        }
        return context;
    }

    private static KeyStore getKeyStore(String location, String storePassword, String storeType) {
        try (InputStream inputStream = new FileInputStream(location)) {
            KeyStore keyStore = KeyStore.getInstance(storeType);
            keyStore.load(inputStream, storePassword.toCharArray());
            return keyStore;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Read unencrypted value from [secrets] section in deployment toml file
     *
     * @param value key to read
     * @return unencrypted value
     */
    public static String getUnEncryptedValue(String value) {
        String[] unEncryptedRefs = StringUtils.substringsBetween(value, "[", "]");
        if (unEncryptedRefs != null && unEncryptedRefs.length == 1) {
            return unEncryptedRefs[0];
        } else {
            return null;
        }
    }

    /**
     * encrypt the plain text password
     *
     * @param cipher init cipher
     * @param plainTextPwd plain text password
     * @return encrypted password
     */
    public static String doEncryption(Cipher cipher, String plainTextPwd) {
        String encodedValue;
        try {
            byte[] encryptedPassword = cipher.doFinal(plainTextPwd.getBytes(Charset.forName("UTF8")));
            encodedValue = DatatypeConverter.printBase64Binary(encryptedPassword);
            return encodedValue;
        } catch (BadPaddingException e) {
            log.error("Error while encrypting secrets", e);
        } catch (IllegalBlockSizeException e) {
            log.error("Error while encrypting secrets", e);
        }
        return null;
    }

    private static void updateDeploymentConfigurationWithEncryptedKeys(Map<String, String> encryptedKeyMap,
            String tomlPath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(tomlPath));
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(tomlPath), StandardCharsets.UTF_8))) {
                boolean found = false;
                for (String line : lines) {
                    if (found) {
                        if (line.matches("\\[.+\\]")) {
                            found = false;
                        } else {
                            StringTokenizer stringTokenizer = new StringTokenizer(line, "=");
                            if (stringTokenizer.hasMoreTokens()) {
                                String key = stringTokenizer.nextToken();
                                String value = encryptedKeyMap.get(key.trim());
                                line = key.concat("= \"").concat(value).concat("\"");
                            }
                        }
                    } else {
                        if ("[secrets]".equals(line.trim())) {
                            found = true;
                        }
                    }
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            log.error("Error while witing encrypted secrets to toml file", e);
        }
    }

    /**
     * writees the properties into a file
     *
     * @param properties properties
     * @param filePath filepath
     */
    public static void writeToPropertyFile(Properties properties, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            log.error("Error loading properties from a file at : " + filePath, e);
        }
    }

    public String getTomlConfig() {
        return tomlConfig;
    }

    public void setTomlConfig(String tomlConfig) {
        this.tomlConfig = tomlConfig;
    }

    public boolean isTomlChanged() {
        return isTomlChanged;
    }
}
