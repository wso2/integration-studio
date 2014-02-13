/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.adapters.AdapterProvider;
import org.eclipse.bpel.model.util.BPELAdapterFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

/**
 * BPELUIAdapterFactory for generating adapters.
 * 
 * We use an instance of AdapterProvider that caches singleton adapters.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 * 
 */

public class BPELUIAdapterFactory extends BPELAdapterFactory {

	static BPELUIAdapterFactory instance;

	protected AdapterProvider fProvider;

	/**
	 * Brand new shiny adapter factory.
	 */

	public BPELUIAdapterFactory() {
		fProvider = new AdapterProvider();
	}

	/**
	 * Get the instance of this factory.
	 * 
	 * @return an instance of this factory.
	 */

	public static BPELUIAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPELUIAdapterFactory();
		}
		return instance;
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createRepeatUntilAdapter()
	 */
	
	public Adapter createRepeatUntilAdapter() {
		return fProvider.getAdapter(RepeatUntilAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createAssignAdapter()
	 */
	
	public Adapter createAssignAdapter() {
		return fProvider.getAdapter(AssignAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createAssignE4XAdapter()
	 */
	
	public Adapter createAssignE4XAdapter() {
		return fProvider.getAdapter(AssignE4XAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExtensionAssignOperationAdapter()
	 */
	
	public Adapter createExtensionAssignOperationAdapter() {
		return fProvider.getAdapter(ExtensionAssignOperationAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createSnippetAdapter()
	 */
	
	public Adapter createSnippetAdapter() {
		return fProvider.getAdapter(SnippetAdapter.class);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCopyAdapter()
	 */
	
	public Adapter createCopyAdapter() {
		return fProvider.getAdapter(CopyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createElseIfAdapter()
	 */
	
	public Adapter createElseIfAdapter() {
		return fProvider.getAdapter(ElseIfAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCatchAdapter()
	 */
	
	public Adapter createCatchAdapter() {
		return fProvider.getAdapter(CatchAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFaultHandlerAdapter()
	 */
	
	public Adapter createFaultHandlerAdapter() {
		return fProvider.getAdapter(FaultHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensationHandlerAdapter()
	 */
	
	public Adapter createCompensationHandlerAdapter() {
		return fProvider.getAdapter(CompensationHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createTerminationHandlerAdapter()
	 */
	
	public Adapter createTerminationHandlerAdapter() {
		return fProvider.getAdapter(TerminationHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEventHandlerAdapter()
	 */
	
	public Adapter createEventHandlerAdapter() {
		return fProvider.getAdapter(EventHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createVariableAdapter()
	 */
	
	public Adapter createVariableAdapter() {
		return fProvider.getAdapter(VariableAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEmptyAdapter()
	 */
	
	public Adapter createEmptyAdapter() {
		return fProvider.getAdapter(EmptyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFlowAdapter()
	 */
	
	public Adapter createFlowAdapter() {
		return fProvider.getAdapter(FlowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createInvokeAdapter()
	 */
	
	public Adapter createInvokeAdapter() {
		return fProvider.getAdapter(InvokeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createLinkAdapter()
	 */
	
	public Adapter createLinkAdapter() {
		return fProvider.getAdapter(LinkAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnAlarmAdapter()
	 */
	
	public Adapter createOnAlarmAdapter() {
		return fProvider.getAdapter(OnAlarmAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnMessageAdapter()
	 */
	
	public Adapter createOnMessageAdapter() {
		return fProvider.getAdapter(OnMessageAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnEventAdapter()
	 */
	
	public Adapter createOnEventAdapter() {
		return fProvider.getAdapter(OnEventAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPartnerLinkAdapter()
	 */
	
	public Adapter createPartnerLinkAdapter() {
		return fProvider.getAdapter(PartnerLinkAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createMessageExchangeAdapter()
	 */
	
	public Adapter createMessageExchangeAdapter() {
		return fProvider.getAdapter(MessageExchangeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPickAdapter()
	 */
	
	public Adapter createPickAdapter() {
		return fProvider.getAdapter(PickAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createProcessAdapter()
	 */
	
	public Adapter createProcessAdapter() {
		return fProvider.getAdapter(ProcessAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createIfAdapter()
	 */
	
	public Adapter createIfAdapter() {
		return fProvider.getAdapter(IfAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createReceiveAdapter()
	 */
	
	public Adapter createReceiveAdapter() {
		return fProvider.getAdapter(ReceiveAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createReplyAdapter()
	 */
	
	public Adapter createReplyAdapter() {
		return fProvider.getAdapter(ReplyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createSequenceAdapter()
	 */
	
	public Adapter createSequenceAdapter() {
		return fProvider.getAdapter(SequenceAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createScopeAdapter()
	 */
	
	public Adapter createScopeAdapter() {
		return fProvider.getAdapter(ScopeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createThrowAdapter()
	 */
	
	public Adapter createThrowAdapter() {
		return fProvider.getAdapter(ThrowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createWaitAdapter()
	 */
	
	public Adapter createWaitAdapter() {
		return fProvider.getAdapter(WaitAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createWhileAdapter()
	 */
	
	public Adapter createWhileAdapter() {
		return fProvider.getAdapter(WhileAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createForEachAdapter()
	 */
	
	public Adapter createForEachAdapter() {
		return fProvider.getAdapter(ForEachAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetAdapter()
	 */
	
	public Adapter createCorrelationSetAdapter() {
		return fProvider.getAdapter(CorrelationSetAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetsAdapter()
	 */
	
	public Adapter createMessageExchangesAdapter() {
		return fProvider.getAdapter(MessageExchangesAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetsAdapter()
	 */
	
	public Adapter createCorrelationSetsAdapter() {
		return fProvider.getAdapter(CorrelationSetsAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPartnerLinksAdapter()
	 */
	
	public Adapter createPartnerLinksAdapter() {
		return fProvider.getAdapter(PartnerLinksAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createVariablesAdapter()
	 */
	
	public Adapter createVariablesAdapter() {
		return fProvider.getAdapter(VariablesAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCatchAllAdapter()
	 */
	
	public Adapter createCatchAllAdapter() {
		return fProvider.getAdapter(CatchAllAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createElseAdapter()
	 */
	
	public Adapter createElseAdapter() {
		return fProvider.getAdapter(ElseAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensateAdapter()
	 */
	
	public Adapter createCompensateAdapter() {
		return fProvider.getAdapter(CompensateAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensateScopeAdapter()
	 */
	
	public Adapter createCompensateScopeAdapter() {
		return fProvider.getAdapter(CompensateScopeAdapter.class);
	}

	/**
	 * 
	 * @return the custom activity adapter.
	 */
	public Adapter createCustomActivityAdapter() {
		return fProvider.getAdapter(CustomActivityAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createRethrowAdapter()
	 */
	
	public Adapter createRethrowAdapter() {
		return fProvider.getAdapter(RethrowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExitAdapter()
	 */
	
	public Adapter createExitAdapter() {
		return fProvider.getAdapter(ExitAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createValidateAdapter()
	 */
	
	public Adapter createValidateAdapter() {
		return fProvider.getAdapter(ValidateAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createToAdapter()
	 */
	
	public Adapter createToAdapter() {
		return fProvider.getAdapter(ToAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFromAdapter()
	 */
	
	public Adapter createFromAdapter() {
		return fProvider.getAdapter(FromAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExpressionAdapter()
	 */
	
	public Adapter createExpressionAdapter() {
		return fProvider.getAdapter(ExpressionAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOpaqueActivityAdapter()
	 */
	
	public Adapter createOpaqueActivityAdapter() {
		return fProvider.getAdapter(OpaqueActivityAdapter.class);
	}

	
	// https://jira.jboss.org/browse/JBIDE-6917
	public Adapter createExtensionActivityAdapter() {
		return fProvider.getAdapter(ExtensionActivityAdapter.class);
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#adaptNew(org.eclipse.emf.common.notify.Notifier,
	 *      java.lang.Object)
	 */
	
	public Adapter adaptNew(Notifier target, Object type) {
		Adapter adapter = createAdapter(target, type);
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7497
		// only associate the adapter with the target (i.e. add it to the
		// target's eAdapters list) if the adapter is for the requested type
		if (adapter == null) {
			if (IMarkerHolder.class.equals(type)) {
				adapter = new MarkerDelegateAdapter();
				associate(adapter, target);
				return adapter;
			}
		}
		else if (adapter.isAdapterForType(type)) {
			associate(adapter, target);
			return adapter;
		}
		return null;
	}

	
	protected Object resolve(Object object, Object type) {
		return null;
	}

	
	protected Adapter createAdapter(Notifier target, Object type) {
		if (BPELUtil.isCustomActivity(target)) {
			// If we have a custom activity that did not provide a
			// custom adapter we create a default adapter.
			return createCustomActivityAdapter();
		}
		return super.createAdapter(target, type);
	}

}
