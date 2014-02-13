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
package org.wso2.developerstudio.eclipse.esb.constraint;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * A constraint responsible for validating string attributes that should contain
 * xml content.
 */
public class MandatoryXmlStringPropertyConstraint extends AbstractModelConstraint {
	/**
	 * {@inheritDoc}
	 */
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		
		if (eType == EMFEventType.NULL) {
			
			if(eObj instanceof ModelObject){
				/*
				Map<String, ObjectValidator> validateMap = ((ModelObject)eObj).validate();
				for (ObjectValidator obValidator : validateMap.values()) {
					Map<String, String> mediatorErrorMap = obValidator.getMediatorErrorMap();
					if(mediatorErrorMap.size() == 0){
						return ctx.createSuccessStatus();
					}else{
						Status status = new Status(4, "org.wso2.developerstudio.eclipse.esb", mediatorErrorMap.values().toArray(new String[]{})[0]);
						return status;					
					}
				}*/
				return ctx.createSuccessStatus();
			}
		}else{
			List<Notification> notifications = ctx.getAllEvents();

			// We are only interested in live validations triggered by 'set'
			// operations which cause only one notification to be sent. 
			if (notifications.size() == 1) {
				Notification notification = notifications.get(0);
				String newValue = notification.getNewStringValue();
				String oldValue = notification.getOldStringValue();

				// If the original value is also invalid, there is no point in
				// triggering a failure. 
				if (!isValidXml(newValue) && isValidXml(oldValue)) {
					return ctx.createFailureStatus();
				}
			}
			
			return ctx.createSuccessStatus();
		}
		
		return ctx.createFailureStatus();
	}
	
	/**
	 * Utility method for checking if a given string contains valid xml. 
	 * 
	 * @param input input string.
	 * @return true if the input string contains valid xml, false otherwise.
	 */
	private boolean isValidXml(String input) {
		boolean result = false;
		if (!StringUtils.isBlank(input)) {
			try {
				EsbUtils.parseElement(input);
				result = true;
			} catch (Exception ex) {
				// Not interested.
			}
		}
		return result;
	}
}
