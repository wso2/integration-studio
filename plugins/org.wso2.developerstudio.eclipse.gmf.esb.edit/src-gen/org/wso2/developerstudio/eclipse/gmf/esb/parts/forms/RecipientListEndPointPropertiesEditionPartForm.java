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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RecipientListEndPointPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RecipientListEndPointPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text endPointName;
	protected Button anonymous;
	protected Button inLine;
	protected Button duplicate;
	protected ReferencesTable properties;
	protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
	protected Button reversed;
	protected ReferencesTable children;
	protected List<ViewerFilter> childrenBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> childrenFilters = new ArrayList<ViewerFilter>();
	protected Text name;
	protected ReferencesTable outputConnector;
	protected List<ViewerFilter> outputConnectorBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outputConnectorFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer endpointType;
	protected Text endpointsValue;
	protected Text maxCache;

    // Start of user code
    protected Composite propertiesGroup;
    protected Control[] reverseElements;
    protected Control[] commentsElements;
    protected Control[] anonymousElements;
    protected Control[] inLineElements;
    protected Control[] duplicateElements;
    protected Control[] childrenElements;
    protected Control[] nameElements;
    protected Control[] outputConnectorElements;
    // End of user code

	/**
	 * For {@link ISection} use only.
	 */
	public RecipientListEndPointPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RecipientListEndPointPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
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
		CompositionSequence recipientListEndPointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = recipientListEndPointStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.endPointName);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.inLine);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.endpointType);
                propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue);
                propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.maxCache);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.reversed);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.children);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector);
		propertiesStep.addStep(EsbViewsRepository.RecipientListEndPoint.Properties.description);
		
		composer = new PartComposer(recipientListEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.endPointName) {
					return createEndPointNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.anonymous) {
					return createAnonymousCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.inLine) {
					return createInLineCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.duplicate) {
					return createDuplicateCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.properties_) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.reversed) {
					return createReversedCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.children) {
					return createChildrenTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector) {
					return createOutputConnectorTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.endpointType) {
					return createEndpointTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue) {
					return createEndpointsValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RecipientListEndPoint.Properties.maxCache) {
					return createMaxCacheText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.RecipientListEndPointPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.description, EsbMessages.RecipientListEndPointPropertiesEditionPart_DescriptionLabel);
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
							RecipientListEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.RecipientListEndPoint.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RecipientListEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.RecipientListEndPoint.Properties.description,
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
									RecipientListEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.RecipientListEndPoint.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.RecipientListEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.commentsList, EsbMessages.RecipientListEndPointPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "RecipientListEndPoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.RecipientListEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
                Control[] newControls = propertiesGroup.getChildren();
                commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.endPointName, EsbMessages.RecipientListEndPointPropertiesEditionPart_EndPointNameLabel);
		endPointName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		endPointName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData endPointNameData = new GridData(GridData.FILL_HORIZONTAL);
		endPointName.setLayoutData(endPointNameData);
		endPointName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RecipientListEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.RecipientListEndPoint.Properties.endPointName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RecipientListEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.RecipientListEndPoint.Properties.endPointName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, endPointName.getText()));
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
									RecipientListEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		endPointName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}
		});
		EditingUtils.setID(endPointName, EsbViewsRepository.RecipientListEndPoint.Properties.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.endPointName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAnonymousCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		anonymous = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.anonymous, EsbMessages.RecipientListEndPointPropertiesEditionPart_AnonymousLabel), SWT.CHECK);
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.RecipientListEndPoint.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.anonymous, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAnonymousCheckbox
		Control[] newControls = propertiesGroup.getChildren();
		anonymousElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createInLineCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		inLine = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.inLine, EsbMessages.RecipientListEndPointPropertiesEditionPart_InLineLabel), SWT.CHECK);
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.RecipientListEndPoint.Properties.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.inLine, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInLineCheckbox
		Control[] newControls = propertiesGroup.getChildren();
		inLineElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createDuplicateCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		duplicate = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.duplicate, EsbMessages.RecipientListEndPointPropertiesEditionPart_DuplicateLabel), SWT.CHECK);
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.RecipientListEndPoint.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.duplicate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDuplicateCheckbox
		Control[] newControls = propertiesGroup.getChildren();
		duplicateElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.properties_, EsbMessages.RecipientListEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.properties_, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.RecipientListEndPoint.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesTableComposition

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createReversedCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		reversed = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.reversed, EsbMessages.RecipientListEndPointPropertiesEditionPart_ReversedLabel), SWT.CHECK);
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.RecipientListEndPoint.Properties.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.reversed, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversedCheckbox
		Control[] newControls = propertiesGroup.getChildren();
		reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 * @generated NOT
	 *
	 */
	protected Composite createChildrenTableComposition(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		this.children = new ReferencesTable(getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.children, EsbMessages.RecipientListEndPointPropertiesEditionPart_ChildrenLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				children.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				children.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				children.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				children.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.childrenFilters) {
			this.children.addFilter(filter);
		}
		this.children.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.children, EsbViewsRepository.FORM_KIND));
		this.children.createControls(parent, widgetFactory);
		this.children.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.children, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData childrenData = new GridData(GridData.FILL_HORIZONTAL);
		childrenData.horizontalSpan = 3;
		this.children.setLayoutData(childrenData);
		this.children.setLowerBound(0);
		this.children.setUpperBound(-1);
		children.setID(EsbViewsRepository.RecipientListEndPoint.Properties.children);
		children.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createChildrenTableComposition
		Control[] newControls = propertiesGroup.getChildren();
		childrenElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.name, EsbMessages.RecipientListEndPointPropertiesEditionPart_NameLabel);
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
							RecipientListEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.RecipientListEndPoint.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RecipientListEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.RecipientListEndPoint.Properties.name,
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
									RecipientListEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EsbViewsRepository.RecipientListEndPoint.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.name, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText
		Control[] newControls = propertiesGroup.getChildren();
		nameElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 * @generated NOT
	 */
	protected Composite createOutputConnectorTableComposition(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		this.outputConnector = new ReferencesTable(getDescription(EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, EsbMessages.RecipientListEndPointPropertiesEditionPart_OutputConnectorLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				outputConnector.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				outputConnector.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				outputConnector.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				outputConnector.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.outputConnectorFilters) {
			this.outputConnector.addFilter(filter);
		}
		this.outputConnector.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, EsbViewsRepository.FORM_KIND));
		this.outputConnector.createControls(parent, widgetFactory);
		this.outputConnector.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outputConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		outputConnectorData.horizontalSpan = 3;
		this.outputConnector.setLayoutData(outputConnectorData);
		this.outputConnector.setLowerBound(0);
		this.outputConnector.setUpperBound(-1);
		outputConnector.setID(EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector);
		outputConnector.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOutputConnectorTableComposition
		Control[] newControls = propertiesGroup.getChildren();
		outputConnectorElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.endpointType, EsbMessages.RecipientListEndPointPropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(parent);
		endpointType.setContentProvider(new ArrayContentProvider());
		endpointType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData endpointTypeData = new GridData(GridData.FILL_HORIZONTAL);
		endpointType.getCombo().setLayoutData(endpointTypeData);
                endpointType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.RecipientListEndPoint.Properties.endpointType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.endpointType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createEndpointsValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue, EsbMessages.RecipientListEndPointPropertiesEditionPart_EndpointsValueLabel);
		endpointsValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		endpointsValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData endpointsValueData = new GridData(GridData.FILL_HORIZONTAL);
		endpointsValue.setLayoutData(endpointsValueData);
		endpointsValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RecipientListEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointsValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RecipientListEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, endpointsValue.getText()));
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
									RecipientListEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		endpointsValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endpointsValue.getText()));
				}
			}
		});
		EditingUtils.setID(endpointsValue, EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue);
		EditingUtils.setEEFtype(endpointsValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointsValueText

		// End of user code
		return parent;
	}

	
	protected Composite createMaxCacheText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.RecipientListEndPoint.Properties.maxCache, EsbMessages.RecipientListEndPointPropertiesEditionPart_MaxCacheLabel);
		maxCache = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxCache.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxCacheData = new GridData(GridData.FILL_HORIZONTAL);
		maxCache.setLayoutData(maxCacheData);
		maxCache.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RecipientListEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.RecipientListEndPoint.Properties.maxCache,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxCache.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RecipientListEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.RecipientListEndPoint.Properties.maxCache,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxCache.getText()));
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
									RecipientListEndPointPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxCache.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RecipientListEndPointPropertiesEditionPartForm.this, EsbViewsRepository.RecipientListEndPoint.Properties.maxCache, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxCache.getText()));
				}
			}
		});
		EditingUtils.setID(maxCache, EsbViewsRepository.RecipientListEndPoint.Properties.maxCache);
		EditingUtils.setEEFtype(maxCache, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RecipientListEndPoint.Properties.maxCache, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxCacheText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProperties(ViewerFilter filter) {
		propertiesFilters.add(filter);
		if (this.properties != null) {
			this.properties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#initChildren(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initChildren(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		children.setContentProvider(contentProvider);
		children.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.children);
		if (eefElementEditorReadOnlyState && children.isEnabled()) {
			children.setEnabled(false);
			children.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !children.isEnabled()) {
			children.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#updateChildren()
	 * 
	 */
	public void updateChildren() {
	children.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addFilterChildren(ViewerFilter filter)
	 * 
	 */
	public void addFilterToChildren(ViewerFilter filter) {
		childrenFilters.add(filter);
		if (this.children != null) {
			this.children.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addBusinessFilterChildren(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToChildren(ViewerFilter filter) {
		childrenBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#isContainedInChildrenTable(EObject element)
	 * 
	 */
	public boolean isContainedInChildrenTable(EObject element) {
		return ((ReferencesTableSettings)children.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#initOutputConnector(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutputConnector(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outputConnector.setContentProvider(contentProvider);
		outputConnector.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.outputConnector);
		if (eefElementEditorReadOnlyState && outputConnector.isEnabled()) {
			outputConnector.setEnabled(false);
			outputConnector.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputConnector.isEnabled()) {
			outputConnector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#updateOutputConnector()
	 * 
	 */
	public void updateOutputConnector() {
	outputConnector.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addFilterOutputConnector(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#addBusinessFilterOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutputConnector(ViewerFilter filter) {
		outputConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#isContainedInOutputConnectorTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutputConnectorTable(EObject element) {
		return ((ReferencesTableSettings)outputConnector.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getEndpointsValue()
	 * 
	 */
	public String getEndpointsValue() {
		return endpointsValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setEndpointsValue(String newValue)
	 * 
	 */
	public void setEndpointsValue(String newValue) {
		if (newValue != null) {
			endpointsValue.setText(newValue);
		} else {
			endpointsValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.endpointsValue);
		if (eefElementEditorReadOnlyState && endpointsValue.isEnabled()) {
			endpointsValue.setEnabled(false);
			endpointsValue.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointsValue.isEnabled()) {
			endpointsValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#getMaxCache()
	 * 
	 */
	public String getMaxCache() {
		return maxCache.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RecipientListEndPointPropertiesEditionPart#setMaxCache(String newValue)
	 * 
	 */
	public void setMaxCache(String newValue) {
		if (newValue != null) {
			maxCache.setText(newValue);
		} else {
			maxCache.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RecipientListEndPoint.Properties.maxCache);
		if (eefElementEditorReadOnlyState && maxCache.isEnabled()) {
			maxCache.setEnabled(false);
			maxCache.setToolTipText(EsbMessages.RecipientListEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxCache.isEnabled()) {
			maxCache.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RecipientListEndPoint_Part_Title;
	}

	// Start of user code additional methods
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.hideEntry(commentsElements, false);
        epv.hideEntry(reverseElements, false);
        epv.hideEntry(anonymousElements, false);
        epv.hideEntry(inLineElements, false);
        epv.hideEntry(duplicateElements, false);
        epv.hideEntry(childrenElements, false);
        epv.hideEntry(nameElements, false);
        epv.hideEntry( outputConnectorElements, false);
        view.layout(true, true);
    }
	// End of user code


}
