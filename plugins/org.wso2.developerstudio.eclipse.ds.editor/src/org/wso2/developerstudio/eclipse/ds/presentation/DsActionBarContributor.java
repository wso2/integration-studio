/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.ds.presentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.CallQueryList;
import org.wso2.developerstudio.eclipse.ds.ConfigurationProperty;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.ElementMapping;
import org.wso2.developerstudio.eclipse.ds.EventSubscriptionList;
import org.wso2.developerstudio.eclipse.ds.EventTrigger;
import org.wso2.developerstudio.eclipse.ds.Operation;
import org.wso2.developerstudio.eclipse.ds.Query;
import org.wso2.developerstudio.eclipse.ds.QueryParameter;
import org.wso2.developerstudio.eclipse.ds.QueryPropertyList;
import org.wso2.developerstudio.eclipse.ds.Resource;
import org.wso2.developerstudio.eclipse.ds.ResultMapping;
import org.wso2.developerstudio.eclipse.ds.actions.DSAction;
import org.wso2.developerstudio.eclipse.ds.actions.DSActionConstants;
import org.wso2.developerstudio.eclipse.ds.actions.DataSourceConfigurationAction;
import org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl;
import org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl;
import org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl;
import org.wso2.developerstudio.eclipse.ds.impl.QueryImpl;
import org.wso2.developerstudio.eclipse.ds.provider.DsEditPlugin;
import org.wso2.developerstudio.eclipse.ds.provider.choiceListProvider.DSPropertyDescriptor;

