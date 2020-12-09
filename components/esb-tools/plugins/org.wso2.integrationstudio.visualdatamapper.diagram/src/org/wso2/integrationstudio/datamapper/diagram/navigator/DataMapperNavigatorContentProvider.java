package org.wso2.integrationstudio.datamapper.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ANDEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.AbsoluteValueEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.AddEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.AdvancedCustomFunctionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CeliEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CloneEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CompareEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ContainsEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.CustomFunctionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DataMapperLinkEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DivideEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.EndsWithEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.EqualEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.FloorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.GlobalVariableEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.IfElseEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.LowerCaseEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MatchEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MaxEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MinEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.MultiplyEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.NOTEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OREditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorLeftContainerEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.PropertiesEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ReplaceEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.RoundEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SetPrecisionEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.StartsWithEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.StringLengthEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.StringToBooleanEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.StringToNumberEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SubstringEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.SubtractEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ToStringEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TrimEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.UpperCaseEditPart;
import org.wso2.integrationstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.integrationstudio.datamapper.diagram.part.Messages;

/**
 * @generated
 */
public class DataMapperNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public DataMapperNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<DataMapperNavigatorItem> result = new ArrayList<DataMapperNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(
					createNavigatorItems(selectViewsByType(topViews, DataMapperRootEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof DataMapperNavigatorGroup) {
			DataMapperNavigatorGroup group = (DataMapperNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof DataMapperNavigatorItem) {
			DataMapperNavigatorItem navigatorItem = (DataMapperNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {

		case DataMapperRootEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			DataMapperNavigatorGroup links = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_DataMapperRoot_1000_links, "icons/linksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(EqualEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(SubtractEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ConcatEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(AddEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(SplitEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ConstantEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(LowerCaseEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ContainsEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(UpperCaseEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(MultiplyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DivideEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(CeliEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(FloorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(RoundEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(SetPrecisionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(AbsoluteValueEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(StringLengthEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(StartsWithEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(EndsWithEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(SubstringEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(IfElseEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ANDEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OREditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(NOTEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TrimEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ReplaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(MatchEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(MinEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(MaxEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(CustomFunctionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(PropertiesEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(CompareEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(StringToNumberEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(StringToBooleanEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(CloneEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ToStringEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(GlobalVariableEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(AdvancedCustomFunctionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case InputEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TreeNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OutputEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TreeNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EqualEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ConcatEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SplitEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ConstantEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LowerCaseEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ContainsEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case UpperCaseEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AddEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SubtractEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MultiplyEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DivideEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CeliEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FloorEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RoundEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SetPrecisionEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AbsoluteValueEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StringLengthEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StartsWithEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EndsWithEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SubstringEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case IfElseEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ANDEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OREditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case NOTEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TrimEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ReplaceEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MatchEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MinEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MaxEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CustomFunctionEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case PropertiesEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CompareEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StringToNumberEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StringToBooleanEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CloneEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ToStringEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case GlobalVariableEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AdvancedCustomFunctionEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorBasicContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TreeNodeEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TreeNode2EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ElementEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case InNode2EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup incominglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_InNode_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OutNode2EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup outgoinglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_OutNode_3009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TreeNode3EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OperatorBasicContainerEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorLeftContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorRightContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OperatorLeftContainerEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorLeftConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OperatorLeftConnectorEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case InNode3EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup incominglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_InNode_3015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OperatorRightContainerEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OperatorRightConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OperatorRightConnectorEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OutNode3EditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup outgoinglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_OutNode_3018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case OutNodeEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup outgoinglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_OutNode_3019_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InNodeEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			DataMapperNavigatorGroup incominglinks = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_InNode_3020_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DataMapperLinkEditPart.VISUAL_ID: {
			LinkedList<DataMapperAbstractNavigatorItem> result = new LinkedList<DataMapperAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			DataMapperNavigatorGroup target = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_DataMapperLink_4001_target, "icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			DataMapperNavigatorGroup source = new DataMapperNavigatorGroup(
					Messages.NavigatorGroupName_DataMapperLink_4001_source, "icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNode2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNodeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(InNode3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNode2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNodeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					DataMapperVisualIDRegistry.getType(OutNode3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return DataMapperRootEditPart.MODEL_ID.equals(DataMapperVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<DataMapperNavigatorItem> createNavigatorItems(Collection<View> views, Object parent,
			boolean isLeafs) {
		ArrayList<DataMapperNavigatorItem> result = new ArrayList<DataMapperNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new DataMapperNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof DataMapperAbstractNavigatorItem) {
			DataMapperAbstractNavigatorItem abstractNavigatorItem = (DataMapperAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
