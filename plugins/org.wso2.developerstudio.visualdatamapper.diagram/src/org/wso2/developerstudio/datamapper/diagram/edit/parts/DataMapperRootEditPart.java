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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.gmf.tooling.runtime.update.UpdateDiagramCommand;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ImageHolder;
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
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.JSEmbeddedFunctions;

/**
 * @generated
 */
public class DataMapperRootEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public final static String MODEL_ID = "DataMapper"; //$NON-NLS-1$
    
    private static final String URL_OF_AI_DATA_MAPPER_SERVER = "https://ai-data-mapper.wso2.com/uploader";
    
    private static final String EMPTY_STRING = "";
    
    private static final String ENABLE_AI_DATAMAPPER = "ENABLE_AI_DATAMAPPER";
    
    private static boolean isAIDataMapperEnabled = false;

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
     * This method reads the ENABLE_AI_DATAMAPPER property from properties file.
     * 
     * @return value of the ENABLE_AI_DATAMAPPER property
     */
    public static boolean getEnableAIDataMapperParameterValue() {

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        String configFilePath = workspaceDirectory.getAbsolutePath() + JSEmbeddedFunctions.getPropertiesFilePath();
        File confFile = new File(configFilePath);

        if (confFile.exists()) {
            try (InputStream input = new FileInputStream(configFilePath)) {
                Properties prop = new Properties();
                prop.load(input);
                return Boolean.parseBoolean(prop.getProperty(ENABLE_AI_DATAMAPPER));
            } catch (IOException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * This method writes given value to ENABLE_AI_DATAMAPPER property in properties file.
     * 
     * @param enableAIDataMapper value to set
     */
    private static void setEnableAIDataMapperParameterValue(boolean enableAIDataMapper) {

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        File workspaceDirectory = workspace.getRoot().getLocation().toFile();
        String configFilePath = workspaceDirectory.getAbsolutePath() + JSEmbeddedFunctions.getPropertiesFilePath();

        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(input);
            input.close();
            prop.setProperty(ENABLE_AI_DATAMAPPER, String.valueOf(enableAIDataMapper));
            output = new FileOutputStream(configFilePath);
            prop.store(output, null);
            output.close();
        } catch (IOException e) {
            log.error("Error ocuured while saving the ENABLE_AI_DATAMAPPER property.", e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                log.error("Error ocuured while saving the ENABLE_AI_DATAMAPPER property.", e);
            }
        }
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

        // Add AI based datamapper button to the canvas.
        RectangleFigure aiDataMapperLabelBox = new RectangleFigure();
        aiDataMapperLabelBox.setBackgroundColor(new Color(null, 232, 234, 237));
        aiDataMapperLabelBox.setLocation(new Point(90, 0));
        aiDataMapperLabelBox.setSize(new Dimension(480, 40));
        LineBorder border = new LineBorder();
        border.setColor(new Color(null, 245, 246, 247));
        aiDataMapperLabelBox.setBorder(border);

        Label aiDataMapperLabel = new Label("AI generated data mappings available.");
        aiDataMapperLabel.setSize(new Dimension(600, 40));
        aiDataMapperLabel.setLocation(new Point(-30, 0));

        Image applyBtnImage = ImageHolder.getInstance().getAddAIDataMappingImage();
        ImageFigure aiDataMapperLabelBtn = new ImageFigure(applyBtnImage);
        aiDataMapperLabelBtn.setSize(new Dimension(200, 30));
        aiDataMapperLabelBtn.setLocation(new Point(360, 5));

        // This block checks whether the input and output empty and make ai data mapping visible accordingly
        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) this.getDiagramView().getDiagram().getElement();

        int inputSize = datamapperRoot.getInput().getTreeNode().size();
        int outputSize = datamapperRoot.getOutput().getTreeNode().size();
        datamapperRoot.setAiDataMapperButton(aiDataMapperLabelBtn);
        datamapperRoot.setAiDataMapperLabel(aiDataMapperLabel);
        datamapperRoot.setAiDataMapperLabelBox(aiDataMapperLabelBox);
        FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
        datamapperRoot.setCanvas(canvas);
        datamapperRoot.setFigure(figure);

        if ((inputSize == 0) || (outputSize == 0)) {
            aiDataMapperLabelBtn.setVisible(false);
            aiDataMapperLabel.setVisible(false);
            aiDataMapperLabelBox.setVisible(false);
        }

        aiDataMapperLabelBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                try {
                    if (getIsAIDataMapperEnabled()) {
                        drawMappings();
                    }
                } catch (ConnectTimeoutException e) {
                    log.error("Connecting to the service timed out", e);
                    popupDialogBox(IStatus.ERROR, "Cannot connect to the service.");
                } catch (SocketTimeoutException e) {
                    log.error("Generation of AI Mapping timed out", e);
                    popupDialogBox(IStatus.ERROR, "Mapping generation takes too long.");
                } catch (IOException | InvocationTargetException | InterruptedException e) {
                    log.error("Error getting mapping suggestions from the server", e);
                    popupDialogBox(IStatus.ERROR, e.getMessage());
                }
            }

            @Override
            public void mouseDoubleClicked(MouseEvent me) {
            }
        });

        return figure;
    }
    
    class DialogWithCheckBox extends MessageDialog {

        private boolean checked;

        /**
         * This method initialize the DialogWithCheckBox class.
         * 
         * @param parentShell shell of the parent
         * @param dialogTitle Title of the message dialog
         * @param dialogTitleImage Image to be shown in the title
         * @param dialogMessage message to be shown
         * @param dialogImageType type of the message
         * @param dialogButtonLabels Label text of two buttons
         * @param defaultIndex default button to be selected
         */
        public DialogWithCheckBox(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
                int dialogImageType, String[] dialogButtonLabels, int defaultIndex) {
            super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels,
                    defaultIndex);
            checked = false;
        }

        /**
         * This method return whether checkbox is selected or not.
         * 
         * @return is check box selected
         */
        public boolean isChecked() {
            return checked;
        }

        /* (non-Javadoc)
         * This method overrides the empty createCustomArea to create the custom area.
         * A checkbox button is added to the custom area.
         * 
         * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
         */
        @Override
        protected Control createCustomArea(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            GridLayout layout = new GridLayout();
            layout.marginHeight = 0;
            layout.marginWidth = 0;
            composite.setLayout(layout);
            Button button = new Button(composite, SWT.CHECK);
            button.setText("Don't show this again");
            button.addSelectionListener(new SelectionListener() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    checked = !checked;
                }

                @Override
                public void widgetDefaultSelected(SelectionEvent e) {
                    // TODO Auto-generated method stub
                }
            });
            return composite;
        }
    }
    
    /**
     * This class connects to the ai datamapper server to obtain generated mappings.
     */
    class DataMapperServiceCaller implements IRunnableWithProgress {
        List<String> mappings;
        String inputContent;
        String outputContent;
        IOException error = null;
        IProgressMonitor monitor;

        /**
         * This is the constructor of the DataMapperServiceCaller class.
         * 
         * @param inputContent the input message to be mapped
         * @param outputContent the output message to be mapped
         */
        public DataMapperServiceCaller(String inputContent, String outputContent) {
            this.inputContent = inputContent;
            this.outputContent = outputContent;
        }
        
        /**
         * This is the getter method of IOException.
         * 
         * @return exception caused while connecting to the server
         */
        public IOException getError() {
            return error;
        }

        /**
         * This is the getter method of mappings.
         * 
         * @return mappings received from the server.
         */
        public List<String> getMappings() {
            return mappings;
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
        public List<String> getMappingsFromTheServer(String inputSchema, String outputSchema)
                throws HttpException, IOException {
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

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            monitor.beginTask("Generating AI based mappings", 4);
            monitor.worked(3);
            this.monitor = monitor;
            try {
                mappings = getMappingsFromTheServer(inputContent, outputContent);
            } catch (IOException e) {
                error = e;
            }
            monitor.done();
        }

        /**
         * This is the getter method of monitor.
         * 
         * @return progress monitor worked during the execution of operation
         */
        public IProgressMonitor getMonitor() {
            return monitor;
        }
    }

    /**
     * This method returns the variable isAIDataMapperEnabled.
     * If isAIDataMapperEnabled is false, it reads value from the properties file.
     * If value in the properties folder is false, a dialog is prompt to user to enable AIDataMapper.
     * 
     * @return isAIDataMapperEnabled
     */
    public boolean getIsAIDataMapperEnabled() {
        if (!isAIDataMapperEnabled) {
            if (getEnableAIDataMapperParameterValue()) {
                isAIDataMapperEnabled = true;
            } else {
                DialogWithCheckBox dialog = new DialogWithCheckBox(Display.getDefault().getActiveShell(),
                        "Permission to upload data", null,
                        "Your data will be uploaded to an internal WSO2 server to process the data mapping. WSO2 does not store the data.",
                        MessageDialog.INFORMATION, new String[] { "Proceed", "Cancel" }, 0);
                int choice = dialog.open();
                if (choice == 0) {
                    if (dialog.isChecked()) {
                        isAIDataMapperEnabled = true;
                        setEnableAIDataMapperParameterValue(isAIDataMapperEnabled);
                    } else {
                        return true;
                    }
                }
            }
        }
        return isAIDataMapperEnabled;
    }
    
    /**
     * This method draws datamapper configurations automatically.
     * 
     * @throws InterruptedException 
     * @throws InvocationTargetException 
     * @throws IOException 
     * @throws Exception 
     */
    public void drawMappings() throws InvocationTargetException, InterruptedException, IOException {
        DataMapperRootImpl datamapperRoot = (DataMapperRootImpl) this.getDiagramView().getDiagram().getElement();
        final Diagram datamapperDiagram = (Diagram) this.getDiagramView().getDiagram();
        
        // Get input and output schemas
        final String inputContent = getSchema(datamapperRoot, "input");
        final String outputContent = getSchema(datamapperRoot, "output");

        DataMapperServiceCaller dataMapperServiceCaller = new DataMapperServiceCaller(inputContent, outputContent);
        ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
        progressDialog.run(true, true, dataMapperServiceCaller);
        
        // Throws any error while connecting to the ai datamapper server. 
        if (dataMapperServiceCaller.getError() != null) {
            throw dataMapperServiceCaller.getError();
        }

        // Check if user has canceled mapping generation.
        if (dataMapperServiceCaller.getMonitor().isCanceled()) {
            return;
        }
        
        List<String> mappings = dataMapperServiceCaller.getMappings();
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
                                
                                final EList transientChildern = datamapperDiagram.getTransientChildren();
                                recursivePersistance(transientChildern);
                                final EList persistantChildern = datamapperDiagram.getPersistedChildren();
                                recursivePersistance(persistantChildern);
                                datamapperDiagram.getDiagram().persistChildren();
                                datamapperDiagram.getDiagram().persistEdges();
                            }
                        });
                        
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            
            FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
            canvas.getViewport().repaint();
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
    
    private void recursivePersistance(EList childern) {
        for (Object child : childern) {
            if (child instanceof CSSShapeImpl) {
                EList childTransientSet = ((CSSShapeImpl) child).getTransientChildren();
                if (childTransientSet != null && childTransientSet.size() > 0) {
                    recursivePersistance(childTransientSet);
                }

                EList childPersistedSet = ((CSSShapeImpl) child).getPersistedChildren();
                if (childPersistedSet != null && childPersistedSet.size() > 0) {
                    recursivePersistance(childPersistedSet);
                }
                ((CSSShapeImpl) child).persistChildren();
            }
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
