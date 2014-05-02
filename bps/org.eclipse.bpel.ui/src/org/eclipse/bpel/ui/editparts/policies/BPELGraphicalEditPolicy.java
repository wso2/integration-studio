/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editparts.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELLinkCreationFactory;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.AddLinkCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.ReplaceInContainerCommand;
import org.eclipse.bpel.ui.commands.SetCompensateCommand;
import org.eclipse.bpel.ui.commands.SetNameCommand;
import org.eclipse.bpel.ui.commands.SetPartnerLinkCommand;
import org.eclipse.bpel.ui.commands.SetVariableCommand;
import org.eclipse.bpel.ui.editparts.ActivityEditPart;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.PartnerLinkEditPart;
import org.eclipse.bpel.ui.editparts.VariableEditPart;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;


public class BPELGraphicalEditPolicy extends GraphicalNodeEditPolicy {
	
	final static private int FLOWLINK = 3, COMPENSATELINK = 4;
	
	private int getLinkMode(CreateConnectionRequest req) {
		if (req.getStartCommand().getClass().equals(SetCompensateCommand.class))
			return COMPENSATELINK;		
		return FLOWLINK;
	}

	protected Command createSetNameCommand(Link link, Process process) {
		if (link == null)  return null;
		return new SetNameCommand(link, BPELUtil.getUniqueModelName(
			process, Messages.BPELGraphicalEditPolicy_link1_1, Collections.singletonList(link))); 
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (getHost() == null)
			return null;
		if (request.getNewObjectType().equals(BPELPackage.eINSTANCE.getLink())) {
			Activity activity = getActivity();
			if (activity == null)
				return null;
				
			if (!FlowLinkUtil.hasParentFlow(activity)) {
				return null;
			}
			Link link = BPELFactory.eINSTANCE.createLink();
			Source source = BPELFactory.eINSTANCE.createSource();
			Target target = BPELFactory.eINSTANCE.createTarget();
			link.getSources().add(source);
			link.getTargets().add(target);
			Process process = BPELUtils.getProcess(activity);
			AddLinkCommand command = new AddLinkCommand(createSetNameCommand(link, process), process);
			command.setLink(link);
			command.setSource(activity);
			request.setStartCommand(command);
			return command;
		}
		else if (request.getNewObjectType().equals(BPELLinkCreationFactory.PartnerTempLink.class)) {
			Activity activity = getActivity();
			if (activity == null)
				return null;
			SetPartnerLinkCommand command = new SetPartnerLinkCommand(activity, null);
			request.setStartCommand(command);
			return command;
		}
		else if (request.getNewObjectType().equals(BPELLinkCreationFactory.IncomingVarTempLink.class)) {
			Activity activity = getActivity();
			if (activity == null)
				return null;
			SetVariableCommand command = new SetVariableCommand(activity, null, ModelHelper.INCOMING);
			request.setStartCommand(command);
			return command;
		}
		else if (request.getNewObjectType().equals(BPELLinkCreationFactory.CompensateTempLink.class)) {
			Activity activity = getActivity();
			if (activity == null)
				return null;
			SetCompensateCommand command = new SetCompensateCommand((CompensateScope)activity, null);
			request.setStartCommand(command);
			return command;
		}		
		else if (request.getNewObjectType().equals(BPELLinkCreationFactory.OutgoingVarTempLink.class)) {		
			Activity activity = getActivity();
			if (activity == null)
				return null;
			SetVariableCommand command = new SetVariableCommand(activity, null, ModelHelper.OUTGOING);
			request.setStartCommand(command);
			return command;
		}
		else {
			// invalid request parameter
			// should we throw an error?
			return null;
		}
	}

