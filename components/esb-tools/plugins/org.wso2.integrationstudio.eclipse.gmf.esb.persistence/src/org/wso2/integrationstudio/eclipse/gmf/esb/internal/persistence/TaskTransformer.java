package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.task.TaskDescription;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskPropertyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.ScheduledTaskFormPage;

public class TaskTransformer {

    public void transform(TransformationInfo info, EsbNode subject, int startupCount) throws Exception {
        create((org.wso2.integrationstudio.eclipse.gmf.esb.Task) subject);
    }

    public TaskDescription create(org.wso2.integrationstudio.eclipse.gmf.esb.Task visualTask) {
        org.apache.synapse.task.TaskDescription taskDescription = new TaskDescription();
        if (visualTask.getTaskName() != null) {
            taskDescription.setName(visualTask.getTaskName());
        } else {
            taskDescription.setName("Default");
        }

        taskDescription.setTaskGroup(visualTask.getTaskGroup());
        taskDescription.setTaskImplClassName(visualTask.getTaskImplementation());
        switch (visualTask.getTriggerType()) {
        case SIMPLE:
            taskDescription.setCount((int) visualTask.getCount());
            taskDescription.setInterval(visualTask.getInterval());
            break;

        case CRON:
            taskDescription.setCronExpression(visualTask.getCron());
            break;
        }

        String pinnedServers = visualTask.getPinnedServers();
        if (pinnedServers != null && !pinnedServers.equals("")) {
            pinnedServers = pinnedServers.replace(',', ' ');
            String[] pinnedServer = pinnedServers.split("\\s");
            List<String> servers = Arrays.asList(pinnedServer);
            taskDescription.setPinnedServers(servers);
        }

        if (visualTask.getTaskProperties() != null) {
            for (TaskProperty taskProperty : visualTask.getTaskProperties()) {
                OMElement source = null;
                if (StringUtils.isNotEmpty(taskProperty.getPropertyName())
                        && StringUtils.isNotEmpty(taskProperty.getPropertyValue())) {
                    try {
                        source = AXIOMUtil.stringToOM(
                                "<property xmlns:task=\"" + "http://www.wso2.org/products/wso2commons/tasks\"/>");

                        if (taskProperty.getPropertyType().equals(TaskPropertyType.LITERAL)) {
                            source.addAttribute("name", taskProperty.getPropertyName(), null);
                            source.addAttribute("value", taskProperty.getPropertyValue(), null);
                        } else {
                            source.addAttribute("name", taskProperty.getPropertyName(), null);
                            OMElement child = AXIOMUtil.stringToOM(taskProperty.getPropertyValue().trim());
                            source.addChild(child);
                        }
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                    taskDescription.setXmlProperty(source);
                }
            }
        }

        return taskDescription;
    }

    public TaskDescription createTask(FormPage formTask) throws Exception {
        ScheduledTaskFormPage formTaskPage = null;
        if (formTask instanceof ScheduledTaskFormPage) {
            formTaskPage = (ScheduledTaskFormPage) formTask;
        }
        org.apache.synapse.task.TaskDescription taskDescription = new TaskDescription();
        if (StringUtils.isNotEmpty(formTaskPage.getTaskName().getText())) {
            taskDescription.setName(formTaskPage.getTaskName().getText());
        } else {
            taskDescription.setName("Default");
        }

        taskDescription.setTaskGroup(formTaskPage.getTaskGroup().getText());
        taskDescription.setTaskImplClassName(formTaskPage.getTaskImpl().getText());

        if (formTaskPage.getTriggerType().getSelectionIndex() == 0) {
            if (StringUtils.isNotEmpty(formTaskPage.getCount().getText())) {
                taskDescription.setCount(Integer.parseInt(formTaskPage.getCount().getText()));
                taskDescription.setCronExpression(null);
            }
            if (StringUtils.isNotEmpty(formTaskPage.getInterval().getText())) {
                taskDescription.setInterval(Integer.parseInt(formTaskPage.getInterval().getText()));
                taskDescription.setCronExpression(null);
            }
        } else if (formTaskPage.getTriggerType().getSelectionIndex() == 1) {
            if (StringUtils.isNotEmpty(formTaskPage.getCron().getText())) {
                taskDescription.setCronExpression(formTaskPage.getCron().getText());
                taskDescription.setCount(0);
                taskDescription.setInterval(1);
            }
        }

        String pinnedServers = formTaskPage.getPinnedServers().getText();
        if (StringUtils.isNotEmpty(pinnedServers)) {
            pinnedServers = pinnedServers.replace(',', ' ');
            String[] pinnedServer = pinnedServers.split("\\s");
            List<String> servers = Arrays.asList(pinnedServer);
            taskDescription.setPinnedServers(servers);
        }

        if (formTaskPage.getTaskPropertyList() != null) {
            for (TaskProperty taskProperty : formTaskPage.getTaskPropertyList()) {
                OMElement source = null;
                if (StringUtils.isNotEmpty(taskProperty.getPropertyName())
                        && StringUtils.isNotEmpty(taskProperty.getPropertyValue())) {
                    try {
                        source = AXIOMUtil.stringToOM(
                                "<property xmlns:task=\"" + "http://www.wso2.org/products/wso2commons/tasks\"/>");

                        if (taskProperty.getPropertyType().equals(TaskPropertyType.LITERAL)) {
                            source.addAttribute("name", taskProperty.getPropertyName(), null);
                            source.addAttribute("value", taskProperty.getPropertyValue(), null);
                        } else {
                            source.addAttribute("name", taskProperty.getPropertyName(), null);
                            OMElement child = AXIOMUtil.stringToOM(taskProperty.getPropertyValue().trim());
                            source.addChild(child);
                        }
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                    taskDescription.setXmlProperty(source);
                }
            }
        }

        return taskDescription;
    }
}
