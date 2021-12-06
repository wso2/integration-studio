/*
* Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.forms;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFPropertyConstants;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

// End of user code

/**
 * 
 * 
 */
public class NTLMMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, NTLMMediatorPropertiesEditionPart {

    protected Text description;
    protected Text username;
    protected Text password;
    protected Text host;
    protected Text domain;
    protected Text ntlmVersion;

    // Start of user code for valueExpression widgets declarations
    private static IIntegrationStudioLog log = Logger.getLog(EEFPropertyViewUtil.PLUGIN_ID);
    protected Composite usernameComposite;
    protected Composite passwordComposite;
    protected Composite hostComposite;
    protected Composite domainComposite;
    protected Composite ntlmVersionComposite;
    protected StyledText usernameExpression;
    protected StyledText passwordExpression;
    protected StyledText hostExpression;
    protected StyledText domainExpression;
    protected StyledText ntlmVersionExpression;
    protected NamespacedProperty usernameExpressionNamespacedProperty;
    protected NamespacedProperty passwordExpressionNamespacedProperty;
    protected NamespacedProperty hostExpressionNamespacedProperty;
    protected NamespacedProperty domainExpressionNamespacedProperty;
    protected NamespacedProperty ntlmVersionExpressionNamespacedProperty;
    // End of user code

