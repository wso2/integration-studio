package org.wso2.developerstudio.datamapper.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
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

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class DataMapperVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.wso2.developerstudio.visualdatamapper.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (DataMapperRootEditPart.MODEL_ID.equals(view.getType())) {
				return DataMapperRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				DataMapperDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DataMapperPackage.eINSTANCE.getDataMapperRoot().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((DataMapperRoot) domainElement)) {
			return DataMapperRootEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
				.getModelID(containerView);
		if (!DataMapperRootEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (DataMapperRootEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DataMapperRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case DataMapperRootEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getInput().isSuperTypeOf(domainElement.eClass())) {
				return InputEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOutput().isSuperTypeOf(domainElement.eClass())) {
				return OutputEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getEqual().isSuperTypeOf(domainElement.eClass())) {
				return EqualEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getSubtract().isSuperTypeOf(domainElement.eClass())) {
				return SubtractEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getConcat().isSuperTypeOf(domainElement.eClass())) {
				return ConcatEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getAdd().isSuperTypeOf(domainElement.eClass())) {
				return AddEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getSplit().isSuperTypeOf(domainElement.eClass())) {
				return SplitEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getConstant().isSuperTypeOf(domainElement.eClass())) {
				return ConstantEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getLowerCase().isSuperTypeOf(domainElement.eClass())) {
				return LowerCaseEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getContains().isSuperTypeOf(domainElement.eClass())) {
				return ContainsEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getUpperCase().isSuperTypeOf(domainElement.eClass())) {
				return UpperCaseEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getMultiply().isSuperTypeOf(domainElement.eClass())) {
				return MultiplyEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getDivide().isSuperTypeOf(domainElement.eClass())) {
				return DivideEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getCeli().isSuperTypeOf(domainElement.eClass())) {
				return CeliEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getFloor().isSuperTypeOf(domainElement.eClass())) {
				return FloorEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getRound().isSuperTypeOf(domainElement.eClass())) {
				return RoundEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getSetPrecision().isSuperTypeOf(domainElement.eClass())) {
				return SetPrecisionEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getAbsoluteValue().isSuperTypeOf(domainElement.eClass())) {
				return AbsoluteValueEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getStringLength().isSuperTypeOf(domainElement.eClass())) {
				return StringLengthEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getStartsWith().isSuperTypeOf(domainElement.eClass())) {
				return StartsWithEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getEndsWith().isSuperTypeOf(domainElement.eClass())) {
				return EndsWithEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getSubstring().isSuperTypeOf(domainElement.eClass())) {
				return SubstringEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getIfElse().isSuperTypeOf(domainElement.eClass())) {
				return IfElseEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getAND().isSuperTypeOf(domainElement.eClass())) {
				return ANDEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOR().isSuperTypeOf(domainElement.eClass())) {
				return OREditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getNOT().isSuperTypeOf(domainElement.eClass())) {
				return NOTEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getTrim().isSuperTypeOf(domainElement.eClass())) {
				return TrimEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getReplace().isSuperTypeOf(domainElement.eClass())) {
				return ReplaceEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getMatch().isSuperTypeOf(domainElement.eClass())) {
				return MatchEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getMin().isSuperTypeOf(domainElement.eClass())) {
				return MinEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getMax().isSuperTypeOf(domainElement.eClass())) {
				return MaxEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getCustomFunction().isSuperTypeOf(domainElement.eClass())) {
				return CustomFunctionEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getProperties().isSuperTypeOf(domainElement.eClass())) {
				return PropertiesEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getCompare().isSuperTypeOf(domainElement.eClass())) {
				return CompareEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getStringToNumber().isSuperTypeOf(domainElement.eClass())) {
				return StringToNumberEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getStringToBoolean().isSuperTypeOf(domainElement.eClass())) {
				return StringToBooleanEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getClone().isSuperTypeOf(domainElement.eClass())) {
				return CloneEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getToString().isSuperTypeOf(domainElement.eClass())) {
				return ToStringEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getGlobalVariable().isSuperTypeOf(domainElement.eClass())) {
				return GlobalVariableEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getAdvancedCustomFunction().isSuperTypeOf(domainElement.eClass())) {
				return AdvancedCustomFunctionEditPart.VISUAL_ID;
			}
			break;
		case InputEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getTreeNode().isSuperTypeOf(domainElement.eClass())) {
				return TreeNodeEditPart.VISUAL_ID;
			}
			break;
		case OutputEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getTreeNode().isSuperTypeOf(domainElement.eClass())) {
				return TreeNode3EditPart.VISUAL_ID;
			}
			break;
		case EqualEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case SubtractEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ConcatEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case AddEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case SplitEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ConstantEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case LowerCaseEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ContainsEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case UpperCaseEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case MultiplyEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case DivideEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case CeliEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case FloorEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case RoundEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case SetPrecisionEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case AbsoluteValueEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case StringLengthEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case StartsWithEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case EndsWithEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case SubstringEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case IfElseEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ANDEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case OREditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case NOTEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case TrimEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ReplaceEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case MatchEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case MinEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case MaxEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case CustomFunctionEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case PropertiesEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case CompareEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case StringToNumberEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case StringToBooleanEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case CloneEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case ToStringEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case GlobalVariableEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorBasicContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorBasicContainerEditPart.VISUAL_ID;
			}
			break;
		case TreeNodeEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getElement().isSuperTypeOf(domainElement.eClass())) {
				return ElementEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getTreeNode().isSuperTypeOf(domainElement.eClass())) {
				return TreeNode2EditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getInNode().isSuperTypeOf(domainElement.eClass())) {
				return InNodeEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOutNode().isSuperTypeOf(domainElement.eClass())) {
				return OutNodeEditPart.VISUAL_ID;
			}
			break;
		case ElementEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getInNode().isSuperTypeOf(domainElement.eClass())) {
				return InNode2EditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOutNode().isSuperTypeOf(domainElement.eClass())) {
				return OutNode2EditPart.VISUAL_ID;
			}
			break;
		case TreeNode2EditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getElement().isSuperTypeOf(domainElement.eClass())) {
				return ElementEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getTreeNode().isSuperTypeOf(domainElement.eClass())) {
				return TreeNode2EditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getInNode().isSuperTypeOf(domainElement.eClass())) {
				return InNodeEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOutNode().isSuperTypeOf(domainElement.eClass())) {
				return OutNodeEditPart.VISUAL_ID;
			}
			break;
		case TreeNode3EditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getElement().isSuperTypeOf(domainElement.eClass())) {
				return ElementEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getTreeNode().isSuperTypeOf(domainElement.eClass())) {
				return TreeNode2EditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getInNode().isSuperTypeOf(domainElement.eClass())) {
				return InNodeEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOutNode().isSuperTypeOf(domainElement.eClass())) {
				return OutNodeEditPart.VISUAL_ID;
			}
			break;
		case OperatorBasicContainerEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorLeftContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorLeftContainerEditPart.VISUAL_ID;
			}
			if (DataMapperPackage.eINSTANCE.getOperatorRightContainer().isSuperTypeOf(domainElement.eClass())) {
				return OperatorRightContainerEditPart.VISUAL_ID;
			}
			break;
		case OperatorLeftContainerEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorLeftConnector().isSuperTypeOf(domainElement.eClass())) {
				return OperatorLeftConnectorEditPart.VISUAL_ID;
			}
			break;
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getInNode().isSuperTypeOf(domainElement.eClass())) {
				return InNode3EditPart.VISUAL_ID;
			}
			break;
		case OperatorRightContainerEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOperatorRightConnector().isSuperTypeOf(domainElement.eClass())) {
				return OperatorRightConnectorEditPart.VISUAL_ID;
			}
			break;
		case OperatorRightConnectorEditPart.VISUAL_ID:
			if (DataMapperPackage.eINSTANCE.getOutNode().isSuperTypeOf(domainElement.eClass())) {
				return OutNode3EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
				.getModelID(containerView);
		if (!DataMapperRootEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (DataMapperRootEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DataMapperRootEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case DataMapperRootEditPart.VISUAL_ID:
			if (InputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EqualEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubtractEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConcatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SplitEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LowerCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ContainsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UpperCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MultiplyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DivideEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CeliEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FloorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RoundEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SetPrecisionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AbsoluteValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StringLengthEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StartsWithEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndsWithEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubstringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IfElseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ANDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NOTEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TrimEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReplaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MatchEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MaxEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CustomFunctionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertiesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompareEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StringToNumberEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StringToBooleanEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ToStringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GlobalVariableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AdvancedCustomFunctionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputEditPart.VISUAL_ID:
			if (TreeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputEditPart.VISUAL_ID:
			if (TreeNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EqualEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubtractEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConcatEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SplitEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstantEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LowerCaseEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ContainsEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UpperCaseEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiplyEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DivideEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CeliEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FloorEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RoundEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SetPrecisionEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbsoluteValueEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StringLengthEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StartsWithEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndsWithEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstringEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IfElseEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ANDEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OREditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NOTEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TrimEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReplaceEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MatchEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MinEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MaxEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CustomFunctionEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertiesEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompareEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StringToNumberEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StringToBooleanEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloneEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ToStringEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GlobalVariableEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			if (OperatorBasicContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TreeNodeEditPart.VISUAL_ID:
			if (TreeNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ElementEditPart.VISUAL_ID:
			if (ElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TreeNode2EditPart.VISUAL_ID:
			if (TreeNodeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TreeNode3EditPart.VISUAL_ID:
			if (TreeNodeName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorBasicContainerEditPart.VISUAL_ID:
			if (OperatorLeftContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OperatorRightContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorLeftContainerEditPart.VISUAL_ID:
			if (OperatorLeftConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			if (InNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorRightContainerEditPart.VISUAL_ID:
			if (OperatorRightConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorRightConnectorEditPart.VISUAL_ID:
			if (OutNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DataMapperPackage.eINSTANCE.getDataMapperLink().isSuperTypeOf(domainElement.eClass())) {
			return DataMapperLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(DataMapperRoot element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case DataMapperRootEditPart.VISUAL_ID:
			return false;
		case InNode2EditPart.VISUAL_ID:
		case OutNode2EditPart.VISUAL_ID:
		case InNode3EditPart.VISUAL_ID:
		case OutNode3EditPart.VISUAL_ID:
		case OutNodeEditPart.VISUAL_ID:
		case InNodeEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
