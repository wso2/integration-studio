/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart;

import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MessageBuilderPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MessageBuilderPropertiesEditionPart {

	protected Text contentType;
	protected Text builderClass;
	protected Text formatterClass;



	/**
	 * For {@link ISection} use only.
	 */
	public MessageBuilderPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MessageBuilderPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence messageBuilderStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = messageBuilderStep.addStep(EsbViewsRepository.MessageBuilder.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.contentType);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.builderClass);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.formatterClass);
		
		
		composer = new PartComposer(messageBuilderStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MessageBuilder.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.contentType) {
					return createContentTypeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.builderClass) {
					return createBuilderClassText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.formatterClass) {
					return createFormatterClassText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.MessageBuilderPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createContentTypeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.contentType, EsbMessages.MessageBuilderPropertiesEditionPart_ContentTypeLabel);
		contentType = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		contentType.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData contentTypeData = new GridData(GridData.FILL_HORIZONTAL);
		contentType.setLayoutData(contentTypeData);
		contentType.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageBuilderPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageBuilder.Properties.contentType,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, contentType.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageBuilderPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageBuilder.Properties.contentType,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, contentType.getText()));
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
									MessageBuilderPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		contentType.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageBuilderPropertiesEditionPartForm.this, EsbViewsRepository.MessageBuilder.Properties.contentType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, contentType.getText()));
				}
			}
		});
		EditingUtils.setID(contentType, EsbViewsRepository.MessageBuilder.Properties.contentType);
		EditingUtils.setEEFtype(contentType, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.contentType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createContentTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createBuilderClassText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.builderClass, EsbMessages.MessageBuilderPropertiesEditionPart_BuilderClassLabel);
		builderClass = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		builderClass.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData builderClassData = new GridData(GridData.FILL_HORIZONTAL);
		builderClass.setLayoutData(builderClassData);
		builderClass.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageBuilderPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageBuilder.Properties.builderClass,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, builderClass.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageBuilderPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageBuilder.Properties.builderClass,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, builderClass.getText()));
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
									MessageBuilderPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		builderClass.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageBuilderPropertiesEditionPartForm.this, EsbViewsRepository.MessageBuilder.Properties.builderClass, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, builderClass.getText()));
				}
			}
		});
		EditingUtils.setID(builderClass, EsbViewsRepository.MessageBuilder.Properties.builderClass);
		EditingUtils.setEEFtype(builderClass, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.builderClass, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBuilderClassText

		// End of user code
		return parent;
	}

	
	protected Composite createFormatterClassText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.formatterClass, EsbMessages.MessageBuilderPropertiesEditionPart_FormatterClassLabel);
		formatterClass = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		formatterClass.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData formatterClassData = new GridData(GridData.FILL_HORIZONTAL);
		formatterClass.setLayoutData(formatterClassData);
		formatterClass.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MessageBuilderPropertiesEditionPartForm.this,
							EsbViewsRepository.MessageBuilder.Properties.formatterClass,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, formatterClass.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MessageBuilderPropertiesEditionPartForm.this,
									EsbViewsRepository.MessageBuilder.Properties.formatterClass,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, formatterClass.getText()));
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
									MessageBuilderPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		formatterClass.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MessageBuilderPropertiesEditionPartForm.this, EsbViewsRepository.MessageBuilder.Properties.formatterClass, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, formatterClass.getText()));
				}
			}
		});
		EditingUtils.setID(formatterClass, EsbViewsRepository.MessageBuilder.Properties.formatterClass);
		EditingUtils.setEEFtype(formatterClass, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.formatterClass, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFormatterClassText

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#getContentType()
	 * 
	 */
	public String getContentType() {
		return contentType.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#setContentType(String newValue)
	 * 
	 */
	public void setContentType(String newValue) {
		if (newValue != null) {
			contentType.setText(newValue);
		} else {
			contentType.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageBuilder.Properties.contentType);
		if (eefElementEditorReadOnlyState && contentType.isEnabled()) {
			contentType.setEnabled(false);
			contentType.setToolTipText(EsbMessages.MessageBuilder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !contentType.isEnabled()) {
			contentType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#getBuilderClass()
	 * 
	 */
	public String getBuilderClass() {
		return builderClass.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#setBuilderClass(String newValue)
	 * 
	 */
	public void setBuilderClass(String newValue) {
		if (newValue != null) {
			builderClass.setText(newValue);
		} else {
			builderClass.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageBuilder.Properties.builderClass);
		if (eefElementEditorReadOnlyState && builderClass.isEnabled()) {
			builderClass.setEnabled(false);
			builderClass.setToolTipText(EsbMessages.MessageBuilder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !builderClass.isEnabled()) {
			builderClass.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#getFormatterClass()
	 * 
	 */
	public String getFormatterClass() {
		return formatterClass.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart#setFormatterClass(String newValue)
	 * 
	 */
	public void setFormatterClass(String newValue) {
		if (newValue != null) {
			formatterClass.setText(newValue);
		} else {
			formatterClass.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.MessageBuilder.Properties.formatterClass);
		if (eefElementEditorReadOnlyState && formatterClass.isEnabled()) {
			formatterClass.setEnabled(false);
			formatterClass.setToolTipText(EsbMessages.MessageBuilder_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !formatterClass.isEnabled()) {
			formatterClass.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.MessageBuilder_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
