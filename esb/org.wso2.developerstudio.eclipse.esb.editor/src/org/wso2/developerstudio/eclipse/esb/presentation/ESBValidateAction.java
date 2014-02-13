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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;


public class ESBValidateAction extends ValidateAction{
	
	protected Collection<EObject> selectedEObjects = null;
	protected Shell shell = null;
	
	
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				this.selectedEObjects = structuredSelection.toList();
			}
		}catch (Exception e) {
			MessageDialog.openInformation(shell, "Validate", "Validate Exception");
			throw new RuntimeException(e);
		}
		
		super.selectionChanged(event);
	}
	
	public void run() {
		IBatchValidator validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
//		validator.setOption(IBatchValidator.OPTION_INCLUDE_LIVE_CONSTRAINTS, true);
//		validator.setOption(IBatchValidator.OPTION_TRACK_RESOURCES, true);
		validator.setIncludeLiveConstraints(true);
		validator.setReportSuccesses(false);
		final IStatus status = validator.validate(selectedEObjects);
		if (status.isOK()) {
			MessageDialog.openInformation(shell, "Validate", "Validate Success");
		} else {
			ListDialog dialog = new ListDialog(shell);
			dialog.setInput(status);
			dialog.setTitle("Validate");
			dialog.setContentProvider(new IStructuredContentProvider() {
				public void dispose() {
					// nothing to dispose
				}

				public Object[] getElements(Object inputElement) {
					if (status != null && status.isMultiStatus() && status == inputElement) {
						return status.getChildren();
					} else if (status != null && status == inputElement) {
						return new Object[] {status};
					}
					return new Object[0];
				}

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					// Do nothing.
				}
			});
			dialog.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					if (element instanceof IStatus) {
						if(((IStatus)element).isMultiStatus()){
							IStatus[] children = ((IStatus)element).getChildren();
							String text = new String();
							for (IStatus iStatus : children) {
								text +=  iStatus.getMessage() + "\n";
                            }
							return text.replaceAll("\n$", "");
						} else{
							return ((IStatus)element).getMessage();
						}
						
					}
					return null;
				}
				@Override
				public Image getImage(Object element) {
				    return SWTResourceManager.getImage(this.getClass(),
					"/icons/exclamation.png");
				}
			});
			dialog.setBlockOnOpen(true);
			dialog.setMessage("Validation Failed");
			
			if (Window.OK == dialog.open()) {
				Set<EObject> errorSelections = new HashSet<EObject>();
				if (!status.isMultiStatus()) {
//					IConstraintStatus cstatus = (IConstraintStatus)status;
//					errorSelections.add(cstatus.getTarget());
				} else {
					IStatus[] children = status.getChildren();
					for (IStatus element : children) {
//						IConstraintStatus cstatus = (IConstraintStatus)element;
//						errorSelections.add(cstatus.getTarget());
					}
				}
//				editor.setSelectionToViewer(errorSelections);
			}
		}
		
//		ValidationDelegateClientSelector.running = false;
		
		// Create problem markers on the resources with validation failures/warnings.
		try {
			MarkerUtil.updateMarkers(status);
		} catch (CoreException e) {
//			.getDefault().getLog().log(e.getStatus());
		}
		
//		super.run();
	}
	
	
}
