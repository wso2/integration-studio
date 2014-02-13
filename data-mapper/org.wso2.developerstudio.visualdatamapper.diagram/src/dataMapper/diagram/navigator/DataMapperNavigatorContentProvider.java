package dataMapper.diagram.navigator;

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

/**
 * @generated
 */
public class DataMapperNavigatorContentProvider implements
		ICommonContentProvider {

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
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
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

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
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
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<dataMapper.diagram.navigator.DataMapperNavigatorItem> result = new ArrayList<dataMapper.diagram.navigator.DataMapperNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(
							topViews,
							dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof dataMapper.diagram.navigator.DataMapperNavigatorGroup) {
			dataMapper.diagram.navigator.DataMapperNavigatorGroup group = (dataMapper.diagram.navigator.DataMapperNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof dataMapper.diagram.navigator.DataMapperNavigatorItem) {
			dataMapper.diagram.navigator.DataMapperNavigatorItem navigatorItem = (dataMapper.diagram.navigator.DataMapperNavigatorItem) parentElement;
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
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {

		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup incominglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_InNode_3009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup incominglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_InNode_3011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup outgoinglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_OutNode_3010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup incominglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_InNode_3014_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup outgoinglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_OutNode_3015_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup outgoinglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_OutNode_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup incominglinks = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_InNode_3016_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup links = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_DataMapperRoot_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			dataMapper.diagram.navigator.DataMapperNavigatorGroup target = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_DataMapperLink_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			dataMapper.diagram.navigator.DataMapperNavigatorGroup source = new dataMapper.diagram.navigator.DataMapperNavigatorGroup(
					dataMapper.diagram.part.Messages.NavigatorGroupName_DataMapperLink_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID: {
			LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem> result = new LinkedList<dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					dataMapper.diagram.part.DataMapperVisualIDRegistry
							.getType(dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
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
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
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
		return dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(dataMapper.diagram.part.DataMapperVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<dataMapper.diagram.navigator.DataMapperNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<dataMapper.diagram.navigator.DataMapperNavigatorItem> result = new ArrayList<dataMapper.diagram.navigator.DataMapperNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new dataMapper.diagram.navigator.DataMapperNavigatorItem(
					nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem) {
			dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem abstractNavigatorItem = (dataMapper.diagram.navigator.DataMapperAbstractNavigatorItem) element;
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
