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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EntitlementMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EntitlementMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text entitlementServerURL;
	protected Text username;
	protected Text password;
	protected Text callbackClassName;
	protected Text thriftHost;
	protected Text thriftPort;
	protected EMFComboViewer entitlementClientType;
	protected EMFComboViewer onRejectSequenceType;
	protected EMFComboViewer onAcceptSequenceType;
	protected EMFComboViewer adviceSequenceType;
	protected EMFComboViewer obligationsSequenceType;
	protected EMFComboViewer callbackHandler;



	/**
	 * For {@link ISection} use only.
	 */
	public EntitlementMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EntitlementMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence entitlementMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = entitlementMediatorStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.username);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.password);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
		propertiesStep.addStep(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
		
		
		composer = new PartComposer(entitlementMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EntitlementMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL) {
					return createEntitlementServerURLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.username) {
					return createUsernameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.password) {
					return createPasswordText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackClassName) {
					return createCallbackClassNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftHost) {
					return createThriftHostText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.thriftPort) {
					return createThriftPortText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType) {
					return createEntitlementClientTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType) {
					return createOnRejectSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType) {
					return createOnAcceptSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType) {
					return createAdviceSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType) {
					return createObligationsSequenceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.EntitlementMediator.Properties.callbackHandler) {
					return createCallbackHandlerEMFComboViewer(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.EntitlementMediatorPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.description, EsbMessages.EntitlementMediatorPropertiesEditionPart_DescriptionLabel);
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
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.description,
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
									EntitlementMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.EntitlementMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.EntitlementMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EntitlementMediator.Properties.commentsList, EsbMessages.EntitlementMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "EntitlementMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.EntitlementMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.EntitlementMediator.Properties.reverse, EsbMessages.EntitlementMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.EntitlementMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createEntitlementServerURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL, EsbMessages.EntitlementMediatorPropertiesEditionPart_EntitlementServerURLLabel);
		entitlementServerURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		entitlementServerURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData entitlementServerURLData = new GridData(GridData.FILL_HORIZONTAL);
		entitlementServerURL.setLayoutData(entitlementServerURLData);
		entitlementServerURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entitlementServerURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, entitlementServerURL.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		entitlementServerURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entitlementServerURL.getText()));
				}
			}
		});
		EditingUtils.setID(entitlementServerURL, EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
		EditingUtils.setEEFtype(entitlementServerURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEntitlementServerURLText

		// End of user code
		return parent;
	}

	
	protected Composite createUsernameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.username, EsbMessages.EntitlementMediatorPropertiesEditionPart_UsernameLabel);
		username = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		username.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData usernameData = new GridData(GridData.FILL_HORIZONTAL);
		username.setLayoutData(usernameData);
		username.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.username,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.username,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, username.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		username.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.username, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
				}
			}
		});
		EditingUtils.setID(username, EsbViewsRepository.EntitlementMediator.Properties.username);
		EditingUtils.setEEFtype(username, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.username, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createUsernameText

		// End of user code
		return parent;
	}

	
	protected Composite createPasswordText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.password, EsbMessages.EntitlementMediatorPropertiesEditionPart_PasswordLabel);
		password = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		password.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData passwordData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(passwordData);
		password.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.password,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.password,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, password.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		password.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.password, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
				}
			}
		});
		EditingUtils.setID(password, EsbViewsRepository.EntitlementMediator.Properties.password);
		EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.password, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createCallbackClassNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName, EsbMessages.EntitlementMediatorPropertiesEditionPart_CallbackClassNameLabel);
		callbackClassName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		callbackClassName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData callbackClassNameData = new GridData(GridData.FILL_HORIZONTAL);
		callbackClassName.setLayoutData(callbackClassNameData);
		callbackClassName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, callbackClassName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.callbackClassName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, callbackClassName.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		callbackClassName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, callbackClassName.getText()));
				}
			}
		});
		EditingUtils.setID(callbackClassName, EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
		EditingUtils.setEEFtype(callbackClassName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCallbackClassNameText

		// End of user code
		return parent;
	}

	
	protected Composite createThriftHostText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.thriftHost, EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftHostLabel);
		thriftHost = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		thriftHost.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData thriftHostData = new GridData(GridData.FILL_HORIZONTAL);
		thriftHost.setLayoutData(thriftHostData);
		thriftHost.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftHost.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.thriftHost,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, thriftHost.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		thriftHost.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.thriftHost, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftHost.getText()));
				}
			}
		});
		EditingUtils.setID(thriftHost, EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
		EditingUtils.setEEFtype(thriftHost, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.thriftHost, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createThriftHostText

		// End of user code
		return parent;
	}

	
	protected Composite createThriftPortText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.thriftPort, EsbMessages.EntitlementMediatorPropertiesEditionPart_ThriftPortLabel);
		thriftPort = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		thriftPort.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData thriftPortData = new GridData(GridData.FILL_HORIZONTAL);
		thriftPort.setLayoutData(thriftPortData);
		thriftPort.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EntitlementMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftPort.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EntitlementMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.EntitlementMediator.Properties.thriftPort,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, thriftPort.getText()));
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
									EntitlementMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		thriftPort.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.thriftPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, thriftPort.getText()));
				}
			}
		});
		EditingUtils.setID(thriftPort, EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
		EditingUtils.setEEFtype(thriftPort, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.thriftPort, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createThriftPortText

		// End of user code
		return parent;
	}

	
	protected Composite createEntitlementClientTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType, EsbMessages.EntitlementMediatorPropertiesEditionPart_EntitlementClientTypeLabel);
		entitlementClientType = new EMFComboViewer(parent);
		entitlementClientType.setContentProvider(new ArrayContentProvider());
		entitlementClientType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData entitlementClientTypeData = new GridData(GridData.FILL_HORIZONTAL);
		entitlementClientType.getCombo().setLayoutData(entitlementClientTypeData);
		entitlementClientType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEntitlementClientType()));
			}

		});
		entitlementClientType.setID(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEntitlementClientTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOnRejectSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType, EsbMessages.EntitlementMediatorPropertiesEditionPart_OnRejectSequenceTypeLabel);
		onRejectSequenceType = new EMFComboViewer(parent);
		onRejectSequenceType.setContentProvider(new ArrayContentProvider());
		onRejectSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onRejectSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onRejectSequenceType.getCombo().setLayoutData(onRejectSequenceTypeData);
		onRejectSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnRejectSequenceType()));
			}

		});
		onRejectSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnRejectSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createOnAcceptSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType, EsbMessages.EntitlementMediatorPropertiesEditionPart_OnAcceptSequenceTypeLabel);
		onAcceptSequenceType = new EMFComboViewer(parent);
		onAcceptSequenceType.setContentProvider(new ArrayContentProvider());
		onAcceptSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData onAcceptSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		onAcceptSequenceType.getCombo().setLayoutData(onAcceptSequenceTypeData);
		onAcceptSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOnAcceptSequenceType()));
			}

		});
		onAcceptSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOnAcceptSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createAdviceSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType, EsbMessages.EntitlementMediatorPropertiesEditionPart_AdviceSequenceTypeLabel);
		adviceSequenceType = new EMFComboViewer(parent);
		adviceSequenceType.setContentProvider(new ArrayContentProvider());
		adviceSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData adviceSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		adviceSequenceType.getCombo().setLayoutData(adviceSequenceTypeData);
		adviceSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getAdviceSequenceType()));
			}

		});
		adviceSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAdviceSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createObligationsSequenceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType, EsbMessages.EntitlementMediatorPropertiesEditionPart_ObligationsSequenceTypeLabel);
		obligationsSequenceType = new EMFComboViewer(parent);
		obligationsSequenceType.setContentProvider(new ArrayContentProvider());
		obligationsSequenceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData obligationsSequenceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		obligationsSequenceType.getCombo().setLayoutData(obligationsSequenceTypeData);
		obligationsSequenceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getObligationsSequenceType()));
			}

		});
		obligationsSequenceType.setID(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createObligationsSequenceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createCallbackHandlerEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.EntitlementMediator.Properties.callbackHandler, EsbMessages.EntitlementMediatorPropertiesEditionPart_CallbackHandlerLabel);
		callbackHandler = new EMFComboViewer(parent);
		callbackHandler.setContentProvider(new ArrayContentProvider());
		callbackHandler.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData callbackHandlerData = new GridData(GridData.FILL_HORIZONTAL);
		callbackHandler.getCombo().setLayoutData(callbackHandlerData);
		callbackHandler.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EntitlementMediatorPropertiesEditionPartForm.this, EsbViewsRepository.EntitlementMediator.Properties.callbackHandler, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCallbackHandler()));
			}

		});
		callbackHandler.setID(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCallbackHandlerEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementServerURL()
	 * 
	 */
	public String getEntitlementServerURL() {
		return entitlementServerURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementServerURL(String newValue)
	 * 
	 */
	public void setEntitlementServerURL(String newValue) {
		if (newValue != null) {
			entitlementServerURL.setText(newValue);
		} else {
			entitlementServerURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.entitlementServerURL);
		if (eefElementEditorReadOnlyState && entitlementServerURL.isEnabled()) {
			entitlementServerURL.setEnabled(false);
			entitlementServerURL.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entitlementServerURL.isEnabled()) {
			entitlementServerURL.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getUsername()
	 * 
	 */
	public String getUsername() {
		return username.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setUsername(String newValue)
	 * 
	 */
	public void setUsername(String newValue) {
		if (newValue != null) {
			username.setText(newValue);
		} else {
			username.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.username);
		if (eefElementEditorReadOnlyState && username.isEnabled()) {
			username.setEnabled(false);
			username.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !username.isEnabled()) {
			username.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getPassword()
	 * 
	 */
	public String getPassword() {
		return password.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setPassword(String newValue)
	 * 
	 */
	public void setPassword(String newValue) {
		if (newValue != null) {
			password.setText(newValue);
		} else {
			password.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.password);
		if (eefElementEditorReadOnlyState && password.isEnabled()) {
			password.setEnabled(false);
			password.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !password.isEnabled()) {
			password.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackClassName()
	 * 
	 */
	public String getCallbackClassName() {
		return callbackClassName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackClassName(String newValue)
	 * 
	 */
	public void setCallbackClassName(String newValue) {
		if (newValue != null) {
			callbackClassName.setText(newValue);
		} else {
			callbackClassName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.callbackClassName);
		if (eefElementEditorReadOnlyState && callbackClassName.isEnabled()) {
			callbackClassName.setEnabled(false);
			callbackClassName.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !callbackClassName.isEnabled()) {
			callbackClassName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftHost()
	 * 
	 */
	public String getThriftHost() {
		return thriftHost.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftHost(String newValue)
	 * 
	 */
	public void setThriftHost(String newValue) {
		if (newValue != null) {
			thriftHost.setText(newValue);
		} else {
			thriftHost.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.thriftHost);
		if (eefElementEditorReadOnlyState && thriftHost.isEnabled()) {
			thriftHost.setEnabled(false);
			thriftHost.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !thriftHost.isEnabled()) {
			thriftHost.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getThriftPort()
	 * 
	 */
	public String getThriftPort() {
		return thriftPort.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setThriftPort(String newValue)
	 * 
	 */
	public void setThriftPort(String newValue) {
		if (newValue != null) {
			thriftPort.setText(newValue);
		} else {
			thriftPort.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.thriftPort);
		if (eefElementEditorReadOnlyState && thriftPort.isEnabled()) {
			thriftPort.setEnabled(false);
			thriftPort.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !thriftPort.isEnabled()) {
			thriftPort.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getEntitlementClientType()
	 * 
	 */
	public Enumerator getEntitlementClientType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) entitlementClientType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initEntitlementClientType(Object input, Enumerator current)
	 */
	public void initEntitlementClientType(Object input, Enumerator current) {
		entitlementClientType.setInput(input);
		entitlementClientType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
		if (eefElementEditorReadOnlyState && entitlementClientType.isEnabled()) {
			entitlementClientType.setEnabled(false);
			entitlementClientType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entitlementClientType.isEnabled()) {
			entitlementClientType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setEntitlementClientType(Enumerator newValue)
	 * 
	 */
	public void setEntitlementClientType(Enumerator newValue) {
		entitlementClientType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.entitlementClientType);
		if (eefElementEditorReadOnlyState && entitlementClientType.isEnabled()) {
			entitlementClientType.setEnabled(false);
			entitlementClientType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entitlementClientType.isEnabled()) {
			entitlementClientType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnRejectSequenceType()
	 * 
	 */
	public Enumerator getOnRejectSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onRejectSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnRejectSequenceType(Object input, Enumerator current)
	 */
	public void initOnRejectSequenceType(Object input, Enumerator current) {
		onRejectSequenceType.setInput(input);
		onRejectSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
		if (eefElementEditorReadOnlyState && onRejectSequenceType.isEnabled()) {
			onRejectSequenceType.setEnabled(false);
			onRejectSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectSequenceType.isEnabled()) {
			onRejectSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnRejectSequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnRejectSequenceType(Enumerator newValue) {
		onRejectSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.onRejectSequenceType);
		if (eefElementEditorReadOnlyState && onRejectSequenceType.isEnabled()) {
			onRejectSequenceType.setEnabled(false);
			onRejectSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onRejectSequenceType.isEnabled()) {
			onRejectSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getOnAcceptSequenceType()
	 * 
	 */
	public Enumerator getOnAcceptSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) onAcceptSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initOnAcceptSequenceType(Object input, Enumerator current)
	 */
	public void initOnAcceptSequenceType(Object input, Enumerator current) {
		onAcceptSequenceType.setInput(input);
		onAcceptSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
		if (eefElementEditorReadOnlyState && onAcceptSequenceType.isEnabled()) {
			onAcceptSequenceType.setEnabled(false);
			onAcceptSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptSequenceType.isEnabled()) {
			onAcceptSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setOnAcceptSequenceType(Enumerator newValue)
	 * 
	 */
	public void setOnAcceptSequenceType(Enumerator newValue) {
		onAcceptSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.onAcceptSequenceType);
		if (eefElementEditorReadOnlyState && onAcceptSequenceType.isEnabled()) {
			onAcceptSequenceType.setEnabled(false);
			onAcceptSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !onAcceptSequenceType.isEnabled()) {
			onAcceptSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getAdviceSequenceType()
	 * 
	 */
	public Enumerator getAdviceSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) adviceSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initAdviceSequenceType(Object input, Enumerator current)
	 */
	public void initAdviceSequenceType(Object input, Enumerator current) {
		adviceSequenceType.setInput(input);
		adviceSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
		if (eefElementEditorReadOnlyState && adviceSequenceType.isEnabled()) {
			adviceSequenceType.setEnabled(false);
			adviceSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !adviceSequenceType.isEnabled()) {
			adviceSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setAdviceSequenceType(Enumerator newValue)
	 * 
	 */
	public void setAdviceSequenceType(Enumerator newValue) {
		adviceSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.adviceSequenceType);
		if (eefElementEditorReadOnlyState && adviceSequenceType.isEnabled()) {
			adviceSequenceType.setEnabled(false);
			adviceSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !adviceSequenceType.isEnabled()) {
			adviceSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getObligationsSequenceType()
	 * 
	 */
	public Enumerator getObligationsSequenceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) obligationsSequenceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initObligationsSequenceType(Object input, Enumerator current)
	 */
	public void initObligationsSequenceType(Object input, Enumerator current) {
		obligationsSequenceType.setInput(input);
		obligationsSequenceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
		if (eefElementEditorReadOnlyState && obligationsSequenceType.isEnabled()) {
			obligationsSequenceType.setEnabled(false);
			obligationsSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !obligationsSequenceType.isEnabled()) {
			obligationsSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setObligationsSequenceType(Enumerator newValue)
	 * 
	 */
	public void setObligationsSequenceType(Enumerator newValue) {
		obligationsSequenceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.obligationsSequenceType);
		if (eefElementEditorReadOnlyState && obligationsSequenceType.isEnabled()) {
			obligationsSequenceType.setEnabled(false);
			obligationsSequenceType.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !obligationsSequenceType.isEnabled()) {
			obligationsSequenceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#getCallbackHandler()
	 * 
	 */
	public Enumerator getCallbackHandler() {
		Enumerator selection = (Enumerator) ((StructuredSelection) callbackHandler.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#initCallbackHandler(Object input, Enumerator current)
	 */
	public void initCallbackHandler(Object input, Enumerator current) {
		callbackHandler.setInput(input);
		callbackHandler.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
		if (eefElementEditorReadOnlyState && callbackHandler.isEnabled()) {
			callbackHandler.setEnabled(false);
			callbackHandler.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !callbackHandler.isEnabled()) {
			callbackHandler.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EntitlementMediatorPropertiesEditionPart#setCallbackHandler(Enumerator newValue)
	 * 
	 */
	public void setCallbackHandler(Enumerator newValue) {
		callbackHandler.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EntitlementMediator.Properties.callbackHandler);
		if (eefElementEditorReadOnlyState && callbackHandler.isEnabled()) {
			callbackHandler.setEnabled(false);
			callbackHandler.setToolTipText(EsbMessages.EntitlementMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !callbackHandler.isEnabled()) {
			callbackHandler.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EntitlementMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
