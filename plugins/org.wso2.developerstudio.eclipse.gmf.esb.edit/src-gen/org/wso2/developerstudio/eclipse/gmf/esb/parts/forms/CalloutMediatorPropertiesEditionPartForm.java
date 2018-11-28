/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class CalloutMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CalloutMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text serviceURL;
	protected Text soapAction;
	protected Text pathToAxis2xml;
	protected Text pathToAxis2Repository;
	protected EMFComboViewer payloadType;
	protected EMFComboViewer resultType;
	protected Text resultContextProperty;
	protected Button passHeaders;
	protected EMFComboViewer endpointType;
	protected Text payloadProperty;
	protected EMFComboViewer securityType;
	protected EMFComboViewer policies;
	protected Button initAxis2ClientOptions;



	/**
	 * For {@link ISection} use only.
	 */
	public CalloutMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CalloutMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence calloutMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = calloutMediatorStep.addStep(EsbViewsRepository.CalloutMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.serviceURL);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.soapAction);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.payloadType);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.resultType);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.resultContextProperty);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.passHeaders);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.endpointType);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.payloadProperty);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.securityType);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.policies);
		propertiesStep.addStep(EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions);
		
		
		composer = new PartComposer(calloutMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.CalloutMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.serviceURL) {
					return createServiceURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.soapAction) {
					return createSoapActionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml) {
					return createPathToAxis2xmlText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository) {
					return createPathToAxis2RepositoryText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.payloadType) {
					return createPayloadTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.resultType) {
					return createResultTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.resultContextProperty) {
					return createResultContextPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.passHeaders) {
					return createPassHeadersCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.endpointType) {
					return createEndpointTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.payloadProperty) {
					return createPayloadPropertyText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.securityType) {
					return createSecurityTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.policies) {
					return createPoliciesEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions) {
					return createInitAxis2ClientOptionsCheckbox(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.CalloutMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.description, EsbMessages.CalloutMediatorPropertiesEditionPart_DescriptionLabel);
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
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.description,
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
									CalloutMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.CalloutMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.CalloutMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Properties.commentsList, EsbMessages.CalloutMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "CalloutMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.CalloutMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Properties.reverse, EsbMessages.CalloutMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.CalloutMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createServiceURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.serviceURL, EsbMessages.CalloutMediatorPropertiesEditionPart_ServiceURLLabel);
		serviceURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		serviceURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceURLData = new GridData(GridData.FILL_HORIZONTAL);
		serviceURL.setLayoutData(serviceURLData);
		serviceURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.serviceURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.serviceURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, serviceURL.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		serviceURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.serviceURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceURL.getText()));
				}
			}
		});
		EditingUtils.setID(serviceURL, EsbViewsRepository.CalloutMediator.Properties.serviceURL);
		EditingUtils.setEEFtype(serviceURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.serviceURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceURLText

		// End of user code
		return parent;
	}

	
	protected Composite createSoapActionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.soapAction, EsbMessages.CalloutMediatorPropertiesEditionPart_SoapActionLabel);
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
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.soapAction,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.soapAction,
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
									CalloutMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.soapAction, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, soapAction.getText()));
				}
			}
		});
		EditingUtils.setID(soapAction, EsbViewsRepository.CalloutMediator.Properties.soapAction);
		EditingUtils.setEEFtype(soapAction, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.soapAction, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSoapActionText

		// End of user code
		return parent;
	}

	
	protected Composite createPathToAxis2xmlText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2xmlLabel);
		pathToAxis2xml = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		pathToAxis2xml.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pathToAxis2xmlData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2xml.setLayoutData(pathToAxis2xmlData);
		pathToAxis2xml.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, pathToAxis2xml.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		pathToAxis2xml.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2xml.getText()));
				}
			}
		});
		EditingUtils.setID(pathToAxis2xml, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml);
		EditingUtils.setEEFtype(pathToAxis2xml, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2xmlText

		// End of user code
		return parent;
	}

	
	protected Composite createPathToAxis2RepositoryText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository, EsbMessages.CalloutMediatorPropertiesEditionPart_PathToAxis2RepositoryLabel);
		pathToAxis2Repository = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		pathToAxis2Repository.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData pathToAxis2RepositoryData = new GridData(GridData.FILL_HORIZONTAL);
		pathToAxis2Repository.setLayoutData(pathToAxis2RepositoryData);
		pathToAxis2Repository.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, pathToAxis2Repository.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		pathToAxis2Repository.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, pathToAxis2Repository.getText()));
				}
			}
		});
		EditingUtils.setID(pathToAxis2Repository, EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository);
		EditingUtils.setEEFtype(pathToAxis2Repository, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPathToAxis2RepositoryText

		// End of user code
		return parent;
	}

	
	protected Composite createPayloadTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.payloadType, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadTypeLabel);
		payloadType = new EMFComboViewer(parent);
		payloadType.setContentProvider(new ArrayContentProvider());
		payloadType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData payloadTypeData = new GridData(GridData.FILL_HORIZONTAL);
		payloadType.getCombo().setLayoutData(payloadTypeData);
		payloadType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.payloadType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPayloadType()));
			}

		});
		payloadType.setID(EsbViewsRepository.CalloutMediator.Properties.payloadType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.payloadType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createResultTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.resultType, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultTypeLabel);
		resultType = new EMFComboViewer(parent);
		resultType.setContentProvider(new ArrayContentProvider());
		resultType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData resultTypeData = new GridData(GridData.FILL_HORIZONTAL);
		resultType.getCombo().setLayoutData(resultTypeData);
		resultType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.resultType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getResultType()));
			}

		});
		resultType.setID(EsbViewsRepository.CalloutMediator.Properties.resultType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.resultType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createResultContextPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.resultContextProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_ResultContextPropertyLabel);
		resultContextProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		resultContextProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData resultContextPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		resultContextProperty.setLayoutData(resultContextPropertyData);
		resultContextProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.resultContextProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.resultContextProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, resultContextProperty.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		resultContextProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.resultContextProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, resultContextProperty.getText()));
				}
			}
		});
		EditingUtils.setID(resultContextProperty, EsbViewsRepository.CalloutMediator.Properties.resultContextProperty);
		EditingUtils.setEEFtype(resultContextProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.resultContextProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createResultContextPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createPassHeadersCheckbox(FormToolkit widgetFactory, Composite parent) {
		passHeaders = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Properties.passHeaders, EsbMessages.CalloutMediatorPropertiesEditionPart_PassHeadersLabel), SWT.CHECK);
		passHeaders.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.passHeaders, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(passHeaders.getSelection())));
			}

		});
		GridData passHeadersData = new GridData(GridData.FILL_HORIZONTAL);
		passHeadersData.horizontalSpan = 2;
		passHeaders.setLayoutData(passHeadersData);
		EditingUtils.setID(passHeaders, EsbViewsRepository.CalloutMediator.Properties.passHeaders);
		EditingUtils.setEEFtype(passHeaders, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.passHeaders, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPassHeadersCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createEndpointTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.endpointType, EsbMessages.CalloutMediatorPropertiesEditionPart_EndpointTypeLabel);
		endpointType = new EMFComboViewer(parent);
		endpointType.setContentProvider(new ArrayContentProvider());
		endpointType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData endpointTypeData = new GridData(GridData.FILL_HORIZONTAL);
		endpointType.getCombo().setLayoutData(endpointTypeData);
		endpointType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.endpointType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEndpointType()));
			}

		});
		endpointType.setID(EsbViewsRepository.CalloutMediator.Properties.endpointType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.endpointType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEndpointTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPayloadPropertyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.payloadProperty, EsbMessages.CalloutMediatorPropertiesEditionPart_PayloadPropertyLabel);
		payloadProperty = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		payloadProperty.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData payloadPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		payloadProperty.setLayoutData(payloadPropertyData);
		payloadProperty.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalloutMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.CalloutMediator.Properties.payloadProperty,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalloutMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.CalloutMediator.Properties.payloadProperty,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, payloadProperty.getText()));
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
									CalloutMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		payloadProperty.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.payloadProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, payloadProperty.getText()));
				}
			}
		});
		EditingUtils.setID(payloadProperty, EsbViewsRepository.CalloutMediator.Properties.payloadProperty);
		EditingUtils.setEEFtype(payloadProperty, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.payloadProperty, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPayloadPropertyText

		// End of user code
		return parent;
	}

	
	protected Composite createSecurityTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.securityType, EsbMessages.CalloutMediatorPropertiesEditionPart_SecurityTypeLabel);
		securityType = new EMFComboViewer(parent);
		securityType.setContentProvider(new ArrayContentProvider());
		securityType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData securityTypeData = new GridData(GridData.FILL_HORIZONTAL);
		securityType.getCombo().setLayoutData(securityTypeData);
		securityType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.securityType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSecurityType()));
			}

		});
		securityType.setID(EsbViewsRepository.CalloutMediator.Properties.securityType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.securityType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSecurityTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPoliciesEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.CalloutMediator.Properties.policies, EsbMessages.CalloutMediatorPropertiesEditionPart_PoliciesLabel);
		policies = new EMFComboViewer(parent);
		policies.setContentProvider(new ArrayContentProvider());
		policies.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData policiesData = new GridData(GridData.FILL_HORIZONTAL);
		policies.getCombo().setLayoutData(policiesData);
		policies.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.policies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPolicies()));
			}

		});
		policies.setID(EsbViewsRepository.CalloutMediator.Properties.policies);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.policies, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPoliciesEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createInitAxis2ClientOptionsCheckbox(FormToolkit widgetFactory, Composite parent) {
		initAxis2ClientOptions = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions, EsbMessages.CalloutMediatorPropertiesEditionPart_InitAxis2ClientOptionsLabel), SWT.CHECK);
		initAxis2ClientOptions.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalloutMediatorPropertiesEditionPartForm.this, EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(initAxis2ClientOptions.getSelection())));
			}

		});
		GridData initAxis2ClientOptionsData = new GridData(GridData.FILL_HORIZONTAL);
		initAxis2ClientOptionsData.horizontalSpan = 2;
		initAxis2ClientOptions.setLayoutData(initAxis2ClientOptionsData);
		EditingUtils.setID(initAxis2ClientOptions, EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions);
		EditingUtils.setEEFtype(initAxis2ClientOptions, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createInitAxis2ClientOptionsCheckbox

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getServiceURL()
	 * 
	 */
	public String getServiceURL() {
		return serviceURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setServiceURL(String newValue)
	 * 
	 */
	public void setServiceURL(String newValue) {
		if (newValue != null) {
			serviceURL.setText(newValue);
		} else {
			serviceURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.serviceURL);
		if (eefElementEditorReadOnlyState && serviceURL.isEnabled()) {
			serviceURL.setEnabled(false);
			serviceURL.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceURL.isEnabled()) {
			serviceURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getSoapAction()
	 * 
	 */
	public String getSoapAction() {
		return soapAction.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setSoapAction(String newValue)
	 * 
	 */
	public void setSoapAction(String newValue) {
		if (newValue != null) {
			soapAction.setText(newValue);
		} else {
			soapAction.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.soapAction);
		if (eefElementEditorReadOnlyState && soapAction.isEnabled()) {
			soapAction.setEnabled(false);
			soapAction.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !soapAction.isEnabled()) {
			soapAction.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPathToAxis2xml()
	 * 
	 */
	public String getPathToAxis2xml() {
		return pathToAxis2xml.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPathToAxis2xml(String newValue)
	 * 
	 */
	public void setPathToAxis2xml(String newValue) {
		if (newValue != null) {
			pathToAxis2xml.setText(newValue);
		} else {
			pathToAxis2xml.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2xml);
		if (eefElementEditorReadOnlyState && pathToAxis2xml.isEnabled()) {
			pathToAxis2xml.setEnabled(false);
			pathToAxis2xml.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pathToAxis2xml.isEnabled()) {
			pathToAxis2xml.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPathToAxis2Repository()
	 * 
	 */
	public String getPathToAxis2Repository() {
		return pathToAxis2Repository.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPathToAxis2Repository(String newValue)
	 * 
	 */
	public void setPathToAxis2Repository(String newValue) {
		if (newValue != null) {
			pathToAxis2Repository.setText(newValue);
		} else {
			pathToAxis2Repository.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.pathToAxis2Repository);
		if (eefElementEditorReadOnlyState && pathToAxis2Repository.isEnabled()) {
			pathToAxis2Repository.setEnabled(false);
			pathToAxis2Repository.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !pathToAxis2Repository.isEnabled()) {
			pathToAxis2Repository.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPayloadType()
	 * 
	 */
	public Enumerator getPayloadType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) payloadType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initPayloadType(Object input, Enumerator current)
	 */
	public void initPayloadType(Object input, Enumerator current) {
		payloadType.setInput(input);
		payloadType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.payloadType);
		if (eefElementEditorReadOnlyState && payloadType.isEnabled()) {
			payloadType.setEnabled(false);
			payloadType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadType.isEnabled()) {
			payloadType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPayloadType(Enumerator newValue)
	 * 
	 */
	public void setPayloadType(Enumerator newValue) {
		payloadType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.payloadType);
		if (eefElementEditorReadOnlyState && payloadType.isEnabled()) {
			payloadType.setEnabled(false);
			payloadType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadType.isEnabled()) {
			payloadType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getResultType()
	 * 
	 */
	public Enumerator getResultType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) resultType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initResultType(Object input, Enumerator current)
	 */
	public void initResultType(Object input, Enumerator current) {
		resultType.setInput(input);
		resultType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.resultType);
		if (eefElementEditorReadOnlyState && resultType.isEnabled()) {
			resultType.setEnabled(false);
			resultType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultType.isEnabled()) {
			resultType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setResultType(Enumerator newValue)
	 * 
	 */
	public void setResultType(Enumerator newValue) {
		resultType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.resultType);
		if (eefElementEditorReadOnlyState && resultType.isEnabled()) {
			resultType.setEnabled(false);
			resultType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultType.isEnabled()) {
			resultType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getResultContextProperty()
	 * 
	 */
	public String getResultContextProperty() {
		return resultContextProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setResultContextProperty(String newValue)
	 * 
	 */
	public void setResultContextProperty(String newValue) {
		if (newValue != null) {
			resultContextProperty.setText(newValue);
		} else {
			resultContextProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.resultContextProperty);
		if (eefElementEditorReadOnlyState && resultContextProperty.isEnabled()) {
			resultContextProperty.setEnabled(false);
			resultContextProperty.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !resultContextProperty.isEnabled()) {
			resultContextProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPassHeaders()
	 * 
	 */
	public Boolean getPassHeaders() {
		return Boolean.valueOf(passHeaders.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPassHeaders(Boolean newValue)
	 * 
	 */
	public void setPassHeaders(Boolean newValue) {
		if (newValue != null) {
			passHeaders.setSelection(newValue.booleanValue());
		} else {
			passHeaders.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.passHeaders);
		if (eefElementEditorReadOnlyState && passHeaders.isEnabled()) {
			passHeaders.setEnabled(false);
			passHeaders.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !passHeaders.isEnabled()) {
			passHeaders.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getEndpointType()
	 * 
	 */
	public Enumerator getEndpointType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) endpointType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initEndpointType(Object input, Enumerator current)
	 */
	public void initEndpointType(Object input, Enumerator current) {
		endpointType.setInput(input);
		endpointType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setEndpointType(Enumerator newValue)
	 * 
	 */
	public void setEndpointType(Enumerator newValue) {
		endpointType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.endpointType);
		if (eefElementEditorReadOnlyState && endpointType.isEnabled()) {
			endpointType.setEnabled(false);
			endpointType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !endpointType.isEnabled()) {
			endpointType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPayloadProperty()
	 * 
	 */
	public String getPayloadProperty() {
		return payloadProperty.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPayloadProperty(String newValue)
	 * 
	 */
	public void setPayloadProperty(String newValue) {
		if (newValue != null) {
			payloadProperty.setText(newValue);
		} else {
			payloadProperty.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.payloadProperty);
		if (eefElementEditorReadOnlyState && payloadProperty.isEnabled()) {
			payloadProperty.setEnabled(false);
			payloadProperty.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !payloadProperty.isEnabled()) {
			payloadProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getSecurityType()
	 * 
	 */
	public Enumerator getSecurityType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) securityType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initSecurityType(Object input, Enumerator current)
	 */
	public void initSecurityType(Object input, Enumerator current) {
		securityType.setInput(input);
		securityType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.securityType);
		if (eefElementEditorReadOnlyState && securityType.isEnabled()) {
			securityType.setEnabled(false);
			securityType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityType.isEnabled()) {
			securityType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setSecurityType(Enumerator newValue)
	 * 
	 */
	public void setSecurityType(Enumerator newValue) {
		securityType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.securityType);
		if (eefElementEditorReadOnlyState && securityType.isEnabled()) {
			securityType.setEnabled(false);
			securityType.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !securityType.isEnabled()) {
			securityType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getPolicies()
	 * 
	 */
	public Enumerator getPolicies() {
		Enumerator selection = (Enumerator) ((StructuredSelection) policies.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#initPolicies(Object input, Enumerator current)
	 */
	public void initPolicies(Object input, Enumerator current) {
		policies.setInput(input);
		policies.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.policies);
		if (eefElementEditorReadOnlyState && policies.isEnabled()) {
			policies.setEnabled(false);
			policies.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policies.isEnabled()) {
			policies.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setPolicies(Enumerator newValue)
	 * 
	 */
	public void setPolicies(Enumerator newValue) {
		policies.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.policies);
		if (eefElementEditorReadOnlyState && policies.isEnabled()) {
			policies.setEnabled(false);
			policies.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !policies.isEnabled()) {
			policies.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#getInitAxis2ClientOptions()
	 * 
	 */
	public Boolean getInitAxis2ClientOptions() {
		return Boolean.valueOf(initAxis2ClientOptions.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.CalloutMediatorPropertiesEditionPart#setInitAxis2ClientOptions(Boolean newValue)
	 * 
	 */
	public void setInitAxis2ClientOptions(Boolean newValue) {
		if (newValue != null) {
			initAxis2ClientOptions.setSelection(newValue.booleanValue());
		} else {
			initAxis2ClientOptions.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.CalloutMediator.Properties.initAxis2ClientOptions);
		if (eefElementEditorReadOnlyState && initAxis2ClientOptions.isEnabled()) {
			initAxis2ClientOptions.setEnabled(false);
			initAxis2ClientOptions.setToolTipText(EsbMessages.CalloutMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !initAxis2ClientOptions.isEnabled()) {
			initAxis2ClientOptions.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.CalloutMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
