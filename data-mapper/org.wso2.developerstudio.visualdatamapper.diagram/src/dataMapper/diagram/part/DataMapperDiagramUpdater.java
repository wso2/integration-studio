package dataMapper.diagram.part;

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

/**
 * @generated
 */
public class DataMapperDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getSemanticChildren(
			View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000SemanticChildren(view);
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getDataMapperDiagram_2001SemanticChildren(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_3001SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3004SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3005SemanticChildren(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3006SemanticChildren(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_3002SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3008SemanticChildren(view);
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getConcat_3013SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getDataMapperRoot_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.DataMapperRoot modelElement = (dataMapper.DataMapperRoot) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.DataMapperDiagram childElement = modelElement
					.getDataMapperDiagram();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getDataMapperDiagram_2001SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.DataMapperDiagram modelElement = (dataMapper.DataMapperDiagram) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.Input childElement = modelElement.getInput();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		{
			dataMapper.Output childElement = modelElement.getOutput();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getConcat().iterator(); it.hasNext();) {
			dataMapper.Concat childElement = (dataMapper.Concat) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getInput_3001SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Input modelElement = (dataMapper.Input) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it
				.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3004SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it
				.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it
					.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it
				.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3005SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it
				.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it
					.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it
				.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getAttribute_3006SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Attribute modelElement = (dataMapper.Attribute) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.InNode childElement = modelElement.getInNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		{
			dataMapper.OutNode childElement = modelElement.getOutNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getElement_3007SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Element modelElement = (dataMapper.Element) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.InNode childElement = modelElement.getInNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		{
			dataMapper.OutNode childElement = modelElement.getOutNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOutput_3002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Output modelElement = (dataMapper.Output) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it
				.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3008SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it
				.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it
					.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it
				.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getConcat_3013SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Concat modelElement = (dataMapper.Concat) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInNode().iterator(); it.hasNext();) {
			dataMapper.InNode childElement = (dataMapper.InNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutNode().iterator(); it
				.hasNext();) {
			dataMapper.OutNode childElement = (dataMapper.OutNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedLinks(
			View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000ContainedLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getDataMapperDiagram_2001ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_3001ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3004ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3005ContainedLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3006ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3009ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3010ContainedLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3011ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3012ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_3002ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3008ContainedLinks(view);
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getConcat_3013ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3014ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3015ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return getInNode_3016ContainedLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingLinks(
			View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getDataMapperDiagram_2001IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_3001IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3004IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3005IncomingLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3006IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3009IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3010IncomingLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3011IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3012IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_3002IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3008IncomingLinks(view);
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getConcat_3013IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3014IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3015IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return getInNode_3016IncomingLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
				.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return getDataMapperDiagram_2001OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_3001OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3004OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3005OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3006OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3009OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3010OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3011OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3012OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_3002OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3008OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return getConcat_3013OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3014OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3015OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return getInNode_3016OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperRoot_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperDiagram_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3009ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3010ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getElement_3007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3012ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getConcat_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3015ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperDiagram_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3009IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3010IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getElement_3007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3011IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3012IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3008IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getConcat_3013IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3014IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3015IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3016IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperDiagram_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3006OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3009OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3010OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getElement_3007OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3011OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3012OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3008OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getConcat_3013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3014OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3015OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3016OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedTypeModelFacetLinks_DataMapperLink_4002(
			dataMapper.OutNode container) {
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof dataMapper.DataMapperLink) {
				continue;
			}
			dataMapper.DataMapperLink link = (dataMapper.DataMapperLink) linkObject;
			if (dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID != dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			dataMapper.InNode dst = link.getInNode();
			dataMapper.OutNode src = link.getOutNode();
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(
					src,
					dst,
					link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002,
					dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingTypeModelFacetLinks_DataMapperLink_4002(
			dataMapper.InNode target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != dataMapper.DataMapperPackage.eINSTANCE
					.getDataMapperLink_InNode()
					|| false == setting.getEObject() instanceof dataMapper.DataMapperLink) {
				continue;
			}
			dataMapper.DataMapperLink link = (dataMapper.DataMapperLink) setting
					.getEObject();
			if (dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID != dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			dataMapper.OutNode src = link.getOutNode();
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(
					src,
					target,
					link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002,
					dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingTypeModelFacetLinks_DataMapperLink_4002(
			dataMapper.OutNode source) {
		dataMapper.OutNode container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof dataMapper.OutNode) {
				container = (dataMapper.OutNode) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof dataMapper.DataMapperLink) {
				continue;
			}
			dataMapper.DataMapperLink link = (dataMapper.DataMapperLink) linkObject;
			if (dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID != dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			dataMapper.InNode dst = link.getInNode();
			dataMapper.OutNode src = link.getOutNode();
			if (src != source) {
				continue;
			}
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(
					src,
					dst,
					link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002,
					dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
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
		public List<dataMapper.diagram.part.DataMapperNodeDescriptor> getSemanticChildren(
				View view) {
			return DataMapperDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedLinks(
				View view) {
			return DataMapperDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingLinks(
				View view) {
			return DataMapperDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingLinks(
				View view) {
			return DataMapperDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
