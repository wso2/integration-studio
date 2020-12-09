/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
    import org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class SequencesPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SequencesPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text name;
	protected Button recieveSequence;
	protected Text associatedProxy;
	protected Button editAssociatedProxy;
	protected EList associatedProxyList;
	protected ReferencesTable templateParameters;
	protected List<ViewerFilter> templateParametersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> templateParametersFilters = new ArrayList<ViewerFilter>();
	protected Button traceEnabled;
	protected Button statisticsEnabled;
	protected GridData templateParametersData;
	// Start of user code  for onError widgets declarations
    protected RegistryKeyProperty onError;
    protected Text onErrorText;
    
    protected Control[] onErrorElements;
    protected Control[] nameElements;
    protected Control[] traceEnabledElements;
    protected Control[] staticsEnabledElements;
    protected Control[] createTemplateParameterElements;
 
    protected Composite propertiesGroup;
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public SequencesPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SequencesPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 *
	 * @generated NOT
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
		CompositionSequence sequencesStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = sequencesStep.addStep(EsbViewsRepository.Sequences.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.name);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.recieveSequence);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.associatedProxy);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.templateParameters);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.traceEnabled);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.statisticsEnabled);
		propertiesStep.addStep(EsbViewsRepository.Sequences.Properties.onError);
		
		
		composer = new PartComposer(sequencesStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Sequences.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.recieveSequence) {
					return createRecieveSequenceCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.associatedProxy) {
					return createAssociatedProxyMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.templateParameters) {
					return createTemplateParametersTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.traceEnabled) {
					return createTraceEnabledCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Sequences.Properties.statisticsEnabled) {
					return createStatisticsEnabledCheckbox(widgetFactory, parent);
				}
				// Start of user code for onError addToPart creation
				if (key == EsbViewsRepository.Sequences.Properties.onError) {
					return createOnError(widgetFactory, parent);
				}
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}
	
	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.SequencesPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}
	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Sequences.Properties.description, EsbMessages.SequencesPropertiesEditionPart_DescriptionLabel);
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
							SequencesPropertiesEditionPartForm.this,
							EsbViewsRepository.Sequences.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SequencesPropertiesEditionPartForm.this,
									EsbViewsRepository.Sequences.Properties.description,
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
									SequencesPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.Sequences.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.Sequences.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequences.Properties.commentsList, EsbMessages.SequencesPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "Sequences", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.Sequences.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		Control nameLabel = createDescription(parent, EsbViewsRepository.Sequences.Properties.name, EsbMessages.SequencesPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SequencesPropertiesEditionPartForm.this,
							EsbViewsRepository.Sequences.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SequencesPropertiesEditionPartForm.this,
									EsbViewsRepository.Sequences.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
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
									SequencesPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EsbViewsRepository.Sequences.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		Control nameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.name, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText
		nameElements = new Control[] { nameLabel, name, nameHelp };
		// End of user code
		return parent;
	}

	
	protected Composite createRecieveSequenceCheckbox(FormToolkit widgetFactory, Composite parent) {
		recieveSequence = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequences.Properties.recieveSequence, EsbMessages.SequencesPropertiesEditionPart_RecieveSequenceLabel), SWT.CHECK);
		recieveSequence.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.recieveSequence, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(recieveSequence.getSelection())));
			}

		});
		GridData recieveSequenceData = new GridData(GridData.FILL_HORIZONTAL);
		recieveSequenceData.horizontalSpan = 2;
		recieveSequence.setLayoutData(recieveSequenceData);
		EditingUtils.setID(recieveSequence, EsbViewsRepository.Sequences.Properties.recieveSequence);
		EditingUtils.setEEFtype(recieveSequence, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.recieveSequence, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRecieveSequenceCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAssociatedProxyMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		associatedProxy = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData associatedProxyData = new GridData(GridData.FILL_HORIZONTAL);
		associatedProxyData.horizontalSpan = 2;
		associatedProxy.setLayoutData(associatedProxyData);
		EditingUtils.setID(associatedProxy, EsbViewsRepository.Sequences.Properties.associatedProxy);
		EditingUtils.setEEFtype(associatedProxy, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editAssociatedProxy = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequences.Properties.associatedProxy, EsbMessages.SequencesPropertiesEditionPart_AssociatedProxyLabel), SWT.NONE);
		GridData editAssociatedProxyData = new GridData();
		editAssociatedProxy.setLayoutData(editAssociatedProxyData);
		editAssociatedProxy.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						associatedProxy.getShell(), "Sequences", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						associatedProxyList, EsbPackage.eINSTANCE.getSequences_AssociatedProxy().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					associatedProxyList = dialog.getResult();
					if (associatedProxyList == null) {
						associatedProxyList = new BasicEList();
					}
					associatedProxy.setText(associatedProxyList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.associatedProxy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(associatedProxyList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editAssociatedProxy, EsbViewsRepository.Sequences.Properties.associatedProxy);
		EditingUtils.setEEFtype(editAssociatedProxy, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createAssociatedProxyMultiValuedEditor

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTemplateParametersTableComposition(FormToolkit widgetFactory, Composite parent) {
		Control[] previousControls = propertiesGroup.getChildren();
		this.templateParameters = new ReferencesTable(getDescription(EsbViewsRepository.Sequences.Properties.templateParameters, EsbMessages.SequencesPropertiesEditionPart_TemplateParametersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				templateParameters.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				templateParameters.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				templateParameters.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.templateParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				templateParameters.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.templateParametersFilters) {
			this.templateParameters.addFilter(filter);
		}
		this.templateParameters.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.templateParameters, EsbViewsRepository.FORM_KIND));
		this.templateParameters.createControls(parent, widgetFactory);
		this.templateParameters.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.templateParameters, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		templateParametersData = new GridData(GridData.FILL_HORIZONTAL);
		templateParametersData.horizontalSpan = 3;
		this.templateParameters.setLayoutData(templateParametersData);
		this.templateParameters.setLowerBound(0);
		this.templateParameters.setUpperBound(-1);
		templateParameters.setID(EsbViewsRepository.Sequences.Properties.templateParameters);
		templateParameters.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTemplateParametersTableComposition
		Control[] newControls = propertiesGroup.getChildren();
		createTemplateParameterElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createTraceEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		traceEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequences.Properties.traceEnabled, EsbMessages.SequencesPropertiesEditionPart_TraceEnabledLabel), SWT.CHECK);
		traceEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.traceEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(traceEnabled.getSelection())));
			}

		});
		GridData traceEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		traceEnabledData.horizontalSpan = 2;
		traceEnabled.setLayoutData(traceEnabledData);
		EditingUtils.setID(traceEnabled, EsbViewsRepository.Sequences.Properties.traceEnabled);
		EditingUtils.setEEFtype(traceEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control traceEnabledHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.traceEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTraceEnabledCheckbox
		traceEnabledElements = new Control[] { traceEnabled, traceEnabledHelp };
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createStatisticsEnabledCheckbox(FormToolkit widgetFactory, Composite parent) {
		statisticsEnabled = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.Sequences.Properties.statisticsEnabled, EsbMessages.SequencesPropertiesEditionPart_StatisticsEnabledLabel), SWT.CHECK);
		statisticsEnabled.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SequencesPropertiesEditionPartForm.this, EsbViewsRepository.Sequences.Properties.statisticsEnabled, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(statisticsEnabled.getSelection())));
			}

		});
		GridData statisticsEnabledData = new GridData(GridData.FILL_HORIZONTAL);
		statisticsEnabledData.horizontalSpan = 2;
		statisticsEnabled.setLayoutData(statisticsEnabledData);
		EditingUtils.setID(statisticsEnabled, EsbViewsRepository.Sequences.Properties.statisticsEnabled);
		EditingUtils.setEEFtype(statisticsEnabled, "eef::Checkbox"); //$NON-NLS-1$
		Control statEnableHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.statisticsEnabled, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatisticsEnabledCheckbox
		staticsEnabledElements = new Control[] { statisticsEnabled, statEnableHelp };
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.Sequences_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getRecieveSequence()
	 * 
	 */
	public Boolean getRecieveSequence() {
		return Boolean.valueOf(recieveSequence.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setRecieveSequence(Boolean newValue)
	 * 
	 */
	public void setRecieveSequence(Boolean newValue) {
		if (newValue != null) {
			recieveSequence.setSelection(newValue.booleanValue());
		} else {
			recieveSequence.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.recieveSequence);
		if (eefElementEditorReadOnlyState && recieveSequence.isEnabled()) {
			recieveSequence.setEnabled(false);
			recieveSequence.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !recieveSequence.isEnabled()) {
			recieveSequence.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getAssociatedProxy()
	 * 
	 */
	public EList getAssociatedProxy() {
		return associatedProxyList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setAssociatedProxy(EList newValue)
	 * 
	 */
	public void setAssociatedProxy(EList newValue) {
		associatedProxyList = newValue;
		if (newValue != null) {
			associatedProxy.setText(associatedProxyList.toString());
		} else {
			associatedProxy.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.associatedProxy);
		if (eefElementEditorReadOnlyState && associatedProxy.isEnabled()) {
			associatedProxy.setEnabled(false);
			associatedProxy.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !associatedProxy.isEnabled()) {
			associatedProxy.setEnabled(true);
		}	
		
	}

	public void addToAssociatedProxy(Object newValue) {
		associatedProxyList.add(newValue);
		if (newValue != null) {
			associatedProxy.setText(associatedProxyList.toString());
		} else {
			associatedProxy.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToAssociatedProxy(Object newValue) {
		associatedProxyList.remove(newValue);
		if (newValue != null) {
			associatedProxy.setText(associatedProxyList.toString());
		} else {
			associatedProxy.setText(""); //$NON-NLS-1$
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#initTemplateParameters(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTemplateParameters(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		templateParameters.setContentProvider(contentProvider);
		templateParameters.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.templateParameters);
		if (eefElementEditorReadOnlyState && templateParameters.isEnabled()) {
			templateParameters.setEnabled(false);
			templateParameters.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !templateParameters.isEnabled()) {
			templateParameters.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#updateTemplateParameters()
	 * 
	 */
	public void updateTemplateParameters() {
	templateParameters.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#addFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersFilters.add(filter);
		if (this.templateParameters != null) {
			this.templateParameters.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#addBusinessFilterTemplateParameters(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter) {
		templateParametersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#isContainedInTemplateParametersTable(EObject element)
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element) {
		return ((ReferencesTableSettings)templateParameters.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getTraceEnabled()
	 * 
	 */
	public Boolean getTraceEnabled() {
		return Boolean.valueOf(traceEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setTraceEnabled(Boolean newValue)
	 * 
	 */
	public void setTraceEnabled(Boolean newValue) {
		if (newValue != null) {
			traceEnabled.setSelection(newValue.booleanValue());
		} else {
			traceEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.traceEnabled);
		if (eefElementEditorReadOnlyState && traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(false);
			traceEnabled.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !traceEnabled.isEnabled()) {
			traceEnabled.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#getStatisticsEnabled()
	 * 
	 */
	public Boolean getStatisticsEnabled() {
		return Boolean.valueOf(statisticsEnabled.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart#setStatisticsEnabled(Boolean newValue)
	 * 
	 */
	public void setStatisticsEnabled(Boolean newValue) {
		if (newValue != null) {
			statisticsEnabled.setSelection(newValue.booleanValue());
		} else {
			statisticsEnabled.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Sequences.Properties.statisticsEnabled);
		if (eefElementEditorReadOnlyState && statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(false);
			statisticsEnabled.setToolTipText(EsbMessages.Sequences_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statisticsEnabled.isEnabled()) {
			statisticsEnabled.setEnabled(true);
		}	
		
	}






	// Start of user code for onError specific getters and setters implementation
	@Override
    public RegistryKeyProperty getOnError() {
        return onError;
    }

    @Override
    public void setOnError(RegistryKeyProperty registryKeyProperty) {
        if(registryKeyProperty != null) {
            onErrorText.setText(registryKeyProperty.getKeyValue());
            onError = registryKeyProperty;
        }
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Sequences_Part_Title;
	}

	// Start of user code additional methods

    /**
     * @generated NOT
     */
	protected Composite createOnError(FormToolkit widgetFactory, Composite parent) {
		Control onErrorLabel = createDescription(parent,
				EsbViewsRepository.Sequences.Properties.onError,
				EsbMessages.SequencesPropertiesEditionPart_OnErrorLabel);
		widgetFactory.paintBordersFor(parent);
		if (onError == null) {
			onError = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		}
		String initValueExpression = onError.getKeyValue().isEmpty() ? "" : onError.getKeyValue();
		onErrorText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
		onErrorText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		onErrorText.setLayoutData(valueData);
		onErrorText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent event ) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                onErrorText.setText(onError.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        SequencesPropertiesEditionPartForm.this,
                        EsbViewsRepository.Sequences.Properties.onError, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getOnError()));
            }

        });

		onErrorText.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, onError, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    onErrorText.setText(onError.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            SequencesPropertiesEditionPartForm.this,
                            EsbViewsRepository.Sequences.Properties.onError, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getOnError()));
                }
            }
        });
		EditingUtils.setID(onErrorText, EsbViewsRepository.Sequences.Properties.onError);
		EditingUtils.setEEFtype(onErrorText, "eef::Text");
		Control onErrorHelp = FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(EsbViewsRepository.Sequences.Properties.onError,
						EsbViewsRepository.FORM_KIND),
				null); // $NON-NLS-1$
		onErrorElements = new Control[] { onErrorLabel, onErrorText, onErrorHelp };
		return parent;
	}
	
	@Override
    public void refresh() {
        super.refresh();
        validate();
    }

	EEFPropertyViewUtil viewUtil = new EEFPropertyViewUtil(view);
	
    public void validate() {
    	
    	viewUtil.clearElements(new Composite[] { propertiesGroup });
    	/*for (Control control : propertiesGroup.getChildren()) {
    		if (!(control instanceof Composite)) {
    			viewUtil.clearElement(control);
    		}
    	}*/

        // Hide the sequence properties if the parent component is Template sequence
        EObject container = null;
        try {
            container = propertiesEditionComponent.getEditingContext().getEObject().eContainer();
        } catch (Exception e) {
            log.error(e);
        }
        if (!(container instanceof org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateImpl)) {
            viewUtil.showEntry(nameElements, false);
            viewUtil.showEntry(onErrorElements, false);
            viewUtil.showEntry(traceEnabledElements, false);
            viewUtil.showEntry(staticsEnabledElements, false);
        }
        view.layout(true, true);
    }

	// End of user code


}
