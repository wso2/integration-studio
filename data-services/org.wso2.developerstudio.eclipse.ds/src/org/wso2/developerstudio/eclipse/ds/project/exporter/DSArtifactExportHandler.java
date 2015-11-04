package org.wso2.developerstudio.eclipse.ds.project.exporter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Dependency;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.export.DefaultArtifactExportHandler;
import org.wso2.developerstudio.eclipse.distribution.project.model.ArtifactData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class DSArtifactExportHandler extends DefaultArtifactExportHandler{
	
	DistProjectUtils distProjectUtils = new DistProjectUtils();

	@Override
	public void exportArtifact(List<ArtifactData> artifactList,
			Map<IProject, Map<String, IResource>> graphicalSynapseProjectList,
			IFolder splitESBResources, DependencyData dependencyData,
			Object parent, Object self) throws Exception {
		if (parent instanceof IProject && self instanceof String) {

			IFile file = ((IProject) parent).getFile((String) self);
		      
			if (file.exists()) {
				File synapseConf = file.getLocation().toFile();
				if (SynapseFileUtils.isSynapseConfGiven(synapseConf,
						SynapseEntryType.ALL)) {
					seperateSynapseConfig(synapseConf, splitESBResources,
							dependencyData, artifactList);
				} else if (dependencyData.getDependency().getType()
						.equals("synapse/graphical-configuration")) {
					IProject resProject = (IProject) parent;
					if (!graphicalSynapseProjectList.containsKey(resProject)) {
						Map<String, IResource> artifacts = new HashMap<String, IResource>();
						List<IResource> buildProject = ExportUtil.buildProject(
								resProject, dependencyData.getCApptype());
						for (IResource res : buildProject) {
							if (res instanceof IFile) {
								IFile synapseFile = resProject.getFile("target"
										+ File.separator + res.getName());
								seperateSynapseConfig(synapseFile.getLocation()
										.toFile(), splitESBResources, dependencyData,
										artifactList);
								artifacts.put(res.getName(), res);
							}
						}
						graphicalSynapseProjectList.put(resProject, artifacts);
					}

				} else {
					ArtifactData artifactData = new ArtifactData();
					artifactData.setDependencyData(dependencyData);
					artifactData.setFile(distProjectUtils.getFileName(dependencyData));
					artifactData.setResource((IResource) file);
					artifactList.add(artifactData);
				}
			}
		}
	}
	
	private void seperateSynapseConfig(File synapseConf,IFolder splitESBResources,DependencyData dependencyData,List<ArtifactData> artifactList) throws Exception{
		List<OMElement> synapseArtifacts = SynapseFileUtils
				.synapseFileProcessing(synapseConf.getPath(),
						SynapseEntryType.ALL);
		for (OMElement element : synapseArtifacts) {
			String localName = element.getLocalName();
			String qualifiedName = element.getAttributeValue(new QName("name"));
			if ((qualifiedName == null) || ("".equals(qualifiedName))) {
				qualifiedName = element.getAttributeValue(new QName("key"));
				if ((qualifiedName == null) || ("".equals(qualifiedName))) {
					/*log.warn("ignoring unrecognized configuration element"
							+ element.toString());*/
					continue;
				}
			}
			File artifact = new File(splitESBResources.getLocation().toFile(),
					qualifiedName + ".xml");
			if (!artifact.exists()) {
				FileUtils.createFile(artifact, element.toString());
			} else {
				/*log.warn("artifact already exists. ignoring... "
						+ element.toString());*/
				continue;
			}
			Dependency dummyDependency = new Dependency();
			dummyDependency.setArtifactId(dependencyData.getDependency()
					.getGroupId());
			dummyDependency.setVersion(dependencyData.getDependency()
					.getVersion());
			dummyDependency.setArtifactId(qualifiedName);

			DependencyData dummyDependencyData = new DependencyData();
			dummyDependencyData.setServerRole(dependencyData.getServerRole());

			if (localName.equalsIgnoreCase("sequence")) {
				dummyDependency.setType("synapse/sequence");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/sequence");
			} else if (localName.equalsIgnoreCase("endpoint")) {
				dummyDependency.setType("synapse/endpoint");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/endpoint");
			} else if (localName.equalsIgnoreCase("proxy")) {
				dummyDependency.setType("synapse/proxy-service");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/proxy-service");
			} else if (localName.equalsIgnoreCase("localEntry")) {
				dummyDependency.setType("synapse/local-entry");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/local-entry");
			} else if (localName.equalsIgnoreCase("task")) {
				dummyDependency.setType("synapse/task");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/task");
			} else if (localName.equalsIgnoreCase("api")) {
				dummyDependency.setType("synapse/api");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/api");
			} else if (localName.equalsIgnoreCase("template")) {
				dummyDependency.setType("synapse/template");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/template");
			} else if (localName.equalsIgnoreCase("priorityExecutor")) {
				dummyDependency.setType("synapse/priority-executor");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/priority-executor");
			} else if (localName.equalsIgnoreCase("messageStore")) {
				dummyDependency.setType("synapse/message-store");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/message-store");
			} else if (localName.equalsIgnoreCase("messageProcessor")) {
				dummyDependency.setType("synapse/message-processors");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/message-processors");
			} else if (localName.equalsIgnoreCase("eventSource")) {
				dummyDependency.setType("synapse/event-source");
				dummyDependencyData.setDependency(dummyDependency);
				dummyDependencyData.setCApptype("synapse/event-source");
			} else {
				/*log.warn("ignoring unrecognized configuration element"
						+ element.toString());*/
				continue;
			}
			ArtifactData artifactData = new ArtifactData();
			artifactData.setDependencyData(dummyDependencyData);
			artifactData.setFile(distProjectUtils.getFileName(dummyDependencyData));
			artifactData.setResource((IResource) splitESBResources
					.getFile(artifact.getName()));
			artifactList.add(artifactData);
		}
	}

}
