/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DATAMAPPER_MEDIATOR_ICON_PATH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.OpenSeparatelyEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs.DialogDisplayUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs.ESBDataMapperConfigurationDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs.RegistryResourcesUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataMapperMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataMapperMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.GraphicalValidatorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProviderData;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.ui.startup.DataMapperEditor;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

/**
 * @generated NOT
 */
public class DataMapperMediatorEditPart extends FixedSizedAbstractMediator {

    private static final String DATAMAPPER_FILTER_TYPE = "application/datamapper"; //$NON-NLS-1$
    private static final String INPUT_AVROSCHEMA = "_inputSchema.json"; //$NON-NLS-1$
    private static final String OUTPUT_AVROSCHEMA = "_outputSchema.json"; //$NON-NLS-1$
    private static final String XSLT_AVROSTYLESHEET = "_xsltStyleSheet.xml";
    private static final String G_REG_PATH_PREFIX = "/_system/governance/"; //$NON-NLS-1$
    private static final String C_REG_PATH_PREFIX = "/_system/config/"; //$NON-NLS-1$
    private static final String G_REG_PREFIX = "gov:%s"; //$NON-NLS-1$
    private static final String C_REG_PREFIX = "conf:%s"; //$NON-NLS-1$
    private static final String DATAMAPPER_CONFIG_EXT = ".dmc"; //$NON-NLS-1$
    private static final String WARNING_TITLE = "Information";
    private static final String WARNING_MESSAGE_1 = "The resource ";
    private static final String WARNING_MESSAGE_2 = " could not be found in the workspace. Do you like to create a new configuration?";
    private static final String DATAMAPPER_PERSPECTIVE = "org.wso2.developerstudio.datamapper.diagram.custom.perspective";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private Class<?>[] type;
    private static Map<String, IDeveloperStudioElement> importListMap;

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3761;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    public DataMapperMediatorEditPart(View view) {
        super(view);

    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(EsbVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DataMapperMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DataMapperMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenSeparatelyEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated NOT
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
                case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new DataMapperMediatorFigure(new Color(null, 255, 255, 255)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                }
            };
        };
    }

    /**
     * @generated
     */
    public DataMapperMediatorFigure getPrimaryShape() {
        return (DataMapperMediatorFigure) primaryShape;
    }

    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DataMapperMediatorDescriptionEditPart) {
            ((DataMapperMediatorDescriptionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getDataMapperDescriptionLabel());
            return true;
        }
        if (childEditPart instanceof DataMapperMediatorInputConnectorEditPart) {
            IFigure borderItemFigure = ((DataMapperMediatorInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof DataMapperMediatorOutputConnectorEditPart) {
            IFigure borderItemFigure = ((DataMapperMediatorOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        return false;
    }

    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof LogMediatorDescriptionEditPart) {
            return true;
        }
        if (childEditPart instanceof DataMapperMediatorInputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((DataMapperMediatorInputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof DataMapperMediatorOutputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((DataMapperMediatorOutputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new ToolbarLayout(true));
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated NOT
     */
    public class DataMapperMediatorFigure extends EsbGraphicalShapeWithLabel {

        /**
         * @generated
         */
        private WrappingLabel fFigureDataMapperMediatorDescriptionFigure;

        private WrappingLabel fFigureDataMapperDescriptionLabel;

        /**
         * @generated
         */
        public DataMapperMediatorFigure(Color borderColor) {
            super(borderColor, false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        /**
         * @generated NOT
         */
        private void createContents() {
            fFigureDataMapperDescriptionLabel = getPropertyNameLabel();
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureDataMapperMediatorDescriptionFigure() {
            return fFigureDataMapperMediatorDescriptionFigure;
        }

        public WrappingLabel getDataMapperDescriptionLabel() {
            return fFigureDataMapperDescriptionLabel;
        }

        public String getIconPath() {
            return DATAMAPPER_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.DataMapperMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.DataMapperMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }

    }

    /**
     * @generated NOT
     */
    static final Color THIS_BACK = new Color(null, 230, 230, 230);

    public void openDataMapperDiagram() {
        // FIXME have to revisit this, think on seperation

        NodeImpl eobject = ((NodeImpl) this.getModel());
        final DataMapperMediatorImpl datamapper = (DataMapperMediatorImpl) eobject.getElement();

        Map<String, List<String>> filters = new HashMap<String, List<String>>();
        String mediaTypeKey = CSProviderConstants.FILTER_MEDIA_TYPE;
        List<String> types = new ArrayList<String>();
        types.add(DATAMAPPER_FILTER_TYPE); // FIXME we need to give this our mediatype like vnd.wso2.esb.datamapper
        filters.put(mediaTypeKey, types);

        if (datamapper.getConfiguration().getKeyValue().isEmpty()) {
            getCreateConfigurationDialog(datamapper, filters, null);
        } else {
            // Open the DataMapper Editor while double clicking on the DataMapperMediator
            String configName = getconfigName(datamapper);
            setType(new Class[] { IRegistryFile.class });
            IDeveloperStudioProviderData[] providerProjectsList = RegistryResourcesUtils.loadProviderProjectsList(type);
            String configLocalPath = getConfigurationLocalPath(providerProjectsList, filters, configName);
            if (StringUtils.isNotEmpty(configLocalPath)) {
                openDataMapperEditor(configLocalPath);
            } else {
                MessageDialog.openInformation(Display.getCurrent().getActiveShell(), WARNING_TITLE,
                        WARNING_MESSAGE_1 + "\"" + configName + "\"" + WARNING_MESSAGE_2);
                getCreateConfigurationDialog(datamapper, filters, configName);
            }
        }
    }

    /**
     * Gets the create configuration dialog
     * 
     * @param datamapper Datamapper Mediator
     * @param filters filter
     * @param configName
     */
    private void getCreateConfigurationDialog(final DataMapperMediatorImpl datamapper,
            Map<String, List<String>> filters, String configName) {
        // IRegistryFile class is only required for datamapper related filtering
        final ESBDataMapperConfigurationDialog dataMapperConfigurationDialog = new ESBDataMapperConfigurationDialog(
                Display.getCurrent().getActiveShell(), new Class[] { IRegistryFile.class }, filters, configName);
        dataMapperConfigurationDialog.create();

        DialogDisplayUtils.setPositionInCenter(dataMapperConfigurationDialog.getShell());

        if (dataMapperConfigurationDialog.open() == Dialog.OK) {
            String configurationPath = formatRegistryPath(dataMapperConfigurationDialog.getSelectedPath());
            String inputSchemaPath = configurationPath.replace(DATAMAPPER_CONFIG_EXT, INPUT_AVROSCHEMA);
            String outputSchemaPath = configurationPath.replace(DATAMAPPER_CONFIG_EXT, OUTPUT_AVROSCHEMA);
            String xsltStyleSheetPath = configurationPath.replace(DATAMAPPER_CONFIG_EXT, XSLT_AVROSTYLESHEET);

            final RegistryKeyProperty configurationKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            configurationKeyProperty.setKeyValue(configurationPath);

            final RegistryKeyProperty inputSchemaKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            inputSchemaKeyProperty.setKeyValue(inputSchemaPath);

            final RegistryKeyProperty outputSchemaKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            outputSchemaKeyProperty.setKeyValue(outputSchemaPath);

            final RegistryKeyProperty xsltStyleSheetKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
            xsltStyleSheetKeyProperty.setKeyValue(xsltStyleSheetPath);

            Display.getDefault().asyncExec(new Runnable() {

                public void run() {

                    TransactionalEditingDomain editingDomain = getEditingDomain();
                    String configLocalPath = dataMapperConfigurationDialog.getIPathOfSelection();
                    String inputSchemaLocalPath = configLocalPath.replace(DATAMAPPER_CONFIG_EXT, INPUT_AVROSCHEMA);
                    String outputSchemaLocalPath = configLocalPath.replace(DATAMAPPER_CONFIG_EXT, OUTPUT_AVROSCHEMA);
                    String xsltStyleSheetLocalPath = configLocalPath.replace(DATAMAPPER_CONFIG_EXT,
                            XSLT_AVROSTYLESHEET);

                    setConfigurationKey(datamapper, configurationKeyProperty, configLocalPath, editingDomain);
                    setInputSchemaKey(datamapper, inputSchemaKeyProperty, inputSchemaLocalPath, editingDomain);
                    setOutputSchemaKey(datamapper, outputSchemaKeyProperty, outputSchemaLocalPath, editingDomain);
                    setXSLTStyleSheetKey(datamapper, xsltStyleSheetKeyProperty, xsltStyleSheetLocalPath, editingDomain);

                    if (StringUtils.isNotEmpty(datamapper.getConfigurationLocalPath())) {
                        openDataMapperEditor(datamapper.getConfigurationLocalPath());
                    }

                }

                private void setOutputSchemaKey(DataMapperMediatorImpl datamapper,
                        RegistryKeyProperty registryKeyProperty, String localPath,
                        TransactionalEditingDomain editingDomain) {

                    SetCommand setCmd = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, registryKeyProperty);
                    if (setCmd.canExecute()) {
                        getEditingDomain().getCommandStack().execute(setCmd);
                    }

                    SetCommand setCmd2 = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH, localPath);
                    if (setCmd2.canExecute()) {
                        editingDomain.getCommandStack().execute(setCmd2);
                    }

                }

                private void setInputSchemaKey(DataMapperMediatorImpl datamapper,
                        RegistryKeyProperty registryKeyProperty, String localPath,
                        TransactionalEditingDomain editingDomain) {

                    SetCommand setCmd = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, registryKeyProperty);
                    if (setCmd.canExecute()) {
                        getEditingDomain().getCommandStack().execute(setCmd);
                    }

                    SetCommand setCmd2 = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH, localPath);
                    if (setCmd2.canExecute()) {
                        editingDomain.getCommandStack().execute(setCmd2);
                    }

                }

                private void setConfigurationKey(final DataMapperMediatorImpl datamapper,
                        final RegistryKeyProperty registryKeyProperty, String localPath,
                        TransactionalEditingDomain editingDomain) {

                    SetCommand setCmd = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION, registryKeyProperty);
                    if (setCmd.canExecute()) {
                        getEditingDomain().getCommandStack().execute(setCmd);
                    }

                    SetCommand setCmd2 = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH, localPath);
                    if (setCmd2.canExecute()) {
                        editingDomain.getCommandStack().execute(setCmd2);
                    }
                }

                private void setXSLTStyleSheetKey(final DataMapperMediatorImpl datamapper,
                        final RegistryKeyProperty registryKeyProperty, String localPath,
                        TransactionalEditingDomain editingDomain) {

                    SetCommand setCmd = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__XSLT_STYLE_SHEET, registryKeyProperty);
                    if (setCmd.canExecute()) {
                        getEditingDomain().getCommandStack().execute(setCmd);
                    }

                    SetCommand setCmd2 = new SetCommand(editingDomain, datamapper,
                            EsbPackage.Literals.DATA_MAPPER_MEDIATOR__XSLT_STYLE_SHEET_LOCAL_PATH, localPath);
                    if (setCmd2.canExecute()) {
                        editingDomain.getCommandStack().execute(setCmd2);
                    }
                }
            });
        }
    }

    /**
     * Gets the configuration name of the datamapper config
     * 
     * @param datamapper DataMapper Mediator object
     * @return configuration name
     */
    private String getconfigName(DataMapperMediatorImpl datamapper) {
        String configName = null;
        String regPath = datamapper.getConfiguration().getKeyValue();
        if (StringUtils.isNotEmpty(regPath)) {
            configName = regPath.substring(regPath.lastIndexOf("/") + 1, regPath.length());
        }
        return configName;
    }

    /**
     * Gets the configuration local path
     * 
     * @param providerProjectsList Provider Project list
     * @param filters filters
     * @param configName configuration name
     * @return configuration local path
     */
    public static String getConfigurationLocalPath(IDeveloperStudioProviderData[] providerProjectsList,
            Map<String, List<String>> filters, String configName) {

        String configPath = null;

        for (IDeveloperStudioProviderData data : providerProjectsList) {
            IDeveloperStudioProvider provider = data.getProvider();

            List<IDeveloperStudioProvider> registryProjectsList = RegistryResourcesUtils
                    .getRegistryProjectsList(provider, filters);
            importListMap = new HashMap<String, IDeveloperStudioElement>();

            for (IDeveloperStudioProvider registryProject : registryProjectsList) {
                List<IDeveloperStudioProvider> childrenList = RegistryResourcesUtils.getChildrenList(registryProject,
                        filters);

                for (IDeveloperStudioProvider child : childrenList) {
                    IDeveloperStudioElement childElement = child.getElements(filters)[0];
                    if (childElement.getName().equals(configName)) {
                        IPath fullPath = ((File) childElement.getSource()).getFullPath();
                        configPath = fullPath.toString();
                    }

                }
            }
        }
        return configPath;

    }

    public Class<?>[] getType() {
        return type;
    }

    public void setType(Class<?>[] type) {
        this.type = type;
    }

    private String formatRegistryPath(String selectedPath) {
        String formattedPath = selectedPath;
        if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
            formattedPath = String.format(G_REG_PREFIX, selectedPath.substring(G_REG_PATH_PREFIX.length()));
        } else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
            formattedPath = String.format(C_REG_PREFIX, selectedPath.substring(C_REG_PATH_PREFIX.length()));
        }
        return formattedPath;
    }

    /**
     * Opens the data mapper editor
     * 
     * @param localPath local path of the configuration
     */
    private void openDataMapperEditor(final String localPath) {
        Path path = new Path(localPath);
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        DataMapperEditor.open(file);
        try {
            PlatformUI.getWorkbench().showPerspective(DATAMAPPER_PERSPECTIVE,
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow());
            ProjectPresentation.setHierarchicalProjectPresentation();
        } catch (WorkbenchException e) {
            log.error("Error occurred while switching to ESB perspective " + e.getMessage());
        }
    }

    @Override
    public void notifyChanged(Notification notification) {
        // this.getModel() will get EMF datamodel of the enrich mediator datamodel
        if (notification.getEventType() == Notification.SET && this.getModel() instanceof CSSNodeImpl) {
            // The following part will check for validation issues with the current data in
            // the model
            CSSNodeImpl model = (CSSNodeImpl) this.getModel();
            if (model.getElement() instanceof DataMapperMediatorImpl) {
                DataMapperMediatorImpl dataMapperMediatorDataModel = (DataMapperMediatorImpl) model.getElement();
                try {
                    boolean isErroneous = false;
                    String configLocalPath = dataMapperMediatorDataModel.getConfiguration().getKeyValue();
                    if (configLocalPath == null || configLocalPath.equals("")) {
                        isErroneous = true;
                    }
                    if (!isErroneous) {
                        String inputSchemaLocalPath = dataMapperMediatorDataModel.getInputSchema().getKeyValue();
                        if (inputSchemaLocalPath == null || inputSchemaLocalPath.equals("")) {
                            isErroneous = true;
                        }
                    }
                    if (!isErroneous) {
                        String outSchemaLocalPath = dataMapperMediatorDataModel.getOutputSchema().getKeyValue();
                        if (outSchemaLocalPath == null || outSchemaLocalPath.equals("")) {
                            isErroneous = true;
                        }
                    }

                    if (isErroneous) {
                        GraphicalValidatorUtil.addValidationMark(this);
                    } else {
                        GraphicalValidatorUtil.removeValidationMark(this);
                    }
                } catch (Exception e) {
                    // Skip error since it's a validation related minor issue
                    log.error("Graphical validation error occured", e);
                }
            }
        }
        super.notifyChanged(notification);
    }

}
