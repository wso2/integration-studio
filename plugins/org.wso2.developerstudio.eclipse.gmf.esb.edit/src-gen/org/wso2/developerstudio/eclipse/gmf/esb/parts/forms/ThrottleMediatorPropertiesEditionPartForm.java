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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ThrottleMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ThrottleMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text groupId;
	protected EMFComboViewer policyType;
	protected Text maxConcurrentAccessCount;
	protected ReferencesTable policyEntries;
	protected List<ViewerFilter> policyEntriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> policyEntriesFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer onAcceptBranchsequenceType;
	protected EMFComboViewer onRejectBranchsequenceType;



	/**
	 * For {@link ISection} use only.
	 */
	public ThrottleMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ThrottleMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence throttleMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.groupId);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.policyType);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.policyEntries);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType);
		propertiesStep.addStep(EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType);
		
		
		composer = new PartComposer(throttleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ThrottleMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.groupId) {
					return createGroupIdText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.policyType) {
					return createPolicyTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount) {
					return createMaxConcurrentAccessCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.policyEntries) {
					return createPolicyEntriesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType) {
					return createOnAcceptBranchsequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType) {
					return createOnRejectBranchsequenceTypeEMFComboViewer(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.description, EsbMessages.ThrottleMediatorPropertiesEditionPart_DescriptionLabel);
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
							ThrottleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottleMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.Properties.description,
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
									ThrottleMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ThrottleMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.ThrottleMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ThrottleMediator.Properties.commentsList, EsbMessages.ThrottleMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ThrottleMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ThrottleMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ThrottleMediator.Properties.reverse, EsbMessages.ThrottleMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ThrottleMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createGroupIdText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.groupId, EsbMessages.ThrottleMediatorPropertiesEditionPart_GroupIdLabel);
		groupId = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		groupId.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData groupIdData = new GridData(GridData.FILL_HORIZONTAL);
		groupId.setLayoutData(groupIdData);
		groupId.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottleMediator.Properties.groupId,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.Properties.groupId,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, groupId.getText()));
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
									ThrottleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		groupId.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.groupId, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
				}
			}
		});
		EditingUtils.setID(groupId, EsbViewsRepository.ThrottleMediator.Properties.groupId);
		EditingUtils.setEEFtype(groupId, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.groupId, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createGroupIdText

		// End of user code
		return parent;
	}

	
	protected Composite createPolicyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.policyType, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyTypeLabel);
		policyType = new EMFComboViewer(parent);
		policyType.setContentProvider(new ArrayContentProvider());
		policyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		policyType.getCombo().setLayoutData(policyTypeData);
		policyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyType()));
			}

		});
		policyType.setID(EsbViewsRepository.ThrottleMediator.Properties.policyType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.policyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPolicyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMaxConcurrentAccessCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount, EsbMessages.ThrottleMediatorPropertiesEditionPart_MaxConcurrentAccessCountLabel);
		maxConcurrentAccessCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxConcurrentAccessCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxConcurrentAccessCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxConcurrentAccessCount.setLayoutData(maxConcurrentAccessCountData);
		maxConcurrentAccessCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxConcurrentAccessCount.getText()));
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
									ThrottleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxConcurrentAccessCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
				}
			}
		});
		EditingUtils.setID(maxConcurrentAccessCount, EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount);
		EditingUtils.setEEFtype(maxConcurrentAccessCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxConcurrentAccessCountText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPolicyEntriesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.policyEntries = new ReferencesTable(getDescription(EsbViewsRepository.ThrottleMediator.Properties.policyEntries, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyEntriesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				policyEntries.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				policyEntries.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				policyEntries.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				policyEntries.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.policyEntriesFilters) {
			this.policyEntries.addFilter(filter);
		}
		this.policyEntries.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.policyEntries, EsbViewsRepository.FORM_KIND));
		this.policyEntries.createControls(parent, widgetFactory);
		this.policyEntries.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.policyEntries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData policyEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		policyEntriesData.horizontalSpan = 3;
		this.policyEntries.setLayoutData(policyEntriesData);
		this.policyEntries.setLowerBound(0);
		this.policyEntries.setUpperBound(-1);
		policyEntries.setID(EsbViewsRepository.ThrottleMediator.Properties.policyEntries);
		policyEntries.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPolicyEntriesTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createOnAcceptBranchsequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptBranchsequenceTypeLabel);
		onAcceptBranchsequenceType = new EMFComboViewer(parent);
		onAcceptBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onAcceptBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onAcceptBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptBranchsequenceType.getCombo().setLayoutData(onAcceptBranchsequenceTypeData);
		onAcceptBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnAcceptBranchsequenceType()));
			}

		});
		onAcceptBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnAcceptBranchsequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOnRejectBranchsequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnRejectBranchsequenceTypeLabel);
		onRejectBranchsequenceType = new EMFComboViewer(parent);
		onRejectBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onRejectBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onRejectBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onRejectBranchsequenceType.getCombo().setLayoutData(onRejectBranchsequenceTypeData);
		onRejectBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectBranchsequenceType()));
			}

		});
		onRejectBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnRejectBranchsequenceTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getGroupId()
	 * 
	 */
	public String getGroupId() {
		return groupId.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setGroupId(String newValue)
	 * 
	 */
	public void setGroupId(String newValue) {
		if (newValue != null) {
			groupId.setText(newValue);
		} else {
			groupId.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.groupId);
		if (eefElementEditorReadOnlyState && groupId.isEnabled()) {
			groupId.setEnabled(false);
			groupId.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !groupId.isEnabled()) {
			groupId.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getPolicyType()
	 * 
	 */
	public Enumerator getPolicyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyType(Object input, Enumerator current)
	 */
	public void initPolicyType(Object input, Enumerator current) {
		policyType.setInput(input);
		policyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setPolicyType(Enumerator newValue)
	 * 
	 */
	public void setPolicyType(Enumerator newValue) {
		policyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.policyType);
		if (eefElementEditorReadOnlyState && policyType.isEnabled()) {
			policyType.setEnabled(false);
			policyType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyType.isEnabled()) {
			policyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getMaxConcurrentAccessCount()
	 * 
	 */
	public String getMaxConcurrentAccessCount() {
		return maxConcurrentAccessCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setMaxConcurrentAccessCount(String newValue)
	 * 
	 */
	public void setMaxConcurrentAccessCount(String newValue) {
		if (newValue != null) {
			maxConcurrentAccessCount.setText(newValue);
		} else {
			maxConcurrentAccessCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.maxConcurrentAccessCount);
		if (eefElementEditorReadOnlyState && maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(false);
			maxConcurrentAccessCount.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxConcurrentAccessCount.isEnabled()) {
			maxConcurrentAccessCount.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyEntries(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPolicyEntries(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		policyEntries.setContentProvider(contentProvider);
		policyEntries.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.policyEntries);
		if (eefElementEditorReadOnlyState && policyEntries.isEnabled()) {
			policyEntries.setEnabled(false);
			policyEntries.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policyEntries.isEnabled()) {
			policyEntries.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#updatePolicyEntries()
	 * 
	 */
	public void updatePolicyEntries() {
	policyEntries.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesFilters.add(filter);
		if (this.policyEntries != null) {
			this.policyEntries.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addBusinessFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#isContainedInPolicyEntriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPolicyEntriesTable(EObject element) {
		return ((ReferencesTableSettings)policyEntries.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnAcceptBranchsequenceType()
	 * 
	 */
	public Enumerator getOnAcceptBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onAcceptBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnAcceptBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnAcceptBranchsequenceType(Object input, Enumerator current) {
		onAcceptBranchsequenceType.setInput(input);
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType);
		if (eefElementEditorReadOnlyState && onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(false);
			onAcceptBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnAcceptBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnAcceptBranchsequenceType(Enumerator newValue) {
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.onAcceptBranchsequenceType);
		if (eefElementEditorReadOnlyState && onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(false);
			onAcceptBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptBranchsequenceType.isEnabled()) {
			onAcceptBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnRejectBranchsequenceType()
	 * 
	 */
	public Enumerator getOnRejectBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onRejectBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnRejectBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnRejectBranchsequenceType(Object input, Enumerator current) {
		onRejectBranchsequenceType.setInput(input);
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType);
		if (eefElementEditorReadOnlyState && onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(false);
			onRejectBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnRejectBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnRejectBranchsequenceType(Enumerator newValue) {
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Properties.onRejectBranchsequenceType);
		if (eefElementEditorReadOnlyState && onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(false);
			onRejectBranchsequenceType.setToolTipText(EsbMessages.ThrottleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectBranchsequenceType.isEnabled()) {
			onRejectBranchsequenceType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ThrottleMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
