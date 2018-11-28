/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CloneMediatorTargetOutputConnectorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CloneMediatorTargetOutputConnectorPropertiesEditionPart {

	protected ReferencesTable commentMediators;
	protected List<ViewerFilter> commentMediatorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> commentMediatorsFilters = new ArrayList<ViewerFilter>();
	protected Text soapAction;
	protected Text toAddress;



	/**
	 * For {@link ISection} use only.
	 */
	public CloneMediatorTargetOutputConnectorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CloneMediatorTargetOutputConnectorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cloneMediatorTargetOutputConnectorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cloneMediatorTargetOutputConnectorStep.addStep(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators);
		propertiesStep.addStep(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction);
		propertiesStep.addStep(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress);
		
		
		composer = new PartComposer(cloneMediatorTargetOutputConnectorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators) {
					return createCommentMediatorsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction) {
					return createSoapActionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress) {
					return createToAddressText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.CloneMediatorTargetOutputConnectorPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createCommentMediatorsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.commentMediators = new ReferencesTable(getDescription(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, EsbMessages.CloneMediatorTargetOutputConnectorPropertiesEditionPart_CommentMediatorsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				commentMediators.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				commentMediators.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				commentMediators.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				commentMediators.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.commentMediatorsFilters) {
			this.commentMediators.addFilter(filter);
		}
		this.commentMediators.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, EsbViewsRepository.FORM_KIND));
		this.commentMediators.createControls(parent, widgetFactory);
		this.commentMediators.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData commentMediatorsData = new GridData(GridData.FILL_HORIZONTAL);
		commentMediatorsData.horizontalSpan = 3;
		this.commentMediators.setLayoutData(commentMediatorsData);
		this.commentMediators.setLowerBound(0);
		this.commentMediators.setUpperBound(-1);
		commentMediators.setID(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators);
		commentMediators.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCommentMediatorsTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createSoapActionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction, EsbMessages.CloneMediatorTargetOutputConnectorPropertiesEditionPart_SoapActionLabel);
		soapAction = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		soapAction.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData soapActionData = new GridData(GridData.FILL_HORIZONTAL);
		soapAction.setLayoutData(soapActionData);
		soapAction.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
							EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
									EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, soapAction.getText()));
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
									CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		soapAction.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
				}
			}
		});
		EditingUtils.setID(soapAction, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction);
		EditingUtils.setEEFtype(soapAction, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapActionText

		// End of user code
		return parent;
	}

	
	protected Composite createToAddressText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress, EsbMessages.CloneMediatorTargetOutputConnectorPropertiesEditionPart_ToAddressLabel);
		toAddress = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		toAddress.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData toAddressData = new GridData(GridData.FILL_HORIZONTAL);
		toAddress.setLayoutData(toAddressData);
		toAddress.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
							EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, toAddress.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
									EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, toAddress.getText()));
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
									CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		toAddress.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CloneMediatorTargetOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, toAddress.getText()));
				}
			}
		});
		EditingUtils.setID(toAddress, EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress);
		EditingUtils.setEEFtype(toAddress, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createToAddressText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#initCommentMediators(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCommentMediators(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		commentMediators.setContentProvider(contentProvider);
		commentMediators.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators);
		if (eefElementEditorReadOnlyState && commentMediators.isEnabled()) {
			commentMediators.setEnabled(false);
			commentMediators.setToolTipText(EsbMessages.CloneMediatorTargetOutputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !commentMediators.isEnabled()) {
			commentMediators.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#updateCommentMediators()
	 * 
	 */
	public void updateCommentMediators() {
	commentMediators.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#addFilterCommentMediators(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCommentMediators(ViewerFilter filter) {
		commentMediatorsFilters.add(filter);
		if (this.commentMediators != null) {
			this.commentMediators.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#addBusinessFilterCommentMediators(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCommentMediators(ViewerFilter filter) {
		commentMediatorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#isContainedInCommentMediatorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInCommentMediatorsTable(EObject element) {
		return ((ReferencesTableSettings)commentMediators.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#getSoapAction()
	 * 
	 */
	public String getSoapAction() {
		return soapAction.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#setSoapAction(String newValue)
	 * 
	 */
	public void setSoapAction(String newValue) {
		if (newValue != null) {
			soapAction.setText(newValue);
		} else {
			soapAction.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction);
		if (eefElementEditorReadOnlyState && soapAction.isEnabled()) {
			soapAction.setEnabled(false);
			soapAction.setToolTipText(EsbMessages.CloneMediatorTargetOutputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapAction.isEnabled()) {
			soapAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#getToAddress()
	 * 
	 */
	public String getToAddress() {
		return toAddress.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart#setToAddress(String newValue)
	 * 
	 */
	public void setToAddress(String newValue) {
		if (newValue != null) {
			toAddress.setText(newValue);
		} else {
			toAddress.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress);
		if (eefElementEditorReadOnlyState && toAddress.isEnabled()) {
			toAddress.setEnabled(false);
			toAddress.setToolTipText(EsbMessages.CloneMediatorTargetOutputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !toAddress.isEnabled()) {
			toAddress.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CloneMediatorTargetOutputConnector_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
