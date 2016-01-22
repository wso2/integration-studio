package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ParametersUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public class Axis2ClassWizard  extends Wizard implements INewWizard{

	IWorkbench workbench;
	IStructuredSelection selection;
	Axis2ClassWizardPage axisClassWizardPage;
	IProject activeProject;
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Axis2 Class";
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
        setDefaultPageImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor(
                Axis2ParametersUtils.AXIS2_WIZARD_IMAGE));
	}
	
	public void addPages() {
		axisClassWizardPage = new Axis2ClassWizardPage(workbench, selection);
		addPage(axisClassWizardPage);
		axisClassWizardPage.init(selection);
//		axisClassWizardPage.setImageDescriptor(Activator.getImageDescriptor("icons/axis2-wizard.png"));
	}
	
	public boolean performFinish() {
		try {
			axisClassWizardPage.createType(new NullProgressMonitor());
			IType classSource = axisClassWizardPage.getCreatedType();
			String fullName = classSource.getFullyQualifiedName();
			activeProject = classSource.getJavaProject().getProject();
		    File serviceXml  =activeProject.getFile("src/main/resources/META-INF/services.xml").getLocation().toFile();
			
		    if(!serviceXml.exists()){
				FileUtils.createFile(serviceXml, "");
				OMElement oMgroup = this.addServiceGroup(activeProject.getName());
			    this.writeToXml(oMgroup, serviceXml); 
			}
			this.addNewService(serviceXml, fullName, fullName);
			activeProject.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
 
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void addNewService(File serviceXml, String serviceName,String className) throws XMLStreamException, IOException{
		OMElement doc = this.readServiceXml(serviceXml);
		if(!"service".equals(doc.getFirstElement().getQName().toString())){
			OMElement oMserviceGroup = addServiceGroup(activeProject.getName());
			oMserviceGroup.addChild(doc);
			doc = oMserviceGroup;
		}
		String[] names = serviceName.split("\\.");
		if(names.length>0){
			serviceName = names[names.length-1];
		}
		
		OMElement oMnewService = this.createNewService(serviceName,className);
		doc.addChild(oMnewService);
		this.writeToXml(doc, serviceXml);
	}
	
	private void writeToXml(OMElement Service,File path) throws IOException, XMLStreamException{
			 XMLOutputFactory xof = XMLOutputFactory.newInstance();	   
	         FileWriter fstream = new FileWriter(path);
	         BufferedWriter out = new BufferedWriter(fstream);
	         XMLStreamWriter writer = xof.createXMLStreamWriter(out);
	         Service.serialize(writer);
	         writer.flush();
	}
	
	private OMElement readServiceXml(File serviceXml) throws FileNotFoundException, XMLStreamException{
		 FileInputStream stream = new FileInputStream(serviceXml);
		 OMElement documentElement = new StAXOMBuilder(stream).getDocumentElement();
		 return documentElement;
	}
	
	private OMElement createNewService(String serviceName,String className){
		
		 OMFactory factory = OMAbstractFactory.getOMFactory();
         OMNamespace poNs = null;		        
         OMElement service =factory.createOMElement("service", poNs);
         service.addAttribute("name", serviceName, poNs);        
         OMElement description = factory.createOMElement("description", poNs);
         description.setText(" Please add your comment here");
         service.addChild(description);
         OMElement msgRecevers = factory.createOMElement("messageReceivers", poNs);
         service.addChild(msgRecevers);    
         OMElement msgRecever = factory.createOMElement("messageReceiver", poNs);
         msgRecever.addAttribute("mep", "http://www.w3.org/2004/08/wsdl/in-only", poNs);
         msgRecever.addAttribute("class", "org.apache.axis2.rpc.receivers.RPCInOnlyMessageReceiver", poNs);
         msgRecevers.addChild(msgRecever);       
         msgRecever = factory.createOMElement("messageReceiver", poNs);
         msgRecever.addAttribute("mep", "http://www.w3.org/2004/08/wsdl/in-out", poNs);
         msgRecever.addAttribute("class", "org.apache.axis2.rpc.receivers.RPCInOnlyMessageReceiver", poNs);
         msgRecevers.addChild(msgRecever);
         OMElement parameter = factory.createOMElement("parameter", poNs);
         parameter.addAttribute("name", "ServiceClass", poNs);
         parameter.addAttribute("locked","false", poNs);
         parameter.setText(className);
         service.addChild(parameter);

         return service;
	}
	
	private OMElement addServiceGroup(String groupName){
		OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace poNs = null;		        
        OMElement serviceGroup =factory.createOMElement("serviceGroup", poNs);
        serviceGroup.addAttribute("name", groupName, poNs);
        return serviceGroup;
	}
}
