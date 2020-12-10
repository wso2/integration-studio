package org.wso2.integrationstudio.datamapper.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.wso2.integrationstudio.datamapper.AbsoluteValue;
import org.wso2.integrationstudio.datamapper.Add;
import org.wso2.integrationstudio.datamapper.AdvancedCustomFunction;
import org.wso2.integrationstudio.datamapper.Celi;
import org.wso2.integrationstudio.datamapper.Clone;
import org.wso2.integrationstudio.datamapper.Compare;
import org.wso2.integrationstudio.datamapper.Concat;
import org.wso2.integrationstudio.datamapper.Constant;
import org.wso2.integrationstudio.datamapper.Contains;
import org.wso2.integrationstudio.datamapper.CustomFunction;
import org.wso2.integrationstudio.datamapper.DataMapperLink;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.DataMapperRoot;
import org.wso2.integrationstudio.datamapper.Divide;
import org.wso2.integrationstudio.datamapper.Element;
import org.wso2.integrationstudio.datamapper.EndsWith;
import org.wso2.integrationstudio.datamapper.Equal;
import org.wso2.integrationstudio.datamapper.Floor;
import org.wso2.integrationstudio.datamapper.GlobalVariable;
import org.wso2.integrationstudio.datamapper.IfElse;
import org.wso2.integrationstudio.datamapper.InNode;
import org.wso2.integrationstudio.datamapper.Input;
import org.wso2.integrationstudio.datamapper.LowerCase;
import org.wso2.integrationstudio.datamapper.Match;
import org.wso2.integrationstudio.datamapper.Max;
import org.wso2.integrationstudio.datamapper.Min;
import org.wso2.integrationstudio.datamapper.Multiply;
import org.wso2.integrationstudio.datamapper.Operator;
import org.wso2.integrationstudio.datamapper.OperatorBasicContainer;
import org.wso2.integrationstudio.datamapper.OperatorLeftConnector;
import org.wso2.integrationstudio.datamapper.OperatorLeftContainer;
import org.wso2.integrationstudio.datamapper.OperatorRightConnector;
import org.wso2.integrationstudio.datamapper.OperatorRightContainer;
import org.wso2.integrationstudio.datamapper.OutNode;
import org.wso2.integrationstudio.datamapper.Output;
import org.wso2.integrationstudio.datamapper.Properties;
import org.wso2.integrationstudio.datamapper.Replace;
import org.wso2.integrationstudio.datamapper.Round;
import org.wso2.integrationstudio.datamapper.SetPrecision;
import org.wso2.integrationstudio.datamapper.Split;
import org.wso2.integrationstudio.datamapper.StartsWith;
import org.wso2.integrationstudio.datamapper.StringLength;
import org.wso2.integrationstudio.datamapper.StringToBoolean;
import org.wso2.integrationstudio.datamapper.StringToNumber;
import org.wso2.integrationstudio.datamapper.Substring;
import org.wso2.integrationstudio.datamapper.Subtract;
import org.wso2.integrationstudio.datamapper.ToString;
import org.wso2.integrationstudio.datamapper.TreeNode;
import org.wso2.integrationstudio.datamapper.Trim;
import org.wso2.integrationstudio.datamapper.UpperCase;
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
import org.wso2.integrationstudio.datamapper.diagram.providers.DataMapperElementTypes;

/**
 * @generated
 */
