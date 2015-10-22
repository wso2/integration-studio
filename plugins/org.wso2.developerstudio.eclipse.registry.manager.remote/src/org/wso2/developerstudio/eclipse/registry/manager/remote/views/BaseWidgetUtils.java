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

package org.wso2.developerstudio.eclipse.registry.manager.remote.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class BaseWidgetUtils {

	public static Composite createColumnContainer(Composite parent,
			int columnCount, int span) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(columnCount, false);
		gl.marginHeight = gl.marginWidth = 0;
		container.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = span;
		container.setLayoutData(gd);
		return container;
	}

	public static Text createLabeledText(Composite parent, String text, int span) {
		Text t = new Text(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = span;
		t.setLayoutData(gd);
		t.setEditable(false);
		t.setBackground(parent.getBackground());
		t.setText(text);
		return t;
	}
}
