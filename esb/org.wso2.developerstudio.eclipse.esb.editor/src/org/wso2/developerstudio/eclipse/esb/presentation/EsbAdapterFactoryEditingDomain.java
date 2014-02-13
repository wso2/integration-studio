/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.esb.presentation;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

public class EsbAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain {

	private static Collection<Object> sharedClipboard;

	public EsbAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack,
	                                      ResourceSet resourceSet) {
		super(adapterFactory, commandStack, resourceSet);
	}

	public EsbAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack) {
		super(adapterFactory, commandStack);

	}

	public EsbAdapterFactoryEditingDomain(ComposedAdapterFactory adapterFactory,
	                                      BasicCommandStack commandStack,
	                                      HashMap<Resource, Boolean> hashMap) {
		super(adapterFactory, commandStack, hashMap);
	}

	
	public Collection<Object> getClipboard() {
		return sharedClipboard;
	}

	
	public void setClipboard(Collection<Object> clipboard) {
		super.setClipboard(clipboard);
		sharedClipboard = clipboard;
	}

}
