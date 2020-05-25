/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * 
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.CloudConnectorOperationPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;

public class ConnectorParameterRenderer extends PropertyParameterRenderer {
    
    HashMap<String, Control> controlList;
    HashMap<String, Composite> compositeList;
    IPropertiesEditionComponent propertiesEditionComponent;
    SectionPropertiesEditingPart partForm;
    
    public ConnectorParameterRenderer(IPropertiesEditionComponent propertiesEditionComponent, SectionPropertiesEditingPart partForm) {
        this.propertiesEditionComponent = propertiesEditionComponent;
        this.partForm = partForm;
    }
    
    @Override
    public Group generate(FormToolkit widgetFactory, Composite parent, ConnectorRoot connectorRoot) {
        //parent.setBackgroundMode(SWT.INHERIT_FORCE);
//        for(Element elem: connectorRoot.getElements()) {
//            recursive(elem, parent);
//        }
        Group propertiesSection = createGroup(parent, "Connector Params");
        Group propertiesAnotherSection = createGroup(parent, "Another Connector Params");
        //Iterate through recieved json and generate fields accordingly. Pass parameter name as id.
        controlList = new HashMap<String, Control>();
        compositeList = new HashMap<String, Composite>();
        createTextBoxFieldWithButton(widgetFactory, propertiesSection, "File Pattern:","FX", "filePattern");
        createTextBoxField(widgetFactory, propertiesSection, "Set Timeout:","setTimeout");
        createTextBoxFieldWithButton(widgetFactory, propertiesSection, "Destination:","FX", "destination");
        createTextBoxField(widgetFactory, propertiesSection, "Set Passive Mode:","setPassiveMode");
        
        Group propertiesSubSection = createGroup(propertiesSection,"Timeout Section");
        createTextBoxField(widgetFactory, propertiesSubSection, "Set So Timeout:", "setSoTimeout");
        createTextBoxField(widgetFactory, propertiesSection, "Source:","source");
        createTextBoxField(widgetFactory, propertiesSubSection, "Set User Dir Is Root:", "setUserDirIsRoot");
        createTextBoxField(widgetFactory, propertiesAnotherSection, "Set Strict Host Key Checking:","setStrictHostKeyChecking");
        createTextBoxField(widgetFactory, propertiesAnotherSection, "Include Parent Directory:", "includeParentDirectory");
        //filePattern=, setTimeout=, destination=, setPassiveMode=, setSoTimeout=, source=, setUserDirIsRoot=, setStrictHostKeyChecking=, includeParentDirectory=}
//        createTextBoxFieldWithButton(widgetFactory, propertiesSection, "Field With Button :", "fX", "xpath");
       createDropDownField(widgetFactory, propertiesSubSection, "Drop Down: ", new String[] {"option 1", "option 2"}, "drop");
//        createCheckBoxField(widgetFactory, propertiesSection, "Check Box : ", new String[] {"option 1", "option 2"}, "check");
        
        return propertiesSection;
    }
    
    public void recursive(Element element, Composite parent) {
        if(element.getType().equals("attribute")) {
            evaluateAttribute((AttributeValue)element.getValue(), parent);
        } else {
            AttributeGroupValue agv = (AttributeGroupValue)element.getValue();
            // Is group Name connection special????
            Group subGroup = createGroup(parent, agv.getGroupName());
            for(Element elem: agv.getElements()) {
                recursive(elem, subGroup);
            }
        }
    }
    
    public void evaluateAttribute(AttributeValue value, Composite parent) {
        if(AttributeValueType.STRING.equals(value.getType())) {
            
        } else if (AttributeValueType.VALUEOREXPRESSION.equals(value.getType())) {
            
        } else if (AttributeValueType.COMBO.equals(value.getType())) {
            
        }
    }
    
    public Group createGroup(Composite parent, String label) {
        Group propertiesSection = new Group(parent, SWT.SHADOW_ETCHED_IN);
        propertiesSection.setBackgroundMode(SWT.INHERIT_FORCE);
        propertiesSection.setText(label);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 2;
        propertiesGroupLayout.marginLeft = 5;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 10;
        propertiesSection.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        propertiesSection.setLayoutData(propertiesSectionData);
        return propertiesSection;      
    }
    
    
    private Composite createTextBoxField(FormToolkit widgetFactory, Composite parent, String Label, String id) {
        Composite textBoxComposite = createComposite(id, widgetFactory, parent,2,2);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(Label);
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        setToolTip(label, "This is a generic Tool tip Message of new properties renderer");
        Text configRef = widgetFactory.createText(textBoxComposite, "");
        controlList.put(id, configRef);
        configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);

