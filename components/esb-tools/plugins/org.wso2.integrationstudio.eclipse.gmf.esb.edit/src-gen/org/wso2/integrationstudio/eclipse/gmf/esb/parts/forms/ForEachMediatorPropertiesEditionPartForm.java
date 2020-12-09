/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

import java.util.ArrayList;

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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart;
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
public class ForEachMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ForEachMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text forEachID;
	// Start of user code  for forEachExpression widgets declarations
    protected NamespacedProperty forEachExpression;
    protected Text forEachExpressionText;
	// End of user code

	protected EMFComboViewer sequenceType;
	protected Text sequenceName;
	// Start of user code  for sequenceKey widgets declarations
    protected RegistryKeyProperty sequenceKey;
    protected Text sequenceKeyText;
    protected Control[] descriptionElements;
    protected Control[] forEachIDElements;
    protected Control[] forEachExpressionElements;
    protected Control[] sequenceKeyElements;
    protected Control[] sequenceTypeElements;
    protected Control[] sequenceNameElements;
    protected Composite propertiesGroup;
    protected Composite sequenceGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ForEachMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ForEachMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence forEachMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = forEachMediatorStep.addStep(EsbViewsRepository.ForEachMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.forEachID);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.forEachExpression);
		propertiesStep.addStep(EsbViewsRepository.ForEachMediator.Properties.description);
		
		CompositionStep sequenceStep = forEachMediatorStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.class);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		sequenceStep.addStep(EsbViewsRepository.ForEachMediator.Sequence.sequenceKey);
		
		
		composer = new PartComposer(forEachMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ForEachMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Properties.forEachID) {
					return createForEachIDText(widgetFactory, parent);
				}
				// Start of user code for forEachExpression addToPart creation
                if(key == EsbViewsRepository.ForEachMediator.Properties.forEachExpression) {
                    return createForEachExpressionWidget(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.ForEachMediator.Sequence.class) {
					return createSequenceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Sequence.sequenceType) {
					return createSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ForEachMediator.Sequence.sequenceName) {
					return createSequenceNameText(widgetFactory, parent);
				}
				// Start of user code for sequenceKey addToPart creation
                if(key == EsbViewsRepository.ForEachMediator.Sequence.sequenceKey) {
                    return createsequenceKeyWidget(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.ForEachMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	    Control itemLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Properties.description, EsbMessages.ForEachMediatorPropertiesEditionPart_DescriptionLabel);
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
							ForEachMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ForEachMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForEachMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ForEachMediator.Properties.description,
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
									ForEachMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ForEachMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] { itemLabel, description, itemHelp };
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
		EditingUtils.setID(commentsList, EsbViewsRepository.ForEachMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ForEachMediator.Properties.commentsList, EsbMessages.ForEachMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ForEachMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ForEachMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}
	
	/**
	 * @generated NOT
	 */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ForEachMediator.Properties.reverse, EsbMessages.ForEachMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ForEachMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createForEachIDText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Properties.forEachID, EsbMessages.ForEachMediatorPropertiesEditionPart_ForEachIDLabel);
		forEachID = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		forEachID.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData forEachIDData = new GridData(GridData.FILL_HORIZONTAL);
		forEachID.setLayoutData(forEachIDData);
		forEachID.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ForEachMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ForEachMediator.Properties.forEachID,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forEachID.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForEachMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ForEachMediator.Properties.forEachID,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, forEachID.getText()));
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
									ForEachMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		forEachID.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Properties.forEachID, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, forEachID.getText()));
				}
			}
		});
		EditingUtils.setID(forEachID, EsbViewsRepository.ForEachMediator.Properties.forEachID);
		EditingUtils.setEEFtype(forEachID, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.forEachID, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createForEachIDText
		forEachIDElements = new Control[] { itemLabel, forEachID, itemHelp };
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSequenceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section sequenceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		sequenceSection.setText(EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceGroupLabel);
		GridData sequenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceSectionData.horizontalSpan = 3;
		sequenceSection.setLayoutData(sequenceSectionData);
		sequenceGroup = widgetFactory.createComposite(sequenceSection);
		GridLayout sequenceGroupLayout = new GridLayout();
		sequenceGroupLayout.numColumns = 3;
		sequenceGroup.setLayout(sequenceGroupLayout);
		sequenceSection.setClient(sequenceGroup);
		return sequenceGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Sequence.sequenceType, EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceTypeLabel);
		sequenceType = new EMFComboViewer(parent);
		sequenceType.setContentProvider(new ArrayContentProvider());
		sequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceType.getCombo().setLayoutData(sequenceTypeData);
                sequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Sequence.sequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceType()));
			}

		});
		sequenceType.setID(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Sequence.sequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceTypeEMFComboViewer
		sequenceTypeElements = new Control[] { itemLabel, sequenceType.getCombo(), itemHelp };
		sequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createSequenceNameText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Sequence.sequenceName, EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceNameLabel);
		sequenceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sequenceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sequenceNameData = new GridData(GridData.FILL_HORIZONTAL);
		sequenceName.setLayoutData(sequenceNameData);
		sequenceName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ForEachMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ForEachMediator.Sequence.sequenceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ForEachMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ForEachMediator.Sequence.sequenceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sequenceName.getText()));
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
									ForEachMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sequenceName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ForEachMediator.Sequence.sequenceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sequenceName.getText()));
				}
			}
		});
		EditingUtils.setID(sequenceName, EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		EditingUtils.setEEFtype(sequenceName, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Sequence.sequenceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSequenceNameText
		sequenceNameElements = new Control[] { itemLabel, sequenceName, itemHelp };
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getForEachID()
	 * 
	 */
	public String getForEachID() {
		return forEachID.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setForEachID(String newValue)
	 * 
	 */
	public void setForEachID(String newValue) {
		if (newValue != null) {
			forEachID.setText(newValue);
		} else {
			forEachID.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Properties.forEachID);
		if (eefElementEditorReadOnlyState && forEachID.isEnabled()) {
			forEachID.setEnabled(false);
			forEachID.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !forEachID.isEnabled()) {
			forEachID.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getSequenceType()
	 * 
	 */
	public Enumerator getSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#initSequenceType(Object input, Enumerator current)
	 */
	public void initSequenceType(Object input, Enumerator current) {
		sequenceType.setInput(input);
		sequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setSequenceType(Enumerator newValue)
	 * 
	 */
	public void setSequenceType(Enumerator newValue) {
		sequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceType);
		if (eefElementEditorReadOnlyState && sequenceType.isEnabled()) {
			sequenceType.setEnabled(false);
			sequenceType.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceType.isEnabled()) {
			sequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#getSequenceName()
	 * 
	 */
	public String getSequenceName() {
		return sequenceName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ForEachMediatorPropertiesEditionPart#setSequenceName(String newValue)
	 * 
	 */
	public void setSequenceName(String newValue) {
		if (newValue != null) {
			sequenceName.setText(newValue);
		} else {
			sequenceName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ForEachMediator.Sequence.sequenceName);
		if (eefElementEditorReadOnlyState && sequenceName.isEnabled()) {
			sequenceName.setEnabled(false);
			sequenceName.setToolTipText(EsbMessages.ForEachMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sequenceName.isEnabled()) {
			sequenceName.setEnabled(true);
		}	
		
	}






	// Start of user code for forEachExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getForEachExpression() {
        return forEachExpression;
    }

    @Override
    public void setForEachExpression(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            forEachExpressionText.setText(nameSpacedProperty.getPropertyValue());
            forEachExpression = nameSpacedProperty;
        }
        
    }
	// End of user code

	// Start of user code for sequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getSequenceKey() {
        return sequenceKey;
    }

    @Override
    public void setSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            sequenceKeyText.setText(registryKeyProperty.getKeyValue());
            sequenceKey = registryKeyProperty;
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
		return EsbMessages.ForEachMediator_Part_Title;
	}




	// Start of user code additional methods
   protected Composite createsequenceKeyWidget(FormToolkit widgetFactory, Composite parent) {
       Control sequenceKeyLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Sequence.sequenceKey, EsbMessages.ForEachMediatorPropertiesEditionPart_SequenceKeyLabel);
       widgetFactory.paintBordersFor(parent);
       if(sequenceKey == null) {
           sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
       } 
       String initValueExpression = sequenceKey.getKeyValue().isEmpty() ? "" : sequenceKey.getKeyValue();
       sequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
       sequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
       widgetFactory.paintBordersFor(parent);
       GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
       sequenceKeyText.setLayoutData(valueData);
        sequenceKeyText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                sequenceKeyText.setText(sequenceKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.ForEachMediator.Sequence.sequenceKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSequenceKey()));
            }

        });

        sequenceKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, sequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    sequenceKeyText.setText(sequenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(ForEachMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.ForEachMediator.Sequence.sequenceKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSequenceKey()));
                }
            }

        });
       
       EditingUtils.setID(sequenceKeyText, EsbViewsRepository.ForEachMediator.Sequence.sequenceKey);
       EditingUtils.setEEFtype(sequenceKeyText, "eef::Text");
       Control sequenceKeyHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Sequence.sequenceKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
       sequenceKeyElements = new Control[] {sequenceKeyLabel, sequenceKeyText, sequenceKeyHelp};
       return parent;
    }

    protected Composite createForEachExpressionWidget(FormToolkit widgetFactory, final Composite parent) {
        Control forEachExpressionLabel = createDescription(parent, EsbViewsRepository.ForEachMediator.Properties.forEachExpression, EsbMessages.ForEachMediatorPropertiesEditionPart_ForEachExpressionLabel);
        widgetFactory.paintBordersFor(parent);
        if(forEachExpression == null) {
            forEachExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        } 
        String initValueExpression = forEachExpression.getPropertyValue().isEmpty() ? "" : forEachExpression.getPropertyValue();
        forEachExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        forEachExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        forEachExpressionText.setLayoutData(valueData);
        forEachExpressionText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent event) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, forEachExpression);
                forEachExpression = nspd.open();
                forEachExpressionText.setText(forEachExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        ForEachMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.ForEachMediator.Properties.forEachExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getForEachExpression()));
            }

        });

        forEachExpressionText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, forEachExpression);
                    forEachExpression = nspd.open();
                    forEachExpressionText.setText(forEachExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ForEachMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.ForEachMediator.Properties.forEachExpression,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getForEachExpression()));
                }
            }
        });
        
        EditingUtils.setID(forEachExpressionText, EsbViewsRepository.ForEachMediator.Properties.forEachExpression);
        EditingUtils.setEEFtype(forEachExpressionText, "eef::Text");
        Control forEachExpressionHelp =FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ForEachMediator.Properties.forEachExpression, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        forEachExpressionElements = new Control[] {forEachExpressionLabel, forEachExpressionText, forEachExpressionHelp};
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { propertiesGroup, sequenceGroup });
        epv.showEntry(forEachIDElements, false);
        epv.showEntry(forEachExpressionElements, false);
        epv.showEntry(sequenceTypeElements, false);
        switch (getSequenceType().getLiteral()) {
        case "Registry Reference": {
            epv.showEntry(sequenceKeyElements, false);
            break;
        }
        case "Named Reference": {
            epv.showEntry(sequenceNameElements, false);
            break;
        }
        case "Anonymous": {
            break;
        }
        }
        epv.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
	// End of user code


}
