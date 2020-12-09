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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class LocalEntryPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, LocalEntryPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Text entryName;
	protected EMFComboViewer localEntryType;
	protected Text valueLiteral;
	protected Text valueXML;
	protected Text valueURL;



	/**
	 * For {@link ISection} use only.
	 */
	public LocalEntryPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LocalEntryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence localEntryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = localEntryStep.addStep(EsbViewsRepository.LocalEntry.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.description);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.entryName);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueXML);
		propertiesStep.addStep(EsbViewsRepository.LocalEntry.Properties.valueURL);
		
		
		composer = new PartComposer(localEntryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.LocalEntry.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.entryName) {
					return createEntryNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.localEntryType) {
					return createLocalEntryTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueLiteral) {
					return createValueLiteralText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueXML) {
					return createValueXMLText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.LocalEntry.Properties.valueURL) {
					return createValueURLText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.LocalEntryPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.description, EsbMessages.LocalEntryPropertiesEditionPart_DescriptionLabel);
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
							LocalEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.LocalEntry.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LocalEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.LocalEntry.Properties.description,
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
									LocalEntryPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.LocalEntry.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		EditingUtils.setID(commentsList, EsbViewsRepository.LocalEntry.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.LocalEntry.Properties.commentsList, EsbMessages.LocalEntryPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "LocalEntry", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.LocalEntry.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createEntryNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.entryName, EsbMessages.LocalEntryPropertiesEditionPart_EntryNameLabel);
		entryName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		entryName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData entryNameData = new GridData(GridData.FILL_HORIZONTAL);
		entryName.setLayoutData(entryNameData);
		entryName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LocalEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.LocalEntry.Properties.entryName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entryName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LocalEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.LocalEntry.Properties.entryName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, entryName.getText()));
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
									LocalEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		entryName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.entryName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, entryName.getText()));
				}
			}
		});
		EditingUtils.setID(entryName, EsbViewsRepository.LocalEntry.Properties.entryName);
		EditingUtils.setEEFtype(entryName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.entryName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEntryNameText

		// End of user code
		return parent;
	}

	/**
	 * @generated NOT
	 */
	protected Composite createLocalEntryTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.localEntryType, EsbMessages.LocalEntryPropertiesEditionPart_LocalEntryTypeLabel);
		localEntryType = new EMFComboViewer(parent);
		localEntryType.setContentProvider(new ArrayContentProvider());
		localEntryType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData localEntryTypeData = new GridData(GridData.FILL_HORIZONTAL);
		localEntryType.getCombo().setLayoutData(localEntryTypeData);
                localEntryType.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {

                    @Override
                    public void handleEvent(Event arg0) {
                        arg0.doit = false;
                    }
                });
		localEntryType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.localEntryType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLocalEntryType()));
			}

		});
		localEntryType.setID(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.localEntryType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLocalEntryTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueLiteralText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueLiteral, EsbMessages.LocalEntryPropertiesEditionPart_ValueLiteralLabel);
		valueLiteral = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueLiteral.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		valueLiteral.setLayoutData(valueLiteralData);
		valueLiteral.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LocalEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.LocalEntry.Properties.valueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LocalEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.LocalEntry.Properties.valueLiteral,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueLiteral.getText()));
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
									LocalEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueLiteral.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.valueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(valueLiteral, EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		EditingUtils.setEEFtype(valueLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueLiteral, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueLiteralText

		// End of user code
		return parent;
	}

	
	protected Composite createValueXMLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueXML, EsbMessages.LocalEntryPropertiesEditionPart_ValueXMLLabel);
		valueXML = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueXML.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueXMLData = new GridData(GridData.FILL_HORIZONTAL);
		valueXML.setLayoutData(valueXMLData);
		valueXML.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LocalEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.LocalEntry.Properties.valueXML,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueXML.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LocalEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.LocalEntry.Properties.valueXML,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueXML.getText()));
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
									LocalEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueXML.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.valueXML, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueXML.getText()));
				}
			}
		});
		EditingUtils.setID(valueXML, EsbViewsRepository.LocalEntry.Properties.valueXML);
		EditingUtils.setEEFtype(valueXML, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueXML, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueXMLText

		// End of user code
		return parent;
	}

	
	protected Composite createValueURLText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.LocalEntry.Properties.valueURL, EsbMessages.LocalEntryPropertiesEditionPart_ValueURLLabel);
		valueURL = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		valueURL.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData valueURLData = new GridData(GridData.FILL_HORIZONTAL);
		valueURL.setLayoutData(valueURLData);
		valueURL.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							LocalEntryPropertiesEditionPartForm.this,
							EsbViewsRepository.LocalEntry.Properties.valueURL,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueURL.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									LocalEntryPropertiesEditionPartForm.this,
									EsbViewsRepository.LocalEntry.Properties.valueURL,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, valueURL.getText()));
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
									LocalEntryPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		valueURL.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LocalEntryPropertiesEditionPartForm.this, EsbViewsRepository.LocalEntry.Properties.valueURL, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, valueURL.getText()));
				}
			}
		});
		EditingUtils.setID(valueURL, EsbViewsRepository.LocalEntry.Properties.valueURL);
		EditingUtils.setEEFtype(valueURL, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.LocalEntry.Properties.valueURL, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValueURLText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getEntryName()
	 * 
	 */
	public String getEntryName() {
		return entryName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setEntryName(String newValue)
	 * 
	 */
	public void setEntryName(String newValue) {
		if (newValue != null) {
			entryName.setText(newValue);
		} else {
			entryName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.entryName);
		if (eefElementEditorReadOnlyState && entryName.isEnabled()) {
			entryName.setEnabled(false);
			entryName.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entryName.isEnabled()) {
			entryName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getLocalEntryType()
	 * 
	 */
	public Enumerator getLocalEntryType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) localEntryType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#initLocalEntryType(Object input, Enumerator current)
	 */
	public void initLocalEntryType(Object input, Enumerator current) {
		localEntryType.setInput(input);
		localEntryType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		if (eefElementEditorReadOnlyState && localEntryType.isEnabled()) {
			localEntryType.setEnabled(false);
			localEntryType.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !localEntryType.isEnabled()) {
			localEntryType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setLocalEntryType(Enumerator newValue)
	 * 
	 */
	public void setLocalEntryType(Enumerator newValue) {
		localEntryType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.localEntryType);
		if (eefElementEditorReadOnlyState && localEntryType.isEnabled()) {
			localEntryType.setEnabled(false);
			localEntryType.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !localEntryType.isEnabled()) {
			localEntryType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueLiteral()
	 * 
	 */
	public String getValueLiteral() {
		return valueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueLiteral(String newValue)
	 * 
	 */
	public void setValueLiteral(String newValue) {
		if (newValue != null) {
			valueLiteral.setText(newValue);
		} else {
			valueLiteral.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueLiteral);
		if (eefElementEditorReadOnlyState && valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(false);
			valueLiteral.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueLiteral.isEnabled()) {
			valueLiteral.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueXML()
	 * 
	 */
	public String getValueXML() {
		return valueXML.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueXML(String newValue)
	 * 
	 */
	public void setValueXML(String newValue) {
		if (newValue != null) {
			valueXML.setText(newValue);
		} else {
			valueXML.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueXML);
		if (eefElementEditorReadOnlyState && valueXML.isEnabled()) {
			valueXML.setEnabled(false);
			valueXML.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueXML.isEnabled()) {
			valueXML.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#getValueURL()
	 * 
	 */
	public String getValueURL() {
		return valueURL.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart#setValueURL(String newValue)
	 * 
	 */
	public void setValueURL(String newValue) {
		if (newValue != null) {
			valueURL.setText(newValue);
		} else {
			valueURL.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.LocalEntry.Properties.valueURL);
		if (eefElementEditorReadOnlyState && valueURL.isEnabled()) {
			valueURL.setEnabled(false);
			valueURL.setToolTipText(EsbMessages.LocalEntry_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valueURL.isEnabled()) {
			valueURL.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.LocalEntry_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
