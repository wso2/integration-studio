/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

 package org.wso2.integrationstudio.esb.form.editors.ui.widgets;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.ViewerFilter;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ValueExpressionWidgetNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.gmf.esb.util.FontUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class CompositeElements {
    public static final String EXPRESSION_TEXT_BOX = "expressiontextbox";
    public static final String KEY_TEXT_BOX = "keytextbox";
    public static final String VALUE_TEXT_BOX = "valuetextbox";
    public static final String EXPRESSION_TOGGLE_BUTTON_IMAGE = "icons/expression_toggle_button_image.png";
    public static final String EXPRESSION_DIALOG_BOX_BUTTON_IMAGE = "icons/expression_dialog_box_button_image.png";
    public static final String EXPRESSION_TEXTBOX_PREFIX = " expression: ";
    public static final String EXPRESSION_TOGGLE_BUTTON = "associatedbutton";
    public static final String REMOVE_ITEM_BUTTON = "removeitembutton";
    public static final String EXPRESSION_COMPOSITE = "expressioncomposite";
    public static final String PLUGIN_ID = "org.wso2.integrationstudio.esb.form.editors";
    private static IIntegrationStudioLog log = Logger.getLog(PLUGIN_ID);

    /**
     * Creates textBox field with button(Expression supported)
     * 
     * @param widgetFactory widget Factory
     * @param parent parent composite
     * @param updatedField updated value field
     * @param updatedFieldExpression updated expression field
     * @param updateFieldType updated type field
     * @return composite which contains the expression supported field
     */
    public static Composite createTextBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
            NamespacedProperty namespacedProperty) {

        if (namespacedProperty == null) {
            namespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Create wrapping composite of 3 elements
        Composite textBoxComposite = createComposite(widgetFactory, parent, 3, 3);

        // Create expression toggle button
        Button expressionToggleButton = new Button(textBoxComposite, SWT.TOGGLE);
        Image expressionToggleButtonImage = null;
        try {
            expressionToggleButtonImage = new Image(parent.getShell().getDisplay(),
                    getIconPath(EXPRESSION_TOGGLE_BUTTON_IMAGE));
            expressionToggleButton.setImage(expressionToggleButtonImage);
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }

        // Create Text box widget
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        valueTextBox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // Create expression composite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(widgetFactory, textBoxComposite,
                namespacedProperty);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // Hide the expression composite first

        StyledText expressionTextBox = (StyledText) expressionComposite.getData(EXPRESSION_TEXT_BOX);

        // Bind toggle button events
        expressionToggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) { // If pressed
                    // Hide value text box
                    valueTextBox.setVisible(false);
                    ((GridData) valueTextBox.getLayoutData()).exclude = true;
                    // Show expression composite
                    expressionComposite.setVisible(true);
                    ((GridData) expressionComposite.getLayoutData()).exclude = false;
                } else {
                    // Show value text box
                    valueTextBox.setVisible(true);
                    ((GridData) valueTextBox.getLayoutData()).exclude = false;
                    // Hide expression composite
                    expressionComposite.setVisible(false);
                    ((GridData) expressionComposite.getLayoutData()).exclude = true;
                }
                parent.layout();
            }
        });
        // Set control widgets as data of parent composite
        textBoxComposite.setData(EXPRESSION_TOGGLE_BUTTON, expressionToggleButton); // Add associated button
        textBoxComposite.setData(EXPRESSION_TEXT_BOX, expressionTextBox);
        textBoxComposite.setData(VALUE_TEXT_BOX, valueTextBox);
        textBoxComposite.setData(EXPRESSION_COMPOSITE, expressionComposite);;
        return textBoxComposite;
    }

    /**
     * Creates expression sub composite
     * 
     * @param widgetFactory widget factory
     * @param parent parent composite
     * @param updatedField
     * @return expression composite
     */
    public static Composite createExpressionComposite(FormToolkit widgetFactory, final Composite parent,
            NamespacedProperty namespacedProperty) {
        // Create wrapping composite of 2 elements and 1 span
        Composite textComposite = createComposite(widgetFactory, parent, 2, 1);

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
                Point textExtent = gc.stringExtent(EXPRESSION_TEXTBOX_PREFIX);
                gc.dispose();
                style.metrics = new GlyphMetrics(0, 0, textExtent.x);

                e.bullet = new Bullet(ST.BULLET_TEXT, style);
                e.bullet.text = EXPRESSION_TEXTBOX_PREFIX;

            }
        });
        expressionTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        expressionTextBox.setLayoutData(configRefData);

        // Create Expression Dialog Box Button
        Button expressionDialogBoxButton = new Button(textComposite, SWT.PUSH);

        Image expressionDialogBoxButtonImage = null;
        try {
            expressionDialogBoxButtonImage = new Image(parent.getShell().getDisplay(),
                    getIconPath(EXPRESSION_DIALOG_BOX_BUTTON_IMAGE));
        } catch (URISyntaxException | IOException e1) {
            log.error("Couldn't fetch property field icon", e1);
        }
        expressionDialogBoxButton.setImage(expressionDialogBoxButtonImage);
        expressionDialogBoxButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                namespacedProperty.setPropertyValue(expressionTextBox.getText());
                boolean saved = openValueExpressionWidgetNamespacedPropertyEditor(parent, namespacedProperty);
                if (saved) { // update only if the value is saved
                    expressionTextBox.setText(namespacedProperty.getPropertyValue());
                }
            }
        });

        textComposite.setData(EXPRESSION_TEXT_BOX, expressionTextBox); // Add associated button
        return textComposite;
    }

    /**
     * Creates composite with given number of columns and span
     * 
     * @param id Field name of the property
     * @param widgetFactory widgetFactory instance
     * @param parent parent composite
     * @param columns number of columns of the field
     * @param span span of the field
     * @return composite
     */
    public static Composite createComposite(FormToolkit widgetFactory, Composite parent, int columns, int span) {
        Composite composite = widgetFactory.createComposite(parent, SWT.TRANSPARENT);
        composite.setBackground(new Color(parent.getShell().getDisplay(), 255, 255, 255));
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = columns;
        propertiesGroupLayout.marginLeft = 0;
        propertiesGroupLayout.horizontalSpacing = 0;
        propertiesGroupLayout.verticalSpacing = 0;
        propertiesGroupLayout.marginHeight = 1;
        propertiesGroupLayout.marginWidth = 1;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = span;
        composite.setLayoutData(propertiesSectionData);
        return composite;

    }

    public static String getIconPath(String iconName) throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(PLUGIN_ID);
        URL webAppURL = bundle.getEntry(iconName);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        return resolvedWebAppFolder.getAbsolutePath();
    }

    /**
     * Opens namespaced property editor for expression widgets
     * 
     * @param parent parent composite
     * @param valueExpressionText expression text box
     * @param valueExpression namespaced property instance
     * @return isSaved
     */
    public static boolean openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent,
            NamespacedProperty valueExpression) {
        if (valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        ValueExpressionWidgetNameSpacedPropertyEditorDialog nspd = new ValueExpressionWidgetNameSpacedPropertyEditorDialog(
                parent.getShell(), SWT.NULL, valueExpression);
        valueExpression = nspd.open();
        return nspd.isSaved();
    }

    public static GridData createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent,
            List<ViewerFilter> propertiesFilters) {

        ReferencesTable properties = new ReferencesTable("Sample label to display", new ReferencesTableListener() {
            public void handleAdd() {
                // propertiesEditionComponent.firePropertiesChanged(new
                // PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this,
                // EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT,
                // PropertiesEditionEvent.ADD, null, null));
                // properties.refresh();
                // Control valueExpressionText;
                // openValueExpressionWidgetNamespacedPropertyEditor(parent, valueExpressionText, null);

            }

            public void handleEdit(EObject element) {
                // propertiesEditionComponent.firePropertiesChanged(new
                // PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this,
                // EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT,
                // PropertiesEditionEvent.EDIT, null, element));
                // properties.refresh();
            }

            public void handleMove(EObject element, int oldIndex, int newIndex) {
                // propertiesEditionComponent.firePropertiesChanged(new
                // PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this,
                // EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT,
                // PropertiesEditionEvent.MOVE, element, newIndex));
                // properties.refresh();
            }

            public void handleRemove(EObject element) {
                // propertiesEditionComponent.firePropertiesChanged(new
                // PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this,
                // EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT,
                // PropertiesEditionEvent.REMOVE, null, element));
                // properties.refresh();
            }

            public void navigateTo(EObject element) {
            }
        });
        for (ViewerFilter filter : propertiesFilters) {
            properties.addFilter(filter);
        }
        properties.setHelpText("Sample help text");
        properties.createControls(parent, widgetFactory);
        properties.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    // propertiesEditionComponent.firePropertiesChanged(new
                    // PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this,
                    // EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.CHANGE,
                    // PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
                }
            }

        });
        GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesData.horizontalSpan = 3;
        properties.setLayoutData(propertiesData);
        properties.setLowerBound(0);
        properties.setUpperBound(-1);

        // TODO: fix column header wrapping issue in mac and windows.
        /*
         * String emptySpace = StringUtils.rightPad("", 2);
         * {
         * this.properties.getTable().setHeaderVisible(true);
         * String title = StringUtils.rightPad(emptySpace + "Property Name", 42) + "|"
         * + StringUtils.rightPad(emptySpace + "Property Value Type", 20) + emptySpace + "|"
         * + StringUtils.rightPad(emptySpace + "Property Value", 42) + "|";
         * 
         * TableColumn column = new TableColumn(this.properties.getTable(), SWT.NONE);
         * column.setText(title);
         * this.properties.getTable().getColumn(0).pack();
         * }
         */

        properties.getTable().setFont(FontUtils.getMonospacedFont());
        // properties.setID(EsbViewsRepository.LogMediator.Properties.properties_);
        properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createPropertiesTableComposition

        // End of user code
        return propertiesData;
    }

    /**
     * @generated NOT
     */
    public static Composite createOAuthParameterListItem(FormToolkit toolkit, Composite parent) {
        Composite listItemComposite = CompositeElements.createComposite(toolkit, parent, 7, 0);
        listItemComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        NamespacedProperty namespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        toolkit.createLabel(listItemComposite, "Name:");
        Text keyText = toolkit.createText(listItemComposite, "");
        toolkit.createLabel(listItemComposite, "Value:");
        Composite textboxComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, listItemComposite,
                namespacedProperty);
        Text valueText = (Text) textboxComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        StyledText expressionText = (StyledText) textboxComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        Button toggleButton = (Button) textboxComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);
        Button removeButton = toolkit.createButton(listItemComposite, "X", SWT.PUSH);

        listItemComposite.setData(CompositeElements.KEY_TEXT_BOX, keyText);
        listItemComposite.setData(CompositeElements.VALUE_TEXT_BOX, valueText);
        listItemComposite.setData(CompositeElements.EXPRESSION_TEXT_BOX, expressionText);
        listItemComposite.setData(CompositeElements.EXPRESSION_TOGGLE_BUTTON, toggleButton);
        listItemComposite.setData(CompositeElements.REMOVE_ITEM_BUTTON, removeButton);

        return listItemComposite;
    }
}
