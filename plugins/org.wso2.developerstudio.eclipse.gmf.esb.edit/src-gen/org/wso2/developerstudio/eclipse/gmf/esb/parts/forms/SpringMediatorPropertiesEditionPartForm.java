/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class SpringMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SpringMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text beanName;
	// Start of user code  for configurationKey widgets declarations
    protected RegistryKeyProperty configurationKey;
    protected Text configurationKeyText;
	protected Control[] descriptionElements;
	protected Control[] configurationKeyElements;
    protected Control[] beanNameElements;
    protected Composite propertiesGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public SpringMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SpringMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence springMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = springMediatorStep.addStep(EsbViewsRepository.SpringMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SpringMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SpringMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.SpringMediator.Properties.beanName);
		propertiesStep.addStep(EsbViewsRepository.SpringMediator.Properties.configurationKey);
		propertiesStep.addStep(EsbViewsRepository.SpringMediator.Properties.description);
		
		composer = new PartComposer(springMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SpringMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SpringMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SpringMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SpringMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SpringMediator.Properties.beanName) {
					return createBeanNameText(widgetFactory, parent);
				}
				// Start of user code for configurationKey addToPart creation
                if (key == EsbViewsRepository.SpringMediator.Properties.configurationKey) {
                    return createConfigurationKeyWidget(widgetFactory, parent);
                }
				// End of user code
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
		propertiesSection.setText(EsbMessages.SpringMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

    /**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
        createDescription(parent, EsbViewsRepository.SpringMediator.Properties.description, EsbMessages.SpringMediatorPropertiesEditionPart_DescriptionLabel);
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
							SpringMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SpringMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SpringMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SpringMediator.Properties.description,
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
									SpringMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SpringMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SpringMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.SpringMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SpringMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		Control [] newControls = propertiesGroup.getChildren();
		descriptionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.SpringMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SpringMediator.Properties.commentsList, EsbMessages.SpringMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "SpringMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SpringMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SpringMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SpringMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SpringMediator.Properties.reverse, EsbMessages.SpringMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SpringMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SpringMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SpringMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SpringMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createBeanNameText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
        createDescription(parent, EsbViewsRepository.SpringMediator.Properties.beanName, EsbMessages.SpringMediatorPropertiesEditionPart_BeanNameLabel);
		beanName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		beanName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData beanNameData = new GridData(GridData.FILL_HORIZONTAL);
		beanName.setLayoutData(beanNameData);
		beanName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SpringMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SpringMediator.Properties.beanName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, beanName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SpringMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SpringMediator.Properties.beanName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, beanName.getText()));
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
									SpringMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		beanName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SpringMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SpringMediator.Properties.beanName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, beanName.getText()));
				}
			}
		});
		EditingUtils.setID(beanName, EsbViewsRepository.SpringMediator.Properties.beanName);
		EditingUtils.setEEFtype(beanName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SpringMediator.Properties.beanName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBeanNameText
		Control [] newControls = propertiesGroup.getChildren();
        beanNameElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SpringMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SpringMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SpringMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SpringMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SpringMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.SpringMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#getBeanName()
	 * 
	 */
	public String getBeanName() {
		return beanName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SpringMediatorPropertiesEditionPart#setBeanName(String newValue)
	 * 
	 */
	public void setBeanName(String newValue) {
		if (newValue != null) {
			beanName.setText(newValue);
		} else {
			beanName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SpringMediator.Properties.beanName);
		if (eefElementEditorReadOnlyState && beanName.isEnabled()) {
			beanName.setEnabled(false);
			beanName.setToolTipText(EsbMessages.SpringMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !beanName.isEnabled()) {
			beanName.setEnabled(true);
		}	
		
	}






	// Start of user code for configurationKey specific getters and setters implementation

    @Override
    public RegistryKeyProperty getConfigurationKey() {
        return configurationKey;
    }

    @Override
    public void setConfigurationKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            configurationKeyText.setText(registryKeyProperty.getKeyValue());
            configurationKey = registryKeyProperty;
        }
     }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SpringMediator_Part_Title;
	}


	// Start of user code additional methods
    protected Composite createConfigurationKeyWidget(FormToolkit widgetFactory, final Composite parent) {
        Control configurationKeyLabel = createDescription(parent,
                EsbViewsRepository.SpringMediator.Properties.configurationKey,
                EsbMessages.SpringMediatorPropertiesEditionPart_ConfigurationKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (configurationKey == null) {
            configurationKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = configurationKey.getKeyValue().isEmpty() ? "" : configurationKey.getKeyValue();
        configurationKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        configurationKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        configurationKeyText.setLayoutData(valueData);
        configurationKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent event ) {
                openConfigurationKeyWidgetNamespacedPropertyEditor(parent);
            }

        });
        configurationKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openConfigurationKeyWidgetNamespacedPropertyEditor(parent);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}
        });
        EditingUtils.setID(configurationKeyText, EsbViewsRepository.SpringMediator.Properties.configurationKey);
        EditingUtils.setEEFtype(configurationKeyText, "eef::Text");
        Control configurationKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.SpringMediator.Properties.configurationKey,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        configurationKeyElements = new Control[] { configurationKeyLabel, configurationKeyText, configurationKeyHelp };
        return parent;
     }
    
    private void openConfigurationKeyWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                SWT.NULL, configurationKey, new ArrayList<NamedEntityDescriptor>());
        dialog.open();
        configurationKeyText.setText(configurationKey.getKeyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                SpringMediatorPropertiesEditionPartForm.this,
                EsbViewsRepository.SpringMediator.Properties.configurationKey, PropertiesEditionEvent.COMMIT,
                PropertiesEditionEvent.SET, null, getConfigurationKey()));
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] {propertiesGroup});
        epv.showEntry(descriptionElements, false);
        epv.showEntry(beanNameElements, false);
        epv.showEntry(configurationKeyElements, false);
        view.layout(true, true);
    }
	// End of user code


}
