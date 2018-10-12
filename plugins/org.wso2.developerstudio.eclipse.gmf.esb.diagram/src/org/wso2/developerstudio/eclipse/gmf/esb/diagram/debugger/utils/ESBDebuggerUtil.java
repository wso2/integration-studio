/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_DELETE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_GET;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_HEAD;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_OPTIONS;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_PATCH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_POST;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_PUT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYANPSE_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTY_TAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.CloneMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EntitlementMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGroupingShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FilterMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SwitchMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.IESBDebuggerInterface;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.IESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl.ESBDebugPointBuilderFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MissingAttributeException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.IMediatorLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl.MediatorLocatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBInboundEndpointDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxyDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBSequenceDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBTemplateDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugModelPresentation;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.suspendpoint.ESBSuspendPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;

/**
 * This class consists exclusively of reusable static methods used by ESB
 * Mediation Debugger implementation.
 *
 */
public class ESBDebuggerUtil {

    private static final int NUM_OF_ENTRIES_IN_COMPLEX_SEQ_TYPE = 1;
    private static final String SPACE_STRING = " ";
    private static final String ATTRIBUTE_SEPERATOR = ",";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static AbstractMediator recentlyAddedMediator;
    private static boolean pageChangeOperationActivated;
    private static boolean pageCreateOperationActivated;
    private static boolean pageSaveOperationActivated;

    private static AbstractMediator deletedMediator;
    private static boolean deleteOperationPerformed;

    /**
     * This private constructor is to hide the implicit public constructor
     */
    private ESBDebuggerUtil() {
    }

