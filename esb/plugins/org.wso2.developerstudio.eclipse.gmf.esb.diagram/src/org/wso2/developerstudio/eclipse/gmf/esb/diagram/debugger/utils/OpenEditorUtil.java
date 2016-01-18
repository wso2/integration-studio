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

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SingleCompartmentComplexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.Deserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MissingAttributeException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.IMediatorLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl.MediatorLocatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class contains methods related to opening ESB Editors and updating debug point activities recived fron ESB
 * Server on artifacts
 *
 */
public class OpenEditorUtil {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static AbstractMediator previousHitPoint;
    private static String toolTipMessage;
    private static final String XML_ATTRIBUTE_SEPERATOR = "><";
    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE_STRING_OPERATOR = "\n";
    private static final String XML_ATTRIBUTE_START_TAG = "<";
    private static final String XML_ATTRIBUTE_CLOSE_TAG = ">";

    /**
     * This private constructor is to hide the implicit public constructor
     */
    private OpenEditorUtil() {
    }

    public static void removeBreakpointHitStatus() {
        if (previousHitPoint != null) {
            previousHitPoint.setBreakpointHitStatus(false);
            previousHitPoint.setSelected(EditPart.SELECTED_NONE);
        }
    }

    public static void setPreviousHitEditPart(AbstractMediator hitPoint) {
        previousHitPoint = hitPoint;
    }

    public static AbstractMediator getPreviousHitEditPart() {
        return previousHitPoint;
    }

    public static void setToolTipMessageOnMediator(String message) {
        toolTipMessage = message;
        AbstractMediator mediator = getPreviousHitEditPart();
        if (mediator instanceof FixedSizedAbstractMediator) {
            ((FixedSizedAbstractMediator) mediator).getPrimaryShape().setToolTipMessage(formatMessageEnvelope(message));
        } else if (mediator instanceof SingleCompartmentComplexFiguredAbstractMediator) {

            ((SingleCompartmentComplexFiguredAbstractMediator) mediator).getPrimaryShape().setToolTipMessage(
                    formatMessageEnvelope(message));

        } else if (mediator instanceof CloneMediatorEditPart) {
            ((CloneMediatorEditPart) mediator).getPrimaryShape().setToolTipMessage(formatMessageEnvelope(message));
        } else if (mediator instanceof EntitlementMediatorEditPart) {
            ((EntitlementMediatorEditPart) mediator).getPrimaryShape()
                    .setToolTipMessage(formatMessageEnvelope(message));
        } else if (mediator instanceof FilterMediatorEditPart) {
            ((FilterMediatorEditPart) mediator).getPrimaryShape().setToolTipMessage(formatMessageEnvelope(message));
        } else if (mediator instanceof SwitchMediatorEditPart) {
            ((SwitchMediatorEditPart) mediator).getPrimaryShape().setToolTipMessage(formatMessageEnvelope(message));
        } else if (mediator instanceof ThrottleMediatorEditPart) {
            ((ThrottleMediatorEditPart) mediator).getPrimaryShape().setToolTipMessage(formatMessageEnvelope(message));
        }
    }

    public static void setToolTipMessageOnMediator() {
        if (toolTipMessage != null) {
            setToolTipMessageOnMediator(toolTipMessage);
        } else {
            log.warn("Valid tooltip message is not yet registered");
        }
    }

    private static String formatMessageEnvelope(String string) {
        String[] envelopeAttributes = string.split(XML_ATTRIBUTE_SEPERATOR);
        String message = EMPTY_STRING;
        for (String attribute : envelopeAttributes) {
            if (attribute.startsWith(XML_ATTRIBUTE_START_TAG)) {
                message = message + attribute + XML_ATTRIBUTE_CLOSE_TAG + NEW_LINE_STRING_OPERATOR;
            } else {
                message = message + XML_ATTRIBUTE_START_TAG + attribute + XML_ATTRIBUTE_CLOSE_TAG
                        + NEW_LINE_STRING_OPERATOR;
            }
        }
        return message;
    }

    /**
     * Open the ESB diagram editor for the given ESB configuration file
     * 
     * @param fileTobeOpened
     */
    public static void openSeparateEditor(final IFile fileTobeOpened, final ESBDebugPoint breakpoint) {
        try {
            final String source = FileUtils.readFileToString(fileTobeOpened.getLocation().toFile());
            final Deserializer deserializer = Deserializer.getInstance();

            PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                    openFileOnEditor(fileTobeOpened, breakpoint, source, deserializer);
                }

                private void openFileOnEditor(final IFile fileTobeOpened, final ESBDebugPoint breakpoint,
                        final String source, final Deserializer deserializer) {
                    try {
                        ArtifactType artifactType = deserializer.getArtifactType(source);

                        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                .getActivePage();
                        IEditorPart openEditor = activePage.openEditor(new EsbEditorInput(null, fileTobeOpened,
                                artifactType.getLiteral()), EsbDiagramEditor.ID, true, IWorkbenchPage.MATCH_INPUT);
                        EsbMultiPageEditor multipageEitor = (EsbMultiPageEditor) openEditor;

                        drawSuspendedBreakpointMark(breakpoint, multipageEitor);

                    } catch (MediatorNotFoundException | MissingAttributeException e) {
                        log.warn("Error while drawing suspended breakpoint mark : " + e.getMessage(), e);
                    } catch (Exception e) {
                        log.error("Error occured while getting artifact type for the given ESB configuration ", e);
                    }
                }
            });

        } catch (IOException e) {
            log.error("Error occured while opening a separate editor", e);
        }
    }

    /**
     * This method will mark debug point as hit, in the given {@link EsbMultiPageEditor}
     * 
     * @param breakpoint
     * @param multipageEitor
     * @throws CoreException
     * @throws ESBDebuggerException
     */
    private static void drawSuspendedBreakpointMark(final ESBDebugPoint breakpoint, EsbMultiPageEditor multipageEitor)
            throws CoreException, ESBDebuggerException {

        Diagram diagram = multipageEitor.getDiagram();
        EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
        EsbServer esbServer = esbDiagram.getServer();
        AbstractEsbNodeDeserializer.setRootCompartment(multipageEitor.getDiagramEditPart());
        IMediatorLocator mediatorLocator = MediatorLocatorFactory.getMediatorLocator(esbServer.getType());
        if (mediatorLocator != null) {
            if (previousHitPoint != null) {
                previousHitPoint.setBreakpointHitStatus(false);
                previousHitPoint.setSelected(EditPart.SELECTED_NONE);
            }
            EditPart editPart = mediatorLocator.getMediatorEditPart(esbServer, breakpoint);

            if (editPart instanceof AbstractMediator) {
                ((AbstractMediator) editPart).setBreakpointHitStatus(true);
                while (true) {
                    if (((AbstractMediator) editPart).isBreakpointHit()) {
                        break;
                    }
                }
                editPart.setSelected(EditPart.SELECTED);
                previousHitPoint = ((AbstractMediator) editPart);
            }
        }
    }
}
