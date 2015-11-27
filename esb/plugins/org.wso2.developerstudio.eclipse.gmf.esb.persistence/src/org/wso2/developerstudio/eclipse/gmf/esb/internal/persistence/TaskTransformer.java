package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.task.TaskDescription;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class TaskTransformer {
	
	public void transform(TransformationInfo info, EsbNode subject,int startupCount)
	throws Exception {
		create((org.wso2.developerstudio.eclipse.gmf.esb.Task)subject);		
	}
	
	public TaskDescription create(
			org.wso2.developerstudio.eclipse.gmf.esb.Task visualTask) {
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
		
		String pinnedServers=visualTask.getPinnedServers();
		if(pinnedServers!=null && !pinnedServers.equals("")){
			pinnedServers=pinnedServers.replace(',', ' ');
			String [] pinnedServer=pinnedServers.split("\\s");
			List<String> servers = Arrays.asList(pinnedServer); 
			taskDescription.setPinnedServers(servers);
		}

		if (visualTask.getTaskProperties() != null) {
			for (TaskProperty taskProperty : visualTask.getTaskProperties()) {
				OMElement source = null;
				if (StringUtils.isNotEmpty(taskProperty.getPropertyName()) &&
				    StringUtils.isNotEmpty(taskProperty.getPropertyValue())) {
					try {
						source =
						         AXIOMUtil.stringToOM("<property xmlns:task=\""
						                              + "http://www.wso2.org/products/wso2commons/tasks\"/>");

						if (taskProperty.getPropertyType().equals(TaskPropertyType.LITERAL)) {
							source.addAttribute("name", taskProperty.getPropertyName(), null);
							source.addAttribute("value", taskProperty.getPropertyValue(), null);
						} else {
							source.addAttribute("name", taskProperty.getPropertyName(), null);
							OMElement child =
							                  AXIOMUtil.stringToOM(taskProperty.getPropertyValue()
							                                                   .trim());
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
