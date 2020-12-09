package org.wso2.developerstudio.eclipse.artifact.bpel.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELArtifactConstants;

public class WSDLInfoWizardPage extends WizardPage{
	private Text serviceNameText;
	private Text portNameText;
	private Text serviceAddressText;
	private Combo bindingProtocolCombo;
	private String serviceName;
	private String portName;
	private String serviceAddress;
	private String bindingProtocol;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getBindingProtocol() {
		return bindingProtocol;
	}

	public void setBindingProtocol(String bindingProtocol) {
		this.bindingProtocol = bindingProtocol;
	}

	protected WSDLInfoWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 15, 104, 13);
		lblNewLabel.setText("Service Name");
		
		serviceNameText = new Text(container, SWT.BORDER);
		serviceNameText.setBounds(120, 10, 343, 23);
		
		portNameText = new Text(container, SWT.BORDER);
		portNameText.setBounds(120, 50, 343, 23);
		
		Label lblPortName = new Label(container, SWT.NONE);
		lblPortName.setText("Port Name");
		lblPortName.setBounds(10, 55, 104, 13);
		
		serviceAddressText = new Text(container, SWT.BORDER);
		serviceAddressText.setBounds(120, 93, 343, 23);
		
		Label lblServiceAddress = new Label(container, SWT.NONE);
		lblServiceAddress.setText("Service Address");
		lblServiceAddress.setBounds(10, 98, 104, 13);
		
		Label lblBindingProtocol = new Label(container, SWT.NONE);
		lblBindingProtocol.setText("Binding Protocol");
		lblBindingProtocol.setBounds(10, 142, 104, 13);
		
		bindingProtocolCombo = new Combo(container, SWT.READ_ONLY);
		bindingProtocolCombo.setBounds(120, 135, 343, 27);
		
		fillCombo();
		
		serviceAddressText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setServiceName(serviceNameText.getText());
			}
		});
		
		portNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setPortName(portNameText.getText());
			}
		});
		
		serviceAddressText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setServiceAddress(serviceAddressText.getText());
			}
		});
		
		bindingProtocolCombo.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				setBindingProtocol(bindingProtocolCombo.getText());
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
	}
	
	public void fillCombo(){
		bindingProtocolCombo.add(BPELArtifactConstants.SOAP_BINDING_TYPE);
		bindingProtocolCombo.add(BPELArtifactConstants.HTTP_BINDING_TYPE);
		if(bindingProtocolCombo.getSelectionIndex() == -1){
			bindingProtocolCombo.select(0);
		}
	}
}
