/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.ENDPOINT_RESOURCE_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SEQUENCE_RESOURCE_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.updateToolpalette;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractProxyServiceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ToolPalleteDetails;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.NamedEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceFaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated
 */
public class EsbPaletteFactory {

    public static final int INITIAL_STATE_OPEN = 0, INITIAL_STATE_CLOSED = 1, INITIAL_STATE_PINNED_OPEN = 2;
    
    private static final String CLOUD_CONNECTOR_PREFIX = "CloudConnector-";
    
    private static final String FILE_PROTOCOL_PREFIX = "file:///";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private static HashMap<String, ImageDescriptor> imageDescriptorMap = new HashMap<String, ImageDescriptor>();

    /**
     * @generated NOT
     */
    public void fillPalette(PaletteRoot paletteRoot) {

        // open the perspective "wso2 esb graphical"
        // TODO review if this is the best place for switching

        // Reason for handling this error - If any runtime error occur while getting the perspective id then ESB editor
        // should be open in a normal way
        try {
            IWorkbench workbench = PlatformUI.getWorkbench();
            IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
            IPerspectiveDescriptor perspective = window.getActivePage().getPerspective();
            if ("org.wso2.developerstudio.registry.remote.registry.apim.pespective".equals(perspective.getId())) {
                paletteRoot.add(createNodes1Group());
                paletteRoot.add(createMediatorsAPIMGroup());
                paletteRoot.add(createEndPoints3Group());
                paletteRoot.add(createLinks4Group());
            } else {
                paletteRoot.add(createNodes1Group());
                paletteRoot.add(createMediators2Group());
                paletteRoot.add(createEndPoints3Group());
                paletteRoot.add(createLinks4Group());
            }
        } catch (Exception e) {
            log.error("Error occur while obtaining the perspective Id " + e.getMessage(), e);
            // If any error occur while obtaining the perspective Id then the ESB editor loads in a normal way
            paletteRoot.add(createNodes1Group());
            paletteRoot.add(createMediators2Group());
            paletteRoot.add(createEndPoints3Group());
            paletteRoot.add(createLinks4Group());
        }

        // paletteRoot.add(createHelpers5Group());
        // paletteRoot.add(createCloudConnectors6Group());
    }

