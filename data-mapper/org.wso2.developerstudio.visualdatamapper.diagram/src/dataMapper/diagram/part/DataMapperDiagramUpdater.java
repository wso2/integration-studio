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
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000SemanticChildren(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_2002SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_2003SemanticChildren(view);
		case dataMapper.diagram.edit.parts.EqualEditPart.VISUAL_ID:
			return getEqual_2005SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003SemanticChildren(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3004SemanticChildren(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007SemanticChildren(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016SemanticChildren(view);
		case dataMapper.diagram.edit.parts.OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017SemanticChildren(view);
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
		dataMapper.DataMapperRoot modelElement = (dataMapper.DataMapperRoot) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.Input childElement = modelElement.getInput();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		{
			dataMapper.Output childElement = modelElement.getOutput();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOperators().iterator(); it.hasNext();) {
			dataMapper.Operator childElement = (dataMapper.Operator) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.EqualEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getInput_2002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Input modelElement = (dataMapper.Input) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOutput_2003SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Output modelElement = (dataMapper.Output) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTreeNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getEqual_2005SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Equal modelElement = (dataMapper.Equal) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.OperatorBasicContainer childElement = modelElement.getBasicContainer();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OperatorBasicContainerEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3003SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getAttribute_3004SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.Attribute modelElement = (dataMapper.Attribute) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.InNode childElement = modelElement.getInNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		{
			dataMapper.OutNode childElement = modelElement.getOutNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
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
		dataMapper.Element modelElement = (dataMapper.Element) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.InNode childElement = modelElement.getInNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		{
			dataMapper.OutNode childElement = modelElement.getOutNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getTreeNode_3011SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.TreeNode modelElement = (dataMapper.TreeNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			dataMapper.TreeNode childElement = (dataMapper.TreeNode) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			dataMapper.Attribute childElement = (dataMapper.Attribute) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			dataMapper.Element childElement = (dataMapper.Element) it.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOperatorBasicContainer_3012SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.OperatorBasicContainer modelElement = (dataMapper.OperatorBasicContainer) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.OperatorLeftContainer childElement = modelElement.getLeftContainer();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OperatorLeftContainerEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		{
			dataMapper.OperatorRightContainer childElement = modelElement.getRightContainer();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OperatorRightContainerEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOperatorLeftContainer_3013SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.OperatorLeftContainer modelElement = (dataMapper.OperatorLeftContainer) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getLeftConnectors().iterator(); it.hasNext();) {
			dataMapper.OperatorLeftConnector childElement = (dataMapper.OperatorLeftConnector) it
					.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OperatorLeftConnectorEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOperatorLeftConnector_3014SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.OperatorLeftConnector modelElement = (dataMapper.OperatorLeftConnector) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.InNode childElement = modelElement.getInNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOperatorRightContainer_3016SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.OperatorRightContainer modelElement = (dataMapper.OperatorRightContainer) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRightConnectors().iterator(); it.hasNext();) {
			dataMapper.OperatorRightConnector childElement = (dataMapper.OperatorRightConnector) it
					.next();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OperatorRightConnectorEditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperNodeDescriptor> getOperatorRightConnector_3017SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		dataMapper.OperatorRightConnector modelElement = (dataMapper.OperatorRightConnector) view
				.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperNodeDescriptor>();
		{
			dataMapper.OutNode childElement = modelElement.getOutNode();
			int visualID = dataMapper.diagram.part.DataMapperVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID) {
				result.add(new dataMapper.diagram.part.DataMapperNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedLinks(View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return getDataMapperRoot_1000ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_2002ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_2003ContainedLinks(view);
		case dataMapper.diagram.edit.parts.EqualEditPart.VISUAL_ID:
			return getEqual_2005ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003ContainedLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3004ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3005ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006ContainedLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3008ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009ContainedLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014ContainedLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3015ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017ContainedLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018ContainedLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingLinks(View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_2002IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_2003IncomingLinks(view);
		case dataMapper.diagram.edit.parts.EqualEditPart.VISUAL_ID:
			return getEqual_2005IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003IncomingLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3004IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3005IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006IncomingLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3008IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009IncomingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014IncomingLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3015IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017IncomingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018IncomingLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingLinks(View view) {
		switch (dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view)) {
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return getInput_2002OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return getOutput_2003OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.EqualEditPart.VISUAL_ID:
			return getEqual_2005OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3004OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return getInNode_3005OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return getElement_3007OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return getInNode_3008OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return getTreeNode_3011OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorBasicContainerEditPart.VISUAL_ID:
			return getOperatorBasicContainer_3012OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftContainerEditPart.VISUAL_ID:
			return getOperatorLeftContainer_3013OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorLeftConnectorEditPart.VISUAL_ID:
			return getOperatorLeftConnector_3014OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return getInNode_3015OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightContainerEditPart.VISUAL_ID:
			return getOperatorRightContainer_3016OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OperatorRightConnectorEditPart.VISUAL_ID:
			return getOperatorRightConnector_3017OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return getOutNode_3018OutgoingLinks(view);
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return getDataMapperLink_4001OutgoingLinks(view);
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
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getEqual_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3006ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
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
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3008ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3009ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorBasicContainer_3012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftContainer_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftConnector_3014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3015ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightContainer_3016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightConnector_3017ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3018ContainedLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_2002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_2003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getEqual_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3005IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3006IncomingLinks(
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
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3008IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3009IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3011IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorBasicContainer_3012IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftContainer_3013IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftConnector_3014IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3015IncomingLinks(
			View view) {
		dataMapper.InNode modelElement = (dataMapper.InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightContainer_3016IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightConnector_3017IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3018IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInput_2002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutput_2003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getEqual_2005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getAttribute_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3006OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
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
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3008OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3009OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getTreeNode_3011OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorBasicContainer_3012OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftContainer_3013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorLeftConnector_3014OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getInNode_3015OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightContainer_3016OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOperatorRightConnector_3017OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutNode_3018OutgoingLinks(
			View view) {
		dataMapper.OutNode modelElement = (dataMapper.OutNode) view.getElement();
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DataMapperLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<dataMapper.diagram.part.DataMapperLinkDescriptor> getDataMapperLink_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedTypeModelFacetLinks_DataMapperLink_4001(
			dataMapper.OutNode container) {
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links.hasNext();) {
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
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(src, dst, link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001,
					dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingTypeModelFacetLinks_DataMapperLink_4001(
			dataMapper.InNode target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor> result = new LinkedList<dataMapper.diagram.part.DataMapperLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != dataMapper.DataMapperPackage.eINSTANCE
					.getDataMapperLink_InNode()
					|| false == setting.getEObject() instanceof dataMapper.DataMapperLink) {
				continue;
			}
			dataMapper.DataMapperLink link = (dataMapper.DataMapperLink) setting.getEObject();
			if (dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID != dataMapper.diagram.part.DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			dataMapper.OutNode src = link.getOutNode();
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(src, target, link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001,
					dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingTypeModelFacetLinks_DataMapperLink_4001(
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
		for (Iterator<?> links = container.getOutgoingLink().iterator(); links.hasNext();) {
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
			result.add(new dataMapper.diagram.part.DataMapperLinkDescriptor(src, dst, link,
					dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4001,
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
		public List<dataMapper.diagram.part.DataMapperNodeDescriptor> getSemanticChildren(View view) {
			return DataMapperDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getContainedLinks(View view) {
			return DataMapperDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getIncomingLinks(View view) {
			return DataMapperDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<dataMapper.diagram.part.DataMapperLinkDescriptor> getOutgoingLinks(View view) {
			return DataMapperDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
