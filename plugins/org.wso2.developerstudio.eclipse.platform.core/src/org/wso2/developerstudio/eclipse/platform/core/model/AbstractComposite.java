/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;

public abstract class AbstractComposite extends Composite implements Observer {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private ProjectDataModel projectModel;
	private ProjectOptionData projectOptionData;
	private AbstractFieldController fieldController;
	private WizardPage wizardPage;

	/**
	 * 
	 * @param parent
	 *            Parent composite of
	 * @param style
	 *            SWT style
	 * @param model
	 */
	public AbstractComposite(Composite parent, int style, ProjectDataModel model, ProjectOptionData optionData,
	                         WizardPage wizardPage) {
		super(parent, style);
		setProjectModel(model);
		setProjectOptionData(optionData);
		if (null != getProjectOptionData().getFieldController()) {
			setFieldController(getProjectOptionData().getFieldController());
		}
		setWizardPage(wizardPage);
		projectModel.addObserver(this);
	}

	/**
	 * 
	 * @param projectModel
	 */
	public void setProjectModel(ProjectDataModel projectModel) {
		this.projectModel = projectModel;
	}

	public ProjectDataModel getProjectModel() {
		return projectModel;
	}

	public ProjectOptionData getProjectOptionData() {
		return projectOptionData;
	}

	public void setProjectOptionData(ProjectOptionData projectOptionData) {
		this.projectOptionData = projectOptionData;
	}

	public void setFieldController(AbstractFieldController fieldController) {
		this.fieldController = fieldController;
	}

	public AbstractFieldController getFieldController() {
		return fieldController;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setModelPropertyValue(String key, Object value) {
		boolean ret;
		try {
			ret = getProjectModel().setModelPropertyValue(key, value);
			validate();
			getWizardPage().setPageComplete(true);
			getWizardPage().setErrorMessage(null);
			invokePrivateMethod((Object) getWizardPage(), "doPostFieldModificationAction",
			                    new Object[] { getProjectOptionData() });
		} catch (FieldValidationException e) {
			getWizardPage().setPageComplete(false);
			getWizardPage().setErrorMessage(e.getMessage());
			return false;
		} catch (ObserverFailedException e) {
			log.error(e.getMessage(), e);
			getWizardPage().setPageComplete(false);
			return false;
		} catch (SecurityException e) {
			getWizardPage().setPageComplete(false);
			return false;
		}
		return ret;
	}

	public boolean validate() throws FieldValidationException {
		if (getCustomFields() != null) {
			for (String fieldKey : getCustomFields()) {
				Object fieldValue = getProjectModel().getModelPropertyValue(fieldKey);
				getFieldController().validate(fieldKey, fieldValue, getProjectModel());
			}
		}
		return false;
	}

	private static Object invokePrivateMethod(Object o, String methodName, Object[] params) {

		final Method methods[] = o.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; ++i) {
			if (methodName.equals(methods[i].getName())) {
				try {
					methods[i].setAccessible(true);
					return methods[i].invoke(o, params);
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
				} catch (InvocationTargetException ite) {
					log.error(ite.getMessage(), ite);
				}
			}
		}
		return null;
	}

	public abstract List<String> getCustomFields();

	public WizardPage getWizardPage() {
		return wizardPage;
	}

	public void setWizardPage(WizardPage wizardPage) {
		this.wizardPage = wizardPage;
	}

}
