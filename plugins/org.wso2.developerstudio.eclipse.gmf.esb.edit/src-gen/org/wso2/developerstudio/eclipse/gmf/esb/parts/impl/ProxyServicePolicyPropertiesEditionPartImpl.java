/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ProxyServicePolicyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class ProxyServicePolicyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProxyServicePolicyPropertiesEditionPart {

	// Start of user code  for policyKey widgets declarations
	protected RegistryKeyProperty policyKey;
	protected Text policyKeyText;
	protected Control[] policyKeyElements;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProxyServicePolicyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence proxyServicePolicyStep = new BindingCompositionSequence(propertiesEditionComponent);
		proxyServicePolicyStep
			.addStep(EsbViewsRepository.ProxyServicePolicy.Properties.class)
			.addStep(EsbViewsRepository.ProxyServicePolicy.Properties.policyKey);
		
		
		composer = new PartComposer(proxyServicePolicyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ProxyServicePolicy.Properties.class) {
					return createPropertiesGroup(parent);
				}
				// Start of user code for policyKey addToPart creation
				if (key == EsbViewsRepository.ProxyServicePolicy.Properties.policyKey) {
                    return createPolicyKey(parent);
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
		propertiesGroup.setText(EsbMessages.ProxyServicePolicyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
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






	// Start of user code for policyKey specific getters and setters implementation
	@Override
    public void setPolicyKey(RegistryKeyProperty registryKeyProperty) {
	    if (policyKey != null) {
            policyKey = registryKeyProperty;
            policyKeyText.setText(registryKeyProperty.getKeyValue());
        }
    }

    @Override
    public RegistryKeyProperty getPolicyKey() {
        return policyKey;
    }
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.ProxyServicePolicy_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createPolicyKey(final Composite parent) {
        Control policyKeyLabel = createDescription(parent, EsbViewsRepository.ProxyServicePolicy.Properties.policyKey,
                EsbMessages.ProxyServicePolicyPropertiesEditionPart_PolicyKeyLabel);

        if (policyKey == null) {
            policyKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        
        policyKeyText = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        policyKeyText.setLayoutData(valueData);
        policyKeyText.addMouseListener(new MouseListener() {

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                        SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                policyKeyText.setText(policyKey.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePolicyPropertiesEditionPartImpl.this,
                                EsbViewsRepository.ProxyServicePolicy.Properties.policyKey, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, getPolicyKey()));
            }

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        
        policyKeyText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(parent.getShell(),
                            SWT.NULL, policyKey, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    policyKeyText.setText(policyKey.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(ProxyServicePolicyPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.ProxyServicePolicy.Properties.policyKey, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, getPolicyKey()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(policyKeyText, EsbViewsRepository.ProxyServicePolicy.Properties.policyKey);
        EditingUtils.setEEFtype(policyKeyText, "eef::Text");
        Control policyKeyHelp = SWTUtils
                .createHelpButton(parent,
                        propertiesEditionComponent.getHelpContent(
                                EsbViewsRepository.ProxyServicePolicy.Properties.policyKey, EsbViewsRepository.FORM_KIND),
                        null);
        policyKeyElements = new Control[] { policyKeyLabel, policyKeyText, policyKeyHelp };
        return parent;
    }
	// End of user code


}
