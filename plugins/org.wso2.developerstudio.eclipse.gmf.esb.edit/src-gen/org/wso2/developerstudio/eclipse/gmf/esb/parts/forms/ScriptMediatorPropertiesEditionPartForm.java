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
import org.eclipse.swt.custom.StyledText;
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
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.SyntaxHighlightTextBox;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart;
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
public class ScriptMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ScriptMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer scriptType;
	protected EMFComboViewer scriptLanguage;
	protected Text mediateFunction;
	protected StyledText scriptBody;
	protected EMFComboViewer keyType;
	protected ReferencesTable scriptKeys;
	protected List<ViewerFilter> scriptKeysBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> scriptKeysFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for Script Static Key widgets declarations
	protected RegistryKeyProperty scriptStaticKey;
    protected Text scriptStaticKeyText;
	// End of user code

	// Start of user code  for Script Dynamic Key widgets declarations
    protected NamespacedProperty scriptDynamicKey;
    protected Text scriptDynamicKeyText;
    
    protected Control[] scriptLanguageElements;
    protected Control[] scriptTypeElements;
    protected Control[] staticReferenceKeyElements;
    protected Control[] scriptBodyElements;
    protected Control[] descriptionElements;
    protected Control[] keyTypeElements;
    protected Control[] scriptStaticKeyElements;
    protected Control[] mediateFuctionElements;
    protected Control[] scriptKeysElements;
    protected Control[] scriptDynamicKeyElements;
    
    protected GridData scriptKeysData;
    
    protected Composite propertiesGroup;
    
    protected Composite filterScriptTypeSubPropertiesGroup;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ScriptMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ScriptMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence scriptMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = scriptMediatorStep.addStep(EsbViewsRepository.ScriptMediator.Properties.class);
		// Start of user code 
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.mediateFunction);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptBody);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.keyType);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptKeys);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.description);
		// End of user code
		
		composer = new PartComposer(scriptMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code for components addToPart creation
				if (key == EsbViewsRepository.ScriptMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptType) {
					return createScriptTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptLanguage) {
					return createScriptLanguageEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.mediateFunction) {
					return createMediateFunctionText(widgetFactory, filterScriptTypeSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptBody) {
					return createScriptBodyText(widgetFactory, filterScriptTypeSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.keyType) {
					return createKeyTypeEMFComboViewer(widgetFactory, filterScriptTypeSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptKeys) {
					return createScriptKeysTableComposition(widgetFactory, filterScriptTypeSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey) {
					return createScriptStaticKey(widgetFactory, filterScriptTypeSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey) {
					return createScriptDynamicKey(widgetFactory, filterScriptTypeSubPropertiesGroup);
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
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.ScriptMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.description, EsbMessages.ScriptMediatorPropertiesEditionPart_DescriptionLabel);
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
							ScriptMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ScriptMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ScriptMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ScriptMediator.Properties.description,
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
									ScriptMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.ScriptMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] { descriptionLabel, description, descriptionHelp };
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
		EditingUtils.setID(commentsList, EsbViewsRepository.ScriptMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ScriptMediator.Properties.commentsList, EsbMessages.ScriptMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "ScriptMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.ScriptMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.ScriptMediator.Properties.reverse, EsbMessages.ScriptMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ScriptMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createScriptTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterScriptTypeSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Script Type", true);
		Control scriptTypeLabel = createDescription(filterScriptTypeSubPropertiesGroup, EsbViewsRepository.ScriptMediator.Properties.scriptType, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptTypeLabel);
		scriptType = new EMFComboViewer(filterScriptTypeSubPropertiesGroup);
		scriptType.setContentProvider(new ArrayContentProvider());
		scriptType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData scriptTypeData = new GridData(GridData.FILL_HORIZONTAL);
		scriptType.getCombo().setLayoutData(scriptTypeData);
                scriptType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		scriptType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptType()));
			}

		});
		scriptType.setID(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		Control scriptTypeHelp = FormUtils.createHelpButton(widgetFactory, filterScriptTypeSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptTypeEMFComboViewer
		scriptTypeElements = new Control[] { scriptTypeLabel, scriptType.getCombo(), scriptTypeHelp };
		scriptType.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
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
	protected Composite createScriptLanguageEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control scriptLanguageLabel = createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptLanguageLabel);
		scriptLanguage = new EMFComboViewer(parent);
		scriptLanguage.setContentProvider(new ArrayContentProvider());
		scriptLanguage.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData scriptLanguageData = new GridData(GridData.FILL_HORIZONTAL);
		scriptLanguage.getCombo().setLayoutData(scriptLanguageData);
                scriptLanguage.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		scriptLanguage.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptLanguage()));
			}

		});
		scriptLanguage.setID(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		Control scriptLanguageHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptLanguageEMFComboViewer
		scriptLanguageElements = new Control[] { scriptLanguageLabel, scriptLanguage.getCombo(), scriptLanguageHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createMediateFunctionText(FormToolkit widgetFactory, Composite parent) {
		Control mediateFunctionLabel = createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.mediateFunction, EsbMessages.ScriptMediatorPropertiesEditionPart_MediateFunctionLabel);
		mediateFunction = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		mediateFunction.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData mediateFunctionData = new GridData(GridData.FILL_HORIZONTAL);
		mediateFunction.setLayoutData(mediateFunctionData);
		mediateFunction.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ScriptMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ScriptMediator.Properties.mediateFunction,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, mediateFunction.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ScriptMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ScriptMediator.Properties.mediateFunction,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, mediateFunction.getText()));
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
									ScriptMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		mediateFunction.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.mediateFunction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, mediateFunction.getText()));
				}
			}
		});
		EditingUtils.setID(mediateFunction, EsbViewsRepository.ScriptMediator.Properties.mediateFunction);
		EditingUtils.setEEFtype(mediateFunction, "eef::Text"); //$NON-NLS-1$
		Control mediateFunctionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.mediateFunction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMediateFunctionText
		mediateFuctionElements = new Control[] { mediateFunctionLabel, mediateFunction, mediateFunctionHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createScriptBodyText(FormToolkit widgetFactory, Composite parent) {
		Control scriptBodyLabel = createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.scriptBody, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptBodyLabel);
		SyntaxHighlightTextBox syntaxStyler = new SyntaxHighlightTextBox();
		scriptBody = syntaxStyler.getStyledTextBox(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		scriptBody.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData scriptBodyData = new GridData(GridData.FILL_HORIZONTAL);
		scriptBodyData.heightHint = scriptBody.getLineHeight()*4;
		scriptBody.setLayoutData(scriptBodyData);
		scriptBody.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ScriptMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ScriptMediator.Properties.scriptBody,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scriptBody.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ScriptMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.ScriptMediator.Properties.scriptBody,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, scriptBody.getText()));
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
									ScriptMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		
		scriptBody.addKeyListener(new KeyListener() {
            
			@Override
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					if (propertiesEditionComponent != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
								ScriptMediatorPropertiesEditionPartForm.this, null,
								PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED, null, null));
					}
				}
			}
            
			@Override
			public void keyPressed(KeyEvent e) {
			}
            
		});

		EditingUtils.setID(scriptBody, EsbViewsRepository.ScriptMediator.Properties.scriptBody);
		EditingUtils.setEEFtype(scriptBody, "eef::Text"); //$NON-NLS-1$
		Control scriptBodyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptBody, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptBodyText
		scriptBodyElements = new Control[] { scriptBodyLabel, scriptBody, scriptBodyHelp };
		syntaxStyler.chooseSyntaxHighlighter(scriptBody.getText(), true);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createKeyTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control keyTypeLabel = createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.keyType, EsbMessages.ScriptMediatorPropertiesEditionPart_KeyTypeLabel);
		keyType = new EMFComboViewer(parent);
		keyType.setContentProvider(new ArrayContentProvider());
		keyType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData keyTypeData = new GridData(GridData.FILL_HORIZONTAL);
		keyType.getCombo().setLayoutData(keyTypeData);
                keyType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		keyType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.keyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getKeyType()));
			}

		});
		keyType.setID(EsbViewsRepository.ScriptMediator.Properties.keyType);
		Control keyTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.keyType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createKeyTypeEMFComboViewer
		keyTypeElements = new Control[] { keyTypeLabel, keyType.getCombo(), keyTypeHelp };
		keyType.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
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
	protected Composite createScriptKeysTableComposition(FormToolkit widgetFactory, Composite parent) {
		Control[] previousControls = parent.getChildren();
		this.scriptKeys = new ReferencesTable(getDescription(EsbViewsRepository.ScriptMediator.Properties.scriptKeys, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptKeysLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				scriptKeys.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				scriptKeys.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				scriptKeys.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				scriptKeys.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.scriptKeysFilters) {
			this.scriptKeys.addFilter(filter);
		}
		this.scriptKeys.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptKeys, EsbViewsRepository.FORM_KIND));
		this.scriptKeys.createControls(parent, widgetFactory);
		this.scriptKeys.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		scriptKeysData = new GridData(GridData.FILL_HORIZONTAL);
		scriptKeysData.horizontalSpan = 3;
		this.scriptKeys.setLayoutData(scriptKeysData);
		this.scriptKeys.setLowerBound(0);
		this.scriptKeys.setUpperBound(-1);
		scriptKeys.setID(EsbViewsRepository.ScriptMediator.Properties.scriptKeys);
		scriptKeys.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createScriptKeysTableComposition
		Control[] newControls = parent.getChildren();
		scriptKeysElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptType()
	 * 
	 */
	public Enumerator getScriptType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scriptType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptType(Object input, Enumerator current)
	 */
	public void initScriptType(Object input, Enumerator current) {
		scriptType.setInput(input);
		scriptType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		if (eefElementEditorReadOnlyState && scriptType.isEnabled()) {
			scriptType.setEnabled(false);
			scriptType.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptType.isEnabled()) {
			scriptType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptType(Enumerator newValue)
	 * 
	 */
	public void setScriptType(Enumerator newValue) {
		scriptType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		if (eefElementEditorReadOnlyState && scriptType.isEnabled()) {
			scriptType.setEnabled(false);
			scriptType.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptType.isEnabled()) {
			scriptType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptLanguage()
	 * 
	 */
	public Enumerator getScriptLanguage() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scriptLanguage.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptLanguage(Object input, Enumerator current)
	 */
	public void initScriptLanguage(Object input, Enumerator current) {
		scriptLanguage.setInput(input);
		scriptLanguage.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		if (eefElementEditorReadOnlyState && scriptLanguage.isEnabled()) {
			scriptLanguage.setEnabled(false);
			scriptLanguage.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptLanguage.isEnabled()) {
			scriptLanguage.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptLanguage(Enumerator newValue)
	 * 
	 */
	public void setScriptLanguage(Enumerator newValue) {
		scriptLanguage.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		if (eefElementEditorReadOnlyState && scriptLanguage.isEnabled()) {
			scriptLanguage.setEnabled(false);
			scriptLanguage.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptLanguage.isEnabled()) {
			scriptLanguage.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getMediateFunction()
	 * 
	 */
	public String getMediateFunction() {
		return mediateFunction.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setMediateFunction(String newValue)
	 * 
	 */
	public void setMediateFunction(String newValue) {
		if (newValue != null) {
			mediateFunction.setText(newValue);
		} else {
			mediateFunction.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.mediateFunction);
		if (eefElementEditorReadOnlyState && mediateFunction.isEnabled()) {
			mediateFunction.setEnabled(false);
			mediateFunction.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediateFunction.isEnabled()) {
			mediateFunction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptBody()
	 * 
	 */
	public String getScriptBody() {
		return scriptBody.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptBody(String newValue)
	 * 
	 */
	public void setScriptBody(String newValue) {
		if (newValue != null) {
			scriptBody.setText(newValue);
		} else {
			scriptBody.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptBody);
		if (eefElementEditorReadOnlyState && scriptBody.isEnabled()) {
			scriptBody.setEnabled(false);
			scriptBody.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptBody.isEnabled()) {
			scriptBody.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getKeyType()
	 * 
	 */
	public Enumerator getKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) keyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initKeyType(Object input, Enumerator current)
	 */
	public void initKeyType(Object input, Enumerator current) {
		keyType.setInput(input);
		keyType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.keyType);
		if (eefElementEditorReadOnlyState && keyType.isEnabled()) {
			keyType.setEnabled(false);
			keyType.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keyType.isEnabled()) {
			keyType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setKeyType(Enumerator newValue)
	 * 
	 */
	public void setKeyType(Enumerator newValue) {
		keyType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.keyType);
		if (eefElementEditorReadOnlyState && keyType.isEnabled()) {
			keyType.setEnabled(false);
			keyType.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !keyType.isEnabled()) {
			keyType.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptKeys(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initScriptKeys(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		scriptKeys.setContentProvider(contentProvider);
		scriptKeys.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ScriptMediator.Properties.scriptKeys);
		if (eefElementEditorReadOnlyState && scriptKeys.isEnabled()) {
			scriptKeys.setEnabled(false);
			scriptKeys.setToolTipText(EsbMessages.ScriptMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scriptKeys.isEnabled()) {
			scriptKeys.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#updateScriptKeys()
	 * 
	 */
	public void updateScriptKeys() {
	scriptKeys.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#addFilterScriptKeys(ViewerFilter filter)
	 * 
	 */
	public void addFilterToScriptKeys(ViewerFilter filter) {
		scriptKeysFilters.add(filter);
		if (this.scriptKeys != null) {
			this.scriptKeys.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#addBusinessFilterScriptKeys(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToScriptKeys(ViewerFilter filter) {
		scriptKeysBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#isContainedInScriptKeysTable(EObject element)
	 * 
	 */
	public boolean isContainedInScriptKeysTable(EObject element) {
		return ((ReferencesTableSettings)scriptKeys.getInput()).contains(element);
	}






	// Start of user code for Script Static Key specific getters and setters implementation
    @Override
    public RegistryKeyProperty getScriptStaticKey() {
        return scriptStaticKey;
    }

    @Override
    public void setScriptStaticKey(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
        	scriptStaticKeyText.setText(registryKeyProperty.getKeyValue());
        	scriptStaticKey = registryKeyProperty;
        }
    }
	// End of user code

	// Start of user code for Script Dynamic Key specific getters and setters implementation
    @Override
    public NamespacedProperty getScriptDynamicKey() {
        return scriptDynamicKey;
    }

    @Override
    public void setScriptDynamicKey(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
        	scriptDynamicKeyText.setText(nameSpacedProperty.getPropertyValue());
        	scriptDynamicKey = nameSpacedProperty;
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
		return EsbMessages.ScriptMediator_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createScriptStaticKey(FormToolkit widgetFactory, Composite parent) {
		Control scriptStaticKeyLabel = createDescription(parent,
				EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey,
				EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptStaticKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (scriptStaticKey == null) {
			scriptStaticKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = scriptStaticKey.getKeyValue().isEmpty() ? "" : scriptStaticKey.getKeyValue();
		scriptStaticKeyText = widgetFactory.createText(parent, initValueExpression);
		scriptStaticKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		scriptStaticKeyText.setLayoutData(valueData);
		scriptStaticKeyText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
						SWT.NULL, scriptStaticKey, new ArrayList<NamedEntityDescriptor>());
				dialog.open();
				scriptStaticKeyText.setText(scriptStaticKey.getKeyValue());
				propertiesEditionComponent
						.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartForm.this,
								EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptStaticKey()));
			}

		});

		scriptStaticKeyText.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
					EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
							SWT.NULL, scriptStaticKey, new ArrayList<NamedEntityDescriptor>());
					dialog.open();
					scriptStaticKeyText.setText(scriptStaticKey.getKeyValue());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ScriptMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey, PropertiesEditionEvent.COMMIT,
							PropertiesEditionEvent.SET, null, getScriptStaticKey()));
				}
			}

		});
        
		EditingUtils.setID(scriptStaticKeyText, EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey);
		EditingUtils.setEEFtype(scriptStaticKeyText, "eef::Text");
		Control scriptStaticKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey,
						EsbViewsRepository.FORM_KIND),null); // $NON-NLS-1$
		scriptStaticKeyElements = new Control[] { scriptStaticKeyLabel, scriptStaticKeyText, scriptStaticKeyHelp };
		return parent;
	}
	
	protected Composite createScriptDynamicKey(FormToolkit widgetFactory, final Composite parent) {
		Control scriptDynamicKeyLabel = createDescription(parent,
				EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey,
				EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptDynamicKeyLabel);
		widgetFactory.paintBordersFor(parent);
		if (scriptDynamicKey == null) {
			scriptDynamicKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		}
		String initValueExpression = scriptDynamicKey.getPropertyValue().isEmpty() ? "/default/expression"
				: scriptDynamicKey.getPropertyValue();
		scriptDynamicKeyText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		scriptDynamicKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		scriptDynamicKeyText.setLayoutData(valueData);

		scriptDynamicKeyText.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseDown( MouseEvent event ) {
                openScriptDynamicKeyNamespacedPropertyEditor(parent);
            }
            
        });
        
		scriptDynamicKeyText.addKeyListener(new KeyListener() {
                        
            @Override
            public void keyPressed(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    openScriptDynamicKeyNamespacedPropertyEditor(parent);
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
		
		EditingUtils.setID(scriptDynamicKeyText,
				EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey);
		EditingUtils.setEEFtype(scriptDynamicKeyText, "eef::Text");
		Control scriptDynamicKeyHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		scriptDynamicKeyElements = new Control[] { scriptDynamicKeyLabel, scriptDynamicKeyText, scriptDynamicKeyHelp };
		return parent;
	}
	
    private void openScriptDynamicKeyNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                SWT.NULL, scriptDynamicKey);
        scriptDynamicKey = nspd.open();
        scriptDynamicKeyText.setText(scriptDynamicKey.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                ScriptMediatorPropertiesEditionPartForm.this,
                EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptDynamicKey()));
    }
	
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }

	EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);
	
	public void validate() {
		viewUtil.clearElements(new Composite[] { propertiesGroup });
		viewUtil.showEntry(new Control[] {filterScriptTypeSubPropertiesGroup.getParent()}, false);
		viewUtil.clearElements(new Composite[] { filterScriptTypeSubPropertiesGroup });

		viewUtil.showEntry(scriptLanguageElements, false);
		viewUtil.showEntry(scriptTypeElements, false);

		if (getScriptType().getName().equals("INLINE")) {
			viewUtil.showEntry(scriptBodyElements, false);
		} else if (getScriptType().getName().equals("REGISTRY_REFERENCE")) {
			viewUtil.showEntry(keyTypeElements, false);
			if (getKeyType().getName().equals("STATIC_KEY")) {
				viewUtil.showEntry(scriptStaticKeyElements, false);
			} else if (getKeyType().getName().equals("DYNAMIC_kEY")) {
				viewUtil.showEntry(scriptDynamicKeyElements, false);
			}
			viewUtil.showEntry(mediateFuctionElements, false);
			viewUtil.showEntry(scriptKeysElements, false);
		}
		viewUtil.showEntry(descriptionElements, false);

		view.layout(true, true);
	}
	// End of user code


}
