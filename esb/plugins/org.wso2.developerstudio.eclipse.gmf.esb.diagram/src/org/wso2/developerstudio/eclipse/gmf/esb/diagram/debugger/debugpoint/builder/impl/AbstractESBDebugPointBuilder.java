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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.*;
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
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

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
		OutputConnector tempConnector = outConnector;
		int count = 0;
		while (isValidConnectorToProceed(tempConnector)) {
			EsbLink outgoingLink = tempConnector.getOutgoingLink();
			if (outgoingLink != null && outgoingLink.getTarget() != null) {
				EObject mediator = outgoingLink.getTarget().eContainer();
				if (isMediatorChainEnded(mediator)) {
					throw new MediatorNotFoundException(
							"Selected Mediator is not found in a valid position");
				} else if (mediator.equals(selection)) {
					positionList.add(count);
					return positionList;
				} else {
					count++;
					tempConnector = getOutputConnector((Mediator) mediator);
				}
			} else {
				throw new MediatorNotFoundException(
						"Mediation flow diagram error");
			}
		}
		throw new MediatorNotFoundException(
				"Selected Mediator is not found in a valid position");
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
