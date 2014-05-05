/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.compare.ui.gef.bpel;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.bpel.compare.ui.gef.mergeviewer.GEFContentMergeViewer;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.BPELEditDomain;
import org.eclipse.bpel.ui.ScrollingBPELGraphicalViewer;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareUI;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

public class BPELContentMergeViewer extends GEFContentMergeViewer {

	private static HashMap<BPELCompareEditPartFactory, BPELContentMergeViewer>
		uiFactory2mergeViewer =
		new HashMap<BPELCompareEditPartFactory, BPELContentMergeViewer>();
	
	public static BPELContentMergeViewer getBPELContentMergeViewer(
			BPELCompareEditPartFactory uiFactory) {
		return uiFactory2mergeViewer.get(uiFactory);
	}
	
	protected BPELContentMergeViewer(Composite parent, CompareConfiguration cc) {
		super(parent, cc);
		getControl().setData(CompareUI.COMPARE_VIEWER_TITLE,
				"BPEL Processes Compare");
	}

	@Override
	public void updateContent(EObject modelAncestor, EObject modelLeft,
			EObject modelRight) {
		BPELEditDomain bpelEditDomain = new BPELEditDomain(null);
		bpelEditDomain.setProcess((Process)modelLeft);
		viewerLeft.setEditDomain(bpelEditDomain);
		BPELCompareEditPartFactory uiFactory = new BPELCompareEditPartFactory();
		viewerLeft.setEditPartFactory(uiFactory);
		uiFactory2mergeViewer.put(uiFactory, this);
//		viewer_left.setRootEditPart(new DiagramRootEditPart(diag_left.getMeasurementUnit()));
		viewerLeft.setContents(modelLeft);
		
		bpelEditDomain = new BPELEditDomain(null);
		bpelEditDomain.setProcess((Process) modelRight);
		viewerRight.setEditDomain(bpelEditDomain);
		viewerRight.setEditPartFactory(uiFactory);
		viewerRight.setContents(modelRight);
		
		if (modelAncestor != null) {
			bpelEditDomain = new BPELEditDomain(null);
			bpelEditDomain.setProcess((Process) modelAncestor);
			viewerAncestor.setEditDomain(bpelEditDomain);
			viewerAncestor.setEditPartFactory(uiFactory);
			viewerAncestor.setContents(modelAncestor);
		}		
		
	}

	@Override
	public void initializeViewers(Composite composite) {
		viewerLeft = new ScrollingBPELGraphicalViewer();
		viewerLeft.createControl(composite);
		viewerLeft.getControl().setBackground(ColorConstants.listBackground);
		
		viewerRight = new ScrollingBPELGraphicalViewer();
		viewerRight.createControl(composite);
		viewerRight.getControl().setBackground(ColorConstants.listBackground);
		
		viewerAncestor = new ScrollingBPELGraphicalViewer();
		viewerAncestor.createControl(composite);
		viewerAncestor.getControl().setBackground(ColorConstants.listBackground);
	}

}
