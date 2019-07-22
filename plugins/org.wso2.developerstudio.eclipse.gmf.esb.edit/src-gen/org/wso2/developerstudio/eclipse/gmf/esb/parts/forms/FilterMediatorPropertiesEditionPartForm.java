/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class FilterMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, FilterMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer conditionType;
	protected Text regex;
	// Start of user code  for XPath widgets declarations
    protected NamespacedProperty xPath;
    protected Text xPathText;
	// End of user code

	// Start of user code  for Source widgets declarations
    protected NamespacedProperty source;
    protected Text sourceText;
    protected Composite propertiesGroup;
    protected Control[] descriptionElements;
    protected Control[] conditionTypeElements;
    protected Control[] regexElements;
    protected Control[] sourceElements;
    protected Control[] xpathElements;
    
    protected Composite filterConditionSubPropertiesGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public FilterMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FilterMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence filterMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = filterMediatorStep.addStep(EsbViewsRepository.FilterMediator.Properties.class);
		// Start of user code 
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.conditionType);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.regex);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.xPath);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.source);
		propertiesStep.addStep(EsbViewsRepository.FilterMediator.Properties.description);
		// End of user code
		
		composer = new PartComposer(filterMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.FilterMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FilterMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FilterMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FilterMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FilterMediator.Properties.conditionType) {
					return createConditionTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FilterMediator.Properties.regex) {
					return createRegexText(widgetFactory, parent);
				}
				// Start of user code for XPath addToPart creation
                if (key == EsbViewsRepository.FilterMediator.Properties.xPath) {
                    return createXPathWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for Source addToPart creation
                if (key == EsbViewsRepository.FilterMediator.Properties.source) {
                    return createSourceWidget(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.FilterMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	    Control itemLabel = createDescription(parent, EsbViewsRepository.FilterMediator.Properties.description, EsbMessages.FilterMediatorPropertiesEditionPart_DescriptionLabel);
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
							FilterMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FilterMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FilterMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FilterMediator.Properties.description,
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
									FilterMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FilterMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.FilterMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FilterMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control [] {itemLabel, description, itemHelp};
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
		EditingUtils.setID(commentsList, EsbViewsRepository.FilterMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FilterMediator.Properties.commentsList, EsbMessages.FilterMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "FilterMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FilterMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.FilterMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FilterMediator.Properties.reverse, EsbMessages.FilterMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FilterMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.FilterMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FilterMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createConditionTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        filterConditionSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
                "Condition", true);
		Control itemLabel = createDescription(filterConditionSubPropertiesGroup, EsbViewsRepository.FilterMediator.Properties.conditionType, EsbMessages.FilterMediatorPropertiesEditionPart_ConditionTypeLabel);
		conditionType = new EMFComboViewer(filterConditionSubPropertiesGroup);
		conditionType.setContentProvider(new ArrayContentProvider());
		conditionType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData conditionTypeData = new GridData(GridData.FILL_HORIZONTAL);
		conditionType.getCombo().setLayoutData(conditionTypeData);
                conditionType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		conditionType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FilterMediator.Properties.conditionType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getConditionType()));
			}

		});
		conditionType.setID(EsbViewsRepository.FilterMediator.Properties.conditionType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, filterConditionSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FilterMediator.Properties.conditionType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConditionTypeEMFComboViewer
		conditionTypeElements = new Control [] {itemLabel, conditionType.getCombo(), itemHelp};
		conditionType.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRegexText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(filterConditionSubPropertiesGroup, EsbViewsRepository.FilterMediator.Properties.regex, EsbMessages.FilterMediatorPropertiesEditionPart_RegexLabel);
		regex = widgetFactory.createText(filterConditionSubPropertiesGroup, ""); //$NON-NLS-1$
		regex.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(filterConditionSubPropertiesGroup);
		GridData regexData = new GridData(GridData.FILL_HORIZONTAL);
		regex.setLayoutData(regexData);
		regex.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FilterMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FilterMediator.Properties.regex,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, regex.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FilterMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FilterMediator.Properties.regex,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, regex.getText()));
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
									FilterMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		regex.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FilterMediator.Properties.regex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, regex.getText()));
				}
			}
		});
		EditingUtils.setID(regex, EsbViewsRepository.FilterMediator.Properties.regex);
		EditingUtils.setEEFtype(regex, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, filterConditionSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FilterMediator.Properties.regex, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRegexText
		regexElements = new Control [] {itemLabel, regex, itemHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#getConditionType()
	 * 
	 */
	public Enumerator getConditionType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) conditionType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#initConditionType(Object input, Enumerator current)
	 */
	public void initConditionType(Object input, Enumerator current) {
		conditionType.setInput(input);
		conditionType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.conditionType);
		if (eefElementEditorReadOnlyState && conditionType.isEnabled()) {
			conditionType.setEnabled(false);
			conditionType.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !conditionType.isEnabled()) {
			conditionType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#setConditionType(Enumerator newValue)
	 * 
	 */
	public void setConditionType(Enumerator newValue) {
		conditionType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.conditionType);
		if (eefElementEditorReadOnlyState && conditionType.isEnabled()) {
			conditionType.setEnabled(false);
			conditionType.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !conditionType.isEnabled()) {
			conditionType.setEnabled(true);
		}	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#getRegex()
	 * 
	 */
	public String getRegex() {
		return regex.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart#setRegex(String newValue)
	 * 
	 */
	public void setRegex(String newValue) {
		if (newValue != null) {
			regex.setText(newValue);
		} else {
			regex.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FilterMediator.Properties.regex);
		if (eefElementEditorReadOnlyState && regex.isEnabled()) {
			regex.setEnabled(false);
			regex.setToolTipText(EsbMessages.FilterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !regex.isEnabled()) {
			regex.setEnabled(true);
		}	
		
	}






	// Start of user code for XPath specific getters and setters implementation
    @Override
    public NamespacedProperty getXPath() {
        return xPath;
    }

    @Override
    public void setXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            xPathText.setText(nameSpacedProperty.getPropertyValue());
            xPath = nameSpacedProperty;
        }
        
    }

	// End of user code

	// Start of user code for Source specific getters and setters implementation

    @Override
    public NamespacedProperty getSource() {
        return source;
    }

    @Override
    public void setSource(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            sourceText.setText(nameSpacedProperty.getPropertyValue());
            source = nameSpacedProperty;
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
		return EsbMessages.FilterMediator_Part_Title;
	}

	// Start of user code additional methods
    protected Composite createSourceWidget(FormToolkit widgetFactory, final Composite parent) {
        Control itemLabel = createDescription(filterConditionSubPropertiesGroup, EsbViewsRepository.FilterMediator.Properties.source,
                EsbMessages.FilterMediatorPropertiesEditionPart_SourceLabel);
        widgetFactory.paintBordersFor(filterConditionSubPropertiesGroup);
        if (source == null) {
            source = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = source.getPropertyValue().isEmpty() ? ""
                : source.getPropertyValue();
        sourceText = widgetFactory.createText(filterConditionSubPropertiesGroup, initValueExpression, SWT.READ_ONLY);
        sourceText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sourceText.setLayoutData(valueData);
        
        sourceText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, source);
                source = nspd.open();
                sourceText.setText(source.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FilterMediator.Properties.source, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSource()));
            }
            
        });
        
        sourceText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, source);
                    source = nspd.open();
                    sourceText.setText(source.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.FilterMediator.Properties.source, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getSource()));
                }
            }
            
        });
        
        EditingUtils.setID(sourceText,  EsbViewsRepository.FilterMediator.Properties.source);
        EditingUtils.setEEFtype(sourceText, "eef::Text");
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, filterConditionSubPropertiesGroup, propertiesEditionComponent
                .getHelpContent( EsbViewsRepository.FilterMediator.Properties.source, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        sourceElements = new Control[] { itemLabel, sourceText, itemHelp };
        return parent;
    }

    protected Composite createXPathWidget(FormToolkit widgetFactory, final Composite parent) {
        Control itemLabel = createDescription(filterConditionSubPropertiesGroup, EsbViewsRepository.FilterMediator.Properties.xPath,
                EsbMessages.FilterMediatorPropertiesEditionPart_XPathLabel);
        widgetFactory.paintBordersFor(filterConditionSubPropertiesGroup);
        if (xPath == null) {
            xPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = xPath.getPropertyValue().isEmpty() ? ""
                : xPath.getPropertyValue();
        xPathText = widgetFactory.createText(filterConditionSubPropertiesGroup, initValueExpression, SWT.READ_ONLY);
        xPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(filterConditionSubPropertiesGroup);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        xPathText.setLayoutData(valueData);

        xPathText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, xPath);
                xPath = nspd.open();
                xPathText.setText(xPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FilterMediator.Properties.xPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getXPath()));
            }
            
        });
        
        xPathText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, xPath);
                    xPath = nspd.open();
                    xPathText.setText(xPath.getPropertyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(FilterMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.FilterMediator.Properties.xPath, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getXPath()));
                }
            }
            
        });
        
        EditingUtils.setID(xPathText,  EsbViewsRepository.FilterMediator.Properties.xPath);
        EditingUtils.setEEFtype(xPathText, "eef::Text");
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, filterConditionSubPropertiesGroup, propertiesEditionComponent
                .getHelpContent( EsbViewsRepository.FilterMediator.Properties.xPath, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // aggregationExpressionElements = new Control[] { aggregationExpressionLabel, aggregationExpressionText,
        // aggregationExpressionHelp };
        xpathElements = new Control[] { itemLabel, xPathText, itemHelp };
        return parent;
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { propertiesGroup });
        epv.showEntry(new Control[] {filterConditionSubPropertiesGroup.getParent()}, false);
        epv.clearElements(new Composite[] { filterConditionSubPropertiesGroup });
        epv.showEntry(conditionTypeElements, false);

        if (getConditionType().equals(FilterMediatorConditionType.SOURCE_REGEX)) {
            epv.showEntry(sourceElements, false);
            epv.showEntry(regexElements, false);
        } else {
            epv.showEntry(xpathElements, false);
        }
        epv.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
	// End of user code

}
