/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;

public class AttributeConstuctionElement {
	FormToolkit widgetFactory;
	Composite parent;
	AttributeValue value;

	public AttributeConstuctionElement(FormToolkit widgetFactory, Composite parent,
	                                    AttributeValue value) {
		super();
		this.widgetFactory = widgetFactory;
		this.parent = parent;
		this.value = value;
	}

	public FormToolkit getWidgetFactory() {
		return widgetFactory;
	}

	public void setWidgetFactory(FormToolkit widgetFactory) {
		this.widgetFactory = widgetFactory;
	}

	public Composite getParent() {
		return parent;
	}

	public void setParent(Composite parent) {
		this.parent = parent;
	}

	public AttributeValue getValue() {
		return value;
	}

	public void setValue(AttributeValue value) {
		this.value = value;
	}

}
