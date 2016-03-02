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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskTriggerType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.task.TaskDescription;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class TaskDeserializer extends AbstractEsbNodeDeserializer<TaskDescription, Task> {

	@Override
	public Task createNode(IGraphicalEditPart part, TaskDescription task) {
		Task taskModel = (Task) DeserializerUtils.createNode(part, EsbElementTypes.Task_3667);
		setElementToEdit(taskModel);

		executeSetValueCommand(TASK__TASK_NAME, task.getName());
		executeSetValueCommand(TASK__TASK_IMPLEMENTATION, task.getTaskImplClassName());

		if (task.getTaskGroup() != null) {
			executeSetValueCommand(TASK__TASK_GROUP, task.getTaskGroup());
		}

		if (task.getPinnedServers().size() > 0) {
			executeSetValueCommand(TASK__PINNED_SERVERS,
					DeserializerUtils.join(task.getPinnedServers(), ","));
		}

		EList<TaskProperty> properties = new BasicEList<TaskProperty>();
		for (OMElement element : task.getXmlProperties()) {
			if (element != null) {
				OMAttribute name = element.getAttribute(new QName("name"));
				if (element.getLocalName().equals("property") && name != null) {
					TaskProperty property = EsbFactory.eINSTANCE.createTaskProperty();
					property.setPropertyName(name.getAttributeValue());
					OMAttribute value = element.getAttribute(new QName("value"));
					if (value != null) {
						property.setPropertyType(TaskPropertyType.LITERAL);
						property.setPropertyValue(value.getAttributeValue());
					} else {
						property.setPropertyType(TaskPropertyType.XML);
						property.setPropertyValue(element.getFirstElement().toString());
					}
					properties.add(property);
				}
			}
		}
		if (properties.size() > 0) {
			executeSetValueCommand(TASK__TASK_PROPERTIES, properties);
		}

		if (task.getCronExpression() != null) {
			executeSetValueCommand(TASK__CRON, task.getCronExpression());
			executeSetValueCommand(TASK__TRIGGER_TYPE, TaskTriggerType.CRON);
		} else {
			executeSetValueCommand(TASK__TRIGGER_TYPE, TaskTriggerType.SIMPLE);
			executeSetValueCommand(TASK__COUNT, (long)task.getCount());
			executeSetValueCommand(TASK__INTERVAL, task.getInterval());
		}

		return taskModel;
	}

}
