/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class NTLMMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NTLMMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text username;
	protected Text password;
	protected Text host;
	protected Text domain;
	protected Text ntlmVersion;
	protected EObjectFlatComboViewer usernameExpression;
	protected EObjectFlatComboViewer passwordExpression;
	protected EObjectFlatComboViewer hostExpression;
	protected EObjectFlatComboViewer domainExpression;
	protected EObjectFlatComboViewer ntlmVersionExpression;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public NTLMMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence nTLMMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = nTLMMediatorStep.addStep(EsbViewsRepository.NTLMMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.username);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.password);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.host);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.domain);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.usernameExpression);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.passwordExpression);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.hostExpression);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.domainExpression);
		propertiesStep.addStep(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression);
		
		
		composer = new PartComposer(nTLMMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.NTLMMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.username) {
					return createUsernameText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.password) {
					return createPasswordText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.host) {
					return createHostText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.domain) {
					return createDomainText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.ntlmVersion) {
					return createNtlmVersionText(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.usernameExpression) {
					return createUsernameExpressionFlatComboViewer(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.passwordExpression) {
					return createPasswordExpressionFlatComboViewer(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.hostExpression) {
					return createHostExpressionFlatComboViewer(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.domainExpression) {
					return createDomainExpressionFlatComboViewer(parent);
				}
				if (key == EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression) {
					return createNtlmVersionExpressionFlatComboViewer(parent);
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
		propertiesGroup.setText(EsbMessages.NTLMMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.description, EsbMessages.NTLMMediatorPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.NTLMMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.NTLMMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.NTLMMediator.Properties.commentsList, EsbMessages.NTLMMediatorPropertiesEditionPart_CommentsListLabel));
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "NTLMMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.NTLMMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.NTLMMediator.Properties.reverse, EsbMessages.NTLMMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.NTLMMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createUsernameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.username, EsbMessages.NTLMMediatorPropertiesEditionPart_UsernameLabel);
		username = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData usernameData = new GridData(GridData.FILL_HORIZONTAL);
		username.setLayoutData(usernameData);
		username.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.username, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
			}

		});
		username.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.username, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, username.getText()));
				}
			}

		});
		EditingUtils.setID(username, EsbViewsRepository.NTLMMediator.Properties.username);
		EditingUtils.setEEFtype(username, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.username, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createUsernameText

		// End of user code
		return parent;
	}

	
	protected Composite createPasswordText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.password, EsbMessages.NTLMMediatorPropertiesEditionPart_PasswordLabel);
		password = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData passwordData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(passwordData);
		password.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.password, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
			}

		});
		password.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.password, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, password.getText()));
				}
			}

		});
		EditingUtils.setID(password, EsbViewsRepository.NTLMMediator.Properties.password);
		EditingUtils.setEEFtype(password, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.password, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPasswordText

		// End of user code
		return parent;
	}

	
	protected Composite createHostText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.host, EsbMessages.NTLMMediatorPropertiesEditionPart_HostLabel);
		host = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData hostData = new GridData(GridData.FILL_HORIZONTAL);
		host.setLayoutData(hostData);
		host.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.host, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, host.getText()));
			}

		});
		host.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.host, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, host.getText()));
				}
			}

		});
		EditingUtils.setID(host, EsbViewsRepository.NTLMMediator.Properties.host);
		EditingUtils.setEEFtype(host, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.host, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostText

		// End of user code
		return parent;
	}

	
	protected Composite createDomainText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.domain, EsbMessages.NTLMMediatorPropertiesEditionPart_DomainLabel);
		domain = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData domainData = new GridData(GridData.FILL_HORIZONTAL);
		domain.setLayoutData(domainData);
		domain.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.domain, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, domain.getText()));
			}

		});
		domain.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.domain, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, domain.getText()));
				}
			}

		});
		EditingUtils.setID(domain, EsbViewsRepository.NTLMMediator.Properties.domain);
		EditingUtils.setEEFtype(domain, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.domain, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDomainText

		// End of user code
		return parent;
	}

	
	protected Composite createNtlmVersionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion, EsbMessages.NTLMMediatorPropertiesEditionPart_NtlmVersionLabel);
		ntlmVersion = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData ntlmVersionData = new GridData(GridData.FILL_HORIZONTAL);
		ntlmVersion.setLayoutData(ntlmVersionData);
		ntlmVersion.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ntlmVersion.getText()));
			}

		});
		ntlmVersion.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ntlmVersion.getText()));
				}
			}

		});
		EditingUtils.setID(ntlmVersion, EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
		EditingUtils.setEEFtype(ntlmVersion, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNtlmVersionText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createUsernameExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.usernameExpression, EsbMessages.NTLMMediatorPropertiesEditionPart_UsernameExpressionLabel);
		usernameExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.NTLMMediator.Properties.usernameExpression, EsbViewsRepository.SWT_KIND));
		usernameExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		usernameExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.usernameExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getUsernameExpression()));
			}

		});
		GridData usernameExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		usernameExpression.setLayoutData(usernameExpressionData);
		usernameExpression.setID(EsbViewsRepository.NTLMMediator.Properties.usernameExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.usernameExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createUsernameExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createPasswordExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.passwordExpression, EsbMessages.NTLMMediatorPropertiesEditionPart_PasswordExpressionLabel);
		passwordExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.NTLMMediator.Properties.passwordExpression, EsbViewsRepository.SWT_KIND));
		passwordExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		passwordExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.passwordExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getPasswordExpression()));
			}

		});
		GridData passwordExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		passwordExpression.setLayoutData(passwordExpressionData);
		passwordExpression.setID(EsbViewsRepository.NTLMMediator.Properties.passwordExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.passwordExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPasswordExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createHostExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.hostExpression, EsbMessages.NTLMMediatorPropertiesEditionPart_HostExpressionLabel);
		hostExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.NTLMMediator.Properties.hostExpression, EsbViewsRepository.SWT_KIND));
		hostExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		hostExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.hostExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getHostExpression()));
			}

		});
		GridData hostExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		hostExpression.setLayoutData(hostExpressionData);
		hostExpression.setID(EsbViewsRepository.NTLMMediator.Properties.hostExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.hostExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDomainExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.domainExpression, EsbMessages.NTLMMediatorPropertiesEditionPart_DomainExpressionLabel);
		domainExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.NTLMMediator.Properties.domainExpression, EsbViewsRepository.SWT_KIND));
		domainExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		domainExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.domainExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDomainExpression()));
			}

		});
		GridData domainExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		domainExpression.setLayoutData(domainExpressionData);
		domainExpression.setID(EsbViewsRepository.NTLMMediator.Properties.domainExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.domainExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDomainExpressionFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createNtlmVersionExpressionFlatComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression, EsbMessages.NTLMMediatorPropertiesEditionPart_NtlmVersionExpressionLabel);
		ntlmVersionExpression = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression, EsbViewsRepository.SWT_KIND));
		ntlmVersionExpression.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		ntlmVersionExpression.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NTLMMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getNtlmVersionExpression()));
			}

		});
		GridData ntlmVersionExpressionData = new GridData(GridData.FILL_HORIZONTAL);
		ntlmVersionExpression.setLayoutData(ntlmVersionExpressionData);
		ntlmVersionExpression.setID(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNtlmVersionExpressionFlatComboViewer

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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getUsername()
	 * 
	 */
	public String getUsername() {
		return username.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setUsername(String newValue)
	 * 
	 */
	public void setUsername(String newValue) {
		if (newValue != null) {
			username.setText(newValue);
		} else {
			username.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.username);
		if (eefElementEditorReadOnlyState && username.isEnabled()) {
			username.setEnabled(false);
			username.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !username.isEnabled()) {
			username.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getPassword()
	 * 
	 */
	public String getPassword() {
		return password.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setPassword(String newValue)
	 * 
	 */
	public void setPassword(String newValue) {
		if (newValue != null) {
			password.setText(newValue);
		} else {
			password.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.password);
		if (eefElementEditorReadOnlyState && password.isEnabled()) {
			password.setEnabled(false);
			password.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !password.isEnabled()) {
			password.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getHost()
	 * 
	 */
	public String getHost() {
		return host.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setHost(String newValue)
	 * 
	 */
	public void setHost(String newValue) {
		if (newValue != null) {
			host.setText(newValue);
		} else {
			host.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.host);
		if (eefElementEditorReadOnlyState && host.isEnabled()) {
			host.setEnabled(false);
			host.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !host.isEnabled()) {
			host.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDomain()
	 * 
	 */
	public String getDomain() {
		return domain.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDomain(String newValue)
	 * 
	 */
	public void setDomain(String newValue) {
		if (newValue != null) {
			domain.setText(newValue);
		} else {
			domain.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.domain);
		if (eefElementEditorReadOnlyState && domain.isEnabled()) {
			domain.setEnabled(false);
			domain.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !domain.isEnabled()) {
			domain.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getNtlmVersion()
	 * 
	 */
	public String getNtlmVersion() {
		return ntlmVersion.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setNtlmVersion(String newValue)
	 * 
	 */
	public void setNtlmVersion(String newValue) {
		if (newValue != null) {
			ntlmVersion.setText(newValue);
		} else {
			ntlmVersion.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion);
		if (eefElementEditorReadOnlyState && ntlmVersion.isEnabled()) {
			ntlmVersion.setEnabled(false);
			ntlmVersion.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ntlmVersion.isEnabled()) {
			ntlmVersion.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getUsernameExpression()
	 * 
	 */
	public NamespacedProperty getUsernameExpression() {
		if (usernameExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) usernameExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (NamespacedProperty) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#initUsernameExpression(EObjectFlatComboSettings)
	 */
	public void initUsernameExpression(EObjectFlatComboSettings settings) {
		usernameExpression.setInput(settings);
		if (current != null) {
			usernameExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.usernameExpression);
		if (eefElementEditorReadOnlyState && usernameExpression.isEnabled()) {
			usernameExpression.setEnabled(false);
			usernameExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !usernameExpression.isEnabled()) {
			usernameExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setUsernameExpression(EObject newValue)
	 * 
	 */
	public void setUsernameExpression(NamespacedProperty newValue) {
		if (newValue != null) {
			usernameExpression.setSelection(new StructuredSelection(newValue));
		} else {
			usernameExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.usernameExpression);
		if (eefElementEditorReadOnlyState && usernameExpression.isEnabled()) {
			usernameExpression.setEnabled(false);
			usernameExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !usernameExpression.isEnabled()) {
			usernameExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setUsernameExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setUsernameExpressionButtonMode(ButtonsModeEnum newValue) {
		usernameExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addFilterUsernameExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUsernameExpression(ViewerFilter filter) {
		usernameExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addBusinessFilterUsernameExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUsernameExpression(ViewerFilter filter) {
		usernameExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getPasswordExpression()
	 * 
	 */
	public NamespacedProperty getPasswordExpression() {
		if (passwordExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) passwordExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (NamespacedProperty) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#initPasswordExpression(EObjectFlatComboSettings)
	 */
	public void initPasswordExpression(EObjectFlatComboSettings settings) {
		passwordExpression.setInput(settings);
		if (current != null) {
			passwordExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.passwordExpression);
		if (eefElementEditorReadOnlyState && passwordExpression.isEnabled()) {
			passwordExpression.setEnabled(false);
			passwordExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !passwordExpression.isEnabled()) {
			passwordExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setPasswordExpression(EObject newValue)
	 * 
	 */
	public void setPasswordExpression(NamespacedProperty newValue) {
		if (newValue != null) {
			passwordExpression.setSelection(new StructuredSelection(newValue));
		} else {
			passwordExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.passwordExpression);
		if (eefElementEditorReadOnlyState && passwordExpression.isEnabled()) {
			passwordExpression.setEnabled(false);
			passwordExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !passwordExpression.isEnabled()) {
			passwordExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setPasswordExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setPasswordExpressionButtonMode(ButtonsModeEnum newValue) {
		passwordExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addFilterPasswordExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPasswordExpression(ViewerFilter filter) {
		passwordExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addBusinessFilterPasswordExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPasswordExpression(ViewerFilter filter) {
		passwordExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getHostExpression()
	 * 
	 */
	public NamespacedProperty getHostExpression() {
		if (hostExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) hostExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (NamespacedProperty) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#initHostExpression(EObjectFlatComboSettings)
	 */
	public void initHostExpression(EObjectFlatComboSettings settings) {
		hostExpression.setInput(settings);
		if (current != null) {
			hostExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.hostExpression);
		if (eefElementEditorReadOnlyState && hostExpression.isEnabled()) {
			hostExpression.setEnabled(false);
			hostExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !hostExpression.isEnabled()) {
			hostExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setHostExpression(EObject newValue)
	 * 
	 */
	public void setHostExpression(NamespacedProperty newValue) {
		if (newValue != null) {
			hostExpression.setSelection(new StructuredSelection(newValue));
		} else {
			hostExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.hostExpression);
		if (eefElementEditorReadOnlyState && hostExpression.isEnabled()) {
			hostExpression.setEnabled(false);
			hostExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !hostExpression.isEnabled()) {
			hostExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setHostExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setHostExpressionButtonMode(ButtonsModeEnum newValue) {
		hostExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addFilterHostExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToHostExpression(ViewerFilter filter) {
		hostExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addBusinessFilterHostExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToHostExpression(ViewerFilter filter) {
		hostExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getDomainExpression()
	 * 
	 */
	public NamespacedProperty getDomainExpression() {
		if (domainExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) domainExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (NamespacedProperty) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#initDomainExpression(EObjectFlatComboSettings)
	 */
	public void initDomainExpression(EObjectFlatComboSettings settings) {
		domainExpression.setInput(settings);
		if (current != null) {
			domainExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.domainExpression);
		if (eefElementEditorReadOnlyState && domainExpression.isEnabled()) {
			domainExpression.setEnabled(false);
			domainExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !domainExpression.isEnabled()) {
			domainExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDomainExpression(EObject newValue)
	 * 
	 */
	public void setDomainExpression(NamespacedProperty newValue) {
		if (newValue != null) {
			domainExpression.setSelection(new StructuredSelection(newValue));
		} else {
			domainExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.domainExpression);
		if (eefElementEditorReadOnlyState && domainExpression.isEnabled()) {
			domainExpression.setEnabled(false);
			domainExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !domainExpression.isEnabled()) {
			domainExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setDomainExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDomainExpressionButtonMode(ButtonsModeEnum newValue) {
		domainExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addFilterDomainExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDomainExpression(ViewerFilter filter) {
		domainExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addBusinessFilterDomainExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDomainExpression(ViewerFilter filter) {
		domainExpression.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#getNtlmVersionExpression()
	 * 
	 */
	public NamespacedProperty getNtlmVersionExpression() {
		if (ntlmVersionExpression.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) ntlmVersionExpression.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (NamespacedProperty) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#initNtlmVersionExpression(EObjectFlatComboSettings)
	 */
	public void initNtlmVersionExpression(EObjectFlatComboSettings settings) {
		ntlmVersionExpression.setInput(settings);
		if (current != null) {
			ntlmVersionExpression.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression);
		if (eefElementEditorReadOnlyState && ntlmVersionExpression.isEnabled()) {
			ntlmVersionExpression.setEnabled(false);
			ntlmVersionExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ntlmVersionExpression.isEnabled()) {
			ntlmVersionExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setNtlmVersionExpression(EObject newValue)
	 * 
	 */
	public void setNtlmVersionExpression(NamespacedProperty newValue) {
		if (newValue != null) {
			ntlmVersionExpression.setSelection(new StructuredSelection(newValue));
		} else {
			ntlmVersionExpression.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.NTLMMediator.Properties.ntlmVersionExpression);
		if (eefElementEditorReadOnlyState && ntlmVersionExpression.isEnabled()) {
			ntlmVersionExpression.setEnabled(false);
			ntlmVersionExpression.setToolTipText(EsbMessages.NTLMMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !ntlmVersionExpression.isEnabled()) {
			ntlmVersionExpression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#setNtlmVersionExpressionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setNtlmVersionExpressionButtonMode(ButtonsModeEnum newValue) {
		ntlmVersionExpression.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addFilterNtlmVersionExpression(ViewerFilter filter)
	 * 
	 */
	public void addFilterToNtlmVersionExpression(ViewerFilter filter) {
		ntlmVersionExpression.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart#addBusinessFilterNtlmVersionExpression(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToNtlmVersionExpression(ViewerFilter filter) {
		ntlmVersionExpression.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.NTLMMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
