/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

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
	protected Button statefulSession;
	protected ReferencesTable ruleSessionProperties;
	protected List<ViewerFilter> ruleSessionPropertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ruleSessionPropertiesFilters = new ArrayList<ViewerFilter>();
	protected Text inputWrapperName;
	protected Text inputNameSpace;
	protected ReferencesTable ruleFactsConfiguration;
	protected List<ViewerFilter> ruleFactsConfigurationBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ruleFactsConfigurationFilters = new ArrayList<ViewerFilter>();
	protected Text outputWrapperName;
	protected Text outputNameSpace;
	protected ReferencesTable ruleResultsConfiguration;
	protected List<ViewerFilter> ruleResultsConfigurationBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ruleResultsConfigurationFilters = new ArrayList<ViewerFilter>();
	protected Text sourceValue;
	// Start of user code  for sourceXPath widgets declarations
	
	// End of user code

	protected Text targetValue;
	protected EMFComboViewer targetAction;
	// Start of user code  for targetXPath widgets declarations
	
	// End of user code

	// Start of user code  for targetResultXPath widgets declarations
	
	// End of user code

	protected EMFComboViewer ruleSetType;
	protected Text ruleSetURL;
	protected EMFComboViewer ruleSetSourceType;
	protected Text ruleSetSourceCode;
	// Start of user code  for ruleSetSourceKey widgets declarations
	
	// End of user code




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
		CompositionStep miscStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.Misc.class);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.description);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.commentsList);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.reverse);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.statefulSession);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties);
		
		CompositionStep inputFactsStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.class);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration);
		
		CompositionStep outputFactsStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.class);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration);
		
		CompositionStep sourceStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.Source.class);
		sourceStep.addStep(EsbViewsRepository.RuleMediator.Source.sourceValue);
		sourceStep.addStep(EsbViewsRepository.RuleMediator.Source.sourceXPath);
		
		CompositionStep targetStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.Target.class);
		targetStep.addStep(EsbViewsRepository.RuleMediator.Target.targetValue);
		targetStep.addStep(EsbViewsRepository.RuleMediator.Target.targetAction);
		targetStep.addStep(EsbViewsRepository.RuleMediator.Target.targetXPath);
		targetStep.addStep(EsbViewsRepository.RuleMediator.Target.targetResultXPath);
		
		CompositionStep ruleSetStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.class);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey);
		
		
		composer = new PartComposer(ruleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleMediator.Misc.class) {
					return createMiscGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.statefulSession) {
					return createStatefulSessionCheckbox(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties) {
					return createRuleSessionPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.class) {
					return createInputFactsGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName) {
					return createInputWrapperNameText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace) {
					return createInputNameSpaceText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration) {
					return createRuleFactsConfigurationAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.class) {
					return createOutputFactsGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName) {
					return createOutputWrapperNameText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace) {
					return createOutputNameSpaceText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration) {
					return createRuleResultsConfigurationAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Source.class) {
					return createSourceGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Source.sourceValue) {
					return createSourceValueText(parent);
				}
				// Start of user code for sourceXPath addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.RuleMediator.Target.class) {
					return createTargetGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Target.targetValue) {
					return createTargetValueText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Target.targetAction) {
					return createTargetActionEMFComboViewer(parent);
				}
				// Start of user code for targetXPath addToPart creation
				
				// End of user code
				// Start of user code for targetResultXPath addToPart creation
				
				// End of user code
				if (key == EsbViewsRepository.RuleMediator.RuleSet.class) {
					return createRuleSetGroup(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetType) {
					return createRuleSetTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL) {
					return createRuleSetURLText(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType) {
					return createRuleSetSourceTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode) {
					return createRuleSetSourceCodeText(parent);
				}
				// Start of user code for ruleSetSourceKey addToPart creation
				
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createMiscGroup(Composite parent) {
		Group miscGroup = new Group(parent, SWT.NONE);
		miscGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_MiscGroupLabel);
		GridData miscGroupData = new GridData(GridData.FILL_HORIZONTAL);
		miscGroupData.horizontalSpan = 3;
		miscGroup.setLayoutData(miscGroupData);
		GridLayout miscGroupLayout = new GridLayout();
		miscGroupLayout.numColumns = 3;
		miscGroup.setLayout(miscGroupLayout);
		return miscGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Misc.description, EsbMessages.RuleMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.RuleMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.RuleMediator.Misc.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.RuleMediator.Misc.commentsList, EsbMessages.RuleMediatorPropertiesEditionPart_CommentsListLabel));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.RuleMediator.Misc.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.RuleMediator.Misc.reverse, EsbMessages.RuleMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.RuleMediator.Misc.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStatefulSessionCheckbox(Composite parent) {
		statefulSession = new Button(parent, SWT.CHECK);
		statefulSession.setText(getDescription(EsbViewsRepository.RuleMediator.Misc.statefulSession, EsbMessages.RuleMediatorPropertiesEditionPart_StatefulSessionLabel));
		statefulSession.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.statefulSession, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statefulSession.getSelection())));
			}

		});
		GridData statefulSessionData = new GridData(GridData.FILL_HORIZONTAL);
		statefulSessionData.horizontalSpan = 2;
		statefulSession.setLayoutData(statefulSessionData);
		EditingUtils.setID(statefulSession, EsbViewsRepository.RuleMediator.Misc.statefulSession);
		EditingUtils.setEEFtype(statefulSession, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.statefulSession, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatefulSessionCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRuleSessionPropertiesAdvancedTableComposition(Composite parent) {
		this.ruleSessionProperties = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSessionPropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleSessionProperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleSessionProperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleSessionProperties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleSessionProperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleSessionPropertiesFilters) {
			this.ruleSessionProperties.addFilter(filter);
		}
		this.ruleSessionProperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, EsbViewsRepository.SWT_KIND));
		this.ruleSessionProperties.createControls(parent);
		this.ruleSessionProperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ruleSessionPropertiesData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSessionPropertiesData.horizontalSpan = 3;
		this.ruleSessionProperties.setLayoutData(ruleSessionPropertiesData);
		this.ruleSessionProperties.setLowerBound(0);
		this.ruleSessionProperties.setUpperBound(-1);
		ruleSessionProperties.setID(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties);
		ruleSessionProperties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRuleSessionPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createInputFactsGroup(Composite parent) {
		Group inputFactsGroup = new Group(parent, SWT.NONE);
		inputFactsGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_InputFactsGroupLabel);
		GridData inputFactsGroupData = new GridData(GridData.FILL_HORIZONTAL);
		inputFactsGroupData.horizontalSpan = 3;
		inputFactsGroup.setLayoutData(inputFactsGroupData);
		GridLayout inputFactsGroupLayout = new GridLayout();
		inputFactsGroupLayout.numColumns = 3;
		inputFactsGroup.setLayout(inputFactsGroupLayout);
		return inputFactsGroup;
	}

	
	protected Composite createInputWrapperNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_InputWrapperNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
				}
			}

		});
		EditingUtils.setID(inputWrapperName, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName);
		EditingUtils.setEEFtype(inputWrapperName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputWrapperNameText

		// End of user code
		return parent;
	}

	
	protected Composite createInputNameSpaceText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_InputNameSpaceLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
				}
			}

		});
		EditingUtils.setID(inputNameSpace, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace);
		EditingUtils.setEEFtype(inputNameSpace, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputNameSpaceText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRuleFactsConfigurationAdvancedTableComposition(Composite parent) {
		this.ruleFactsConfiguration = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, EsbMessages.RuleMediatorPropertiesEditionPart_RuleFactsConfigurationLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleFactsConfiguration.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleFactsConfiguration.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleFactsConfiguration.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleFactsConfiguration.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleFactsConfigurationFilters) {
			this.ruleFactsConfiguration.addFilter(filter);
		}
		this.ruleFactsConfiguration.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, EsbViewsRepository.SWT_KIND));
		this.ruleFactsConfiguration.createControls(parent);
		this.ruleFactsConfiguration.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ruleFactsConfigurationData = new GridData(GridData.FILL_HORIZONTAL);
		ruleFactsConfigurationData.horizontalSpan = 3;
		this.ruleFactsConfiguration.setLayoutData(ruleFactsConfigurationData);
		this.ruleFactsConfiguration.setLowerBound(0);
		this.ruleFactsConfiguration.setUpperBound(1);
		ruleFactsConfiguration.setID(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration);
		ruleFactsConfiguration.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRuleFactsConfigurationAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createOutputFactsGroup(Composite parent) {
		Group outputFactsGroup = new Group(parent, SWT.NONE);
		outputFactsGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_OutputFactsGroupLabel);
		GridData outputFactsGroupData = new GridData(GridData.FILL_HORIZONTAL);
		outputFactsGroupData.horizontalSpan = 3;
		outputFactsGroup.setLayoutData(outputFactsGroupData);
		GridLayout outputFactsGroupLayout = new GridLayout();
		outputFactsGroupLayout.numColumns = 3;
		outputFactsGroup.setLayout(outputFactsGroupLayout);
		return outputFactsGroup;
	}

	
	protected Composite createOutputWrapperNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_OutputWrapperNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
				}
			}

		});
		EditingUtils.setID(outputWrapperName, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName);
		EditingUtils.setEEFtype(outputWrapperName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputWrapperNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOutputNameSpaceText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_OutputNameSpaceLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
				}
			}

		});
		EditingUtils.setID(outputNameSpace, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace);
		EditingUtils.setEEFtype(outputNameSpace, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputNameSpaceText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createRuleResultsConfigurationAdvancedTableComposition(Composite parent) {
		this.ruleResultsConfiguration = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, EsbMessages.RuleMediatorPropertiesEditionPart_RuleResultsConfigurationLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleResultsConfiguration.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleResultsConfiguration.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleResultsConfiguration.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleResultsConfiguration.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleResultsConfigurationFilters) {
			this.ruleResultsConfiguration.addFilter(filter);
		}
		this.ruleResultsConfiguration.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, EsbViewsRepository.SWT_KIND));
		this.ruleResultsConfiguration.createControls(parent);
		this.ruleResultsConfiguration.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData ruleResultsConfigurationData = new GridData(GridData.FILL_HORIZONTAL);
		ruleResultsConfigurationData.horizontalSpan = 3;
		this.ruleResultsConfiguration.setLayoutData(ruleResultsConfigurationData);
		this.ruleResultsConfiguration.setLowerBound(0);
		this.ruleResultsConfiguration.setUpperBound(1);
		ruleResultsConfiguration.setID(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration);
		ruleResultsConfiguration.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createRuleResultsConfigurationAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSourceGroup(Composite parent) {
		Group sourceGroup = new Group(parent, SWT.NONE);
		sourceGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_SourceGroupLabel);
		GridData sourceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		sourceGroupData.horizontalSpan = 3;
		sourceGroup.setLayoutData(sourceGroupData);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		return sourceGroup;
	}

	
	protected Composite createSourceValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Source.sourceValue, EsbMessages.RuleMediatorPropertiesEditionPart_SourceValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Source.sourceValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Source.sourceValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
				}
			}

		});
		EditingUtils.setID(sourceValue, EsbViewsRepository.RuleMediator.Source.sourceValue);
		EditingUtils.setEEFtype(sourceValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Source.sourceValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceValueText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTargetGroup(Composite parent) {
		Group targetGroup = new Group(parent, SWT.NONE);
		targetGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_TargetGroupLabel);
		GridData targetGroupData = new GridData(GridData.FILL_HORIZONTAL);
		targetGroupData.horizontalSpan = 3;
		targetGroup.setLayoutData(targetGroupData);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		return targetGroup;
	}

	
	protected Composite createTargetValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Target.targetValue, EsbMessages.RuleMediatorPropertiesEditionPart_TargetValueLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Target.targetValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Target.targetValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
				}
			}

		});
		EditingUtils.setID(targetValue, EsbViewsRepository.RuleMediator.Target.targetValue);
		EditingUtils.setEEFtype(targetValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Target.targetValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetValueText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTargetActionEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.Target.targetAction, EsbMessages.RuleMediatorPropertiesEditionPart_TargetActionLabel);
		targetAction = new EMFComboViewer(parent);
		targetAction.setContentProvider(new ArrayContentProvider());
		targetAction.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetActionData = new GridData(GridData.FILL_HORIZONTAL);
		targetAction.getCombo().setLayoutData(targetActionData);
                targetAction.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		targetAction.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.Target.targetAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAction()));
			}

		});
		targetAction.setID(EsbViewsRepository.RuleMediator.Target.targetAction);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Target.targetAction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetActionEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createRuleSetGroup(Composite parent) {
		Group ruleSetGroup = new Group(parent, SWT.NONE);
		ruleSetGroup.setText(EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetGroupLabel);
		GridData ruleSetGroupData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetGroupData.horizontalSpan = 3;
		ruleSetGroup.setLayoutData(ruleSetGroupData);
		GridLayout ruleSetGroupLayout = new GridLayout();
		ruleSetGroupLayout.numColumns = 3;
		ruleSetGroup.setLayout(ruleSetGroupLayout);
		return ruleSetGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createRuleSetTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetType, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetTypeLabel);
		ruleSetType = new EMFComboViewer(parent);
		ruleSetType.setContentProvider(new ArrayContentProvider());
		ruleSetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleSetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetType.getCombo().setLayoutData(ruleSetTypeData);
                ruleSetType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		ruleSetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetType()));
			}

		});
		ruleSetType.setID(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetURLText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetURLLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
				}
			}

		});
		EditingUtils.setID(ruleSetURL, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL);
		EditingUtils.setEEFtype(ruleSetURL, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetURLText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createRuleSetSourceTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetSourceTypeLabel);
		ruleSetSourceType = new EMFComboViewer(parent);
		ruleSetSourceType.setContentProvider(new ArrayContentProvider());
		ruleSetSourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData ruleSetSourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetSourceType.getCombo().setLayoutData(ruleSetSourceTypeData);
                ruleSetSourceType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		ruleSetSourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetSourceType()));
			}

		});
		ruleSetSourceType.setID(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createRuleSetSourceCodeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetSourceCodeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
				}
			}

		});
		EditingUtils.setID(ruleSetSourceCode, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		EditingUtils.setEEFtype(ruleSetSourceCode, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceCodeText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Misc.description);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Misc.commentsList);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Misc.reverse);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getStatefulSession()
	 * 
	 */
	public Boolean getStatefulSession() {
		return Boolean.valueOf(statefulSession.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setStatefulSession(Boolean newValue)
	 * 
	 */
	public void setStatefulSession(Boolean newValue) {
		if (newValue != null) {
			statefulSession.setSelection(newValue.booleanValue());
		} else {
			statefulSession.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Misc.statefulSession);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSessionProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRuleSessionProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ruleSessionProperties.setContentProvider(contentProvider);
		ruleSessionProperties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleSessionProperties()
	 * 
	 */
	public void updateRuleSessionProperties() {
	ruleSessionProperties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleSessionProperties(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleSessionProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleSessionProperties(ViewerFilter filter) {
		ruleSessionPropertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleSessionPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleSessionPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)ruleSessionProperties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getInputWrapperName()
	 * 
	 */
	public String getInputWrapperName() {
		return inputWrapperName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setInputWrapperName(String newValue)
	 * 
	 */
	public void setInputWrapperName(String newValue) {
		if (newValue != null) {
			inputWrapperName.setText(newValue);
		} else {
			inputWrapperName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getInputNameSpace()
	 * 
	 */
	public String getInputNameSpace() {
		return inputNameSpace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setInputNameSpace(String newValue)
	 * 
	 */
	public void setInputNameSpace(String newValue) {
		if (newValue != null) {
			inputNameSpace.setText(newValue);
		} else {
			inputNameSpace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleFactsConfiguration(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRuleFactsConfiguration(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ruleFactsConfiguration.setContentProvider(contentProvider);
		ruleFactsConfiguration.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration);
		if (eefElementEditorReadOnlyState && ruleFactsConfiguration.isEnabled()) {
			ruleFactsConfiguration.setEnabled(false);
			ruleFactsConfiguration.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleFactsConfiguration.isEnabled()) {
			ruleFactsConfiguration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleFactsConfiguration()
	 * 
	 */
	public void updateRuleFactsConfiguration() {
	ruleFactsConfiguration.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleFactsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRuleFactsConfiguration(ViewerFilter filter) {
		ruleFactsConfigurationFilters.add(filter);
		if (this.ruleFactsConfiguration != null) {
			this.ruleFactsConfiguration.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleFactsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleFactsConfiguration(ViewerFilter filter) {
		ruleFactsConfigurationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleFactsConfigurationTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleFactsConfigurationTable(EObject element) {
		return ((ReferencesTableSettings)ruleFactsConfiguration.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getOutputWrapperName()
	 * 
	 */
	public String getOutputWrapperName() {
		return outputWrapperName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setOutputWrapperName(String newValue)
	 * 
	 */
	public void setOutputWrapperName(String newValue) {
		if (newValue != null) {
			outputWrapperName.setText(newValue);
		} else {
			outputWrapperName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getOutputNameSpace()
	 * 
	 */
	public String getOutputNameSpace() {
		return outputNameSpace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setOutputNameSpace(String newValue)
	 * 
	 */
	public void setOutputNameSpace(String newValue) {
		if (newValue != null) {
			outputNameSpace.setText(newValue);
		} else {
			outputNameSpace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleResultsConfiguration(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRuleResultsConfiguration(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		ruleResultsConfiguration.setContentProvider(contentProvider);
		ruleResultsConfiguration.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration);
		if (eefElementEditorReadOnlyState && ruleResultsConfiguration.isEnabled()) {
			ruleResultsConfiguration.setEnabled(false);
			ruleResultsConfiguration.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleResultsConfiguration.isEnabled()) {
			ruleResultsConfiguration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleResultsConfiguration()
	 * 
	 */
	public void updateRuleResultsConfiguration() {
	ruleResultsConfiguration.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleResultsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRuleResultsConfiguration(ViewerFilter filter) {
		ruleResultsConfigurationFilters.add(filter);
		if (this.ruleResultsConfiguration != null) {
			this.ruleResultsConfiguration.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleResultsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleResultsConfiguration(ViewerFilter filter) {
		ruleResultsConfigurationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleResultsConfigurationTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleResultsConfigurationTable(EObject element) {
		return ((ReferencesTableSettings)ruleResultsConfiguration.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getSourceValue()
	 * 
	 */
	public String getSourceValue() {
		return sourceValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setSourceValue(String newValue)
	 * 
	 */
	public void setSourceValue(String newValue) {
		if (newValue != null) {
			sourceValue.setText(newValue);
		} else {
			sourceValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Source.sourceValue);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getTargetValue()
	 * 
	 */
	public String getTargetValue() {
		return targetValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setTargetValue(String newValue)
	 * 
	 */
	public void setTargetValue(String newValue) {
		if (newValue != null) {
			targetValue.setText(newValue);
		} else {
			targetValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Target.targetValue);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getTargetAction()
	 * 
	 */
	public Enumerator getTargetAction() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetAction.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initTargetAction(Object input, Enumerator current)
	 */
	public void initTargetAction(Object input, Enumerator current) {
		targetAction.setInput(input);
		targetAction.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Target.targetAction);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setTargetAction(Enumerator newValue)
	 * 
	 */
	public void setTargetAction(Enumerator newValue) {
		targetAction.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.Target.targetAction);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetType()
	 * 
	 */
	public Enumerator getRuleSetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleSetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSetType(Object input, Enumerator current)
	 */
	public void initRuleSetType(Object input, Enumerator current) {
		ruleSetType.setInput(input);
		ruleSetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetType(Enumerator newValue)
	 * 
	 */
	public void setRuleSetType(Enumerator newValue) {
		ruleSetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetURL()
	 * 
	 */
	public String getRuleSetURL() {
		return ruleSetURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetURL(String newValue)
	 * 
	 */
	public void setRuleSetURL(String newValue) {
		if (newValue != null) {
			ruleSetURL.setText(newValue);
		} else {
			ruleSetURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetSourceType()
	 * 
	 */
	public Enumerator getRuleSetSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) ruleSetSourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSetSourceType(Object input, Enumerator current)
	 */
	public void initRuleSetSourceType(Object input, Enumerator current) {
		ruleSetSourceType.setInput(input);
		ruleSetSourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetSourceType(Enumerator newValue)
	 * 
	 */
	public void setRuleSetSourceType(Enumerator newValue) {
		ruleSetSourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#getRuleSetSourceCode()
	 * 
	 */
	public String getRuleSetSourceCode() {
		return ruleSetSourceCode.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetSourceCode(String newValue)
	 * 
	 */
	public void setRuleSetSourceCode(String newValue) {
		if (newValue != null) {
			ruleSetSourceCode.setText(newValue);
		} else {
			ruleSetSourceCode.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		if (eefElementEditorReadOnlyState && ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(false);
			ruleSetSourceCode.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(true);
		}	
		
	}






	// Start of user code for sourceXPath specific getters and setters implementation
	
	// End of user code

	// Start of user code for targetXPath specific getters and setters implementation
	
	// End of user code

	// Start of user code for targetResultXPath specific getters and setters implementation
	
	// End of user code

	// Start of user code for ruleSetSourceKey specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.RuleMediator_Part_Title;
	}

	@Override
	public NamespacedProperty getSourceXPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
		// TODO Auto-generated method stub

	}

	@Override
	public NamespacedProperty getTargetXPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTargetXPath(NamespacedProperty nameSpacedProperty) {
		// TODO Auto-generated method stub

	}

	@Override
	public NamespacedProperty getTargetResultXPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTargetResultXPath(NamespacedProperty nameSpacedProperty) {
		// TODO Auto-generated method stub

	}

	@Override
	public RegistryKeyProperty getRuleSetSourceKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRuleSetSourceKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub

	}

	// Start of user code additional methods
	
	// End of user code


}
