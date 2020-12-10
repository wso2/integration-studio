/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

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

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ThrottlePolicyEntryPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ThrottlePolicyEntryPropertiesEditionPart {

	protected EMFComboViewer throttleType;
	protected Text throttleRange;
	protected EMFComboViewer accessType;
	protected Text maxRequestCount;
	protected Text unitTime;
	protected Text prohibitPeriod;



	/**
	 * For {@link ISection} use only.
	 */
	public ThrottlePolicyEntryPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ThrottlePolicyEntryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence throttlePolicyEntryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = throttlePolicyEntryStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime);
		propertiesStep.addStep(EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod);
		
		
		composer = new PartComposer(throttlePolicyEntryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType) {
					return createThrottleTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange) {
					return createThrottleRangeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType) {
					return createAccessTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount) {
					return createMaxRequestCountText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime) {
					return createUnitTimeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod) {
					return createProhibitPeriodText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * @generated NOT
	 */
	protected Composite createThrottleTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_ThrottleTypeLabel);
		throttleType = new EMFComboViewer(parent);
		throttleType.setContentProvider(new ArrayContentProvider());
		throttleType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData throttleTypeData = new GridData(GridData.FILL_HORIZONTAL);
		throttleType.getCombo().setLayoutData(throttleTypeData);
                throttleType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		throttleType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getThrottleType()));
			}

		});
		throttleType.setID(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createThrottleTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createThrottleRangeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_ThrottleRangeLabel);
		throttleRange = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		throttleRange.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData throttleRangeData = new GridData(GridData.FILL_HORIZONTAL);
		throttleRange.setLayoutData(throttleRangeData);
		throttleRange.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottlePolicyEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, throttleRange.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, throttleRange.getText()));
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
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		throttleRange.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, throttleRange.getText()));
				}
			}
		});
		EditingUtils.setID(throttleRange, EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange);
		EditingUtils.setEEFtype(throttleRange, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createThrottleRangeText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createAccessTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_AccessTypeLabel);
		accessType = new EMFComboViewer(parent);
		accessType.setContentProvider(new ArrayContentProvider());
		accessType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData accessTypeData = new GridData(GridData.FILL_HORIZONTAL);
		accessType.getCombo().setLayoutData(accessTypeData);
                accessType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		accessType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAccessType()));
			}

		});
		accessType.setID(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAccessTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createMaxRequestCountText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_MaxRequestCountLabel);
		maxRequestCount = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maxRequestCount.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maxRequestCountData = new GridData(GridData.FILL_HORIZONTAL);
		maxRequestCount.setLayoutData(maxRequestCountData);
		maxRequestCount.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottlePolicyEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxRequestCount.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maxRequestCount.getText()));
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
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maxRequestCount.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maxRequestCount.getText()));
				}
			}
		});
		EditingUtils.setID(maxRequestCount, EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount);
		EditingUtils.setEEFtype(maxRequestCount, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaxRequestCountText

		// End of user code
		return parent;
	}

	
	protected Composite createUnitTimeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_UnitTimeLabel);
		unitTime = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		unitTime.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData unitTimeData = new GridData(GridData.FILL_HORIZONTAL);
		unitTime.setLayoutData(unitTimeData);
		unitTime.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottlePolicyEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, unitTime.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, unitTime.getText()));
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
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		unitTime.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, unitTime.getText()));
				}
			}
		});
		EditingUtils.setID(unitTime, EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime);
		EditingUtils.setEEFtype(unitTime, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUnitTimeText

		// End of user code
		return parent;
	}

	
	protected Composite createProhibitPeriodText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod, EsbMessages.ThrottlePolicyEntryPropertiesEditionPart_ProhibitPeriodLabel);
		prohibitPeriod = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		prohibitPeriod.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData prohibitPeriodData = new GridData(GridData.FILL_HORIZONTAL);
		prohibitPeriod.setLayoutData(prohibitPeriodData);
		prohibitPeriod.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ThrottlePolicyEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prohibitPeriod.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, prohibitPeriod.getText()));
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
									ThrottlePolicyEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		prohibitPeriod.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ThrottlePolicyEntryPropertiesEditionPartForm.this, EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, prohibitPeriod.getText()));
				}
			}
		});
		EditingUtils.setID(prohibitPeriod, EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod);
		EditingUtils.setEEFtype(prohibitPeriod, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProhibitPeriodText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getThrottleType()
	 * 
	 */
	public Enumerator getThrottleType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) throttleType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#initThrottleType(Object input, Enumerator current)
	 */
	public void initThrottleType(Object input, Enumerator current) {
		throttleType.setInput(input);
		throttleType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType);
		if (eefElementEditorReadOnlyState && throttleType.isEnabled()) {
			throttleType.setEnabled(false);
			throttleType.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !throttleType.isEnabled()) {
			throttleType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setThrottleType(Enumerator newValue)
	 * 
	 */
	public void setThrottleType(Enumerator newValue) {
		throttleType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType);
		if (eefElementEditorReadOnlyState && throttleType.isEnabled()) {
			throttleType.setEnabled(false);
			throttleType.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !throttleType.isEnabled()) {
			throttleType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getThrottleRange()
	 * 
	 */
	public String getThrottleRange() {
		return throttleRange.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setThrottleRange(String newValue)
	 * 
	 */
	public void setThrottleRange(String newValue) {
		if (newValue != null) {
			throttleRange.setText(newValue);
		} else {
			throttleRange.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange);
		if (eefElementEditorReadOnlyState && throttleRange.isEnabled()) {
			throttleRange.setEnabled(false);
			throttleRange.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !throttleRange.isEnabled()) {
			throttleRange.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getAccessType()
	 * 
	 */
	public Enumerator getAccessType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) accessType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#initAccessType(Object input, Enumerator current)
	 */
	public void initAccessType(Object input, Enumerator current) {
		accessType.setInput(input);
		accessType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType);
		if (eefElementEditorReadOnlyState && accessType.isEnabled()) {
			accessType.setEnabled(false);
			accessType.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !accessType.isEnabled()) {
			accessType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setAccessType(Enumerator newValue)
	 * 
	 */
	public void setAccessType(Enumerator newValue) {
		accessType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType);
		if (eefElementEditorReadOnlyState && accessType.isEnabled()) {
			accessType.setEnabled(false);
			accessType.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !accessType.isEnabled()) {
			accessType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getMaxRequestCount()
	 * 
	 */
	public String getMaxRequestCount() {
		return maxRequestCount.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setMaxRequestCount(String newValue)
	 * 
	 */
	public void setMaxRequestCount(String newValue) {
		if (newValue != null) {
			maxRequestCount.setText(newValue);
		} else {
			maxRequestCount.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount);
		if (eefElementEditorReadOnlyState && maxRequestCount.isEnabled()) {
			maxRequestCount.setEnabled(false);
			maxRequestCount.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maxRequestCount.isEnabled()) {
			maxRequestCount.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getUnitTime()
	 * 
	 */
	public String getUnitTime() {
		return unitTime.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setUnitTime(String newValue)
	 * 
	 */
	public void setUnitTime(String newValue) {
		if (newValue != null) {
			unitTime.setText(newValue);
		} else {
			unitTime.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime);
		if (eefElementEditorReadOnlyState && unitTime.isEnabled()) {
			unitTime.setEnabled(false);
			unitTime.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !unitTime.isEnabled()) {
			unitTime.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#getProhibitPeriod()
	 * 
	 */
	public String getProhibitPeriod() {
		return prohibitPeriod.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart#setProhibitPeriod(String newValue)
	 * 
	 */
	public void setProhibitPeriod(String newValue) {
		if (newValue != null) {
			prohibitPeriod.setText(newValue);
		} else {
			prohibitPeriod.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod);
		if (eefElementEditorReadOnlyState && prohibitPeriod.isEnabled()) {
			prohibitPeriod.setEnabled(false);
			prohibitPeriod.setToolTipText(EsbMessages.ThrottlePolicyEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !prohibitPeriod.isEnabled()) {
			prohibitPeriod.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ThrottlePolicyEntry_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
