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
package org.eclipse.bpel.ui.actions;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.print.PrintGraphicalViewerOperation;
import org.eclipse.gef.ui.actions.PrintAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;

public class BPELPrintAction extends PrintAction {

	protected class InternalPrintGraphicalViewerOperation extends PrintGraphicalViewerOperation {
		
		protected boolean needMultiPageX = false;
		protected boolean needMultiPageY = false;

		private long fPagesX = 1;
		private long fPagesY = 1;
		
		public InternalPrintGraphicalViewerOperation(Printer p, GraphicalViewer g) {
			super(p, g);
		}
		
		protected ImageData getNewImageData(Image image) {
			ImageData imageData = image.getImageData();
		
			int x = imageData.width;
			int y = imageData.height;
			
			return imageData.scaledTo(x, y);			
		}
		
		@Override
		protected void setupPrinterGraphicsFor(Graphics graphics, IFigure figure) {
			super.setupPrinterGraphicsFor(graphics, figure);
			
			double dpiScale = (double) getPrinter().getDPI().x / Display.getCurrent().getDPI().x;
			
			// put the print region in display coordinates
			org.eclipse.draw2d.geometry.Rectangle printableRegion = getPrintRegion();
			printableRegion.width /= dpiScale;
			printableRegion.height /= dpiScale;
			
			org.eclipse.draw2d.geometry.Rectangle printRegion = figure.getBounds();

			if (printRegion.width > printableRegion.width) {
				needMultiPageX = true;
				fPagesX = printRegion.width / printableRegion.width;
				if (printRegion.width % printableRegion.width != 0)
					fPagesX ++;
			}
			
			if (printRegion.height > printableRegion.height) {
				needMultiPageY = true;
				fPagesY = printRegion.height / printableRegion.height;
				if ((printRegion.height % printableRegion.height) != 0)
					fPagesY ++;
			}			
		}
		
		@Override
		protected void printPages() {
			Graphics graphics = getFreshPrinterGraphics();
			IFigure figure = getPrintSource();
			setupPrinterGraphicsFor(graphics, figure);
			
			org.eclipse.draw2d.geometry.Rectangle region = figure.getBounds();
			Image image = new Image(null, region.width, region.height);
			GC gc = new GC(image);
			SWTGraphics g = new SWTGraphics(gc);
			g.translate(region.x, region.y);

			figure.paint(g);
			
			
			double dpiScale = (double) getPrinter().getDPI().x / Display.getCurrent().getDPI().x;
			
			// put the print region in display coordinates
			region = getPrintRegion();
			region.width /= dpiScale;
			region.height /= dpiScale;			
			
			
			// print the graph
			ImageData imageData = getNewImageData(image);
			Image newImage = new Image(null, imageData);
						
			for (int j=0; j < fPagesY; j++) {
				for (int i=0; i < fPagesX; i++) {
					int x = region.width * i;
					int y = region.height * j;
					
					graphics.pushState();
					getPrinter().startPage();
					graphics.drawImage(newImage, 
							x, 
							y, 
							imageData.width - x,
							imageData.height - y,
							0,
							0,
							imageData.width - x,
							imageData.height - y);
					getPrinter().endPage();
					graphics.popState();
				}
			}
			
			g.dispose();
			gc.dispose();
			image.dispose();			
		}
	}
	
	public BPELPrintAction(IWorkbenchPart part) {
		super(part);
	}

	@Override
	public void run() {
		GraphicalViewer viewer;
		viewer = (GraphicalViewer)getWorkbenchPart().getAdapter(GraphicalViewer.class);
		
		PrintDialog dialog = new PrintDialog(viewer.getControl().getShell(), SWT.NULL);
		PrinterData data = dialog.open();
		
		if (data != null) {
			PrintGraphicalViewerOperation op = 
						new InternalPrintGraphicalViewerOperation(new Printer(data), viewer);
			op.run(getWorkbenchPart().getTitle());
		}
	}
		
}
