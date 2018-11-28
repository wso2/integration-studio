/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.URLRewriteMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class URLRewriteMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, URLRewriteMediatorPropertiesEditionPart {

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



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public URLRewriteMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence uRLRewriteMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uRLRewriteMediatorStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.inProperty);
		propertiesStep.addStep(EsbViewsRepository.URLRewriteMediator.Properties.outProperty);
		
		
		composer = new PartComposer(uRLRewriteMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules) {
					return createUrlRewriteRulesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.inProperty) {
					return createInPropertyText(parent);
				}
				if (key == EsbViewsRepository.URLRewriteMediator.Properties.outProperty) {
					return createOutPropertyText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.URLRewriteMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteMediator.Properties.description, EsbMessages.URLRewriteMediatorPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.URLRewriteMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.URLRewriteMediator.Properties.commentsList, EsbMessages.URLRewriteMediatorPropertiesEditionPart_CommentsListLabel));
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.URLRewriteMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.URLRewriteMediator.Properties.reverse, EsbMessages.URLRewriteMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.URLRewriteMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createUrlRewriteRulesAdvancedTableComposition(Composite parent) {
		this.urlRewriteRules = new ReferencesTable(getDescription(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, EsbMessages.URLRewriteMediatorPropertiesEditionPart_UrlRewriteRulesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				urlRewriteRules.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				urlRewriteRules.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				urlRewriteRules.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				urlRewriteRules.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.urlRewriteRulesFilters) {
			this.urlRewriteRules.addFilter(filter);
		}
		this.urlRewriteRules.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, EsbViewsRepository.SWT_KIND));
		this.urlRewriteRules.createControls(parent);
		this.urlRewriteRules.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.urlRewriteRules, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createUrlRewriteRulesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createInPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteMediator.Properties.inProperty, EsbMessages.URLRewriteMediatorPropertiesEditionPart_InPropertyLabel);
		inProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		inProperty.setLayoutData(inPropertyData);
		inProperty.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.inProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inProperty.getText()));
			}

		});
		inProperty.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.inProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inProperty.getText()));
				}
			}

		});
		EditingUtils.setID(inProperty, EsbViewsRepository.URLRewriteMediator.Properties.inProperty);
		EditingUtils.setEEFtype(inProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.inProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createOutPropertyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.URLRewriteMediator.Properties.outProperty, EsbMessages.URLRewriteMediatorPropertiesEditionPart_OutPropertyLabel);
		outProperty = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		outProperty.setLayoutData(outPropertyData);
		outProperty.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.outProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outProperty.getText()));
			}

		});
		outProperty.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(URLRewriteMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.URLRewriteMediator.Properties.outProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outProperty.getText()));
				}
			}

		});
		EditingUtils.setID(outProperty, EsbViewsRepository.URLRewriteMediator.Properties.outProperty);
		EditingUtils.setEEFtype(outProperty, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.URLRewriteMediator.Properties.outProperty, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	
	// End of user code


}
