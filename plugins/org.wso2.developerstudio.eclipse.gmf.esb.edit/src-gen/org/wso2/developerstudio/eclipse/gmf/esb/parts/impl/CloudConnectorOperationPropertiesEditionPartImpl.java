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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CloudConnectorOperationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CloudConnectorOperationPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected ReferencesTable connectorParameters;
	protected List<ViewerFilter> connectorParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> connectorParametersFilters = new ArrayList<ViewerFilter>();
	protected Text configRef;
	protected Text connectorName;
	protected Text operationName;
	protected Text cloudConnectorName;
	protected Text availableConfigs;
	protected EMFComboViewer parameterEditorType;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloudConnectorOperationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cloudConnectorOperationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cloudConnectorOperationStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
		propertiesStep.addStep(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		
		
		composer = new PartComposer(cloudConnectorOperationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters) {
					return createConnectorParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.configRef) {
					return createConfigRefText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.connectorName) {
					return createConnectorNameText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.operationName) {
					return createOperationNameText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName) {
					return createCloudConnectorNameText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs) {
					return createAvailableConfigsText(parent);
				}
				if (key == EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType) {
					return createParameterEditorTypeEMFComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.CloudConnectorOperationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.description, EsbMessages.CloudConnectorOperationPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.CloudConnectorOperation.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList, EsbMessages.CloudConnectorOperationPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "CloudConnectorOperation", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.reverse, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createConnectorParametersAdvancedTableComposition(Composite parent) {
		this.connectorParameters = new ReferencesTable(getDescription(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConnectorParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				connectorParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				connectorParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				connectorParameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				connectorParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.connectorParametersFilters) {
			this.connectorParameters.addFilter(filter);
		}
		this.connectorParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, EsbViewsRepository.SWT_KIND));
		this.connectorParameters.createControls(parent);
		this.connectorParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData connectorParametersData = new GridData(GridData.FILL_HORIZONTAL);
		connectorParametersData.horizontalSpan = 3;
		this.connectorParameters.setLayoutData(connectorParametersData);
		this.connectorParameters.setLowerBound(0);
		this.connectorParameters.setUpperBound(-1);
		connectorParameters.setID(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
		connectorParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createConnectorParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createConfigRefText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.configRef, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConfigRefLabel);
		configRef = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
		configRef.setLayoutData(configRefData);
		configRef.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configRef.getText()));
			}

		});
		configRef.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.configRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, configRef.getText()));
				}
			}

		});
		EditingUtils.setID(configRef, EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
		EditingUtils.setEEFtype(configRef, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.configRef, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createConfigRefText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectorNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ConnectorNameLabel);
		connectorName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData connectorNameData = new GridData(GridData.FILL_HORIZONTAL);
		connectorName.setLayoutData(connectorNameData);
		connectorName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectorName.getText()));
			}

		});
		connectorName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectorName.getText()));
				}
			}

		});
		EditingUtils.setID(connectorName, EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
		EditingUtils.setEEFtype(connectorName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOperationNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.operationName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_OperationNameLabel);
		operationName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData operationNameData = new GridData(GridData.FILL_HORIZONTAL);
		operationName.setLayoutData(operationNameData);
		operationName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
			}

		});
		operationName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
				}
			}

		});
		EditingUtils.setID(operationName, EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
		EditingUtils.setEEFtype(operationName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.operationName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationNameText

		// End of user code
		return parent;
	}

	
	protected Composite createCloudConnectorNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, EsbMessages.CloudConnectorOperationPropertiesEditionPart_CloudConnectorNameLabel);
		cloudConnectorName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cloudConnectorNameData = new GridData(GridData.FILL_HORIZONTAL);
		cloudConnectorName.setLayoutData(cloudConnectorNameData);
		cloudConnectorName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloudConnectorName.getText()));
			}

		});
		cloudConnectorName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cloudConnectorName.getText()));
				}
			}

		});
		EditingUtils.setID(cloudConnectorName, EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
		EditingUtils.setEEFtype(cloudConnectorName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCloudConnectorNameText

		// End of user code
		return parent;
	}

	
	protected Composite createAvailableConfigsText(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, EsbMessages.CloudConnectorOperationPropertiesEditionPart_AvailableConfigsLabel);
		availableConfigs = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData availableConfigsData = new GridData(GridData.FILL_HORIZONTAL);
		availableConfigs.setLayoutData(availableConfigsData);
		availableConfigs.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableConfigs.getText()));
			}

		});
		availableConfigs.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, availableConfigs.getText()));
				}
			}

		});
		EditingUtils.setID(availableConfigs, EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
		EditingUtils.setEEFtype(availableConfigs, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableConfigsText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createParameterEditorTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, EsbMessages.CloudConnectorOperationPropertiesEditionPart_ParameterEditorTypeLabel);
		parameterEditorType = new EMFComboViewer(parent);
		parameterEditorType.setContentProvider(new ArrayContentProvider());
		parameterEditorType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData parameterEditorTypeData = new GridData(GridData.FILL_HORIZONTAL);
		parameterEditorType.getCombo().setLayoutData(parameterEditorTypeData);
                parameterEditorType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		parameterEditorType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloudConnectorOperationPropertiesEditionPartImpl.this, EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParameterEditorType()));
			}

		});
		parameterEditorType.setID(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParameterEditorTypeEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#initConnectorParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initConnectorParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		connectorParameters.setContentProvider(contentProvider);
		connectorParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters);
		if (eefElementEditorReadOnlyState && connectorParameters.isEnabled()) {
			connectorParameters.setEnabled(false);
			connectorParameters.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectorParameters.isEnabled()) {
			connectorParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#updateConnectorParameters()
	 * 
	 */
	public void updateConnectorParameters() {
	connectorParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#addFilterConnectorParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToConnectorParameters(ViewerFilter filter) {
		connectorParametersFilters.add(filter);
		if (this.connectorParameters != null) {
			this.connectorParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#addBusinessFilterConnectorParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToConnectorParameters(ViewerFilter filter) {
		connectorParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#isContainedInConnectorParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInConnectorParametersTable(EObject element) {
		return ((ReferencesTableSettings)connectorParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getConfigRef()
	 * 
	 */
	public String getConfigRef() {
		return configRef.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setConfigRef(String newValue)
	 * 
	 */
	public void setConfigRef(String newValue) {
		if (newValue != null) {
			configRef.setText(newValue);
		} else {
			configRef.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.configRef);
		if (eefElementEditorReadOnlyState && configRef.isEnabled()) {
			configRef.setEnabled(false);
			configRef.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !configRef.isEnabled()) {
			configRef.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getConnectorName()
	 * 
	 */
	public String getConnectorName() {
		return connectorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setConnectorName(String newValue)
	 * 
	 */
	public void setConnectorName(String newValue) {
		if (newValue != null) {
			connectorName.setText(newValue);
		} else {
			connectorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName);
		if (eefElementEditorReadOnlyState && connectorName.isEnabled()) {
			connectorName.setEnabled(false);
			connectorName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectorName.isEnabled()) {
			connectorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getOperationName()
	 * 
	 */
	public String getOperationName() {
		return operationName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setOperationName(String newValue)
	 * 
	 */
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.setText(newValue);
		} else {
			operationName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.operationName);
		if (eefElementEditorReadOnlyState && operationName.isEnabled()) {
			operationName.setEnabled(false);
			operationName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationName.isEnabled()) {
			operationName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getCloudConnectorName()
	 * 
	 */
	public String getCloudConnectorName() {
		return cloudConnectorName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setCloudConnectorName(String newValue)
	 * 
	 */
	public void setCloudConnectorName(String newValue) {
		if (newValue != null) {
			cloudConnectorName.setText(newValue);
		} else {
			cloudConnectorName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName);
		if (eefElementEditorReadOnlyState && cloudConnectorName.isEnabled()) {
			cloudConnectorName.setEnabled(false);
			cloudConnectorName.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cloudConnectorName.isEnabled()) {
			cloudConnectorName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getAvailableConfigs()
	 * 
	 */
	public String getAvailableConfigs() {
		return availableConfigs.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setAvailableConfigs(String newValue)
	 * 
	 */
	public void setAvailableConfigs(String newValue) {
		if (newValue != null) {
			availableConfigs.setText(newValue);
		} else {
			availableConfigs.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs);
		if (eefElementEditorReadOnlyState && availableConfigs.isEnabled()) {
			availableConfigs.setEnabled(false);
			availableConfigs.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !availableConfigs.isEnabled()) {
			availableConfigs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#getParameterEditorType()
	 * 
	 */
	public Enumerator getParameterEditorType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) parameterEditorType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#initParameterEditorType(Object input, Enumerator current)
	 */
	public void initParameterEditorType(Object input, Enumerator current) {
		parameterEditorType.setInput(input);
		parameterEditorType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		if (eefElementEditorReadOnlyState && parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(false);
			parameterEditorType.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart#setParameterEditorType(Enumerator newValue)
	 * 
	 */
	public void setParameterEditorType(Enumerator newValue) {
		parameterEditorType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType);
		if (eefElementEditorReadOnlyState && parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(false);
			parameterEditorType.setToolTipText(EsbMessages.CloudConnectorOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameterEditorType.isEnabled()) {
			parameterEditorType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloudConnectorOperation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
