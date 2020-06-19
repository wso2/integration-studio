/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class FailoverEndPointPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, FailoverEndPointPropertiesEditionPart {

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
	protected Button buildMessage;

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
	public FailoverEndPointPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FailoverEndPointPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence failoverEndPointStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = failoverEndPointStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.endPointName);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.anonymous);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.inLine);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.duplicate);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.buildMessage);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.reversed);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.children);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.outputConnector);
		propertiesStep.addStep(EsbViewsRepository.FailoverEndPoint.Properties.description);
		
		composer = new PartComposer(failoverEndPointStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.endPointName) {
					return createEndPointNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.anonymous) {
					return createAnonymousCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.inLine) {
					return createInLineCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.duplicate) {
					return createDuplicateCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.properties_) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.reversed) {
					return createReversedCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.children) {
					return createChildrenTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.outputConnector) {
					return createOutputConnectorTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FailoverEndPoint.Properties.buildMessage) {
					return createBuildMessageCheckbox(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.FailoverEndPointPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.FailoverEndPoint.Properties.description, EsbMessages.FailoverEndPointPropertiesEditionPart_DescriptionLabel);
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
							FailoverEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.FailoverEndPoint.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FailoverEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.FailoverEndPoint.Properties.description,
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
									FailoverEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.FailoverEndPoint.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.FailoverEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.commentsList, EsbMessages.FailoverEndPointPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "FailoverEndPoint", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.FailoverEndPoint.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		Control[] newControls = propertiesGroup.getChildren();
		commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createEndPointNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.FailoverEndPoint.Properties.endPointName, EsbMessages.FailoverEndPointPropertiesEditionPart_EndPointNameLabel);
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
							FailoverEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.FailoverEndPoint.Properties.endPointName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FailoverEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.FailoverEndPoint.Properties.endPointName,
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
									FailoverEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.endPointName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, endPointName.getText()));
				}
			}
		});
		EditingUtils.setID(endPointName, EsbViewsRepository.FailoverEndPoint.Properties.endPointName);
		EditingUtils.setEEFtype(endPointName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.endPointName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndPointNameText

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createAnonymousCheckbox(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		anonymous = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.anonymous, EsbMessages.FailoverEndPointPropertiesEditionPart_AnonymousLabel), SWT.CHECK);
		anonymous.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.anonymous, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(anonymous.getSelection())));
			}

		});
		GridData anonymousData = new GridData(GridData.FILL_HORIZONTAL);
		anonymousData.horizontalSpan = 2;
		anonymous.setLayoutData(anonymousData);
		EditingUtils.setID(anonymous, EsbViewsRepository.FailoverEndPoint.Properties.anonymous);
		EditingUtils.setEEFtype(anonymous, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.anonymous, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		inLine = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.inLine, EsbMessages.FailoverEndPointPropertiesEditionPart_InLineLabel), SWT.CHECK);
		inLine.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.inLine, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inLine.getSelection())));
			}

		});
		GridData inLineData = new GridData(GridData.FILL_HORIZONTAL);
		inLineData.horizontalSpan = 2;
		inLine.setLayoutData(inLineData);
		EditingUtils.setID(inLine, EsbViewsRepository.FailoverEndPoint.Properties.inLine);
		EditingUtils.setEEFtype(inLine, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.inLine, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		duplicate = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.duplicate, EsbMessages.FailoverEndPointPropertiesEditionPart_DuplicateLabel), SWT.CHECK);
		duplicate.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.duplicate, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(duplicate.getSelection())));
			}

		});
		GridData duplicateData = new GridData(GridData.FILL_HORIZONTAL);
		duplicateData.horizontalSpan = 2;
		duplicate.setLayoutData(duplicateData);
		EditingUtils.setID(duplicate, EsbViewsRepository.FailoverEndPoint.Properties.duplicate);
		EditingUtils.setEEFtype(duplicate, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.duplicate, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.FailoverEndPoint.Properties.properties_, EsbMessages.FailoverEndPointPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.properties_, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.FailoverEndPoint.Properties.properties_);
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
		reversed = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.reversed, EsbMessages.FailoverEndPointPropertiesEditionPart_ReversedLabel), SWT.CHECK);
		reversed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.reversed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reversed.getSelection())));
			}

		});
		GridData reversedData = new GridData(GridData.FILL_HORIZONTAL);
		reversedData.horizontalSpan = 2;
		reversed.setLayoutData(reversedData);
		EditingUtils.setID(reversed, EsbViewsRepository.FailoverEndPoint.Properties.reversed);
		EditingUtils.setEEFtype(reversed, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.reversed, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		this.children = new ReferencesTable(getDescription(EsbViewsRepository.FailoverEndPoint.Properties.children, EsbMessages.FailoverEndPointPropertiesEditionPart_ChildrenLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				children.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				children.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				children.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.children, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				children.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.childrenFilters) {
			this.children.addFilter(filter);
		}
		this.children.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.children, EsbViewsRepository.FORM_KIND));
		this.children.createControls(parent, widgetFactory);
		this.children.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.children, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData childrenData = new GridData(GridData.FILL_HORIZONTAL);
		childrenData.horizontalSpan = 3;
		this.children.setLayoutData(childrenData);
		this.children.setLowerBound(0);
		this.children.setUpperBound(-1);
		children.setID(EsbViewsRepository.FailoverEndPoint.Properties.children);
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
		createDescription(parent, EsbViewsRepository.FailoverEndPoint.Properties.name, EsbMessages.FailoverEndPointPropertiesEditionPart_NameLabel);
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
							FailoverEndPointPropertiesEditionPartForm.this,
							EsbViewsRepository.FailoverEndPoint.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FailoverEndPointPropertiesEditionPartForm.this,
									EsbViewsRepository.FailoverEndPoint.Properties.name,
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
									FailoverEndPointPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EsbViewsRepository.FailoverEndPoint.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.name, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 *
	 */
	protected Composite createOutputConnectorTableComposition(FormToolkit widgetFactory, Composite parent) {
	        Control[] previousControls = propertiesGroup.getChildren();
		this.outputConnector = new ReferencesTable(getDescription(EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, EsbMessages.FailoverEndPointPropertiesEditionPart_OutputConnectorLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				outputConnector.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				outputConnector.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				outputConnector.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				outputConnector.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.outputConnectorFilters) {
			this.outputConnector.addFilter(filter);
		}
		this.outputConnector.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, EsbViewsRepository.FORM_KIND));
		this.outputConnector.createControls(parent, widgetFactory);
		this.outputConnector.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.outputConnector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outputConnectorData = new GridData(GridData.FILL_HORIZONTAL);
		outputConnectorData.horizontalSpan = 3;
		this.outputConnector.setLayoutData(outputConnectorData);
		this.outputConnector.setLowerBound(0);
		this.outputConnector.setUpperBound(-1);
		outputConnector.setID(EsbViewsRepository.FailoverEndPoint.Properties.outputConnector);
		outputConnector.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOutputConnectorTableComposition
		Control[] newControls = propertiesGroup.getChildren();
                outputConnectorElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createBuildMessageCheckbox(FormToolkit widgetFactory, Composite parent) {
		buildMessage = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FailoverEndPoint.Properties.buildMessage, EsbMessages.FailoverEndPointPropertiesEditionPart_BuildMessageLabel), SWT.CHECK);
		buildMessage.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FailoverEndPointPropertiesEditionPartForm.this, EsbViewsRepository.FailoverEndPoint.Properties.buildMessage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(buildMessage.getSelection())));
			}

		});
		GridData buildMessageData = new GridData(GridData.FILL_HORIZONTAL);
		buildMessageData.horizontalSpan = 2;
		buildMessage.setLayoutData(buildMessageData);
		EditingUtils.setID(buildMessage, EsbViewsRepository.FailoverEndPoint.Properties.buildMessage);
		EditingUtils.setEEFtype(buildMessage, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FailoverEndPoint.Properties.buildMessage, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBuildMessageCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getEndPointName()
	 * 
	 */
	public String getEndPointName() {
		return endPointName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setEndPointName(String newValue)
	 * 
	 */
	public void setEndPointName(String newValue) {
		if (newValue != null) {
			endPointName.setText(newValue);
		} else {
			endPointName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.endPointName);
		if (eefElementEditorReadOnlyState && endPointName.isEnabled()) {
			endPointName.setEnabled(false);
			endPointName.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endPointName.isEnabled()) {
			endPointName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getAnonymous()
	 * 
	 */
	public Boolean getAnonymous() {
		return Boolean.valueOf(anonymous.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setAnonymous(Boolean newValue)
	 * 
	 */
	public void setAnonymous(Boolean newValue) {
		if (newValue != null) {
			anonymous.setSelection(newValue.booleanValue());
		} else {
			anonymous.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.anonymous);
		if (eefElementEditorReadOnlyState && anonymous.isEnabled()) {
			anonymous.setEnabled(false);
			anonymous.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !anonymous.isEnabled()) {
			anonymous.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getInLine()
	 * 
	 */
	public Boolean getInLine() {
		return Boolean.valueOf(inLine.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setInLine(Boolean newValue)
	 * 
	 */
	public void setInLine(Boolean newValue) {
		if (newValue != null) {
			inLine.setSelection(newValue.booleanValue());
		} else {
			inLine.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.inLine);
		if (eefElementEditorReadOnlyState && inLine.isEnabled()) {
			inLine.setEnabled(false);
			inLine.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inLine.isEnabled()) {
			inLine.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getDuplicate()
	 * 
	 */
	public Boolean getDuplicate() {
		return Boolean.valueOf(duplicate.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setDuplicate(Boolean newValue)
	 * 
	 */
	public void setDuplicate(Boolean newValue) {
		if (newValue != null) {
			duplicate.setSelection(newValue.booleanValue());
		} else {
			duplicate.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.duplicate);
		if (eefElementEditorReadOnlyState && duplicate.isEnabled()) {
			duplicate.setEnabled(false);
			duplicate.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duplicate.isEnabled()) {
			duplicate.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getReversed()
	 * 
	 */
	public Boolean getReversed() {
		return Boolean.valueOf(reversed.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setReversed(Boolean newValue)
	 * 
	 */
	public void setReversed(Boolean newValue) {
		if (newValue != null) {
			reversed.setSelection(newValue.booleanValue());
		} else {
			reversed.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.reversed);
		if (eefElementEditorReadOnlyState && reversed.isEnabled()) {
			reversed.setEnabled(false);
			reversed.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversed.isEnabled()) {
			reversed.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#initChildren(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initChildren(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		children.setContentProvider(contentProvider);
		children.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.children);
		if (eefElementEditorReadOnlyState && children.isEnabled()) {
			children.setEnabled(false);
			children.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !children.isEnabled()) {
			children.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#updateChildren()
	 * 
	 */
	public void updateChildren() {
	children.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addFilterChildren(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addBusinessFilterChildren(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToChildren(ViewerFilter filter) {
		childrenBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#isContainedInChildrenTable(EObject element)
	 * 
	 */
	public boolean isContainedInChildrenTable(EObject element) {
		return ((ReferencesTableSettings)children.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#initOutputConnector(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutputConnector(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outputConnector.setContentProvider(contentProvider);
		outputConnector.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.outputConnector);
		if (eefElementEditorReadOnlyState && outputConnector.isEnabled()) {
			outputConnector.setEnabled(false);
			outputConnector.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputConnector.isEnabled()) {
			outputConnector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#updateOutputConnector()
	 * 
	 */
	public void updateOutputConnector() {
	outputConnector.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addFilterOutputConnector(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#addBusinessFilterOutputConnector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutputConnector(ViewerFilter filter) {
		outputConnectorBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#isContainedInOutputConnectorTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutputConnectorTable(EObject element) {
		return ((ReferencesTableSettings)outputConnector.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#getBuildMessage()
	 * 
	 */
	public Boolean getBuildMessage() {
		return Boolean.valueOf(buildMessage.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.FailoverEndPointPropertiesEditionPart#setBuildMessage(Boolean newValue)
	 * 
	 */
	public void setBuildMessage(Boolean newValue) {
		if (newValue != null) {
			buildMessage.setSelection(newValue.booleanValue());
		} else {
			buildMessage.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FailoverEndPoint.Properties.buildMessage);
		if (eefElementEditorReadOnlyState && buildMessage.isEnabled()) {
			buildMessage.setEnabled(false);
			buildMessage.setToolTipText(EsbMessages.FailoverEndPoint_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !buildMessage.isEnabled()) {
			buildMessage.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.FailoverEndPoint_Part_Title;
	}

	// Start of user code additional methods
    @Override
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
        epv.hideEntry(nameElements, false);
        epv.hideEntry( outputConnectorElements, false);
        view.layout(true, true);
    }
	// End of user code


}