/**
 * This is the action bar contributor for the DS Model Editor. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DsActionBarContributor extends EditingDomainActionBarContributor implements
                                                                             ISelectionChangedListener {

	/**
     * This keeps track of the active editor.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	protected IEditorPart activeEditorPart;

	/**
     * This keeps track of the current selection provider.
     * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
     * @generated
     */
	protected ISelectionProvider selectionProvider;

	/**
	 * Indicates whether the menu items belonging to a DataSource element need
	 * to be displayed.
	 */
	private boolean generateDataSourceMenu = false;

	/**
	 * Indicates whether the menu items common to Query, Operation and Resource
	 * elements need to be displayed.
	 */
	private boolean generateQueryMenu = false;

	/**
	 * Indicates whether the menu items belonging to a Query element need to be
	 * displayed.
	 */
	private boolean generateQueryChildrenMenu = false;

	/**
	 * Indicates whether the menu items belonging to a Query element need to be
	 * displayed.
	 */
	private boolean generateOutputMappingMenu = false;

	private boolean generateElementMappingMenu = false;

	private boolean generateExcelMenu = false;

	/**
	 * Indicates whether the menu items belonging to Call-Query and Input
	 * Mapping elements need to be displayed.
	 */
	private boolean generateCallQueryInputMappingMenu = false;

	/**
	 * generateCallQueryInputMappingMenu indicates whether the menu items
	 * belonging to a Validator element need to be displayed.
	 */
	private boolean generateValidatorMenu = false;

	private boolean generateEventTriggerMenu = false;

	/**
	 * Indicates whether the menu items belonging to a Subscription element need
	 * to be displayed.
	 */
	private boolean generateSubscriptionMenu = false;

	/**
	 * Indicates whether the menu items belonging to a Call Query element need
	 * to be displayed.
	 */
	private boolean generateCallQueryMenu = false;

	/**
	 * Indicates whether the menu items belonging to a Query Property List need
	 * to be displayed.
	 */
	private boolean generateQueryPropertyListMenu = false;

	/**
	 * The ds menu manager manages contributions to a menu bar and its sub
	 * menus. Also allows sub-menus to be nested in parent menus.
	 */
	private IMenuManager dsMenuManager;

	/** The rdbms data source actions. */
	private List<IAction> rdbmsDataSourceActions;

	/** The data source actions. */
	private List<IAction> dataSourceActions;

	/** The query action. */
	private IAction queryAction;
	
	/** The query property group action. */
	private IAction queryPropertyGroupAction;

	/** The query property action. */
	private IAction queryPropertyAction;

	/** The result action. */
	private IAction resultAction;

	/** The output mappings actions. */
	private List<IAction> outputMappingsActions;

	/** The call query action. */
	private IAction callQueryAction;

	/** The call query input mapping action. */
	private IAction callQueryInputMappingAction;

	/** The output mappings menu manager. */
	private IMenuManager outputMappingsMenuManager;

	/** The validator menu manager. */
	private IMenuManager validatorMenuManager;

	/** The validator actions. */
	private List<IAction> validatorActions;

	/** The event trigger action. */
	private IAction eventTriggerAction;

	private IAction expressionAction;

	private IAction targetTopicAcion;

	/** The subscription action. */
	private IAction subscriptionAction;

	/** The operation action. */
	private IAction operationAction;

	/** The resource action. */
	private IAction resourceAction;

	/** The rdbms menu manager. */
	private IMenuManager rdbmsMenuManager;

	/** The shell. */
	private final Shell shell = new Shell();

	private DSAction descriptionAction;
	
	private DSAction policyAction;

	/** The data source configuration instance. */
	private DataSourceConfiguration config;

	/** The query instance. */
	private Query query;

	/** The event trigger instance. */
	private EventTrigger eventTrigger;

	/** The result. */
	private ResultMapping result;

	private DSAction sqlAction;

	private DSAction sparqlAction;

	private DSAction excelAction;

	private DSAction gspredAction;
	
	private DSAction queryExpressionAction;

	private DSAction queryParmAction;

	/** The selected object in the editor. */
	private Object referenceObject = null;

	/**
     * This action opens the Properties view.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	protected IAction showPropertiesViewAction = new Action(DsEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) {
            @Override
            public void run() {
                try {
                    getPage().showView("org.eclipse.ui.views.PropertySheet");
                }
                catch (PartInitException exception) {
                    DsEditorPlugin.INSTANCE.log(exception);
                }
            }
        };

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IAction refreshViewerAction = new Action(DsEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {
            @Override
            public boolean isEnabled() {
                return activeEditorPart instanceof IViewerProvider;
            }

            @Override
            public void run() {
                if (activeEditorPart instanceof IViewerProvider) {
                    Viewer viewer = ((IViewerProvider)activeEditorPart).getViewer();
                    if (viewer != null) {
                        viewer.refresh();
                    }
                }
            }
        };

	/**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor
     * generated for the current selection by the item provider.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected Collection<IAction> createChildActions;

	/**
	 * This is the menu manager into which menu contribution items should be
	 * added for CreateChild actions. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected IMenuManager createChildMenuManager;

	/**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor
     * generated for the current selection by the item provider.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected Collection<IAction> createSiblingActions;

	/**
     * This is the menu manager into which menu contribution items should be added for CreateSibling actions.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	protected IMenuManager createSiblingMenuManager;

	/**
     * This creates an instance of the contributor.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	public DsActionBarContributor() {
        super(ADDITIONS_LAST_STYLE);
        loadResourceAction = new LoadResourceAction();
        validateAction = new ValidateAction();
        controlAction = new ControlAction();
    }

	/**
	 * This adds Separators for editor additions to the tool bar. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param toolBarManager
	 *            the tool bar manager
	 * @generated
	 */

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
        toolBarManager.add(new Separator("ds-settings"));
        toolBarManager.add(new Separator("ds-additions"));
    }

	/**
	 * This adds to the menu bar a menu and some separators for editor
	 * additions, as well as the sub-menus for object creation items. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param menuManager
	 *            the menu manager
	 * @generated_not
	 */

	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager =
		                              new MenuManager(
		                                              DsEditorPlugin.INSTANCE.getString("_UI_DsEditor_menu"),
		                                              "org.wso2.developerstudio.eclipse.dsMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		// Prepare for item addition or removal.

		if (generateDataSourceMenu) {
			submenuManager.insertBefore("additions", dsMenuManager);
		}

		if (generateQueryMenu) {
			submenuManager.insertBefore("additions", queryAction);
			submenuManager.insertBefore("additions", operationAction);
			submenuManager.insertBefore("additions", resourceAction);
		}

		if (generateQueryChildrenMenu) {
			submenuManager.insertBefore("additions", resultAction);
			submenuManager.insertBefore("additions", eventTriggerAction);
			submenuManager.insertBefore("additions", queryPropertyGroupAction);
		}

		if (generateSubscriptionMenu) {
			submenuManager.insertBefore("additions", subscriptionAction);
		}

		if (generateCallQueryInputMappingMenu) {
			submenuManager.insertBefore("additions", callQueryInputMappingAction);
		}

		if (generateOutputMappingMenu) {
			submenuManager.insertBefore("additions", outputMappingsMenuManager);
		}

		if (generateCallQueryMenu) {
			submenuManager.insertBefore("additions", callQueryAction);
		}

		if (generateValidatorMenu) {
			submenuManager.insertBefore("additions", validatorMenuManager);
		}

		if (generateQueryPropertyListMenu) {

			submenuManager.insertBefore("additions", queryPropertyAction);
		}

		// Force an update because Eclipse hides empty menus now.

		submenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager menuManager) {
				menuManager.updateAll(true);
			}
		});

		addGlobalActions(submenuManager);
	}

	/**
     * When the active editor changes, this remembers the change and registers with it as a selection provider.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */

	@Override
	public void setActiveEditor(IEditorPart part) {
        super.setActiveEditor(part);
        activeEditorPart = part;

        // Switch to the new selection provider.
        //
        if (selectionProvider != null) {
            selectionProvider.removeSelectionChangedListener(this);
        }
        if (part == null) {
            selectionProvider = null;
        }
        else {
            selectionProvider = part.getSite().getSelectionProvider();
            selectionProvider.addSelectionChangedListener(this);

            // Fake a selection changed event to update the menus.
            //
            if (selectionProvider.getSelection() != null) {
                selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
            }
        }
    }

	/**
	 * This handles the functionality when the selection is changed.
	 * 
	 * @param event
	 *            the event
	 *            {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 *            handling
	 *            {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by
	 *            querying for the children and siblings that can be added to
	 *            the selected object and updating the menus accordingly. <!--
	 *            begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void selectionChanged(SelectionChangedEvent event) {

		// Remove any menu items for old selection.

		if (dsMenuManager != null) {
			depopulateDatasourceActions();
		}

		if (outputMappingsMenuManager != null) {
			depopulateOutputMappingActions();
		}

		if (validatorMenuManager != null) {
			depopulateValidatorActions();
		}

		// Query the new selection for appropriate new child/sibling descriptors

		Collection<?> newChildDescriptors = null;
		Collection<?> newSiblingDescriptors = null;

		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection &&
		    ((IStructuredSelection) selection).size() == 1) {
			referenceObject = ((IStructuredSelection) selection).getFirstElement();

			// An editing domain manages a self-contained set of interrelated
			// EMF models and the Commands that modify them. The models are
			// maintained in the form of a ResourceSet.

			EditingDomain domain = ((IEditingDomainProvider) activeEditorPart).getEditingDomain();

			// The ids of config, query and event-trigger objects that are
			// already in the tree need to be determined
			// in order to populate drop down lists.

			DSPropertyDescriptor.populateIds(referenceObject);

			// This returns a collection of objects describing the different
			// children that can be added under the specified object

			newChildDescriptors = domain.getNewChildDescriptors(referenceObject, null);

			// This returns a collection of objects describing the different
			// siblings that can be added under the specified object

			newSiblingDescriptors = domain.getNewChildDescriptors(null, referenceObject);

			// If the selected element is of type DataService

			if (referenceObject != null && referenceObject instanceof DataService) {

				generateDataSourceMenu = true;

				populateAddDatasourceActions(selection, domain, newChildDescriptors);

				descriptionAction =
				                    new DSAction(selection, domain, newChildDescriptors,
				                                 DSActionConstants.ADD_DESCRIPTION_ACTION);
				
				policyAction =
	                    new DSAction(selection, domain, newChildDescriptors,
	                                 DSActionConstants.ADD_POLICY_ACTION);

				queryAction =
				              new DSAction(selection, domain, newChildDescriptors,
				                           DSActionConstants.ADD_QUERY_ACTION);

				operationAction =
				                  new DSAction(selection, domain, newChildDescriptors,
				                               DSActionConstants.ADD_OPERATION_ACTION);

				eventTriggerAction =
				                     new DSAction(selection, domain, newChildDescriptors,
				                                  DSActionConstants.ADD_EVENT_TRIGGER_ACTION);

				resourceAction =
				                 new DSAction(selection, domain, newChildDescriptors,
				                              DSActionConstants.ADD_RESOURCE_ACTION);

			} else {
				generateDataSourceMenu = false;
			}

			// If the selected element is of type DataSourceConfiguration

			if (referenceObject != null && referenceObject instanceof DataSourceConfiguration) {

				config = (DataSourceConfigurationImpl) referenceObject;

				// do noting we do nto give add properties to the configuration

			}

			// If the selected element is of type Query

			if (referenceObject != null && referenceObject instanceof Query) {
				query = (QueryImpl) referenceObject;
				generateQueryMenu = true;

				sqlAction =
				            new DSAction(selection, domain, newChildDescriptors,
				                         DSActionConstants.ADD_SQL_ACTION);

				sparqlAction =
				               new DSAction(selection, domain, newChildDescriptors,
				                            DSActionConstants.ADD_SPARQL_ACTION);

				queryPropertyGroupAction =
				                           new DSAction(
				                                        selection,
				                                        domain,
				                                        newChildDescriptors,
				                                        DSActionConstants.ADD_QUERY_PROPERTY_LIST_ACTION);

				resultAction =
				               new DSAction(selection, domain, newChildDescriptors,
				                            DSActionConstants.ADD_OUTPUT_MAPPING_ACTION);

				excelAction =
				              new DSAction(selection, domain, newChildDescriptors,
				                           DSActionConstants.ADD_EXCEL_QUERY_ACTION);

				gspredAction =
				               new DSAction(selection, domain, newChildDescriptors,
				                            DSActionConstants.ADD_GSPREAD_QUERY_ACTION);
				
				queryExpressionAction =
			               new DSAction(selection, domain, newChildDescriptors,
			                            DSActionConstants.ADD_QUERY_EXPRESSION_ACTION);

				queryParmAction =
				                  new DSAction(selection, domain, newChildDescriptors,
				                               DSActionConstants.ADD_INPUT_MAPPING_ACTION);// DSActionConstants.ADD_QUERY_PARAM_ACTION);

			} else {
				generateQueryMenu = false;

			}

			// If the selected element is of type QueryPropertyList

			if (referenceObject != null && referenceObject instanceof QueryPropertyList) {
				generateQueryPropertyListMenu = true;

				queryPropertyAction =
				                      new DSAction(selection, domain, newChildDescriptors,
				                                   DSActionConstants.ADD_QUERY_PROPERTY_ACTION);

			} else {

				generateQueryPropertyListMenu = false;
			}

			// if the selected element is ResultMapping

			if (referenceObject != null && referenceObject instanceof ResultMapping) {

				result = (ResultMapping) referenceObject;
				generateOutputMappingMenu = true;
				populateAddElementAndAttributeAction(selection, domain, newChildDescriptors);

			} else {

				generateOutputMappingMenu = false;
			}

			if (referenceObject != null && referenceObject instanceof ElementMapping) {

				ElementMapping elmMap = (ElementMapping) referenceObject;

				if (elmMap.isIsComplexType()) {
					generateElementMappingMenu = true;
				} else {
					generateElementMappingMenu = false;
				}
				populateAddElementAndAttributeAction(selection, domain, newChildDescriptors);

			} else {

				generateElementMappingMenu = false;
			}

			// If the selected element is of type QueryParameter

			if (referenceObject != null && referenceObject instanceof QueryParameter) {

				generateValidatorMenu = true;
				populateAddValidatorAction(selection, domain, newChildDescriptors);

			} else {
				generateValidatorMenu = false;
			}

			// If the selected element is of type EventTrigger

			if (referenceObject != null && referenceObject instanceof EventTrigger) {
				eventTrigger = (EventTriggerImpl) referenceObject;
				generateEventTriggerMenu = true;

				expressionAction =
				                   new DSAction(selection, domain, newChildDescriptors,
				                                DSActionConstants.ADD_EXPRESSION_ACTION);
				targetTopicAcion =
				                   new DSAction(selection, domain, newChildDescriptors,
				                                DSActionConstants.ADD_TARGET_TOPOIC_ACTION);
				subscriptionAction =
				                     new DSAction(selection, domain, newChildDescriptors,
				                                  DSActionConstants.ADD_SUBSCRIPTIONS_ACTION);

			} else {
				generateEventTriggerMenu = false;

			}

			// if the selected element is of type EventSubscriptionList

			if (referenceObject != null && referenceObject instanceof EventSubscriptionList) {

				generateSubscriptionMenu = true;

				subscriptionAction =
				                     new DSAction(selection, domain, newChildDescriptors,
				                                  DSActionConstants.ADD_SUBSCRIPTION_ACTION);
			} else {

				generateSubscriptionMenu = false;
			}

			// If the selected element is of type Operation or Resource or
			// CallQueryList (to generate the Add Call Query menu item since
			// CallQuery is a common child)
			if (referenceObject != null &&
			    (referenceObject instanceof Operation || referenceObject instanceof Resource || referenceObject instanceof CallQueryList)) {
				generateCallQueryMenu = true;
				callQueryAction =
				                  new DSAction(
				                               selection,
				                               domain,
				                               newChildDescriptors,
				                               DSActionConstants.ADD_OUTPUT_MAPPING_CALL_QUERY_ACTION);
			} else {

				generateCallQueryMenu = false;
			}

			// If the selected element is of type CallQuery

			if (referenceObject != null && referenceObject instanceof CallQuery) {
				generateCallQueryInputMappingMenu = true;
				callQueryInputMappingAction =
				                              new DSAction(
				                                           selection,
				                                           domain,
				                                           newChildDescriptors,
				                                           DSActionConstants.ADD_INPUT_MAPPING_ACTION);

			} else {
				generateCallQueryInputMappingMenu = false;
			}

		}
	}

	/**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
     * and returns the collection of these actions.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors,
	                                                         ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

	/**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
     * and returns the collection of these actions.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors,
	                                                           ISelection selection) {
        Collection<IAction> actions = new ArrayList<IAction>();
        if (descriptors != null) {
            for (Object descriptor : descriptors) {
                actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));
            }
        }
        return actions;
    }

	/**
     * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
     * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,
     * by inserting them before the specified contribution item <code>contributionID</code>.
     * If <code>contributionID</code> is <code>null</code>, they are simply added.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected void populateManager(IContributionManager manager,
	                               Collection<? extends IAction> actions, String contributionID) {
        if (actions != null) {
            for (IAction action : actions) {
                if (contributionID != null) {
                    manager.insertBefore(contributionID, action);
                }
                else {
                    manager.add(action);
                }
            }
        }
    }

	/**
     * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s
     * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	protected void depopulateManager(IContributionManager manager,
	                                 Collection<? extends IAction> actions) {
        if (actions != null) {
            IContributionItem[] items = manager.getItems();
            for (int i = 0; i < items.length; i++) {
                // Look into SubContributionItems
                //
                IContributionItem contributionItem = items[i];
                while (contributionItem instanceof SubContributionItem) {
                    contributionItem = ((SubContributionItem)contributionItem).getInnerItem();
                }

                // Delete the ActionContributionItems with matching action.
                //
                if (contributionItem instanceof ActionContributionItem) {
                    IAction action = ((ActionContributionItem)contributionItem).getAction();
                    if (actions.contains(action)) {
                        manager.remove(contributionItem);
                    }
                }
            }
        }
    }

	/**
	 * This populates the pop-up menu(context menu) before it appears. <!--
	 * begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param menuManager
	 *            the menu manager
	 * @generated NOT
	 */

	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);

		// Menu for data service item

		if (generateDataSourceMenu) {
			generateDataSourceSubMenusAndActions();
			menuManager.insertBefore("edit", dsMenuManager);
			menuManager.insertBefore("edit", descriptionAction);
			menuManager.insertBefore("edit", queryAction);
			menuManager.insertBefore("edit", eventTriggerAction);
			menuManager.insertBefore("edit", operationAction);
			menuManager.insertBefore("edit", resourceAction);
			menuManager.insertBefore("edit", policyAction);
			generateDataSourceMenu = false;
		}

		// Menu for query item

		if (generateQueryMenu) {

			if (query != null && (query.getId() == null || StringUtils.isBlank(query.getId()))) {

				displayError("Enter the Query Id to proceed.");

			} else if (query != null &&
			           (query.getUseConfig() == null || StringUtils.isBlank(query.getUseConfig()))) {

				displayError("Please Select a valid data source to proceed.");

			} else {

				DataService dataService = getDataServiceObject(query);

				if (dataService != null && query.getUseConfig() != null) {

					String dataSourceType = getDataSourceType(dataService, query.getUseConfig());

					if (dataSourceType.equals(DSActionConstants.DRIVER_PROPERTY) ||
					    dataSourceType.equals(DSActionConstants.JNDI_CONTEXT_PROPERTY) ||
					    dataSourceType.equals(DSActionConstants.CARBON_DATASOURCE_NAME_PROPERTY)) {

						menuManager.insertBefore("edit", sqlAction);

					} else if (dataSourceType.equals(DSActionConstants.EXCEL_DATASOURCE_PROPERTY)) {

						menuManager.insertBefore("edit", excelAction);

					} else if (dataSourceType.equals(DSActionConstants.GSPREAD_DATASOURCE_PROPERTY)) {

						menuManager.insertBefore("edit", gspredAction);

					} else if (dataSourceType.equals(DSActionConstants.CASSANDRA_DRIVER_CLASS_NAME)) {

						menuManager.insertBefore("edit", queryExpressionAction);

					} else {
						// TODO since editor does not have RDF dataSource ,can
						// not show the sparql action.
						menuManager.insertBefore("edit", sparqlAction);
					}
				}

				menuManager.insertBefore("edit", queryPropertyGroupAction);
				menuManager.insertBefore("edit", resultAction);
				menuManager.insertBefore("edit", queryParmAction);
				generateQueryMenu = false;

			}
		}

		// Menu for query property list item

		if (generateQueryPropertyListMenu) {
			menuManager.insertBefore("edit", queryPropertyAction);

		}

		// To add an Output Mapping to a Result element, the Grouped By Element
		// and Row Name values should be provided.
		if (generateOutputMappingMenu | generateElementMappingMenu) {

			if (result != null &&
			    (result.getElementName() == null || StringUtils.isBlank(result.getElementName()))) {

				displayError("Enter value for Grouped by Element");

			} else {
				String lb = DSActionConstants.ADD_OUTPUT_MAPPING_ACTION;
				if (generateElementMappingMenu) {
					lb = DSActionConstants.ADD_OUTOUT_MAPPING_NESTED_ELEMENT;
					generateElementMappingMenu = false;
				}
				generateOutputMappingSubMenusAndActions(lb);
				menuManager.insertBefore("edit", outputMappingsMenuManager);
				generateOutputMappingMenu = false;

			}
		}
		// Validator menu

		if (generateValidatorMenu) {
			generateValidatorSubMenusAndActions();
			menuManager.insertBefore("edit", validatorMenuManager);
			generateValidatorMenu = false;
		}

		// event trigger menu

		if (generateEventTriggerMenu) {

			menuManager.insertBefore("edit", expressionAction);
			menuManager.insertBefore("edit", targetTopicAcion);
			menuManager.insertBefore("edit", subscriptionAction);
			generateEventTriggerMenu = false;
		}

		// subscription menu

		if (generateSubscriptionMenu) {

			menuManager.insertBefore("edit", subscriptionAction);
			generateSubscriptionMenu = false;
		}

		if (generateCallQueryMenu) {
			menuManager.insertBefore("edit", callQueryAction);
			generateCallQueryMenu = false;
		}

		if (generateCallQueryInputMappingMenu) {
			menuManager.insertBefore("edit", callQueryInputMappingAction);
			generateCallQueryInputMappingMenu = false;
		}

	}

	/**
	 * This inserts global actions before the "additions-end" separator. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param menuManager
	 *            the menu manager
	 * @generated
	 */

	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
        menuManager.insertAfter("additions-end", new Separator("ui-actions"));
        menuManager.insertAfter("ui-actions", showPropertiesViewAction);

        refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());		
        menuManager.insertAfter("ui-actions", refreshViewerAction);

        super.addGlobalActions(menuManager);
    }

	/**
     * This ensures that a delete action will clean up all references to deleted objects.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */

	@Override
	protected boolean removeAllReferencesOnDelete() {
        return true;
    }

	/**
	 * Populate Data Source Actions for Different Types of Data Sources.
	 * 
	 * @param selection
	 *            the selection
	 * @param domain
	 *            the domain
	 * @param newDSChildDescriptors
	 *            the new DS child descriptors
	 */
	private void populateAddDatasourceActions(ISelection selection, EditingDomain domain,
	                                          Collection<?> newDSChildDescriptors) {

		// Create an array list to hold actions
		dataSourceActions = new ArrayList<IAction>();

		// RDBMS type is a sub menu, therefore create a separate container to
		// hold its actions
		rdbmsDataSourceActions = new ArrayList<IAction>();

		// Add actions for MySQL data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.MYSQL_DATASOURCE_TYPE,
		                                                             DSActionConstants.MYSQL_DRIVER_VALUE,
		                                                             DSActionConstants.MYSQL_PROTOCOL_VALUE));

		// Add actions for Apache Derby data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.APACHE_DERBY_DATASOURCE_TYPE,
		                                                             DSActionConstants.APACHE_DERBY_DRIVER_VALUE,
		                                                             DSActionConstants.APACHE_DERBY_PROTOCOL_VALUE));

		// Add actions for Microsoft SQL Server data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.MS_SQL_SERVER_DATASOURCE_TYPE,
		                                                             DSActionConstants.MS_SQL_SERVER_DRIVER_VALUE,
		                                                             DSActionConstants.MS_SQL_SERVER_PROTOCOL_VALUE));

		// Add actions for Oracle data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.ORACLE_DATASOURCE_TYPE,
		                                                             DSActionConstants.ORACLE_DRIVER_VALUE,
		                                                             DSActionConstants.ORACLE_PROTOCOL_VALUE));

		// Add actions for IBM DB2 data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.IBM_DB2_DATASOURCE_TYPE,
		                                                             DSActionConstants.IBM_DB2_DRIVER_VALUE,
		                                                             DSActionConstants.IBM_DB2_PROTOCOL_VALUE));

		// Add actions for HSQLDB data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.HSQLDB_DATASOURCE_TYPE,
		                                                             DSActionConstants.HSQLDB_DB_DRIVER_VALUE,
		                                                             DSActionConstants.HSQLDB_DB_PROTOCOL_VALUE));

		// Add actions for Informix data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.INFORMIX_DATASOURCE_TYPE,
		                                                             DSActionConstants.INFORMIX_DRIVER_VALUE,
		                                                             DSActionConstants.INFORMIX_PROTOCOL_VALUE));

		// Add actions for PostgreSQL data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.POSTGRESQL_DATASOURCE_TYPE,
		                                                             DSActionConstants.POSTGRESQL_DRIVER_VALUE,
		                                                             DSActionConstants.POSTGRESQL_PROTOCOL_VALUE));

		// Add actions for Sybase ASE data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.SYBASE_ASE_DATASOURCE_TYPE,
		                                                             DSActionConstants.SYBASE_ASE_DRIVER_VALUE,
		                                                             DSActionConstants.SYBASE_ASE_PROTOCOL_VALUE));

		// Add actions for H2 data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.H2_DATASOURCE_TYPE,
		                                                             DSActionConstants.H2_DRIVER_VALUE,
		                                                             DSActionConstants.H2_PROTOCOL_VALUE));

		// Add actions for Generic data sources
		rdbmsDataSourceActions.add(new DataSourceConfigurationAction(
		                                                             selection,
		                                                             domain,
		                                                             newDSChildDescriptors,
		                                                             DSActionConstants.RDBMS_TYPE,
		                                                             DSActionConstants.GENERIC_DATASOURCE_TYPE,
		                                                             DSActionConstants.GENERIC_DRIVER_VALUE,
		                                                             DSActionConstants.GENERIC_PROTOCOL_VALUE));

		// CSV Type
		dataSourceActions.add(new DataSourceConfigurationAction(selection, domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.CSV_TYPE, null,
		                                                        null, null));
		
		// Cassandra Type
		dataSourceActions.add(new DataSourceConfigurationAction(selection, domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.CASSANDRA_TYPE, null,
		                                                        DSActionConstants.CASSANDRA_DRIVER_VALUE, null));
		// Excel Type
		dataSourceActions.add(new DataSourceConfigurationAction(selection, domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.SPREADSHEET_TYPE,
		                                                        null, null, null));

		// JNDI Type
		dataSourceActions.add(new DataSourceConfigurationAction(selection, domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.JNDI_TYPE, null,
		                                                        null, null));

		// Google Spreadsheet Type
		dataSourceActions.add(new DataSourceConfigurationAction(selection, domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.GSPREAD_TYPE,
		                                                        null, null, null));

		// Carbon Datasource Type
		dataSourceActions.add(new DataSourceConfigurationAction(
		                                                        selection,
		                                                        domain,
		                                                        newDSChildDescriptors,
		                                                        DSActionConstants.CARBON_DATASOURCE_TYPE,
		                                                        null, null, null));

	}

	/**
	 * Populate add element and attribute action.
	 * 
	 * @param selection
	 *            the selection
	 * @param domain
	 *            the domain
	 * @param newOutputMappingChildDescriptors
	 *            the new output mapping child descriptors
	 */
	private void populateAddElementAndAttributeAction(ISelection selection, EditingDomain domain,
	                                                  Collection<?> newOutputMappingChildDescriptors) {

		boolean enableCompleElem = false;
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object owner = structuredSelection.getFirstElement();
		if (owner instanceof ElementMapping) {

			ElementMapping element = (ElementMapping) owner;
			enableCompleElem = element.isIsComplexType();

		} else {

			enableCompleElem = true;
		}
		if (enableCompleElem) {
			outputMappingsActions = new ArrayList<IAction>();
			outputMappingsActions.add(new DSAction(
			                                       selection,
			                                       domain,
			                                       newOutputMappingChildDescriptors,
			                                       DSActionConstants.ADD_OUTPUT_MAPPING_ELEMENT_ACTION));
			outputMappingsActions.add(new DSAction(
			                                       selection,
			                                       domain,
			                                       newOutputMappingChildDescriptors,
			                                       DSActionConstants.ADD_OUTPUT_MAPPING_ATTRIBUTE_ACTION));
			outputMappingsActions.add(new DSAction(
			                                       selection,
			                                       domain,
			                                       newOutputMappingChildDescriptors,
			                                       DSActionConstants.ADD_OUTPUT_MAPPING_CALL_QUERY_ACTION));

			outputMappingsActions.add(new DSAction(
			                                       selection,
			                                       domain,
			                                       newOutputMappingChildDescriptors,
			                                       DSActionConstants.ADD_OUTPUT_MAPPING_COMPLEX_ELEMENT));
		}

	}

	/**
	 * Populate add validator action.
	 * 
	 * @param selection
	 *            the selection
	 * @param domain
	 *            the domain
	 * @param newValidatorChildDescriptors
	 *            the new validator child descriptors
	 */
	private void populateAddValidatorAction(ISelection selection, EditingDomain domain,
	                                        Collection<?> newValidatorChildDescriptors) {
		validatorActions = new ArrayList<IAction>();

		validatorActions.add(new DSAction(selection, domain, newValidatorChildDescriptors,
		                                  DSActionConstants.ADD_LONG_RANGE_VALIDATOR_ACTION));

		validatorActions.add(new DSAction(selection, domain, newValidatorChildDescriptors,
		                                  DSActionConstants.ADD_DOUBLE_RANGE_VALIDATOR_ACTION));

		validatorActions.add(new DSAction(selection, domain, newValidatorChildDescriptors,
		                                  DSActionConstants.ADD_LENGTH_VALIDATOR_ACTION));

		validatorActions.add(new DSAction(selection, domain, newValidatorChildDescriptors,
		                                  DSActionConstants.ADD_PATTERN_VALIDATOR_ACTION));

		validatorActions.add(new DSAction(selection, domain, newValidatorChildDescriptors,
		                                  DSActionConstants.ADD_CUSTOM_VALIDATOR_ACTION));
	}

	/**
	 * Depopulate datasource actions.
	 */
	private void depopulateDatasourceActions() {

		if (rdbmsDataSourceActions != null) {
			for (int i = 0; i < rdbmsDataSourceActions.size(); i++) {
				rdbmsDataSourceActions.remove(i);
			}
		}

		if (dataSourceActions != null) {
			for (int i = 0; i < dataSourceActions.size(); i++) {
				dataSourceActions.remove(i);
			}
		}
	}

	/**
	 * Depopulate output mapping actions.
	 */
	private void depopulateOutputMappingActions() {

		if (outputMappingsActions != null) {
			for (int i = 0; i < outputMappingsActions.size(); i++) {
				outputMappingsActions.remove(i);
			}
		}
	}

	/**
	 * Depopulate validator actions.
	 */
	private void depopulateValidatorActions() {

		if (validatorActions != null) {
			for (int i = 0; i < validatorActions.size(); i++) {
				validatorActions.remove(i);
			}
		}
	}

	/**
	 * Generate Menus and Sub Menus Related to Data Services.
	 */
	protected void generateDataSourceSubMenusAndActions() {

		URL url = (URL) DsEditPlugin.INSTANCE.getImage("wso2/rdbms");

		rdbmsMenuManager =
		                   new MenuManager(DSActionConstants.RDBMS_TYPE,
		                                   ImageDescriptor.createFromURL(url), null);

		for (IAction action : rdbmsDataSourceActions) {
			rdbmsMenuManager.add(action);
		}

		dsMenuManager = new MenuManager(DSActionConstants.ADD_DATASOURCE_ACTION);
		dsMenuManager.add(rdbmsMenuManager);

		for (IAction action : dataSourceActions) {
			dsMenuManager.add(action);
		}

	}

	/**
	 * Generate output mapping sub menus and actions.
	 */
	protected void generateOutputMappingSubMenusAndActions(String actionLable) {

		outputMappingsMenuManager = new MenuManager(actionLable);

		for (IAction action : outputMappingsActions) {
			outputMappingsMenuManager.add(action);
		}

	}

	/**
	 * Generate validator sub menus and actions.
	 */
	protected void generateValidatorSubMenusAndActions() {

		validatorMenuManager = new MenuManager(DSActionConstants.ADD_VALIDATOR_ACTION);

		for (IAction action : validatorActions) {
			validatorMenuManager.add(action);
		}

	}

	/**
	 * Display error.
	 * 
	 * @param errorMsg
	 *            the error msg
	 */
	private void displayError(String errorMsg) {
		if (shell != null) {
			MessageDialog.openWarning(shell, "Warning", errorMsg);
		}
	}

	/**
	 * 
	 * @param eobject
	 *            EObject submit to get the root
	 * @return DataService Object
	 */
	private DataService getDataServiceObject(EObject eobject) {

		DocumentRootImpl root = (DocumentRootImpl) EcoreUtil.getRootContainer(eobject);
		return root.getData();
	}

	private String getDataSourceType(DataService dataService, String usedDataSource) {

		String dataSourceType = "";

		if (dataService != null) {
			int index = 0;
			EList<DataSourceConfiguration> configList = dataService.getConfig();

			DataSourceConfiguration[] confArr = configList.toArray(new DataSourceConfiguration[0]);

			for (int j = 0; j < configList.size(); j++) {

				if (confArr[j].getId() != null && confArr[j].getId().equals(usedDataSource)) {

					index = j;
				}

			}

			if (configList != null && !configList.isEmpty()) {
				DataSourceConfiguration config = configList.get(index);

				EList<ConfigurationProperty> proplist = config.getProperty();

				Iterator<ConfigurationProperty> iterator = proplist.iterator();

				while (iterator.hasNext()) {

					ConfigurationProperty property = (ConfigurationProperty) iterator.next();

					if (property != null) {

						if (property.getName().equals(DSActionConstants.DRIVER_PROPERTY) ||
						    property.getName().equals(DSActionConstants.CSV_DATASOURCE_PROPERTY) ||
						    property.getName().equals(DSActionConstants.EXCEL_DATASOURCE_PROPERTY) ||
						    property.getName().equals(DSActionConstants.JNDI_CONTEXT_PROPERTY) ||
						    property.getName()
						            .equals(DSActionConstants.GSPREAD_DATASOURCE_PROPERTY) ||
						    property.getName()
						            .equals(DSActionConstants.CARBON_DATASOURCE_NAME_PROPERTY)||
						    property.getName().equals(DSActionConstants.CASSANDRA_DRIVER_CLASS_NAME)) {

							dataSourceType = property.getName();
						}
					}

				}
			}
		}

		return dataSourceType;
	}
}
