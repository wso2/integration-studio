package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.AddBranchCloneMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.AddBranchFailoverEndpointAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.AddBranchLoadBalanceEndpointAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.AddBranchRouterMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.AddBranchSwitchMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureCallTemplateMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureCloneMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureCommandMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureConditionalRouterMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureEsbNodeAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureLogMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigurePayloadFactoryMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureProxyServiceAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureRouterMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureSqlStatementsAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureSwitchMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureTaskAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ConfigureXQueryMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionAggregateMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionCacheMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionCalloutMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionClassMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionCloneMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionCommandMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionDBLookupMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionDBReportMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionDropMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionEnrichMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionEntitlementMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionEsbNodeAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionEventMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionFaultMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionFilterMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionHeaderMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionIterateMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionLogMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionOAuthMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionPropertyMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionRMSequenceMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionRuleMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionScriptMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionSendMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionSmooksMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionSpringMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionSwitchMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionThrottleMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionTransactionMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionXQueryMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.direction.DirectionXSLTMediatorAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.export.EsbModelExportAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBBreakpointAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBBreakpointDeleteAllAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBBreakpointRePopulateAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBSkipPointAction;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	private static final String ESB_DEBUGGER_ACTIONS_MENU_GROUP = "navigateGroup";
	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private DeleteElementAction deleteAction;

	/**
	 * Model export action.
	 */
	private EsbModelExportAction exportAction;

	/**
	 * Actions used to configure {@link EsbNode} objects via custom UIs. 
	 */
	private Map<Class<? extends EsbNode>, ConfigureEsbNodeAction> contextActions;
	private Map<Class<? extends EsbNode>, ConfigureEsbNodeAction> addBranchContextActions;
	private Map<Class<? extends EsbNode>, DirectionEsbNodeAction> contextActionsDirection;

	private EditPart selectedEditorPart;

	/**
	 * @generated NOT
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;

		deleteAction = new DeleteElementAction(part);
		deleteAction.init();
		exportAction = new EsbModelExportAction(part);
		exportAction.init();

		// Initialize context sensitive actions.
		contextActions = new HashMap<Class<? extends EsbNode>, ConfigureEsbNodeAction>();

		contextActions.put(LogMediator.class, new ConfigureLogMediatorAction(part));

		contextActions.put(SwitchMediator.class, new ConfigureSwitchMediatorAction(part));

		contextActions.put(ProxyService.class, new ConfigureProxyServiceAction(part));

		contextActions.put(XQueryMediator.class, new ConfigureXQueryMediatorAction(part));

		contextActions.put(CloneMediator.class, new ConfigureCloneMediatorAction(part));

		contextActions.put(CommandMediator.class, new ConfigureCommandMediatorAction(part));

		contextActions.put(CallTemplateMediator.class, new ConfigureCallTemplateMediatorAction(part));

		contextActions.put(RouterMediator.class, new ConfigureRouterMediatorAction(part));

		contextActions.put(ConditionalRouterMediator.class, new ConfigureConditionalRouterMediatorAction(part));

		contextActions.put(PayloadFactoryMediator.class, new ConfigurePayloadFactoryMediatorAction(part));

		contextActions.put(DBLookupMediator.class, new ConfigureSqlStatementsAction(part));

		contextActions.put(DBReportMediator.class, new ConfigureSqlStatementsAction(part));

		contextActions.put(Task.class, new ConfigureTaskAction(part));

		//Initialize branch context sensitive actions.
		addBranchContextActions = new HashMap<Class<? extends EsbNode>, ConfigureEsbNodeAction>();

		addBranchContextActions.put(SwitchMediator.class, new AddBranchSwitchMediatorAction(part));

		addBranchContextActions.put(FailoverEndPoint.class, new AddBranchFailoverEndpointAction(part));

		addBranchContextActions.put(LoadBalanceEndPoint.class, new AddBranchLoadBalanceEndpointAction(part));

		addBranchContextActions.put(CloneMediator.class, new AddBranchCloneMediatorAction(part));

		addBranchContextActions.put(RouterMediator.class, new AddBranchRouterMediatorAction(part));

		//Initialize direction sensitive actions.
		contextActionsDirection = new HashMap<Class<? extends EsbNode>, DirectionEsbNodeAction>();

		contextActionsDirection.put(LogMediator.class, new DirectionLogMediatorAction(part));

		contextActionsDirection.put(DropMediator.class, new DirectionDropMediatorAction(part));

		contextActionsDirection.put(SwitchMediator.class, new DirectionSwitchMediatorAction(part));

		contextActionsDirection.put(FilterMediator.class, new DirectionFilterMediatorAction(part));

		contextActionsDirection.put(PropertyMediator.class, new DirectionPropertyMediatorAction(part));

		contextActionsDirection.put(EnrichMediator.class, new DirectionEnrichMediatorAction(part));

		contextActionsDirection.put(XSLTMediator.class, new DirectionXSLTMediatorAction(part));

		contextActionsDirection.put(EventMediator.class, new DirectionEventMediatorAction(part));

		contextActionsDirection.put(EntitlementMediator.class, new DirectionEntitlementMediatorAction(part));

		contextActionsDirection.put(ClassMediator.class, new DirectionClassMediatorAction(part));

		contextActionsDirection.put(SpringMediator.class, new DirectionSpringMediatorAction(part));

		contextActionsDirection.put(ScriptMediator.class, new DirectionScriptMediatorAction(part));

		contextActionsDirection.put(FaultMediator.class, new DirectionFaultMediatorAction(part));

		contextActionsDirection.put(XQueryMediator.class, new DirectionXQueryMediatorAction(part));

		contextActionsDirection.put(DBLookupMediator.class, new DirectionDBLookupMediatorAction(part));

		contextActionsDirection.put(DBReportMediator.class, new DirectionDBReportMediatorAction(part));

		contextActionsDirection.put(SmooksMediator.class, new DirectionSmooksMediatorAction(part));

		contextActionsDirection.put(CommandMediator.class, new DirectionCommandMediatorAction(part));

		contextActionsDirection.put(SendMediator.class, new DirectionSendMediatorAction(part));

		contextActionsDirection.put(HeaderMediator.class, new DirectionHeaderMediatorAction(part));

		contextActionsDirection.put(CloneMediator.class, new DirectionCloneMediatorAction(part));

		contextActionsDirection.put(CacheMediator.class, new DirectionCacheMediatorAction(part));

		contextActionsDirection.put(IterateMediator.class, new DirectionIterateMediatorAction(part));

		contextActionsDirection.put(AggregateMediator.class, new DirectionAggregateMediatorAction(part));

		contextActionsDirection.put(CalloutMediator.class, new DirectionCalloutMediatorAction(part));

		contextActionsDirection.put(TransactionMediator.class, new DirectionTransactionMediatorAction(part));

		contextActionsDirection.put(ThrottleMediator.class, new DirectionThrottleMediatorAction(part));

		contextActionsDirection.put(RMSequenceMediator.class, new DirectionRMSequenceMediatorAction(part));

		contextActionsDirection.put(RuleMediator.class, new DirectionRuleMediatorAction(part));

		contextActionsDirection.put(OAuthMediator.class, new DirectionOAuthMediatorAction(part));

	}

	/**
	 * @generated NOT
	 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}

		if (null != exportAction) {
			exportAction.dispose();
			exportAction = null;
		}

		super.dispose();
	}

	/**
	 * @generated NOT
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel()).runExclusive(
					new Runnable() {
						public void run() {
							ContributionItemService.getInstance().contributeToPopupMenu(
									DiagramEditorContextMenuProvider.this, part);
							//menu.removeAll();
							// Fixing TOOLS-1959.
							menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
							menu.remove(ActionIds.ACTION_ADD_NOTELINK);
							menu.remove(ActionIds.MENU_DIAGRAM_ADD);
							//menu.remove(ActionIds.MENU_EDIT);
							menu.remove(ActionIds.MENU_NAVIGATE);
							menu.remove(ActionIds.MENU_VIEW);
							menu.remove(ActionIds.MENU_SELECT);
							menu.remove(ActionIds.ACTION_TOOLBAR_ARRANGE_ALL);

							// Remove Zoom menu item.
							menu.remove(ActionIds.CUSTOM_ZOOM);
							// Remove Filter menu item.
							menu.remove(ActionIds.MENU_FILTERS);
							// Remove Format menu item. 
							menu.remove(ActionIds.MENU_FORMAT);

							menu.appendToGroup("editGroup", deleteAction);
							menu.remove(EsbModelExportAction.ACTION_ID);
							//menu.appendToGroup("editGroup", exportAction);

							// Custom configuration menu item.
							List<?> selectedEPs = getViewer().getSelectedEditParts();
							if (selectedEPs.size() == 1) {
								selectedEditorPart = (IGraphicalEditPart) selectedEPs.get(0);
								EObject contextObj = ((View) selectedEditorPart.getModel()).getElement();
								ConfigureEsbNodeAction contextAction = null;
								ConfigureEsbNodeAction addBranchContextAction = null;

								if (contextObj instanceof EObject) {
									contextAction = contextActions.get(contextObj.eClass().getInstanceClass());
									addBranchContextAction = addBranchContextActions.get(contextObj.eClass()
											.getInstanceClass());
									menu.appendToGroup(
											ESB_DEBUGGER_ACTIONS_MENU_GROUP,
											new ESBBreakpointAction(part));
									menu.appendToGroup(
											ESB_DEBUGGER_ACTIONS_MENU_GROUP,
											new ESBSkipPointAction(part));
									menu.appendToGroup(
											ESB_DEBUGGER_ACTIONS_MENU_GROUP,
											new ESBBreakpointRePopulateAction(
													part));
									menu.appendToGroup(
											ESB_DEBUGGER_ACTIONS_MENU_GROUP,
											new ESBBreakpointDeleteAllAction(
													part));
								}

								if (null != contextAction) {
									menu.appendToGroup("editGroup", contextAction);
								}
								if (null != addBranchContextAction) {
									menu.appendToGroup("editGroup", addBranchContextAction);
								}
							}
							//appendToGroupDirection(menu);
						}
					});
		} catch (Exception e) {
			EsbDiagramEditorPlugin.getInstance().logError("Error building context menu", e);
		}
	}

	private void appendToGroupDirection(IMenuManager menu) {
		List<?> selectedEPs = getViewer().getSelectedEditParts();
		if (selectedEPs.size() == 1) {
			EditPart selectedEP = (IGraphicalEditPart) selectedEPs.get(0);
			EObject contextObj = ((View) selectedEditorPart.getModel()).getElement();
			DirectionEsbNodeAction contextActionDirection = contextActionsDirection.get(contextObj.eClass()
					.getInstanceClass());

			if (null != contextActionDirection) {
				contextActionDirection.setEditorPart(selectedEditorPart);
				menu.appendToGroup("editGroup", contextActionDirection);
			}
		}
	}
}
