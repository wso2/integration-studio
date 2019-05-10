/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class RuleMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RuleMediatorPropertiesEditionPart {

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
    protected NamespacedProperty sourceXPath;
    protected Text sourceXPathText;
	// End of user code

	protected Text targetValue;
	protected EMFComboViewer targetAction;
	// Start of user code  for targetXPath widgets declarations
    protected NamespacedProperty targetXPath;
    protected Text targetXPathText;
	// End of user code

	// Start of user code  for targetResultXPath widgets declarations
    protected NamespacedProperty targetResultXPath;
    protected Text targetResultXPathText;
	// End of user code

	protected EMFComboViewer ruleSetType;
	protected Text ruleSetURL;
	protected EMFComboViewer ruleSetSourceType;
	protected Text ruleSetSourceCode;
	// Start of user code  for ruleSetSourceKey widgets declarations
    protected RegistryKeyProperty ruleSetSourceKey;
    protected Text ruleSetSourceKeyText;
    protected Control[] sourceXPathElements;
    protected Control[] targetXPathElements;
    protected Control[] targetResultXPathElements;
    protected Control[] ruleSetSourceKeyElements;
    protected Control[] descriptionElements;
    protected Control[] statefulSessionElements;
    protected Control[] ruleSessionPropertiesElements;
    protected Control[] inputWrapperNameElements;
    protected Control[] inputNameSpaceElements;
    protected Control[] ruleFactsElements;
    protected Control[] outputWrapperNameElements;
    protected Control[] outputnamespaceElements;
    protected Control[] ruleResultsConfigurationElements;
    protected Control[] sourceValueElements;
    protected Control[] targetValueElements;
    protected Control[] targetActionElements;
    protected Control[] ruleSetTypeElements;
    protected Control[] ruleSetURLElements;
    protected Control[] ruleSetSourceTypeElements;
    protected Control[] ruleSetSourceCodeElements;
    protected Composite miscGroup;
    protected Composite inputFactsGroup;
    protected Composite outputFactsGroup;
    protected Composite sourceGroup;
    protected Composite targetGroup;
    protected Composite ruleSetGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public RuleMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RuleMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ruleMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
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
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		ruleSetStep.addStep(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey);
		
		CompositionStep inputFactsStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.class);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace);
		inputFactsStep.addStep(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration);
		
		CompositionStep outputFactsStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.class);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace);
		outputFactsStep.addStep(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration);

		CompositionStep miscStep = ruleMediatorStep.addStep(EsbViewsRepository.RuleMediator.Misc.class);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.description);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.commentsList);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.reverse);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.statefulSession);
		miscStep.addStep(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties);

		composer = new PartComposer(ruleMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.RuleMediator.Misc.class) {
					return createMiscGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.statefulSession) {
					return createStatefulSessionCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties) {
					return createRuleSessionPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.class) {
					return createInputFactsGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName) {
					return createInputWrapperNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace) {
					return createInputNameSpaceText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration) {
					return createRuleFactsConfigurationTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.class) {
					return createOutputFactsGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName) {
					return createOutputWrapperNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace) {
					return createOutputNameSpaceText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration) {
					return createRuleResultsConfigurationTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Source.class) {
					return createSourceGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Source.sourceValue) {
					return createSourceValueText(widgetFactory, parent);
				}
				// Start of user code for sourceXPath addToPart creation
                if (key == EsbViewsRepository.RuleMediator.Source.sourceXPath) {
                    return createsourceXPathWidget(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.RuleMediator.Target.class) {
					return createTargetGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Target.targetValue) {
					return createTargetValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.Target.targetAction) {
					return createTargetActionEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for targetXPath addToPart creation
                if (key == EsbViewsRepository.RuleMediator.Target.targetXPath) {
                    return createtargetXPathWidget(widgetFactory, parent);
                }
				// End of user code
				// Start of user code for targetResultXPath addToPart creation
                if (key == EsbViewsRepository.RuleMediator.Target.targetResultXPath) {
                    return createtargetResultXPathWidget(widgetFactory, parent);
                }
				// End of user code
				if (key == EsbViewsRepository.RuleMediator.RuleSet.class) {
					return createRuleSetGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetType) {
					return createRuleSetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL) {
					return createRuleSetURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType) {
					return createRuleSetSourceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode) {
					return createRuleSetSourceCodeText(widgetFactory, parent);
				}
				// Start of user code for ruleSetSourceKey addToPart creation
                if (key == EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceKey) {
                    return createRuleSetSourceKeyWidget(widgetFactory, parent);
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
	protected Composite createMiscGroup(FormToolkit widgetFactory, final Composite parent) {
		Section miscSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		miscSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_MiscGroupLabel);
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
	    Control [] previousControls = miscGroup.getChildren();
        createDescription(parent, EsbViewsRepository.RuleMediator.Misc.description, EsbMessages.RuleMediatorPropertiesEditionPart_DescriptionLabel);
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
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.Misc.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.Misc.description,
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
									RuleMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.RuleMediator.Misc.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		Control [] newControls = miscGroup.getChildren();
		descriptionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.RuleMediator.Misc.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RuleMediator.Misc.commentsList, EsbMessages.RuleMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

    /**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RuleMediator.Misc.reverse, EsbMessages.RuleMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.RuleMediator.Misc.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createStatefulSessionCheckbox(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = miscGroup.getChildren();
        statefulSession = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.RuleMediator.Misc.statefulSession, EsbMessages.RuleMediatorPropertiesEditionPart_StatefulSessionLabel), SWT.CHECK);
		statefulSession.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.statefulSession, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statefulSession.getSelection())));
			}

		});
		GridData statefulSessionData = new GridData(GridData.FILL_HORIZONTAL);
		statefulSessionData.horizontalSpan = 2;
		statefulSession.setLayoutData(statefulSessionData);
		EditingUtils.setID(statefulSession, EsbViewsRepository.RuleMediator.Misc.statefulSession);
		EditingUtils.setEEFtype(statefulSession, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.statefulSession, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatefulSessionCheckbox
		Control [] newControls = miscGroup.getChildren();
		statefulSessionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
     */
	protected Composite createRuleSessionPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = miscGroup.getChildren();
        this.ruleSessionProperties = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSessionPropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleSessionProperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleSessionProperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleSessionProperties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleSessionProperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleSessionPropertiesFilters) {
			this.ruleSessionProperties.addFilter(filter);
		}
		this.ruleSessionProperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, EsbViewsRepository.FORM_KIND));
		this.ruleSessionProperties.createControls(parent, widgetFactory);
		this.ruleSessionProperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Misc.ruleSessionProperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createRuleSessionPropertiesTableComposition
		Control [] newControls = miscGroup.getChildren();
		ruleSessionPropertiesElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
	    // End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createInputFactsGroup(FormToolkit widgetFactory, final Composite parent) {
		Section inputFactsSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		inputFactsSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_InputFactsGroupLabel);
		GridData inputFactsSectionData = new GridData(GridData.FILL_HORIZONTAL);
		inputFactsSectionData.horizontalSpan = 3;
		inputFactsSection.setLayoutData(inputFactsSectionData);
		inputFactsGroup = widgetFactory.createComposite(inputFactsSection);
		GridLayout inputFactsGroupLayout = new GridLayout();
		inputFactsGroupLayout.numColumns = 3;
		inputFactsGroup.setLayout(inputFactsGroupLayout);
		inputFactsSection.setClient(inputFactsGroup);
		return inputFactsGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createInputWrapperNameText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = inputFactsGroup.getChildren();
        createDescription(parent, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_InputWrapperNameLabel);
		inputWrapperName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		inputWrapperName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData inputWrapperNameData = new GridData(GridData.FILL_HORIZONTAL);
		inputWrapperName.setLayoutData(inputWrapperNameData);
		inputWrapperName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inputWrapperName.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inputWrapperName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputWrapperName.getText()));
				}
			}
		});
		EditingUtils.setID(inputWrapperName, EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName);
		EditingUtils.setEEFtype(inputWrapperName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.inputWrapperName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputWrapperNameText
		Control [] newControls = inputFactsGroup.getChildren();
		inputWrapperNameElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
	    // End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createInputNameSpaceText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = inputFactsGroup.getChildren();
        createDescription(parent, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_InputNameSpaceLabel);
		inputNameSpace = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		inputNameSpace.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData inputNameSpaceData = new GridData(GridData.FILL_HORIZONTAL);
		inputNameSpace.setLayoutData(inputNameSpaceData);
		inputNameSpace.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, inputNameSpace.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		inputNameSpace.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, inputNameSpace.getText()));
				}
			}
		});
		EditingUtils.setID(inputNameSpace, EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace);
		EditingUtils.setEEFtype(inputNameSpace, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.inputNameSpace, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInputNameSpaceText
		Control [] newControls = inputFactsGroup.getChildren();
		inputNameSpaceElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
	 */
	protected Composite createRuleFactsConfigurationTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = inputFactsGroup.getChildren();
        this.ruleFactsConfiguration = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, EsbMessages.RuleMediatorPropertiesEditionPart_RuleFactsConfigurationLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleFactsConfiguration.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleFactsConfiguration.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleFactsConfiguration.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleFactsConfiguration.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleFactsConfigurationFilters) {
			this.ruleFactsConfiguration.addFilter(filter);
		}
		this.ruleFactsConfiguration.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, EsbViewsRepository.FORM_KIND));
		this.ruleFactsConfiguration.createControls(parent, widgetFactory);
		this.ruleFactsConfiguration.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.InputFacts.ruleFactsConfiguration, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createRuleFactsConfigurationTableComposition
		Control [] newControls = inputFactsGroup.getChildren();
		ruleFactsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createOutputFactsGroup(FormToolkit widgetFactory, final Composite parent) {
		Section outputFactsSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		outputFactsSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_OutputFactsGroupLabel);
		GridData outputFactsSectionData = new GridData(GridData.FILL_HORIZONTAL);
		outputFactsSectionData.horizontalSpan = 3;
		outputFactsSection.setLayoutData(outputFactsSectionData);
		outputFactsGroup = widgetFactory.createComposite(outputFactsSection);
		GridLayout outputFactsGroupLayout = new GridLayout();
		outputFactsGroupLayout.numColumns = 3;
		outputFactsGroup.setLayout(outputFactsGroupLayout);
		outputFactsSection.setClient(outputFactsGroup);
		return outputFactsGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createOutputWrapperNameText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = outputFactsGroup.getChildren();
		createDescription(parent, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, EsbMessages.RuleMediatorPropertiesEditionPart_OutputWrapperNameLabel);
		outputWrapperName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outputWrapperName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outputWrapperNameData = new GridData(GridData.FILL_HORIZONTAL);
		outputWrapperName.setLayoutData(outputWrapperNameData);
		outputWrapperName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outputWrapperName.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outputWrapperName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputWrapperName.getText()));
				}
			}
		});
		EditingUtils.setID(outputWrapperName, EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName);
		EditingUtils.setEEFtype(outputWrapperName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.outputWrapperName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputWrapperNameText
		Control [] newControls = outputFactsGroup.getChildren();
		outputWrapperNameElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createOutputNameSpaceText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = outputFactsGroup.getChildren();
		createDescription(parent, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, EsbMessages.RuleMediatorPropertiesEditionPart_OutputNameSpaceLabel);
		outputNameSpace = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		outputNameSpace.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData outputNameSpaceData = new GridData(GridData.FILL_HORIZONTAL);
		outputNameSpace.setLayoutData(outputNameSpaceData);
		outputNameSpace.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, outputNameSpace.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		outputNameSpace.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, outputNameSpace.getText()));
				}
			}
		});
		EditingUtils.setID(outputNameSpace, EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace);
		EditingUtils.setEEFtype(outputNameSpace, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.outputNameSpace, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputNameSpaceText
		Control [] newControls = outputFactsGroup.getChildren();
		outputnamespaceElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * @generated NOT
	 */
	protected Composite createRuleResultsConfigurationTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = outputFactsGroup.getChildren();
		this.ruleResultsConfiguration = new ReferencesTable(getDescription(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, EsbMessages.RuleMediatorPropertiesEditionPart_RuleResultsConfigurationLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				ruleResultsConfiguration.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				ruleResultsConfiguration.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				ruleResultsConfiguration.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				ruleResultsConfiguration.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.ruleResultsConfigurationFilters) {
			this.ruleResultsConfiguration.addFilter(filter);
		}
		this.ruleResultsConfiguration.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, EsbViewsRepository.FORM_KIND));
		this.ruleResultsConfiguration.createControls(parent, widgetFactory);
		this.ruleResultsConfiguration.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.OutputFacts.ruleResultsConfiguration, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createRuleResultsConfigurationTableComposition
		Control [] newControls = outputFactsGroup.getChildren();
		ruleResultsConfigurationElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSourceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section sourceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		sourceSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_SourceGroupLabel);
		GridData sourceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		sourceSectionData.horizontalSpan = 3;
		sourceSection.setLayoutData(sourceSectionData);
		sourceGroup = widgetFactory.createComposite(sourceSection);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		sourceSection.setClient(sourceGroup);
		return sourceGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createSourceValueText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = sourceGroup.getChildren();
		createDescription(parent, EsbViewsRepository.RuleMediator.Source.sourceValue, EsbMessages.RuleMediatorPropertiesEditionPart_SourceValueLabel);
		sourceValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceValueData = new GridData(GridData.FILL_HORIZONTAL);
		sourceValue.setLayoutData(sourceValueData);
		sourceValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.Source.sourceValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.Source.sourceValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceValue.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Source.sourceValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceValue.getText()));
				}
			}
		});
		EditingUtils.setID(sourceValue, EsbViewsRepository.RuleMediator.Source.sourceValue);
		EditingUtils.setEEFtype(sourceValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Source.sourceValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceValueText
		Control [] newControls = sourceGroup.getChildren();
		sourceValueElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTargetGroup(FormToolkit widgetFactory, final Composite parent) {
		Section targetSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		targetSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_TargetGroupLabel);
		GridData targetSectionData = new GridData(GridData.FILL_HORIZONTAL);
		targetSectionData.horizontalSpan = 3;
		targetSection.setLayoutData(targetSectionData);
		targetGroup = widgetFactory.createComposite(targetSection);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		targetSection.setClient(targetGroup);
		return targetGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createTargetValueText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = targetGroup.getChildren();
		createDescription(parent, EsbViewsRepository.RuleMediator.Target.targetValue, EsbMessages.RuleMediatorPropertiesEditionPart_TargetValueLabel);
		targetValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetValueData = new GridData(GridData.FILL_HORIZONTAL);
		targetValue.setLayoutData(targetValueData);
		targetValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.Target.targetValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.Target.targetValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetValue.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Target.targetValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetValue.getText()));
				}
			}
		});
		EditingUtils.setID(targetValue, EsbViewsRepository.RuleMediator.Target.targetValue);
		EditingUtils.setEEFtype(targetValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Target.targetValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetValueText
        Control [] newControls = targetGroup.getChildren();
        targetValueElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createTargetActionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = targetGroup.getChildren();
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.Target.targetAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAction()));
			}

		});
		targetAction.setID(EsbViewsRepository.RuleMediator.Target.targetAction);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.Target.targetAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetActionEMFComboViewer
        Control [] newControls = targetGroup.getChildren();
        targetActionElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleSetGroup(FormToolkit widgetFactory, final Composite parent) {
		Section ruleSetSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		ruleSetSection.setText(EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetGroupLabel);
		GridData ruleSetSectionData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetSectionData.horizontalSpan = 3;
		ruleSetSection.setLayoutData(ruleSetSectionData);
		ruleSetGroup = widgetFactory.createComposite(ruleSetSection);
		GridLayout ruleSetGroupLayout = new GridLayout();
		ruleSetGroupLayout.numColumns = 3;
		ruleSetGroup.setLayout(ruleSetGroupLayout);
		ruleSetSection.setClient(ruleSetGroup);
		return ruleSetGroup;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleSetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = ruleSetGroup.getChildren();
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetType()));
			}

		});
		ruleSetType.setID(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetTypeEMFComboViewer
		Control [] newControls = ruleSetGroup.getChildren();
        ruleSetTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleSetURLText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = ruleSetGroup.getChildren();
        createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetURLLabel);
		ruleSetURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		ruleSetURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData ruleSetURLData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetURL.setLayoutData(ruleSetURLData);
		ruleSetURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, ruleSetURL.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		ruleSetURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetURL.getText()));
				}
			}
		});
		EditingUtils.setID(ruleSetURL, EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL);
		EditingUtils.setEEFtype(ruleSetURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetURLText
		Control [] newControls = ruleSetGroup.getChildren();
        ruleSetURLElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRuleSetSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = ruleSetGroup.getChildren();
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getRuleSetSourceType()));
			}

		});
		ruleSetSourceType.setID(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceTypeEMFComboViewer
		Control [] newControls = ruleSetGroup.getChildren();
		ruleSetSourceTypeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
        ruleSetSourceType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createRuleSetSourceCodeText(FormToolkit widgetFactory, Composite parent) {
	    Control [] previousControls = ruleSetGroup.getChildren();
        createDescription(parent, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, EsbMessages.RuleMediatorPropertiesEditionPart_RuleSetSourceCodeLabel);
		ruleSetSourceCode = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		ruleSetSourceCode.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData ruleSetSourceCodeData = new GridData(GridData.FILL_HORIZONTAL);
		ruleSetSourceCode.setLayoutData(ruleSetSourceCodeData);
		ruleSetSourceCode.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RuleMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RuleMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, ruleSetSourceCode.getText()));
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
									RuleMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		ruleSetSourceCode.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ruleSetSourceCode.getText()));
				}
			}
		});
		EditingUtils.setID(ruleSetSourceCode, EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		EditingUtils.setEEFtype(ruleSetSourceCode, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRuleSetSourceCodeText
		Control [] newControls = ruleSetGroup.getChildren();
        ruleSetSourceCodeElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleSessionProperties(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleFactsConfiguration(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleFactsConfiguration()
	 * 
	 */
	public void updateRuleFactsConfiguration() {
	ruleFactsConfiguration.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleFactsConfiguration(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleFactsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleFactsConfiguration(ViewerFilter filter) {
		ruleFactsConfigurationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleFactsConfigurationTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleFactsConfigurationTable(EObject element) {
		return ((ReferencesTableSettings)ruleFactsConfiguration.getInput()).contains(element);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#initRuleResultsConfiguration(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#updateRuleResultsConfiguration()
	 * 
	 */
	public void updateRuleResultsConfiguration() {
	ruleResultsConfiguration.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addFilterRuleResultsConfiguration(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#addBusinessFilterRuleResultsConfiguration(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRuleResultsConfiguration(ViewerFilter filter) {
		ruleResultsConfigurationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#isContainedInRuleResultsConfigurationTable(EObject element)
	 * 
	 */
	public boolean isContainedInRuleResultsConfigurationTable(EObject element) {
		return ((ReferencesTableSettings)ruleResultsConfiguration.getInput()).contains(element);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setTargetAction(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetType(Enumerator newValue)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.RuleMediatorPropertiesEditionPart#setRuleSetSourceType(Enumerator newValue)
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
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.RuleMediator.RuleSet.ruleSetSourceCode);
		if (eefElementEditorReadOnlyState && ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(false);
			ruleSetSourceCode.setToolTipText(EsbMessages.RuleMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ruleSetSourceCode.isEnabled()) {
			ruleSetSourceCode.setEnabled(true);
		}	
		
	}






	// Start of user code for sourceXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return sourceXPath;
    }

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            sourceXPathText.setText(nameSpacedProperty.getPropertyValue());
            sourceXPath = nameSpacedProperty;
        }

    }
	// End of user code

	// Start of user code for targetXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getTargetXPath() {
         return targetXPath;
    }

    @Override
    public void setTargetXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            targetXPathText.setText(nameSpacedProperty.getPropertyValue());
            targetXPath = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for targetResultXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getTargetResultXPath() {
        return targetResultXPath;
    }

    @Override
    public void setTargetResultXPath(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            targetResultXPathText.setText(nameSpacedProperty.getPropertyValue());
            targetResultXPath = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for ruleSetSourceKey specific getters and setters implementation

    @Override
    public RegistryKeyProperty getRuleSetSourceKey() {
        return ruleSetSourceKey;
    }

    @Override
    public void setRuleSetSourceKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            ruleSetSourceKeyText.setText(registryKeyProperty.getKeyValue());
            ruleSetSourceKey = registryKeyProperty;
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
		return EsbMessages.RuleMediator_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createsourceXPathWidget(FormToolkit widgetFactory, final Composite parent) {
	    Control sourceXPathLabel = createDescription(parent, EsbViewsRepository.RuleMediator.Source.sourceXPath,
                EsbMessages.RuleMediatorPropertiesEditionPart_SourceXPathLabel);
        widgetFactory.paintBordersFor(parent);
        if (sourceXPath == null) {
            sourceXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = sourceXPath.getPropertyValue().isEmpty() ? "/default/expression"
                : sourceXPath.getPropertyValue();
        sourceXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        sourceXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        sourceXPathText.setLayoutData(valueData);

        sourceXPathText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, sourceXPath);
                // valueExpression.setPropertyValue(valueExpressionText.getText());
                sourceXPath = nspd.open();
                sourceXPathText.setText(sourceXPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.RuleMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSourceXPath()));
            }
            
        });
        
        sourceXPathText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, sourceXPath);
                // valueExpression.setPropertyValue(valueExpressionText.getText());
                sourceXPath = nspd.open();
                sourceXPathText.setText(sourceXPath.getPropertyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.RuleMediator.Source.sourceXPath, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getSourceXPath()));
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(sourceXPathText, EsbViewsRepository.RuleMediator.Source.sourceXPath);
        EditingUtils.setEEFtype(sourceXPathText, "eef::Text");
        Control sourceXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.RuleMediator.Source.sourceXPath, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        sourceXPathElements = new Control[] { sourceXPathLabel, sourceXPathText, sourceXPathHelp };
        return parent;
    }
	
	 protected Composite createtargetXPathWidget(FormToolkit widgetFactory, final Composite parent) {
	        Control targetXPathLabel = createDescription(parent, EsbViewsRepository.RuleMediator.Target.targetXPath,
	                EsbMessages.EnrichMediatorPropertiesEditionPart_TargetXPathLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (targetXPath == null) {
	            targetXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
	        }
	        String initValueExpression = targetXPath.getPropertyValue().isEmpty() ? "/default/expression"
	                : targetXPath.getPropertyValue();
	        targetXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
	        targetXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        targetXPathText.setLayoutData(valueData);
	        
	        targetXPathText.addMouseListener(new MouseAdapter() {
	            
	            @Override
	            public void mouseDown( MouseEvent event ) {
	                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, targetXPath);
	                // valueExpression.setPropertyValue(valueExpressionText.getText());
	                targetXPath = nspd.open();
	                targetXPathText.setText(targetXPath.getPropertyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
	                                EsbViewsRepository.RuleMediator.Target.targetXPath, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getTargetXPath()));
	            }
	            
	        });
	        
	        targetXPathText.addKeyListener(new KeyListener() {
	                        
	            @Override
	            public void keyPressed(KeyEvent e) {
	                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
	                        SWT.NULL, targetXPath);
	                // valueExpression.setPropertyValue(valueExpressionText.getText());
	                targetXPath = nspd.open();
	                targetXPathText.setText(targetXPath.getPropertyValue());
	                propertiesEditionComponent
	                        .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
	                                EsbViewsRepository.RuleMediator.Target.targetXPath, PropertiesEditionEvent.COMMIT,
	                                PropertiesEditionEvent.SET, null, getTargetXPath()));
	            }
	            
	            @Override
	            public void keyReleased(KeyEvent e) {}
	            
	        });
	        
	        EditingUtils.setID(targetXPathText, EsbViewsRepository.RuleMediator.Target.targetXPath);
	        EditingUtils.setEEFtype(targetXPathText, "eef::Text");
	        Control targetXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
	                .getHelpContent(EsbViewsRepository.RuleMediator.Target.targetXPath, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        targetXPathElements = new Control[] { targetXPathLabel, targetXPathText, targetXPathHelp };
	        return parent;
	    }
	 
	 protected Composite createtargetResultXPathWidget(FormToolkit widgetFactory, final Composite parent) {
         Control targetResultXPathLabel = createDescription(parent, EsbViewsRepository.RuleMediator.Target.targetResultXPath,
                 EsbMessages.RuleMediatorPropertiesEditionPart_TargetResultXPathLabel);
         widgetFactory.paintBordersFor(parent);
         if (targetResultXPath == null) {
             targetResultXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
         }
         String initValueExpression = targetResultXPath.getPropertyValue().isEmpty() ? "/default/expression"
                 : targetResultXPath.getPropertyValue();
         targetResultXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
         targetResultXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
         widgetFactory.paintBordersFor(parent);
         GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
         targetResultXPathText.setLayoutData(valueData);
         
         targetResultXPathText.addMouseListener(new MouseAdapter() {
             
             @Override
             public void mouseDown( MouseEvent event ) {
                 EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                         SWT.NULL, targetResultXPath);
                 // valueExpression.setPropertyValue(valueExpressionText.getText());
                 targetResultXPath = nspd.open();
                 targetResultXPathText.setText(targetResultXPath.getPropertyValue());
                 propertiesEditionComponent
                         .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
                                 EsbViewsRepository.RuleMediator.Target.targetResultXPath, PropertiesEditionEvent.COMMIT,
                                 PropertiesEditionEvent.SET, null, getTargetResultXPath()));
             }
             
         });
         
         targetResultXPathText.addKeyListener(new KeyListener() {
                         
             @Override
             public void keyPressed(KeyEvent e) {
                 EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                         SWT.NULL, targetResultXPath);
                 // valueExpression.setPropertyValue(valueExpressionText.getText());
                 targetResultXPath = nspd.open();
                 targetResultXPathText.setText(targetResultXPath.getPropertyValue());
                 propertiesEditionComponent
                         .firePropertiesChanged(new PropertiesEditionEvent(RuleMediatorPropertiesEditionPartForm.this,
                                 EsbViewsRepository.RuleMediator.Target.targetResultXPath, PropertiesEditionEvent.COMMIT,
                                 PropertiesEditionEvent.SET, null, getTargetResultXPath()));
             }
             
             @Override
             public void keyReleased(KeyEvent e) {}
             
         });
         
         EditingUtils.setID(targetResultXPathText, EsbViewsRepository.RuleMediator.Target.targetResultXPath);
         EditingUtils.setEEFtype(targetResultXPathText, "eef::Text");
         Control targetResultXPathHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                 .getHelpContent(EsbViewsRepository.RuleMediator.Target.targetResultXPath, EsbViewsRepository.FORM_KIND),
                 null); // $NON-NLS-1$
         targetResultXPathElements = new Control[] { targetResultXPathLabel, targetResultXPathText, targetResultXPathHelp };
         return parent;
     }
	 
	 protected Composite createRuleSetSourceKeyWidget(FormToolkit widgetFactory, Composite parent) {
	        Control ruleSetSourceKeyLabel = createDescription(parent,
	                EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey,
	                EsbMessages.EnrichMediatorPropertiesEditionPart_InlineRegistryKeyLabel);
	        widgetFactory.paintBordersFor(parent);
	        if (ruleSetSourceKey == null) {
	            ruleSetSourceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initValueExpression = ruleSetSourceKey.getKeyValue().isEmpty() ? "" : ruleSetSourceKey.getKeyValue();
	        ruleSetSourceKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
	        ruleSetSourceKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        ruleSetSourceKeyText.setLayoutData(valueData);
	        ruleSetSourceKeyText.addFocusListener(new FocusAdapter() {
	            /**
	             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
	             * 
	             */
	            @Override
	            @SuppressWarnings("synthetic-access")
	            public void focusLost(FocusEvent e) {
	            }

	            /**
	             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
	             */
	            @Override
	            public void focusGained(FocusEvent e) {
	                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
	                        SWT.NULL, ruleSetSourceKey, new ArrayList<NamedEntityDescriptor>());
	                dialog.open();
	                ruleSetSourceKeyText.setText(ruleSetSourceKey.getKeyValue());
	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
	                        RuleMediatorPropertiesEditionPartForm.this,
	                        EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey, PropertiesEditionEvent.COMMIT,
	                        PropertiesEditionEvent.SET, null, getRuleSetSourceKey()));
	            }
	        });
	        EditingUtils.setID(ruleSetSourceKeyText, EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey);
	        EditingUtils.setEEFtype(ruleSetSourceKeyText, "eef::Text");
	        Control inlineRegistryKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
	                propertiesEditionComponent.getHelpContent(EsbViewsRepository.EnrichMediator.Source.inlineRegistryKey,
	                        EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        ruleSetSourceKeyElements = new Control[] { ruleSetSourceKeyLabel, ruleSetSourceKeyText, inlineRegistryKeyHelp };
	        return parent;
	    }
	 
	    @Override
	    public void refresh() {
	        super.refresh();
	        validate();
	    }

	    public void validate() {
	        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
	        epv.clearElements(new Composite[] {miscGroup,inputFactsGroup,outputFactsGroup,sourceGroup,targetGroup,ruleSetGroup});
	        epv.showEntry(ruleSetSourceTypeElements, false);
	        if (getRuleSetSourceType() == RuleSourceType.REGISTRY) {
	            epv.showEntry(ruleSetSourceKeyElements, false);
	        } else if (getRuleSetSourceType() == RuleSourceType.URL) {
	            epv.showEntry(ruleSetURLElements, false);
	        } else {
	            epv.showEntry(ruleSetSourceCodeElements, false);
	        }
	        epv.showEntry(ruleFactsElements, false);
	        epv.showEntry(ruleResultsConfigurationElements, false);
	        epv.showEntry(sourceValueElements, false);
	        epv.showEntry(sourceXPathElements, false);
	        epv.showEntry(targetValueElements, false);
	        epv.showEntry(targetResultXPathElements, false);
	        epv.showEntry(targetXPathElements, false);
	        epv.showEntry(targetActionElements, false);
	        epv.showEntry(inputWrapperNameElements, false);
	        epv.showEntry(inputNameSpaceElements, false);
	        epv.showEntry(outputWrapperNameElements, false);
	        epv.showEntry(outputnamespaceElements, false);
	        epv.showEntry(ruleSetTypeElements, false);
	        epv.showEntry(descriptionElements, false);
	        view.layout(true, true);
	    }
	
	// End of user code


}
