/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dnd;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.ui.Templates;
import org.eclipse.bpel.ui.Templates.Template;
import org.eclipse.bpel.ui.Templates.TemplateResource;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.internal.text.html.HTMLTextPresenter;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 16, 2007
 *
 */
public class DropPopup extends PopupDialog implements StatusTextListener, MenuDetectListener, KeyListener {
	
		
	
	interface CommandListener {
		/**
		 * @param cmd
		 */
		void execute (String cmd) ;
	}
	
	CommandListener fTarget;
	
	protected HTMLTextPresenter fPresenter;
	protected  TextPresentation fPresentation =  new TextPresentation();
	protected StyledText fText;
	
	void setCommandListener ( CommandListener listener ) {
		fTarget = listener;
	}
	
	
	/**
	 * @param parentShell
	 * @param shellStyle
	 * @param title
	 * @param statusFieldText
	 */
	
	public DropPopup (Shell parentShell, int shellStyle, String title, String statusFieldText) {		
		super(parentShell,shellStyle | SWT.TOOL, true, true, false, false, title, statusFieldText);	
	}
	
	@Override
	protected Control createDialogArea (Composite parent) {
		fText= new StyledText(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		fText.setEditable(false);
		fPresenter= new HTMLTextPresenter(false);

		fText.addControlListener(new ControlAdapter() {
			/*
			 * @see org.eclipse.swt.events.ControlAdapter#controlResized(org.eclipse.swt.events.ControlEvent)
			 */
			@Override
			public void controlResized(ControlEvent e) {
				fText.setText(fText.getText());
			}
		});	
		return fText;
	}
	
	
	protected void setInput (String html) {
				
		Template template = getViewTemplate();
		TemplateResource resource = template.getResources().get(0);
		
		Map<String,Object> args = new HashMap<String,Object>();
		
		args.put("content",html);
		args.put("background-color", toCSS("background-color", getShell().getBackground() ));
		args.put("font", toCSS( getShell().getFont() ));
		
		fPresentation.clear();
		Rectangle size=  fText.getClientArea();
		html = resource.process(args);
		System.out.println("Text: "  + html);
		html = ((DefaultInformationControl.IInformationPresenterExtension)fPresenter).updatePresentation(getShell(), html, fPresentation, size.width, size.height);
		fText.setText(html);
		
		TextPresentation.applyTextPresentation(fPresentation, fText);		
		
		// fBrowser.setText( resource.process(args) );		
		
	}	
		
	
	String toCSS ( String name, Color color ) {
		StringBuilder sb = new StringBuilder();
	
		sb.append(name).append(": rgb(").append(color.getRed()).append(",");
		sb.append(color.getGreen()).append(",");
		sb.append(color.getBlue()).append(");");
		return sb.toString();
	}
	
	String toCSS ( Font font ) {
		
		FontData fd[] = font.getFontData();
		
		StringBuilder sb = new StringBuilder ();
		
		if (fd.length < 1) {
			return sb.toString();
		}
		
		sb.append("font-size: ").append(fd[0].getHeight()).append("pt;");
		sb.append("font-family: ").append(fd[0].getName()).append(";");
		
		return sb.toString();		
	}
	
	
	@SuppressWarnings("nls")
	
	Template getViewTemplate () {		
		Template t = dropTemplates.getTemplateByKey("dropPopupTemplate");
		if (t == null || true ) {
			dropTemplates.initializeFrom("/html/");
			t = dropTemplates.getTemplateByKey("dropPopupTemplate");
		}
		return t;
		
	}
	
	
	static Templates dropTemplates = new Templates();


	/** (non-Javadoc)
	 * @see org.eclipse.swt.browser.StatusTextListener#changed(org.eclipse.swt.browser.StatusTextEvent)
	 */
	
	public void changed (StatusTextEvent event) {
		String cmd = event.text;
		if (cmd == null || cmd.startsWith("event://") == false) {
			return ;
		}
		
		cmd = cmd.substring(8);
		if (fTarget != null) {
			fTarget.execute(cmd);
		}
		close();
	}

	/**
	 * @see org.eclipse.swt.events.MenuDetectListener#menuDetected(org.eclipse.swt.events.MenuDetectEvent)
	 */
	public void menuDetected (MenuDetectEvent e) {
		e.doit = false;		
	}

	/**
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyPressed (KeyEvent e) {					
		e.doit = false;
		close();
	}

	/**
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {		 
		e.doit = false;
	}
	
	
}
