/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.mediators.template.TemplateParam;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.Template;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateType;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * Sequence template deserializer
 */
public class SequenceTemplateDeserializer extends AbstractEsbNodeDeserializer<TemplateMediator, Template> {

    @SuppressWarnings("unchecked")
    @Override
    public Template createNode(IGraphicalEditPart part, TemplateMediator template) throws DeserializerException {
        Template templateModel = (Template) DeserializerUtils.createNode(part, EsbElementTypes.Template_3664);
        setElementToEdit(templateModel);
        executeSetValueCommand(TEMPLATE__NAME, template.getName());
        
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(templateModel);
        if (domain != null) {
            domain.getCommandStack().execute(new RecordingCommand(domain) {

                @Override
                protected void doExecute() {
                    templateModel.setDescription(template.getDescription());
                }
            });
        } else {
            templateModel.setDescription(template.getDescription());
        }
        
        executeSetValueCommand(TEMPLATE__TEMPLATE_TYPE, TemplateType.SEQUENCE);

        if (template.getParameters() != null) {
            for (TemplateParam parameter : template.getParameters()) {
                TemplateParameter templateParameter = EsbFactory.eINSTANCE.createTemplateParameter();
                templateParameter.setName(parameter.getName());
                templateParameter.setDefaultValue((String)parameter.getDefaultValue());
                templateParameter.setIsMandatory(templateParameter.isIsMandatory());
                executeAddValueCommand(templateModel.getParameters(), templateParameter, false);
            }
        }
        
        executeSetValueCommand(TEMPLATE__ON_ERROR, template.getErrorHandler());

        TransactionalEditingDomain domain1 = TransactionUtil.getEditingDomain(templateModel);
        if (domain1 != null) {
            domain1.getCommandStack().execute(new RecordingCommand(domain1) {

                @Override
                protected void doExecute() {
                    RegistryKeyProperty rk = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
                    rk.setKeyValue(template.getErrorHandler());
                    templateModel.setOnError(rk);
                }
            });
        } else {
            RegistryKeyProperty rk = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
            rk.setKeyValue(template.getErrorHandler());
            templateModel.setOnError(rk);
        }
        
        

        SequenceMediator sequenceMediator = new SequenceMediator();
        sequenceMediator.addAll(template.getList());
        sequenceMediator.setName(template.getName());
        
        refreshEditPartMap();
        @SuppressWarnings("rawtypes")
        IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(sequenceMediator);
        IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(templateModel).getChildren().get(0);
        if (deserializer != null) {
            EsbNode node = deserializer.createNode(compartment, sequenceMediator);
            if (node != null) {
                refreshEditPartMap();
                IGraphicalEditPart graphicalNode = (IGraphicalEditPart) getEditpart(node);
                if (graphicalNode != null) {
                    Rectangle rect = new Rectangle(new Point(), graphicalNode.getFigure().getPreferredSize()).getCopy();
                    rect.x = 0;
                    rect.y = 0;
                    SetBoundsCommand sbc = new SetBoundsCommand(graphicalNode.getEditingDomain(), "change location",
                            new EObjectAdapter((View) graphicalNode.getModel()), rect);
                    graphicalNode.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(sbc));
                }
            }
        }
        executeAddAllCommand(templateModel.getCommentsList(), template.getCommentsList());
        
        return templateModel;
    }

}
