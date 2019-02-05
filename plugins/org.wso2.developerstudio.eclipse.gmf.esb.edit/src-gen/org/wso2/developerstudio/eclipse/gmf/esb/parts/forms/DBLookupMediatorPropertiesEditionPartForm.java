/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DBLookupMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DBLookupMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer connectionType;
	protected EMFComboViewer connectionDsType;
	protected EMFComboViewer connectionDbType;
	protected Text connectionDbDriver;
	protected Text connectionDsInitialContext;
	protected Text connectionDsName;
	protected Text connectionURL;
	protected Text connectionUsername;
	protected Text connectionPassword;
	protected EMFComboViewer propertyAutocommit;
	protected EMFComboViewer propertyIsolation;
	protected Text propertyMaxactive;
	protected Text propertyMaxidle;
	protected Text propertyMaxopenstatements;
	protected Text propertyMaxwait;
	protected Text propertyMinidle;
	protected EMFComboViewer propertyPoolstatements;
	protected EMFComboViewer propertyTestonborrow;
	protected EMFComboViewer propertyTestwhileidle;
	protected Text propertyValidationquery;
	protected Text propertyInitialsize;
	protected ReferencesTable sqlStatements;
	protected List<ViewerFilter> sqlStatementsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> sqlStatementsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public DBLookupMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DBLookupMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dBLookupMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dBLookupMediatorStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionType);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionDsType);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionDbType);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionDsName);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionURL);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionUsername);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.connectionPassword);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize);
		propertiesStep.addStep(EsbViewsRepository.DBLookupMediator.Properties.sqlStatements);
		
		
		composer = new PartComposer(dBLookupMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DBLookupMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionType) {
					return createConnectionTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionDsType) {
					return createConnectionDsTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionDbType) {
					return createConnectionDbTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver) {
					return createConnectionDbDriverText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext) {
					return createConnectionDsInitialContextText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionDsName) {
					return createConnectionDsNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionURL) {
					return createConnectionURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionUsername) {
					return createConnectionUsernameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.connectionPassword) {
					return createConnectionPasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit) {
					return createPropertyAutocommitEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation) {
					return createPropertyIsolationEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive) {
					return createPropertyMaxactiveText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle) {
					return createPropertyMaxidleText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements) {
					return createPropertyMaxopenstatementsText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait) {
					return createPropertyMaxwaitText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle) {
					return createPropertyMinidleText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements) {
					return createPropertyPoolstatementsEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow) {
					return createPropertyTestonborrowEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle) {
					return createPropertyTestwhileidleEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery) {
					return createPropertyValidationqueryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize) {
					return createPropertyInitialsizeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DBLookupMediator.Properties.sqlStatements) {
					return createSqlStatementsTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.description, EsbMessages.DBLookupMediatorPropertiesEditionPart_DescriptionLabel);
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
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.description,
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
									DBLookupMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.DBLookupMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DBLookupMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DBLookupMediator.Properties.commentsList, EsbMessages.DBLookupMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "DBLookupMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DBLookupMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DBLookupMediator.Properties.reverse, EsbMessages.DBLookupMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DBLookupMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionType, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionTypeLabel);
		connectionType = new EMFComboViewer(parent);
		connectionType.setContentProvider(new ArrayContentProvider());
		connectionType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData connectionTypeData = new GridData(GridData.FILL_HORIZONTAL);
		connectionType.getCombo().setLayoutData(connectionTypeData);
		connectionType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getConnectionType()));
			}

		});
		connectionType.setID(EsbViewsRepository.DBLookupMediator.Properties.connectionType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionDsTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionDsType, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionDsTypeLabel);
		connectionDsType = new EMFComboViewer(parent);
		connectionDsType.setContentProvider(new ArrayContentProvider());
		connectionDsType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData connectionDsTypeData = new GridData(GridData.FILL_HORIZONTAL);
		connectionDsType.getCombo().setLayoutData(connectionDsTypeData);
		connectionDsType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionDsType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getConnectionDsType()));
			}

		});
		connectionDsType.setID(EsbViewsRepository.DBLookupMediator.Properties.connectionDsType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionDsType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionDsTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionDbTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionDbType, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionDbTypeLabel);
		connectionDbType = new EMFComboViewer(parent);
		connectionDbType.setContentProvider(new ArrayContentProvider());
		connectionDbType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData connectionDbTypeData = new GridData(GridData.FILL_HORIZONTAL);
		connectionDbType.getCombo().setLayoutData(connectionDbTypeData);
		connectionDbType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionDbType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getConnectionDbType()));
			}

		});
		connectionDbType.setID(EsbViewsRepository.DBLookupMediator.Properties.connectionDbType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionDbType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionDbTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionDbDriverText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionDbDriverLabel);
		connectionDbDriver = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionDbDriver.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionDbDriverData = new GridData(GridData.FILL_HORIZONTAL);
		connectionDbDriver.setLayoutData(connectionDbDriverData);
		connectionDbDriver.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDbDriver.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionDbDriver.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionDbDriver.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDbDriver.getText()));
				}
			}
		});
		EditingUtils.setID(connectionDbDriver, EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver);
		EditingUtils.setEEFtype(connectionDbDriver, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionDbDriverText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionDsInitialContextText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionDsInitialContextLabel);
		connectionDsInitialContext = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionDsInitialContext.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionDsInitialContextData = new GridData(GridData.FILL_HORIZONTAL);
		connectionDsInitialContext.setLayoutData(connectionDsInitialContextData);
		connectionDsInitialContext.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDsInitialContext.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionDsInitialContext.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionDsInitialContext.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDsInitialContext.getText()));
				}
			}
		});
		EditingUtils.setID(connectionDsInitialContext, EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext);
		EditingUtils.setEEFtype(connectionDsInitialContext, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionDsInitialContextText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionDsNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionDsName, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionDsNameLabel);
		connectionDsName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionDsName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionDsNameData = new GridData(GridData.FILL_HORIZONTAL);
		connectionDsName.setLayoutData(connectionDsNameData);
		connectionDsName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionDsName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDsName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionDsName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionDsName.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionDsName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionDsName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionDsName.getText()));
				}
			}
		});
		EditingUtils.setID(connectionDsName, EsbViewsRepository.DBLookupMediator.Properties.connectionDsName);
		EditingUtils.setEEFtype(connectionDsName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionDsName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionDsNameText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionURL, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionURLLabel);
		connectionURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionURLData = new GridData(GridData.FILL_HORIZONTAL);
		connectionURL.setLayoutData(connectionURLData);
		connectionURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionURL.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionURL.getText()));
				}
			}
		});
		EditingUtils.setID(connectionURL, EsbViewsRepository.DBLookupMediator.Properties.connectionURL);
		EditingUtils.setEEFtype(connectionURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionURLText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionUsernameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionUsername, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionUsernameLabel);
		connectionUsername = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionUsername.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionUsernameData = new GridData(GridData.FILL_HORIZONTAL);
		connectionUsername.setLayoutData(connectionUsernameData);
		connectionUsername.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionUsername,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionUsername.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionUsername,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionUsername.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionUsername.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionUsername, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionUsername.getText()));
				}
			}
		});
		EditingUtils.setID(connectionUsername, EsbViewsRepository.DBLookupMediator.Properties.connectionUsername);
		EditingUtils.setEEFtype(connectionUsername, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionUsername, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionUsernameText

		// End of user code
		return parent;
	}

	
	protected Composite createConnectionPasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.connectionPassword, EsbMessages.DBLookupMediatorPropertiesEditionPart_ConnectionPasswordLabel);
		connectionPassword = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		connectionPassword.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData connectionPasswordData = new GridData(GridData.FILL_HORIZONTAL);
		connectionPassword.setLayoutData(connectionPasswordData);
		connectionPassword.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.connectionPassword,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionPassword.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.connectionPassword,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, connectionPassword.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		connectionPassword.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.connectionPassword, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, connectionPassword.getText()));
				}
			}
		});
		EditingUtils.setID(connectionPassword, EsbViewsRepository.DBLookupMediator.Properties.connectionPassword);
		EditingUtils.setEEFtype(connectionPassword, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.connectionPassword, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createConnectionPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyAutocommitEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyAutocommitLabel);
		propertyAutocommit = new EMFComboViewer(parent);
		propertyAutocommit.setContentProvider(new ArrayContentProvider());
		propertyAutocommit.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyAutocommitData = new GridData(GridData.FILL_HORIZONTAL);
		propertyAutocommit.getCombo().setLayoutData(propertyAutocommitData);
		propertyAutocommit.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyAutocommit()));
			}

		});
		propertyAutocommit.setID(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyAutocommitEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyIsolationEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyIsolationLabel);
		propertyIsolation = new EMFComboViewer(parent);
		propertyIsolation.setContentProvider(new ArrayContentProvider());
		propertyIsolation.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyIsolationData = new GridData(GridData.FILL_HORIZONTAL);
		propertyIsolation.getCombo().setLayoutData(propertyIsolationData);
		propertyIsolation.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyIsolation()));
			}

		});
		propertyIsolation.setID(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyIsolationEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyMaxactiveText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyMaxactiveLabel);
		propertyMaxactive = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyMaxactive.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyMaxactiveData = new GridData(GridData.FILL_HORIZONTAL);
		propertyMaxactive.setLayoutData(propertyMaxactiveData);
		propertyMaxactive.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxactive.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyMaxactive.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyMaxactive.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxactive.getText()));
				}
			}
		});
		EditingUtils.setID(propertyMaxactive, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive);
		EditingUtils.setEEFtype(propertyMaxactive, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyMaxactiveText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyMaxidleText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyMaxidleLabel);
		propertyMaxidle = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyMaxidle.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyMaxidleData = new GridData(GridData.FILL_HORIZONTAL);
		propertyMaxidle.setLayoutData(propertyMaxidleData);
		propertyMaxidle.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxidle.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyMaxidle.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyMaxidle.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxidle.getText()));
				}
			}
		});
		EditingUtils.setID(propertyMaxidle, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle);
		EditingUtils.setEEFtype(propertyMaxidle, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyMaxidleText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyMaxopenstatementsText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyMaxopenstatementsLabel);
		propertyMaxopenstatements = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyMaxopenstatements.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyMaxopenstatementsData = new GridData(GridData.FILL_HORIZONTAL);
		propertyMaxopenstatements.setLayoutData(propertyMaxopenstatementsData);
		propertyMaxopenstatements.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxopenstatements.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyMaxopenstatements.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyMaxopenstatements.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxopenstatements.getText()));
				}
			}
		});
		EditingUtils.setID(propertyMaxopenstatements, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements);
		EditingUtils.setEEFtype(propertyMaxopenstatements, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyMaxopenstatementsText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyMaxwaitText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyMaxwaitLabel);
		propertyMaxwait = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyMaxwait.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyMaxwaitData = new GridData(GridData.FILL_HORIZONTAL);
		propertyMaxwait.setLayoutData(propertyMaxwaitData);
		propertyMaxwait.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxwait.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyMaxwait.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyMaxwait.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMaxwait.getText()));
				}
			}
		});
		EditingUtils.setID(propertyMaxwait, EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait);
		EditingUtils.setEEFtype(propertyMaxwait, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyMaxwaitText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyMinidleText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyMinidleLabel);
		propertyMinidle = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyMinidle.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyMinidleData = new GridData(GridData.FILL_HORIZONTAL);
		propertyMinidle.setLayoutData(propertyMinidleData);
		propertyMinidle.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMinidle.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyMinidle.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyMinidle.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyMinidle.getText()));
				}
			}
		});
		EditingUtils.setID(propertyMinidle, EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle);
		EditingUtils.setEEFtype(propertyMinidle, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyMinidleText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyPoolstatementsEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyPoolstatementsLabel);
		propertyPoolstatements = new EMFComboViewer(parent);
		propertyPoolstatements.setContentProvider(new ArrayContentProvider());
		propertyPoolstatements.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyPoolstatementsData = new GridData(GridData.FILL_HORIZONTAL);
		propertyPoolstatements.getCombo().setLayoutData(propertyPoolstatementsData);
		propertyPoolstatements.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyPoolstatements()));
			}

		});
		propertyPoolstatements.setID(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyPoolstatementsEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyTestonborrowEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyTestonborrowLabel);
		propertyTestonborrow = new EMFComboViewer(parent);
		propertyTestonborrow.setContentProvider(new ArrayContentProvider());
		propertyTestonborrow.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyTestonborrowData = new GridData(GridData.FILL_HORIZONTAL);
		propertyTestonborrow.getCombo().setLayoutData(propertyTestonborrowData);
		propertyTestonborrow.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyTestonborrow()));
			}

		});
		propertyTestonborrow.setID(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyTestonborrowEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyTestwhileidleEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyTestwhileidleLabel);
		propertyTestwhileidle = new EMFComboViewer(parent);
		propertyTestwhileidle.setContentProvider(new ArrayContentProvider());
		propertyTestwhileidle.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData propertyTestwhileidleData = new GridData(GridData.FILL_HORIZONTAL);
		propertyTestwhileidle.getCombo().setLayoutData(propertyTestwhileidleData);
		propertyTestwhileidle.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPropertyTestwhileidle()));
			}

		});
		propertyTestwhileidle.setID(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyTestwhileidleEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyValidationqueryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyValidationqueryLabel);
		propertyValidationquery = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyValidationquery.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyValidationqueryData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValidationquery.setLayoutData(propertyValidationqueryData);
		propertyValidationquery.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValidationquery.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyValidationquery.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyValidationquery.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValidationquery.getText()));
				}
			}
		});
		EditingUtils.setID(propertyValidationquery, EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery);
		EditingUtils.setEEFtype(propertyValidationquery, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValidationqueryText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyInitialsizeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize, EsbMessages.DBLookupMediatorPropertiesEditionPart_PropertyInitialsizeLabel);
		propertyInitialsize = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyInitialsize.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyInitialsizeData = new GridData(GridData.FILL_HORIZONTAL);
		propertyInitialsize.setLayoutData(propertyInitialsizeData);
		propertyInitialsize.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DBLookupMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyInitialsize.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DBLookupMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyInitialsize.getText()));
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
									DBLookupMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyInitialsize.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyInitialsize.getText()));
				}
			}
		});
		EditingUtils.setID(propertyInitialsize, EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize);
		EditingUtils.setEEFtype(propertyInitialsize, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyInitialsizeText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSqlStatementsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.sqlStatements = new ReferencesTable(getDescription(EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, EsbMessages.DBLookupMediatorPropertiesEditionPart_SqlStatementsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				sqlStatements.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				sqlStatements.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				sqlStatements.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				sqlStatements.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.sqlStatementsFilters) {
			this.sqlStatements.addFilter(filter);
		}
		this.sqlStatements.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, EsbViewsRepository.FORM_KIND));
		this.sqlStatements.createControls(parent, widgetFactory);
		this.sqlStatements.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DBLookupMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DBLookupMediator.Properties.sqlStatements, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData sqlStatementsData = new GridData(GridData.FILL_HORIZONTAL);
		sqlStatementsData.horizontalSpan = 3;
		this.sqlStatements.setLayoutData(sqlStatementsData);
		this.sqlStatements.setLowerBound(0);
		this.sqlStatements.setUpperBound(-1);
		sqlStatements.setID(EsbViewsRepository.DBLookupMediator.Properties.sqlStatements);
		sqlStatements.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createSqlStatementsTableComposition

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionType()
	 * 
	 */
	public Enumerator getConnectionType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) connectionType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initConnectionType(Object input, Enumerator current)
	 */
	public void initConnectionType(Object input, Enumerator current) {
		connectionType.setInput(input);
		connectionType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionType);
		if (eefElementEditorReadOnlyState && connectionType.isEnabled()) {
			connectionType.setEnabled(false);
			connectionType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionType.isEnabled()) {
			connectionType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionType(Enumerator newValue)
	 * 
	 */
	public void setConnectionType(Enumerator newValue) {
		connectionType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionType);
		if (eefElementEditorReadOnlyState && connectionType.isEnabled()) {
			connectionType.setEnabled(false);
			connectionType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionType.isEnabled()) {
			connectionType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionDsType()
	 * 
	 */
	public Enumerator getConnectionDsType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) connectionDsType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initConnectionDsType(Object input, Enumerator current)
	 */
	public void initConnectionDsType(Object input, Enumerator current) {
		connectionDsType.setInput(input);
		connectionDsType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDsType);
		if (eefElementEditorReadOnlyState && connectionDsType.isEnabled()) {
			connectionDsType.setEnabled(false);
			connectionDsType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDsType.isEnabled()) {
			connectionDsType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionDsType(Enumerator newValue)
	 * 
	 */
	public void setConnectionDsType(Enumerator newValue) {
		connectionDsType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDsType);
		if (eefElementEditorReadOnlyState && connectionDsType.isEnabled()) {
			connectionDsType.setEnabled(false);
			connectionDsType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDsType.isEnabled()) {
			connectionDsType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionDbType()
	 * 
	 */
	public Enumerator getConnectionDbType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) connectionDbType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initConnectionDbType(Object input, Enumerator current)
	 */
	public void initConnectionDbType(Object input, Enumerator current) {
		connectionDbType.setInput(input);
		connectionDbType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDbType);
		if (eefElementEditorReadOnlyState && connectionDbType.isEnabled()) {
			connectionDbType.setEnabled(false);
			connectionDbType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDbType.isEnabled()) {
			connectionDbType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionDbType(Enumerator newValue)
	 * 
	 */
	public void setConnectionDbType(Enumerator newValue) {
		connectionDbType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDbType);
		if (eefElementEditorReadOnlyState && connectionDbType.isEnabled()) {
			connectionDbType.setEnabled(false);
			connectionDbType.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDbType.isEnabled()) {
			connectionDbType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionDbDriver()
	 * 
	 */
	public String getConnectionDbDriver() {
		return connectionDbDriver.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionDbDriver(String newValue)
	 * 
	 */
	public void setConnectionDbDriver(String newValue) {
		if (newValue != null) {
			connectionDbDriver.setText(newValue);
		} else {
			connectionDbDriver.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDbDriver);
		if (eefElementEditorReadOnlyState && connectionDbDriver.isEnabled()) {
			connectionDbDriver.setEnabled(false);
			connectionDbDriver.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDbDriver.isEnabled()) {
			connectionDbDriver.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionDsInitialContext()
	 * 
	 */
	public String getConnectionDsInitialContext() {
		return connectionDsInitialContext.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionDsInitialContext(String newValue)
	 * 
	 */
	public void setConnectionDsInitialContext(String newValue) {
		if (newValue != null) {
			connectionDsInitialContext.setText(newValue);
		} else {
			connectionDsInitialContext.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDsInitialContext);
		if (eefElementEditorReadOnlyState && connectionDsInitialContext.isEnabled()) {
			connectionDsInitialContext.setEnabled(false);
			connectionDsInitialContext.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDsInitialContext.isEnabled()) {
			connectionDsInitialContext.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionDsName()
	 * 
	 */
	public String getConnectionDsName() {
		return connectionDsName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionDsName(String newValue)
	 * 
	 */
	public void setConnectionDsName(String newValue) {
		if (newValue != null) {
			connectionDsName.setText(newValue);
		} else {
			connectionDsName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionDsName);
		if (eefElementEditorReadOnlyState && connectionDsName.isEnabled()) {
			connectionDsName.setEnabled(false);
			connectionDsName.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionDsName.isEnabled()) {
			connectionDsName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionURL()
	 * 
	 */
	public String getConnectionURL() {
		return connectionURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionURL(String newValue)
	 * 
	 */
	public void setConnectionURL(String newValue) {
		if (newValue != null) {
			connectionURL.setText(newValue);
		} else {
			connectionURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionURL);
		if (eefElementEditorReadOnlyState && connectionURL.isEnabled()) {
			connectionURL.setEnabled(false);
			connectionURL.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionURL.isEnabled()) {
			connectionURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionUsername()
	 * 
	 */
	public String getConnectionUsername() {
		return connectionUsername.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionUsername(String newValue)
	 * 
	 */
	public void setConnectionUsername(String newValue) {
		if (newValue != null) {
			connectionUsername.setText(newValue);
		} else {
			connectionUsername.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionUsername);
		if (eefElementEditorReadOnlyState && connectionUsername.isEnabled()) {
			connectionUsername.setEnabled(false);
			connectionUsername.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionUsername.isEnabled()) {
			connectionUsername.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getConnectionPassword()
	 * 
	 */
	public String getConnectionPassword() {
		return connectionPassword.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setConnectionPassword(String newValue)
	 * 
	 */
	public void setConnectionPassword(String newValue) {
		if (newValue != null) {
			connectionPassword.setText(newValue);
		} else {
			connectionPassword.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.connectionPassword);
		if (eefElementEditorReadOnlyState && connectionPassword.isEnabled()) {
			connectionPassword.setEnabled(false);
			connectionPassword.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !connectionPassword.isEnabled()) {
			connectionPassword.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyAutocommit()
	 * 
	 */
	public Enumerator getPropertyAutocommit() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyAutocommit.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initPropertyAutocommit(Object input, Enumerator current)
	 */
	public void initPropertyAutocommit(Object input, Enumerator current) {
		propertyAutocommit.setInput(input);
		propertyAutocommit.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit);
		if (eefElementEditorReadOnlyState && propertyAutocommit.isEnabled()) {
			propertyAutocommit.setEnabled(false);
			propertyAutocommit.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyAutocommit.isEnabled()) {
			propertyAutocommit.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyAutocommit(Enumerator newValue)
	 * 
	 */
	public void setPropertyAutocommit(Enumerator newValue) {
		propertyAutocommit.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit);
		if (eefElementEditorReadOnlyState && propertyAutocommit.isEnabled()) {
			propertyAutocommit.setEnabled(false);
			propertyAutocommit.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyAutocommit.isEnabled()) {
			propertyAutocommit.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyIsolation()
	 * 
	 */
	public Enumerator getPropertyIsolation() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyIsolation.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initPropertyIsolation(Object input, Enumerator current)
	 */
	public void initPropertyIsolation(Object input, Enumerator current) {
		propertyIsolation.setInput(input);
		propertyIsolation.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation);
		if (eefElementEditorReadOnlyState && propertyIsolation.isEnabled()) {
			propertyIsolation.setEnabled(false);
			propertyIsolation.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyIsolation.isEnabled()) {
			propertyIsolation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyIsolation(Enumerator newValue)
	 * 
	 */
	public void setPropertyIsolation(Enumerator newValue) {
		propertyIsolation.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation);
		if (eefElementEditorReadOnlyState && propertyIsolation.isEnabled()) {
			propertyIsolation.setEnabled(false);
			propertyIsolation.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyIsolation.isEnabled()) {
			propertyIsolation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyMaxactive()
	 * 
	 */
	public String getPropertyMaxactive() {
		return propertyMaxactive.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyMaxactive(String newValue)
	 * 
	 */
	public void setPropertyMaxactive(String newValue) {
		if (newValue != null) {
			propertyMaxactive.setText(newValue);
		} else {
			propertyMaxactive.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive);
		if (eefElementEditorReadOnlyState && propertyMaxactive.isEnabled()) {
			propertyMaxactive.setEnabled(false);
			propertyMaxactive.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyMaxactive.isEnabled()) {
			propertyMaxactive.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyMaxidle()
	 * 
	 */
	public String getPropertyMaxidle() {
		return propertyMaxidle.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyMaxidle(String newValue)
	 * 
	 */
	public void setPropertyMaxidle(String newValue) {
		if (newValue != null) {
			propertyMaxidle.setText(newValue);
		} else {
			propertyMaxidle.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle);
		if (eefElementEditorReadOnlyState && propertyMaxidle.isEnabled()) {
			propertyMaxidle.setEnabled(false);
			propertyMaxidle.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyMaxidle.isEnabled()) {
			propertyMaxidle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyMaxopenstatements()
	 * 
	 */
	public String getPropertyMaxopenstatements() {
		return propertyMaxopenstatements.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyMaxopenstatements(String newValue)
	 * 
	 */
	public void setPropertyMaxopenstatements(String newValue) {
		if (newValue != null) {
			propertyMaxopenstatements.setText(newValue);
		} else {
			propertyMaxopenstatements.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements);
		if (eefElementEditorReadOnlyState && propertyMaxopenstatements.isEnabled()) {
			propertyMaxopenstatements.setEnabled(false);
			propertyMaxopenstatements.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyMaxopenstatements.isEnabled()) {
			propertyMaxopenstatements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyMaxwait()
	 * 
	 */
	public String getPropertyMaxwait() {
		return propertyMaxwait.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyMaxwait(String newValue)
	 * 
	 */
	public void setPropertyMaxwait(String newValue) {
		if (newValue != null) {
			propertyMaxwait.setText(newValue);
		} else {
			propertyMaxwait.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait);
		if (eefElementEditorReadOnlyState && propertyMaxwait.isEnabled()) {
			propertyMaxwait.setEnabled(false);
			propertyMaxwait.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyMaxwait.isEnabled()) {
			propertyMaxwait.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyMinidle()
	 * 
	 */
	public String getPropertyMinidle() {
		return propertyMinidle.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyMinidle(String newValue)
	 * 
	 */
	public void setPropertyMinidle(String newValue) {
		if (newValue != null) {
			propertyMinidle.setText(newValue);
		} else {
			propertyMinidle.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle);
		if (eefElementEditorReadOnlyState && propertyMinidle.isEnabled()) {
			propertyMinidle.setEnabled(false);
			propertyMinidle.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyMinidle.isEnabled()) {
			propertyMinidle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyPoolstatements()
	 * 
	 */
	public Enumerator getPropertyPoolstatements() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyPoolstatements.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initPropertyPoolstatements(Object input, Enumerator current)
	 */
	public void initPropertyPoolstatements(Object input, Enumerator current) {
		propertyPoolstatements.setInput(input);
		propertyPoolstatements.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements);
		if (eefElementEditorReadOnlyState && propertyPoolstatements.isEnabled()) {
			propertyPoolstatements.setEnabled(false);
			propertyPoolstatements.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyPoolstatements.isEnabled()) {
			propertyPoolstatements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyPoolstatements(Enumerator newValue)
	 * 
	 */
	public void setPropertyPoolstatements(Enumerator newValue) {
		propertyPoolstatements.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements);
		if (eefElementEditorReadOnlyState && propertyPoolstatements.isEnabled()) {
			propertyPoolstatements.setEnabled(false);
			propertyPoolstatements.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyPoolstatements.isEnabled()) {
			propertyPoolstatements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyTestonborrow()
	 * 
	 */
	public Enumerator getPropertyTestonborrow() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyTestonborrow.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initPropertyTestonborrow(Object input, Enumerator current)
	 */
	public void initPropertyTestonborrow(Object input, Enumerator current) {
		propertyTestonborrow.setInput(input);
		propertyTestonborrow.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow);
		if (eefElementEditorReadOnlyState && propertyTestonborrow.isEnabled()) {
			propertyTestonborrow.setEnabled(false);
			propertyTestonborrow.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyTestonborrow.isEnabled()) {
			propertyTestonborrow.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyTestonborrow(Enumerator newValue)
	 * 
	 */
	public void setPropertyTestonborrow(Enumerator newValue) {
		propertyTestonborrow.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow);
		if (eefElementEditorReadOnlyState && propertyTestonborrow.isEnabled()) {
			propertyTestonborrow.setEnabled(false);
			propertyTestonborrow.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyTestonborrow.isEnabled()) {
			propertyTestonborrow.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyTestwhileidle()
	 * 
	 */
	public Enumerator getPropertyTestwhileidle() {
		Enumerator selection = (Enumerator) ((StructuredSelection) propertyTestwhileidle.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initPropertyTestwhileidle(Object input, Enumerator current)
	 */
	public void initPropertyTestwhileidle(Object input, Enumerator current) {
		propertyTestwhileidle.setInput(input);
		propertyTestwhileidle.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle);
		if (eefElementEditorReadOnlyState && propertyTestwhileidle.isEnabled()) {
			propertyTestwhileidle.setEnabled(false);
			propertyTestwhileidle.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyTestwhileidle.isEnabled()) {
			propertyTestwhileidle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyTestwhileidle(Enumerator newValue)
	 * 
	 */
	public void setPropertyTestwhileidle(Enumerator newValue) {
		propertyTestwhileidle.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle);
		if (eefElementEditorReadOnlyState && propertyTestwhileidle.isEnabled()) {
			propertyTestwhileidle.setEnabled(false);
			propertyTestwhileidle.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyTestwhileidle.isEnabled()) {
			propertyTestwhileidle.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyValidationquery()
	 * 
	 */
	public String getPropertyValidationquery() {
		return propertyValidationquery.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyValidationquery(String newValue)
	 * 
	 */
	public void setPropertyValidationquery(String newValue) {
		if (newValue != null) {
			propertyValidationquery.setText(newValue);
		} else {
			propertyValidationquery.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery);
		if (eefElementEditorReadOnlyState && propertyValidationquery.isEnabled()) {
			propertyValidationquery.setEnabled(false);
			propertyValidationquery.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValidationquery.isEnabled()) {
			propertyValidationquery.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#getPropertyInitialsize()
	 * 
	 */
	public String getPropertyInitialsize() {
		return propertyInitialsize.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#setPropertyInitialsize(String newValue)
	 * 
	 */
	public void setPropertyInitialsize(String newValue) {
		if (newValue != null) {
			propertyInitialsize.setText(newValue);
		} else {
			propertyInitialsize.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize);
		if (eefElementEditorReadOnlyState && propertyInitialsize.isEnabled()) {
			propertyInitialsize.setEnabled(false);
			propertyInitialsize.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyInitialsize.isEnabled()) {
			propertyInitialsize.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#initSqlStatements(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSqlStatements(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		sqlStatements.setContentProvider(contentProvider);
		sqlStatements.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DBLookupMediator.Properties.sqlStatements);
		if (eefElementEditorReadOnlyState && sqlStatements.isEnabled()) {
			sqlStatements.setEnabled(false);
			sqlStatements.setToolTipText(EsbMessages.DBLookupMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sqlStatements.isEnabled()) {
			sqlStatements.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#updateSqlStatements()
	 * 
	 */
	public void updateSqlStatements() {
	sqlStatements.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#addFilterSqlStatements(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSqlStatements(ViewerFilter filter) {
		sqlStatementsFilters.add(filter);
		if (this.sqlStatements != null) {
			this.sqlStatements.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#addBusinessFilterSqlStatements(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSqlStatements(ViewerFilter filter) {
		sqlStatementsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart#isContainedInSqlStatementsTable(EObject element)
	 * 
	 */
	public boolean isContainedInSqlStatementsTable(EObject element) {
		return ((ReferencesTableSettings)sqlStatements.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DBLookupMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
