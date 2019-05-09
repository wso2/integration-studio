/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.EList;

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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
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
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.eclipse.gmf.esb.util.FontUtils;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class PayloadFactoryMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, PayloadFactoryMediatorPropertiesEditionPart {

    /**
     * Default payload value for XML media type
     */
    private final static String INITIAL_XML_PAYLOAD = "<inline/>";
    
	protected EMFComboViewer payloadFormat;
	// Start of user code  for payloadKey widgets declarations
	protected Control[] payloadFormatElements;
	protected Control[] payloadElements;
	protected Control[] mediaTypeElements;
	protected Control[] descriptionElements;
	protected Control[] payloadKeyElements;
	protected Control[] argsTableElements;
	
	protected RegistryKeyProperty payloadKey;
	protected Text payloadKeyText;
	protected Composite propertiesGroup;
	
	protected Composite filterPayloadSubPropertiesGroup;
	// End of user code

	protected Text payload;
	protected ReferencesTable args;
	protected List<ViewerFilter> argsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> argsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer mediaType;
	protected Text description;



	protected Text commentsList;
    protected Button editCommentsList;
    protected EList commentsListList;



  protected Button reverse;



  /**
	 * For {@link ISection} use only.
	 */
	public PayloadFactoryMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PayloadFactoryMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence payloadFactoryMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = payloadFactoryMediatorStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.class);
		// Start of user code
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		propertiesStep.addStep(EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		// End of user code
		
		composer = new PartComposer(payloadFactoryMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code for components addToPart creation
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat) {
					return createPayloadFormatEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey) {
					return createPayloadKey(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.payload) {
					return createPayloadText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.args) {
					return createArgsTableComposition(widgetFactory, filterPayloadSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType) {
					return createMediaTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.PayloadFactoryMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				// End of user code
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
		propertiesSection.setText(EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createPayloadFormatEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control payloadFormatLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadFormatLabel);
		payloadFormat = new EMFComboViewer(parent, SWT.SCROLL_LOCK);
		payloadFormat.setContentProvider(new ArrayContentProvider());
		payloadFormat.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData payloadFormatData = new GridData(GridData.FILL_HORIZONTAL);
		payloadFormat.getCombo().setLayoutData(payloadFormatData);
		payloadFormat.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadFormat()));
			}

		});
		payloadFormat.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		Control payloadFormatHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadFormatEMFComboViewer
		payloadFormatElements = new Control[] {payloadFormatLabel, payloadFormat.getCombo(), payloadFormatHelp};
		payloadFormat.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
                refresh();
            }
        });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createPayloadText(FormToolkit widgetFactory, Composite parent) {
        filterPayloadSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Payload",
                true);
		Control payloadLabel = createDescription(filterPayloadSubPropertiesGroup, EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadLabel);
		payload = widgetFactory.createText(filterPayloadSubPropertiesGroup, "", SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL); //$NON-NLS-1$
		payload.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(filterPayloadSubPropertiesGroup);
		GridData payloadData = new GridData(GridData.FILL_HORIZONTAL);
		payloadData.heightHint = payload.getLineHeight()*4;
		payload.setLayoutData(payloadData);
		payload.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							PayloadFactoryMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PayloadFactoryMediator.Properties.payload,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payload.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.PayloadFactoryMediator.Properties.payload,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, payload.getText()));
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
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});

		EditingUtils.setID(payload, EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		EditingUtils.setEEFtype(payload, "eef::Text"); //$NON-NLS-1$
		Control payloadHelp = FormUtils.createHelpButton(widgetFactory, filterPayloadSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payload, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadText
		payloadElements = new Control[] {payloadLabel, payload, payloadHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createArgsTableComposition(FormToolkit widgetFactory, Composite parent) {
	    Control[] previousControls = filterPayloadSubPropertiesGroup.getChildren();
		this.args = new ReferencesTable(getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_ArgsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				args.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				args.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				args.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				args.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.argsFilters) {
			this.args.addFilter(filter);
		}
		this.args.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.args, EsbViewsRepository.FORM_KIND));
		this.args.createControls(parent, widgetFactory);
		this.args.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.args, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData argsData = new GridData(GridData.FILL_HORIZONTAL);
		argsData.horizontalSpan = 3;
		this.args.setLayoutData(argsData);
		this.args.setLowerBound(0);
		this.args.setUpperBound(-1);
		this.args.getTable().setFont(FontUtils.getMonospacedFont());
		args.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		args.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createArgsTableComposition
        Control[] newControls = filterPayloadSubPropertiesGroup.getChildren();
        argsTableElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createMediaTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control mediaTypeLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_MediaTypeLabel);
		mediaType = new EMFComboViewer(parent, SWT.SCROLL_LOCK);
		mediaType.setContentProvider(new ArrayContentProvider());
		mediaType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData mediaTypeData = new GridData(GridData.FILL_HORIZONTAL);
		mediaType.getCombo().setLayoutData(mediaTypeData);
		mediaType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null) {
				    validate();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getMediaType()));
			
				}
			}

		});
		mediaType.setID(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		Control mediaTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMediaTypeEMFComboViewer
		mediaTypeElements = new Control[] {mediaTypeLabel, mediaType.getCombo(), mediaTypeHelp};
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_DescriptionLabel);
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
							PayloadFactoryMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.PayloadFactoryMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.PayloadFactoryMediator.Properties.description,
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
									PayloadFactoryMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control[] {descriptionLabel, description, descriptionHelp};
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
    EditingUtils.setID(commentsList, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
    EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
    editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
            commentsList.getShell(), "PayloadFactoryMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
            commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
            false, true, 
            null, null);
        if (dialog.open() == Window.OK) {
          commentsListList = dialog.getResult();
          if (commentsListList == null) {
            commentsListList = new BasicEList();
          }
          commentsList.setText(commentsListList.toString());
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
          setHasChanged(true);
        }
      }
    });
    EditingUtils.setID(editCommentsList, EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
    EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
    // Start of user code for createCommentsListMultiValuedEditor

    // End of user code
    return parent;
  }

  protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
    reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
    reverse.addSelectionListener(new SelectionAdapter() {

      /**
       * {@inheritDoc}
       *
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       * 	
       */
      public void widgetSelected(SelectionEvent e) {
        if (propertiesEditionComponent != null)
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
      }

    });
    GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
    reverseData.horizontalSpan = 2;
    reverse.setLayoutData(reverseData);
    EditingUtils.setID(reverse, EsbViewsRepository.PayloadFactoryMediator.Properties.reverse);
    EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
    FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
    // Start of user code for createReverseCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayloadFormat()
	 * 
	 */
	public Enumerator getPayloadFormat() {
		Enumerator selection = (Enumerator) ((StructuredSelection) payloadFormat.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initPayloadFormat(Object input, Enumerator current)
	 */
	public void initPayloadFormat(Object input, Enumerator current) {
		payloadFormat.setInput(input);
		payloadFormat.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		if (eefElementEditorReadOnlyState && payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(false);
			payloadFormat.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayloadFormat(Enumerator newValue)
	 * 
	 */
	public void setPayloadFormat(Enumerator newValue) {
		payloadFormat.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadFormat);
		if (eefElementEditorReadOnlyState && payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(false);
			payloadFormat.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadFormat.isEnabled()) {
			payloadFormat.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getPayload()
	 * 
	 */
	public String getPayload() {
		return payload.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setPayload(String newValue)
	 * 
	 */
	public void setPayload(String newValue) {
		if (newValue != null) {
			payload.setText(newValue);
		} else {
			payload.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.payload);
		if (eefElementEditorReadOnlyState && payload.isEnabled()) {
			payload.setEnabled(false);
			payload.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payload.isEnabled()) {
			payload.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initArgs(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initArgs(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		args.setContentProvider(contentProvider);
		args.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.args);
		if (eefElementEditorReadOnlyState && args.isEnabled()) {
			args.setEnabled(false);
			args.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !args.isEnabled()) {
			args.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#updateArgs()
	 * 
	 */
	public void updateArgs() {
	args.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addFilterArgs(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArgs(ViewerFilter filter) {
		argsFilters.add(filter);
		if (this.args != null) {
			this.args.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#addBusinessFilterArgs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArgs(ViewerFilter filter) {
		argsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#isContainedInArgsTable(EObject element)
	 * 
	 */
	public boolean isContainedInArgsTable(EObject element) {
		return ((ReferencesTableSettings)args.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getMediaType()
	 * 
	 */
	public Enumerator getMediaType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) mediaType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#initMediaType(Object input, Enumerator current)
	 */
	public void initMediaType(Object input, Enumerator current) {
		mediaType.setInput(input);
		mediaType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		if (eefElementEditorReadOnlyState && mediaType.isEnabled()) {
			mediaType.setEnabled(false);
			mediaType.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediaType.isEnabled()) {
			mediaType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setMediaType(Enumerator newValue)
	 * 
	 */
	public void setMediaType(Enumerator newValue) {
		mediaType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.mediaType);
		if (eefElementEditorReadOnlyState && mediaType.isEnabled()) {
			mediaType.setEnabled(false);
			mediaType.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !mediaType.isEnabled()) {
			mediaType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getCommentsList()
   * 
   */
  public EList getCommentsList() {
    return commentsListList;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setCommentsList(EList newValue)
   * 
   */
  public void setCommentsList(EList newValue) {
    commentsListList = newValue;
    if (newValue != null) {
      commentsList.setText(commentsListList.toString());
    } else {
      commentsList.setText(""); //$NON-NLS-1$
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.commentsList);
    if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
      commentsList.setEnabled(false);
      commentsList.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
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
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#getReverse()
   * 
   */
  public Boolean getReverse() {
    return Boolean.valueOf(reverse.getSelection());
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.PayloadFactoryMediatorPropertiesEditionPart#setReverse(Boolean newValue)
   * 
   */
  public void setReverse(Boolean newValue) {
    if (newValue != null) {
      reverse.setSelection(newValue.booleanValue());
    } else {
      reverse.setSelection(false);
    }
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.PayloadFactoryMediator.Properties.reverse);
    if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
      reverse.setEnabled(false);
      reverse.setToolTipText(EsbMessages.PayloadFactoryMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
      reverse.setEnabled(true);
    }	
    
  }

  // Start of user code for payloadKey specific getters and setters implementation
	@Override
	public void setPayloadKey(RegistryKeyProperty registryKeyProperty) {
		if (payloadKey != null) {
			payloadKey = registryKeyProperty;
			payloadKeyText.setText(registryKeyProperty.getKeyValue());
		}
	}

	@Override
	public RegistryKeyProperty getPayloadKey() {
		return payloadKey;
	}
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.PayloadFactoryMediator_Part_Title;
	}

	// Start of user code additional methods
    protected Composite createPayloadKey(FormToolkit widgetFactory, final Composite parent) {
        Control payloadKeyLabel = createDescription(parent, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, EsbMessages.PayloadFactoryMediatorPropertiesEditionPart_PayloadKeyLabel);
        widgetFactory.paintBordersFor(parent);
        if(payloadKey == null) {
            payloadKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        } 
        String initPayloadKey = payloadKey.getKeyValue().isEmpty() ? "" : payloadKey.getKeyValue();
        payloadKeyText = widgetFactory.createText(parent, initPayloadKey);
        payloadKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        payloadKeyText.setLayoutData(valueData);
        payloadKeyText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				EEFRegistryKeyPropertyEditorDialog dialog = new  EEFRegistryKeyPropertyEditorDialog(parent.getShell(), SWT.NULL,
                        payloadKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                payloadKeyText.setText(payloadKey.getKeyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadKey()));
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        EditingUtils.setID(payloadKeyText, EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey);
        EditingUtils.setEEFtype(payloadKeyText, "eef::Text");
        Control payloadKeyHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryMediator.Properties.payloadKey, EsbViewsRepository.FORM_KIND), null);
        payloadKeyElements = new Control[] {payloadKeyLabel, payloadKeyText, payloadKeyHelp};
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }
    
    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });

        eu.showEntry(new Control[] { filterPayloadSubPropertiesGroup.getParent() }, false);
        eu.clearElements(new Composite[] { filterPayloadSubPropertiesGroup });

        eu.showEntry(payloadFormatElements, false);
        eu.showEntry(argsTableElements, false);
        
        // Sets a default XML value. If not, parsing to XML fails and is unable to load the source view
        if (getMediaType().getName().equals(MediaType.XML.getName()) && getPayload().equals("")) {
            setPayload(INITIAL_XML_PAYLOAD);
            propertiesEditionComponent.firePropertiesChanged(
                    new PropertiesEditionEvent(PayloadFactoryMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.PayloadFactoryMediator.Properties.payload, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, INITIAL_XML_PAYLOAD));
        }

        if (getPayloadFormat().getName().equals(PayloadFormatType.INLINE.getName())) {
            eu.showEntry(payloadElements, false);

        } else if (getPayloadFormat().getName().equals(PayloadFormatType.REGISTRY_REFERENCE.getName())) {
            eu.showEntry(payloadKeyElements, false);
        }

        eu.showEntry(mediaTypeElements, false);
        eu.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
	
	// End of user code


}
