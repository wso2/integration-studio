/*******************************************************************************
 * Copyright (c) 2007, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui.hovers;

import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.adapters.IAnnotatedElement;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

public class DefaultHoverHelper implements IHoverHelper {
	
	public IFigure getHoverFigure(EObject modelObject) {
		ILabeledElement e = getLabeledElement(modelObject);
		if (e == null) {
			return null;
		}
		String name = e.getLabel(modelObject);
		String type = e.getTypeLabel(modelObject);

		Figure panel = new Figure();
		panel.setLayoutManager(new GridLayout(2, false));

		Label title = new BoldLabel();
		title.setIcon(e.getSmallImage(modelObject));
		title.setIconAlignment(PositionConstants.TOP);
		title.setText(type);
		
		panel.add(title);
		
		Label label = new Label();
		if(!name.equals(type)) {
			label.setText(name);
		}
		panel.add(label);
		
		if (e instanceof IAnnotatedElement) {
			String annotation[] = ((IAnnotatedElement)e).getAnnotation(modelObject);
			if (annotation != null) {
				for (int i = 0; i < annotation.length; i += 2) {
					if (annotation[i+1] != null && annotation[i+1].length() > 0) {
						panel.add(new Label(annotation[i] + " :"));
						panel.add(new Label(annotation[i+1]));
					}
				}
			}
		}
		return panel;
	}

	public String getHoverHelp(IMarker marker) {
		return null;
//		return BPELUtil.getObjectFromMarker(marker, ref) marker.toString();
	}

	protected ILabeledElement getLabeledElement(EObject modelObject) {
		if (modelObject == null) {
			return null;
		}
		for (Adapter adapter : modelObject.eAdapters()) {
			if (adapter instanceof ILabeledElement) {
				return (ILabeledElement)adapter;
			}
		}
		return null;
	}
	
	private static class BoldLabel extends Label {
		@Override
		public void addNotify() {
			super.addNotify();
			
			Font font = getFont();
			if (font == null) {
				return;
			}
			FontData[] fontData = font.getFontData();
			for (FontData fd : fontData) {
				fd.setStyle(fd.getStyle() | SWT.BOLD);
			}
			Font bold = new Font(font.getDevice(), fontData);
			setFont(bold);
		}
	}
	
}