    /**
     * For {@link ISection} use only.
     */
    public NTLMMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public NTLMMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
     * 
     */
    public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
        Form form = widgetFactory.createForm(parent);
        view = form.getBody();
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(widgetFactory, view);
        return form;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence nTLMMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = nTLMMediatorStep.addStep(EsbViewsRepository.NTLMMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.description);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.username);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.password);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.host);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.domain);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.usernameExpression);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.passwordExpression);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.hostExpression);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.domainExpression);
        propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression);

        composer = new PartComposer(nTLMMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.NTLMMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.username) {
                    return createUsernameText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.password) {
                    return createPasswordText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.host) {
                    return createHostText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.domain) {
                    return createDomainText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.NTLMMediator.Properties.ntlmVersion) {
                    return createNtlmVersionText(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.NTLMMediatorPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 3;
        propertiesSection.setLayoutData(propertiesSectionData);
        Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        propertiesSection.setClient(propertiesGroup);
        return propertiesGroup;
    }

    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.description,
                EsbMessages.NTLMMediatorPropertiesEditionPart_DescriptionLabel);
        description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
        description.setLayoutData(descriptionData);
        description.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.NTLMMediator.Properties.description, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.NTLMMediator.Properties.description,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    description.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        description.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                NTLMMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.NTLMMediator.Properties.description, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.NTLMMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.NTLMMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createDescriptionText

        // End of user code
        return parent;
    }

    protected Composite createUsernameText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.username,
                EsbMessages.NTLMMediatorPropertiesEditionPart_UsernameLabel);
        widgetFactory.paintBordersFor(parent);

        if (usernameExpressionNamespacedProperty == null) {
            usernameExpressionNamespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Add new toggle expression widget
        usernameComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, usernameComposite,
                EsbViewsRepository.NTLMMediator.Properties.username); // $NON-NLS-1$

        username = (Text) usernameComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        usernameExpression = (StyledText) usernameComposite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

        EditingUtils.setID(username, EsbViewsRepository.NTLMMediator.Properties.username);
        EditingUtils.setEEFtype(username, "eef::Text"); //$NON-NLS-1$

        EditingUtils.setID(usernameExpression, EsbViewsRepository.NTLMMediator.Properties.username);
        EditingUtils.setEEFtype(usernameExpression, "eef::Text"); //$NON-NLS-1$

        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.NTLMMediator.Properties.username, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$

        return parent;
    }

    protected Composite createPasswordText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.password,
                EsbMessages.NTLMMediatorPropertiesEditionPart_PasswordLabel);
        widgetFactory.paintBordersFor(parent);

        if (passwordExpressionNamespacedProperty == null) {
            passwordExpressionNamespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Add new toggle expression widget
        passwordComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, passwordComposite,
                EsbViewsRepository.NTLMMediator.Properties.password); // $NON-NLS-1$

        password = (Text) passwordComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        passwordExpression = (StyledText) passwordComposite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

        EditingUtils.setID(password, EsbViewsRepository.NTLMMediator.Properties.password);
        EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$

        EditingUtils.setID(passwordExpression, EsbViewsRepository.NTLMMediator.Properties.password);
        EditingUtils.setEEFtype(passwordExpression, "eef::Text"); //$NON-NLS-1$

        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.NTLMMediator.Properties.password, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$

        return parent;
    }

    protected Composite createHostText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.host,
                EsbMessages.NTLMMediatorPropertiesEditionPart_HostLabel);
        widgetFactory.paintBordersFor(parent);

        if (hostExpressionNamespacedProperty == null) {
            hostExpressionNamespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Add new toggle expression widget
        hostComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, hostComposite, EsbViewsRepository.NTLMMediator.Properties.host); // $NON-NLS-1$

        host = (Text) hostComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        hostExpression = (StyledText) hostComposite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

        EditingUtils.setID(host, EsbViewsRepository.NTLMMediator.Properties.host);
        EditingUtils.setEEFtype(host, "eef::Text"); //$NON-NLS-1$

        EditingUtils.setID(hostExpression, EsbViewsRepository.NTLMMediator.Properties.host);
        EditingUtils.setEEFtype(hostExpression, "eef::Text"); //$NON-NLS-1$

        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.NTLMMediator.Properties.host, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$

        return parent;
    }

    protected Composite createDomainText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.domain,
                EsbMessages.NTLMMediatorPropertiesEditionPart_DomainLabel);
        widgetFactory.paintBordersFor(parent);

        if (domainExpressionNamespacedProperty == null) {
            domainExpressionNamespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Add new toggle expression widget
        domainComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, domainComposite, EsbViewsRepository.NTLMMediator.Properties.domain); // $NON-NLS-1$

        domain = (Text) domainComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        domainExpression = (StyledText) domainComposite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

        EditingUtils.setID(domain, EsbViewsRepository.NTLMMediator.Properties.domain);
        EditingUtils.setEEFtype(domain, "eef::Text"); //$NON-NLS-1$

        EditingUtils.setID(domainExpression, EsbViewsRepository.NTLMMediator.Properties.domain);
        EditingUtils.setEEFtype(domainExpression, "eef::Text"); //$NON-NLS-1$

        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.NTLMMediator.Properties.domain, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$

        return parent;
    }

    protected Composite createNtlmVersionText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion,
                EsbMessages.NTLMMediatorPropertiesEditionPart_NtlmVersionLabel);
        widgetFactory.paintBordersFor(parent);

        if (ntlmVersionExpressionNamespacedProperty == null) {
            ntlmVersionExpressionNamespacedProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }

        // Add new toggle expression widget
        ntlmVersionComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 1, 1);
        createTextBoxFieldWithButton(widgetFactory, ntlmVersionComposite,
                EsbViewsRepository.NTLMMediator.Properties.ntlmVersion); // $NON-NLS-1$

        ntlmVersion = (Text) ntlmVersionComposite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        ntlmVersionExpression = (StyledText) ntlmVersionComposite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

        EditingUtils.setID(ntlmVersion, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
        EditingUtils.setEEFtype(ntlmVersion, "eef::Text"); //$NON-NLS-1$

        EditingUtils.setID(ntlmVersionExpression, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
        EditingUtils.setEEFtype(ntlmVersionExpression, "eef::Text"); //$NON-NLS-1$

        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.NTLMMediator.Properties.ntlmVersion, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$

        return parent;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void firePropertiesChanged(IPropertiesEditionEvent event) {
        // Start of user code for tab synchronization

        // End of user code
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDescription()
     * 
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDescription(String newValue)
     * 
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getUsername()
     * 
     */
    public String getUsername() {
        Button expressionToggleButton = (Button) usernameComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        if (expressionToggleButton.getSelection()) {
            return usernameExpression.getText();
        } else {
            return username.getText();
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setUsername(String newValue)
     * 
     */
    public void setUsername(String newValue) {

        setProperty(usernameComposite, newValue);

    }

    private void setProperty(Composite composite, String newValue) {
        String value = newValue;
        if (newValue == null) {
            value = "";
        }

        Composite expressionComposite = (Composite) composite.getData(EEFPropertyConstants.EXPRESSION_COMPOSITE);
        Button expressionToggleButton = (Button) composite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        Text valueText = (Text) composite.getData(EEFPropertyConstants.VALUE_TEXT_BOX);
        StyledText expressionText = (StyledText) composite.getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);
        
        if (isDynamicAttribute(value)) {
            String newValueExp = getValueFromExpression(value);
            expressionText.setText(newValueExp);
            // Hide value text box
            valueText.setVisible(false);
            ((GridData) valueText.getLayoutData()).exclude = true;
            // Show expression composite
            expressionToggleButton.setSelection(true);
            expressionComposite.setVisible(true);
            ((GridData) expressionComposite.getLayoutData()).exclude = false;
            composite.layout();

        } else {
            valueText.setText(value);
            // Show value text box
            valueText.setVisible(true);
            ((GridData) valueText.getLayoutData()).exclude = false;
            // Hide expression composite
            expressionToggleButton.setSelection(false);
            expressionComposite.setVisible(false);
            ((GridData) expressionComposite.getLayoutData()).exclude = true;
            composite.layout();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getPassword()
     * 
     */
    public String getPassword() {
        Button expressionToggleButton = (Button) passwordComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        if (expressionToggleButton.getSelection()) {
            return passwordExpression.getText();
        } else {
            return password.getText();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setPassword(String newValue)
     * 
     */
    public void setPassword(String newValue) {
        setProperty(passwordComposite, newValue);

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getHost()
     * 
     */
    public String getHost() {
        Button expressionToggleButton = (Button) hostComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        if (expressionToggleButton.getSelection()) {
            return hostExpression.getText();
        } else {
            return host.getText();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setHost(String newValue)
     * 
     */
    public void setHost(String newValue) {
        setProperty(hostComposite, newValue);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDomain()
     * 
     */
    public String getDomain() {
        Button expressionToggleButton = (Button) domainComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        if (expressionToggleButton.getSelection()) {
            return domainExpression.getText();
        } else {
            return domain.getText();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDomain(String newValue)
     * 
     */
    public void setDomain(String newValue) {
        setProperty(domainComposite, newValue);

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getNtlmVersion()
     * 
     */
    public String getNtlmVersion() {
        Button expressionToggleButton = (Button) ntlmVersionComposite.getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
        if (expressionToggleButton.getSelection()) {
            return ntlmVersionExpression.getText();
        } else {
            return ntlmVersion.getText();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setNtlmVersion(String newValue)
     * 
     */
    public void setNtlmVersion(String newValue) {
        setProperty(ntlmVersionComposite, newValue);

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getUsernameExpression()
     * 
     */
    public NamespacedProperty getUsernameExpression() {
        return usernameExpressionNamespacedProperty;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setUsernameExpression(NamespacedProperty
     *      newValue)
     * 
     */
    public void setUsernameExpression(NamespacedProperty nameSpacedProperty) {

        if (nameSpacedProperty != null) {
            usernameExpressionNamespacedProperty = nameSpacedProperty;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getPasswordExpression()
     * 
     */
    public NamespacedProperty getPasswordExpression() {
        return passwordExpressionNamespacedProperty;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setPasswordExpression(NamespacedProperty
     *      newValue)
     * 
     */
    public void setPasswordExpression(NamespacedProperty newValue) {
        if (newValue != null) {
            passwordExpressionNamespacedProperty = newValue;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getHostExpression()
     * 
     */
    public NamespacedProperty getHostExpression() {
        return hostExpressionNamespacedProperty;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setHostExpression(NamespacedProperty
     *      newValue)
     * 
     */
    public void setHostExpression(NamespacedProperty newValue) {
        if (newValue != null) {
            hostExpressionNamespacedProperty = newValue;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDomainExpression()
     * 
     */
    public NamespacedProperty getDomainExpression() {
        return domainExpressionNamespacedProperty;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDomainExpression(NamespacedProperty
     *      newValue)
     * 
     */
    public void setDomainExpression(NamespacedProperty newValue) {
        if (newValue != null) {
            domainExpressionNamespacedProperty = newValue;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getNtlmVersionExpression()
     * 
     */
    public NamespacedProperty getNtlmVersionExpression() {
        return ntlmVersionExpressionNamespacedProperty;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setNtlmVersionExpression(EObject
     *      newValue)
     * 
     */
    public void setNtlmVersionExpression(NamespacedProperty newValue) {
        if (newValue != null) {
            ntlmVersionExpressionNamespacedProperty = newValue;
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return EsbMessages.NTLMMediator_Part_Title;
    }

    // Start of user code additional methods
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
    public Composite createTextBoxFieldWithButton(FormToolkit widgetFactory, final Composite parent,
            final String updatedField) {

        // Create wrapping composite of 3 elements
        Composite textBoxComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 3, 3);

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
        final Text valueTextBox = widgetFactory.createText(textBoxComposite, "", SWT.BORDER);
        valueTextBox.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        valueTextBox.setLayoutData(configRefData);
        valueTextBox.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, valueTextBox.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartForm.this, updatedField,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    valueTextBox.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        valueTextBox.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, valueTextBox.getText()));
                }
            }
        });

        // Create expression compsite(Which has text box and exp button)
        final Composite expressionComposite = createExpressionComposite(widgetFactory, textBoxComposite, updatedField);
        expressionComposite.setVisible(false);
        ((GridData) expressionComposite.getLayoutData()).exclude = true; // Hide the expression composite first

        StyledText expressionTextBox = (StyledText) expressionComposite
                .getData(EEFPropertyConstants.EXPRESSION_TEXT_BOX);

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
                    expressionTextBox.forceFocus();
                    parent.layout();
                    // update ecore object to expression
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getExpressionFromValue(expressionTextBox.getText())));
                } else {
                    // Show value text box
                    valueTextBox.setVisible(true);
                    ((GridData) valueTextBox.getLayoutData()).exclude = false;
                    // Hide expression composite
                    expressionComposite.setVisible(false);
                    ((GridData) expressionComposite.getLayoutData()).exclude = true;
                    parent.layout();
                    // update ecore object to expression
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, valueTextBox.getText()));
                }
            }
        });
        // Set control widgets as data of parent composite
        parent.setData(EEFPropertyConstants.ASSOCIATED_BUTTON, expressionToggleButton); // Add associated button
        parent.setData(EEFPropertyConstants.EXPRESSION_TEXT_BOX, expressionTextBox);
        parent.setData(EEFPropertyConstants.VALUE_TEXT_BOX, valueTextBox);
        parent.setData(EEFPropertyConstants.EXPRESSION_COMPOSITE, expressionComposite);;
        return parent;
    }

    /**
     * Creates expression sub composite
     * 
     * @param widgetFactory widget factory
     * @param parent parent composite
     * @param updatedField
     * @return expression composite
     */
    public Composite createExpressionComposite(FormToolkit widgetFactory, final Composite parent, String updatedField) {
        // Create wrapping composite of 2 elements and 1 span
        Composite textComposite = EEFPropertyViewUtil.createComposite(widgetFactory, parent, 2, 1);

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
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        expressionTextBox.setLayoutData(configRefData);
        expressionTextBox.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getExpressionFromValue(expressionTextBox.getText())));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartForm.this, updatedField,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    getExpressionFromValue(expressionTextBox.getText())));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            NTLMMediatorPropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        expressionTextBox.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                NTLMMediatorPropertiesEditionPartForm.this, updatedField, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getExpressionFromValue(expressionTextBox.getText())));
                }
            }
        });

        // Create Expression Dialog Box Button
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
                NamespacedProperty expressioNamespacedProperty = getExpressionNamespacedProperty(updatedField);
                expressioNamespacedProperty.setPropertyValue(expressionTextBox.getText());
                boolean saved = EEFPropertyViewUtil.openValueExpressionWidgetNamespacedPropertyEditor(parent,
                        expressionTextBox, getExpressionNamespacedProperty(updatedField));
                if (saved) { // update only if the value is saved
                    expressionTextBox.setText(getExpressionNamespacedProperty(updatedField).getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartForm.this, updatedField,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getExpressionFromValue(getExpressionNamespacedProperty(updatedField).getPropertyValue())));
                }
            }
        });
        textComposite.setData(EEFPropertyConstants.EXPRESSION_TEXT_BOX, expressionTextBox); // Add associated button
        return textComposite;
    }

    private NamespacedProperty getExpressionNamespacedProperty(String propertyName) {
        if (propertyName == EsbViewsRepository.NTLMMediator.Properties.username) {
            return getUsernameExpression();
        }
        if (propertyName == EsbViewsRepository.NTLMMediator.Properties.password) {
            return getPasswordExpression();
        }
        if (propertyName == EsbViewsRepository.NTLMMediator.Properties.host) {
            return getHostExpression();
        }
        if (propertyName == EsbViewsRepository.NTLMMediator.Properties.domain) {
            return getDomainExpression();
        }
        if (propertyName == EsbViewsRepository.NTLMMediator.Properties.ntlmVersion) {
            return getNtlmVersionExpression();
        }

        return null;
    }

    /**
     * Validate the given attribute to identify whether it is static or dynamic key
     * If the name is in the {} format then it is dynamic key(XPath)
     * Otherwise just a static name
     *
     * @param attributeValue string to validate as the attribute
     * @return isDynamicAttribute representing the attribute type
     */
    private boolean isDynamicAttribute(String attributeValue) {
        if (attributeValue.length() < 2) {
            return false;
        }

        final char startExpression = '{';
        final char endExpression = '}';

        char firstChar = attributeValue.charAt(0);
        char lastChar = attributeValue.charAt(attributeValue.length() - 1);

        return (startExpression == firstChar && endExpression == lastChar);
    }

    private String getExpressionFromValue(String value) {
        final char startExpression = '{';
        final char endExpression = '}';

        return startExpression + value + endExpression;
    }

    private String getValueFromExpression(String expression) {
        return expression.substring(1, expression.length() - 1);
    }
    // End of user code

}