        configRef.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                //if (e.character == SWT.CR) {
                    //((CallTemplateParameter)configRef.getData()).setParameterValue(configRef.getText());
                    CallTemplateParameter ctp = (CallTemplateParameter)configRef.getData();
                    setParameterType(RuleOptionType.VALUE, ctp);
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, ctp, configRef.getText()));
                    
               // }
            }
        });
        return parent;
    }
    
    private Composite createTextBoxFieldWithButton(FormToolkit widgetFactory,final Composite parent, String Label, String buttonText, String id) {
        Composite textBoxComposite = createComposite(id, widgetFactory, parent,3,3);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(Label);
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        //label.setToolTipText(Label);
        setToolTip(label, "This is a generic Tool tip Message of new properties renderer");
        final Text configRef = widgetFactory.createText(textBoxComposite, "");
        configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        controlList.put(id, configRef);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        Button configButton = widgetFactory.createButton(textBoxComposite, buttonText, SWT.PUSH);
        configButton.setText(buttonText);
        configRef.setLayoutData(configRefData);
        configButton.addListener(SWT.Selection, new Listener()
        {
            @Override
            public void handleEvent(Event event)
            {
                CallTemplateParameter ctp = (CallTemplateParameter)configRef.getData();
                setParameterType(RuleOptionType.EXPRESSION, ctp);
                openValueExpressionWidgetNamespacedPropertyEditor(parent, configRef, ctp.getParameterExpression());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, ctp, configRef.getText()));
            }
        });
        configRef.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                //if (e.character == SWT.CR) {
                    //((CallTemplateParameter)configRef.getData()).setParameterValue(configRef.getText());
                    CallTemplateParameter ctp = (CallTemplateParameter)configRef.getData();
                    //ctp.setParameterValue(configRef.getText());
                    setParameterType(RuleOptionType.VALUE, ctp);
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(partForm, EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, ctp, configRef.getText()));
                    
                //}
            }
        });
        return parent;
    }
    
    private Composite createDropDownField(FormToolkit widgetFactory, Composite parent, String Label, String [] options, String id) {
        Composite textBoxComposite = createComposite(id, widgetFactory, parent, 2, 2);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(Label);
        GridData labelRefData = new GridData();
        labelRefData.widthHint = 120;
        label.setLayoutData(labelRefData);
        Combo configRef = new Combo(textBoxComposite, SWT.DROP_DOWN);
        controlList.put(id, configRef);
        configRef.setItems(options);
        GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
        configRef.setLayoutData(configRefData);
        return parent;
    }
    
    private Composite createCheckBoxField(FormToolkit widgetFactory, Composite parent, String Label, String [] options, String id) {
        Composite textBoxComposite = createComposite(id, widgetFactory, parent, options.length+1, options.length+1);
        Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
        label.setText(Label);
        GridData configRefDatass = new GridData(GridData.FILL_HORIZONTAL);
        label.setLayoutData(configRefDatass);
        for (String option:options) {
            Button configRef = widgetFactory.createButton(textBoxComposite,option,SWT.CHECK);
            configRef.setText(option);
            //configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
            GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
            configRef.setLayoutData(configRefData);
        }
        return parent;
    }
    
    private Composite createComposite(FormToolkit widgetFactory, Composite parent) {
        Composite composite = widgetFactory.createComposite(parent);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 2;
        propertiesGroupLayout.marginLeft = 15;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 10;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 2;
        composite.setLayoutData(propertiesSectionData);
        return composite;
        
    }
    
    private Composite createComposite(String id, FormToolkit widgetFactory, Composite parent, int columns, int span) {
        Composite composite = widgetFactory.createComposite(parent, SWT.NO_BACKGROUND);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = columns;
        propertiesGroupLayout.marginLeft = 0;
        propertiesGroupLayout.horizontalSpacing = 20;
        propertiesGroupLayout.verticalSpacing = 10;
        composite.setLayout(propertiesGroupLayout);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = span;
        composite.setLayoutData(propertiesSectionData);
        compositeList.put(id, composite);
        return composite;
        
    }
    
    
    //Triggerred with ecore event bus
    @Override
    public void fillData(HashMap<String,String> paramValues, EList parameterList) {
        for(String key: controlList.keySet()) {
            if(controlList.get(key) instanceof Text) {
                CallTemplateParameter ctp = null;
                for(Object parameter: parameterList) {
                   CallTemplateParameter ctpi = (CallTemplateParameter)parameter;
                   if(((String)key).equals(ctpi.getParameterName())) {
                       ctp = ctpi;
                   }
                }
                String value = ctp.getParameterValue();
                if (ctp.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
                    NamespacedProperty namespacedExpression = ctp.getParameterExpression();
                    value = namespacedExpression.getPropertyValue();
                }
                ((Text)controlList.get(key)).setText(value);
                ((Text)controlList.get(key)).setData(ctp);
            }
        }
        validate();
    }
    
    public void validate() {
        //Implement enableCondition Logic Here
    }
    
    
    
    private void openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent, Text valueExpressionText, NamespacedProperty valueExpression) {
        if(valueExpression == null) { 
            valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
            ((CallTemplateParameter)valueExpressionText.getData()).setParameterExpression(valueExpression);
        }
        EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
                valueExpression);
        valueExpression = nspd.open();
        valueExpressionText.setText(valueExpression.getPropertyValue());
    }
    
    private void setParameterType(RuleOptionType ruleType, CallTemplateParameter ctp) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ctp);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

            @Override
            protected void doExecute() {
                ctp.setTemplateParameterType(ruleType);
            }
        });
    }
    
    public void setToolTip(Control control, String text) {
        final ToolTip tip = new ToolTip(control.getShell(), SWT.BALLOON);
        tip.setMessage(text);
        tip.setAutoHide(true);
        control.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseUp(MouseEvent e) {                
            Control actionWidget = (Control) e.widget;
            Point loc = actionWidget.toDisplay(actionWidget.getLocation());
            tip.setLocation(loc.x + actionWidget.getSize().x - actionWidget.getBorderWidth(), loc.y);
            tip.setVisible(true);
            }
            
            @Override
            public void mouseDown(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
    }
    

}