	/**
	 * Create a polyline connection from sourceAnchor to targetAnchor. 
	 * Add arrows as specified by the arguments.
	 * Add the connection to the connection layer and return it.
	 */
	private PolylineConnection createConnection(ConnectionAnchor sourceAnchor, ConnectionAnchor targetAnchor, boolean sourceArrow, boolean targetArrow) {
		PolylineConnection connection = new PolylineConnection();
		if (sourceAnchor != null)
			connection.setSourceAnchor(sourceAnchor);
		if (targetAnchor != null)
			connection.setTargetAnchor(targetAnchor);
		connection.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLUE));
		connection.setBackgroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLUE));
		connection.setConnectionRouter(new ManhattanConnectionRouter());
		PolygonDecoration arrow = new PolygonDecoration();
		arrow.setTemplate(PolygonDecoration.TRIANGLE_TIP);
		arrow.setScale(5,2.5);
		arrow.setBackgroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLUE));
		if (targetArrow) {
			connection.setTargetDecoration(arrow);
		}
		if (sourceArrow) {
			connection.setSourceDecoration(arrow);
		}
		getLayer(LayerConstants.CONNECTION_LAYER).add(connection);			
		return connection;
	}

	@Override
	protected Connection createDummyConnection(Request req) {
		if (getLinkMode((CreateConnectionRequest)req) == FLOWLINK)
			return super.createDummyConnection(req);
		return createConnection(null, null, false, true);
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command startCommand  = request.getStartCommand();
		if (getLinkMode(request) == FLOWLINK) {
			AddLinkCommand command = (AddLinkCommand)startCommand;
			Activity activity = getActivity();
			if (activity == null || !FlowLinkUtil.hasParentFlow(activity)) {
				return null;
			}
			command.setTarget(activity);
			if (!command.canExecute()) return null;
			ConnectionAnchor ctor = getActivityEditPart().getTargetConnectionAnchor(request);
			if (ctor == null) {
				return null;
			}
			return command;
		}
		else if (getLinkMode(request) == COMPENSATELINK) {
			SetCompensateCommand command = (SetCompensateCommand)startCommand;
			Activity compensate = getActivity();
			
			// true if activity selected is in list of valid activities that 
			// compensate can point to
			boolean b = BPELUtil.getCompensableActivities(command.getTarget()).contains(compensate);

			if (compensate == null || !b) {
				return null;
			}			
			command.setNewValue(compensate);
			if (!command.canExecute()) 
				return null;
			ConnectionAnchor ctor = ((BPELEditPart)request.getTargetEditPart()).getConnectionAnchor(CenteredConnectionAnchor.LEFT);
			if (ctor == null) {
				return null;
			}
			return command;
		}
		return null;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Activity activity = getActivity();
		Link link = (Link)request.getConnectionEditPart().getModel();
		Process process = BPELUtils.getProcess(activity);
		AddLinkCommand cmd = new AddLinkCommand(createSetNameCommand(link, process), process);
		cmd.setLink(link);

		// it's necessary to set also the source so the move command can be excecuted. Otherwise the flow cannot be identified and
		// the connection of the link is not moved.	
		// As the link has only one source take the first item of the sources list.	
   		if (link.getSources().size() > 0)
			cmd.setSource((link.getSources().get(0)).getActivity());
		cmd.setTarget(activity);
		return cmd;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		Activity activity = getActivity();
		Link link = (Link)request.getConnectionEditPart().getModel();
		Process process = BPELUtils.getProcess(activity);
		AddLinkCommand cmd = new AddLinkCommand(createSetNameCommand(link, process), process);
		cmd.setLink(link);

		// it's necessary to set also the target so the move command can be excecuted. Otherwise the flow cannot be identified and
		// the connection of the link is not moved.	
		// As the link has only one target take the first item of the sources list.
		if (link.getTargets().size() > 0)	
			cmd.setTarget((link.getTargets().get(0)).getActivity());	
		cmd.setSource(activity);
		return cmd;
	}

	protected ActivityEditPart getActivityEditPart() {
		if (getHost() instanceof ActivityEditPart) {
			return (ActivityEditPart)getHost();
		}
		return null;	
	}
	
	protected Activity getActivity() {
		EditPart ep = getActivityEditPart();
		if (ep == null)
			return null;
		return (Activity)ep.getModel();
	}

	protected PartnerLinkEditPart getPartnerEditPart() {
		EditPart ep = getHost();
		if (ep instanceof PartnerLinkEditPart)
			return (PartnerLinkEditPart)getHost();
		return null;
	}

	protected PartnerLink getPartnerLink() {
		if (!(getHost() instanceof PartnerLinkEditPart))
			return null;
		Object model = getHost().getModel();
		return (PartnerLink)model;
	}

	protected Variable getVariable() {
		if (!(getHost() instanceof VariableEditPart))
			return null;
		Object model = getHost().getModel();
		return (Variable)model;
	}
	
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor(CreateConnectionRequest request) {
		EditPart source = request.getSourceEditPart();
		if (source instanceof NodeEditPart) {
			if (getLinkMode(request) == FLOWLINK)
				return ((NodeEditPart) source).getSourceConnectionAnchor(request);
			return ((BPELEditPart) source).getConnectionAnchor(CenteredConnectionAnchor.LEFT);
		}
		return null;
	}

	@Override
	protected ConnectionAnchor getTargetConnectionAnchor(CreateConnectionRequest request) {
		EditPart target = request.getTargetEditPart();
		if (target instanceof NodeEditPart) {
			// make sure object is INSIDE a flow
			
			if (!FlowLinkUtil.hasParentFlow((EObject)target.getModel()))
				return null;
			
			if (getLinkMode(request) == FLOWLINK) {
				// does it make sense to allow two links with the same source and dest?
				// I assume not, so we'll prevent it.
				
				// iterate through all the current links
				EditPart source = request.getSourceEditPart();
				Flow flows[] = FlowLinkUtil.getParentFlows((EObject)source.getModel());
				for (int i = 0; i< flows.length; i++) {
					List links = FlowLinkUtil.getFlowLinks(flows[i]);
					for (int j = 0; j < links.size(); j++) {
						Link link = (Link)links.get(j);
						if (FlowLinkUtil.getLinkSource(link) == source.getModel() && 
							FlowLinkUtil.getLinkTarget(link) == target.getModel())
								return null;
					}
				}
				return ((NodeEditPart) target).getTargetConnectionAnchor(request);
			}
		}
		
		// (VZ) FIXME: we cannot cast target to BPELEditPart instance. Debug it...
		else if (target instanceof PartnerLinkEditPart)
			return ((BPELEditPart)target).getConnectionAnchor(CenteredConnectionAnchor.LEFT);
		else if (target instanceof VariableEditPart)
			return ((BPELEditPart)target).getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
		return null;
	}

	@Override
	public Command getCommand(Request request) {
		if ("changeType".equals(request.getType())) //$NON-NLS-1$
			return getReplaceInContainerCommand((CreateRequest)request);
		return super.getCommand(request);
	}

	protected Command getReplaceInContainerCommand(CreateRequest request) {
		Object target = getHost().getParent().getModel(); 
		Object oldElement = getHost().getModel();
		Object newElement = request.getNewObject();
		
		//Only change type for Activity
		// TODO: remove this limitation in the future ?
		if (!(oldElement instanceof Activity)) return null;
		
		CompoundCommand command = new CompoundCommand();
		command.add(new ReplaceInContainerCommand(target, oldElement, newElement));
		
		//Update the display name as stored in the extension
		// TODO
		
		return command;
	}
}

