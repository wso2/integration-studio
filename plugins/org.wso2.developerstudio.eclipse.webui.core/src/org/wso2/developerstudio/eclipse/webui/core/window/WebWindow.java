/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.webui.core.window;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.webui.core.composite.WebComposite;
import org.wso2.developerstudio.eclipse.webui.core.exception.WebUIException;
import org.wso2.developerstudio.eclipse.webui.core.window.function.DisposeWindowFunction;
import org.wso2.developerstudio.eclipse.webui.core.window.function.ResizeWindowFunction;

public class WebWindow {

	protected WebComposite composite;
	protected Shell shell;

	public WebWindow(String appID) throws WebUIException {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		positionShell();
		composite = new WebComposite(appID, shell, SWT.NONE);
		injectCallbacks();
	}

	public WebWindow(String appID, String appContext) throws WebUIException {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		positionShell();
		composite = new WebComposite(appID, appContext, shell, SWT.NONE);
		injectCallbacks();
	}

	public WebWindow(URL appURL) throws WebUIException {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		positionShell();
		composite = new WebComposite(appURL, shell, SWT.NONE);
		injectCallbacks();
	}
	
	public void setSize(int width, int height){
		this.shell.setSize(width, height);
		positionShell();
		shell.redraw();
	}

	private void positionShell() {
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Monitor primary = Display.getDefault().getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);
	}

	private void injectCallbacks() {
		new DisposeWindowFunction(this);
		new ResizeWindowFunction(this);	
	}

	public void open() {
		shell.setText("Updates Manager for Developer Studio");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!Display.getDefault().readAndDispatch()) {
				Display.getDefault().sleep();
			}
		}
	}

	public Browser getBrowser() {
		return composite.getBrowser();
	}

	public Shell getShell() {
		return shell;
	}

}
