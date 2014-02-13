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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.ui.IEditorPart;

/**
 * This class provides live model constraint validation support.
 */
public class LiveValidationContentAdapter extends EContentAdapter {
	/**
	 * {@link ILiveValidator} used to delegate model constraint validation.
	 */
	private ILiveValidator validator;
	
	/**
	 * A reference to model editor.
	 */
	private IEditorPart editorPart;
	
	/**
	 * Reference to current editing domain.
	 */
	private EditingDomain editingDomain;
	
	/**
	 * Creates a new {@link LiveValidationContentAdapter}.
	 * 
	 * @param editorPart model editor.
	 * @param editingDomain used to undo commands when validation errors are encountered.
	 */
	public LiveValidationContentAdapter(IEditorPart editorPart, EditingDomain editingDomain) {
		this.editorPart = editorPart;
		this.editingDomain = editingDomain;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		editorPart.getEditorSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (null == validator) {
					validator = (ILiveValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
				}
				
				IStatus status = validator.validate(notification);
				
				if (!status.isOK()) {
					/*
					 * TODO: Here we simply undo the last command hoping that it
					 * was the cause for this validation failure. Instead of
					 * this hack, the recommended method is to use the EMF
					 * transactions API for reverting changes upon validation
					 * errors. I tried out the EMF transactions API in this
					 * regard but could not figure out how to use it for undoing
					 * changes (I couldn't get the example to work as explained
					 * in http://dev.eclipse.org/newslists/news.eclipse
					 * .tools.emf/msg30253.html).
					 */
					editingDomain.getCommandStack().undo();
				}
			}
		});
	}
}
