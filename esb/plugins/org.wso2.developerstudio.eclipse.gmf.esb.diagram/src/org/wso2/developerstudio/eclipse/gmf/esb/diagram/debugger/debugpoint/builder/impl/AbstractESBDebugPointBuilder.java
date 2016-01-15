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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ADVICE_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_OBLIGATIONS_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ON_ACCEPT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ON_REJECT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.FILTER_FAIL_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.FILTER_PASS_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MAIN_SEQUENCE_RELATIVE_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_DELETE_ACTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SWITCH_DEFAULT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.THROTTLE_ON_ACCEPT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.THROTTLE_ON_REJECT_CONTAINER_POSITION_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.IESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugModelPresentation;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbServerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneTargetContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementAdviceContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementObligationsContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementOnAcceptContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementOnRejectContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterFailContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterPassContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.MediatorFlowImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchCaseContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchCaseParentContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchDefaultParentContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleOnAcceptContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleOnRejectContainerImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * All ESBBreakpoint builders should extend AbstractESBBreakpointBuilder class.
 * This class contains common methods related to ESBBreakpointBuilders and
 * implements {@link IESBDebugPointBuilder}
 *
 */
public abstract class AbstractESBDebugPointBuilder implements IESBDebugPointBuilder {

    protected static final String EMPTY_STRING = "";
    protected static final int INDEX_OF_FIRST_ELEMENT = 0;
    private EObject innerContainerInstance;
    private EObject innerParentContainer;
    private Integer switchCasePosition;
    private Integer cloneTargetPosition;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This method takes mediator editpart and find and returns the immediate
     * container inside the given classType container.
     * 
     * @param part
     * @param classType
     * @return EditPart
     * @throws ESBDebuggerException
     *             if given classType container not found
     */
    protected EditPart getContainerFromEditPart(EditPart part, Class<?> classType) throws ESBDebuggerException {
        EditPart container = part;
        while (!(classType.isInstance(container.getParent()))) {
            container = container.getParent();
            if (container instanceof EsbServerEditPart || container == null) {
                throw new ESBDebuggerException(part + " : is included in an unexpected artifact type");
            }
        }
        return container;
    }

    /**
     * This method finds the fault sequence name and returns or if it is null
     * returns an empty string
     * 
     * @param element
     * @return String
     */
    protected String getFaultSequenceName(EObject element) {
        String faultSeqName = null;
        if (element instanceof ProxyServiceImpl) {
            faultSeqName = ((ProxyServiceImpl) element).getFaultSequenceName();
        } else if (element instanceof APIResource) {
            faultSeqName = ((APIResource) element).getFaultSequenceName();
        }
        if (faultSeqName != null) {
            return faultSeqName;
        } else {
            return EMPTY_STRING;
        }
    }

    /**
     * This method increment position of the breakpoints by one. It deletes the
     * older breakpoint and add the modified breakpoint.
     * 
     * @param breakpontList
     * @param position
     */
    protected void increaseBreakpointPosition(List<ESBDebugPoint> breakpontList, List<Integer> position) {
        for (ESBDebugPoint esbBreakpoint : breakpontList) {
            try {
                AbstractESBDebugPointMessage message = increasePositionOfTheMessage(esbBreakpoint.getLocation(),
                        position);
                ESBDebugPoint modifiedBreakpoint = new ESBDebugPoint(esbBreakpoint.getResource(),
                        esbBreakpoint.getLineNumber(), message);
                DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(modifiedBreakpoint);
                DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(esbBreakpoint, true);
            } catch (DebugPointMarkerNotFoundException e) {
                log.error("Error while increasing debug point position value" + e.getMessage(), e);
                ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(esbBreakpoint);
            } catch (CoreException e) {
                log.error("Error while increasing debug point position value", e);
            }
        }
    }

