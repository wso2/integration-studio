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
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * @generated NOT
 */
public class ConditionalRouterMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ConditionalRouterMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Button continueAfterRoute;
	protected ReferencesTable conditionalRouteBranches;
	protected List<ViewerFilter> conditionalRouteBranchesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> conditionalRouteBranchesFilters = new ArrayList<ViewerFilter>();
    protected Control[] commentsElements;
    protected Control[] reverseElements;
    protected Composite propertiesGroup;


	/**
	 * For {@link ISection} use only.
	 */
	public ConditionalRouterMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConditionalRouterMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conditionalRouterMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = conditionalRouterMediatorStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouterMediator.Properties.description);
		
		composer = new PartComposer(conditionalRouterMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute) {
					return createContinueAfterRouteCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches) {
					return createConditionalRouteBranchesTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.ConditionalRouterMediator.Properties.description, EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_DescriptionLabel);
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
							ConditionalRouterMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ConditionalRouterMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConditionalRouterMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ConditionalRouterMediator.Properties.description,
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
									ConditionalRouterMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ConditionalRouterMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouterMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
        commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList, EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ConditionalRouterMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		Control [] newControls = propertiesGroup.getChildren();
        commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
        reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ConditionalRouterMediator.Properties.reverse, EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ConditionalRouterMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouterMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
		Control [] newControls = propertiesGroup.getChildren();
        reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        
		// End of user code
		return parent;
	}

	
	protected Composite createContinueAfterRouteCheckbox(FormToolkit widgetFactory, Composite parent) {
		continueAfterRoute = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute, EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_ContinueAfterRouteLabel), SWT.CHECK);
		continueAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(continueAfterRoute.getSelection())));
			}

		});
		GridData continueAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		continueAfterRouteData.horizontalSpan = 2;
		continueAfterRoute.setLayoutData(continueAfterRouteData);
		EditingUtils.setID(continueAfterRoute, EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute);
		EditingUtils.setEEFtype(continueAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createContinueAfterRouteCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createConditionalRouteBranchesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.conditionalRouteBranches = new ReferencesTable(getDescription(EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, EsbMessages.ConditionalRouterMediatorPropertiesEditionPart_ConditionalRouteBranchesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				conditionalRouteBranches.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				conditionalRouteBranches.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				conditionalRouteBranches.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				conditionalRouteBranches.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.conditionalRouteBranchesFilters) {
			this.conditionalRouteBranches.addFilter(filter);
		}
		this.conditionalRouteBranches.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, EsbViewsRepository.FORM_KIND));
		this.conditionalRouteBranches.createControls(parent, widgetFactory);
		this.conditionalRouteBranches.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouterMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData conditionalRouteBranchesData = new GridData(GridData.FILL_HORIZONTAL);
		conditionalRouteBranchesData.horizontalSpan = 3;
		this.conditionalRouteBranches.setLayoutData(conditionalRouteBranchesData);
		this.conditionalRouteBranches.setLowerBound(0);
		this.conditionalRouteBranches.setUpperBound(-1);
		conditionalRouteBranches.setID(EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches);
		conditionalRouteBranches.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createConditionalRouteBranchesTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouterMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ConditionalRouterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouterMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ConditionalRouterMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouterMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ConditionalRouterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#getContinueAfterRoute()
	 * 
	 */
	public Boolean getContinueAfterRoute() {
		return Boolean.valueOf(continueAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#setContinueAfterRoute(Boolean newValue)
	 * 
	 */
	public void setContinueAfterRoute(Boolean newValue) {
		if (newValue != null) {
			continueAfterRoute.setSelection(newValue.booleanValue());
		} else {
			continueAfterRoute.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouterMediator.Properties.continueAfterRoute);
		if (eefElementEditorReadOnlyState && continueAfterRoute.isEnabled()) {
			continueAfterRoute.setEnabled(false);
			continueAfterRoute.setToolTipText(EsbMessages.ConditionalRouterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !continueAfterRoute.isEnabled()) {
			continueAfterRoute.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#initConditionalRouteBranches(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initConditionalRouteBranches(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		conditionalRouteBranches.setContentProvider(contentProvider);
		conditionalRouteBranches.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouterMediator.Properties.conditionalRouteBranches);
		if (eefElementEditorReadOnlyState && conditionalRouteBranches.isEnabled()) {
			conditionalRouteBranches.setEnabled(false);
			conditionalRouteBranches.setToolTipText(EsbMessages.ConditionalRouterMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !conditionalRouteBranches.isEnabled()) {
			conditionalRouteBranches.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#updateConditionalRouteBranches()
	 * 
	 */
	public void updateConditionalRouteBranches() {
	conditionalRouteBranches.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#addFilterConditionalRouteBranches(ViewerFilter filter)
	 * 
	 */
	public void addFilterToConditionalRouteBranches(ViewerFilter filter) {
		conditionalRouteBranchesFilters.add(filter);
		if (this.conditionalRouteBranches != null) {
			this.conditionalRouteBranches.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#addBusinessFilterConditionalRouteBranches(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToConditionalRouteBranches(ViewerFilter filter) {
		conditionalRouteBranchesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ConditionalRouterMediatorPropertiesEditionPart#isContainedInConditionalRouteBranchesTable(EObject element)
	 * 
	 */
	public boolean isContainedInConditionalRouteBranchesTable(EObject element) {
		return ((ReferencesTableSettings)conditionalRouteBranches.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ConditionalRouterMediator_Part_Title;
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
        view.layout(true, true);
    }
	// End of user code


}
