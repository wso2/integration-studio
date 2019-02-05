/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MemberPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class MemberPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MemberPropertiesEditionPart {

	protected Text hostName;
	protected Text httpPort;
	protected Text httpsPort;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MemberPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence memberStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = memberStep.addStep(EsbViewsRepository.Member.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.hostName);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.httpPort);
		propertiesStep.addStep(EsbViewsRepository.Member.Properties.httpsPort);
		
		
		composer = new PartComposer(memberStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Member.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.Member.Properties.hostName) {
					return createHostNameText(parent);
				}
				if (key == EsbViewsRepository.Member.Properties.httpPort) {
					return createHttpPortText(parent);
				}
				if (key == EsbViewsRepository.Member.Properties.httpsPort) {
					return createHttpsPortText(parent);
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
		propertiesGroup.setText(EsbMessages.MemberPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createHostNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.hostName, EsbMessages.MemberPropertiesEditionPart_HostNameLabel);
		hostName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData hostNameData = new GridData(GridData.FILL_HORIZONTAL);
		hostName.setLayoutData(hostNameData);
		hostName.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
			}

		});
		hostName.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.hostName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, hostName.getText()));
				}
			}

		});
		EditingUtils.setID(hostName, EsbViewsRepository.Member.Properties.hostName);
		EditingUtils.setEEFtype(hostName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.hostName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHostNameText

		// End of user code
		return parent;
	}

	
	protected Composite createHttpPortText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.httpPort, EsbMessages.MemberPropertiesEditionPart_HttpPortLabel);
		httpPort = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData httpPortData = new GridData(GridData.FILL_HORIZONTAL);
		httpPort.setLayoutData(httpPortData);
		httpPort.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.httpPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpPort.getText()));
			}

		});
		httpPort.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.httpPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpPort.getText()));
				}
			}

		});
		EditingUtils.setID(httpPort, EsbViewsRepository.Member.Properties.httpPort);
		EditingUtils.setEEFtype(httpPort, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.httpPort, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createHttpPortText

		// End of user code
		return parent;
	}

	
	protected Composite createHttpsPortText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Member.Properties.httpsPort, EsbMessages.MemberPropertiesEditionPart_HttpsPortLabel);
		httpsPort = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData httpsPortData = new GridData(GridData.FILL_HORIZONTAL);
		httpsPort.setLayoutData(httpsPortData);
		httpsPort.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.httpsPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpsPort.getText()));
			}

		});
		httpsPort.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MemberPropertiesEditionPartImpl.this, EsbViewsRepository.Member.Properties.httpsPort, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, httpsPort.getText()));
				}
			}

		});
		EditingUtils.setID(httpsPort, EsbViewsRepository.Member.Properties.httpsPort);
		EditingUtils.setEEFtype(httpsPort, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Member.Properties.httpsPort, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
