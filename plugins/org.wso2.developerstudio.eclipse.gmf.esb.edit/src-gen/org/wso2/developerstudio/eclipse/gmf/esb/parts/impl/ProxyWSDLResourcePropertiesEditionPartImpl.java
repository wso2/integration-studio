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
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyWSDLResourcePropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import java.util.ArrayList;
// End of user code

/**
 * 
 * 
 */
public class ProxyWSDLResourcePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProxyWSDLResourcePropertiesEditionPart {

	protected Text location;
	// Start of user code  for key widgets declarations
	protected RegistryKeyProperty key;
	protected Text keyText;
	protected Control[] keyElements;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProxyWSDLResourcePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence proxyWSDLResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = proxyWSDLResourceStep.addStep(EsbViewsRepository.ProxyWSDLResource.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ProxyWSDLResource.Properties.location);
		propertiesStep.addStep(EsbViewsRepository.ProxyWSDLResource.Properties.key);
		
		
		composer = new PartComposer(proxyWSDLResourceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ProxyWSDLResource.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ProxyWSDLResource.Properties.location) {
					return createLocationText(parent);
				}
				// Start of user code for key addToPart creation
				if (key == EsbViewsRepository.ProxyWSDLResource.Properties.key) {
                    return createKeyText(parent);
                }
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
		propertiesGroup.setText(EsbMessages.ProxyWSDLResourcePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

    /**
     * @generated NOT
     * 
     */
	protected Composite createLocationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ProxyWSDLResource.Properties.location, EsbMessages.ProxyWSDLResourcePropertiesEditionPart_LocationLabel);
		location = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData locationData = new GridData(GridData.FILL_HORIZONTAL);
		location.setLayoutData(locationData);
		location.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyWSDLResourcePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyWSDLResource.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
			}

		});
		location.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProxyWSDLResourcePropertiesEditionPartImpl.this, EsbViewsRepository.ProxyWSDLResource.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
				}
			}

		});
		EditingUtils.setID(location, EsbViewsRepository.ProxyWSDLResource.Properties.location);
		EditingUtils.setEEFtype(location, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ProxyWSDLResource.Properties.location, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLocationText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyWSDLResourcePropertiesEditionPart#getLocation()
	 * 
	 */
	public String getLocation() {
		return location.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyWSDLResourcePropertiesEditionPart#setLocation(String newValue)
	 * 
	 */
	public void setLocation(String newValue) {
		if (newValue != null) {
			location.setText(newValue);
		} else {
			location.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ProxyWSDLResource.Properties.location);
		if (eefElementEditorReadOnlyState && location.isEnabled()) {
			location.setEnabled(false);
			location.setToolTipText(EsbMessages.ProxyWSDLResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !location.isEnabled()) {
			location.setEnabled(true);
		}	
		
	}






	// Start of user code for key specific getters and setters implementation
	@Override
    public void setKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            key = registryKeyProperty;
            keyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getKey() {
        return key;
    }
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ProxyWSDLResource_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createKeyText(final Composite parent) {
        Control keyLabel = createDescription(parent, EsbViewsRepository.ProxyWSDLResource.Properties.key,
                EsbMessages.ProxyWSDLResourcePropertiesEditionPart_KeyLabel);

        if (key == null) {
            key = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        
        keyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        keyText.setLayoutData(valueData);
        keyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, key, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                keyText.setText(key.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyWSDLResourcePropertiesEditionPartImpl.this,
                                EsbViewsRepository.ProxyWSDLResource.Properties.key, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        keyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                   if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                       EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                               SWT.NULL, key, new ArrayList<NamedEntityDescriptor>());
                       dialog.open();
                       keyText.setText(key.getKeyValue());
                       propertiesEditionComponent
                               .firePropertiesChanged(new PropertiesEditionEvent(ProxyWSDLResourcePropertiesEditionPartImpl.this,
                                       EsbViewsRepository.ProxyWSDLResource.Properties.key, PropertiesEditionEvent.COMMIT,
                                       PropertiesEditionEvent.SET, null, getKey()));
                   }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(keyText, EsbViewsRepository.ProxyWSDLResource.Properties.key);
        EditingUtils.setEEFtype(keyText, "eef::Text");
        Control keyHelp = SWTUtils
                .createHelpButton(parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.ProxyWSDLResource.Properties.key, EsbViewsRepository.FORM_KIND),
                        null);
        keyElements = new Control[] { keyLabel, keyText, keyHelp };
        return parent;
    }
	// End of user code


}
