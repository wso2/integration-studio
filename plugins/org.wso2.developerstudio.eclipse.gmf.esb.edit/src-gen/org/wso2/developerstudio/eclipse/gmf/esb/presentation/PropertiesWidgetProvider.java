package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;

public class PropertiesWidgetProvider {

    protected static String UI_SCHEMA_OBJECT_KEY = "uischema";
    protected IPropertiesEditionComponent propertiesEditionComponent;
    protected SectionPropertiesEditingPart partForm;
    protected HashMap<String, Control> controlList;
    protected HashMap<String, Composite> compositeList;
    private boolean isConnectionWidgetProvider = false;
    protected HashMap<String, Control> requiredList;

    public PropertiesWidgetProvider(SectionPropertiesEditingPart partForm,
            IPropertiesEditionComponent propertiesEditionComponent, HashMap<String, Control> controlList,
            HashMap<String, Composite> compositeList, HashMap<String, Control> requiredList) {
        this.propertiesEditionComponent = propertiesEditionComponent;
        this.partForm = partForm;
        this.controlList = controlList;
        this.compositeList = compositeList;
        this.requiredList = requiredList;
    }
    
    public PropertiesWidgetProvider(HashMap<String, Control> controlList, HashMap<String, Composite> compositeList, HashMap<String, Control> requiredList) {
        this.controlList = controlList;
        this.compositeList = compositeList;
        this.isConnectionWidgetProvider = true;
        this.requiredList = requiredList;
    }

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

    public Composite createTextBoxField(FormToolkit widgetFactory, Composite parent, AttributeValue value) {
        Composite textBoxComposite = createComposite(value.getName(), widgetFactory, parent, 2, 2);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(value.getDisplayName());
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        setToolTip(label, value.getHelpTip());
        Text configRef = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        controlList.put(value.getName(), configRef);
        if(value.getRequired()) {
            requiredList.put(value.getName(), configRef);
        }
        configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);

