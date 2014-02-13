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
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * A constraint for validating mandatory {@link NamespacedProperty} attributes.
 */
public class MandatoryNamespacedPropertyConstraint extends AbstractModelConstraint {
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
				String newValue = ((NamespacedProperty) notification.getNewValue()).getPropertyValue();
				String oldValue = ((NamespacedProperty) notification.getOldValue()).getPropertyValue();
				
				// If the original value is also invalid, there is no point in
				// triggering a failure. 
				if (StringUtils.isBlank(newValue) && !StringUtils.isBlank(oldValue)) {
					return ctx.createFailureStatus();
				}
			}
			
			return ctx.createSuccessStatus();
		}
		return ctx.createFailureStatus();
	}	
}
