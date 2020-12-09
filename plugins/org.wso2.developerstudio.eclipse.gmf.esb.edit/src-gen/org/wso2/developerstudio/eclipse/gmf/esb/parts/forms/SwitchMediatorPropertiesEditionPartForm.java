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
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class SwitchMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SwitchMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text source;
	protected Text namespace;
	protected Text namespacePrefix;
	protected ReferencesTable caseBranches;
	protected List<ViewerFilter> caseBranchesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> caseBranchesFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for sourceXPath widgets declarations
    protected NamespacedProperty sourceXPath;
    protected Text sourceXPathText;
    protected Control[] descriptionElements;
    protected Control[] completionTimeoutElements;
    protected Control[] sourceTextElements;
    protected Control[] nameSpaceTextElements;
    protected Control[] nameSpacePrefixElements;
    protected Control[] completionMaxMessagesValueElements;
    protected Control[] caseBranchesElements;
    protected Control[] sourceXPathElements;
    protected Composite propertiesGroup;
    protected GridData caseBranchesData;
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public SwitchMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SwitchMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence switchMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = switchMediatorStep.addStep(EsbViewsRepository.SwitchMediator.Properties.class);
		// Start of user code  
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.sourceXPath);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.source);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.namespace);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.namespacePrefix);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.caseBranches);
		propertiesStep.addStep(EsbViewsRepository.SwitchMediator.Properties.description);
        // End of user code
		
		composer = new PartComposer(switchMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.SwitchMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.source) {
					return createSourceText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.namespace) {
					return createNamespaceText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.namespacePrefix) {
					return createNamespacePrefixText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.SwitchMediator.Properties.caseBranches) {
					return createCaseBranchesTableComposition(widgetFactory, parent);
				}
				// Start of user code for sourceXPath addToPart creation
                if(key == EsbViewsRepository.SwitchMediator.Properties.sourceXPath) {
                    return createSourceXPathWidget(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.SwitchMediatorPropertiesEditionPart_PropertiesGroupLabel);
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

    /**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.SwitchMediator.Properties.description, EsbMessages.SwitchMediatorPropertiesEditionPart_DescriptionLabel);
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
							SwitchMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SwitchMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SwitchMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SwitchMediator.Properties.description,
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
									SwitchMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.SwitchMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {itemLabel, description, itemHelp};
        
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
		EditingUtils.setID(commentsList, EsbViewsRepository.SwitchMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SwitchMediator.Properties.commentsList, EsbMessages.SwitchMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "SwitchMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.SwitchMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.SwitchMediator.Properties.reverse, EsbMessages.SwitchMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.SwitchMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSourceText(FormToolkit widgetFactory, Composite parent) {
		Control itemLabel = createDescription(parent, EsbViewsRepository.SwitchMediator.Properties.source, EsbMessages.SwitchMediatorPropertiesEditionPart_SourceLabel);
		source = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		source.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SwitchMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SwitchMediator.Properties.source,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SwitchMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SwitchMediator.Properties.source,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, source.getText()));
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
									SwitchMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		source.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
				}
			}
		});
		EditingUtils.setID(source, EsbViewsRepository.SwitchMediator.Properties.source);
		EditingUtils.setEEFtype(source, "eef::Text"); //$NON-NLS-1$
		Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.source, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceText
		sourceTextElements = new Control[] {itemLabel, source, itemHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNamespaceText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SwitchMediator.Properties.namespace, EsbMessages.SwitchMediatorPropertiesEditionPart_NamespaceLabel);
		namespace = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		namespace.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData namespaceData = new GridData(GridData.FILL_HORIZONTAL);
		namespace.setLayoutData(namespaceData);
		namespace.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SwitchMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SwitchMediator.Properties.namespace,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SwitchMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SwitchMediator.Properties.namespace,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, namespace.getText()));
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
									SwitchMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		namespace.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.namespace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespace.getText()));
				}
			}
		});
		EditingUtils.setID(namespace, EsbViewsRepository.SwitchMediator.Properties.namespace);
		EditingUtils.setEEFtype(namespace, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.namespace, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespaceText

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNamespacePrefixText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.SwitchMediator.Properties.namespacePrefix, EsbMessages.SwitchMediatorPropertiesEditionPart_NamespacePrefixLabel);
		namespacePrefix = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		namespacePrefix.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData namespacePrefixData = new GridData(GridData.FILL_HORIZONTAL);
		namespacePrefix.setLayoutData(namespacePrefixData);
		namespacePrefix.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SwitchMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.SwitchMediator.Properties.namespacePrefix,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SwitchMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.SwitchMediator.Properties.namespacePrefix,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, namespacePrefix.getText()));
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
									SwitchMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		namespacePrefix.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.namespacePrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, namespacePrefix.getText()));
				}
			}
		});
		EditingUtils.setID(namespacePrefix, EsbViewsRepository.SwitchMediator.Properties.namespacePrefix);
		EditingUtils.setEEFtype(namespacePrefix, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.namespacePrefix, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNamespacePrefixText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 *
     * @generated NOT
	 */
	protected Composite createCaseBranchesTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control[] previousControls = propertiesGroup.getChildren();
		this.caseBranches = new ReferencesTable(getDescription(EsbViewsRepository.SwitchMediator.Properties.caseBranches, EsbMessages.SwitchMediatorPropertiesEditionPart_CaseBranchesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.caseBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				caseBranches.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.caseBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				caseBranches.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.caseBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				caseBranches.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.caseBranches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				caseBranches.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.caseBranchesFilters) {
			this.caseBranches.addFilter(filter);
		}
		this.caseBranches.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.caseBranches, EsbViewsRepository.FORM_KIND));
		this.caseBranches.createControls(parent, widgetFactory);
		this.caseBranches.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.caseBranches, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		
		caseBranchesData = new GridData(GridData.FILL_HORIZONTAL);
		caseBranchesData.horizontalSpan = 3;
		this.caseBranches.setLayoutData(caseBranchesData);
		this.caseBranches.setLowerBound(0);
		this.caseBranches.setUpperBound(-1);
		caseBranches.setID(EsbViewsRepository.SwitchMediator.Properties.caseBranches);
		caseBranches.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCaseBranchesTableComposition
		//caseBranchesElements = new Control [] {caseBranches.getTable()};
		Control[] newControls = propertiesGroup.getChildren();
		caseBranchesElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getSource()
	 * 
	 */
	public String getSource() {
		return source.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setSource(String newValue)
	 * 
	 */
	public void setSource(String newValue) {
		if (newValue != null) {
			source.setText(newValue);
		} else {
			source.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getNamespace()
	 * 
	 */
	public String getNamespace() {
		return namespace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setNamespace(String newValue)
	 * 
	 */
	public void setNamespace(String newValue) {
		if (newValue != null) {
			namespace.setText(newValue);
		} else {
			namespace.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.namespace);
		if (eefElementEditorReadOnlyState && namespace.isEnabled()) {
			namespace.setEnabled(false);
			namespace.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespace.isEnabled()) {
			namespace.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#getNamespacePrefix()
	 * 
	 */
	public String getNamespacePrefix() {
		return namespacePrefix.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#setNamespacePrefix(String newValue)
	 * 
	 */
	public void setNamespacePrefix(String newValue) {
		if (newValue != null) {
			namespacePrefix.setText(newValue);
		} else {
			namespacePrefix.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.namespacePrefix);
		if (eefElementEditorReadOnlyState && namespacePrefix.isEnabled()) {
			namespacePrefix.setEnabled(false);
			namespacePrefix.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !namespacePrefix.isEnabled()) {
			namespacePrefix.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#initCaseBranches(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCaseBranches(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		caseBranches.setContentProvider(contentProvider);
		caseBranches.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.SwitchMediator.Properties.caseBranches);
		if (eefElementEditorReadOnlyState && caseBranches.isEnabled()) {
			caseBranches.setEnabled(false);
			caseBranches.setToolTipText(EsbMessages.SwitchMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !caseBranches.isEnabled()) {
			caseBranches.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#updateCaseBranches()
	 * 
	 */
	public void updateCaseBranches() {
	caseBranches.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#addFilterCaseBranches(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCaseBranches(ViewerFilter filter) {
		caseBranchesFilters.add(filter);
		if (this.caseBranches != null) {
			this.caseBranches.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#addBusinessFilterCaseBranches(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCaseBranches(ViewerFilter filter) {
		caseBranchesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart#isContainedInCaseBranchesTable(EObject element)
	 * 
	 */
	public boolean isContainedInCaseBranchesTable(EObject element) {
		return ((ReferencesTableSettings)caseBranches.getInput()).contains(element);
	}






	// Start of user code for sourceXPath specific getters and setters implementation
    @Override
    public NamespacedProperty getSourceXPath() {
        // TODO Auto-generated method stub
        return sourceXPath;
    }

    @Override
    public void setSourceXPath(NamespacedProperty nameSpacedProperty) {
        if(nameSpacedProperty != null) {
            sourceXPathText.setText(nameSpacedProperty.getPropertyValue());
            sourceXPath = nameSpacedProperty;
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
		return EsbMessages.SwitchMediator_Part_Title;
	}



	// Start of user code additional methods
   protected Composite createSourceXPathWidget(FormToolkit widgetFactory, final Composite parent) {
       Control itemLabel = createDescription(parent, EsbViewsRepository.SwitchMediator.Properties.sourceXPath, EsbMessages.SwitchMediatorPropertiesEditionPart_SourceXPathLabel);
       widgetFactory.paintBordersFor(parent);
       if(sourceXPath == null) {
           sourceXPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
       } 
       String initValueExpression = sourceXPath.getPropertyValue().isEmpty() ? "/default/expression" : sourceXPath.getPropertyValue();
       sourceXPathText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
       sourceXPathText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
       widgetFactory.paintBordersFor(parent);
       GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
       sourceXPathText.setLayoutData(valueData);

       sourceXPathText.addMouseListener(new MouseAdapter() {
           
           @Override
           public void mouseDown( MouseEvent event ) {
               openSourceXPathWidgetNamespacedPropertyEditor(parent);
           }
           
       });
       
       sourceXPathText.addKeyListener(new KeyListener() {
                       
           @Override
           public void keyPressed(KeyEvent e) {
           }
           
           @Override
           public void keyReleased(KeyEvent e) {
               if(!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                   openSourceXPathWidgetNamespacedPropertyEditor(parent);
               }
           }
           
       });
       
       EditingUtils.setID(sourceXPathText, EsbViewsRepository.SwitchMediator.Properties.sourceXPath);
       EditingUtils.setEEFtype(sourceXPathText, "eef::Text");
       Control itemHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.SwitchMediator.Properties.sourceXPath, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
       sourceXPathElements = new Control[] {itemLabel, sourceXPathText, itemHelp};
       return parent;
    }
   
    private void openSourceXPathWidgetNamespacedPropertyEditor(final Composite parent) {
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                sourceXPath);
        sourceXPath = nspd.open();
        sourceXPathText.setText(sourceXPath.getPropertyValue());
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                SwitchMediatorPropertiesEditionPartForm.this, EsbViewsRepository.SwitchMediator.Properties.sourceXPath,
                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceXPath()));
    }
   
   @Override
   public void refresh() {
       super.refresh();
       validate();
   }

   public void validate() {
       EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
       epv.clearElements(new Composite[] { propertiesGroup });

       epv.showEntry(descriptionElements, false);
       epv.showEntry(sourceXPathElements, false);
       epv.showEntry(caseBranchesElements, false);
       epv.clearTableButtons(caseBranchesElements);
       view.layout(true, true);
   }
	// End of user code


}
