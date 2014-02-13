package dataMapper.diagram.navigator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class DataMapperNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		dataMapper.diagram.part.DataMapperDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		dataMapper.diagram.part.DataMapperDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorItem
				&& !isOwnView(((dataMapper.diagram.navigator.DataMapperNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorGroup) {
			dataMapper.diagram.navigator.DataMapperNavigatorGroup group = (dataMapper.diagram.navigator.DataMapperNavigatorGroup) element;
			return dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorItem) {
			dataMapper.diagram.navigator.DataMapperNavigatorItem navigatorItem = (dataMapper.diagram.navigator.DataMapperNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", dataMapper.diagram.providers.DataMapperElementTypes.InNode_3009); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", dataMapper.diagram.providers.DataMapperElementTypes.InNode_3011); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3010); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", dataMapper.diagram.providers.DataMapperElementTypes.InNode_3014); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Concat", dataMapper.diagram.providers.DataMapperElementTypes.Concat_3013); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3008); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3015); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Element", dataMapper.diagram.providers.DataMapperElementTypes.Element_3007); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Input", dataMapper.diagram.providers.DataMapperElementTypes.Input_3001); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", dataMapper.diagram.providers.DataMapperElementTypes.OutNode_3012); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Output", dataMapper.diagram.providers.DataMapperElementTypes.Output_3002); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperDiagram", dataMapper.diagram.providers.DataMapperElementTypes.DataMapperDiagram_2001); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", dataMapper.diagram.providers.DataMapperElementTypes.InNode_3016); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperRoot", dataMapper.diagram.providers.DataMapperElementTypes.DataMapperRoot_1000); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Attribute", dataMapper.diagram.providers.DataMapperElementTypes.Attribute_3006); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3005); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperLink", dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002); //$NON-NLS-1$
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = dataMapper.diagram.part.DataMapperDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& dataMapper.diagram.providers.DataMapperElementTypes
						.isKnownElementType(elementType)) {
			image = dataMapper.diagram.providers.DataMapperElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorGroup) {
			dataMapper.diagram.navigator.DataMapperNavigatorGroup group = (dataMapper.diagram.navigator.DataMapperNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof dataMapper.diagram.navigator.DataMapperNavigatorItem) {
			dataMapper.diagram.navigator.DataMapperNavigatorItem navigatorItem = (dataMapper.diagram.navigator.DataMapperNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3009Text(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3011Text(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3010Text(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3014Text(view);
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getConcat_3013Text(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3008Text(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3015Text(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007Text(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_3001Text(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3012Text(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_3002Text(view);
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getDataMapperDiagram_2001Text(view);
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return getInNode_3016Text(view);
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000Text(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3006Text(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3005Text(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4002Text(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getDataMapperRoot_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDataMapperDiagram_2001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3016Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInput_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3011Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3009Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3004Text(View view) {
		dataMapper.TreeNode domainModelElement = (dataMapper.TreeNode) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataMapperLink_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3005Text(View view) {
		dataMapper.TreeNode domainModelElement = (dataMapper.TreeNode) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAttribute_3006Text(View view) {
		dataMapper.Attribute domainModelElement = (dataMapper.Attribute) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutNode_3010Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConcat_3013Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getElement_3007Text(View view) {
		dataMapper.Element domainModelElement = (dataMapper.Element) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutput_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutNode_3012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3008Text(View view) {
		dataMapper.TreeNode domainModelElement = (dataMapper.TreeNode) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			dataMapper.diagram.part.DataMapperDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutNode_3015Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
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
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(dataMapper.diagram.part.DataMapperVisualIDRegistry
						.getModelID(view));
	}

}
