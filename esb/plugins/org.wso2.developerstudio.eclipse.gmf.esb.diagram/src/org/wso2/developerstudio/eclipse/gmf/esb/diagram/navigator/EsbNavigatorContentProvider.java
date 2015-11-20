package org.wso2.developerstudio.eclipse.gmf.esb.diagram.navigator;

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
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;

/**
 * @generated
 */
public class EsbNavigatorContentProvider implements ICommonContentProvider {

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
	public EsbNavigatorContentProvider() {
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
			ArrayList<EsbNavigatorItem> result = new ArrayList<EsbNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, EsbDiagramEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof EsbNavigatorGroup) {
			EsbNavigatorGroup group = (EsbNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof EsbNavigatorItem) {
			EsbNavigatorItem navigatorItem = (EsbNavigatorItem) parentElement;
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
		switch (EsbVisualIDRegistry.getVisualID(view)) {

		case EsbDiagramEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			EsbNavigatorGroup links = new EsbNavigatorGroup(Messages.NavigatorGroupName_EsbDiagram_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case EsbServerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ProxyServiceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MessageMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequencesEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LocalEntryEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(TemplateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(TaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SynapseAPIEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ComplexEndpointsEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(MessageStoreEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(MessageProcessorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbServerContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(InboundEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ProxyServiceEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyFaultInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyInSequenceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ProxyOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ProxyOutputConnector_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProxyInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ProxyInputConnector_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DropMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DropMediatorInputConnector_3008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FilterMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FilterMediatorInputConnector_3010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FilterMediatorPassOutputConnector_3011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FilterMediatorFailOutputConnector_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MergeNodeEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeFirstInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeSecondInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_MergeNodeFirstInputConnector_3014_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_MergeNodeSecondInputConnector_3015_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case MergeNodeOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_MergeNodeOutputConnector_3016_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LogMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LogMediatorInputConnector_3018_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LogMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LogMediatorOutputConnector_3019_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DefaultEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DefaultEndPointInputConnector_3021_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DefaultEndPointOutputConnector_3022_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AddressEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressEndPointInputConnector_3030_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AddressEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressEndPointOutputConnector_3031_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PropertyMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PropertyMediatorInputConnector_3033_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PropertyMediatorOutputConnector_3034_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EnrichMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EnrichMediatorInputConnector_3036_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EnrichMediatorOutputConnector_3037_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case XSLTMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_XSLTMediatorInputConnector_3039_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_XSLTMediatorOutputConnector_3040_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SwitchMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SwitchMediatorInputConnector_3042_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SwitchCaseBranchOutputConnector_3043_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SwitchDefaultBranchOutputConnector_3044_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MessageMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MessageInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MessageOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MessageInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_MessageInputConnector_3046_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case MessageOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_MessageOutputConnector_3047_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SequenceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SequenceInputConnector_3049_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SequenceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SequenceOutputConnector_3050_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EventMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EventMediatorInputConnector_3052_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EventMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EventMediatorOutputConnector_3053_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorInputConnector_3055_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorOutputConnector_3056_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ClassMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ClassMediatorInputConnector_3058_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ClassMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ClassMediatorOutputConnector_3059_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SpringMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SpringMediatorInputConnector_3061_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SpringMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SpringMediatorOutputConnector_3062_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ScriptMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ScriptMediatorInputConnector_3064_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ScriptMediatorOutputConnector_3065_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FaultMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FaultMediatorInputConnector_3067_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FaultMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FaultMediatorOutputConnector_3068_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case XQueryMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_XQueryMediatorInputConnector_3070_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_XQueryMediatorOutputConnector_3071_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CommandMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CommandMediatorInputConnector_3073_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CommandMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CommandMediatorOutputConnector_3074_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DBLookupMediatorInputConnector_3076_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DBLookupMediatorOutputConnector_3077_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DBReportMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DBReportMediatorInputConnector_3079_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DBReportMediatorOutputConnector_3080_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SmooksMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SmooksMediatorInputConnector_3082_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SmooksMediatorOutputConnector_3083_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SendMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SendMediatorInputConnector_3085_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SendMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SendMediatorOutputConnector_3086_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FailoverEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointInputConnector_3088_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointOutputConnector_3090_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case WSDLEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_WSDLEndPointInputConnector_3092_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_WSDLEndPointOutputConnector_3093_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointInputConnector_3095_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointOutputConnector_3096_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointWestOutputConnector_3097_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointWestOutputConnector_3098_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case HeaderMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HeaderMediatorInputConnector_3100_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HeaderMediatorOutputConnector_3101_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CloneMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloneMediatorInputConnector_3103_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CloneMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloneMediatorOutputConnector_3104_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CacheMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CacheMediatorInputConnector_3106_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CacheMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CacheMediatorOutputConnector_3107_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case IterateMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_IterateMediatorInputConnector_3109_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case IterateMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_IterateMediatorOutputConnector_3110_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AggregateMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AggregateMediatorInputConnector_3112_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AggregateMediatorOutputConnector_3113_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CalloutMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CalloutMediatorInputConnector_3115_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CalloutMediatorOutputConnector_3116_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TransactionMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TransactionMediatorInputConnector_3118_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TransactionMediatorOutputConnector_3119_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ThrottleMediatorInputConnector_3121_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ThrottleMediatorOutputConnector_3122_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RMSequenceMediatorInputConnector_3124_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RMSequenceMediatorOutputConnector_3125_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RuleMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RuleMediatorInputConnector_3127_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RuleMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RuleMediatorOutputConnector_3128_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case OAuthMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_OAuthMediatorInputConnector_3130_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_OAuthMediatorOutputConnector_3131_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AggregateMediatorOnCompleteOutputConnector_3132_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloneMediatorTargetOutputConnector_3133_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProxyServiceContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceFaultContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ProxyServiceFaultContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow6EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ProxyFaultInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ProxyFaultInputConnector_3489_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DropMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DropMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case PropertyMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PropertyMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PropertyMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ThrottleMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FilterMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorPassOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorFailOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LogMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LogMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LogMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EnrichMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnrichMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnrichMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case XSLTMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XSLTMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XSLTMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SwitchMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchMediatorContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SwitchMediatorOutputConnector_3499_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SwitchMediatorContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchCaseParentContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchDefaultParentContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SequenceEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequenceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequenceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EventMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EventMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EventMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EntitlementMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ClassMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ClassMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ClassMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SpringMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SpringMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SpringMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ScriptMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ScriptMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ScriptMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FaultMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FaultMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FaultMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case XQueryMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XQueryMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XQueryMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CommandMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CommandMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CommandMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DBLookupMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBLookupMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBLookupMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DBReportMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBReportMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBReportMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SmooksMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SmooksMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SmooksMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SendMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow19EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case HeaderMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HeaderMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HeaderMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CloneMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CacheMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow13EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case IterateMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow12EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CalloutMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CalloutMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CalloutMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TransactionMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TransactionMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TransactionMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RMSequenceMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RMSequenceMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RuleMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow17EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case OAuthMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(OAuthMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(OAuthMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AggregateMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow3EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow4EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow6EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FilterContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterPassContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterFailContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FilterMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FilterMediatorOutputConnector_3534_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FilterPassContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow7EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow7EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FilterFailContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow8EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow8EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SendMediatorEndpointOutputConnector_3539_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ThrottleMediatorOnAcceptOutputConnector_3581_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ThrottleMediatorOnRejectOutputConnector_3582_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ThrottleContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleOnAcceptContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleOnRejectContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ThrottleOnAcceptContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow9EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow9EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ThrottleOnRejectContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow10EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow10EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StoreMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(StoreMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(StoreMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case StoreMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_StoreMediatorInputConnector_3589_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StoreMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_StoreMediatorOutputConnector_3590_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BuilderMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BuilderMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BuilderMediatorOutputConectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case BuilderMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BuilderMediatorInputConnector_3592_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BuilderMediatorOutputConectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BuilderMediatorOutputConector_3593_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CallTemplateMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallTemplateMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CallTemplateMediatorInputConnector_3595_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CallTemplateMediatorOutputConnector_3596_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PayloadFactoryMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PayloadFactoryMediatorInputConnector_3598_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PayloadFactoryMediatorOutputConnector_3599_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EnqueueMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnqueueMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnqueueMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EnqueueMediatorInputConnector_3601_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EnqueueMediatorOutputConnector_3602_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CloneMediatorContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneTargetContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CloneTargetContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow11EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow11EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_IterateMediatorTargetOutputConnector_3606_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow12EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlowEditPart.VISUAL_ID: {
			return mediatorFlowEditPart(view, parentElement);
		}

		case DefaultEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AddressEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FailoverEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case WSDLEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LoadBalanceEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SequencesEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow5EditPart.VISUAL_ID: {
			return mediatorFlow5EditPart(view, parentElement);
		}

		case SequencesInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SequencesInputConnector_3616_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SequencesOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_SequencesOutputConnector_3617_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CacheMediatorOnHitOutputConnector_3618_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow13EditPart.VISUAL_ID: {
			return mediatorFlow13EditPart(view, parentElement);
		}

		case URLRewriteMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(URLRewriteMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_URLRewriteMediatorInputConnector_3621_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_URLRewriteMediatorOutputConnector_3622_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ValidateMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow14EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ValidateMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ValidateMediatorInputConnector_3624_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ValidateMediatorOutputConnector_3625_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ValidateMediatorOnFailOutputConnector_3626_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow14EditPart.VISUAL_ID: {
			return mediatorFlow14EditPart(view, parentElement);
		}

		case RouterMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RouterMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RouterMediatorInputConnector_3629_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RouterMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RouterMediatorOutputConnector_3630_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RouterMediatorTargetOutputConnector_3631_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RouterMediatorContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterTargetContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RouterTargetContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow15EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow15EditPart.VISUAL_ID: {
			return mediatorFlow15EditPart(view, parentElement);
		}

		case ConditionalRouterMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow16EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ConditionalRouterMediatorInputConnector_3636_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ConditionalRouterMediatorOutputConnector_3637_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ConditionalRouterMediatorAdditionalOutputConnector_3638_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow16EditPart.VISUAL_ID: {
			return mediatorFlow16EditPart(view, parentElement);
		}

		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RuleMediatorChildMediatorsOutputConnector_3640_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow17EditPart.VISUAL_ID: {
			return mediatorFlow17EditPart(view, parentElement);
		}

		case EndpointDiagramEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DefaultEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DefaultEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DefaultEndPointInputConnector_3644_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DefaultEndPointOutputConnector_3645_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AddressEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AddressEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressEndPointInputConnector_3647_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AddressEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressEndPointOutputConnector_3648_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FailoverEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow27EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FailoverEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointInputConnector_3650_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointOutputConnector_3651_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FailoverEndPointWestOutputConnector_3652_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case WSDLEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case WSDLEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_WSDLEndPointInputConnector_3654_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_WSDLEndPointOutputConnector_3655_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow29EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointInputConnector_3657_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointOutputConnector_3658_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoadBalanceEndPointWestOutputConnector_3659_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NamedEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(NamedEndpointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(NamedEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case NamedEndpointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_NamedEndpointInputConnector_3661_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case NamedEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_NamedEndpointOutputConnector_3662_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TemplateEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateTemplateCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(Sequences2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateTemplateCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(EndpointDiagram2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case Sequences2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EndpointDiagram2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(DefaultEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(AddressEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(FailoverEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(RecipientListEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(WSDLEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(LoadBalanceEndPoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(HTTPEndpoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(TemplateEndpoint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SynapseAPIEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SynapseAPIAPICompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EsbVisualIDRegistry.getType(APIResourceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case APIResourceEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceFaultInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceContainer2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceInSequenceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case APIResourceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceInputConnector_3670_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case APIResourceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceOutputConnector_3671_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case APIResourceFaultInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceFaultInputConnector_3672_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ProxyServiceContainer2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyServiceFaultContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case APIResourceEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceEndpointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceEndpointInputConnector_3675_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceEndpointOutputConnector_3676_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ComplexEndpointsEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow18EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ComplexEndpointsOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow18EditPart.VISUAL_ID: {
			return mediatorFlow18EditPart(view, parentElement);
		}

		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ComplexEndpointsOutputConnector_3679_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BAMMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BAMMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BAMMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case BAMMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BAMMediatorInputConnector_3681_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BAMMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BAMMediatorOutputConnector_3682_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BeanMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BeanMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BeanMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case BeanMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BeanMediatorInputConnector_3684_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case BeanMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_BeanMediatorOutputConnector_3685_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EJBMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EJBMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EJBMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EJBMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EJBMediatorInputConnector_3687_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EJBMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EJBMediatorOutputConnector_3688_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AddressingEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressingEndpointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressingEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case AddressingEndpointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressingEndpointInputConnector_3690_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_AddressingEndpointOutputConnector_3691_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointInputConnector_3693_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointOutputConnector_3694_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointWestOutputConnector_3695_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow28EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointInputConnector_3697_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointOutputConnector_3698_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RecipientListEndPointWestOutputConnector_3699_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case HTTPEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case HTTPEndPointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HTTPEndPointInputConnector_3710_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HTTPEndPointOutputConnector_3711_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case HTTPEndpoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case HTTPEndPointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HTTPEndPointInputConnector_3713_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_HTTPEndPointOutputConnector_3714_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TemplateEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TemplateEndpointInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TemplateEndpointInputConnector_3717_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TemplateEndpointOutputConnector_3718_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CloudConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CloudConnectorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloudConnectorInputConnector_3720_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CloudConnectorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloudConnectorOutputConnector_3721_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CloudConnectorOperationEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOperationInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloudConnectorOperationInputConnector_3723_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CloudConnectorOperationOutputConnector_3724_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TemplateEndpoint2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointInputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointOutputConnector2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case TemplateEndpointInputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TemplateEndpointInputConnector_3726_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_TemplateEndpointOutputConnector_3727_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow19EditPart.VISUAL_ID: {
			return mediatorFlow19EditPart(view, parentElement);
		}

		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ProxyOutSequenceOutputConnector_3729_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceOutSequenceOutputConnector_3730_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ProxyInSequenceInputConnector_3731_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SwitchCaseParentContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchCaseContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SwitchCaseContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SwitchDefaultParentContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchDefaultContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case SwitchDefaultContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LoopBackMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoopBackMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoopBackMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoopBackMediatorInputConnector_3737_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_LoopBackMediatorOutputConnector_3738_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RespondMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RespondMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RespondMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case RespondMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RespondMediatorInputConnector_3740_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case RespondMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_RespondMediatorOutputConnector_3741_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CallMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow20EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case CallMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CallMediatorInputConnector_3743_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CallMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CallMediatorOutputConnector_3744_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_CallMediatorEndpointOutputConnector_3745_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow20EditPart.VISUAL_ID: {
			return mediatorFlow20EditPart(view, parentElement);
		}

		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_APIResourceInSequenceInputConnector_3747_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorOnRejectOutputConnector_3748_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorOnAcceptOutputConnector_3749_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorAdviceOutputConnector_3750_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_EntitlementMediatorObligationsOutputConnector_3751_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntitlementContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementOnRejectContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementOnAcceptContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementAdviceContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementObligationsContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case EntitlementOnRejectContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow21EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow21EditPart.VISUAL_ID: {
			return mediatorFlow21EditPart(view, parentElement);
		}

		case EntitlementOnAcceptContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow22EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow22EditPart.VISUAL_ID: {
			return mediatorFlow22EditPart(view, parentElement);
		}

		case EntitlementAdviceContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow23EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow23EditPart.VISUAL_ID: {
			return mediatorFlow23EditPart(view, parentElement);
		}

		case EntitlementObligationsContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow24EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow24EditPart.VISUAL_ID: {
			return mediatorFlow24EditPart(view, parentElement);
		}

		case DataMapperMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DataMapperMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DataMapperMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DataMapperMediatorInputConnector_3762_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_DataMapperMediatorOutputConnector_3763_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FastXSLTMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FastXSLTMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FastXSLTMediatorInputConnector_3765_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_FastXSLTMediatorOutputConnector_3766_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InboundEndpointEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_InboundEndpointSequenceInputConnector_3768_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_InboundEndpointSequenceOutputConnector_3769_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_InboundEndpointOnErrorSequenceInputConnector_3770_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_InboundEndpointOnErrorSequenceOutputConnector_3771_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InboundEndpointContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointSequenceContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case InboundEndpointSequenceContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow25EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow25EditPart.VISUAL_ID: {
			return mediatorFlow25EditPart(view, parentElement);
		}

		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow26EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case MediatorFlow26EditPart.VISUAL_ID: {
			return mediatorFlow26EditPart(view, parentElement);
		}

		case MediatorFlow27EditPart.VISUAL_ID: {
			return mediatorFlow27EditPart(view, parentElement);
		}

		case MediatorFlow28EditPart.VISUAL_ID: {
			return mediatorFlow28EditPart(view, parentElement);
		}

		case MediatorFlow29EditPart.VISUAL_ID: {
			return mediatorFlow29EditPart(view, parentElement);
		}

		case ForEachMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MediatorFlow30EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ForEachMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ForEachMediatorInputConnector_3781_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ForEachMediatorOutputConnector_3782_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_ForEachMediatorTargetOutputConnector_3783_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MediatorFlow30EditPart.VISUAL_ID: {
			return mediatorFlow30EditPart(view, parentElement);
		}

		case PublishEventMediatorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PublishEventMediatorInputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PublishEventMediatorOutputConnectorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup incominglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PublishEventMediatorInputConnector_3786_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Node sv = (Node) view;
			EsbNavigatorGroup outgoinglinks = new EsbNavigatorGroup(
					Messages.NavigatorGroupName_PublishEventMediatorOutputConnector_3787_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EsbLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EsbLinkEditPart.VISUAL_ID: {
			LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			EsbNavigatorGroup target = new EsbNavigatorGroup(Messages.NavigatorGroupName_EsbLink_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EsbNavigatorGroup source = new EsbNavigatorGroup(Messages.NavigatorGroupName_EsbLink_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyFaultInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DropMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PropertyMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LogMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnrichMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XSLTMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequenceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EventMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ClassMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SpringMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ScriptMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FaultMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XQueryMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CommandMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBLookupMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBReportMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SmooksMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HeaderMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CalloutMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TransactionMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RMSequenceMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(OAuthMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(StoreMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BuilderMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallTemplateMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnqueueMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(URLRewriteMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BAMMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BeanMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EJBMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(NamedEndpointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceEndpointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressingEndpointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOperationInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoopBackMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RespondMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DataMapperMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FastXSLTMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PublishEventMediatorInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyInSequenceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MessageInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeFirstInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeSecondInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointInputConnector2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceFaultInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceInSequenceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PropertyMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorPassOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FilterMediatorFailOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LogMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnrichMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XSLTMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequenceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EventMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ClassMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SpringMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ScriptMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FaultMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(XQueryMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CommandMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBLookupMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DBReportMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SmooksMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HeaderMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CalloutMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TransactionMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(OAuthMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(StoreMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BuilderMediatorOutputConectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EnqueueMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BAMMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(BeanMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(EJBMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(NamedEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressingEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoopBackMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RespondMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DataMapperMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(PublishEventMediatorOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MessageOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(MergeNodeOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(SequencesOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(DefaultEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(AddressEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(WSDLEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(HTTPEndPointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(TemplateEndpointOutputConnector2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(ComplexEndpointsOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EsbVisualIDRegistry.getType(InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID));
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

	private Object[] mediatorFlowEditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow5EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow13EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow14EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow15EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow16EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow17EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow18EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow19EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow20EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow21EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow22EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow23EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow24EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow25EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow26EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow27EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow28EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow29EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
	}

	private Object[] mediatorFlow30EditPart(View view, Object parentElement) {
		LinkedList<EsbAbstractNavigatorItem> result = new LinkedList<EsbAbstractNavigatorItem>();
		Node sv = (Node) view;
		Collection<View> connectedViews;
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DropMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PropertyMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ThrottleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FilterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LogMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnrichMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SwitchMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, EsbVisualIDRegistry.getType(SequenceEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EntitlementMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ClassMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SpringMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ScriptMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FaultMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(XQueryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CommandMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBLookupMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DBReportMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SmooksMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(SendMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HeaderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloneMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CacheMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(IterateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CalloutMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TransactionMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RMSequenceMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RuleMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(OAuthMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AggregateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(StoreMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BuilderMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallTemplateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EnqueueMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(URLRewriteMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ValidateMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BAMMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(BeanMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(EJBMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DefaultEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FailoverEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RecipientListEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(WSDLEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(NamedEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(APIResourceEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(AddressingEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(HTTPEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(TemplateEndpointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CloudConnectorOperationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(LoopBackMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(RespondMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(CallMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(DataMapperMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(FastXSLTMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(ForEachMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(sv),
				EsbVisualIDRegistry.getType(MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews,
				EsbVisualIDRegistry.getType(PublishEventMediatorEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		return result.toArray();
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
		return EsbDiagramEditPart.MODEL_ID.equals(EsbVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<EsbNavigatorItem> createNavigatorItems(Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<EsbNavigatorItem> result = new ArrayList<EsbNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new EsbNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof EsbAbstractNavigatorItem) {
			EsbAbstractNavigatorItem abstractNavigatorItem = (EsbAbstractNavigatorItem) element;
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