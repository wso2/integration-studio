/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.CloudConnectorOperationPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.EnableCondition;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.EnableConditionManager;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.DescriptorConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.KeyValueTableColumn;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Widget Provider class for the new properties framework.
 */
public class PropertiesWidgetProvider {

    protected IPropertiesEditionComponent propertiesEditionComponent;
    protected SectionPropertiesEditingPart partForm;
    protected HashMap<String, Control> controlList;
    private static final char PASSWORD_BLACK_CIRCLE = '\u25CF';
    protected HashMap<String, Composite> compositeList;
    protected HashMap<String, Control> requiredList;
    private EnableConditionManager enableConditionManager;
    private boolean isConnectionWidgetProvider = false;
    private static IDeveloperStudioLog log = Logger.getLog(EEFPropertyViewUtil.PLUGIN_ID);
    private HashMap<String, AttributeConstuctionElement> attributeQueue = new HashMap<>();
    private final int MAX_NUMBER_OF_RESULTS = 50;
    protected HashMap<String, Composite> initialCompositeList;


    /**
     * General constructor to initialize properties widget provider
     *
     * @param partForm                   Properties Editing Part Form which holds the relevent properties composite in the view
     * @param propertiesEditionComponent Component object which uses to manipulate ecore model
     * @param controlList                Map which holds each SWT input widget against its property name
     * @param compositeList              Map which holds each composite of the property against its property name
     * @param requiredList               Map which holds the required composite list based on the 'required' parameter of json schema
     */
    public PropertiesWidgetProvider(SectionPropertiesEditingPart partForm,
                                    IPropertiesEditionComponent propertiesEditionComponent,
                                    HashMap<String, Control> controlList,
                                    HashMap<String, Composite> compositeList,
                                    HashMap<String, Control> requiredList,
                                    EnableConditionManager enableConditionManager) {

        this.propertiesEditionComponent = propertiesEditionComponent;
        this.partForm = partForm;
        this.controlList = controlList;
        this.compositeList = compositeList;
        this.requiredList = requiredList;
        this.enableConditionManager = enableConditionManager;
    }

    /**
     * Special constructor to be used with connection dialog box property generation
     *
     * @param controlList   Map which holds each SWT input widget against its property name
     * @param compositeList Map which holds each composite of the property against its property name
     * @param requiredList  Map which holds the required composite list based on the 'required' parameter of json schema
     */
    public PropertiesWidgetProvider(HashMap<String, Control> controlList, HashMap<String, Composite> compositeList,
                                    HashMap<String, Control> requiredList) {

        this.controlList = controlList;
        this.compositeList = compositeList;
        this.isConnectionWidgetProvider = true;
        this.requiredList = requiredList;
        this.enableConditionManager = new EnableConditionManager(compositeList);
    }

    /**
     * Provides a new group inside the provided composite
     *
     * @param parent parent composite
     * @param label  label of the group
     * @return Generated Group widget
     */
    public Group createGroup(Composite parent, String label) {

        Group propertiesSection = new Group(parent, SWT.SHADOW_ETCHED_IN);
        propertiesSection.setBackgroundMode(SWT.INHERIT_FORCE);
        propertiesSection.setText(label);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 1;
        propertiesGroupLayout.marginLeft = 5;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 5;
        propertiesSection.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        propertiesSection.setLayoutData(propertiesSectionData);
        return propertiesSection;
    }

    /**
     * Provide a composite with plain text box widget and a label
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return composite with plain text box widget and a label
     */
    public Composite createTextBoxField(FormToolkit widgetFactory, Composite parent,
                                        final AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 2 elements
        Composite textBoxComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 2, 2);

