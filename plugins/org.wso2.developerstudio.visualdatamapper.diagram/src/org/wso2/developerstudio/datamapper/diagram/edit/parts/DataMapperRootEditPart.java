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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ImageHolder;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.DataMapperRootItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.ISchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformerRegistry;
import org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;

import com.google.gson.Gson;

/**
 * @generated
 */
public class DataMapperRootEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    public final static String MODEL_ID = "DataMapper"; //$NON-NLS-1$

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

      
//  Set color theme from preference store colors
    protected IFigure createFigure() {
            IFigure fig = super.createFigure();
            fig.setBackgroundColor(new Color(null, 246,255,255));
            fig.setOpaque(true);
            
//            Image img = ImageHolder.getInstance().getMapContentImage();
            Image img = ImageHolder.getInstance().getMapContentImage();
            ImageFigure iconImageFigure = new ImageFigure(img);
            iconImageFigure.setSize(new Dimension(200, 200));
            iconImageFigure.setLocation(new Point(0,-400));
            
            iconImageFigure.addMouseListener(new MouseListener() {

                @Override
                public void mouseReleased(MouseEvent me) {
                // TODO Auto-generated method stub

                }

                @Override
                public void mousePressed(MouseEvent me) {
                // TODO Auto-generated method stub
                    drawMappings();
                    

                }

                @Override
                public void mouseDoubleClicked(MouseEvent me) {
                // TODO Auto-generated method stub

                }
                });
            
            fig.add(iconImageFigure);
             
            return fig;
            }
    
    public void drawMappings() {
        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) this.getDiagramView().getDiagram().getElement();
        
        // Get input and output schemas
        String inputContent = getSchema(datamapperRoot, "input");
        String outputContent = getSchema(datamapperRoot, "output");
        writeUsingFiles(inputContent);
        
        List<String> mappings = getMappings(inputContent, outputContent);
        
        
        EList<TreeNode> inputTreeNodesList = ((DataMapperRoot) datamapperRoot).getInput().getTreeNode();
        EList<TreeNode> outputTreeNodesList = ((DataMapperRoot) datamapperRoot).getOutput().getTreeNode();
        
        int size = mappings.size()/4;
        for (int i = 0; i < size; i++) {
            String attr1 = mappings.get(i*4);
            String path1 = mappings.get(i*4 + 1);
            String attr2 = mappings.get(i*4 + 2);
            String path2 = mappings.get(i*4 + 3);
            
            Iterator iterator = inputTreeNodesList.iterator();
            String nodeName = "";
            TreeNode treeNodeFin = null; 
            TreeNode treeNode = iterateList(treeNodeFin, iterator, attr1, path1);
            
            
            Iterator iteratorOut = outputTreeNodesList.iterator();
            nodeName = "";
            TreeNode treeNodeOutFin = null;
            TreeNode treeNodeOut = iterateList(treeNodeOutFin, iteratorOut, attr2, path2);
            
            try {
                final EObject source = (EObject) treeNode.getOutNode();
                final EObject target = (EObject) treeNodeOut.getInNode();
                final OutNode container = deduceContainer(source, target);
            
            
                final DataMapperLink newElement = DataMapperFactory.eINSTANCE.createDataMapperLink();
                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(container);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
        
        UpdateDiagramCommand updater = new UpdateDiagramCommand();
        try {
            updater.execute(null);
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            ////////////////////////
            if ( attributePath.indexOf(nodeName) !=-1) {
                treeNodeFinal = traverseNode(treeNodeFinal, treeNode, attributeName, attributePath);
            }
            ///////////////////////////
//          treeNodeFinal = traverseNode(treeNodeFinal, treeNode, attributeName);
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
        // Find container element for the new link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
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
//          log.error(e);
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
//            content = schemaTransformer.getSchemaContentFromModel(inputTreeNode, schemaFile);
            content = schemaTransformer.getSchemaContentFromModel(inputTreeNode, schemaFile, true, content);  //.getSchemaContentFromModel(inputTreeNode, schemaFile);
        }
        // Empty tree node, clear the file
        else {
            content = "";
        }
        return content;
    }
    
    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("/Users/ayodhya/PycharmProjects/Data_mapping/files_java.json"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getMappings(String inputSchema, String outputSchema) {
        HttpURLConnection connection = null;  

        Gson gson = new Gson();
        String jsonIn = gson.toJson(inputSchema);
        String jsonOut = gson.toJson(outputSchema);
        
        final HttpClient httpClient = new HttpClient();
        
        // Send file1
        StringRequestEntity requestEntity;
        try {
            requestEntity = new StringRequestEntity(jsonIn,"application/json","UTF-8");
            PostMethod postMethod = new PostMethod("http://127.0.0.1:5000/uploader1");
            postMethod.setRequestEntity(requestEntity);
            try {
                int statusCode = httpClient.executeMethod(postMethod);
            } catch (HttpException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // send file2
        StringRequestEntity requestEntity2;
        try {
            requestEntity2 = new StringRequestEntity(jsonOut,"application/json","UTF-8");
            PostMethod postMethod2 = new PostMethod("http://127.0.0.1:5000/uploader2");
            postMethod2.setRequestEntity(requestEntity2);
            try {
                int statusCode = httpClient.executeMethod(postMethod2);
            } catch (HttpException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // receive answer
        String out = null;
        List<String> myList = null;
        HttpClient httpclient2 = new HttpClient();
        // Prepare a request object
        GetMethod httpget = new GetMethod("http://127.0.0.1:5000/answer");
        try{
            httpclient2.executeMethod(httpget);
            out = httpget.getResponseBodyAsString();
            myList = new ArrayList<String>(Arrays.asList(out.split("#")));
        }catch(Exception e) { 
            System.err.println(e); 
        }finally { 
            httpget.releaseConnection();
        }
        
        return myList;
    }
}
