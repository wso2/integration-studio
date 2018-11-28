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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EnrichMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EnrichMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Button cloneSource;
	protected EMFComboViewer sourceType;
	protected Text sourceProperty;
	protected Text sourceXML;
	protected EMFComboViewer targetAction;
	protected EMFComboViewer targetType;
	protected Text targetProperty;
	protected EMFComboViewer inlineType;



	/**
	 * For {@link ISection} use only.
	 */
	public EnrichMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EnrichMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence enrichMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = enrichMediatorStep.addStep(EsbViewsRepository.EnrichMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.cloneSource);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.sourceType);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.sourceProperty);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.sourceXML);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.targetAction);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.targetProperty);
		propertiesStep.addStep(EsbViewsRepository.EnrichMediator.Properties.inlineType);
		
		
		composer = new PartComposer(enrichMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EnrichMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.cloneSource) {
					return createCloneSourceCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.sourceType) {
					return createSourceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.sourceProperty) {
					return createSourcePropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.sourceXML) {
					return createSourceXMLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.targetAction) {
					return createTargetActionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.targetProperty) {
					return createTargetPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EnrichMediator.Properties.inlineType) {
					return createInlineTypeEMFComboViewer(widgetFactory, parent);
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
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.EnrichMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.description, EsbMessages.EnrichMediatorPropertiesEditionPart_DescriptionLabel);
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
							EnrichMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnrichMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnrichMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnrichMediator.Properties.description,
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
									EnrichMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.EnrichMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
		EditingUtils.setID(commentsList, EsbViewsRepository.EnrichMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnrichMediator.Properties.commentsList, EsbMessages.EnrichMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "EnrichMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.EnrichMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnrichMediator.Properties.reverse, EsbMessages.EnrichMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.EnrichMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createCloneSourceCheckbox(FormToolkit widgetFactory, Composite parent) {
		cloneSource = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EnrichMediator.Properties.cloneSource, EsbMessages.EnrichMediatorPropertiesEditionPart_CloneSourceLabel), SWT.CHECK);
		cloneSource.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.cloneSource, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(cloneSource.getSelection())));
			}

		});
		GridData cloneSourceData = new GridData(GridData.FILL_HORIZONTAL);
		cloneSourceData.horizontalSpan = 2;
		cloneSource.setLayoutData(cloneSourceData);
		EditingUtils.setID(cloneSource, EsbViewsRepository.EnrichMediator.Properties.cloneSource);
		EditingUtils.setEEFtype(cloneSource, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.cloneSource, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCloneSourceCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.sourceType, EsbMessages.EnrichMediatorPropertiesEditionPart_SourceTypeLabel);
		sourceType = new EMFComboViewer(parent);
		sourceType.setContentProvider(new ArrayContentProvider());
		sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceType.getCombo().setLayoutData(sourceTypeData);
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
			}

		});
		sourceType.setID(EsbViewsRepository.EnrichMediator.Properties.sourceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.sourceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSourcePropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.sourceProperty, EsbMessages.EnrichMediatorPropertiesEditionPart_SourcePropertyLabel);
		sourceProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourcePropertyData = new GridData(GridData.FILL_HORIZONTAL);
		sourceProperty.setLayoutData(sourcePropertyData);
		sourceProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EnrichMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnrichMediator.Properties.sourceProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnrichMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnrichMediator.Properties.sourceProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceProperty.getText()));
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
									EnrichMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.sourceProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceProperty.getText()));
				}
			}
		});
		EditingUtils.setID(sourceProperty, EsbViewsRepository.EnrichMediator.Properties.sourceProperty);
		EditingUtils.setEEFtype(sourceProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.sourceProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourcePropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createSourceXMLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.sourceXML, EsbMessages.EnrichMediatorPropertiesEditionPart_SourceXMLLabel);
		sourceXML = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceXML.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceXMLData = new GridData(GridData.FILL_HORIZONTAL);
		sourceXML.setLayoutData(sourceXMLData);
		sourceXML.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EnrichMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnrichMediator.Properties.sourceXML,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceXML.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnrichMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnrichMediator.Properties.sourceXML,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceXML.getText()));
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
									EnrichMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceXML.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.sourceXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceXML.getText()));
				}
			}
		});
		EditingUtils.setID(sourceXML, EsbViewsRepository.EnrichMediator.Properties.sourceXML);
		EditingUtils.setEEFtype(sourceXML, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.sourceXML, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createTargetActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.targetAction, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetActionLabel);
		targetAction = new EMFComboViewer(parent);
		targetAction.setContentProvider(new ArrayContentProvider());
		targetAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetActionData = new GridData(GridData.FILL_HORIZONTAL);
		targetAction.getCombo().setLayoutData(targetActionData);
		targetAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.targetAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAction()));
			}

		});
		targetAction.setID(EsbViewsRepository.EnrichMediator.Properties.targetAction);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.targetAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetActionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.targetType, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(parent);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.EnrichMediator.Properties.targetType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.targetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTargetPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.targetProperty, EsbMessages.EnrichMediatorPropertiesEditionPart_TargetPropertyLabel);
		targetProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		targetProperty.setLayoutData(targetPropertyData);
		targetProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EnrichMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EnrichMediator.Properties.targetProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EnrichMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EnrichMediator.Properties.targetProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetProperty.getText()));
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
									EnrichMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.targetProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetProperty.getText()));
				}
			}
		});
		EditingUtils.setID(targetProperty, EsbViewsRepository.EnrichMediator.Properties.targetProperty);
		EditingUtils.setEEFtype(targetProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.targetProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createInlineTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EnrichMediator.Properties.inlineType, EsbMessages.EnrichMediatorPropertiesEditionPart_InlineTypeLabel);
		inlineType = new EMFComboViewer(parent);
		inlineType.setContentProvider(new ArrayContentProvider());
		inlineType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData inlineTypeData = new GridData(GridData.FILL_HORIZONTAL);
		inlineType.getCombo().setLayoutData(inlineTypeData);
		inlineType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EnrichMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EnrichMediator.Properties.inlineType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getInlineType()));
			}

		});
		inlineType.setID(EsbViewsRepository.EnrichMediator.Properties.inlineType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Properties.inlineType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInlineTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getCloneSource()
	 * 
	 */
	public Boolean getCloneSource() {
		return Boolean.valueOf(cloneSource.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setCloneSource(Boolean newValue)
	 * 
	 */
	public void setCloneSource(Boolean newValue) {
		if (newValue != null) {
			cloneSource.setSelection(newValue.booleanValue());
		} else {
			cloneSource.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.cloneSource);
		if (eefElementEditorReadOnlyState && cloneSource.isEnabled()) {
			cloneSource.setEnabled(false);
			cloneSource.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloneSource.isEnabled()) {
			cloneSource.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceType()
	 * 
	 */
	public Enumerator getSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
	 */
	public void initSourceType(Object input, Enumerator current) {
		sourceType.setInput(input);
		sourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
	 * 
	 */
	public void setSourceType(Enumerator newValue) {
		sourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceProperty()
	 * 
	 */
	public String getSourceProperty() {
		return sourceProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceProperty(String newValue)
	 * 
	 */
	public void setSourceProperty(String newValue) {
		if (newValue != null) {
			sourceProperty.setText(newValue);
		} else {
			sourceProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.sourceProperty);
		if (eefElementEditorReadOnlyState && sourceProperty.isEnabled()) {
			sourceProperty.setEnabled(false);
			sourceProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceProperty.isEnabled()) {
			sourceProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getSourceXML()
	 * 
	 */
	public String getSourceXML() {
		return sourceXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setSourceXML(String newValue)
	 * 
	 */
	public void setSourceXML(String newValue) {
		if (newValue != null) {
			sourceXML.setText(newValue);
		} else {
			sourceXML.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.sourceXML);
		if (eefElementEditorReadOnlyState && sourceXML.isEnabled()) {
			sourceXML.setEnabled(false);
			sourceXML.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceXML.isEnabled()) {
			sourceXML.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetAction()
	 * 
	 */
	public Enumerator getTargetAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetAction(Object input, Enumerator current)
	 */
	public void initTargetAction(Object input, Enumerator current) {
		targetAction.setInput(input);
		targetAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetAction(Enumerator newValue)
	 * 
	 */
	public void setTargetAction(Enumerator newValue) {
		targetAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getTargetProperty()
	 * 
	 */
	public String getTargetProperty() {
		return targetProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setTargetProperty(String newValue)
	 * 
	 */
	public void setTargetProperty(String newValue) {
		if (newValue != null) {
			targetProperty.setText(newValue);
		} else {
			targetProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.targetProperty);
		if (eefElementEditorReadOnlyState && targetProperty.isEnabled()) {
			targetProperty.setEnabled(false);
			targetProperty.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetProperty.isEnabled()) {
			targetProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#getInlineType()
	 * 
	 */
	public Enumerator getInlineType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) inlineType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#initInlineType(Object input, Enumerator current)
	 */
	public void initInlineType(Object input, Enumerator current) {
		inlineType.setInput(input);
		inlineType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.inlineType);
		if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
			inlineType.setEnabled(false);
			inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
			inlineType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EnrichMediatorPropertiesEditionPart#setInlineType(Enumerator newValue)
	 * 
	 */
	public void setInlineType(Enumerator newValue) {
		inlineType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EnrichMediator.Properties.inlineType);
		if (eefElementEditorReadOnlyState && inlineType.isEnabled()) {
			inlineType.setEnabled(false);
			inlineType.setToolTipText(EsbMessages.EnrichMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inlineType.isEnabled()) {
			inlineType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EnrichMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
