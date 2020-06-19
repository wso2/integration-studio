/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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
import org.wso2.developerstudio.eclipse.gmf.esb.CacheType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart;
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
public class XQueryMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, XQueryMediatorPropertiesEditionPart {

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable variables;
	protected List<ViewerFilter> variablesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> variablesFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer scriptKeyType;
	// Start of user code  for staticScriptKey widgets declarations
	protected RegistryKeyProperty staticScriptKey;
	protected Text staticScriptKeyText;
	// End of user code

	// Start of user code  for targetXPath widgets declarations
	protected NamespacedProperty targetXPath;
	protected Text targetXPathText;
	// End of user code

	// Start of user code  for dynamicScriptKey widgets declarations
	protected NamespacedProperty dynamicScriptKey;
	protected Text dynamicScriptKeyText;
	
	protected Control[] staticScriptKeyElements;
	protected Control[] scriptKeyTypeElements;
	protected Control[] variablesElements;
	protected Control[] descriptionElements;
	protected Control[] targetXPathElements;
	protected Control[] dynamicScriptKeyElements;
	
	protected Composite propertiesGroup;
	protected Composite filterVariablesSubPropetiesGroup;
	// End of user code

	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public XQueryMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XQueryMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xQueryMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xQueryMediatorStep.addStep(EsbViewsRepository.XQueryMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.scriptKeyType);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.staticScriptKey);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.targetXPath);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.variables);
		propertiesStep.addStep(EsbViewsRepository.XQueryMediator.Properties.description);
		
		
		composer = new PartComposer(xQueryMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XQueryMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryMediator.Properties.variables) {
					return createVariablesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.XQueryMediator.Properties.scriptKeyType) {
					return createScriptKeyTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for staticScriptKey addToPart creation
				if (key == EsbViewsRepository.XQueryMediator.Properties.staticScriptKey) {
                    return createStaticScriptKey(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for targetXPath addToPart creation
				if ( key == EsbViewsRepository.XQueryMediator.Properties.targetXPath) {
                    return createTargetXPath(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for dynamicScriptKey addToPart creation
				if ( key == EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey) {
                    return createDynamicScriptKey(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.XQueryMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.XQueryMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.XQueryMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.XQueryMediator.Properties.commentsList, EsbMessages.XQueryMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "XQueryMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.XQueryMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.XQueryMediator.Properties.reverse, EsbMessages.XQueryMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.XQueryMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createVariablesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    filterVariablesSubPropetiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent,
	            "Variables", true);
	    Control [] previousControls = filterVariablesSubPropetiesGroup.getChildren();
	    
		this.variables = new ReferencesTable(getDescription(EsbViewsRepository.XQueryMediator.Properties.variables, EsbMessages.XQueryMediatorPropertiesEditionPart_VariablesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.variables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				variables.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.variables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				variables.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.variables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				variables.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.variables, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				variables.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.variablesFilters) {
			this.variables.addFilter(filter);
		}
		this.variables.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.variables, EsbViewsRepository.FORM_KIND));
		this.variables.createControls(filterVariablesSubPropetiesGroup, widgetFactory);
		this.variables.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.variables, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData variablesData = new GridData(GridData.FILL_HORIZONTAL);
		variablesData.horizontalSpan = 3;
		this.variables.setLayoutData(variablesData);
		this.variables.setLowerBound(0);
		this.variables.setUpperBound(-1);
		variables.setID(EsbViewsRepository.XQueryMediator.Properties.variables);
		variables.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createVariablesTableComposition
		Control [] newControls = filterVariablesSubPropetiesGroup.getChildren();
		variablesElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createScriptKeyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control scriptKeyTypeLabel = createDescription(parent, EsbViewsRepository.XQueryMediator.Properties.scriptKeyType, EsbMessages.XQueryMediatorPropertiesEditionPart_ScriptKeyTypeLabel);
		scriptKeyType = new EMFComboViewer(parent);
		scriptKeyType.setContentProvider(new ArrayContentProvider());
		scriptKeyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData scriptKeyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		scriptKeyType.getCombo().setLayoutData(scriptKeyTypeData);
                scriptKeyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		scriptKeyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.scriptKeyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptKeyType()));
				validate();
			}

		});
		scriptKeyType.setID(EsbViewsRepository.XQueryMediator.Properties.scriptKeyType);
		Control scriptKeyTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.scriptKeyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptKeyTypeEMFComboViewer
		scriptKeyTypeElements = new Control[] {scriptKeyTypeLabel, scriptKeyType.getCombo(), scriptKeyTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.XQueryMediator.Properties.description, EsbMessages.XQueryMediatorPropertiesEditionPart_DescriptionLabel);
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
							XQueryMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.XQueryMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									XQueryMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.XQueryMediator.Properties.description,
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
									XQueryMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.XQueryMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#initVariables(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initVariables(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		variables.setContentProvider(contentProvider);
		variables.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.variables);
		if (eefElementEditorReadOnlyState && variables.isEnabled()) {
			variables.setEnabled(false);
			variables.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !variables.isEnabled()) {
			variables.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#updateVariables()
	 * 
	 */
	public void updateVariables() {
	variables.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#addFilterVariables(ViewerFilter filter)
	 * 
	 */
	public void addFilterToVariables(ViewerFilter filter) {
		variablesFilters.add(filter);
		if (this.variables != null) {
			this.variables.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#addBusinessFilterVariables(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToVariables(ViewerFilter filter) {
		variablesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#isContainedInVariablesTable(EObject element)
	 * 
	 */
	public boolean isContainedInVariablesTable(EObject element) {
		return ((ReferencesTableSettings)variables.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#getScriptKeyType()
	 * 
	 */
	public Enumerator getScriptKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scriptKeyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#initScriptKeyType(Object input, Enumerator current)
	 */
	public void initScriptKeyType(Object input, Enumerator current) {
		scriptKeyType.setInput(input);
		scriptKeyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.scriptKeyType);
		if (eefElementEditorReadOnlyState && scriptKeyType.isEnabled()) {
			scriptKeyType.setEnabled(false);
			scriptKeyType.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptKeyType.isEnabled()) {
			scriptKeyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#setScriptKeyType(Enumerator newValue)
	 * 
	 */
	public void setScriptKeyType(Enumerator newValue) {
		scriptKeyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.scriptKeyType);
		if (eefElementEditorReadOnlyState && scriptKeyType.isEnabled()) {
			scriptKeyType.setEnabled(false);
			scriptKeyType.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptKeyType.isEnabled()) {
			scriptKeyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XQueryMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XQueryMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.XQueryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	// Start of user code for staticScriptKey specific getters and setters implementation
    @Override
    public void setStaticScriptKey(RegistryKeyProperty registryKeyProperty) {
        if (staticScriptKey != null) {
            staticScriptKey = registryKeyProperty;
            staticScriptKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getStaticScriptKeyProperty() {
        return staticScriptKey;
    }
	// End of user code

	// Start of user code for targetXPath specific getters and setters implementation
    @Override
    public void setTargetXPath(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            targetXPath = namespacedProperty;
            targetXPathText.setText(namespacedProperty.getPropertyValue());
        }
    }

    @Override
    public NamespacedProperty getTargetXpath() {
        return targetXPath;
    }
	// End of user code

	// Start of user code for dynamicScriptKey specific getters and setters implementation
    @Override
    public void setDynamicScriptKey(NamespacedProperty namespacedProperty) {
        if (namespacedProperty != null) {
            dynamicScriptKey = namespacedProperty;
            dynamicScriptKeyText.setText(namespacedProperty.getPropertyValue());
        }
    }

    @Override
    public NamespacedProperty getDynamicScriptKey() {
        return dynamicScriptKey;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.XQueryMediator_Part_Title;
	}







	// Start of user code additional methods
	
	protected Composite createStaticScriptKey(FormToolkit widgetFactory, final Composite parent) {
        Control staticScriptKeyLabel = createDescription(parent, EsbViewsRepository.XQueryMediator.Properties.staticScriptKey,
                EsbMessages.XQueryMediatorPropertiesEditionPart_StaticScriptKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if (staticScriptKey == null) {
            staticScriptKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initStaticScriptKey = staticScriptKey.getKeyValue().isEmpty() ? "" : staticScriptKey.getKeyValue();
        staticScriptKeyText = widgetFactory.createText(parent, initStaticScriptKey, SWT.READ_ONLY);
        staticScriptKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        staticScriptKeyText.setLayoutData(valueData);
        staticScriptKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, staticScriptKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                staticScriptKeyText.setText(staticScriptKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.XQueryMediator.Properties.staticScriptKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getStaticScriptKeyProperty()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        EditingUtils.setID(staticScriptKeyText, EsbViewsRepository.XQueryMediator.Properties.staticScriptKey);
        EditingUtils.setEEFtype(staticScriptKeyText, "eef::Text");
        Control staticScriptKeyHelp = FormUtils
                .createHelpButton(widgetFactory, parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.XQueryMediator.Properties.staticScriptKey, EsbViewsRepository.FORM_KIND),
                        null);
        staticScriptKeyElements = new Control[] { staticScriptKeyLabel, staticScriptKeyText, staticScriptKeyHelp };
        return parent;
    }
	
	protected Composite createTargetXPath(FormToolkit widgetFactory, final Composite parent) {
        Control targetXPathLabel = createDescription(parent, EsbViewsRepository.XQueryMediator.Properties.targetXPath, 
                EsbMessages.XQueryMediatorPropertiesEditionPart_TargetXPathLabel);
        widgetFactory.paintBordersFor(parent);
        if(targetXPath == null) {
            targetXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initTargetXPath = targetXPath.getPropertyValue().isEmpty() ? "" : targetXPath.getPropertyValue();
        targetXPathText = widgetFactory.createText(parent, initTargetXPath, SWT.READ_ONLY);
        targetXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        targetXPathText.setLayoutData(valueData);
        targetXPathText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent event ) {
                openTargetXPathWidgetNamespacedPropertyEditor(parent);
            }

        });
        targetXPathText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openTargetXPathWidgetNamespacedPropertyEditor(parent);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}
        });
        EditingUtils.setID(targetXPathText, EsbViewsRepository.XQueryMediator.Properties.targetXPath);
        EditingUtils.setEEFtype(targetXPathText, "eef::Text");
        Control targetXPathHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.targetXPath,
                EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        targetXPathElements = new Control[] {targetXPathLabel, targetXPathText, targetXPathHelp};
        return parent;
    }
	
	protected Composite createDynamicScriptKey(FormToolkit widgetFactory, final Composite parent) {
        Control dynamicScriptKeyLabel = createDescription(parent, EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey,
                EsbMessages.XQueryMediatorPropertiesEditionPart_DynamicScriptKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(dynamicScriptKey == null) {
            dynamicScriptKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initDynamicScriptKey = dynamicScriptKey.getPropertyValue().isEmpty() ? "" : dynamicScriptKey.getPropertyValue();
        dynamicScriptKeyText = widgetFactory.createText(parent, initDynamicScriptKey);
        dynamicScriptKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        dynamicScriptKeyText.setLayoutData(valueData);
        dynamicScriptKeyText.addFocusListener(new FocusAdapter() {
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
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, dynamicScriptKey);
                dynamicScriptKey = nspd.open();
                dynamicScriptKeyText.setText(dynamicScriptKey.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XQueryMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDynamicScriptKey()));
            }
        });
        EditingUtils.setID(dynamicScriptKeyText, EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey);
        EditingUtils.setEEFtype(dynamicScriptKeyText, "eef::Text");
        Control dynamicScriptKeyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XQueryMediator.Properties.dynamicScriptKey,
                EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        dynamicScriptKeyElements = new Control[] {dynamicScriptKeyLabel, dynamicScriptKeyText, dynamicScriptKeyHelp};
        return parent;
    }

    private void openTargetXPathWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                targetXPath);
        targetXPath = nspd.open();
        targetXPathText.setText(targetXPath.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                XQueryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.XQueryMediator.Properties.targetXPath,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetXpath()));
    }

    @Override
    public void refresh() {
        super.refresh();
        validate();
    }
    
    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        
        eu.showEntry(scriptKeyTypeElements, false);
        
        if (getScriptKeyType() != null && getScriptKeyType().getName().equals(KeyType.STATIC.getName())) {
            eu.showEntry(staticScriptKeyElements, false);
        } else if (getScriptKeyType() != null && getScriptKeyType().getName().equals(KeyType.DYNAMIC.getName())) {
            eu.showEntry(dynamicScriptKeyElements, false);
        }
        eu.showEntry(new Control[] { filterVariablesSubPropetiesGroup.getParent() }, false);
        eu.clearElements(new Composite[] { filterVariablesSubPropetiesGroup });
        eu.showEntry(targetXPathElements, false);
        eu.showEntry(variablesElements, false);
        eu.showEntry(descriptionElements, false);
        
        view.layout(true, true);
    }
	// End of user code


}
