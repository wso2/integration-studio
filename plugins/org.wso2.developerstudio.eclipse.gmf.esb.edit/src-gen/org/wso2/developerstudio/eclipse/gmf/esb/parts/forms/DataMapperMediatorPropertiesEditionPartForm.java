/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * @generated NOT
 */
public class DataMapperMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DataMapperMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer inputType;
	protected Text configurationLocalPath;
    protected RegistryKeyProperty configurationLocalPathRegistryKey;
    protected RegistryKeyProperty inputSchemaLocalPathRegistryKey;
    protected RegistryKeyProperty outputSchemaLocalPathRegistryKey;
	protected Text inputSchemaLocalPath;
	protected Text outputSchemaLocalPath;
	protected EMFComboViewer outputType;

    protected Control[] descriptionElements;
    protected Control[] commentListElements;
    protected Control[] inputTypeElements;
    protected Control[] configurationPathElements;
    protected Control[] inputSchemaElements;
    protected Control[] outputSchemaElements;
    protected Control[] outputTypeElements;
    protected Composite propertiesGroup;
    protected Composite inputTypePropertiesGroup;
    protected Composite outputTypePropertiesGroup;


	/**
	 * For {@link ISection} use only.
	 */
	public DataMapperMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataMapperMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * @generated NOT
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
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence dataMapperMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataMapperMediatorStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
        propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		propertiesStep.addStep(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		
		
		
		composer = new PartComposer(dataMapperMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DataMapperMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.inputType) {
					return createInputTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath) {
					return createConfigurationLocalPathText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath) {
					return createInputSchemaLocalPathText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath) {
					return createOutputSchemaLocalPathText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataMapperMediator.Properties.outputType) {
					return createOutputTypeEMFComboViewer(widgetFactory, parent);
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
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.DataMapperMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	    Control itemLabel = createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.description, EsbMessages.DataMapperMediatorPropertiesEditionPart_DescriptionLabel);
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
							DataMapperMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataMapperMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataMapperMediator.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.DataMapperMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		 Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		 descriptionElements = new Control [] {itemLabel, description, itemHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataMapperMediator.Properties.commentsList, EsbMessages.DataMapperMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "DataMapperMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		commentListElements = new Control [] {editCommentsList, commentsList};
		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataMapperMediator.Properties.reverse, EsbMessages.DataMapperMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DataMapperMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createInputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        inputTypePropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
                "Input Type", true);
	    Control itemLabel = createDescription(inputTypePropertiesGroup, EsbViewsRepository.DataMapperMediator.Properties.inputType, EsbMessages.DataMapperMediatorPropertiesEditionPart_InputTypeLabel);
		inputType = new EMFComboViewer(inputTypePropertiesGroup);
		inputType.setContentProvider(new ArrayContentProvider());
		inputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inputType.getCombo().setLayoutData(inputTypeData);
                inputType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		inputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.inputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInputType()));
			}

		});
		inputType.setID(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, inputTypePropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.inputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputTypeEMFComboViewer
		inputTypeElements = new Control [] {itemLabel, inputType.getCombo(), itemHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createConfigurationLocalPathText(FormToolkit widgetFactory, Composite parent) {
	    Control itemLabel = createDescription(parent, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_ConfigurationLocalPathLabel);
		configurationLocalPath = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		configurationLocalPath.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData configurationLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		configurationLocalPath.setLayoutData(configurationLocalPathData);
		configurationLocalPath.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataMapperMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configurationLocalPath.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, configurationLocalPath.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		configurationLocalPath.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configurationLocalPath.getText()));
				}
			}
		});
		EditingUtils.setID(configurationLocalPath, EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
		EditingUtils.setEEFtype(configurationLocalPath, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConfigurationLocalPathText
		configurationPathElements = new Control [] {itemLabel, configurationLocalPath, itemHelp};
        if(configurationLocalPathRegistryKey == null) {
            configurationLocalPathRegistryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
	    configurationLocalPath.addFocusListener(new FocusAdapter() {
	            /**
	             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
	             * 
	             */
	            @Override
	            @SuppressWarnings("synthetic-access")
	            public void focusLost(FocusEvent e) {

	            }

	            /**
	             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
	             */
	            @Override
	            public void focusGained(FocusEvent e) {
	                configurationLocalPathRegistryKey.setKeyValue(configurationLocalPath.getText());
	                EEFRegistryKeyPropertyEditorDialog dialog = new  EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
	                        configurationLocalPathRegistryKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                configurationLocalPath.setText(configurationLocalPathRegistryKey.getKeyValue());
	            }
	        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createInputSchemaLocalPathText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(inputTypePropertiesGroup, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_InputSchemaLocalPathLabel);
		inputSchemaLocalPath = widgetFactory.createText(inputTypePropertiesGroup, ""); //$NON-NLS-1$
		inputSchemaLocalPath.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(inputTypePropertiesGroup);
		GridData inputSchemaLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		inputSchemaLocalPath.setLayoutData(inputSchemaLocalPathData);
		inputSchemaLocalPath.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataMapperMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputSchemaLocalPath.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inputSchemaLocalPath.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inputSchemaLocalPath.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputSchemaLocalPath.getText()));
				}
			}
		});
		EditingUtils.setID(inputSchemaLocalPath, EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		EditingUtils.setEEFtype(inputSchemaLocalPath, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, inputTypePropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputSchemaLocalPathText
		inputSchemaElements = new Control [] {itemLabel, inputSchemaLocalPath, itemHelp};
        if(inputSchemaLocalPathRegistryKey == null) {
            inputSchemaLocalPathRegistryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        inputSchemaLocalPath.addFocusListener(new FocusAdapter() {
                /**
                 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
                 * 
                 */
                @Override
                @SuppressWarnings("synthetic-access")
                public void focusLost(FocusEvent e) {

                }

                /**
                 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
                 */
                @Override
                public void focusGained(FocusEvent e) {
                    inputSchemaLocalPathRegistryKey.setKeyValue(inputSchemaLocalPath.getText());
                    EEFRegistryKeyPropertyEditorDialog dialog = new  EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
                            inputSchemaLocalPathRegistryKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    inputSchemaLocalPath.setText(inputSchemaLocalPathRegistryKey.getKeyValue());
                }
            });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */ 
	protected Composite createOutputSchemaLocalPathText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(outputTypePropertiesGroup, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, EsbMessages.DataMapperMediatorPropertiesEditionPart_OutputSchemaLocalPathLabel);
		outputSchemaLocalPath = widgetFactory.createText(outputTypePropertiesGroup, ""); //$NON-NLS-1$
		outputSchemaLocalPath.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(outputTypePropertiesGroup);
		GridData outputSchemaLocalPathData = new GridData(GridData.FILL_HORIZONTAL);
		outputSchemaLocalPath.setLayoutData(outputSchemaLocalPathData);
		outputSchemaLocalPath.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataMapperMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputSchemaLocalPath.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outputSchemaLocalPath.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataMapperMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outputSchemaLocalPath.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputSchemaLocalPath.getText()));
				}
			}
		});
		EditingUtils.setID(outputSchemaLocalPath, EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		EditingUtils.setEEFtype(outputSchemaLocalPath, "eef::Text"); //$NON-NLS-1$
		Control  itemHelp = FormUtils.createHelpButton(widgetFactory, outputTypePropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputSchemaLocalPathText
		outputSchemaElements = new Control [] {itemLabel, outputSchemaLocalPath, itemHelp};
        if(outputSchemaLocalPathRegistryKey == null) {
            outputSchemaLocalPathRegistryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        outputSchemaLocalPath.addFocusListener(new FocusAdapter() {
                /**
                 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
                 * 
                 */
                @Override
                @SuppressWarnings("synthetic-access")
                public void focusLost(FocusEvent e) {

                }

                /**
                 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
                 */
                @Override
                public void focusGained(FocusEvent e) {
                    outputSchemaLocalPathRegistryKey.setKeyValue(outputSchemaLocalPath.getText());
                    EEFRegistryKeyPropertyEditorDialog dialog = new  EEFRegistryKeyPropertyEditorDialog(view.getShell(), SWT.NULL,
                            outputSchemaLocalPathRegistryKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    outputSchemaLocalPath.setText(outputSchemaLocalPathRegistryKey.getKeyValue());
                }
            });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */ 
	protected Composite createOutputTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        outputTypePropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
                "Output Type", true);
		Control itemLabel = createDescription(outputTypePropertiesGroup, EsbViewsRepository.DataMapperMediator.Properties.outputType, EsbMessages.DataMapperMediatorPropertiesEditionPart_OutputTypeLabel);
		outputType = new EMFComboViewer(outputTypePropertiesGroup);
		outputType.setContentProvider(new ArrayContentProvider());
		outputType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData outputTypeData = new GridData(GridData.FILL_HORIZONTAL);
		outputType.getCombo().setLayoutData(outputTypeData);
                outputType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		outputType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataMapperMediator.Properties.outputType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOutputType()));
			}

		});
		outputType.setID(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, outputTypePropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataMapperMediator.Properties.outputType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputTypeEMFComboViewer
		outputTypeElements = new Control [] {itemLabel, outputType.getCombo(), itemHelp};
		// End of user code
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
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
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getInputType()
	 * 
	 */
	public Enumerator getInputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#initInputType(Object input, Enumerator current)
	 */
	public void initInputType(Object input, Enumerator current) {
		inputType.setInput(input);
		inputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setInputType(Enumerator newValue)
	 * 
	 */
	public void setInputType(Enumerator newValue) {
		inputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputType);
		if (eefElementEditorReadOnlyState && inputType.isEnabled()) {
			inputType.setEnabled(false);
			inputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputType.isEnabled()) {
			inputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getConfigurationLocalPath()
	 * 
	 */
	public String getConfigurationLocalPath() {
		return configurationLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setConfigurationLocalPath(String newValue)
	 * 
	 */
	public void setConfigurationLocalPath(String newValue) {
		if (newValue != null) {
			configurationLocalPath.setText(newValue);
		} else {
			configurationLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath);
		if (eefElementEditorReadOnlyState && configurationLocalPath.isEnabled()) {
			configurationLocalPath.setEnabled(false);
			configurationLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !configurationLocalPath.isEnabled()) {
			configurationLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getInputSchemaLocalPath()
	 * 
	 */
	public String getInputSchemaLocalPath() {
		return inputSchemaLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setInputSchemaLocalPath(String newValue)
	 * 
	 */
	public void setInputSchemaLocalPath(String newValue) {
		if (newValue != null) {
			inputSchemaLocalPath.setText(newValue);
		} else {
			inputSchemaLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath);
		if (eefElementEditorReadOnlyState && inputSchemaLocalPath.isEnabled()) {
			inputSchemaLocalPath.setEnabled(false);
			inputSchemaLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputSchemaLocalPath.isEnabled()) {
			inputSchemaLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getOutputSchemaLocalPath()
	 * 
	 */
	public String getOutputSchemaLocalPath() {
	    
		return outputSchemaLocalPath.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setOutputSchemaLocalPath(String newValue)
	 * 
	 */
	public void setOutputSchemaLocalPath(String newValue) {
		if (newValue != null) {
			outputSchemaLocalPath.setText(newValue);
		} else {
			outputSchemaLocalPath.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath);
		if (eefElementEditorReadOnlyState && outputSchemaLocalPath.isEnabled()) {
			outputSchemaLocalPath.setEnabled(false);
			outputSchemaLocalPath.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputSchemaLocalPath.isEnabled()) {
			outputSchemaLocalPath.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#getOutputType()
	 * 
	 */
	public Enumerator getOutputType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) outputType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#initOutputType(Object input, Enumerator current)
	 */
	public void initOutputType(Object input, Enumerator current) {
		outputType.setInput(input);
		outputType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart#setOutputType(Enumerator newValue)
	 * 
	 */
	public void setOutputType(Enumerator newValue) {
		outputType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataMapperMediator.Properties.outputType);
		if (eefElementEditorReadOnlyState && outputType.isEnabled()) {
			outputType.setEnabled(false);
			outputType.setToolTipText(EsbMessages.DataMapperMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputType.isEnabled()) {
			outputType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DataMapperMediator_Part_Title;
	}

	// Start of user code additional methods
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] {propertiesGroup});
        epv.showEntry(new Control[] {inputTypePropertiesGroup.getParent()}, false);
        epv.showEntry(new Control[] {outputTypePropertiesGroup.getParent()}, false);
        epv.showEntry(descriptionElements, false);
        epv.showEntry(configurationPathElements, false);
        epv.showEntry(inputSchemaElements, false);
        epv.showEntry(outputSchemaElements, false);
        epv.showEntry(inputTypeElements, false);
        epv.showEntry(outputTypeElements, false);
        view.layout(true, true);
    }
	// End of user code


}
