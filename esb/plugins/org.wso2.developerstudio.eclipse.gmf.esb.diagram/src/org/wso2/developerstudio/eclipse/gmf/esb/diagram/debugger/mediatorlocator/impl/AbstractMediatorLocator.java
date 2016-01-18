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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ADVICE_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_OBLIGATIONS_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ON_ACCEPT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ENTITLEMENT_ON_REJECT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.FILTER_FAIL_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.FILTER_PASS_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SWITCH_DEFAULT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.THROTTLE_ON_ACCEPT_CONTAINER_POSITION_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.THROTTLE_ON_REJECT_CONTAINER_POSITION_VALUE;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl.AbstractESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.IMediatorLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.AggregateMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ThrottleMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl;

/**
 * This class should be implemented by all Mediator locator class
 * implementations.
 * <P>
 * Common methods needed by mediator locators are implemented in this class and it implements {@link IMediatorLocator}
 * interface
 *
 */
public abstract class AbstractMediatorLocator implements IMediatorLocator {

    protected static final String MEDIATOR_POSITION_SEPERATOR = " ";
    protected static final int INDEX_OF_FIRST_ELEMENT = 0;
    private static final String EMPTY_STRING = "";

    protected EditPart getMediatorFromMediationFlow(OutputConnector tempConnector, List<Integer> mediatorPosition)
            throws MediatorNotFoundException {
        int count = 0;
        while (tempConnector != null) {
            EsbLink outgoingLink = tempConnector.getOutgoingLink();
            if (outgoingLink != null && outgoingLink.getTarget() != null) {
                EObject mediator = outgoingLink.getTarget().eContainer();
                if (count == mediatorPosition.get(INDEX_OF_FIRST_ELEMENT)) {
                    mediatorPosition.remove(INDEX_OF_FIRST_ELEMENT);
                    if (AbstractESBDebugPointBuilder.isComplexMediatorType(mediator) && !mediatorPosition.isEmpty()) {
                        count = 0;
                        if (AbstractESBDebugPointBuilder.isComplexListMediator(mediator)) {
                            tempConnector = getInnerListOutputConnector(mediator,
                                    mediatorPosition.remove(INDEX_OF_FIRST_ELEMENT));
                        } else {
                            tempConnector = getInnerOutputConnector((Mediator) mediator);
                        }
                    } else {
                        return ESBDebuggerUtil.getEditorEditpart(mediator);
                    }
                } else {
                    count++;
                    if (mediator instanceof Mediator) {
                        tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediator);
                    }
                }
            } else {
                throw new MediatorNotFoundException("Mediation flow diagram error");
            }
        }
        throw new IllegalArgumentException("tempConnector argument is null");
    }

    private OutputConnector getInnerOutputConnector(Mediator mediatorImpl) {
        if (mediatorImpl instanceof CloneMediatorImpl) {
            return ((CloneMediatorImpl) mediatorImpl).getTargetsOutputConnector().get(0);
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

    private OutputConnector getInnerListOutputConnector(EObject mediatorImpl, Integer position) {
        if (mediatorImpl instanceof FilterMediatorImpl) {
            if (position == FILTER_PASS_CONTAINER_POSITION_VALUE) {
                return ((FilterMediatorImpl) mediatorImpl).getPassOutputConnector();
            } else if (position == FILTER_FAIL_CONTAINER_POSITION_VALUE) {
                return ((FilterMediatorImpl) mediatorImpl).getFailOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Filter Mediator List position found : " + position);
            }
        } else if (mediatorImpl instanceof SwitchMediatorImpl) {
            if (position == SWITCH_DEFAULT_CONTAINER_POSITION_VALUE) {
                return ((SwitchMediatorImpl) mediatorImpl).getDefaultBranch();
            } else {
                EList<SwitchCaseBranchOutputConnector> caseBranches = ((SwitchMediatorImpl) mediatorImpl)
                        .getCaseBranches();
                if (caseBranches.size() >= position) {
                    return caseBranches.get(position - 1);
                } else {
                    throw new IllegalArgumentException("Unknown Switch Mediator List position found : " + position);
                }
            }
        } else if (mediatorImpl instanceof ThrottleMediatorImpl) {
            if (position == THROTTLE_ON_ACCEPT_CONTAINER_POSITION_VALUE) {
                return ((ThrottleMediatorImpl) mediatorImpl).getOnAcceptOutputConnector();
            } else if (position == THROTTLE_ON_REJECT_CONTAINER_POSITION_VALUE) {
                return ((ThrottleMediatorImpl) mediatorImpl).getOnRejectOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Throttle Mediator List position found : " + position);
            }
        } else if (mediatorImpl instanceof EntitlementMediatorImpl) {
            if (position == ENTITLEMENT_ON_REJECT_CONTAINER_POSITION_VALUE) {
                return ((EntitlementMediatorImpl) mediatorImpl).getOnRejectOutputConnector();
            } else if (position == ENTITLEMENT_ON_ACCEPT_CONTAINER_POSITION_VALUE) {
                return ((EntitlementMediatorImpl) mediatorImpl).getOnAcceptOutputConnector();
            } else if (position == ENTITLEMENT_ADVICE_CONTAINER_POSITION_VALUE) {
                return ((EntitlementMediatorImpl) mediatorImpl).getAdviceOutputConnector();
            } else if (position == ENTITLEMENT_OBLIGATIONS_CONTAINER_POSITION_VALUE) {
                return ((EntitlementMediatorImpl) mediatorImpl).getObligationsOutputConnector();
            } else {
                throw new IllegalArgumentException("Unknown Entitlement Mediator List position found : " + position);
            }
        } else if (mediatorImpl instanceof CloneMediatorImpl) {
            EList<CloneMediatorTargetOutputConnector> targetBranches = ((CloneMediatorImpl) mediatorImpl)
                    .getTargetsOutputConnector();
            if (targetBranches.size() >= position) {
                return targetBranches.get(position);
            } else {
                throw new IllegalArgumentException("Unknown Clone Mediator List position found : " + position);
            }
        }
        throw new IllegalArgumentException("Unknown Complex Mediator found : " + mediatorImpl.getClass());
    }

    protected EditPart getMediatorInFaultSeq(EList<EsbElement> children, List<Integer> positionList)
            throws MediatorNotFoundException {
        int count = 0;
        EsbElement mediatorElement = null;
        EditPart mediatorImpl = null;
        int position = positionList.remove(INDEX_OF_FIRST_ELEMENT);
        for (EsbElement mediator : children) {
            if ((children.size() - count - 1) == position) {
                mediatorImpl = ESBDebuggerUtil.getEditorEditpart(mediator);
                mediatorElement = mediator;
                break;
            } else {
                count++;
            }
        }

        if (mediatorImpl == null) {
            throw new MediatorNotFoundException("Breakpoint position value is invalid : " + "position expected - "
                    + position + " , Last Index in flow : " + (count - 1));
        }
        OutputConnector tempConnector;
        if (AbstractESBDebugPointBuilder.isComplexMediatorType(mediatorElement) && !positionList.isEmpty()) {
            count = 0;
            if (AbstractESBDebugPointBuilder.isComplexListMediator(mediatorElement)) {
                tempConnector = getInnerListOutputConnector(mediatorElement,
                        positionList.remove(INDEX_OF_FIRST_ELEMENT));
            } else {
                tempConnector = getInnerOutputConnector((Mediator) mediatorImpl);
            }
        } else {
            return mediatorImpl;
        }
        count = 0;
        while (tempConnector != null) {
            EsbLink outgoingLink = tempConnector.getOutgoingLink();
            if (outgoingLink != null && outgoingLink.getTarget() != null) {
                EObject mediator = outgoingLink.getTarget().eContainer();
                if (count == positionList.get(INDEX_OF_FIRST_ELEMENT)) {
                    positionList.remove(INDEX_OF_FIRST_ELEMENT);
                    if (AbstractESBDebugPointBuilder.isComplexMediatorType(mediator) && !positionList.isEmpty()) {
                        count = 0;
                        if (AbstractESBDebugPointBuilder.isComplexListMediator(mediator)) {
                            tempConnector = getInnerListOutputConnector(mediator,
                                    positionList.remove(INDEX_OF_FIRST_ELEMENT));
                        } else {
                            tempConnector = getInnerOutputConnector((Mediator) mediator);
                        }
                    } else {
                        return ESBDebuggerUtil.getEditorEditpart(mediator);
                    }
                } else {
                    count++;
                    if (mediator instanceof Mediator) {
                        tempConnector = EditorUtils.getOutputConnectorFromMediator((Mediator) mediator);
                    }
                }
            } else {
                throw new MediatorNotFoundException("Mediation flow diagram error");
            }
        }
        throw new IllegalArgumentException("tempConnector argument is null");

    }

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

}