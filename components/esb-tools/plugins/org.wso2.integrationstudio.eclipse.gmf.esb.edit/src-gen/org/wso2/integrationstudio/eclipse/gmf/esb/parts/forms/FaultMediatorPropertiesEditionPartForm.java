/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultStringType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class FaultMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, FaultMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer soapVersion;
	protected Button serializeResponse;
	protected Button markAsResponse;
	protected EMFComboViewer faultCodeSoap11;
	protected EMFComboViewer faultCodeType;
	protected EMFComboViewer faultStringType;
	protected Text faultStringValue;
	protected Text faultActor;
	protected EMFComboViewer faultCodeSoap12;
	protected EMFComboViewer faultReasonType;
	protected Text faultReasonValue;
	protected Text roleName;
	protected Text nodeName;
	protected EMFComboViewer faultDetailType;
	protected Text faultDetailValue;
	// Start of user code for faultStringExpression widgets declarations
    protected NamespacedProperty faultStringExpression;
    protected Text faultStringExpressionText;
    protected Control[] faultStringElements;
    // End of user code

	// Start of user code for faultCodeExpression widgets declarations
    protected NamespacedProperty faultCodeExpression;
    protected Text faultCodeExpressionText;
    protected Control[] faultCodeElements;
    // End of user code

	// Start of user code  for faultDetailExpression widgets declarations
	protected NamespacedProperty faultDetailExpression;
    protected Text faultDetailExpressionText;
    protected Control [] faultDetailElements;
    // End of user code

	// Start of user code  for faultReasonExpression widgets declarations
    protected NamespacedProperty faultReasonExpression;
    protected Text faultReasonExpressionText;
    protected Control [] faultReasonElements;
	// End of user code

    // Start of user code  
    Composite propertiesGroup;
    protected Control[] FaultDetailValueElements;
    protected Control[] faultDetailTypeElements;
    protected Control[] nodeNameElements;
    protected Control[] roleNameElements;
    protected Control[] faultReasonValueElements;
    protected Control[] faultReasonTypeElements;
    protected Control[] faultCodeSoap12Elements;
    protected Control[] faultActorElements;
    protected Control[] faultStringValueElements;
    protected Control[] faultStringTypeElements;
    protected Control[] faultCodeTypeElements;
    protected Control[] faultCodeSoap11Elements;
    protected Control[] markAsResponseElements;
    protected Control[] serializeResponseElements;
    protected Control[] soapVersionElements;
    protected Control[] descriptionElements;
    
    protected Composite filterDetailSubPropertiesGroup;
    protected Composite filterReasonSubPropertiesGroup;
    // End of user code

	/**
	 * For {@link ISection} use only.
	 */
	public FaultMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FaultMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
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
	 * @generated NOT
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * @generated NOT
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence faultMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = faultMediatorStep.addStep(EsbViewsRepository.FaultMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.soapVersion);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultActor);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.markAsResponse);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.roleName);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.nodeName);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultReasonExpression);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringType);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringValue);
        propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultStringExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.faultCodeExpression);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.FaultMediator.Properties.reverse);
		
		
		composer = new PartComposer(faultMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
			    // Start of user code
				if (key == EsbViewsRepository.FaultMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.soapVersion) {
					return createSoapVersionEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.serializeResponse) {
					return createSerializeResponseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.markAsResponse) {
					return createMarkAsResponseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11) {
					return createFaultCodeSoap11EMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeType) {
					return createFaultCodeTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultStringType) {
					return createFaultStringTypeEMFComboViewer(widgetFactory, filterReasonSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultStringValue) {
					return createFaultStringValueText(widgetFactory, filterReasonSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultActor) {
					return createFaultActorText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12) {
					return createFaultCodeSoap12EMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultReasonType) {
					return createFaultReasonTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultReasonValue) {
					return createFaultReasonValueText(widgetFactory, filterReasonSubPropertiesGroup);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.roleName) {
					return createRoleNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.nodeName) {
					return createNodeNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultDetailType) {
					return createFaultDetailTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.FaultMediator.Properties.faultDetailValue) {
					return createFaultDetailValueText(widgetFactory, filterDetailSubPropertiesGroup);
				}
                if (key == EsbViewsRepository.FaultMediator.Properties.faultStringExpression) {
                    return createFaultStringExpressionText(widgetFactory, filterReasonSubPropertiesGroup);
                }
                if (key == EsbViewsRepository.FaultMediator.Properties.faultCodeExpression) {
                    return createFaultCodeExpressionText(widgetFactory, parent);
                }
				if (key == EsbViewsRepository.FaultMediator.Properties.faultDetailExpression) {
                    return createFaultDetailExpressionText(widgetFactory, filterDetailSubPropertiesGroup);
                }
				if (key == EsbViewsRepository.FaultMediator.Properties.faultReasonExpression) {
                    return createFaultReasonExpressionText(widgetFactory, filterReasonSubPropertiesGroup);
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
		propertiesSection.setText(EsbMessages.FaultMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		Control descriptionLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.description, EsbMessages.FaultMediatorPropertiesEditionPart_DescriptionLabel);
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
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.description,
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
									FaultMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.FaultMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		Control descriptionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText
		descriptionElements = new Control [] {descriptionLabel, descriptionHelp, description};
		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.FaultMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FaultMediator.Properties.commentsList, EsbMessages.FaultMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "FaultMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.FaultMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FaultMediator.Properties.reverse, EsbMessages.FaultMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.FaultMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createSoapVersionEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control soapVersionLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.soapVersion, EsbMessages.FaultMediatorPropertiesEditionPart_SoapVersionLabel);
		soapVersion = new EMFComboViewer(parent);
		soapVersion.setContentProvider(new ArrayContentProvider());
		soapVersion.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData soapVersionData = new GridData(GridData.FILL_HORIZONTAL);
		soapVersion.getCombo().setLayoutData(soapVersionData);
                soapVersion.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		soapVersion.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.soapVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSoapVersion()));
			}

		});
		soapVersion.setID(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		Control soapVersionHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.soapVersion, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapVersionEMFComboViewer
		soapVersionElements = new Control [] { soapVersionLabel, soapVersion.getCombo(), soapVersionHelp };
        soapVersion.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createSerializeResponseCheckbox(FormToolkit widgetFactory, Composite parent) {
		serializeResponse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FaultMediator.Properties.serializeResponse, EsbMessages.FaultMediatorPropertiesEditionPart_SerializeResponseLabel), SWT.CHECK);
		serializeResponse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.serializeResponse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(serializeResponse.getSelection())));
			}

		});
		GridData serializeResponseData = new GridData(GridData.FILL_HORIZONTAL);
		serializeResponseData.horizontalSpan = 2;
		serializeResponse.setLayoutData(serializeResponseData);
		EditingUtils.setID(serializeResponse, EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		EditingUtils.setEEFtype(serializeResponse, "eef::Checkbox"); //$NON-NLS-1$
		Control serializeResponseHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.serializeResponse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSerializeResponseCheckbox
		serializeResponseElements = new Control [] {serializeResponse, serializeResponseHelp};
	      serializeResponse.addSelectionListener(new SelectionAdapter() {

	            /**
	             * {@inheritDoc}
	             *
	             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	             *  
	             */
	            public void widgetSelected(SelectionEvent e) {
	                refresh();
	            }

	        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createMarkAsResponseCheckbox(FormToolkit widgetFactory, Composite parent) {
		markAsResponse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.FaultMediator.Properties.markAsResponse, EsbMessages.FaultMediatorPropertiesEditionPart_MarkAsResponseLabel), SWT.CHECK);
		markAsResponse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.markAsResponse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(markAsResponse.getSelection())));
			}

		});
		GridData markAsResponseData = new GridData(GridData.FILL_HORIZONTAL);
		markAsResponseData.horizontalSpan = 2;
		markAsResponse.setLayoutData(markAsResponseData);
		EditingUtils.setID(markAsResponse, EsbViewsRepository.FaultMediator.Properties.markAsResponse);
		EditingUtils.setEEFtype(markAsResponse, "eef::Checkbox"); //$NON-NLS-1$
		Control markAsResponseHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.markAsResponse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMarkAsResponseCheckbox
		markAsResponseElements = new Control [] {markAsResponse, markAsResponseHelp};
        markAsResponse.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
              refresh();
            }

        });
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFaultCodeSoap11EMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control faultCodeSoapLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, EsbMessages.FaultMediatorPropertiesEditionPart_FaultCodeSoap11Label);
		faultCodeSoap11 = new EMFComboViewer(parent);
		faultCodeSoap11.setContentProvider(new ArrayContentProvider());
		faultCodeSoap11.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeSoap11Data = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeSoap11.getCombo().setLayoutData(faultCodeSoap11Data);
                faultCodeSoap11.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeSoap11.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeSoap11()));
			}

		});
		faultCodeSoap11.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		Control faultCodeSoapHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeSoap11EMFComboViewer
		faultCodeSoap11Elements = new Control [] {faultCodeSoapLabel, faultCodeSoapHelp, faultCodeSoap11.getCombo()};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFaultCodeTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		Control faultCodeTypeLabel = createDescription(parent, null, "Fault CodeType");
		faultCodeType = new EMFComboViewer(parent);
		faultCodeType.setContentProvider(new ArrayContentProvider());
		faultCodeType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeType.getCombo().setLayoutData(faultCodeTypeData);
                faultCodeType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultCodeType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeType()));
			}

		});
		faultCodeType.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		Control faultCodeTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeTypeEMFComboViewer
		faultCodeTypeElements = new Control [] {faultCodeTypeLabel, faultCodeTypeHelp, faultCodeType.getCombo()};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFaultStringTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control faultStringTypeLabel = createDescription(parent, null, "Type");
		faultStringType = new EMFComboViewer(parent);
		faultStringType.setContentProvider(new ArrayContentProvider());
		faultStringType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultStringTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultStringType.getCombo().setLayoutData(faultStringTypeData);
                faultStringType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultStringType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultStringType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultStringType()));
			}

		});
		faultStringType.setID(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		Control faultStringTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultStringType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultStringTypeEMFComboViewer
		faultStringTypeElements = new Control [] {faultStringTypeLabel, faultStringTypeHelp, faultStringType.getCombo()};
	    faultStringType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createFaultStringValueText(FormToolkit widgetFactory, Composite parent) {
	    Control faultStringValueLabel = createDescription(parent, null, "Value");
		faultStringValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultStringValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultStringValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultStringValue.setLayoutData(faultStringValueData);
		faultStringValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.faultStringValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultStringValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.faultStringValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultStringValue.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultStringValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultStringValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultStringValue.getText()));
				}
			}
		});
		EditingUtils.setID(faultStringValue, EsbViewsRepository.FaultMediator.Properties.faultStringValue);
		EditingUtils.setEEFtype(faultStringValue, "eef::Text"); //$NON-NLS-1$
		Control faultStringValueHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultStringValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultStringValueText
		faultStringValueElements = new Control [] {faultStringValueLabel, faultStringValue, faultStringValueHelp};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */	
	protected Composite createFaultActorText(FormToolkit widgetFactory, Composite parent) {
	    Control faultActorLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultActor, EsbMessages.FaultMediatorPropertiesEditionPart_FaultActorLabel);
		faultActor = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultActor.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultActorData = new GridData(GridData.FILL_HORIZONTAL);
		faultActor.setLayoutData(faultActorData);
		faultActor.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.faultActor,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultActor.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.faultActor,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultActor.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultActor.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultActor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultActor.getText()));
				}
			}
		});
		EditingUtils.setID(faultActor, EsbViewsRepository.FaultMediator.Properties.faultActor);
		EditingUtils.setEEFtype(faultActor, "eef::Text"); //$NON-NLS-1$
		Control faultActorHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultActor, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultActorText
		faultActorElements = new Control [] {faultActorLabel, faultActorHelp, faultActor};
		// End of user code
		return parent;
	}

	
    /**
     * @generated NOT
     */
	protected Composite createFaultCodeSoap12EMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    Control faultCodeSoap12Label = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, EsbMessages.FaultMediatorPropertiesEditionPart_FaultCodeSoap12Label);
		faultCodeSoap12 = new EMFComboViewer(parent);
		faultCodeSoap12.setContentProvider(new ArrayContentProvider());
		faultCodeSoap12.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultCodeSoap12Data = new GridData(GridData.FILL_HORIZONTAL);
		faultCodeSoap12.getCombo().setLayoutData(faultCodeSoap12Data);
                faultCodeSoap12.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultCodeSoap12.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultCodeSoap12()));
			}

		});
		faultCodeSoap12.setID(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		Control faultCodeSoap12Help = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultCodeSoap12EMFComboViewer
		faultCodeSoap12Elements = new Control [] {faultCodeSoap12Label, faultCodeSoap12Help, faultCodeSoap12.getCombo()};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFaultReasonTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterReasonSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Reason", true);
	    Control faultReasonTypeLabel = createDescription(filterReasonSubPropertiesGroup, null, "Type");
		faultReasonType = new EMFComboViewer(filterReasonSubPropertiesGroup);
		faultReasonType.setContentProvider(new ArrayContentProvider());
		faultReasonType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultReasonTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultReasonType.getCombo().setLayoutData(faultReasonTypeData);
                faultReasonType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultReasonType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultReasonType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultReasonType()));
			}

		});
		faultReasonType.setID(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		Control faultReasonTypeHelp = FormUtils.createHelpButton(widgetFactory, filterReasonSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultReasonType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultReasonTypeEMFComboViewer
		faultReasonTypeElements = new Control[] {faultReasonTypeLabel, faultReasonTypeHelp, faultReasonType.getCombo()};
        faultReasonType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createFaultReasonValueText(FormToolkit widgetFactory, Composite parent) {
	    Control faultReasonValueLabel = createDescription(parent, null, "Value");
		faultReasonValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultReasonValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultReasonValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultReasonValue.setLayoutData(faultReasonValueData);
		faultReasonValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.faultReasonValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultReasonValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.faultReasonValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultReasonValue.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultReasonValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultReasonValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultReasonValue.getText()));
				}
			}
		});
		EditingUtils.setID(faultReasonValue, EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		EditingUtils.setEEFtype(faultReasonValue, "eef::Text"); //$NON-NLS-1$
		Control faultReasonValueHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultReasonValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultReasonValueText
		faultReasonValueElements = new Control [] {faultReasonValueLabel, faultReasonValueHelp, faultReasonValue};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createRoleNameText(FormToolkit widgetFactory, Composite parent) {
	    Control roleNameLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.roleName, EsbMessages.FaultMediatorPropertiesEditionPart_RoleNameLabel);
		roleName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		roleName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData roleNameData = new GridData(GridData.FILL_HORIZONTAL);
		roleName.setLayoutData(roleNameData);
		roleName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.roleName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, roleName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.roleName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, roleName.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		roleName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.roleName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, roleName.getText()));
				}
			}
		});
		EditingUtils.setID(roleName, EsbViewsRepository.FaultMediator.Properties.roleName);
		EditingUtils.setEEFtype(roleName, "eef::Text"); //$NON-NLS-1$
		Control roleNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.roleName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createRoleNameText
		roleNameElements = new Control [] {roleNameLabel, roleNameHelp, roleName};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createNodeNameText(FormToolkit widgetFactory, Composite parent) {
	    Control nodeNameLabel = createDescription(parent, EsbViewsRepository.FaultMediator.Properties.nodeName, EsbMessages.FaultMediatorPropertiesEditionPart_NodeNameLabel);
		nodeName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		nodeName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nodeNameData = new GridData(GridData.FILL_HORIZONTAL);
		nodeName.setLayoutData(nodeNameData);
		nodeName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.nodeName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nodeName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.nodeName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, nodeName.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		nodeName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.nodeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nodeName.getText()));
				}
			}
		});
		EditingUtils.setID(nodeName, EsbViewsRepository.FaultMediator.Properties.nodeName);
		EditingUtils.setEEFtype(nodeName, "eef::Text"); //$NON-NLS-1$
		Control nodeNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.nodeName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNodeNameText
		nodeNameElements = new Control [] {nodeNameLabel, nodeNameHelp, nodeName};
		// End of user code
		return parent;
	}

    /**
     * @generated NOT
     */
	protected Composite createFaultDetailTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
	    filterDetailSubPropertiesGroup = EEFPropertyViewUtil.createSubsectionGroup(widgetFactory, parent, "Detail", true);
	    Control faultDetailTypeLabel = createDescription(filterDetailSubPropertiesGroup, null, "Type");
		faultDetailType = new EMFComboViewer(filterDetailSubPropertiesGroup);
		faultDetailType.setContentProvider(new ArrayContentProvider());
		faultDetailType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData faultDetailTypeData = new GridData(GridData.FILL_HORIZONTAL);
		faultDetailType.getCombo().setLayoutData(faultDetailTypeData);
                faultDetailType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		faultDetailType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultDetailType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFaultDetailType()));
			}

		});
		faultDetailType.setID(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		Control faultDetailTypeHelp = FormUtils.createHelpButton(widgetFactory, filterDetailSubPropertiesGroup, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultDetailType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultDetailTypeEMFComboViewer
		faultDetailTypeElements = new Control [] {faultDetailTypeLabel, faultDetailTypeHelp, faultDetailType.getCombo()};
	      faultDetailType.addSelectionChangedListener(new ISelectionChangedListener() {

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
	protected Composite createFaultDetailValueText(FormToolkit widgetFactory, Composite parent) {
		Control FaultDetailValueLabel = createDescription(parent, null, "Value");
		faultDetailValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		faultDetailValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData faultDetailValueData = new GridData(GridData.FILL_HORIZONTAL);
		faultDetailValue.setLayoutData(faultDetailValueData);
		faultDetailValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							FaultMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.FaultMediator.Properties.faultDetailValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultDetailValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									FaultMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.FaultMediator.Properties.faultDetailValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, faultDetailValue.getText()));
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
									FaultMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		faultDetailValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FaultMediatorPropertiesEditionPartForm.this, EsbViewsRepository.FaultMediator.Properties.faultDetailValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, faultDetailValue.getText()));
				}
			}
		});
		EditingUtils.setID(faultDetailValue, EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		EditingUtils.setEEFtype(faultDetailValue, "eef::Text"); //$NON-NLS-1$
		Control FaultDetailValueHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.FaultMediator.Properties.faultDetailValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFaultDetailValueText
		FaultDetailValueElements = new Control [] {FaultDetailValueLabel, FaultDetailValueHelp, faultDetailValue}; 
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getSoapVersion()
	 * 
	 */
	public Enumerator getSoapVersion() {
		Enumerator selection = (Enumerator) ((StructuredSelection) soapVersion.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initSoapVersion(Object input, Enumerator current)
	 */
	public void initSoapVersion(Object input, Enumerator current) {
		soapVersion.setInput(input);
		soapVersion.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		if (eefElementEditorReadOnlyState && soapVersion.isEnabled()) {
			soapVersion.setEnabled(false);
			soapVersion.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapVersion.isEnabled()) {
			soapVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setSoapVersion(Enumerator newValue)
	 * 
	 */
	public void setSoapVersion(Enumerator newValue) {
		soapVersion.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.soapVersion);
		if (eefElementEditorReadOnlyState && soapVersion.isEnabled()) {
			soapVersion.setEnabled(false);
			soapVersion.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapVersion.isEnabled()) {
			soapVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getSerializeResponse()
	 * 
	 */
	public Boolean getSerializeResponse() {
		return Boolean.valueOf(serializeResponse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setSerializeResponse(Boolean newValue)
	 * 
	 */
	public void setSerializeResponse(Boolean newValue) {
		if (newValue != null) {
			serializeResponse.setSelection(newValue.booleanValue());
		} else {
			serializeResponse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.serializeResponse);
		if (eefElementEditorReadOnlyState && serializeResponse.isEnabled()) {
			serializeResponse.setEnabled(false);
			serializeResponse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serializeResponse.isEnabled()) {
			serializeResponse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getMarkAsResponse()
	 * 
	 */
	public Boolean getMarkAsResponse() {
		return Boolean.valueOf(markAsResponse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setMarkAsResponse(Boolean newValue)
	 * 
	 */
	public void setMarkAsResponse(Boolean newValue) {
		if (newValue != null) {
			markAsResponse.setSelection(newValue.booleanValue());
		} else {
			markAsResponse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.markAsResponse);
		if (eefElementEditorReadOnlyState && markAsResponse.isEnabled()) {
			markAsResponse.setEnabled(false);
			markAsResponse.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !markAsResponse.isEnabled()) {
			markAsResponse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeSoap11()
	 * 
	 */
	public Enumerator getFaultCodeSoap11() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeSoap11.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeSoap11(Object input, Enumerator current)
	 */
	public void initFaultCodeSoap11(Object input, Enumerator current) {
		faultCodeSoap11.setInput(input);
		faultCodeSoap11.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		if (eefElementEditorReadOnlyState && faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(false);
			faultCodeSoap11.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeSoap11(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeSoap11(Enumerator newValue) {
		faultCodeSoap11.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11);
		if (eefElementEditorReadOnlyState && faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(false);
			faultCodeSoap11.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap11.isEnabled()) {
			faultCodeSoap11.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeType()
	 * 
	 */
	public Enumerator getFaultCodeType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeType(Object input, Enumerator current)
	 */
	public void initFaultCodeType(Object input, Enumerator current) {
		faultCodeType.setInput(input);
		faultCodeType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		if (eefElementEditorReadOnlyState && faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(false);
			faultCodeType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeType(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeType(Enumerator newValue) {
		faultCodeType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeType);
		if (eefElementEditorReadOnlyState && faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(false);
			faultCodeType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeType.isEnabled()) {
			faultCodeType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultStringType()
	 * 
	 */
	public Enumerator getFaultStringType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultStringType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultStringType(Object input, Enumerator current)
	 */
	public void initFaultStringType(Object input, Enumerator current) {
		faultStringType.setInput(input);
		faultStringType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		if (eefElementEditorReadOnlyState && faultStringType.isEnabled()) {
			faultStringType.setEnabled(false);
			faultStringType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringType.isEnabled()) {
			faultStringType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultStringType(Enumerator newValue)
	 * 
	 */
	public void setFaultStringType(Enumerator newValue) {
		faultStringType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringType);
		if (eefElementEditorReadOnlyState && faultStringType.isEnabled()) {
			faultStringType.setEnabled(false);
			faultStringType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringType.isEnabled()) {
			faultStringType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultStringValue()
	 * 
	 */
	public String getFaultStringValue() {
		return faultStringValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultStringValue(String newValue)
	 * 
	 */
	public void setFaultStringValue(String newValue) {
		if (newValue != null) {
			faultStringValue.setText(newValue);
		} else {
			faultStringValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultStringValue);
		if (eefElementEditorReadOnlyState && faultStringValue.isEnabled()) {
			faultStringValue.setEnabled(false);
			faultStringValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultStringValue.isEnabled()) {
			faultStringValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultActor()
	 * 
	 */
	public String getFaultActor() {
		return faultActor.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultActor(String newValue)
	 * 
	 */
	public void setFaultActor(String newValue) {
		if (newValue != null) {
			faultActor.setText(newValue);
		} else {
			faultActor.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultActor);
		if (eefElementEditorReadOnlyState && faultActor.isEnabled()) {
			faultActor.setEnabled(false);
			faultActor.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultActor.isEnabled()) {
			faultActor.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultCodeSoap12()
	 * 
	 */
	public Enumerator getFaultCodeSoap12() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultCodeSoap12.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultCodeSoap12(Object input, Enumerator current)
	 */
	public void initFaultCodeSoap12(Object input, Enumerator current) {
		faultCodeSoap12.setInput(input);
		faultCodeSoap12.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		if (eefElementEditorReadOnlyState && faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(false);
			faultCodeSoap12.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultCodeSoap12(Enumerator newValue)
	 * 
	 */
	public void setFaultCodeSoap12(Enumerator newValue) {
		faultCodeSoap12.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12);
		if (eefElementEditorReadOnlyState && faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(false);
			faultCodeSoap12.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultCodeSoap12.isEnabled()) {
			faultCodeSoap12.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultReasonType()
	 * 
	 */
	public Enumerator getFaultReasonType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultReasonType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultReasonType(Object input, Enumerator current)
	 */
	public void initFaultReasonType(Object input, Enumerator current) {
		faultReasonType.setInput(input);
		faultReasonType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		if (eefElementEditorReadOnlyState && faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(false);
			faultReasonType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultReasonType(Enumerator newValue)
	 * 
	 */
	public void setFaultReasonType(Enumerator newValue) {
		faultReasonType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonType);
		if (eefElementEditorReadOnlyState && faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(false);
			faultReasonType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonType.isEnabled()) {
			faultReasonType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultReasonValue()
	 * 
	 */
	public String getFaultReasonValue() {
		return faultReasonValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultReasonValue(String newValue)
	 * 
	 */
	public void setFaultReasonValue(String newValue) {
		if (newValue != null) {
			faultReasonValue.setText(newValue);
		} else {
			faultReasonValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultReasonValue);
		if (eefElementEditorReadOnlyState && faultReasonValue.isEnabled()) {
			faultReasonValue.setEnabled(false);
			faultReasonValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultReasonValue.isEnabled()) {
			faultReasonValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getRoleName()
	 * 
	 */
	public String getRoleName() {
		return roleName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setRoleName(String newValue)
	 * 
	 */
	public void setRoleName(String newValue) {
		if (newValue != null) {
			roleName.setText(newValue);
		} else {
			roleName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.roleName);
		if (eefElementEditorReadOnlyState && roleName.isEnabled()) {
			roleName.setEnabled(false);
			roleName.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !roleName.isEnabled()) {
			roleName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getNodeName()
	 * 
	 */
	public String getNodeName() {
		return nodeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setNodeName(String newValue)
	 * 
	 */
	public void setNodeName(String newValue) {
		if (newValue != null) {
			nodeName.setText(newValue);
		} else {
			nodeName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.nodeName);
		if (eefElementEditorReadOnlyState && nodeName.isEnabled()) {
			nodeName.setEnabled(false);
			nodeName.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !nodeName.isEnabled()) {
			nodeName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultDetailType()
	 * 
	 */
	public Enumerator getFaultDetailType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) faultDetailType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#initFaultDetailType(Object input, Enumerator current)
	 */
	public void initFaultDetailType(Object input, Enumerator current) {
		faultDetailType.setInput(input);
		faultDetailType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		if (eefElementEditorReadOnlyState && faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(false);
			faultDetailType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultDetailType(Enumerator newValue)
	 * 
	 */
	public void setFaultDetailType(Enumerator newValue) {
		faultDetailType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailType);
		if (eefElementEditorReadOnlyState && faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(false);
			faultDetailType.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailType.isEnabled()) {
			faultDetailType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#getFaultDetailValue()
	 * 
	 */
	public String getFaultDetailValue() {
		return faultDetailValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart#setFaultDetailValue(String newValue)
	 * 
	 */
	public void setFaultDetailValue(String newValue) {
		if (newValue != null) {
			faultDetailValue.setText(newValue);
		} else {
			faultDetailValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.FaultMediator.Properties.faultDetailValue);
		if (eefElementEditorReadOnlyState && faultDetailValue.isEnabled()) {
			faultDetailValue.setEnabled(false);
			faultDetailValue.setToolTipText(EsbMessages.FaultMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !faultDetailValue.isEnabled()) {
			faultDetailValue.setEnabled(true);
		}	
		
	}






	// Start of user code for faultStringExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultStringExpression() {
        return faultStringExpression;
    }

    @Override
    public void setFaultStringExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            faultStringExpressionText.setText(nameSpacedProperty.getPropertyValue());
            faultStringExpression = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for faultCodeExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultCodeExpression() {
        return faultCodeExpression;
    }

    @Override
    public void setFaultCodeExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            faultCodeExpressionText.setText(nameSpacedProperty.getPropertyValue());
            faultCodeExpression = nameSpacedProperty;
        }
    }	
	// End of user code

	// Start of user code for faultDetailExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultDetailExpression() {
        return faultDetailExpression;
    }

    @Override
    public void setFaultDetailExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            faultDetailExpressionText.setText(nameSpacedProperty.getPropertyValue());
            faultDetailExpression = nameSpacedProperty;
        }
    }
	// End of user code

	// Start of user code for faultReasonExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getFaultReasonExpression() {
        return faultReasonExpression;
    }

    @Override
    public void setFaultReasonExpression(NamespacedProperty nameSpacedProperty) {
        if (nameSpacedProperty != null) {
            faultReasonExpressionText.setText(nameSpacedProperty.getPropertyValue());
            faultReasonExpression = nameSpacedProperty;
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
		return EsbMessages.FaultMediator_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createFaultDetailExpressionText(FormToolkit widgetFactory, final Composite parent) {
        Control faultDetailExpressionLabel = createDescription(parent, null, "Expression");
        widgetFactory.paintBordersFor(parent);
        if (faultDetailExpression== null) {
            faultDetailExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        String initValueExpression = faultDetailExpression.getPropertyValue().isEmpty() ? ""
                : faultDetailExpression.getPropertyValue();
        faultDetailExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
        faultDetailExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        faultDetailExpressionText.setLayoutData(valueData);
        faultDetailExpressionText.addMouseListener(new MouseListener() {

            @Override
            public void mouseDown(MouseEvent e) {
                EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, faultDetailExpression);
                faultDetailExpression = nspd.open();
                faultDetailExpressionText.setText(faultDetailExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        FaultMediatorPropertiesEditionPartForm.this,
                        EsbViewsRepository.FaultMediator.Properties.faultDetailExpression, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getFaultDetailExpression()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {}
            
            @Override
            public void mouseUp(MouseEvent e) {}
            
        });
        
        faultDetailExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                 if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                     EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                             SWT.NULL, faultDetailExpression);
                     nspd.open();
                     faultDetailExpressionText.setText(faultDetailExpression.getPropertyValue());
                     propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                             FaultMediatorPropertiesEditionPartForm.this,
                             EsbViewsRepository.FaultMediator.Properties.faultDetailExpression, PropertiesEditionEvent.COMMIT,
                             PropertiesEditionEvent.SET, null, getFaultDetailExpression()));
                 }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });

        EditingUtils.setID(faultDetailExpressionText, EsbViewsRepository.FaultMediator.Properties.faultDetailExpression);
        EditingUtils.setEEFtype(faultDetailExpressionText, "eef::Text");
        Control faultDetailExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        EsbViewsRepository.FaultMediator.Properties.faultDetailExpression, EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        faultDetailElements = new Control[] { faultDetailExpressionLabel, faultDetailExpressionText,
                faultDetailExpressionHelp };
        return parent;
    }
	
	   protected Composite createFaultReasonExpressionText(FormToolkit widgetFactory, final Composite parent) {
        Control faultReasonExpressionLabel = createDescription(parent, null, "Expression");
	        widgetFactory.paintBordersFor(parent);
	        if (faultReasonExpression== null) {
	            faultReasonExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
	        }
	        String initValueExpression = faultReasonExpression.getPropertyValue().isEmpty() ? ""
	                : faultReasonExpression.getPropertyValue();
	        faultReasonExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
	        faultReasonExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        widgetFactory.paintBordersFor(parent);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        faultReasonExpressionText.setLayoutData(valueData);
	        faultReasonExpressionText.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseDown(MouseEvent e) {
                    EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, faultReasonExpression);
                    nspd.open();
                    faultReasonExpressionText.setText(faultReasonExpression.getPropertyValue());
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            FaultMediatorPropertiesEditionPartForm.this,
                            EsbViewsRepository.FaultMediator.Properties.faultReasonExpression, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getFaultReasonExpression()));
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {}
	            
	            @Override
                public void mouseUp(MouseEvent e) {}
	            
	        });
	        
	        faultReasonExpressionText.addKeyListener(new KeyListener() {
	            
	            @Override
	            public void keyReleased(KeyEvent e) {
	                 if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
	                     EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
	                             SWT.NULL, faultReasonExpression);
	                     nspd.open();
	                     faultReasonExpressionText.setText(faultReasonExpression.getPropertyValue());
	                     propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
	                             FaultMediatorPropertiesEditionPartForm.this,
	                             EsbViewsRepository.FaultMediator.Properties.faultReasonExpression, PropertiesEditionEvent.COMMIT,
	                             PropertiesEditionEvent.SET, null, getFaultReasonExpression()));
	                 }
	            }
	            
	            @Override
	            public void keyPressed(KeyEvent e) {}
	            
	        });

	        EditingUtils.setID(faultReasonExpressionText, EsbViewsRepository.FaultMediator.Properties.faultReasonExpression);
	        EditingUtils.setEEFtype(faultReasonExpressionText, "eef::Text");
	        Control faultReasonExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
	                propertiesEditionComponent.getHelpContent(
	                        EsbViewsRepository.FaultMediator.Properties.faultReasonExpression, EsbViewsRepository.FORM_KIND),
	                null); // $NON-NLS-1$
	        faultReasonElements = new Control[] { faultReasonExpressionLabel, faultReasonExpressionText,
	                faultReasonExpressionHelp };
	        return parent;
	    }
	   
    protected Composite createFaultStringExpressionText(FormToolkit widgetFactory, final Composite parent) {
        Control faultStringExpressionLabel = createDescription(parent, null, "Expression");
           widgetFactory.paintBordersFor(parent);
           if (faultStringExpression== null) {
               faultStringExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
           }
           String initValueExpression = faultStringExpression.getPropertyValue().isEmpty() ? ""
                   : faultStringExpression.getPropertyValue();
           faultStringExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
           faultStringExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
           widgetFactory.paintBordersFor(parent);
           GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
           faultStringExpressionText.setLayoutData(valueData);
           
           faultStringExpressionText.addMouseListener(new MouseListener() {

               @Override
               public void mouseDown(MouseEvent e) {
                   EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                           SWT.NULL, faultStringExpression);
                   faultStringExpression = nspd.open();
                   faultStringExpressionText.setText(faultStringExpression.getPropertyValue());
                   propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                           FaultMediatorPropertiesEditionPartForm.this,
                           EsbViewsRepository.FaultMediator.Properties.faultStringExpression, PropertiesEditionEvent.COMMIT,
                           PropertiesEditionEvent.SET, null, getFaultStringExpression()));
               }

               @Override
               public void mouseDoubleClick(MouseEvent e) {}
               
               @Override
               public void mouseUp(MouseEvent e) {}
               
           });
           
           faultStringExpressionText.addKeyListener(new KeyListener() {
               
               @Override
               public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, faultStringExpression);
                        nspd.open();
                        faultStringExpressionText.setText(faultStringExpression.getPropertyValue());
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                FaultMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FaultMediator.Properties.faultStringExpression, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getFaultStringExpression()));
                    }
               }
               
               @Override
               public void keyPressed(KeyEvent e) {}
               
           });

           EditingUtils.setID(faultStringExpressionText, EsbViewsRepository.FaultMediator.Properties.faultStringExpression);
           EditingUtils.setEEFtype(faultStringExpressionText, "eef::Text");
           Control faultStringExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
                   propertiesEditionComponent.getHelpContent(
                           EsbViewsRepository.FaultMediator.Properties.faultStringExpression, EsbViewsRepository.FORM_KIND),
                   null); // $NON-NLS-1$
           faultStringElements = new Control[] { faultStringExpressionLabel, faultStringExpressionText,
                   faultStringExpressionHelp };
           return parent;
       }
	   
	   protected Composite createFaultCodeExpressionText(FormToolkit widgetFactory, final Composite parent) {
        Control faultCodeExpressionLabel = createDescription(parent, null, "Expression");
           widgetFactory.paintBordersFor(parent);
           if (faultCodeExpression== null) {
               faultCodeExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
           }
           String initValueExpression = faultCodeExpression.getPropertyValue().isEmpty() ? ""
                   : faultCodeExpression.getPropertyValue();
           faultCodeExpressionText = widgetFactory.createText(parent, initValueExpression, SWT.READ_ONLY);
           faultCodeExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
           widgetFactory.paintBordersFor(parent);
           GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
           faultCodeExpressionText.setLayoutData(valueData);
           
           faultCodeExpressionText.addMouseListener(new MouseListener() {

               @Override
               public void mouseDown(MouseEvent e) {
                   EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                           SWT.NULL, faultCodeExpression);
                   faultCodeExpression = nspd.open();
                   faultCodeExpressionText.setText(faultCodeExpression.getPropertyValue());
                   propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                           FaultMediatorPropertiesEditionPartForm.this,
                           EsbViewsRepository.FaultMediator.Properties.faultCodeExpression, PropertiesEditionEvent.COMMIT,
                           PropertiesEditionEvent.SET, null, getFaultCodeExpression()));
               }

               @Override
               public void mouseDoubleClick(MouseEvent e) {}
               
               @Override
               public void mouseUp(MouseEvent e) {}
               
           });
           
           faultCodeExpressionText.addKeyListener(new KeyListener() {
               
               @Override
               public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(),
                                SWT.NULL, faultCodeExpression);
                        nspd.open();
                        faultCodeExpressionText.setText(faultCodeExpression.getPropertyValue());
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                FaultMediatorPropertiesEditionPartForm.this,
                                EsbViewsRepository.FaultMediator.Properties.faultCodeExpression, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getFaultCodeExpression()));
                    }
               }
               
               @Override
               public void keyPressed(KeyEvent e) {}
               
           });

           EditingUtils.setID(faultCodeExpressionText, EsbViewsRepository.FaultMediator.Properties.faultCodeExpression);
           EditingUtils.setEEFtype(faultCodeExpressionText, "eef::Text");
           Control faultCodeExpressionHelp = FormUtils.createHelpButton(widgetFactory, parent,
                   propertiesEditionComponent.getHelpContent(
                           EsbViewsRepository.FaultMediator.Properties.faultCodeExpression, EsbViewsRepository.FORM_KIND),
                   null); // $NON-NLS-1$
           faultCodeElements = new Control[] { faultCodeExpressionLabel, faultCodeExpressionText,
                   faultCodeExpressionHelp };
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
        eu.showEntry(soapVersionElements, false);
        
        eu.showEntry(new Control[] { filterDetailSubPropertiesGroup.getParent() }, false);
        eu.clearElements(new Composite[] { filterDetailSubPropertiesGroup });

        eu.showEntry(new Control[] { filterReasonSubPropertiesGroup.getParent() }, false);
        eu.clearElements(new Composite[] { filterReasonSubPropertiesGroup });

        switch (getSoapVersion().getName()) {
        case "SOAP_1_1": {
            eu.showEntry(faultCodeSoap11Elements, false);
            eu.showEntry(faultStringTypeElements, false);
            eu.showEntry(faultActorElements, false);
            if (getFaultStringType().getName().equals("EXPRESSION")) {
                eu.showEntry(faultStringElements, false);
            } else {
                eu.showEntry(faultStringValueElements, false);
            }
            break;
        }
        case "SOAP_1_2": {
            eu.showEntry(faultCodeSoap12Elements, false);
            eu.showEntry(faultReasonTypeElements, false);
            eu.showEntry(roleNameElements, false);
            eu.showEntry(nodeNameElements, false);

            if (getFaultReasonType().getName().equals("EXPRESSION")) {
                eu.showEntry(faultReasonElements, false);
            } else {
                eu.showEntry(faultReasonValueElements, false);
            }
        }

        default:
            eu.showEntry(faultReasonTypeElements, false);
            if (getFaultReasonType().getName().equals("EXPRESSION")) {
                eu.showEntry(faultReasonElements, false);
            } else {
                eu.showEntry(faultReasonValueElements, false);
            }
            break;
        }

        eu.showEntry(faultDetailTypeElements, false);
        if (getFaultDetailType().getName().equals("EXPRESSION")) {
            eu.showEntry(faultDetailElements, false);
        } else {
            eu.showEntry(FaultDetailValueElements, false);
        }

        eu.showEntry(serializeResponseElements, false);
        if (getSerializeResponse()) {
            eu.showEntry(markAsResponseElements, false);
        }
        eu.showEntry(descriptionElements, false);
        view.layout(true, true);
    }
    // End of user code

}
