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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

import java.util.ArrayList;
// End of user code

/**
 * 
 * 
 */
public class XSLTResourcePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, XSLTResourcePropertiesEditionPart {

	protected Text location;
	// Start of user code  for resourceRegistryKey widgets declarations
	protected Text resourceRegistryKeyText;
	protected RegistryKeyProperty registryKey;
    protected Control[] resourceRegistryKeyElements;
    protected Control[] locationElements;
    protected Group propertiesGroup; 
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public XSLTResourcePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence xSLTResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = xSLTResourceStep.addStep(EsbViewsRepository.XSLTResource.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.XSLTResource.Properties.location);
		propertiesStep.addStep(EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey);
		
		
		composer = new PartComposer(xSLTResourceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.XSLTResource.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.XSLTResource.Properties.location) {
					return createLocationText(parent);
				}
				// Start of user code for resourceRegistryKey addToPart creation
			    if (key == EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey) {
                    return createRegistryKeyText(parent);
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
		propertiesGroup.setText(EsbMessages.XSLTResourcePropertiesEditionPart_PropertiesGroupLabel);
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
		Control locationTextLabel = createDescription(parent, EsbViewsRepository.XSLTResource.Properties.location, EsbMessages.XSLTResourcePropertiesEditionPart_LocationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTResourcePropertiesEditionPartImpl.this, EsbViewsRepository.XSLTResource.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(XSLTResourcePropertiesEditionPartImpl.this, EsbViewsRepository.XSLTResource.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
				}
			}

		});
		EditingUtils.setID(location, EsbViewsRepository.XSLTResource.Properties.location);
		EditingUtils.setEEFtype(location, "eef::Text"); //$NON-NLS-1$
		Control locationHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.XSLTResource.Properties.location, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLocationText
		locationElements = new Control [] {locationTextLabel, location, locationHelp};
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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart#getLocation()
	 * 
	 */
	public String getLocation() {
		return location.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart#setLocation(String newValue)
	 * 
	 */
	public void setLocation(String newValue) {
		if (newValue != null) {
			location.setText(newValue);
		} else {
			location.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTResource.Properties.location);
		if (eefElementEditorReadOnlyState && location.isEnabled()) {
			location.setEnabled(false);
			location.setToolTipText(EsbMessages.XSLTResource_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !location.isEnabled()) {
			location.setEnabled(true);
		}	
		
	}






	// Start of user code for resourceRegistryKey specific getters and setters implementation
	   @Override
       public RegistryKeyProperty getResourceRegistryKey() {
           return registryKey;
       }

       @Override
       public void setResourceRegistryKey(RegistryKeyProperty regKey) {
           if (regKey != null) {
               resourceRegistryKeyText.setText(regKey.getKeyValue());
               registryKey = regKey;
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
		return EsbMessages.XSLTResource_Part_Title;
	}

	// Start of user code additional methods
	/**
     * @generated NOT
     */
    protected Composite createRegistryKeyText(Composite parent) {
        Control registryTextLabel = createDescription(parent,
                EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey,
                EsbMessages.XSLTResourcePropertiesEditionPart_ResourceRegistryKeyLabel);
        resourceRegistryKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY); // $NON-NLS-1$
        resourceRegistryKeyText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
        resourceRegistryKeyText.setLayoutData(propertyValueData);
        if(registryKey==null) {
            registryKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        resourceRegistryKeyText.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTResourcePropertiesEditionPartImpl.this,
                            EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getResourceRegistryKey()));
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(XSLTResourcePropertiesEditionPartImpl.this,
                                    EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey,
                                    PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST, null,
                                    getResourceRegistryKey()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTResourcePropertiesEditionPartImpl.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        resourceRegistryKeyText.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, registryKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    resourceRegistryKeyText.setText(registryKey.getKeyValue());

                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTResourcePropertiesEditionPartImpl.this,
                            EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, getResourceRegistryKey()));
                }
            }
        });
        EditingUtils.setID(resourceRegistryKeyText, EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey);
        EditingUtils.setEEFtype(resourceRegistryKeyText, "eef::Text"); //$NON-NLS-1$
        Control propertyExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createPropertyValueText
        resourceRegistryKeyElements = new Control[] { registryTextLabel, resourceRegistryKeyText,
                propertyExpressionHelp };// mouse
        resourceRegistryKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, registryKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                resourceRegistryKeyText.setText(registryKey.getKeyValue());

                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                        XSLTResourcePropertiesEditionPartImpl.this,
                        EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey, PropertiesEditionEvent.COMMIT,
                        PropertiesEditionEvent.SET, null, getResourceRegistryKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        return parent;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil eu = new EEFPropertyViewUtil(view);
        eu.clearElements(new Composite[] { propertiesGroup });
        eu.showEntry(locationElements, false);
        eu.showEntry(resourceRegistryKeyElements, false);

        view.layout(true, true);
    }

        // End of user code


}
