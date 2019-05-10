/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.gmf.esb.util.FontUtils;

public class PropertyGroupMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, PropertyGroupMediatorPropertiesEditionPart {

    protected Text description;
    protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;
    protected Button reverse;
    protected ReferencesTable properties;
    protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
    protected Composite propertiesGroup;
    protected Control[] reverseElements;
    protected Control[] commentsElements;

    /**
     * For {@link ISection} use only.
     */
    public PropertyGroupMediatorPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     */
    public PropertyGroupMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit) 
     */
    public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
        ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
        Form form = scrolledForm.getForm();
        view = form.getBody();
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(widgetFactory, view);
        return scrolledForm;
    }

    /**
     * {@inheritDoc}
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence propertyGroupMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = propertyGroupMediatorStep
                .addStep(EsbViewsRepository.PropertyGroupMediator.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.PropertyGroupMediator.Properties.description);
        propertiesStep.addStep(EsbViewsRepository.PropertyGroupMediator.Properties.commentsList);
        propertiesStep.addStep(EsbViewsRepository.PropertyGroupMediator.Properties.reverse);
        propertiesStep.addStep(EsbViewsRepository.PropertyGroupMediator.Properties.properties_);

        composer = new PartComposer(propertyGroupMediatorStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.PropertyGroupMediator.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.PropertyGroupMediator.Properties.description) {
                    return createDescriptionText(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.PropertyGroupMediator.Properties.commentsList) {
                    return createCommentsListMultiValuedEditor(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.PropertyGroupMediator.Properties.reverse) {
                    return createReverseCheckbox(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.PropertyGroupMediator.Properties.properties_) {
                    return createPropertiesTableComposition(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * @generated NOT
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.PropertyGroupMediatorPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 3;
        propertiesSection.setLayoutData(propertiesSectionData);
        propertiesGroup = widgetFactory.createComposite(propertiesSection);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        propertiesSection.setClient(propertiesGroup);
        return propertiesGroup;
    }

    protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.PropertyGroupMediator.Properties.description,
                EsbMessages.PropertyGroupMediatorPropertiesEditionPart_DescriptionLabel);
        description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
        description.setLayoutData(descriptionData);
        description.addFocusListener(new FocusAdapter() {
            
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            PropertyGroupMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.PropertyGroupMediator.Properties.description,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.PropertyGroupMediator.Properties.description,
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
                            PropertyGroupMediatorPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.PropertyGroupMediator.Properties.description,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        description.getText()));
                }
            }
        });
        EditingUtils.setID(description, EsbViewsRepository.PropertyGroupMediator.Properties.description);
        EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.PropertyGroupMediator.Properties.description, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDescriptionText

        // End of user code
        return parent;
    }

    /**
     * generated NOT
     */
    protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
        commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
        GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
        commentsListData.horizontalSpan = 2;
        commentsList.setLayoutData(commentsListData);
        EditingUtils.setID(commentsList, EsbViewsRepository.PropertyGroupMediator.Properties.commentsList);
        EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editCommentsList = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.PropertyGroupMediator.Properties.commentsList,
                        EsbMessages.PropertyGroupMediatorPropertiesEditionPart_CommentsListLabel),
                SWT.NONE);
        GridData editCommentsListData = new GridData();
        editCommentsList.setLayoutData(editCommentsListData);
        editCommentsList.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e) {
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(commentsList.getShell(),
                        "PropertyGroupMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
                        commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null, false,
                        true, null, null);
                if (dialog.open() == Window.OK) {
                    commentsListList = dialog.getResult();
                    if (commentsListList == null) {
                        commentsListList = new BasicEList();
                    }
                    commentsList.setText(commentsListList.toString());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.PropertyGroupMediator.Properties.commentsList,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new BasicEList(commentsListList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editCommentsList, EsbViewsRepository.PropertyGroupMediator.Properties.commentsList);
        EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createCommentsListMultiValuedEditor
        Control[] newControls = propertiesGroup.getChildren();
        commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        // End of user code
        return parent;
    }

    /**
     * @generated NOT
     */
    protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
        Control[] previousControls = propertiesGroup.getChildren();
        reverse = widgetFactory.createButton(parent,
                getDescription(EsbViewsRepository.PropertyGroupMediator.Properties.reverse,
                        EsbMessages.PropertyGroupMediatorPropertiesEditionPart_ReverseLabel),
                SWT.CHECK);
        reverse.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            PropertyGroupMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.PropertyGroupMediator.Properties.reverse, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
            }
        });
        GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
        reverseData.horizontalSpan = 2;
        reverse.setLayoutData(reverseData);
        EditingUtils.setID(reverse, EsbViewsRepository.PropertyGroupMediator.Properties.reverse);
        EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.PropertyGroupMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createReverseCheckbox
        Control[] newControls = propertiesGroup.getChildren();
        reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        // End of user code
        return parent;
    }

    /**
     * @param container
     */
    protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
        this.properties = new ReferencesTable(
                getDescription(EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                        EsbMessages.PropertyGroupMediatorPropertiesEditionPart_PropertiesLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
                        properties.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
                        properties.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
                        properties.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                        EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
                        properties.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.propertiesFilters) {
            this.properties.addFilter(filter);
        }
        this.properties.setHelpText(propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.PropertyGroupMediator.Properties.properties_, EsbViewsRepository.FORM_KIND));
        this.properties.createControls(parent, widgetFactory);
        this.properties.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(PropertyGroupMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.PropertyGroupMediator.Properties.properties_,
                                    PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null,
                                    e.item.getData()));
                }
            }

        });
        GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesData.horizontalSpan = 3;
        this.properties.setLayoutData(propertiesData);
        this.properties.setLowerBound(0);
        this.properties.setUpperBound(-1);
        this.properties.getTable().setFont(FontUtils.getMonospacedFont());
        properties.setID(EsbViewsRepository.PropertyGroupMediator.Properties.properties_);
        properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createPropertiesTableComposition

        // End of user code
        return parent;
    }

    /**
     * {@inheritDoc} 
     * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     */
    public void firePropertiesChanged(IPropertiesEditionEvent event) {
        // Start of user code for tab synchronization

        // End of user code
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#getDescription()
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#setDescription(String
     *      newValue)
     */
    public void setDescription(String newValue) {
        if (newValue != null) {
            description.setText(newValue);
        } else {
            description.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.PropertyGroupMediator.Properties.description);
        if (eefElementEditorReadOnlyState && description.isEnabled()) {
            description.setEnabled(false);
            description.setToolTipText(EsbMessages.PropertyGroupMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
            description.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#getCommentsList()
     */
    public EList getCommentsList() {
        return commentsListList;
    }

    /**
     * {@inheritDoc} 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#setCommentsList(EList
     *      newValue)
     */
    public void setCommentsList(EList newValue) {
        commentsListList = newValue;
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.PropertyGroupMediator.Properties.commentsList);
        if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
            commentsList.setEnabled(false);
            commentsList.setToolTipText(EsbMessages.PropertyGroupMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !commentsList.isEnabled()) {
            commentsList.setEnabled(true);
        }

    }

    public void addToCommentsList(Object newValue) {
        commentsListList.add(newValue);
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
    }

    public void removeToCommentsList(Object newValue) {
        commentsListList.remove(newValue);
        if (newValue != null) {
            commentsList.setText(commentsListList.toString());
        } else {
            commentsList.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#getReverse() 
     */
    public Boolean getReverse() {
        return Boolean.valueOf(reverse.getSelection());
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#setReverse(Boolean
     *      newValue) 
     */
    public void setReverse(Boolean newValue) {
        if (newValue != null) {
            reverse.setSelection(newValue.booleanValue());
        } else {
            reverse.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PropertyGroupMediator.Properties.reverse);
        if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
            reverse.setEnabled(false);
            reverse.setToolTipText(EsbMessages.PropertyGroupMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
            reverse.setEnabled(true);
        }
    }

    /**
     * {@inheritDoc} 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#initProperties(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initProperties(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        properties.setContentProvider(contentProvider);
        properties.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                EsbViewsRepository.PropertyGroupMediator.Properties.properties_);
        if (eefElementEditorReadOnlyState && properties.isEnabled()) {
            properties.setEnabled(false);
            properties.setToolTipText(EsbMessages.PropertyGroupMediator_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
            properties.setEnabled(true);
        }
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#updateProperties()
     */
    public void updateProperties() {
        properties.refresh();
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#addFilterProperties(ViewerFilter
     *      filter)
     */
    public void addFilterToProperties(ViewerFilter filter) {
        propertiesFilters.add(filter);
        if (this.properties != null) {
            this.properties.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc} 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter
     *      filter)
     */
    public void addBusinessFilterToProperties(ViewerFilter filter) {
        propertiesBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart#isContainedInPropertiesTable(EObject
     *      element) 
     */
    public boolean isContainedInPropertiesTable(EObject element) {
        return ((ReferencesTableSettings) properties.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     */
    public String getTitle() {
        return EsbMessages.PropertyGroupMediator_Part_Title;
    }

    // Start of user code additional methods
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.hideEntry(commentsElements, false);
        epv.hideEntry(reverseElements, false);
        view.layout(true, true);
    }

    // Start of user code additional methods

    // End of user code
}
