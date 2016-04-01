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

import org.eclipse.bpel.common.ui.details.viewers.CComboViewer;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCompensateCommand;
import org.eclipse.bpel.ui.details.providers.AddNullFilter;
import org.eclipse.bpel.ui.details.providers.AddSelectedObjectFilter;
import org.eclipse.bpel.ui.details.providers.CompensableActivityContentProvider;
import org.eclipse.bpel.ui.details.providers.ModelLabelProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;


/**
 * Details section for the Compensate properties of a
 * Compensate activity.
 */
public class CompensateScopeSection extends BPELPropertySection {

	protected Composite parentComposite;
	protected Composite activityComposite;	
	protected Label activityLabel;
	protected CComboViewer activityViewer;
	protected AddSelectedObjectFilter addSelectedObjectFilter;
	
	
	/**
	 * Brand new shiny compensate scope section.
	 */
	
	public CompensateScopeSection(){
		super();
	}
	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] {
				new MultiObjectAdapter(){
					@Override
					public void notify(Notification n) {
						// TODO: isCompensateAffected() ?
						refresh();
					}
				},
		};
	}

	protected void createActivityWidgets(Composite parent) {
		FlatFormData data;
		
		final Composite composite = activityComposite = createFlatFormComposite(parent);
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 0);
		data.left = new FlatFormAttachment(0, 0);
		composite.setLayoutData(data);
		
		activityLabel = fWidgetFactory.createLabel(composite, Messages.CompensateImplDetails_Activity__10); 
		CCombo activityCombo = fWidgetFactory.createCCombo(composite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(activityLabel, STANDARD_LABEL_WIDTH_SM));		
		activityCombo.setLayoutData(data);	
		
		activityViewer = new CComboViewer(activityCombo);
		activityViewer.addFilter(AddNullFilter.getInstance());
		activityViewer.setLabelProvider(new ModelLabelProvider());
		activityViewer.setContentProvider(new CompensableActivityContentProvider());
		// TODO: should this have a sorter?  Probably not?
		addSelectedObjectFilter = new AddSelectedObjectFilter(); 
		activityViewer.addFilter(addSelectedObjectFilter);
		activityViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {				
				IStructuredSelection sel = (IStructuredSelection)activityViewer.getSelection();
				
				EObject compensate = (EObject) sel.getFirstElement();
				
				CompensateScope compensateScope = getInput();
				
				if (compensate instanceof Activity) {
					compensateScope.setTarget( (Activity) compensate);
					
					CompoundCommand cmd = new CompoundCommand();
					Command child = new SetCompensateCommand(compensateScope, (Activity) compensate);
					
					if (child.canExecute()) {
						cmd.add(child);				
					}
				}
			}
		});	
		
		activityViewer.setInput(getInput());	
	}	

	@Override
	protected void createClient(Composite parent) {	
		Composite composite = parentComposite = createFlatFormComposite(parent);
		createActivityWidgets(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parentComposite, IHelpContextIds.PROPERTY_PAGE_COMPENSATE_IMPLEMENTATION);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		
		super.refresh();
		
		CompensateScope compensateScope = getInput();
		Activity targetActivity = compensateScope.getTarget();
		addSelectedObjectFilter.setSelectedObject( targetActivity );
		activityViewer.setInput(getInput());
		refreshCCombo(activityViewer, targetActivity);
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */
	@Override
	public Object getUserContext() {
		return null;
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#getUserContext()
	 */	
	@Override
	public void restoreUserContext(Object userContext) {
		activityViewer.getCCombo().setFocus();
	}
}