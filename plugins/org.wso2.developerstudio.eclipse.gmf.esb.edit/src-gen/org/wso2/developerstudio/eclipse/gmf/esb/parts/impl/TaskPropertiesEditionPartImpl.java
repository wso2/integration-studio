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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class TaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TaskPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text taskName;
	protected Text taskGroup;
	protected EMFComboViewer triggerType;
	protected Text count;
	protected Text interval;
	protected Text cron;
	protected Text pinnedServers;
	protected Text taskImplementation;
	protected ReferencesTable taskProperties;
	protected List<ViewerFilter> taskPropertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> taskPropertiesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence taskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = taskStep.addStep(EsbViewsRepository.Task.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.taskName);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.taskGroup);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.triggerType);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.count);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.interval);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.cron);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.pinnedServers);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.taskImplementation);
		propertiesStep.addStep(EsbViewsRepository.Task.Properties.taskProperties);
		
		
		composer = new PartComposer(taskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Task.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.taskName) {
					return createTaskNameText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.taskGroup) {
					return createTaskGroupText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.triggerType) {
					return createTriggerTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.count) {
					return createCountText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.interval) {
					return createIntervalText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.cron) {
					return createCronText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.pinnedServers) {
					return createPinnedServersText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.taskImplementation) {
					return createTaskImplementationText(parent);
				}
				if (key == EsbViewsRepository.Task.Properties.taskProperties) {
					return createTaskPropertiesAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.TaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.description, EsbMessages.TaskPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.Task.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.Task.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.Task.Properties.commentsList, EsbMessages.TaskPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "Task", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.Task.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createTaskNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.taskName, EsbMessages.TaskPropertiesEditionPart_TaskNameLabel);
		taskName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData taskNameData = new GridData(GridData.FILL_HORIZONTAL);
		taskName.setLayoutData(taskNameData);
		taskName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskName.getText()));
			}

		});
		taskName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskName.getText()));
				}
			}

		});
		EditingUtils.setID(taskName, EsbViewsRepository.Task.Properties.taskName);
		EditingUtils.setEEFtype(taskName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.taskName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTaskNameText

		// End of user code
		return parent;
	}

	
	protected Composite createTaskGroupText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.taskGroup, EsbMessages.TaskPropertiesEditionPart_TaskGroupLabel);
		taskGroup = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData taskGroupData = new GridData(GridData.FILL_HORIZONTAL);
		taskGroup.setLayoutData(taskGroupData);
		taskGroup.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskGroup.getText()));
			}

		});
		taskGroup.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskGroup, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskGroup.getText()));
				}
			}

		});
		EditingUtils.setID(taskGroup, EsbViewsRepository.Task.Properties.taskGroup);
		EditingUtils.setEEFtype(taskGroup, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.taskGroup, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTaskGroupText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createTriggerTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.triggerType, EsbMessages.TaskPropertiesEditionPart_TriggerTypeLabel);
		triggerType = new EMFComboViewer(parent);
		triggerType.setContentProvider(new ArrayContentProvider());
		triggerType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData triggerTypeData = new GridData(GridData.FILL_HORIZONTAL);
		triggerType.getCombo().setLayoutData(triggerTypeData);
                triggerType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		triggerType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.triggerType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTriggerType()));
			}

		});
		triggerType.setID(EsbViewsRepository.Task.Properties.triggerType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.triggerType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTriggerTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCountText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.count, EsbMessages.TaskPropertiesEditionPart_CountLabel);
		count = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData countData = new GridData(GridData.FILL_HORIZONTAL);
		count.setLayoutData(countData);
		count.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.count, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, count.getText()));
			}

		});
		count.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.count, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, count.getText()));
				}
			}

		});
		EditingUtils.setID(count, EsbViewsRepository.Task.Properties.count);
		EditingUtils.setEEFtype(count, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.count, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCountText

		// End of user code
		return parent;
	}

	
	protected Composite createIntervalText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.interval, EsbMessages.TaskPropertiesEditionPart_IntervalLabel);
		interval = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData intervalData = new GridData(GridData.FILL_HORIZONTAL);
		interval.setLayoutData(intervalData);
		interval.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.interval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, interval.getText()));
			}

		});
		interval.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.interval, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, interval.getText()));
				}
			}

		});
		EditingUtils.setID(interval, EsbViewsRepository.Task.Properties.interval);
		EditingUtils.setEEFtype(interval, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.interval, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIntervalText

		// End of user code
		return parent;
	}

	
	protected Composite createCronText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.cron, EsbMessages.TaskPropertiesEditionPart_CronLabel);
		cron = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData cronData = new GridData(GridData.FILL_HORIZONTAL);
		cron.setLayoutData(cronData);
		cron.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.cron, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cron.getText()));
			}

		});
		cron.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.cron, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, cron.getText()));
				}
			}

		});
		EditingUtils.setID(cron, EsbViewsRepository.Task.Properties.cron);
		EditingUtils.setEEFtype(cron, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.cron, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCronText

		// End of user code
		return parent;
	}

	
	protected Composite createPinnedServersText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.pinnedServers, EsbMessages.TaskPropertiesEditionPart_PinnedServersLabel);
		pinnedServers = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData pinnedServersData = new GridData(GridData.FILL_HORIZONTAL);
		pinnedServers.setLayoutData(pinnedServersData);
		pinnedServers.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
			}

		});
		pinnedServers.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.pinnedServers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pinnedServers.getText()));
				}
			}

		});
		EditingUtils.setID(pinnedServers, EsbViewsRepository.Task.Properties.pinnedServers);
		EditingUtils.setEEFtype(pinnedServers, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.pinnedServers, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPinnedServersText

		// End of user code
		return parent;
	}

	
	protected Composite createTaskImplementationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Task.Properties.taskImplementation, EsbMessages.TaskPropertiesEditionPart_TaskImplementationLabel);
		taskImplementation = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData taskImplementationData = new GridData(GridData.FILL_HORIZONTAL);
		taskImplementation.setLayoutData(taskImplementationData);
		taskImplementation.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskImplementation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskImplementation.getText()));
			}

		});
		taskImplementation.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskImplementation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, taskImplementation.getText()));
				}
			}

		});
		EditingUtils.setID(taskImplementation, EsbViewsRepository.Task.Properties.taskImplementation);
		EditingUtils.setEEFtype(taskImplementation, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.taskImplementation, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTaskImplementationText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTaskPropertiesAdvancedTableComposition(Composite parent) {
		this.taskProperties = new ReferencesTable(getDescription(EsbViewsRepository.Task.Properties.taskProperties, EsbMessages.TaskPropertiesEditionPart_TaskPropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				taskProperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				taskProperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				taskProperties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskProperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				taskProperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.taskPropertiesFilters) {
			this.taskProperties.addFilter(filter);
		}
		this.taskProperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.Task.Properties.taskProperties, EsbViewsRepository.SWT_KIND));
		this.taskProperties.createControls(parent);
		this.taskProperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TaskPropertiesEditionPartImpl.this, EsbViewsRepository.Task.Properties.taskProperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData taskPropertiesData = new GridData(GridData.FILL_HORIZONTAL);
		taskPropertiesData.horizontalSpan = 3;
		this.taskProperties.setLayoutData(taskPropertiesData);
		this.taskProperties.setLowerBound(0);
		this.taskProperties.setUpperBound(-1);
		taskProperties.setID(EsbViewsRepository.Task.Properties.taskProperties);
		taskProperties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTaskPropertiesAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.Task_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getTaskName()
	 * 
	 */
	public String getTaskName() {
		return taskName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setTaskName(String newValue)
	 * 
	 */
	public void setTaskName(String newValue) {
		if (newValue != null) {
			taskName.setText(newValue);
		} else {
			taskName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.taskName);
		if (eefElementEditorReadOnlyState && taskName.isEnabled()) {
			taskName.setEnabled(false);
			taskName.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !taskName.isEnabled()) {
			taskName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getTaskGroup()
	 * 
	 */
	public String getTaskGroup() {
		return taskGroup.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setTaskGroup(String newValue)
	 * 
	 */
	public void setTaskGroup(String newValue) {
		if (newValue != null) {
			taskGroup.setText(newValue);
		} else {
			taskGroup.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.taskGroup);
		if (eefElementEditorReadOnlyState && taskGroup.isEnabled()) {
			taskGroup.setEnabled(false);
			taskGroup.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !taskGroup.isEnabled()) {
			taskGroup.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getTriggerType()
	 * 
	 */
	public Enumerator getTriggerType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) triggerType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#initTriggerType(Object input, Enumerator current)
	 */
	public void initTriggerType(Object input, Enumerator current) {
		triggerType.setInput(input);
		triggerType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.triggerType);
		if (eefElementEditorReadOnlyState && triggerType.isEnabled()) {
			triggerType.setEnabled(false);
			triggerType.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !triggerType.isEnabled()) {
			triggerType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setTriggerType(Enumerator newValue)
	 * 
	 */
	public void setTriggerType(Enumerator newValue) {
		triggerType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.triggerType);
		if (eefElementEditorReadOnlyState && triggerType.isEnabled()) {
			triggerType.setEnabled(false);
			triggerType.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !triggerType.isEnabled()) {
			triggerType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getCount()
	 * 
	 */
	public String getCount() {
		return count.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setCount(String newValue)
	 * 
	 */
	public void setCount(String newValue) {
		if (newValue != null) {
			count.setText(newValue);
		} else {
			count.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.count);
		if (eefElementEditorReadOnlyState && count.isEnabled()) {
			count.setEnabled(false);
			count.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !count.isEnabled()) {
			count.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getInterval()
	 * 
	 */
	public String getInterval() {
		return interval.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setInterval(String newValue)
	 * 
	 */
	public void setInterval(String newValue) {
		if (newValue != null) {
			interval.setText(newValue);
		} else {
			interval.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.interval);
		if (eefElementEditorReadOnlyState && interval.isEnabled()) {
			interval.setEnabled(false);
			interval.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !interval.isEnabled()) {
			interval.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getCron()
	 * 
	 */
	public String getCron() {
		return cron.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setCron(String newValue)
	 * 
	 */
	public void setCron(String newValue) {
		if (newValue != null) {
			cron.setText(newValue);
		} else {
			cron.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.cron);
		if (eefElementEditorReadOnlyState && cron.isEnabled()) {
			cron.setEnabled(false);
			cron.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !cron.isEnabled()) {
			cron.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getPinnedServers()
	 * 
	 */
	public String getPinnedServers() {
		return pinnedServers.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setPinnedServers(String newValue)
	 * 
	 */
	public void setPinnedServers(String newValue) {
		if (newValue != null) {
			pinnedServers.setText(newValue);
		} else {
			pinnedServers.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.pinnedServers);
		if (eefElementEditorReadOnlyState && pinnedServers.isEnabled()) {
			pinnedServers.setEnabled(false);
			pinnedServers.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pinnedServers.isEnabled()) {
			pinnedServers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#getTaskImplementation()
	 * 
	 */
	public String getTaskImplementation() {
		return taskImplementation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#setTaskImplementation(String newValue)
	 * 
	 */
	public void setTaskImplementation(String newValue) {
		if (newValue != null) {
			taskImplementation.setText(newValue);
		} else {
			taskImplementation.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.taskImplementation);
		if (eefElementEditorReadOnlyState && taskImplementation.isEnabled()) {
			taskImplementation.setEnabled(false);
			taskImplementation.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !taskImplementation.isEnabled()) {
			taskImplementation.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#initTaskProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTaskProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		taskProperties.setContentProvider(contentProvider);
		taskProperties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Task.Properties.taskProperties);
		if (eefElementEditorReadOnlyState && taskProperties.isEnabled()) {
			taskProperties.setEnabled(false);
			taskProperties.setToolTipText(EsbMessages.Task_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !taskProperties.isEnabled()) {
			taskProperties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#updateTaskProperties()
	 * 
	 */
	public void updateTaskProperties() {
	taskProperties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#addFilterTaskProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTaskProperties(ViewerFilter filter) {
		taskPropertiesFilters.add(filter);
		if (this.taskProperties != null) {
			this.taskProperties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#addBusinessFilterTaskProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTaskProperties(ViewerFilter filter) {
		taskPropertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart#isContainedInTaskPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInTaskPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)taskProperties.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Task_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
