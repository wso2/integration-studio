/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.bpelactions.AbstractBPELAction;
import org.eclipse.bpel.ui.bpelactions.SimpleAction;
import org.eclipse.bpel.ui.details.providers.AbstractContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelViewerSorter;
import org.eclipse.bpel.ui.extensions.ActionCategoryDescriptor;
import org.eclipse.bpel.ui.extensions.ActionDescriptor;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.ActionUIObjectFactory;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;


public class ActionImplementationSection extends BPELPropertySection {

    protected Browser description;
    protected CCombo categoryCombo;
    protected CComboViewer categoryViewer;
    protected Composite buttonsComposite;
    protected List buttonsList;

    public ActionImplementationSection() {
        super();
        buttonsList = new ArrayList();
    }

	@Override
	protected void createClient(Composite parent) {
		Composite composite = createFlatFormComposite(parent);
		createImplementationWidgets(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			composite, IHelpContextIds.PROPERTY_PAGE_EMPTY_IMPLEMENTATION);
	}

    public void createImplementationWidgets(Composite parent) {
        Composite left = getWidgetFactory().createComposite(parent);
        FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(100, 0);
        left.setLayoutData(data);
        
        left.setLayout(new GridLayout(1, false));
        Composite combos = getWidgetFactory().createComposite(left);
        combos.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
        combos.setLayout(new GridLayout(2, false));
        Label categoryLabel = getWidgetFactory().createLabel(combos, Messages.ActionImplementationSection_Action_Category_1); 
        categoryLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        categoryCombo = getWidgetFactory().createCCombo(combos);
        Composite chooseActionComposite = getWidgetFactory().createComposite(left);
        chooseActionComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
        chooseActionComposite.setLayout(new GridLayout(1, false));
        Label chooseActionLabel = getWidgetFactory().createLabel(chooseActionComposite, Messages.ActionImplementationSection_Choose_one_of_these_actions_2); 
        chooseActionLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        buttonsComposite = getWidgetFactory().createComposite(left);
        buttonsComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
        buttonsComposite.setLayout(new RowLayout());
        
        Composite right = getWidgetFactory().createComposite(parent);
        data = new FlatFormData();
		data.left = new FlatFormAttachment(left);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.bottom = new FlatFormAttachment(100, 0);
        right.setLayoutData(data);

		right.setLayout(new GridLayout(1, false));
        Label descriptionLabel = getWidgetFactory().createLabel(right, Messages.ActionImplementationSection_Description_3); 
        descriptionLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        descriptionLabel.setToolTipText(Messages.ActionImplementationSection_Hover_tooltip_4); 
        description = new Browser(right, SWT.NONE);
        description.setLayoutData(new GridData(GridData.FILL_BOTH));

        // initialize values and viewers
        categoryViewer = new CComboViewer(categoryCombo);
        categoryViewer.setLabelProvider(new LabelProvider() {
            @Override
			public String getText(Object element) {
                if (element instanceof ActionCategoryDescriptor) {
                    return ((ActionCategoryDescriptor)element).getName();
                }
                return super.getText(element);
            }
        });
        categoryViewer.setContentProvider(new AbstractContentProvider() {
            @Override
			public Object[] getElements(Object inputElement) {
                return (Object[])inputElement;
            }
        });
		categoryViewer.setSorter(ModelViewerSorter.getInstance());
        categoryViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                if (event.getSelection() instanceof IStructuredSelection) {
                    ActionCategoryDescriptor category = (ActionCategoryDescriptor)((IStructuredSelection)event.getSelection()).getFirstElement();
                    createActionButtons(category);
                }
            }
        });
        ActionCategoryDescriptor[] categories = BPELUIRegistry.getInstance().getActionCategoryDescriptors();
        categoryViewer.setInput(categories);
    }
    
    @Override
	public void refresh() {
        super.refresh();
        ActionCategoryDescriptor[] categories = BPELUIRegistry.getInstance().getActionCategoryDescriptors();
        categoryViewer.setSelection(new StructuredSelection(categories[0])); // select the Basic Actions category
    }

    @Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

    protected void createActionButtons(ActionCategoryDescriptor category) {
        // remove old buttons
        for (Iterator iter = buttonsList.iterator(); iter.hasNext();) {
            Button button = (Button) iter.next();
            button.dispose();
        }
        
        // create buttons
        ActionDescriptor[] descriptors = BPELUIRegistry.getInstance().getActionDescriptors();
        for (int i = 0; i < descriptors.length; i++) {
            ActionDescriptor descriptor = descriptors[i];
            // filter by spec-compliance
            if (ModelHelper.isSpecCompliant(getProcess()) && !descriptor.isSpecCompliant()) {
            	continue;
            }
            final AbstractBPELAction action = descriptor.getAction();
            // Remove the Empty action since we are already in it.
            // Also remove the actions that do not belong to the given category.
            if (action instanceof SimpleAction || !descriptor.getCategoryId().equals(category.getId())) {
                continue;
            }
            final Object currentModel = getModel();
            final BPELEditor editor = ModelHelper.getBPELEditor(getProcess());
            final AbstractUIObjectFactory factory = action.getUIObjectFactory();
            Button button = getWidgetFactory().createButton(buttonsComposite, String.valueOf(i), SWT.PUSH);
            button.setImage(factory.getSmallImage());
            button.setToolTipText(action.getLabel());
            Listener listener = new Listener() {
                public void handleEvent(Event event) {
                    description.setText("<HTML>" + action.getDescription() + "</HTML>"); //$NON-NLS-1$ //$NON-NLS-2$
                }
            };
            button.addListener(SWT.MouseEnter, listener);
            button.addListener(SWT.FocusIn, listener);
            button.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event event) {
                    try {
						EObject parent = getModel().eContainer();
						final Object newModel = (factory instanceof ActionUIObjectFactory) ? ((ActionUIObjectFactory)factory).createInstance(parent) : factory.createInstance();
						Command command = action.getChangeActionTypeCommand(parent, currentModel, newModel);
						command = wrapInShowContextCommand(command);
						editor.getCommandStack().execute(command);
						selectModelObject((EObject)newModel);
					} catch (OperationCanceledException e) {
						// The user has canceled the request so we just return without doing anything.
						return;
					}
                }
            });
            buttonsList.add(button);
        }
        buttonsComposite.layout(true);
    }

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
        description.setText(Messages.ActionImplementationSection_HTML_hover_description_text_5); 
	}
}