    /**
     * Creates "Nodes" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createNodes1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
        paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
        // paletteContainer.add(createEsbServer1CreationTool());
        paletteContainer.add(createProxyService2CreationTool());
        // paletteContainer.add(createMessageMediator3CreationTool());
        paletteContainer.add(createAPIResource5CreationTool());
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    /**
     * Creates "Mediators" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createMediators2Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Mediators2Group_title);
        paletteContainer.setId("createMediators2Group"); //$NON-NLS-1$

        paletteContainer.add(createCallMediator46CreationTool());
        paletteContainer.add(createCallTemplateMediator33CreationTool());
        paletteContainer.add(createDropMediator1CreationTool());
        paletteContainer.add(createLogMediator3CreationTool());
        paletteContainer.add(createLoopBackMediator44CreationTool());
        paletteContainer.add(createPropertyMediator4CreationTool());
        paletteContainer.add(createPropertyGroupMediator5CreationTool());
        paletteContainer.add(createRespondMediator45CreationTool());
        paletteContainer.add(createSendMediator20CreationTool());
        paletteContainer.add(createSequence4CreationTool());
        paletteContainer.add(createStoreMediator31CreationTool());

        // Core Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Core"));

        paletteContainer.add(createConditionalRouterMediator40CreationTool());
        paletteContainer.add(createFilterMediator2CreationTool());
        paletteContainer.add(createSwitchMediator8CreationTool());
        paletteContainer.add(createValidateMediator38CreationTool());

        // Filter Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Filter"));

        paletteContainer.add(createBeanMediator42CreationTool());
        paletteContainer.add(createClassMediator11CreationTool());
        paletteContainer.add(createCommandMediator16CreationTool());
        paletteContainer.add(createEJBMediator43CreationTool());
        paletteContainer.add(createScriptMediator13CreationTool());
        paletteContainer.add(createSpringMediator12CreationTool());

        // Extension Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Extension"));

        paletteContainer.add(createEnrichMediator6CreationTool());
        paletteContainer.add(createFaultMediator14CreationTool());
        paletteContainer.add(createHeaderMediator21CreationTool());
        paletteContainer.add(createPayloadFactoryMediator35CreationTool());
        paletteContainer.add(createSmooksMediator19CreationTool());
        paletteContainer.add(createURLRewriteMediator37CreationTool());
        paletteContainer.add(createXQueryMediator15CreationTool());
        paletteContainer.add(createXSLTMediator7CreationTool());
        paletteContainer.add(createDataMapperMediator47CreationTool()); // enabled
        paletteContainer.add(createFastXSLTMediator48CreationTool());
        paletteContainer.add(createJsonTransformMediator50CreationTool());

        // Transform Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Transform"));

        paletteContainer.add(createCacheMediator24CreationTool());
        paletteContainer.add(createDBLookupMediator17CreationTool());
        paletteContainer.add(createDBReportMediator18CreationTool());
        paletteContainer.add(createEnqueueMediator36CreationTool());
        paletteContainer.add(createEventMediator9CreationTool());
        // paletteContainer.add(createRMSequenceMediator28CreationTool());
        paletteContainer.add(createThrottleMediator28CreationTool());
        paletteContainer.add(createTransactionMediator27CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced"));

        paletteContainer.add(createAggregateMediator25CreationTool());
        paletteContainer.add(createCalloutMediator26CreationTool());
        paletteContainer.add(createCloneMediator22CreationTool());
        paletteContainer.add(createIterateMediator23CreationTool());
        paletteContainer.add(createForEachMediator7CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced1"));

        paletteContainer.add(createEntitlementMediator10CreationTool());
        paletteContainer.add(createOAuthMediator30CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced2"));

        // paletteContainer.add(createRouterMediator38CreationTool()); removed as requested in TOOLS-1800
        paletteContainer.add(createBuilderMediator32CreationTool());
        paletteContainer.add(createRuleMediator31CreationTool());

        // Agent Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Agent"));

        paletteContainer.add(createBAMMediator41CreationTool());
        paletteContainer.add(createPublishEventMediator49CreationTool());

        paletteContainer.setInitialState(INITIAL_STATE_PINNED_OPEN);
        return paletteContainer;
    }

    /**
     * Creates "Mediators" palette tool for APIM group
     * 
     * @generated NOT
     */
    private PaletteContainer createMediatorsAPIMGroup() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Mediators2Group_title);
        paletteContainer.setId("createMediatorsAPIMGroup"); //$NON-NLS-1$
        paletteContainer.add(createCallMediator46CreationTool());
        // paletteContainer.add(createCallTemplateMediator33CreationTool());
        paletteContainer.add(createDropMediator1CreationTool());
        paletteContainer.add(createLogMediator3CreationTool());
        // paletteContainer.add(createLoopBackMediator43CreationTool());
        paletteContainer.add(createPropertyMediator4CreationTool());
        paletteContainer.add(createPropertyGroupMediator5CreationTool());
        // paletteContainer.add(createRespondMediator44CreationTool());
        // paletteContainer.add(createSendMediator19CreationTool());
        paletteContainer.add(createSequence4CreationTool());
        // paletteContainer.add(createStoreMediator31CreationTool());

        // Core Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Core"));

        paletteContainer.add(createConditionalRouterMediator40CreationTool());
        paletteContainer.add(createFilterMediator2CreationTool());
        paletteContainer.add(createSwitchMediator8CreationTool());
        paletteContainer.add(createValidateMediator38CreationTool());

        // Filter Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Filter"));

        // paletteContainer.add(createBeanMediator41CreationTool());
        paletteContainer.add(createClassMediator11CreationTool());
        // paletteContainer.add(createCommandMediator15CreationTool());
        // paletteContainer.add(createEJBMediator42CreationTool());
        paletteContainer.add(createScriptMediator13CreationTool());
        // paletteContainer.add(createSpringMediator11CreationTool());

        // Extension Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Extension"));

        paletteContainer.add(createEnrichMediator6CreationTool());
        paletteContainer.add(createFaultMediator14CreationTool());
        paletteContainer.add(createHeaderMediator21CreationTool());
        paletteContainer.add(createPayloadFactoryMediator35CreationTool());
        // paletteContainer.add(createSmooksMediator18CreationTool());
        paletteContainer.add(createURLRewriteMediator37CreationTool());
        paletteContainer.add(createXQueryMediator15CreationTool());
        paletteContainer.add(createXSLTMediator7CreationTool());
        paletteContainer.add(createDataMapperMediator47CreationTool()); // enabled
        paletteContainer.add(createFastXSLTMediator48CreationTool());
        paletteContainer.add(createJsonTransformMediator50CreationTool());

        // Transform Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Transform"));

        paletteContainer.add(createCacheMediator24CreationTool());
        paletteContainer.add(createDBLookupMediator17CreationTool());
        paletteContainer.add(createDBReportMediator18CreationTool());
        paletteContainer.add(createEnqueueMediator36CreationTool());
        paletteContainer.add(createEventMediator9CreationTool());
        // paletteContainer.add(createRMSequenceMediator28CreationTool());
        paletteContainer.add(createThrottleMediator28CreationTool());
        paletteContainer.add(createTransactionMediator27CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced"));

        paletteContainer.add(createAggregateMediator25CreationTool());
        paletteContainer.add(createCalloutMediator26CreationTool());
        paletteContainer.add(createCloneMediator22CreationTool());
        paletteContainer.add(createIterateMediator23CreationTool());
        paletteContainer.add(createForEachMediator7CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced1"));

        paletteContainer.add(createEntitlementMediator10CreationTool());
        // paletteContainer.add(createOAuthMediator29CreationTool());

        // Advanced Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Advanced2"));

        // paletteContainer.add(createRouterMediator38CreationTool()); removed as requested in TOOLS-1800
        paletteContainer.add(createBuilderMediator32CreationTool());
        // paletteContainer.add(createRuleMediator30CreationTool());

        // Agent Mediator Category separator.
        paletteContainer.add(new PaletteSeparator("Agent"));

        paletteContainer.add(createBAMMediator41CreationTool());
        paletteContainer.add(createPublishEventMediator49CreationTool());

        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    /**
     * Creates "EndPoints" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createEndPoints3Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.EndPoints3Group_title);
        paletteContainer.setId("createEndPoints3Group"); //$NON-NLS-1$
        paletteContainer.add(createAddressEndPoint2CreationTool());
        // paletteContainer.add(createAddressingEndpoint7CreationTool());
        paletteContainer.add(createDefaultEndPoint1CreationTool());
        paletteContainer.add(createFailoverEndPoint3CreationTool());
        paletteContainer.add(createHTTPEndpoint9CreationTool());
        paletteContainer.add(createLoadBalanceEndPoint5CreationTool());
        paletteContainer.add(createNamedEndpoint6CreationTool());
        paletteContainer.add(createRecipientListEndPoint8CreationTool());
        paletteContainer.add(createTemplateEndpoint10CreationTool());
        paletteContainer.add(createWSDLEndPoint4CreationTool());
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    /**
     * Creates "Links" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createLinks4Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links4Group_title);
        paletteContainer.setId("createLinks4Group"); //$NON-NLS-1$
        paletteContainer.add(createEsbLink1CreationTool());
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    /**
     * Creates "Helpers" palette tool group
     * 
     * @generated
     */
    private PaletteContainer createHelpers5Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Helpers5Group_title);
        paletteContainer.setId("createHelpers5Group"); //$NON-NLS-1$
        paletteContainer.add(createMergeNode1CreationTool());
        return paletteContainer;
    }

    /**
     * Creates "Cloud Connectors" palette tool group
     * 
     * @generated NOT
     */
    private PaletteContainer createCloudConnectors6Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.CloudConnectors6Group_title);
        paletteContainer.setId("createCloudConnectors6Group"); //$NON-NLS-1$
        // paletteContainer.add(createCloudConnector1CreationTool());
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createEsbServer1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EsbServer1CreationTool_title,
                Messages.EsbServer1CreationTool_desc, Collections.singletonList(EsbElementTypes.EsbServer_2001));
        entry.setId("createEsbServer1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EsbServer_2001));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createProxyService2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ProxyService2CreationTool_title,
                Messages.ProxyService2CreationTool_desc, Collections.singletonList(EsbElementTypes.ProxyService_3001));
        entry.setId("createProxyService2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ProxyService_3001));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createMessageMediator3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.MessageMediator3CreationTool_title,
                Messages.MessageMediator3CreationTool_desc,
                Collections.singletonList(EsbElementTypes.MessageMediator_3045));
        entry.setId("createMessageMediator3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.MessageMediator_3045));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSequence4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Sequence4CreationTool_title,
                Messages.Sequence4CreationTool_desc, Collections.singletonList(EsbElementTypes.Sequence_3503));
        entry.setId("createSequence4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.Sequence_3503));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAPIResource5CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.APIResource5CreationTool_title,
                Messages.APIResource5CreationTool_desc, Collections.singletonList(EsbElementTypes.APIResource_3669));
        entry.setId("createAPIResource5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.APIResource_3669));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCloudConnectorOperation6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CloudConnectorOperation6CreationTool_title,
                Messages.CloudConnectorOperation6CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CloudConnectorOperation_3722));
        entry.setId("createCloudConnectorOperation6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CloudConnectorOperation_3722));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createForEachMediator7CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ForEachMediator7CreationTool_title,
                Messages.ForEachMediator7CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ForEachMediator_3780));
        entry.setId("createForEachMediator7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ForEachMediator_3780));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createPublishEventMediatorInputConnector8CreationTool() {
        ToolEntry entry = new ToolEntry(Messages.PublishEventMediatorInputConnector8CreationTool_title,
                Messages.PublishEventMediatorInputConnector8CreationTool_desc, null, null) {
        };
        entry.setId("createPublishEventMediatorInputConnector8CreationTool"); //$NON-NLS-1$
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createPublishEventMediatorOutputConnector9CreationTool() {
        ToolEntry entry = new ToolEntry(Messages.PublishEventMediatorOutputConnector9CreationTool_title,
                Messages.PublishEventMediatorOutputConnector9CreationTool_desc, null, null) {
        };
        entry.setId("createPublishEventMediatorOutputConnector9CreationTool"); //$NON-NLS-1$
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createDropMediator1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.DropMediator1CreationTool_title,
                Messages.DropMediator1CreationTool_desc, Collections.singletonList(EsbElementTypes.DropMediator_3491));
        entry.setId("createDropMediator1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.DropMediator_3491));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createFilterMediator2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.FilterMediator2CreationTool_title,
                Messages.FilterMediator2CreationTool_desc,
                Collections.singletonList(EsbElementTypes.FilterMediator_3494));
        entry.setId("createFilterMediator2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.FilterMediator_3494));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLogMediator3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.LogMediator3CreationTool_title,
                Messages.LogMediator3CreationTool_desc, Collections.singletonList(EsbElementTypes.LogMediator_3495));
        entry.setId("createLogMediator3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.LogMediator_3495));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createPropertyMediator4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.PropertyMediator4CreationTool_title,
                Messages.PropertyMediator4CreationTool_desc,
                Collections.singletonList(EsbElementTypes.PropertyMediator_3492));
        entry.setId("createPropertyMediator4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.PropertyMediator_3492));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated NOT
    */
    private ToolEntry createPropertyGroupMediator5CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.PropertyGroupMediator5CreationTool_title,
                Messages.PropertyGroupMediator5CreationTool_desc,
                Collections.singletonList(EsbElementTypes.PropertyGroupMediator_3788));
        entry.setId("createPropertyGroupMediator5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.PropertyGroupMediator_3788));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createEnrichMediator6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EnrichMediator6CreationTool_title,
                Messages.EnrichMediator6CreationTool_desc,
                Collections.singletonList(EsbElementTypes.EnrichMediator_3496));
        entry.setId("createEnrichMediator6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EnrichMediator_3496));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createXSLTMediator7CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.XSLTMediator7CreationTool_title,
                Messages.XSLTMediator7CreationTool_desc,
                Collections.singletonList(EsbElementTypes.XSLTMediator_3497));
        entry.setId("createXSLTMediator7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.XSLTMediator_3497));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createSwitchMediator8CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SwitchMediator8CreationTool_title,
                Messages.SwitchMediator8CreationTool_desc,
                Collections.singletonList(EsbElementTypes.SwitchMediator_3498));
        entry.setId("createSwitchMediator8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.SwitchMediator_3498));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createEventMediator9CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EventMediator9CreationTool_title,
                Messages.EventMediator9CreationTool_desc,
                Collections.singletonList(EsbElementTypes.EventMediator_3504));
        entry.setId("createEventMediator9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EventMediator_3504));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createEntitlementMediator10CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EntitlementMediator10CreationTool_title,
                Messages.EntitlementMediator10CreationTool_desc,
                Collections.singletonList(EsbElementTypes.EntitlementMediator_3505));
        entry.setId("createEntitlementMediator10CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EntitlementMediator_3505));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createClassMediator11CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ClassMediator11CreationTool_title,
                Messages.ClassMediator11CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ClassMediator_3506));
        entry.setId("createClassMediator11CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ClassMediator_3506));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createSpringMediator12CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SpringMediator12CreationTool_title,
                Messages.SpringMediator12CreationTool_desc,
                Collections.singletonList(EsbElementTypes.SpringMediator_3507));
        entry.setId("createSpringMediator12CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.SpringMediator_3507));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createScriptMediator13CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ScriptMediator13CreationTool_title,
                Messages.ScriptMediator13CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ScriptMediator_3508));
        entry.setId("createScriptMediator13CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ScriptMediator_3508));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createFaultMediator14CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.FaultMediator14CreationTool_title,
                Messages.FaultMediator14CreationTool_desc,
                Collections.singletonList(EsbElementTypes.FaultMediator_3509));
        entry.setId("createFaultMediator14CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.FaultMediator_3509));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createXQueryMediator15CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.XQueryMediator15CreationTool_title,
                Messages.XQueryMediator15CreationTool_desc,
                Collections.singletonList(EsbElementTypes.XQueryMediator_3510));
        entry.setId("createXQueryMediator15CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.XQueryMediator_3510));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCommandMediator16CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CommandMediator16CreationTool_title,
                Messages.CommandMediator16CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CommandMediator_3511));
        entry.setId("createCommandMediator16CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CommandMediator_3511));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createDBLookupMediator17CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.DBLookupMediator17CreationTool_title,
                Messages.DBLookupMediator17CreationTool_desc,
                Collections.singletonList(EsbElementTypes.DBLookupMediator_3512));
        entry.setId("createDBLookupMediator17CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.DBLookupMediator_3512));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createDBReportMediator18CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.DBReportMediator18CreationTool_title,
                Messages.DBReportMediator18CreationTool_desc,
                Collections.singletonList(EsbElementTypes.DBReportMediator_3513));
        entry.setId("createDBReportMediator18CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.DBReportMediator_3513));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createSmooksMediator19CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SmooksMediator19CreationTool_title,
                Messages.SmooksMediator19CreationTool_desc,
                Collections.singletonList(EsbElementTypes.SmooksMediator_3514));
        entry.setId("createSmooksMediator19CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.SmooksMediator_3514));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createSendMediator20CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SendMediator20CreationTool_title,
                Messages.SendMediator20CreationTool_desc,
                Collections.singletonList(EsbElementTypes.SendMediator_3515));
        entry.setId("createSendMediator20CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.SendMediator_3515));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createHeaderMediator21CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.HeaderMediator21CreationTool_title,
                Messages.HeaderMediator21CreationTool_desc,
                Collections.singletonList(EsbElementTypes.HeaderMediator_3516));
        entry.setId("createHeaderMediator21CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.HeaderMediator_3516));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCloneMediator22CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CloneMediator22CreationTool_title,
                Messages.CloneMediator22CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CloneMediator_3517));
        entry.setId("createCloneMediator22CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CloneMediator_3517));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createIterateMediator23CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.IterateMediator23CreationTool_title,
                Messages.IterateMediator23CreationTool_desc,
                Collections.singletonList(EsbElementTypes.IterateMediator_3519));
        entry.setId("createIterateMediator23CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.IterateMediator_3519));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCacheMediator24CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CacheMediator24CreationTool_title,
                Messages.CacheMediator24CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CacheMediator_3518));
        entry.setId("createCacheMediator24CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CacheMediator_3518));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createAggregateMediator25CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.AggregateMediator25CreationTool_title,
                Messages.AggregateMediator25CreationTool_desc,
                Collections.singletonList(EsbElementTypes.AggregateMediator_3525));
        entry.setId("createAggregateMediator25CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.AggregateMediator_3525));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCalloutMediator26CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CalloutMediator26CreationTool_title,
                Messages.CalloutMediator26CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CalloutMediator_3520));
        entry.setId("createCalloutMediator26CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CalloutMediator_3520));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createTransactionMediator27CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.TransactionMediator27CreationTool_title,
                Messages.TransactionMediator27CreationTool_desc,
                Collections.singletonList(EsbElementTypes.TransactionMediator_3521));
        entry.setId("createTransactionMediator27CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.TransactionMediator_3521));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createThrottleMediator28CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ThrottleMediator28CreationTool_title,
                Messages.ThrottleMediator28CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ThrottleMediator_3493));
        entry.setId("createThrottleMediator28CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ThrottleMediator_3493));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createRMSequenceMediator29CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.RMSequenceMediator29CreationTool_title,
                Messages.RMSequenceMediator29CreationTool_desc,
                Collections.singletonList(EsbElementTypes.RMSequenceMediator_3522));
        entry.setId("createRMSequenceMediator29CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.RMSequenceMediator_3522));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createOAuthMediator30CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.OAuthMediator30CreationTool_title,
                Messages.OAuthMediator30CreationTool_desc,
                Collections.singletonList(EsbElementTypes.OAuthMediator_3524));
        entry.setId("createOAuthMediator30CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.OAuthMediator_3524));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createRuleMediator31CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.RuleMediator31CreationTool_title,
                Messages.RuleMediator31CreationTool_desc, Collections.singletonList(EsbElementTypes.RuleMediator_3523));
        entry.setId("createRuleMediator30CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.RuleMediator_3523));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createStoreMediator32CreationTool() {
        ToolEntry entry = new ToolEntry(Messages.StoreMediator32CreationTool_title,
                Messages.StoreMediator32CreationTool_desc, null, null) {
        };
        entry.setId("createStoreMediator32CreationTool"); //$NON-NLS-1$
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createBuilderMediator33CreationTool() {
        ToolEntry entry = new ToolEntry(Messages.BuilderMediator33CreationTool_title,
                Messages.BuilderMediator33CreationTool_desc, null, null) {
        };
        entry.setId("createBuilderMediator33CreationTool"); //$NON-NLS-1$
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCallTemplateMediator34CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CallTemplateMediator34CreationTool_title,
                Messages.CallTemplateMediator34CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CallTemplateMediator_3594));
        entry.setId("createCallTemplateMediator34CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CallTemplateMediator_3594));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createPayloadFactoryMediator35CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.PayloadFactoryMediator35CreationTool_title,
                Messages.PayloadFactoryMediator35CreationTool_desc,
                Collections.singletonList(EsbElementTypes.PayloadFactoryMediator_3597));
        entry.setId("createPayloadFactoryMediator35CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.PayloadFactoryMediator_3597));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createEnqueueMediator36CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EnqueueMediator36CreationTool_title,
                Messages.EnqueueMediator36CreationTool_desc,
                Collections.singletonList(EsbElementTypes.EnqueueMediator_3600));
        entry.setId("createEnqueueMediator36CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EnqueueMediator_3600));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createURLRewriteMediator37CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.URLRewriteMediator37CreationTool_title,
                Messages.URLRewriteMediator37CreationTool_desc,
                Collections.singletonList(EsbElementTypes.URLRewriteMediator_3620));
        entry.setId("createURLRewriteMediator37CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.URLRewriteMediator_3620));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createValidateMediator38CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ValidateMediator38CreationTool_title,
                Messages.ValidateMediator38CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ValidateMediator_3623));
        entry.setId("createValidateMediator38CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ValidateMediator_3623));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createRouterMediator39CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.RouterMediator39CreationTool_title,
                Messages.RouterMediator39CreationTool_desc,
                Collections.singletonList(EsbElementTypes.RouterMediator_3628));
        entry.setId("createRouterMediator39CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.RouterMediator_3628));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createConditionalRouterMediator40CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ConditionalRouterMediator40CreationTool_title,
                Messages.ConditionalRouterMediator40CreationTool_desc,
                Collections.singletonList(EsbElementTypes.ConditionalRouterMediator_3635));
        entry.setId("createConditionalRouterMediator40CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.ConditionalRouterMediator_3635));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createBAMMediator41CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.BAMMediator41CreationTool_title,
                Messages.BAMMediator41CreationTool_desc, Collections.singletonList(EsbElementTypes.BAMMediator_3680));
        entry.setId("createBAMMediator41CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.BAMMediator_3680));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createBeanMediator42CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.BeanMediator42CreationTool_title,
                Messages.BeanMediator42CreationTool_desc, Collections.singletonList(EsbElementTypes.BeanMediator_3683));
        entry.setId("createBeanMediator42CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.BeanMediator_3683));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createEJBMediator43CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EJBMediator43CreationTool_title,
                Messages.EJBMediator43CreationTool_desc,
                Collections.singletonList(EsbElementTypes.EJBMediator_3686));
        entry.setId("createEJBMediator43CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EJBMediator_3686));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createLoopBackMediator44CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.LoopBackMediator44CreationTool_title,
                Messages.LoopBackMediator44CreationTool_desc,
                Collections.singletonList(EsbElementTypes.LoopBackMediator_3736));
        entry.setId("createLoopBackMediator44CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.LoopBackMediator_3736));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createRespondMediator45CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.RespondMediator45CreationTool_title,
                Messages.RespondMediator45CreationTool_desc,
                Collections.singletonList(EsbElementTypes.RespondMediator_3739));
        entry.setId("createRespondMediator45CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.RespondMediator_3739));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createCallMediator46CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CallMediator46CreationTool_title,
                Messages.CallMediator46CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CallMediator_3742));
        entry.setId("createCallMediator46CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CallMediator_3742));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createDataMapperMediator47CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.DataMapperMediator47CreationTool_title,
                Messages.DataMapperMediator47CreationTool_desc,
                Collections.singletonList(EsbElementTypes.DataMapperMediator_3761));
        entry.setId("createDataMapperMediator47CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.DataMapperMediator_3761));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createFastXSLTMediator48CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.FastXSLTMediator48CreationTool_title,
                Messages.FastXSLTMediator48CreationTool_desc,
                Collections.singletonList(EsbElementTypes.FastXSLTMediator_3764));
        entry.setId("createFastXSLTMediator48CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.FastXSLTMediator_3764));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createPublishEventMediator49CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.PublishEventMediator49CreationTool_title,
                Messages.PublishEventMediator49CreationTool_desc,
                Collections.singletonList(EsbElementTypes.PublishEventMediator_3785));
        entry.setId("createPublishEventMediator48CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.PublishEventMediator_3785));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
    * @generated
    */
    private ToolEntry createJsonTransformMediator50CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.JsonTransformMediator50CreationTool_title,
                Messages.JsonTransformMediator50CreationTool_desc,
                Collections.singletonList(EsbElementTypes.JsonTransformMediator_3791));
        entry.setId("createJsonTransformMediator50CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.JsonTransformMediator_3791));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated NOT
     */
    private ToolEntry createStoreMediator31CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.StoreMediator32CreationTool_title,
                Messages.StoreMediator32CreationTool_desc,
                Collections.singletonList(EsbElementTypes.StoreMediator_3588));
        entry.setId("createStoreMediator31CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.StoreMediator_3588));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated NOT
     */
    private ToolEntry createBuilderMediator32CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.BuilderMediator33CreationTool_title,
                Messages.BuilderMediator33CreationTool_desc,
                Collections.singletonList(EsbElementTypes.BuilderMediator_3591));
        entry.setId("createBuilderMediator32CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.BuilderMediator_3591));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated NOT
     */
    private ToolEntry createCallTemplateMediator33CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CallTemplateMediator34CreationTool_title,
                Messages.CallTemplateMediator34CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CallTemplateMediator_3594));
        entry.setId("createCallTemplateMediator33CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CallTemplateMediator_3594));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createDefaultEndPoint1CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.DefaultEndPoint_3609);
        types.add(EsbElementTypes.DefaultEndPoint_3643);
        NodeToolEntry entry = new NodeToolEntry(Messages.DefaultEndPoint1CreationTool_title,
                Messages.DefaultEndPoint1CreationTool_desc, types);
        entry.setId("createDefaultEndPoint1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.DefaultEndPoint_3609));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAddressEndPoint2CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.AddressEndPoint_3610);
        types.add(EsbElementTypes.AddressEndPoint_3646);
        NodeToolEntry entry = new NodeToolEntry(Messages.AddressEndPoint2CreationTool_title,
                Messages.AddressEndPoint2CreationTool_desc, types);
        entry.setId("createAddressEndPoint2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.AddressEndPoint_3610));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createFailoverEndPoint3CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.FailoverEndPoint_3611);
        types.add(EsbElementTypes.FailoverEndPoint_3649);
        NodeToolEntry entry = new NodeToolEntry(Messages.FailoverEndPoint3CreationTool_title,
                Messages.FailoverEndPoint3CreationTool_desc, types);
        entry.setId("createFailoverEndPoint3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.FailoverEndPoint_3611));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createWSDLEndPoint4CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.WSDLEndPoint_3612);
        types.add(EsbElementTypes.WSDLEndPoint_3653);
        NodeToolEntry entry = new NodeToolEntry(Messages.WSDLEndPoint4CreationTool_title,
                Messages.WSDLEndPoint4CreationTool_desc, types);
        entry.setId("createWSDLEndPoint4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.WSDLEndPoint_3612));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLoadBalanceEndPoint5CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
        types.add(EsbElementTypes.LoadBalanceEndPoint_3656);
        NodeToolEntry entry = new NodeToolEntry(Messages.LoadBalanceEndPoint5CreationTool_title,
                Messages.LoadBalanceEndPoint5CreationTool_desc, types);
        entry.setId("createLoadBalanceEndPoint5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.LoadBalanceEndPoint_3613));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createNamedEndpoint6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.NamedEndpoint6CreationTool_title,
                Messages.NamedEndpoint6CreationTool_desc,
                Collections.singletonList(EsbElementTypes.NamedEndpoint_3660));
        entry.setId("createNamedEndpoint6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.NamedEndpoint_3660));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAddressingEndpoint7CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.AddressingEndpoint7CreationTool_title,
                Messages.AddressingEndpoint7CreationTool_desc,
                Collections.singletonList(EsbElementTypes.AddressingEndpoint_3689));
        entry.setId("createAddressingEndpoint7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.AddressingEndpoint_3689));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createRecipientListEndPoint8CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.RecipientListEndPoint_3692);
        types.add(EsbElementTypes.RecipientListEndPoint_3696);
        NodeToolEntry entry = new NodeToolEntry(Messages.RecipientListEndPoint8CreationTool_title,
                Messages.RecipientListEndPoint8CreationTool_desc, types);
        entry.setId("createRecipientListEndPoint8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.RecipientListEndPoint_3692));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createHTTPEndpoint9CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.HTTPEndpoint_3709);
        types.add(EsbElementTypes.HTTPEndpoint_3712);
        NodeToolEntry entry = new NodeToolEntry(Messages.HTTPEndpoint9CreationTool_title,
                Messages.HTTPEndpoint9CreationTool_desc, types);
        entry.setId("createHTTPEndpoint9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.HTTPEndpoint_3709));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createTemplateEndpoint10CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.TemplateEndpoint_3716);
        types.add(EsbElementTypes.TemplateEndpoint_3725);
        NodeToolEntry entry = new NodeToolEntry(Messages.TemplateEndpoint10CreationTool_title,
                Messages.TemplateEndpoint10CreationTool_desc, types);
        entry.setId("createTemplateEndpoint10CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.TemplateEndpoint_3716));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEsbLink1CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.EsbLink1CreationTool_title,
                Messages.EsbLink1CreationTool_desc, Collections.singletonList(EsbElementTypes.EsbLink_4001));
        entry.setId("createEsbLink1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.EsbLink_4001));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createMergeNode1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.MergeNode1CreationTool_title,
                Messages.MergeNode1CreationTool_desc, Collections.singletonList(EsbElementTypes.MergeNode_3013));
        entry.setId("createMergeNode1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.MergeNode_3013));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCloudConnector1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CloudConnector1CreationTool_title,
                Messages.CloudConnector1CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CloudConnector_3719));
        entry.setId("createCloudConnector1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CloudConnector_3719));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated NOT
     */
    private ToolEntry createCloudConnector1CreationTool(String name, String ID, String imagePath) {
        NodeToolEntry entry = new NodeToolEntry(name, Messages.CloudConnector1CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CloudConnector_3719));
        entry.setId(ID); // $NON-NLS-1$
        ImageDescriptor imgDesc = getImageDescriptor(imagePath);
        entry.setSmallIcon(imgDesc);
        // entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.CloudConnector_3719));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /*
     * public Collection<String> parameters=null;
     * private static final String synapseNS = "http://ws.apache.org/ns/synapse";
     * private Properties properties = new Properties();
     * ArrayList<String> cloudConnectorOperationsList=null;
     * 
     * public Collection<String> readTemplateConfiguration(String fileLocation) throws IOException, XMLStreamException{
     * String path = fileLocation;
     * String source = FileUtils.getContentAsString(new File(path));
     * OMElement element = AXIOMUtil.stringToOM(source);
     * TemplateMediator templateMediator=null;
     * 
     * if (element.getFirstChildWithName(new QName(synapseNS, "sequence", null)) != null) {
     * TemplateMediatorFactory templateMediatorFactory = new TemplateMediatorFactory();
     * templateMediator = (TemplateMediator) templateMediatorFactory.createMediator(element, properties);
     * }
     * return templateMediator.getParameters();
     * }
     * 
     * 
     * 
     * public ArrayList<String> getCloudConnectorOperations() {
     * ArrayList<String> cloudConnectorOperations = new ArrayList<String>();
     * try {
     * CloudConnectorZIPReader cloudConnectorZIPReader = CloudConnectorZIPReader
     * .getInstance(new File(
     * "/home/viraj/WSO2/DeveloperStudio/Trunk/eclipse/esb/org.wso2.developerstudio.eclipse.gmf.esb.diagram/resources/cloudConnectors/twilio-connector.zip"
     * ));
     * InputStream inputStream = cloudConnectorZIPReader.getFileContentInZIP("artifacts.xml");
     * 
     * File artifactsFile = new File(
     * "/home/viraj/WSO2/DeveloperStudio/Trunk/eclipse/esb/org.wso2.developerstudio.eclipse.gmf.esb.diagram/resources/cloudConnectors/temp/twilio-connector/artifacts.xml"
     * );
     * 
     * String artifactsContent = FileUtils.getContentAsString(artifactsFile);
     * BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
     * String sCurrentLine;
     * while ((sCurrentLine = br.readLine()) != null) {
     * s=s.concat(sCurrentLine);
     * }
     * Artifacts artifacts = new Artifacts();
     * artifacts.deserialize(artifactsContent);
     * 
     * for (ArtifactDependency artifactDependency : artifacts.getArtifactDependencies()) {
     * InputStream inputStream2=cloudConnectorZIPReader.getFileContentInZIP(artifactDependency.getName());
     * ZipEntry zipEntry=cloudConnectorZIPReader.getZipFile().getEntry(artifactDependency.getName());
     * 
     * String pathname =
     * "/home/viraj/WSO2/DeveloperStudio/Trunk/eclipse/esb/org.wso2.developerstudio.eclipse.gmf.esb.diagram/resources/cloudConnectors/temp/twilio-connector/"
     * + artifactDependency.getName();
     * File artifactFile = new File(
     * pathname + "/artifact.xml");
     * String artifactContent = FileUtils.getContentAsString(artifactFile);
     * Artifact artifact = new Artifact();
     * artifact.deserialize(artifactContent);
     * for (org.wso2.developerstudio.eclipse.capp.core.manifest.Artifact artifact_ : artifact
     * .getArtifacts()) {
     * if("configure".equals(artifact_.getName())){
     * parameters=readTemplateConfiguration(pathname+"/configure.xml");
     * }
     * cloudConnectorOperations.add(artifact_.getName());
     * }
     * 
     * }
     * 
     * } catch (ZipException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * } catch (IOException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * } catch (Exception e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * cloudConnectorOperationsList=cloudConnectorOperations;
     * return cloudConnectorOperations;
     * }
     */

    public void addCloudConnectors(IEditorPart editor) {
        boolean cloudConnectorsGroupAdded = false;
        int indexOfcloudConnectorsGroup = 0;

        List<?> list = ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                .getPaletteRoot().getChildren();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) instanceof PaletteDrawer) {
                if (("createCloudConnectors6Group").equals(((PaletteDrawer) list.get(i)).getId())) {
                    cloudConnectorsGroupAdded = true;
                    indexOfcloudConnectorsGroup = i;
                    break;
                }
            }
        }

        if (!cloudConnectorsGroupAdded) {
            ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer().getPaletteRoot()
                    .add(createCloudConnectors6Group());
            indexOfcloudConnectorsGroup = list.size() - 1;
        }
        PaletteContainer container = ((PaletteContainer) ((DiagramEditDomain) ((EsbDiagramEditor) editor)
                .getDiagramEditDomain()).getPaletteViewer().getPaletteRoot().getChildren()
                        .get(indexOfcloudConnectorsGroup));
        container.getChildren().clear();

        IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
        IFile file = input.getFile();
        IProject activeProject = file.getProject();
        String connectorPath = activeProject.getWorkspace().getRoot().getLocation().toOSString() + File.separator
                + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
        File directory = new File(connectorPath);

        String icon_exsists = "icon-small.png";
        if (!new File(connectorPath + File.separator + "icon" + File.separator + icon_exsists).exists()) {
            icon_exsists = "icon-small.gif";
        }

        String[] names = directory.list();
        if (names != null) {
            for (int i = 0; i < names.length; ++i) {
                container.add(createCloudConnector1CreationTool(names[i].split("-")[0],
                        names[i].split("-")[0] + "-cloudConnector", connectorPath + File.separator + names[i]
                                + File.separator + "icon" + File.separator + icon_exsists));
            }
        }
    }
    
    /**
     * This method removes connector palettes from editor if the connector is not in the given list.
     * 
     * @param editor editor from which palettes should be removed
     * @param connectorDirectoryNames list to be checked against
     */
    public void removeNonExistingCloudConnectorOperations(IEditorPart editor, List<String> connectorDirectoryNames) {
        List<String> connectorNames = new ArrayList<>();
        for (String connectorDirectoryName : connectorDirectoryNames) {
            String connectorName = connectorDirectoryName.split("-")[0];
            connectorNames.add(CLOUD_CONNECTOR_PREFIX + connectorName);
        }

        List<?> list = ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                .getPaletteRoot().getChildren();
        for (int palleteIndex = 0; palleteIndex < list.size(); ++palleteIndex) {
            if (list.get(palleteIndex) instanceof PaletteDrawer) {
                String peletteId = ((PaletteDrawer) list.get(palleteIndex)).getId();
                if (peletteId.startsWith(CLOUD_CONNECTOR_PREFIX) && !connectorNames.contains(peletteId)) {
                    ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                            .getPaletteRoot().remove((PaletteDrawer) list.get(palleteIndex));
                    palleteIndex--;
                }
            }
        }
    }

    public void addCloudConnectorOperations(IEditorPart editor, String connectorDirectoryName) throws Exception {
        Set<String> cloudConnectorOperations = Collections.emptySet();
        String connectorPath = null;
        String cloudConnectorName = connectorDirectoryName.split("-")[0];
        String connectorType = "Connector";

        /*
         * IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
         * .getActivePage().getActiveEditor();
         */
        EsbEditorInput input = (EsbEditorInput) editor.getEditorInput();
        IFile file = input.getXmlResource();
        IProject activeProject = file.getProject();
        // connectorPath = activeProject.getLocation().toOSString() + File.separator
        // + "cloudConnectors" + File.separator + connectorDirectoryName;
        connectorPath = activeProject.getWorkspace().getRoot().getLocation().toOSString() + File.separator
                + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace + File.separator + connectorDirectoryName;
        CloudConnectorDirectoryTraverser cloudConnectorTraverser = CloudConnectorDirectoryTraverser
                .getInstance(connectorPath);
        cloudConnectorOperations = cloudConnectorTraverser.getOperationsMap().keySet();
        if (cloudConnectorTraverser.getConnectorType() != null) {
            connectorType = cloudConnectorTraverser.getConnectorType();
        }
        boolean definedEndpointsAdded = false;
        int indexOfDefinedEndpoints = 0;

        List<?> list = ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                .getPaletteRoot().getChildren();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) instanceof PaletteDrawer) {
                if (("CloudConnector-" + cloudConnectorName).equals(((PaletteDrawer) list.get(i)).getId())) {
                    definedEndpointsAdded = true;
                    indexOfDefinedEndpoints = i;
                    break;
                }
            }
        }

        if (!definedEndpointsAdded) {
            ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer().getPaletteRoot()
                    .add(createCloudConnectorGroup(WordUtils.capitalize(cloudConnectorName) + " " + WordUtils.capitalize(connectorType),
                            "CloudConnector-" + cloudConnectorName));
            indexOfDefinedEndpoints = list.size() - 1;
        } /*
           * if (indexOfDefinedEndpoints == 0) {
           * indexOfDefinedEndpoints = list.size()-1;
           * }
           */
        PaletteContainer container = ((PaletteContainer) ((DiagramEditDomain) ((EsbDiagramEditor) editor)
                .getDiagramEditDomain()).getPaletteViewer().getPaletteRoot().getChildren()
                        .get(indexOfDefinedEndpoints));
        container.getChildren().clear();
        Object[] keys = cloudConnectorOperations.toArray();
        String icon_exists = "icon-small.png";
        if (!new File(connectorPath + File.separator + "icon" + File.separator + icon_exists).exists()) {
            icon_exists = "icon-small.gif";
        }
        if (keys != null) {
            Arrays.sort(keys);
            for (int k = 0; k < keys.length; ++k) {
                try {
                    container.add(createCloudConnectorOperationCreationTool((String) keys[k],
                            "cloudConnectorOperation-" + cloudConnectorName,
                            connectorPath + File.separator + "icon" + File.separator + icon_exists));
                } catch (SWTException e) {
                    container.getChildren().clear();
                    log.error("Failed to add connector " + cloudConnectorName + " to the tool palette", e);
                    IStatus errorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                    ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error in connector",
                            "Failed to add connector " + cloudConnectorName + " to the tool palette", errorStatus);
                    return;
                }
            }
        }

    }

    public void addDefinedSequences(IEditorPart editor) {
        ArrayList<String> definedSequences = addDefinedArtifacts(editor, SEQUENCE_RESOURCE_DIR, "synapse/sequence");
        /*
         * if (editor != null) {
         * IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
         * IFile file = input.getFile();
         * IProject activeProject = file.getProject();
         * try {
         * IResource[] SequenceMembers = activeProject.getFolder(
         * SEQUENCE_RESOURCE_DIR).members();
         * for (int j = 0; j < SequenceMembers.length; ++j) {
         * 
         * Pattern p = Pattern.compile(".esb_diagram");
         * Matcher m = p.matcher(SequenceMembers[j].getName());
         * StringBuffer sb = new StringBuffer();
         * boolean result = m.find();
         * 
         * if (result) {
         * String[] splittedFilename = SequenceMembers[j]
         * .getName().split(".esb_diagram");
         * if (splittedFilename[0] != null) {
         * String[] tempName = splittedFilename[0]
         * .split("sequence_");
         * definedSequences.add(tempName[1].trim());
         * }
         * }
         * }
         * } catch (CoreException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         * 
         * }
         */

        boolean definedSequencesAdded = false;
        int indexOfDefinedSequences = 0;

        List<?> list = ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                .getPaletteRoot().getChildren();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) instanceof PaletteDrawer) {
                if ("Sequences".equals(((PaletteDrawer) list.get(i)).getId())) {
                    definedSequencesAdded = true;
                    indexOfDefinedSequences = i;
                    break;
                }
            }
        }

        if (!definedSequencesAdded) {
            ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer().getPaletteRoot()
                    .add(createSequenceGroup());
        }
        if (indexOfDefinedSequences == 0) {
            indexOfDefinedSequences = ToolPalleteDetails.SEQUENCE;
        }

        PaletteContainer container = ((PaletteContainer) ((DiagramEditDomain) ((EsbDiagramEditor) editor)
                .getDiagramEditDomain()).getPaletteViewer().getPaletteRoot().getChildren()
                        .get(indexOfDefinedSequences));
        container.getChildren().clear();
        for (int k = 0; k < definedSequences.size(); ++k) {
            container.add(createDefinedSequenceCreationTool(definedSequences.get(k)));
            SequenceEditPart.definedSequenceNames.add(definedSequences.get(k));
        }

    }

    public void addDefinedEndpoints(IEditorPart editor) {
        ArrayList<String> definedEndpoints = addDefinedArtifacts(editor, ENDPOINT_RESOURCE_DIR, "synapse/endpoint");

        boolean definedEndpointsAdded = false;
        int indexOfDefinedEndpoints = 0;

        List<?> list = ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer()
                .getPaletteRoot().getChildren();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) instanceof PaletteDrawer) {
                if ("DefinedEndpoints".equals(((PaletteDrawer) list.get(i)).getId())) {
                    definedEndpointsAdded = true;
                    indexOfDefinedEndpoints = i;
                    break;
                }
            }
        }

        if (!definedEndpointsAdded) {
            ((DiagramEditDomain) ((EsbDiagramEditor) editor).getDiagramEditDomain()).getPaletteViewer().getPaletteRoot()
                    .add(createDefinedEndpointGroup());
        }
        if (indexOfDefinedEndpoints == 0) {
            indexOfDefinedEndpoints = ToolPalleteDetails.DEFINED_ENDPOINT;
        }
        PaletteContainer container = ((PaletteContainer) ((DiagramEditDomain) ((EsbDiagramEditor) editor)
                .getDiagramEditDomain()).getPaletteViewer().getPaletteRoot().getChildren()
                        .get(indexOfDefinedEndpoints));
        container.getChildren().clear();
        for (int k = 0; k < definedEndpoints.size(); ++k) {
            container.add(createDefinedEndpointCreationTool(definedEndpoints.get(k)));
            NamedEndpointEditPart.definedEndpointsNames.add(definedEndpoints.get(k));
        }

    }

    private ArrayList<String> addDefinedArtifacts(IEditorPart editor, String dir, String type) {
        ArrayList<String> definedArtifacts = new ArrayList<String>();
        if (editor != null) {
            EsbEditorInput input = (EsbEditorInput) editor.getEditorInput();
            IFile file = input.getXmlResource();
            IProject activeProject = file.getProject();
            // FIXME: scan whole workspace
            try {
                if (activeProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {

                    ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
                    File projectPath = activeProject.getLocation().toFile();
                    try {
                        esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile());
                        List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
                        for (ESBArtifact esbArtifact : allESBArtifacts) {
                            if (esbArtifact.getType().equals(type)) {
                                File artifact = new File(projectPath, esbArtifact.getFile());
                                definedArtifacts.add(artifact.getName().replaceAll("[.]xml$", ""));
                            }
                        }
                    } catch (Exception e) {
                        log.error("Error occured while scanning the project for " + type + " artifacts", e);
                    }
                }
            } catch (CoreException e) {
                log.error("Error occured while scanning the project", e);
            }

        }

        return definedArtifacts;
    }

    /**
     * Update tool palette items according to diagram type
     * 
     * @param diagramEditor
     */
    public void updateToolPaletteItems(EsbDiagramEditor diagramEditor) {

        EObject element = diagramEditor.getDiagramEditPart().getDiagramView().getElement();
        if (element instanceof EsbDiagram /* this check is not required */) {
            EsbServer server = ((EsbDiagram) element).getServer();
            PaletteViewer paletteViewer = ((DiagramEditDomain) diagramEditor.getDiagramEditDomain()).getPaletteViewer();
            PaletteContainer paletteContainer = paletteViewer.getPaletteRoot();
            PaletteContainer nodePalette = (PaletteContainer) paletteContainer.getChildren().get(1);
            PaletteContainer mediatorPalette = (PaletteContainer) paletteContainer.getChildren().get(2);
            PaletteContainer endpoitPalette = (PaletteContainer) paletteContainer.getChildren().get(3);
            PaletteContainer linksPalette = (PaletteContainer) paletteContainer.getChildren().get(4);

            PaletteContainer seqPalette = (PaletteContainer) paletteContainer.getChildren().get(5);
            PaletteContainer defineEpPalette = (PaletteContainer) paletteContainer.getChildren().get(6);
            ToolEntry proxyServiceTool = (ToolEntry) (nodePalette.getChildren().get(0));
            ToolEntry apiResourceTool = (ToolEntry) (nodePalette.getChildren().get(1));
            if (server != null) {
                switch (server.getType()) {
                case PROXY:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(false);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                case SEQUENCE:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                case ENDPOINT:
                    mediatorPalette.setVisible(false);
                    nodePalette.setVisible(false);
                    seqPalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, false);
                    break;
                case LOCAL_ENTRY:
                case TASK:
                    mediatorPalette.setVisible(false);
                    nodePalette.setVisible(false);
                    seqPalette.setVisible(false);
                    endpoitPalette.setVisible(false);
                    defineEpPalette.setVisible(false);
                    linksPalette.setVisible(false);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, false);
                    break;
                case API:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(true);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(false);
                    // fixing TOOLS-1820
                    apiResourceTool.getParent().setLabel("API");
                    apiResourceTool.setVisible(true);
                    proxyServiceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                case TEMPLATE:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                case COMPLEX_ENDPOINT:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(false);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    seqPalette.setVisible(false);
                    updateConnectorVisibility(paletteContainer, false);
                    break;
                case MAIN_SEQUENCE:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                case MESSAGE_STORE:
                case MESSAGE_PROCESSOR:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(false);
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(false);
                    defineEpPalette.setVisible(false);
                    seqPalette.setVisible(false);
                    linksPalette.setVisible(false);
                    apiResourceTool.setVisible(false);
                    updateConnectorVisibility(paletteContainer, false);
                    break;
                case INBOUND_ENDPOINT:
                    proxyServiceTool.setVisible(false);
                    mediatorPalette.setVisible(true);
                    // Hiding all mediators except Sequence mediator.
                    for (Object child : mediatorPalette.getChildren()) {
                        if ("Sequence".equals(((PaletteEntry) child).getLabel())) {
                            ((PaletteEntry) child).setVisible(true);
                        } else {
                            ((PaletteEntry) child).setVisible(false);
                        }
                    }
                    nodePalette.setVisible(false);
                    endpoitPalette.setVisible(false);
                    defineEpPalette.setVisible(false);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(false);
                    seqPalette.setVisible(true);
                    updateConnectorVisibility(paletteContainer, false);
                    break;
                case SYNAPSE_CONFIG:
                default:
                    proxyServiceTool.setVisible(true);
                    mediatorPalette.setVisible(true);
                    nodePalette.setVisible(true);
                    endpoitPalette.setVisible(true);
                    defineEpPalette.setVisible(true);
                    linksPalette.setVisible(true);
                    apiResourceTool.setVisible(true);
                    updateConnectorVisibility(paletteContainer, true);
                    break;
                }
            }

            // Initialize palette viewer key handler.
            if (paletteViewer.getKeyHandler() instanceof CustomPaletteViewerKeyHandler) {
                ((CustomPaletteViewerKeyHandler) paletteViewer.getKeyHandler()).initializeKeyHandler();
            }
        }
    }

    /**
     * Change the visibility of Connector palette group(s) based on the opened
     * artifact
     * 
     * @param paletteContainer
     * @param visible
     */
    private void updateConnectorVisibility(PaletteContainer paletteContainer, boolean visible) {
        List children = paletteContainer.getChildren();

        for (Object child : children) {
            if (child instanceof PaletteContainer && ((PaletteContainer) child).getId().startsWith("CloudConnector")) {
                ((PaletteContainer) child).setVisible(visible);
            }
        }
    }

    private PaletteContainer createSequenceGroup() {
        PaletteDrawer paletteContainer = new PaletteDrawer("Defined Sequences");
        paletteContainer.setId("Sequences"); //$NON-NLS-1$
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        updateToolpalette();
        return paletteContainer;
    }

    private PaletteContainer createDefinedEndpointGroup() {
        PaletteDrawer paletteContainer = new PaletteDrawer("Defined EndPoints");
        paletteContainer.setId("DefinedEndpoints"); //$NON-NLS-1$
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    private PaletteContainer createCloudConnectorGroup(String name, String ID) {
        PaletteDrawer paletteContainer = new PaletteDrawer(name);
        paletteContainer.setId(ID); // $NON-NLS-1$
        paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
        return paletteContainer;
    }

    private ToolEntry createCloudConnectorOperationCreationTool(String name, String ID, String imagePath)
            throws SWTException {
        NodeToolEntry entry = new NodeToolEntry(name, Messages.CloudConnectorOperation6CreationTool_desc,
                Collections.singletonList(EsbElementTypes.CloudConnectorOperation_3722));
        entry.setId(ID); // $NON-NLS-1$
        ImageDescriptor imgDesc = getImageDescriptor(imagePath);
        entry.setSmallIcon(imgDesc);
        /*
         * entry.setSmallIcon(EsbElementTypes
         * .getImageDescriptor(EsbElementTypes.CloudConnectorOperation_3722));
         */
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    private ToolEntry createDefinedSequenceCreationTool(String name) {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(EsbElementTypes.Sequence_3503);
        /*
         * types.add(EsbElementTypes.Sequence_3187);
         * types.add(EsbElementTypes.Sequence_3254);
         * types.add(EsbElementTypes.Sequence_3375);
         */
        NodeToolEntry entry = new NodeToolEntry(name, null, types);
        entry.setId("createSequence4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.Sequence_3503));
        entry.setLargeIcon(entry.getSmallIcon());

        return entry;
    }

    private ToolEntry createDefinedEndpointCreationTool(String name) {
        NodeToolEntry entry = new NodeToolEntry(name, null,
                Collections.singletonList(EsbElementTypes.NamedEndpoint_3660));
        entry.setId("createNamedEndpoint6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.NamedEndpoint_3660));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated NOT
     */
    @SuppressWarnings("restriction")
    public static class NodeToolEntry extends PaletteToolEntry {

        /**
         * @generated NOT
         */
        private final List<IElementType> elementTypes;

        /**
         * @generated NOT
         */
        private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
            // super(title, description, null, null);
            super(null, title, null);
            this.setDescription(description);
            this.elementTypes = elementTypes;
        }

        /**
         * @generated NOT
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }

    /**
     * @generated NOT
     */
    private static class LinkToolEntry extends ToolEntry {

        /**
         * @generated NOT
         */
        private final List<IElementType> relationshipTypes;

        /**
         * @generated NOT
         */
        private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
            super(title, description, null, null);
            this.relationshipTypes = relationshipTypes;
        }

        /**
         * @generated NOT
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes) {

                public void mouseDown(MouseEvent me, EditPartViewer viewer) {
                    super.mouseDown(me, viewer);

                }

                public void mouseUp(MouseEvent me, EditPartViewer viewer) {
                    super.mouseUp(me, viewer);
                }

                public void mouseDrag(MouseEvent me, EditPartViewer viewer) {
                    super.mouseDrag(me, viewer);
                }

                public void mouseHover(MouseEvent me, EditPartViewer viewer) {
                    super.mouseHover(me, viewer);
                }

                public void mouseMove(MouseEvent me, EditPartViewer viewer) {
                    super.mouseMove(me, viewer);
                }

                protected Command getCommand() {
                    if (getTargetEditPart() == null) {
                        return null;
                    }
                    if (getTargetEditPart() instanceof AbstractMediator) {
                        for (int i = 0; i < ((AbstractMediator) getTargetEditPart()).getChildren().size(); ++i) {
                            if (((AbstractMediator) getTargetEditPart()).getChildren()
                                    .get(i) instanceof AbstractMediatorInputConnectorEditPart) {
                                return ((AbstractMediatorInputConnectorEditPart) ((AbstractMediator) getTargetEditPart())
                                        .getChildren().get(i)).getCommand(getTargetRequest());
                            }
                        }
                    } else if (getTargetEditPart() instanceof AbstractEndpoint) {
                        for (int j = 0; j < ((AbstractEndpoint) getTargetEditPart()).getChildren().size(); ++j) {
                            if (((AbstractEndpoint) getTargetEditPart()).getChildren()
                                    .get(j) instanceof AbstractEndpointInputConnectorEditPart) {
                                return ((AbstractEndpointInputConnectorEditPart) ((AbstractEndpoint) getTargetEditPart())
                                        .getChildren().get(j)).getCommand(getTargetRequest());
                            }
                        }
                    } else if (getTargetEditPart() instanceof AbstractBaseFigureEditPart) {
                        for (int i = 0; i < ((AbstractBaseFigureEditPart) getTargetEditPart()).getChildren()
                                .size(); ++i) {
                            int yFaultContainer = ((ProxyServiceFaultContainerEditPart) ((AbstractProxyServiceContainerEditPart) EditorUtils
                                    .getProxyContainer((ShapeNodeEditPart) getTargetEditPart())).getChildren().get(1))
                                            .getFigure().getBounds().getLocation().y;
                            if ((((AbstractBaseFigureEditPart) getTargetEditPart()).getChildren()
                                    .get(i) instanceof AbstractBaseFigureInputConnectorEditPart)
                                    && (getStartLocation().y < yFaultContainer)) {
                                return ((AbstractBaseFigureInputConnectorEditPart) ((AbstractBaseFigureEditPart) getTargetEditPart())
                                        .getChildren().get(i)).getCommand(getTargetRequest());
                            } else if ((((AbstractBaseFigureEditPart) getTargetEditPart()).getChildren()
                                    .get(i) instanceof AbstractBaseFigureFaultInputConnectorEditPart)
                                    && (getStartLocation().y > yFaultContainer)) {
                                return ((AbstractBaseFigureFaultInputConnectorEditPart) ((AbstractBaseFigureEditPart) getTargetEditPart())
                                        .getChildren().get(i)).getCommand(getTargetRequest());
                            }
                        }
                    }
                    return getTargetEditPart().getCommand(getTargetRequest());
                }
            };
            tool.setProperties(getToolProperties());
            return tool;
        }
    }

    private ImageDescriptor getImageDescriptor(String imagePath) {
        ImageDescriptor imgDesc = null;
        if (imageDescriptorMap.containsKey(imagePath)) {
            return imageDescriptorMap.get(imagePath);
        } else {
            try {
                imgDesc = ImageDescriptor.createFromURL(new URL(FILE_PROTOCOL_PREFIX + imagePath));
                imageDescriptorMap.put(imagePath, imgDesc);
            } catch (MalformedURLException e) {
                log.error("Error while creating the cloud connector palette icon");
            }
        }
        return imgDesc;
    }
}
