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
import java.util.ArrayList;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class SimpleModel {
	private ArrayList modelListeners;
	private ArrayList objects;
	public SimpleModel() {
		modelListeners = new ArrayList();
		initialize();
	}
	public void addModelListener(IModelListener listener) {
		if (!modelListeners.contains(listener))
			modelListeners.add(listener);
	}
	public void removeModelListener(IModelListener listener) {
		modelListeners.remove(listener);
	}
	public void fireModelChanged(Object[] objects, String type, String property) {
		for (int i = 0; i < modelListeners.size(); i++) {
			((IModelListener) modelListeners.get(i)).modelChanged(objects,
					type, property);
		}
	}
	public Object[] getContents() {
		return objects.toArray();
	}
	private void initialize() {
		objects = new ArrayList();
		NamedObject[] objects = {
				new TypeOne(Messages.getString("SimpleModel.t1_i1"), 2, true, Messages.getString("SimpleModel.text1")), //$NON-NLS-1$ //$NON-NLS-2$
				new TypeOne(Messages.getString("SimpleModel.t1_i2"), 1, false, Messages.getString("SimpleModel.text2")), //$NON-NLS-1$ //$NON-NLS-2$
				new TypeOne(Messages.getString("SimpleModel.t1_i3"), 3, true, Messages.getString("SimpleModel.text3")), //$NON-NLS-1$ //$NON-NLS-2$
				new TypeOne(Messages.getString("SimpleModel.t1_i4"), 0, false, Messages.getString("SimpleModel.text4")), //$NON-NLS-1$ //$NON-NLS-2$
				new TypeOne(Messages.getString("SimpleModel.t1_i5"), 1, true, Messages.getString("SimpleModel.text5")), //$NON-NLS-1$ //$NON-NLS-2$
				new TypeTwo(Messages.getString("SimpleModel.t2_i1"), false, true), //$NON-NLS-1$
				new TypeTwo(Messages.getString("SimpleModel.t2_i2"), true, false)}; //$NON-NLS-1$
		add(objects, false);
	}
	public void add(NamedObject[] objs, boolean notify) {
		for (int i = 0; i < objs.length; i++) {
			objects.add(objs[i]);
			objs[i].setModel(this);
		}
		if (notify)
			fireModelChanged(objs, IModelListener.ADDED, ""); //$NON-NLS-1$
	}
	public void remove(NamedObject[] objs, boolean notify) {
		for (int i = 0; i < objs.length; i++) {
			objects.remove(objs[i]);
			objs[i].setModel(null);
		}
		if (notify)
			fireModelChanged(objs, IModelListener.REMOVED, ""); //$NON-NLS-1$
	}
}