        // Create label for the property
        Label propertyLabel = new Label(textBoxComposite, SWT.TRANSPARENT | SWT.WRAP);
        propertyLabel.setText(jsonSchemaObject.getDisplayName());
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        propertyLabel.setLayoutData(labelRefData);
        // Add tooltip to the label
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());
        addToEnableConditionManager(jsonSchemaObject, jsonSchemaObject.getName());
        // Create Text box widget
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        valueTextBox.setLayoutData(configRefData);
        valueTextBox.addKeyListener(new KeyAdapter() {

            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {

                if (!isConnectionWidgetProvider) { // Connection widgets are not notified to ecore model
                    if (jsonSchemaObject.getName().equals("description")) { // Notify ecore model directly since
                        // description is not a connector param
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                                EsbViewsRepository.CloudConnectorOperation.Properties.description,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                valueTextBox.getText()));
                    } else {
                        CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                        setParameterType(RuleOptionType.VALUE, ctp);
                        AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource())
                                .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                        updateModel(ctp, valueTextBox, uiSchemaValue);
                        updateEnableConditionValidation(jsonSchemaObject.getName(), ctp.getParameterValue());
                    }

                }
            }
        });
        // Register created widget in notify lists
        controlList.put(jsonSchemaObject.getName(), valueTextBox);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueTextBox);
        }
        return parent;
    }

    /**
     * Provide a composite with text box widget with expression support and a label
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return composite
     */
    public Composite createTextBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
                                                  final AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 3 elements
        Composite textBoxComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 3, 3);

        // Create label for the property
        Label propertyLabel = new Label(textBoxComposite, SWT.TRANSPARENT | SWT.WRAP);
        // Append * If required field
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        propertyLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        propertyLabel.setLayoutData(labelRefData);
        // Add tooltip to the label
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());
        // Create expression toggle button
        Button expressionToggleButton = new Button(textBoxComposite, SWT.TOGGLE);
        Image expressionToggleButtonImage = null;
        try {
            expressionToggleButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
            expressionToggleButton.setImage(expressionToggleButtonImage);
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        addToEnableConditionManager(jsonSchemaObject, jsonSchemaObject.getName());
        // Create Text box widget
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.BORDER );
        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        // Set the height of the value input text box since there is issue with toggling expression text box is
        // not visible when the height of the label is high
        configRefData.heightHint = propertyLabel.computeSize(EEFPropertyConstants.LABEL_WIDTH, SWT.DEFAULT).y;
        valueTextBox.setLayoutData(configRefData);
        valueTextBox.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject); // Set UI schema object as
        // control data
        valueTextBox.addKeyListener(new KeyAdapter() {

            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource())
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, valueTextBox, uiSchemaValue);
                    updateEnableConditionValidation(jsonSchemaObject.getName(), ctp.getParameterValue());
                }
            }
        });

        // Create expression compsite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(jsonSchemaObject.getName(), widgetFactory,
                textBoxComposite, jsonSchemaObject);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // Hide the expression composite first

        // Bind toggle button events
        expressionToggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                if (!isConnectionWidgetProvider) {
                    Button source = (Button) e.getSource();
                    if (source.getSelection()) { // If pressed
                        // Hide value text box
                        valueTextBox.setVisible(false);
                        ((GridData) valueTextBox.getLayoutData()).exclude = true;
                        // Show expression composite
                        expressionComposite.setVisible(true);
                        ((GridData) expressionComposite.getLayoutData()).exclude = false;
                        parent.layout();
                        // update ecore object to expression
                        CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                        setParameterType(RuleOptionType.EXPRESSION, ctp);
                    } else {
                        // Show value text box
                        valueTextBox.setVisible(true);
                        ((GridData) valueTextBox.getLayoutData()).exclude = false;
                        // Hide expression composite
                        expressionComposite.setVisible(false);
                        ((GridData) expressionComposite.getLayoutData()).exclude = true;
                        parent.layout();
                        // update ecore object to value
                        CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                        setParameterType(RuleOptionType.VALUE, ctp);
                    }
                }
            }
        });
        valueTextBox.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionToggleButton); // Add associated button
        // to
        setItemFocus(valueTextBox);
        // Register created widget in notify lists
        controlList.put(jsonSchemaObject.getName(), valueTextBox);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueTextBox);
        }
        return parent;
    }

    /**
     * Provide a composite with password text box widget with expression support and a label
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return composite
     */
    public Composite createPasswordTextBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
                                                          AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 3 elements
        Composite textBoxComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 4, 3);

        // Create label for the property
        Label propertyLabel = new Label(textBoxComposite, SWT.TRANSPARENT | SWT.WRAP);
        // Append * If required field
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        propertyLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        propertyLabel.setLayoutData(labelRefData);
        // Add tooltip to the label
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());
        // Create expression toggle button
        Button expressionToggleButton = new Button(textBoxComposite, SWT.TOGGLE);
        Image expressionToggleButtonImage = null;
        try {
            expressionToggleButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
            expressionToggleButton.setImage(expressionToggleButtonImage);
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }

        // Create Text box widget
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.SINGLE | SWT.BORDER);
        valueTextBox.setEchoChar(PASSWORD_BLACK_CIRCLE);

        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        valueTextBox.setLayoutData(configRefData);
        valueTextBox.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject); // Set UI schema object as
        // control data
        valueTextBox.addKeyListener(new KeyAdapter() {

            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource())
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, valueTextBox, uiSchemaValue);
                }
            }
        });

        // Create expression compsite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(jsonSchemaObject.getName(), widgetFactory,
                textBoxComposite, jsonSchemaObject);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // Hide the expression composite first

        // Show hide password checkbox
        final Button showPasswordCheckBox = new Button(textBoxComposite, SWT.CHECK);
        showPasswordCheckBox.setText("Show Password");
        showPasswordCheckBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                Button source = (Button) e.getSource();
                if (source.getSelection()) { // If pressed
                    valueTextBox.setEchoChar('\0');
                } else {
                    valueTextBox.setEchoChar(PASSWORD_BLACK_CIRCLE);
                }
            }
        });
        // Bind toggle button events
        expressionToggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                if (!isConnectionWidgetProvider) {
                    Button source = (Button) e.getSource();
                    if (source.getSelection()) { // If pressed
                        // Hide value text box
                        valueTextBox.setVisible(false);
                        ((GridData) valueTextBox.getLayoutData()).exclude = true;
                        // Show expression composite
                        expressionComposite.setVisible(true);
                        ((GridData) expressionComposite.getLayoutData()).exclude = false;
                        parent.layout();
                        // update ecore object to expression
                        CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                        setParameterType(RuleOptionType.EXPRESSION, ctp);
                        showPasswordCheckBox.setVisible(false);
                    } else {
                        // Show value text box
                        valueTextBox.setVisible(true);
                        ((GridData) valueTextBox.getLayoutData()).exclude = false;
                        // Hide expression composite
                        expressionComposite.setVisible(false);
                        ((GridData) expressionComposite.getLayoutData()).exclude = true;
                        parent.layout();
                        // update ecore object to value
                        CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                        setParameterType(RuleOptionType.VALUE, ctp);
                        showPasswordCheckBox.setVisible(true);
                    }
                }
            }
        });
        valueTextBox.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionToggleButton); // Add associated button
        setItemFocus(valueTextBox);
        // Register created widget in notify lists
        controlList.put(jsonSchemaObject.getName(), valueTextBox);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueTextBox);
        }
        return parent;
    }

    /**
     * Provide a composite with search box widget with expression support and a label
     *
     * @param widgetFactory widget factory instance
     * @param parent parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return composite
     */
    public Composite createSearchBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
            AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 1 element
        final Composite searchBoxComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 1, 1);

        // Search field with search icon and cancel icon
        final Text searchField = new Text(searchBoxComposite,
                SWT.BORDER | SWT.SEARCH | SWT.WRAP | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        searchField.setMessage("Search");

        // Layout of search box
        searchField.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData searchData = new GridData(GridData.FILL_HORIZONTAL);
        searchField.setLayoutData(searchData);
        searchField.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);

        // listener to monitor changes in the text field
        searchField.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {

                if (initialCompositeList == null) {
                    initialCompositeList = new HashMap<String, Composite>(compositeList);
                }
                String searchText = searchField.getText().toLowerCase();
                if (StringUtils.isNotBlank(searchText)) {
                    int resultCount = 0;
                    // traverse through the hash map of the available composites
                    for (Map.Entry<String, Composite> entry : compositeList.entrySet()) {
                        // Check if the display name contains the searched text
                        if (entry.getKey().contains(searchText) && resultCount < MAX_NUMBER_OF_RESULTS) {
                            if (!entry.getKey().endsWith("exp")) { // skip the expression text boxes and button
                                entry.getValue().setVisible(true);// shows the attribute that match
                                ((GridData) entry.getValue().getLayoutData()).exclude = false;
                                validateExpressionButton(entry.getValue());
                                resultCount++;
                            }
                        } else {
                            if (!entry.getKey().equals("search")) { // skip the search bar from hiding
                                entry.getValue().setVisible(false);// hides the attribute that doesn't match
                                ((GridData) entry.getValue().getLayoutData()).exclude = true;
                            }
                        }
                    }
                    // Show the additional attributes from the availabe from queue
                    ArrayList<String> listOfAttributesAdded = new ArrayList<>();
                    if (resultCount < MAX_NUMBER_OF_RESULTS) {
                        for (Entry<String, AttributeConstuctionElement> attributeElement : attributeQueue.entrySet()) {
                            if (attributeElement.getValue().getValue().getName().contains(searchText)
                                    && resultCount < MAX_NUMBER_OF_RESULTS) {
                                loadAttributeFromQueue(attributeElement.getValue().getValue().getName());
                                listOfAttributesAdded.add(attributeElement.getValue().getValue().getName());
                                resultCount++;
                            }
                        }
                        partForm.refresh();
                    }

                    for (String attributeName : listOfAttributesAdded) {
                        attributeQueue.remove(attributeName);
                    }

                    if (compositeList.get(DescriptorConstants.CONFIG_REF) != null) {
                        compositeList.get(DescriptorConstants.CONFIG_REF).setVisible(true); // keeps connection visible
                        ((GridData) compositeList.get(DescriptorConstants.CONFIG_REF).getLayoutData()).exclude = false; // show
                    }

                    // refresh the swt graphical objects
                    searchBoxComposite.getParent().getParent().layout();

                } else {
                    // if the search text is empty show the initial set of attributes
                    for (Map.Entry<String, Composite> entry : compositeList.entrySet()) {
                        entry.getValue().setVisible(false);
                        ((GridData) entry.getValue().getLayoutData()).exclude = true;

                    }
                    for (Map.Entry<String, Composite> entry : initialCompositeList.entrySet()) { // hash
                        if (!entry.getKey().endsWith("exp")) {
                            entry.getValue().setVisible(true);
                            ((GridData) entry.getValue().getLayoutData()).exclude = false;
                            validateExpressionButton(entry.getValue());
                        }
                    }
                    // refresh the SWT graphical objects
                    searchBoxComposite.getParent().getParent().layout();
                }
            }
        });

        return parent;
    }
    
    private static void validateExpressionButton(Composite composite) {
        Control[] compositeChildren = composite.getChildren();
        Text valueTextBox = null;
        Button expressionToggleButton = null;
        Composite expressionComposite = null;
        for (Control child : compositeChildren) {
            if (child instanceof Text) {
                valueTextBox = (Text) child;
            } else if (child instanceof Composite) {
                expressionComposite = (Composite) child;
            } else if (child instanceof Button) {
                expressionToggleButton = (Button) child;
            }
        }
        if (valueTextBox != null && expressionToggleButton != null && expressionComposite != null) {
            if (expressionToggleButton.getSelection()) { // If pressed
                // Hide value text box
                valueTextBox.setVisible(false);
                ((GridData) valueTextBox.getLayoutData()).exclude = true;
                // Show expression composite
                expressionComposite.setVisible(true);
                ((GridData) expressionComposite.getLayoutData()).exclude = false;
                // update ecore object to expression
                CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                setParameterType(RuleOptionType.EXPRESSION, ctp);
            } else {
                // Show value text box
                valueTextBox.setVisible(true);
                ((GridData) valueTextBox.getLayoutData()).exclude = false;
                // Hide expression composite
                expressionComposite.setVisible(false);
                ((GridData) expressionComposite.getLayoutData()).exclude = true;
                // update ecore object to value
                CallTemplateParameter ctp = (CallTemplateParameter) valueTextBox.getData();
                setParameterType(RuleOptionType.VALUE, ctp);
            }
        }
    }

    /**
     * Provide a composite with Drop down Combo widget with expression support and a label
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param options          options array for drop down menu
     * @param jsonSchemaObject JSONSchema object of the property
     * @return Composite
     */
    public Composite createDropDownField(FormToolkit widgetFactory, final Composite parent, String[] options,
                                         final AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 3 elements
        Composite dropDownComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 3, 3);

        // Create label for the property
        Label propertyLabel = new Label(dropDownComposite, SWT.TRANSPARENT | SWT.WRAP);
        // Append * If required field
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        propertyLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        propertyLabel.setLayoutData(labelRefData);
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());

        // Create expression toggle button
        Button expressionToggleButton = new Button(dropDownComposite, SWT.TOGGLE);
        Image expressionToggleButtonImage = null;
        try {
            expressionToggleButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionToggleButton.setImage(expressionToggleButtonImage);

        // Create expression compsite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(jsonSchemaObject.getName(), widgetFactory,
                dropDownComposite, jsonSchemaObject);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // hide

        addToEnableConditionManager(jsonSchemaObject, jsonSchemaObject.getName());

        // Create combo box
        final Combo valueComboBox = new Combo(dropDownComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
        Color colorWhite = new Color(null, 255, 255, 255);
        valueComboBox.setBackground(colorWhite);
        valueComboBox.setItems(options);
        valueComboBox.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        valueComboBox.setLayoutData(configRefData);
        valueComboBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Combo) event.getSource()).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Combo) event.getSource())
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, valueComboBox, uiSchemaValue);
                    updateEnableConditionValidation(jsonSchemaObject.getName(), ctp.getParameterValue());
                }
            }
        });

        // Bind events to toggle button
        expressionToggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                if (!isConnectionWidgetProvider) {
                    Button source = (Button) e.getSource();

                    if (source.getSelection()) {
                        valueComboBox.setVisible(false);
                        ((GridData) valueComboBox.getLayoutData()).exclude = true;
                        expressionComposite.setVisible(true);
                        ((GridData) expressionComposite.getLayoutData()).exclude = false;
                        parent.layout();
                        CallTemplateParameter ctp = (CallTemplateParameter) valueComboBox.getData();
                        setParameterType(RuleOptionType.EXPRESSION, ctp);
                    } else {
                        valueComboBox.setVisible(true);
                        ((GridData) valueComboBox.getLayoutData()).exclude = false;
                        expressionComposite.setVisible(false);
                        ((GridData) expressionComposite.getLayoutData()).exclude = true;
                        parent.layout();
                        CallTemplateParameter ctp = (CallTemplateParameter) valueComboBox.getData();
                        setParameterType(RuleOptionType.VALUE, ctp);
                    }

                }
            }
        });
        valueComboBox.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionToggleButton);
        setItemFocus(valueComboBox);
        // Register created widget in notify lists
        controlList.put(jsonSchemaObject.getName(), valueComboBox);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueComboBox);
        }
        return parent;
    }

    private void addToEnableConditionManager(AttributeValue jsonSchemaObject, String componentName) {

        EnableCondition enableCondition = jsonSchemaObject.getEnableCondition();
        if (enableCondition != null) {
            enableConditionManager.addEnableCondition(enableCondition, componentName);
        }
    }

    private void updateEnableConditionValidation(String componentName, String componentValue) {

        enableConditionManager.handleValueChange(componentName, componentValue);
    }

    /**
     * Create expression composite which shows when expression toggle button is pressed
     *
     * @param id               Property Field Name
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return Composite
     */
    public Composite createExpressionComposite(String id, FormToolkit widgetFactory, final Composite parent,
                                               AttributeValue jsonSchemaObject) {
        // Create wrapping composite of 2 elements and 1 span
        Composite textComposite = createComposite(id + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX, widgetFactory,
                parent, 2, 1);

        // Create expression Text box
        final StyledText expressionTextBox = new StyledText(textComposite, SWT.SINGLE);
        expressionTextBox.setBackground(new Color(null, 255, 255, 255));
        expressionTextBox.addLineStyleListener(new LineStyleListener() {
            public void lineGetStyle(LineStyleEvent e) {
                // Set the line number
                e.bulletIndex = expressionTextBox.getLineAtOffset(e.lineOffset);

                // Set the style, 12 pixles wide for each digit
                StyleRange style = new StyleRange();
                Device device = Display.getCurrent();
                final RGB LINE_NUMBER_FG = new RGB(185, 193, 196);

                style.foreground = new Color(device, LINE_NUMBER_FG);
                GC gc = new GC(expressionTextBox);
                Point textExtent = gc.stringExtent(EEFPropertyConstants.EXPRESSION_TEXTBOX_PREFIX);
                gc.dispose();
                style.metrics = new GlyphMetrics(0, 0, textExtent.x);

                e.bullet = new Bullet(ST.BULLET_TEXT, style);
                e.bullet.text = EEFPropertyConstants.EXPRESSION_TEXTBOX_PREFIX;

            }
        });
        expressionTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        expressionTextBox.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        expressionTextBox.setLayoutData(configRefData);
        expressionTextBox.addKeyListener(new KeyAdapter() {
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((StyledText) e.getSource()).getData();
                    setParameterType(RuleOptionType.EXPRESSION, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((StyledText) e.getSource())
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    setExpressionValue(ctp, expressionTextBox.getText());
                    updateModel(ctp, expressionTextBox, uiSchemaValue);
                }
            }
        });

        // Create Expression Dialog Box Button
        // Button expressionDialogBoxButton = widgetFactory.createButton(textComposite, "", SWT.PUSH);
        Button expressionDialogBoxButton = new Button(textComposite, SWT.PUSH);

        Image expressionDialogBoxButtonImage = null;
        try {
            expressionDialogBoxButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_DIALOG_BOX_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionDialogBoxButton.setImage(expressionDialogBoxButtonImage);
        expressionDialogBoxButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) expressionTextBox.getData();
                    boolean saved = openValueExpressionWidgetNamespacedPropertyEditor(parent, expressionTextBox,
                            ctp.getParameterExpression());
                    if (saved) { // update only if the value is saved
                        setParameterType(RuleOptionType.EXPRESSION, ctp);
                        AttributeValue uiSchemaValue = (AttributeValue) expressionTextBox
                                .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                        updateModel(ctp, expressionTextBox, uiSchemaValue);
                    }
                }
            }
        });
        setItemFocus(expressionTextBox);
        // Register created widget in notify lists
        controlList.put(jsonSchemaObject.getName() + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX, expressionTextBox);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName() + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX,
                    expressionTextBox);
        }
        return textComposite;
    }

    /**
     * Creates connection field for the config Ref
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @param options          options array for drop down menu
     * @return Composite
     */
    public Composite createConnectionField(final FormToolkit widgetFactory, final Composite parent,
                                           final AttributeValue jsonSchemaObject, String[] options) {
        // Fetch images for add and edit connection buttons
        Image newElementImage = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");
        Image deleteElementImage = null;
        try {
            deleteElementImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.CONNECTION_EDIT_ELEMENT_IMG));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }

        // Create composite with 4 elements
        Composite textBoxComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 4, 4);

        // Create label
        Label connectionLabel = new Label(textBoxComposite, SWT.TRANSPARENT | SWT.WRAP);
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        connectionLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        connectionLabel.setLayoutData(labelRefData);
        setToolTip(connectionLabel, jsonSchemaObject.getHelpTip());

        // Create connection combo box
        final Combo connectionComboBox = new Combo(textBoxComposite, SWT.READ_ONLY | SWT.DROP_DOWN);
        connectionComboBox.setItems(options);
        connectionComboBox.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        connectionComboBox.setLayoutData(configRefData);

        // Create Add Connection Button
        Button addConnectionButton = widgetFactory.createButton(textBoxComposite, "", SWT.PUSH | SWT.TRANSPARENT);
        addConnectionButton.setImage(newElementImage);
        addConnectionButton.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(Event event) {

                if (!isConnectionWidgetProvider) {
                    openConnectionEditor(widgetFactory, parent, connectionComboBox, null, jsonSchemaObject);
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                            EsbViewsRepository.CloudConnectorOperation.Properties.configRef,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                            connectionComboBox.getText()));
                    checkRequired();
                }

            }
        });

        // Create edit connection button
        final Button editConnectionButton =
                widgetFactory.createButton(textBoxComposite, "",
                        SWT.PUSH | SWT.TRANSPARENT);
        editConnectionButton.setImage(deleteElementImage);
        editConnectionButton.setEnabled(false);
        editConnectionButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {

                openConnectionUpdateEditor(widgetFactory, parent, connectionComboBox, null, jsonSchemaObject);
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                        EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.EDIT, null, connectionComboBox.getText()));
            }
        });

        // Add connection combo box selection listener
        connectionComboBox.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {

                if (!isConnectionWidgetProvider) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                            EsbViewsRepository.CloudConnectorOperation.Properties.configRef,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                            connectionComboBox.getText()));
                    checkRequired();
                }

                if (!connectionComboBox.getText().isEmpty()) {
                    editConnectionButton.setEnabled(true);
                } else {
                    editConnectionButton.setEnabled(false);
                }
            }
        });

        // Register created widget in notify lists
        setItemFocus(connectionComboBox);
        controlList.put(jsonSchemaObject.getName(), connectionComboBox);
        connectionComboBox.setData("editConnectionButton", editConnectionButton);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), connectionComboBox);
        }
        return parent;
    }

    /**
     * Creates composite with text area
     *
     * @param widgetFactory    widget factory instance
     * @param parent           parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return Composite
     */
    public Composite createTextAreaFieldWithButton(FormToolkit widgetFactory, final Composite parent,
                                                   AttributeValue jsonSchemaObject) {
        // Create composite with 3 elements
        Composite textAreaComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 3, 3);

        // Create label
        Label propertyLabel = new Label(textAreaComposite, SWT.TRANSPARENT | SWT.WRAP);
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        propertyLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        propertyLabel.setLayoutData(labelRefData);
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());

        // Create expression Button
        Button expressionButton = new Button(textAreaComposite, SWT.TOGGLE);
        Image expressionButtonImage = null;
        try {
            expressionButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionButton.setImage(expressionButtonImage);

        // Create Text Area
        final Text valueTextArea = widgetFactory.createText(textAreaComposite, "",
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        valueTextArea.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        valueTextArea.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);
        GridData configRefData = new GridData(GridData.FILL_BOTH);
        configRefData.heightHint = EEFPropertyConstants.TEXT_AREA_DEFAULT_HEIGHT;
        valueTextArea.setLayoutData(configRefData);
        valueTextArea.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             *
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {

                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource())
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, valueTextArea, uiSchemaValue);
                }
            }
        });

        // Create Expression Composite
        final Composite expressionComposite = createExpressionComposite(jsonSchemaObject.getName(), widgetFactory,
                textAreaComposite, jsonSchemaObject);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true;

        // Bind events to toggle button
        expressionButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                Button source = (Button) e.getSource();

                if (source.getSelection()) {
                    valueTextArea.setVisible(false);
                    ((GridData) valueTextArea.getLayoutData()).exclude = true;
                    expressionComposite.setVisible(true);
                    ((GridData) expressionComposite.getLayoutData()).exclude = false;
                    CallTemplateParameter ctp = (CallTemplateParameter) valueTextArea.getData();
                    parent.layout();
                    setParameterType(RuleOptionType.EXPRESSION, ctp);
                } else {
                    valueTextArea.setVisible(true);
                    ((GridData) valueTextArea.getLayoutData()).exclude = false;
                    expressionComposite.setVisible(false);
                    ((GridData) expressionComposite.getLayoutData()).exclude = true;
                    CallTemplateParameter ctp = (CallTemplateParameter) valueTextArea.getData();
                    parent.layout();
                    setParameterType(RuleOptionType.VALUE, ctp);
                }

            }
        });
        valueTextArea.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionButton);

        // Register created widget in notify lists
        setItemFocus(valueTextArea);
        controlList.put(jsonSchemaObject.getName(), valueTextArea);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueTextArea);
        }
        return parent;
    }

    public Composite createCheckBoxField(FormToolkit widgetFactory, Composite parent, String Label, String[] options,
                                         String id) {

        Composite textBoxComposite = createComposite(id, widgetFactory, parent, options.length + 1, options.length + 1);
        Label label = new Label(textBoxComposite, SWT.TRANSPARENT | SWT.WRAP);
        label.setText(Label);
        GridData configRefDatass = new GridData(GridData.FILL_HORIZONTAL);
        label.setLayoutData(configRefDatass);
        for (String option : options) {
            Button configRef = widgetFactory.createButton(textBoxComposite, option, SWT.CHECK);
            configRef.setText(option);
            GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
            configRef.setLayoutData(configRefData);
        }
        return parent;
    }

    /**
     * Creates Table field for type KeyValueTable
     * 
     * @param widgetFactory widget factory instance
     * @param parent parent composite
     * @param jsonSchemaObject JSONSchema object of the property
     * @return Composite
     */
    public Composite createKeyValueTable(FormToolkit widgetFactory, final Composite parent, AttributeValue jsonSchemaObject) {
        // Create composite with 3 elements
        Composite tableComposite = createComposite(jsonSchemaObject.getName(), widgetFactory, parent, 3, 3);

        // Create label
        Label propertyLabel = new Label(tableComposite, SWT.TRANSPARENT | SWT.WRAP);
        String displayName = jsonSchemaObject.getDisplayName();
        if (jsonSchemaObject.getRequired()) {
            displayName = displayName.concat(EEFPropertyConstants.REQUIRED_FIELD_INDICATOR);
        }
        propertyLabel.setText(displayName + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = EEFPropertyConstants.LABEL_WIDTH;
        propertyLabel.setLayoutData(labelRefData);
        setToolTip(propertyLabel, jsonSchemaObject.getHelpTip());

        // Create expression Button
        Button expressionButton = new Button(tableComposite, SWT.TOGGLE);
        Image expressionButtonImage = null;
        try {
            expressionButtonImage = new Image(parent.getShell().getDisplay(),
                    EEFPropertyViewUtil.getIconPath(EEFPropertyConstants.EXPRESSION_TOGGLE_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionButton.setImage(expressionButtonImage);

        // Create table (uses a new composite since its a complex widget)
        final Composite composite = createComposite(jsonSchemaObject.getName(), widgetFactory, tableComposite, 2, 1);
        Button addButton = widgetFactory.createButton(composite, "", SWT.PUSH);
        addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
        Button removeButton = widgetFactory.createButton(composite, "", SWT.PUSH);
        removeButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));

        final Table valueTable = new Table(composite, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        valueTable.setHeaderVisible(true);
        valueTable.setLinesVisible(true);
        GridLayout tableLayout = new GridLayout();
        tableLayout.numColumns = 2;
        tableLayout.marginLeft = 0;
        composite.setLayout(tableLayout);
        GridData tableCompositeLayoutData = new GridData(GridData.FILL_HORIZONTAL);
        tableCompositeLayoutData.grabExcessHorizontalSpace = true;
        tableCompositeLayoutData.grabExcessVerticalSpace = false;
        tableCompositeLayoutData.horizontalSpan = 1;
        tableCompositeLayoutData.verticalSpan = 1;
        composite.setLayoutData(tableCompositeLayoutData);
        GridData tableLayoutData = new GridData(GridData.FILL_HORIZONTAL);
        tableLayoutData.heightHint = 100;
        tableLayoutData.minimumHeight = 100;
        tableLayoutData.widthHint = 600;
        tableLayoutData.minimumWidth = 600;
        tableLayoutData.grabExcessHorizontalSpace = true;
        tableLayoutData.grabExcessVerticalSpace = false;
        tableLayoutData.horizontalSpan = 1;
        tableLayoutData.verticalSpan = 1;
        valueTable.setLayoutData(tableLayoutData);

        // Populate Table
        final List<KeyValueTableColumn> kColumns = jsonSchemaObject.getColumns();

        for (KeyValueTableColumn kColumn : kColumns) {
            TableColumn keyColumn = new TableColumn(valueTable, SWT.NULL);
            keyColumn.setText(kColumn.getName());
            keyColumn.setWidth(380);
            keyColumn.setData(EEFPropertyConstants.JSON_COLUMN_WIDGET_DATA, kColumn);
        }

        Image addButtonImage = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");
        addButton.setImage(addButtonImage);
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int i = 0;
                TableItem item = new TableItem(valueTable, SWT.NULL);
                //item.setText(0, "Item " + valueTable.getItemCount());
                List<Control> controlList = new ArrayList<Control>();

                for (KeyValueTableColumn valueColumn : kColumns) {
                    TableEditor te = new TableEditor(valueTable);
                    Control innerControl = null;

                    if (DescriptorConstants.COMBO_STRING.equals(valueColumn.getType())) {
                        innerControl = new Combo(valueTable, SWT.DROP_DOWN | SWT.READ_ONLY);
                        ((Combo) innerControl).setItems(valueColumn.getAllowedValues().toArray(new String[] {}));
                        ((Combo) innerControl).select(0);
                        ((Combo) innerControl).addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent event) {
                                if (!isConnectionWidgetProvider) { // update model
                                    CallTemplateParameter ctp = (CallTemplateParameter) (valueTable).getData();
                                    setParameterType(RuleOptionType.VALUE, ctp);
                                    AttributeValue uiSchemaValue = (AttributeValue) (valueTable)
                                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                    updateModel(ctp, valueTable, uiSchemaValue);
                                }
                            }
                        });
                    } else if (DescriptorConstants.TEXT_STRING.equals(valueColumn.getType())) {
                        innerControl = new Text(valueTable, SWT.NONE);
                        ((Text) innerControl).addKeyListener(new KeyAdapter() {
                            /**
                             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
                             * 
                             */
                            @Override
                            @SuppressWarnings("synthetic-access")
                            public void keyReleased(KeyEvent e) {
                                if (!isConnectionWidgetProvider) { // update model
                                    CallTemplateParameter ctp = (CallTemplateParameter) (valueTable).getData();
                                    setParameterType(RuleOptionType.VALUE, ctp);
                                    AttributeValue uiSchemaValue = (AttributeValue) (valueTable)
                                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                    updateModel(ctp, valueTable, uiSchemaValue);
                                }
                            }
                        });
                    }
                    innerControl.computeSize(SWT.DEFAULT, valueTable.getItemHeight());

                    // Set attributes of the editor
                    te.grabHorizontal = true;
                    te.minimumHeight = innerControl.getSize().y;
                    te.minimumWidth = innerControl.getSize().x;

                    te.setEditor(innerControl, item, i);
                    i++;
                    controlList.add(innerControl);
                }
                item.setData(EEFPropertyConstants.CONTROL_LIST_WIDGET_DATA, controlList);
            }
        });

        Image removeButtonImage = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Delete_16x16.gif");
        removeButton.setImage(removeButtonImage);
        removeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                final TableItem[] items = valueTable.getItems();
                List<Integer> removableIndices = new ArrayList<Integer>();

                for (int i = 0; i < items.length; i++) {
                    if (items[i].getChecked()) {
                        removableIndices.add(i);
                    }
                }

                for (int index : removableIndices) {
                    List<Control> controlList = (List<Control>) valueTable.getItem(index)
                            .getData(EEFPropertyConstants.CONTROL_LIST_WIDGET_DATA);
                    for (Control control : controlList) {
                        control.dispose(); // dispose inner controls in table columns
                    }
                }
                valueTable.remove(ArrayUtils.toPrimitive(removableIndices.toArray(new Integer[removableIndices.size()]))); // remove table rows
                // valueTable.remove(valueTable.getSelectionIndices()); uncomment to remove selected indices too
                if (!isConnectionWidgetProvider) { // update model
                    CallTemplateParameter ctp = (CallTemplateParameter) (valueTable).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) (valueTable)
                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, valueTable, uiSchemaValue);
                }
            }
        });

        valueTable.addListener(SWT.MeasureItem, new Listener() {
            public void handleEvent(Event event) {
                event.height = 20; // Adjust table item height accordingly
            }
        });
        valueTable.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        valueTable.setData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY, jsonSchemaObject);

        // Create Expression Composite
        final Composite expressionComposite = createExpressionComposite(jsonSchemaObject.getName(), widgetFactory,
                tableComposite, jsonSchemaObject);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true;

        // Bind events to toggle button
        expressionButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();

                if (source.getSelection()) {
                    composite.setVisible(false);
                    ((GridData) composite.getLayoutData()).exclude = true;
                    expressionComposite.setVisible(true);
                    ((GridData) expressionComposite.getLayoutData()).exclude = false;
                    CallTemplateParameter ctp = (CallTemplateParameter) valueTable.getData();
                    parent.layout();
                    setParameterType(RuleOptionType.EXPRESSION, ctp);
                } else {
                    composite.setVisible(true);
                    ((GridData) composite.getLayoutData()).exclude = false;
                    expressionComposite.setVisible(false);
                    ((GridData) expressionComposite.getLayoutData()).exclude = true;
                    CallTemplateParameter ctp = (CallTemplateParameter) valueTable.getData();
                    parent.layout();
                    setParameterType(RuleOptionType.VALUE, ctp);
                }

            }
        });
        valueTable.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionButton);
        valueTable.setData(EEFPropertyConstants.JSON_OBJECT_WIDGET_DATA, expressionButton);
        // Register created widget in notify lists
        setItemFocus(valueTable);
        controlList.put(jsonSchemaObject.getName(), valueTable);
        if (jsonSchemaObject.getRequired()) {
            requiredList.put(jsonSchemaObject.getName(), valueTable);
        }
        return parent;
    }

    /**
     * Creates composite with fixed(2) number of columns
     *
     * @param widgetFactory widgetFactory instance
     * @param parent        parent composite
     * @return Composite
     */
    public Composite createComposite(FormToolkit widgetFactory, Composite parent) {

        Composite composite = widgetFactory.createComposite(parent);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 2;
        propertiesGroupLayout.marginLeft = 15;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 0;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        composite.setLayoutData(propertiesSectionData);
        return composite;

    }

    /**
     * Creates composite with given number of columns and span
     *
     * @param id            Field name of the property
     * @param widgetFactory widgetFactory instance
     * @param parent        parent composite
     * @param columns       number of columns of the field
     * @param span          span of the field
     * @return composite
     */
    public Composite createComposite(String id, FormToolkit widgetFactory, Composite parent, int columns, int span) {

        Composite composite = widgetFactory.createComposite(parent, SWT.TRANSPARENT);
        composite.setBackground(new Color(parent.getShell().getDisplay(), 245, 245, 245));
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = columns;
        propertiesGroupLayout.marginLeft = 0;
        propertiesGroupLayout.horizontalSpacing = 10;
        propertiesGroupLayout.verticalSpacing = 0;
        propertiesGroupLayout.marginHeight = 1;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = span;
        composite.setLayoutData(propertiesSectionData);
        compositeList.put(id, composite);
        return composite;

    }

    //////////////// Dialog Box open methods////////////////////

    /**
     * Open expression dialog box
     *
     * @param parent              parent
     * @param valueExpressionText expression text box
     * @param valueExpression     Name spaced property instance
     * @return
     */
    public boolean openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent,
                                                                     Control valueExpressionText,
                                                                     NamespacedProperty valueExpression) {

        if (valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
            ((CallTemplateParameter) valueExpressionText.getData()).setParameterExpression(valueExpression);
        }
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        if (nspd.isSaved()) {
            if (valueExpressionText instanceof Text) {
                ((Text) valueExpressionText).setText(valueExpression.getPropertyValue());
            } else if (valueExpressionText instanceof Combo) {
                ((Combo) valueExpressionText).setText(valueExpression.getPropertyValue());
            }
        }
        return nspd.isSaved();
    }

    /**
     * Open add connection dialog box
     *
     * @param widgetFactory        widgetFactory instance
     * @param parent               parent composite
     * @param valueExpressionCombo connection selector combo box
     * @param valueExpression      Namespaced property object
     * @param jsonSchemaObject     json Shema UI object
     */
    public void openConnectionEditor(FormToolkit widgetFactory, final Composite parent, Combo valueExpressionCombo,
                                     NamespacedProperty valueExpression, AttributeValue jsonSchemaObject) {
        // Get connector semantic object from component
        CloudConnectorOperationImpl connectorObject = (CloudConnectorOperationImpl) propertiesEditionComponent
                .getEditingContext().getEObject();
        String connectorName = connectorObject.getConnectorName()
                .split(EEFPropertyConstants.ECORE_CONNECTOR_NAME_SUFFIX)[0]; // Ecore connector name has connector
        // suffix
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        ConnectionParameterWizard wizard = new ConnectionParameterWizard(widgetFactory, connectorName,
                valueExpressionCombo, jsonSchemaObject);
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog connectionWizard = new WizardDialog(window.getShell(), wizard);
        connectionWizard.setHelpAvailable(false);
        connectionWizard.setPageSize(550, 460);
        connectionWizard.open();
    }

    /**
     * Open edit connection dialog box
     *
     * @param widgetFactory        widgetFactory instance
     * @param parent               parent composite
     * @param valueExpressionCombo connection selector combo box
     * @param valueExpression      Namespaced property object
     * @param jsonSchemaObject     json Shema UI object
     */
    public void openConnectionUpdateEditor(FormToolkit widgetFactory, final Composite parent,
                                           Combo valueExpressionCombo, NamespacedProperty valueExpression,
                                           AttributeValue value) {
        // Get connector semantic object from component
        CloudConnectorOperationImpl connectorObject = (CloudConnectorOperationImpl) propertiesEditionComponent
                .getEditingContext().getEObject();
        String connectorName = connectorObject.getConnectorName()
                .split(EEFPropertyConstants.ECORE_CONNECTOR_NAME_SUFFIX)[0]; // Ecore connector name has connector
        // suffix
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        ConnectionParameterWizard wizard = new ConnectionParameterWizard(widgetFactory, connectorName,
                valueExpressionCombo.getText(), value);
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog connectionWizard = new WizardDialog(window.getShell(), wizard);
        connectionWizard.setHelpAvailable(false);
        connectionWizard.setPageSize(550, 460);
        connectionWizard.open();
    }

    //////////////// Widget util Methods////////////////////////

    /**
     * Update parameter type to VALUE or EXPRESSION
     *
     * @param ruleType parameter type value/expression
     * @param ctp      Call template param
     */
    public static void setParameterType(final RuleOptionType ruleType, final CallTemplateParameter ctp) {

        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ctp);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

            @Override
            protected void doExecute() {

                ctp.setTemplateParameterType(ruleType);
            }
        });
    }

    /**
     * Set value of expression, this will not change the namespace of the expr
     *
     * @param ctp   Calltemplate parameter
     * @param value local value
     */
    public void setExpressionValue(final CallTemplateParameter ctp, final String value) {

        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ctp);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

            @Override
            protected void doExecute() {

                ctp.getParameterExpression().setPropertyValue(value);
            }
        });
    }

    /**
     * Add a tooltip to the control
     *
     * @param control Control which tool tip should be added
     * @param text    tooltip message
     */
    public void setToolTip(Control control, String text) {

        final ToolTip tip = new ToolTip(control.getShell(), SWT.BALLOON);
        tip.setMessage(text);
        tip.setAutoHide(true);
        control.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {

                Control actionWidget = (Control) e.widget;
                Point loc = actionWidget.toDisplay(actionWidget.getLocation());
                tip.setLocation(loc.x + actionWidget.getSize().x - actionWidget.getBorderWidth(), loc.y);
                tip.setVisible(true);
            }

            @Override
            public void mouseDown(MouseEvent e) {

            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {

            }
        });

    }

    public void setItemFocus(final Control control) {

        control.addFocusListener(new org.eclipse.swt.events.FocusListener() {

            @Override
            public void focusLost(org.eclipse.swt.events.FocusEvent e) {

            }

            @Override
            public void focusGained(org.eclipse.swt.events.FocusEvent e) {

                control.setFocus();

            }
        });
    }

    /**
     * update ecore model
     *
     * @param ctp           call template param
     * @param targetControl updated control
     * @param uiSchameValue uischema object
     */
    public void updateModel(CallTemplateParameter ctp, Control targetControl, AttributeValue uiSchameValue) {

        String value = "";
        if (targetControl instanceof Text) {
            value = ((Text) targetControl).getText();
        } else if (targetControl instanceof Combo) {
            value = ((Combo) targetControl).getText();
        } else if (targetControl instanceof Table) {
            try {
                value = serializeKeyValueTable((Table)targetControl);
            } catch (JSONException e) {
                log.error("Could not serialize table to JSON array", e);
            }
        }
        if (validateValue(uiSchameValue.getValidation(), value, uiSchameValue.getRequired(),
                uiSchameValue.getDisplayName())) {
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                    EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters,
                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, ctp, value));
        }
    }

    public boolean validateValue(String regex, String value, boolean required, String fieldName) {
        // Do required validation
        checkRequired();
        if (StringUtils.isEmpty(regex)) {
            return true;
        }
        // Do xpath validation
        boolean result = Pattern.matches(regex, value);
        if (!result) {
            updateBanner("regexerror", "", fieldName, regex);
            return false;
        }
        updateBanner("ok", "", fieldName, regex);
        return true;
    }

    public void checkRequired() {

        boolean isError = false;
        String fieldName = "";
        for (String key : requiredList.keySet()) {
            if (!key.contains(EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX)) {
                Control control = requiredList.get(key);
                Control expControl = requiredList.get(key + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX);
                if (control instanceof Text) {
                    String value = ((Text) control).getText();
                    if ((value == null || value.isEmpty())) {
                        if (expControl != null) {
                            String expValue = ((StyledText) expControl).getText();
                            if ((expValue == null || expValue.isEmpty())) {
                                isError = true;
                                AttributeValue va = (AttributeValue) control
                                        .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                fieldName = va.getDisplayName();
                            }
                        } else {
                            isError = true;
                            AttributeValue va = (AttributeValue) control
                                    .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                            fieldName = va.getDisplayName();
                        }
                    }
                } else if (control instanceof Combo) {
                    String value = ((Combo) control).getText();
                    if ((value == null || value.isEmpty())) {
                        if (expControl != null) {
                            String expValue = ((StyledText) expControl).getText();
                            if ((expValue == null || expValue.isEmpty())) {
                                isError = true;
                                AttributeValue va = (AttributeValue) control
                                        .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                fieldName = va.getDisplayName();
                            }
                        } else {
                            isError = true;
                            AttributeValue va = (AttributeValue) control
                                    .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                            fieldName = va.getDisplayName();
                        }
                    }
                }
            }

        }
        if (isError) {
            updateBanner("requirederror", "", fieldName, "");
        } else {
            updateBanner("ok", "", fieldName, "");
        }
    }

    public void updateBanner(String kind, String message, String field, String regex) {

        try {
            ((CloudConnectorOperationPropertiesEditionPartForm) partForm).updateMessage(kind, message, field, regex);
        } catch (URISyntaxException | IOException e) {
            log.error("Error updating message banner", e);
        }
    }

    /**
     * Deserializes Key Value table json string. The parameter in KeyValueTable type holds a json
     * in below structure(If 2 columns are defined).
     * [{"column1Name":"Row1ValueForColumn1","column2Name":"Row1ValueForColumn2"},
     * {"column1Name":"Row2ValueForColumn1","column2Name":"Row2ValueForColumn2"}]
     * @param json Json string
     * @param table Table which the data should be added
     * @throws JSONException if json string isn't parseable
     */
    public void deserializeKeyValueTableJson(String json, final Table table) throws JSONException {

        JSONArray tableJsonArray = new JSONArray("[]");
        if(json != null && !json.isEmpty()) {
            tableJsonArray = new JSONArray(json);
        }
        for (TableItem tableItem : table.getItems()) {
            List<Control> tempControlList = (ArrayList<Control>) tableItem
                    .getData(EEFPropertyConstants.CONTROL_LIST_WIDGET_DATA);
            for (Control control : tempControlList) {
                control.dispose();
            }
        }
        table.removeAll(); // Clean the table before refilling

        for (int i = 0; i < tableJsonArray.length(); i++) {
            JSONObject tableRowJsonObject = tableJsonArray.getJSONObject(i);
            TableItem tableItem = new TableItem(table, SWT.NULL);
            tableItem.setText(0, "Item " + table.getItemCount());
            Iterator<String> keys = tableRowJsonObject.keys();
            int j = 0;
            List<Control> controlList = new ArrayList<Control>();

            while (keys.hasNext()) {
                String key = keys.next();

                if (tableRowJsonObject.get(key) instanceof String) {
                    TableColumn tableColumn = EEFPropertyViewUtil.getColumnByName(table, key);
                    KeyValueTableColumn jsonColumn = (KeyValueTableColumn) tableColumn
                            .getData(EEFPropertyConstants.JSON_COLUMN_WIDGET_DATA);
                    TableEditor te = new TableEditor(table);
                    Control innerControl = null;

                    if (DescriptorConstants.COMBO_STRING.equals(jsonColumn.getType())) {
                        innerControl = new Combo(table, SWT.DROP_DOWN | SWT.READ_ONLY);
                        ((Combo) innerControl).setItems(jsonColumn.getAllowedValues().toArray(new String[] {}));
                        ((Combo) innerControl).setText(tableRowJsonObject.get(key).toString());
                        ((Combo) innerControl).addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent event) {
                                if (!isConnectionWidgetProvider) { //update model
                                    CallTemplateParameter ctp = (CallTemplateParameter) (table).getData();
                                    setParameterType(RuleOptionType.VALUE, ctp);
                                    AttributeValue uiSchemaValue = (AttributeValue) (table)
                                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                    updateModel(ctp, table, uiSchemaValue);
                                }
                            }
                        });
                    } else if (DescriptorConstants.TEXT_STRING.equals(jsonColumn.getType())) {
                        innerControl = new Text(table, SWT.NONE);
                        ((Text) innerControl).setText(tableRowJsonObject.get(key).toString());
                        ((Text) innerControl).addKeyListener(new KeyAdapter() {
                            /**
                             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
                             * 
                             */
                            @Override
                            @SuppressWarnings("synthetic-access")
                            public void keyReleased(KeyEvent e) {
                                if (!isConnectionWidgetProvider) { //update model
                                    CallTemplateParameter ctp = (CallTemplateParameter) (table).getData();
                                    setParameterType(RuleOptionType.VALUE, ctp);
                                    AttributeValue uiSchemaValue = (AttributeValue) (table)
                                            .getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
                                    updateModel(ctp, table, uiSchemaValue);
                                }
                            }
                        });
                    }
                    innerControl.computeSize(SWT.DEFAULT, table.getItemHeight());

                    // Set attributes of the editor
                    te.grabHorizontal = true;
                    te.minimumHeight = innerControl.getSize().y;
                    te.minimumWidth = innerControl.getSize().x;
                    te.setEditor(innerControl, tableItem, j);
                    controlList.add(innerControl);
                    j++;
                }
            }
            tableItem.setData(EEFPropertyConstants.CONTROL_LIST_WIDGET_DATA, controlList); //notify item control list
        }
    }

    /**
     * Serializes Key Value Table and produce a json String
     * @param keyValueTable table widget
     * @return JSONString
     * @throws JSONException
     */
    public String serializeKeyValueTable(Table keyValueTable) throws JSONException {
        final TableItem[] items = keyValueTable.getItems();
        JSONArray jsonArray = new JSONArray();
        String[] columnNames = new String[keyValueTable.getColumnCount()];

        for (int i = 0; i < columnNames.length; i++) { // get columns names
            columnNames[i] = keyValueTable.getColumn(i).getText();
        }

        for (int j = 0; j < items.length; j++) {
            TableItem item = items[j];
            JSONObject row = new JSONObject();
            List<Control> controlList = (List<Control>) item.getData(EEFPropertyConstants.CONTROL_LIST_WIDGET_DATA);
            for (int i = 0; i < controlList.size(); i++) {
                Control control = controlList.get(i);
                // gettext according to control
                String value = "";
                if (control instanceof Combo) {
                    value = ((Combo) control).getText();
                } else if (control instanceof Text) {
                    value = ((Text) control).getText();
                }
                row.put(columnNames[i], value);
            }

            jsonArray.put(j, row);
        }
        return jsonArray.toString();
    }

    /**
     * Add the attribute to temporary queue if there are more attributes than MAX_ALLOWED_ATTRTIBUTES
     * 
     * @param widgetFactory widget factory to save
     * @param parent parent for the attribute
     * @param value the attribute value to save in the queue
     */
    public void addToAttributeQueue(FormToolkit widgetFactory, Composite parent, AttributeValue value) {
        AttributeConstuctionElement tmpElement = new AttributeConstuctionElement(widgetFactory, parent, value);
        attributeQueue.put(value.getName(), tmpElement);
    }

    /**
     * Load the attribute to the properties pane from the queue
     * 
     * @param attributeName name of the attribute to retrieve from the queue of attributes
     * 
     */
    public void loadAttributeFromQueue(String attributeName) {
        AttributeConstuctionElement attElem = attributeQueue.get(attributeName);
        if (attElem != null) {

            FormToolkit widgetFactory = attElem.getWidgetFactory();
            Composite parent = attElem.getParent();
            AttributeValue value = attElem.getValue();

            if (AttributeValueType.STRING.equals(value.getType())) {
                createTextBoxFieldWithButton(widgetFactory, parent, value);

            } else if (AttributeValueType.BOOLEANOREXPRESSION.equals(value.getType())) {
                createDropDownField(widgetFactory, parent, new String[] { "true", "false" }, value);
            } else if (AttributeValueType.COMBO.equals(value.getType())) {
                createDropDownField(widgetFactory, parent, value.getComboValues().toArray(new String[0]), value);
            } else if (AttributeValueType.TEXTAREAOREXPRESSION.equals(value.getType())) {
                createTextAreaFieldWithButton(widgetFactory, parent, value);
            } else if (AttributeValueType.PASSWORDTEXTOREXPRESSION.equals(value.getType())) {
                createPasswordTextBoxFieldWithButton(widgetFactory, parent, value);
            } else if (AttributeValueType.SEARCHBOX.equals(value.getType())) {
                createSearchBoxFieldWithButton(widgetFactory, parent, value);
            } else if (AttributeValueType.KEYVALUETABLE.equals(value.getType())) {
                createKeyValueTable(widgetFactory, parent, value);
            }
        }
    }

}