        configRef.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (!isConnectionWidgetProvider) {
                    if(value.getName().equals("description")) { 
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                                EsbViewsRepository.CloudConnectorOperation.Properties.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.EDIT, null, configRef.getText()));
                    } else {
        
                        CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                        setParameterType(RuleOptionType.VALUE, ctp);
                        AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource()).getData(UI_SCHEMA_OBJECT_KEY);
                        updateModel(ctp, configRef, uiSchemaValue);
        
                     }

                }
            }
        });
        setItemFocus(configRef);
        return parent;
    }

    public Composite createTextBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
            AttributeValue value) {
        Composite textBoxComposite = createComposite(value.getName(), widgetFactory, parent, 3, 3);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(value.getDisplayName() + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        // label.setToolTipText(Label);
        setToolTip(label, value.getHelpTip());
        final Text configRef = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        configRef.setData(UI_SCHEMA_OBJECT_KEY, value);
        controlList.put(value.getName(), configRef);
        if(value.getRequired()) {
            requiredList.put(value.getName(), configRef);
        }
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        Button configButton = new Button(textBoxComposite, SWT.PUSH);
        // configButton.setText(buttonText);
        configRef.setLayoutData(configRefData);
        configButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (!isConnectionWidgetProvider) {
                CallTemplateParameter ctp = (CallTemplateParameter) configRef.getData();
                boolean saved = openValueExpressionWidgetNamespacedPropertyEditor(parent, configRef, ctp.getParameterExpression());
                if(saved) {
                    setParameterType(RuleOptionType.EXPRESSION, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) configRef.getData(UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, configRef, uiSchemaValue);
                }
              }
            }
        });
        Image image = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "DataMapperMediator.png");
        configButton.setImage(image);
        configRef.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!isConnectionWidgetProvider) {
                 // if (e.character == SWT.CR) {
                    // ((CallTemplateParameter)configRef.getData()).setParameterValue(configRef.getText());
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Text) e.getSource()).getData();
                    // ctp.setParameterValue(configRef.getText());
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Text) e.getSource()).getData(UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, configRef, uiSchemaValue);
                    // }
                }
            }
        });
        setItemFocus(configRef);
        return parent;
    }

    public Composite createDropDownField(FormToolkit widgetFactory, Composite parent, String[] options,
            AttributeValue value) {
        Composite textBoxComposite = createComposite(value.getName(), widgetFactory, parent, 3, 3);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(value.getDisplayName() + ":");
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        Combo configRef = new Combo(textBoxComposite, SWT.DROP_DOWN);
        controlList.put(value.getName(), configRef);
        if(value.getRequired()) {
            requiredList.put(value.getName(), configRef);
        }
        configRef.setItems(options);
        configRef.setData(UI_SCHEMA_OBJECT_KEY, value);
        setToolTip(label, value.getHelpTip());
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);
        configRef.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                if (!isConnectionWidgetProvider) {
                    CallTemplateParameter ctp = (CallTemplateParameter) ((Combo) event.getSource()).getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) ((Combo) event.getSource())
                            .getData(UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, configRef, uiSchemaValue);
                }
            }
        });
        
        Button configButton = new Button(textBoxComposite, SWT.PUSH);
        Image image = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "DataMapperMediator.png");
        configButton.setImage(image);
        configButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                CallTemplateParameter ctp = (CallTemplateParameter) configRef.getData();
                boolean saved = openValueExpressionWidgetNamespacedPropertyEditor(parent, configRef, ctp.getParameterExpression());
                if(saved) {
                    setParameterType(RuleOptionType.EXPRESSION, ctp);
                    AttributeValue uiSchemaValue = (AttributeValue) configRef.getData(UI_SCHEMA_OBJECT_KEY);
                    updateModel(ctp, configRef, uiSchemaValue);
                }
            }
        });
        configRef.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
               e.doit = false;
            }
        });
        setItemFocus(configRef);
        return parent;
    }

    public Composite createConnectionField(FormToolkit widgetFactory, Composite parent, AttributeValue value,
            String[] options) {
        Image NEW_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");
        Image DELETE_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Delete_16x16.gif");
        Composite textBoxComposite = createComposite(value.getName(), widgetFactory, parent, 4, 4);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(value.getDisplayName());
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        Combo configRef = new Combo(textBoxComposite, SWT.READ_ONLY | SWT.DROP_DOWN);
        controlList.put(value.getName(), configRef);
        configRef.setItems(options);
        configRef.setData(UI_SCHEMA_OBJECT_KEY, value);
        if(value.getRequired()) {
            requiredList.put(value.getName(), configRef);
        }
        setToolTip(label, value.getHelpTip());
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);
        configRef.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                if (!isConnectionWidgetProvider) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                            EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.EDIT, null, configRef.getText()));
                }
            }
        });
        Button configButton = widgetFactory.createButton(textBoxComposite, "", SWT.PUSH | SWT.TRANSPARENT);
        configButton.setImage(NEW_ELEMENT_IMG);
        
        configButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (!isConnectionWidgetProvider) {
                    openConnectionEditor(widgetFactory, parent, configRef, null, value);
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                            EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.EDIT, null, configRef.getText()));
                }
                
            }
        });
        setItemFocus(configRef);
        
        Button editConnectionButton = widgetFactory.createButton(textBoxComposite, "", SWT.PUSH | SWT.TRANSPARENT);
        editConnectionButton.setImage(DELETE_ELEMENT_IMG);
        editConnectionButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                openConnectionUpdateEditor(widgetFactory, parent, configRef, null, value);
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                        EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.EDIT, null, configRef.getText()));
            }
        });
        
        return parent;
    }

    public Composite createCheckBoxField(FormToolkit widgetFactory, Composite parent, String Label, String[] options,
            String id) {
        Composite textBoxComposite = createComposite(id, widgetFactory, parent, options.length + 1, options.length + 1);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
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

    public Composite createComposite(FormToolkit widgetFactory, Composite parent) {
        Composite composite = widgetFactory.createComposite(parent);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 2;
        propertiesGroupLayout.marginLeft = 15;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 10;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        composite.setLayoutData(propertiesSectionData);
        return composite;

    }

    public Composite createComposite(String id, FormToolkit widgetFactory, Composite parent, int columns, int span) {
        Composite composite = widgetFactory.createComposite(parent, SWT.NO_BACKGROUND);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = columns;
        propertiesGroupLayout.marginLeft = 0;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 0;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = span;
        composite.setLayoutData(propertiesSectionData);
        compositeList.put(id, composite);
        return composite;

    }

    //////////////// Dialog Box open methods////////////////////

    public boolean openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent, Control valueExpressionText,
            NamespacedProperty valueExpression) {
        if (valueExpression == null) {
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
            ((CallTemplateParameter) valueExpressionText.getData()).setParameterExpression(valueExpression);
        }
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        if(nspd.isSaved()) {
            if(valueExpressionText instanceof Text) {
                ((Text)valueExpressionText).setText(valueExpression.getPropertyValue());
            } else if (valueExpressionText instanceof Combo) {
                ((Combo)valueExpressionText).setText(valueExpression.getPropertyValue());
            }
        }
        return nspd.isSaved();
    }

    public void openConnectionEditor(FormToolkit widgetFactory, final Composite parent, Combo valueExpressionCombo,
            NamespacedProperty valueExpression, AttributeValue value) {
        CloudConnectorOperationImpl connectorObject = (CloudConnectorOperationImpl) propertiesEditionComponent
                .getEditingContext().getEObject();
        String connectorName = connectorObject.getConnectorName().split("connector")[0];
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        ConnectionParameterWizard wizard = new ConnectionParameterWizard(widgetFactory, connectorName,
                valueExpressionCombo, value);
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog connectionWizard = new WizardDialog(window.getShell(), wizard);
        connectionWizard.setHelpAvailable(false);
        connectionWizard.open();
    }

    public void openConnectionUpdateEditor(FormToolkit widgetFactory, final Composite parent, Combo valueExpressionCombo,
            NamespacedProperty valueExpression, AttributeValue value) {
        CloudConnectorOperationImpl connectorObject = (CloudConnectorOperationImpl) propertiesEditionComponent
                .getEditingContext().getEObject();
        String connectorName = connectorObject.getConnectorName().split("connector")[0];
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        ConnectionParameterWizard wizard = new ConnectionParameterWizard(widgetFactory, connectorName,
                valueExpressionCombo.getText(), value);
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog connectionWizard = new WizardDialog(window.getShell(), wizard);
        connectionWizard.setHelpAvailable(false);
        connectionWizard.open();
    }

    //////////////// Widget util Methods////////////////////////

    public void setParameterType(RuleOptionType ruleType, CallTemplateParameter ctp) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ctp);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

            @Override
            protected void doExecute() {
                ctp.setTemplateParameterType(ruleType);
            }
        });
    }

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

    public void setItemFocus(Control control) {
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

    /////////Subclass according to usage
    public void updateModel(CallTemplateParameter ctp, Control configRef, AttributeValue uiSchameValue) {
        String value = "";
        if (configRef instanceof Text) {
            value = ((Text) configRef).getText();
        } else if (configRef instanceof Combo) {
            value = ((Combo) configRef).getText();
        }
        if (validateValue("", value, uiSchameValue.getRequired(), uiSchameValue.getDisplayName())) { // Validation
                                                                                                           // regex
                                                                                                           // model
                                                                                                           // support
            propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm,
                    EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters,
                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, ctp, value));
        } else {
            // Update message box
        }
    }

    public boolean validateValue(String regex, String value, boolean required, String fieldName) {
        // Do required validation
        if(regex.isEmpty()) {
            return true;
        }
        // Do xpath validation
        boolean result = Pattern.matches(regex, value);
        if (!result) {
            try {
                ((CloudConnectorOperationPropertiesEditionPartForm) partForm).updateMessage("regexerror", "", fieldName,
                        regex);
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
            // return false;
            return true;
        }
        try {
            ((CloudConnectorOperationPropertiesEditionPartForm) partForm).updateMessage("ok", "", fieldName, regex);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public void checkRequired() {
        boolean isError = false;
        String fieldName = "";
        for(String key: requiredList.keySet()) {
            Control control = requiredList.get(key);
            if(control instanceof Text) {
                String value = ((Text)control).getText();
                if(value == null || value.isEmpty()) {
                    isError = true;
                    AttributeValue va = (AttributeValue)control.getData(UI_SCHEMA_OBJECT_KEY);
                    fieldName = va.getDisplayName();
                } 
            }
        
        }
        if(isError) {
            try {
                ((CloudConnectorOperationPropertiesEditionPartForm) partForm).updateMessage("requirederror", "", fieldName, "");
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
