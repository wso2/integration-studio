package org.wso2.integrationstudio.datamapper.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.wso2.integrationstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class DataMapperEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (DataMapperVisualIDRegistry.getVisualID(view)) {

			case DataMapperRootEditPart.VISUAL_ID:
				return new DataMapperRootEditPart(view);

			case InputEditPart.VISUAL_ID:
				return new InputEditPart(view);

			case OutputEditPart.VISUAL_ID:
				return new OutputEditPart(view);

			case EqualEditPart.VISUAL_ID:
				return new EqualEditPart(view);

			case SubtractEditPart.VISUAL_ID:
				return new SubtractEditPart(view);

			case ConcatEditPart.VISUAL_ID:
				return new ConcatEditPart(view);

			case AddEditPart.VISUAL_ID:
				return new AddEditPart(view);

			case SplitEditPart.VISUAL_ID:
				return new SplitEditPart(view);

			case ConstantEditPart.VISUAL_ID:
				return new ConstantEditPart(view);

			case LowerCaseEditPart.VISUAL_ID:
				return new LowerCaseEditPart(view);

			case ContainsEditPart.VISUAL_ID:
				return new ContainsEditPart(view);

			case UpperCaseEditPart.VISUAL_ID:
				return new UpperCaseEditPart(view);

			case MultiplyEditPart.VISUAL_ID:
				return new MultiplyEditPart(view);

			case DivideEditPart.VISUAL_ID:
				return new DivideEditPart(view);

			case CeliEditPart.VISUAL_ID:
				return new CeliEditPart(view);

			case FloorEditPart.VISUAL_ID:
				return new FloorEditPart(view);

			case RoundEditPart.VISUAL_ID:
				return new RoundEditPart(view);

			case SetPrecisionEditPart.VISUAL_ID:
				return new SetPrecisionEditPart(view);

			case AbsoluteValueEditPart.VISUAL_ID:
				return new AbsoluteValueEditPart(view);

			case StringLengthEditPart.VISUAL_ID:
				return new StringLengthEditPart(view);

			case StartsWithEditPart.VISUAL_ID:
				return new StartsWithEditPart(view);

			case EndsWithEditPart.VISUAL_ID:
				return new EndsWithEditPart(view);

			case SubstringEditPart.VISUAL_ID:
				return new SubstringEditPart(view);

			case IfElseEditPart.VISUAL_ID:
				return new IfElseEditPart(view);

			case ANDEditPart.VISUAL_ID:
				return new ANDEditPart(view);

			case OREditPart.VISUAL_ID:
				return new OREditPart(view);

			case NOTEditPart.VISUAL_ID:
				return new NOTEditPart(view);

			case TrimEditPart.VISUAL_ID:
				return new TrimEditPart(view);

			case ReplaceEditPart.VISUAL_ID:
				return new ReplaceEditPart(view);

			case MatchEditPart.VISUAL_ID:
				return new MatchEditPart(view);

			case MinEditPart.VISUAL_ID:
				return new MinEditPart(view);

			case MaxEditPart.VISUAL_ID:
				return new MaxEditPart(view);

			case CustomFunctionEditPart.VISUAL_ID:
				return new CustomFunctionEditPart(view);

			case PropertiesEditPart.VISUAL_ID:
				return new PropertiesEditPart(view);

			case CompareEditPart.VISUAL_ID:
				return new CompareEditPart(view);

			case StringToNumberEditPart.VISUAL_ID:
				return new StringToNumberEditPart(view);

			case StringToBooleanEditPart.VISUAL_ID:
				return new StringToBooleanEditPart(view);

			case CloneEditPart.VISUAL_ID:
				return new CloneEditPart(view);

			case ToStringEditPart.VISUAL_ID:
				return new ToStringEditPart(view);

			case GlobalVariableEditPart.VISUAL_ID:
				return new GlobalVariableEditPart(view);

			case AdvancedCustomFunctionEditPart.VISUAL_ID:
				return new AdvancedCustomFunctionEditPart(view);

			case TreeNodeEditPart.VISUAL_ID:
				return new TreeNodeEditPart(view);

			case TreeNodeNameEditPart.VISUAL_ID:
				return new TreeNodeNameEditPart(view);

			case ElementEditPart.VISUAL_ID:
				return new ElementEditPart(view);

			case ElementNameEditPart.VISUAL_ID:
				return new ElementNameEditPart(view);

			case InNode2EditPart.VISUAL_ID:
				return new InNode2EditPart(view);

			case OutNode2EditPart.VISUAL_ID:
				return new OutNode2EditPart(view);

			case TreeNode2EditPart.VISUAL_ID:
				return new TreeNode2EditPart(view);

			case TreeNodeName2EditPart.VISUAL_ID:
				return new TreeNodeName2EditPart(view);

			case InNodeEditPart.VISUAL_ID:
				return new InNodeEditPart(view);

			case OutNodeEditPart.VISUAL_ID:
				return new OutNodeEditPart(view);

			case TreeNode3EditPart.VISUAL_ID:
				return new TreeNode3EditPart(view);

			case TreeNodeName3EditPart.VISUAL_ID:
				return new TreeNodeName3EditPart(view);

			case OperatorBasicContainerEditPart.VISUAL_ID:
				return new OperatorBasicContainerEditPart(view);

			case OperatorLeftContainerEditPart.VISUAL_ID:
				return new OperatorLeftContainerEditPart(view);

			case OperatorLeftConnectorEditPart.VISUAL_ID:
				return new OperatorLeftConnectorEditPart(view);

			case InNode3EditPart.VISUAL_ID:
				return new InNode3EditPart(view);

			case OperatorRightContainerEditPart.VISUAL_ID:
				return new OperatorRightContainerEditPart(view);

			case OperatorRightConnectorEditPart.VISUAL_ID:
				return new OperatorRightConnectorEditPart(view);

			case OutNode3EditPart.VISUAL_ID:
				return new OutNode3EditPart(view);

			case DataMapperLinkEditPart.VISUAL_ID:
				return new DataMapperLinkEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
