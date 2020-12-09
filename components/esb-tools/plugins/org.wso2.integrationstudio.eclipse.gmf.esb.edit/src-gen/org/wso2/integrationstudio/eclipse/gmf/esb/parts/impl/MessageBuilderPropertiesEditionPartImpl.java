/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.MessageBuilderPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MessageBuilderPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MessageBuilderPropertiesEditionPart {

	protected Text contentType;
	protected Text builderClass;
	protected Text formatterClass;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MessageBuilderPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence messageBuilderStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = messageBuilderStep.addStep(EsbViewsRepository.MessageBuilder.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.contentType);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.builderClass);
		propertiesStep.addStep(EsbViewsRepository.MessageBuilder.Properties.formatterClass);
		
		
		composer = new PartComposer(messageBuilderStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.MessageBuilder.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.contentType) {
					return createContentTypeText(parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.builderClass) {
					return createBuilderClassText(parent);
				}
				if (key == EsbViewsRepository.MessageBuilder.Properties.formatterClass) {
					return createFormatterClassText(parent);
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
		propertiesGroup.setText(EsbMessages.MessageBuilderPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createContentTypeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.contentType, EsbMessages.MessageBuilderPropertiesEditionPart_ContentTypeLabel);
		contentType = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData contentTypeData = new GridData(GridData.FILL_HORIZONTAL);
		contentType.setLayoutData(contentTypeData);
		
        contentType.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            MessageBuilderPropertiesEditionPartImpl.this,
                            EsbViewsRepository.MessageBuilder.Properties.contentType, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, contentType.getText()));
            }

        });
        contentType.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                MessageBuilderPropertiesEditionPartImpl.this,
                                EsbViewsRepository.MessageBuilder.Properties.contentType, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, contentType.getText()));
                }
            }

		});
        
		EditingUtils.setID(contentType, EsbViewsRepository.MessageBuilder.Properties.contentType);
		EditingUtils.setEEFtype(contentType, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.contentType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createContentTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createBuilderClassText(Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.builderClass, EsbMessages.MessageBuilderPropertiesEditionPart_BuilderClassLabel);
		builderClass = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData builderClassData = new GridData(GridData.FILL_HORIZONTAL);
		builderClass.setLayoutData(builderClassData);
		
        builderClass.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            MessageBuilderPropertiesEditionPartImpl.this,
                            EsbViewsRepository.MessageBuilder.Properties.builderClass, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, builderClass.getText()));
            }

        });
        builderClass.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(MessageBuilderPropertiesEditionPartImpl.this,
                                        EsbViewsRepository.MessageBuilder.Properties.builderClass,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        builderClass.getText()));
                }
            }

        });
		
		EditingUtils.setID(builderClass, EsbViewsRepository.MessageBuilder.Properties.builderClass);
		EditingUtils.setEEFtype(builderClass, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.builderClass, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBuilderClassText

		// End of user code
		return parent;
	}

	
	protected Composite createFormatterClassText(Composite parent) {
		createDescription(parent, EsbViewsRepository.MessageBuilder.Properties.formatterClass, EsbMessages.MessageBuilderPropertiesEditionPart_FormatterClassLabel);
		formatterClass = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData formatterClassData = new GridData(GridData.FILL_HORIZONTAL);
		formatterClass.setLayoutData(formatterClassData);
		
        formatterClass.addFocusListener(new FocusAdapter() {

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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            MessageBuilderPropertiesEditionPartImpl.this,
                            EsbViewsRepository.MessageBuilder.Properties.formatterClass, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, formatterClass.getText()));
            }

        });
        formatterClass.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(MessageBuilderPropertiesEditionPartImpl.this,
                                        EsbViewsRepository.MessageBuilder.Properties.formatterClass,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                        formatterClass.getText()));
                }
            }

        });
		
		EditingUtils.setID(formatterClass, EsbViewsRepository.MessageBuilder.Properties.formatterClass);
		EditingUtils.setEEFtype(formatterClass, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.MessageBuilder.Properties.formatterClass, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
