/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver42.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Test {
	public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setSize(300, 200);
	    shell.setText("Button Example");
	    shell.setLayout(new RowLayout());

	    final Button button = new Button(shell, SWT.CHECK);
	    button.setText("Click Me");
	    
	    final Text text = new Text(shell, SWT.SHADOW_IN);

	    button.addSelectionListener(new SelectionListener() {

	      public void widgetSelected(SelectionEvent event) {
	        text.setText("No worries!");
	        boolean g = button.getGrayed();
	        boolean s = button.getSelection();
        	button.setSelection(s ^ g);
        	button.setGrayed(s && !g);
	      }
	      public void widgetDefaultSelected(SelectionEvent event) {
	        text.setText("No worries!");
	      }
	    });
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	  }
}
