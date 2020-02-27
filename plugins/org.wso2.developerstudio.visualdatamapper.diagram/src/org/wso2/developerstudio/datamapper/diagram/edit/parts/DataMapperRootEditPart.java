/*
 * Copyright (c) 2014 -2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Button;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.gmf.tooling.runtime.update.UpdateDiagramCommand;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.diagram.schemagen.json.JSONArray;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.ISchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformerRegistry;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated
 */
public class DataMapperRootEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public final static String MODEL_ID = "DataMapper"; //$NON-NLS-1$
    
    private Label aiDataMapperLabel;

    private Button aiDataMapperLabelBtn;

    private RoundedRectangle aiDataMapperLabelBox;
    
    private static final String URL_OF_AI_DATA_MAPPER_SERVER = "https://ai-data-mapper.wso2.com/uploader";
    
    private static final String EMPTY_STRING = "";
    

    /**
     * @generated
     */
    public static final int VISUAL_ID = 1000;

    /**
     * @generated
     */
    public DataMapperRootEditPart(View view) {
        super(view);
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DataMapperRootItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DataMapperRootCanonicalEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(DataMapperVisualIDRegistry.TYPED_INSTANCE));
        removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    }
  
    /** 
     * This method creates the figure to be used as datamapper editpart's visuals.
     * Set color theme of the figure and append figures related to AI data mapping. 
     */
    protected IFigure createFigure() {
        IFigure figure = super.createFigure();
        figure.setBackgroundColor(new Color(null, 246, 255, 255));
        figure.setOpaque(true);

        aiDataMapperLabelBox = new RoundedRectangle();
        aiDataMapperLabelBox.setBackgroundColor(new Color(null, 232, 234, 237));
        aiDataMapperLabelBox.setLocation(new Point(0, -400));
        aiDataMapperLabelBox.setSize(new Dimension(480, 40));
        LineBorder border = new LineBorder();
        border.setColor(new Color(null, 245, 246, 247));
        aiDataMapperLabelBox.setBorder(border);

        aiDataMapperLabel = new Label("AI generated mappings available.");
        aiDataMapperLabel.setSize(new Dimension(600, 40));
        aiDataMapperLabel.setLocation(new Point(-130, -400));

        aiDataMapperLabelBtn = new Button("Apply");
        aiDataMapperLabelBtn.setSize(new Dimension(100, 30));
        aiDataMapperLabelBtn.setBackgroundColor(new Color(null, 11, 164, 226));
        aiDataMapperLabelBtn.setLocation(new Point(360, -398));
        aiDataMapperLabelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                try {
                    drawMappings();
                } catch (ConnectTimeoutException e) {
                    log.error("Connecting to the service timed out", e);
                    popupDialogBox(IStatus.ERROR, "Cannot connect to the service.");
                } catch (SocketTimeoutException e) {
                    log.error("Generation of AI Mapping timed out", e);
                    popupDialogBox(IStatus.ERROR, "Mapping generation takes too long.");
                } catch (IOException e) {
                    log.error("Error getting mapping suggestions from the server", e);
                    popupDialogBox(IStatus.ERROR, e.getMessage());
                }

            }
        });

        figure.add(aiDataMapperLabelBox);
        figure.add(aiDataMapperLabel);
        figure.add(aiDataMapperLabelBtn);

        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) this.getDiagramView().getDiagram().getElement();
        int inputSize = datamapperRoot.getInput().getTreeNode().size();
        int outputSize = datamapperRoot.getOutput().getTreeNode().size();
        datamapperRoot.setAiDataMapperButton(aiDataMapperLabelBtn);
        datamapperRoot.setAiDataMapperLabel(aiDataMapperLabel);
        datamapperRoot.setAiDataMapperLabelBox(aiDataMapperLabelBox);

        if ((inputSize == 0) || (outputSize == 0)) {
            aiDataMapperLabelBtn.setVisible(false);
            aiDataMapperLabel.setVisible(false);
            aiDataMapperLabelBox.setVisible(false);
        }
        return figure;            
    }
    
    /**
     * This method draws datamapper configurations automatically.
     * 
     * @throws HttpException exceptions from getMappings method
     * @throws IOException exceptions from getMappings method
     */
    public void drawMappings() throws HttpException, IOException {
        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) this.getDiagramView().getDiagram().getElement();
        
        // Get input and output schemas
        String inputContent = getSchema(datamapperRoot, "input");
        String outputContent = getSchema(datamapperRoot, "output");
        
        List<String> mappings = getMappings(inputContent, outputContent);
        
        EList<TreeNode> inputTreeNodesList = ((DataMapperRoot) datamapperRoot).getInput().getTreeNode();
        EList<TreeNode> outputTreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput().getTreeNode();
        int numberOfMappingSuggestions = mappings.size() / 4;

        // Checking whether any mapping suggestions exists 
        if (numberOfMappingSuggestions > 0) {
            for (int i = 0; i < numberOfMappingSuggestions; i++) {
                final String attributeNameOfInputNode = mappings.get(i * 4);
                String pathOfInputNode = mappings.get(i * 4 + 1);
                final String attributeNameOfOutputNode = mappings.get(i * 4 + 2);
                String pathOfOutputNode = mappings.get(i * 4 + 3);

                Iterator iterator = inputTreeNodesList.iterator();
                String nodeName = EMPTY_STRING;
                TreeNode treeNodeInFinal = null;
                TreeNode treeNode = iterateList(treeNodeInFinal, iterator, attributeNameOfInputNode, pathOfInputNode);

                Iterator iteratorOut = outputTreeNodesList.iterator();
                nodeName = EMPTY_STRING;
                TreeNode treeNodeOutFinal = null;
                TreeNode treeNodeOut = iterateList(treeNodeOutFinal, iteratorOut, attributeNameOfOutputNode,
                        pathOfOutputNode);
                if ((treeNodeOut != null) && (treeNodeOut.getInNode().getIncomingLink().size() == 0)) {
                    try {
                        final EObject source = (EObject) treeNode.getOutNode();
                        final EObject target = (EObject) treeNodeOut.getInNode();
                        final OutNode container = deduceContainer(source, target);
                        final DataMapperLink newElement = DataMapperFactory.eINSTANCE.createDataMapperLink();
                        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(container);
                        domain.getCommandStack().execute(new RecordingCommand(domain) {
                            @Override
                            protected void doExecute() {
                                container.getOutgoingLink().add(newElement);
                                newElement.setOutNode((OutNode) source);
                                newElement.setInNode((InNode) target);
                            }
                        });
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } else {
            popupDialogBox(IStatus.INFO, "No suggessions from AI Mapping");
        }
        UpdateDiagramCommand updater = new UpdateDiagramCommand();
        try {
            updater.execute(null);
        } catch (ExecutionException e) {
            log.error(e);
        }
    }

    private TreeNode iterateList(TreeNode treeNodeFinal, Iterator iterator, String attributeName, String attributePath) {
        TreeNode treeNode = null;
        String nodeName = null;
        while(iterator.hasNext() && !attributeName.equals(nodeName)) {
            treeNode = (TreeNode) iterator.next();
            nodeName = (String) treeNode.getName();
            if (attributeName.equals(nodeName)) {
                treeNodeFinal = treeNode;
            }
            if ( attributePath.indexOf(nodeName) !=-1) {
                treeNodeFinal = traverseNode(treeNodeFinal, treeNode, attributeName, attributePath);
            }
        }
        return treeNodeFinal;
    }
    
    private TreeNode traverseNode(TreeNode treeNodeFinal, TreeNode prevTreeNode, String attributeName, String attributePath) {
        EList<TreeNode> treeNode = prevTreeNode.getNode();
        Iterator iterator = treeNode.iterator();
        treeNodeFinal = iterateList(treeNodeFinal, iterator,  attributeName, attributePath);
        return treeNodeFinal;
    }
    
    private static OutNode deduceContainer(EObject source, EObject target) {
        for (EObject element = source; element != null; element = element.eContainer()) {
            if (element instanceof OutNode) {
                return (OutNode) element;
            }
        }
        return null;
    }
    
    private String getSchema(DataMapperRootImpl datamapperRoot, String type) {
        ISchemaTransformer schemaTransformer = null;
        try {
            schemaTransformer = SchemaTransformerRegistry.getInstance().getSchemaTransformer().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
          log.error(e);
        }
        // Model root of input schema tree
        EList<TreeNode> TreeNodesList = null;
        if (type.equals("input")){
            TreeNodesList = ((DataMapperRoot) datamapperRoot).getInput().getTreeNode();
        }
        else {
            TreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput().getTreeNode();
        }
        File schemaFile = null;
        String content = null;
        // If a tree node is found, continue saving
        if (null != TreeNodesList && !TreeNodesList.isEmpty()) {
            TreeNodeImpl inputTreeNode = (TreeNodeImpl) TreeNodesList.get(0);
            content = schemaTransformer.getSchemaContentFromModel(inputTreeNode, schemaFile, true, content);  //.getSchemaContentFromModel(inputTreeNode, schemaFile);
        }
        // Empty tree node, clear the file
        else {
            content = EMPTY_STRING;
        }
        return content;
    }
    
    /**
     * This method gets AI generated mapping suggestions from the server.
     * 
     * @param inputSchema schema of the input message
     * @param outputSchema schema of the output message
     * @return arrayList with mapping suggestions
     * @throws HttpException exception related to connecting to the service
     * @throws IOException exceptions related getting/sending data to the service.
     */
    public List<String> getMappings(String inputSchema, String outputSchema) throws HttpException, IOException {
        HttpURLConnection connection = null;  
        
        // Create one set of schemas
        JSONArray schemas = new JSONArray();
        schemas.put(inputSchema);
        schemas.put(outputSchema);
        
        String schemasToSend = schemas.toString();
        StringRequestEntity requestEntity = new StringRequestEntity(schemasToSend, "application/json", "UTF-8");
        final HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(2000);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(4000);
        PostMethod postMethod = new PostMethod(URL_OF_AI_DATA_MAPPER_SERVER);
        postMethod.setRequestEntity(requestEntity);
        int statusCode = httpClient.executeMethod(postMethod);
        String outString = postMethod.getResponseBodyAsString();
        return new ArrayList<String>(Arrays.asList(outString.split("#")));
    }    
    
    /**
     * This method shows a pop up dialog box.
     * 
     * @param type Type of the message
     * @param message message to be displayed
     */
    private void popupDialogBox(int type, String message) {
        final IStatus editorStatus = new Status(type, Activator.PLUGIN_ID, message);
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                ErrorDialog.openError(Display.getDefault().getActiveShell(), "AI Data Mapper is not working", EMPTY_STRING,
                        editorStatus);
            }
        });
    }
}
