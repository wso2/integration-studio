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
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
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
    HashMap<String, Control> requiredList;
    HashMap<String, Composite> compositeList;
    IPropertiesEditionComponent propertiesEditionComponent;
    SectionPropertiesEditingPart partForm;
    PropertiesWidgetProvider widgetProvider;
    
    public ConnectorParameterRenderer(IPropertiesEditionComponent propertiesEditionComponent, SectionPropertiesEditingPart partForm) {
        this.propertiesEditionComponent = propertiesEditionComponent;
        this.partForm = partForm;
        this.controlList = new HashMap<String, Control>();
        this.compositeList = new HashMap<String, Composite>();
        this.requiredList = new HashMap<String, Control>();
        widgetProvider = new PropertiesWidgetProvider(partForm, propertiesEditionComponent, controlList, compositeList, requiredList);
    }
    
    @Override
    public Composite generate(FormToolkit widgetFactory, Composite parent, ConnectorRoot connectorRoot) {
        //parent.setBackgroundMode(SWT.INHERIT_FORCE);

        Group generalGroup = widgetProvider.createGroup(parent, "General");
//      
        for(Element elem: connectorRoot.getElements()) {
            recursive(elem, parent, generalGroup, widgetFactory, 0);
        }       
        return parent;

    }
    
    public void recursive(Element element, Composite parent, Composite generalGroup, FormToolkit widgetFactory, int level) {
        ++level;
        if(element.getType().equals("attribute")) {
            if(level != 2) { //Will be 2 since ++ level
                evaluateAttribute((AttributeValue)element.getValue(), parent, widgetFactory, level);
            } else {
                evaluateAttribute((AttributeValue)element.getValue(), generalGroup, widgetFactory, level);
            }
        } else {
            AttributeGroupValue agv = (AttributeGroupValue)element.getValue();
            // Is group Name connection special????
            if(level != 1) {
                Group subGroup = widgetProvider.createGroup(parent, agv.getGroupName());
                for(Element elem: agv.getElements()) {
                    recursive(elem, subGroup, generalGroup, widgetFactory, level);
                }
            } else {
                for(Element elem: agv.getElements()) {
                    recursive(elem, parent, generalGroup, widgetFactory, level);
                }
            }

        }
    }
    
    public void evaluateAttribute(AttributeValue value, Composite parent, FormToolkit widgetFactory, int level) {
        if (AttributeValueType.STRING.equals(value.getType())) {
            if(level == 2) {
                widgetProvider.createTextBoxField(widgetFactory, parent, value);
            } else {
                widgetProvider.createTextBoxFieldWithButton(widgetFactory, parent, value);
            }
        } else if (AttributeValueType.BOOLEANOREXPRESSION.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, new String[] {"true", "false"}, value);
        } else if (AttributeValueType.COMBO.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, value.getComboValues().toArray(new String[0]), value);
        } else if (AttributeValueType.CONNECTION.equals(value.getType())) {
            widgetProvider.createConnectionField(widgetFactory, parent, value, getConnectionEntriesList());
        }
    }
    

  //mock values
    public String[] getConnectionEntriesList () {
        return new String[] {"SMTP", "POP3", "IMAP"};
    }
    
    
    
    
    //Triggerred with ecore event bus
    @Override
    public void fillData(EObject dataObject) {
        EList<CallTemplateParameter> parameterList = ((CloudConnectorOperation)dataObject).getConnectorParameters();

        //Not parameters
        String configRefValue = ((CloudConnectorOperation)dataObject).getConfigRef();
        Combo configRefCombo = (Combo)controlList.get("configRef");
        if(configRefValue != null) {
            configRefCombo.setText(configRefValue);
        }
        String descriptionValue = ((CloudConnectorOperation)dataObject).getDescription();
        Text descriptionText = (Text)controlList.get("description");
        if(descriptionValue != null) {
            descriptionText.setText(descriptionValue);
        }
        //////

       
        for(String key: controlList.keySet()) {
                CallTemplateParameter ctp = null;
                for(Object parameter: parameterList) {
                   CallTemplateParameter ctpi = (CallTemplateParameter)parameter;
                   if(((String)key).equals(ctpi.getParameterName())) {
                       ctp = ctpi;
                   }
                }
                if (ctp != null) {
                    String value = ctp.getParameterValue();
                    if (ctp.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
                        NamespacedProperty namespacedExpression = ctp.getParameterExpression();
                        value = namespacedExpression.getPropertyValue();
                    }
                
                    if(controlList.get(key) instanceof Text) {
                        ((Text)controlList.get(key)).setText(value);
                        ((Text)controlList.get(key)).setData(ctp);
                    } else if (controlList.get(key) instanceof Combo) {
                        Combo combo = (Combo)controlList.get(key);
                        combo.setText(value);
                        combo.setData(ctp);
                    }
                }
            
        }
        validate();
        widgetProvider.checkRequired();
    }
    
    public void validate() {
        //Implement enableCondition Logic Here
    }

}
