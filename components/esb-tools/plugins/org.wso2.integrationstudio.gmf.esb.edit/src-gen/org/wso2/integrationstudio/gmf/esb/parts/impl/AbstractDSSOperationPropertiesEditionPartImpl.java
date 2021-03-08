/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class AbstractDSSOperationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AbstractDSSOperationPropertiesEditionPart {

	protected ReferencesTable dSSPrperties;
	protected List<ViewerFilter> dSSPrpertiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dSSPrpertiesFilters = new ArrayList<ViewerFilter>();
	protected Text operationName;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AbstractDSSOperationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence abstractDSSOperationStep = new BindingCompositionSequence(propertiesEditionComponent);
//		abstractDSSOperationStep
//			.addStep(EsbViewsRepository.AbstractDSSOperation.Properties.class);
		abstractDSSOperationStep.addStep(EsbViewsRepository.AbstractDSSOperation.operationName);
		abstractDSSOperationStep.addStep(EsbViewsRepository.AbstractDSSOperation.dSSPrperties);
		
		composer = new PartComposer(abstractDSSOperationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.AbstractDSSOperation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.AbstractDSSOperation.dSSPrperties) {
					return createDSSPrpertiesAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.AbstractDSSOperation.operationName) {
					return createOperationNameText(parent);
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
		propertiesGroup.setText(EsbMessages.AbstractDSSOperationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createDSSPrpertiesAdvancedTableComposition(Composite parent) {
		this.dSSPrperties = new ReferencesTable(getDescription(EsbViewsRepository.AbstractDSSOperation.dSSPrperties, EsbMessages.AbstractDSSOperationPropertiesEditionPart_DSSPrpertiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				dSSPrperties.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				dSSPrperties.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				dSSPrperties.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				dSSPrperties.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.dSSPrpertiesFilters) {
			this.dSSPrperties.addFilter(filter);
		}
		this.dSSPrperties.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.AbstractDSSOperation.dSSPrperties, EsbViewsRepository.SWT_KIND));
		this.dSSPrperties.createControls(parent);
		this.dSSPrperties.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.dSSPrperties, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
		// Start of user code for createDSSPrpertiesAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createOperationNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.AbstractDSSOperation.operationName, EsbMessages.AbstractDSSOperationPropertiesEditionPart_OperationNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractDSSOperationPropertiesEditionPartImpl.this, EsbViewsRepository.AbstractDSSOperation.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
				}
			}

		});
		EditingUtils.setID(operationName, EsbViewsRepository.AbstractDSSOperation.operationName);
		EditingUtils.setEEFtype(operationName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.AbstractDSSOperation.operationName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
