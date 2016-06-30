/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
public class TypeTwo extends NamedObject {
	public static final String P_FLAG1="flag1"; //$NON-NLS-1$
	public static final String P_FLAG2="flag2"; //$NON-NLS-1$
	private boolean flag1;
	private boolean flag2;

	/**
	 * @param name
	 */
	public TypeTwo(String name, boolean flag1, boolean flag2) {
		super(name);
		this.flag1 = flag1;
		this.flag2 = flag2;
	}
	public boolean getFlag1() {
		return flag1;
	}
	public boolean getFlag2() {
		return flag2;
	}
	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
		model.fireModelChanged(new Object[] {this}, IModelListener.CHANGED, P_FLAG1);
	}
	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
		model.fireModelChanged(new Object[] {this}, IModelListener.CHANGED, P_FLAG2);
	}
}