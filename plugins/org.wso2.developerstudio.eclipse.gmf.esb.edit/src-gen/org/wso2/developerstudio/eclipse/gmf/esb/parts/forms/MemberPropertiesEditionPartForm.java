/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MemberPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MemberPropertiesEditionPart {

	protected Text hostName;
	protected Text httpPort;
	protected Text httpsPort;



	/**
	 * For {@link ISection} use only.
	 */
	public MemberPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MemberPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence memberStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = memberStep.addStep(EsbViewsRepository.Member.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.hostName);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.httpPort);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.httpsPort);
		
		
		composer = new PartComposer(memberStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Member.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Member.Properties.hostName) {
					return createHostNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Member.Properties.httpPort) {
					return createHttpPortText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Member.Properties.httpsPort) {
					return createHttpsPortText(widgetFactory, parent);
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
		propertiesSection.setText(EsbMessages.MemberPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createHostNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.hostName, EsbMessages.MemberPropertiesEditionPart_HostNameLabel);
		hostName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		hostName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData hostNameData = new GridData(GridData.FILL_HORIZONTAL);
		hostName.setLayoutData(hostNameData);
		hostName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MemberPropertiesEditionPartForm.this,
							EsbViewsRepository.Member.Properties.hostName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MemberPropertiesEditionPartForm.this,
									EsbViewsRepository.Member.Properties.hostName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, hostName.getText()));
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
									MemberPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		hostName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartForm.this, EsbViewsRepository.Member.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
				}
			}
		});
		EditingUtils.setID(hostName, EsbViewsRepository.Member.Properties.hostName);
		EditingUtils.setEEFtype(hostName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.hostName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostNameText

		// End of user code
		return parent;
	}

	
	protected Composite createHttpPortText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.httpPort, EsbMessages.MemberPropertiesEditionPart_HttpPortLabel);
		httpPort = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		httpPort.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData httpPortData = new GridData(GridData.FILL_HORIZONTAL);
		httpPort.setLayoutData(httpPortData);
		httpPort.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MemberPropertiesEditionPartForm.this,
							EsbViewsRepository.Member.Properties.httpPort,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpPort.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MemberPropertiesEditionPartForm.this,
									EsbViewsRepository.Member.Properties.httpPort,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, httpPort.getText()));
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
									MemberPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		httpPort.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartForm.this, EsbViewsRepository.Member.Properties.httpPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpPort.getText()));
				}
			}
		});
		EditingUtils.setID(httpPort, EsbViewsRepository.Member.Properties.httpPort);
		EditingUtils.setEEFtype(httpPort, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.httpPort, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHttpPortText

		// End of user code
		return parent;
	}

	
	protected Composite createHttpsPortText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.httpsPort, EsbMessages.MemberPropertiesEditionPart_HttpsPortLabel);
		httpsPort = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		httpsPort.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData httpsPortData = new GridData(GridData.FILL_HORIZONTAL);
		httpsPort.setLayoutData(httpsPortData);
		httpsPort.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							MemberPropertiesEditionPartForm.this,
							EsbViewsRepository.Member.Properties.httpsPort,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpsPort.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									MemberPropertiesEditionPartForm.this,
									EsbViewsRepository.Member.Properties.httpsPort,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, httpsPort.getText()));
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
									MemberPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		httpsPort.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartForm.this, EsbViewsRepository.Member.Properties.httpsPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpsPort.getText()));
				}
			}
		});
		EditingUtils.setID(httpsPort, EsbViewsRepository.Member.Properties.httpsPort);
		EditingUtils.setEEFtype(httpsPort, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.httpsPort, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createHttpsPortText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#getHostName()
	 * 
	 */
	public String getHostName() {
		return hostName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#setHostName(String newValue)
	 * 
	 */
	public void setHostName(String newValue) {
		if (newValue != null) {
			hostName.setText(newValue);
		} else {
			hostName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Member.Properties.hostName);
		if (eefElementEditorReadOnlyState && hostName.isEnabled()) {
			hostName.setEnabled(false);
			hostName.setToolTipText(EsbMessages.Member_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !hostName.isEnabled()) {
			hostName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#getHttpPort()
	 * 
	 */
	public String getHttpPort() {
		return httpPort.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#setHttpPort(String newValue)
	 * 
	 */
	public void setHttpPort(String newValue) {
		if (newValue != null) {
			httpPort.setText(newValue);
		} else {
			httpPort.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Member.Properties.httpPort);
		if (eefElementEditorReadOnlyState && httpPort.isEnabled()) {
			httpPort.setEnabled(false);
			httpPort.setToolTipText(EsbMessages.Member_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !httpPort.isEnabled()) {
			httpPort.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#getHttpsPort()
	 * 
	 */
	public String getHttpsPort() {
		return httpsPort.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart#setHttpsPort(String newValue)
	 * 
	 */
	public void setHttpsPort(String newValue) {
		if (newValue != null) {
			httpsPort.setText(newValue);
		} else {
			httpsPort.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Member.Properties.httpsPort);
		if (eefElementEditorReadOnlyState && httpsPort.isEnabled()) {
			httpsPort.setEnabled(false);
			httpsPort.setToolTipText(EsbMessages.Member_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !httpsPort.isEnabled()) {
			httpsPort.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Member_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
