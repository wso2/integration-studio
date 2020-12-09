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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottleSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class ThrottleMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ThrottleMediatorPropertiesEditionPart {

	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text groupId;
	protected Text description;
	protected EMFComboViewer onAcceptBranchsequenceType;
	// Start of user code  for OnAcceptBranchSequenceKey widgets declarations
    protected RegistryKeyProperty onAcceptBranchSequenceKey;
    protected Text onAcceptBranchSequenceKeyText;
	// End of user code

	protected EMFComboViewer onRejectBranchsequenceType;
	// Start of user code  for OnRejectBranchSequenceKey widgets declarations
    protected RegistryKeyProperty onRejectBranchSequenceKey;
    protected Text onRejectBranchSequenceKeyText;
	// End of user code

	protected EMFComboViewer policyType;
	protected Text maxConcurrentAccessCount;
	protected ReferencesTable policyEntries;
	protected List<ViewerFilter> policyEntriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> policyEntriesFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for policyKey widgets declarations
    protected RegistryKeyProperty policyKey;
    protected Text policyKeyText;
    protected Control[] groupIDElements;
    protected Control[] descriptionElements;
    protected Control[] onAcceptBranchSequenceTypeElements;
    protected Control[] onAcceptBranchSequenceKeyElements;
    protected Control[] onRejectBranchSequenceTypeElements;
    protected Control[] onRejectBranchSequenceKeyElements;
    protected Control[] policyTypeElements;
    protected Control[] maxConcurrentElements;
    protected Control[] policyEntriesElements;
    protected Control[] policyKeyElements;
    protected Composite generalGroup;
    protected Composite miscGroup;
    protected Composite onAcceptGroup;
    protected Composite onRejectGroup;
    protected Composite throttlePolicyGroup;
	// End of user code




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
	 * @generated NOT
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
		CompositionSequence throttleMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep generalStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.General.class);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.commentsList);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.reverse);
		generalStep.addStep(EsbViewsRepository.ThrottleMediator.General.groupId);
		
		CompositionStep onAcceptStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.class);
		onAcceptStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		onAcceptStep.addStep(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey);
		
		CompositionStep onRejectStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.class);
		onRejectStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		onRejectStep.addStep(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey);
		
		CompositionStep throttlePolicyStep = throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.class);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
		throttlePolicyStep.addStep(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey);
		
        throttleMediatorStep.addStep(EsbViewsRepository.ThrottleMediator.Misc.class)
                .addStep(EsbViewsRepository.ThrottleMediator.Misc.description);
		
		composer = new PartComposer(throttleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ThrottleMediator.General.class) {
					return createGeneralGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.General.groupId) {
					return createGroupIdText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnAccept.class) {
					return createOnAcceptGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType) {
					return createOnAcceptBranchsequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for OnAcceptBranchSequenceKey addToPart creation
                if(key == EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey) {
                    return createOnAcceptBranchSequenceKey(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.ThrottleMediator.OnReject.class) {
				    return createOnRejectGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType) {
					return createOnRejectBranchsequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for OnRejectBranchSequenceKey addToPart creation
                if(key == EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey) {
                    return createOnRejectBranchSequenceKey(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.class) {
					return createThrottlePolicyGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType) {
					return createPolicyTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount) {
					return createMaxConcurrentAccessCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries) {
					return createPolicyEntriesTableComposition(widgetFactory, parent);
				}
				// Start of user code for policyKey addToPart creation
                if(key == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey) {
                    return createPolicyKey(widgetFactory, parent);
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
	protected Composite createGeneralGroup(FormToolkit widgetFactory, final Composite parent) {
		Section generalSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		generalSection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		generalSection.setClient(generalGroup);
		return generalGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ThrottleMediator.General.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ThrottleMediator.General.commentsList, EsbMessages.ThrottleMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.General.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ThrottleMediator.General.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ThrottleMediator.General.reverse, EsbMessages.ThrottleMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.General.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ThrottleMediator.General.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.General.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createGroupIdText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.General.groupId, EsbMessages.ThrottleMediatorPropertiesEditionPart_GroupIdLabel);
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
							EsbViewsRepository.ThrottleMediator.General.groupId,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.General.groupId,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.General.groupId, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, groupId.getText()));
				}
			}
		});
		EditingUtils.setID(groupId, EsbViewsRepository.ThrottleMediator.General.groupId);
		EditingUtils.setEEFtype(groupId, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.General.groupId, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createGroupIdText
		groupIDElements = new Control[] {itemLabel, groupId, itemHelp};        
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscSectionData = new GridData(GridData.FILL_HORIZONTAL);
		miscSectionData.horizontalSpan = 3;
		miscSection.setLayoutData(miscSectionData);
		miscGroup = widgetFactory.createComposite(miscSection);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		miscSection.setClient(miscGroup);
		return miscGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.Misc.description, EsbMessages.ThrottleMediatorPropertiesEditionPart_DescriptionLabel);
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
							EsbViewsRepository.ThrottleMediator.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.Misc.description,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ThrottleMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {itemLabel, description, itemHelp};  
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createOnAcceptGroup(FormToolkit widgetFactory, final Composite parent) {
		Section onAcceptSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		onAcceptSection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptGroupLabel);
		GridData onAcceptSectionData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptSectionData.horizontalSpan = 3;
		onAcceptSection.setLayoutData(onAcceptSectionData);
		onAcceptGroup = widgetFactory.createComposite(onAcceptSection);
		GridLayout onAcceptGroupLayout = new GridLayout();
		onAcceptGroupLayout.numColumns = 3;
		onAcceptGroup.setLayout(onAcceptGroupLayout);
		onAcceptSection.setClient(onAcceptGroup);
		return onAcceptGroup;
	}
	
    /**
     * @generated NOT
     */
    protected Composite createOnRejectGroup(FormToolkit widgetFactory, final Composite parent) {
        Section onRejectsection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        onRejectsection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_OnRejectGroupLabel);
        GridData onRejectsectionData = new GridData(GridData.FILL_HORIZONTAL);
        onRejectsectionData.horizontalSpan = 3;
        onRejectsection.setLayoutData(onRejectsectionData);
        onRejectGroup = widgetFactory.createComposite(onRejectsection);
        GridLayout onRejectGroupLayout = new GridLayout();
        onRejectGroupLayout.numColumns = 3;
        onRejectGroup.setLayout(onRejectGroupLayout);
        onRejectsection.setClient(onRejectGroup);
        return onRejectGroup;
    }

    /**
     * @generated NOT
     */
	protected Composite createOnAcceptBranchsequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptBranchsequenceTypeLabel);
		onAcceptBranchsequenceType = new EMFComboViewer(parent);
		onAcceptBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onAcceptBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onAcceptBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptBranchsequenceType.getCombo().setLayoutData(onAcceptBranchsequenceTypeData);
                onAcceptBranchsequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		onAcceptBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnAcceptBranchsequenceType()));
			}

		});
		onAcceptBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnAcceptBranchsequenceTypeEMFComboViewer
		onAcceptBranchSequenceTypeElements = new Control[] {itemLabel, onAcceptBranchsequenceType.getCombo(), itemHelp};
		onAcceptBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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

