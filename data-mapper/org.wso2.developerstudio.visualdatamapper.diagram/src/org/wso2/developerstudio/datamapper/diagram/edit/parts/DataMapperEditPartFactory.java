package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

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

			case ConcatEditPart.VISUAL_ID:
				return new ConcatEditPart(view);

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

			case TreeNodeEditPart.VISUAL_ID:
				return new TreeNodeEditPart(view);

			case TreeNodeNameEditPart.VISUAL_ID:
				return new TreeNodeNameEditPart(view);

			case TreeNode2EditPart.VISUAL_ID:
				return new TreeNode2EditPart(view);

			case TreeNodeName2EditPart.VISUAL_ID:
				return new TreeNodeName2EditPart(view);

			case AttributeEditPart.VISUAL_ID:
				return new AttributeEditPart(view);

			case InNodeEditPart.VISUAL_ID:
				return new InNodeEditPart(view);

			case OutNodeEditPart.VISUAL_ID:
				return new OutNodeEditPart(view);

			case ElementEditPart.VISUAL_ID:
				return new ElementEditPart(view);

			case ElementNameEditPart.VISUAL_ID:
				return new ElementNameEditPart(view);

			case InNode2EditPart.VISUAL_ID:
				return new InNode2EditPart(view);

			case OutNode2EditPart.VISUAL_ID:
				return new OutNode2EditPart(view);

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
