/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EJBMediatorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EJBMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected Text beanstalk;
	protected Text class_;
	protected Text method;
	protected EMFComboViewer sessionIdType;
	protected Text sessionIdLiteral;
	protected Button remove;
	protected Text target;
	protected Text jNDIName;
	protected ReferencesTable methodArguments;
	protected List<ViewerFilter> methodArgumentsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> methodArgumentsFilters = new ArrayList<ViewerFilter>();
	// Start of user code  for sessionIdExpression widgets declarations
	
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EJBMediatorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eJBMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eJBMediatorStep.addStep(EsbViewsRepository.EJBMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.beanstalk);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.class_);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.method);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.sessionIdType);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.remove);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.target);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.jNDIName);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.methodArguments);
		propertiesStep.addStep(EsbViewsRepository.EJBMediator.Properties.sessionIdExpression);
		
		
		composer = new PartComposer(eJBMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.EJBMediator.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.reverse) {
					return createReverseCheckbox(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.beanstalk) {
					return createBeanstalkText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.class_) {
					return createClass_Text(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.method) {
					return createMethodText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.sessionIdType) {
					return createSessionIdTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral) {
					return createSessionIdLiteralText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.remove) {
					return createRemoveCheckbox(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.target) {
					return createTargetText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.jNDIName) {
					return createJNDINameText(parent);
				}
				if (key == EsbViewsRepository.EJBMediator.Properties.methodArguments) {
					return createMethodArgumentsAdvancedTableComposition(parent);
				}
				// Start of user code for sessionIdExpression addToPart creation
				
				// End of user code
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
		propertiesGroup.setText(EsbMessages.EJBMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.description, EsbMessages.EJBMediatorPropertiesEditionPart_DescriptionLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, EsbViewsRepository.EJBMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.description, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	protected Composite createCommentsListMultiValuedEditor(Composite parent) {
		commentsList = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.EJBMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = new Button(parent, SWT.NONE);
		editCommentsList.setText(getDescription(EsbViewsRepository.EJBMediator.Properties.commentsList, EsbMessages.EJBMediatorPropertiesEditionPart_CommentsListLabel));
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
						commentsList.getShell(), "EJBMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.EJBMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(Composite parent) {
		reverse = new Button(parent, SWT.CHECK);
		reverse.setText(getDescription(EsbViewsRepository.EJBMediator.Properties.reverse, EsbMessages.EJBMediatorPropertiesEditionPart_ReverseLabel));
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.EJBMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.reverse, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createBeanstalkText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.beanstalk, EsbMessages.EJBMediatorPropertiesEditionPart_BeanstalkLabel);
		beanstalk = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData beanstalkData = new GridData(GridData.FILL_HORIZONTAL);
		beanstalk.setLayoutData(beanstalkData);
		beanstalk.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.beanstalk, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, beanstalk.getText()));
			}

		});
		beanstalk.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.beanstalk, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, beanstalk.getText()));
				}
			}

		});
		EditingUtils.setID(beanstalk, EsbViewsRepository.EJBMediator.Properties.beanstalk);
		EditingUtils.setEEFtype(beanstalk, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.beanstalk, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBeanstalkText

		// End of user code
		return parent;
	}

	
	protected Composite createClass_Text(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.class_, EsbMessages.EJBMediatorPropertiesEditionPart_Class_Label);
		class_ = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData class_Data = new GridData(GridData.FILL_HORIZONTAL);
		class_.setLayoutData(class_Data);
		class_.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.class_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, class_.getText()));
			}

		});
		class_.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.class_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, class_.getText()));
				}
			}

		});
		EditingUtils.setID(class_, EsbViewsRepository.EJBMediator.Properties.class_);
		EditingUtils.setEEFtype(class_, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.class_, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createClass_Text

		// End of user code
		return parent;
	}

	
	protected Composite createMethodText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.method, EsbMessages.EJBMediatorPropertiesEditionPart_MethodLabel);
		method = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData methodData = new GridData(GridData.FILL_HORIZONTAL);
		method.setLayoutData(methodData);
		method.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.method, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, method.getText()));
			}

		});
		method.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.method, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, method.getText()));
				}
			}

		});
		EditingUtils.setID(method, EsbViewsRepository.EJBMediator.Properties.method);
		EditingUtils.setEEFtype(method, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.method, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMethodText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createSessionIdTypeEMFComboViewer(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.sessionIdType, EsbMessages.EJBMediatorPropertiesEditionPart_SessionIdTypeLabel);
		sessionIdType = new EMFComboViewer(parent);
		sessionIdType.setContentProvider(new ArrayContentProvider());
		sessionIdType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sessionIdTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sessionIdType.getCombo().setLayoutData(sessionIdTypeData);
                sessionIdType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		sessionIdType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.sessionIdType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSessionIdType()));
			}

		});
		sessionIdType.setID(EsbViewsRepository.EJBMediator.Properties.sessionIdType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.sessionIdType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSessionIdTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSessionIdLiteralText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral, EsbMessages.EJBMediatorPropertiesEditionPart_SessionIdLiteralLabel);
		sessionIdLiteral = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sessionIdLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		sessionIdLiteral.setLayoutData(sessionIdLiteralData);
		sessionIdLiteral.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sessionIdLiteral.getText()));
			}

		});
		sessionIdLiteral.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sessionIdLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(sessionIdLiteral, EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral);
		EditingUtils.setEEFtype(sessionIdLiteral, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSessionIdLiteralText

		// End of user code
		return parent;
	}

	
	protected Composite createRemoveCheckbox(Composite parent) {
		remove = new Button(parent, SWT.CHECK);
		remove.setText(getDescription(EsbViewsRepository.EJBMediator.Properties.remove, EsbMessages.EJBMediatorPropertiesEditionPart_RemoveLabel));
		remove.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.remove, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(remove.getSelection())));
			}

		});
		GridData removeData = new GridData(GridData.FILL_HORIZONTAL);
		removeData.horizontalSpan = 2;
		remove.setLayoutData(removeData);
		EditingUtils.setID(remove, EsbViewsRepository.EJBMediator.Properties.remove);
		EditingUtils.setEEFtype(remove, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.remove, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createRemoveCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createTargetText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.target, EsbMessages.EJBMediatorPropertiesEditionPart_TargetLabel);
		target = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
		target.setLayoutData(targetData);
		target.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.target, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, target.getText()));
			}

		});
		target.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.target, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, target.getText()));
				}
			}

		});
		EditingUtils.setID(target, EsbViewsRepository.EJBMediator.Properties.target);
		EditingUtils.setEEFtype(target, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.target, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetText

		// End of user code
		return parent;
	}

	
	protected Composite createJNDINameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.EJBMediator.Properties.jNDIName, EsbMessages.EJBMediatorPropertiesEditionPart_JNDINameLabel);
		jNDIName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData jNDINameData = new GridData(GridData.FILL_HORIZONTAL);
		jNDIName.setLayoutData(jNDINameData);
		jNDIName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.jNDIName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jNDIName.getText()));
			}

		});
		jNDIName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.jNDIName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, jNDIName.getText()));
				}
			}

		});
		EditingUtils.setID(jNDIName, EsbViewsRepository.EJBMediator.Properties.jNDIName);
		EditingUtils.setEEFtype(jNDIName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.jNDIName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createJNDINameText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createMethodArgumentsAdvancedTableComposition(Composite parent) {
		this.methodArguments = new ReferencesTable(getDescription(EsbViewsRepository.EJBMediator.Properties.methodArguments, EsbMessages.EJBMediatorPropertiesEditionPart_MethodArgumentsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.methodArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				methodArguments.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.methodArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				methodArguments.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.methodArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				methodArguments.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.methodArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				methodArguments.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.methodArgumentsFilters) {
			this.methodArguments.addFilter(filter);
		}
		this.methodArguments.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.EJBMediator.Properties.methodArguments, EsbViewsRepository.SWT_KIND));
		this.methodArguments.createControls(parent);
		this.methodArguments.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EJBMediatorPropertiesEditionPartImpl.this, EsbViewsRepository.EJBMediator.Properties.methodArguments, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData methodArgumentsData = new GridData(GridData.FILL_HORIZONTAL);
		methodArgumentsData.horizontalSpan = 3;
		this.methodArguments.setLayoutData(methodArgumentsData);
		this.methodArguments.setLowerBound(0);
		this.methodArguments.setUpperBound(-1);
		methodArguments.setID(EsbViewsRepository.EJBMediator.Properties.methodArguments);
		methodArguments.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createMethodArgumentsAdvancedTableComposition

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getBeanstalk()
	 * 
	 */
	public String getBeanstalk() {
		return beanstalk.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setBeanstalk(String newValue)
	 * 
	 */
	public void setBeanstalk(String newValue) {
		if (newValue != null) {
			beanstalk.setText(newValue);
		} else {
			beanstalk.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.beanstalk);
		if (eefElementEditorReadOnlyState && beanstalk.isEnabled()) {
			beanstalk.setEnabled(false);
			beanstalk.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !beanstalk.isEnabled()) {
			beanstalk.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getClass_()
	 * 
	 */
	public String getClass_() {
		return class_.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setClass_(String newValue)
	 * 
	 */
	public void setClass_(String newValue) {
		if (newValue != null) {
			class_.setText(newValue);
		} else {
			class_.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.class_);
		if (eefElementEditorReadOnlyState && class_.isEnabled()) {
			class_.setEnabled(false);
			class_.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !class_.isEnabled()) {
			class_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getMethod()
	 * 
	 */
	public String getMethod() {
		return method.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setMethod(String newValue)
	 * 
	 */
	public void setMethod(String newValue) {
		if (newValue != null) {
			method.setText(newValue);
		} else {
			method.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.method);
		if (eefElementEditorReadOnlyState && method.isEnabled()) {
			method.setEnabled(false);
			method.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !method.isEnabled()) {
			method.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getSessionIdType()
	 * 
	 */
	public Enumerator getSessionIdType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sessionIdType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#initSessionIdType(Object input, Enumerator current)
	 */
	public void initSessionIdType(Object input, Enumerator current) {
		sessionIdType.setInput(input);
		sessionIdType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.sessionIdType);
		if (eefElementEditorReadOnlyState && sessionIdType.isEnabled()) {
			sessionIdType.setEnabled(false);
			sessionIdType.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sessionIdType.isEnabled()) {
			sessionIdType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setSessionIdType(Enumerator newValue)
	 * 
	 */
	public void setSessionIdType(Enumerator newValue) {
		sessionIdType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.sessionIdType);
		if (eefElementEditorReadOnlyState && sessionIdType.isEnabled()) {
			sessionIdType.setEnabled(false);
			sessionIdType.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sessionIdType.isEnabled()) {
			sessionIdType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getSessionIdLiteral()
	 * 
	 */
	public String getSessionIdLiteral() {
		return sessionIdLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setSessionIdLiteral(String newValue)
	 * 
	 */
	public void setSessionIdLiteral(String newValue) {
		if (newValue != null) {
			sessionIdLiteral.setText(newValue);
		} else {
			sessionIdLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral);
		if (eefElementEditorReadOnlyState && sessionIdLiteral.isEnabled()) {
			sessionIdLiteral.setEnabled(false);
			sessionIdLiteral.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sessionIdLiteral.isEnabled()) {
			sessionIdLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getRemove()
	 * 
	 */
	public Boolean getRemove() {
		return Boolean.valueOf(remove.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setRemove(Boolean newValue)
	 * 
	 */
	public void setRemove(Boolean newValue) {
		if (newValue != null) {
			remove.setSelection(newValue.booleanValue());
		} else {
			remove.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.remove);
		if (eefElementEditorReadOnlyState && remove.isEnabled()) {
			remove.setEnabled(false);
			remove.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !remove.isEnabled()) {
			remove.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getTarget()
	 * 
	 */
	public String getTarget() {
		return target.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setTarget(String newValue)
	 * 
	 */
	public void setTarget(String newValue) {
		if (newValue != null) {
			target.setText(newValue);
		} else {
			target.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.target);
		if (eefElementEditorReadOnlyState && target.isEnabled()) {
			target.setEnabled(false);
			target.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
			target.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#getJNDIName()
	 * 
	 */
	public String getJNDIName() {
		return jNDIName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#setJNDIName(String newValue)
	 * 
	 */
	public void setJNDIName(String newValue) {
		if (newValue != null) {
			jNDIName.setText(newValue);
		} else {
			jNDIName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.jNDIName);
		if (eefElementEditorReadOnlyState && jNDIName.isEnabled()) {
			jNDIName.setEnabled(false);
			jNDIName.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !jNDIName.isEnabled()) {
			jNDIName.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#initMethodArguments(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMethodArguments(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		methodArguments.setContentProvider(contentProvider);
		methodArguments.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EJBMediator.Properties.methodArguments);
		if (eefElementEditorReadOnlyState && methodArguments.isEnabled()) {
			methodArguments.setEnabled(false);
			methodArguments.setToolTipText(EsbMessages.EJBMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !methodArguments.isEnabled()) {
			methodArguments.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#updateMethodArguments()
	 * 
	 */
	public void updateMethodArguments() {
	methodArguments.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#addFilterMethodArguments(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMethodArguments(ViewerFilter filter) {
		methodArgumentsFilters.add(filter);
		if (this.methodArguments != null) {
			this.methodArguments.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#addBusinessFilterMethodArguments(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMethodArguments(ViewerFilter filter) {
		methodArgumentsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart#isContainedInMethodArgumentsTable(EObject element)
	 * 
	 */
	public boolean isContainedInMethodArgumentsTable(EObject element) {
		return ((ReferencesTableSettings)methodArguments.getInput()).contains(element);
	}






	// Start of user code for sessionIdExpression specific getters and setters implementation
    @Override
    public NamespacedProperty getSessionIdExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSessionIdExpression(NamespacedProperty nameSpacedProperty) {
        // TODO Auto-generated method stub
        
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.EJBMediator_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
