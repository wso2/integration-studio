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
package org.eclipse.bpel.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator;
import org.eclipse.bpel.common.ui.tray.MainTrayEditPart;
import org.eclipse.bpel.common.ui.tray.TrayMarkerDecorator;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.IHoverHelperSupport;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.policies.BPELDirectEditPolicy;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;


/**
 * @author IBM, initial contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com) 
 *
 */
public class ProcessTrayEditPart extends MainTrayEditPart implements IHoverHelperSupport {

	protected ISelectionChangedListener selectionListener;
	protected Object lastSelection = null;
	
	protected MouseMotionListener fMouseMotionListener;

	// protected ReferencePartnerLinks referencePartners;

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.common.ui.tray.TrayCategoryEntryEditPart#createEditPartMarkerDecorator()
	 */
	
	@Override
	protected EditPartMarkerDecorator createEditPartMarkerDecorator() {

		return new TrayMarkerDecorator((EObject)getModel(), new ToolbarLayout()) {
			@Override
			protected IMarker[] getMarkers () {
				
				IMarkerHolder holder = BPELUtil.adapt(modelObject, IMarkerHolder.class);
				
				if (holder != null) {
					return holder.getMarkers(modelObject);
				}
				
				return super.getMarkers();
			}
		};
		
	}
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		// The DIRECT_EDIT_ROLE policy determines how in-place editing takes place.
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new BPELDirectEditPolicy());
	}
	
		

	
	/**
	 * @see org.eclipse.bpel.ui.IHoverHelperSupport#refreshHoverHelp()
	 */
	public void refreshHoverHelp() {
		
		// Refresh the tool-tip if we can find a helper.
		IHoverHelper helper = null; 
		try {
			helper = BPELUIRegistry.getInstance().getHoverHelper();
			if (helper == null) {
				return;				
			}
		} catch (CoreException e) {
			getFigure().setToolTip(null);
			BPELUIPlugin.log(e);
			return ;
		}		
		
		
		IFigure text = helper.getHoverFigure((EObject)getModel());
		getFigure().setToolTip(text);
	}

	protected MouseMotionListener getMouseMotionListener() {
		if (fMouseMotionListener == null) {
			this.fMouseMotionListener = new MouseMotionListener() {
				public void mouseDragged(MouseEvent me) {
				}
				public void mouseEntered(MouseEvent me) {
				}
				public void mouseExited(MouseEvent me) {
				}
				public void mouseHover(MouseEvent me) {
				}
				public void mouseMoved(MouseEvent me) {
					refreshHoverHelp();
				}
			};
		}
		return fMouseMotionListener;
	}
	
	@Override
	
	protected IFigure createFigure() {
		IFigure fig =  super.createFigure();
		fig.addMouseMotionListener(getMouseMotionListener());
		return fig;
	}
	
	
	@Override
	protected List<?> getModelChildren() {
		
		//Process process = getProcess();
		List<Object> list = new ArrayList<Object>();

		PartnerLinks links = getPartnerLinks();
		if (links != null) {			
			list.add(links);
			// referencePartners = UiextensionmodelFactory.eINSTANCE.createReferencePartnerLinks();
			// referencePartners.setPartnerLinks(links);
			// list.add(referencePartners);
		}

		Variables variables = getVariables();
		if (variables != null) {
			list.add(variables);
		}
		
		CorrelationSets sets = getCorrelationSets();
		if (sets != null) {
			list.add(sets);
		}
		
		MessageExchanges exchanges = getMessageExchanges();
		if (exchanges != null) {
			list.add(exchanges);
		}
		
		return list;
	}
	
	/**
	 * We show scoped partnerLinks if a Scope is the current selection,
	 * otherwise we show the process partnerLinks.
	 */
	protected PartnerLinks getPartnerLinks() {
		if (lastSelection instanceof Scope) {
			Scope scope = (Scope) lastSelection;
			if ( scope.getPartnerLinks() == null) {
				scope.setPartnerLinks( BPELFactory.eINSTANCE.createPartnerLinks() );
			}
			return scope.getPartnerLinks();						
		} 
		Process process = getProcess();
		if (process.getPartnerLinks() == null) {
			process.setPartnerLinks(  BPELFactory.eINSTANCE.createPartnerLinks()  );
		}
		
		return process.getPartnerLinks();
		
	}

	/**
	 * We show scoped variables if a Scope is the current selection,
	 * otherwise we show the process variables.
	 */
	protected Variables getVariables() {
		
		if (lastSelection instanceof Scope) {
			
			Scope scope = (Scope) lastSelection;
			if ( scope.getVariables() == null) {
				scope.setVariables( BPELFactory.eINSTANCE.createVariables() );
			}
			return scope.getVariables();
			
		} 
		
		Process process = getProcess();
		if (process.getVariables() == null) {
			process.setVariables(  BPELFactory.eINSTANCE.createVariables()  );
		}
		
		return process.getVariables();		
	}
	
	/**
	 * We show scoped correlationSets if a Scope is the current selection,
	 * otherwise we show the process correlationSets.
	 */
	protected CorrelationSets getCorrelationSets() {		
		if (lastSelection instanceof Scope) {
			Scope scope = (Scope) lastSelection;
			if ( scope.getCorrelationSets() == null) {
				scope.setCorrelationSets( BPELFactory.eINSTANCE.createCorrelationSets() );
			}
			return scope.getCorrelationSets();
		}
		Process process = getProcess();
		if (process.getCorrelationSets() == null) {
			process.setCorrelationSets(  BPELFactory.eINSTANCE.createCorrelationSets()  );
		}

		return process.getCorrelationSets();
	}
	
	/**
	 * We show scoped correlationSets if a Scope is the current selection,
	 * otherwise we show the process correlationSets.
	 */
	protected MessageExchanges getMessageExchanges() {		
		if (lastSelection instanceof Scope) {
			Scope scope = (Scope) lastSelection;
			if ( scope.getMessageExchanges() == null) {
				scope.setMessageExchanges( BPELFactory.eINSTANCE.createMessageExchanges() );
			}
			return scope.getMessageExchanges();
		}
		Process process = getProcess();
		if (process.getMessageExchanges() == null) {
			process.setMessageExchanges( BPELFactory.eINSTANCE.createMessageExchanges() );
		}

		return process.getMessageExchanges();
	}
	
	protected Process getProcess() {
		return (Process)getModel();
	}
	
	
	/**
	 * @see org.eclipse.bpel.common.ui.tray.TrayEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		BPELEditor editor = ModelHelper.getBPELEditor(getProcess());
		editor.getGraphicalViewer().addSelectionChangedListener(getSelectionChangedListener());		
	}
	
	
	/**
	 * @see org.eclipse.bpel.common.ui.tray.TrayEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		// There is a chance that by the time we deactivate, we can't find the editor anymore.
		// This is okay because there is a hack in BPELEditor.modelReloaded that manually
		// removes this selection change listener from the graphical viewer.
		try {
			BPELEditor editor = ModelHelper.getBPELEditor(getProcess());
			editor.getGraphicalViewer().removeSelectionChangedListener(getSelectionChangedListener());
		} catch (Exception e) {	
		}
	}

	/**
	 * Selection listeners that tracks the canvas selection and causes the variables
	 * to refresh accordingly.
	 * @return the selection changed listener
	 */
	public ISelectionChangedListener getSelectionChangedListener() {
		if (selectionListener == null) {
			selectionListener = new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					Object currentSelection = getModelObjectFromSelection(event.getSelection());
					if (shouldRefresh(currentSelection)) {
						lastSelection = currentSelection;
						refreshChildren();
					}
				}
				protected boolean shouldRefresh(Object currentSelection) {
					if (currentSelection == null)
						return false;
					if (currentSelection instanceof Variables || currentSelection instanceof Variable)
						return false;
					if (currentSelection instanceof PartnerLinks || currentSelection instanceof PartnerLink)
						return false;
					if (currentSelection instanceof CorrelationSets || currentSelection instanceof CorrelationSet)
						return false;
					if (currentSelection instanceof MessageExchanges || currentSelection instanceof MessageExchange)
						return false;
					if (currentSelection instanceof ReferencePartnerLinks)
						return false;
					return (lastSelection != currentSelection && (lastSelection instanceof Scope || currentSelection instanceof Scope));
				}
			};
		}
		return selectionListener;
	}

	
	@Override
	protected AccessibleEditPart createAccessible() {
		return new BPELTrayAccessibleEditPart(this);
	}
}
