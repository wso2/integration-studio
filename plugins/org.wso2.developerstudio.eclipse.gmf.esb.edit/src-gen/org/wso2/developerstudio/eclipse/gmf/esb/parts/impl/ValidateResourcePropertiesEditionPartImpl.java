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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateResourcePropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.EnrichMediatorPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
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
public class ValidateResourcePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ValidateResourcePropertiesEditionPart {

	protected Text location;
	// Start of user code  for locationKey widgets declarations
    protected RegistryKeyProperty locationKey;
    protected Text locationKeyText;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ValidateResourcePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence validateResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = validateResourceStep.addStep(EsbViewsRepository.ValidateResource.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ValidateResource.Properties.location);
		propertiesStep.addStep(EsbViewsRepository.ValidateResource.Properties.locationKey);
		
		
		composer = new PartComposer(validateResourceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ValidateResource.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ValidateResource.Properties.location) {
					return createLocationText(parent);
				}
				// Start of user code for locationKey addToPart creation
                if (key == EsbViewsRepository.ValidateResource.Properties.locationKey) {
                    return createLocationKeyWidget(parent);
                }
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

    /**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.ValidateResourcePropertiesEditionPart_PropertiesGroupLabel);
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
     */
	protected Composite createLocationText(Composite parent) {
		createDescription(parent, EsbViewsRepository.ValidateResource.Properties.location, EsbMessages.ValidateResourcePropertiesEditionPart_LocationLabel);
		location = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData locationData = new GridData(GridData.FILL_HORIZONTAL);
		location.setLayoutData(locationData);

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
                    if (propertiesEditionComponent != null) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                ValidateResourcePropertiesEditionPartImpl.this,
                                EsbViewsRepository.ValidateResource.Properties.location, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, location.getText()));
                    }
                }
			}

		});
		EditingUtils.setID(location, EsbViewsRepository.ValidateResource.Properties.location);
		EditingUtils.setEEFtype(location, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateResource.Properties.location, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateResourcePropertiesEditionPart#getLocation()
	 * 
	 */
	public String getLocation() {
		return location.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ValidateResourcePropertiesEditionPart#setLocation(String newValue)
	 * 
	 */
	public void setLocation(String newValue) {
		if (newValue != null) {
			location.setText(newValue);
		} else {
			location.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ValidateResource.Properties.location);
		if (eefElementEditorReadOnlyState && location.isEnabled()) {
			location.setEnabled(false);
			location.setToolTipText(EsbMessages.ValidateResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !location.isEnabled()) {
			location.setEnabled(true);
		}	
		
	}






	// Start of user code for locationKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getLocationKey() {
        return locationKey;
    }

    @Override
    public void setLocationKey(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            locationKeyText.setText(registryKeyProperty.getKeyValue());
            locationKey = registryKeyProperty;
        }
    }


	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ValidateResource_Part_Title;
	}

	// Start of user code additional methods
	   protected Composite createLocationKeyWidget(Composite parent) {
	       Control itemLabel = createDescription(parent,
	                EsbViewsRepository.ValidateResource.Properties.locationKey,
	                EsbMessages.ValidateResourcePropertiesEditionPart_LocationKeyLabel);
	        if (locationKey == null) {
	            locationKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
	        }
	        String initValueExpression = locationKey.getKeyValue().isEmpty() ? "" : locationKey.getKeyValue();
	        locationKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
	        locationKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
	        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
	        locationKeyText.setLayoutData(valueData);
	        locationKeyText.addMouseListener(new MouseListener(){

	            @Override
	            public void mouseDoubleClick(MouseEvent e) {
	                // TODO Auto-generated method stub
	                
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, locationKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.create();
                    dialog.getShell().setText("Resource key");
                    dialog.open();
                    locationKeyText.setText(locationKey.getKeyValue());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(ValidateResourcePropertiesEditionPartImpl.this,
                                    EsbViewsRepository.ValidateResource.Properties.locationKey,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLocationKey()));
	            }

	            @Override
	            public void mouseUp(MouseEvent e) {
	                // TODO Auto-generated method stub
	                
	            }
	            
	        });
	        
	        locationKeyText.addKeyListener(new KeyListener() {
                
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                        EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                                SWT.NULL, locationKey, new ArrayList<NamedEntityDescriptor>());
                        dialog.create();
                        dialog.getShell().setText("Resource key");
                        dialog.open();
                        locationKeyText.setText(locationKey.getKeyValue());
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(ValidateResourcePropertiesEditionPartImpl.this,
                                        EsbViewsRepository.ValidateResource.Properties.locationKey,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLocationKey()));
                    }
                }
                
                @Override
                public void keyPressed(KeyEvent e) {}
                
            });
	        
	        EditingUtils.setID(locationKeyText, EsbViewsRepository.ValidateResource.Properties.locationKey);
	        EditingUtils.setEEFtype(locationKeyText, "eef::Text");
	        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ValidateResource.Properties.locationKey, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	       
	        return parent;
	    }
	// End of user code


}
