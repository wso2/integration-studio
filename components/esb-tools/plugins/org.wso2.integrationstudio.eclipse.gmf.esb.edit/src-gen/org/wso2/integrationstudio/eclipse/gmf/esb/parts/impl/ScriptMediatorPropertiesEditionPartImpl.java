/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ScriptMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ScriptMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer scriptType;
	protected EMFComboViewer scriptLanguage;
	protected Text mediateFunction;
	protected Text scriptBody;
	protected EMFComboViewer keyType;
	protected ReferencesTable scriptKeys;
	protected List<ViewerFilter> scriptKeysBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> scriptKeysFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for Script Static Key widgets declarations
	
	// End of user code

	// Start of user code  for Script Dynamic Key widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ScriptMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence scriptMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = scriptMediatorStep.addStep(EsbViewsRepository.ScriptMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.mediateFunction);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptBody);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.keyType);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptKeys);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey);
		propertiesStep.addStep(EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey);
		
		
		composer = new PartComposer(scriptMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ScriptMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptType) {
					return createScriptTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptLanguage) {
					return createScriptLanguageEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.mediateFunction) {
					return createMediateFunctionText(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptBody) {
					return createScriptBodyText(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.keyType) {
					return createKeyTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.ScriptMediator.Properties.scriptKeys) {
					return createScriptKeysAdvancedTableComposition(parent);
				}
				// Start of user code for Script Static Key addToPart creation
				
				// End of user code
				// Start of user code for Script Dynamic Key addToPart creation
				
				// End of user code
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
		propertiesGroup.setText(EsbMessages.ScriptMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.description, EsbMessages.ScriptMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.ScriptMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.ScriptMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.ScriptMediator.Properties.commentsList, EsbMessages.ScriptMediatorPropertiesEditionPart_CommentsListLabel));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
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

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.ScriptMediator.Properties.reverse, EsbMessages.ScriptMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.ScriptMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createScriptTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.scriptType, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptTypeLabel);
		scriptType = new EMFComboViewer(parent);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptType()));
			}

		});
		scriptType.setID(EsbViewsRepository.ScriptMediator.Properties.scriptType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createScriptLanguageEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptLanguageLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getScriptLanguage()));
			}

		});
		scriptLanguage.setID(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptLanguageEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMediateFunctionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.mediateFunction, EsbMessages.ScriptMediatorPropertiesEditionPart_MediateFunctionLabel);
		mediateFunction = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData mediateFunctionData = new GridData(GridData.FILL_HORIZONTAL);
		mediateFunction.setLayoutData(mediateFunctionData);
		mediateFunction.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.mediateFunction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, mediateFunction.getText()));
			}

		});
		mediateFunction.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.mediateFunction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, mediateFunction.getText()));
				}
			}

		});
		EditingUtils.setID(mediateFunction, EsbViewsRepository.ScriptMediator.Properties.mediateFunction);
		EditingUtils.setEEFtype(mediateFunction, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.mediateFunction, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMediateFunctionText

		// End of user code
		return parent;
	}

	
	protected Composite createScriptBodyText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.scriptBody, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptBodyLabel);
		scriptBody = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData scriptBodyData = new GridData(GridData.FILL_HORIZONTAL);
		scriptBody.setLayoutData(scriptBodyData);
		scriptBody.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptBody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scriptBody.getText()));
			}

		});
		scriptBody.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptBody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scriptBody.getText()));
				}
			}

		});
		EditingUtils.setID(scriptBody, EsbViewsRepository.ScriptMediator.Properties.scriptBody);
		EditingUtils.setEEFtype(scriptBody, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptBody, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createScriptBodyText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createKeyTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.ScriptMediator.Properties.keyType, EsbMessages.ScriptMediatorPropertiesEditionPart_KeyTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.keyType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getKeyType()));
			}

		});
		keyType.setID(EsbViewsRepository.ScriptMediator.Properties.keyType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.keyType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createKeyTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createScriptKeysAdvancedTableComposition(Composite parent) {
		this.scriptKeys = new ReferencesTable(getDescription(EsbViewsRepository.ScriptMediator.Properties.scriptKeys, EsbMessages.ScriptMediatorPropertiesEditionPart_ScriptKeysLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				scriptKeys.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				scriptKeys.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				scriptKeys.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				scriptKeys.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.scriptKeysFilters) {
			this.scriptKeys.addFilter(filter);
		}
		this.scriptKeys.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.ScriptMediator.Properties.scriptKeys, EsbViewsRepository.SWT_KIND));
		this.scriptKeys.createControls(parent);
		this.scriptKeys.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScriptMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.ScriptMediator.Properties.scriptKeys, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData scriptKeysData = new GridData(GridData.FILL_HORIZONTAL);
		scriptKeysData.horizontalSpan = 3;
		this.scriptKeys.setLayoutData(scriptKeysData);
		this.scriptKeys.setLowerBound(0);
		this.scriptKeys.setUpperBound(-1);
		scriptKeys.setID(EsbViewsRepository.ScriptMediator.Properties.scriptKeys);
		scriptKeys.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createScriptKeysAdvancedTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setDescription(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setCommentsList(EList newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setReverse(Boolean newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptType()
	 * 
	 */
	public Enumerator getScriptType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scriptType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptLanguage()
	 * 
	 */
	public Enumerator getScriptLanguage() {
		Enumerator selection = (Enumerator) ((StructuredSelection) scriptLanguage.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptLanguage(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptLanguage(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getMediateFunction()
	 * 
	 */
	public String getMediateFunction() {
		return mediateFunction.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setMediateFunction(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getScriptBody()
	 * 
	 */
	public String getScriptBody() {
		return scriptBody.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setScriptBody(String newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#getKeyType()
	 * 
	 */
	public Enumerator getKeyType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) keyType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initKeyType(Object input, Enumerator current)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#setKeyType(Enumerator newValue)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#initScriptKeys(EObject current, EReference containingFeature, EReference feature)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#updateScriptKeys()
	 * 
	 */
	public void updateScriptKeys() {
	scriptKeys.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#addFilterScriptKeys(ViewerFilter filter)
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#addBusinessFilterScriptKeys(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToScriptKeys(ViewerFilter filter) {
		scriptKeysBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart#isContainedInScriptKeysTable(EObject element)
	 * 
	 */
	public boolean isContainedInScriptKeysTable(EObject element) {
		return ((ReferencesTableSettings)scriptKeys.getInput()).contains(element);
	}






	// Start of user code for Script Static Key specific getters and setters implementation
	@Override
	public RegistryKeyProperty getScriptStaticKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScriptStaticKey(RegistryKeyProperty registryKeyProperty) {
		// TODO Auto-generated method stub
		
	}
	// End of user code

	// Start of user code for Script Dynamic Key specific getters and setters implementation
	@Override
	public NamespacedProperty getScriptDynamicKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScriptDynamicKey(NamespacedProperty nameSpacedProperty) {
		// TODO Auto-generated method stub
		
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
	
	// End of user code


}
