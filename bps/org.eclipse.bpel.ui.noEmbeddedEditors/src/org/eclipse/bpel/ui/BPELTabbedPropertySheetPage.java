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
package org.eclipse.bpel.ui;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.Expression;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyViewer;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Our own version of the TabbedPropertySheetPage in order to supply the
 * BPELEditor to the property sections.
 */
public class BPELTabbedPropertySheetPage extends TabbedPropertySheetPage {
	
	protected BPELEditor editor;
	protected TabbedPropertyViewer viewer;
	protected TabbedPropertyRegistry registry;
	
	public BPELTabbedPropertySheetPage(ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor, BPELEditor editor) {
		super(tabbedPropertySheetPageContributor);
		this.editor = editor;
	}
	
	public BPELEditor getEditor() {
		return editor;
	}
	
	public TabbedPropertyViewer getTabbedPropertyViewer() {
		if (viewer == null) {
			// TODO: hack - use reflection to get the field - it should be API in the super class
			try {
				Field field = TabbedPropertySheetPage.class.getDeclaredField("tabbedPropertyViewer"); //$NON-NLS-1$
				field.setAccessible(true);
				viewer = (TabbedPropertyViewer) field.get(this); 
			} catch (Exception e) {
				BPELUIPlugin.log(e);
			}
		}
		return viewer;
	}
	
	public void setBPELEditorActions() {
		IPageSite pageSite = getSite();
		IActionBars actionBars = pageSite.getActionBars(); 
		String id = ActionFactory.REVERT.getId();
		IAction action = editor.getActionRegistry().getAction(id);
		actionBars.setGlobalActionHandler(id, action);
		
		id = ActionFactory.UNDO.getId();
		action = editor.getActionRegistry().getAction(id);
		actionBars.setGlobalActionHandler(id, action);
		
		id = ActionFactory.REDO.getId();
		action = editor.getActionRegistry().getAction(id);
		actionBars.setGlobalActionHandler(id, action);
		actionBars.updateActionBars();
	}
		
	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		// add some actions to the properties view
		setBPELEditorActions();
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO: (DO) If we change selection in the Designer then it causes
		// changing selection in the SourceTab too. We are not going to create
		// PropertySheetPage twice, so, ignore the second case
		if (selection instanceof ITextSelection) {
			return;
		}
		selection = calculateSelection(selection);
		super.selectionChanged(part, selection);
//		TabDescriptor[] descriptors = getRegistry().getTabDescriptors(part, selection);
//		if (descriptors.length > 0) {
//			super.selectionChanged(part, selection);
//		}
	}
	
	/**
	 * Replace EditPart with model object.
	 */
	protected ISelection calculateSelection(ISelection selection) {
		Set<Object> newSet = new HashSet<Object>();
		if (selection != null && !selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Iterator<Object> it = ((IStructuredSelection)selection).iterator();
			while (it.hasNext()) {
				Object o = it.next();
				if (o instanceof EditPart) {
					o = ((EditPart)o).getModel();
				}
				if (editor.getMultipageEditor().getActiveEditor() == editor.getMultipageEditor().getTextEditor()) {
					// the selection came from the Source view of this multipage editor so we have to
					// be careful here: if a selection does not have a corresponding property sheet page
					// (e.g. a <copy>, <from>. <to>, etc.) then traverse the selection's ancestors to find
					// an element which DOES have a property sheet page associated with it. 
					while (o!=null && o instanceof EObject && !hasPropertySheetPage(o)) {
						o = ((EObject)o).eContainer();
					}
				}
				newSet.add(o);
			}
		}
		return new StructuredSelection(newSet.toArray(new Object[newSet.size()]));
	}
	
	private boolean hasPropertySheetPage(Object o) {
		return
			o instanceof org.eclipse.bpel.model.Activity ||
			o instanceof org.eclipse.bpel.model.Assign ||
			o instanceof org.eclipse.bpel.model.Catch ||
			o instanceof org.eclipse.bpel.model.CatchAll ||
			o instanceof org.eclipse.bpel.model.CompensateScope ||
			o instanceof org.eclipse.bpel.model.CorrelationSet ||
			o instanceof org.eclipse.bpel.model.Else ||
			o instanceof org.eclipse.bpel.model.ElseIf ||
			o instanceof org.eclipse.bpel.model.Empty ||
			o instanceof org.eclipse.bpel.model.ForEach ||
			o instanceof org.eclipse.bpel.model.If ||
			o instanceof org.eclipse.bpel.model.Invoke ||
			o instanceof org.eclipse.bpel.model.Link ||
			o instanceof org.eclipse.bpel.model.MessageExchange ||
			o instanceof org.eclipse.bpel.model.MessageExchanges ||
			o instanceof org.eclipse.bpel.model.OnAlarm ||
			o instanceof org.eclipse.bpel.model.OnEvent ||
			o instanceof org.eclipse.bpel.model.OnMessage ||
			o instanceof org.eclipse.bpel.model.PartnerLink ||
			o instanceof org.eclipse.bpel.model.PartnerLinks ||
			o instanceof org.eclipse.bpel.model.Pick ||
			o instanceof org.eclipse.bpel.model.Process ||
			o instanceof org.eclipse.bpel.model.Receive ||
			o instanceof org.eclipse.bpel.model.RepeatUntil ||
			o instanceof org.eclipse.bpel.model.Reply ||
			o instanceof org.eclipse.bpel.model.Scope ||
			o instanceof org.eclipse.bpel.model.Throw ||
			o instanceof org.eclipse.bpel.model.Validate ||
			o instanceof org.eclipse.bpel.model.Variable ||
			o instanceof org.eclipse.bpel.model.Variables ||
			o instanceof org.eclipse.bpel.model.Wait ||
			o instanceof org.eclipse.bpel.model.While;
	}
	
	protected TabbedPropertyRegistry getRegistry() {
		if (registry == null) {
			// TODO: hack - use reflection to get the field - it should be API in the super class
			try {
				Field field = TabbedPropertySheetPage.class.getDeclaredField("registry"); //$NON-NLS-1$
				field.setAccessible(true);
				registry = (TabbedPropertyRegistry) field.get(this); 
			} catch (Exception e) {
				BPELUIPlugin.log(e);
			}
		}
		return registry;
	}
}