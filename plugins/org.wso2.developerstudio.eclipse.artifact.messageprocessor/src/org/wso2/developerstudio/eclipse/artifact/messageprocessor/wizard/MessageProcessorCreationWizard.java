/*
 * Copyright (c) 2012-2015 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messageprocessor.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.MessageProcessorSerializer;
import org.apache.synapse.message.processor.MessageProcessor;
import org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor;
import org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor;
import org.apache.synapse.message.processor.impl.sampler.SamplingProcessor;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.Activator;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.model.MessageProcessorModel;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.util.MessageProcessorImageUtils;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
//import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MessageProcessorCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Message Processor Artifact";
	private MessageProcessorModel messageProcessorModel;
	private ESBProjectArtifact esbProjectArtifact;
	private IProject esbProject;
	private IFile artifactFile;
	private List<File> fileLst = new ArrayList<File>();

	private String version = "1.0.0";

	public MessageProcessorCreationWizard() {
		messageProcessorModel = new MessageProcessorModel();
		setModel(messageProcessorModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(MessageProcessorImageUtils.getInstance().getImageDescriptor("message-processor.png"));
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}

	@Override
	public boolean performFinish() {
		try {
			boolean isNewArtifact = true;
			esbProject = messageProcessorModel.getSaveLocation().getProject();
			IContainer location = esbProject
					.getFolder("src/main/synapse-config/message-processors");
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if (!pomfile.exists()) {
				createPOM(pomfile);
			}
			esbProjectArtifact = new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
			updatePom();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			String groupId = getMavenGroupId(pomfile) + ".message-processors";
			if (getModel().getSelectedOption().equals("create.processor")) {
				artifactFile = location.getFile(new Path(messageProcessorModel
						.getMessageProcessorName() + ".xml"));
				File destFile = artifactFile.getLocation().toFile();
				FileUtils.createFile(destFile, getTemplateContent());
				fileLst.add(destFile);
				String relativePath = FileUtils.getRelativePath(
						esbProject.getLocation().toFile(),
						new File(location.getLocation().toFile(), messageProcessorModel
								.getMessageProcessorName() + ".xml")).replaceAll(
										Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifact(
						messageProcessorModel.getMessageProcessorName(), groupId, version,
						relativePath));
				esbProjectArtifact.toFile();
			} else {
				IFile task = location.getFile(new Path(getModel().getImportFile().getName()));
				if (task.exists()) {
					if (!MessageDialog.openQuestion(getShell(), "WARNING",
							"Do you like to override exsiting project in the workspace")) {
						return false;
					}
					isNewArtifact = false;
				}
				copyImportFile(location, isNewArtifact, groupId);

			}
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			for (File file : fileLst) {
				if (file.exists()) {
					openEditor(file);
				}
			}

		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}

	@Override
	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	@Override
	protected boolean isRequiredWorkingSet() {
		return false;
	}

	private ESBArtifact createArtifact(String name, String groupId, String version, String path) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType("synapse/message-processors");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		version = mavenProject.getVersion();

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-messageprocessor-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven",
				"wso2-esb-messageprocessor-plugin", ESBMavenConstants.WSO2_ESB_MESSAGE_PROCESSOR_PLUGIN_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("task");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	private String getTemplateContent() {

		Map<String, Object> messageProcessorPrameeters = null;
		String className = "";
		OMElement messageProcessorElement;
		MessageProcessor messageProcessor = new ScheduledMessageForwardingProcessor();
		String lineSeparator = System.getProperty("line.separator", "\n");

		if (messageProcessorModel.getMessageProcessorType().equals(
				"Scheduled Message Forwarding Processor")) {
			messageProcessorPrameeters = new HashMap<String, Object>();

			// Fixing TOOLS-2026.
			// className =
			// "org.apache.synapse.message.processors.forward.ScheduledMessageForwardingProcessor";
			className = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";

			messageProcessorPrameeters.put("interval",
					((Integer) messageProcessorModel.getForwardingInterval())
							.toString());

			if (StringUtils
					.isNotBlank(messageProcessorModel.getRetryInterval())) {
				messageProcessorPrameeters.put("client.retry.interval",
						messageProcessorModel.getRetryInterval());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getDeliveryAttempts())) {
				messageProcessorPrameeters.put("max.delivery.attempts",
						messageProcessorModel.getDeliveryAttempts());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getClientRepository())) {
				messageProcessorPrameeters.put("axis2.repo",
						messageProcessorModel.getClientRepository());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getAxis2Configuration())) {
				messageProcessorPrameeters.put("axis2.config",
						messageProcessorModel.getAxis2Configuration());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getReplySequenceName())) {
				messageProcessorPrameeters.put(
						"message.processor.reply.sequence",
						messageProcessorModel.getReplySequenceName());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getFaultSequenceName())) {
				messageProcessorPrameeters.put(
						"message.processor.fault.sequence",
						messageProcessorModel.getFaultSequenceName());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getDeactivateSequenceName())) {
				messageProcessorPrameeters.put(
						"message.processor.deactivate.sequence",
						messageProcessorModel.getDeactivateSequenceName());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getConfigurationFilePath())) {
				messageProcessorPrameeters.put("quartz.conf",
						messageProcessorModel.getConfigurationFilePath());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getCronExpression())) {
				messageProcessorPrameeters.put("cronExpression",
						messageProcessorModel.getCronExpression());
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getProcessorState())) {
				if (messageProcessorModel.getProcessorState()
						.equals("Activate")) {
					Boolean isActive = true;
					messageProcessorPrameeters.put("is.active",
							isActive.toString());
				} else {
					Boolean isActive = false;
					messageProcessorPrameeters.put("is.active",
							isActive.toString());
				}
			}
			if (StringUtils.isNotBlank(messageProcessorModel
					.getNonRetryHttpStatusCodes())) {
				messageProcessorPrameeters.put("non.retry.status.codes",
						messageProcessorModel.getNonRetryHttpStatusCodes());
			}

			if (StringUtils.isNotBlank(messageProcessorModel
					.getDropMessageAfterMaxDeliveryAttempts())) {
				messageProcessorPrameeters.put("max.delivery.drop",
						messageProcessorModel
								.getDropMessageAfterMaxDeliveryAttempts());
			}

			if (StringUtils.isNotBlank(messageProcessorModel.getTaskCount())) {
				messageProcessorPrameeters.put("member.count",
						messageProcessorModel.getTaskCount());
			}

			messageProcessor = new ScheduledMessageForwardingProcessor();

			messageProcessor.setTargetEndpoint(messageProcessorModel
					.getEndpointName());
			messageProcessor.setName(messageProcessorModel
					.getMessageProcessorName());
			messageProcessor.setMessageStoreName(messageProcessorModel
					.getMessageStore());
			messageProcessor.setParameters(messageProcessorPrameeters);

		} else if (messageProcessorModel.getMessageProcessorType().equals(
				"Message Sampling Processor")) {
			messageProcessorPrameeters = new HashMap<String, Object>();
			
			// Fixing TOOLS-2026.
			//className = "org.apache.synapse.message.processors.sampler.SamplingProcessor";
			className = "org.apache.synapse.message.processor.impl.sampler.SamplingProcessor";

			messageProcessorPrameeters.put("interval",
					((Integer) messageProcessorModel.getSamplingInterval()).toString());
			messageProcessorPrameeters.put("concurrency",
					((Integer) messageProcessorModel.getSamplingConcurrency()).toString());

			if (StringUtils.isNotBlank(messageProcessorModel.getConfigurationFilePath())) {
				messageProcessorPrameeters.put("quartz.conf",
						messageProcessorModel.getConfigurationFilePath());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getCronExpression())) {
				messageProcessorPrameeters.put("cronExpression",
						messageProcessorModel.getCronExpression());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getSequence())) {
				messageProcessorPrameeters.put("sequence", messageProcessorModel.getSequence());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getProcessorState())) {
				if (messageProcessorModel.getProcessorState().equals("Activate")) {
					Boolean isActive = true;
					messageProcessorPrameeters.put("is.active", isActive.toString());
				} else {
					Boolean isActive = false;
					messageProcessorPrameeters.put("is.active", isActive.toString());
				}
			}

			messageProcessor = new SamplingProcessor();

			messageProcessor.setName(messageProcessorModel.getMessageProcessorName());
			messageProcessor.setMessageStoreName(messageProcessorModel.getMessageStore());
			messageProcessor.setParameters(messageProcessorPrameeters);

		} else if (messageProcessorModel.getMessageProcessorType().equals(
				"Custom Message Processor")) {
			messageProcessorPrameeters = new HashMap<String, Object>();
			messageProcessor = new SamplingProcessor();
			className = messageProcessorModel.getClassFQN();

			messageProcessor.setName(messageProcessorModel.getMessageProcessorName());
			messageProcessor.setMessageStoreName(messageProcessorModel.getMessageStore());
			messageProcessor.setParameters(messageProcessorPrameeters);

			HashMap<String, String> parameters = messageProcessorModel
					.getCustomProcessorParameters();

			if (parameters.size() > 0) {
				Set<Entry<String, String>> parameterEntrySet = parameters.entrySet();
				Iterator<Entry<String, String>> it = parameterEntrySet.iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					if (StringUtils.isNotBlank(entry.getKey())) {
						messageProcessorPrameeters.put(entry.getKey(), entry.getValue());
					}
				}
			}
		} else if (messageProcessorModel.getMessageProcessorType().equals(
				"Scheduled Failover Message Forwarding Processor")) {
			messageProcessorPrameeters = new HashMap<String, Object>();
			className = "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor";

			messageProcessorPrameeters.put("interval",
					((Integer) messageProcessorModel.getForwardingInterval()).toString());

			if (StringUtils.isNotBlank(messageProcessorModel.getRetryInterval())) {
				messageProcessorPrameeters.put("client.retry.interval",
						messageProcessorModel.getRetryInterval());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getDeliveryAttempts())) {
				messageProcessorPrameeters.put("max.delivery.attempts",
						messageProcessorModel.getDeliveryAttempts());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getFaultSequenceName())) {
				messageProcessorPrameeters.put("message.processor.fault.sequence",
						messageProcessorModel.getFaultSequenceName());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getDeactivateSequenceName())) {
				messageProcessorPrameeters.put("message.processor.deactivate.sequence",
						messageProcessorModel.getDeactivateSequenceName());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getConfigurationFilePath())) {
				messageProcessorPrameeters.put("quartz.conf",
						messageProcessorModel.getConfigurationFilePath());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getCronExpression())) {
				messageProcessorPrameeters.put("cronExpression",
						messageProcessorModel.getCronExpression());
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getProcessorState())) {
				if (messageProcessorModel.getProcessorState().equals("Activate")) {
					Boolean isActive = true;
					messageProcessorPrameeters.put("is.active", isActive.toString());
				} else {
					Boolean isActive = false;
					messageProcessorPrameeters.put("is.active", isActive.toString());
				}
			}
			if (StringUtils.isNotBlank(messageProcessorModel.getDropMessageAfterMaxDeliveryAttempts())) {
				messageProcessorPrameeters.put("max.delivery.drop",
						messageProcessorModel.getDropMessageAfterMaxDeliveryAttempts());
			}
			
			if (StringUtils.isNotBlank(messageProcessorModel.getTaskCount())) {
				messageProcessorPrameeters.put("member.count",
						messageProcessorModel.getTaskCount());
			}
			
			if (StringUtils.isNotBlank(messageProcessorModel.getTargetMessageStore())) {
				messageProcessorPrameeters.put("message.target.store.name",
						messageProcessorModel.getTargetMessageStore());
			}

			messageProcessor = new FailoverScheduledMessageForwardingProcessor();

			messageProcessor.setName(messageProcessorModel.getMessageProcessorName());
			messageProcessor.setMessageStoreName(messageProcessorModel.getSourceMessageStore());
			messageProcessor.setParameters(messageProcessorPrameeters);

		} 

		messageProcessorElement = MessageProcessorSerializer.serializeMessageProcessor(null,
				messageProcessor);
		OMAttribute classAttr = messageProcessorElement.getAttribute(new QName("class"));

		if (messageProcessorModel.getMessageProcessorType().equals("Custom Message Processor")
				&& classAttr != null) {
			classAttr.setAttributeValue(className);
		} else {
			messageProcessorElement.addAttribute("class", className, null);
		}
		return messageProcessorElement.toString().replace("><", ">" + lineSeparator + "<");
	}

	public void copyImportFile(IContainer importLocation, boolean isNewAritfact, String groupId)
			throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedList = ((MessageProcessorModel) getModel())
				.getSelectedProcessorList();
		if (selectedList != null && selectedList.size() > 0) {
			for (OMElement element : selectedList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
				if (isNewAritfact) {
					String relativePath = FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
							new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
							Pattern.quote(File.separator), "/");
					esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version,
							relativePath));
				}
			}

		} else {
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$", "");
			if (isNewAritfact) {
				String relativePath = FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
						new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
						Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version,
						relativePath));
			}
		}
		try {
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	@Override
	public void openEditor(File file) {
		try {
			refreshDistProjects();
			IFile resource = ResourcesPlugin.getWorkspace().getRoot()
					.getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
			String path = resource.getParent().getFullPath() + "/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			openable.editorOpen(file.getName(), ArtifactType.MESSAGE_PROCESSOR.getLiteral(), path,
					source);
		} catch (Exception e) {
			log.error("Cannot open the editor", e);
		}
	}
}