    /**
     * This method decrement position of the breakpoints by one. It deletes the
     * older breakpoint and add the modified breakpoint.
     * 
     * @param breakpontList
     * @param position
     */
    protected void decreaseBreakpointPosition(List<ESBDebugPoint> breakpontList, List<Integer> position) {
        for (ESBDebugPoint esbBreakpoint : breakpontList) {

            try {
                AbstractESBDebugPointMessage message = decreasePositionOfTheMessage(esbBreakpoint.getLocation(),
                        position);
                ESBDebugPoint modifiedBreakpoint = new ESBDebugPoint(esbBreakpoint.getResource(),
                        esbBreakpoint.getLineNumber(), message);
                DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(modifiedBreakpoint);
                DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(esbBreakpoint, true);
            } catch (DebugPointMarkerNotFoundException e) {
                log.error("Error while decreasing the debug point position :" + e.getMessage(), e);
                ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(esbBreakpoint);
            } catch (CoreException e) {
                log.error("Error while decreasing the debug point position :", e);
            }
        }
    }

    /**
     * Only breakpoints which contains a higher mediator position than added
     * mediator position are selected. Returns empty list for a negative
     * mediator position
     * 
     * @param resource
     * @param position
     * @return
     */
    protected static List<ESBDebugPoint> getDebugPointsRelatedToModification(IResource resource,
            List<Integer> position, String listSequence, String action) {
        List<ESBDebugPoint> breakpointList = new ArrayList<ESBDebugPoint>();
        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(ESBDebugModelPresentation.ID);
        for (IBreakpoint breakpoint : breakpoints) {
            try {
                IResource file = ((ESBDebugPoint) breakpoint).getResource();
                String listSequencePosition = EMPTY_STRING;
                if (file.equals(resource)) {
                    List<Integer> positionList = getMediatorPositionOfBreakpoint(breakpoint);
                    String sequnceType = EMPTY_STRING;
                    if (resource.getLocation().toString().endsWith(MAIN_SEQUENCE_RELATIVE_LOCATION)) {
                        listSequencePosition = EMPTY_STRING + (positionList.get(0));
                    } else {
                        sequnceType = getSequenceTypeOfBreakpoint(breakpoint);
                    }
                    if (listSequence.equalsIgnoreCase(listSequencePosition)
                            || listSequence.equalsIgnoreCase(sequnceType)) {
                        if (MEDIATOR_DELETE_ACTION.equals(action) && position.equals(positionList)) {
                            ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(breakpoint);
                        } else if (isBreakpointShouldInModifyingList(position, positionList)) {
                            breakpointList.add((ESBDebugPoint) breakpoint);
                        }
                    }
                }
            } catch (DebugPointMarkerNotFoundException e) {
                log.error("Error while retrieving Debug points related to modifications : " + e.getMessage(), e);
                ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(breakpoint);
            } catch (CoreException e) {
                log.error("Error while retrieving Debug points related to modifications : ", e);
            }

        }
        return breakpointList;
    }

    /**
     * Returns mediator position of abstractMediator in the mediation flow
     * starting from outputConnector Returns -1 if not found this mediator in
     * the mediation flow.
     * 
     * @param outputConnector
     * @param abstractMediator
     * @return List<Integer>
     * @throws MediatorNotFoundException
     */
    protected List<Integer> getMediatorPosition(OutputConnector outputConnector, AbstractMediator newMediator)
            throws MediatorNotFoundException {
        EObject newMediatorImpl = ((NodeImpl) newMediator.getModel()).getElement();
        return getMediatorPosition(outputConnector, newMediatorImpl);
    }

