/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl;



// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import java.util.ArrayList;
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
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFEvaluatorExpressionEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFRegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;

// End of user code

/**
 * 
 * 
 */
public class ConditionalRouteBranchPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConditionalRouteBranchPropertiesEditionPart {

	protected Button breakAfterRoute;
	// Start of user code  for targetSequence widgets declarations
    protected RegistryKeyProperty targetSequence;
    protected Text targetSequenceText;
	// End of user code

	// Start of user code  for evaluatorExpression widgets declarations
    protected EvaluatorExpressionProperty evaluatorExpression;
    protected Text evaluatorExpressionText;
    protected Group propertiesGroup;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConditionalRouteBranchPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conditionalRouteBranchStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = conditionalRouteBranchStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		propertiesStep.addStep(EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence);
		
		conditionalRouteBranchStep.addStep(EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression);
		
		composer = new PartComposer(conditionalRouteBranchStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute) {
					return createBreakAfterRouteCheckbox(parent);
				}
				// Start of user code for targetSequence addToPart creation
                if (key == EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence) {
                    return createTargetSequenceWidget(parent);
                }
				// End of user code
				// Start of user code for evaluatorExpression addToPart creation
                if (key == EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression) {
                    return createEvaluatorExpressionWidget(parent);
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
		propertiesGroup.setText(EsbMessages.ConditionalRouteBranchPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createBreakAfterRouteCheckbox(Composite parent) {
		breakAfterRoute = new Button(parent, SWT.CHECK);
		breakAfterRoute.setText(getDescription(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbMessages.ConditionalRouteBranchPropertiesEditionPart_BreakAfterRouteLabel));
		breakAfterRoute.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(breakAfterRoute.getSelection())));
			}

		});
		GridData breakAfterRouteData = new GridData(GridData.FILL_HORIZONTAL);
		breakAfterRouteData.horizontalSpan = 2;
		breakAfterRoute.setLayoutData(breakAfterRouteData);
		EditingUtils.setID(breakAfterRoute, EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		EditingUtils.setEEFtype(breakAfterRoute, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createBreakAfterRouteCheckbox

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
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart#getBreakAfterRoute()
	 * 
	 */
	public Boolean getBreakAfterRoute() {
		return Boolean.valueOf(breakAfterRoute.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart#setBreakAfterRoute(Boolean newValue)
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue) {
		if (newValue != null) {
			breakAfterRoute.setSelection(newValue.booleanValue());
		} else {
			breakAfterRoute.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute);
		if (eefElementEditorReadOnlyState && breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(false);
			breakAfterRoute.setToolTipText(EsbMessages.ConditionalRouteBranch_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !breakAfterRoute.isEnabled()) {
			breakAfterRoute.setEnabled(true);
		}	
		
	}






	// Start of user code for targetSequence specific getters and setters implementation
    @Override
    public RegistryKeyProperty getTargetSequence() {
        return targetSequence;
    }

    @Override
    public void setTargetSequence(RegistryKeyProperty registryKeyProperty) {
        if (registryKeyProperty != null) {
            targetSequenceText.setText(registryKeyProperty.getKeyValue());
            targetSequence = registryKeyProperty;
        }
        
    }
	// End of user code

	// Start of user code for evaluatorExpression specific getters and setters implementation
    @Override
    public EvaluatorExpressionProperty getEvaluatorExpression() {
        return evaluatorExpression;
    }

    @Override
    public void setEvaluatorExpression(EvaluatorExpressionProperty evaluatorExpressionProperty) {
        if (evaluatorExpressionProperty != null) {
            evaluatorExpressionText.setText(evaluatorExpressionProperty.getEvaluatorValue());
            evaluatorExpression = evaluatorExpressionProperty;
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
		return EsbMessages.ConditionalRouteBranch_Part_Title;
	}





	// Start of user code additional methods
	
    protected Composite createEvaluatorExpressionWidget(Composite parent) {
        Control evaluatorExpressionLabel = createDescription(parent,
                EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression,
                EsbMessages.ConditionalRouteBranchPropertiesEditionPart_EvaluatorExpressionLabel);
        if (evaluatorExpression == null) {
            evaluatorExpression = EsbFactoryImpl.eINSTANCE.createEvaluatorExpressionProperty();
        }
        String initValueExpression = (evaluatorExpression.getEvaluatorValue() == null || evaluatorExpression.getEvaluatorValue().isEmpty()) ? "" : evaluatorExpression.getEvaluatorValue();
        evaluatorExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        evaluatorExpressionText.setText(initValueExpression);
        evaluatorExpressionText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        evaluatorExpressionText.setLayoutData(valueData);
        evaluatorExpressionText.addMouseListener(new MouseListener(){
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFEvaluatorExpressionEditorDialog dialog = new EEFEvaluatorExpressionEditorDialog(view.getShell(),
                         evaluatorExpression);
                dialog.open();
                evaluatorExpressionText.setText(evaluatorExpression.getEvaluatorValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this,
                                EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEvaluatorExpression()));
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        evaluatorExpressionText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFEvaluatorExpressionEditorDialog dialog = new EEFEvaluatorExpressionEditorDialog(view.getShell(),
                            evaluatorExpression);
                   dialog.open();
                   evaluatorExpressionText.setText(evaluatorExpression.getEvaluatorValue());
                   propertiesEditionComponent
                           .firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this,
                                   EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression,
                                   PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEvaluatorExpression()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(evaluatorExpressionText, EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression);
        EditingUtils.setEEFtype(evaluatorExpressionText, "eef::Text");
        Control evaluatorExpressionHelp = SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        //endpointKeyElements = new Control[] { evaluatorExpressionLabel, evaluatorExpressionText, evaluatorExpression };
        return parent;
    }

    protected Composite createTargetSequenceWidget(Composite parent) {
        Control targetSequenceLabel = createDescription(parent,
                EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence,
                EsbMessages.ConditionalRouteBranchPropertiesEditionPart_TargetSequenceLabel);
        if (targetSequence == null) {
            targetSequence = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        }
        String initValueExpression = targetSequence.getKeyValue().isEmpty() ? "" : targetSequence.getKeyValue();
        targetSequenceText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        targetSequenceText.setText(initValueExpression);
        targetSequenceText.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        targetSequenceText.setLayoutData(valueData);
        targetSequenceText.addMouseListener(new MouseListener(){

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDown(MouseEvent e) {
                EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                        SWT.NULL, targetSequence, new ArrayList<NamedEntityDescriptor>());
                dialog.open();
                targetSequenceText.setText(targetSequence.getKeyValue());
                propertiesEditionComponent
                        .firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this,
                                EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetSequence()));
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        targetSequenceText.addKeyListener(new KeyListener() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (!EEFPropertyViewUtil.isReservedKeyCombination(e)) {
                    EEFRegistryKeyPropertyEditorDialog dialog = new EEFRegistryKeyPropertyEditorDialog(view.getShell(),
                            SWT.NULL, targetSequence, new ArrayList<NamedEntityDescriptor>());
                    dialog.open();
                    targetSequenceText.setText(targetSequence.getKeyValue());
                    propertiesEditionComponent
                            .firePropertiesChanged(new PropertiesEditionEvent(ConditionalRouteBranchPropertiesEditionPartImpl.this,
                                    EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetSequence()));
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {}
            
        });
        
        EditingUtils.setID(targetSequenceText, EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence);
        EditingUtils.setEEFtype(targetSequenceText, "eef::Text");
        Control targetSequenceTextHelp = SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence,
                        EsbViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        //targetSequenceElements = new Control[] { targetSequenceLabel, targetSequenceText, targetSequenceTextHelp };
        return parent;
    }

	// End of user code


}
