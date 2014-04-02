/*
o * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.qos.project.ui.wizard;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.wsdl.Definition;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.maven.project.MavenProject;
import org.apache.woden.wsdl20.Description;
import org.apache.woden.wsdl20.InterfaceOperation;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.libraries.utils.WSDLUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.qos.project.controller.QoSProjectTypeList;
import org.wso2.developerstudio.eclipse.qos.project.model.Binding;
import org.wso2.developerstudio.eclipse.qos.project.model.Bindings;
import org.wso2.developerstudio.eclipse.qos.project.model.Module;
import org.wso2.developerstudio.eclipse.qos.project.model.Operation;
import org.wso2.developerstudio.eclipse.qos.project.model.Parameter;
import org.wso2.developerstudio.eclipse.qos.project.model.QOSProjectModel;
import org.wso2.developerstudio.eclipse.qos.project.model.Service;
import org.wso2.developerstudio.eclipse.qos.project.model.ServiceGroup;
import org.wso2.developerstudio.eclipse.qos.project.ui.dashboard.QoSDashboardPage;
import org.wso2.developerstudio.eclipse.qos.project.utils.QOSImageUtils;
import org.wso2.developerstudio.eclipse.qos.project.utils.WSDL2Utils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class QOSProjectWizard extends AbstractWSO2ProjectCreationWizard {

	private static final String ESB_PROJECT = "ESB";
	private static final String DS_PROJECT = "DS";
	private static final String AXIS_PROJECT = "Axis";

	static final String QOS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.qos.project.nature";
	static final String INTRO_VIEW_ID = "org.eclipse.ui.internal.introview";
	static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.qos.QoSDashboard";
	static final String J2EE_PERSPECTIVE_ID = "org.eclipse.jst.j2ee.J2EEPerspective";
	
	private static final String AXIS2_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.axis2.project.nature";
	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
	private static final String ESB_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.esb.project.nature";
	private static final String ADDRESSING_VERSION = "4.2.0";
	
	private IProject project;
	private QOSProjectModel qosProjectModel;
	private File pomfile;
	private File meta;
	private String serviceName;
	// private Service service;
	private ServiceGroup serviceGroup;
	public static String metaFileName;
	private String projectType;

	@Override
	public void init(IWorkbench arg0, IStructuredSelection selection) {
		try {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IResource) {
				selectedProject = ((IResource) element).getProject();
				IProjectDescription description = selectedProject.getDescription();
				String[] natureIds = description.getNatureIds();

				for (String natueId : natureIds) {
					if (AXIS2_PROJECT_NATURE.equals(natueId)) {
						setProjectType(AXIS_PROJECT);
						List<String> services = new ArrayList<String>();
						services.add(selectedProject.getName());
						QoSProjectTypeList.setServiceNames(services);
						break;
					} else if (DS_PROJECT_NATURE.equals(natueId)) {
						setProjectType(DS_PROJECT);
						List<String> services = new ArrayList<String>();
						services.add(selectedProject.getName());
						QoSProjectTypeList.setServiceNames(services);
						break;
					} else if (ESB_PROJECT_NATURE.equals(natueId)) {
						setProjectType(ESB_PROJECT);
						File fXmlFile = selectedProject.getFile("artifact.xml").getLocation()
								.toFile();
						List<String> services = new ArrayList<String>();
						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
						Document doc = dBuilder.parse(fXmlFile);
						doc.getDocumentElement().normalize();
						Node artifacts = doc.getFirstChild();
						NodeList childNodes = artifacts.getChildNodes();
						for (int i = 0; i < childNodes.getLength(); i++) {
							Node tempNode = childNodes.item(i);
							if (tempNode instanceof Element) {
								Element eElement = (Element) tempNode;
								String type = eElement.getAttribute("type");
								if ("synapse/proxy-service".equals(type)) {
									String name = eElement.getAttribute("name");
									services.add(name);
								}
							}
						}
						QoSProjectTypeList.setServiceNames(services);
						break;
					}
				}

			}
		} catch (Exception e) {
			/* ignored */
		}
		super.init(arg0, selection);

	}

	public QOSProjectWizard() {
		setQosProjectModel(new QOSProjectModel());
		setModel(qosProjectModel);
		setDefaultPageImageDescriptor(QOSImageUtils.getInstance().getImageDescriptor("secured.gif"));
	}

	@Override
	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof ProjectOptionsDataPage)
			return false;
		else
			return super.canFinish();
	}

	@Override
	protected boolean isRequiredWorkspaceLocation() {
		return true;
	}

	@Override
	protected boolean isCustomPageRequired() {
		return true;
	}

	@Override
	protected WizardPage getCustomPage() {
		SelectWSDLPage axis2SelectWSDLPage = new SelectWSDLPage("WSDL selector",
				getQosProjectModel());
		return axis2SelectWSDLPage;
	}

	public boolean performFinish() {
		try {
			String wsdlURI = qosProjectModel.getWsdlURI();
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(Display
					.getDefault().getActiveShell());
			progressMonitorDialog.create();
			progressMonitorDialog.open();
			progressMonitorDialog.run(true, false, new WSDLReadingJob(wsdlURI, projectType));

			while (true) {
				if (isJobfinish()) {
					hideIntroView();
					hideDashboards();
					IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					IWorkbenchPage page = window.getActivePage();
					PlatformUI.getWorkbench().showPerspective(J2EE_PERSPECTIVE_ID, window);
					IEditorPart openEditor = page.openEditor(new NullEditorInput(),
							DASHBOARD_VIEW_ID);
					break;
				}
			}

		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error while creating the project", e.getMessage());
			return false;
		}
		return true;
	}

	public QOSProjectModel getQosProjectModel() {
		return qosProjectModel;
	}

	public void setQosProjectModel(QOSProjectModel qosProjectModel) {
		this.qosProjectModel = qosProjectModel;
	}

	public IResource getCreatedResource() {
		return project;
	}

	public void setCurrentSelection(ISelection currentSelection) {
		super.setCurrentSelection(currentSelection);
	}

	public String getMetaFileName() {
		return metaFileName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public void setMetaFileName(String metaFileName) {
		QOSProjectWizard.metaFileName = metaFileName;
	}

	public boolean isJobfinish() {
		return jobfinish;
	}

	public void setJobfinish(boolean jobfinish) {
		this.jobfinish = jobfinish;
	}

	private boolean jobfinish;
	private IProject selectedProject;

	private Service createService(QName fname, List<String> operations) {

		String name = fname.getLocalPart();
		Service service = new Service();
		service.setName(name);
		service.setServiceDocumentation(name);
		service.setExposedAllTransports(false);
		long time = new Date().getTime();
		service.setServiceDeployedTime(BigInteger.valueOf(time));
		service.setSuccessfullyAdded(true);
		service.setServiceActive(true);
		Bindings bindings = new Bindings();

		String serviceHttpBinding = name + "HttpBinding";
		String serviceSoap11Binding = name + "Soap11Binding";
		String serviceSoap12Binding = name + "Soap12Binding";		
		if(getProjectType().equals(DS_PROJECT)) {
			//Data Service Server bindings use 'SOAP' for SOAP binding
			serviceSoap11Binding = name + "SOAP11Binding";
			serviceSoap12Binding = name + "SOAP12Binding";
		} 
		
		Binding hHttpBinding = new Binding();
		hHttpBinding.setName(serviceHttpBinding);
		Binding sSoap12Binding = new Binding();
		sSoap12Binding.setName(serviceSoap12Binding);
		Binding sSoap11Binding = new Binding();
		sSoap11Binding.setName(serviceSoap11Binding);

		Parameter parameter = new Parameter();
		createParam(parameter);

		/*
		 * No need to define version number for modules. Module persistence
		 * manager will take care the version and it will use one of the
		 * available versions of the same module of the server
		 */
		Module pPOXSecurityModule = new Module();
		pPOXSecurityModule.setName("POXSecurityModule");
		//pPOXSecurityModule.setVersion("4.2.2");
		pPOXSecurityModule.setType("engagedModules");

		Module addressing = new Module();
		addressing.setName("addressing");
		addressing.setVersion(ADDRESSING_VERSION);
		addressing.setType("engagedModules");

		Module serverAdminModule = new Module();
		serverAdminModule.setName("ServerAdminModule");
		//serverAdminModule.setVersion("4.2.0");
		serverAdminModule.setType("engagedModules");

		Module pagination = new Module();
		pagination.setName("pagination");
		//pagination.setVersion("4.2.0");
		pagination.setType("engagedModules");

		Module wso2statistics = new Module();
		wso2statistics.setName("wso2statistics");
		//wso2statistics.setVersion("4.2.2");
		wso2statistics.setType("engagedModules");

		Module activation = new Module();
		activation.setName("activation");
		//activation.setVersion("2.2.0");
		activation.setType("engagedModules");

		/* 
		 * Globally engaged modules are not added to the policy.
		 * POXSecurityModule, ServerAdminModule, pagination, wso2statistics
		 */
		/* service.getModuleOrParameterOrPolicyUUID().add(pPOXSecurityModule);
		service.getModuleOrParameterOrPolicyUUID().add(serverAdminModule);
		service.getModuleOrParameterOrPolicyUUID().add(pagination);
		service.getModuleOrParameterOrPolicyUUID().add(wso2statistics);
		service.getModuleOrParameterOrPolicyUUID().add(activation); */
		
		service.getModuleOrParameterOrPolicyUUID().add(addressing);

		service.getModuleOrParameterOrPolicyUUID().add(parameter);
		for (String opName : operations) {
			Operation operation = new Operation();
			operation.setName(opName);
			operation.getModule().add(addressing);
			/* operation.getModule().add(pPOXSecurityModule);			
			operation.getModule().add(serverAdminModule);
			operation.getModule().add(pagination);
			operation.getModule().add(wso2statistics);
			operation.getModule().add(activation); */
			service.getOperation().add(operation);
			Operation operation2 = new Operation();
			operation2.setName(opName);
			hHttpBinding.getOperation().add(operation2);
			sSoap12Binding.getOperation().add(operation2);
			sSoap11Binding.getOperation().add(operation2);

		}
		
		bindings.getBinding().add(hHttpBinding);
		bindings.getBinding().add(sSoap11Binding);
		bindings.getBinding().add(sSoap12Binding);
		service.setBindings(bindings);

		return service;
	}

	private void createParam(Parameter parameter) {
		try {
			if (getProjectType().equals(AXIS_PROJECT)) {

				parameter.setName("ServiceClass");
				parameter.setLocked(false);
				File fXmlFile = selectedProject
						.getFile("/src/main/resources/META-INF/services.xml").getLocation()
						.toFile();
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				String nodeName = doc.getDocumentElement().getNodeName();
				Node firstChild = doc.getFirstChild();
				if ("service".equals(nodeName)) {
					Element eElement = (Element) firstChild;
					parameter.setValue(eElement.getElementsByTagName("parameter").item(0)
							.getTextContent());

				} else if ("serviceGroup".equals(nodeName)) {
					NodeList childNodes = firstChild.getChildNodes();
					for (int i = 0; i < childNodes.getLength(); i++) {
						Node tempNode = childNodes.item(i);
						if (tempNode instanceof Element) {
							Element eElement = (Element) tempNode;
							parameter.setValue(eElement.getElementsByTagName("parameter").item(0)
									.getTextContent());
						}
					}
				}

			} else if (getProjectType().equals(DS_PROJECT)) {
				parameter.setName("serviceType");
				parameter.setValue("data_service");
			} else if (getProjectType().equals(ESB_PROJECT)) {
				parameter.setName("serviceType");
				parameter.setType(new BigInteger("1"));
				parameter.setValue("proxy");
			}

		} catch (Exception e) {
			/* ignored */
		}
	}

	private void hideIntroView() {
		try {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IViewReference ref = page.findViewReference(INTRO_VIEW_ID);
			page.hideView(ref);
		} catch (Exception e) {
			/* safe to ignore */
		}
	}

	/**
	 * hide open dashboards
	 */
	private void hideDashboards() {
		try {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			List<IEditorReference> openEditors = new ArrayList<IEditorReference>();
			IEditorReference[] editorReferences = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for (IEditorReference iEditorReference : editorReferences) {
				if (DASHBOARD_VIEW_ID.equals(iEditorReference.getId())) {
					openEditors.add(iEditorReference);
				}
			}
			if (openEditors.size() > 0) {
				page.closeEditors(openEditors.toArray(new IEditorReference[] {}), false);
			}
		} catch (Exception e) {
			/* safe to ignore */
		}
	}

	private class WSDLReadingJob implements IRunnableWithProgress {

		String wsdlURI;
		String projectNature;

		public WSDLReadingJob(String wsdlURI, String projectNature) {
			this.wsdlURI = wsdlURI;
			this.projectNature = projectNature;
		}

		@Override
		public void run(IProgressMonitor monitor) {
			String operationText = "";
			monitor.beginTask(operationText, 100);
			try {
				operationText = "Parsing the WSDL...";
				monitor.subTask(operationText);
				monitor.worked(20);

				project = createNewProject();
				pomfile = project.getFile("pom.xml").getLocation().toFile();

				MavenInfo mavenInfo = getModel().getMavenInfo();
				mavenInfo.setPackageName("service/meta");
				if (!pomfile.exists()) {
					createPOM(pomfile);
				}

				getModel().addToWorkingSet(project);

				serviceGroup = new ServiceGroup();
				//serviceGroup.setName(project.getName());
				serviceGroup.setSuccessfullyAdded(true);
				QName fname = null;
				List<String> operations = new ArrayList<String>();
				int wsdlVersion = WSDL2Utils.getWSDLVersion(wsdlURI);
				if (wsdlVersion == 20) {
					Description description = WSDL2Utils.getDescription(wsdlURI);
					fname = WSDL2Utils.getName(description);
					List<InterfaceOperation> ioperations = WSDL2Utils.getOperations(description);

					for (InterfaceOperation interfaceOperation : ioperations) {
						operations.add(interfaceOperation.getName().getLocalPart());
					}

				} else {
					Definition definition = WSDLUtils.readWSDL(wsdlURI);
					List<QName> serviceList = WSDLUtils.getServiceList(definition);
					for (QName qName : serviceList) {
						fname = qName;
						break;
					}
					operations = WSDLUtils.getOperationNameList(definition, fname);
				}

				Service sService = createService(fname, operations);
				serviceGroup.getService().add(sService);
				
				if(ESB_PROJECT.equals(projectNature)) {
					//ESB configuration project.
					serviceGroup.setName(sService.getName());
					metaFileName = sService.getName() + ".xml";
				} else if(AXIS_PROJECT.equals(projectNature)){
					//Axis2 project.
					File pomFile = selectedProject.getFile("pom.xml").getLocation().toFile();
					MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
					//Service group name of the axis2 project: 'projectName-projectVersion' (.aar file name).
					String serviceGroupName = selectedProject.getName() + "-" + mavenProject.getVersion();
					serviceGroup.setName(serviceGroupName);
					metaFileName = serviceGroupName + ".xml";
				} else if(DS_PROJECT.equals(projectNature)){
					//Data service project.
					serviceGroup.setName(sService.getName());
					metaFileName = sService.getName() + ".xml";
				} else {
					
				}

				meta = project.getFile("src/main/resources/" + metaFileName).getLocation().toFile();
				ProjectUtils.addNatureToProject(project, false, QOS_PROJECT_NATURE);
				MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
						new String[] { QOS_PROJECT_NATURE });
				meta.createNewFile();
				QoSDashboardPage.metaProject = project;
				QoSDashboardPage.metaFileName = metaFileName;
				QoSDashboardPage.serviceName = sService.getName();
				JAXBContext jaxbContext = JAXBContext.newInstance(ServiceGroup.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(serviceGroup, meta);
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				monitor.subTask(operationText);
				monitor.worked(80);

			} catch (Exception e) {
				e.printStackTrace();
				/* ignored */
			}
			setJobfinish(true);
			monitor.worked(100);
			monitor.done();
		}
	}

	class NullEditorInput implements IEditorInput {

		public boolean exists() {
			return true;
		}

		public ImageDescriptor getImageDescriptor() {
			return ImageDescriptor.getMissingImageDescriptor();
		}

		public String getName() {
			return "Dashboard";
		}

		public IPersistableElement getPersistable() {
			return null;
		}

		public String getToolTipText() {
			return "Developer Studio QoS Editor";
		}

		public Object getAdapter(Class adapter) {
			return null;
		}
	}
}
