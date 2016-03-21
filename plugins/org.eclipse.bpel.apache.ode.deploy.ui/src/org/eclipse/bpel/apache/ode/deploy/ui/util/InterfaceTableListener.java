/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui.util;

import java.util.Iterator;

import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.ui.pages.ProcessPage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.ide.IDE;
import org.eclipse.wst.wsdl.PortType;

public class InterfaceTableListener implements Listener {

	protected ProcessType processType = null;
	protected Table table = null;
	protected TableEditor editor = null;
	protected FormToolkit toolkit = null;
	protected IWorkbenchPage page = null;
	protected boolean isInbound = false;
	
	public InterfaceTableListener(ProcessType fProcessType, Table fTable, TableEditor fEditor, FormToolkit fToolkit, IWorkbenchPage fPage, boolean bIsInbound){
		processType = fProcessType;
		table = fTable;
		editor = fEditor;
		toolkit = fToolkit;
		page = fPage;
		isInbound = bIsInbound;
	}
	
	public void handleEvent(Event event) {
        Rectangle clientArea = table.getClientArea();
        Point pt = new Point(event.x, event.y);
        int index = table.getTopIndex();
        while (index < table.getItemCount()) {
          boolean visible = false;
          final TableItem item = table.getItem(index);
          for (int i = 0; i < table.getColumnCount(); i++) {
            Rectangle rect = item.getBounds(i);
            if (rect.contains(pt)) {
              
            final int column = i;
            
            System.out.println("A cell in column " + (i+1) + " has been pressed");
            
             if (i == ProcessPage.PARTNER_LINK_COLUMN) {
            	  System.out.println("PORT_TYPE_COLUMN has been pressed");
            	  final Hyperlink link = toolkit.createHyperlink(table, "", SWT.NONE); //$NON-NLS-1$
            	  IHyperlinkListener listener = new HyperlinkAdapter(){
            			public void linkActivated(HyperlinkEvent e) {
            				
            				System.out.println("Hyper clicked!");
            				
            				String partnerLinkName = e.getLabel();
            				PartnerLink theOne = null;
            			
            				PartnerLinks partnerLinksElm = processType.getModel().getPartnerLinks();
            				EList<PartnerLink> partnerLinks = partnerLinksElm.getChildren();
            				for (Iterator<PartnerLink> iterator = partnerLinks.iterator(); iterator.hasNext();) {
            					PartnerLink currentPL = iterator.next();
            					if (currentPL.getName().equals(partnerLinkName)){
            						theOne = currentPL;
            						break;
            					}
							}
            				
            				if (theOne != null) {

            					Role role = null;
            					
            					if (isInbound) {
            						role = theOne.getMyRole();
            					}
            					else {
            						role = theOne.getPartnerRole();
            					}

            					if (role != null) {
									PortType portType = (PortType) role.getPortType();
									Resource resource = portType.eResource();
									IFile file = DeployUtils.getIFileForURI(resource.getURI());;
									try {
										IDE.openEditor(page, file);
									} 
									catch (PartInitException e1) {
										e1.printStackTrace();
									}
								}
            				}
            			}
            	  };
            	  link.addHyperlinkListener(listener);
	              editor.setEditor(link, item, i);
	              link.setText(item.getText(i));
	              link.setFocus();
             }
             else {
	              final Text text = new Text(table, SWT.NONE);
	              Listener textListener = new Listener() {
	                public void handleEvent(final Event e) {
	                  switch (e.type) {
	                  case SWT.FocusOut:
	                    item.setText(column, text.getText());
	                    text.dispose();
	                    break;
	                  case SWT.Traverse:
	                    switch (e.detail) {
	                    case SWT.TRAVERSE_RETURN:
	                      item.setText(column, text.getText());
	                    // FALL THROUGH
	                    case SWT.TRAVERSE_ESCAPE:
	                      text.dispose();
	                      e.doit = false;
	                    }
	                    break;
	                  }
	                }
	              };
	              text.addListener(SWT.FocusOut, textListener);
	              text.addListener(SWT.Traverse, textListener);
	              editor.setEditor(text, item, i);
	              text.setText(item.getText(i));
	              text.selectAll();
	              text.setFocus();
             }

              return;
            }
            if (!visible && rect.intersects(clientArea)) {
              visible = true;
            }
          }
          if (!visible)
            return;
          index++;
        }
      }
}
