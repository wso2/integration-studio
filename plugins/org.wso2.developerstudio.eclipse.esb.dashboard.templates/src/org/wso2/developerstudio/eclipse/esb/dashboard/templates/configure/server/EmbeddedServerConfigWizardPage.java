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

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.configure.server;

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
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
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
import org.eclipse.swt.graphics.Image;
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
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import net.consensys.cava.toml.Toml;
import net.consensys.cava.toml.TomlParseResult;
import net.consensys.cava.toml.TomlTable;

public class EmbeddedServerConfigWizardPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String DIALOG_TITLE = "Embedded Micro Integrator Server Configuration";
    private static final Image NEW_ELEMENT_IMG = EEFRuntimePlugin
            .getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");
    private static final Image DELETE_ELEMENT_IMG = EEFRuntimePlugin
            .getImage(EEFRuntimePlugin.ICONS_16x16 + "Delete_16x16.gif");
    private static final String SERVER_CONFIG_LIBS = File.separator + "lib";
    private static final String SERVER_CONFIG_SELECTED_LIBS = File.separator + "selected";

    private String tomlConfig;
    private Map<String, Boolean> librariesList = new HashMap<>();
    private String serverConfigPath;
    private String embeddedMILocation;
    private Table libTable;
    private boolean isTomlChanged = false;

    /**
     * Class constructor.
     */
    public EmbeddedServerConfigWizardPage(String tomlConfig, String serverConfigPath,
            Map<String, Boolean> librariesList, String embeddedMILocation) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        final URL imagePathInString = FileLocator.find(bundle, new Path("icons/server-config-64x64.png"), null);
        setImageDescriptor(ImageDescriptor.createFromURL(imagePathInString));
        setTomlConfig(tomlConfig);
        this.serverConfigPath = serverConfigPath;
        this.librariesList = librariesList;
        this.embeddedMILocation = embeddedMILocation;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

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
        data.top = new FormAttachment(3);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.bottom = new FormAttachment(97);
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

        Group secureGroup = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(textGroup, 10);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        secureGroup.setLayoutData(data);
        secureGroup.setLayout(new FormLayout());

        Label secureLabel = new Label(secureGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(25);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        secureLabel.setText("Encrypt secrets by running cipher-tool: ");
        secureLabel.setLayoutData(data);

        Button encryptButton = new Button(secureGroup, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(15);
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
                                    embeddedMILocation + File.separator + "conf" + File.separator + "security"
                                            + File.separator + "cipher-text.properties");
                            properties.setProperty("keystore.identity.location", keyStoreFile);
                            properties.setProperty("keystore.identity.type", "JKS");
                            properties.setProperty("keystore.identity.alias", "wso2carbon");
                            properties.setProperty("keystore.identity.store.password", "wso2carbon");
                            properties.setProperty("keystore.identity.store.secretProvider",
                                    "org.wso2.carbon.securevault.DefaultSecretCallbackHandler");
                            properties.setProperty("keystore.identity.key.password", "wso2carbon");
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
        data.bottom = new FormAttachment(98);
        data.height = 260;
        libGroup.setLayoutData(data);
        libGroup.setLayout(new FormLayout());
        libGroup.setText("Select libraries(JARs) which are needed to copy to Lib directory:");
        Font boldLibFont = new Font(null, new FontData("Arial", 10, SWT.BOLD));
        libGroup.setFont(boldLibFont);

        Button removeButton = new Button(libGroup, SWT.NONE);
        removeButton.setImage(DELETE_ELEMENT_IMG);
        data = new FormData();
        data.top = new FormAttachment(2);
        data.right = new FormAttachment(98);
        removeButton.setLayoutData(data);
        removeButton.setEnabled(false);

        Button addButton = new Button(libGroup, SWT.NONE);
        addButton.setImage(NEW_ELEMENT_IMG);
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
                    String[] pathSegments = importFile.split(File.separator);
                    String libraryName = pathSegments[pathSegments.length - 1];
                    FileUtils.copyFile(new File(importFile),
                            new File(serverConfigPath + SERVER_CONFIG_LIBS + File.separator + libraryName));
                    if (libraryName != null && !libraryName.isEmpty()) {
                        librariesList.put(libraryName, false);
                        reloadLibraryList();
                    }
                } catch (IOException err) {
                    log.error("Error while loading selected jar file", err);
                }
            }
        });

        libTable = new Table(libGroup, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        data = new FormData();
        data.top = new FormAttachment(removeButton, 3);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.height = 120;
        libTable.setLayoutData(data);
        libTable.setLinesVisible(true);
        libTable.setHeaderVisible(true);

        TableColumn columnCheck = new TableColumn(libTable, SWT.LEFT);
        columnCheck.setText("");

        TableColumn columnLibName = new TableColumn(libTable, SWT.LEFT);
        columnLibName.setText("Library Name");
        columnLibName.setWidth(500);

        for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
            TableItem item = new TableItem(libTable, SWT.NONE);
            item.setText(1, entry.getKey());
            item.setChecked(entry.getValue());
        }

        libTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                final TableItem item = (TableItem) event.item;
                if (event.detail == SWT.CHECK && item != null) {
                    String itemName = item.getText(1);
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
                    String propertyKey = libTable.getItem(libTable.getSelectionIndex()).getText(1);
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
        data.left = new FormAttachment(1);
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
                    item.setText(1, entry.getKey());
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
                    item.setText(1, entry.getKey());
                    item.setChecked(false);

                    if (librariesList.containsKey(itemName)) {
                        librariesList.put(itemName, false);
                    }
                }
            }
        });
    }

    private void reloadLibraryList() {
        libTable.removeAll();
        for (Map.Entry<String, Boolean> entry : librariesList.entrySet()) {
            TableItem item = new TableItem(libTable, SWT.NONE);
            item.setText(1, entry.getKey());
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