//FIXME INVALID CASE INTO template public additionalImplementation(editor : ViewElement, pec : PropertiesEditionComponent, inputPEC : PropertiesEditionComponent) in Form Impl for ViewElement onReject

    /**
     * @generated NOT
     */
	protected Composite createOnRejectBranchsequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnRejectBranchsequenceTypeLabel);
		onRejectBranchsequenceType = new EMFComboViewer(parent);
		onRejectBranchsequenceType.setContentProvider(new ArrayContentProvider());
		onRejectBranchsequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onRejectBranchsequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onRejectBranchsequenceType.getCombo().setLayoutData(onRejectBranchsequenceTypeData);
                onRejectBranchsequenceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		onRejectBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectBranchsequenceType()));
			}

		});
		onRejectBranchsequenceType.setID(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnRejectBranchsequenceTypeEMFComboViewer
		onRejectBranchSequenceTypeElements = new Control[] {itemLabel, onRejectBranchsequenceType.getCombo(), itemHelp};        
		onRejectBranchsequenceType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
	protected Composite createThrottlePolicyGroup(FormToolkit widgetFactory, final Composite parent) {
		Section throttlePolicySection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		throttlePolicySection.setText(EsbMessages.ThrottleMediatorPropertiesEditionPart_ThrottlePolicyGroupLabel);
		GridData throttlePolicySectionData = new GridData(GridData.FILL_HORIZONTAL);
		throttlePolicySectionData.horizontalSpan = 3;
		throttlePolicySection.setLayoutData(throttlePolicySectionData);
		throttlePolicyGroup = widgetFactory.createComposite(throttlePolicySection);
		GridLayout throttlePolicyGroupLayout = new GridLayout();
		throttlePolicyGroupLayout.numColumns = 3;
		throttlePolicyGroup.setLayout(throttlePolicyGroupLayout);
		throttlePolicySection.setClient(throttlePolicyGroup);
		return throttlePolicyGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createPolicyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyTypeLabel);
		policyType = new EMFComboViewer(parent);
		policyType.setContentProvider(new ArrayContentProvider());
		policyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		policyType.getCombo().setLayoutData(policyTypeData);
                policyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		policyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyType()));
			}

		});
		policyType.setID(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPolicyTypeEMFComboViewer
		policyTypeElements = new Control[] {itemLabel, policyType.getCombo(), itemHelp};        
		policyType.addSelectionChangedListener(new ISelectionChangedListener() {
            
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
	protected Composite createMaxConcurrentAccessCountText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, EsbMessages.ThrottleMediatorPropertiesEditionPart_MaxConcurrentAccessCountLabel);
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
							EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxConcurrentAccessCount.getText()));
				}
			}
		});
		EditingUtils.setID(maxConcurrentAccessCount, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
		EditingUtils.setEEFtype(maxConcurrentAccessCount, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxConcurrentAccessCountText
		maxConcurrentElements = new Control[] {itemLabel, maxConcurrentAccessCount, itemHelp};        
        
		// End of user code
		return parent;
	}

	/**
	 * @param container
     *
     * @generated NOT
     */
	protected Composite createPolicyEntriesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = throttlePolicyGroup.getChildren();
		this.policyEntries = new ReferencesTable(getDescription(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyEntriesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				policyEntries.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				policyEntries.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				policyEntries.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				policyEntries.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.policyEntriesFilters) {
			this.policyEntries.addFilter(filter);
		}
		this.policyEntries.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, EsbViewsRepository.FORM_KIND));
		this.policyEntries.createControls(parent, widgetFactory);
		this.policyEntries.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData policyEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		policyEntriesData.horizontalSpan = 3;
		this.policyEntries.setLayoutData(policyEntriesData);
		this.policyEntries.setLowerBound(0);
		this.policyEntries.setUpperBound(-1);
		policyEntries.setID(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
		policyEntries.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPolicyEntriesTableComposition
		Control [] newControls = throttlePolicyGroup.getChildren();
		policyEntriesElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.commentsList);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.reverse);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getGroupId()
	 * 
	 */
	public String getGroupId() {
		return groupId.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setGroupId(String newValue)
	 * 
	 */
	public void setGroupId(String newValue) {
		if (newValue != null) {
			groupId.setText(newValue);
		} else {
			groupId.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.General.groupId);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.Misc.description);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnAcceptBranchsequenceType()
	 * 
	 */
	public Enumerator getOnAcceptBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onAcceptBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnAcceptBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnAcceptBranchsequenceType(Object input, Enumerator current) {
		onAcceptBranchsequenceType.setInput(input);
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnAcceptBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnAcceptBranchsequenceType(Enumerator newValue) {
		onAcceptBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getOnRejectBranchsequenceType()
	 * 
	 */
	public Enumerator getOnRejectBranchsequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onRejectBranchsequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initOnRejectBranchsequenceType(Object input, Enumerator current)
	 */
	public void initOnRejectBranchsequenceType(Object input, Enumerator current) {
		onRejectBranchsequenceType.setInput(input);
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setOnRejectBranchsequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnRejectBranchsequenceType(Enumerator newValue) {
		onRejectBranchsequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getPolicyType()
	 * 
	 */
	public Enumerator getPolicyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyType(Object input, Enumerator current)
	 */
	public void initPolicyType(Object input, Enumerator current) {
		policyType.setInput(input);
		policyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setPolicyType(Enumerator newValue)
	 * 
	 */
	public void setPolicyType(Enumerator newValue) {
		policyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#getMaxConcurrentAccessCount()
	 * 
	 */
	public String getMaxConcurrentAccessCount() {
		return maxConcurrentAccessCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#setMaxConcurrentAccessCount(String newValue)
	 * 
	 */
	public void setMaxConcurrentAccessCount(String newValue) {
		if (newValue != null) {
			maxConcurrentAccessCount.setText(newValue);
		} else {
			maxConcurrentAccessCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#initPolicyEntries(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPolicyEntries(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		policyEntries.setContentProvider(contentProvider);
		policyEntries.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#updatePolicyEntries()
	 * 
	 */
	public void updatePolicyEntries() {
	policyEntries.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addFilterPolicyEntries(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#addBusinessFilterPolicyEntries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPolicyEntries(ViewerFilter filter) {
		policyEntriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart#isContainedInPolicyEntriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPolicyEntriesTable(EObject element) {
		return ((ReferencesTableSettings)policyEntries.getInput()).contains(element);
	}






	// Start of user code for OnAcceptBranchSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnAcceptBranchSequenceKey() {
        return onAcceptBranchSequenceKey;
    }

    @Override
    public void setOnAcceptBranchSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            onAcceptBranchSequenceKeyText.setText(registryKeyProperty.getKeyValue());
            onAcceptBranchSequenceKey = registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for OnRejectBranchSequenceKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getOnRejectBranchSequenceKey() {
        return onRejectBranchSequenceKey;
    }

    @Override
    public void setOnRejectBranchSequenceKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            onRejectBranchSequenceKeyText.setText(registryKeyProperty.getKeyValue());
            onRejectBranchSequenceKey = registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for policyKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getPolicyKey() {
        return policyKey;
    }

    @Override
    public void setPolicyKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            policyKeyText.setText(registryKeyProperty.getKeyValue());
            policyKey = registryKeyProperty;
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
		return EsbMessages.ThrottleMediator_Part_Title;
	}

	// Start of user code additional methods
   protected Composite createPolicyKey(FormToolkit widgetFactory, Composite parent) {
       Control policyKeyLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey, EsbMessages.ThrottleMediatorPropertiesEditionPart_PolicyKeyLabel);
       widgetFactory.paintBordersFor(parent);
       if(policyKey == null) {
           policyKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
       } 
       String initValueExpression = policyKey.getKeyValue().isEmpty() ? "" : policyKey.getKeyValue();
       policyKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
       policyKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
       widgetFactory.paintBordersFor(parent);
       GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
       policyKeyText.setLayoutData(valueData);
       
        policyKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                policyKeyText.setText(policyKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyKey()));
            }

            @Override
            public void mouseUp(MouseEvent e) {}

            @Override
            public void mouseDoubleClick(MouseEvent e) {}

        });
        
        policyKeyText.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    policyKeyText.setText(policyKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicyKey()));
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {}

        });
       
       EditingUtils.setID(policyKeyText, EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey);
       EditingUtils.setEEFtype(policyKeyText, "eef::Text");
       Control sequenceKeyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
       policyKeyElements = new Control[] {policyKeyLabel, policyKeyText, sequenceKeyHelp};
       return parent;
    }

    protected Composite createOnRejectBranchSequenceKey(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnRejectBranchSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(onRejectBranchSequenceKey == null) {
            onRejectBranchSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = onRejectBranchSequenceKey.getKeyValue().isEmpty() ? "" : onRejectBranchSequenceKey.getKeyValue();
        onRejectBranchSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onRejectBranchSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onRejectBranchSequenceKeyText.setLayoutData(valueData);
        
        onRejectBranchSequenceKeyText.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onRejectBranchSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onRejectBranchSequenceKeyText.setText(onRejectBranchSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                getOnRejectBranchSequenceKey()));
            }
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
        });
        
        onRejectBranchSequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, onRejectBranchSequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    onRejectBranchSequenceKeyText.setText(onRejectBranchSequenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnRejectBranchSequenceKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(onRejectBranchSequenceKeyText, EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey);
        EditingUtils.setEEFtype(onRejectBranchSequenceKeyText, "eef::Text");
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        onRejectBranchSequenceKeyElements = new Control[] {itemLabel, onRejectBranchSequenceKeyText, itemHelp};
        return parent;
    }

    protected Composite createOnAcceptBranchSequenceKey(FormToolkit widgetFactory, Composite parent) {
        Control itemLabel = createDescription(parent, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey, EsbMessages.ThrottleMediatorPropertiesEditionPart_OnAcceptBranchSequenceKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(onAcceptBranchSequenceKey == null) {
            onAcceptBranchSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initValueExpression = onAcceptBranchSequenceKey.getKeyValue().isEmpty() ? "" : onAcceptBranchSequenceKey.getKeyValue();
        onAcceptBranchSequenceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        onAcceptBranchSequenceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        onAcceptBranchSequenceKeyText.setLayoutData(valueData);
        
        onAcceptBranchSequenceKeyText.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onAcceptBranchSequenceKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onAcceptBranchSequenceKeyText.setText(onAcceptBranchSequenceKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                getOnAcceptBranchSequenceKey()));
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
        });
        
        onAcceptBranchSequenceKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, onAcceptBranchSequenceKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    onAcceptBranchSequenceKeyText.setText(onAcceptBranchSequenceKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(ThrottleMediatorPropertiesEditionPartForm.this,
                                    EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getOnAcceptBranchSequenceKey()));
                } 
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(onAcceptBranchSequenceKeyText, EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey);
        EditingUtils.setEEFtype(onAcceptBranchSequenceKeyText, "eef::Text");
        Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        onAcceptBranchSequenceKeyElements = new Control[] {itemLabel, onAcceptBranchSequenceKeyText, itemHelp};
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.clearElements(new Composite[] { generalGroup, miscGroup, onAcceptGroup, onRejectGroup, throttlePolicyGroup });
        epv.showEntry(descriptionElements, false);
        epv.showEntry(groupIDElements, false);
        epv.showEntry(policyTypeElements, false);
        epv.showEntry(onAcceptBranchSequenceTypeElements, false);
        epv.showEntry(onRejectBranchSequenceTypeElements, false);
        if (getPolicyType().getLiteral().equals(ThrottlePolicyType.INLINE.getLiteral())) {
            epv.showEntry(policyEntriesElements, false);
        } else {
            epv.showEntry(policyKeyElements, false);
        }

        if (getOnAcceptBranchsequenceType().getLiteral().equals(ThrottleSequenceType.REGISTRY_REFERENCE.getLiteral())) {
            epv.showEntry(onAcceptBranchSequenceKeyElements, false);
        }

        if (getOnRejectBranchsequenceType().getLiteral().equals(ThrottleSequenceType.REGISTRY_REFERENCE.getLiteral())) {
            epv.showEntry(onRejectBranchSequenceKeyElements, false);
        }
        view.layout(true, true);
    }
	// End of user codeg


}
