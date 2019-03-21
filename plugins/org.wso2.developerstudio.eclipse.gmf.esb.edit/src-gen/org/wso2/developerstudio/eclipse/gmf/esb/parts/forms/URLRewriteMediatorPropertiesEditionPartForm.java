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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * @generated NOT
 */
public class URLRewriteMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, URLRewriteMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable urlRewriteRules;
	protected List<ViewerFilter> urlRewriteRulesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> urlRewriteRulesFilters = new ArrayList<ViewerFilter>();
	protected Text inProperty;
	protected Text outProperty;
    protected Control[] commentsElements;
    protected Control[] reverseElements;
    protected Composite propertiesGroup;
    protected Composite filterInOutSubPropertiesGroup;

	/**
	 * For {@link ISection} use only.
	 */
	public URLRewriteMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uRLRewriteMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uRLRewriteMediatorStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.inProperty);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.outProperty);
        propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.description);
		
		composer = new PartComposer(uRLRewriteMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules) {
					return createUrlRewriteRulesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.inProperty) {
					return createInPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.outProperty) {
					return createOutPropertyText(widgetFactory, filterInOutSubPropertiesGroup);
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
		propertiesSection.setText(EsbMessages.URLRewriteMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.URLRewriteMediator.Properties.description, EsbMessages.URLRewriteMediatorPropertiesEditionPart_DescriptionLabel);
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
							URLRewriteMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.URLRewriteMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									URLRewriteMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.URLRewriteMediator.Properties.description,
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
									URLRewriteMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.URLRewriteMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.URLRewriteMediator.Properties.commentsList, EsbMessages.URLRewriteMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "URLRewriteMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
        Control [] newControls = propertiesGroup.getChildren();
        commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = propertiesGroup.getChildren();
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.URLRewriteMediator.Properties.reverse, EsbMessages.URLRewriteMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.URLRewriteMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
        Control [] newControls = propertiesGroup.getChildren();
        reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createUrlRewriteRulesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.urlRewriteRules = new ReferencesTable(getDescription(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, EsbMessages.URLRewriteMediatorPropertiesEditionPart_UrlRewriteRulesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				urlRewriteRules.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				urlRewriteRules.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				urlRewriteRules.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				urlRewriteRules.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.urlRewriteRulesFilters) {
			this.urlRewriteRules.addFilter(filter);
		}
		this.urlRewriteRules.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, EsbViewsRepository.FORM_KIND));
		this.urlRewriteRules.createControls(parent, widgetFactory);
		this.urlRewriteRules.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData urlRewriteRulesData = new GridData(GridData.FILL_HORIZONTAL);
		urlRewriteRulesData.horizontalSpan = 3;
		this.urlRewriteRules.setLayoutData(urlRewriteRulesData);
		this.urlRewriteRules.setLowerBound(0);
		this.urlRewriteRules.setUpperBound(-1);
		urlRewriteRules.setID(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules);
		urlRewriteRules.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createUrlRewriteRulesTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createInPropertyText(FormToolkit widgetFactory, Composite parent) {
	    filterInOutSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "In-Out Properties", true);
		createDescription(filterInOutSubPropertiesGroup, EsbViewsRepository.URLRewriteMediator.Properties.inProperty, EsbMessages.URLRewriteMediatorPropertiesEditionPart_InPropertyLabel);
		inProperty = widgetFactory.createText(filterInOutSubPropertiesGroup, ""); //$NON-NLS-1$
		inProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(filterInOutSubPropertiesGroup);
		GridData inPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		inProperty.setLayoutData(inPropertyData);
		inProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							URLRewriteMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.URLRewriteMediator.Properties.inProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									URLRewriteMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.URLRewriteMediator.Properties.inProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inProperty.getText()));
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
									URLRewriteMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.inProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inProperty.getText()));
				}
			}
		});
		EditingUtils.setID(inProperty, EsbViewsRepository.URLRewriteMediator.Properties.inProperty);
		EditingUtils.setEEFtype(inProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, filterInOutSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.inProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createOutPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteMediator.Properties.outProperty, EsbMessages.URLRewriteMediatorPropertiesEditionPart_OutPropertyLabel);
		outProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		outProperty.setLayoutData(outPropertyData);
		outProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							URLRewriteMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.URLRewriteMediator.Properties.outProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									URLRewriteMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.URLRewriteMediator.Properties.outProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outProperty.getText()));
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
									URLRewriteMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartForm.this, EsbViewsRepository.URLRewriteMediator.Properties.outProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outProperty.getText()));
				}
			}
		});
		EditingUtils.setID(outProperty, EsbViewsRepository.URLRewriteMediator.Properties.outProperty);
		EditingUtils.setEEFtype(outProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.outProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutPropertyText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#initUrlRewriteRules(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initUrlRewriteRules(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		urlRewriteRules.setContentProvider(contentProvider);
		urlRewriteRules.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules);
		if (eefElementEditorReadOnlyState && urlRewriteRules.isEnabled()) {
			urlRewriteRules.setEnabled(false);
			urlRewriteRules.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !urlRewriteRules.isEnabled()) {
			urlRewriteRules.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#updateUrlRewriteRules()
	 * 
	 */
	public void updateUrlRewriteRules() {
	urlRewriteRules.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#addFilterUrlRewriteRules(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUrlRewriteRules(ViewerFilter filter) {
		urlRewriteRulesFilters.add(filter);
		if (this.urlRewriteRules != null) {
			this.urlRewriteRules.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#addBusinessFilterUrlRewriteRules(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUrlRewriteRules(ViewerFilter filter) {
		urlRewriteRulesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#isContainedInUrlRewriteRulesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUrlRewriteRulesTable(EObject element) {
		return ((ReferencesTableSettings)urlRewriteRules.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#getInProperty()
	 * 
	 */
	public String getInProperty() {
		return inProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#setInProperty(String newValue)
	 * 
	 */
	public void setInProperty(String newValue) {
		if (newValue != null) {
			inProperty.setText(newValue);
		} else {
			inProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.inProperty);
		if (eefElementEditorReadOnlyState && inProperty.isEnabled()) {
			inProperty.setEnabled(false);
			inProperty.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inProperty.isEnabled()) {
			inProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#getOutProperty()
	 * 
	 */
	public String getOutProperty() {
		return outProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart#setOutProperty(String newValue)
	 * 
	 */
	public void setOutProperty(String newValue) {
		if (newValue != null) {
			outProperty.setText(newValue);
		} else {
			outProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.URLRewriteMediator.Properties.outProperty);
		if (eefElementEditorReadOnlyState && outProperty.isEnabled()) {
			outProperty.setEnabled(false);
			outProperty.setToolTipText(EsbMessages.URLRewriteMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outProperty.isEnabled()) {
			outProperty.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.URLRewriteMediator_Part_Title;
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