public class DataMapperDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getSemanticChildren(View view) {
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000SemanticChildren(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002SemanticChildren(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003SemanticChildren(view);
		case EqualEditPart.VISUAL_ID:
			return getEqual_2005SemanticChildren(view);
		case SubtractEditPart.VISUAL_ID:
			return getSubtract_2013SemanticChildren(view);
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006SemanticChildren(view);
		case AddEditPart.VISUAL_ID:
			return getAdd_2012SemanticChildren(view);
		case SplitEditPart.VISUAL_ID:
			return getSplit_2007SemanticChildren(view);
		case ConstantEditPart.VISUAL_ID:
			return getConstant_2008SemanticChildren(view);
		case LowerCaseEditPart.VISUAL_ID:
			return getLowerCase_2009SemanticChildren(view);
		case ContainsEditPart.VISUAL_ID:
			return getContains_2010SemanticChildren(view);
		case UpperCaseEditPart.VISUAL_ID:
			return getUpperCase_2011SemanticChildren(view);
		case MultiplyEditPart.VISUAL_ID:
			return getMultiply_2014SemanticChildren(view);
		case DivideEditPart.VISUAL_ID:
			return getDivide_2015SemanticChildren(view);
		case CeliEditPart.VISUAL_ID:
			return getCeli_2016SemanticChildren(view);
		case FloorEditPart.VISUAL_ID:
			return getFloor_2017SemanticChildren(view);
		case RoundEditPart.VISUAL_ID:
			return getRound_2018SemanticChildren(view);
		case SetPrecisionEditPart.VISUAL_ID:
			return getSetPrecision_2019SemanticChildren(view);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getAbsoluteValue_2020SemanticChildren(view);
		case StringLengthEditPart.VISUAL_ID:
			return getStringLength_2021SemanticChildren(view);
		case StartsWithEditPart.VISUAL_ID:
			return getStartsWith_2022SemanticChildren(view);
		case EndsWithEditPart.VISUAL_ID:
			return getEndsWith_2023SemanticChildren(view);
		case SubstringEditPart.VISUAL_ID:
			return getSubstring_2024SemanticChildren(view);
		case IfElseEditPart.VISUAL_ID:
			return getIfElse_2025SemanticChildren(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2026SemanticChildren(view);
		case OREditPart.VISUAL_ID:
			return getOR_2027SemanticChildren(view);
		case NOTEditPart.VISUAL_ID:
			return getNOT_2028SemanticChildren(view);
		case TrimEditPart.VISUAL_ID:
			return getTrim_2029SemanticChildren(view);
		case ReplaceEditPart.VISUAL_ID:
			return getReplace_2030SemanticChildren(view);
		case MatchEditPart.VISUAL_ID:
			return getMatch_2031SemanticChildren(view);
		case MinEditPart.VISUAL_ID:
			return getMin_2032SemanticChildren(view);
		case MaxEditPart.VISUAL_ID:
			return getMax_2033SemanticChildren(view);
		case CustomFunctionEditPart.VISUAL_ID:
			return getCustomFunction_2034SemanticChildren(view);
		case PropertiesEditPart.VISUAL_ID:
			return getProperties_2035SemanticChildren(view);
		case CompareEditPart.VISUAL_ID:
			return getCompare_2036SemanticChildren(view);
		case StringToNumberEditPart.VISUAL_ID:
			return getStringToNumber_2037SemanticChildren(view);
		case StringToBooleanEditPart.VISUAL_ID:
			return getStringToBoolean_2038SemanticChildren(view);
		case CloneEditPart.VISUAL_ID:
			return getClone_2039SemanticChildren(view);
		case ToStringEditPart.VISUAL_ID:
			return getToString_2040SemanticChildren(view);
		case GlobalVariableEditPart.VISUAL_ID:
			return getGlobalVariable_2041SemanticChildren(view);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getAdvancedCustomFunction_2042SemanticChildren(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002SemanticChildren(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007SemanticChildren(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003SemanticChildren(view);
		case TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011SemanticChildren(view);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012SemanticChildren(view);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013SemanticChildren(view);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014SemanticChildren(view);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016SemanticChildren(view);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getDataMapperRoot_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DataMapperRoot modelElement = (DataMapperRoot) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			Input childElement = modelElement.getInput();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			Output childElement = modelElement.getOutput();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOperators().iterator(); it.hasNext();) {
			Operator childElement = (Operator) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EqualEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SubtractEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConcatEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SplitEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstantEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LowerCaseEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ContainsEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == UpperCaseEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MultiplyEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DivideEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CeliEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FloorEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RoundEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SetPrecisionEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AbsoluteValueEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StringLengthEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StartsWithEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EndsWithEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SubstringEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IfElseEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ANDEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OREditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NOTEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TrimEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ReplaceEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MatchEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MinEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MaxEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CustomFunctionEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertiesEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CompareEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StringToNumberEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StringToBooleanEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ToStringEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GlobalVariableEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AdvancedCustomFunctionEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getInput_2002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Input modelElement = (Input) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOutput_2003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Output modelElement = (Output) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode3EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getEqual_2005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Equal modelElement = (Equal) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getSubtract_2013SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Subtract modelElement = (Subtract) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getConcat_2006SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Concat modelElement = (Concat) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getAdd_2012SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Add modelElement = (Add) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getSplit_2007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Split modelElement = (Split) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getConstant_2008SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Constant modelElement = (Constant) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getLowerCase_2009SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		LowerCase modelElement = (LowerCase) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getContains_2010SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Contains modelElement = (Contains) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getUpperCase_2011SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		UpperCase modelElement = (UpperCase) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getMultiply_2014SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Multiply modelElement = (Multiply) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getDivide_2015SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Divide modelElement = (Divide) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getCeli_2016SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Celi modelElement = (Celi) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getFloor_2017SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Floor modelElement = (Floor) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getRound_2018SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Round modelElement = (Round) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getSetPrecision_2019SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SetPrecision modelElement = (SetPrecision) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getAbsoluteValue_2020SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AbsoluteValue modelElement = (AbsoluteValue) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getStringLength_2021SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StringLength modelElement = (StringLength) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getStartsWith_2022SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StartsWith modelElement = (StartsWith) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getEndsWith_2023SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EndsWith modelElement = (EndsWith) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getSubstring_2024SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Substring modelElement = (Substring) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getIfElse_2025SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		IfElse modelElement = (IfElse) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getAND_2026SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		org.wso2.integrationstudio.datamapper.AND modelElement = (org.wso2.integrationstudio.datamapper.AND) view
				.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getOR_2027SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		org.wso2.integrationstudio.datamapper.OR modelElement = (org.wso2.integrationstudio.datamapper.OR) view
				.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getNOT_2028SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		org.wso2.integrationstudio.datamapper.NOT modelElement = (org.wso2.integrationstudio.datamapper.NOT) view
				.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getTrim_2029SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Trim modelElement = (Trim) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getReplace_2030SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Replace modelElement = (Replace) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getMatch_2031SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Match modelElement = (Match) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getMin_2032SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Min modelElement = (Min) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getMax_2033SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Max modelElement = (Max) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getCustomFunction_2034SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CustomFunction modelElement = (CustomFunction) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getProperties_2035SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Properties modelElement = (Properties) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getCompare_2036SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Compare modelElement = (Compare) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getStringToNumber_2037SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StringToNumber modelElement = (StringToNumber) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getStringToBoolean_2038SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StringToBoolean modelElement = (StringToBoolean) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getClone_2039SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Clone modelElement = (Clone) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getToString_2040SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ToString modelElement = (ToString) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getGlobalVariable_2041SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		GlobalVariable modelElement = (GlobalVariable) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<DataMapperNodeDescriptor> getAdvancedCustomFunction_2042SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AdvancedCustomFunction modelElement = (AdvancedCustomFunction) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getTreeNode_3002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TreeNode modelElement = (TreeNode) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InNode childElement = modelElement.getInNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutNode childElement = modelElement.getOutNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getTreeNode_3003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TreeNode modelElement = (TreeNode) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InNode childElement = modelElement.getInNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutNode childElement = modelElement.getOutNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getElement_3007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Element modelElement = (Element) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			InNode childElement = modelElement.getInNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutNode childElement = modelElement.getOutNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getTreeNode_3011SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TreeNode modelElement = (TreeNode) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InNode childElement = modelElement.getInNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutNode childElement = modelElement.getOutNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutNodeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorBasicContainer_3012SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OperatorBasicContainer modelElement = (OperatorBasicContainer) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OperatorLeftContainer childElement = modelElement.getLeftContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorLeftContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		{
			OperatorRightContainer childElement = modelElement.getRightContainer();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorRightContainerEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorLeftContainer_3013SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OperatorLeftContainer modelElement = (OperatorLeftContainer) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getLeftConnectors().iterator(); it.hasNext();) {
			OperatorLeftConnector childElement = (OperatorLeftConnector) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorLeftConnectorEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorLeftConnector_3014SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OperatorLeftConnector modelElement = (OperatorLeftConnector) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			InNode childElement = modelElement.getInNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InNode3EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorRightContainer_3016SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OperatorRightContainer modelElement = (OperatorRightContainer) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRightConnectors().iterator(); it.hasNext();) {
			OperatorRightConnector childElement = (OperatorRightConnector) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorRightConnectorEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorRightConnector_3017SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OperatorRightConnector modelElement = (OperatorRightConnector) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		{
			OutNode childElement = modelElement.getOutNode();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutNode3EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getContainedLinks(View view) {
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000ContainedLinks(view);
		case InputEditPart.VISUAL_ID:
			return getInput_2002ContainedLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003ContainedLinks(view);
		case EqualEditPart.VISUAL_ID:
			return getEqual_2005ContainedLinks(view);
		case SubtractEditPart.VISUAL_ID:
			return getSubtract_2013ContainedLinks(view);
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006ContainedLinks(view);
		case AddEditPart.VISUAL_ID:
			return getAdd_2012ContainedLinks(view);
		case SplitEditPart.VISUAL_ID:
			return getSplit_2007ContainedLinks(view);
		case ConstantEditPart.VISUAL_ID:
			return getConstant_2008ContainedLinks(view);
		case LowerCaseEditPart.VISUAL_ID:
			return getLowerCase_2009ContainedLinks(view);
		case ContainsEditPart.VISUAL_ID:
			return getContains_2010ContainedLinks(view);
		case UpperCaseEditPart.VISUAL_ID:
			return getUpperCase_2011ContainedLinks(view);
		case MultiplyEditPart.VISUAL_ID:
			return getMultiply_2014ContainedLinks(view);
		case DivideEditPart.VISUAL_ID:
			return getDivide_2015ContainedLinks(view);
		case CeliEditPart.VISUAL_ID:
			return getCeli_2016ContainedLinks(view);
		case FloorEditPart.VISUAL_ID:
			return getFloor_2017ContainedLinks(view);
		case RoundEditPart.VISUAL_ID:
			return getRound_2018ContainedLinks(view);
		case SetPrecisionEditPart.VISUAL_ID:
			return getSetPrecision_2019ContainedLinks(view);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getAbsoluteValue_2020ContainedLinks(view);
		case StringLengthEditPart.VISUAL_ID:
			return getStringLength_2021ContainedLinks(view);
		case StartsWithEditPart.VISUAL_ID:
			return getStartsWith_2022ContainedLinks(view);
		case EndsWithEditPart.VISUAL_ID:
			return getEndsWith_2023ContainedLinks(view);
		case SubstringEditPart.VISUAL_ID:
			return getSubstring_2024ContainedLinks(view);
		case IfElseEditPart.VISUAL_ID:
			return getIfElse_2025ContainedLinks(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2026ContainedLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_2027ContainedLinks(view);
		case NOTEditPart.VISUAL_ID:
			return getNOT_2028ContainedLinks(view);
		case TrimEditPart.VISUAL_ID:
			return getTrim_2029ContainedLinks(view);
		case ReplaceEditPart.VISUAL_ID:
			return getReplace_2030ContainedLinks(view);
		case MatchEditPart.VISUAL_ID:
			return getMatch_2031ContainedLinks(view);
		case MinEditPart.VISUAL_ID:
			return getMin_2032ContainedLinks(view);
		case MaxEditPart.VISUAL_ID:
			return getMax_2033ContainedLinks(view);
		case CustomFunctionEditPart.VISUAL_ID:
			return getCustomFunction_2034ContainedLinks(view);
		case PropertiesEditPart.VISUAL_ID:
			return getProperties_2035ContainedLinks(view);
		case CompareEditPart.VISUAL_ID:
			return getCompare_2036ContainedLinks(view);
		case StringToNumberEditPart.VISUAL_ID:
			return getStringToNumber_2037ContainedLinks(view);
		case StringToBooleanEditPart.VISUAL_ID:
			return getStringToBoolean_2038ContainedLinks(view);
		case CloneEditPart.VISUAL_ID:
			return getClone_2039ContainedLinks(view);
		case ToStringEditPart.VISUAL_ID:
			return getToString_2040ContainedLinks(view);
		case GlobalVariableEditPart.VISUAL_ID:
			return getGlobalVariable_2041ContainedLinks(view);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getAdvancedCustomFunction_2042ContainedLinks(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002ContainedLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007ContainedLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008ContainedLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009ContainedLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003ContainedLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3020ContainedLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3019ContainedLinks(view);
		case TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011ContainedLinks(view);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012ContainedLinks(view);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013ContainedLinks(view);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014ContainedLinks(view);
		case InNode3EditPart.VISUAL_ID:
			return getInNode_3015ContainedLinks(view);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016ContainedLinks(view);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017ContainedLinks(view);
		case OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018ContainedLinks(view);
		case DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getIncomingLinks(View view) {
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case InputEditPart.VISUAL_ID:
			return getInput_2002IncomingLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003IncomingLinks(view);
		case EqualEditPart.VISUAL_ID:
			return getEqual_2005IncomingLinks(view);
		case SubtractEditPart.VISUAL_ID:
			return getSubtract_2013IncomingLinks(view);
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006IncomingLinks(view);
		case AddEditPart.VISUAL_ID:
			return getAdd_2012IncomingLinks(view);
		case SplitEditPart.VISUAL_ID:
			return getSplit_2007IncomingLinks(view);
		case ConstantEditPart.VISUAL_ID:
			return getConstant_2008IncomingLinks(view);
		case LowerCaseEditPart.VISUAL_ID:
			return getLowerCase_2009IncomingLinks(view);
		case ContainsEditPart.VISUAL_ID:
			return getContains_2010IncomingLinks(view);
		case UpperCaseEditPart.VISUAL_ID:
			return getUpperCase_2011IncomingLinks(view);
		case MultiplyEditPart.VISUAL_ID:
			return getMultiply_2014IncomingLinks(view);
		case DivideEditPart.VISUAL_ID:
			return getDivide_2015IncomingLinks(view);
		case CeliEditPart.VISUAL_ID:
			return getCeli_2016IncomingLinks(view);
		case FloorEditPart.VISUAL_ID:
			return getFloor_2017IncomingLinks(view);
		case RoundEditPart.VISUAL_ID:
			return getRound_2018IncomingLinks(view);
		case SetPrecisionEditPart.VISUAL_ID:
			return getSetPrecision_2019IncomingLinks(view);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getAbsoluteValue_2020IncomingLinks(view);
		case StringLengthEditPart.VISUAL_ID:
			return getStringLength_2021IncomingLinks(view);
		case StartsWithEditPart.VISUAL_ID:
			return getStartsWith_2022IncomingLinks(view);
		case EndsWithEditPart.VISUAL_ID:
			return getEndsWith_2023IncomingLinks(view);
		case SubstringEditPart.VISUAL_ID:
			return getSubstring_2024IncomingLinks(view);
		case IfElseEditPart.VISUAL_ID:
			return getIfElse_2025IncomingLinks(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2026IncomingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_2027IncomingLinks(view);
		case NOTEditPart.VISUAL_ID:
			return getNOT_2028IncomingLinks(view);
		case TrimEditPart.VISUAL_ID:
			return getTrim_2029IncomingLinks(view);
		case ReplaceEditPart.VISUAL_ID:
			return getReplace_2030IncomingLinks(view);
		case MatchEditPart.VISUAL_ID:
			return getMatch_2031IncomingLinks(view);
		case MinEditPart.VISUAL_ID:
			return getMin_2032IncomingLinks(view);
		case MaxEditPart.VISUAL_ID:
			return getMax_2033IncomingLinks(view);
		case CustomFunctionEditPart.VISUAL_ID:
			return getCustomFunction_2034IncomingLinks(view);
		case PropertiesEditPart.VISUAL_ID:
			return getProperties_2035IncomingLinks(view);
		case CompareEditPart.VISUAL_ID:
			return getCompare_2036IncomingLinks(view);
		case StringToNumberEditPart.VISUAL_ID:
			return getStringToNumber_2037IncomingLinks(view);
		case StringToBooleanEditPart.VISUAL_ID:
			return getStringToBoolean_2038IncomingLinks(view);
		case CloneEditPart.VISUAL_ID:
			return getClone_2039IncomingLinks(view);
		case ToStringEditPart.VISUAL_ID:
			return getToString_2040IncomingLinks(view);
		case GlobalVariableEditPart.VISUAL_ID:
			return getGlobalVariable_2041IncomingLinks(view);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getAdvancedCustomFunction_2042IncomingLinks(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002IncomingLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007IncomingLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008IncomingLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009IncomingLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003IncomingLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3020IncomingLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3019IncomingLinks(view);
		case TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011IncomingLinks(view);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012IncomingLinks(view);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013IncomingLinks(view);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014IncomingLinks(view);
		case InNode3EditPart.VISUAL_ID:
			return getInNode_3015IncomingLinks(view);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016IncomingLinks(view);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017IncomingLinks(view);
		case OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018IncomingLinks(view);
		case DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutgoingLinks(View view) {
		switch (DataMapperVisualIDRegistry.getVisualID(view)) {
		case InputEditPart.VISUAL_ID:
			return getInput_2002OutgoingLinks(view);
		case OutputEditPart.VISUAL_ID:
			return getOutput_2003OutgoingLinks(view);
		case EqualEditPart.VISUAL_ID:
			return getEqual_2005OutgoingLinks(view);
		case SubtractEditPart.VISUAL_ID:
			return getSubtract_2013OutgoingLinks(view);
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006OutgoingLinks(view);
		case AddEditPart.VISUAL_ID:
			return getAdd_2012OutgoingLinks(view);
		case SplitEditPart.VISUAL_ID:
			return getSplit_2007OutgoingLinks(view);
		case ConstantEditPart.VISUAL_ID:
			return getConstant_2008OutgoingLinks(view);
		case LowerCaseEditPart.VISUAL_ID:
			return getLowerCase_2009OutgoingLinks(view);
		case ContainsEditPart.VISUAL_ID:
			return getContains_2010OutgoingLinks(view);
		case UpperCaseEditPart.VISUAL_ID:
			return getUpperCase_2011OutgoingLinks(view);
		case MultiplyEditPart.VISUAL_ID:
			return getMultiply_2014OutgoingLinks(view);
		case DivideEditPart.VISUAL_ID:
			return getDivide_2015OutgoingLinks(view);
		case CeliEditPart.VISUAL_ID:
			return getCeli_2016OutgoingLinks(view);
		case FloorEditPart.VISUAL_ID:
			return getFloor_2017OutgoingLinks(view);
		case RoundEditPart.VISUAL_ID:
			return getRound_2018OutgoingLinks(view);
		case SetPrecisionEditPart.VISUAL_ID:
			return getSetPrecision_2019OutgoingLinks(view);
		case AbsoluteValueEditPart.VISUAL_ID:
			return getAbsoluteValue_2020OutgoingLinks(view);
		case StringLengthEditPart.VISUAL_ID:
			return getStringLength_2021OutgoingLinks(view);
		case StartsWithEditPart.VISUAL_ID:
			return getStartsWith_2022OutgoingLinks(view);
		case EndsWithEditPart.VISUAL_ID:
			return getEndsWith_2023OutgoingLinks(view);
		case SubstringEditPart.VISUAL_ID:
			return getSubstring_2024OutgoingLinks(view);
		case IfElseEditPart.VISUAL_ID:
			return getIfElse_2025OutgoingLinks(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_2026OutgoingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_2027OutgoingLinks(view);
		case NOTEditPart.VISUAL_ID:
			return getNOT_2028OutgoingLinks(view);
		case TrimEditPart.VISUAL_ID:
			return getTrim_2029OutgoingLinks(view);
		case ReplaceEditPart.VISUAL_ID:
			return getReplace_2030OutgoingLinks(view);
		case MatchEditPart.VISUAL_ID:
			return getMatch_2031OutgoingLinks(view);
		case MinEditPart.VISUAL_ID:
			return getMin_2032OutgoingLinks(view);
		case MaxEditPart.VISUAL_ID:
			return getMax_2033OutgoingLinks(view);
		case CustomFunctionEditPart.VISUAL_ID:
			return getCustomFunction_2034OutgoingLinks(view);
		case PropertiesEditPart.VISUAL_ID:
			return getProperties_2035OutgoingLinks(view);
		case CompareEditPart.VISUAL_ID:
			return getCompare_2036OutgoingLinks(view);
		case StringToNumberEditPart.VISUAL_ID:
			return getStringToNumber_2037OutgoingLinks(view);
		case StringToBooleanEditPart.VISUAL_ID:
			return getStringToBoolean_2038OutgoingLinks(view);
		case CloneEditPart.VISUAL_ID:
			return getClone_2039OutgoingLinks(view);
		case ToStringEditPart.VISUAL_ID:
			return getToString_2040OutgoingLinks(view);
		case GlobalVariableEditPart.VISUAL_ID:
			return getGlobalVariable_2041OutgoingLinks(view);
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return getAdvancedCustomFunction_2042OutgoingLinks(view);
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002OutgoingLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007OutgoingLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008OutgoingLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009OutgoingLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003OutgoingLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3020OutgoingLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3019OutgoingLinks(view);
		case TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011OutgoingLinks(view);
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012OutgoingLinks(view);
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013OutgoingLinks(view);
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014OutgoingLinks(view);
		case InNode3EditPart.VISUAL_ID:
			return getInNode_3015OutgoingLinks(view);
		case OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016OutgoingLinks(view);
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017OutgoingLinks(view);
		case OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018OutgoingLinks(view);
		case DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getDataMapperRoot_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInput_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutput_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getEqual_2005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubtract_2013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConcat_2006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdd_2012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getSplit_2007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConstant_2008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getLowerCase_2009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getContains_2010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getUpperCase_2011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMultiply_2014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getDivide_2015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCeli_2016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getFloor_2017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getRound_2018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSetPrecision_2019ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAbsoluteValue_2020ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringLength_2021ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStartsWith_2022ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getEndsWith_2023ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubstring_2024ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getIfElse_2025ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAND_2026ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getOR_2027ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getNOT_2028ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getTrim_2029ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getReplace_2030ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMatch_2031ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMin_2032ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMax_2033ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCustomFunction_2034ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getProperties_2035ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCompare_2036ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToNumber_2037ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToBoolean_2038ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getClone_2039ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getToString_2040ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getGlobalVariable_2041ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdvancedCustomFunction_2042ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3020ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3019ContainedLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getElement_3007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3009ContainedLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3018ContainedLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getDataMapperLink_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInput_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutput_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getEqual_2005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubtract_2013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConcat_2006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdd_2012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getSplit_2007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConstant_2008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getLowerCase_2009IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getContains_2010IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getUpperCase_2011IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMultiply_2014IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getDivide_2015IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCeli_2016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getFloor_2017IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getRound_2018IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSetPrecision_2019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAbsoluteValue_2020IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringLength_2021IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStartsWith_2022IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getEndsWith_2023IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubstring_2024IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getIfElse_2025IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAND_2026IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getOR_2027IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getNOT_2028IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getTrim_2029IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getReplace_2030IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMatch_2031IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMin_2032IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMax_2033IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCustomFunction_2034IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getProperties_2035IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCompare_2036IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToNumber_2037IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToBoolean_2038IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getClone_2039IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getToString_2040IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getGlobalVariable_2041IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdvancedCustomFunction_2042IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3020IncomingLinks(View view) {
		InNode modelElement = (InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getElement_3007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3008IncomingLinks(View view) {
		InNode modelElement = (InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3009IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3011IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3015IncomingLinks(View view) {
		InNode modelElement = (InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3018IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getDataMapperLink_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInput_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutput_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getEqual_2005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubtract_2013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConcat_2006OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdd_2012OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getSplit_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getConstant_2008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getLowerCase_2009OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getContains_2010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getUpperCase_2011OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMultiply_2014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getDivide_2015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCeli_2016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getFloor_2017OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getRound_2018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSetPrecision_2019OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAbsoluteValue_2020OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringLength_2021OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStartsWith_2022OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getEndsWith_2023OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getSubstring_2024OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getIfElse_2025OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAND_2026OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getOR_2027OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getNOT_2028OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getTrim_2029OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getReplace_2030OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMatch_2031OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMin_2032OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getMax_2033OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCustomFunction_2034OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getProperties_2035OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getCompare_2036OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToNumber_2037OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getStringToBoolean_2038OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getClone_2039OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getToString_2040OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getGlobalVariable_2041OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<DataMapperLinkDescriptor> getAdvancedCustomFunction_2042OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3020OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3019OutgoingLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getElement_3007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3009OutgoingLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getTreeNode_3011OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3018OutgoingLinks(View view) {
		OutNode modelElement = (OutNode) view.getElement();
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getDataMapperLink_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<DataMapperLinkDescriptor> getContainedTypeModelFacetLinks_DataMapperLink_4001(
			OutNode container) {
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DataMapperLink) {
				continue;
			}
			DataMapperLink link = (DataMapperLink) linkObject;
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			InNode dst = link.getInNode();
			OutNode src = link.getOutNode();
			result.add(new DataMapperLinkDescriptor(src, dst, link, DataMapperElementTypes.DataMapperLink_4001,
					DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DataMapperLinkDescriptor> getIncomingTypeModelFacetLinks_DataMapperLink_4001(
			InNode target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != DataMapperPackage.eINSTANCE.getDataMapperLink_InNode()
					|| false == setting.getEObject() instanceof DataMapperLink) {
				continue;
			}
			DataMapperLink link = (DataMapperLink) setting.getEObject();
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutNode src = link.getOutNode();
			result.add(new DataMapperLinkDescriptor(src, target, link, DataMapperElementTypes.DataMapperLink_4001,
					DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<DataMapperLinkDescriptor> getOutgoingTypeModelFacetLinks_DataMapperLink_4001(
			OutNode source) {
		OutNode container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof OutNode) {
				container = (OutNode) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DataMapperLink) {
				continue;
			}
			DataMapperLink link = (DataMapperLink) linkObject;
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			InNode dst = link.getInNode();
			OutNode src = link.getOutNode();
			if (src != source) {
				continue;
			}
			result.add(new DataMapperLinkDescriptor(src, dst, link, DataMapperElementTypes.DataMapperLink_4001,
					DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<DataMapperNodeDescriptor> getSemanticChildren(View view) {
			return DataMapperDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DataMapperLinkDescriptor> getContainedLinks(View view) {
			return DataMapperDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DataMapperLinkDescriptor> getIncomingLinks(View view) {
			return DataMapperDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<DataMapperLinkDescriptor> getOutgoingLinks(View view) {
			return DataMapperDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
