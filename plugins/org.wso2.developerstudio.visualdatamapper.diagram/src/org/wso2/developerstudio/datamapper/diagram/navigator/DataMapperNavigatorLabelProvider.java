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
import org.wso2.developerstudio.datamapper.AbsoluteValue;
import org.wso2.developerstudio.datamapper.Add;
import org.wso2.developerstudio.datamapper.AdvancedCustomFunction;
import org.wso2.developerstudio.datamapper.Celi;
import org.wso2.developerstudio.datamapper.Clone;
import org.wso2.developerstudio.datamapper.Compare;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.CustomFunction;
import org.wso2.developerstudio.datamapper.Divide;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.EndsWith;
import org.wso2.developerstudio.datamapper.Equal;
import org.wso2.developerstudio.datamapper.Floor;
import org.wso2.developerstudio.datamapper.GlobalVariable;
import org.wso2.developerstudio.datamapper.IfElse;
import org.wso2.developerstudio.datamapper.LowerCase;
import org.wso2.developerstudio.datamapper.Match;
import org.wso2.developerstudio.datamapper.Max;
import org.wso2.developerstudio.datamapper.Min;
import org.wso2.developerstudio.datamapper.Multiply;
import org.wso2.developerstudio.datamapper.Properties;
import org.wso2.developerstudio.datamapper.Replace;
import org.wso2.developerstudio.datamapper.Round;
import org.wso2.developerstudio.datamapper.SetPrecision;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.StartsWith;
import org.wso2.developerstudio.datamapper.StringLength;
import org.wso2.developerstudio.datamapper.StringToBoolean;
import org.wso2.developerstudio.datamapper.StringToNumber;
import org.wso2.developerstudio.datamapper.Substring;
import org.wso2.developerstudio.datamapper.Subtract;
import org.wso2.developerstudio.datamapper.ToString;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.Trim;
import org.wso2.developerstudio.datamapper.UpperCase;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ANDEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.AbsoluteValueEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.AddEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.AdvancedCustomFunctionEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CeliEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CloneEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CompareEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConcatEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ConstantEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ContainsEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.CustomFunctionEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperLinkEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.DivideEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementNameEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.EndsWithEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.EqualEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.FloorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.GlobalVariableEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.IfElseEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.LowerCaseEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.MatchEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.MaxEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.MinEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.MultiplyEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.NOTEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OREditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorBasicContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorLeftContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRightContainerEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.PropertiesEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ReplaceEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.RoundEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SetPrecisionEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.StartsWithEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.StringLengthEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.StringToBooleanEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.StringToNumberEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SubstringEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SubtractEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ToStringEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeName2EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeName3EditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TreeNodeNameEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TrimEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.UpperCaseEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperParserProvider;

/**
 * @generated
 */
