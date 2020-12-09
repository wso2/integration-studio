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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.Task;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskPropertyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskTriggerType;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ScheduledTaskFormPage;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.task.TaskDescription;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import java.util.ArrayList;
import java.util.List;

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
            executeSetValueCommand(TASK__PINNED_SERVERS, DeserializerUtils.join(task.getPinnedServers(), ","));
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
            executeSetValueCommand(TASK__COUNT, (long) task.getCount());
            executeSetValueCommand(TASK__INTERVAL, task.getInterval());
        }

        return taskModel;
    }

    @Override
    public void createNode(FormEditor formEditor, TaskDescription task) {
        ESBFormEditor LocalEntryFormEditor = (ESBFormEditor) formEditor;
        FormPage formPage = LocalEntryFormEditor.getFormPageForArtifact(ArtifactType.TASK);
        if (formPage instanceof ScheduledTaskFormPage) {
            ScheduledTaskFormPage taskFormPage = (ScheduledTaskFormPage) formPage;
            if (task.getName() != null) {
                taskFormPage.getTaskName().setText(task.getName());
            }
            if (task.getTaskImplClassName() != null) {
                taskFormPage.getTaskImpl().setText(task.getTaskImplClassName());
            }
            if (task.getTaskGroup() != null) {
                taskFormPage.getTaskGroup().setText(task.getTaskGroup());
            }
            if (task.getPinnedServers() != null) {
                if (task.getPinnedServers().size() > 0) {
                    taskFormPage.getPinnedServers().setText(DeserializerUtils.join(task.getPinnedServers(), ","));
                }
            }

            if (task.getCronExpression() != null) {
                taskFormPage.getTriggerType().select(1);
                taskFormPage.getCron().setText(task.getCronExpression());
                taskFormPage.setCheckCron(true);
            } else if (String.valueOf(task.getCount()) != null || String.valueOf(task.getInterval()) != null) {
                taskFormPage.getTriggerType().select(0);
                taskFormPage.setCheckSimple(true);
                if (taskFormPage.getCount() != null) {
                    taskFormPage.getCount().setText(String.valueOf(task.getCount()));
                }
                if (taskFormPage.getInterval() != null) {
                    taskFormPage.getInterval().setText(String.valueOf(task.getInterval()));
                }
            }

            if (!task.getXmlProperties().isEmpty()) {
                List<TaskProperty> existingProperties = taskFormPage.getTaskPropertyList();
                List<TaskProperty> newlyAddedProperties = new ArrayList<TaskProperty>();
                List<TaskProperty> removedProperties = new ArrayList<TaskProperty>();
                List<TaskProperty> newProperties = new ArrayList<TaskProperty>();

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

                            if (existingProperties != null) {
                                for (TaskProperty propertyItem : existingProperties) {
                                    // When updating the existing properties from source view, then remove the property
                                    // from old list and add to new list
                                    if (propertyItem.getPropertyName().equals(name.getAttributeValue())) {
                                        existingProperties.remove(propertyItem);
                                        newlyAddedProperties.add(property);
                                        break;
                                    }
                                }
                            }
                            // When adding a new property from source then add it to the new list
                            if (!newlyAddedProperties.contains(property)) {
                                newlyAddedProperties.add(property);
                            }
                        }
                    }
                }
                // If old properties contain any property values, then remove the value and add the property to the new
                // list, DEVTOOLESB-505
                if (existingProperties != null) {
                    for (TaskProperty prop : existingProperties) {
                        String value = prop.getPropertyValue();
                        String name = prop.getPropertyName();
                        if (StringUtils.isNotEmpty(value)) {
                            // Add the property to removed list
                            removedProperties.add(prop);
                            TaskProperty newPrp = createProperty(name);
                            if (!newlyAddedProperties.contains(newPrp)) {
                                // Add to the new properties list
                                newProperties.add(newPrp);
                            }
                        }
                    }
                }
                // First remove the removed properties from existing properties
                if (removedProperties.size() > 0) {
                    existingProperties.removeAll(removedProperties);
                }
                // Adds the new properties
                if (newProperties.size() > 0) {
                    newlyAddedProperties.addAll(newProperties);
                }
                // Adds the existing old properties (which didn't get updated)
                // to the new list
                if (existingProperties != null) {
                    newlyAddedProperties.addAll(existingProperties);
                }
                taskFormPage.setTaskPropertyList(newlyAddedProperties);
            } else {
                // When removing all properties from the source view then clear the list
                taskFormPage.setTaskPropertyList(null);
            }
        }
    }

    /**
     * Creates a new property
     * 
     * @param name
     * @return
     */
    private TaskProperty createProperty(String name) {
        TaskProperty newPrp = EsbFactory.eINSTANCE.createTaskProperty();
        newPrp.setPropertyName(name);
        newPrp.setPropertyType(TaskPropertyType.LITERAL);
        newPrp.setPropertyValue(null);
        return newPrp;
    }
}
