/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SqlStatementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SqlStatementPropertiesEditionPart {

	protected Text queryString;
	protected ReferencesTable parameters;
	protected List<ViewerFilter> parametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> parametersFilters = new ArrayList<ViewerFilter>();
	protected Button resultsEnabled;
	protected ReferencesTable results;
	protected List<ViewerFilter> resultsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> resultsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SqlStatementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence sqlStatementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sqlStatementStep.addStep(EsbViewsRepository.SqlStatement.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.SqlStatement.Properties.queryString);
		propertiesStep.addStep(EsbViewsRepository.SqlStatement.Properties.parameters);
		propertiesStep.addStep(EsbViewsRepository.SqlStatement.Properties.resultsEnabled);
		propertiesStep.addStep(EsbViewsRepository.SqlStatement.Properties.results);
		
		
		composer = new PartComposer(sqlStatementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SqlStatement.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.SqlStatement.Properties.queryString) {
					return createQueryStringText(parent);
				}
				if (key == EsbViewsRepository.SqlStatement.Properties.parameters) {
					return createParametersAdvancedTableComposition(parent);
				}
				if (key == EsbViewsRepository.SqlStatement.Properties.resultsEnabled) {
					return createResultsEnabledCheckbox(parent);
				}
				if (key == EsbViewsRepository.SqlStatement.Properties.results) {
					return createResultsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EsbMessages.SqlStatementPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createQueryStringText(Composite parent) {
		createDescription(parent, EsbViewsRepository.SqlStatement.Properties.queryString, EsbMessages.SqlStatementPropertiesEditionPart_QueryStringLabel);
		queryString = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData queryStringData = new GridData(GridData.FILL_HORIZONTAL);
		queryString.setLayoutData(queryStringData);
		queryString.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.queryString, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, queryString.getText()));
			}

		});
		queryString.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.queryString, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, queryString.getText()));
				}
			}

		});

            queryString.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.queryString, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, queryString.getText()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

        });
		EditingUtils.setID(queryString, EsbViewsRepository.SqlStatement.Properties.queryString);
		EditingUtils.setEEFtype(queryString, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlStatement.Properties.queryString, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createQueryStringText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createParametersAdvancedTableComposition(Composite parent) {
		this.parameters = new ReferencesTable(getDescription(EsbViewsRepository.SqlStatement.Properties.parameters, EsbMessages.SqlStatementPropertiesEditionPart_ParametersLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				parameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				parameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				parameters.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.parameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				parameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.parametersFilters) {
			this.parameters.addFilter(filter);
		}
		this.parameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlStatement.Properties.parameters, EsbViewsRepository.SWT_KIND));
		this.parameters.createControls(parent);
		this.parameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.parameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData parametersData = new GridData(GridData.FILL_HORIZONTAL);
		parametersData.horizontalSpan = 3;
		this.parameters.setLayoutData(parametersData);
		this.parameters.setLowerBound(0);
		this.parameters.setUpperBound(-1);
		parameters.setID(EsbViewsRepository.SqlStatement.Properties.parameters);
		parameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParametersAdvancedTableComposition

		// End of user code
		return parent;
	}

	
	protected Composite createResultsEnabledCheckbox(Composite parent) {
		resultsEnabled = new Button(parent, SWT.CHECK);
		resultsEnabled.setText(getDescription(EsbViewsRepository.SqlStatement.Properties.resultsEnabled, EsbMessages.SqlStatementPropertiesEditionPart_ResultsEnabledLabel));
		resultsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.resultsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(resultsEnabled.getSelection())));
			}

		});
		GridData resultsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		resultsEnabledData.horizontalSpan = 2;
		resultsEnabled.setLayoutData(resultsEnabledData);
		EditingUtils.setID(resultsEnabled, EsbViewsRepository.SqlStatement.Properties.resultsEnabled);
		EditingUtils.setEEFtype(resultsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlStatement.Properties.resultsEnabled, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultsEnabledCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createResultsAdvancedTableComposition(Composite parent) {
		this.results = new ReferencesTable(getDescription(EsbViewsRepository.SqlStatement.Properties.results, EsbMessages.SqlStatementPropertiesEditionPart_ResultsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				results.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				results.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				results.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.results, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				results.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.resultsFilters) {
			this.results.addFilter(filter);
		}
		this.results.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SqlStatement.Properties.results, EsbViewsRepository.SWT_KIND));
		this.results.createControls(parent);
		this.results.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SqlStatementPropertiesEditionPartImpl.this, EsbViewsRepository.SqlStatement.Properties.results, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData resultsData = new GridData(GridData.FILL_HORIZONTAL);
		resultsData.horizontalSpan = 3;
		this.results.setLayoutData(resultsData);
		this.results.setLowerBound(0);
		this.results.setUpperBound(-1);
		results.setID(EsbViewsRepository.SqlStatement.Properties.results);
		results.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createResultsAdvancedTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#getQueryString()
	 * 
	 */
	public String getQueryString() {
		return queryString.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#setQueryString(String newValue)
	 * 
	 */
	public void setQueryString(String newValue) {
		if (newValue != null) {
			queryString.setText(newValue);
		} else {
			queryString.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlStatement.Properties.queryString);
		if (eefElementEditorReadOnlyState && queryString.isEnabled()) {
			queryString.setEnabled(false);
			queryString.setToolTipText(EsbMessages.SqlStatement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !queryString.isEnabled()) {
			queryString.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#initParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		parameters.setContentProvider(contentProvider);
		parameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlStatement.Properties.parameters);
		if (eefElementEditorReadOnlyState && parameters.isEnabled()) {
			parameters.setEnabled(false);
			parameters.setToolTipText(EsbMessages.SqlStatement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parameters.isEnabled()) {
			parameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#updateParameters()
	 * 
	 */
	public void updateParameters() {
	parameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#addFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParameters(ViewerFilter filter) {
		parametersFilters.add(filter);
		if (this.parameters != null) {
			this.parameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#addBusinessFilterParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParameters(ViewerFilter filter) {
		parametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#isContainedInParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInParametersTable(EObject element) {
		return ((ReferencesTableSettings)parameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#getResultsEnabled()
	 * 
	 */
	public Boolean getResultsEnabled() {
		return Boolean.valueOf(resultsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#setResultsEnabled(Boolean newValue)
	 * 
	 */
	public void setResultsEnabled(Boolean newValue) {
		if (newValue != null) {
			resultsEnabled.setSelection(newValue.booleanValue());
		} else {
			resultsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlStatement.Properties.resultsEnabled);
		if (eefElementEditorReadOnlyState && resultsEnabled.isEnabled()) {
			resultsEnabled.setEnabled(false);
			resultsEnabled.setToolTipText(EsbMessages.SqlStatement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultsEnabled.isEnabled()) {
			resultsEnabled.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#initResults(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initResults(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		results.setContentProvider(contentProvider);
		results.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SqlStatement.Properties.results);
		if (eefElementEditorReadOnlyState && results.isEnabled()) {
			results.setEnabled(false);
			results.setToolTipText(EsbMessages.SqlStatement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !results.isEnabled()) {
			results.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#updateResults()
	 * 
	 */
	public void updateResults() {
	results.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#addFilterResults(ViewerFilter filter)
	 * 
	 */
	public void addFilterToResults(ViewerFilter filter) {
		resultsFilters.add(filter);
		if (this.results != null) {
			this.results.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#addBusinessFilterResults(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToResults(ViewerFilter filter) {
		resultsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart#isContainedInResultsTable(EObject element)
	 * 
	 */
	public boolean isContainedInResultsTable(EObject element) {
		return ((ReferencesTableSettings)results.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.SqlStatement_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