public class DataMapperNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		DataMapperDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		DataMapperDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof DataMapperNavigatorItem && !isOwnView(((DataMapperNavigatorItem) element).getView())) {
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
			return getImage("Navigator?Diagram?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperRoot", //$NON-NLS-1$
					DataMapperElementTypes.DataMapperRoot_1000);
		case InputEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Input", //$NON-NLS-1$
					DataMapperElementTypes.Input_2002);
		case OutputEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Output", //$NON-NLS-1$
					DataMapperElementTypes.Output_2003);
		case EqualEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Equal", //$NON-NLS-1$
					DataMapperElementTypes.Equal_2005);
		case ConcatEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Concat", //$NON-NLS-1$
					DataMapperElementTypes.Concat_2006);
		case SplitEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Split", //$NON-NLS-1$
					DataMapperElementTypes.Split_2007);
		case ConstantEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Constant", //$NON-NLS-1$
					DataMapperElementTypes.Constant_2008);
		case LowerCaseEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?LowerCase", //$NON-NLS-1$
					DataMapperElementTypes.LowerCase_2009);
		case ContainsEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Contains", //$NON-NLS-1$
					DataMapperElementTypes.Contains_2010);
		case UpperCaseEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?UpperCase", //$NON-NLS-1$
					DataMapperElementTypes.UpperCase_2011);
		case AddEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Add", //$NON-NLS-1$
					DataMapperElementTypes.Add_2012);
		case SubtractEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Subtract", //$NON-NLS-1$
					DataMapperElementTypes.Subtract_2013);
		case MultiplyEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Multiply", //$NON-NLS-1$
					DataMapperElementTypes.Multiply_2014);
		case DivideEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Divide", //$NON-NLS-1$
					DataMapperElementTypes.Divide_2015);
		case CeliEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Celi", //$NON-NLS-1$
					DataMapperElementTypes.Celi_2016);
		case FloorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Floor", //$NON-NLS-1$
					DataMapperElementTypes.Floor_2017);
		case RoundEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Round", //$NON-NLS-1$
					DataMapperElementTypes.Round_2018);
		case SetPrecisionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?SetPrecision", //$NON-NLS-1$
					DataMapperElementTypes.SetPrecision_2019);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?AbsoluteValue", //$NON-NLS-1$
					DataMapperElementTypes.AbsoluteValue_2020);
		case StringLengthEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?StringLength", //$NON-NLS-1$
					DataMapperElementTypes.StringLength_2021);
		case StartsWithEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?StartsWith", //$NON-NLS-1$
					DataMapperElementTypes.StartsWith_2022);
		case EndsWithEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?EndsWith", //$NON-NLS-1$
					DataMapperElementTypes.EndsWith_2023);
		case SubstringEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Substring", //$NON-NLS-1$
					DataMapperElementTypes.Substring_2024);
		case IfElseEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?IfElse", //$NON-NLS-1$
					DataMapperElementTypes.IfElse_2025);
		case ANDEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?AND", //$NON-NLS-1$
					DataMapperElementTypes.AND_2026);
		case OREditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OR", //$NON-NLS-1$
					DataMapperElementTypes.OR_2027);
		case NOTEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?NOT", //$NON-NLS-1$
					DataMapperElementTypes.NOT_2028);
		case TrimEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Trim", //$NON-NLS-1$
					DataMapperElementTypes.Trim_2029);
		case ReplaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Replace", //$NON-NLS-1$
					DataMapperElementTypes.Replace_2030);
		case MatchEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Match", //$NON-NLS-1$
					DataMapperElementTypes.Match_2031);
		case MinEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Min", //$NON-NLS-1$
					DataMapperElementTypes.Min_2032);
		case MaxEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Max", //$NON-NLS-1$
					DataMapperElementTypes.Max_2033);
		case CustomFunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?CustomFunction", //$NON-NLS-1$
					DataMapperElementTypes.CustomFunction_2034);
		case PropertiesEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Properties", //$NON-NLS-1$
					DataMapperElementTypes.Properties_2035);
		case CompareEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Compare", //$NON-NLS-1$
					DataMapperElementTypes.Compare_2036);
		case StringToNumberEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?StringToNumber", //$NON-NLS-1$
					DataMapperElementTypes.StringToNumber_2037);
		case StringToBooleanEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?StringToBoolean", //$NON-NLS-1$
					DataMapperElementTypes.StringToBoolean_2038);
		case CloneEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Clone", //$NON-NLS-1$
					DataMapperElementTypes.Clone_2039);
		case ToStringEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?ToString", //$NON-NLS-1$
					DataMapperElementTypes.ToString_2040);
		case GlobalVariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?GlobalVariable", //$NON-NLS-1$
					DataMapperElementTypes.GlobalVariable_2041);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?AdvancedCustomFunction", //$NON-NLS-1$
					DataMapperElementTypes.AdvancedCustomFunction_2042);
		case TreeNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", //$NON-NLS-1$
					DataMapperElementTypes.TreeNode_3002);
		case TreeNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", //$NON-NLS-1$
					DataMapperElementTypes.TreeNode_3003);
		case ElementEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?Element", //$NON-NLS-1$
					DataMapperElementTypes.Element_3007);
		case InNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", //$NON-NLS-1$
					DataMapperElementTypes.InNode_3008);
		case OutNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", //$NON-NLS-1$
					DataMapperElementTypes.OutNode_3009);
		case TreeNode3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?TreeNode", //$NON-NLS-1$
					DataMapperElementTypes.TreeNode_3011);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorBasicContainer", //$NON-NLS-1$
					DataMapperElementTypes.OperatorBasicContainer_3012);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorLeftContainer", //$NON-NLS-1$
					DataMapperElementTypes.OperatorLeftContainer_3013);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorLeftConnector", //$NON-NLS-1$
					DataMapperElementTypes.OperatorLeftConnector_3014);
		case InNode3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", //$NON-NLS-1$
					DataMapperElementTypes.InNode_3015);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorRightContainer", //$NON-NLS-1$
					DataMapperElementTypes.OperatorRightContainer_3016);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OperatorRightConnector", //$NON-NLS-1$
					DataMapperElementTypes.OperatorRightConnector_3017);
		case OutNode3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", //$NON-NLS-1$
					DataMapperElementTypes.OutNode_3018);
		case OutNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?OutNode", //$NON-NLS-1$
					DataMapperElementTypes.OutNode_3019);
		case InNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?InNode", //$NON-NLS-1$
					DataMapperElementTypes.InNode_3020);
		case DataMapperLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http:///org/wso2/developerstudio/eclipse/gmf/datamapper?DataMapperLink", //$NON-NLS-1$
					DataMapperElementTypes.DataMapperLink_4001);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = DataMapperDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && DataMapperElementTypes.isKnownElementType(elementType)) {
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
		case AddEditPart.VISUAL_ID:
			return getAdd_2012Text(view);
		case SubtractEditPart.VISUAL_ID:
			return getSubtract_2013Text(view);
		case MultiplyEditPart.VISUAL_ID:
			return getMultiply_2014Text(view);
		case DivideEditPart.VISUAL_ID:
			return getDivide_2015Text(view);
		case CeliEditPart.VISUAL_ID:
			return getCeli_2016Text(view);
		case FloorEditPart.VISUAL_ID:
			return getFloor_2017Text(view);
		case RoundEditPart.VISUAL_ID:
			return getRound_2018Text(view);
		case SetPrecisionEditPart.VISUAL_ID:
			return getSetPrecision_2019Text(view);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getAbsoluteValue_2020Text(view);
		case StringLengthEditPart.VISUAL_ID:
			return getStringLength_2021Text(view);
		case StartsWithEditPart.VISUAL_ID:
			return getStartsWith_2022Text(view);
		case EndsWithEditPart.VISUAL_ID:
			return getEndsWith_2023Text(view);
		case SubstringEditPart.VISUAL_ID:
			return getSubstring_2024Text(view);
		case IfElseEditPart.VISUAL_ID:
			return getIfElse_2025Text(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2026Text(view);
		case OREditPart.VISUAL_ID:
			return getOR_2027Text(view);
		case NOTEditPart.VISUAL_ID:
			return getNOT_2028Text(view);
		case TrimEditPart.VISUAL_ID:
			return getTrim_2029Text(view);
		case ReplaceEditPart.VISUAL_ID:
			return getReplace_2030Text(view);
		case MatchEditPart.VISUAL_ID:
			return getMatch_2031Text(view);
		case MinEditPart.VISUAL_ID:
			return getMin_2032Text(view);
		case MaxEditPart.VISUAL_ID:
			return getMax_2033Text(view);
		case CustomFunctionEditPart.VISUAL_ID:
			return getCustomFunction_2034Text(view);
		case PropertiesEditPart.VISUAL_ID:
			return getProperties_2035Text(view);
		case CompareEditPart.VISUAL_ID:
			return getCompare_2036Text(view);
		case StringToNumberEditPart.VISUAL_ID:
			return getStringToNumber_2037Text(view);
		case StringToBooleanEditPart.VISUAL_ID:
			return getStringToBoolean_2038Text(view);
		case CloneEditPart.VISUAL_ID:
			return getClone_2039Text(view);
		case ToStringEditPart.VISUAL_ID:
			return getToString_2040Text(view);
		case GlobalVariableEditPart.VISUAL_ID:
			return getGlobalVariable_2041Text(view);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getAdvancedCustomFunction_2042Text(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002Text(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003Text(view);
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
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3019Text(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3020Text(view);
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2005); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2006); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2007); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2008); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2009); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2010); //$NON-NLS-1$
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
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAdd_2012Text(View view) {
		Add domainModelElement = (Add) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubtract_2013Text(View view) {
		Subtract domainModelElement = (Subtract) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMultiply_2014Text(View view) {
		Multiply domainModelElement = (Multiply) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDivide_2015Text(View view) {
		Divide domainModelElement = (Divide) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCeli_2016Text(View view) {
		Celi domainModelElement = (Celi) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFloor_2017Text(View view) {
		Floor domainModelElement = (Floor) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRound_2018Text(View view) {
		Round domainModelElement = (Round) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSetPrecision_2019Text(View view) {
		SetPrecision domainModelElement = (SetPrecision) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAbsoluteValue_2020Text(View view) {
		AbsoluteValue domainModelElement = (AbsoluteValue) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getStringLength_2021Text(View view) {
		StringLength domainModelElement = (StringLength) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getStartsWith_2022Text(View view) {
		StartsWith domainModelElement = (StartsWith) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEndsWith_2023Text(View view) {
		EndsWith domainModelElement = (EndsWith) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubstring_2024Text(View view) {
		Substring domainModelElement = (Substring) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getIfElse_2025Text(View view) {
		IfElse domainModelElement = (IfElse) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAND_2026Text(View view) {
		org.wso2.developerstudio.datamapper.AND domainModelElement = (org.wso2.developerstudio.datamapper.AND) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getOR_2027Text(View view) {
		org.wso2.developerstudio.datamapper.OR domainModelElement = (org.wso2.developerstudio.datamapper.OR) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getNOT_2028Text(View view) {
		org.wso2.developerstudio.datamapper.NOT domainModelElement = (org.wso2.developerstudio.datamapper.NOT) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTrim_2029Text(View view) {
		Trim domainModelElement = (Trim) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getReplace_2030Text(View view) {
		Replace domainModelElement = (Replace) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMatch_2031Text(View view) {
		Match domainModelElement = (Match) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMin_2032Text(View view) {
		Min domainModelElement = (Min) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMax_2033Text(View view) {
		Max domainModelElement = (Max) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCustomFunction_2034Text(View view) {
		CustomFunction domainModelElement = (CustomFunction) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getFunctionName();
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getProperties_2035Text(View view) {
		Properties domainModelElement = (Properties) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCompare_2036Text(View view) {
		Compare domainModelElement = (Compare) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getStringToNumber_2037Text(View view) {
		StringToNumber domainModelElement = (StringToNumber) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getStringToBoolean_2038Text(View view) {
		StringToBoolean domainModelElement = (StringToBoolean) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getClone_2039Text(View view) {
		Clone domainModelElement = (Clone) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getToString_2040Text(View view) {
		ToString domainModelElement = (ToString) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isSerialized());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGlobalVariable_2041Text(View view) {
		GlobalVariable domainModelElement = (GlobalVariable) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAdvancedCustomFunction_2042Text(View view) {
		AdvancedCustomFunction domainModelElement = (AdvancedCustomFunction) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getFunctionName();
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2042); //$NON-NLS-1$
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
	private String getTreeNode_3003Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3003,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
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
	private String getTreeNode_3002Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3002,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
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
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTreeNode_3011Text(View view) {
		IParser parser = DataMapperParserProvider.getParser(DataMapperElementTypes.TreeNode_3011,
				view.getElement() != null ? view.getElement() : view,
				DataMapperVisualIDRegistry.getType(TreeNodeName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			DataMapperDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
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
	private String getOutNode_3019Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInNode_3020Text(View view) {
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
