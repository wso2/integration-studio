/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.CompletionMessagesType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class SequencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SequencePropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text name;
	protected Text key;
	protected ReferencesTable outputConnector;
	protected List<ViewerFilter> outputConnectorBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outputConnectorFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable includedMediators;
	protected List<ViewerFilter> includedMediatorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> includedMediatorsFilters = new ArrayList<ViewerFilter>();
	protected Button receiveSequence;
	protected Button duplicate;
	protected EMFComboViewer referringSequenceType;
	// Start of user code  for staticReferenceKey widgets declarations
	protected RegistryKeyProperty staticReferenceKey;
    protected Text staticReferenceKeyText;
	// End of user code

	// Start of user code  for dynamicReferenceKey widgets declarations
    protected NamespacedProperty dynamicReferenceKey;
    protected Text dynamicReferenceKeyText;
    
    protected Control[] referringSequenceTypeElements;
    protected Control[] descriptionElements;
    protected Control[] staticReferenceKeyElements;
    protected Control[] dynamicReferenceKeyElements;
 
    protected Composite propertiesGroup;
    protected Composite referingSequenceSubsection;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public SequencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SequencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence sequenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sequenceStep.addStep(EsbViewsRepository.Sequence.Properties.class);
        // Start of user code
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.key);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.outputConnector);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.includedMediators);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.receiveSequence);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.referringSequenceType);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.staticReferenceKey);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.dynamicReferenceKey);
		propertiesStep.addStep(EsbViewsRepository.Sequence.Properties.description);
        // End of user code
		
		composer = new PartComposer(sequenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Sequence.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.key) {
					return createKeyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.outputConnector) {
					return createOutputConnectorTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.includedMediators) {
					return createIncludedMediatorsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.receiveSequence) {
					return createReceiveSequenceCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.duplicate) {
					return createDuplicateCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequence.Properties.referringSequenceType) {
					return createReferringSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for staticReferenceKey addToPart creation
				if (key == EsbViewsRepository.Sequence.Properties.staticReferenceKey) {
					return createStaticReferenceKey(widgetFactory, referingSequenceSubsection);
				}
				// End of user code
				// Start of user code for dynamicReferenceKey addToPart creation
				if (key == EsbViewsRepository.Sequence.Properties.dynamicReferenceKey) {
					return createDynamicReferenceKey(widgetFactory, referingSequenceSubsection);
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
		propertiesSection.setText(EsbMessages.SequencePropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.Sequence.Properties.description, EsbMessages.SequencePropertiesEditionPart_DescriptionLabel);
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
							SequencePropertiesEditionPartForm.this,
							EsbViewsRepository.Sequence.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SequencePropertiesEditionPartForm.this,
									EsbViewsRepository.Sequence.Properties.description,
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
									SequencePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.Sequence.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
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
		EditingUtils.setID(commentsList, EsbViewsRepository.Sequence.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequence.Properties.commentsList, EsbMessages.SequencePropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "Sequence", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.Sequence.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequence.Properties.reverse, EsbMessages.SequencePropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.Sequence.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Sequence.Properties.name, EsbMessages.SequencePropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SequencePropertiesEditionPartForm.this,
							EsbViewsRepository.Sequence.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SequencePropertiesEditionPartForm.this,
									EsbViewsRepository.Sequence.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
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
									SequencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EsbViewsRepository.Sequence.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.name, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createKeyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Sequence.Properties.key, EsbMessages.SequencePropertiesEditionPart_KeyLabel);
		key = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		key.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData keyData = new GridData(GridData.FILL_HORIZONTAL);
		key.setLayoutData(keyData);
		key.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SequencePropertiesEditionPartForm.this,
							EsbViewsRepository.Sequence.Properties.key,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, key.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SequencePropertiesEditionPartForm.this,
									EsbViewsRepository.Sequence.Properties.key,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, key.getText()));
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
									SequencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		key.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.key, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, key.getText()));
				}
			}
		});
		EditingUtils.setID(key, EsbViewsRepository.Sequence.Properties.key);
		EditingUtils.setEEFtype(key, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.key, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createKeyText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOutputConnectorTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.outputConnector = new ReferencesTable(getDescription(EsbViewsRepository.Sequence.Properties.outputConnector, EsbMessages.SequencePropertiesEditionPart_OutputConnectorLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				outputConnector.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				outputConnector.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				outputConnector.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				outputConnector.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.outputConnectorFilters) {
			this.outputConnector.addFilter(filter);
		}
		this.outputConnector.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.outputConnector, EsbViewsRepository.FORM_KIND));
		this.outputConnector.createControls(parent, widgetFactory);
		this.outputConnector.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.outputConnector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outputConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		outputConnectorData.horizontalSpan = 3;
		this.outputConnector.setLayoutData(outputConnectorData);
		this.outputConnector.setLowerBound(0);
		this.outputConnector.setUpperBound(-1);
		outputConnector.setID(EsbViewsRepository.Sequence.Properties.outputConnector);
		outputConnector.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOutputConnectorTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createIncludedMediatorsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.includedMediators = new ReferencesTable(getDescription(EsbViewsRepository.Sequence.Properties.includedMediators, EsbMessages.SequencePropertiesEditionPart_IncludedMediatorsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.includedMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				includedMediators.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.includedMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				includedMediators.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.includedMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				includedMediators.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.includedMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				includedMediators.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.includedMediatorsFilters) {
			this.includedMediators.addFilter(filter);
		}
		this.includedMediators.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.includedMediators, EsbViewsRepository.FORM_KIND));
		this.includedMediators.createControls(parent, widgetFactory);
		this.includedMediators.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.includedMediators, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData includedMediatorsData = new GridData(GridData.FILL_HORIZONTAL);
		includedMediatorsData.horizontalSpan = 3;
		this.includedMediators.setLayoutData(includedMediatorsData);
		this.includedMediators.setLowerBound(0);
		this.includedMediators.setUpperBound(-1);
		includedMediators.setID(EsbViewsRepository.Sequence.Properties.includedMediators);
		includedMediators.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createIncludedMediatorsTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createReceiveSequenceCheckbox(FormToolkit widgetFactory, Composite parent) {
		receiveSequence = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequence.Properties.receiveSequence, EsbMessages.SequencePropertiesEditionPart_ReceiveSequenceLabel), SWT.CHECK);
		receiveSequence.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.receiveSequence, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(receiveSequence.getSelection())));
			}

		});
		GridData receiveSequenceData = new GridData(GridData.FILL_HORIZONTAL);
		receiveSequenceData.horizontalSpan = 2;
		receiveSequence.setLayoutData(receiveSequenceData);
		EditingUtils.setID(receiveSequence, EsbViewsRepository.Sequence.Properties.receiveSequence);
		EditingUtils.setEEFtype(receiveSequence, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.receiveSequence, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReceiveSequenceCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createDuplicateCheckbox(FormToolkit widgetFactory, Composite parent) {
		duplicate = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequence.Properties.duplicate, EsbMessages.SequencePropertiesEditionPart_DuplicateLabel), SWT.CHECK);
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.Sequence.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.duplicate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createReferringSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    referingSequenceSubsection = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Refering Sequence", true);
		Control referringSequenceTypeLable = createDescription(referingSequenceSubsection, EsbViewsRepository.Sequence.Properties.referringSequenceType, EsbMessages.SequencePropertiesEditionPart_ReferringSequenceTypeLabel);
		referringSequenceType = new EMFComboViewer(referingSequenceSubsection);
		referringSequenceType.setContentProvider(new ArrayContentProvider());
		referringSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData referringSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		referringSequenceType.getCombo().setLayoutData(referringSequenceTypeData);
                referringSequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		referringSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencePropertiesEditionPartForm.this, EsbViewsRepository.Sequence.Properties.referringSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getReferringSequenceType()));
			}

		});
		referringSequenceType.setID(EsbViewsRepository.Sequence.Properties.referringSequenceType);
		Control referringSequenceTypeHelp = FormUtils.createHelpButton(widgetFactory, referingSequenceSubsection, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.referringSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReferringSequenceTypeEMFComboViewer
		referringSequenceTypeElements = new Control[] { referringSequenceTypeLable, referringSequenceType.getCombo(),
				referringSequenceTypeHelp };
		referringSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
			    refresh();
			}
		});
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.Sequence_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getKey()
	 * 
	 */
	public String getKey() {
		return key.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setKey(String newValue)
	 * 
	 */
	public void setKey(String newValue) {
		if (newValue != null) {
			key.setText(newValue);
		} else {
			key.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.key);
		if (eefElementEditorReadOnlyState && key.isEnabled()) {
			key.setEnabled(false);
			key.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !key.isEnabled()) {
			key.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#initOutputConnector(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutputConnector(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outputConnector.setContentProvider(contentProvider);
		outputConnector.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.outputConnector);
		if (eefElementEditorReadOnlyState && outputConnector.isEnabled()) {
			outputConnector.setEnabled(false);
			outputConnector.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputConnector.isEnabled()) {
			outputConnector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#updateOutputConnector()
	 * 
	 */
	public void updateOutputConnector() {
	outputConnector.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#addFilterOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOutputConnector(ViewerFilter filter) {
		outputConnectorFilters.add(filter);
		if (this.outputConnector != null) {
			this.outputConnector.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#addBusinessFilterOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutputConnector(ViewerFilter filter) {
		outputConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#isContainedInOutputConnectorTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutputConnectorTable(EObject element) {
		return ((ReferencesTableSettings)outputConnector.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#initIncludedMediators(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initIncludedMediators(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		includedMediators.setContentProvider(contentProvider);
		includedMediators.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.includedMediators);
		if (eefElementEditorReadOnlyState && includedMediators.isEnabled()) {
			includedMediators.setEnabled(false);
			includedMediators.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !includedMediators.isEnabled()) {
			includedMediators.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#updateIncludedMediators()
	 * 
	 */
	public void updateIncludedMediators() {
	includedMediators.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#addFilterIncludedMediators(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIncludedMediators(ViewerFilter filter) {
		includedMediatorsFilters.add(filter);
		if (this.includedMediators != null) {
			this.includedMediators.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#addBusinessFilterIncludedMediators(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIncludedMediators(ViewerFilter filter) {
		includedMediatorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#isContainedInIncludedMediatorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInIncludedMediatorsTable(EObject element) {
		return ((ReferencesTableSettings)includedMediators.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getReceiveSequence()
	 * 
	 */
	public Boolean getReceiveSequence() {
		return Boolean.valueOf(receiveSequence.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setReceiveSequence(Boolean newValue)
	 * 
	 */
	public void setReceiveSequence(Boolean newValue) {
		if (newValue != null) {
			receiveSequence.setSelection(newValue.booleanValue());
		} else {
			receiveSequence.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.receiveSequence);
		if (eefElementEditorReadOnlyState && receiveSequence.isEnabled()) {
			receiveSequence.setEnabled(false);
			receiveSequence.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !receiveSequence.isEnabled()) {
			receiveSequence.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#getReferringSequenceType()
	 * 
	 */
	public Enumerator getReferringSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) referringSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#initReferringSequenceType(Object input, Enumerator current)
	 */
	public void initReferringSequenceType(Object input, Enumerator current) {
		referringSequenceType.setInput(input);
		referringSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.referringSequenceType);
		if (eefElementEditorReadOnlyState && referringSequenceType.isEnabled()) {
			referringSequenceType.setEnabled(false);
			referringSequenceType.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !referringSequenceType.isEnabled()) {
			referringSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart#setReferringSequenceType(Enumerator newValue)
	 * 
	 */
	public void setReferringSequenceType(Enumerator newValue) {
		referringSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequence.Properties.referringSequenceType);
		if (eefElementEditorReadOnlyState && referringSequenceType.isEnabled()) {
			referringSequenceType.setEnabled(false);
			referringSequenceType.setToolTipText(EsbMessages.Sequence_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !referringSequenceType.isEnabled()) {
			referringSequenceType.setEnabled(true);
		}	
		
	}






	// Start of user code for staticReferenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getStaticReferenceKey() {
        return staticReferenceKey;
    }

    @Override
    public void setStaticReferenceKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            staticReferenceKeyText.setText(registryKeyProperty.getKeyValue());
            staticReferenceKey = registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for dynamicReferenceKey specific getters and setters implementation
    @Override
    public NamespacedProperty getdDynamicReferenceKey() {
        return dynamicReferenceKey;
    }

    @Override
    public void setDynamicReferenceKey(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            dynamicReferenceKeyText.setText(nameSpacedProperty.getPropertyValue());
            dynamicReferenceKey = nameSpacedProperty;
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
		return EsbMessages.Sequence_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createStaticReferenceKey(FormToolkit widgetFactory, Composite parent) {
		Control staticReferenceKeyLabel = createDescription(parent,
				EsbViewsRepository.Sequence.Properties.staticReferenceKey,
				"Static Reference Key");
		widgetFactory.paintBordersFor(parent);
		if (staticReferenceKey == null) {
			staticReferenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = staticReferenceKey.getKeyValue().isEmpty() ? "" : staticReferenceKey.getKeyValue();
		staticReferenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		staticReferenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		staticReferenceKeyText.setLayoutData(valueData);
        staticReferenceKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, staticReferenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                staticReferenceKeyText.setText(staticReferenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        SequencePropertiesEditionPartForm.this,
                        EsbViewsRepository.Sequence.Properties.staticReferenceKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getStaticReferenceKey()));
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        SequencePropertiesEditionPartForm.this, 
                        EsbViewsRepository.Sequence.Properties.name, PropertiesEditionEvent.COMMIT, 
                        PropertiesEditionEvent.SET, null, getStaticReferenceKey().getKeyValue()));
            }

        });
        
        staticReferenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, staticReferenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    staticReferenceKeyText.setText(staticReferenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            SequencePropertiesEditionPartForm.this,
                            EsbViewsRepository.Sequence.Properties.staticReferenceKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getStaticReferenceKey()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            SequencePropertiesEditionPartForm.this,
                            EsbViewsRepository.Sequence.Properties.name, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getStaticReferenceKey().getKeyValue()));
                }
            }
            
        });
        
		EditingUtils.setID(staticReferenceKeyText, EsbViewsRepository.Sequence.Properties.staticReferenceKey);
		EditingUtils.setEEFtype(staticReferenceKeyText, "eef::Text");
		Control staticReferenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequence.Properties.staticReferenceKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		staticReferenceKeyElements = new Control[] { staticReferenceKeyLabel, staticReferenceKeyText,
				staticReferenceKeyHelp };
		return parent;
	}
	
	protected Composite createDynamicReferenceKey(FormToolkit widgetFactory, final Composite parent) {
		Control dynamicReferenceKeyLabel = createDescription(parent,
				EsbViewsRepository.Sequence.Properties.dynamicReferenceKey,
				EsbMessages.SequencePropertiesEditionPart_DynamicReferenceKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (dynamicReferenceKey == null) {
			dynamicReferenceKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		}
		String initValueExpression = dynamicReferenceKey.getPropertyValue().isEmpty() ? ""
				: dynamicReferenceKey.getPropertyValue();
		dynamicReferenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		dynamicReferenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		dynamicReferenceKeyText.setLayoutData(valueData);

		dynamicReferenceKeyText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown(MouseEvent event) {
                openDynamicReferenceKeyNamespacedPropertyEditor(parent);
            }
            
        });
        
		dynamicReferenceKeyText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openDynamicReferenceKeyNamespacedPropertyEditor(parent);
                }
            }
            
        });
		
		EditingUtils.setID(dynamicReferenceKeyText,
				EsbViewsRepository.Sequence.Properties.dynamicReferenceKey);
		EditingUtils.setEEFtype(dynamicReferenceKeyText, "eef::Text");
		Control dynamicReferenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						EsbViewsRepository.Sequence.Properties.dynamicReferenceKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		dynamicReferenceKeyElements = new Control[] { dynamicReferenceKeyLabel, dynamicReferenceKeyText,
				dynamicReferenceKeyHelp };
		return parent;
	}
	
    private void openDynamicReferenceKeyNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, dynamicReferenceKey);
        dynamicReferenceKey = nspd.open();
        dynamicReferenceKeyText.setText(dynamicReferenceKey.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                SequencePropertiesEditionPartForm.this,
                EsbViewsRepository.Sequence.Properties.dynamicReferenceKey,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getdDynamicReferenceKey()));
    }
	
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {

        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { propertiesGroup });
        epv.showEntry(new Control[] { referingSequenceSubsection.getParent() }, false);
        epv.clearElements(new Composite[] { referingSequenceSubsection });

        epv.showEntry(referringSequenceTypeElements, false);
        if (getReferringSequenceType().getName().equals("STATIC")) {
            epv.showEntry(staticReferenceKeyElements, false);
        } else if (getReferringSequenceType().getName().equals("DYNAMIC")) {
            epv.showEntry(dynamicReferenceKeyElements, false);
        }
        epv.showEntry(descriptionElements, false);

        view.layout(true, true);
    }

	// End of user code


}
