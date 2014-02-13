package dataMapper.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

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
			if (dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
					.equals(view.getType())) {
				return dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view.getType());
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				dataMapper.diagram.part.DataMapperDiagramEditorPlugin
						.getInstance().logError(
								"Unable to parse view type as a visualID number: "
										+ type);
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
		if (dataMapper.DataMapperPackage.eINSTANCE.getDataMapperRoot()
				.isSuperTypeOf(domainElement.eClass())
				&& isDiagram((dataMapper.DataMapperRoot) domainElement)) {
			return dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID;
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
		String containerModelID = dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getModelID(containerView);
		if (!dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getDataMapperDiagram()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getInput()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getOutput()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getConcat()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getTreeNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getTreeNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getAttribute()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getElement()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getTreeNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getAttribute()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getElement()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getInNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getOutNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getInNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getOutNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getTreeNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getTreeNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getAttribute()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getElement()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID;
			}
			break;
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			if (dataMapper.DataMapperPackage.eINSTANCE.getInNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getOutNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID;
			}
			if (dataMapper.DataMapperPackage.eINSTANCE.getInNode()
					.isSuperTypeOf(domainElement.eClass())) {
				return dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getModelID(containerView);
		if (!dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (dataMapper.diagram.edit.parts.DataMapperRootEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			if (dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID == nodeVisualID) {
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
		if (dataMapper.DataMapperPackage.eINSTANCE.getDataMapperLink()
				.isSuperTypeOf(domainElement.eClass())) {
			return dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(dataMapper.DataMapperRoot element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
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
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return false;
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
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
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return dataMapper.diagram.part.DataMapperVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
