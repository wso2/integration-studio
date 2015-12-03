package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class represents an execution context in a suspended thread. And it
 * contains variables representing visible locals and arguments at the current
 * execution location.
 * 
 */
public class ESBStackFrame extends ESBDebugElement implements IStackFrame {

	private final IThread thread;
	private int lineNumber = 1;
	private List<IVariable> variables = new ArrayList<>();
	private boolean variablesDirty = true;

	public ESBStackFrame(IDebugTarget target, IThread thread) {
		super(target);
		this.thread = thread;
	}

	@Override
	public IThread getThread() {
		return thread;
	}

	@Override
	public synchronized IVariable[] getVariables() {
		if (variablesDirty) {
			variablesDirty = false;
			getDebugTarget().fireModelEvent(new FetchVariablesRequest());
		}

		return variables.toArray(new IVariable[variables.size()]);
	}

	@Override
	public boolean hasVariables() {
		return getVariables().length > 0;
	}

	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public int getCharStart() {
		return -1;
	}

	@Override
	public int getCharEnd() {
		return -1;
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() {
		return new IRegisterGroup[0];
	}

	@Override
	public boolean hasRegisterGroups() {
		return getRegisterGroups().length > 0;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public synchronized void setVariables(
			PropertyRespondMessage propertyRespondMessage)
			throws DebugException {

		String name = propertyRespondMessage.getScope();
		boolean processed = false;
		for (IVariable variable : variables) {
			if (variable.getName().equals(getUITableVariableName(name))) {
				((ESBVariable) variable).setValue(propertyRespondMessage
						.getPropertyValues());
				((ESBVariable) variable).fireChangeEvent(DebugEvent.CONTENT);
				processed = true;
				break;
			}
		}

		if (!processed) {
			ESBVariable textVariable = new ESBVariable(getDebugTarget(),
					getUITableVariableName(name), propertyRespondMessage
							.getPropertyValues().toString());
			variables.add(textVariable);
			textVariable.fireCreationEvent();
		}
	}

	@Override
	public synchronized void fireChangeEvent(int detail) {
		variablesDirty = true;
		super.fireChangeEvent(detail);
	}

	@Override
	public String getName() throws DebugException {
		return Messages.ESBStackFrame_ESBDebuggerStackFrameTag;
	}

	private String getUITableVariableName(String name) {
		switch (name) {
		case ESBDebuggerConstants.AXIS2_PROPERTIES_KEY:
			return Messages.ESBStackFrame_Axis2ScopePropertyTag;
		case ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_KEY:
			return Messages.ESBStackFrame_OperationScopePropertyTag;
		case ESBDebuggerConstants.SYNAPSE_PROPERTIES_KEY:
			return Messages.ESBStackFrame_Axis2ClientScopePropertyTag;
		case ESBDebuggerConstants.TRANSPORT_PROPERTIES_KEY:
			return Messages.ESBStackFrame_TransportScopePropertyTag;
		case ESBDebuggerConstants.OPERATION_PROPERTIES_KEY:
			return Messages.ESBStackFrame_SynapseScopePropertyTag;
		}
		return name;
	}

}
