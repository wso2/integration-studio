package org.wso2.developerstudio.datamapper.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
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
import org.wso2.developerstudio.datamapper.Attribute;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Equal;
import org.wso2.developerstudio.datamapper.LowerCase;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.UpperCase;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.AttributeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ContainsEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperLinkEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementNameEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.EqualEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.LowerCaseEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorLeftContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeName2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeName3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeNameEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.UpperCaseEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperParserProvider;

/**
 * @generated
 */
public class DataMapperNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		DataMapperDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		DataMapperDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof DataMapperNavigatorItem
				&& !isOwnView(((DataMapperNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof DataMapperNavigatorGroup) {
			DataMapperNavigatorGroup group = (DataMapperNavigatorGroup) element;
			return DataMapperDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof DataMapperNavigatorItem) {
			DataMapperNavigatorItem navigatorItem = (DataMapperNavigatorItem) element;
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
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case DataMapperRootEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperRoot", DataMapperElementTypes.DataMapperRoot_1000); //$NON-NLS-1$
		case InputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Input", DataMapperElementTypes.Input_2002); //$NON-NLS-1$
		case OutputEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Output", DataMapperElementTypes.Output_2003); //$NON-NLS-1$
		case EqualEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Equal", DataMapperElementTypes.Equal_2005); //$NON-NLS-1$
		case ConcatEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Concat", DataMapperElementTypes.Concat_2006); //$NON-NLS-1$
		case SplitEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Split", DataMapperElementTypes.Split_2007); //$NON-NLS-1$
		case ConstantEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Constant", DataMapperElementTypes.Constant_2008); //$NON-NLS-1$
		case LowerCaseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?LowerCase", DataMapperElementTypes.LowerCase_2009); //$NON-NLS-1$
		case ContainsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Contains", DataMapperElementTypes.Contains_2010); //$NON-NLS-1$
		case UpperCaseEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?UpperCase", DataMapperElementTypes.UpperCase_2011); //$NON-NLS-1$
		case TreeNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", DataMapperElementTypes.TreeNode_3002); //$NON-NLS-1$
		case TreeNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", DataMapperElementTypes.TreeNode_3003); //$NON-NLS-1$
		case AttributeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Attribute", DataMapperElementTypes.Attribute_3004); //$NON-NLS-1$
		case InNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", DataMapperElementTypes.InNode_3005); //$NON-NLS-1$
		case OutNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", DataMapperElementTypes.OutNode_3006); //$NON-NLS-1$
		case ElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Element", DataMapperElementTypes.Element_3007); //$NON-NLS-1$
		case InNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", DataMapperElementTypes.InNode_3008); //$NON-NLS-1$
		case OutNode2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", DataMapperElementTypes.OutNode_3009); //$NON-NLS-1$
		case TreeNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", DataMapperElementTypes.TreeNode_3011); //$NON-NLS-1$
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorBasicContainer", DataMapperElementTypes.OperatorBasicContainer_3012); //$NON-NLS-1$
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorLeftContainer", DataMapperElementTypes.OperatorLeftContainer_3013); //$NON-NLS-1$
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorLeftConnector", DataMapperElementTypes.OperatorLeftConnector_3014); //$NON-NLS-1$
		case InNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", DataMapperElementTypes.InNode_3015); //$NON-NLS-1$
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorRightContainer", DataMapperElementTypes.OperatorRightContainer_3016); //$NON-NLS-1$
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorRightConnector", DataMapperElementTypes.OperatorRightConnector_3017); //$NON-NLS-1$
		case OutNode3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", DataMapperElementTypes.OutNode_3018); //$NON-NLS-1$
		case DataMapperLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperLink", DataMapperElementTypes.DataMapperLink_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = DataMapperDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& DataMapperElementTypes.isKnownElementType(elementType)) {
			image = DataMapperElementTypes.getImage(elementType);
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
		if (element instanceof DataMapperNavigatorGroup) {
			DataMapperNavigatorGroup group = (DataMapperNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof DataMapperNavigatorItem) {
			DataMapperNavigatorItem navigatorItem = (DataMapperNavigatorItem) element;
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
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000Text(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002Text(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003Text(view);
		case EqualEditPart.VISUAL_ID:
			return getEqual_2005Text(view);
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006Text(view);
		case SplitEditPart.VISUAL_ID:
			return getSplit_2007Text(view);
		case ConstantEditPart.VISUAL_ID:
			return getConstant_2008Text(view);
		case LowerCaseEditPart.VISUAL_ID:
			return getLowerCase_2009Text(view);
		case ContainsEditPart.VISUAL_ID:
			return getContains_2010Text(view);
		case UpperCaseEditPart.VISUAL_ID:
			return getUpperCase_2011Text(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002Text(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003Text(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3004Text(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3005Text(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006Text(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007Text(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008Text(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009Text(view);
		case TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011Text(view);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012Text(view);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013Text(view);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014Text(view);
		case InNode3EditPart.VISUAL_ID:
			return getInNode_3015Text(view);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016Text(view);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017Text(view);
		case OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018Text(view);
		case DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001Text(view);
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
	private String getInput_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutput_2003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEqual_2005Text(View view) {
		Equal domainModelElement = (Equal) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConcat_2006Text(View view) {
		Concat domainModelElement = (Concat) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSplit_2007Text(View view) {
		Split domainModelElement = (Split) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstant_2008Text(View view) {
		Constant domainModelElement = (Constant) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLowerCase_2009Text(View view) {
		LowerCase domainModelElement = (LowerCase) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getContains_2010Text(View view) {
		Contains domainModelElement = (Contains) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUpperCase_2011Text(View view) {
		UpperCase domainModelElement = (UpperCase) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataMapperLink_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAttribute_3004Text(View view) {
		Attribute domainModelElement = (Attribute) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3003Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3003,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
					new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInNode_3008Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutNode_3009Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutNode_3006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3002Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3002,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
					new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getElement_3007Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.Element_3007,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(ElementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
					new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInNode_3005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3011Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3011,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
					new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperatorBasicContainer_3012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorLeftContainer_3013Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorLeftConnector_3014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3015Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorRightContainer_3016Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorRightConnector_3017Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutNode_3018Text(View view) {
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
		return DataMapperRootEditPart.MODEL_ID.equals(DataMapperVisualIDRegistry.getModelID(view));
	}

}
