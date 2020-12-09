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
import org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class LogMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LogMediatorPropertiesEditionPart {

	protected EMFComboViewer logCategory;
	protected EMFComboViewer logLevel;
	protected Text logSeparator;
	protected ReferencesTable properties;
	protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LogMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence logMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = logMediatorStep.addStep(EsbViewsRepository.LogMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.LogMediator.Properties.logCategory);
		propertiesStep.addStep(EsbViewsRepository.LogMediator.Properties.logLevel);
		propertiesStep.addStep(EsbViewsRepository.LogMediator.Properties.logSeparator);
		propertiesStep.addStep(EsbViewsRepository.LogMediator.Properties.properties_);
		propertiesStep.addStep(EsbViewsRepository.LogMediator.Properties.description);
		
		
		composer = new PartComposer(logMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.LogMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logCategory) {
					return createLogCategoryEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logLevel) {
					return createLogLevelEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logSeparator) {
					return createLogSeparatorText(parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.properties_) {
					return createPropertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.description) {
					return createDescriptionText(parent);
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
		propertiesGroup.setText(EsbMessages.LogMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createLogCategoryEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logCategory, EsbMessages.LogMediatorPropertiesEditionPart_LogCategoryLabel);
		logCategory = new EMFComboViewer(parent);
		logCategory.setContentProvider(new ArrayContentProvider());
		logCategory.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData logCategoryData = new GridData(GridData.FILL_HORIZONTAL);
		logCategory.getCombo().setLayoutData(logCategoryData);
                logCategory.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		logCategory.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.logCategory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLogCategory()));
			}

		});
		logCategory.setID(EsbViewsRepository.LogMediator.Properties.logCategory);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logCategory, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogCategoryEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createLogLevelEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logLevel, EsbMessages.LogMediatorPropertiesEditionPart_LogLevelLabel);
		logLevel = new EMFComboViewer(parent);
		logLevel.setContentProvider(new ArrayContentProvider());
		logLevel.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData logLevelData = new GridData(GridData.FILL_HORIZONTAL);
		logLevel.getCombo().setLayoutData(logLevelData);
                logLevel.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		logLevel.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.logLevel, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLogLevel()));
			}

		});
		logLevel.setID(EsbViewsRepository.LogMediator.Properties.logLevel);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logLevel, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogLevelEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createLogSeparatorText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logSeparator, EsbMessages.LogMediatorPropertiesEditionPart_LogSeparatorLabel);
		logSeparator = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData logSeparatorData = new GridData(GridData.FILL_HORIZONTAL);
		logSeparator.setLayoutData(logSeparatorData);
		logSeparator.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.logSeparator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, logSeparator.getText()));
			}

		});
		logSeparator.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.logSeparator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, logSeparator.getText()));
				}
			}

		});
		EditingUtils.setID(logSeparator, EsbViewsRepository.LogMediator.Properties.logSeparator);
		EditingUtils.setEEFtype(logSeparator, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logSeparator, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogSeparatorText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesAdvancedTableComposition(Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.LogMediator.Properties.properties_, EsbMessages.LogMediatorPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.properties_, EsbViewsRepository.SWT_KIND));
		this.properties.createControls(parent);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);
		properties.setID(EsbViewsRepository.LogMediator.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.description, EsbMessages.LogMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.LogMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.LogMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#getLogCategory()
	 * 
	 */
	public Enumerator getLogCategory() {
		Enumerator selection = (Enumerator) ((StructuredSelection) logCategory.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#initLogCategory(Object input, Enumerator current)
	 */
	public void initLogCategory(Object input, Enumerator current) {
		logCategory.setInput(input);
		logCategory.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.logCategory);
		if (eefElementEditorReadOnlyState && logCategory.isEnabled()) {
			logCategory.setEnabled(false);
			logCategory.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !logCategory.isEnabled()) {
			logCategory.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#setLogCategory(Enumerator newValue)
	 * 
	 */
	public void setLogCategory(Enumerator newValue) {
		logCategory.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.logCategory);
		if (eefElementEditorReadOnlyState && logCategory.isEnabled()) {
			logCategory.setEnabled(false);
			logCategory.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !logCategory.isEnabled()) {
			logCategory.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#getLogLevel()
	 * 
	 */
	public Enumerator getLogLevel() {
		Enumerator selection = (Enumerator) ((StructuredSelection) logLevel.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#initLogLevel(Object input, Enumerator current)
	 */
	public void initLogLevel(Object input, Enumerator current) {
		logLevel.setInput(input);
		logLevel.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.logLevel);
		if (eefElementEditorReadOnlyState && logLevel.isEnabled()) {
			logLevel.setEnabled(false);
			logLevel.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !logLevel.isEnabled()) {
			logLevel.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#setLogLevel(Enumerator newValue)
	 * 
	 */
	public void setLogLevel(Enumerator newValue) {
		logLevel.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.logLevel);
		if (eefElementEditorReadOnlyState && logLevel.isEnabled()) {
			logLevel.setEnabled(false);
			logLevel.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !logLevel.isEnabled()) {
			logLevel.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#getLogSeparator()
	 * 
	 */
	public String getLogSeparator() {
		return logSeparator.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#setLogSeparator(String newValue)
	 * 
	 */
	public void setLogSeparator(String newValue) {
		if (newValue != null) {
			logSeparator.setText(newValue);
		} else {
			logSeparator.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.logSeparator);
		if (eefElementEditorReadOnlyState && logSeparator.isEnabled()) {
			logSeparator.setEnabled(false);
			logSeparator.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !logSeparator.isEnabled()) {
			logSeparator.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#initProperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		properties.setContentProvider(contentProvider);
		properties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.properties_);
		if (eefElementEditorReadOnlyState && properties.isEnabled()) {
			properties.setEnabled(false);
			properties.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !properties.isEnabled()) {
			properties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#updateProperties()
	 * 
	 */
	public void updateProperties() {
	properties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#addFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProperties(ViewerFilter filter) {
		propertiesFilters.add(filter);
		if (this.properties != null) {
			this.properties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#addBusinessFilterProperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProperties(ViewerFilter filter) {
		propertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#isContainedInPropertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPropertiesTable(EObject element) {
		return ((ReferencesTableSettings)properties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LogMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.LogMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.LogMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
