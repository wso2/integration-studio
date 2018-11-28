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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SwitchCaseBranchOutputConnectorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SwitchCaseBranchOutputConnectorPropertiesEditionPart {

	protected ReferencesTable commentMediators;
	protected List<ViewerFilter> commentMediatorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> commentMediatorsFilters = new ArrayList<ViewerFilter>();
	protected Text caseRegex;



	/**
	 * For {@link ISection} use only.
	 */
	public SwitchCaseBranchOutputConnectorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SwitchCaseBranchOutputConnectorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence switchCaseBranchOutputConnectorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = switchCaseBranchOutputConnectorStep.addStep(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators);
		propertiesStep.addStep(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex);
		
		
		composer = new PartComposer(switchCaseBranchOutputConnectorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators) {
					return createCommentMediatorsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex) {
					return createCaseRegexText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.SwitchCaseBranchOutputConnectorPropertiesEditionPart_PropertiesGroupLabel);
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
		this.commentMediators = new ReferencesTable(getDescription(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, EsbMessages.SwitchCaseBranchOutputConnectorPropertiesEditionPart_CommentMediatorsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				commentMediators.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				commentMediators.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				commentMediators.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				commentMediators.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.commentMediatorsFilters) {
			this.commentMediators.addFilter(filter);
		}
		this.commentMediators.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, EsbViewsRepository.FORM_KIND));
		this.commentMediators.createControls(parent, widgetFactory);
		this.commentMediators.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData commentMediatorsData = new GridData(GridData.FILL_HORIZONTAL);
		commentMediatorsData.horizontalSpan = 3;
		this.commentMediators.setLayoutData(commentMediatorsData);
		this.commentMediators.setLowerBound(0);
		this.commentMediators.setUpperBound(-1);
		commentMediators.setID(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators);
		commentMediators.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCommentMediatorsTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createCaseRegexText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex, EsbMessages.SwitchCaseBranchOutputConnectorPropertiesEditionPart_CaseRegexLabel);
		caseRegex = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		caseRegex.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData caseRegexData = new GridData(GridData.FILL_HORIZONTAL);
		caseRegex.setLayoutData(caseRegexData);
		caseRegex.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this,
							EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, caseRegex.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this,
									EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, caseRegex.getText()));
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
									SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		caseRegex.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchCaseBranchOutputConnectorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, caseRegex.getText()));
				}
			}
		});
		EditingUtils.setID(caseRegex, EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex);
		EditingUtils.setEEFtype(caseRegex, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCaseRegexText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#initCommentMediators(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCommentMediators(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		commentMediators.setContentProvider(contentProvider);
		commentMediators.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.commentMediators);
		if (eefElementEditorReadOnlyState && commentMediators.isEnabled()) {
			commentMediators.setEnabled(false);
			commentMediators.setToolTipText(EsbMessages.SwitchCaseBranchOutputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !commentMediators.isEnabled()) {
			commentMediators.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#updateCommentMediators()
	 * 
	 */
	public void updateCommentMediators() {
	commentMediators.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#addFilterCommentMediators(ViewerFilter filter)
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#addBusinessFilterCommentMediators(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCommentMediators(ViewerFilter filter) {
		commentMediatorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#isContainedInCommentMediatorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInCommentMediatorsTable(EObject element) {
		return ((ReferencesTableSettings)commentMediators.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#getCaseRegex()
	 * 
	 */
	public String getCaseRegex() {
		return caseRegex.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchCaseBranchOutputConnectorPropertiesEditionPart#setCaseRegex(String newValue)
	 * 
	 */
	public void setCaseRegex(String newValue) {
		if (newValue != null) {
			caseRegex.setText(newValue);
		} else {
			caseRegex.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchCaseBranchOutputConnector.Properties.caseRegex);
		if (eefElementEditorReadOnlyState && caseRegex.isEnabled()) {
			caseRegex.setEnabled(false);
			caseRegex.setToolTipText(EsbMessages.SwitchCaseBranchOutputConnector_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !caseRegex.isEnabled()) {
			caseRegex.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SwitchCaseBranchOutputConnector_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
