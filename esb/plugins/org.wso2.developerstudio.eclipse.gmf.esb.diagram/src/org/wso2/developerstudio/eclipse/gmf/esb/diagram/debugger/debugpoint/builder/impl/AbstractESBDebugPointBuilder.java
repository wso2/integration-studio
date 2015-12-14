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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_DELETE_ACTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_INSERT_ACTION;
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
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
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
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl;
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
public abstract class AbstractESBDebugPointBuilder implements
		IESBDebugPointBuilder {

	protected static final String EMPTY_STRING = "";
	protected static final int INDEX_OF_FIRST_ELEMENT = 0;
	private EObject innerContainerInstance;
	private EObject innerParentContainer;
	private Integer switchCasePosition;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * This method returns the InputConnector of the given mediator.
	 * 
	 * @param mediator
	 * @return
	 */
	public static InputConnector getInputConnector(Mediator mediator) {

		if (mediator instanceof AggregateMediator) {
			return ((AggregateMediator) mediator).getInputConnector();
		} else if (mediator instanceof CacheMediator) {
			return ((CacheMediator) mediator).getInputConnector();
		} else if (mediator instanceof CalloutMediator) {
			return ((CalloutMediator) mediator).getInputConnector();
		} else if (mediator instanceof CallTemplateMediator) {
			return ((CallTemplateMediator) mediator).getInputConnector();
		} else if (mediator instanceof ClassMediator) {
			return ((ClassMediator) mediator).getInputConnector();
		} else if (mediator instanceof CloneMediator) {
			return ((CloneMediator) mediator).getInputConnector();
		} else if (mediator instanceof CommandMediator) {
			return ((CommandMediator) mediator).getInputConnector();
		} else if (mediator instanceof DBLookupMediator) {
			return ((DBLookupMediator) mediator).getInputConnector();
		} else if (mediator instanceof DBReportMediator) {
			return ((DBReportMediator) mediator).getInputConnector();
		} else if (mediator instanceof DropMediator) {
			return ((DropMediator) mediator).getInputConnector();
		} else if (mediator instanceof EnqueueMediator) {
			return ((EnqueueMediator) mediator).getInputConnector();
		} else if (mediator instanceof EnrichMediator) {
			return ((EnrichMediator) mediator).getInputConnector();
		} else if (mediator instanceof EntitlementMediator) {
			return ((EntitlementMediator) mediator).getInputConnector();
		} else if (mediator instanceof EventMediator) {
			return ((EventMediator) mediator).getInputConnector();
		} else if (mediator instanceof FaultMediator) {
			return ((FaultMediator) mediator).getInputConnector();
		} else if (mediator instanceof FilterMediator) {
			return ((FilterMediator) mediator).getInputConnector();
		} else if (mediator instanceof HeaderMediator) {
			return ((HeaderMediator) mediator).getInputConnector();
		} else if (mediator instanceof IterateMediator) {
			return ((IterateMediator) mediator).getInputConnector();
		} else if (mediator instanceof LogMediator) {
			return ((LogMediator) mediator).getInputConnector();
		} else if (mediator instanceof OAuthMediator) {
			return ((OAuthMediator) mediator).getInputConnector();
		} else if (mediator instanceof PayloadFactoryMediator) {
			return ((PayloadFactoryMediator) mediator).getInputConnector();
		} else if (mediator instanceof PropertyMediator) {
			return ((PropertyMediator) mediator).getInputConnector();
		} else if (mediator instanceof RMSequenceMediator) {
			return ((RMSequenceMediator) mediator).getInputConnector();
		} else if (mediator instanceof RuleMediator) {
			return ((RuleMediator) mediator).getInputConnector();
		} else if (mediator instanceof ScriptMediator) {
			return ((ScriptMediator) mediator).getInputConnector();
		} else if (mediator instanceof SendMediator) {
			return ((SendMediator) mediator).getInputConnector();
		} else if (mediator instanceof SmooksMediator) {
			return ((SmooksMediator) mediator).getInputConnector();
		} else if (mediator instanceof SpringMediator) {
			return ((SpringMediator) mediator).getInputConnector();
		} else if (mediator instanceof StoreMediator) {
			return ((StoreMediator) mediator).getInputConnector();
		} else if (mediator instanceof SwitchMediator) {
			return ((SwitchMediator) mediator).getInputConnector();
		} else if (mediator instanceof ThrottleMediator) {
			return ((ThrottleMediator) mediator).getInputConnector();
		} else if (mediator instanceof XQueryMediator) {
			return ((XQueryMediator) mediator).getInputConnector();
		} else if (mediator instanceof XSLTMediator) {
			return ((XSLTMediator) mediator).getInputConnector();
		} else if (mediator instanceof FastXSLTMediator) {
			return ((FastXSLTMediator) mediator).getInputConnector();
		} else if (mediator instanceof BAMMediator) {
			return ((BAMMediator) mediator).getInputConnector();
		} else if (mediator instanceof Sequence) {
			return ((Sequence) mediator).getInputConnector();
		} else if (mediator instanceof CallMediator) {
			return ((CallMediator) mediator).getInputConnector();
		} else if (mediator instanceof LoopBackMediator) {
			return ((LoopBackMediator) mediator).getInputConnector();
		} else if (mediator instanceof RespondMediator) {
			return ((RespondMediator) mediator).getInputConnector();
		} else if (mediator instanceof ConditionalRouterMediator) {
			return ((ConditionalRouterMediator) mediator).getInputConnector();
		} else if (mediator instanceof ValidateMediator) {
			return ((ValidateMediator) mediator).getInputConnector();
		} else if (mediator instanceof BeanMediator) {
			return ((BeanMediator) mediator).getInputConnector();
		} else if (mediator instanceof EJBMediator) {
			return ((EJBMediator) mediator).getInputConnector();
		} else if (mediator instanceof URLRewriteMediator) {
			return ((URLRewriteMediator) mediator).getInputConnector();
		} else if (mediator instanceof TransactionMediator) {
			return ((TransactionMediator) mediator).getInputConnector();
		} else if (mediator instanceof ForEachMediator) {
			return ((ForEachMediator) mediator).getInputConnector();
		} else if (mediator instanceof BuilderMediator) {
			return ((BuilderMediator) mediator).getInputConnector();
		} else if (mediator instanceof PublishEventMediator) {
			return ((PublishEventMediator) mediator).getInputConnector();
		} else if (mediator instanceof CloudConnectorOperationImpl) {
			return ((CloudConnectorOperationImpl) mediator).getInputConnector();
		}
		throw new IllegalArgumentException(
				"Invalid/Unknown Mediator type found : " + mediator.toString());
	}

	/**
	 * This method returns the OutputConnector of the given mediator.
	 * 
	 * @param mediator
	 * @return
	 */
	public static OutputConnector getOutputConnector(Mediator mediator) {

		if (mediator instanceof AggregateMediator) {
			return ((AggregateMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CacheMediator) {
			return ((CacheMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CalloutMediator) {
			return ((CalloutMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CallTemplateMediator) {
			return ((CallTemplateMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ClassMediator) {
			return ((ClassMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CloneMediator) {
			return ((CloneMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CommandMediator) {
			return ((CommandMediator) mediator).getOutputConnector();
		} else if (mediator instanceof DBLookupMediator) {
			return ((DBLookupMediator) mediator).getOutputConnector();
		} else if (mediator instanceof DBReportMediator) {
			return ((DBReportMediator) mediator).getOutputConnector();
		} else if (mediator instanceof EnqueueMediator) {
			return ((EnqueueMediator) mediator).getOutputConnector();
		} else if (mediator instanceof EnrichMediator) {
			return ((EnrichMediator) mediator).getOutputConnector();
		} else if (mediator instanceof Sequence) {
			return ((Sequence) mediator).getOutputConnector().get(0);
		} else if (mediator instanceof EntitlementMediator) {
			return ((EntitlementMediator) mediator).getOutputConnector();
		} else if (mediator instanceof EventMediator) {
			return ((EventMediator) mediator).getOutputConnector();
		} else if (mediator instanceof FaultMediator) {
			return ((FaultMediator) mediator).getOutputConnector();
		} else if (mediator instanceof FilterMediator) {
			return ((FilterMediator) mediator).getOutputConnector();
		} else if (mediator instanceof HeaderMediator) {
			return ((HeaderMediator) mediator).getOutputConnector();
		} else if (mediator instanceof IterateMediator) {
			return ((IterateMediator) mediator).getOutputConnector();
		} else if (mediator instanceof LogMediator) {
			return ((LogMediator) mediator).getOutputConnector();
		} else if (mediator instanceof OAuthMediator) {
			return ((OAuthMediator) mediator).getOutputConnector();
		} else if (mediator instanceof PayloadFactoryMediator) {
			return ((PayloadFactoryMediator) mediator).getOutputConnector();
		} else if (mediator instanceof PropertyMediator) {
			return ((PropertyMediator) mediator).getOutputConnector();
		} else if (mediator instanceof RMSequenceMediator) {
			return ((RMSequenceMediator) mediator).getOutputConnector();
		} else if (mediator instanceof RuleMediator) {
			return ((RuleMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ScriptMediator) {
			return ((ScriptMediator) mediator).getOutputConnector();
		} else if (mediator instanceof SendMediator) {
			return ((SendMediator) mediator).getOutputConnector();
		} else if (mediator instanceof SmooksMediator) {
			return ((SmooksMediator) mediator).getOutputConnector();
		} else if (mediator instanceof SpringMediator) {
			return ((SpringMediator) mediator).getOutputConnector();
		} else if (mediator instanceof StoreMediator) {
			return ((StoreMediator) mediator).getOutputConnector();
		} else if (mediator instanceof SwitchMediator) {
			return ((SwitchMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ThrottleMediator) {
			return ((ThrottleMediator) mediator).getOutputConnector();
		} else if (mediator instanceof XQueryMediator) {
			return ((XQueryMediator) mediator).getOutputConnector();
		} else if (mediator instanceof XSLTMediator) {
			return ((XSLTMediator) mediator).getOutputConnector();
		} else if (mediator instanceof FastXSLTMediator) {
			return ((FastXSLTMediator) mediator).getOutputConnector();
		} else if (mediator instanceof BAMMediator) {
			return ((BAMMediator) mediator).getOutputConnector();
		} else if (mediator instanceof CallMediator) {
			return ((CallMediator) mediator).getOutputConnector();
		} else if (mediator instanceof LoopBackMediator) {
			return ((LoopBackMediator) mediator).getOutputConnector();
		} else if (mediator instanceof RespondMediator) {
			return ((RespondMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ConditionalRouterMediator) {
			return ((ConditionalRouterMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ValidateMediator) {
			return ((ValidateMediator) mediator).getOutputConnector();
		} else if (mediator instanceof BeanMediator) {
			return ((BeanMediator) mediator).getOutputConnector();
		} else if (mediator instanceof EJBMediator) {
			return ((EJBMediator) mediator).getOutputConnector();
		} else if (mediator instanceof URLRewriteMediator) {
			return ((URLRewriteMediator) mediator).getOutputConnector();
		} else if (mediator instanceof TransactionMediator) {
			return ((TransactionMediator) mediator).getOutputConnector();
		} else if (mediator instanceof ForEachMediator) {
			return ((ForEachMediator) mediator).getOutputConnector();
		} else if (mediator instanceof BuilderMediator) {
			return ((BuilderMediator) mediator).getOutputConnector();
		} else if (mediator instanceof PublishEventMediator) {
			return ((PublishEventMediator) mediator).getOutputconnector();
		} else if (mediator instanceof CloudConnectorOperationImpl) {
			return ((CloudConnectorOperationImpl) mediator)
					.getOutputConnector();
		}
		throw new IllegalArgumentException(
				"Invalid/Unknown Mediator type found : " + mediator.toString());
	}

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
	protected EditPart getContainerFromEditPart(EditPart part,
			Class<?> classType) throws ESBDebuggerException {
		EditPart container = part;
		while (!(classType.isInstance(container.getParent()))) {
			container = container.getParent();
			if (container instanceof EsbServerEditPart || container == null) {
				throw new ESBDebuggerException(part
						+ " : is included in an unexpected artifact type");
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
	 */
	protected void increaseBreakpointPosition(List<ESBDebugPoint> breakpontList) {
		for (ESBDebugPoint esbBreakpoint : breakpontList) {
			try {
				AbstractESBDebugPointMessage message = increasePositionOfTheMessage(esbBreakpoint
						.getLocation());
				ESBDebugPoint modifiedBreakpoint = new ESBDebugPoint(
						esbBreakpoint.getResource(),
						esbBreakpoint.getLineNumber(), message);
				DebugPlugin.getDefault().getBreakpointManager()
						.addBreakpoint(modifiedBreakpoint);
				DebugPlugin.getDefault().getBreakpointManager()
						.removeBreakpoint(esbBreakpoint, true);
			} catch (DebugPointMarkerNotFoundException e) {
				log.error("Error while increasing debug point position value"
						+ e.getMessage(), e);
				ESBDebuggerUtil
						.removeESBDebugPointFromBreakpointManager(esbBreakpoint);
			} catch (CoreException e) {
				log.error("Error while increasing debug point position value",
						e);
			}
		}
	}

	/**
	 * This method decrement position of the breakpoints by one. It deletes the
	 * older breakpoint and add the modified breakpoint.
	 * 
	 * @param breakpontList
	 */
	protected void decreaseBreakpointPosition(List<ESBDebugPoint> breakpontList) {
		for (ESBDebugPoint esbBreakpoint : breakpontList) {

			try {
				AbstractESBDebugPointMessage message = decreasePositionOfTheMessage(esbBreakpoint
						.getLocation());
				ESBDebugPoint modifiedBreakpoint = new ESBDebugPoint(
						esbBreakpoint.getResource(),
						esbBreakpoint.getLineNumber(), message);
				DebugPlugin.getDefault().getBreakpointManager()
						.addBreakpoint(modifiedBreakpoint);
				DebugPlugin.getDefault().getBreakpointManager()
						.removeBreakpoint(esbBreakpoint, true);
			} catch (DebugPointMarkerNotFoundException e) {
				log.error("Error while decreasing the debug point position :"
						+ e.getMessage(), e);
				ESBDebuggerUtil
						.removeESBDebugPointFromBreakpointManager(esbBreakpoint);
			} catch (CoreException e) {
				log.error("Error while decreasing the debug point position :",
						e);
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
	protected static List<ESBDebugPoint> getDebugPointsRelatedToModification(
			IResource resource, List<Integer> position, String listSequence,
			String action) {
		List<ESBDebugPoint> breakpointList = new ArrayList<ESBDebugPoint>();
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager()
				.getBreakpoints(ESBDebugModelPresentation.ID);
		for (IBreakpoint breakpoint : breakpoints) {
			try {
				IResource file = ((ESBDebugPoint) breakpoint).getResource();
				String listSequencePosition = EMPTY_STRING;
				if (file.equals(resource)) {
					List<Integer> positionList = getMediatorPositionOfBreakpoint(breakpoint);
					int valueInLastPosition = positionList.get(positionList
							.size() - 1);
					String sequnceType = EMPTY_STRING;
					if (positionList.size() > 1) {
						listSequencePosition = EMPTY_STRING
								+ (positionList.get(positionList.size() - 2));
					} else {
						sequnceType = getSequenceTypeOfBreakpoint(breakpoint);
					}
					if (listSequence.equalsIgnoreCase(listSequencePosition)
							|| listSequence.equalsIgnoreCase(sequnceType)) {
						if (isBreakpointShouldInModifyingList(action, position,
								valueInLastPosition)) {
							breakpointList.add((ESBDebugPoint) breakpoint);
						} else if (MEDIATOR_DELETE_ACTION.equals(action)
								&& position.get(position.size() - 1) == valueInLastPosition) {
							ESBDebuggerUtil
									.removeESBDebugPointFromBreakpointManager(breakpoint);
						}
					}
				}
			} catch (DebugPointMarkerNotFoundException e) {
				log.error(
						"Error while retrieving Debug points related to modifications : "
								+ e.getMessage(), e);
				ESBDebuggerUtil
						.removeESBDebugPointFromBreakpointManager(breakpoint);
			} catch (CoreException e) {
				log.error(
						"Error while retrieving Debug points related to modifications : ",
						e);
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
	protected List<Integer> getMediatorPosition(
			OutputConnector outputConnector, AbstractMediator newMediator)
			throws MediatorNotFoundException {
		OutputConnector tempConnector = outputConnector;
		int count = 0;
		List<Integer> positionList = new ArrayList<>();
		EObject newMediatorImpl = ((NodeImpl) newMediator.getModel())
				.getElement();
		while (isValidConnectorToProceed(tempConnector)) {
			EsbLink outgoingLink = tempConnector.getOutgoingLink();
			if (outgoingLink != null && outgoingLink.getTarget() != null) {
				EObject mediator = outgoingLink.getTarget().eContainer();
				if (mediator instanceof MediatorImpl) {
					if (newMediatorImpl.equals(mediator)) {
						positionList.add(count);
						return positionList;
					} else if (isMediatorChainEnded(mediator)) {
						throw new MediatorNotFoundException(newMediator
								+ " Mediator is not found in a valid position");
					} else {
						count++;
						tempConnector = getOutputConnector((Mediator) mediator);
					}
				} else {
					throw new MediatorNotFoundException(newMediator
							+ " Mediator is not found in a valid position");
				}
			} else {
				throw new MediatorNotFoundException(
						"Mediation flow diagram error");
			}
		}
		throw new MediatorNotFoundException(newMediator
				+ " Mediator is not found in a valid position");
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
	protected List<Integer> getMediatorPosition(OutputConnector outConnector,
			EObject selection) throws MediatorNotFoundException {
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
						throw new MediatorNotFoundException(
								"Selected Mediator is not found in a valid position");
					} else if (mediator.equals(mediatorImpl)) {
						positionList.add(count);
						if (parentStack.isEmpty()) {
							return positionList;
						}
						if (isComplexListMediator(mediatorImpl)) {
							positionList.add(getPositionOfInnerContainer(
									parentStack, mediatorImpl));
						}
						if (isComplexMediatorType(mediatorImpl)) {
							tempConnector = getNextMediatorOutputConnector(mediatorImpl);
						} else {
							tempConnector = getOutputConnector((Mediator) mediatorImpl);
						}
						mediatorImpl = getNextMediatorFromParentStack(parentStack);
						break;
					} else {
						count++;
						tempConnector = getOutputConnector((Mediator) mediator);
					}
				} else {
					throw new MediatorNotFoundException(
							"Mediation flow diagram error");
				}
			}

		} while (mediatorImpl instanceof MediatorImpl);

		throw new MediatorNotFoundException(
				"Selected Mediator is not found in a valid position. Unknown Complex Mediator Type found : "
						+ mediatorImpl.getClass());
	}

	private Stack<EObject> removeTopObjectsUntilFirstMediator(
			Stack<EObject> parentStack) {
		while (!(parentStack.peek() instanceof MediatorImpl)) {
			parentStack.pop();
			if (parentStack.empty()) {
				throw new IllegalArgumentException(
						"Valid MediatorImpl instance not found in the given parent instances stack ");
			}
		}
		return parentStack;
	}

	private Integer getPositionOfInnerContainer(Stack<EObject> parentStack,
			EObject mediatorImpl) {
		if (mediatorImpl instanceof FilterMediatorImpl) {
			parentStack.pop();
			innerContainerInstance = parentStack.pop();
			if (innerContainerInstance instanceof FilterPassContainerImpl) {
				return FILTER_PASS_CONTAINER_POSITION_VALUE;
			} else if (innerContainerInstance instanceof FilterFailContainerImpl) {
				return FILTER_FAIL_CONTAINER_POSITION_VALUE;
			} else {
				throw new IllegalArgumentException(
						"Unknown Filter Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		} else if (mediatorImpl instanceof SwitchMediatorImpl) {
			parentStack.pop();
			innerParentContainer = parentStack.pop();

			if (innerParentContainer instanceof SwitchCaseParentContainerImpl) {
				SwitchCaseContainerImpl switchCase = (SwitchCaseContainerImpl) parentStack
						.pop();
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
				throw new IllegalArgumentException(
						"Unknown Throttle Mediator Container type found : "
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
				throw new IllegalArgumentException(
						"Unknown Throttle Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		}
		throw new IllegalArgumentException(
				"Unknown multiple inner sequence mediator found : "
						+ mediatorImpl.getClass());

	}

	private EObject getNextMediatorFromParentStack(Stack<EObject> parentStack) {
		EObject nextImpl = parentStack.pop();
		while (!(nextImpl instanceof MediatorImpl)) {
			if (parentStack.empty()) {
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
				return ((FilterMediatorImpl) mediatorImpl)
						.getPassOutputConnector();
			} else if (innerContainerInstance instanceof FilterFailContainerImpl) {
				return ((FilterMediatorImpl) mediatorImpl)
						.getFailOutputConnector();
			} else {
				throw new IllegalArgumentException(
						"Unknown Filter Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		} else if (mediatorImpl instanceof SwitchMediatorImpl) {
			if (innerParentContainer instanceof SwitchCaseParentContainerImpl) {
				return ((SwitchMediatorImpl) mediatorImpl).getCaseBranches()
						.get(switchCasePosition - 1);

			} else if (innerParentContainer instanceof SwitchDefaultParentContainerImpl) {
				return ((SwitchMediatorImpl) mediatorImpl).getDefaultBranch();
			} else {
				throw new IllegalArgumentException(
						"Unknown Switch Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		} else if (mediatorImpl instanceof ThrottleMediatorImpl) {
			if (innerContainerInstance instanceof ThrottleOnAcceptContainerImpl) {
				return ((ThrottleMediatorImpl) mediatorImpl)
						.getOnAcceptOutputConnector();
			} else if (innerContainerInstance instanceof ThrottleOnRejectContainerImpl) {
				return ((ThrottleMediatorImpl) mediatorImpl)
						.getOnRejectOutputConnector();
			} else {
				throw new IllegalArgumentException(
						"Unknown Filter Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		} else if (mediatorImpl instanceof EntitlementMediatorImpl) {
			if (innerContainerInstance instanceof EntitlementOnRejectContainerImpl) {
				return ((EntitlementMediatorImpl) mediatorImpl)
						.getOnRejectOutputConnector();
			} else if (innerContainerInstance instanceof EntitlementOnAcceptContainerImpl) {
				return ((EntitlementMediatorImpl) mediatorImpl)
						.getOnAcceptOutputConnector();
			} else if (innerContainerInstance instanceof EntitlementAdviceContainerImpl) {
				return ((EntitlementMediatorImpl) mediatorImpl)
						.getAdviceOutputConnector();
			} else if (innerContainerInstance instanceof EntitlementObligationsContainerImpl) {
				return ((EntitlementMediatorImpl) mediatorImpl)
						.getObligationsOutputConnector();
			} else {
				throw new IllegalArgumentException(
						"Unknown Entitlement Mediator Container type found : "
								+ innerContainerInstance.getClass());
			}
		} else if (mediatorImpl instanceof CloneMediatorImpl) {
			return ((CloneMediatorImpl) mediatorImpl)
					.getTargetsOutputConnector().get(0);
		} else if (mediatorImpl instanceof ValidateMediatorImpl) {
			return ((ValidateMediatorImpl) mediatorImpl)
					.getOnFailOutputConnector();
		} else if (mediatorImpl instanceof CacheMediatorImpl) {
			return ((CacheMediatorImpl) mediatorImpl).getOnHitOutputConnector();
		} else if (mediatorImpl instanceof ForEachMediatorImpl) {
			return ((ForEachMediatorImpl) mediatorImpl)
					.getTargetOutputConnector();
		} else if (mediatorImpl instanceof AggregateMediatorImpl) {
			return ((AggregateMediatorImpl) mediatorImpl)
					.getOnCompleteOutputConnector();
		} else if (mediatorImpl instanceof RuleMediatorImpl) {
			return ((RuleMediatorImpl) mediatorImpl)
					.getChildMediatorsOutputConnector();
		} else if (mediatorImpl instanceof IterateMediatorImpl) {
			return ((IterateMediatorImpl) mediatorImpl)
					.getTargetOutputConnector();
		} else {
			throw new IllegalArgumentException(
					"Unknown Complex Mediator type found : "
							+ mediatorImpl.getClass());
		}
	}

	public static boolean isComplexMediatorType(EObject mediatorImpl) {
		if (mediatorImpl instanceof FilterMediatorImpl
				|| mediatorImpl instanceof SwitchMediatorImpl
				|| mediatorImpl instanceof ThrottleMediatorImpl
				|| mediatorImpl instanceof EntitlementMediatorImpl
				|| mediatorImpl instanceof CloneMediatorImpl
				|| mediatorImpl instanceof ValidateMediatorImpl
				|| mediatorImpl instanceof CacheMediatorImpl
				|| mediatorImpl instanceof AggregateMediatorImpl
				|| mediatorImpl instanceof ForEachMediatorImpl
				|| mediatorImpl instanceof RuleMediatorImpl
				|| mediatorImpl instanceof IterateMediatorImpl) {
			return true;
		}
		return false;
	}

	public static boolean isComplexListMediator(EObject mediatorImpl) {
		if (mediatorImpl instanceof FilterMediatorImpl
				|| mediatorImpl instanceof SwitchMediatorImpl
				|| mediatorImpl instanceof ThrottleMediatorImpl
				|| mediatorImpl instanceof EntitlementMediatorImpl) {
			return true;
		}
		return false;
	}

	private Stack<EObject> getParentMediatorStack(MediatorImpl selection)
			throws MediatorNotFoundException {
		EObject parentMediator = selection;
		Stack<EObject> parentStack = new Stack<EObject>();
		parentStack.push(parentMediator);
		while (!isMediatorChainEnded(parentMediator)) {
			parentStack
					.addAll(getParentMediatorImpl((MediatorImpl) parentMediator));
			parentMediator = parentStack.peek();
		}
		return parentStack;
	}

	private Stack<EObject> getParentMediatorImpl(MediatorImpl childMediator)
			throws MediatorNotFoundException {
		MediatorFlowImpl parentMediationFlowImpl = (MediatorFlowImpl) (childMediator)
				.eContainer();
		Stack<EObject> mediatorStack = new Stack<EObject>();
		EObject nextImpl = parentMediationFlowImpl;
		do {
			nextImpl = nextImpl.eContainer();
			mediatorStack.push(nextImpl);
			if (nextImpl instanceof MediatorImpl
					|| isMediatorChainEnded(nextImpl)) {
				return mediatorStack;
			}
		} while (!(nextImpl instanceof MediatorFlowImpl));
		throw new MediatorNotFoundException(
				"Valid parent mediator can not be found for : "
						+ childMediator.toString());
	}

	/**
	 * This method returns mediator position in fault sequence.
	 * 
	 * @param eList
	 * @param AbstractMediator
	 * @return
	 * @throws MediatorNotFoundException
	 */
	protected List<Integer> getMediatorPositionInFaultSeq(
			EList<EsbElement> eList, AbstractMediator selection)
			throws MediatorNotFoundException {
		int count = 0;
		MediatorImpl selectionImpl = (MediatorImpl) ((NodeImpl) selection
				.getModel()).getElement();
		List<Integer> positionList = new ArrayList<>();
		for (EsbElement mediator : eList) {
			if (selectionImpl.equals(mediator)) {
				positionList.add(count);
				return positionList;
			} else {
				count++;
			}
		}
		throw new MediatorNotFoundException(selection
				+ " Mediator not found in Fault Sequence");
	}

	/**
	 * This method returns mediator position in fault sequence.
	 * 
	 * @param eList
	 * @param EObject
	 * @return
	 * @throws MediatorNotFoundException
	 */
	protected List<Integer> getMediatorPositionInFaultSeq(
			EList<EsbElement> eList, EObject selection)
			throws MediatorNotFoundException {
		int count = 0;
		List<Integer> positionList = new ArrayList<>();
		for (EsbElement mediator : eList) {
			if (mediator.equals(selection)) {
				positionList.add(count);
				return positionList;
			} else {
				count++;
			}
		}
		throw new MediatorNotFoundException(selection
				+ " Mediator not found in Fault Sequence");
	}

	private AbstractESBDebugPointMessage increasePositionOfTheMessage(
			AbstractESBDebugPointMessage esbDebugPointMessage) {
		List<Integer> positionArray = esbDebugPointMessage
				.getMediatorPosition().getPosition();
		int lastPosition = positionArray.get(positionArray.size() - 1) + 1;
		positionArray.set(positionArray.size() - 1, lastPosition);
		esbDebugPointMessage.setMediatorPosition(positionArray);
		return esbDebugPointMessage;
	}

	private AbstractESBDebugPointMessage decreasePositionOfTheMessage(
			AbstractESBDebugPointMessage esbDebugPointMessage) {
		List<Integer> positionArray = esbDebugPointMessage
				.getMediatorPosition().getPosition();
		int lastPosition = positionArray.get(positionArray.size() - 1) - 1;
		positionArray.set(positionArray.size() - 1, lastPosition);
		esbDebugPointMessage.setMediatorPosition(positionArray);
		return esbDebugPointMessage;
	}

	private static boolean isBreakpointShouldInModifyingList(String action,
			List<Integer> position, int valueInLastPosition) {
		if ((MEDIATOR_INSERT_ACTION.equals(action) && (position.get(position
				.size() - 1) <= valueInLastPosition))
				|| (MEDIATOR_DELETE_ACTION.equals(action) && position
						.get(position.size() - 1) < valueInLastPosition)) {
			return true;
		}
		return false;
	}

	private boolean isValidConnectorToProceed(OutputConnector tempConnector) {
		return tempConnector instanceof OutputConnector;
	}

	private static String getSequenceTypeOfBreakpoint(IBreakpoint breakpoint)
			throws DebugPointMarkerNotFoundException, CoreException {
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
	private static List<Integer> getMediatorPositionOfBreakpoint(
			IBreakpoint breakpoint) throws DebugPointMarkerNotFoundException,
			CoreException {
		AbstractESBDebugPointMessage message = ((ESBDebugPoint) breakpoint)
				.getLocation();
		return message.getMediatorPosition().getPosition();
	}

	/**
	 * This method checks whether the mediation flow came to an end
	 * 
	 * @param mediator
	 * @return
	 */
	private boolean isMediatorChainEnded(EObject mediator) {
		if (mediator instanceof SequencesImpl
				|| mediator instanceof ProxyServiceImpl
				|| mediator instanceof APIResourceImpl
				|| mediator instanceof TemplateImpl) {
			return true;
		}
		return false;
	}

}
