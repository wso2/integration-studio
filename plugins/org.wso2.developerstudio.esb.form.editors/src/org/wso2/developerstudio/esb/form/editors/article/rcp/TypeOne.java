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


package org.wso2.developerstudio.esb.form.editors.article.rcp;

/**
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class TypeOne extends NamedObject {
	public static final String P_CHOICE="choice"; //$NON-NLS-1$
	public static final String P_FLAG="flag"; //$NON-NLS-1$
	public static final String P_TEXT="text"; //$NON-NLS-1$
	public static final String [] CHOICES = {
			Messages.getString("TypeOne.c1"), Messages.getString("TypeOne.c2"), Messages.getString("TypeOne.c3"), Messages.getString("TypeOne.c4") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	private int choice=0;
	private String text;
	private boolean flag;

	/**
	 * @param name
	 */
	public TypeOne(String name, int choice, boolean flag, String text) {
		super(name);
		this.flag = flag;
		this.text = text;
		this.choice = choice;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
		model.fireModelChanged(new Object[] {this}, IModelListener.CHANGED, P_CHOICE);
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
		model.fireModelChanged(new Object[] {this}, IModelListener.CHANGED, P_FLAG);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		model.fireModelChanged(new Object[] {this}, IModelListener.CHANGED, P_TEXT);
	}
}