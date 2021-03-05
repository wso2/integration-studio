/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class AbstractDSSOperationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AbstractDSSOperationPropertiesEditionPart {

	protected ReferencesTable dSSPrperties;
	protected List<ViewerFilter> dSSPrpertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dSSPrpertiesFilters = new ArrayList<ViewerFilter>();
	protected Text operationName;



	/**
	 * For {@link ISection} use only.
	 */
	public AbstractDSSOperationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AbstractDSSOperationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence abstractDSSOperationStep = new BindingCompositionSequence(propertiesEditionComponent);
		abstractDSSOperationStep
			.addStep(EsbViewsRepository.AbstractDSSOperation.Properties.class);
		abstractDSSOperationStep.addStep(EsbViewsRepository.AbstractDSSOperation.dSSPrperties);
		abstractDSSOperationStep.addStep(EsbViewsRepository.AbstractDSSOperation.operationName);
		
		composer = new PartComposer(abstractDSSOperationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.AbstractDSSOperation.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AbstractDSSOperation.dSSPrperties) {
					return createDSSPrpertiesTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.AbstractDSSOperation.operationName) {
					return createOperationNameText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.AbstractDSSOperationPropertiesEditionPart_PropertiesGroupLabel);
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
	 * @param container
	 * 
	 */
	protected Composite createDSSPrpertiesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.dSSPrperties = new ReferencesTable(getDescription(EsbViewsRepository.AbstractDSSOperation.dSSPrperties, EsbMessages.AbstractDSSOperationPropertiesEditionPart_DSSPrpertiesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				dSSPrperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				dSSPrperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				dSSPrperties.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				dSSPrperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.dSSPrpertiesFilters) {
			this.dSSPrperties.addFilter(filter);
		}
		this.dSSPrperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.AbstractDSSOperation.dSSPrperties, EsbViewsRepository.FORM_KIND));
		this.dSSPrperties.createControls(parent, widgetFactory);
		this.dSSPrperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData dSSPrpertiesData = new GridData(GridData.FILL_HORIZONTAL);
		dSSPrpertiesData.horizontalSpan = 3;
		this.dSSPrperties.setLayoutData(dSSPrpertiesData);
		this.dSSPrperties.setLowerBound(0);
		this.dSSPrperties.setUpperBound(-1);
		dSSPrperties.setID(EsbViewsRepository.AbstractDSSOperation.dSSPrperties);
		dSSPrperties.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createDSSPrpertiesTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createOperationNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.AbstractDSSOperation.operationName, EsbMessages.AbstractDSSOperationPropertiesEditionPart_OperationNameLabel);
		operationName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		operationName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData operationNameData = new GridData(GridData.FILL_HORIZONTAL);
		operationName.setLayoutData(operationNameData);
		operationName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AbstractDSSOperationPropertiesEditionPartForm.this,
							EsbViewsRepository.AbstractDSSOperation.operationName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AbstractDSSOperationPropertiesEditionPartForm.this,
									EsbViewsRepository.AbstractDSSOperation.operationName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, operationName.getText()));
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
									AbstractDSSOperationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		operationName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartForm.this, EsbViewsRepository.AbstractDSSOperation.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
				}
			}
		});
		EditingUtils.setID(operationName, EsbViewsRepository.AbstractDSSOperation.operationName);
		EditingUtils.setEEFtype(operationName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AbstractDSSOperation.operationName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationNameText

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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#initDSSPrperties(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initDSSPrperties(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		dSSPrperties.setContentProvider(contentProvider);
		dSSPrperties.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AbstractDSSOperation.dSSPrperties);
		if (eefElementEditorReadOnlyState && dSSPrperties.isEnabled()) {
			dSSPrperties.setEnabled(false);
			dSSPrperties.setToolTipText(EsbMessages.AbstractDSSOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dSSPrperties.isEnabled()) {
			dSSPrperties.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#updateDSSPrperties()
	 * 
	 */
	public void updateDSSPrperties() {
	dSSPrperties.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#addFilterDSSPrperties(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDSSPrperties(ViewerFilter filter) {
		dSSPrpertiesFilters.add(filter);
		if (this.dSSPrperties != null) {
			this.dSSPrperties.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#addBusinessFilterDSSPrperties(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDSSPrperties(ViewerFilter filter) {
		dSSPrpertiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#isContainedInDSSPrpertiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInDSSPrpertiesTable(EObject element) {
		return ((ReferencesTableSettings)dSSPrperties.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#getOperationName()
	 * 
	 */
	public String getOperationName() {
		return operationName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart#setOperationName(String newValue)
	 * 
	 */
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.setText(newValue);
		} else {
			operationName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.AbstractDSSOperation.operationName);
		if (eefElementEditorReadOnlyState && operationName.isEnabled()) {
			operationName.setEnabled(false);
			operationName.setToolTipText(EsbMessages.AbstractDSSOperation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationName.isEnabled()) {
			operationName.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.AbstractDSSOperation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
