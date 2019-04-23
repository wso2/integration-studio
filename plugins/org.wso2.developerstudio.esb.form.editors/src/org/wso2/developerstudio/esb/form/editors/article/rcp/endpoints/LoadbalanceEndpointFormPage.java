package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.OMNamespaceImpl;
//import org.apache.axiom.om.impl.llom.OMElementImpl;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.endpoints.AddressEndpointFactory;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Member;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndpointsDialog;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureMembersDialog;
import org.wso2.developerstudio.esb.form.editors.article.providers.EndpointTableEntry;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class LoadbalanceEndpointFormPage extends EndpointFormPage {

    protected Text sessionTimeout;

    protected Combo endpointAlgorithmn;
    protected Combo endpointFailover;
    protected Combo endpointBuildMessage;
    protected Combo endpointSessionType;

    protected Button loadbalanceEP_Properties;
    protected Button loadbalanceEP_Endpoints;
    protected Button loadbalanceEP_Members;

    private List<EndPointProperty> endpointPropertyList;
    private List<EndpointTableEntry> endpointsList;
    private List<Member> memberList;
    private List<Endpoint> synapseEndpointList;

    private Section basicSection;
    private Section miscSection;
    private Section sessionSection;
    private Section memberSection;

    public LoadbalanceEndpointFormPage(FormEditor editor) {
        super(editor);
    }

    public Button getLoadBalanceEP_Properties() {
        return loadbalanceEP_Properties;
    }

    public void setLoadBalanceEP_Properties(Button addressEP_Properties) {
        this.loadbalanceEP_Properties = addressEP_Properties;
    }

    protected void createFormContent(IManagedForm managedForm) {
        form = managedForm.getForm();
        toolkit = managedForm.getToolkit();
        form.setText(Messages.getString("EndpointPage.sectionMainTitle"));
        form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

        GridLayout layout = new GridLayout();
        layout.marginLeft = 20;
        layout.marginRight = 20;
        layout.marginTop = 10;
        layout.numColumns = 1;
        layout.makeColumnsEqualWidth = true;

        form.getBody().setLayout(layout);
        GridData formGridData = new GridData();
        formGridData.horizontalSpan = 6;
        formGridData.grabExcessHorizontalSpace = true;
        form.setLayoutData(formGridData);

        createLoadBalanceFormBasicSection();
        createFormSessionSection();
        createFormMemberSection();
        createFormMiscSection();

        form.setText(Messages.getString("LoadbalanceEndpointPage.sectionMainTitle"));
    }

    public void createLoadBalanceFormBasicSection() {
        basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));

        GridData samplegridData = new GridData();
        samplegridData.horizontalSpan = 3;
        samplegridData.horizontalAlignment = SWT.FILL;
        samplegridData.grabExcessHorizontalSpace = true;
        basicSection.setLayoutData(samplegridData);

        Composite basicSectionClient = toolkit.createComposite(basicSection);
        basicSectionClient.setLayout(new GridLayout());
        basicSection.setClient(basicSectionClient);

        toolkit.createLabel(basicSectionClient, "Name :");
        endpointName = toolkit.createText(basicSectionClient, "");
        endpointName.setBackground(new Color(null, 229, 236, 253));
        GridData endpointNameGridData = new GridData();
        endpointNameGridData.horizontalSpan = 3;
        endpointNameGridData.horizontalAlignment = GridData.FILL;
        endpointNameGridData.grabExcessHorizontalSpace = true;
        endpointName.setLayoutData(endpointNameGridData);

        endpointName.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Algorithm :");
        endpointAlgorithmn = new Combo(basicSectionClient, SWT.DROP_DOWN);
        String[] formats = { "Round Robin", "Other" };
        endpointAlgorithmn.setItems(formats);
        GridData endpointFormatGridData = new GridData();
        endpointFormatGridData.horizontalSpan = 3;
        endpointFormatGridData.horizontalAlignment = GridData.FILL;
        endpointFormatGridData.grabExcessHorizontalSpace = true;
        endpointAlgorithmn.setLayoutData(endpointFormatGridData);

        endpointAlgorithmn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Failover :");
        endpointFailover = new Combo(basicSectionClient, SWT.DROP_DOWN);
        String[] statisticsStates = { "True", "False" };
        endpointFailover.setItems(statisticsStates);
        GridData endpointStatisticsGridData = new GridData();
        endpointStatisticsGridData.horizontalSpan = 3;
        endpointStatisticsGridData.horizontalAlignment = GridData.FILL;
        endpointStatisticsGridData.grabExcessHorizontalSpace = true;
        endpointFailover.setLayoutData(endpointStatisticsGridData);

        endpointFailover.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (Boolean.parseBoolean(endpointFailover.getText())) {
                    endpointFailover.select(0);
                }
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Build Message :");
        endpointBuildMessage = new Combo(basicSectionClient, SWT.DROP_DOWN);
        String[] buildMessageStates = { "True", "False" };
        endpointBuildMessage.setItems(buildMessageStates);
        GridData endpointBuildMessageGridData = new GridData();
        endpointBuildMessageGridData.horizontalSpan = 3;
        endpointBuildMessageGridData.horizontalAlignment = GridData.FILL;
        endpointBuildMessageGridData.grabExcessHorizontalSpace = true;
        endpointBuildMessage.setLayoutData(endpointBuildMessageGridData);

        endpointBuildMessage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (Boolean.parseBoolean(endpointBuildMessage.getText())) {
                    endpointBuildMessage.select(0);
                }
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Endpoints :");

        loadbalanceEP_Endpoints = toolkit.createButton(basicSectionClient, "Add Endpoints", SWT.PUSH);
        loadbalanceEP_Endpoints.setBackground(new Color(null, 229, 236, 253));
        loadbalanceEP_Endpoints.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndpointsDialog endpointsDialog = new ConfigureEndpointsDialog(shell, endpointsList);
                endpointsDialog.setBlockOnOpen(true);
                endpointsDialog.open();
                if (endpointsDialog.isOk()) {
                    endpointsList = endpointsDialog.getEndpointsList();
                }

                setSave(true);
                updateDirtyState();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void createFormSessionSection() {
        sessionSection = endpointCommons.createSection(form, toolkit,
                Messages.getString("EndpointPage.section.session"));

        GridData samplegridData = new GridData();
        samplegridData.horizontalSpan = 3;
        samplegridData.horizontalAlignment = SWT.FILL;
        samplegridData.grabExcessHorizontalSpace = true;
        sessionSection.setLayoutData(samplegridData);

        Composite basicSectionClient = toolkit.createComposite(sessionSection);
        basicSectionClient.setLayout(new GridLayout());
        sessionSection.setClient(basicSectionClient);
        sessionSection.setExpanded(false);

        toolkit.createLabel(basicSectionClient, "Session Management :");
        endpointSessionType = new Combo(basicSectionClient, SWT.DROP_DOWN);
        String[] formats = { "None", "Transport", "SOAP", "Client ID" };
        endpointSessionType.setItems(formats);
        endpointSessionType.select(0);
        GridData endpointFormatGridData = new GridData();
        endpointFormatGridData.horizontalSpan = 3;
        endpointFormatGridData.horizontalAlignment = GridData.FILL;
        endpointFormatGridData.grabExcessHorizontalSpace = true;
        endpointSessionType.setLayoutData(endpointFormatGridData);

        endpointSessionType.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Session Timeout :");
        sessionTimeout = toolkit.createText(basicSectionClient, "");
        sessionTimeout.setBackground(new Color(null, 229, 236, 253));
        GridData endpointNameGridData = new GridData();
        endpointNameGridData.horizontalSpan = 3;
        endpointNameGridData.horizontalAlignment = GridData.FILL;
        endpointNameGridData.grabExcessHorizontalSpace = true;
        sessionTimeout.setLayoutData(endpointNameGridData);

        sessionTimeout.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });
    }

    public void createFormMemberSection() {
        memberSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.member"));

        GridData samplegridData = new GridData();
        samplegridData.horizontalSpan = 3;
        samplegridData.horizontalAlignment = SWT.FILL;
        samplegridData.grabExcessHorizontalSpace = true;
        memberSection.setLayoutData(samplegridData);

        Composite basicSectionClient = toolkit.createComposite(memberSection);
        basicSectionClient.setLayout(new GridLayout());
        memberSection.setClient(basicSectionClient);
        memberSection.setExpanded(false);

        toolkit.createLabel(basicSectionClient, "Members :");

        loadbalanceEP_Members = toolkit.createButton(basicSectionClient, "Add Members", SWT.PUSH);
        loadbalanceEP_Members.setBackground(new Color(null, 229, 236, 253));
        loadbalanceEP_Members.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = Display.getDefault().getActiveShell();
                ConfigureMembersDialog paramDialog = new ConfigureMembersDialog(shell, memberList);
                paramDialog.setBlockOnOpen(true);
                paramDialog.open();
                memberList = paramDialog.getEndpointMemberList();

                setSave(true);
                updateDirtyState();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void createFormMiscSection() {

        miscSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));

        GridData miscSectionGridData = new GridData();
        miscSectionGridData.horizontalSpan = 3;
        miscSectionGridData.horizontalAlignment = GridData.FILL;
        miscSectionGridData.grabExcessHorizontalSpace = true;
        miscSection.setLayoutData(miscSectionGridData);

        Composite miscSectionClient = toolkit.createComposite(miscSection);
        miscSectionClient.setLayout(new GridLayout());
        miscSection.setClient(miscSectionClient);

        toolkit.createLabel(miscSectionClient, "Description :");
        eP_Description = toolkit.createText(miscSectionClient, "");
        eP_Description.setBackground(new Color(null, 229, 236, 253));
        GridData addressEPDescriptionGridData = new GridData();
        addressEPDescriptionGridData.horizontalSpan = 3;
        addressEPDescriptionGridData.horizontalAlignment = GridData.FILL;
        addressEPDescriptionGridData.grabExcessHorizontalSpace = true;
        eP_Description.setLayoutData(addressEPDescriptionGridData);

        eP_Description.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(miscSectionClient, "Properties :");

        loadbalanceEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
        loadbalanceEP_Properties.setBackground(new Color(null, 229, 236, 253));
        loadbalanceEP_Properties.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndPointPropertiesDialog paramDialog = new ConfigureEndPointPropertiesDialog(shell,
                        endpointPropertyList);
                paramDialog.setBlockOnOpen(true);
                paramDialog.open();
                endpointPropertyList = paramDialog.getEndpointPropertyList();

                setSave(true);
                updateDirtyState();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });

    }

    public Text getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Text sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Combo getEndpointAlgorithmn() {
        return endpointAlgorithmn;
    }

    public void setEndpointAlgorithmn(Combo endpointAlgorithmn) {
        this.endpointAlgorithmn = endpointAlgorithmn;
    }

    public Combo getEndpointFailover() {
        return endpointFailover;
    }

    public void setEndpointFailover(Combo endpointFailover) {
        this.endpointFailover = endpointFailover;
    }

    public Combo getEndpointBuildMessage() {
        return endpointBuildMessage;
    }

    public void setEndpointBuildMessage(Combo endpointBuildMessage) {
        this.endpointBuildMessage = endpointBuildMessage;
    }

    public List<Member> getMemberList() {
        return this.memberList;
    }

    public void setMemberList(List<Member> memList) {
        this.memberList = memList;
    }

    public List<EndpointTableEntry> getEndpointList() {
        return this.endpointsList;
    }
    
    public void setEndpointList(List<EndpointTableEntry> list) {
        this.endpointsList = list;
    }

    public List<EndPointProperty> getEndPointPropertyList() {
        return this.endpointPropertyList;
    }

    public void setEndPointPropertyList(List<EndPointProperty> propList) {
        this.endpointPropertyList = propList;
    }

    public Combo getEndpointSessionType() {
        return this.endpointSessionType;
    }
    
    public List<Endpoint> getSynapseEndpointList() {
        synapseEndpointList = new ArrayList<>();
        for (int i = 0; i < endpointsList.size(); i++) {
            EndpointTableEntry endpointTableEntry = endpointsList.get(i);
            if (endpointTableEntry.isInline()) {
                String endpointContent = endpointTableEntry.getEndpointValue();
                try {
                    OMElement element = AXIOMUtil.stringToOM(endpointContent);
                    if (element.getChildrenWithLocalName("address") != null) {
                        if (!element.getChildrenWithName(new QName("http://ws.apache.org/ns/synapse", "address")).hasNext()) {
                            Iterator children = element.getChildrenWithLocalName("address");
                            while (children.hasNext()) {
                                OMElement child = (OMElement) children.next();
                                child.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                                setNamespaceForChildren(child);
                            }
                        }
                        
                        AddressEndpoint addressEndpoint = (AddressEndpoint) AddressEndpointFactory.getEndpointFromElement(element, false, null);
                        synapseEndpointList.add(addressEndpoint);
                    } else {
                        System.out.println("$$$$$$$");
                    }
                } catch (XMLStreamException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            } else {
                
            }
            
        }
        return this.synapseEndpointList;
    }
    
    private static void setNamespaceForChildren(OMElement omElement) {
        Iterator childern = omElement.getChildren();
        OMElement currentElement = null;
        while (childern.hasNext()) {
            Object child = childern.next();
            if (child instanceof OMElement) {
                currentElement = (OMElement) child;
                currentElement.setNamespace(new OMNamespaceImpl("http://ws.apache.org/ns/synapse", ""));
                if (currentElement.getChildren().hasNext()) {
                    setNamespaceForChildren(currentElement);
                }

            }
        }
    }
} 
