/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
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

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.LogMediatorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.gmf.esb.util.FontUtils;

// End of user code

/**
 * 
 * 
 */
public class LogMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, LogMediatorPropertiesEditionPart {

	protected EMFComboViewer logCategory;
	protected EMFComboViewer logLevel;
	protected Text logSeparator;
	protected ReferencesTable properties;
	protected List<ViewerFilter> propertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> propertiesFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public LogMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LogMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logCategory) {
					return createLogCategoryEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logLevel) {
					return createLogLevelEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.logSeparator) {
					return createLogSeparatorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.properties_) {
					return createPropertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LogMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.LogMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createLogCategoryEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logCategory, EsbMessages.LogMediatorPropertiesEditionPart_LogCategoryLabel);
		logCategory = new EMFComboViewer(parent, SWT.SCROLL_LOCK);
		logCategory.setContentProvider(new ArrayContentProvider());
		logCategory.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData logCategoryData = new GridData(GridData.FILL_HORIZONTAL);
		logCategory.getCombo().setLayoutData(logCategoryData);
		logCategory.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.logCategory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLogCategory()));
			}

		});
		logCategory.setID(EsbViewsRepository.LogMediator.Properties.logCategory);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logCategory, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogCategoryEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createLogLevelEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logLevel, EsbMessages.LogMediatorPropertiesEditionPart_LogLevelLabel);
		logLevel = new EMFComboViewer(parent, SWT.SCROLL_LOCK);
		logLevel.setContentProvider(new ArrayContentProvider());
		logLevel.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData logLevelData = new GridData(GridData.FILL_HORIZONTAL);
		logLevel.getCombo().setLayoutData(logLevelData);
		logLevel.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.logLevel, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLogLevel()));
			}

		});
		logLevel.setID(EsbViewsRepository.LogMediator.Properties.logLevel);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logLevel, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogLevelEMFComboViewer

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createLogSeparatorText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.logSeparator, EsbMessages.LogMediatorPropertiesEditionPart_LogSeparatorLabel);
		logSeparator = widgetFactory.createText(parent, ","); //$NON-NLS-1$
		logSeparator.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData logSeparatorData = new GridData(GridData.FILL_HORIZONTAL);
		logSeparator.setLayoutData(logSeparatorData);
		logSeparator.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LogMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.LogMediator.Properties.logSeparator,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, logSeparator.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LogMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.LogMediator.Properties.logSeparator,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, logSeparator.getText()));
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
									LogMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		logSeparator.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.logSeparator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, logSeparator.getText()));
				}
			}
		});
		EditingUtils.setID(logSeparator, EsbViewsRepository.LogMediator.Properties.logSeparator);
		EditingUtils.setEEFtype(logSeparator, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.logSeparator, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLogSeparatorText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPropertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.properties = new ReferencesTable(getDescription(EsbViewsRepository.LogMediator.Properties.properties_, EsbMessages.LogMediatorPropertiesEditionPart_PropertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				properties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				properties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				properties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				properties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.propertiesFilters) {
			this.properties.addFilter(filter);
		}
		this.properties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.properties_, EsbViewsRepository.FORM_KIND));
		this.properties.createControls(parent, widgetFactory);
		this.properties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.properties_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData propertiesData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesData.horizontalSpan = 3;
		this.properties.setLayoutData(propertiesData);
		this.properties.setLowerBound(0);
		this.properties.setUpperBound(-1);

		//TODO: fix column header wrapping issue in mac and windows.  
		/*String emptySpace = StringUtils.rightPad("", 2);
		{
		    this.properties.getTable().setHeaderVisible(true);
		    String title = StringUtils.rightPad(emptySpace + "Property Name", 42) + "|"
		            + StringUtils.rightPad(emptySpace + "Property Value Type", 20) + emptySpace + "|"
		            + StringUtils.rightPad(emptySpace + "Property Value", 42) + "|";

		    TableColumn column = new TableColumn(this.properties.getTable(), SWT.NONE);
		    column.setText(title);
		    this.properties.getTable().getColumn(0).pack();
		}*/

		this.properties.getTable().setFont(FontUtils.getMonospacedFont());
		properties.setID(EsbViewsRepository.LogMediator.Properties.properties_);
		properties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createPropertiesTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LogMediator.Properties.description, EsbMessages.LogMediatorPropertiesEditionPart_DescriptionLabel);
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
							LogMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.LogMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LogMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.LogMediator.Properties.description,
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
									LogMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LogMediatorPropertiesEditionPartForm.this, EsbViewsRepository.LogMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.LogMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LogMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
