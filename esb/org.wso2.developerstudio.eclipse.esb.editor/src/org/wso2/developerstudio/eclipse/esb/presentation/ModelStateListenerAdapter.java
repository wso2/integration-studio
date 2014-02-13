/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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

import org.eclipse.wst.sse.core.internal.provisional.IModelStateListener;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;

/**
 * An adapter for {@link IModelStateListener}.
 */
@SuppressWarnings("restriction")
public class ModelStateListenerAdapter implements IModelStateListener {

	/**
	 * {@inheritDoc}
	 */
	public void modelAboutToBeChanged(IStructuredModel model) {
		// Do nothing.		
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelAboutToBeReinitialized(IStructuredModel model) {
		// Do nothing.		
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelChanged(IStructuredModel model) {
		// Do nothing.
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelDirtyStateChanged(IStructuredModel model, boolean dirty) {
		// Do nothing.	
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelReinitialized(IStructuredModel model) {
		// Do nothing.		
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelResourceDeleted(IStructuredModel model) {
		// Do nothing.
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelResourceMoved(IStructuredModel source, IStructuredModel destination) {
		// Do nothing.
	}	
}
