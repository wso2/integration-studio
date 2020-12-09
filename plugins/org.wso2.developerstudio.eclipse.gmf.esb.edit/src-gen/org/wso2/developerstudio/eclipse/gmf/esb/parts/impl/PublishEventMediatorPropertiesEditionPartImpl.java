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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class PublishEventMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PublishEventMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text streamName;
	protected Text streamVersion;
	protected Text eventSink;
	protected ReferencesTable metaAttributes;
	protected List<ViewerFilter> metaAttributesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> metaAttributesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable correlationAttributes;
	protected List<ViewerFilter> correlationAttributesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> correlationAttributesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable payloadAttributes;
	protected List<ViewerFilter> payloadAttributesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> payloadAttributesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable arbitraryAttributes;
	protected List<ViewerFilter> arbitraryAttributesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> arbitraryAttributesFilters = new ArrayList<ViewerFilter>();
	protected Button async;
	protected Text asyncTimeout;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PublishEventMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence publishEventMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = publishEventMediatorStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.streamName);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.streamVersion);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.eventSink);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.async);
		propertiesStep.addStep(EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout);
		
		
		composer = new PartComposer(publishEventMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.PublishEventMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.streamName) {
					return createStreamNameText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.streamVersion) {
					return createStreamVersionText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.eventSink) {
					return createEventSinkText(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.metaAttributes) {
					return createMetaAttributesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes) {
					return createCorrelationAttributesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes) {
					return createPayloadAttributesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes) {
					return createArbitraryAttributesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.async) {
					return createAsyncCheckbox(parent);
				}
				if (key == EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout) {
					return createAsyncTimeoutText(parent);
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
		propertiesGroup.setText(EsbMessages.PublishEventMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediator.Properties.description, EsbMessages.PublishEventMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.PublishEventMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.PublishEventMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.PublishEventMediator.Properties.commentsList, EsbMessages.PublishEventMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "PublishEventMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.PublishEventMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.PublishEventMediator.Properties.reverse, EsbMessages.PublishEventMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.PublishEventMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createStreamNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediator.Properties.streamName, EsbMessages.PublishEventMediatorPropertiesEditionPart_StreamNameLabel);
		streamName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData streamNameData = new GridData(GridData.FILL_HORIZONTAL);
		streamName.setLayoutData(streamNameData);
		streamName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.streamName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamName.getText()));
			}

		});
		streamName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.streamName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamName.getText()));
				}
			}

		});
		EditingUtils.setID(streamName, EsbViewsRepository.PublishEventMediator.Properties.streamName);
		EditingUtils.setEEFtype(streamName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.streamName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStreamNameText

		// End of user code
		return parent;
	}

	
	protected Composite createStreamVersionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediator.Properties.streamVersion, EsbMessages.PublishEventMediatorPropertiesEditionPart_StreamVersionLabel);
		streamVersion = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData streamVersionData = new GridData(GridData.FILL_HORIZONTAL);
		streamVersion.setLayoutData(streamVersionData);
		streamVersion.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.streamVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamVersion.getText()));
			}

		});
		streamVersion.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.streamVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, streamVersion.getText()));
				}
			}

		});
		EditingUtils.setID(streamVersion, EsbViewsRepository.PublishEventMediator.Properties.streamVersion);
		EditingUtils.setEEFtype(streamVersion, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.streamVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStreamVersionText

		// End of user code
		return parent;
	}

	
	protected Composite createEventSinkText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediator.Properties.eventSink, EsbMessages.PublishEventMediatorPropertiesEditionPart_EventSinkLabel);
		eventSink = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData eventSinkData = new GridData(GridData.FILL_HORIZONTAL);
		eventSink.setLayoutData(eventSinkData);
		eventSink.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.eventSink, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, eventSink.getText()));
			}

		});
		eventSink.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.eventSink, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, eventSink.getText()));
				}
			}

		});
		EditingUtils.setID(eventSink, EsbViewsRepository.PublishEventMediator.Properties.eventSink);
		EditingUtils.setEEFtype(eventSink, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.eventSink, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createEventSinkText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMetaAttributesAdvancedTableComposition(Composite parent) {
		this.metaAttributes = new ReferencesTable(getDescription(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, EsbMessages.PublishEventMediatorPropertiesEditionPart_MetaAttributesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				metaAttributes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				metaAttributes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				metaAttributes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				metaAttributes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.metaAttributesFilters) {
			this.metaAttributes.addFilter(filter);
		}
		this.metaAttributes.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, EsbViewsRepository.SWT_KIND));
		this.metaAttributes.createControls(parent);
		this.metaAttributes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.metaAttributes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData metaAttributesData = new GridData(GridData.FILL_HORIZONTAL);
		metaAttributesData.horizontalSpan = 3;
		this.metaAttributes.setLayoutData(metaAttributesData);
		this.metaAttributes.setLowerBound(0);
		this.metaAttributes.setUpperBound(-1);
		metaAttributes.setID(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes);
		metaAttributes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createMetaAttributesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createCorrelationAttributesAdvancedTableComposition(Composite parent) {
		this.correlationAttributes = new ReferencesTable(getDescription(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, EsbMessages.PublishEventMediatorPropertiesEditionPart_CorrelationAttributesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				correlationAttributes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				correlationAttributes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				correlationAttributes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				correlationAttributes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.correlationAttributesFilters) {
			this.correlationAttributes.addFilter(filter);
		}
		this.correlationAttributes.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, EsbViewsRepository.SWT_KIND));
		this.correlationAttributes.createControls(parent);
		this.correlationAttributes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData correlationAttributesData = new GridData(GridData.FILL_HORIZONTAL);
		correlationAttributesData.horizontalSpan = 3;
		this.correlationAttributes.setLayoutData(correlationAttributesData);
		this.correlationAttributes.setLowerBound(0);
		this.correlationAttributes.setUpperBound(-1);
		correlationAttributes.setID(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes);
		correlationAttributes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCorrelationAttributesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPayloadAttributesAdvancedTableComposition(Composite parent) {
		this.payloadAttributes = new ReferencesTable(getDescription(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, EsbMessages.PublishEventMediatorPropertiesEditionPart_PayloadAttributesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				payloadAttributes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				payloadAttributes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				payloadAttributes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				payloadAttributes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.payloadAttributesFilters) {
			this.payloadAttributes.addFilter(filter);
		}
		this.payloadAttributes.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, EsbViewsRepository.SWT_KIND));
		this.payloadAttributes.createControls(parent);
		this.payloadAttributes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData payloadAttributesData = new GridData(GridData.FILL_HORIZONTAL);
		payloadAttributesData.horizontalSpan = 3;
		this.payloadAttributes.setLayoutData(payloadAttributesData);
		this.payloadAttributes.setLowerBound(0);
		this.payloadAttributes.setUpperBound(-1);
		payloadAttributes.setID(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes);
		payloadAttributes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPayloadAttributesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createArbitraryAttributesAdvancedTableComposition(Composite parent) {
		this.arbitraryAttributes = new ReferencesTable(getDescription(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, EsbMessages.PublishEventMediatorPropertiesEditionPart_ArbitraryAttributesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				arbitraryAttributes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				arbitraryAttributes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				arbitraryAttributes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				arbitraryAttributes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.arbitraryAttributesFilters) {
			this.arbitraryAttributes.addFilter(filter);
		}
		this.arbitraryAttributes.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, EsbViewsRepository.SWT_KIND));
		this.arbitraryAttributes.createControls(parent);
		this.arbitraryAttributes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData arbitraryAttributesData = new GridData(GridData.FILL_HORIZONTAL);
		arbitraryAttributesData.horizontalSpan = 3;
		this.arbitraryAttributes.setLayoutData(arbitraryAttributesData);
		this.arbitraryAttributes.setLowerBound(0);
		this.arbitraryAttributes.setUpperBound(-1);
		arbitraryAttributes.setID(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes);
		arbitraryAttributes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createArbitraryAttributesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createAsyncCheckbox(Composite parent) {
		async = new Button(parent, SWT.CHECK);
		async.setText(getDescription(EsbViewsRepository.PublishEventMediator.Properties.async, EsbMessages.PublishEventMediatorPropertiesEditionPart_AsyncLabel));
		async.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.async, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(async.getSelection())));
			}

		});
		GridData asyncData = new GridData(GridData.FILL_HORIZONTAL);
		asyncData.horizontalSpan = 2;
		async.setLayoutData(asyncData);
		EditingUtils.setID(async, EsbViewsRepository.PublishEventMediator.Properties.async);
		EditingUtils.setEEFtype(async, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.async, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAsyncCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createAsyncTimeoutText(Composite parent) {
		createDescription(parent, EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout, EsbMessages.PublishEventMediatorPropertiesEditionPart_AsyncTimeoutLabel);
		asyncTimeout = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData asyncTimeoutData = new GridData(GridData.FILL_HORIZONTAL);
		asyncTimeout.setLayoutData(asyncTimeoutData);
		asyncTimeout.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, asyncTimeout.getText()));
			}

		});
		asyncTimeout.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PublishEventMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, asyncTimeout.getText()));
				}
			}

		});
		EditingUtils.setID(asyncTimeout, EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout);
		EditingUtils.setEEFtype(asyncTimeout, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createAsyncTimeoutText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getStreamName()
	 * 
	 */
	public String getStreamName() {
		return streamName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setStreamName(String newValue)
	 * 
	 */
	public void setStreamName(String newValue) {
		if (newValue != null) {
			streamName.setText(newValue);
		} else {
			streamName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.streamName);
		if (eefElementEditorReadOnlyState && streamName.isEnabled()) {
			streamName.setEnabled(false);
			streamName.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !streamName.isEnabled()) {
			streamName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getStreamVersion()
	 * 
	 */
	public String getStreamVersion() {
		return streamVersion.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setStreamVersion(String newValue)
	 * 
	 */
	public void setStreamVersion(String newValue) {
		if (newValue != null) {
			streamVersion.setText(newValue);
		} else {
			streamVersion.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.streamVersion);
		if (eefElementEditorReadOnlyState && streamVersion.isEnabled()) {
			streamVersion.setEnabled(false);
			streamVersion.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !streamVersion.isEnabled()) {
			streamVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getEventSink()
	 * 
	 */
	public String getEventSink() {
		return eventSink.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setEventSink(String newValue)
	 * 
	 */
	public void setEventSink(String newValue) {
		if (newValue != null) {
			eventSink.setText(newValue);
		} else {
			eventSink.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.eventSink);
		if (eefElementEditorReadOnlyState && eventSink.isEnabled()) {
			eventSink.setEnabled(false);
			eventSink.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !eventSink.isEnabled()) {
			eventSink.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#initMetaAttributes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMetaAttributes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		metaAttributes.setContentProvider(contentProvider);
		metaAttributes.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.metaAttributes);
		if (eefElementEditorReadOnlyState && metaAttributes.isEnabled()) {
			metaAttributes.setEnabled(false);
			metaAttributes.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !metaAttributes.isEnabled()) {
			metaAttributes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#updateMetaAttributes()
	 * 
	 */
	public void updateMetaAttributes() {
	metaAttributes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addFilterMetaAttributes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMetaAttributes(ViewerFilter filter) {
		metaAttributesFilters.add(filter);
		if (this.metaAttributes != null) {
			this.metaAttributes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addBusinessFilterMetaAttributes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMetaAttributes(ViewerFilter filter) {
		metaAttributesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#isContainedInMetaAttributesTable(EObject element)
	 * 
	 */
	public boolean isContainedInMetaAttributesTable(EObject element) {
		return ((ReferencesTableSettings)metaAttributes.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#initCorrelationAttributes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCorrelationAttributes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		correlationAttributes.setContentProvider(contentProvider);
		correlationAttributes.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.correlationAttributes);
		if (eefElementEditorReadOnlyState && correlationAttributes.isEnabled()) {
			correlationAttributes.setEnabled(false);
			correlationAttributes.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !correlationAttributes.isEnabled()) {
			correlationAttributes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#updateCorrelationAttributes()
	 * 
	 */
	public void updateCorrelationAttributes() {
	correlationAttributes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addFilterCorrelationAttributes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCorrelationAttributes(ViewerFilter filter) {
		correlationAttributesFilters.add(filter);
		if (this.correlationAttributes != null) {
			this.correlationAttributes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addBusinessFilterCorrelationAttributes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCorrelationAttributes(ViewerFilter filter) {
		correlationAttributesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#isContainedInCorrelationAttributesTable(EObject element)
	 * 
	 */
	public boolean isContainedInCorrelationAttributesTable(EObject element) {
		return ((ReferencesTableSettings)correlationAttributes.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#initPayloadAttributes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPayloadAttributes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		payloadAttributes.setContentProvider(contentProvider);
		payloadAttributes.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.payloadAttributes);
		if (eefElementEditorReadOnlyState && payloadAttributes.isEnabled()) {
			payloadAttributes.setEnabled(false);
			payloadAttributes.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadAttributes.isEnabled()) {
			payloadAttributes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#updatePayloadAttributes()
	 * 
	 */
	public void updatePayloadAttributes() {
	payloadAttributes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addFilterPayloadAttributes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPayloadAttributes(ViewerFilter filter) {
		payloadAttributesFilters.add(filter);
		if (this.payloadAttributes != null) {
			this.payloadAttributes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addBusinessFilterPayloadAttributes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPayloadAttributes(ViewerFilter filter) {
		payloadAttributesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#isContainedInPayloadAttributesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPayloadAttributesTable(EObject element) {
		return ((ReferencesTableSettings)payloadAttributes.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#initArbitraryAttributes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initArbitraryAttributes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		arbitraryAttributes.setContentProvider(contentProvider);
		arbitraryAttributes.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.arbitraryAttributes);
		if (eefElementEditorReadOnlyState && arbitraryAttributes.isEnabled()) {
			arbitraryAttributes.setEnabled(false);
			arbitraryAttributes.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !arbitraryAttributes.isEnabled()) {
			arbitraryAttributes.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#updateArbitraryAttributes()
	 * 
	 */
	public void updateArbitraryAttributes() {
	arbitraryAttributes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addFilterArbitraryAttributes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArbitraryAttributes(ViewerFilter filter) {
		arbitraryAttributesFilters.add(filter);
		if (this.arbitraryAttributes != null) {
			this.arbitraryAttributes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#addBusinessFilterArbitraryAttributes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArbitraryAttributes(ViewerFilter filter) {
		arbitraryAttributesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#isContainedInArbitraryAttributesTable(EObject element)
	 * 
	 */
	public boolean isContainedInArbitraryAttributesTable(EObject element) {
		return ((ReferencesTableSettings)arbitraryAttributes.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getAsync()
	 * 
	 */
	public Boolean getAsync() {
		return Boolean.valueOf(async.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setAsync(Boolean newValue)
	 * 
	 */
	public void setAsync(Boolean newValue) {
		if (newValue != null) {
			async.setSelection(newValue.booleanValue());
		} else {
			async.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.async);
		if (eefElementEditorReadOnlyState && async.isEnabled()) {
			async.setEnabled(false);
			async.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !async.isEnabled()) {
			async.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#getAsyncTimeout()
	 * 
	 */
	public String getAsyncTimeout() {
		return asyncTimeout.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PublishEventMediatorPropertiesEditionPart#setAsyncTimeout(String newValue)
	 * 
	 */
	public void setAsyncTimeout(String newValue) {
		if (newValue != null) {
			asyncTimeout.setText(newValue);
		} else {
			asyncTimeout.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PublishEventMediator.Properties.asyncTimeout);
		if (eefElementEditorReadOnlyState && asyncTimeout.isEnabled()) {
			asyncTimeout.setEnabled(false);
			asyncTimeout.setToolTipText(EsbMessages.PublishEventMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !asyncTimeout.isEnabled()) {
			asyncTimeout.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PublishEventMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
