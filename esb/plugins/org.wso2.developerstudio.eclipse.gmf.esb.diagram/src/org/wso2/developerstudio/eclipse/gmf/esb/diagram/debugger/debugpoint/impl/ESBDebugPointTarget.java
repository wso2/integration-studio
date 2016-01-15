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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.IESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl.ESBDebugPointBuilderFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugModelPresentation;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This is a utility class which contains methods related to breakpoints
 *
 */
public class ESBDebugPointTarget {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This private constructor is for hide the implicit public constructor
     */
    private ESBDebugPointTarget() {
    }

    /**
     * This method checks whether selected line can be assign as a line
     * breakpoint.
     */
    public static boolean canToggleLineDebugPoints(IWorkbenchPart part, ISelection selection) {
        // TODO This function should implement when source view breakpoints are
        // adding to debugger
        return false;
    }

    /**
     * This method checks whether selected part can be assign as a diagram
     * breakpoint.
     * 
     * @param part
     * @return
     */
    public static boolean canToggleDiagramDebugpoints(EditPart part) {
        return true;
    }

    /**
     * This method performs the source view breakpoint insertion action
     */
    public static void toggleLineDebugpoints(IWorkbenchPart part, ISelection selection) {
        // This method should be implement to support source view breakpoints
        throw new UnsupportedOperationException("Line breakpoint are not supported");
    }

    /**
     * This method performs the graphical view breakpoint insertion action
     * 
     * @param part
     * @throws CoreException
     * @throws ESBDebuggerException
     */
    public static void toggleDiagramDebugpoints(AbstractMediator part, String commandArgument) throws CoreException,
            ESBDebuggerException {

        IEditorPart activeEditor = EditorUtils.getActiveEditor();

        if (activeEditor instanceof EsbMultiPageEditor) {

            EsbServer esbServer = getESBServerFromESBMultiPageEditor(activeEditor);
            IESBDebugPointBuilder breakpointBuilder = ESBDebugPointBuilderFactory.getBreakpointBuilder(esbServer
                    .getType());
            IResource resource = getFileIResourceFromESBMultiPageEditor(activeEditor);
            ESBDebugPoint debugPoint = breakpointBuilder.getESBDebugPoint(esbServer, resource, part, commandArgument);
            ESBDebugPoint existingBreakpoint = getMatchingDebugPoint(debugPoint);
            if (existingBreakpoint == null) {
                DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(debugPoint);
                if (ESBDebuggerConstants.BREAKPOINT_LABEL.equals(commandArgument)) {
                    ESBDebuggerUtil.addBreakpointMark(part);
                } else {
                    ESBDebuggerUtil.addSkippointMark(part);
                }
            } else {
                debugPoint.getMarker().delete();
                ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(existingBreakpoint);
                if (ESBDebuggerConstants.BREAKPOINT_LABEL.equals(commandArgument)) {
                    ESBDebuggerUtil.removeBreakpointMark(part);
                } else {
                    ESBDebuggerUtil.removeSkippointMark(part);
                }
            }
        }
    }

    /**
     * @param activeEditor
     * @return
     */
    private static IResource getFileIResourceFromESBMultiPageEditor(IEditorPart activeEditor) {
        IFile file = ((FileEditorInput) (((EsbMultiPageEditor) activeEditor).getEditorInput())).getFile();
        return (IResource) file.getAdapter(IResource.class);
    }

    /**
     * @param activeEditor
     * @return
     */
    private static EsbServer getESBServerFromESBMultiPageEditor(IEditorPart activeEditor) {
        Diagram diagram = ((EsbMultiPageEditor) (activeEditor)).getDiagram();
        EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
        return esbDiagram.getServer();
    }

    /**
     * This method finds similar mediator registered as a breakpoint in the
     * BreakpointManager and returns.
     * 
     * @param targetBreakpoint
     * @return ESBBreakpoint if found or null
     */
    private static ESBDebugPoint getMatchingDebugPoint(ESBDebugPoint targetBreakpoint) {
        IBreakpoint[] debugpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint debugpoint : debugpoints) {
            try {
                ESBDebugPoint esbDebugpoint = (ESBDebugPoint) debugpoint;
                if ((esbDebugpoint.getResource()).equals(targetBreakpoint.getResource())
                        && esbDebugpoint.equals(targetBreakpoint)) {
                    return esbDebugpoint;
                }
            } catch (DebugPointMarkerNotFoundException e) {
                log.error("Error while checking the maching debug point : " + e.getMessage(), e);
                ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(debugpoint);
            }

        }
        return null;
    }
}
