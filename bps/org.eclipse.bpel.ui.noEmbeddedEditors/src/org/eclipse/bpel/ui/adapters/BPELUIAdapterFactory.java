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
	@Override
	public Adapter createRepeatUntilAdapter() {
		return fProvider.getAdapter(RepeatUntilAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createAssignAdapter()
	 */
	@Override
	public Adapter createAssignAdapter() {
		return fProvider.getAdapter(AssignAdapter.class);
	}


	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createAssignE4XAdapter()
	 */
	@Override
	public Adapter createAssignE4XAdapter() {
		return fProvider.getAdapter(AssignE4XAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExtensionAssignOperationAdapter()
	 */
	@Override
	public Adapter createExtensionAssignOperationAdapter() {
		return fProvider.getAdapter(ExtensionAssignOperationAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createSnippetAdapter()
	 */
	@Override
	public Adapter createSnippetAdapter() {
		return fProvider.getAdapter(SnippetAdapter.class);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCopyAdapter()
	 */
	@Override
	public Adapter createCopyAdapter() {
		return fProvider.getAdapter(CopyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createElseIfAdapter()
	 */
	@Override
	public Adapter createElseIfAdapter() {
		return fProvider.getAdapter(ElseIfAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCatchAdapter()
	 */
	@Override
	public Adapter createCatchAdapter() {
		return fProvider.getAdapter(CatchAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFaultHandlerAdapter()
	 */
	@Override
	public Adapter createFaultHandlerAdapter() {
		return fProvider.getAdapter(FaultHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensationHandlerAdapter()
	 */
	@Override
	public Adapter createCompensationHandlerAdapter() {
		return fProvider.getAdapter(CompensationHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createTerminationHandlerAdapter()
	 */
	@Override
	public Adapter createTerminationHandlerAdapter() {
		return fProvider.getAdapter(TerminationHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEventHandlerAdapter()
	 */
	@Override
	public Adapter createEventHandlerAdapter() {
		return fProvider.getAdapter(EventHandlerAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createVariableAdapter()
	 */
	@Override
	public Adapter createVariableAdapter() {
		return fProvider.getAdapter(VariableAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEmptyAdapter()
	 */
	@Override
	public Adapter createEmptyAdapter() {
		return fProvider.getAdapter(EmptyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFlowAdapter()
	 */
	@Override
	public Adapter createFlowAdapter() {
		return fProvider.getAdapter(FlowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createInvokeAdapter()
	 */
	@Override
	public Adapter createInvokeAdapter() {
		return fProvider.getAdapter(InvokeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createLinkAdapter()
	 */
	@Override
	public Adapter createLinkAdapter() {
		return fProvider.getAdapter(LinkAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnAlarmAdapter()
	 */
	@Override
	public Adapter createOnAlarmAdapter() {
		return fProvider.getAdapter(OnAlarmAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnMessageAdapter()
	 */
	@Override
	public Adapter createOnMessageAdapter() {
		return fProvider.getAdapter(OnMessageAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOnEventAdapter()
	 */
	@Override
	public Adapter createOnEventAdapter() {
		return fProvider.getAdapter(OnEventAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPartnerLinkAdapter()
	 */
	@Override
	public Adapter createPartnerLinkAdapter() {
		return fProvider.getAdapter(PartnerLinkAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createMessageExchangeAdapter()
	 */
	@Override
	public Adapter createMessageExchangeAdapter() {
		return fProvider.getAdapter(MessageExchangeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPickAdapter()
	 */
	@Override
	public Adapter createPickAdapter() {
		return fProvider.getAdapter(PickAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createProcessAdapter()
	 */
	@Override
	public Adapter createProcessAdapter() {
		return fProvider.getAdapter(ProcessAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createIfAdapter()
	 */
	@Override
	public Adapter createIfAdapter() {
		return fProvider.getAdapter(IfAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createReceiveAdapter()
	 */
	@Override
	public Adapter createReceiveAdapter() {
		return fProvider.getAdapter(ReceiveAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createReplyAdapter()
	 */
	@Override
	public Adapter createReplyAdapter() {
		return fProvider.getAdapter(ReplyAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createSequenceAdapter()
	 */
	@Override
	public Adapter createSequenceAdapter() {
		return fProvider.getAdapter(SequenceAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createScopeAdapter()
	 */
	@Override
	public Adapter createScopeAdapter() {
		return fProvider.getAdapter(ScopeAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createThrowAdapter()
	 */
	@Override
	public Adapter createThrowAdapter() {
		return fProvider.getAdapter(ThrowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createWaitAdapter()
	 */
	@Override
	public Adapter createWaitAdapter() {
		return fProvider.getAdapter(WaitAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createWhileAdapter()
	 */
	@Override
	public Adapter createWhileAdapter() {
		return fProvider.getAdapter(WhileAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createForEachAdapter()
	 */
	@Override
	public Adapter createForEachAdapter() {
		return fProvider.getAdapter(ForEachAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetAdapter()
	 */
	@Override
	public Adapter createCorrelationSetAdapter() {
		return fProvider.getAdapter(CorrelationSetAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetsAdapter()
	 */
	@Override
	public Adapter createMessageExchangesAdapter() {
		return fProvider.getAdapter(MessageExchangesAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCorrelationSetsAdapter()
	 */
	@Override
	public Adapter createCorrelationSetsAdapter() {
		return fProvider.getAdapter(CorrelationSetsAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPartnerLinksAdapter()
	 */
	@Override
	public Adapter createPartnerLinksAdapter() {
		return fProvider.getAdapter(PartnerLinksAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createVariablesAdapter()
	 */
	@Override
	public Adapter createVariablesAdapter() {
		return fProvider.getAdapter(VariablesAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCatchAllAdapter()
	 */
	@Override
	public Adapter createCatchAllAdapter() {
		return fProvider.getAdapter(CatchAllAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createElseAdapter()
	 */
	@Override
	public Adapter createElseAdapter() {
		return fProvider.getAdapter(ElseAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensateAdapter()
	 */
	@Override
	public Adapter createCompensateAdapter() {
		return fProvider.getAdapter(CompensateAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createCompensateScopeAdapter()
	 */
	@Override
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
	@Override
	public Adapter createRethrowAdapter() {
		return fProvider.getAdapter(RethrowAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExitAdapter()
	 */
	@Override
	public Adapter createExitAdapter() {
		return fProvider.getAdapter(ExitAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createValidateAdapter()
	 */
	@Override
	public Adapter createValidateAdapter() {
		return fProvider.getAdapter(ValidateAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createToAdapter()
	 */
	@Override
	public Adapter createToAdapter() {
		return fProvider.getAdapter(ToAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createFromAdapter()
	 */
	@Override
	public Adapter createFromAdapter() {
		return fProvider.getAdapter(FromAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createExpressionAdapter()
	 */
	@Override
	public Adapter createExpressionAdapter() {
		return fProvider.getAdapter(ExpressionAdapter.class);
	}

	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createOpaqueActivityAdapter()
	 */
	@Override
	public Adapter createOpaqueActivityAdapter() {
		return fProvider.getAdapter(OpaqueActivityAdapter.class);
	}

	@Override
	// https://jira.jboss.org/browse/JBIDE-6917
	public Adapter createExtensionActivityAdapter() {
		return fProvider.getAdapter(ExtensionActivityAdapter.class);
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#adaptNew(org.eclipse.emf.common.notify.Notifier,
	 *      java.lang.Object)
	 */
	@Override
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

	@Override
	protected Object resolve(Object object, Object type) {
		return null;
	}

	@Override
	protected Adapter createAdapter(Notifier target, Object type) {
		if (BPELUtil.isCustomActivity(target)) {
			// If we have a custom activity that did not provide a
			// custom adapter we create a default adapter.
			return createCustomActivityAdapter();
		}
		return super.createAdapter(target, type);
	}

}
