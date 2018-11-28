/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class RuleMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RuleMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text ruleSetURL;
	protected EMFComboViewer ruleSetSourceType;
	protected Text ruleSetSourceCode;
	protected Button statefulSession;
	protected ReferencesTable ruleSessionProperties;
	protected List<ViewerFilter> ruleSessionPropertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ruleSessionPropertiesFilters = new ArrayList<ViewerFilter>();
	protected Text sourceValue;
	protected Text targetValue;
	protected EMFComboViewer targetAction;
	protected Text inputWrapperName;
	protected Text inputNameSpace;
	protected Text outputWrapperName;
	protected Text outputNameSpace;
	protected EMFComboViewer ruleSetType;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ruleMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.ruleSetURL);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.statefulSession);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.sourceValue);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.targetValue);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.targetAction);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.inputWrapperName);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.inputNameSpace);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.outputWrapperName);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.outputNameSpace);
		propertiesStep.addStep(EsbViewsRepository.RuleMediator.Properties.ruleSetType);
		
		
		composer = new PartComposer(ruleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.ruleSetURL) {
					return createRuleSetURLText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType) {
					return createRuleSetSourceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode) {
					return createRuleSetSourceCodeText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.statefulSession) {
					return createStatefulSessionCheckbox(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties) {
					return createRuleSessionPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.sourceValue) {
					return createSourceValueText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.targetValue) {
					return createTargetValueText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.targetAction) {
					return createTargetActionEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.inputWrapperName) {
					return createInputWrapperNameText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.inputNameSpace) {
					return createInputNameSpaceText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.outputWrapperName) {
					return createOutputWrapperNameText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.outputNameSpace) {
					return createOutputNameSpaceText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Properties.ruleSetType) {
					return createRuleSetTypeEMFComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.description, EsbMessages.RuleMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.RuleMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.RuleMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.RuleMediator.Properties.commentsList, EsbMessages.RuleMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "RuleMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.RuleMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.RuleMediator.Properties.reverse, EsbMessages.RuleMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.RuleMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.ruleSetURL, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetURLLabel);
		ruleSetURL = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData ruleSetURLData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetURL.setLayoutData(ruleSetURLData);
		ruleSetURL.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
			}

		});
		ruleSetURL.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
				}
			}

		});
		EditingUtils.setID(ruleSetURL, EsbViewsRepository.RuleMediator.Properties.ruleSetURL);
		EditingUtils.setEEFtype(ruleSetURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.ruleSetURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetURLText

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetSourceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetSourceTypeLabel);
		ruleSetSourceType = new EMFComboViewer(parent);
		ruleSetSourceType.setContentProvider(new ArrayContentProvider());
		ruleSetSourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleSetSourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetSourceType.getCombo().setLayoutData(ruleSetSourceTypeData);
		ruleSetSourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetSourceType()));
			}

		});
		ruleSetSourceType.setID(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetSourceCodeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetSourceCodeLabel);
		ruleSetSourceCode = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData ruleSetSourceCodeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetSourceCode.setLayoutData(ruleSetSourceCodeData);
		ruleSetSourceCode.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
			}

		});
		ruleSetSourceCode.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
				}
			}

		});
		EditingUtils.setID(ruleSetSourceCode, EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode);
		EditingUtils.setEEFtype(ruleSetSourceCode, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceCodeText

		// End of user code
		return parent;
	}

	
	protected Composite createStatefulSessionCheckbox(Composite parent) {
		statefulSession = new Button(parent, SWT.CHECK);
		statefulSession.setText(getDescription(EsbViewsRepository.RuleMediator.Properties.statefulSession, EsbMessages.RuleMediatorPropertiesEditionPart_StatefulSessionLabel));
		statefulSession.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.statefulSession, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statefulSession.getSelection())));
			}

		});
		GridData statefulSessionData = new GridData(GridData.FILL_HORIZONTAL);
		statefulSessionData.horizontalSpan = 2;
		statefulSession.setLayoutData(statefulSessionData);
		EditingUtils.setID(statefulSession, EsbViewsRepository.RuleMediator.Properties.statefulSession);
		EditingUtils.setEEFtype(statefulSession, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.statefulSession, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatefulSessionCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRuleSessionPropertiesAdvancedTableComposition(Composite parent) {
		this.ruleSessionProperties = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSessionPropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleSessionProperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleSessionProperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleSessionProperties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleSessionProperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleSessionPropertiesFilters) {
			this.ruleSessionProperties.addFilter(filter);
		}
		this.ruleSessionProperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, EsbViewsRepository.SWT_KIND));
		this.ruleSessionProperties.createControls(parent);
		this.ruleSessionProperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ruleSessionPropertiesData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSessionPropertiesData.horizontalSpan = 3;
		this.ruleSessionProperties.setLayoutData(ruleSessionPropertiesData);
		this.ruleSessionProperties.setLowerBound(0);
		this.ruleSessionProperties.setUpperBound(-1);
		ruleSessionProperties.setID(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties);
		ruleSessionProperties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRuleSessionPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createSourceValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.sourceValue, EsbMessages.RuleMediatorPropertiesEditionPart_SourceValueLabel);
		sourceValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sourceValueData = new GridData(GridData.FILL_HORIZONTAL);
		sourceValue.setLayoutData(sourceValueData);
		sourceValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.sourceValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
			}

		});
		sourceValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.sourceValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
				}
			}

		});
		EditingUtils.setID(sourceValue, EsbViewsRepository.RuleMediator.Properties.sourceValue);
		EditingUtils.setEEFtype(sourceValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.sourceValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceValueText

		// End of user code
		return parent;
	}

	
	protected Composite createTargetValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.targetValue, EsbMessages.RuleMediatorPropertiesEditionPart_TargetValueLabel);
		targetValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData targetValueData = new GridData(GridData.FILL_HORIZONTAL);
		targetValue.setLayoutData(targetValueData);
		targetValue.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.targetValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
			}

		});
		targetValue.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.targetValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
				}
			}

		});
		EditingUtils.setID(targetValue, EsbViewsRepository.RuleMediator.Properties.targetValue);
		EditingUtils.setEEFtype(targetValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.targetValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetValueText

		// End of user code
		return parent;
	}

	
	protected Composite createTargetActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.targetAction, EsbMessages.RuleMediatorPropertiesEditionPart_TargetActionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.targetAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAction()));
			}

		});
		targetAction.setID(EsbViewsRepository.RuleMediator.Properties.targetAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.targetAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetActionEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInputWrapperNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.inputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_InputWrapperNameLabel);
		inputWrapperName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inputWrapperNameData = new GridData(GridData.FILL_HORIZONTAL);
		inputWrapperName.setLayoutData(inputWrapperNameData);
		inputWrapperName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.inputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
			}

		});
		inputWrapperName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.inputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
				}
			}

		});
		EditingUtils.setID(inputWrapperName, EsbViewsRepository.RuleMediator.Properties.inputWrapperName);
		EditingUtils.setEEFtype(inputWrapperName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.inputWrapperName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputWrapperNameText

		// End of user code
		return parent;
	}

	
	protected Composite createInputNameSpaceText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.inputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_InputNameSpaceLabel);
		inputNameSpace = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData inputNameSpaceData = new GridData(GridData.FILL_HORIZONTAL);
		inputNameSpace.setLayoutData(inputNameSpaceData);
		inputNameSpace.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.inputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
			}

		});
		inputNameSpace.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.inputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
				}
			}

		});
		EditingUtils.setID(inputNameSpace, EsbViewsRepository.RuleMediator.Properties.inputNameSpace);
		EditingUtils.setEEFtype(inputNameSpace, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.inputNameSpace, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputNameSpaceText

		// End of user code
		return parent;
	}

	
	protected Composite createOutputWrapperNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.outputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_OutputWrapperNameLabel);
		outputWrapperName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outputWrapperNameData = new GridData(GridData.FILL_HORIZONTAL);
		outputWrapperName.setLayoutData(outputWrapperNameData);
		outputWrapperName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.outputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
			}

		});
		outputWrapperName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.outputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
				}
			}

		});
		EditingUtils.setID(outputWrapperName, EsbViewsRepository.RuleMediator.Properties.outputWrapperName);
		EditingUtils.setEEFtype(outputWrapperName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.outputWrapperName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputWrapperNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOutputNameSpaceText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.outputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_OutputNameSpaceLabel);
		outputNameSpace = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData outputNameSpaceData = new GridData(GridData.FILL_HORIZONTAL);
		outputNameSpace.setLayoutData(outputNameSpaceData);
		outputNameSpace.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.outputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
			}

		});
		outputNameSpace.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.outputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
				}
			}

		});
		EditingUtils.setID(outputNameSpace, EsbViewsRepository.RuleMediator.Properties.outputNameSpace);
		EditingUtils.setEEFtype(outputNameSpace, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.outputNameSpace, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputNameSpaceText

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Properties.ruleSetType, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetTypeLabel);
		ruleSetType = new EMFComboViewer(parent);
		ruleSetType.setContentProvider(new ArrayContentProvider());
		ruleSetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleSetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetType.getCombo().setLayoutData(ruleSetTypeData);
		ruleSetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Properties.ruleSetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetType()));
			}

		});
		ruleSetType.setID(EsbViewsRepository.RuleMediator.Properties.ruleSetType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Properties.ruleSetType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetURL()
	 * 
	 */
	public String getRuleSetURL() {
		return ruleSetURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetURL(String newValue)
	 * 
	 */
	public void setRuleSetURL(String newValue) {
		if (newValue != null) {
			ruleSetURL.setText(newValue);
		} else {
			ruleSetURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetURL);
		if (eefElementEditorReadOnlyState && ruleSetURL.isEnabled()) {
			ruleSetURL.setEnabled(false);
			ruleSetURL.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetURL.isEnabled()) {
			ruleSetURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetSourceType()
	 * 
	 */
	public Enumerator getRuleSetSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleSetSourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSetSourceType(Object input, Enumerator current)
	 */
	public void initRuleSetSourceType(Object input, Enumerator current) {
		ruleSetSourceType.setInput(input);
		ruleSetSourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType);
		if (eefElementEditorReadOnlyState && ruleSetSourceType.isEnabled()) {
			ruleSetSourceType.setEnabled(false);
			ruleSetSourceType.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetSourceType.isEnabled()) {
			ruleSetSourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetSourceType(Enumerator newValue)
	 * 
	 */
	public void setRuleSetSourceType(Enumerator newValue) {
		ruleSetSourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceType);
		if (eefElementEditorReadOnlyState && ruleSetSourceType.isEnabled()) {
			ruleSetSourceType.setEnabled(false);
			ruleSetSourceType.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetSourceType.isEnabled()) {
			ruleSetSourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetSourceCode()
	 * 
	 */
	public String getRuleSetSourceCode() {
		return ruleSetSourceCode.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetSourceCode(String newValue)
	 * 
	 */
	public void setRuleSetSourceCode(String newValue) {
		if (newValue != null) {
			ruleSetSourceCode.setText(newValue);
		} else {
			ruleSetSourceCode.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetSourceCode);
		if (eefElementEditorReadOnlyState && ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(false);
			ruleSetSourceCode.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getStatefulSession()
	 * 
	 */
	public Boolean getStatefulSession() {
		return Boolean.valueOf(statefulSession.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setStatefulSession(Boolean newValue)
	 * 
	 */
	public void setStatefulSession(Boolean newValue) {
		if (newValue != null) {
			statefulSession.setSelection(newValue.booleanValue());
		} else {
			statefulSession.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.statefulSession);
		if (eefElementEditorReadOnlyState && statefulSession.isEnabled()) {
			statefulSession.setEnabled(false);
			statefulSession.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statefulSession.isEnabled()) {
			statefulSession.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSessionProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRuleSessionProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ruleSessionProperties.setContentProvider(contentProvider);
		ruleSessionProperties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSessionProperties);
		if (eefElementEditorReadOnlyState && ruleSessionProperties.isEnabled()) {
			ruleSessionProperties.setEnabled(false);
			ruleSessionProperties.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSessionProperties.isEnabled()) {
			ruleSessionProperties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleSessionProperties()
	 * 
	 */
	public void updateRuleSessionProperties() {
	ruleSessionProperties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleSessionProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRuleSessionProperties(ViewerFilter filter) {
		ruleSessionPropertiesFilters.add(filter);
		if (this.ruleSessionProperties != null) {
			this.ruleSessionProperties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleSessionProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleSessionProperties(ViewerFilter filter) {
		ruleSessionPropertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleSessionPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleSessionPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)ruleSessionProperties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getSourceValue()
	 * 
	 */
	public String getSourceValue() {
		return sourceValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setSourceValue(String newValue)
	 * 
	 */
	public void setSourceValue(String newValue) {
		if (newValue != null) {
			sourceValue.setText(newValue);
		} else {
			sourceValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.sourceValue);
		if (eefElementEditorReadOnlyState && sourceValue.isEnabled()) {
			sourceValue.setEnabled(false);
			sourceValue.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceValue.isEnabled()) {
			sourceValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getTargetValue()
	 * 
	 */
	public String getTargetValue() {
		return targetValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setTargetValue(String newValue)
	 * 
	 */
	public void setTargetValue(String newValue) {
		if (newValue != null) {
			targetValue.setText(newValue);
		} else {
			targetValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.targetValue);
		if (eefElementEditorReadOnlyState && targetValue.isEnabled()) {
			targetValue.setEnabled(false);
			targetValue.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetValue.isEnabled()) {
			targetValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getTargetAction()
	 * 
	 */
	public Enumerator getTargetAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initTargetAction(Object input, Enumerator current)
	 */
	public void initTargetAction(Object input, Enumerator current) {
		targetAction.setInput(input);
		targetAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setTargetAction(Enumerator newValue)
	 * 
	 */
	public void setTargetAction(Enumerator newValue) {
		targetAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.targetAction);
		if (eefElementEditorReadOnlyState && targetAction.isEnabled()) {
			targetAction.setEnabled(false);
			targetAction.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetAction.isEnabled()) {
			targetAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getInputWrapperName()
	 * 
	 */
	public String getInputWrapperName() {
		return inputWrapperName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setInputWrapperName(String newValue)
	 * 
	 */
	public void setInputWrapperName(String newValue) {
		if (newValue != null) {
			inputWrapperName.setText(newValue);
		} else {
			inputWrapperName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.inputWrapperName);
		if (eefElementEditorReadOnlyState && inputWrapperName.isEnabled()) {
			inputWrapperName.setEnabled(false);
			inputWrapperName.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputWrapperName.isEnabled()) {
			inputWrapperName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getInputNameSpace()
	 * 
	 */
	public String getInputNameSpace() {
		return inputNameSpace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setInputNameSpace(String newValue)
	 * 
	 */
	public void setInputNameSpace(String newValue) {
		if (newValue != null) {
			inputNameSpace.setText(newValue);
		} else {
			inputNameSpace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.inputNameSpace);
		if (eefElementEditorReadOnlyState && inputNameSpace.isEnabled()) {
			inputNameSpace.setEnabled(false);
			inputNameSpace.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputNameSpace.isEnabled()) {
			inputNameSpace.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getOutputWrapperName()
	 * 
	 */
	public String getOutputWrapperName() {
		return outputWrapperName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setOutputWrapperName(String newValue)
	 * 
	 */
	public void setOutputWrapperName(String newValue) {
		if (newValue != null) {
			outputWrapperName.setText(newValue);
		} else {
			outputWrapperName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.outputWrapperName);
		if (eefElementEditorReadOnlyState && outputWrapperName.isEnabled()) {
			outputWrapperName.setEnabled(false);
			outputWrapperName.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputWrapperName.isEnabled()) {
			outputWrapperName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getOutputNameSpace()
	 * 
	 */
	public String getOutputNameSpace() {
		return outputNameSpace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setOutputNameSpace(String newValue)
	 * 
	 */
	public void setOutputNameSpace(String newValue) {
		if (newValue != null) {
			outputNameSpace.setText(newValue);
		} else {
			outputNameSpace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.outputNameSpace);
		if (eefElementEditorReadOnlyState && outputNameSpace.isEnabled()) {
			outputNameSpace.setEnabled(false);
			outputNameSpace.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputNameSpace.isEnabled()) {
			outputNameSpace.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetType()
	 * 
	 */
	public Enumerator getRuleSetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleSetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSetType(Object input, Enumerator current)
	 */
	public void initRuleSetType(Object input, Enumerator current) {
		ruleSetType.setInput(input);
		ruleSetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetType);
		if (eefElementEditorReadOnlyState && ruleSetType.isEnabled()) {
			ruleSetType.setEnabled(false);
			ruleSetType.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetType.isEnabled()) {
			ruleSetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetType(Enumerator newValue)
	 * 
	 */
	public void setRuleSetType(Enumerator newValue) {
		ruleSetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Properties.ruleSetType);
		if (eefElementEditorReadOnlyState && ruleSetType.isEnabled()) {
			ruleSetType.setEnabled(false);
			ruleSetType.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetType.isEnabled()) {
			ruleSetType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