    /**
     * This method returns mediator position in sequence specified by the
     * output-connector. Returns Empty String if selection editpart not found in
     * mediation flow.
     * 
     * @param outConnector
     * @param selection
     * @return positionList Array
     * @throws MediatorNotFoundException
     */
    protected List<Integer> getMediatorPosition(OutputConnector outConnector, EObject selection)
            throws MediatorNotFoundException {
        List<Integer> positionList = new ArrayList<>();
        Stack<EObject> parentStack = getParentMediatorStack((MediatorImpl) selection);
        parentStack.pop();// removing the Super Parent
                          // Container(Proxy,Sequence,...)
        parentStack = removeTopObjectsUntilFirstMediator(parentStack);
        EObject mediatorImpl = parentStack.pop();
        OutputConnector tempConnector = outConnector;
        do {
            int count = 0;
            while (isValidConnectorToProceed(tempConnector)) {
                EsbLink outgoingLink = tempConnector.getOutgoingLink();
                if (outgoingLink != null && outgoingLink.getTarget() != null) {
                    EObject mediator = outgoingLink.getTarget().eContainer();
                    if (isMediatorChainEnded(mediator)) {
                        throw new MediatorNotFoundException("Selected Mediator is not found in a valid position");
                    } else if (mediator.equals(mediatorImpl)) {
                        positionList.add(count);
                        if (parentStack.isEmpty()) {
                            return positionList;
                        }
                        if (isComplexListMediator(mediatorImpl)) {
                            positionList.add(getPositionOfInnerContainer(parentStack, mediatorImpl));
                        }
                        if (isComplexMediatorType(mediatorImpl)) {
                            tempConnector = getNextMediatorOutputConnector(mediatorImpl);
                        } else {
                            tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediatorImpl);
                        }
                        mediatorImpl = getNextMediatorFromParentStack(parentStack);
                        break;
                    } else {
                        count++;
                        tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediator);
                    }
                } else {
                    throw new MediatorNotFoundException("Mediation flow diagram error");
                }
            }

        } while (mediatorImpl instanceof MediatorImpl);

        throw new MediatorNotFoundException(
                "Selected Mediator is not found in a valid position. Unknown Complex Mediator Type found : "
                        + mediatorImpl.getClass());
    }

    private Stack<EObject> removeTopObjectsUntilFirstMediator(Stack<EObject> parentStack) {
        while (!(parentStack.peek() instanceof MediatorImpl)) {
            parentStack.pop();
            if (parentStack.isEmpty()) {
                throw new IllegalArgumentException(
                        "Valid MediatorImpl instance not found in the given parent instances stack ");
            }
        }
        return parentStack;
    }

    private Integer getPositionOfInnerContainer(Stack<EObject> parentStack, EObject mediatorImpl) {
        if (mediatorImpl instanceof FilterMediatorImpl) {
            parentStack.pop();
            innerContainerInstance = parentStack.pop();
            if (innerContainerInstance instanceof FilterPassContainerImpl) {
                return FILTER_PASS_CONTAINER_POSITION_VALUE;
            } else if (innerContainerInstance instanceof FilterFailContainerImpl) {
                return FILTER_FAIL_CONTAINER_POSITION_VALUE;
            } else {
                throw new IllegalArgumentException("Unknown Filter Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof SwitchMediatorImpl) {
            parentStack.pop();
            innerParentContainer = parentStack.pop();

            if (innerParentContainer instanceof SwitchCaseParentContainerImpl) {
                SwitchCaseContainerImpl switchCase = (SwitchCaseContainerImpl) parentStack.pop();
                EList<SwitchCaseContainer> switchCaseContainerList = ((SwitchCaseParentContainerImpl) innerParentContainer)
                        .getSwitchCaseContainer();
                switchCasePosition = 1;
                for (SwitchCaseContainer switchCaseContainerImpl : switchCaseContainerList) {
                    if (switchCaseContainerImpl.equals(switchCase)) {
                        innerContainerInstance = switchCase;
                        return switchCasePosition;
                    } else {
                        switchCasePosition++;
                    }
                }
            } else if (innerParentContainer instanceof SwitchDefaultParentContainerImpl) {
                return SWITCH_DEFAULT_CONTAINER_POSITION_VALUE;
            } else {
                throw new IllegalArgumentException(
                        "Required SwitchCaseContainerImpl instance not found in switchCaseContainerList ");
            }

        } else if (mediatorImpl instanceof ThrottleMediatorImpl) {
            parentStack.pop();
            innerContainerInstance = parentStack.pop();
            if (innerContainerInstance instanceof ThrottleOnAcceptContainerImpl) {
                return THROTTLE_ON_ACCEPT_CONTAINER_POSITION_VALUE;
            } else if (innerContainerInstance instanceof ThrottleOnRejectContainerImpl) {
                return THROTTLE_ON_REJECT_CONTAINER_POSITION_VALUE;
            } else {
                throw new IllegalArgumentException("Unknown Throttle Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof EntitlementMediatorImpl) {
            parentStack.pop();
            innerContainerInstance = parentStack.pop();
            if (innerContainerInstance instanceof EntitlementOnRejectContainerImpl) {
                return ENTITLEMENT_ON_REJECT_CONTAINER_POSITION_VALUE;
            } else if (innerContainerInstance instanceof EntitlementOnAcceptContainerImpl) {
                return ENTITLEMENT_ON_ACCEPT_CONTAINER_POSITION_VALUE;
            } else if (innerContainerInstance instanceof EntitlementAdviceContainerImpl) {
                return ENTITLEMENT_ADVICE_CONTAINER_POSITION_VALUE;
            } else if (innerContainerInstance instanceof EntitlementObligationsContainerImpl) {
                return ENTITLEMENT_OBLIGATIONS_CONTAINER_POSITION_VALUE;
            } else {
                throw new IllegalArgumentException("Unknown Throttle Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof CloneMediatorImpl) {
            innerParentContainer = parentStack.pop();
            if (innerParentContainer instanceof CloneMediatorContainerImpl) {
                CloneTargetContainerImpl cloneTarget = (CloneTargetContainerImpl) parentStack.pop();
                EList<CloneTargetContainer> cloneTargetContainerList = ((CloneMediatorContainerImpl) innerParentContainer)
                        .getCloneTargetContainer();
                cloneTargetPosition = 0;
                for (CloneTargetContainer switchCaseContainerImpl : cloneTargetContainerList) {
                    if (switchCaseContainerImpl.equals(cloneTarget)) {
                        innerContainerInstance = cloneTarget;
                        return cloneTargetPosition;
                    } else {
                        cloneTargetPosition++;
                    }
                }
            } else if (innerParentContainer instanceof SwitchDefaultParentContainerImpl) {
                return SWITCH_DEFAULT_CONTAINER_POSITION_VALUE;
            } else {
                throw new IllegalArgumentException(
                        "Required SwitchCaseContainerImpl instance not found in switchCaseContainerList ");
            }
        }
        throw new IllegalArgumentException("Unknown multiple inner sequence mediator found : "
                + mediatorImpl.getClass());

    }

    private EObject getNextMediatorFromParentStack(Stack<EObject> parentStack) {
        EObject nextImpl = parentStack.pop();
        while (!(nextImpl instanceof MediatorImpl)) {
            if (parentStack.isEmpty()) {
                throw new IllegalArgumentException(
                        "Valid MediatorImpl instance not found in the given parent instances stack ");
            }
            nextImpl = parentStack.pop();
        }
        return nextImpl;
    }

    private OutputConnector getNextMediatorOutputConnector(EObject mediatorImpl) {
        if (mediatorImpl instanceof FilterMediatorImpl) {
            if (innerContainerInstance instanceof FilterPassContainerImpl) {
                return ((FilterMediatorImpl) mediatorImpl).getPassOutputConnector();
            } else if (innerContainerInstance instanceof FilterFailContainerImpl) {
                return ((FilterMediatorImpl) mediatorImpl).getFailOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Filter Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof SwitchMediatorImpl) {
            if (innerParentContainer instanceof SwitchCaseParentContainerImpl) {
                return ((SwitchMediatorImpl) mediatorImpl).getCaseBranches().get(switchCasePosition - 1);

            } else if (innerParentContainer instanceof SwitchDefaultParentContainerImpl) {
                return ((SwitchMediatorImpl) mediatorImpl).getDefaultBranch();
            } else {
                throw new IllegalArgumentException("Unknown Switch Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof ThrottleMediatorImpl) {
            if (innerContainerInstance instanceof ThrottleOnAcceptContainerImpl) {
                return ((ThrottleMediatorImpl) mediatorImpl).getOnAcceptOutputConnector();
            } else if (innerContainerInstance instanceof ThrottleOnRejectContainerImpl) {
                return ((ThrottleMediatorImpl) mediatorImpl).getOnRejectOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Filter Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof EntitlementMediatorImpl) {
            if (innerContainerInstance instanceof EntitlementOnRejectContainerImpl) {
                return ((EntitlementMediatorImpl) mediatorImpl).getOnRejectOutputConnector();
            } else if (innerContainerInstance instanceof EntitlementOnAcceptContainerImpl) {
                return ((EntitlementMediatorImpl) mediatorImpl).getOnAcceptOutputConnector();
            } else if (innerContainerInstance instanceof EntitlementAdviceContainerImpl) {
                return ((EntitlementMediatorImpl) mediatorImpl).getAdviceOutputConnector();
            } else if (innerContainerInstance instanceof EntitlementObligationsContainerImpl) {
                return ((EntitlementMediatorImpl) mediatorImpl).getObligationsOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Entitlement Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof CloneMediatorImpl) {
            if (innerParentContainer instanceof CloneMediatorContainerImpl) {
                return ((CloneMediatorImpl) mediatorImpl).getTargetsOutputConnector().get(cloneTargetPosition);
            } else {
                throw new IllegalArgumentException("Unknown Clone Mediator Container type found : "
                        + innerContainerInstance.getClass());
            }
        } else if (mediatorImpl instanceof ValidateMediatorImpl) {
            return ((ValidateMediatorImpl) mediatorImpl).getOnFailOutputConnector();
        } else if (mediatorImpl instanceof CacheMediatorImpl) {
            return ((CacheMediatorImpl) mediatorImpl).getOnHitOutputConnector();
        } else if (mediatorImpl instanceof ForEachMediatorImpl) {
            return ((ForEachMediatorImpl) mediatorImpl).getTargetOutputConnector();
        } else if (mediatorImpl instanceof AggregateMediatorImpl) {
            return ((AggregateMediatorImpl) mediatorImpl).getOnCompleteOutputConnector();
        } else if (mediatorImpl instanceof RuleMediatorImpl) {
            return ((RuleMediatorImpl) mediatorImpl).getChildMediatorsOutputConnector();
        } else if (mediatorImpl instanceof IterateMediatorImpl) {
            return ((IterateMediatorImpl) mediatorImpl).getTargetOutputConnector();
        } else {
            throw new IllegalArgumentException("Unknown Complex Mediator type found : " + mediatorImpl.getClass());
        }
    }

    public static boolean isComplexMediatorType(EObject mediatorImpl) {
        if (mediatorImpl instanceof FilterMediatorImpl || mediatorImpl instanceof SwitchMediatorImpl
                || mediatorImpl instanceof ThrottleMediatorImpl || mediatorImpl instanceof EntitlementMediatorImpl
                || mediatorImpl instanceof CloneMediatorImpl || mediatorImpl instanceof ValidateMediatorImpl
                || mediatorImpl instanceof CacheMediatorImpl || mediatorImpl instanceof AggregateMediatorImpl
                || mediatorImpl instanceof ForEachMediatorImpl || mediatorImpl instanceof RuleMediatorImpl
                || mediatorImpl instanceof IterateMediatorImpl) {
            return true;
        }
        return false;
    }

    public static boolean isComplexListMediator(EObject mediatorImpl) {
        if (mediatorImpl instanceof FilterMediatorImpl || mediatorImpl instanceof SwitchMediatorImpl
                || mediatorImpl instanceof ThrottleMediatorImpl || mediatorImpl instanceof EntitlementMediatorImpl
                || mediatorImpl instanceof CloneMediatorImpl) {
            return true;
        }
        return false;
    }

    private Stack<EObject> getParentMediatorStack(MediatorImpl selection) throws MediatorNotFoundException {
        EObject parentMediator = selection;
        Stack<EObject> parentStack = new Stack<>();
        parentStack.push(parentMediator);
        while (!isMediatorChainEnded(parentMediator)) {
            parentStack.addAll(getParentMediatorImpl((MediatorImpl) parentMediator));
            parentMediator = parentStack.peek();
        }
        return parentStack;
    }

    private Stack<EObject> getParentMediatorImpl(MediatorImpl childMediator) throws MediatorNotFoundException {
        MediatorFlowImpl parentMediationFlowImpl = (MediatorFlowImpl) (childMediator).eContainer();
        Stack<EObject> mediatorStack = new Stack<>();
        EObject nextImpl = parentMediationFlowImpl;
        do {
            nextImpl = nextImpl.eContainer();
            mediatorStack.push(nextImpl);
            if (nextImpl instanceof MediatorImpl || isMediatorChainEnded(nextImpl)) {
                return mediatorStack;
            }
        } while (!(nextImpl instanceof MediatorFlowImpl));
        throw new MediatorNotFoundException("Valid parent mediator can not be found for : " + childMediator.toString());
    }

    /**
     * This method returns mediator position in fault sequence.
     * 
     * @param elementList
     * @param AbstractMediator
     * @return
     * @throws MediatorNotFoundException
     */
    protected List<Integer> getMediatorPositionInFaultSeq(EList<EsbElement> elementList, AbstractMediator selection)
            throws MediatorNotFoundException {
        MediatorImpl selectionImpl = (MediatorImpl) ((NodeImpl) selection.getModel()).getElement();
        EList<EsbElement> restructuredElementList = null;
        if (elementList.contains(selectionImpl)) {
            restructuredElementList = restructureMediatorList(elementList, selectionImpl);
        }
        return getMediatorPositionInFaultSeq(restructuredElementList, selectionImpl);
    }

    private EList<EsbElement> restructureMediatorList(EList<EsbElement> eList, MediatorImpl selectionImpl) {
        int eListSize = eList.size();
        for (int index = 0; index < eListSize; index++) {
            Mediator esbElement = (Mediator) eList.get(index);
            OutputConnector tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) esbElement);
            EsbLink outgoingLink = tempConnector.getOutgoingLink();
            if (outgoingLink != null && outgoingLink.getTarget() != null) {
                EObject mediator = outgoingLink.getTarget().eContainer();
                if (mediator.equals(selectionImpl)) {
                    eList.move(index, selectionImpl);
                    break;
                }
            }
        }
        return eList;
    }

    /**
     * This method returns mediator position in fault sequence.
     * 
     * @param eList
     * @param EObject
     * @return
     * @throws MediatorNotFoundException
     */
    protected List<Integer> getMediatorPositionInFaultSeq(EList<EsbElement> eList, EObject selection)
            throws MediatorNotFoundException {
        int count = 1;
        Stack<EObject> parentStack = getParentMediatorStack((MediatorImpl) selection);
        parentStack.pop();// removing the Super Parent
                          // Container(Proxy,Sequence,...)
        parentStack = removeTopObjectsUntilFirstMediator(parentStack);
        EObject mediatorImpl = parentStack.pop();
        List<Integer> positionList = new ArrayList<>();
        for (EsbElement mediator : eList) {
            if (mediator.equals(mediatorImpl)) {
                positionList.add(eList.size() - count);
                if (parentStack.isEmpty()) {
                    return positionList;
                }
                break;
            } else {
                count++;
            }
        }
        OutputConnector tempConnector;
        if (isComplexListMediator(mediatorImpl)) {
            positionList.add(getPositionOfInnerContainer(parentStack, mediatorImpl));
        }
        if (isComplexMediatorType(mediatorImpl)) {
            tempConnector = getNextMediatorOutputConnector(mediatorImpl);
        } else {
            tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediatorImpl);
        }
        mediatorImpl = getNextMediatorFromParentStack(parentStack);
        do {
            count = 0;
            while (isValidConnectorToProceed(tempConnector)) {
                EsbLink outgoingLink = tempConnector.getOutgoingLink();
                if (outgoingLink != null && outgoingLink.getTarget() != null) {
                    EObject mediator = outgoingLink.getTarget().eContainer();
                    if (isMediatorChainEnded(mediator)) {
                        throw new MediatorNotFoundException("Selected Mediator is not found in a valid position");
                    } else if (mediator.equals(mediatorImpl)) {
                        positionList.add(count);
                        if (parentStack.isEmpty()) {
                            return positionList;
                        }
                        if (isComplexListMediator(mediatorImpl)) {
                            positionList.add(getPositionOfInnerContainer(parentStack, mediatorImpl));
                        }
                        if (isComplexMediatorType(mediatorImpl)) {
                            tempConnector = getNextMediatorOutputConnector(mediatorImpl);
                        } else {
                            tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediatorImpl);
                        }
                        mediatorImpl = getNextMediatorFromParentStack(parentStack);
                        break;
                    } else {
                        count++;
                        tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediator);
                    }
                } else {
                    throw new MediatorNotFoundException("Mediation flow diagram error");
                }
            }

        } while (mediatorImpl instanceof MediatorImpl);

        throw new MediatorNotFoundException(selection + " Mediator not found in Fault Sequence");
    }

    private AbstractESBDebugPointMessage increasePositionOfTheMessage(
            AbstractESBDebugPointMessage esbDebugPointMessage, List<Integer> position) {
        List<Integer> positionArray = esbDebugPointMessage.getMediatorPosition().getPosition();
        int modifiedPositionValue = positionArray.get(position.size() - 1) + 1;
        positionArray.set(position.size() - 1, modifiedPositionValue);
        esbDebugPointMessage.setMediatorPosition(positionArray);
        return esbDebugPointMessage;
    }

    private AbstractESBDebugPointMessage decreasePositionOfTheMessage(
            AbstractESBDebugPointMessage esbDebugPointMessage, List<Integer> position) {
        List<Integer> positionArray = esbDebugPointMessage.getMediatorPosition().getPosition();
        int modifiedPositionValue = positionArray.get(position.size() - 1) - 1;
        positionArray.set(position.size() - 1, modifiedPositionValue);
        esbDebugPointMessage.setMediatorPosition(positionArray);
        return esbDebugPointMessage;
    }

    private static boolean isBreakpointShouldInModifyingList(List<Integer> addedMediatorPosition,
            List<Integer> breakpointPosition) {
        int addedMediatorLastPositionValueIndex = addedMediatorPosition.size() - 1;
        for (int positionIndex = 0; positionIndex < addedMediatorLastPositionValueIndex; positionIndex++) {
            if (!addedMediatorPosition.get(positionIndex).equals(breakpointPosition.get(positionIndex))) {
                return false;
            }
        }
        if (addedMediatorPosition.get(addedMediatorLastPositionValueIndex) <= breakpointPosition
                .get(addedMediatorLastPositionValueIndex)) {
            return true;
        }
        return false;
    }

    private boolean isValidConnectorToProceed(OutputConnector tempConnector) {
        return tempConnector instanceof OutputConnector;
    }

    private static String getSequenceTypeOfBreakpoint(IBreakpoint breakpoint) throws DebugPointMarkerNotFoundException,
            CoreException {
        return ((ESBDebugPoint) breakpoint).getLocation().getSequenceType();
    }

    /**
     * Returns mediator position String of the breakpoint
     * 
     * @param breakpoint
     * @return String
     * @throws CoreException
     * @throws DebugPointMarkerNotFoundException
     */
    private static List<Integer> getMediatorPositionOfBreakpoint(IBreakpoint breakpoint)
            throws DebugPointMarkerNotFoundException, CoreException {
        AbstractESBDebugPointMessage message = ((ESBDebugPoint) breakpoint).getLocation();
        return message.getMediatorPosition().getPosition();
    }

    /**
     * This method checks whether the mediation flow came to an end
     * 
     * @param mediator
     * @return
     */
    private boolean isMediatorChainEnded(EObject mediator) {
        if (mediator instanceof SequencesImpl || mediator instanceof ProxyServiceImpl
                || mediator instanceof APIResourceImpl || mediator instanceof TemplateImpl) {
            return true;
        }
        return false;
    }

}