    /**
     * This method removes all registered ESBDebugPoints from ESB Server
     * 
     * @param debuggerInterface
     * @throws DebugPointMarkerNotFoundException
     * @throws CoreException
     */
    public static void removeDebugPointsFromESBServer(IESBDebuggerInterface debuggerInterface)
            throws DebugPointMarkerNotFoundException, CoreException {
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint debugPoint : breakpoints) {
            AbstractESBDebugPointMessage debugPointMessage = ((ESBDebugPoint) debugPoint).getLocation();
            debugPointMessage.setCommand(DebugPointEventAction.REMOVED.toString());
            debuggerInterface.sendBreakpointCommand(debugPointMessage);
        }
    }

    /**
     * This method modify debug points when a new mediator addition operation is
     * performed
     *
     * @param isSaveFlow - Boolean to identify whether this method is called when saving the artifact or not.
     * @param abstractMediator
     * @throws CoreException
     * @throws ESBDebuggerException
     */
    public static void modifyDebugPointsointsAfterMediatorAddition(boolean isSaveFlow,
            AbstractMediator abstractMediator) throws CoreException, ESBDebuggerException {

        IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
        for (IWorkbenchPage iWorkbenchPage : pages) {
            IEditorReference[] editorReferences = iWorkbenchPage.getEditorReferences();
            for (IEditorReference iEditorReference : editorReferences) {
                IEditorPart activeEditor = iEditorReference.getEditor(false);
                if (activeEditor instanceof EsbMultiPageEditor) {
                    IResource resource = getIResourceFromIEditorPart(activeEditor);
                    if (!isSaveFlow || (isSaveFlow && resource == getCurrentOpenResource())) {
                        EsbServer esbServer = getESBServerFromIEditorPart(activeEditor);
                        if (esbServer != null) {
                            IESBDebugPointBuilder breakpointBuilder = ESBDebugPointBuilderFactory
                                    .getBreakpointBuilder(esbServer.getType());
                            try {
                                breakpointBuilder.updateExistingDebugPoints(resource, abstractMediator, esbServer,
                                        ESBDebuggerConstants.MEDIATOR_INSERT_ACTION);
                                setRecentlyAddedMediator(null);
                                return;
                            } catch (MediatorNotFoundException e) {
                                log.info("Inserted Mediator not found in a valid location for breakpoint validation",
                                        e);
                            } catch (ESBDebuggerException e) {
                                log.info(e.getMessage(), e);
                            }
                        }
                    }
                }
            }
        }
        setRecentlyAddedMediator(null);
    }

    /**
     * Get the currently open resource ( the tab which we are working on currently ).
     *
     * @return - The current resource
     */
    private static IResource getCurrentOpenResource() {
        try {
            IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor();
            return getIResourceFromIEditorPart(activeEditor);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * This method updates, if there is any debug points needed to be modified
     */
    public static void updateModifiedDebugPoints(boolean isSaveFlow) {
        try {
            if (recentlyAddedMediator != null) {
                modifyDebugPointsointsAfterMediatorAddition(isSaveFlow, recentlyAddedMediator);
            }
        } catch (CoreException | ESBDebuggerException e) {
            log.error("Error while updating debug points : " + e.getMessage(), e);
        }
    }

    /**
     * This method modify debug points when a new mediator deletion operation is
     * performed
     * 
     * @throws CoreException
     * @throws ESBDebuggerException
     */
    public static void modifyBreakpointsAfterMediatorDeletion(boolean isDeleteFlow)
            throws CoreException, ESBDebuggerException {

        if (getDeletedMediator() != null) {
            IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
            for (IWorkbenchPage iWorkbenchPage : pages) {
                IEditorReference[] editorReferences = iWorkbenchPage.getEditorReferences();
                for (IEditorReference iEditorReference : editorReferences) {
                    IEditorPart activeEditor = iEditorReference.getEditor(false);
                    if (activeEditor instanceof EsbMultiPageEditor) {
                        if (activeEditor instanceof EsbMultiPageEditor) {
                            IResource resource = getIResourceFromIEditorPart(activeEditor);
                            if (!isDeleteFlow || (isDeleteFlow && resource == getCurrentOpenResource())) {
                                EsbServer esbServer = getESBServerFromIEditorPart(activeEditor);
                                if (esbServer != null) {
                                    IESBDebugPointBuilder breakpointBuilder = ESBDebugPointBuilderFactory
                                            .getBreakpointBuilder(esbServer.getType());
                                    try {
                                        breakpointBuilder.updateExistingDebugPoints(resource, getDeletedMediator(),
                                                esbServer, ESBDebuggerConstants.MEDIATOR_DELETE_ACTION);
                                        setDeletedMediator(null);
                                        ESBDebuggerUtil.setDeleteOperationPerformed(false);
                                        return;
                                    } catch (MediatorNotFoundException e) {
                                        log.info(
                                                "Deleted Mediator not found in a valid location for breakpoint validation",
                                                e);
                                    } catch (ESBDebuggerException e) {
                                        log.info(e.getMessage(), e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        setDeletedMediator(null);
        ESBDebuggerUtil.setDeleteOperationPerformed(false);
    }

    /**
     * This method will handle an error occurred in the application. The thrown
     * exception will be logged using {@link IDeveloperStudioLog} and also pop
     * up an error Dialog of {@link ErrorDialog} mentioning the given message
     * and occurred exception.
     * 
     * @param ex
     * @param message
     * @see ErrorDialog
     * @see IStatus
     */
    public static void popUpErrorDialogAndLogException(Exception ex, final String message) {
        log.error(message, ex);
        String simpleMessage = ex.getMessage();
        final IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, simpleMessage);
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                ErrorDialog.openError(Display.getDefault().getActiveShell(), Messages.ESBDebugerUtil_ErrorDialogTitle,
                        message, editorStatus);

            }
        });
    }

    /**
     * This method remove quotation marks of the entry value of JsonElement and
     * return only the string value component
     * 
     * @param entry
     * @return
     */
    public static String convertEntryValueToString(Entry<String, JsonElement> entry) {
        return entry.getValue().getAsString();
    }

    /**
     * This method generate and returns relevant ESBDebugPointMessage from a
     * JsonElement
     * 
     * @param debugPointType
     * @param event
     * @param recievedArtifactInfo
     * @return
     */
    public static AbstractESBDebugPointMessage getESBDebugPoint(ArtifactType debugPointType, EventMessageType event,
            JsonElement recievedArtifactInfo) {
        switch (debugPointType) {
        case TEMPLATE:
            return getTemplateDebugPoint(event, recievedArtifactInfo);
        case SEQUENCE:
            return getSequenceTypeDebugPoint(event, recievedArtifactInfo);
        default:
            throw new IllegalArgumentException("Illegal Artifact type for create debug point " + debugPointType);
        }

    }

    /**
     * Remove Debug Point from Breakpoint Manager
     * 
     * @param breakpoint
     */
    public static void removeESBDebugPointFromBreakpointManager(IBreakpoint breakpoint) {
        try {
            DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(breakpoint, true);
        } catch (CoreException e1) {
            log.error("Error while removing debug point : " + breakpoint, e1);
        }
    }

    /**
     * Remove all registered Debug Points from Breakpoint Manager
     * 
     * @param breakpoint
     */
    public static void removeAllESBDebugPointsFromBreakpointManager() {
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint breakpoint : breakpoints) {
            removeESBDebugPointFromBreakpointManager(breakpoint);
        }
    }

    /**
     * This method will list all methods activated from the api resource into a
     * string
     * 
     * @param apiResource
     * @return
     */
    public static String getMethodValuesFromResource(APIResource apiResource) {
        StringBuilder methodValuesBuilder = new StringBuilder();
        if (apiResource.isAllowGet()) {
            methodValuesBuilder.append(API_METHOD_GET).append(SPACE_STRING);
        }
        if (apiResource.isAllowPost()) {
            methodValuesBuilder.append(API_METHOD_POST).append(SPACE_STRING);
        }
        if (apiResource.isAllowPut()) {
            methodValuesBuilder.append(API_METHOD_PUT).append(SPACE_STRING);
        }
        if (apiResource.isAllowDelete()) {
            methodValuesBuilder.append(API_METHOD_DELETE).append(SPACE_STRING);
        }
        if (apiResource.isAllowOptions()) {
            methodValuesBuilder.append(API_METHOD_OPTIONS).append(SPACE_STRING);
        }
        if (apiResource.isAllowHead()) {
            methodValuesBuilder.append(API_METHOD_HEAD).append(SPACE_STRING);
        }
        if (apiResource.isAllowPatch()) {
            methodValuesBuilder.append(API_METHOD_PATCH).append(SPACE_STRING);
        }
        return methodValuesBuilder.toString().trim().replace(SPACE_STRING, ATTRIBUTE_SEPERATOR);
    }

    /**
     * This method publish registered ESB Breakpoints to connected Server
     * 
     * @throws CoreException
     */
    public static void repopulateESBServerBreakpoints() {
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint breakpoint : breakpoints) {
            try {
                DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(breakpoint, false);
                DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(breakpoint);
            } catch (CoreException e) {
                log.error("Error while repopulating debug point in Breakpoint Manager", e);
            }
        }
    }

    /**
     * This method remove all ESBDebugPoints saved in breakpoint manager
     * 
     * @throws ESBDebuggerException
     */
    public static void removeAllESBDebugPointsFromDebugPointManager() throws ESBDebuggerException {
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint breakpoint : breakpoints) {
            try {
                IResource resource = ((ESBDebugPoint) breakpoint).getResource();
                IEditorReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getEditorReferences();
                ArtifactType type = null;
                EsbServer esbServer = null;
                for (IEditorReference iEditorReference : references) {
                    if (iEditorReference.getEditorInput() instanceof FileEditorInput
                            && ((FileEditorInput) iEditorReference.getEditorInput()).getFile().equals(resource)) {
                        IEditorPart multipageEditor = iEditorReference.getEditor(true);
                        if (multipageEditor != null) {
                            Diagram diagram = ((EsbMultiPageEditor) (multipageEditor)).getDiagram();
                            EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
                            esbServer = esbDiagram.getServer();
                            type = esbServer.getType();
                            break;
                        }
                    }
                }
                if (type != null) {
                    IMediatorLocator mediatorLocator = MediatorLocatorFactory.getMediatorLocator(type);
                    EditPart editPart = mediatorLocator.getMediatorEditPart(esbServer, (ESBDebugPoint) breakpoint);
                    String commandArgument = ((ESBDebugPoint) breakpoint).getLocation().getCommandArgument();
                    if (editPart instanceof AbstractMediator) {
                        if (ESBDebuggerConstants.BREAKPOINT_LABEL.equals(commandArgument)) {
                            ESBDebuggerUtil.removeBreakpointMark((AbstractMediator) editPart);
                        } else {
                            ESBDebuggerUtil.removeSkippointMark((AbstractMediator) editPart);
                        }
                    } else {
                        editPart = mediatorLocator.getMediatorEditPart(esbServer, (ESBDebugPoint) breakpoint);
                        if (editPart instanceof AbstractMediator) {
                            if (ESBDebuggerConstants.BREAKPOINT_LABEL.equals(commandArgument)) {
                                ESBDebuggerUtil.removeBreakpointMark((AbstractMediator) editPart);
                            } else {
                                ESBDebuggerUtil.removeSkippointMark((AbstractMediator) editPart);
                            }
                        } else {
                            editPart = mediatorLocator.getMediatorEditPart(esbServer, (ESBDebugPoint) breakpoint);
                            log.warn(
                                    "Error occured while removing ESB Debugpoints From Editor. Expected AbstractMediator for "
                                            + commandArgument + " : found " + editPart.toString());
                        }
                    }
                }
                removeESBDebugPointFromBreakpointManager(breakpoint);
            } catch (DebugPointMarkerNotFoundException | MediatorNotFoundException | MissingAttributeException
                    | CoreException e) {
                log.error("Error occured while removing ESB Debugpoints From Breakpoint Manager " + e.getMessage(), e);
            }
        }
    }

    /**
     * This method return relevant EditPart of a node object in the current
     * active editor.
     * 
     * @param node
     * @param editPartMap
     * @return
     */
    public static EditPart getEditorEditpart(EObject node) {
        Map<EObject, ShapeNodeEditPart> editPartMap = getEditorEditPartMap();
        if (editPartMap.containsKey(node)) {
            return editPartMap.get(node);
        }
        return null;
    }

    /**
     * This method add breakpoint mark to the selected edit part
     */
    public static void addBreakpointMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            if (part instanceof CloudConnectorOperationEditPart) {
                ((CloudConnectorOperationEditPart) part).getPrimaryShape().addBreakpointMark();
            } else {
                ((FixedSizedAbstractMediator) part).getPrimaryShape().addBreakpointMark();
            }
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).addBreakpointMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).addBreakpointMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).addBreakpointMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).addBreakpointMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).addBreakpointMark();
            } else {
                throw new IllegalArgumentException(
                        "Adding break point mark is not implemented for type " + part.getClass());
            }
        }
        part.setBreakpointStatus(true);
    }

    /**
     * This method add skip point mark to the selected edit part
     */
    public static void addSkippointMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            if (part instanceof CloudConnectorOperationEditPart) {
                ((CloudConnectorOperationEditPart) part).getPrimaryShape().addSkipPointMark();
            } else {
                ((FixedSizedAbstractMediator) part).getPrimaryShape().addSkipPointMark();
            }
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).addSkipPointMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).addSkipPointMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).addSkipPointMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).addSkipPointMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).addSkipPointMark();
            } else {
                throw new IllegalArgumentException(
                        "Adding skip point mark is not implemented for type " + part.getClass());
            }
        }
        part.setSkippointStatus(true);
    }

    /**
     * This method remove breakpoint mark from the selected edit part
     */
    public static void removeBreakpointMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            ((FixedSizedAbstractMediator) part).getPrimaryShape().removeBreakpointMark();
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).removeBreakpointMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).removeBreakpointMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).removeBreakpointMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).removeBreakpointMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).removeBreakpointMark();
            } else {
                throw new IllegalArgumentException(
                        "Removing break point mark is not implemented for type " + part.getClass());
            }
        }
        part.setBreakpointStatus(false);
    }

    /**
     * This method remove skip point mark from the selected edit part
     */
    public static void removeSkippointMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            ((FixedSizedAbstractMediator) part).getPrimaryShape().removeSkipPointMark();
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).removeSkipPointMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).removeSkipPointMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).removeSkipPointMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).removeSkipPointMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).removeSkipPointMark();
            } else {
                throw new IllegalArgumentException(
                        "Removing skip point mark is not implemented for type " + part.getClass());
            }
        }
        part.setSkippointStatus(false);
    }

    /**
     * This method add debug points for registered debug point mediators in the
     * given ESBServer
     * 
     * It finds the related project type and get the relevant
     * {@link IMediatorLocator} implementation from
     * {@link MediatorLocatorFactory}
     * 
     * @param server
     * @param editorInput
     * @throws ESBDebuggerException
     */
    public static void addDesignViewDebugPoints(EsbServer server, IEditorInput editorInput)
            throws ESBDebuggerException {

        if (editorInput instanceof FileEditorInput) {
            IFile file = ((FileEditorInput) editorInput).getFile();
            IMediatorLocator mediatorLocator = MediatorLocatorFactory.getMediatorLocator(server.getType());
            if (mediatorLocator != null) {
                addDebugPointMarkForExistingDebugPoints(server, file, mediatorLocator);
            }
        }
    }

    /**
     * This method give the ESB Mediation property context name from the UI
     * representation of the scope name
     * 
     * @param name
     * @return
     */
    public static String getPropertyContextNameOfUIPropertyName(String name) {
        switch (name) {
        case AXIS2_PROPERTIES_TAG:
            return AXIS2_PROPERTY_TAG;
        case AXIS2_CLIENT_PROPERTIES_TAG:
            return AXIS2_CLIENT_PROPERTY_TAG;
        case SYNAPSE_PROPERTIES_TAG:
            return SYANPSE_PROPERTY_TAG;
        case TRANSPORT_PROPERTIES_TAG:
            return TRANSPORT_PROPERTY_TAG;
        case OPERATION_PROPERTIES_TAG:
            return OPERATION_PROPERTY_TAG;
        }
        return name;
    }

    private static AbstractESBDebugPointMessage getSequenceTypeDebugPoint(EventMessageType event,
            JsonElement recievedArtifactInfo) {
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        if (entrySet.size() == NUM_OF_ENTRIES_IN_COMPLEX_SEQ_TYPE) {
            for (Entry<String, JsonElement> entry : entrySet) {
                if (ESBDebuggerConstants.PROXY_LABEL.equalsIgnoreCase(entry.getKey())) {
                    return new ESBProxyDebugPointMessage(event, recievedArtifactInfo);
                } else if (ESBDebuggerConstants.API_LABEL.equalsIgnoreCase(entry.getKey())) {
                    return new ESBAPIDebugPointMessage(event, recievedArtifactInfo);
                } else if (ESBDebuggerConstants.INBOUND_ENDPOINT_LABEL.equalsIgnoreCase(entry.getKey())) {
                    return new ESBInboundEndpointDebugPointMessage(event, recievedArtifactInfo);
                }
            }
        } else {
            return new ESBSequenceDebugPointMessage(event, recievedArtifactInfo);
        }
        throw new IllegalArgumentException(
                "Illegal sequence artifact type recived.Artifact should be sequence, proxy inbound or api : "
                        + recievedArtifactInfo.toString());
    }

    private static ESBTemplateDebugPointMessage getTemplateDebugPoint(EventMessageType event,
            JsonElement recievedArtifactInfo) {
        return new ESBTemplateDebugPointMessage(event, recievedArtifactInfo);
    }

    /**
     * This method add debug point mark and hit status mark for relevant
     * mediators
     * 
     * @param server
     * @param file
     * @param mediatorLocator
     * @throws MediatorNotFoundException
     * @throws MissingAttributeException
     * @throws DebugPointMarkerNotFoundException
     */
    private static void addDebugPointMarkForExistingDebugPoints(EsbServer server, IFile file,
            IMediatorLocator mediatorLocator)
            throws MediatorNotFoundException, MissingAttributeException, DebugPointMarkerNotFoundException {
        IBreakpoint[] suspendPoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebuggerConstants.SUSPEND_POINT_MODEL_ID);
        IBreakpoint[] breakpoints = getDebugPointsInFile(file);
        for (IBreakpoint breakpoint : breakpoints) {
            try {
                EditPart editPart = mediatorLocator.getMediatorEditPart(server, (ESBDebugPoint) breakpoint);
                if (editPart instanceof AbstractMediator) {

                    if (((ESBDebugPoint) breakpoint).isBreakpoint()) {
                        addBreakpointMark((AbstractMediator) editPart);
                    } else if (((ESBDebugPoint) breakpoint).isSkippoint()) {
                        addSkippointMark((AbstractMediator) editPart);
                    }

                    if (isSuspendedBreakpoint(suspendPoints, breakpoint)) {
                        AbstractMediator hitEditPart = OpenEditorUtil.getPreviousHitEditPart();
                        if (hitEditPart != null) {
                            hitEditPart.setBreakpointHitStatus(false);
                            hitEditPart.setSelected(EditPart.SELECTED_NONE);
                        }
                        ((AbstractMediator) editPart).setBreakpointHitStatus(true);
                        while (true) {
                            if (((AbstractMediator) editPart).isBreakpointHit()) {
                                break;
                            }
                        }
                        editPart.setSelected(EditPart.SELECTED);
                        OpenEditorUtil.setPreviousHitEditPart((AbstractMediator) editPart);
                        OpenEditorUtil.setToolTipMessageOnMediator();
                    }
                }
            } catch (CoreException | DebugPointMarkerNotFoundException e) {
                log.error("Error while adding debug point mark : " + e.getMessage(), e);
            }
        }
    }

    /**
     * This method returns EditPart map of the current active editor
     * 
     * @param editPartMap
     */
    private static Map<EObject, ShapeNodeEditPart> getEditorEditPartMap() {

        Map<EObject, ShapeNodeEditPart> editPartMap = new HashMap<>();
        IEditorReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getEditorReferences();
        for (IEditorReference iEditorReference : references) {
            IEditorPart editorReference = iEditorReference.getEditor(true);
            if (editorReference instanceof EsbMultiPageEditor) {
                EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) iEditorReference.getEditor(true);
                // Do not consider the form editors
                if (esbMultiPageEditor.getDiagramEditPart() != null) {
                    @SuppressWarnings("rawtypes")
                    Map editPartRegistry = esbMultiPageEditor.getDiagramEditPart().getViewer().getEditPartRegistry();
                    for (Object object : editPartRegistry.keySet()) {
                        if (object instanceof Node) {
                            Node nodeImpl = (Node) object;
                            Object editPart = editPartRegistry.get(nodeImpl);
                            if (editPart instanceof ShapeNodeEditPart) {
                                editPartMap.put(nodeImpl.getElement(), (ShapeNodeEditPart) editPart);
                            }
                        }
                    }
                }
            }
        }
        return editPartMap;
    }

    /**
     * This method finds the registered debug points under resource file in the
     * Eclipse breakpointpoint manager
     * 
     * @param file
     * @return
     * @throws DebugPointMarkerNotFoundException
     */
    private static IBreakpoint[] getDebugPointsInFile(IFile file) throws DebugPointMarkerNotFoundException {
        IBreakpoint[] debugPoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        List<IBreakpoint> relatedBreakpoints = new ArrayList<>();
        for (IBreakpoint iBreakpoint : debugPoints) {
            if (file.equals(((ESBDebugPoint) iBreakpoint).getResource())) {
                relatedBreakpoints.add(iBreakpoint);
            }
        }
        return relatedBreakpoints.toArray(new IBreakpoint[relatedBreakpoints.size()]);
    }

    /**
     * This method checks whether targetBreakpoint in in the
     * suspendedBreakpoints list
     * 
     * @param suspendPoints
     * @param targetBreakpoint
     */
    private static boolean isSuspendedBreakpoint(IBreakpoint[] suspendPoints, IBreakpoint targetBreakpoint) {
        for (IBreakpoint suspendPoint : suspendPoints) {
            if (targetBreakpoint.equals(((ESBSuspendPoint) suspendPoint).getSuspendedPoint())) {
                return true;
            }
        }
        return false;
    }

    private static EsbServer getESBServerFromIEditorPart(IEditorPart activeEditor) throws ESBDebuggerException {
        Diagram diagram = ((EsbMultiPageEditor) (activeEditor)).getDiagram();
        if (diagram != null) {
            EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
            return esbDiagram.getServer();
        } else {
            return null;
        }
    }

    private static IResource getIResourceFromIEditorPart(IEditorPart activeEditor) {
        IFile file = ((FileEditorInput) (((EsbMultiPageEditor) activeEditor).getEditorInput())).getFile();
        return (IResource) file.getAdapter(IResource.class);
    }

    public static void setDeletedMediator(AbstractMediator editPart) {
        deletedMediator = editPart;
    }

    public static AbstractMediator getDeletedMediator() {
        return deletedMediator;
    }

    public static void setDeleteOperationPerformed(boolean status) {
        deleteOperationPerformed = status;
    }

    public static boolean isDeleteOperationPerformed() {
        return deleteOperationPerformed;
    }

    public static void setPageCreateOperationActivated(boolean status) {
        pageCreateOperationActivated = status;
    }

    public static boolean isPageCreateOperationActivated() {
        return pageCreateOperationActivated;
    }

    public static void setPageSaveOperationActivated(boolean status) {
        pageSaveOperationActivated = status;
    }

    public static boolean isPageSaveOperationActivated() {
        return pageSaveOperationActivated;
    }

    public static void setPageChangeOperationActivated(boolean status) {
        pageChangeOperationActivated = status;
    }

    public static boolean isPageChangeOperationActivated() {
        return pageChangeOperationActivated;
    }

    public static void setRecentlyAddedMediator(AbstractMediator addedMediator) {
        recentlyAddedMediator = addedMediator;
    }

    public static AbstractMediator getRecentlyAddedMediator() {
        return recentlyAddedMediator;
    }

}
